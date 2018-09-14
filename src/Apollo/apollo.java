package Apollo;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringReader;
import java.io.StringWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.PropertyException;
import javax.xml.bind.Unmarshaller;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.soap.MessageFactory;
import javax.xml.soap.SOAPException;
import javax.xml.soap.SOAPMessage;
import javax.xml.transform.stream.StreamSource;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathFactory;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
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

import com.apollo_proposal_pojo;
import com.main;

/**
 * Servlet implementation class apollo
 */
@WebServlet("/apollo")
public class apollo extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static String TotalPremium;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public apollo() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response){

	}

	public static void apollo_premium(HttpServletRequest request, HttpServletResponse response) throws IOException {

		PrintWriter pw = response.getWriter();

		HttpSession session = request.getSession();
		apollo_proposal_pojo ap = (apollo_proposal_pojo) session.getAttribute("ap");
		String date = ap.getDob();

		AddressSubElement addressSubElem = new AddressSubElement();
		/*
		 * addressSubElem.setAddressLine1("emerald appartment");
		 * addressSubElem.setAddressLine2("ramprastha green");
		 * addressSubElem.setAddressLine3("vaishali");
		 * addressSubElem.setCountryCode("IN"); addressSubElem.setDistrict("ghaziabad");
		 * addressSubElem.setPinCode("201010");
		 */
		 String state_one_code = (String) session.getAttribute("state_one_code");
		addressSubElem.setStateCode(state_one_code);
		System.out.println("StateCode :"+state_one_code);
		addressSubElem.setTownCode("774");

		Address Addr = new Address();
		Addr.setAddress(addressSubElem);

		Partner part = new Partner();
		part.setPartnerCode("13961");
		part.setPassword("master123");
		part.setUserName("policymaster");

		ProductSubElement productSubElem = new ProductSubElement();
		productSubElem.setClientcode("PolicyHolder");
		productSubElem.setProductCode("11119");
		productSubElem.setProductGroup("1");
		productSubElem.setProductLine("9");
		productSubElem.setProductType("1");
		productSubElem.setProductVersion("1");
		productSubElem.setSACCode("1");
		productSubElem.setSumAssured("500000");

		Product prod = new Product();
		prod.setProduct(productSubElem);

		SimpleDateFormat format = new SimpleDateFormat("dd/yy/yyyy");
		java.util.Date utilDate;
		Calendar dob = Calendar.getInstance();
		Calendar today = Calendar.getInstance();

		try {
			utilDate = format.parse(date);
			dob.setTime(utilDate);
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		// calculating age from dob

		int age = today.get(Calendar.YEAR) - dob.get(Calendar.YEAR);
		if (today.get(Calendar.DAY_OF_YEAR) < dob.get(Calendar.DAY_OF_YEAR)) {
			age--;
			System.out.println(age);
		}
		String custage = Integer.toString(age);
		System.out.println(custage);

		Client cli = new Client();
		cli.setAge(custage);
		cli.setClientCode("PolicyHolder");
		cli.setOccuptionCode("303601");
		cli.setAddress(Addr);
		cli.setProduct(prod);

		Clients clis = new Clients();
		clis.setClient(cli);

		PremiumCalculatorRequest premiumCalculatorReq = new PremiumCalculatorRequest();
		premiumCalculatorReq.setClients(clis);
		premiumCalculatorReq.setPartner(part);

		ComputePremium ComputePrem = new ComputePremium();
		ComputePrem.setPremiumCalculatorRequest(premiumCalculatorReq);

		// String xmlString = "";
		Document document;
		try {
			document = DocumentBuilderFactory.newInstance().newDocumentBuilder().newDocument();

			document = DocumentBuilderFactory.newInstance().newDocumentBuilder().newDocument();
			Marshaller marshaller = JAXBContext.newInstance(ComputePremium.class).createMarshaller();
			marshaller.marshal(ComputePrem, document);

			SOAPMessage soapMessage = MessageFactory.newInstance().createMessage();

			soapMessage.getSOAPPart().getEnvelope().removeNamespaceDeclaration("SOAP-ENV");

			String myNamespace = "b2b";
			String myNamespaceURI = "http://www.apollomunichinsurance.com/B2BService";

			String myNamespace1 = "prem";
			String myNamespaceURI1 = "http://schemas.datacontract.org/2004/07/PremiumCalculatorLibrary";

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
			HttpPost post = new HttpPost("http://b2buat.apollomunichinsurance.com/PremiumCaculatorHttpService.svc");
			String output = new String(outputStream.toByteArray());
			StringEntity userEntity = new StringEntity(output);
			post.setEntity(userEntity);
			post.setHeader("Accept-Encoding", "gzip,deflate");
			post.setHeader("Content-Type", "text/xml; charset=UTF-8");
			post.setHeader("SOAPAction",
					"http://www.apollomunichinsurance.com/B2BService/IPremimumCalculatorService/ComputePremium");
			HttpResponse response1 = client1.execute(post);
			String res_xml = EntityUtils.toString(response1.getEntity());
			InputSource is = new InputSource(new StringReader(res_xml));
			System.out.println(output);
			System.out.println("\n");
			// System.out.println(response1);
			System.out.println(res_xml);

			try {

				String xpath_TotalPremium = "//TotalPremium/text()";
				DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
				DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
				Document doc = dBuilder.parse(is);
				XPathFactory xPathfactory = XPathFactory.newInstance();
				XPath xpath = xPathfactory.newXPath();
				XPathExpression xpath_expression_TotalPremium = xpath.compile(xpath_TotalPremium);
				NodeList TotalPremiumNodes = (NodeList) xpath_expression_TotalPremium.evaluate(doc,
						XPathConstants.NODESET);
				for (int i = 0; i < TotalPremiumNodes.getLength(); i++) {

					System.out.println("TotalPremium: " + TotalPremiumNodes.item(i).getNodeValue());

					String TotalPremium = TotalPremiumNodes.item(i).getNodeValue();
					System.out.println("TotalPremium");
					session.setAttribute("TotalPremium", TotalPremium);

					String s1[] = TotalPremium.split("\\.");
					String tp = s1[0];

					Integer a = Integer.parseInt(tp);
					Integer b1 = a / 12;
					String b2 = String.valueOf(b1);
					System.out.println(b2);
					session.setAttribute("b2", b2);
					// String b2=(String) session.getAttribute("b2");
					pw.close();
					// response.sendRedirect("healthquotes");

				}

			} catch (Exception e) {
				e.printStackTrace();
			}

		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		} catch (JAXBException e) {
			e.printStackTrace();
		} catch (SOAPException e) {
			e.printStackTrace();

		} catch (NullPointerException e) {
			e.printStackTrace();

		}catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} finally {

		}

	}

	public static void apollo_proposal(HttpServletRequest request, HttpServletResponse response) throws IOException {

		PrintWriter pw = response.getWriter();
		HttpSession session = request.getSession();
		apollo_proposal_pojo app = (apollo_proposal_pojo) session.getAttribute("app");

		String fullname = app.getFullname();
		String salutation = app.getSalutation();
		String dob = app.getDob();
		String occupation = app.getOccupation();
		String height = app.getHeight();
		String height1 = app.getHeight1();
		String weight = app.getWeight();
		String mobile = app.getMobile();
		String email = app.getEmail();
		String address = app.getAddress();
		String city = app.getCity();
		String state = app.getState();
		String pincode = app.getPincode();
		

		String s = fullname;
		String s1[] = s.split("\\s");
		System.out.println(s1[0]);
		System.out.println(s1[1]);

		Partner part = new Partner();
		part.setPartnerCode("13961");
		part.setPassword("master123");
		part.setUserName("policymaster");

		AddressSubElement addressSubElem = new AddressSubElement();
		addressSubElem.setAddressLine1(address);
		addressSubElem.setAddressLine2("");
		addressSubElem.setAddressLine3("");
		addressSubElem.setCountryCode("IN");
		addressSubElem.setDistrict("");
		addressSubElem.setPinCode(pincode);
		addressSubElem.setStateCode("010");
		addressSubElem.setTownCode("774");

		Address Addr = new Address();
		Addr.setAddress(addressSubElem);

		ProductSubElement productSubElem = new ProductSubElement();

		productSubElem.setBasePremiumAmount("7145.00");
		productSubElem.setClientcode("PolicyHolder");
		 productSubElem.setDiscountAmount("0.00");
		 productSubElem.setGrossPremiumAmount("8431.1");
		 productSubElem.setLoadingAmount("11006");
		// productSubElem.setPaidBy("1");
		productSubElem.setProductCode("11119");
		productSubElem.setProductGroup("1");
		productSubElem.setProductLine("9");
		productSubElem.setProductType("1");
		productSubElem.setProductVersion("1");
		productSubElem.setSACCode("1");
		productSubElem.setSumAssured("500000");
		 productSubElem.setTaxAmount("1101.06");

		Product prod = new Product();
		prod.setProduct(productSubElem);

		LifeStyleHabits lifeStyle = new LifeStyleHabits();
		// lifeStyle.setBeerBottle("1");
		// lifeStyle.setLiquorPeg("2");
		// lifeStyle.setPouches("0");
		// lifeStyle.setSmoking("5");
		// lifeStyle.setWineGlass("0");

		ContactSubElement contactSubElem = new ContactSubElement();
		contactSubElem.setNumber(mobile);
		contactSubElem.setType("7");

		ContactNumber contactNum = new ContactNumber();
		contactNum.setContactNumber(contactSubElem);

		ContactInformation contactInform = new ContactInformation();
		contactInform.setContactNumber(contactNum);
		contactInform.setEmail(email);

		main m = new main(); 
		  String salu[]= m.Titleapollo(salutation) ;
		  String saluta =salu[0];
		 String gencode = salu[1];
		 
		System.out.println("salutation: "+saluta);
		System.out.println("gendercode: "+gencode);
		
		
		
		
		
		Client cli = new Client();
		
		// cli.setAge("");
		cli.setClientCode("PolicyHolder");
		cli.setOccuptionCode("303601");
		cli.setAddress(Addr);
		cli.setProduct(prod);
		 cli.setAnnualIncome("999999");
		cli.setBirthDate(dob);
		cli.setContactInformation(contactInform);
		// cli.setFamilySize("1");
		cli.setFirstName(s1[0]);
		cli.setGenderCode(gencode);
		// cli.setGstinNumber("abc12345");
		cli.setHeight("170");
		// cli.setIDProofNumber("IDNO388");
		// cli.setIDProofTypeCode("IDNO1");
		cli.setLastName(s1[1]);
		// cli.setLifeStyleHabits(lifeStyle);
		cli.setMaritalStatusCode("1");
		cli.setMiddleName("");
		cli.setNationalityCode("IN");
		cli.setRelationshipCode("1");
		cli.setTitleCode(saluta );
		cli.setWeight(weight);

		Proposer prop = new Proposer();
		prop.setAddress(Addr);
		prop.setBirthDate(dob);
		prop.setContactInformation(contactInform);
		prop.setFirstName(s1[0]);
		prop.setGenderCode(gencode);
		// prop.setGstinNumber("abc12345");
		// prop.setIDProofNumber("IDNO388");
		// prop.setIDProofTypeCode("IDNO1");
		prop.setLastName(s1[1]);
		prop.setMaritalStatusCode("1");
		prop.setMiddleName("");
		prop.setNationalityCode("IN");
		prop.setRelationshipCode("1");

		NomineeAddress nomineeAddr = new NomineeAddress();
		nomineeAddr.setAddressLine1(address);
		nomineeAddr.setAddressLine2("");
		nomineeAddr.setAddressLine3("");
		nomineeAddr.setCountryCode("IN");
		nomineeAddr.setDistrict("");
		nomineeAddr.setPinCode(pincode);
		nomineeAddr.setStateCode("010");
		nomineeAddr.setTownCode("774");

		Application appli = new Application();
		appli.setNamefor80D(fullname);
		appli.setNomineeAddress(nomineeAddr);
		appli.setNomineeName(fullname);
		appli.setNomineeTitleCode(saluta);
		appli.setProposer(prop);
		appli.setRelationToNomineeCode("14");
		// appli.setRuralFlag("0");
		appli.setTPANameCode("FHPL");

		Prospect pros = new Prospect();
		pros.setBrandCode("ApolloMunich");
		//pros.setTotalPremiumAmount("8431.1");
		pros.setApplication(appli);
		pros.setClient(cli);

		ProposalCaptureServiceRequest proposalCapt = new ProposalCaptureServiceRequest();
		proposalCapt.setAction("Create");
		proposalCapt.setProspect(pros);
		proposalCapt.setPartner(part);

		ProposalCapture proposalC = new ProposalCapture();
		proposalC.setProposalCaptureServiceRequest(proposalCapt);

		Document document;
		try {
			document = DocumentBuilderFactory.newInstance().newDocumentBuilder().newDocument();

			document = DocumentBuilderFactory.newInstance().newDocumentBuilder().newDocument();
			Marshaller marshaller = JAXBContext.newInstance(ProposalCapture.class).createMarshaller();
			marshaller.marshal(proposalC, document);

			SOAPMessage soapMessage = MessageFactory.newInstance().createMessage();

			soapMessage.getSOAPPart().getEnvelope().removeNamespaceDeclaration("SOAP-ENV");

			String myNamespace = "b2b";
			String myNamespaceURI = "http://www.apollomunichinsurance.com/B2BService";

			String myNamespace1 = "prop";
			String myNamespaceURI1 = "http://schemas.datacontract.org/2004/07/ProposalCaptureServiceLibrary";

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
			HttpPost post = new HttpPost("http://b2buat.apollomunichinsurance.com/ProposalCaptureHttpService.svc");
			String output = new String(outputStream.toByteArray());
			StringEntity userEntity = new StringEntity(output);
			post.setEntity(userEntity);
			post.setHeader("Accept-Encoding", "gzip,deflate");
			post.setHeader("Content-Type", "text/xml; charset=UTF-8");
			post.setHeader("SOAPAction",
					"http://www.apollomunichinsurance.com/B2BService/IProposalCaptureService/ProposalCapture");
			HttpResponse response1 = client1.execute(post);
			String res_xml = EntityUtils.toString(response1.getEntity());
			InputSource is = new InputSource(new StringReader(res_xml));
			System.out.println(output);
			System.out.println("\n");
			// System.out.println(response1);
			System.out.println(res_xml);
			try {

				String xpath_ProposalCaptureResult = "//ProposalCaptureResult/text()";
				DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
				DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
				Document doc = dBuilder.parse(is);
				XPathFactory xPathfactory = XPathFactory.newInstance();
				XPath xpath = xPathfactory.newXPath();
				XPathExpression xpath_expression_ProposalCaptureResult = xpath.compile(xpath_ProposalCaptureResult);
				NodeList ProposalCaptureResultNodes = (NodeList) xpath_expression_ProposalCaptureResult.evaluate(doc,
						XPathConstants.NODESET);
				for (int i = 0; i < ProposalCaptureResultNodes.getLength(); i++) {
					System.out.println("ProposalCaptureResult: " + ProposalCaptureResultNodes.item(i).getNodeValue());
					String Proposal_id = ProposalCaptureResultNodes.item(i).getNodeValue();
					session.setAttribute("Proposal_id", Proposal_id);
				}
					pw.close();
			} catch (Exception e) {
				e.printStackTrace();
			}

		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		} catch (JAXBException e) {
			e.printStackTrace();
		} catch (SOAPException e) {
			e.printStackTrace();

		} catch (ClientProtocolException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (NullPointerException e) {
			e.printStackTrace();

		}catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} finally {

		}
		if(session!=null) {
			session.removeAttribute("app");
			session.removeAttribute("members");
		}
	}

	public static void apollo_payment(HttpServletRequest request, HttpServletResponse response) throws IOException {
		PrintWriter pw = response.getWriter();
		HttpSession session = request.getSession();
		String Proposal_id = (String) session.getAttribute("Proposal_id");

		String SALTCHARS = "MAI1780";
		StringBuilder salt = new StringBuilder();
		Random rnd = new Random();
		while (salt.length() < 6) { // length of the random string.
			int index = (int) (rnd.nextFloat() * SALTCHARS.length());
			salt.append(SALTCHARS.charAt(index));
		}
		String saltStr = salt.toString();

		PGDetail pgdet = new PGDetail();
		pgdet.setIPAddress("127.0.0.1");
		pgdet.setMerchantRefNo(saltStr);
		pgdet.setProposalId(Proposal_id);
		pgdet.setReturnUrl("http://localhost:8080/PolicyMaster");
		pgdet.setUDF1("");
		pgdet.setUDF2("");
		pgdet.setUDF3("");
		pgdet.setUDF4("");
		pgdet.setUDF5("");

		Partner part = new Partner();
		part.setPartnerCode("13961");
		part.setPassword("master123");
		part.setUserName("policymaster");

		paymentGatewayServiceRequest pgsr = new paymentGatewayServiceRequest();
		pgsr.setPGDetail(pgdet);
		pgsr.setPartner(part);

		PaymentDetails paymentdet = new PaymentDetails();
		paymentdet.setPaymentGatewayServiceRequest(pgsr);

		Document document;
		try {
			document = DocumentBuilderFactory.newInstance().newDocumentBuilder().newDocument();

			document = DocumentBuilderFactory.newInstance().newDocumentBuilder().newDocument();
			Marshaller marshaller = JAXBContext.newInstance(PaymentDetails.class).createMarshaller();
			marshaller.marshal(paymentdet, document);

			SOAPMessage soapMessage = MessageFactory.newInstance().createMessage();

			soapMessage.getSOAPPart().getEnvelope().removeNamespaceDeclaration("SOAP-ENV");

			String myNamespace = "b2b";
			String myNamespaceURI = "http://www.apollomunichinsurance.com/B2BService";
			String myNamespace1 = "pay";
			String myNamespaceURI1 = "http://schemas.datacontract.org/2004/07/PaymentGatewayServiceLibrary";

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
			HttpPost post = new HttpPost("http://b2buat.apollomunichinsurance.com/PaymentGatewayHttpService.svc");
			String output = new String(outputStream.toByteArray());
			StringEntity userEntity = new StringEntity(output);
			post.setEntity(userEntity);
			post.setHeader("Accept-Encoding", "gzip,deflate");
			post.setHeader("Content-Type", "text/xml; charset=UTF-8");
			post.setHeader("SOAPAction",
					"http://www.apollomunichinsurance.com/B2BService/IPaymentGatewayService/PaymentDetails");
			HttpResponse response1 = client1.execute(post);
			String res_xml = EntityUtils.toString(response1.getEntity());
			InputSource is = new InputSource(new StringReader(res_xml));
			System.out.println(output);
			System.out.println("\n");
			// System.out.println(response1);
			System.out.println(res_xml);
			try {

				String xpath_PaymentUrl = "//PaymentUrl/text()";
				DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
				DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
				Document doc = dBuilder.parse(is);
				XPathFactory xPathfactory = XPathFactory.newInstance();
				XPath xpath = xPathfactory.newXPath();
				XPathExpression xpath_expression_PaymentUrl = xpath.compile(xpath_PaymentUrl);
				NodeList PaymentUrlNodes = (NodeList) xpath_expression_PaymentUrl.evaluate(doc, XPathConstants.NODESET);
				for (int i = 0; i < PaymentUrlNodes.getLength(); i++) {
					System.out.println("PaymentUrl: " + PaymentUrlNodes.item(i).getNodeValue());
					String PaymentUrl = PaymentUrlNodes.item(i).getNodeValue();
					session.setAttribute("PaymentUrl", PaymentUrl);
				}
				pw.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		} catch (JAXBException e) {
			e.printStackTrace();
		} catch (NullPointerException e) {
			e.printStackTrace();

		}catch (SOAPException e) {
			e.printStackTrace();

		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} 
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
