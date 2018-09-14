package com;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringReader;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.soap.MessageFactory;
import javax.xml.soap.SOAPElement;
import javax.xml.soap.SOAPException;
import javax.xml.soap.SOAPMessage;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import com.User;
/**
 * Servlet implementation class shri
 */
@WebServlet("/shri")
public class shri extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public shri() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");  
        PrintWriter pw = response.getWriter();  
		
		 HttpSession session=request.getSession();		
		 String strRTOCode = (String) session.getAttribute("strRTOCode");
		 String strVehicleCode = (String) session.getAttribute("strVehicleCode");
		 String strProductCode = (String) session.getAttribute("strProductCode");
		 String strPolicyType = (String) session.getAttribute("strPolicyType");
		 String strADDONCover = (String) session.getAttribute("strADDONCover");
		 String strPrevPolClaimYN = (String) session.getAttribute("strPrevPolClaimYN");
		 String strPrevPolNCB = (String) session.getAttribute("strPrevPolNCB");
		 String strPrevPolExpDt = (String) session.getAttribute("strPrevPolExpDt");
		 String strFirstRegDt = (String) session.getAttribute("strFirstRegDt");
		 String strInsuredState= (String) session.getAttribute("strInsuredState");
		 
		 User user=new User();
			user.setStrProductCode(strProductCode);
			user.setStrPolicyType(strPolicyType);
			user.setStrRTOCode(strRTOCode);
			user.setStrVehicleCode(strVehicleCode);
			user.setStrADDONCover(strADDONCover);
			if(strPrevPolExpDt.equals("")) {
				user.setStrFirstRegDt("");
				user.setStrPrevPolExpDt("");
			}
			else {
				user.setStrFirstRegDt(strFirstRegDt);
				user.setStrPrevPolExpDt(strPrevPolExpDt);
			}
			
			user.setStrInsuredState(strInsuredState);
			user.setStrPrevPolClaimYN(strPrevPolClaimYN);
			user.setStrPrevPolNCB(strPrevPolNCB);
			
			pw.println(user.getStrProductCode());
			pw.println(user.getStrPolicyType());
			pw.println(user.getStrRTOCode());
			pw.println(user.getStrVehicleCode());
			pw.println(user.getStrADDONCover());
			pw.println(user.getStrFirstRegDt());
			pw.println(user.getStrInsuredState());
			pw.println(user.getStrPrevPolExpDt());
			pw.println(user.getStrPrevPolClaimYN());
			pw.println(user.getStrPrevPolNCB());
			
			Document document;
			try {
				document = DocumentBuilderFactory.newInstance().newDocumentBuilder().newDocument();
				Marshaller marshaller = JAXBContext.newInstance(User.class).createMarshaller();
				marshaller.marshal(user, document);
				SOAPMessage soapMessage = MessageFactory.newInstance().createMessage();
				soapMessage.getSOAPPart().getEnvelope().removeNamespaceDeclaration("SOAP-ENV");
				String myNamespace = "tem";
			    String myNamespaceURI = "http://tempuri.org/";
				
			    soapMessage.getSOAPPart().getEnvelope().addNamespaceDeclaration(myNamespace, myNamespaceURI);
			    
			    SOAPElement AuthHeader=soapMessage.getSOAPHeader().addChildElement("AuthHeader",myNamespace);
				SOAPElement Username=AuthHeader.addChildElement("Username",myNamespace);
				Username.addTextNode("POLICYMASTER");
				SOAPElement Password=AuthHeader.addChildElement("Password",myNamespace);
				Password.addTextNode("PM@123"); 
			    
				soapMessage.getSOAPPart().getEnvelope().setPrefix("soapenv");
				soapMessage.getSOAPHeader().setPrefix("soapenv");		
			    soapMessage.getSOAPBody().setPrefix("soapenv"); 
				soapMessage.getSOAPBody().addDocument(document);
				ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
				soapMessage.writeTo(outputStream);
				
				HttpClient client = HttpClientBuilder.create().build();
				String output = new String(outputStream.toByteArray());
				HttpPost post = new HttpPost("http://119.226.131.2/ShriramService/ShriramService.asmx");
				StringEntity userEntity = new StringEntity(output);
				post.setEntity(userEntity);
				post.setHeader("Accept-Encoding", "gzip,deflate");
				post.setHeader("Content-Type", "text/xml; charset=UTF-8");
				//post.setHeader("Content-Type", "application/soap+xml; charset=UTF-8;action=http://tempuri.org/GetQuot");
				post.setHeader("SOAPAction", "http://tempuri.org/GetQuot");
				 HttpResponse response1=client.execute(post);
				 String res_xml = EntityUtils.toString(response1.getEntity());
				 pw.println("\n");
				 pw.println(output);
				 pw.println("\n");
				 pw.println(res_xml);
				 Document document1 = parseXmlFile(res_xml);
				 NodeList nodeLst = document1.getElementsByTagName("POL_SYS_ID");
				 NodeList nodeLst1=document1.getElementsByTagName("PROPOSAL_NO");
				 NodeList nodeLst2=document1.getElementsByTagName("VehicleIDV");
				 NodeList nodeLst3=document1.getElementsByTagName("ERROR_CODE");
				 NodeList nodeLst4=document1.getElementsByTagName("ERROR_DESC");
				 NodeList nodeLst5=document1.getElementsByTagName("CoverDtlList");
				 String ec = nodeLst.item(0).getTextContent();
				 String ec1= nodeLst1.item(0).getTextContent();
				 String ec2= nodeLst2.item(0).getTextContent();
				 String ec3= nodeLst3.item(0).getTextContent();
				 String ec4= nodeLst4.item(0).getTextContent();
				/* pw.println(ec);
				 pw.println(ec1);
				 pw.println(ec2);
				 pw.println(ec3);
				 pw.println(ec4);*/
				 session.setAttribute("ec", ec);
				 session.setAttribute("ec1", ec1);
				 session.setAttribute("ec2", ec2);
				 session.setAttribute("ec3", ec3);
				 session.setAttribute("ec4", ec4);
				 if(nodeLst5 != null) {
					 int length = nodeLst5.getLength();
				        for (int i = 0; i < length; i++) {
				        	 if (nodeLst5.item(i).getNodeType() == Node.ELEMENT_NODE) {
				        		 Element el = (Element) nodeLst5.item(i);
				        		 if ( el.getNodeName().contains("CoverDtl")) {
				        			 String CoverDesc = el.getElementsByTagName("CoverDesc").item(1).getTextContent();
				                     String Premium = el.getElementsByTagName("Premium").item(1).getTextContent();
				                     session.setAttribute("CoverDesc", CoverDesc);
				                     session.setAttribute("Premium", Premium);
				                     String CoverDesc1 = el.getElementsByTagName("CoverDesc").item(5).getTextContent();
				                     String Premium1 = el.getElementsByTagName("Premium").item(5).getTextContent();
				                     session.setAttribute("CoverDesc1", CoverDesc1);
				                     session.setAttribute("Premium1", Premium1);
				        		 }
				        	 }
				        }
				 }
				
			
			 response.sendRedirect("termquotes");			 
				pw.close(); 

			} catch (ParserConfigurationException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (JAXBException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SOAPException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (NullPointerException e) {
				e.printStackTrace();
			}
			if(session!=null) {
				session.removeAttribute("strRTOCode");
				session.removeAttribute("strPrevPolNCB");
				session.removeAttribute("strPrevPolExpDt");
				session.removeAttribute("strFirstRegDt");
				session.removeAttribute("strInsuredState");
			}
			
	}
	private static Document parseXmlFile(String in) {
		try {
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		DocumentBuilder db = dbf.newDocumentBuilder();
		InputSource is = new InputSource(new StringReader(in));
		return db.parse(is);
		} catch (ParserConfigurationException e) {
		throw new RuntimeException(e);
		} catch (SAXException e) {
		throw new RuntimeException(e);
		} catch (IOException e) {
		throw new RuntimeException(e);
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
