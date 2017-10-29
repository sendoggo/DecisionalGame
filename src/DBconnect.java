public class ConnectionManager {

    MysqlDataSource dataSource = new MysqlDataSource();
        dataSource.setUser("sql1702439");
        dataSource.setPassword("");
        dataSource.setServerName("lochnagar.abertay.ac.uk");

    Connection conn = dataSource.getConnection();
    Statement stmt = conn.createStatement();
    ResultSet rs = stmt.executeQuery("SELECT ID FROM Question");

        rs.close();
        stmt.close();
        conn.close();

}