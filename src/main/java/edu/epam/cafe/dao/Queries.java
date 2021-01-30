package edu.epam.cafe.dao;

public class Queries {
    private static final String SELECT_ALL_USERS = "SELECT email, username, firstname, lastname, user_role FROM users;";

    private static final String ADD_USER = "INSERT INTO users (`email, `username`, `password`, `firstname`, `lastname`, `user_role`) " +
            "VALUES ('%s', '%s', '%s', '%s', '%s', '%s');";

    private static final String SET_ADMIN_ROLE = "UPDATE users SET user_role = 'ADMIN' where `username` = '%s';";

    private static final String FIND_USER_BY_EMAIL = "SELECT email, username, firstname, lastname, user_role" +
            "FROM users WHERE email = ?";
    private static final String FIND_USER_BY_USERNAME = "SELECT email, username, firstname, lastname, user_role" +
            "FROM users WHERE username = ?";

    private static final String FIND_USER_BY_EMAIL_AND_PASSWORD = "SELECT email, username, firstname, lastname, user_role" +
            "FROM users WHERE email = ? " + "AND password = ?";

    private static final String FIND_USER_BY_USERNAME_AND_PASSWORD = "SELECT email, username, firstname, lastname, user_role" +
            "FROM users WHERE username = ? " + "AND password = ?";
}
