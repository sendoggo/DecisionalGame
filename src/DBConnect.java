import java.sql.Statement;

import java.sql.*;

public class DBConnect {

    private Connection con;
    private Statement st;
    private ResultSet rs;

    public DBConnect() {
        try {

            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://lochnagar.abertay.ac.uk:3306/sql1702439","sql1702439","n8HXtGlbgGVg");
            st = con.createStatement();

        } catch (Exception ex) {
            System.out.println("Error: " + ex);
        }
    }

    public void getData(){
        try{

            String query= "SELECT * FROM Question";
            rs = st.executeQuery(query);
            System.out.println("Records from Database");
            while(rs.next()){
                String question = rs.getString("question");
                String answer1 = rs.getString("answer1");
                System.out.println("Question: "+question+" "+"Answer 1"+answer1);
            }

        }catch(Exception ex){
            System.out.println(ex);
        }
    }
}
