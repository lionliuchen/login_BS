/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package src.DB;

/**
 *
 * @author Tom
 */

import com.mchange.v2.c3p0.ComboPooledDataSource;
import java.beans.PropertyVetoException;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public final class DBPool {
    private static DBPool dbpool;
    public ComboPooledDataSource cpds; 
    
    static {
        dbpool=new DBPool();
    }
    
    public DBPool(){
        try {
            cpds=new ComboPooledDataSource();
            cpds.setUser("root");
            cpds.setPassword("154704");
            cpds.setJdbcUrl("jdbc:mysql://127.0.0.1:3307/login");
            cpds.setDriverClass("com.mysql.jdbc.Driver");
            cpds.setInitialPoolSize(100);
            cpds.setMinPoolSize(100);
            cpds.setMaxPoolSize(1000);
            cpds.setMaxStatements(1000);
            cpds.setMaxIdleTime(0);
            cpds.setTestConnectionOnCheckin(true);
            cpds.setIdleConnectionTestPeriod(60);
        } catch (PropertyVetoException ex) {
            Logger.getLogger(DBPool.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    public final static DBPool getInstance(){
        return dbpool;
    }
    
    public final Connection getConnection(){
        try {
            return cpds.getConnection();
        } catch (SQLException ex) {
            throw new RuntimeException("无法从数据源获取连接 ", ex);
        }
    }
   
}
