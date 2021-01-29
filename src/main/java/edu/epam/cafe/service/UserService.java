package edu.epam.cafe.service;

import edu.epam.cafe.entity.User;
import org.graalvm.compiler.nodes.calc.IntegerDivRemNode;

import java.util.Optional;

public interface UserService {

    Optional<User> createUser(User user, String password);
    Optional<User> findUserById(Long id);
    Optional<User> findUserByEmail(String email);

}
