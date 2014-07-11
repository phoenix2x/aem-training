<%@include file="/libs/foundation/global.jsp"%>
<%@ taglib prefix="nav" uri="http://aemtraining.example.org/taglibs/aem-training-taglib" %>
<%
%>
<div class="navigation_wrapper">
    <nav:getNav var="navBean"/>
    <div class="header_navigation topnavigation">
        <div class="first_level_wrapper">
            <ul class="first_level">
                <li class="list_item_first_level">
					<a href="${navBean.firstLevel[0].path}.html">
                        <img src="/etc/designs/aem-training/img/logo-white.png" title="EPAM Systems">
                    </a>
                    <c:forEach var="firstLvlLink" items="${navBean.firstLevel}">
                        <li class="list_item_first_level<c:if test="${navBean.currentFirstLevel.path eq firstLvlLink.path}"> current</c:if>">
                	        <a href="${firstLvlLink.path}.html">${firstLvlLink.title}</a>
                            <c:choose>
                                <c:when test="${navBean.currentFirstLevel.path eq firstLvlLink.path}"><div class="arrow"></div></c:when>
                                <c:otherwise><div class="notarrow"></div></c:otherwise>
                            </c:choose>
                        </li>
                    </c:forEach>
            </ul>
        </div>
        <div class="clr"></div>
        <div class="second_level_wrapper">
            <ul class="ul_second_level">
                <li class="list_item_second_level<c:if test="${navBean.currentFirstLevel.path eq currentPage.path}"> current</c:if>">
                    <a class="<c:if test="${navBean.currentFirstLevel.path eq currentPage.path}"> current</c:if>" href="${navBean.currentFirstLevel.path}.html">All</a>
                </li>
                <c:forEach var="secondLevelLink" items="${navBean.secondLevel}">
                <li class="list_item_second_level<c:if test="${secondLevelLink.path eq currentPage.path}"> current</c:if>">
                    <a class="<c:if test="${secondLevelLink.path eq currentPage.path}"> current</c:if>" href="${secondLevelLink.path}.html">${secondLevelLink.title}</a>
                </li>
            </c:forEach>
            </ul>
        </div>
    </div>
</div>