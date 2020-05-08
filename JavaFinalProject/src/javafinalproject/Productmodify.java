/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafinalproject;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author abc
 */
public class Productmodify {
    public static List<Products> findAll()
    {
        List<Products> productlist = new ArrayList<>();

        Connection connection = null;

        // an instruction that explains what should happen
        Statement statement = null;
        try {            
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/finalproject02?serverTimezone=UTC", "root", "");

            //Query
            String sql = "select * from products";
            // Creates a Statement object for sending SQL statements to the database
            statement = connection.createStatement();
            // A table of data representing a database result set, which is usually generated by executing a statement that queries the database.
            ResultSet resultSet = statement.executeQuery(sql);
            // reselutSet.next() == moves the pointer of the current (ResultSet) object to the next row, from the current position
            while (resultSet.next()) {
                
                // Create a student getting from resultSet ( database ) 
                Products products = new Products(resultSet.getInt("id"),
                        resultSet.getInt("quantity_inStock"),
                        resultSet.getString("NAME"),
                        resultSet.getString("description"),
                        resultSet.getFloat("price"));
                        

                productlist.add(products);
            }

        } catch (SQLException ex) {
            Logger.getLogger(Productmodify.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(Productmodify.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            // neu connection da chay , dong connection.
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(Productmodify.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }

        return productlist;
    }
    
    
    public static void insert(Products prd) {
        Connection connection = null;

        // for parametirized query
        PreparedStatement statement = null;
        try {
            // Ket noi toi database : jdbc : mysql://localhost:3306/ ten ; tai khoan + mat khau
            //muc dich lay danh sach tat ca sinh vien :
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/finalproject02?serverTimezone=UTC", "root", "");

            //Query
            String sql = "insert into products(id , NAME , description , price , quantity_inStock) values(?,?,?,?,?)";
            //
            statement = connection.prepareCall(sql);

            statement.setInt(1, prd.getId() );
            statement.setString(2, prd.getName());
            statement.setString(3 , prd.getDescription());
            statement.setFloat(4 , prd.getPrice());
            statement.setInt(5, prd.getQuantityinS());
            

            statement.execute();

        } catch (SQLException ex) {
            Logger.getLogger(Productmodify.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(Productmodify.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            // neu connection da chay , dong connection.
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(Productmodify.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }
    
    
    public static void delete(int id) {
        Connection connection = null;

        // for parametirized query
        PreparedStatement statement = null;
        try {
            // Ket noi toi database : jdbc : mysql://localhost:3306/ ten ; tai khoan + mat khau
            //muc dich lay danh sach tat ca sinh vien :
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/finalproject02?serverTimezone=UTC", "root", "");

            //Query
            String sql = "delete from products where id = ?";
            
            //
            statement = connection.prepareCall(sql);
            
            statement.setInt(1, id);
            
            statement.execute();
            

        } catch (SQLException ex) {
            Logger.getLogger(Productmodify.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(Productmodify.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            // neu connection da chay , dong connection.
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(Productmodify.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }
    
    public static List<Products> findByFullname( String NAME ) {
        List<Products> productlist = new ArrayList<>();

        Connection connection = null;

        // an instruction that explains what should happen
        PreparedStatement statement = null;
        try {
            
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/finalproject02?serverTimezone=UTC", "root", "");

            //Query
            String sql = "select * from products WHERE NAME like ?";
            // Creates a Statement object for sending SQL statements to the database
            statement = connection.prepareCall(sql);
            
            statement.setString(1, "%" + NAME + "%");
            
            
            // A table of data representing a database result set, which is usually generated by executing a statement that queries the database.
            ResultSet resultSet = statement.executeQuery(sql);
            // reselutSet.next() == moves the pointer of the current (ResultSet) object to the next row, from the current position
            while (resultSet.next()) {
                
                // Create a student getting from resultSet ( database ) 
                Products products = new Products(resultSet.getInt("id"),
                        resultSet.getInt("quantity_inStock"),
                        resultSet.getString("NAME"),
                        resultSet.getString("description"),
                        resultSet.getFloat("price"));
                productlist.add(products);
            }

        } catch (SQLException ex) {
            Logger.getLogger(Productmodify.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(Productmodify.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            // neu connection da chay , dong connection.
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(Productmodify.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }

        return productlist;
    }
    
    public static List<Products> findByID( int id ) {
        List<Products> productlist = new ArrayList<>();

        Connection connection = null;

        // an instruction that explains what should happen
        PreparedStatement statement = null;
        try {
            // Ket noi toi database : jdbc : mysql://localhost:3306/ ten ; tai khoan + mat khau
            //muc dich lay danh sach tat ca sinh vien :
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/finalproject02?serverTimezone=UTC", "root", "");

            //Query
            String sql = "select * from products WHERE id = ?";
            // Creates a Statement object for sending SQL statements to the database
            statement = connection.prepareCall(sql);
            
            statement.setInt(1, id);
            
            
            // A table of data representing a database result set, which is usually generated by executing a statement that queries the database.
            ResultSet resultSet = statement.executeQuery(sql);
            // reselutSet.next() == moves the pointer of the current (ResultSet) object to the next row, from the current position
            while (resultSet.next()) {
                
                // Create a student getting from resultSet ( database ) 
                Products products = new Products(resultSet.getInt("id"),
                        resultSet.getInt("quantity_inStock"),
                        resultSet.getString("NAME"),
                        resultSet.getString("description"),
                        resultSet.getFloat("price"));
                productlist.add(products);
            }

        } catch (SQLException ex) {
            Logger.getLogger(Productmodify.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(Productmodify.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            // neu connection da chay , dong connection.
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(Productmodify.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }

        return productlist;
    }
    
    public static List<Products> findABLE()
    {
        List<Products> productlist = new ArrayList<>();

        Connection connection = null;

        // an instruction that explains what should happen
        Statement statement = null;
        try {            
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/finalproject02?serverTimezone=UTC", "root", "");

            //Query
            String sql = "select * from products where quantity_inStock > 0 ";
            // Creates a Statement object for sending SQL statements to the database
            statement = connection.createStatement();
            // A table of data representing a database result set, which is usually generated by executing a statement that queries the database.
            ResultSet resultSet = statement.executeQuery(sql);
            // reselutSet.next() == moves the pointer of the current (ResultSet) object to the next row, from the current position
            while (resultSet.next()) {
                
                // Create a student getting from resultSet ( database ) 
                Products products = new Products(resultSet.getInt("id"),
                        resultSet.getInt("quantity_inStock"),
                        resultSet.getString("NAME"),
                        resultSet.getString("description"),
                        resultSet.getFloat("price"));
                        

                productlist.add(products);
            }

        } catch (SQLException ex) {
            Logger.getLogger(Productmodify.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(Productmodify.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            // neu connection da chay , dong connection.
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(Productmodify.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }

        return productlist;
    }
    
    
    public static List<Products> findNOTABLE()
    {
        List<Products> productlist = new ArrayList<>();

        Connection connection = null;

        // an instruction that explains what should happen
        Statement statement = null;
        try {            
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/finalproject02?serverTimezone=UTC", "root", "");

            //Query
            String sql = "select * from products where quantity_inStock = 0 ";
            // Creates a Statement object for sending SQL statements to the database
            statement = connection.createStatement();
            // A table of data representing a database result set, which is usually generated by executing a statement that queries the database.
            ResultSet resultSet = statement.executeQuery(sql);
            // reselutSet.next() == moves the pointer of the current (ResultSet) object to the next row, from the current position
            while (resultSet.next()) {
                
                // Create a student getting from resultSet ( database ) 
                Products products = new Products(resultSet.getInt("id"),
                        resultSet.getInt("quantity_inStock"),
                        resultSet.getString("NAME"),
                        resultSet.getString("description"),
                        resultSet.getFloat("price"));
                        

                productlist.add(products);
            }

        } catch (SQLException ex) {
            Logger.getLogger(Productmodify.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(Productmodify.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            // neu connection da chay , dong connection.
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(Productmodify.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }

        return productlist;
    }

}
