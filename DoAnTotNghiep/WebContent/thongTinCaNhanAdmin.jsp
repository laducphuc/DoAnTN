<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>
<%@ taglib uri="http://struts.apache.org/tags-tiles" prefix="tiles"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Website Tin tức - Dịch Thuật Việt Nhật</title>

<link rel="stylesheet" href="css/songnguvietnhat3.css">
<link rel="stylesheet" href="css/bootstrap.min.css">
<link rel="stylesheet" href="css/style.css" />
<link rel="stylesheet"
	href="font-awesome-4.4.0/css/font-awesome.min.css">
<link rel="stylesheet" href="css/fileinput.css">
<script src="js/jquery-1.11.2.min.js"></script>
<script src="js/bootstrap.min.js"></script>
<script src="js/fileinput.js"></script>
<script type="text/javascript" src="js/main.js"></script>
<script type="text/javascript" src="js/my-include.js"></script>
<script type="text/javascript" src="js/my-carousel.js"></script>
<script type="text/javascript" src="js/fix-menu.js"></script>
<link rel="stylesheet" href="css/songnguok.css" type="text/css">
</head>
<body>
	<!-- header -->
	<div class="include" data-include="header"></div>

	<!-- menu -->
	<div id="tabMenu" class="col-lg-12 tabMenu" style="padding: 0px;">
		<div id="menuItems" class="col-lg-12">
			<ul>
				<li><a href="trang-gioi-thieu.do">Giới thiệu</a></li>
				<li><html:link action="/trang-chu.do">Trang chủ</html:link></li>
				<li class="dropdown"><a class="dropdown-toggle"
					data-toggle="dropdown" href="#">Danh Mục Bài Viết <span
						class="caret"></span></a>
					<ul class="dropdown-menu" style="text-align: left">
						<li><html:link
								action="/trang-chu.do?maDanhMuc=DM00000001&kiemTra=1"
								style="text-align: left">Xã Hội</html:link></li>
						<li><html:link
								action="/trang-chu.do?maDanhMuc=DM00000002&kiemTra=1"
								style="text-align: left">Thế Giới</html:link></li>
						<li><html:link
								action="/trang-chu.do?maDanhMuc=DM00000003&kiemTra=1"
								style="text-align: left">Giáo Dục</html:link></li>
						<li><html:link
								action="/trang-chu.do?maDanhMuc=DM00000004&kiemTra=1"
								style="text-align: left">Công Nghệ</html:link></li>
						<li><html:link
								action="/trang-chu.do?maDanhMuc=DM00000005&kiemTra=1"
								style="text-align: left">Thể Thao</html:link></li>
						<li><html:link
								action="/trang-chu.do?maDanhMuc=DM00000006&kiemTra=1"
								style="text-align: left">Giải Trí</html:link></li>
						<li><html:link
								action="/trang-chu.do?maDanhMuc=DM00000007&kiemTra=1"
								style="text-align: left">Sức Khỏe</html:link></li>
					</ul></li>

				<logic:notEmpty name="dangNhapForm" property="taiKhoan"
					scope="session">
					<bean:define id="taikhoan" name="dangNhapForm" property="taiKhoan"
						scope="session"></bean:define>
					<li class="dropdown pull-right"><a class="dropdown-toggle"
						dropdown-toggle="dropdown" href="#"> <bean:define id="anh"
								name="taikhoan" property="anh"></bean:define> <html:img
								src="avata/${anh }" styleClass="img-circle"
								style="width: 40px; height:40px" /> <bean:write name="taikhoan"
								property="tenThanhVien" /> <span class="caret"></span></a>

						<ul class="dropdown-menu">
							<li><html:link action="/danh-sach-thanh-vien.do">Quản trị</html:link></li>
							<li><html:link action="/thong-tin-admin.do">Thông tin cá nhân</html:link></li>
							<li><html:link action="/dang-xuat.do">Đăng xuất</html:link></li>
						</ul></li>
				</logic:notEmpty>
			</ul>
		</div>
	</div>

	<!-- body -->

	<div class="col-lg-offset-2 col-lg-8" style="margin-top: 50px">
		<div class="panel panel-default">
			<div class="panel-heading">
				<div class="panel-title" style="text-align: center">
					<label>Chỉnh sửa thông tin cá nhân</label>
				</div>
			</div>
			<div class="panel-body">
				<html:form action="/thong-tin-admin.do" method="post" enctype="multipart/form-data">
					<div class="col-lg-12">
						<div class="col-lg-6">
							<div class="col-lg-12">
								<label><i class="fa fa-user"></i> Cập nhật tên hiển thị
									: </label>
								<bean:define id="taiKhoan" name="dangNhapForm"
									property="taiKhoan" scope="session" />
								<label><bean:write property="tenThanhVien"
										name="taiKhoan" /> </label>
							</div>
							<div class="col-lg-12">
								<html:text styleClass="form-control" property="tenThanhVien"
									name="thanhVienForm"></html:text>
							</div>
							<div class="col-lg-12" style="text-align:center">
								<label style="color: red"><bean:write
										property="tenThanhVienLoi" name="thanhVienForm" /> </label>
							</div>
						</div>
						<div class="col-lg-6">
							<div class="col-lg-12">
								<label><i class="fa fa-file-image-o"></i> Cập nhật ảnh
									đại diện</label>
							</div>
							<div class="col-lg-8">
								<html:file styleId="input-1" styleClass="file" accept="image/*"
									property="file"></html:file>
							</div>
						</div>
					</div>
					<div class="col-lg-12" style="text-align: center; margin-top: 30px">
						<html:submit styleClass="btn btn-info" property="submit">Cập nhật thông tin</html:submit>
					</div>
				</html:form>
			</div>
		</div>
	</div>

	<div class="col-lg-offset-2 col-lg-8" style="margin-top: 50px">
		<div class="panel panel-default">
			<div class="panel-heading">
				<div class="panel-title" style="text-align: center">
					<label>Đổi mật khẩu</label>
				</div>
			</div>
			<div class="panel-body">
				<html:form action="/thong-tin-admin.do">
					<div class="col-lg-12">
						<div class="col-lg-3">
							<label><i class="fa fa-key"></i> Mật khẩu hiện tại</label>
						</div>
						<div class="col-lg-9">
							<html:password styleClass="form-control" property="matKhauCu"></html:password>
						</div>
					</div>
					<div class="col-lg-12" style="height: 50px; text-align: center">
						<label style="color: red"><bean:write name="thanhVienForm"
								property="matKhauLoi" /></label>
					</div>
					<div class="col-lg-12">
						<div class="col-lg-3">
							<label><i class="fa fa-question-circle"></i> Mật khẩu mới
							</label>
						</div>
						<div class="col-lg-9">
							<html:password styleClass="form-control" property="matKhauMoi"></html:password>
						</div>
					</div>
					<div class="col-lg-12" style="height: 50px; text-align: center">
						<label style="color: red"><bean:write name="thanhVienForm"
								property="matKhauMoiLoi" /> </label>
					</div>
					<div class="col-lg-12">
						<div class="col-lg-3">
							<label><i class="fa fa-question-circle"></i> Xác nhận mật
								khẩu mới </label>
						</div>
						<div class="col-lg-9">
							<html:password styleClass="form-control"
								property="nhapLaiMatKhau"></html:password>
						</div>
					</div>
					<div class="col-lg-12" style="height: 50px; text-align: center">
						<label style="color: red"><bean:write name="thanhVienForm"
								property="nhapLaiMatKhauLoi" /> </label>
					</div>
					<div class="col-lg-12" style="text-align: center">
						<html:submit property="submit" styleClass="btn btn-info">Đổi mật khẩu</html:submit>
					</div>
				</html:form>
			</div>
		</div>
	</div>

	<div class="include" data-include="footer"></div>

	<script type="text/javascript">
		$("#input-1").fileinput({
			showUpload : false,
			showRemove : false,
			browseLabel : "Duyệt ảnh đại diện",
			previewFileType : "image",
		});
	</script>
</body>
</html>