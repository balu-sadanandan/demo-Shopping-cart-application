package cart;
import java.util.*;

import cart.dao.Getprop;

import java.sql.SQLException;
import java.util.*;

public class Dbtest {
public static void main(String[] args)  {
//Pdao t1= new Pdao("jdbc:mysql://localhost:3306/shopcart","root","1234");
	//try
	{
		//Prod p= new Prod(1,"cpu",5000,"xxx");
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
		//t1.updateProd(p);
//		List<Ucart> ulist =t1.getUcart(10);
	//	Ucart cart=new Ucart(10,2,3);
//		Iterator itr =ulist.iterator();
//		while(itr.hasNext())
//		{
//			cart =(Ucart) itr.next();
//			System.out.println(cart.getProdid());
//		t1.deletefromCart(cart);
//		}
//		Random rand = new Random();
//		String d="Lorem ipsum dolor sit amet, consectetur adipiscing elit. Suspendisse vel massa ac ante sollicitudin accumsan a et odio. Aliquam erat volutpat. Pellentesque habitant morbi tristique senectus et netus et malesuada fames ac turpis egestas. Curabitur accumsan suscipit auctor. Mauris sit amet mi aliquet, semper risus eu, dignissim eros. Maecenas euismod ex a nulla volutpat, a pharetra elit congue. Etiam pharetra placerat felis eleifend cursus. Suspendisse sem eros, egestas ac interdum quis, mattis nec sapien. In turpis tortor, fringilla id nisi vel, efficitur ullamcorper dolor. Mauris vel fermentum magna. Maecenas vel accumsan nisl, eu viverra eros. Quisque congue aliquet metus ac.";
//		String pname[]={"Finplus","Zaamstock","Tonsoft","Dento Hothome","Hot-Tone","Freshredlab","Zooplus","Lamfresh","Drip Tontex","Zenzumin","Grave Tam","Gravehold","Quotefind","Round Rantouch","Lightdom","Via-Find","Flexplus","Vivaex","Redcof","Hotdom","Zooeco","Rankquadfan","Zumma Otfax","Fax-Dom","Tipdox","Golden Cof","Zaam Fix","An Jaylam","Tam Eco","Vilatraxlam","Toughtam","Zummamatplus","Zer-Light","Vilatop","Voyasing","Rontouch","Domlight","Kon-Fan","Kaylax","Saltfresh","Fixlax","Damkeybam","Superin","Is-Dex","Hotron","Goodin","Kin-String","Fintone","Spanflex","Fin Danit","Siltamsing","Zoolab","An Kix","Span Silnix","Trans Jaytip","Itzimdex","Saltron","Whiteex","Ron Kix","Kaystring","Newtech","Soft Otdom","Lottip","Hotcof","Move Lux","Bio Dex","Newlam","Lamjob","Driptom","Singlewarm","Intop","Physfix","Homekix","Rankcore","Tempdax","Aptip","Biohome","Viva Tanflex","U-job","Fresh Zap","Ventozamit","Rankex","Geoing","Flexdamit","Golden-Ron","Cofmatfresh","Medstrong","Dong Kix","Big-Nix","Uno Phase","Lalex","Touchcom","Anfan","Phys Is","Medmatstrong","Trisla","Icetom","Volity","Zummaron","Singlefix","Kinkeycof","Quotefresh","Zoomtough","Is-String","Touching","Good-Eco","Tip-Tech","Silvertone","Nam Dax","Plus Tough","Tristouch","Xxx--Lam","Betabam","Tech Otlux","Duotex","Icetouch","Medkix","Nimtom","Faxtax","Jayair","Qvosing","Zun Nix","Tree Silin","Conair","Freeair","Joblux","Kaydex","Fasedom","Spanit","Sub Zunwarm","Quotein","Roundtouch","Cansiltop","Whitedex","Itit","Dongex","K-tone","Biohotit","Sub-Air","Kansing","Gravecof","Touch Otkix","Kanlab","Sondex","Stan Strong","Domlam","Opezumis","Itity","Sanlight","Nimflex","Singdamdox","Ton Saolux","Volt Hathold","Joblight"};
//
//		int  n = rand.nextInt(50) + 1;
//		for(int i=101;i<200;i++)
//		{
//		int id = i;
//        String name = pname[i-100];
//        int price = rand.nextInt(50000) + 100;
//        String desc = d;
//       Prod p=new Prod(id, name, price, desc);
//       //System.out.println(p.getPrice()); 
//       t1.addItem(p);	
//		}
//		
//		
		
		System.out.println(Getprop.getJdbcUsername());
		
		//System.out.println(t1.getItem(0).getName());
	}	
//	 catch (SQLException e) {
//		// TODO Auto-generated catch block
//		e.printStackTrace();
//	}
}
}
