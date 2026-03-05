## Functional Requirements

- Users
  - Buyer - can bid in multiple auction
  - Seller - can host auctions and track profit/loss;
- Auctions
  - unique id
  - max and min bid;
  - a seller
  - fixed participation cost paid by each bidder
  - Seller receives 20% of participation cost
  - Remaining is by AuctionSystem as commission
- Bids
  - Buyer can create, update and withdraw until auction is closed.
  - bid amount in bid limits
  - multiple auctions can run simultaneously
- Winner
  - Highest unique bid
  - If no highest unique, no winner
- Seller profit or loss
  - if winner 
    - winning_bid + (no. of bidders * 0.2 * participation cost) - avg(lowestBidLimit,highestBidLimit)
  - If no winner
    - profit = (no. of bidders * 0.2 * participation cost)

## Bonus
Preferred buyers
if buyer participate in more than 2 auctions he is marked as preferred
- if tie between a preferred and non preferred preferred wins
- if tie between two preferred next hight unique bid wins