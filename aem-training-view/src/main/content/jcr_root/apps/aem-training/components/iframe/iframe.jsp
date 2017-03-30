<%--

  IFrame component.

  

--%><%
%><%@include file="/libs/foundation/global.jsp"%><%
%><%@page session="false" %><%
%><%
	// TODO add you code here
%><%@ page import="com.day.cq.wcm.foundation.Placeholder" %>
<cq:text property="text" escapeXml="false"
        placeholder="<%= Placeholder.getDefaultPlaceholder(slingRequest, component, null)%>"/>