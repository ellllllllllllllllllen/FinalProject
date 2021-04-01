package edu.epam.cafe.model.service.impl;

import edu.epam.cafe.exception.DaoException;
import edu.epam.cafe.exception.ServiceException;
import edu.epam.cafe.model.dao.impl.UserDao;
import edu.epam.cafe.model.entity.Role;
import edu.epam.cafe.model.entity.User;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RunWith(MockitoJUnitRunner.class)
public class UserServiceImplTest {
    @InjectMocks
    UserServiceImpl userService;

    @Mock
    UserDao userDaoMock;

    @Before
    public void init(){
        userService = new UserServiceImpl();
    }


    @Test
    public void isEmailExistReturnTrue() throws ServiceException, DaoException {
        String email = "ellen@mail.ru";

        boolean expected = true;

        List<User> expectedUserList = Arrays.asList(
                new User("ellen@mail.ru", "ellen", "Elena", "Zavadskaya", Role.USER),
                new User("lytkina@mail.ru", "lytkina", "Olga", "Lytkina", Role.USER),
                new User("danik@mail.ru", "danik", "Danik", "Larchenko", Role.USER));

        Mockito.when(userDaoMock.findAll()).thenReturn(expectedUserList);

        boolean actual = userService.isEmailExist(email);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void isUsernameExistReturnFalse() throws ServiceException, DaoException {

        String username = "username";

        boolean expected = false;

        List<User> expectedUserList = Arrays.asList(
                new User("ellen@mail.ru", "ellen", "Elena", "Zavadskaya", Role.USER),
                new User("lytkina@mail.ru", "lytkina", "Olga", "Lytkina", Role.USER),
                new User("danik@mail.ru", "danik", "Danik", "Larchenko", Role.USER));

        Mockito.when(userDaoMock.findAll()).thenReturn(expectedUserList);

        boolean actual = userService.isUsernameExist(username);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void isUserExistReturnFalse() throws ServiceException, DaoException {

        String username = "username";

        boolean expected = false;

        List<User> expectedUserList = Arrays.asList(
                new User("ellen@mail.ru", "ellen", "Elena", "Zavadskaya", Role.USER),
                new User("lytkina@mail.ru", "lytkina", "Olga", "Lytkina", Role.USER),
                new User("danik@mail.ru", "danik", "Danik", "Larchenko", Role.USER));

        Mockito.when(userDaoMock.findAll()).thenReturn(expectedUserList);

        boolean actual = userService.isUsernameExist(username);
        Assert.assertEquals(expected, actual);
    }

}