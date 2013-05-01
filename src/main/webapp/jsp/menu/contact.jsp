<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<s:head />
<sj:head />
<link rel="stylesheet" href="/ivoniart/css/ivoniart-website.css" type="text/css" />
<style type="text/css">
div#userMessage {
	float: left;
}

div#addressAndPhone {
}
</style>
</head>
<body>
		<%@include file="/jsp/website/header" %>
			<div id="body">
				<%@include file="/jsp/website/title-picture-content" %>
					<table width="100%">
						<tr>
							<td>
								<div id="addressAndPhone">
									<p>
										<s:property value="websiteMenu.address" /><br />
										<s:property value="websiteMenu.phone" /><br />
										<s:property value="websiteMenu.email" /><br/>
									</p>
								</div>
							</td>
						</tr>
						<tr>
							<td>
				
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
										<s:submit key="resource.submit" name="%{resource.submit}" align="center" />
									</s:form>
								</div>
							</td>
						</tr>
					</table>
				</div>
		<%@include file="/jsp/website/footer" %>
</body>
<%@include file="/jsp/website/menu_item_active" %>
</html>
