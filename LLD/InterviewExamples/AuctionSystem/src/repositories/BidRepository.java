package repositories;

import models.Auction;
import models.Bid;
import models.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class BidRepository {

    List<Bid> bidList;

    public BidRepository() {
        this.bidList = new ArrayList<>();
    }

    public List<Bid> getBidList() {
        return bidList;
    }

    public void addBid(Bid bid) {
        this.bidList.add(bid);
    }

    public void deleteBid(Bid bid) {
        bidList = bidList.stream()
                .filter(b -> !b.equals(bid)).collect(Collectors.toList());
    }

    public List<Bid> getBidsByAuction(Auction auction) {
        return bidList.stream().filter(bid -> bid.getAuction().equals(auction)).collect(Collectors.toList());
    }

    public Optional<Bid> getBidByAuctionAndUser(Auction auction , User bidder) {

        for(Bid bid : bidList) {
            if(bid.getAuction().equals(auction) && bid.getBidder().equals(bidder)) {
                return Optional.of(bid);
            }
        }

        return Optional.empty();
    }
}
