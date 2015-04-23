<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@ page import="java.io.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Application Error</title>
</head>
<body>
<pre style="color: red;">
There was a problem on your action.
Please press your browser's back button and try again.
If the problem persists, contact Support.
</pre>
<div>
Message:
${exception.message}
<br/>
	<a href="/code-challenge/">Return to Home</a>
</body>
</html>