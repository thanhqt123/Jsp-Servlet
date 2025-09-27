<%@ taglib
	uri="http://java.sun.com/jsp/jstl/core"
	prefix="c"
%>
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
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-sRIl4kxILFvY47J16cr9ZwB07vP4J8+LH7qKQnuqkuIAvNWLzeN8tE5YBujZqJLB"
	crossorigin="anonymous"
>
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-FKyoEForCGlyvwx9Hj09JcYn3nv7wiPVlz7YYwJrWVcXK/BmnVDxM+D2scQbITxI"
	crossorigin="anonymous"
></script>
<script
	src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.8/dist/umd/popper.min.js"
	integrity="sha384-I7E8VVD/ismYTF4hNIPjVp/Zjvgyol6VFvRkX/vR+Vc4jQkC+hVqc2pM8ODewa9r"
	crossorigin="anonymous"
></script>
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/js/bootstrap.min.js"
	integrity="sha384-G/EV+4j2dNv+tEPo3++6LCgdCROaejBqfUeNjuKAiuXbjrxilcCdDz6ZAVfHWe1Y"
	crossorigin="anonymous"
></script>
<title>Tao hoat dong</title>
</head>
<body>
	<style>
.group {
	padding: 20px 0;
}
</style>
	<nav class="navbar navbar-expand-lg bg-body-tertiary">
		<div class="container-fluid">
			<div
				class="collapse navbar-collapse"
				id="navbarSupportedContent"
			>
				<ul class="navbar-nav me-auto mb-2 mb-lg-0">
					<li class="nav-item">
						<a
							class="nav-link active"
							aria-current="page"
							href="#"
						>Home </a>
					</li>
					<li class="nav-item">
						<a
							class="nav-link"
							href="TaoHoatDong.jsp"
						>Tạo hoạt động</a>
					</li>
					<li class="nav-item dropdown">
						<a
							class="nav-link dropdown-toggle"
							href="#"
							role="button"
							data-bs-toggle="dropdown"
							aria-expanded="false"
						> Dropdown </a>
						<ul class="dropdown-menu">
							<li>
								<a
									class="dropdown-item"
									href="#"
								>Action</a>
							</li>
							<li>
								<a
									class="dropdown-item"
									href="#"
								>Another action</a>
							</li>
							<li>
								<hr class="dropdown-divider">
							</li>
							<li>
								<a
									class="dropdown-item"
									href="#">
									Something else here</a>
							</li>
						</ul>
					</li>
					<li class="nav-item">
						<a
							class="nav-link disabled"
							aria-disabled="true"
						>Disabled</a>
					</li>
				</ul>
				<form
					class="d-flex"
					role="search"
				>
					<input
						class="form-control me-2"
						type="search"
						placeholder="Search"
						aria-label="Search"
					/>
					<button
						class="btn btn-outline-success"
						type="submit"
					>Search</button>
				</form>
			</div>
		</div>
	</nav>
	<div class="container">
		<h2>Tạo mới hoạt động</h2>
		<form
			action="${pageContext.request.contextPath}/taoHoatDong"
			method="post"
		>
			<div class="row">
				<div class="col-sm-6">
					<div class="form-group">
						<label for="nameAcv">Tên Hoạt động:</label>
						<input
							type="text"
							class="form-control"
							id="nameAcv"
							name="nameAcv"
							value="${tenHd}"
							placeholder="Nhập tên hoạt động"
						>
					</div>
					<div class="form-group">
						<label for="descAcv">Mô tả hoạt động:</label>
						<input
							type="text"
							class="form-control"
							id="descAcv"
							name="descAcv"
							value="${moTaHd}"
							placeholder="Nhập mô tả hoạt động"
						>
					</div>
					<div class="form-group">
						<label for="startDate">Ngày giờ bắt đầu:</label>
						<input
							type="datetime-local"
							class="form-control"
							id="startDate"
							name="startDate"
							value="${ngayBatDau}"
						>
					</div>
					<div class="form-group">
						<label for="endDate">Ngày giờ kết thúc:</label>
						<input
							type="datetime-local"
							class="form-control"
							id="endDate"
							name="endDate"
							value="${ngayKetThuc}"
						>
					</div>
					<div class="form-group">
						<label for="idMember">Mã trưởng đoàn:</label>
						<input
							type="text"
							class="form-control"
							id="idMember"
							name="idMember"
							value="${idMember}"
							placeholder="Nhập mã trưởng đoàn"
						>
					</div>
				</div>
				<div class="col-sm-6">
					<div class="form-group">
						<label for="maxQuantity">Số lượng tối đa:</label>
						<input
							type="number"
							class="form-control"
							id="maxQuantity"
							name="maxQuantity"
							value="${soLuongMax}"
						>
					</div>
					<div class="form-group">
						<label for="expiredRegis">Thời hạn đăng ký:</label>
						<input
							type="datetime-local"
							class="form-control"
							id="expiredRegis"
							name="expiredRegis"
							value="${thoiHanDk}"
						>
					</div>
					<div class="form-group">
						<label for="statusAcv">Trạng thái:</label>
						<input
							type="text"
							class="form-control"
							id="statusAcv"
							name="statusAcv"
							value="${status}"
						>
					</div>
					<div class="form-group">
						<label for="minQuantity">Số lượng tối thiểu:</label>
						<input
							type="number"
							class="form-control"
							id="minQuantity"
							name="minQuantity"
							value="${soLuongMin}"
						>
					</div>
				</div>
			</div>
			<button
				type="submit"
				class="btn btn-primary"
			>Tạo</button>
		</form>
		<c:if test="${not empty error}">
			<div style="color: red">${error}</div>
		</c:if>
	</div>
</body>
</html>