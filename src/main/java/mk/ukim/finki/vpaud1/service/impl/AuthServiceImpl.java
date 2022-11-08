package mk.ukim.finki.vpaud1.service.impl;

import mk.ukim.finki.vpaud1.model.User;
import mk.ukim.finki.vpaud1.model.exceptions.InvalidArgumentException;
import mk.ukim.finki.vpaud1.model.exceptions.InvalidUserCredentialsException;
import mk.ukim.finki.vpaud1.model.exceptions.PasswordsDoNotMatchException;
import mk.ukim.finki.vpaud1.repository.InMemoryCategoryRepository;
import mk.ukim.finki.vpaud1.repository.InMemoryUserRepository;
import mk.ukim.finki.vpaud1.service.AuthService;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImpl implements AuthService {

    private final InMemoryUserRepository userRepository;

    public AuthServiceImpl(InMemoryUserRepository userRepository) {
        this.userRepository = userRepository;
    }


    @Override
    public User login(String username, String password) {
        if (username == null || username.isEmpty() || password == null || password.isEmpty())
        {
            throw new InvalidArgumentException();
        }
        return userRepository.findByUsernameAndPassword(username, password).orElseThrow(InvalidUserCredentialsException::new);
    }

    @Override
    public User register(String username, String password, String repeatedPassword, String name, String surname) {
        if (username == null || username.isEmpty() || password == null || password.isEmpty())
        {
            throw new InvalidArgumentException();
        }

        if (!password.equals(repeatedPassword)){
            throw new PasswordsDoNotMatchException();
        }

        User user = new User (username, password, name, surname);
        userRepository.saveOrUpdate(user);
        return user;
    }
}
