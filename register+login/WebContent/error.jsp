<html>

<head>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<title>Login Error</title>

</head>

<body>

<p style="color:red">Sorry, your record is not available.</p>

<%

getServletContext().getRequestDispatcher("/index.jsp").include(request, 
response);

%>

</body>

</html>