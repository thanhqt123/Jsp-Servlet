<%@ page
	language="java"
	contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link
	rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css"
>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
<title>Tao hoat dong</title>
</head>
<body>
	<style>
.group {
	padding: 20px 0;
}
</style>
	<div class="container">

		<h2>Tạo mới hoạt động</h2>
		<form
			action="${pageContext.request.contextPath}/hoatDong"
			method="post"
		>
			<div class="row">
				<!-- col-1 -->
				<div class="col-sm-6">
					<div class="form-group">
						<label for="nameAcv">Tên Hoạt động:</label> <input
							type="text"
							class="form-control"
							id="nameAcv"
							placeholder="Nhập tên hoạt động"
							name="nameAcv"
						>
					</div>
					<div class="form-group">
						<label for="descAcv">Mô tả hoạt động:</label> <input
							type="text"
							class="form-control"
							id="descAcv"
							placeholder="Nhập mô tả hoạt động"
							name="descAcv"
						>
					</div>
					<div class="form-group">
						<label for="startDate">Ngày giờ bắt đầu:</label> <input
							type="datetime-local"
							class="form-control"
							id="startDate"
							placeholder="Nhập ngày giờ bắt đầu"
							name="startDate"
						>

					</div>
					<div class="form-group">
						<label for="endDate">Ngày giờ kết thúc:</label> <input
							type="datetime-local"
							class="form-control"
							id="endDate"
							placeholder="Nhập ngày giờ kết thúc"
							name="endDate"
						>

					</div>
					<!-- <div class="form-group">
						<label for="idMember">Mã trưởng đoàn:</label> <input
							type="text"
							class="form-control"
							id="idMember"
							placeholder="Nhập mã trưởng đoàn"
							name="idMember"
						>

					</div> -->

				</div>
				<!-- col-2 -->
				<div class="col-sm-6">
					<div class="form-group">
						<label for="maxQuantity">Số lượng tối đa:</label> <input
							class="form-control"
							type="number"
							id="maxQuantity"
							name="maxQuantity"
						>
					</div>
					<div class="form-group">
						<label for="expiredRegis">Thời hạn đăng ký</label> <input
							type="datetime-local"
							class="form-control"
							id="expiredRegis"
							placeholder="Nhập ngày giờ kết thúc đăng ký"
							name="expiredRegis"
						>

					</div>
					<div class="form-group">
						<label for="statusAcv">Trạng thái</label> <input
							type="text"
							class="form-control"
							id="statusAcv"
							name="statusAcv"
							value="Đang mời đăng ký"
						>

					</div>
					<div class="form-group">
						<label for="minQuantity">Số lượng tối thiểu:</label> <input
							class="form-control"
							type="number"
							id="minQuantity"
							name="minQuantity"
						>
					</div>
				</div>
			</div>



			<button
				type="submit"
				class="btn btn-primary"
			>Tạo</button>
		</form>
	</div>
</body>
</html>