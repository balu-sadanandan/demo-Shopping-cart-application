package cart.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;

import javax.servlet.http.HttpSession;

import cart.bean.Ucart;

public class Ucdao {
	private String jdbcURL;
    private String jdbcUsername;
    private String jdbcPassword;
    private Connection conn;
    public Ucdao() {
        this.jdbcURL =Getpropf.getJdbcURL();
        this.jdbcUsername = Getpropf.getJdbcUsername();
        this.jdbcPassword = Getpropf.getJdbcPassword();
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
    public boolean addtoCart(Ucart uc) throws SQLException{
    	String sql = "INSERT INTO ucart (uid,prodid,qty)  VALUES (?, ?,?)";
    	//INSERT into prodcat (prodid,name,price) VALUES ("02","monitor","10574");
    	System.out.println("Ädding to cart for user:"+uc.getUid());
    	List<Ucart> ulist =getUcart(uc.getUid());
		Ucart cart;
		Iterator itr =ulist.iterator();
		int flag=0;
		int tid=00;
		int q=0;
		while(itr.hasNext())
		{
			cart =(Ucart) itr.next();
			System.out.println(cart.getName());
			if(cart.getProdid()==uc.getProdid()){
				flag=1;
				tid=cart.getTid();
				q=cart.getQty();
			}
				
				
		}   	
    	
    	connect();
    	if(flag==1){
    		  sql = "UPDATE ucart SET  qty = ?";
    	        sql += " WHERE transactionid = ?";
    	        PreparedStatement statement = conn.prepareStatement(sql);
    	        statement.setString(1,Integer.toString(q+uc.getQty()) );
    	        statement.setString(2, Integer.toString(tid));
    	        boolean rowUpdated = statement.executeUpdate() > 0;
    	        statement.close();
    	        disconnect();
    	        return rowUpdated;   
    	}
		 
		PreparedStatement statement = conn.prepareStatement(sql);
		//statement.setString(1, Integer.toString(e.getEmp_id()));
		statement.setString(1,Integer.toString(uc.getUid()));
		statement.setString(2,Integer.toString(uc.getProdid()) );
		statement.setString(3,Integer.toString(uc.getQty()));
		 
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
    public List<Ucart> getUcart(int uid) throws SQLException{
    	Pdao p = new Pdao();
    	List<Ucart> ucList = new ArrayList<>();
    	String sql="select * from ucart where uid ="+uid;
    	connect();
		 
		Statement statement = conn.prepareStatement(sql);
		//statement.setString(1,Integer.toString(uid));
	     ResultSet resultSet = statement.executeQuery(sql);
	    
	     while (resultSet.next()) {
	            int prodid = resultSet.getInt("prodid");
	            int qty =resultSet.getInt("qty");    
	            int tid =resultSet.getInt("transactionid");
	            String name=p.getItem(prodid).getName();
	            int price=(p.getItem(prodid).getPrice())*qty;
//	            Ucart uc=new Ucart(uid, prodid,qty);   
//	            Ucart uc = new Ucart(tid, uid, prodid, qty);
	            Ucart uc =new Ucart(tid, uid, prodid, name, price, qty);
	            ucList.add(uc);
	            }
	 
	     
	    
	     
	         
	        resultSet.close();
	        statement.close();
	         
	        disconnect();
	       return ucList;
    }
    public boolean deletefromCart(Ucart uc) throws SQLException {
    	String sql;
    	List<Ucart> ulist =getUcart(uc.getUid());
		Ucart cart;
		Iterator itr =ulist.iterator();
		int flag=0;
		int tid=00;
		int q=0;
		while(itr.hasNext())
		{
			cart =(Ucart) itr.next();
			//System.out.println(cart.getProdid());
			if(cart.getProdid()==uc.getProdid()){
				flag=1;
				tid=cart.getTid();
				q=cart.getQty();
			}
				
				
		}   	
    	
    	connect();
    	if(q>1){
    		  sql = "UPDATE ucart SET  qty = ?";
    	        sql += " WHERE transactionid = ?";
    	        PreparedStatement statement = conn.prepareStatement(sql);
    	        statement.setString(1,Integer.toString(q-1 ));
    	        statement.setString(2, Integer.toString(tid));
    	        boolean rowUpdated = statement.executeUpdate() > 0;
    	        statement.close();
    	        disconnect();
    	        return rowUpdated;   
    	}
    	else
    	{
    	
    	
         sql = "DELETE FROM ucart where transactionid = ?";
         
        connect();
         
        PreparedStatement statement = conn.prepareStatement(sql);
        statement.setInt(1,tid);         
        boolean rowDeleted = statement.executeUpdate() > 0;
        statement.close();
        disconnect();
        return rowDeleted;     
    	}
    }




}
