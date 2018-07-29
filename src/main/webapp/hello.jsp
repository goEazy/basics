<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<body>
	Logged In By Harsh!!
	<h3>Message : ${message} </h3>
	<h3>Username : ${username}</h3><br/>
	Click here to <a href="<c:url value="j_spring_logout" />">Logout</a>
</body>
</html>