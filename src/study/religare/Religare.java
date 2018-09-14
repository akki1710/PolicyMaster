package study.religare;

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
import javax.xml.soap.SOAPException;
import javax.xml.soap.SOAPMessage;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import com.apollo_proposal_pojo;
import com.main;

import Apollo.apollo;
/**
 * Servlet implementation class Religare
 */
@WebServlet("/Religare")
public class Religare extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Religare() {
        super();
        
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		  PrintWriter pw = response.getWriter();  
			
			 HttpSession session=request.getSession();		
			 apollo_proposal_pojo ap = (apollo_proposal_pojo) session.getAttribute("ap");
			 String cityCd=ap.getCity();
			 String name=ap.getFullname();
			 String emailAddress=ap.getEmail();
			 String contactNum=ap.getMobile();
			 String birthDt=ap.getDob();
			 String title=ap.getSalutation();
			 
			 String firstName=null;
			 String lastName=null;
			 
			 
			 		if(name!=null) {
					String word[]=name.split("\\s");
			        
			        firstName=word[0];
			        lastName=word[1];
			        }
			 
			 	main m=new main();
		        String prefix[]=m.TitleReligare(title);
		        String titleCd=prefix[0];
		        String genderCd=prefix[1];
			 
			 System.out.println("cityCd: "+cityCd);
			 System.out.println("firstName: "+firstName);
			 System.out.println("lastName: "+lastName);
			 System.out.println("emailAddress: "+emailAddress);
			 System.out.println("contactNum: "+contactNum);
			 System.out.println("titleCd: "+titleCd);
			 System.out.println("genderCd: "+genderCd);
			 System.out.println("birthDt: "+birthDt);
			 
			 partyAddressDOList partyAddressDOList=new partyAddressDOList();
				partyAddressDOList.setAddressLine1Lang1(cityCd);
				partyAddressDOList.setAddressLine2Lang1("");
				partyAddressDOList.setAddressTypeCd("PERMANENT");
				partyAddressDOList.setAreaCd("");
				partyAddressDOList.setCityCd(cityCd);
				partyAddressDOList.setPinCode("110056");
				partyAddressDOList.setStateCd("");
				
				partyAddressDOList partyAddressDOList1=new partyAddressDOList();
				partyAddressDOList1.setAddressLine1Lang1(cityCd);
				partyAddressDOList1.setAddressLine2Lang1("");
				partyAddressDOList1.setAddressTypeCd("COMMUNICATION");
				partyAddressDOList1.setAreaCd("");
				partyAddressDOList1.setCityCd(cityCd);
				partyAddressDOList1.setPinCode("110056");
				partyAddressDOList1.setStateCd("");
				
				partyContactDOList partyContactDOList=new partyContactDOList();
				partyContactDOList.setContactNum(contactNum);
				partyContactDOList.setContactTypeCd("MOBILE");
				partyContactDOList.setStdCode("");
				
				partyEmailDOList partyEmailDOList=new partyEmailDOList();
				partyEmailDOList.setEmailAddress(emailAddress);
				partyEmailDOList.setEmailTypeCd("PERSONAL");
				
				partyIdentityDOList partyIdentityDOList=new partyIdentityDOList();
				partyIdentityDOList.setIdentityNum("");
				partyIdentityDOList.setIdentityTypeCd("");
				
				partyQuestionDOList partyQuestionDOList=new partyQuestionDOList();
				partyQuestionDOList.setQuestionCd("");
				partyQuestionDOList.setQuestionSetCd("");
				partyQuestionDOList.setResponse("");
				
