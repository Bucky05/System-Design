package iterators;

import java.util.List;

import repositories.UserRepository;
import repositories.UserRepositoryImpl;

public class UserIterator implements Iterator{
    
    private UserRepository userRepository;
    private int limit = 1;
    private int offset = 0;
    private List<String> current;
    public UserIterator(int limit) {
        userRepository = new UserRepositoryImpl();
        this.limit = limit;
        this.current = userRepository.findUsers(limit, offset);
    }
    @Override
    public boolean hasNext() {
        return !current.isEmpty();
    }

    @Override
    public List<String> next() {
        List<String> result = current;
        this.offset += limit;
        this.current = this.userRepository.findUsers(limit, offset);
        return result;
    }
}
