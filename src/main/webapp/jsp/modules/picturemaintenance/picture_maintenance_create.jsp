<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>
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
			<td class="pageTitle1"><s:text name="resource.page.title.pictureMaintenance" /></td> 
		</tr>
		<tr>
			<td class="pageTitle2"><s:text name="resource.page.title2.create" /></td>
		</tr>
	</table>
	<s:form action="/modules/picturemaintenance/validateCreate.action" theme="simple" enctype="multipart/form-data">
		<table>
			<tr>
				<td><img src="<%=request.getContextPath()%>/resources/resource.action?path=images/no-image.jpg" height="300px" class="imageFrame" /></td>
			</tr>
		</table>
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
						<s:file name="fileUpload" label="Picture File" theme="xhtml" size="35px" />
						<s:textfield key="resource.title" name="newTitle" theme="xhtml" size="30px" />
						<s:textfield key="resource.comment" name="newComment" theme="xhtml" size="30px" />
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
								onclick="if (!confirmCancel()) {return;} $(this).closest('form').attr('action', '<%=request.getContextPath()%>/modules/picturemaintenance/main.action'); $(this).closest('form').submit();" /></td>
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
