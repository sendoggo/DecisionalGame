import java.sql.Statement;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DBConnection {

    private Connection con;
 

    public DBConnection() {
        try {

            Class.forName("com.mysql.jdbc.Driver");
            //con = DriverManager.getConnection("jdbc:mysql://lochnagar.abertay.ac.uk:3306/sql1702439","sql1702439","n8HXtGlbgGVg");
            
            con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/sql1702439","root","");
        } catch (Exception ex) {
            System.out.println("Error: " + ex);
        }
    }
    public void closeConnection(){
        try {
            con.close();
        }
        catch (SQLException e) {
        }
    }

    public void getData() throws SQLException{
        Statement st = null;
        ResultSet rs = null;
        try{
            
            st = con.createStatement();
            
            String query= "SELECT * FROM Question";
            rs = st.executeQuery(query);
            System.out.println("Records from Database");
            while(rs.next()){
                String question = rs.getString("question");
                String answer1 = rs.getString("answer1");
                System.out.println("Question: "+question+" "+"Answer 1"+answer1);
            }

        }catch(SQLException ex){
            System.out.println(ex);
            
            rs.close();
            st.close();
        }
    }

    boolean loginChecker(String _username,String _password){   
                                                    
        try{
            String username, password;
            Statement st;
            st = con.createStatement();
            ResultSet rs;
            String query = "SELECT * FROM users WHERE username = '"+ _username+"'";
            
            rs = st.executeQuery(query);
            
            if (!rs.isBeforeFirst()) { return false; } // no results = no such username in db
            else{ // matching password control
                while(rs.next()){
                    password = rs.getString("password"); 
                    if (password.equals(_password)) { return true; } // passwords match
                    else{ return false; } // passwords do not match

                }
            }

        }catch(Exception ex){
            System.out.println(ex);
            return false;
        }
        return false;
    }
}