				partyDOList partyDOList=new partyDOList();
				partyDOList.setBirthDt(birthDt);
				partyDOList.setFirstName(firstName);
				partyDOList.setGenderCd(genderCd);
				partyDOList.setGuid("0");
				partyDOList.setLastName(lastName);
				partyDOList.getpartyAddressDOList().add(partyAddressDOList);
				partyDOList.getpartyAddressDOList().add(partyAddressDOList1);
				//partyDOList.setPartyAddressDOList(partyAddressDOList);
				partyDOList.setPartyContactDOList(partyContactDOList);
				partyDOList.setPartyEmailDOList(partyEmailDOList);
				partyDOList.setPartyIdentityDOList(partyIdentityDOList);
				partyDOList.setPartyQuestionDOList(partyQuestionDOList);
				partyDOList.setRelationCd("SELF");
				partyDOList.setRoleCd("PROPOSER");
				partyDOList.setTitleCd(titleCd);
				
				partyAddressDOList partyAddressDOList2=new partyAddressDOList();
				partyAddressDOList2.setAddressLine1Lang1(cityCd);
				partyAddressDOList2.setAddressLine2Lang1("");
				partyAddressDOList2.setAddressTypeCd("PERMANENT");
				partyAddressDOList2.setAreaCd("");
				partyAddressDOList2.setCityCd(cityCd);
				partyAddressDOList2.setPinCode("110056");
				partyAddressDOList2.setStateCd("");
				
				partyAddressDOList partyAddressDOList3=new partyAddressDOList();
				partyAddressDOList3.setAddressLine1Lang1(cityCd);
				partyAddressDOList3.setAddressLine2Lang1("");
				partyAddressDOList3.setAddressTypeCd("COMMUNICATION");
				partyAddressDOList3.setAreaCd("");
				partyAddressDOList3.setCityCd(cityCd);
				partyAddressDOList3.setPinCode("110056");
				partyAddressDOList3.setStateCd("");
				
				partyContactDOList partyContactDOList1=new partyContactDOList();
				partyContactDOList1.setContactNum(contactNum);
				partyContactDOList1.setContactTypeCd("MOBILE");
				partyContactDOList1.setStdCode("");
				
				partyEmailDOList partyEmailDOList1=new partyEmailDOList();
				partyEmailDOList1.setEmailAddress(emailAddress);
				partyEmailDOList1.setEmailTypeCd("PERSONAL");
				
				partyIdentityDOList partyIdentityDOList1=new partyIdentityDOList();
				partyIdentityDOList1.setIdentityNum("");
				partyIdentityDOList1.setIdentityTypeCd("");
				
				partyQuestionDOList partyQuestionDOList1=new partyQuestionDOList();
				partyQuestionDOList1.setQuestionCd("H101");
				partyQuestionDOList1.setQuestionSetCd("HEDCFLEAFONE");
				partyQuestionDOList1.setResponse("NO");
				
				partyDOList partyDOList1=new partyDOList();
				partyDOList1.setBirthDt(birthDt);
				partyDOList1.setFirstName(firstName);
				partyDOList1.setGenderCd(genderCd);
				partyDOList1.setGuid("1");
				partyDOList1.setLastName("cvgfg");
				partyDOList1.getpartyAddressDOList().add(partyAddressDOList2);
				partyDOList1.getpartyAddressDOList().add(partyAddressDOList3);
				//partyDOList.setPartyAddressDOList(partyAddressDOList);
				partyDOList1.setPartyContactDOList(partyContactDOList1);
				partyDOList1.setPartyEmailDOList(partyEmailDOList1);
				partyDOList1.setPartyIdentityDOList(partyIdentityDOList1);
				partyDOList1.setPartyQuestionDOList(partyQuestionDOList1);
				partyDOList1.setRelationCd("BOTH");
				partyDOList1.setRoleCd("PRIMARY");
				partyDOList1.setTitleCd(titleCd);
				
				policyAdditionalFieldsDOList policyAdditionalFieldsDOList=new policyAdditionalFieldsDOList();
				policyAdditionalFieldsDOList.setFieldAgree("YES");
				policyAdditionalFieldsDOList.setFieldAlerts("YES");
				policyAdditionalFieldsDOList.setFieldTc("YES");
				
