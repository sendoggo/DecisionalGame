
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Francesco
 */
public class DBconnection {
    final private String driver = "com.mysql.jdbc.Driver";
    final private String url = "jdbc:mysql://lochnagar.abertay.ac.uk/sql1702439";
    final private String user = "sql1702439";
    final private String password = "n8HXtGlbgGVg";
    private Connection db;
    private boolean connected;
    
    public DBconnection(){
       
        try {
            Class.forName(driver);
            db = DriverManager.getConnection(url, user, password);
            connected = true;
            System.out.println("Connected");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DBconnection.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(DBconnection.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }
    
    public void closeConnection(){
        try {
            db.close();
        }
        catch (SQLException e) {
        }
    }
    
    public void getQuestions(){        
        try {
            Statement statement = db.createStatement();
            ResultSet result = statement.executeQuery( "SELECT id,question,answer1,answer2,answer1Pop, answer1Earn, answer2Pop, answer2Earn FROM Question ;");
            while (result.next()) {
                System.out.println(result.getInt(1));
                System.out.println(result.getString(2));
                System.out.println(result.getString(3));
                System.out.println(result.getString(4));
                System.out.println(result.getInt(5));
                System.out.println(result.getInt(6));
                System.out.println(result.getInt(7));
                System.out.println(result.getInt(8));
            }
            
            result.close();
            statement.close();
            
        } catch (SQLException ex) {
            Logger.getLogger(DBconnection.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void deleteQuestion(int questionID){
        
    }
    
    public static void main(String args[]){
        DBconnection test = new DBconnection();
        test.getQuestions();
        
        test.closeConnection();
        
    }
}
