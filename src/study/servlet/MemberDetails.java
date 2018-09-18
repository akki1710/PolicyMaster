package study.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.apollo_proposal_pojo;

import Apollo.apollo;
import study.religare.Religare;

/**
 * Servlet implementation class MemberDetails
 */
@WebServlet("/MemberDetails")
public class MemberDetails extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MemberDetails() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/*response.sendRedirect("index");
		return;*/
				 //PrintWriter pw = response.getWriter();
		 HttpSession session=request.getSession();	
		 String health_policy=(String) session.getAttribute("health_policy");
		 String disease=(String) session.getAttribute("member_disease");
		 
		 String salutation=request.getParameter("salutation");
		 String fullname=request.getParameter("fullname");
		 String dob=request.getParameter("dob");
		 String occupation=request.getParameter("occupation");
		 String height=request.getParameter("height");
		 String height1=request.getParameter("height1");
		 String weight=request.getParameter("weight");
		 String mobile=request.getParameter("mobile");
		 String email=request.getParameter("email");
		 String address=request.getParameter("address");
		 String city=request.getParameter("city");
		 String state=request.getParameter("state");
		 String pincode=request.getParameter("pincode");
		 String nomsalutation=request.getParameter("nomsalutation");
		 String nomname=request.getParameter("nomname");
		 String nomrelation=request.getParameter("nomrelation");
		 String nommobile=request.getParameter("nommobile");
		 String nomdob=request.getParameter("nomdob");
		 String nomoccupation=request.getParameter("nomoccupation");
		 String nomemail=request.getParameter("nomemail");
		 String nomaddress=request.getParameter("nomaddress");
		 String nomcity=request.getParameter("nomcity");
		 String nomstate=request.getParameter("nomstate");
		 String nompincode=request.getParameter("nompincode");
		 
		 System.out.println("salutation: "+salutation);
		 System.out.println("fullname: "+fullname);
		 System.out.println("dob: "+dob);
		 System.out.println("mobile: "+mobile);
		 System.out.println("email: "+email);
		 System.out.println("address: "+address);
		 System.out.println("city: "+city);
		 System.out.println("state: "+state);
		 System.out.println("pincode: "+pincode);
		 System.out.println("nomsalutation: "+nomsalutation);
		 System.out.println("nomname: "+nomname);
		 System.out.println("nomrelation: "+nomrelation);
		 System.out.println("nommobile: "+nommobile);
		 System.out.println("nomdob: "+nomdob);
		 System.out.println("nomemail: "+nomemail);
		 System.out.println("nomaddress: "+nomaddress);
		 System.out.println("nomcity: "+nomcity);
		 System.out.println("nomstate: "+nomstate);
		 System.out.println("nompincode: "+nompincode);
		 
		 
	    	   apollo_proposal_pojo app=new apollo_proposal_pojo();
	    	   app.setFullname(fullname);
	    	   app.setSalutation(salutation);
	    	   app.setDob(dob);
	    	   app.setOccupation(occupation);
	    	   app.setHeight(height);
	    	   app.setHeight1(height1);
	    	   app.setWeight(weight);
	    	   app.setMobile(mobile);
	    	   app.setEmail(email);
	    	   app.setAddress(address);
	    	   app.setCity(city);
	    	   app.setState(state);
	    	   app.setPincode(pincode);
	    	   app.setDisease(disease);
	    	   app.setNomsalutation(nomsalutation);
	    	   app.setNomname(nomname);
	    	   app.setNomrelation(nomrelation);
	    	   app.setNommobile(nommobile);
	    	   app.setNomdob(nomdob);
	    	   app.setNomoccupation(nomoccupation);
	    	   app.setNomemail(nomemail);
	    	   app.setNomaddress(nomaddress);
	    	   app.setNomcity(nomcity);
	    	   app.setNomstate(nomstate);
	    	   app.setNompincode(nompincode);
	    	   
	    	   
	    	   session.setAttribute("app", app);
	    	   if(health_policy.equals("Carefreedom")) {

		    	   response.sendRedirect("Rel_Pay.jsp");
		    	   study.religare.Religare.religare_premium(request, response);
	    	   }
	    	   else if(health_policy.equals("Optima_Restore")) {
	    		   response.sendRedirect("diseasepaycart.jsp");
	    		   Apollo.apollo.apollo_proposal(request, response);
		    	   Apollo.apollo.apollo_payment(request, response);
		    	   
	    	   }
	    	   if(session!=null) {
	    		   session.removeAttribute("member_disease");
	    		   session.removeAttribute("rel_proposal_num");
	    		   session.removeAttribute("rel_premium");
	    		   session.removeAttribute("b");
	    	   }
	    	   
	    	   return;
	    	   //pw.close();
	}

}
