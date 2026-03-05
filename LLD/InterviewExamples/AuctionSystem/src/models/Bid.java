package models;

public class Bid {

    private Auction auction;
    private User bidder;
    int amount;

    public Bid(Auction auction, User bidder, int amount) {
        this.auction = auction;
        this.bidder = bidder;
        this.amount = amount;
    }

    public Auction getAuction() {
        return auction;
    }

    public User getBidder() {
        return this.bidder;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
}
