package repositories;
import java.util.List;

public interface UserRepository {

    public List<String> findUsers(int limit, int offset);
}