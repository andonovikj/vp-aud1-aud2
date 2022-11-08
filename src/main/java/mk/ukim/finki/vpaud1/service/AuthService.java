package mk.ukim.finki.vpaud1.service;

import mk.ukim.finki.vpaud1.model.User;

public interface AuthService {

    User login (String username, String password);

    User register (String username, String password, String repeatedPassword, String name, String surname);
}
