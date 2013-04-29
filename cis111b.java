/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cis111b;

import java.sql.*;
import org.jooq.*;
import org.jooq.impl.*;
import org.jooq.conf.*;
import static generated.Tables.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


/**
 *
 * @author jmclaughlin
 */
public class CIS111b {


    //DSLContext create = DSL.using(CIS111b.connect(), CIS111b.getDialect(), CIS111b.getSettings());

    public static Settings getSettings() throws SQLException {
        Settings settings = new Settings();
        settings.setRenderFormatted(true); 
        settings.setRenderNameStyle(RenderNameStyle.LOWER); 
        settings.setRenderKeywordStyle(RenderKeywordStyle.UPPER); 
        settings.setRenderSchema(Boolean.FALSE);
        return settings;
    }
    
    public static SQLDialect getDialect() throws SQLException {
        SQLDialect dialect = SQLDialect.DERBY; 
        return dialect;
    }
    
    public static Connection connect() throws SQLException{
        String userName = "root";
        String password = "password";
        String url = "jdbc:derby://localhost:1527/school";
        Connection connection = DriverManager.getConnection(url, userName, password);
        return connection;
    }
    
    
    public static ResultSet getRS(String table) throws SQLException{
        
         Statement statement = CIS111b.connect().createStatement();
         ResultSet rs = statement.executeQuery("SELECT * FROM "+table);
        return rs;
    }
    
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws SQLException {

        cis111bRUN.init();

    }


}


