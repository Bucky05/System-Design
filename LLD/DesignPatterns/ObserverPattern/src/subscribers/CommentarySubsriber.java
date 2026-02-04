package subscribers;

import producers.Producer;

import java.util.ArrayList;
import java.util.List;

public class CommentarySubsriber implements  Subscriber{

    private List<String> commentary;
    private List<Producer> producers;
    public CommentarySubsriber(List<Producer> producers) {
        this.commentary = new ArrayList<>();
        this.producers = producers;
        for(Producer producer : producers) {
            producer.subscribe(this);
        }
    }
    @Override
    public void update(Producer producer) {
        this.commentary.add(producer.getMatchData().getCommentary().get(producer.getMatchData().getCommentary().size()-1));
    }
}
