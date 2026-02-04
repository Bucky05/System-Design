package producers;

import models.Match;
import subscribers.Subscriber;

import java.util.ArrayList;
import java.util.List;

public class BCCIProducer implements  Producer{

    Match match;
    private List<Subscriber> subscribers;

    public BCCIProducer() {
        this.subscribers = new ArrayList<>();
    }

    public void commentaryUpdate(String runs, String over, String ball, String wickets , boolean isFirstInnings) {
        // some api to fetch data
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
