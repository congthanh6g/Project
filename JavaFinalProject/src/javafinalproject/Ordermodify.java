/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafinalproject;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author abc
 */
public class Ordermodify {
    public static void insert(Order order) {
        Connection connection = null;

        // for parametirized query
        PreparedStatement statement = null;
        try {
            // Ket noi toi database : jdbc : mysql://localhost:3306/ ten ; tai khoan + mat khau
            //muc dich lay danh sach tat ca sinh vien :
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/finalproject02?serverTimezone=UTC", "root", "");

            //Query
            String sql = "insert into finalproject02(order_id ,orderDate, STATUS , comments ,customerID) values(?,?,?,?,?)";
            //
            statement = connection.prepareCall(sql);

            statement.setInt(1, order.getOrderid());
            statement.setString(2, order.getDate());
            statement.setString(3, order.getStatus());
            statement.setString(4, order.getComments());
            statement.setInt(5, order.getCustomerID());

            statement.execute();

        } catch (SQLException ex) {
            Logger.getLogger(Ordermodify.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(Ordermodify.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            // neu connection da chay , dong connection.
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(Ordermodify.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }
}
