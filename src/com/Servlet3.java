package com;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import study.db.Db;

/**
 * Servlet implementation class Servlet3
 */
@WebServlet("/Servlet3")
public class Servlet3 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Servlet3() {
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
		HttpSession session=request.getSession();
		String Prefix=request.getParameter("title");
		String Car_RegNo= request.getParameter("Car_RegNo");
		 
		String Owner_Name = request.getParameter("Owner_Name");
		String Car_Registration_Address=request.getParameter("Registration_Address");
		String day=request.getParameter("day");
        String month=request.getParameter("month");
        String year=request.getParameter("year");
        String dateStr = year + "-" + month + "-" + day;
        String dateStr1= day + "-" + month + "-" + year; 
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        java.util.Date utilDate = null;
		try {
			utilDate = format.parse(dateStr);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());

	        String nomines_name = request.getParameter("nomines_name");
	        String nomines_relation =  request.getParameter("nomines_relation");
	        String selectage = request.getParameter("selectage");
	       
	        String engine_number = request.getParameter("engine_number");
	        String chassis_number = request.getParameter("chassis_number");
	        System.out.println("chassis_number: "+chassis_number);
	       
	        String selectime = request.getParameter("selectime");
	        String driving = request.getParameter("driving");
	        String evening = request.getParameter("evening");
	        String financed="";
	        String a[]=request.getParameterValues("financed");
	        for(int i=0;i<a.length;i++){
	            financed+=a[i]+"";}
	     
	        
	        String title = request.getParameter("title");
	        String email = request.getParameter("email");
	        String pno = request.getParameter("pno");
	        String month1= request.getParameter("month"); //edit
	        
	        String year1= request.getParameter("year"); //edit
	        
	        main m=new main();
	        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
	        String DateOfBirth=dateStr1;
			 Date date = new Date();  
			 String PolicyFromDt=formatter.format(date);
			 Calendar c = Calendar.getInstance();
			    c.setTime(date);
			    c.add(Calendar.DAY_OF_MONTH, 364);
			    Date end=c.getTime();
			    String PolicyToDt=formatter.format(end); 
			    String PolicyIssueDt=PolicyFromDt;
			    String[] g=m.Title(Prefix);
			    String InsuredPrefix=g[0];
			    String Gender=g[1];
			    String Address1=Car_Registration_Address;
			    System.out.println("Address"+Address1);
			    String State=Car_RegNo.substring(0,2);
			    String rto=Car_RegNo.substring(0,4);
				String RTOCODE=rto.substring(0,2)+"-"+rto.substring(2, rto.length());
			    
			    String City=m.city(RTOCODE);
			    String PinCode="110056";
			    String PolicyType="MOT-PLT-001";
			    String EngineNo=engine_number;
			    String FirstRegDt=PolicyIssueDt;
			    String ChassisNo=chassis_number;
			    String RegNo1=State;
			    String RegNo2=Car_RegNo.substring(2,4);
			    String RegNo3=Car_RegNo.substring(4,6);
			    String RegNo4=Car_RegNo.substring(6,10);
			    String NomineeNameforPAOwnerDriver=nomines_name;
			    String NomineeAgeforPAOwnerDriver=selectage;
			    String NomineeRelationforPAOwnerDriver=nomines_relation;
			    String VehicleManufactureYear1="2018";
			    
			 session.setAttribute("PolicyFromDt", PolicyFromDt);
			 session.setAttribute("PolicyToDt", PolicyToDt);
			 session.setAttribute("PolicyIssueDt", PolicyIssueDt);
			 session.setAttribute("InsuredPrefix", InsuredPrefix);
			 session.setAttribute("Gender", Gender); 
			 session.setAttribute("Address1", Address1);
			 session.setAttribute("State", State);
			 session.setAttribute("City", City);
			 session.setAttribute("PinCode", PinCode);
			 session.setAttribute("PolicyType", PolicyType);
			 session.setAttribute("DateOfBirth", DateOfBirth);
			 session.setAttribute("EngineNo", EngineNo);
			 session.setAttribute("FirstRegDt", FirstRegDt);
			 //remember VehicleType
			 session.setAttribute("ChassisNo", ChassisNo);
			 session.setAttribute("RTOCODE", RTOCODE);
			 session.setAttribute("RegNo1", RegNo1);
			 session.setAttribute("RegNo2", RegNo2);
			 session.setAttribute("RegNo3", RegNo3);
			 session.setAttribute("RegNo4", RegNo4);
			 session.setAttribute("NomineeNameforPAOwnerDriver", NomineeNameforPAOwnerDriver);
			 session.setAttribute("NomineeAgeforPAOwnerDriver", NomineeAgeforPAOwnerDriver);
			 session.setAttribute("NomineeRelationforPAOwnerDriver", NomineeRelationforPAOwnerDriver);
			 session.setAttribute("VehicleManufactureYear1", VehicleManufactureYear1);
			 
			 
	        try {
				Connection con = Db.myGetConnection();
				String s="insert into details(title, Owner_Name, pno, email, Car_Registration_Address, sqlDate, nomines_name, nomines_relation, selectage, Car_RegNo, engine_number, chassis_number, month1, year1, selectime, driving, evening, financed) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
				PreparedStatement stmt = con.prepareStatement(s);
			
				stmt.setString(1, title);
				stmt.setString(2, Owner_Name);
				stmt.setString(3, pno);
				stmt.setString(4, email);
				stmt.setString(5, Car_Registration_Address);
				stmt.setDate(6, sqlDate);
				stmt.setString(7, nomines_name);
				stmt.setString(8, nomines_relation);
				stmt.setString(9, selectage);
				stmt.setString(10,Car_RegNo);
				stmt.setString(11,engine_number);
				stmt.setString(12,chassis_number );
				stmt.setString(13,month1);
				stmt.setString(14,year1 );
				stmt.setString(15,selectime );
				stmt.setString(16,driving );
				stmt.setString(17,evening );
				 
				stmt.setString(18,financed );
				
				//response.sendRedirect("shri1"); 
				stmt.executeUpdate();
				  
				stmt.close();
				
				
				 
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
	        catch(NullPointerException e1) {
	        	e1.printStackTrace();
	        }
	        catch (Exception s) {
	        	s.printStackTrace();
	        }
			
	}

}
