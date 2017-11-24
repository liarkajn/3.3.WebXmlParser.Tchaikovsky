<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Main page</title>
</head>
<body>

<div align="center">
    <table border="1">
        <thead>
        <tr>
            <td>ID</td>
            <td>Author</td>
            <td>Title</td>
            <td>Genre</td>
            <td>Price</td>
            <td>Publish date</td>
            <td>Description</td>
        </tr>
        </thead>
        <c:forEach items="${requestScope.bookList}" var="book">
            <tr>
                <td><c:out value="${book.id}"/></td>
                <td><c:out value="${book.author}"/></td>
                <td><c:out value="${book.title}"/></td>
                <td><c:out value="${book.genre}"/></td>
                <td><c:out value="${book.price}"/></td>
                <td><c:out value="${book.publish_date}"/></td>
                <td width="200"><c:out value="${book.description}"/></td>
            </tr>
        </c:forEach>

    </table>
</div>

<div align="center">

    <c:forEach begin="0" end="3" var="i">
        <c:set var="pageNumber" value="${requestScope.page + i - 3}" />
        <c:if test="${pageNumber > 0}">
            <a href="main?page=<c:out value="${pageNumber}" />&&parserType=${requestScope.parserType}&&command=${requestScope.command}"><c:out
                    value="${pageNumber}"/></a>
        </c:if>

    </c:forEach>

    <c:forEach begin="1" end="3" var="i">
        <c:set var="pageNumber" value="${i + requestScope.page}" />
        <c:if test="${pageNumber <= requestScope.totalPages}">
            <a href="main?page=<c:out value="${pageNumber}" />&&parserType=${requestScope.parserType}&&command=${requestScope.command}"><c:out
                    value="${pageNumber}"/></a>
        </c:if>
    </c:forEach>

</div>

</body>
</html>
