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
                    <td><c:out value="${book.id}" /></td>
                    <td><c:out value="${book.author}" /></td>
                    <td><c:out value="${book.title}" /></td>
                    <td><c:out value="${book.genre}" /></td>
                    <td><c:out value="${book.price}" /></td>
                    <td><c:out value="${book.publish_date}" /></td>
                    <td width="200"><c:out value="${book.description}" /></td>
                </tr>
            </c:forEach>

        </table>
    </div>

</body>
</html>
