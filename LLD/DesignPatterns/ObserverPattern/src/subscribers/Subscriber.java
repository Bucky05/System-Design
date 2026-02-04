package subscribers;

import producers.Producer;

public interface Subscriber {

    void update(Producer producer);
}
