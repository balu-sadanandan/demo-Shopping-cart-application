package cart;

import java.sql.SQLException;
import java.util.*;

public class Dbtest {
public static void main(String[] args)  {
	Pdao t1= new Pdao("jdbc:mysql://localhost:3306/shopcart","root","1234");
	try {
		Prod p= new Prod(1,"cpu",5000,"xxx");
//		t1.addItem(p);
//		Prod p= new Prod(1);
//		t1.deleteItem(p);
//		p=t1.getItem(5);
//		System.out.println(p.desc);
//		List<Prod> plist =t1.listAll();
//		Iterator itr =plist.iterator();
//		while(itr.hasNext())
//		{
//			Prod pit =(Prod) itr.next();
//			System.out.println(pit.getName());
//		}
		t1.updateProd(p);
		
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}
}
