<%--

    This is a simple page component using JSP that extends the foundation page component.

--%>

<%@ include file="/apps/aem-training/components/global.jspx" %>

<body>
    <cq:include path="topnav" resourceType="aem-training/components/topnav"/>
    <cq:include path="par" resourceType="foundation/components/title"/>
    <cq:include path="iframe" resourceType="aem-training/components/iframe"/>
    <cq:include path="par" resourceType="foundation/components/parsys"/>
</body>
