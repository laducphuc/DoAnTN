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
<link rel="stylesheet" type="text/css"
	href="css/mycss/styleloginform.css">
<title>Insert title here</title>

<style type="text/css">
label.error {
	color: #FF0000;
}

input.error {
	border: 2px solid #FF0000;
	color: #0000FF;
	border-style: ridge;
}
</style>
<script type="text/javascript">
	function hienThiFormDangNhap() {
		$("#form-login").css("top", "20%");
		$(".overflow").show();
	}
	function tatFormDangNhap() {
		$("#form-login").css("top", "-100%");
		$(".overflow").hide();
	}
	$(document).ready(function() {
		console.log("runnn");
		var overflow = $(".overflow")[0];
		$(overflow).on("click", function() {
			console.log("runnn");
			tatFormDangNhap();
		});
		$("#my-submit").on("click", function() {
			var taiKhoan = $("#taiKhoan").val();
			var matKhau = $("#matKhau").val();
			console.log("taikhoan :" + taiKhoan + "matKhau : " + matKhau);
			$.ajax({
				type : "POST",
				url : "http://localhost:8080/DoAnTotNghiep/dang-nhap.do",
				data : "tenTaiKhoan="+taiKhoan+"&matKhau="+matKhau,
				dataType : "json",
				success : function(response){
					console.log("run den day");
					var jsonObject=response[0];
					var ketQua=jsonObject.ketQua;
					var thongBao=jsonObject.thongBao;
					console.log("runnn day");
					if("dangNhapThatBai"==ketQua){
						console.log("thatttttttt bai");
						$("#thongBao").html(""+thongBao);
					}
					if("dangNhapThanhCong"==ketQua){
						console.log("thanh cong");
						window.location.href="http://localhost:8080/DoAnTotNghiep/trang-chu.do";
					}
				},
				error : function(errormessage){
					alert("error "+errormessage);
				}
			});
		});
	});
