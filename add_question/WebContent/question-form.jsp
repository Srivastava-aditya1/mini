<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>User Management Application</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
</head>
<body>

	<header>
		<nav class="navbar navbar-expand-md navbar-dark"
			style="background-color: tomato">
			<div>
				<a href="https://www.javaguides.net" class="navbar-brand">Student Management System </a>
			</div>

			<ul class="navbar-nav">
				<li><a href="<%=request.getContextPath()%>/list"
					class="nav-link">Questions</a></li>
			</ul>
		</nav>
	</header>
	<br>
	<div class="container col-md-5">
		<div class="card">
			<div class="card-body">
				<c:if test="${question!= null}">
					<form action="update" method="post">
				</c:if>
				<c:if test="${question == null}">
					<form action="insert" method="post">
				</c:if>

				<caption>
					
						<c:if test="${question != null}">
            			Edit Question
            			
            		</c:if>
						<c:if test="${question == null}">
            			Add New Question
            		</c:if>
					
				</caption>

				
				<fieldset class="form-group">
					<label>Question</label> <input type="text"
						value="<c:out value='${question.question}' />" class="form-control"
						name="question" required="required">
				</fieldset>
				
				

				

				

				<button name="id" type="submit" class="btn btn-success" value='${question.question_no}'>Save</button>
				</form>
				
			</div>
		</div>
	</div>
</body>
</html>
