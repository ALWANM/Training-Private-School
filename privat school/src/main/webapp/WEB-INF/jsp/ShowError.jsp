<%-- 
    Document   : ShowError
    Created on : Nov 26, 2017, 5:35:14 PM
    Author     : m-alwan
--%>

<%@page contentType="text/html" pageEncoding="UTF-8" isErrorPage = "true" %>

<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<html>
    <head>
        <title>Show Error Page</title>
    </head>

    <body>
        <h1>Opps...</h1>
        <table width = "100%" border = "1">
            <tr valign = "top">
                <td width = "40%"><b>Error:</b></td>
                <td>${pageContext.exception}</td>
            </tr>

            <tr valign = "top">
                <td><b>URI:</b></td>
                <td>${pageContext.errorData.requestURI}</td>
            </tr>

            <tr valign = "top">
                <td><b>Status code:</b></td>
                <td>${pageContext.errorData.statusCode}</td>
            </tr>

            <tr valign = "top">
                <td><b>Stack trace:</b></td>
                <td>
                    <c:forEach var = "trace" 
                               items = "${pageContext.exception.stackTrace}">
                        <p>${trace}</p>
                    </c:forEach>
                </td>
            </tr>
        </table>

    </body>
</html>