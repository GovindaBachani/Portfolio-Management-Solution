<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Create PM</title>
</head>
<body>
	<f:view>
		<center>
			<h:form>
				<h:panelGrid border="1" columns="3">
					<h:outputText value="Portfolio Manager Name"></h:outputText>
					<h:inputText value="#{pMBean.pfm_name}" id="name" required="true"
						requiredMessage="*Name cannot be blank."></h:inputText>
					<h:message for="name" style="color: #FF0000"></h:message>
					<h:outputText value="Address"></h:outputText>
					<h:inputTextarea id="address" value="#{pMBean.address}"
						required="true" requiredMessage="*Address cannot be blank"></h:inputTextarea>
					<h:message for="address" style="color: #FF0000"></h:message>
					<h:outputText value="Contact Number"></h:outputText>
					<h:inputText id="contact" value="#{pMBean.contact_number }"
						required="true" requiredMessage="*Contact number cannot be blank">
						<f:validator validatorId="num_validator" />
					</h:inputText>
					<h:message for="contact" style="color: #FF0000"></h:message>
					<h:outputText value="Username"></h:outputText>
					<h:inputText id="username" value="#{pMBean.username}"
						required="true" requiredMessage="*Username cannot be left blank">
						<f:validator validatorId="usernamevalidator" />
					</h:inputText>
					<h:message for="username" style="color: #FF0000"></h:message>
					<h:outputText value="Password"></h:outputText>
					<h:inputSecret id="pass" value="#{pMBean.password }"
						required="true" requiredMessage="*Password cannot be left blank">
					</h:inputSecret>
					<h:message for="pass" style="color: #FF0000"></h:message>
					<h:outputText value="Retype Password"></h:outputText>
					<h:inputSecret id="repass" value="#{pMBean.re_password}"
						required="true" requiredMessage="*Field cannot be left blank">
					</h:inputSecret>
					<h:message for="repass" style="color: #FF0000"></h:message>
				</h:panelGrid>
				<h:commandButton value="Submit" type="submit"
					action="#{pMBean.save}"></h:commandButton>
				<h:commandButton value="Reset" type="reset"></h:commandButton>
				<br>
				<br>
				<h:outputText value="#{pMBean.message}" style="color: #FF0000"></h:outputText>
				<br>
				<br>
				<br>
			</h:form><br>
			<h:outputLink value="AdminWelcomePage.jsp">Home</h:outputLink>
			<h:form>
				<h:commandLink value="Logout" action="#{logout.logout}" />
			</h:form>
		</center>
	</f:view>
</body>
</html>