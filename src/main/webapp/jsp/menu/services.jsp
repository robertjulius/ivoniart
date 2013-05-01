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
div#serviceList {
}

div.serviceItem {
    padding-bottom: 10px;
    padding-top: 10px;
}

div.serviceItemTitle {
	color: white;
	font-weight: bold;
}

div.serviceItemPicture {
	float: left;
	margin-bottom: 5px;
    margin-right: 10px;
    margin-top: 5px;
}

div.serviceItemContent {
}
</style>
</head>
<body>
		<%@include file="/jsp/website/header" %>
			<div id="body">
				<%@include file="/jsp/website/title-picture-content" %>
				<div id="serviceList">
					<s:iterator value="websiteMenu.services" status="rowstatus">
						<div class="serviceItem borderTop">
							<div class="serviceItemPicture imageFrame">
								<img src="<%=request.getContextPath()%>/resources/resource.action?path=images/<s:property value="picture.id" />&resType=image" height="100px"/>
							</div>
							<div class="serviceItemTitle"><s:property value="title" /></div>
							<div class="serviceItemContent"><s:property value="content" escape="false" /></div>
						</div>
					</s:iterator>
				</div>
			</div>
		<%@include file="/jsp/website/footer" %>
</body>
<%@include file="/jsp/website/menu_item_active" %>
</html>
