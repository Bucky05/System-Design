package producers;

import models.Match;
import subscribers.Subscriber;

public interface Producer {

    Match getMatchData();
    void subscribe(Subscriber subscriber);
    void unsubscribe(Subscriber subscriber);
    void notifySubscriber();
}
