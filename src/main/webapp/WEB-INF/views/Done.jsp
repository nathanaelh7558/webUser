<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<link href='https://fonts.googleapis.com/css?family=Roboto:400,100' rel='stylesheet' type='text/css'>
<head>
	<title>Home</title>
</head>
<style type="text/css">

body {
 background-color: #94d1f0;
}
.body {
	width:60%;
	margin-left: auto;
	margin-right: auto;
	font-family: 'Roboto', sans-serif;	
	height: 550px;
	margin-top: 70px;
}

form {
width: 80%;
margin-left:auto;
margin-right:auto;
}

h1 {
font-size: 2.3em;
font-weight: 400;
color: #fff;
}

a {
color: #fff
 }

</style>

<body>
<div class="body">
<form action="createUser" method="POST" >
<h1>
<p>Welcome, ${msg}</p>
</h1>
<a href="LogIn">Return to login</a>
</form>
</div>
</body>
</html>


