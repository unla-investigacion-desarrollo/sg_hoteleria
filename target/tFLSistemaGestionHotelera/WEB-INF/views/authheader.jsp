

<head>
	<script src=" <c:url value= '/static/js/jquery-1.12.4.js'/>" type="text/javascript"></script>
	<script src=" <c:url value= '/static/js/bootstrap.min.js'/>" type="text/javascript"></script>
</head>


<div class="authbar">
	<span>Welcome <strong>${loggedinuser}</strong></span>
	<span class="floatRight"><a href="<c:url value="/logout" />">Logout</a></span>
	<span class="floatRight"><a href="javascript:window.history.back();">&laquo; Back</a></span>
</div>

<%@include file="menu.jsp" %>


<c:choose>
    <c:when test="${success != null}">
        <div class="alert alert-success lead">
	    	${success}
		</div>
    </c:when>
</c:choose>