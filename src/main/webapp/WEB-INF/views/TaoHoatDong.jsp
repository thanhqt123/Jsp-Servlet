<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
<title>Tao hoat dong</title>
</head>
<body>
	<div class="container">
		<h2>Tạo mới hoạt động</h2>
		<form action="${pageContext.request.contextPath}/hoatDong" method="post">
			<div class="form-group">
				<label for="id">ID:</label> <input type="tel" class="form-control"
					id="id" placeholder="Nhập id" name="id">
			</div>
			<div class="form-group">
				<label for="tenHd">Tên Hoạt động:</label> <input type="text"
					class="form-control" id="tenHd" placeholder="Nhập tên hoạt động"
					name="tenHd">
			</div>
			<div class="form-group">
				<label for="email">Email:</label> <input type="email"
					class="form-control" id="email" placeholder="Nhập email"
					name="email">
			</div>
			<div class="form-group">
				<label for="gioitinh">Chọn giới tính</label> <select
					class="form-control" id="gioitinh" name="gioitinh">
					<option>Nam</option>
					<option>Nữ</option>
				</select>

			</div>
			<div style="margin-top: 10px" class="form-group">
				<label for="ngaySinh">Ngày sinh:</label> <input class="form-control"
					type="date" id="ngaySinh" name="ngaySinh">
			</div>
			<button type="submit" class="btn btn-primary">Tạo</button>
		</form>
	</div>
</body>
</html>