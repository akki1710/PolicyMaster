package com;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Servlet1
 */
@WebServlet("/Servlet1")
public class Servlet1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Servlet1() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		PrintWriter pw=response.getWriter();
		
		String RegNo=request.getParameter("RegNo");
		String Manufacturer=request.getParameter("Manufacturer");
		String Model=request.getParameter("b1");
		String FuelType=request.getParameter("FuelType");
		String Variant=request.getParameter("Variant");
		String Regyr=request.getParameter("Regyr");
		String PreIns=request.getParameter("PreIns");
		String Claim=request.getParameter("Claim");
		String ExpiryDate = request.getParameter("ExpiryDate");
		
		String bike_reg=request.getParameter("bike_reg");
		String manufacturer2=request.getParameter("manufacturer2");
		String bk1=request.getParameter("bk1");
		String bk2=request.getParameter("bk2");
		String bk3=request.getParameter("bk3");
		String bk4=request.getParameter("bk4");
		String Bike_Claim=request.getParameter("Bike_Claim");
		String BikeExpiryDate=request.getParameter("BikeExpiryDate");

		
			HttpSession session=request.getSession();
			
// Car servlet starts here			
			if(RegNo!=null)
			{
				System.out.println("CarRegNo: "+RegNo);
            session.setAttribute("RegNo", RegNo);
            
            response.sendRedirect("car_page1.jsp");
			}
			if(Manufacturer!=null)
			{
            session.setAttribute("Manufacturer", Manufacturer);
            
            if(Manufacturer.equals("maruti"))
            {
            response.sendRedirect("car_page2.jsp");
            }
            else if(Manufacturer.equals("hyundai"))
            {
            response.sendRedirect("car_hyundai_model.jsp");
            }
            else if(Manufacturer.equals("honda"))
            {
            response.sendRedirect("car_honda_model.jsp");
            }
            else if(Manufacturer.equals("chevrolet"))
            {
            response.sendRedirect("car_chevrolet_model.jsp");
            }
            else if(Manufacturer.equals("fiat"))
            {
            response.sendRedirect("car_fiat_model.jsp");
            }
            else if(Manufacturer.equals("ford"))
            {
            response.sendRedirect("car_ford_model.jsp");
            }
            else if(Manufacturer.equals("renault"))
            {
            response.sendRedirect("car_renault_model.jsp");
            }
            else if(Manufacturer.equals("skoda"))
            {
            response.sendRedirect("car_skoda_model.jsp");
            }
            else if(Manufacturer.equals("toyota"))
            {
            response.sendRedirect("car_toyota_model.jsp");
            }
            else if(Manufacturer.equals("volkswagen"))
            {
            response.sendRedirect("car_volkswagen_model.jsp");
            }
            else if(Manufacturer.equals("tata"))
            {
            response.sendRedirect("car_tata_model.jsp");
            }
            else if(Manufacturer.equals("mahindra"))
            {
            response.sendRedirect("car_mahindra_model.jsp");
            }
			}
			if (Model!=null)
			{
				System.out.println("CarMOdel"+Model);
				session.setAttribute("Model", Model);
	            
	            response.sendRedirect("car_page3.jsp");
			}
			if (FuelType!=null)
			{
				session.setAttribute("FuelType", FuelType);
	            
	            response.sendRedirect("car_page4.jsp");
			}
			if (Variant!=null)
			{
				session.setAttribute("Variant", Variant);
	            
	            response.sendRedirect("car_page5.jsp");
			}
			if (Regyr!=null)
			{
				if(Regyr.equals("Brandnew"))
				{
					session.setAttribute("Regyr", Regyr);
		            
		            response.sendRedirect("car_page9.jsp");
				}
				else
				{
					session.setAttribute("Regyr", Regyr);
		            
		            response.sendRedirect("car_page6.jsp");
				}
				
			}
			if (PreIns!=null)
			{
				session.setAttribute("PreIns", PreIns);
	            
	            response.sendRedirect("car_page7.jsp");
			}
			if (Claim!=null)
			{
				session.setAttribute("Claim", Claim);
	            
	            response.sendRedirect("car_page8.jsp");
			}
			if (ExpiryDate!=null)
			{
				
				session.setAttribute("ExpiryDate", ExpiryDate);
	            
	            response.sendRedirect("car_page9.jsp");
			}
			
// Car servlet Ends here
			
			//Bike servlet starts here
			
			if(bike_reg!=null)
			{
				System.out.println("BikeReg"+bike_reg);
            session.setAttribute("bike_reg", bike_reg);
            
            response.sendRedirect("bike_page1.jsp");
			}
			if(manufacturer2!=null)
			{
            session.setAttribute("manufacturer2", manufacturer2);
            
            if(manufacturer2.equals("honda"))
            {
            response.sendRedirect("bike_page2.jsp");
            }
            else if(manufacturer2.equals("bajaj"))
            {
            response.sendRedirect("bike_bajaj_model.jsp");
            }
            else if(manufacturer2.equals("herohonda"))
            {
            response.sendRedirect("bike_herohonda_model.jsp");
            }
            else if(manufacturer2.equals("tvs"))
            {
            response.sendRedirect("bike_tvs_model.jsp");
            }
            else if(manufacturer2.equals("yamaha"))
            {
            response.sendRedirect("bike_yamaha_model.jsp");
            }
            else if(manufacturer2.equals("hero"))
            {
            response.sendRedirect("bike_heromoto_model.jsp");
            }
            else if(manufacturer2.equals("royalenfield"))
            {
            response.sendRedirect("bike_royalenfield_model.jsp");
            }
            else if(manufacturer2.equals("suzuki"))
            {
            response.sendRedirect("bike_suzuki_model.jsp");
            }
            else if(manufacturer2.equals("mahindra"))
            {
            response.sendRedirect("bike_mahindra_model.jsp");
            }
            else if(manufacturer2.equals("ktm"))
            {
            response.sendRedirect("bike_ktm_model.jsp");
            }
            else if(manufacturer2.equals("lml"))
            {
            response.sendRedirect("bike_lml_model.jsp");
            }
            else if(manufacturer2.equals("harleydevidson"))
            {
            response.sendRedirect("bike_harleydev_model.jsp");
            }
			}
			if (bk1!=null)
			{
				System.out.println("BikeModel"+bk1);
				session.setAttribute("bk1", bk1);
	            
	            response.sendRedirect("bike_page3.jsp");
			}
			if (bk2!=null)
			{
				session.setAttribute("bk2", bk2);
	            
	            response.sendRedirect("bike_page4.jsp");
			}
			if (bk3!=null)
			{
				if(bk3.equals("Brandnew"))
				{
					session.setAttribute("bk3", bk3);
		            
					 response.sendRedirect("bike_page7.jsp");
				}
				else
				{
					session.setAttribute("bk3", bk3);
		            
		            response.sendRedirect("bike_page5.jsp");
				}
				
			}
			if (bk4!=null)
			{
				session.setAttribute("bk4", bk4);
	            
	            response.sendRedirect("bike_page8.jsp");
			}
			if (Bike_Claim!=null) {
				System.out.println(Bike_Claim);
				session.setAttribute("Bike_Claim", Bike_Claim);
				
				response.sendRedirect("bike_page9.jsp");
			}
			if (BikeExpiryDate!=null) {
				System.out.println(BikeExpiryDate);
				session.setAttribute("BikeExpiryDate", BikeExpiryDate);
				
				response.sendRedirect("bike_page7.jsp");
			}
			
	}

}