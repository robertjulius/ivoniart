<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<s:head />
<sj:head />
<script type="text/javascript" src="/ivoniart/js/jquery-slides/jquery.slides.min.js"></script>
<link rel="stylesheet" href="/ivoniart/css/ivoniart-jquery-slides.css" type="text/css" />
<link rel="stylesheet" href="/ivoniart/css/ivoniart-website.css" type="text/css" />
<style type="text/css">
div#logoStrip {
	height: 150px;
}

div#logo {
	top: 60px;
}

div#body {
	padding: 0px;
}

div#image {
	margin: 0 auto;
	overflow: hidden;
	width: 800px;
	height: 350px;
	overflow: hidden;
}
</style>
</head>
<body>
		<%@include file="/jsp/website/header" %>
			<div id="body">			
				<div id="image" class="borderRight borderLeft">
					<div id="slides">
						<s:iterator value="menuHome.pictures" status="rowstatus">
							<img src="<%=request.getContextPath()%>/resources/resource.action?path=images/<s:property value="id" />&resType=image" />											
						</s:iterator>
	  				</div>
				</div>
			</div>
		<%@include file="/jsp/website/footer" %>
</body>
<script type="text/javascript">
	$(function() {
		$("#slides").slidesjs({
			play : {
				active : true,
				// [boolean] Generate the play and stop buttons.
				// You cannot use your own buttons. Sorry.
				effect : "slide",
				// [string] Can be either "slide" or "fade".
				interval : 5000,
				// [number] Time spent on each slide in milliseconds.
				auto : true,
				// [boolean] Start playing the slideshow on load.
				swap : true,
				// [boolean] show/hide stop and play buttons
				pauseOnHover : false,
				// [boolean] pause a playing slideshow on hover
				restartDelay : 1000
				// [number] restart delay on inactive slideshow
			}
		});
	});
</script>
<%@include file="/jsp/website/menu_item_active" %>
</html>
