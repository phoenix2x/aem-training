<%@include file="/libs/foundation/global.jsp"%>
<%-- 
    <%@ page import="com.day.cq.wcm.foundation.Placeholder" %>
<cq:text property="text" escapeXml="false"
        placeholder="<%= Placeholder.getDefaultPlaceholder(slingRequest, component, null)%>"/>
--%>
<c:set var="content" value="${sling:getResource(resourceResolver,'/content/geometrixx/en/jcr:content')}" />
<c:set var="myProperties" value="${sling:adaptTo(content,'org.apache.sling.api.resource.ValueMap')}" />
<div>

${myProperties.pageTitle}
</div>