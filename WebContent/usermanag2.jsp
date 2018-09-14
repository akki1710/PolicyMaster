<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page import="java.util.List" %>
<%@ page import="ServeletBean.RegPJ" %>
<jsp:useBean id="rp1" class="ServeletBean.RegPJ"/>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="UserManag" method=get>
<%List<RegPJ> rp2=(List<RegPJ>) session.getAttribute("rp2"); %>
<%for(int i=0;i<rp2.size();i++) {%>
All Data:<%=rp2.get(i) %>
	
	<%}%>

<%-- <%rp1=(ServeletBean.RegPJ)session.getAttribute( "rp1" ); %> --%>
<%-- ProposalNo: <%=rp1.getProposalNo() %><br>
PolicyNo: <%=rp1.getApprovePolNo() %><br>
TotalPremium: <%=rp1.getTotalPremium() %><br>
PolicyName: <%=rp1.getPolicyName() %><br>
Fullname: <%=rp1.getName() %><br>
Email: <%=rp1.getEmail() %><br>
Mobile: <%=rp1.getPhoneno() %><br> --%>
</form>
</body>
</html>