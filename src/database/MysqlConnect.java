/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

import com.mysql.jdbc.Connection;
import java.sql.*;
import java.sql.DriverManager;

/**
 *
 * @author selvera
 */
public final class MysqlConnect {

    public Connection conn;
    private Statement statement;
    public static MysqlConnect db;

    private MysqlConnect() {
        String url = "jdbc:mysql://localhost:3306/";
        String dbName = "citation";			//modify according to your DB
        String driver = "com.mysql.jdbc.Driver";
        String userName = "root";				//modify according to your user
        String password = "Bjms83936878.,";				//modify according to your password
        try {
            Class.forName(driver).newInstance();
            this.conn = (Connection) DriverManager.getConnection(url + dbName, userName, password);
        } catch (Exception sqle) {
            sqle.printStackTrace();
        }
    }

    /**
     *
     * @return MysqlConnect Database connection object
     */
    public static synchronized MysqlConnect getDbCon() {
        if (db == null) {
            db = new MysqlConnect();
        }
        return db;

    }

    /**
     *
     * @param query String The query to be executed
     * @return a ResultSet object containing the results or null if not
     * available
     * @throws SQLException
     */
    public ResultSet query(String query) throws SQLException {
        statement = db.conn.createStatement();
        ResultSet res = statement.executeQuery(query);
        return res;
    }

    /**
     * @desc Method to insert data to a table
     * @param insertQuery String The Insert query
     * @return boolean
     * @throws SQLException
     */
    public int insert(String insertQuery) throws SQLException {
        statement = db.conn.createStatement();
        int result = statement.executeUpdate(insertQuery, Statement.RETURN_GENERATED_KEYS);

   
       

        return result;

    }

    /**
     * @desc Method to insert data to a table with PreparedStatement
     * @param insertQuery String The Insert query
     * @return boolean
     * @throws SQLException
     */
    public PreparedStatement preparedStatement(String insertQuery) throws SQLException {

        PreparedStatement result = db.conn.prepareStatement(insertQuery);
        return result;

    }
}
