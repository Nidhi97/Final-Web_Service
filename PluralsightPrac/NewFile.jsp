<%@ page import="java.sql.*" %>
<%@ page import="javax.sql.*" %>
<%@ page import="java.io.*" %>
<%@ page import="javax.servlet.*" %>
<%@ page import="javax.servlet.http.*" %>
 
<% 	
	PrintWriter out1=response.getWriter();
	out1.println("<h1> Record successfully inserted </h1>");
	Class.forName("com.mysql.jdbc.Driver");
        String jdbcUrl = "jdbc:mysql://localhost:3306/mysampledb";
        String username = "root";
        String password = "Nidhi@97"; 
    	Connection connection = null;   
    	connection = DriverManager.getConnection(jdbcUrl, username, password);
    	Statement statement = connection.createStatement();
	String x=request.getParameter("ename");
	String y=request.getParameter("dept");
	String sql = "insert into emp values ('"+x+"','"+y+"')";
      	statement.executeUpdate(sql);	
	RequestDispatcher rd=request.getRequestDispatcher("form.html");  
        rd.include(request, response);  
%>
