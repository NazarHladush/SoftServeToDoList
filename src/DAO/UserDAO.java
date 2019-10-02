package DAO;

import model.User;

import java.sql.SQLException;

public interface UserDAO extends GeneralDAO<User, Integer> {
    User selectByEmailAndPassword(String email, String password) throws SQLException;
}
