package DAO.implementation;

import DAO.UserDAO;
import connection.ConnectionManager;
import model.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDAOImpl implements UserDAO {
    //language=SQL
    private static final String DELETE = "DELETE FROM softserve.user WHERE id=?";
    //language=SQL
    private static final String FIND_ALL = "SELECT * FROM `softserve.user`";
    //language=SQL
    private static final String FIND_BY_ID = "SELECT * FROM `softserve.user` WHERE id=?";
    //language=SQL
    private static final String CREATE = "INSERT INTO softserve.user (`email`, `password`, `first_name`, `second_name`) Values (?, ?, ?, ?)";
    //language=SQL
    private static final String UPDATE = "UPDATE softserve.user SET (`email=?`, `password=?`, `first_name=?`, `second_name=?`) WHERE `user.id`=?";
    //language=SQL
    private static final String FIND_BY_EMAIL_ADN_PASSWORD = "SELECT * FROM softserve.user WHERE `email` = ? and `password` = ?";

    private static PreparedStatement createPreparedStatementById(Connection connection, String sql, int id) throws SQLException {
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setInt(1, id);
        return ps;
    }

    private static PreparedStatement createPreparedStatementForCreate(Connection connection, String sql, User user) throws SQLException {
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setString(1, user.getEmail());
        ps.setString(2, user.getPassword());
        ps.setString(3, user.getFirstName());
        ps.setString(4, user.getSecondName());
        return ps;
    }

    private static PreparedStatement createPreparedStatementForUpdate(Connection connection, String sql, User user) throws SQLException {
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setString(1, user.getEmail());
        ps.setString(2, user.getPassword());
        ps.setString(3, user.getFirstName());
        ps.setString(4, user.getSecondName());
        ps.setInt(5, user.getId());
        return ps;
    }

    private PreparedStatement createPreparedStatementByEmailAndPassword(Connection conn, String sql, String uEmail, String uPassword) throws SQLException {
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setString(1, uEmail);
        ps.setString(2, uPassword);
        return ps;
    }

    @Override
    public List<User> findAll() throws SQLException {
        List<User> users = new ArrayList<>();
        Connection connection = ConnectionManager.getConnection();
        try (Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(FIND_ALL)) {
            while (resultSet.next()) {
                int id = resultSet.getInt(1);
                String email = resultSet.getString(2);
                String password = resultSet.getString(3);
                String firstName = resultSet.getString(4);
                String secondName = resultSet.getString(5);
                users.add(new User(id, email, password, firstName, secondName));
            }
        }
        return users;
    }

    @Override
    public User findById(Integer id) throws SQLException {
        User user = null;
        Connection connection = ConnectionManager.getConnection();
        try (PreparedStatement preparedStatement = createPreparedStatementById(connection, FIND_BY_ID, id);
             ResultSet resultSet = preparedStatement.executeQuery()) {
            if (resultSet.next()) {
                String email = resultSet.getString(2);
                String password = resultSet.getString(3);
                String firstName = resultSet.getString(4);
                String secondName = resultSet.getString(5);
                user = new User(id, email, password, firstName, secondName);
            }
        }
        return user;
    }

    @Override
    public int create(User user) throws SQLException {
        Connection connection = ConnectionManager.getConnection();
        try (PreparedStatement preparedStatement = createPreparedStatementForCreate(connection, CREATE, user)) {
            return preparedStatement.executeUpdate();
        }
    }

    @Override
    public int update(User user) throws SQLException {
        Connection connection = ConnectionManager.getConnection();
        try (PreparedStatement preparedStatement = createPreparedStatementForUpdate(connection, UPDATE, user)) {
            return preparedStatement.executeUpdate();
        }
    }

    @Override
    public int delete(Integer id) throws SQLException {
        Connection connection = ConnectionManager.getConnection();
        try (PreparedStatement preparedStatement = createPreparedStatementById(connection, DELETE, id)) {
            return preparedStatement.executeUpdate();
        }
    }

    @Override
    public User selectByEmailAndPassword(String uEmail, String uPassword) throws SQLException {
        User user = null;
        Connection conn = ConnectionManager.getConnection();
        try (PreparedStatement preparedStatement = createPreparedStatementByEmailAndPassword(conn, FIND_BY_EMAIL_ADN_PASSWORD, uEmail, uPassword);
             ResultSet resultSet = preparedStatement.executeQuery()) {
            if (resultSet.next()) {
                int userId = resultSet.getInt(1);
                String email = resultSet.getString(2);
                String password = resultSet.getString(3);
                String firstName = resultSet.getString(4);
                String secondName = resultSet.getString(5);
                user = new User(userId, email, password, firstName, secondName);
            }
        }
        return user;
    }
}
