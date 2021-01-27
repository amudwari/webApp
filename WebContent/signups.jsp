
<!DOCTYPE html>
<%@page import="com.signup.Signup"%>
<%@page import="java.util.List"%>
<html>
<head>
<meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
<title>signups page</title>
</head>
<body>
<header style="height: 30px;background-color: yellow;">
</header>

<div class =  " container">
        <img alt="" src="img/hands.jpg" style="height: 300px;">
		//  <h3>Data:</h3>

         <%
            //this called jsp scriptlet tag
            //where we can write all java code inside jsp pages

            List<Signup> signups=(List<Signup>)request.getAttribute("psignups");
         %>

  <table class="table">
 	 <thead>
  	   <tr>
        <th>Username</th>
        <th>Password</th>
        <th>Email</th>
        <th>Name</th>

        <th>Mobile</th>
        <th>Gender</th>
        <th>Action </th>
      </tr> 
    </thead>
		<tbody>
		
		<% 
		for(Signup s: signups){
			%>
		
		<tr> 
			<td><%=s.getUsername()%></td>		
			<td><%=s.getPassword()%></td>		
			<td><%=s.getEmail()%></td>
			<td><%=s.getName()%></td>		

			<td><%=s.getMobile()%></td>		
			<td><%=s.getGender()%></td>		
			
			<td>

			  <a href="deleteSignup?ddata=<%=s.getEmail()%>">
            <img alt="" src="img/del.png" style="width:8%;" >
            </a>
		 &nbsp;
			  <a href="editSignup?ddata=<%=s.getEmail()%>">
            <img alt="" src="img/edit.png" style="width: 8%;" >
            </a>
          </td>
					
         </tr> 
         
         <%
		}
		%>
             
	</tbody>
	</table>
</div>

</body>
</html>