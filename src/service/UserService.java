package service;

import DAO.implementation.UserDAOImpl;
import exeptions.EmailAlreadyExists;
import exeptions.IncorrectLoginData;
import model.User;
import org.apache.commons.codec.digest.DigestUtils;

import java.sql.SQLException;

public class UserService {
    static UserDAOImpl userDAO = new UserDAOImpl();

    public static User login(String uEmail, String uPassword) throws SQLException, IncorrectLoginData {

        String md5Pass = DigestUtils.md5Hex(uPassword);

        User user = userDAO.selectByEmailAndPassword(uEmail, md5Pass);
        if (user == null) {
            throw new IncorrectLoginData();
        }

        return user;
    }

    public static void registration(User user) throws SQLException, EmailAlreadyExists {

        String email = user.getEmail();

        int isInDB = userDAO.selectByEmail(email);

        if (isInDB == 0) {
            user.setPassword(DigestUtils.md5Hex(user.getPassword()));
            userDAO.create(user);
        } else {
            throw new EmailAlreadyExists();
        }

    }
}
