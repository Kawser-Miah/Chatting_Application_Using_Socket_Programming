/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package chatting_application.entitymodel;

/**
 *
 * @author Lenovo
 */
public class UserEntityModel {

    public int id;
    public String username;
    public String fullName;
    public String password;
    public int userId;

    public UserEntityModel() {
    }

    public UserEntityModel(int id, String username, String fullName, String password, int userId) {
        this.id = id;
        this.username = username;
        this.fullName = fullName;
        this.password = password;
        this.userId = userId;
    }

    public UserEntityModel(int userId, String password) {
        this.userId = userId;
        this.password = password;
    }

    @Override
    public String toString() {
        return "UserEntityModel{"
                + "id=" + id
                + ", username='" + username + '\''
                + ", fullName='" + fullName + '\''
                + ", password='" + password + '\''
                + ", userId=" + userId
                + '}';
    }
}
