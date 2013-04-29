<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>
<%@ taglib prefix="sjr" uri="/struts-jquery-richtext-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<s:head />
<sj:head />
</head>
<body>
	<table>
		<tr>
			<td class="pageTitle1"><s:text name="resource.page.title" /></td> 
		</tr>
		<tr>
			<td class="pageTitle2"><s:text name="resource.page.title2.update" /></td>
		</tr>
	</table>
	<s:form action="/modules/webitemsmaintenance/executeUpdate.action" theme="simple">
		<s:if test="hasActionErrors()">
			<table>
				<s:actionerror />
				<s:fielderror />
			</table>
		</s:if>
		<table class="form">
			<tr>
				<td>
					<table>
						<s:select key="resource.logoImage" name="newLogoImageId" id="newLogoImageId" list="selectListLogoImage" listKey="id" listValue="title" theme="xhtml" />
						<tr>
							<td align="right">Copyright:</td>
							<td><sjr:tinymce key="resource.copyright" id="newCopyright" name="newCopyright"
									height="50" width="300" />
							</td>
						</tr>
						<s:select key="resource.backgroundImage" name="newBackgroundImageId" id="newBackgroundImageId" list="selectListBackgroundImage" listKey="id" listValue="title" theme="xhtml" />
					</table>
				</td>
			</tr>
			<tr>
				<td>
					<table width="100%">
						<tr>
							<td><hr /></td>
						</tr>
					</table>
					<table>
						<tr>
							<td><input type="button" value="<s:text name="resource.cancel"/>"
								onclick="if (!confirmCancel()) {return;} $(this).closest('form').attr('action', '<%=request.getContextPath()%>/modules/webitemsmaintenance/detail.action'); $(this).closest('form').submit();" /></td>
							<td><input type="button" value="<s:text name="resource.submit"/>"
								onclick="if (confirmAction()) {$(this).closest('form').submit();}" /></td>
						</tr>
					</table>
				</td>
			</tr>
		</table>
	</s:form>
</body>
</html>
