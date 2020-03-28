<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1"%>

<%@ page import="java.sql.*" %> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Welcome</title>
</head>
<body>
<center>
<%! String questionName;

%>
<%
Connection con= null;
PreparedStatement ps = null;
ResultSet rs = null;

String driverName = "com.mysql.jdbc.Driver";
String url = "jdbc:mysql://localhost:3306/studentss1";
String user = "root";
String dbpsw = "root";
String sql = "select `question` from (select `uniroll`, `question` from student1 natural join question_table where Serial_no=question_no) as abc where abc.uniroll=?";
String uniroll=(String)session.getAttribute("uniroll");
int inum = Integer.parseInt(uniroll);


Class.forName(driverName);
con = DriverManager.getConnection(url, user, dbpsw);
ps = con.prepareStatement(sql);
ps.setInt(1,inum);
rs = ps.executeQuery();
//while statemnt se retrieve krna

rs.first();


questionName=rs.getString("question");
%>

<p>Welcome, <%=session.getAttribute("uniroll")%></p><br>
<p>Your First Question is:-</p>
<p> <%=questionName %></p>
<form method="post" class="form-group" action="uploadServlet"
					enctype="multipart/form-data">
					<br>
					<div class="form-group">
						<label for="solution">Upload Your Solution Here:</label> <input
							type="file" name="solution" size="7" />
					</div>
					<br>
					<input type="submit" value="Save" class="btn btn-success">
				</form>
				</center>
<p><a href="logout.jsp">Logout</a></p>
</body>
</html>
