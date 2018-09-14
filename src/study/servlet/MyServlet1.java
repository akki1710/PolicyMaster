package study.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.sql.*;
import java.util.Random;

import study.db.Db;

/**
 * Servlet implementation class MyServlet1
 */
@WebServlet("/MyServlet1")
public class MyServlet1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MyServlet1() {
        super();
        // TODO Auto-generated constructor stub
    }

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 PrintWriter pw = response.getWriter();
		
	}
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");  
        PrintWriter pw = response.getWriter(); 
        
        String policy=request.getParameter("policy");
        
        HttpSession session=request.getSession();		
        String ProposalNo=(String) session.getAttribute("ec1");
        String VehicleIDV=(String) session.getAttribute("ec2");
        String Premium=(String) session.getAttribute("Premium1");
        String PolSysId=(String) session.getAttribute("ec");
        Random rand1 = new Random();
        int num = rand1.nextInt(9000000) + 1000000;
		String transid=Integer.toString(num);
		session.setAttribute("transid", transid);
		session.setAttribute("policy", policy);
        
        if(policy.equals("Motor Package"))
        {
        

        try {
			Connection con = Db.myGetConnection();
			
			String s="insert into quote(PolSysId,policy,ProposalNo,VehicleIDV,Premium) values(?,?,?,?,?)";
			PreparedStatement stmt = con.prepareStatement(s);
			stmt.setString(1, PolSysId);
			stmt.setString(2, policy);
			stmt.setString(3, ProposalNo);
			stmt.setString(4, VehicleIDV);
			stmt.setString(5, Premium);
			
			response.sendRedirect("Details2");
			
            stmt.executeUpdate();
			
			stmt.close();
			pw.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        if(session!=null) {
			session.removeAttribute("ec1");
			session.removeAttribute("ec2");
			session.removeAttribute("Premium1");
			}
        }
        
        else if(policy.equals("Online Term Plus"))
        {
        	

            try {
    			Connection con = Db.myGetConnection();
    			
    			String s="insert into policyname(policy) values(?)";
    			PreparedStatement stmt = con.prepareStatement(s);
    			stmt.setString(1, policy);
    			
    			response.sendRedirect("abc.jsp");
    			
                stmt.executeUpdate();
    			
    			stmt.close();
    			pw.close();
    			
    		} catch (SQLException e) {
    			// TODO Auto-generated catch block
    			e.printStackTrace();
    		}
        	
        }
        
        else if(policy.equals("e-Term Life")) {

            try {
    			Connection con = Db.myGetConnection();
    			
    			String s="insert into policyname(policy) values(?)";
    			PreparedStatement stmt = con.prepareStatement(s);
    			stmt.setString(1, policy);
    			
    			response.sendRedirect("abc.jsp");
    			
                stmt.executeUpdate();
    			
    			stmt.close();
    			pw.close();
    		} catch (SQLException e) {
    			// TODO Auto-generated catch block
    			e.printStackTrace();
    		}
        	
        	
        }
        
	}
        

}
