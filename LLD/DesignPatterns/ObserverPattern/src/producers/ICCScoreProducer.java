package producers;

import models.Match;
import subscribers.ScoreBoardSubscriber;
import subscribers.Subscriber;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ICCScoreProducer implements  Producer{

    Match match;
    private List<Subscriber> subscribers;

    public ICCScoreProducer() {
        this.subscribers = new ArrayList<>();
    }

    public void scoreUpdate() {
        // some api to fetch data
        // api layer has the logic for server sent events
        // for demo can add arguments in params
        this.notifySubscriber();
    }



    @Override
    public Match getMatchData() {
        return match;
    }

    @Override
    public void subscribe(Subscriber subscriber) {
        subscribers.add(subscriber);
    }

    @Override
    public void unsubscribe(Subscriber subscriber) {
        subscribers.remove(subscriber);
    }

    @Override
    public void notifySubscriber() {
        for(Subscriber subscriber : subscribers) {
            subscriber.update(this);
        }
    }
}
