package com;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import study.db.Db;

/**
 * Servlet implementation class Servlet2
 */
@WebServlet("/Servlet2")
public class Servlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Servlet2() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	
    }
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter pw = response.getWriter();
		HttpSession session=request.getSession();
	       
		String Car_RegNo=(String)session.getAttribute("RegNo");
		System.out.println("Car_RegNo :"+Car_RegNo);
        String Manufacturer=(String) session.getAttribute("Manufacturer");
        String Model=(String)session.getAttribute("Model");
        System.out.println("CarModel :"+Model);
        String FuelType=(String)session.getAttribute("FuelType");
        String Varient=(String)session.getAttribute("Variant");
        String RegYear=(String)session.getAttribute("Regyr");
        String Insurer=(String)session.getAttribute("PreIns");
        String AnyClaim=(String)session.getAttribute("Claim");
        String date=(String)session.getAttribute("ExpiryDate");
     
		String Fullname=request.getParameter("Name");
		session.setAttribute("Fullname", Fullname);
		String Email=request.getParameter("Email");
		session.setAttribute("Email", Email);
		String Mobile=request.getParameter("Mobile");
		session.setAttribute("Mobile", Mobile);
		java.sql.Date ExpiryDate = null;
		
		if(Car_RegNo!=null)
		{ 
			//session.removeAttribute("bike_reg");
			//System.out.println(Bike_RegNo);
			String a=Car_RegNo.substring(0,4);
			String strRTOCode=a.substring(0,2)+"-"+a.substring(2, a.length());
			session.setAttribute("strRTOCode", strRTOCode);
			
			String strInsuredState=Car_RegNo.substring(0,2);
			session.setAttribute("strInsuredState", strInsuredState);
			 main m=new main();
			 
			 //String strVehicleCode=m.car(Model, FuelType);
			 String strVehicleCode=m.ifModel(Model, FuelType);
			 System.out.println(strVehicleCode);
			 
			 String g[]=m.ifRegyr(RegYear,AnyClaim);
			 	String strProductCode=g[0];
		 	   	String strPolicyType=g[1];
		 	   	String strADDONCover=g[2];
		 	   	String strFirstRegDt=g[3];
		 	   	String strPrevPolClaimYN=g[4];
		 	   	String strPrevPolNCB=g[5];
		 	   	
		 	    session.setAttribute("strVehicleCode", strVehicleCode);
		 	  	session.setAttribute("strProductCode", strProductCode);
				session.setAttribute("strPolicyType", strPolicyType);
				session.setAttribute("strADDONCover", strADDONCover);
				session.setAttribute("strPrevPolClaimYN", strPrevPolClaimYN);
				session.setAttribute("strPrevPolNCB", strPrevPolNCB);
				
				//String strPrevPolExpDt=date;
				
				//session.setAttribute("strFirstRegDt", strFirstRegDt);
				
				
				if(RegYear.equals("Brandnew")) {
					Insurer=null;
					date=null;
		        	ExpiryDate=null;
		        	AnyClaim=null;
					String strPrevPolExpDt="";
					strFirstRegDt="";
					String PreviousPolicyToDt="";
					String PreviousPolicyFromDt="";
					String PreviousPolicyUWYear="";
					String VehicleManufactureYear=RegYear;
					String PreviousInsurer="";
					session.setAttribute("PreviousInsurer", PreviousInsurer);
					session.setAttribute("PreviousPolicyToDt", PreviousPolicyToDt);
					session.setAttribute("PreviousPolicyFromDt", PreviousPolicyFromDt);
					session.setAttribute("PreviousPolicyUWYear", PreviousPolicyUWYear);
					session.setAttribute("VehicleManufactureYear", VehicleManufactureYear);
					session.setAttribute("strPrevPolExpDt", strPrevPolExpDt);
					session.setAttribute("strFirstRegDt", strFirstRegDt);
				}
				else {
					String PreviousInsurer=m.insurer(Insurer);
					
					session.setAttribute("PreviousInsurer", PreviousInsurer);
					
				 SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");	
				 SimpleDateFormat format1 = new SimpleDateFormat("dd-MM-yyyy");
				 String OrDate=null;
				 try {
					java.util.Date date1= format.parse(date);
					OrDate=format1.format(date1);
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				 
					java.util.Date utilDate1 = null;
					try {
						utilDate1 = format1.parse(OrDate);
					} catch (ParseException e2) {
						// TODO Auto-generated catch block
						e2.printStackTrace();
					}
					String PreviousPolicyToDt=format1.format(utilDate1);
					 Calendar c = Calendar.getInstance();
					    c.setTime(utilDate1);
					    c.add(Calendar.DAY_OF_MONTH, -364);
					    java.util.Date end=c.getTime();
					    String PreviousPolicyFromDt=format1.format(end);
					    
					    String strPrevPolExpDt=PreviousPolicyToDt;
						 strFirstRegDt=PreviousPolicyFromDt;
						 String PreviousPolicyUWYear=RegYear;
						 String VehicleManufactureYear=RegYear;
						 
						 	session.setAttribute("PreviousPolicyToDt", PreviousPolicyToDt);
							session.setAttribute("PreviousPolicyFromDt", PreviousPolicyFromDt);
							session.setAttribute("PreviousPolicyUWYear", PreviousPolicyUWYear);
							session.setAttribute("VehicleManufactureYear", VehicleManufactureYear);
							session.setAttribute("strPrevPolExpDt", strPrevPolExpDt);
							session.setAttribute("strFirstRegDt", strFirstRegDt);
				}

			if(date!=null) {
				SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		        java.util.Date utilDate = null;

		        try {
					utilDate = format.parse(date);
		        } catch (ParseException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
		         ExpiryDate = new java.sql.Date(utilDate.getTime());
		         System.out.println(ExpiryDate);
			}
		       /* if(RegYear.equals("Brandnew"))
		        {
		        	Insurer=null;
		        	AnyClaim=null;
		        	ExpiryDate=null;
		        }*/
			
        try {
			Connection con = Db.myGetConnection();
			String s="insert into main_data(RegNo,Manufacturer,Model,FuelType,Varient,RegYear,Insurer,AnyClaim,ExpiryDate,name,email,Mobile) values(?,?,?,?,?,?,?,?,?,?,?,?)";
			PreparedStatement stmt = con.prepareStatement(s);
			stmt.setString(1, Car_RegNo);
			stmt.setString(2, Manufacturer);
			stmt.setString(3, Model);
			stmt.setString(4, FuelType);
			stmt.setString(5, Varient);
			stmt.setString(6, RegYear);
			stmt.setString(7, Insurer);
			stmt.setString(8, AnyClaim);
			stmt.setDate(9, ExpiryDate);
			stmt.setString(10, Fullname);
			stmt.setString(11, Email);
			stmt.setString(12, Mobile);
			
			stmt.executeUpdate();
			stmt.close();
			
			String s1="insert into reg(Name,Email,Mobile) values(?,?,?)";
			PreparedStatement statement = con.prepareStatement(s1);
			statement.setString(1, Fullname);
			statement.setString(2, Email);
			statement.setString(3, Mobile);
			
			response.sendRedirect("shri");
			statement.executeUpdate();
			statement.close();
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        catch(NullPointerException e) {
        	e.printStackTrace();
        }
        catch (Exception s) {
        	s.printStackTrace();
        }
		}
		
		 	String Bike_RegNo=(String)session.getAttribute("bike_reg");
	        System.out.println("Bike_RegNo :"+Bike_RegNo);
	        String Bike_Manufacturer=(String) session.getAttribute("manufacturer2");
	        String Bike_Model=(String)session.getAttribute("bk1");
	        System.out.println("Bike_Model :"+Bike_Model);
	        String Variant=(String)session.getAttribute("bk2");
	        String Bike_RegYear=(String)session.getAttribute("bk3");
	        String Bike_Insurer=(String)session.getAttribute("bk4");
	        String Bike_Claim=(String)session.getAttribute("Bike_Claim");
	        String BikeExpiryDate=(String)session.getAttribute("BikeExpiryDate");
		if(Bike_RegNo!=null)
		{
			//session.removeAttribute("RegNo");
			String a=Bike_RegNo.substring(0,4);
			String strRTOCode=a.substring(0,2)+"-"+a.substring(2, a.length());
			
			session.setAttribute("strRTOCode", strRTOCode);
			String strInsuredState=Bike_RegNo.substring(0,2);
			session.setAttribute("strInsuredState", strInsuredState);
			
			 main m=new main();
			 String strVehicleCode=m.ifByke(Bike_Model);
			 //String strVehicleCode=m.byke(Bike_Model);
			 System.out.println(strVehicleCode);
			 String g[]=m.ifBykeRegyr(Bike_RegYear,Bike_Claim);
			 String strProductCode=g[0];
		 	   	String strPolicyType=g[1];
		 	   	String strADDONCover=g[2];
		 	   	String strFirstRegDt=g[3];
		 	   	String strPrevPolClaimYN=g[4];
		 	   	String strPrevPolNCB=g[5];
		 	   	
		 	    session.setAttribute("strVehicleCode", strVehicleCode);
		 	  	session.setAttribute("strProductCode", strProductCode);
				session.setAttribute("strPolicyType", strPolicyType);
				session.setAttribute("strADDONCover", strADDONCover);
				session.setAttribute("strPrevPolClaimYN", strPrevPolClaimYN);
				session.setAttribute("strPrevPolNCB", strPrevPolNCB);
			
			if(Bike_RegYear.equals("Brandnew"))
	        {
	        	Bike_Insurer=null;
	        	BikeExpiryDate=null;
	        	Bike_Claim=null;
	        	String strPrevPolExpDt="";
				strFirstRegDt="";
				String PreviousPolicyToDt="";
				String PreviousPolicyFromDt="";
				String PreviousPolicyUWYear="";
				String VehicleManufactureYear=Bike_RegYear;
				String PreviousInsurer="";
				session.setAttribute("PreviousInsurer", PreviousInsurer);
				session.setAttribute("PreviousPolicyToDt", PreviousPolicyToDt);
				session.setAttribute("PreviousPolicyFromDt", PreviousPolicyFromDt);
				session.setAttribute("PreviousPolicyUWYear", PreviousPolicyUWYear);
				session.setAttribute("VehicleManufactureYear", VehicleManufactureYear);
				session.setAttribute("strPrevPolExpDt", strPrevPolExpDt);
				session.setAttribute("strFirstRegDt", strFirstRegDt);
	        }
			else {
				String PreviousInsurer=m.insurer(Bike_Insurer);
				
				session.setAttribute("PreviousInsurer", PreviousInsurer);
				
				SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");	
				 SimpleDateFormat format1 = new SimpleDateFormat("dd-MM-yyyy");
				 String OrDate=null;
				 try {
					java.util.Date date1= format.parse(BikeExpiryDate);
					OrDate=format1.format(date1);
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				 
					java.util.Date utilDate1 = null;
					try {
						utilDate1 = format1.parse(OrDate);
					} catch (ParseException e2) {
						// TODO Auto-generated catch block
						e2.printStackTrace();
					}
					String PreviousPolicyToDt=format1.format(utilDate1);
					 Calendar c = Calendar.getInstance();
					    c.setTime(utilDate1);
					    c.add(Calendar.DAY_OF_MONTH, -364);
					    java.util.Date end=c.getTime();
					    String PreviousPolicyFromDt=format1.format(end);
					    
					    String strPrevPolExpDt=PreviousPolicyToDt;
						 strFirstRegDt=PreviousPolicyFromDt;
						 String PreviousPolicyUWYear=Bike_RegYear;
						 String VehicleManufactureYear=Bike_RegYear;
						 
						 	session.setAttribute("PreviousPolicyToDt", PreviousPolicyToDt);
							session.setAttribute("PreviousPolicyFromDt", PreviousPolicyFromDt);
							session.setAttribute("PreviousPolicyUWYear", PreviousPolicyUWYear);
							session.setAttribute("VehicleManufactureYear", VehicleManufactureYear);
							session.setAttribute("strPrevPolExpDt", strPrevPolExpDt);
							session.setAttribute("strFirstRegDt", strFirstRegDt);
			}
			if(BikeExpiryDate!=null) {
				SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		        java.util.Date utilDate = null;

		        try {
					utilDate = format.parse(BikeExpiryDate);
		        } catch (ParseException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
		         ExpiryDate = new java.sql.Date(utilDate.getTime());
			}
			System.out.println(Bike_RegNo);
			System.out.println(Bike_Manufacturer);
			System.out.println(Bike_Model);
			System.out.println(Variant);
			System.out.println(Bike_RegYear);
			System.out.println(Bike_Insurer);
			System.out.println(Bike_Claim);
			System.out.println(ExpiryDate);
			System.out.println(Fullname);
			System.out.println(Email);
			System.out.println(Mobile);
			
			try {
				Connection con = Db.myGetConnection();
				String s2="insert into main_data(RegNo,Manufacturer,Model,Varient,RegYear,Insurer,AnyClaim,ExpiryDate,name,email,Mobile) values(?,?,?,?,?,?,?,?,?,?,?)";
				PreparedStatement stmt2 = con.prepareStatement(s2);
				stmt2.setString(1, Bike_RegNo);
				stmt2.setString(2, Bike_Manufacturer);
				stmt2.setString(3, Bike_Model);
				stmt2.setString(4, Variant);
				stmt2.setString(5, Bike_RegYear);
				stmt2.setString(6, Bike_Insurer);
				stmt2.setString(7, Bike_Claim);
				stmt2.setDate(8, ExpiryDate);
				stmt2.setString(9, Fullname);
				stmt2.setString(10, Email);
				stmt2.setString(11, Mobile);
				stmt2.executeUpdate();
				stmt2.close();
				
				String s1="insert into reg(Name,Email,Mobile) values(?,?,?)";
				PreparedStatement statement = con.prepareStatement(s1);
				statement.setString(1, Fullname);
				statement.setString(2, Email);
				statement.setString(3, Mobile);
				
				response.sendRedirect("shri");
				statement.executeUpdate();
				statement.close();
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	        
	        catch (Exception s) {
	        	s.printStackTrace();
	        }
		}
		if(session!=null) {
			
			session.removeAttribute("bike_reg");
			session.removeAttribute("manufacturer2");
			session.removeAttribute("bk1");
			session.removeAttribute("bk2");
			session.removeAttribute("bk3");
			session.removeAttribute("bk4");
			session.removeAttribute("Bike_Claim");
			session.removeAttribute("BikeExpiryDate");
			
			session.removeAttribute("RegNo");
			session.removeAttribute("Manufacturer");
			session.removeAttribute("Model");
			session.removeAttribute("FuelType");
			session.removeAttribute("Variant");
			session.removeAttribute("Regyr");
			session.removeAttribute("Claim");
			session.removeAttribute("ExpiryDate");
			}
		
	}

	}

