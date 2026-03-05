package models;

import enums.AuctionStatusEnum;

import java.util.Objects;
import java.util.UUID;
public class Auction {
    String id;
    private int lowestBidLimit;
    private int highestBidLimit;

    private User seller;
    private int participationCost;
    private AuctionStatusEnum status;

    public Auction(int lowestBidLimit, int highestBidLimit,User seller, int participationCost) {
        id = UUID.randomUUID().toString();
        this.lowestBidLimit = lowestBidLimit;
        this.highestBidLimit = highestBidLimit;
        this.seller = seller;
        this.participationCost = participationCost;
        status = AuctionStatusEnum.OPEN;
    }


    public String getId() {
        return id;
    }


    public int getLowestBidLimit() {
        return lowestBidLimit;
    }

    public int getHighestBidLimit() {
        return highestBidLimit;
    }


    public User getSeller() {
        return seller;
    }

    public int getParticipationCost() {
        return participationCost;
    }

    public AuctionStatusEnum getStatus() {
        return status;
    }

    public void setStatus(AuctionStatusEnum status) {
        this.status = status;
    }

    public boolean equals(Auction auction) {
        return id.equals(auction.getId());
    }
}
