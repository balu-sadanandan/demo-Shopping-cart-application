package cart;
import java.sql.*;
import java.util.*;
public class Cartdao {
	private String jdbcURL;
    private String jdbcUsername;
    private String jdbcPassword;
    private Connection conn;
    public Cartdao(String jdbcURL, String jdbcUsername, String jdbcPassword) {
        this.jdbcURL =jdbcURL ;
        this.jdbcUsername = jdbcUsername;
        this.jdbcPassword = jdbcPassword;
    }

    protected void connect() throws SQLException {
        if (conn == null ||conn.isClosed()) {
            try {
                Class.forName("com.mysql.jdbc.Driver");
            } catch (ClassNotFoundException e) {
                throw new SQLException(e);
            }
            conn = DriverManager.getConnection(
                                        jdbcURL, jdbcUsername, jdbcPassword);
            if (conn != null) {
		        System.out.println("Connected");
		    }
        }
    }
     
    protected void disconnect() throws SQLException {
        if (conn != null && !conn.isClosed()) {
            conn.close();
        }

}
    public boolean addUser(User u) throws SQLException{
    	String sql = "INSERT INTO userlist (username,password,emailid)  VALUES (?, ?, ?)";
    	connect();
		 
		PreparedStatement statement = conn.prepareStatement(sql);
		//statement.setString(1, Integer.toString(e.getEmp_id()));
		statement.setString(1, u.getName());
		statement.setString(2, u.getPwd());
		statement.setString(3, u.getMailid());
		 
		int rowsInserted = statement.executeUpdate();
		
		statement.close();
		disconnect();
		//conn.close();
		if (rowsInserted > 0) {
		    System.out.println("A new user was inserted successfully!");
		    return true;
		}
		return false;
    }
    public boolean deleteUser(User u) throws SQLException {
        String sql = "DELETE FROM userlist where userid = ?";
         
        connect();
         
        PreparedStatement statement = conn.prepareStatement(sql);
        statement.setInt(1,u.getUid());         
        boolean rowDeleted = statement.executeUpdate() > 0;
        statement.close();
        disconnect();
        return rowDeleted;     
    }
    public User getUser(int id) throws SQLException {
        User u = null;
        String sql = "SELECT * FROM userlist WHERE userid = ?";
         
        connect();
         
        PreparedStatement statement = conn.prepareStatement(sql);
        statement.setInt(1, id);
         
        ResultSet resultSet = statement.executeQuery();
         
        if (resultSet.next()) {
            String name = resultSet.getString("username");
            String pwd = resultSet.getString("password");
            String mailid = resultSet.getString("emailid");
            
             
            u= new User(id, name, pwd, mailid);
        }
         
        resultSet.close();
        statement.close();
         
        return u;
    }
    
    public List<User> listAll() throws SQLException {
        List<User> uList = new ArrayList<>();
         
        String sql = "SELECT * FROM userlist";
         
        connect();
         
        Statement statement = conn.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);
         
        while (resultSet.next()) {
            int id = resultSet.getInt("userid");
            String name = resultSet.getString("username");
            String pwd = resultSet.getString("password");
            String mid =resultSet.getString("emailid");
             
            User u = new User(id, name, pwd, mid);
            uList.add(u);
            }
         
        resultSet.close();
        statement.close();
         
        disconnect();
        return uList;
    }
    public boolean updateUser(User u) throws SQLException {
        String sql = "UPDATE userlist SET username = ?, password  = ?, emailid = ?";
        sql += " WHERE userid = ?";
        connect();
         
        PreparedStatement statement = conn.prepareStatement(sql);
        statement.setString(1, u.getName());
        statement.setString(2, u.getPwd());
        statement.setString(3, u.getMailid());
        statement.setString(4, Integer.toString(u.getUid()));       
        boolean rowUpdated = statement.executeUpdate() > 0;
        statement.close();
        disconnect();
        return rowUpdated;     
    }
    
    public  void run() throws SQLException {
    	
    	//User u= new User(5);
    	//addUser(u);
    	//deleteUser(u);
    	//User u = getUser(6);
    	//System.out.println(u.getName());
    	//System.out.println(u.getMailid());
    	
    	List<User> u= listAll();
		Iterator itr =u.iterator();
		while(itr.hasNext())
		{
			User uit =(User) itr.next();
			System.out.println(uit.getName());
		}
//    	
//    	User u=new User(7,"name1","fght","mailid");
//    	updateUser(u);
    	
    	
	}
    
}


