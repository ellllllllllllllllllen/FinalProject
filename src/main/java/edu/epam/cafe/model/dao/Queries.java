package edu.epam.cafe.model.dao;

public class Queries {
    private static final String SELECT_ALL_USERS = "SELECT email, username, firstname, lastname, user_role FROM users;";

//    public static final String ADD_USER = "INSERT INTO users (`email, `username`, `pass`, `firstname`, `lastname`, `user_role`) " +
//            "VALUES ('%s', '%s', '%s', '%s', '%s', '%s');";

    public static final String ADD_USER = "INSERT INTO users (`email, `username`, `pass`, `firstname`, `lastname`, `user_role`) " +
            "VALUES (?, ?, ?, ?, ?, ?);";

    private static final String SET_ADMIN_ROLE = "UPDATE users SET user_role = 'ADMIN' where `username` = '%s';";

    public static final String FIND_USER_BY_EMAIL = "SELECT email, username, firstname, lastname, user_role" +
            "FROM users WHERE email = ?";
    public static final String FIND_USER_BY_USERNAME = "SELECT id, email, username, firstname, lastname, user_role" +
            "FROM users WHERE username = ?";

    private static final String FIND_USER_BY_EMAIL_AND_PASSWORD = "SELECT email, username, firstname, lastname, user_role" +
            "FROM users WHERE email = ? " + "AND pass = ?";

    public static final String FIND_USER_BY_USERNAME_AND_PASSWORD = "SELECT email, username, firstname, lastname, user_role" +
            "FROM users WHERE username = ? " + "AND pass = ?";

    public static String getSelectAllUsers() {
        return SELECT_ALL_USERS;
    }

//    public static String getAddUser() {
//        return ADD_USER;
//    }

    public static String getSetAdminRole() {
        return SET_ADMIN_ROLE;
    }

    public static String getFindUserByEmail() {
        return FIND_USER_BY_EMAIL;
    }

    public static String getFindUserByUsername() {
        return FIND_USER_BY_USERNAME;
    }

    public static String getFindUserByEmailAndPassword() {
        return FIND_USER_BY_EMAIL_AND_PASSWORD;
    }

    public static String getFindUserByUsernameAndPassword() {
        return FIND_USER_BY_USERNAME_AND_PASSWORD;
    }
}
