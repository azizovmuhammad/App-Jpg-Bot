package repository;

import model.User;

public interface UserRepository {

    void save(User user);

    User findByChatId(Long chatId);

    void update(User user);

    boolean existsByChatId(Long chatId);
}
