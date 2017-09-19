package cart.dao;
import java.util.Properties;
import java.io.*;

public class Config {
	public static void main(String[] args) {
		Properties prop =new Properties();
		OutputStream output = null;
		try{
			output= new FileOutputStream("config.properties");
			prop.setProperty("jdbcURL", "jdbc:mysql://localhost:3306/shopcart");
			prop.setProperty("jdbcUsername", "root");
			prop.setProperty("jdbcPassword", "1234");
			prop.store(output, null);		
	      
		}catch(IOException io){
			io.printStackTrace();
		}finally{
			if(output!=null){
				try{
					output.close();
				}catch(IOException e){
					e.printStackTrace();
				}
			}
			
		}
		
	}

}
