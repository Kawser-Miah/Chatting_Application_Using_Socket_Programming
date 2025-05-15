/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package chatting_application.dao;

import chatting_application.entitymodel.UserEntityModel;
import chatting_application.exception.NullException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author Lenovo
 */
interface User_dao {

    public UserEntityModel reed(UserEntityModel user, Statement statement) throws NullException;

}

public class User implements User_dao {

    @Override
    public UserEntityModel reed(UserEntityModel user, Statement statement) throws NullException {
        UserEntityModel u = null;
        String query = "SELECT * FROM users WHERE user_id = " + user.userId + " AND password = '" + user.password + "'";
        try {
            ResultSet result = statement.executeQuery(query);
            if (result.next()) {
                u = new UserEntityModel(
                        result.getInt("id"),
                        result.getString("username"),
                        result.getString("fullName"),
                        result.getString("password"),
                        result.getInt("user_id")
                );
            } else {
                throw new NullException();
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
        return u;
    }

}
