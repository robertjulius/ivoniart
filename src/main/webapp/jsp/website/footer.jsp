<%@page import="com.ganesha.basicweb.model.systemsetting.SystemSetting"%>
<%@page import="com.ganesha.basicweb.utility.PropertiesConstants"%>
		<div id="footer" class="borderTop">
			<div id="copyright">
				<%=SystemSetting.getProperty(PropertiesConstants.WEB_ITEMS_COPYRIGHT)%>
			</div>
		</div>