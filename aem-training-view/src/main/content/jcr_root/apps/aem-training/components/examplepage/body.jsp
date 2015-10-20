<%--

    This is a simple page component using JSP that extends the foundation page component.

--%>

<%@ include file="/apps/aem-training/components/global.jspx" %>

<body>
<%--
  <c:set var="include" value="${bindings.include}"/>
  <c:if test="${not empty include}">
        ${include.script}
</c:if>
--%>
    <cq:include path="topnav" resourceType="aem-training/components/topnav"/>
    <cq:include path="par" resourceType="foundation/components/title"/>
        <%--
    <cq:include path="iframe" resourceType="aem-training/components/iframe"/>
        --%>
    <cq:include path="iframe" resourceType="aem-training/components/extendedDialogTest"/>
    <cq:include path="par1" resourceType="foundation/components/parsys"/>
    <div>13</div>
    <div>${bindings.testVar}</div>
    <div>${bindings.testMapVar}</div>

</body>
