<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core"
	   prefix = "c" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@page import="bean.LoginBean"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<f:view>
	
		<center>
		<h:form>
			<h2>Welcome Home <h:outputText value="#{loginBean.username}"></h:outputText></h2>
			<br><br>
			<h3>What Operation would you like to perform?</h3>
			<br> <br>
			<h:outputLink value="SearchShares.jsp">Order Shares</h:outputLink>
			<br> <br>
			<h:outputLink value="SellShares.jsp">Sell Shares</h:outputLink>
			<br> <br>
			<h:outputLink value="ViewPortfolio.jsp">View Portfolio</h:outputLink>
			<br> <br>
			<h:outputLink value="ViewTransactionHistory.jsp">View Transaction History</h:outputLink>
			<br> <br>
			<h:commandLink value="See Stock Suggestion" action="#{stockSuggestionBean.getCustomerStockSuggestion}"></h:commandLink><br> <br>
			<h:commandLink action="#{customerBean.retrieveVal}">Update Profile</h:commandLink>
			<br><br>
			<h:commandLink value="View Portfolio Mananger" action="#{customerBean.getPM}"></h:commandLink><br><br>
			
				<h:commandLink value="Logout" action="#{logout.logout}" />
			</h:form>
		</center>
	</f:view>
	
</body>
</html>