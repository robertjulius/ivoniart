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
		<table>
			<tr>
				<td><img src="<%=request.getContextPath()%>/resources/resource.action?path=images/<s:property value="old.picture.id" />&resType=image" height="100px" class="imageFrame" /></td>
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
						<tr>
							<td align="right"><b><s:text name="resource.picture" /></b></td>
							<td>:</td>
							<td align="left"><s:property value="old.picture.title" /></td>
						</tr>
						<tr>
							<td align="right"><b><s:text name="resource.title" /></b></td>
							<td>:</td>
							<td align="left"><s:property value="old.title" /></td>
						</tr>
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
							<td align="left" colspan="2">
								<table>
									<tr>
										<td><b><s:text name="resource.services" /></b></td>
									</tr>
									<s:iterator value="old.services" status="rowstatus">
										<tr>
											<td>&#149; <s:property value="title" /></td>
										</tr>
									</s:iterator>
								</table>
							</td>
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
								onclick="$(this).closest('form').attr('action', '<%=request.getContextPath()%>/modules/menuservicesmaintenance/prepareUpdate.action'); $(this).closest('form').submit();" /></td>
						</tr>
					</table>
				</td>
			</tr>
		</table>
	</s:form>
</body>
</html>
