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
			<td class="pageTitle1"><s:text name="resource.page.title" /></td> 
		</tr>
		<tr>
			<td class="pageTitle2"><s:text name="resource.page.title2.detail" /></td>
		</tr>
	</table>
	<s:form theme="simple">
		<s:if test="hasActionErrors()">
			<table>
				<s:actionerror />
				<s:fielderror />
			</table>
		</s:if>
		<table class="form">
			<tr>
				<td>
					<table class="grid">
						<thead>
							<tr>
								<td colspan="2"><s:text name="resource.menuContactInformation" /></td>
							</tr>
						</thead>
						<tbody>
							<tr>
								<td align="right" width="100px"><b><s:text name="resource.title" /></b></td>
								<td align="left" width="300px"><s:property value="old.title" /></td>
							</tr>
							<tr>
								<td align="right" width="100px"><b><s:text name="resource.address" /></b></td>
								<td align="left" width="300px"><s:property value="old.address" /></td>
							</tr>
							<tr>
								<td align="right" width="100px"><b><s:text name="resource.phone" /></b></td>
								<td align="left" width="300px"><s:property value="old.phone" /></td>
							</tr>
							<tr>
								<td align="right" width="100px"><b><s:text name="resource.email" /></b></td>
								<td align="left" width="300px"><s:property value="old.email" /></td>
							</tr>
						</tbody>
					</table>
				</td>
			</tr>
			<tr>
				<td><hr /></td>
			</tr>
			<tr>
				<td>
					<table width="500px">
						<tr style="white-space: normal;">
							<td><s:property value="old.content" escape="false" /></td>
						</tr>
					</table>
				</td>
			</tr>
			<tr>
				<td><hr /></td>
			</tr>
			<tr>
				<td>
					<table>
						<tr>
							<td><input type="button" value="<s:text name="resource.edit"/>"
								onclick="$(this).closest('form').attr('action', '<%=request.getContextPath()%>/modules/menucontactmaintenance/prepareUpdate.action'); $(this).closest('form').submit();" /></td>
						</tr>
					</table>
				</td>
			</tr>
		</table>
	</s:form>
</body>
<script type="text/javascript">
	window.onload = function() {
		stripeTable($('table.grid'));
	}
</script>
</html>
