package service.impl;

import model.User;
import repository.UserRepository;
import repository.impl.UserRepositoryImpl;
import service.UserService;

public class UserServiceImpl implements UserService {
    public static UserRepository userRepository = new UserRepositoryImpl();

    @Override
    public void save(User user) {

        userRepository.save(user);

    }

    @Override
    public boolean existsByChatId(Long chatId)
    {
        return userRepository.existsByChatId(chatId);
    }

    @Override
    public User findByChatId(Long chatId) {
        return userRepository.findByChatId(chatId);
    }

    @Override
    public void update(User user) {
        userRepository.update(user);
    }
}
