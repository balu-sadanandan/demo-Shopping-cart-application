package cart;

import java.sql.SQLException;

public class Dbtest {
public static void main(String[] args)  {
	Cartdao t1= new Cartdao("jdbc:mysql://localhost:3306/shopcart","root","1234");
	try {
		t1.run();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}
}