</script>
</head>
<body>
	<div class="overflow"></div>
	<!-- body main -->
	<div id="form-login" class="col-lg-offset-3 col-lg-6 my-form"
		style="margin-top: 40px">
		<center style="margin-top: 30px">
			<strong style="font-size: 28px;">Đăng nhập hệ thống</strong>
		</center>
		<br>
		<html:form action="/dang-nhap">
			<div class="col-lg-12" style="margin-top: 10px">
				<label class="col-lg-3"><i class="fa fa-user"></i> Tài
					khoản</label>
				<div class="col-lg-9">
					<html:text styleId="taiKhoan" property="tenTaiKhoan"
						styleClass="form-control"></html:text>
				</div>
			</div>
			<div class="col-lg-12" style="margin-top: 10px">
				<label class="col-lg-3"><i class="fa fa-key"></i> Mật khẩu</label>
				<div class="col-lg-9">
					<html:password styleId="matKhau" property="matKhau"
						styleClass="form-control"></html:password>
				</div>
			</div>
			<div class="col-lg-12" style="margin-top: 10px; text-align: center">
				<p style="color: red;" id="thongBao"></p>
			</div>
			<div class="col-lg-12"
				style="text-align: center; margin-bottom: 35px; margin-top: 10px;">
				<div class="col-lg-12">
					<html:button styleId="my-submit" styleClass="btn btn-info"
						property="submit">Đăng Nhập</html:button>
					<button class="btn btn-info" type="reset"
						onclick="tatFormDangNhap()">
						<i class="fa fa-times"></i> Hủy bỏ
					</button>
				</div>
			</div>
		</html:form>
	</div>

	<div id="tabMenu" class="col-lg-12 tabMenu" style="padding: 0px;">
		<%-- <logic:empty name="dangNhapForm" property="taiKhoan" scope="session"> --%>
			<div id="menuItems" class="col-lg-12">
				<ul>
					<li><a href="trang-gioi-thieu.do">Giới thiệu</a></li>
					<li><html:link action="/trang-chu.do">Trang chủ</html:link></li>
					<li class="dropdown"><a class="dropdown-toggle"
						data-toggle="dropdown" href="#">Học theo giáo trình <span
							class="caret"></span></a>
						<ul class="dropdown-menu" style="text-align: left">
							<li><html:link action="/bai-hoc.do?maCapDo=GT001"
									style="text-align: left">Giáo trình N5</html:link></li>
							<li><html:link action="/bai-hoc.do?maCapDo=GT002"
									style="text-align: left">Giáo trình N4</html:link></li>
							<li><html:link action="/bai-hoc.do?maCapDo=GT003"
									style="text-align: left">Giáo trình N3</html:link></li>
						</ul></li>
					<li class="dropdown"><a class="dropdown-toggle"
						data-toggle="dropdown" href="#">Luyện thi online <span
							class="caret"></span></a>
						<ul class="dropdown-menu" style="text-align: left">
							<li><html:link action="/test.do?maCapDo=GT001"
									style="text-align: left">Đề luyện thi N5</html:link></li>
							<li><html:link
									action="/test.do?maDanhMuc=DM00000002&kiemTra=1"
									style="text-align: left">Đề luyện thi N4</html:link></li>
							<li><html:link
									action="/test.do?maDanhMuc=DM00000003&kiemTra=1"
									style="text-align: left">Đề luyện thi N3</html:link></li>
						</ul></li>
					<li><html:link action="/dang-ky-thanh-vien.do">Đăng ký thành viên</html:link></li>
					<li class="pull-right"><html:link href="#x"
							onclick="hienThiFormDangNhap()">Đăng Nhập</html:link></li>
				</ul>
			</div>
		<%-- </logic:empty> --%>
		<%-- <logic:notEmpty name="dangNhapForm" property="taiKhoan"
			scope="session">
			<bean:define id="taiKhoan" name="dangNhapForm" property="taiKhoan"
				scope="session"></bean:define>
			<logic:equal value="0" name="taiKhoan" property="chucVu">
				<div class="col-lg-12" id="menuItems">
					<ul>
						<li><a href="trang-gioi-thieu.do">Giới thiệu</a></li>
						<li><html:link action="/trang-chu.do">Trang chủ</html:link></li>
						<li class="dropdown"><a class="dropdown-toggle"
							data-toggle="dropdown" href="#">Học theo giáo trình <span
								class="caret"></span></a>
							<ul class="dropdown-menu" style="text-align: left">
								<li><html:link action="/bai-hoc.do?maCapDo=GT001"
										style="text-align: left">Giáo trình N5</html:link></li>
								<li><html:link action="/bai-hoc.do?maCapDo=GT002"
										style="text-align: left">Giáo trình N4</html:link></li>
								<li><html:link action="/bai-hoc.do?maCapDo=GT003"
										style="text-align: left">Giáo trình N3</html:link></li>
							</ul></li>
						<li class="dropdown"><a class="dropdown-toggle"
							data-toggle="dropdown" href="#">Luyện thi online <span
								class="caret"></span></a>
							<ul class="dropdown-menu" style="text-align: left">
								<li><html:link action="/test.do?maCapDo=GT001"
										style="text-align: left">Đề luyện thi N5</html:link></li>
								<li><html:link action="/test.do?maCapDo=GT002"
										style="text-align: left">Đề luyện thi N4</html:link></li>
								<li><html:link action="/test.do?maCapDo=GT003"
										style="text-align: left">Đề luyện thi N3</html:link></li>
							</ul></li>
						<li class="dropdown pull-right"><a class="dropdown-toggle"
							data-toggle="dropdown" href="#"> <bean:define id="anh"
									name="taiKhoan" property="anh"></bean:define> <html:img
									src="avata/${anh }" styleClass="img-circle"
									style="width: 40px; height:40px" /> <bean:write
									name="taiKhoan" property="tenThanhVien" /> <span class="caret"></span>
						</a>
							<ul class="dropdown-menu">
								<li><html:link action="/xem-thong-tin-ca-nhan.do">Thông tin cá nhân</html:link></li>
								<li><html:link action="/them-bai-viet.do">Viết bài mới</html:link></li>
								<li><html:link action="/dang-xuat.do">Đăng xuất</html:link></li>
							</ul></li>
					</ul>
				</div>
			</logic:equal>
		</logic:notEmpty> --%>
	</div>
</body>
</html>