				policy policy=new policy();
				policy.setAddOns("CAREWITHNCB");
				policy.setBusinessTypeCd("NEWBUSINESS");
				policy.setBaseProductId("12001002");
				policy.setBaseAgentId("20572800");
				policy.setCoverType("INDIVIDUAL");
				policy.getpartyDOList().add(partyDOList);
				policy.getpartyDOList().add(partyDOList1);
				policy.setPolicyAdditionalFieldsDOList(policyAdditionalFieldsDOList);
				policy.setPolicyNum("");
				policy.setProposalNum("");
				policy.setQuotationReferenceNum("");
				policy.setSumInsured("013");
				policy.setTerm("1");
				policy.setUwDecisionCd("");
				policy.setIsPremiumCalculation("YES");
				
				intIO intIO=new intIO();
				intIO.setPolicy(policy);
				
				createPolicy createPolicy=new createPolicy();
				createPolicy.setIntIO(intIO);
				
				try {
					Document document = DocumentBuilderFactory.newInstance().newDocumentBuilder().newDocument();
					Marshaller marshaller = JAXBContext.newInstance(createPolicy.class).createMarshaller();
					marshaller.marshal(createPolicy, document);
					
					SOAPMessage soapMessage = MessageFactory.newInstance().createMessage();
					soapMessage.getSOAPPart().getEnvelope().removeNamespaceDeclaration("SOAP-ENV");
					soapMessage.getSOAPHeader().setPrefix("soap");
					soapMessage.getSOAPBody().setPrefix("soap");
					soapMessage.getSOAPPart().getEnvelope().setPrefix("soap");
					
					String myNamespace = "rel";
				    String myNamespaceURI = "http://relinterface.insurance.symbiosys.c2lbiz.com";
				    String myNamespace1 = "xsd";
				    String myNamespaceURI1 = "http://intf.insurance.symbiosys.c2lbiz.com/xsd";
				    soapMessage.getSOAPPart().getEnvelope().addNamespaceDeclaration(myNamespace, myNamespaceURI);
				    soapMessage.getSOAPPart().getEnvelope().addNamespaceDeclaration(myNamespace1, myNamespaceURI1);
				    soapMessage.getSOAPBody().addDocument(document);
				    
				    ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
					soapMessage.writeTo(outputStream);
					
					HttpClient client = HttpClientBuilder.create().build();
					String output = new String(outputStream.toByteArray());
					System.out.println(output);
					HttpPost post = new HttpPost("https://apiuat.religarehealthinsurance.com/relinterface/services/RelSymbiosysServices.RelSymbiosysServicesHttpSoap12Endpoint/");
					StringEntity userEntity = new StringEntity(output);
					post.setEntity(userEntity);
					
					 HttpResponse response1=client.execute(post);
					 String res_xml = EntityUtils.toString(response1.getEntity());
					 System.out.println("\n");
					 System.out.println(res_xml);
					 
					 Document document1 = parseXmlFile(res_xml);
					 NodeList nodeLst = document1.getElementsByTagName("proposal-num");
					 NodeList nodeLst1=document1.getElementsByTagName("premium");
					 String rel_proposal_num = nodeLst.item(0).getTextContent();
					 String rel_premium = nodeLst1.item(0).getTextContent();
					 
					 String s1[]=rel_premium.split("\\.");
						String rp=s1[0];
					 
					Integer a=Integer.parseInt(rp);
					Integer b=a/12;
					 System.out.println("rel_proposal_num: "+rel_proposal_num);
					 System.out.println("rel_premium: "+rel_premium);
					 System.out.println(b);
					 
					 session.setAttribute("rel_proposal_num", rel_proposal_num);
					 session.setAttribute("rel_premium", rel_premium);
					 session.setAttribute("b", b);
					 
					 response.sendRedirect("healthquotes.jsp");			 
						pw.close(); 
				} catch (ParserConfigurationException e) {
					e.printStackTrace();
				} catch (JAXBException e) {
					e.printStackTrace();
				} catch (SOAPException e) {
					e.printStackTrace();
				} catch (NullPointerException e) {
					e.printStackTrace();
				}
				Apollo.apollo.apollo_premium(request, response);
			
	}
	
	public static void religare_premium(HttpServletRequest request, HttpServletResponse response) throws IOException {
		PrintWriter pw = response.getWriter();
		HttpSession session = request.getSession();
		apollo_proposal_pojo app = (apollo_proposal_pojo) session.getAttribute("app");
		main m=new main();
		
		String salutation = app.getSalutation();
		String fullname = app.getFullname();
		String dob = app.getDob();
		String mobile = app.getMobile();
		String email = app.getEmail();
		String address = app.getAddress();
		String city = app.getCity();
		String state = app.getState();
		String pincode = app.getPincode();
		String nomsalutation=app.getNomsalutation();
		String nomname=app.getNomname();
		String nomrelation=app.getNomrelation();
		String nommobile=app.getNommobile();
		String nomdob=app.getNomdob();
		String nomemail=app.getNomemail();
		String nomaddress=app.getNomaddress();
		String nomcity=app.getNomcity();
		String nomstate=app.getNomstate();
		String nompincode=app.getNompincode();
		
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
		 
		 String firstname=null;
		 String lastname=null;
		 String nomfirstname=null;
		 String nomlastname=null;
		 
		 	if(fullname!=null) {
		 	String word[]=fullname.split("\\s");
		 	firstname=word[0];
		 	lastname=word[1];
		 	}
		 	if(nomname!=null) {
		 	String word[]=nomname.split("\\s");
		 	nomfirstname=word[0];
		 	nomlastname=word[1];
		 	}
		 	
		 	String prefix[]=m.TitleReligare(salutation);
	        String title=prefix[0];
	        String gender=prefix[1];
	        
	        String nomprefix[]=m.TitleReligare(nomsalutation);
	        String nomtitle=nomprefix[0];
	        String nomgender=nomprefix[1];
		 
		 partyAddressDOList partyAddressDOList=new partyAddressDOList();
		 	partyAddressDOList.setAddressLine1Lang1(address);
		 	partyAddressDOList.setAddressLine2Lang1("");
			partyAddressDOList.setAddressTypeCd("PERMANENT");
			partyAddressDOList.setAreaCd("");
			partyAddressDOList.setCityCd(city);
			partyAddressDOList.setPinCode(pincode);
			partyAddressDOList.setStateCd(state);
			
			partyAddressDOList partyAddressDOList1=new partyAddressDOList();
			partyAddressDOList1.setAddressLine1Lang1(address);
			partyAddressDOList1.setAddressLine2Lang1("");
			partyAddressDOList1.setAddressTypeCd("COMMUNICATION");
			partyAddressDOList1.setAreaCd("");
			partyAddressDOList1.setCityCd(city);
			partyAddressDOList1.setPinCode(pincode);
			partyAddressDOList1.setStateCd(state);
			
			partyContactDOList partyContactDOList=new partyContactDOList();
			partyContactDOList.setContactNum(mobile);
			partyContactDOList.setContactTypeCd("MOBILE");
			partyContactDOList.setStdCode("");
			
			partyEmailDOList partyEmailDOList=new partyEmailDOList();
			partyEmailDOList.setEmailAddress(email);
			partyEmailDOList.setEmailTypeCd("PERSONAL");
			
			partyIdentityDOList partyIdentityDOList=new partyIdentityDOList();
			partyIdentityDOList.setIdentityNum("");
			partyIdentityDOList.setIdentityTypeCd("");
			
			partyQuestionDOList partyQuestionDOList=new partyQuestionDOList();
			partyQuestionDOList.setQuestionCd("");
			partyQuestionDOList.setQuestionSetCd("");
			partyQuestionDOList.setResponse("");
			
			partyDOList partyDOList=new partyDOList();
			partyDOList.setBirthDt(dob);
			partyDOList.setFirstName(firstname);
			partyDOList.setGenderCd(gender);
			partyDOList.setGuid("0");
			partyDOList.setLastName(lastname);
			partyDOList.getpartyAddressDOList().add(partyAddressDOList);
			partyDOList.getpartyAddressDOList().add(partyAddressDOList1);
			partyDOList.setPartyContactDOList(partyContactDOList);
			partyDOList.setPartyEmailDOList(partyEmailDOList);
			partyDOList.setPartyIdentityDOList(partyIdentityDOList);
			partyDOList.setPartyQuestionDOList(partyQuestionDOList);
			partyDOList.setRelationCd("SELF");
			partyDOList.setRoleCd("PROPOSER");
			partyDOList.setTitleCd(title);
			
			partyAddressDOList partyAddressDOList2=new partyAddressDOList();
			partyAddressDOList2.setAddressLine1Lang1(nomcity);
			partyAddressDOList2.setAddressLine2Lang1("");
			partyAddressDOList2.setAddressTypeCd("PERMANENT");
			partyAddressDOList2.setAreaCd("");
			partyAddressDOList2.setCityCd(nomcity);
			partyAddressDOList2.setPinCode(nompincode);
			partyAddressDOList2.setStateCd(nomstate);
			
			partyAddressDOList partyAddressDOList3=new partyAddressDOList();
			partyAddressDOList3.setAddressLine1Lang1(nomcity);
			partyAddressDOList3.setAddressLine2Lang1("");
			partyAddressDOList3.setAddressTypeCd("COMMUNICATION");
			partyAddressDOList3.setAreaCd("");
			partyAddressDOList3.setCityCd(nomcity);
			partyAddressDOList3.setPinCode(nompincode);
			partyAddressDOList3.setStateCd(nomstate);
			
			partyContactDOList partyContactDOList1=new partyContactDOList();
			partyContactDOList1.setContactNum(nommobile);
			partyContactDOList1.setContactTypeCd("MOBILE");
			partyContactDOList1.setStdCode("");
			
			partyEmailDOList partyEmailDOList1=new partyEmailDOList();
			partyEmailDOList1.setEmailAddress(nomemail);
			partyEmailDOList1.setEmailTypeCd("PERSONAL");
			
			partyIdentityDOList partyIdentityDOList1=new partyIdentityDOList();
			partyIdentityDOList1.setIdentityNum("");
			partyIdentityDOList1.setIdentityTypeCd("");
			
			partyQuestionDOList partyQuestionDOList1=new partyQuestionDOList();
			partyQuestionDOList1.setQuestionCd("H101");
			partyQuestionDOList1.setQuestionSetCd("HEDCFLEAFONE");
			partyQuestionDOList1.setResponse("NO");
			
			partyDOList partyDOList1=new partyDOList();
			partyDOList1.setBirthDt(nomdob);
			partyDOList1.setFirstName(nomfirstname);
			partyDOList1.setGenderCd(nomgender);
			partyDOList1.setGuid("1");
			partyDOList1.setLastName(nomlastname);
			partyDOList1.getpartyAddressDOList().add(partyAddressDOList2);
			partyDOList1.getpartyAddressDOList().add(partyAddressDOList3);
			partyDOList1.setPartyContactDOList(partyContactDOList1);
			partyDOList1.setPartyEmailDOList(partyEmailDOList1);
			partyDOList1.setPartyIdentityDOList(partyIdentityDOList1);
			partyDOList1.setPartyQuestionDOList(partyQuestionDOList1);
			partyDOList1.setRelationCd("BOTH");
			partyDOList1.setRoleCd("PRIMARY");
			partyDOList1.setTitleCd(nomtitle);
			
			policyAdditionalFieldsDOList policyAdditionalFieldsDOList=new policyAdditionalFieldsDOList();
			policyAdditionalFieldsDOList.setField12(nomrelation);
			policyAdditionalFieldsDOList.setFieldAgree("YES");
			policyAdditionalFieldsDOList.setFieldAlerts("YES");
			policyAdditionalFieldsDOList.setFieldTc("YES");
			
			policy policy=new policy();
			policy.setAddOns("CAREWITHNCB");
			policy.setBusinessTypeCd("NEWBUSINESS");
			policy.setBaseProductId("12001002");
			policy.setBaseAgentId("20572800");
			policy.setCoverType("INDIVIDUAL");
			policy.getpartyDOList().add(partyDOList);
			policy.getpartyDOList().add(partyDOList1);
			policy.setPolicyAdditionalFieldsDOList(policyAdditionalFieldsDOList);
			policy.setPolicyNum("");
			policy.setProposalNum("");
			policy.setQuotationReferenceNum("");
			policy.setSumInsured("013");
			policy.setTerm("1");
			policy.setUwDecisionCd("");
			policy.setIsPremiumCalculation("YES");
			
			intIO intIO=new intIO();
			intIO.setPolicy(policy);
			
			createPolicy createPolicy=new createPolicy();
			createPolicy.setIntIO(intIO);
			
			try {
				Document document = DocumentBuilderFactory.newInstance().newDocumentBuilder().newDocument();
				Marshaller marshaller = JAXBContext.newInstance(createPolicy.class).createMarshaller();
				marshaller.marshal(createPolicy, document);
				
				SOAPMessage soapMessage = MessageFactory.newInstance().createMessage();
				soapMessage.getSOAPPart().getEnvelope().removeNamespaceDeclaration("SOAP-ENV");
				soapMessage.getSOAPHeader().setPrefix("soap");
				soapMessage.getSOAPBody().setPrefix("soap");
				soapMessage.getSOAPPart().getEnvelope().setPrefix("soap");
				
				String myNamespace = "rel";
			    String myNamespaceURI = "http://relinterface.insurance.symbiosys.c2lbiz.com";
			    String myNamespace1 = "xsd";
			    String myNamespaceURI1 = "http://intf.insurance.symbiosys.c2lbiz.com/xsd";
			    soapMessage.getSOAPPart().getEnvelope().addNamespaceDeclaration(myNamespace, myNamespaceURI);
			    soapMessage.getSOAPPart().getEnvelope().addNamespaceDeclaration(myNamespace1, myNamespaceURI1);
			    soapMessage.getSOAPBody().addDocument(document);
			    
			    ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
				soapMessage.writeTo(outputStream);
				
				HttpClient client = HttpClientBuilder.create().build();
				String output = new String(outputStream.toByteArray());
				System.out.println(output);
				HttpPost post = new HttpPost("https://apiuat.religarehealthinsurance.com/relinterface/services/RelSymbiosysServices.RelSymbiosysServicesHttpSoap12Endpoint/");
				StringEntity userEntity = new StringEntity(output);
				post.setEntity(userEntity);
				
				 HttpResponse response1=client.execute(post);
				 String res_xml = EntityUtils.toString(response1.getEntity());
				 System.out.println("\n");
				 System.out.println(res_xml);
				 
				 Document document1 = parseXmlFile(res_xml);
				 NodeList nodeLst = document1.getElementsByTagName("proposal-num");
				 NodeList nodeLst1=document1.getElementsByTagName("premium");
				 String rel_two_proposal_num = nodeLst.item(0).getTextContent();
				 String rel_two_premium = nodeLst1.item(0).getTextContent();
				 
				 System.out.println("rel_two_proposal_num: "+rel_two_proposal_num);
				 System.out.println("rel_two_premium: "+rel_two_premium);
				 
				 session.setAttribute("rel_two_proposal_num", rel_two_proposal_num);
				 session.setAttribute("rel_two_premium", rel_two_premium);
				 
					pw.close(); 
			} catch (ParserConfigurationException e) {
				e.printStackTrace();
			} catch (JAXBException e) {
				e.printStackTrace();
			} catch (SOAPException e) {
				e.printStackTrace();
			}
			return;
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
			}catch (NullPointerException e) {
				throw new RuntimeException(e);
			}
			}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
