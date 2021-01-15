<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Obrazy</title>
    <!-- CSS only -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-giJF6kkoqNQ00vy+HMDP7azOuL0xtbfIcaT9wjKHr8RbDVddVHyTfAAsrekwKmP1" crossorigin="anonymous">

    <link rel="stylesheet" href="css/main.css"/>
</head>
<body>

<div class="container">
    <form action="paintings" class="row">
        <input class="form-control" name="paintingName" value="${param.paintingName}"/>
        <button type="submit" class="btn btn-primary">Szukaj</button>
    </form>


    <c:forEach var="painting" items="${paintings}">

        <div class="row">
            <div class="col-sm-6">
                <h3 class="${painting.getYear() < 1900 ? 'old' : ''}">${painting.getName()}</h3>

                <c:if test="${painting.getYear() <= 1900}">
                    <div>${painting.getAuthor()}</div>
                </c:if>


                <div>${painting.getYear()}</div>
            </div>
            <div class="col-sm-6">
                <img src="${painting.getUrl()}" width="150px"/>
            </div>
        </div>

    </c:forEach>
</div>

</body>
</html>




