package cart.dao;
import java.util.Properties;
import java.io.*;

public class Getprop {
	static protected String jdbcURL="jdbc:mysql://localhost:3306/shopcart";//"jdbc\:mysql\://localhost\:3306/shopcart";
	static protected String jdbcUsername="root";
	static protected String jdbcPassword="1234";
//	static{
//		
//
//				Properties prop =new Properties();
//				InputStream input=null;
//				try{
//					input= new FileInputStream("config.properties");
//					prop.load(input);
//					System.out.println(prop.getProperty("jdbcURL"));
//					System.out.println(prop.getProperty("jdbcUsername"));
//					System.out.println(prop.getProperty("jdbcPassword"));
//					jdbcURL=prop.getProperty("jdbcURL");
//					jdbcUsername=prop.getProperty("jdbcUsername");
//					jdbcPassword=prop.getProperty("jdbcPassword");
//				}catch(IOException ex){
//					ex.printStackTrace();
//				}finally{
//					if(input!=null){
//						try{
//							input.close();
//						}catch(IOException e){
//							e.printStackTrace();
//						}
//					}
//				}
//			
//		
//	}
	public static String getJdbcUsername() {
		return jdbcUsername;
	}
	public static void setJdbcUsername(String jdbcUsername) {
		Getprop.jdbcUsername = jdbcUsername;
	}
	public static String getJdbcURL() {
		return jdbcURL;
	}
	public static void setJdbcURL(String jdbcURL) {
		Getprop.jdbcURL = jdbcURL;
	}
	public static String getJdbcPassword() {
		return jdbcPassword;
	}
	public static void setJdbcPassword(String jdbcPassword) {
		Getprop.jdbcPassword = jdbcPassword;
	}
	
	
}

