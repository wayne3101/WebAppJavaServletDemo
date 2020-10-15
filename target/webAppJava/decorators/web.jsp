<%--
  Created by IntelliJ IDEA.
  User: daoka
  Date: 10/12/2020
  Time: 3:53 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java"  pageEncoding="UTF-8" %>
<%@include file="/common/taglib.jsp"%>

<!doctype html>
<html>
<head>
    <title><dec:title default="Home"/> </title>

    <!-- Bootstrap core CSS -->
    <link href="<c:url value="/template/web/bootstrap/css/bootstrap.min.css"/>" rel="stylesheet" type="text/css" media="all"/>
    <link href="<c:url value="/template/web/css/style.css"/>" rel="stylesheet" type="text/css" media="all"/>
</head>
<body>
    <%--header--%>
    <%@include file="/common/web/header.jsp"%>
    <%--header--%>

    <div class="container">
        <dec:body/>
    </div>


    <%--footer--%>
    <%@include file="/common/web/footer.jsp"%>
    <%--footer--%>

    <script type="text/javascript" src="<c:url value="/template/web/jquery/jquery.min.js" />"></script>
    <script type="text/javascript" src="<c:url value="/template/web/bootstrap/js/bootstrap.bundle.min.js" />"></script>
</body>
</html>
