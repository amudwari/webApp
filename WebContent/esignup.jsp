
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>

<title>edit page</title>
</head>
<body>
<header style="height: 30px;background-color: cyan;">
</header>

<div class =  " container">
        <img alt="" src="img/editpage.png" style="height: 300px;">
		//  <h3>Edit Signup page</h3>


<form action="updateSignup" method = "post">

<label>Username</label>
<input type="text" name="username" value="${signup.username}" class="form-control" style="width: 60%;">

<label>Password</label>
<input type="password" name="password" value="${signup.password}" class="form-control" style="width: 60%;">

<label>Email</label>
<input type="email" name="email" value="${signup.email}" class="form-control" style="width: 60%;">

<label>Name</label>
<input type="text" name="name" value="${signup.name}" class="form-control" style="width: 60%;">

<label>Mobile</label>
<input type="number" name="mobile" value="${signup.mobile}" class="form-control" style="width: 60%;">

<label>Gender</label>
<select name = "gender" class="form-control" style="width:60%;">
	<option ${signup.gender=='Male'?'selected':''}> Male </option>
	<option ${signup.gender=='Female'?'selected':''}> Female </option>
	<option ${signup.gender=='Other'?'selected':''}> Other </option>

</select>
 <hr/>

<button type="submit" class="btn btn-primary">Update Signup</button>

<a href = "signups">
<button type="button" class="btn btn-danger">Back</button>
</a>


</form>

</div>

</body>
</html>