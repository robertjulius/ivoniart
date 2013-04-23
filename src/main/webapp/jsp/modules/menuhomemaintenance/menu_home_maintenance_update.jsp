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
			<td class="pageTitle2"><s:text name="resource.page.title2.update" /></td>
		</tr>
	</table>
	<s:form action="/modules/menuhomemaintenance/executeUpdate.action" theme="simple">
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
						<tr>
							<td><b><s:text name="resource.pictures" /></b></td>
						</tr>
						<tbody>
							<s:iterator value="newPictures" status="rowstatus">
								<tr>
									<td><s:select name="listPictures[%{#rowstatus.index}]" id="listPictures[%{#rowstatus.index}]" list="selectListPicture" listKey="id" listValue="title" value="%{newPictures[#rowstatus.index].id}" /></td>
									<td><input type="button" value="Remove" onclick="removeRow($(this))" /></td>
								</tr>
							</s:iterator>
						</tbody>
						<tfoot>
							<tr>
								<td align="center" colspan="2"><input type="button"
									value="Add" onclick="addRow($(this).closest('table'));" /></td>
							</tr>
						</tfoot>
					</table>
				</td>
			</tr>
			<tr>
				<td><hr /></td>
			</tr>
			<tr>
				<td>
					<table>
						<s:textfield key="resource.quickLink1" name="newQuickLink1" theme="xhtml" size="30px" />
						<s:textfield key="resource.quickLink2" name="newQuickLink2" theme="xhtml" size="30px" />
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
								onclick="if (!confirmCancel()) {return;} $(this).closest('form').attr('action', '<%=request.getContextPath()%>/modules/menuhomemaintenance/detail.action'); $(this).closest('form').submit();" /></td>
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
	function removeRow(button) {
		button.closest('tr').remove();
	}

	var rowSize = <s:property value="newPictures.size"/>;
	function addRow(table) {
		var td1 = '<td>';
		td1 += '<select name=listPictures[' + rowSize + '] id=listPictures[' + rowSize + ']>';
		<s:iterator value="selectListPicture" status="rowstatus">
		td1 += '<option value="<s:property value="id"/>"><s:property value="title"/></option>';
		</s:iterator>
		td1 += '</select>';
		td1 += '</td>';
		var td2 = '<td><input type="button" value="Remove" onclick="removeRow($(this))" />';
		
		table.find('tbody:last').append('<tr>' + td1 + td2 + '</tr>');
		++rowSize;
	}
</script>
</html>
