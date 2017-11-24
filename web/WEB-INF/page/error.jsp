<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Something went wrond :(</title>
</head>
<body>

    <div align="center">

        <h2> <c:out value="${requestScope.errorMessage}" /> </h2>

    </div>

</body>
</html>
