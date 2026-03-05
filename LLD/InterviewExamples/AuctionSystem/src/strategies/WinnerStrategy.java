package strategies;

import models.Auction;
import models.Bid;

import java.util.List;
import java.util.Optional;

public interface WinnerStrategy {


    Optional<Bid> getWinner(List<Bid> bidList);
}
