<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="f"  uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h"  uri="http://java.sun.com/jsf/html"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<f:view>
<center>
<h2>
Previous Suggestions
</h2>
			<h:dataTable border="3" value="#{stockSuggestionBean.suggestedStocks}" var="s">
				<h:column id="column1">
				<h:outputText value="#{s.id.stockTickr}"></h:outputText>
					<f:facet name="header">
						<h:outputText value="Suggested Stock"></h:outputText>
					</f:facet>
				</h:column>
				<h:column id="column2">
				<h:outputText value="#{s.suggestedDate}"></h:outputText>
					<f:facet name="header">
						<h:outputText value="Suggeston Date"></h:outputText>
					</f:facet>
				</h:column>
				<h:column id="column3">
				<h:outputText value="#{s.comments}"></h:outputText>
					<f:facet name="header">
						<h:outputText value="Comments"></h:outputText>
					</f:facet>
				</h:column>
			</h:dataTable>
			<h:form>
<h2>Suggest Stock Options to Customer</h2>
				<h:panelGrid border="1" columns="3">
					<h:outputText value="Enter Stock Ticker"></h:outputText>
					<h:inputText value="#{stockSuggestionBean.stockTickr}" id="tick" required="true" requiredMessage="Can't be left Blank">
					
					<f:validator validatorId="stocktick" /></h:inputText>
					<h:message for="tick"></h:message>
					<h:outputText value="Comments"></h:outputText>
					<h:inputTextarea value="#{stockSuggestionBean.suggestion}" id="message" required="true" requiredMessage="Can't be left blank">
					
					</h:inputTextarea>
					<h:message for="message"></h:message>
				</h:panelGrid>
				<br>
				<h:commandButton action="#{stockSuggestionBean.saveSuggestion}" value="Suggest"></h:commandButton>
			</h:form>
			<h:outputLink value="PMWelcomePage.jsp">Home</h:outputLink>
			<h:form>
				<h:commandLink value="Logout" action="#{logout.logout}" />
			</h:form>
</center>
</f:view>
</body>
</html>