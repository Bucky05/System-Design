package repositories;

import models.Auction;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class AuctionRepository {


    List<Auction> auctionList;

    public AuctionRepository() {
        this.auctionList = new ArrayList<>();
    }

    public List<Auction> getAuctionList() {
        return auctionList;
    }

    public void addAuction(Auction auction) {
        auctionList.add(auction);
    }

    public Auction getAuctionById(String id) {
        Optional<Auction> a =  auctionList.stream().filter(auction -> auction.getId().equals(id)).findFirst();
        return a.orElse(null);
    }
}
