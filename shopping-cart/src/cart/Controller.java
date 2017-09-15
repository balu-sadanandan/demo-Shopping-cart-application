package cart;


import java.io.IOException;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.sql.*;
import java.util.*;
/**
 * Servlet implementation class Controller
 */
@WebServlet("//*")
public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
    protected Cartdao udao;   
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Controller() {
        super();
        // TODO Auto-generated constructor stub
    }
    public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		 udao= new Cartdao("jdbc:mysql://localhost:3306/shopcart","root","1234");
		 System.out.println("init");
		 
	}
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		System.out.println("in servlet now");
		String action = request.getServletPath();
		System.out.println("printing action");
		System.out.println(action);
		HttpSession session=request.getSession();
		//session.setMaxInactiveInterval(120);
		if(session.isNew())
		{
			System.out.println("new");
			session.setAttribute("login", "invalid");
			RequestDispatcher dispatcher = request.getRequestDispatcher("login1.jsp");
	        dispatcher.forward(request, response);
	        return;
		}
		if(action.equals("/login")){
			validate(request,response);
		}
			
		
		if((session.getAttribute("login").equals("admin")))
		{// the switch case should be here
			System.out.println("inside admin page");
			try{
			switch(action){
			case "/logout":
            	session.invalidate();
            	session=request.getSession();
    	    	session.setAttribute("login", "invalid");
              	RequestDispatcher dispatcher = request.getRequestDispatcher("login1.jsp");
    	        dispatcher.forward(request, response);
            	break;
			case "/new":
				showNewForm(request, response);
				break;
			case "/edit":
				showEditForm(request, response);
				break;
			case "/insert":
				insertUser(request, response);
				break;
			case "/update":
				updateUser(request, response);
				break;
			case "/delete":
				deleteUser(request, response);
				break;
				
				
						
			default:
				listUsers(request, response);
				
			}
			}
			catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
//				System.out.println("somthing went wrong!");
			}
			
			
			
		}
		//if session is old and admin is not validated
		else {
    		System.out.println("nice try");
    		RequestDispatcher dispatch = request.getRequestDispatcher("login1.jsp");
	        dispatch.forward(request, response);
	        return;
    	}
		
		
		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	private void validate(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException
	{
		System.out.println(request.getParameter("uname"));
		String uname=request.getParameter("uname");
		String pwd=request.getParameter("pass");
		if((uname.equals("admin")))
		{
			HttpSession session= request.getSession();
			session.setAttribute("login", "admin");
			System.out.println("login is valid");			
		}
				
		else {
			try{
				List<User> uList = udao.listAll();	
				Iterator itr =uList.iterator();
				while(itr.hasNext())
				{
					User uit =(User) itr.next();
					System.out.println(uit.getName());
					if((uname.equals(uit.getName()))&&(pwd.equals(uit.getPwd())))
							{
								System.out.println("user validated");
								HttpSession session= request.getSession();
								session.setAttribute("login", "user");
							}
				}
				HttpSession session= request.getSession();
				if(!session.getAttribute("login").equals("user")){
					System.out.println("wrong data");
					RequestDispatcher dispatcher = request.getRequestDispatcher("login2.jsp");
			        dispatcher.forward(request, response);
				}
				
			}
			catch (Exception e) {
				// TODO: handle exception
				System.out.println("couldnt fetch userlist to validate login");
			}
//			 
//			System.out.println("wrong data");
//			RequestDispatcher dispatcher = request.getRequestDispatcher("login2.jsp");
//	        dispatcher.forward(request, response);
		}
			
			
	}
	private void listUsers(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException{
		 List<User> uList = udao.listAll();
		 System.out.println("got sql data");
	        request.setAttribute("userlist",uList);
	        RequestDispatcher dispatcher = request.getRequestDispatcher("userlist.jsp");
	        dispatcher.forward(request, response);
	        return;
	     
	        
	}
	private void showEditForm(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        User u= udao.getUser(id);
        RequestDispatcher dispatcher = request.getRequestDispatcher("form.jsp");
        request.setAttribute("user", u);
        dispatcher.forward(request, response);
        return;
 
    }
	private void showNewForm(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
	 System.out.println("new form");
        RequestDispatcher dispatcher = request.getRequestDispatcher("/form.jsp");
        dispatcher.forward(request, response);
        return;
    }
	
	 private void insertUser(HttpServletRequest request, HttpServletResponse response)
	            throws SQLException, IOException, ServletException {
		         
	        String name = request.getParameter("name");
	        String pwd = request.getParameter("pwd");
	        String mid = request.getParameter("mid");
	        User u= new User(name, pwd, mid);
	        udao.addUser(u);	            
	        response.sendRedirect("list");
	        return;
	    }
	
	 private void updateUser(HttpServletRequest request, HttpServletResponse response)
	            throws SQLException, IOException, ServletException {
	        int id = Integer.parseInt(request.getParameter("id"));
	        String name = request.getParameter("name");
	        String pwd = request.getParameter("pwd");
	        String mid = request.getParameter("mid");
	        User u =new User(id, name, pwd, mid);         
	          if(  udao.updateUser(u))
	    	  System.out.println("update success");
	      else
	    	  System.out.println("some thing went wrong");
	        System.out.println("udating sql database");
	        response.sendRedirect("list");
	        return;
	    }
	 private void deleteUser(HttpServletRequest request, HttpServletResponse response)
	            throws SQLException, IOException {
	        int id = Integer.parseInt(request.getParameter("id"));
	        User u=new User(id);
	        udao.deleteUser(u);	       
	        response.sendRedirect("list");
	        return;
	 } 
	 

}
