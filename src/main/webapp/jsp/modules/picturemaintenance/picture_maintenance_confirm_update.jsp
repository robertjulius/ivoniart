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
			<td class="pageTitle2"><s:text name="resource.page.title2.confirmUpdate" /></td>
		</tr>
	</table>
	<s:form action="/modules/picturemaintenance/executeUpdate.action" theme="simple">
		<s:if test="hasActionErrors()">
			<table>
				<s:actionerror />
				<s:fielderror />
			</table>
		</s:if>
		<table class="form">
			<tr>
				<td>
					<table class="grid" id="grid1">
						<thead>
							<tr>
								<td colspan="2"><s:text name="resource.oldValue" /></td>
							</tr>
						</thead>
						<tbody>
							<tr>
								<td align="right" width="100px"><s:text name="resource.description" /></td>
								<td align="left" width="300px"><s:label name="old.description" /></td>
							</tr>
							<tr>
								<td align="right" width="100px"><s:text name="resource.comment" /></td>
								<td align="left" width="300px"><s:label name="old.comment" /></td>
							</tr>
						</tbody>
					</table>
				</td>
			</tr>
			<tr>
				<td>
					<table class="grid" id="grid2">
						<thead>
							<tr>
								<td colspan="2"><s:text name="resource.newValue" /></td>
							</tr>
						</thead>
						<tbody>
							<tr>
								<td align="right" width="100px"><s:text name="resource.description" /></td>
								<td align="left" width="300px"><s:label name="newDescription" /></td>
							</tr>
							<tr>
								<td align="right" width="100px"><s:text name="resource.comment" /></td>
								<td align="left" width="300px"><s:label name="newComment" /></td>
							</tr>
						</tbody>
					</table>
				</td>
			</tr>
			<tr>
				<td>
					<table>
						<tr>
							<td><input type="button" value="<s:text name="resource.back"/>"
								onclick="$(this).closest('form').attr('action', '<%=request.getContextPath()%>/modules/picturemaintenance/formUpdate.action'); $(this).closest('form').submit();" /></td>
							<td><input type="button" value="<s:text name="resource.submit"/>"
								onclick="$(this).closest('form').submit();" /></td>
						</tr>
					</table>
				</td>
			</tr>
		</table>
	</s:form>
</body>
<script type="text/javascript">
	window.onload = function() {
		stripeTable($('table#grid1'));
		stripeTable($('table#grid2'));
	}
</script>
</html>
