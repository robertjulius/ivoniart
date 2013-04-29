<%@page import="com.ganesha.basicweb.model.systemsetting.SystemSetting"%>
<%@page import="com.ganesha.basicweb.utility.PropertiesConstants"%>
		<div id="header">
			<div id="logo">
				<img src="<%=request.getContextPath()%>/resources/resource.action?path=images/<%=SystemSetting.getProperty(PropertiesConstants.WEB_ITEMS_IMAGE_LOGO)%>&resType=image" />
			</div>
			<div id="menuStrip" class="borderTop borderBottom">
				<div id="menuBar">
					<div id="menuItem">
						<a href="<%=request.getContextPath()%>/menu/home.action">Home</a>
					</div>
					<div id="menuItem">
						<a href="<%=request.getContextPath()%>/menu/about.action">About</a>
					</div>
					<div id="menuItem">
						<a href="<%=request.getContextPath()%>/menu/services.action">Services</a>
					</div>
					<div id="menuItem">
						<a href="<%=request.getContextPath()%>/menu/contact.action">Contact</a>
					</div>
				</div>
			</div>
		</div>