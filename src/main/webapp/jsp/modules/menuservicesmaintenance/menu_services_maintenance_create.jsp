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
			<td class="pageTitle2"><s:text name="resource.page.title2.create" /></td>
		</tr>
	</table>
	<s:form action="/modules/menuservicesmaintenance/validateCreate.action" theme="simple">
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
						<s:select key="resource.picture" name="newPictureId" id="newPictureId" list="selectListPicture" listKey="id" listValue="title" theme="xhtml" />
						<s:hidden name="newPictureTitle" id="newPictureTitle" />
						<s:textfield key="resource.title" name="newTitle" theme="xhtml" size="30px" />
						<s:textfield key="resource.content" name="newContent" theme="xhtml" size="30px" />
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
							<td><b><s:text name="resource.services" /></b></td>
						</tr>
						<tbody>
							<s:iterator value="newServices" status="rowstatus">
								<tr>
									<td><s:textfield name="listAccessPaths[%{#rowstatus.index}].id" value="%{newServices[#rowstatus.index].id}" size="50px" /></td>
									<td><input type="button" value="Remove" onclick="removeRow($(this))" /></td>
								</tr>
							</s:iterator>
						</tbody>
						<tfoot>
							<tr>
								<td align="center" colspan="2"><input type="button" value="Add" onclick="addRow($(this).closest('table'));" /></td>
							</tr>
						</tfoot>
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
								onclick="if (!confirmCancel()) {return;} $(this).closest('form').attr('action', '<%=request.getContextPath()%>/modules/menuservicesmaintenance/main.action'); $(this).closest('form').submit();" /></td>
							<td><input type="button" value="<s:text name="resource.submit"/>"
								onclick="if (confirmAction()) {$(this).closest('form').submit();}" /></td>
						</tr>
					</table>
				</td>
			</tr>
		</table>
	</s:form>
</body>
<script type="text/javascript">
	$(function() {
		$('#newPictureId').change(
				function() {
					$('#newPictureTitle').val(
							$(this).children("option").filter(":selected")
									.text());
				});
	});
	
	function removeRow(button) {
		button.closest('tr').remove();
	}

	var rowSize = <s:property value="newServices.size"/>;
	function addRow(table) {
		var td1 = '<td><input type="text" name="listServices[' + rowSize + ']" size="50px" /></td>';
		var td2 = '<td><input type="button" value="Remove" onclick="removeRow($(this))" />';
		table.find('tbody:last').append('<tr>' + td1 + td2 + '</tr>');
		++rowSize;
	}
</script>
</html>
