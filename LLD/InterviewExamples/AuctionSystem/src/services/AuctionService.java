package services;

import enums.AuctionStatusEnum;
import enums.UserTypeEnum;
import models.Auction;
import models.Bid;
import models.User;
import repositories.AuctionRepository;
import repositories.BidRepository;
import repositories.UserRepository;
import strategies.WinnerStrategy;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

public class AuctionService {

    private AuctionRepository auctionRepository;
    private BidRepository bidRepository;
    private WinnerStrategy winnerStrategy;
    private UserRepository userRepository;
    public AuctionService(AuctionRepository repository, BidRepository bidRepository, WinnerStrategy winnerStrategy, UserRepository userRepository) {
        this.auctionRepository = repository;
        this.winnerStrategy = winnerStrategy;
        this.bidRepository = bidRepository;
        this.userRepository = userRepository;
    }

    public String createAuction(int lowestBid, int highestBid, String sellerId, int participationCost) {
        User seller = userRepository.getUserById(sellerId);
        Auction auction = new Auction(lowestBid,highestBid,seller,participationCost);
        auctionRepository.addAuction(auction);
        return auction.getId();
    }

    public void closeAuction(String id) {
        Auction auction = auctionRepository.getAuctionById(id);

        if(auction.getStatus() == AuctionStatusEnum.CLOSED) {
            throw new IllegalArgumentException("The auction is already closed");
        }
        List<Bid> bidList = bidRepository.getBidsByAuction(auction);
        Optional<Bid> winner = winnerStrategy.getWinner(bidList);

        if(winner.isEmpty()) {
            System.out.println("There is no winner");
        } else {
            Bid winningBid = winner.get();
            System.out.println("Winner is "+winningBid.getBidder().getName()+". Winning Bid is "+winningBid.getAmount());
            calculateProfitOrLoss(auction, winningBid.getAmount(),bidList);
        }
    }

    private void calculateProfitOrLoss(Auction auction, int amount, List<Bid> bidList) {
        Set<String> bidders = new HashSet<>();

        bidList.forEach(bid -> bidders.add(bid.getBidder().getId()));

        int participantCount = bidders.size();

        double revenue = amount + (0.2*auction.getParticipationCost()*participantCount) - ((auction.getHighestBidLimit() + auction.getLowestBidLimit())/2);

        if(revenue >= 0) {
            System.out.println("Total profit is: "+ revenue);
        } else {
            System.out.println("Total loss is: "+ revenue);
        }
    }

    public void placeBid(String auctionId, String bidderId, int amount) {
        User bidder = userRepository.getUserById(bidderId);
        Auction auction = auctionRepository.getAuctionById(auctionId);
        validateBidAmount(auction, amount);

        bidRepository.addBid(new Bid(auction, bidder, amount));
    }

    private void validateBidAmount(Auction auction, int amount) {
        if(amount < auction.getLowestBidLimit() || amount > auction.getHighestBidLimit()) {
            throw new IllegalArgumentException("Amount should be between "+auction.getLowestBidLimit() +" and "+auction.getHighestBidLimit());
        }
    }

    public void updateBid(String bidderId, String auctionId, int amount) {
        Auction auction = auctionRepository.getAuctionById(auctionId);
        User bidder = userRepository.getUserById(bidderId);
        if(auction.getStatus() == AuctionStatusEnum.CLOSED) {
            throw new IllegalStateException("Cannot update bid of a closed auction");
        }
        validateBidAmount(auction, amount);

        Optional<Bid> bid = bidRepository.getBidByAuctionAndUser(auction , bidder);

        if(bid.isEmpty()) {
            throw new IllegalArgumentException("Bid doesn't exist");
        }
        bid.get().setAmount(amount);


    }

    public void withdrawBid(String bidderId, String auctionid) {
        Auction auction = auctionRepository.getAuctionById(auctionid);
        User bidder = userRepository.getUserById(bidderId);
        Optional<Bid> bid = bidRepository.getBidByAuctionAndUser(auction,bidder);
        if(bid.isEmpty()) {
            throw new IllegalArgumentException("Invalid bid provided");
        }
        bidRepository.deleteBid(bid.get());
    }
    public String addBuyer(String name) {
        User user = new User(name, UserTypeEnum.BUYER);
        userRepository.addUser(user);
        return user.getId();
    }

    public String addSeller(String name) {
        User user = new User(name, UserTypeEnum.SELLER);
        userRepository.addUser(user);
        return user.getId();
    }
}
