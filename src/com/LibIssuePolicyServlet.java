package com;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;
import org.w3c.dom.Document;

import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * Servlet implementation class LibIssuePolicyServlet
 */
@WebServlet("/LibIssuePolicyServlet")
public class LibIssuePolicyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LibIssuePolicyServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter pw = response.getWriter(); 
		
		 HttpSession session=request.getSession();
		 HttpClient client = HttpClientBuilder.create().build();
		 
		 String GCCustomerID = (String) session.getAttribute("CustomerID");
		 //String IMDNumber = (String) session.getAttribute("IMDNumber");
		 String IMDNumber="IMD1010030";
		 Double PremiumAmount = (Double) session.getAttribute("TotalPremium");
		 String QuotationNumber = (String) session.getAttribute("QuotationNumber");
		 String TransactionID = (String) session.getAttribute("tnx");
		 String TPEmailID = (String) session.getAttribute("EmailID");
		 String PaymentDate = (String) session.getAttribute("PaymentDate");
		 
		 
		 
		 LibSuccessPayPojo sp = new LibSuccessPayPojo();
		 
		 sp.setGCCustomerID(GCCustomerID);
		 sp.setIMDNumber(IMDNumber);
		 sp.setOfficeCode("110034");
		 sp.setPremiumAmount(PremiumAmount);
		 sp.setProductCode("3152");
		 sp.setQuotationNumber(QuotationNumber);
		 sp.setPaymentSource("LGI-PAYU");
		 sp.setPaymentDate(PaymentDate);
		sp.setTransactionID(TransactionID);
		sp.setTPEmailID("rajmaurya490gmail.com");
		sp.setSendEmailtoCustomer(true);
		sp.setTPSourceName("TPService");
		sp.setOTP("");
		sp.setOTPCreatedDate("");
		sp.setOTPEnteredDate("");
		
		try {
			
			ObjectMapper objectMapper = new ObjectMapper();
			String jsonRequest=objectMapper.writeValueAsString(sp);
			System.out.println("Request :  "+jsonRequest);
			
			HttpPost pos = new HttpPost("http://168.87.83.122:8180/api/IMDTPService/GetPolicy");
			StringEntity userEntity = new StringEntity(jsonRequest);
			pos.setEntity(userEntity);
			pos.setHeader("Content-Type", "application/json");
			HttpResponse res=client.execute(pos);

			String res_json = EntityUtils.toString(res.getEntity());
			System.out.println("\nResponse : "+res_json);
			
			JSONObject obj = new JSONObject(res_json);
			System.out.println("Get Policy Response coming....");
			System.out.println(obj.get("PolicyNumber"));
			
			if(obj.get("PolicyNumber").toString().equals(null) && obj.get("ErrorText").toString().equals(null))
			{
				String Message=(String) obj.get("Message");
				String PolicyNumber=(String) obj.get("PolicyNumber");
				Double PolicyID=(Double) obj.get("PolicyID");
				
				session.setAttribute("Message", Message);
				session.setAttribute("PolicyNumber", PolicyNumber);
				session.setAttribute("PolicyID", PolicyID);
				
				System.out.println(Message);
				System.out.println(PolicyNumber);
				System.out.println(PolicyID);
				
				response.sendRedirect("abc.jsp");
			}
			else
			{
			/*
				String ErrorText=(String) obj.get("ErrorText");
				session.setAttribute("ErrorText", ErrorText);
				System.out.println(ErrorText);*/
				response.sendRedirect("abc3.jsp");
				
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
}
