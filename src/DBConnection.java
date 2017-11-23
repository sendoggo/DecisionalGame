import java.sql.Statement;

import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class DBConnection {

    private Connection con;
 

    public DBConnection() {
        
        try {
            // recall the external library for db connection
            Class.forName("com.mysql.jdbc.Driver");
            // connection string + used db + username and password
            //con = DriverManager.getConnection("jdbc:mysql://lochnagar.abertay.ac.uk:3306/sql1702439","sql1702439","n8HXtGlbgGVg");
            con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/sql1702439","root","");
        } catch (Exception ex) {
            System.out.println("Error: " + ex);
            JOptionPane.showMessageDialog(null, "Unable to connect to the Database","Error", JOptionPane.ERROR_MESSAGE);
            
            System.exit(0);
        }
    }
    public void closeConnection(){
        try {
            con.close();
        }
        catch (SQLException e) {
        }
    }

    // returns an arraylist of all the questions on the db
    public ArrayList<QuestionStruct> getQuestions() throws SQLException{
        Statement st = null;
        ResultSet rs = null;
        ArrayList<QuestionStruct> list = new ArrayList<>();
        
        try{
            
            st = con.createStatement();
            
            String query= "SELECT * FROM questions";
            rs = st.executeQuery(query);
            while(rs.next()){
                
                String question = rs.getString("question");
                String answer1 = rs.getString("answer1");
                list.add(new QuestionStruct(rs.getInt("id"),rs.getString("question"), rs.getString("answer1"), rs.getString("answer2"),rs.getInt("answer1Pop"),rs.getInt("answer2Pop"),rs.getInt("answer1Earn"),rs.getInt("answer2Earn")));
                
            }
            return list;
        }catch(SQLException ex){
            System.out.println(ex);
        }
        
        return list;
    }
    
    // insert a new question with the relative answers and scoring to the db
    boolean insertNewQuestion(String question, String answer1, String answer2, int answer1Pop, int answer2Pop, int answer1Earn, int answer2Earn){
        
        try {
            String query = "INSERT INTO questions(question, answer1, answer2, answer1Pop, answer2Pop, answer1Earn, answer2Earn) VALUES (\""+question+"\",\""+answer1+"\",\""+answer2+"\","+answer1Pop+","+answer2Pop+","+answer1Earn+","+answer2Earn+")";
            Statement st;
            st = con.createStatement();
            
            st.executeUpdate(query);
            return true;
        } catch (SQLException ex) {
            System.out.println(ex);
            return false;
        }
    }
    
    // delete a question and relative answers and scoring based on the question ID
    boolean deleteQuestion(int id){
        
        try {
            String query = "DELETE FROM questions WHERE id="+id;
            Statement st;
            st = con.createStatement();
            
            st.executeUpdate(query);
            return true;
        } catch (SQLException ex) {
            System.out.println(ex);
            return false;
        }
    }
    
    // check the validity of entered username and password
    boolean loginChecker(String _username,String _password){   
                                                    
        try{
            String username, password;
            Statement st;
            st = con.createStatement();
            ResultSet rs;
            String query = "SELECT * FROM admins WHERE username = '"+ _username+"'";
            
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
