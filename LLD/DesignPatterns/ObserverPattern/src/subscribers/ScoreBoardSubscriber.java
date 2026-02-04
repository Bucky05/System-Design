package subscribers;

import models.Innings;
import models.Match;
import producers.Producer;

import java.util.List;

public class ScoreBoardSubscriber implements  Subscriber{

    private Match match;
    private List<Producer> producers;
    public ScoreBoardSubscriber(Match match, List<Producer> producers) {
        this.match = match;
        this.producers = producers;
        for(Producer producer : producers ) {
            producer.subscribe(this);
        }
    }

    public void update(Producer producer) {
        boolean isFirstInnings = producer.getMatchData().isFirstInnings();
        Innings inningsProducer = isFirstInnings ? producer.getMatchData().getInnings1() : producer.getMatchData().getInnings2();
        Innings inningsSubscriber = isFirstInnings ? this.match.getInnings1() : this.match.getInnings2();


        inningsSubscriber.setCurrentScore(inningsProducer.getCurrentScore());
        inningsSubscriber.setWickets(inningsProducer.getWickets());
        inningsSubscriber.setCurrentBall(inningsProducer.getCurrentBall());
    }
}
