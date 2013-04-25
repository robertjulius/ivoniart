<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<s:head />
<sj:head />
<link rel="stylesheet" href="/ivoniart/css/ivoniart-website.css"
	type="text/css" />
<style type="text/css">
div#userMessage {
		
}
</style>
</head>
<body>
	<div id="root">
		<div id="header">
			<div id="menuStrip">
				<div id="menuBar">
					<div id="menuItem">
						<a href="<%=request.getContextPath()%>/menu/home.action">Home</a>
					</div>
					<div id="menuItem">
						<a href="<%=request.getContextPath()%>/menu/about.action">About</a>
					</div>
					<div id="menuItem">
						<a href="<%=request.getContextPath()%>/menu/services.action">Services</a>
					</div>
					<div id="menuItem">
						<a href="<%=request.getContextPath()%>/menu/contact.action">Contact</a>
					</div>
				</div>
			</div>
		</div>
		<div id="body">
			<div id="title">
				<s:property value="title" escape="false" />
			</div>
			<div id="content">
				<s:property value="content" escape="false" />
			</div>
			<div id="userMessage">
				<s:form action="/menu/saveGuessMessage.action">
					<s:actionmessage/>
					<s:actionerror/>
					<s:fielderror/>
					<s:textfield key="guessMessage.name" labelposition="top" required="true" />
					<s:textfield key="guessMessage.company" labelposition="top" required="true" />
					<s:textfield key="guessMessage.phone" labelposition="top" required="true" />
					<s:textfield key="guessMessage.email" labelposition="top" required="true" />
					<s:textfield key="guessMessage.emailConfirm" labelposition="top" required="true" />
					<s:textarea key="guessMessage.messages" labelposition="top" required="true" cols="40" rows="10" />
					<s:submit key="resource.submit" name="%{resource.submit}" />
				</s:form>
			</div>
		</div>
		<div id="footer">Copyright</div>
	</div>
</body>
</html>
