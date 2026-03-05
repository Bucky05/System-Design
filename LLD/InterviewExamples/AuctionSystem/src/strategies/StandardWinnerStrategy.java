package strategies;

import models.Bid;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.PriorityQueue;

public class StandardWinnerStrategy implements  WinnerStrategy{

    public Optional<Bid> getWinner(List<Bid> bidList) {
        PriorityQueue<Bid> pQ = new PriorityQueue<>((a,b) -> b.getAmount() - a.getAmount());

        for(Bid bid : bidList) {
            pQ.add(bid);
        }

        while(!pQ.isEmpty()) {
            Bid bid = pQ.remove();
            if(pQ.isEmpty() || pQ.peek().getAmount() != bid.getAmount()) {
                return Optional.of(bid);
            }
            while(!pQ.isEmpty()) {
                if(pQ.peek().getAmount() == bid.getAmount()) {
                    pQ.remove();
                } else break;
            }
        }

        return Optional.empty();
    }
}
