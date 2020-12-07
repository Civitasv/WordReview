<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" >
<title>Insert title here</title>
<link rel="stylesheet" href="css/style.css">
<link rel="stylesheet" type="text/css"
	href="bootstrap/css/bootstrap.min.css">
</head>
<body>
	<div class="holder">
		<div class="new-word">
			<button class="btn btn-default next" style="font-size: 30px;">NEXT</button>
			</br>
			<button class='btn btn-primary' id='mybtn' type='button'
				data-toggle='collapse' data-target='#collapseUse'
				aria-expanded='false' aria-controls='collapseUse'
				style="font-size: 10px;">添加</button>
			<div class='collapse' id='collapseUse'>
				单词<input type="text" class='well form-control' id="word" rows='3'
					style="width: 300px; margin: 0 auto;" /> 翻译<input type="text"
					class='well form-control' id="translation" rows='3'
					style="width: 300px; margin: 0 auto;" />
				<button class='btn btn-success assure' style="font-size: 10px;">确认添加</button>
			</div>
		</div>
	</div>
	<div id="root"></div>
	<script
		src='https://cdnjs.cloudflare.com/ajax/libs/gsap/2.0.2/TweenMax.min.js'></script>


	<script type="text/javascript" src="js/jquery-3.3.1.js"></script>
	<script src="js/index.js"></script>

	<script src="bootstrap/js/bootstrap.min.js"></script>
	<script
		src='https://cdnjs.cloudflare.com/ajax/libs/react/16.7.0/umd/react.production.min.js'></script>
	<script
		src='https://cdnjs.cloudflare.com/ajax/libs/react-dom/16.7.0/umd/react-dom.production.min.js'></script>
	<script
		src='https://cdnjs.cloudflare.com/ajax/libs/styled-components/3.4.10/styled-components.min.js'></script>
	<script src="js/watch.js"></script>
</body>
</html>