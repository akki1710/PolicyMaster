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
import javax.xml.soap.SOAPBodyElement;
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

import com.Proposal1;

/**
 * Servlet implementation class shri1
 */
@WebServlet("/shri1")
public class shri1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public shri1() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 PrintWriter pw = response.getWriter();  
		 HttpSession session=request.getSession();
		 String PolicyFromDt = (String) session.getAttribute("PolicyFromDt");
		 String PolicyToDt=(String) session.getAttribute("PolicyToDt");
		 String PolicyIssueDt=(String) session.getAttribute("PolicyIssueDt");
		 String InsuredPrefix=(String) session.getAttribute("InsuredPrefix");
		 String Gender=(String) session.getAttribute("Gender");
		 String Address1=(String) session.getAttribute("Address1");
		 String State=(String) session.getAttribute("State");
		 String City=(String) session.getAttribute("City");
		 String PinCode=(String) session.getAttribute("PinCode");
		 //String PolicyType=(String) session.getAttribute("PolicyType");
		 String DateOfBirth=(String) session.getAttribute("DateOfBirth");
		 String EngineNo=(String) session.getAttribute("EngineNo");
		 String FirstRegDt=(String) session.getAttribute("FirstRegDt");
		 String ChassisNo=(String) session.getAttribute("ChassisNo");
		 String RegNo1=(String) session.getAttribute("RegNo1");
		 String RegNo2=(String) session.getAttribute("RegNo2");
		 String RegNo3=(String) session.getAttribute("RegNo3");
		 String RegNo4=(String) session.getAttribute("RegNo4");
		 String NomineeNameforPAOwnerDriver=(String) session.getAttribute("NomineeNameforPAOwnerDriver");
		 String NomineeAgeforPAOwnerDriver=(String) session.getAttribute("NomineeAgeforPAOwnerDriver");
		 String NomineeRelationforPAOwnerDriver=(String) session.getAttribute("NomineeRelationforPAOwnerDriver");
		 String VehicleManufactureYear1=(String) session.getAttribute("VehicleManufactureYear1");
		 String ProdCode = (String) session.getAttribute("strProductCode");
		 String ProposalType = (String) session.getAttribute("strPolicyType");
		 String InsuredName = (String) session.getAttribute("Fullname");
		 String EMailID = (String) session.getAttribute("Email");
		 String MobileNo = (String) session.getAttribute("Mobile");
		 String VehicleCode = (String) session.getAttribute("strVehicleCode");
		 String RTOCode = (String) session.getAttribute("RTOCODE");
		 String AddonPackage = (String) session.getAttribute("strADDONCover");
		 String PreviousInsurer=(String) session.getAttribute("PreviousInsurer");
		 System.out.println("PreviousInsurer: "+PreviousInsurer);
		 String PreviousPolicyFromDt=(String) session.getAttribute("PreviousPolicyFromDt");
		 String PreviousPolicyToDt=(String) session.getAttribute("PreviousPolicyToDt");
		 String PreviousPolicyUWYear=(String) session.getAttribute("PreviousPolicyUWYear");
		 String VehicleManufactureYear=(String) session.getAttribute("VehicleManufactureYear");
		 String strPrevPolClaimYN=(String) session.getAttribute("strPrevPolClaimYN");
		 
		 
		 Proposal1 prop=new Proposal1();
		 	prop.setReferenceNo("");
			prop.setProdCode(ProdCode);
			prop.setPolicyFromDt(PolicyFromDt);
			prop.setPolicyToDt(PolicyToDt);
			prop.setPolicyIssueDt(PolicyIssueDt);
			prop.setInsuredPrefix(InsuredPrefix);
			prop.setInsuredName(InsuredName);
			prop.setGender(Gender);
			prop.setAddress1(Address1);
			prop.setAddress2("");
			prop.setAddress3("");
			prop.setState(State);
			prop.setCity(City);
			prop.setPinCode(PinCode);
			prop.setPanNo("");
			prop.setGSTNo("");
			prop.setTelephoneNo("");
			prop.setFaxNo("");
			prop.setEMailID(EMailID);
			prop.setPolicyType("MOT-PLT-001");
			prop.setProposalType(ProposalType);
			prop.setMobileNo(MobileNo);
			prop.setDateOfBirth(DateOfBirth);
			prop.setPOSAgentName("");
			prop.setPOSAgentPanNo("");
			prop.setCoverNoteNo("");
			prop.setCoverNoteDt("");
			prop.setVehicleCode(VehicleCode);
			prop.setEngineNo(EngineNo);
			prop.setFirstRegDt(FirstRegDt);
			
			prop.setChassisNo(ChassisNo);
			prop.setRegNo1(RegNo1);
			prop.setRegNo2(RegNo2);
			prop.setRegNo3(RegNo3);
			prop.setRegNo4(RegNo4);
			prop.setRTOCode(RTOCode);
			prop.setIDV_of_Vehicle("");
			prop.setColour("");
			prop.setNoEmpCoverLL("");
			prop.setVehiclePurposeYN("0");
			prop.setDriverAgeYN("0");
			prop.setLimitOwnPremiseYN("0");
			prop.setCNGKitYN("0");
			prop.setCNGKitSI("");
			prop.setLimitedTPPDYN("");
			prop.setInBuiltCNGKitYN("0");
			prop.setVoluntaryExcess("");
			prop.setBangladesh("0");
			prop.setBhutan("0");
			prop.setSriLanka("0");
			prop.setPakistan("0");
			prop.setNepal("0");
			prop.setMaldives("0");
			prop.setDeTariff("");
			prop.setPreInspectionReportYN("0");
			prop.setPreInspection("");
			prop.setBreakIn("");
			prop.setAddonPackage(AddonPackage);
			prop.setNilDepreciationCoverYN("");
			prop.setPAforUnnamedPassengerYN("");
			prop.setPAforUnnamedPassengerSI("");
			prop.setElectricalaccessYN("");
			prop.setElectricalaccessSI("");
			prop.setElectricalaccessRemarks("");
			prop.setNonElectricalaccessYN("");
			prop.setNonElectricalaccessSI("");
			prop.setNonElectricalaccessRemarks("");
			prop.setPAPaidDriverConductorCleanerYN("");
			prop.setPAPaidDriverConductorCleanerSI("");
			prop.setPAPaidDriverCount("");
			prop.setPAPaidConductorCount("");
			prop.setPAPaidCleanerCount("");
			prop.setNomineeNameforPAOwnerDriver(NomineeNameforPAOwnerDriver);
			prop.setNomineeAgeforPAOwnerDriver(NomineeAgeforPAOwnerDriver);
			prop.setNomineeRelationforPAOwnerDriver(NomineeRelationforPAOwnerDriver);
			prop.setAppointeeNameforPAOwnerDriver("");
			prop.setAppointeeRelationforPAOwnerDriver("");
			prop.setLLtoPaidDriverYN("");
			prop.setAntiTheftYN("0");
			prop.setPreviousPolicyNo("");
			if(PreviousInsurer.equals("")) {
				prop.setPreviousInsurer("");
				prop.setVehicleType("W");
				prop.setPreviousPolicyFromDt("");
				prop.setPreviousPolicyToDt("");
				prop.setPreviousPolicyUWYear("");
				prop.setVehicleManufactureYear(VehicleManufactureYear1);
				
				
			}
			else {
				prop.setPreviousInsurer(PreviousInsurer);
				prop.setVehicleType("U");
				prop.setPreviousPolicyFromDt(PreviousPolicyFromDt);
				prop.setPreviousPolicyToDt(PreviousPolicyToDt);
				prop.setPreviousPolicyUWYear(PreviousPolicyUWYear);
				prop.setVehicleManufactureYear(VehicleManufactureYear);
			}
			prop.setPreviousPolicySI("");
			prop.setPreviousPolicyClaimYN(strPrevPolClaimYN);
			prop.setPreviousPolicyNCBPerc("0");
			prop.setPreviousPolicyType("");
			prop.setPreviousNilDepreciation("");
			prop.setHypothecationType("");
			prop.setHypothecationBankName("");
			prop.setHypothecationAddress1("");
			prop.setHypothecationAddress2("");
			prop.setHypothecationAddress3("");
			prop.setHypothecationAgreementNo("");
			prop.setHypothecationCountry("");
			prop.setHypothecationState("");
			prop.setHypothecationCity("");
			prop.setHypothecationPinCode("");
			prop.setSpecifiedPersonField("");
			prop.setPAOwnerDriverExclusion("");
			prop.setPAOwnerDriverExReason("");
			prop.setDepDeductWaiverYN("0");
			prop.setDailyExpRemYN("0");
			prop.setInvReturnYN("0");
			prop.setLossOfPersonBelongYN("0");
			prop.setEmergencyTranHotelExpRemYN("0");
			prop.setKeyReplacementYN("0");
			prop.setMultiCarBenefitYN("0");
			prop.setAadharNo("");
			prop.setAadharEnrollNo("");
			prop.setForm16("");
			prop.setVehicleManufactureYear(VehicleManufactureYear);
			
			HttpClient client = HttpClientBuilder.create().build();
			
			Document document;
			try {
				document = DocumentBuilderFactory.newInstance().newDocumentBuilder().newDocument();
				Marshaller marshaller = JAXBContext.newInstance(Proposal1.class).createMarshaller();
				marshaller.marshal(prop, document);
				
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
				
				SOAPBodyElement abc = (SOAPBodyElement) soapMessage.getSOAPBody().addBodyElement(soapMessage.getSOAPPart().getEnvelope().createName("GenerateProposal",myNamespace,myNamespaceURI));
				
				SOAPBodyElement def = soapMessage.getSOAPBody().addDocument(document);	
			   	abc.addChildElement(def);
				ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
				soapMessage.writeTo(outputStream);			
				
				
				String output = new String(outputStream.toByteArray());
				HttpPost post = new HttpPost("http://119.226.131.2/ShriramService/ShriramService.asmx");
				StringEntity userEntity = new StringEntity(output);
				post.setEntity(userEntity);
				post.setHeader("Accept-Encoding", "gzip,deflate");
				post.setHeader("Content-Type", "text/xml; charset=UTF-8");
				//post.setHeader("Content-Type", "application/soap+xml; charset=UTF-8;action=http://tempuri.org/GetQuot");
				post.setHeader("SOAPAction", "http://tempuri.org/GenerateProposal");
				 HttpResponse response1=client.execute(post);
				 String res_xml = EntityUtils.toString(response1.getEntity());
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
				 String POL_SYS_ID = nodeLst.item(0).getTextContent();
				 String ProposalNo= nodeLst1.item(0).getTextContent();
				 String ec2= nodeLst2.item(0).getTextContent();
				 String ec3= nodeLst3.item(0).getTextContent();
				 String ec4= nodeLst4.item(0).getTextContent();
				 session.setAttribute("ec2", ec2);
				 session.setAttribute("ec3", ec3);
				 session.setAttribute("ec4", ec4);
				 session.setAttribute("ProposalNo", ProposalNo);
				 session.setAttribute("POL_SYS_ID", POL_SYS_ID);
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
				                     String CoverDesc1 = el.getElementsByTagName("CoverDesc").item(7).getTextContent();
				                     String TotalPremium = el.getElementsByTagName("Premium").item(7).getTextContent();
				                     //session.setAttribute("CoverDesc1", CoverDesc1);
				                     session.setAttribute("TotalPremium", TotalPremium);
				        		 }
				        	 }
				        }
				 }
				 response.sendRedirect("shripay.jsp");
					
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
				session.removeAttribute("PolicyFromDt");
				session.removeAttribute("PolicyToDt");
				session.removeAttribute("PolicyIssueDt");
				session.removeAttribute("InsuredPrefix");
				session.removeAttribute("Gender");
				session.removeAttribute("Address1");
				session.removeAttribute("State");
				session.removeAttribute("City");
				session.removeAttribute("PinCode");
				session.removeAttribute("PolicyType");
				session.removeAttribute("DateOfBirth");
				session.removeAttribute("EngineNo");
				session.removeAttribute("FirstRegDt");
				session.removeAttribute("ChassisNo");
				session.removeAttribute("RegNo1");
				session.removeAttribute("RegNo2");
				session.removeAttribute("RegNo3");
				session.removeAttribute("RegNo4");
				session.removeAttribute("NomineeNameforPAOwnerDriver");
				session.removeAttribute("NomineeAgeforPAOwnerDriver");
				session.removeAttribute("NomineeRelationforPAOwnerDriver");
				session.removeAttribute("VehicleManufactureYear1");
				session.removeAttribute("strProductCode");
				session.removeAttribute("strPolicyType");
				session.removeAttribute("strVehicleCode");
				session.removeAttribute("RTOCODE");
				session.removeAttribute("strADDONCover");
				session.removeAttribute("PreviousInsurer");
				session.removeAttribute("PreviousPolicyFromDt");
				session.removeAttribute("PreviousPolicyToDt");
				session.removeAttribute("PreviousPolicyUWYear");
				session.removeAttribute("VehicleManufactureYear");
				session.removeAttribute("strPrevPolClaimYN");
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
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
