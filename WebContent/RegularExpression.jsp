<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style>
.container {
	display: flex;
}

.error-msg {
	display: none;
	color: red;
}
</style>
</head>
<body>

	<div class="container">
		<form  >

			<input type="text" name="username" class="username" id="username"
				required placeholder="User Name">
			<p class="error-msg" id="error">Enter a valid password</p>
			<input type="text" class="password" id="password" required
				placeholder="Password" onchange="checkpassword()"> <input type="submit" class="submit"
				value="submit">

		</form>
	</div>

	<script>

   // const errorMsg=document.getElementById('error').innerHTML;
    const errorMsg=document.querySelector('.error-msg');
const reg=/^[a-zA-Z]{4}$/;

// \w [a-zA-Z0-9] 2


		 function checkpassword()
		{
			 const password=document.getElementById('password').value;
			const isValid=reg.test(password)
			
			if(isValid)
				{
				//console.log('valid username')
				errorMsg.style.display='none'
					alert("condition: "+isValid );
				}
			else
				{
				//console.log('invalid username')
				errorMsg.style.display='block'
				document.querySelector('.submit').style.disabled=false
					alert("condtion: "+isValid );
				}
		}

</script>
</body>
</html>