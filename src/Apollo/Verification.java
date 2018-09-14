package Apollo;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringReader;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.soap.MessageFactory;
import javax.xml.soap.SOAPException;
import javax.xml.soap.SOAPMessage;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.w3c.dom.Document;
import org.xml.sax.InputSource;

/**
 * Servlet implementation class Verification
 */
@WebServlet("/Verification")
public class Verification extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Verification() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		PrintWriter pw = response.getWriter();
		
		Partner part = new Partner();
    	part.setPartnerCode("13961");
    	part.setPassword("master123");
    	part.setUserName("policymaster");
    	
    	
    	TransactionVerificationRequest transactionrequest = new TransactionVerificationRequest();
    	transactionrequest.setPartner(part);
    	transactionrequest.setPaymentId("10829220");
    	transactionrequest.setTransactionId("B115845518");
    	
    	
    	VerifyTransaction verifytransac = new VerifyTransaction();
    	verifytransac.setTransactionVerificationRequest(transactionrequest);
    	
    	 Document document;
         try {
        	 document = DocumentBuilderFactory.newInstance().newDocumentBuilder().newDocument();
				
        	 document = DocumentBuilderFactory.newInstance().newDocumentBuilder().newDocument();
				Marshaller marshaller = JAXBContext.newInstance(VerifyTransaction.class).createMarshaller();
				marshaller.marshal(verifytransac, document);
             
             SOAPMessage soapMessage = MessageFactory.newInstance().createMessage();
             
                soapMessage.getSOAPPart().getEnvelope().removeNamespaceDeclaration("SOAP-ENV");
                
                String myNamespace = "b2b";
			    String myNamespaceURI = "http://www.apollomunichinsurance.com/B2BService";
			    
			    String myNamespace1 = "tran";
			    String myNamespaceURI1 = "http://schemas.datacontract.org/2004/07/TransactionVerificationLibrary";
			    
			    String myNamespace2 = "ser";
			    String myNamespaceURI2 = "http://schemas.datacontract.org/2004/07/ServiceObjects";
			    
			    soapMessage.getSOAPPart().getEnvelope().addNamespaceDeclaration(myNamespace, myNamespaceURI);
			    soapMessage.getSOAPPart().getEnvelope().addNamespaceDeclaration(myNamespace1, myNamespaceURI1);
			    soapMessage.getSOAPPart().getEnvelope().addNamespaceDeclaration(myNamespace2, myNamespaceURI2);
			    
                soapMessage.getSOAPPart().getEnvelope().setPrefix("soapenv");
                soapMessage.getSOAPHeader().setPrefix("soapenv"); 
			    soapMessage.getSOAPBody().setPrefix("soapenv"); 
				soapMessage.getSOAPBody().addDocument(document);
				ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
				soapMessage.writeTo(outputStream);
             HttpClient client1 = HttpClientBuilder.create().build();
             HttpPost post = new HttpPost("http://b2buat.apollomunichinsurance.com/TransactionVerificationHttpService.svc");
             String output = new String(outputStream.toByteArray());
             StringEntity userEntity = new StringEntity(output);
              post.setEntity(userEntity);
              post.setHeader("Accept-Encoding", "gzip,deflate");
              post.setHeader("Content-Type", "text/xml; charset=UTF-8");
              post.setHeader("SOAPAction", "http://www.apollomunichinsurance.com/B2BService/ITransactionVerificationService/VerifyTransaction");
              HttpResponse response1=client1.execute(post);
              String res_xml = EntityUtils.toString(response1.getEntity());
              InputSource is = new InputSource(new StringReader(res_xml));
              System.out.println(output);
              System.out.println("\n");
     		 //System.out.println(response1);
      		 System.out.println(res_xml);
         }
         
      		catch (ParserConfigurationException e) {
     			e.printStackTrace();
     		} catch (JAXBException e) {
     			e.printStackTrace();
     		} catch (SOAPException e) {
     			e.printStackTrace();
     	
     		}
         		finally
         		{
         			
         		}
         		
     	 
    	
    	
    	
    	
    	
    	
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
