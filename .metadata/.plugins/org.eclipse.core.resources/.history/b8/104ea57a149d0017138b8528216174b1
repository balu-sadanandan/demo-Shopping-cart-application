package cart;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class Pdao {
	private String jdbcURL;
    private String jdbcUsername;
    private String jdbcPassword;
    private Connection conn;
    public Pdao(String jdbcURL, String jdbcUsername, String jdbcPassword) {
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
    public boolean addItem(Prod p) throws SQLException{
    	String sql = "INSERT INTO prodcat (prodid,name,price,description)  VALUES (?, ?, ?,?)";
    	//INSERT into prodcat (prodid,name,price) VALUES ("02","monitor","10574");
    	connect();
		 
		PreparedStatement statement = conn.prepareStatement(sql);
		//statement.setString(1, Integer.toString(e.getEmp_id()));
		statement.setString(1,Integer.toString(p.getProdid()));
		statement.setString(2,p.getName() );
		statement.setString(3,Integer.toString(p.getPrice()));
		statement.setString(4,p.getDesc());
		 
		int rowsInserted = statement.executeUpdate();
				statement.close();
		disconnect();
		//conn.close();
		if (rowsInserted > 0) {
		    System.out.println("A new item was inserted successfully!");
		    return true;
		}
		return false;
    }
    public boolean deleteItem(Prod p) throws SQLException {
        String sql = "DELETE FROM prodcat where prodid = ?";
         
        connect();
         
        PreparedStatement statement = conn.prepareStatement(sql);
        statement.setInt(1,p.getProdid());         
        boolean rowDeleted = statement.executeUpdate() > 0;
        statement.close();
        disconnect();
        return rowDeleted;     
    }
    public Prod getItem(int id) throws SQLException {
         Prod p = null;
        String sql = "SELECT * FROM prodcat WHERE prodid = ?";
         
        connect();
         
        PreparedStatement statement = conn.prepareStatement(sql);
        statement.setInt(1, id);
         
        ResultSet resultSet = statement.executeQuery();
         
        if (resultSet.next()) {
            String name = resultSet.getString("name");
            int  price = Integer.parseInt(resultSet.getString("price"));
            String desc = resultSet.getString("description");
            p= new Prod(id,name,price,desc);            
                  }
         
        resultSet.close();
        statement.close();
         
        return p;
    }
    //outputs the product list with all details except the description 
    public List<Prod> listAll() throws SQLException {
        List<Prod> pList = new ArrayList<>();
         
        String sql = "SELECT * FROM prodcat";
         
        connect();
         
        Statement statement = conn.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);
         
        while (resultSet.next()) {
            int id = resultSet.getInt("prodid");
            String name = resultSet.getString("name");
            int price=Integer.parseInt(resultSet.getString("price"));           
            Prod p=new Prod(id, name, price);
            pList.add(p);
            }
         
        resultSet.close();
        statement.close();
         
        disconnect();
       return pList;
    }
    public boolean updateProd(Prod p) throws SQLException {
        String sql = "UPDATE prodcat SET  name  = ?, price= ?, description = ?";
        sql += " WHERE prodid = ?";
        connect();
         
        PreparedStatement statement = conn.prepareStatement(sql);
        statement.setString(1,p.getName() );
        statement.setString(2,Integer.toString(p.getPrice()));
        statement.setString(3,p.getDesc() );  
        statement.setString(4,Integer.toString(p.getProdid()));
        boolean rowUpdated = statement.executeUpdate() > 0;
        statement.close();
        disconnect();
        return rowUpdated;     
    }
    
    

}
