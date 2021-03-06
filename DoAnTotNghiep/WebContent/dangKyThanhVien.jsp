<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>
<%@ taglib uri="http://struts.apache.org/tags-tiles" prefix="tiles"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Đăng ký thành viên</title>
<link rel="stylesheet"
	href="font-awesome-4.4.0/css/font-awesome.min.css">
<link rel="stylesheet" href="css/bootstrap.min.css">
<link rel="stylesheet" href="css/songnguvietnhat3.css">
<link rel="stylesheet" href="css/style.css" />
<link rel="stylesheet" href="css/bootstrap-formhelpers.css">
<link rel="stylesheet" href="css/bootstrap-formhelpers.min.css">
<link rel="stylesheet"
	href="font-awesome-4.4.0/css/font-awesome.min.css">
<link rel="stylesheet" href="css/datepicker.css">
<link rel="stylesheet" href="css/fileinput.css">
<script src="js/jquery-1.11.2.min.js"></script>
<script src="js/fileinput.js"></script>
<script src="js/bootstrap.min.js"></script>
<script src="js/bootstrap-formhelpers.js"></script>
<script src="js/bootstrap-formhelpers.min.js"></script>
<script src="js/bootstrap-datepicker.js"></script>
<script type="text/javascript" src="js/my-include.js"></script>
<script type="text/javascript" src="js/fix-menu.js"></script>
<script type="text/javascript">
	$(document).ready(function() {
		$('#haha').datepicker({
			format : "yyyy-mm-dd"
		});
	});
</script>

</head>

<body>

	<!-- header -->
	<div class="include" data-include="header"></div>
	<!-- menu -->
	<jsp:include page="dangNhapForm.jsp"></jsp:include>
	<!-- boby -->
	<div class="col-lg-12" >
		<div class="col-lg-1"
			style="height: auto; margin-right: 14px; margin-top: 20px;"></div>

		<div class="col-lg-10" style="margin-top: 20px; padding: 0px;">
			<div class="col-lg-12" style="height: auto; padding: 0px;">
				<!-- body main -->
				<div class="col-lg-12" style="height: auto; padding: 0px;">
					<div class="col-lg-12 divMain" style="height: auto;">
						<html:form action="/dang-ky-thanh-vien" method="post"
							enctype="multipart/form-data">
						<div class="col-lg-12">
									<h4
										style="font-size: 30px; margin-top: 30px;text-align: center;">
										<i class="fa fa-users"></i> Đăng ký thành viên
									</h4>
								</div>
								<div class="col-lg-12">
							<div class="col-lg-8">
								
								<div class="col-lg-12" style="border-bottom: 1px solid #725a65;">
									<h4>
										<i class="fa fa-info"></i> Thông tin thành viên
									</h4>
								</div>

								<div class="row form-group">
									<label class="control-label col-sm-12"
										style="text-align: left;"><i class="fa fa-user"></i>
										Họ Tên:</label>
									<div class="col-sm-7">
										<html:text name="dangKyThanhVienForm" property="tenThanhVien"
											styleClass="form-control"></html:text>
									</div>
									<div class="col-sm-1">
										<samp style="color: red">(*)</samp>
									</div>
									<div class="col-sm-4">
										<html:radio name="dangKyThanhVienForm" property="gioiTinh"
											value="1" style="margin-right: 10px;">Nam</html:radio>
										<html:radio name="dangKyThanhVienForm" property="gioiTinh"
											value="0" style="margin: 0px 10px 0px 30px;">Nữ</html:radio>
									</div>
									<div class="col-sm-12">
										<font style="color: red;"> <html:errors
												property="tenThanhVienError" />
										</font>
									</div>
								</div>
								<div class="row form-group">
									<label class="control-label col-sm-12"
										style="text-align: left;"><i
										class="fa fa-birthday-cake"></i> Ngày sinh:</label>
									<div class="col-sm-11">
										<html:text name="dangKyThanhVienForm" property="ngaySinh"
											styleId="haha" styleClass="form-control"></html:text>
									</div>
									<div class="col-sm-1">
										<samp style="color: red">(*)</samp>
									</div>
									<div class="col-sm-12">
										<font style="color: red;"> <html:errors
												property="ngaySinhError" />
										</font>
									</div>
								</div>
								<div class="row form-group">
									<label class="control-label col-sm-12"
										style="text-align: left;"><i class="fa fa-map-marker"></i>
										Địa chỉ:</label>
									<div class="col-sm-11">
										<html:text name="dangKyThanhVienForm" property="diaChi"
											styleClass="form-control"></html:text>
									</div>
									<div class="col-sm-1">
										<samp style="color: red">(*)</samp>
									</div>
									<div class="col-sm-12">
										<font style="color: red;"> <html:errors
												property="diaChiError" />
										</font>
									</div>
								</div>
								
								
								<div class="row form-group">
									<label class="control-label col-sm-12"
										style="text-align: left;"><i class="fa fa-phone"></i>
										Số điện thoại:</label>
									<div class="col-sm-11">
										<html:text name="dangKyThanhVienForm" property="soDienThoai"
											styleClass="form-control"></html:text>
									</div>
									<div class="col-sm-1">
										<samp style="color: red">(*)</samp>
									</div>
									<div class="col-sm-12">
										<font style="color: red;"> <html:errors
												property="soDienThoaiError" />
										</font>
									</div>
								</div>
								<div class="row form-group">
									<label class="control-label col-sm-12"
										style="text-align: left;"><i class="fa fa-envelope-o"></i>
										Email:</label>
									<div class="col-sm-11">
										<html:text name="dangKyThanhVienForm" property="email"
											styleClass="form-control"></html:text>
									</div>
									<div class="col-sm-1">
										<samp style="color: red">(*)</samp>
									</div>
									<div class="col-sm-12">
										<font style="color: red;"> <html:errors
												property="emailError" />
										</font>
									</div>
								</div>
								<div class="col-lg-12" style="border-bottom: 1px solid #725a65;">
									<h4>
										<i class="fa fa-info"></i> Thông tin tài khoản
									</h4>
								</div>
								<div class="row form-group">
									<label class="control-label col-sm-12"
										style="text-align: left;"><i class="fa fa-user"></i>
										Tên đăng nhập</label>
									<div class="col-sm-11">
										<html:text name="dangKyThanhVienForm" property="tenTaiKhoan"
											styleClass="form-control"></html:text>
									</div>
									<div class="col-sm-1">
										<samp style="color: red">(*)</samp>
									</div>
									<div class="col-sm-12">
										<font style="color: red;"> <html:errors
												property="tenTaiKhoanError" />
										</font>
									</div>


								</div>
								<div class="row form-group">
									<label class="control-label col-sm-12"
										style="text-align: left;"><i class="fa fa-unlock"></i>
										Mật khẩu</label>
									<div class="col-sm-11">
										<html:password name="dangKyThanhVienForm" property="matKhau"
											styleClass="form-control"></html:password>
									</div>
									<div class="col-sm-1">
										<samp style="color: red">(*)</samp>
									</div>
									<div class="col-sm-12">
										<font style="color: red;"> <html:errors
												property="matKhauError" />
										</font>
									</div>

								</div>
								<div class="row form-group">
									<label class="control-label col-sm-12"
										style="text-align: left;"><i class="fa fa-unlock"></i>
										Nhập lại mật khẩu</label>
									<div class="col-sm-11">
										<html:password name="dangKyThanhVienForm"
											property="nhapLaiMatKhau" styleClass="form-control"></html:password>
									</div>
									<div class="col-sm-1">
										<samp style="color: red">(*)</samp>
									</div>
									<div class="col-sm-12">
										<font style="color: red;"> <html:errors
												property="matKhauNhapLaiError" />
										</font>
									</div>
									<div class="col-sm-12">
										<font style="color: red;"> <html:errors
												property="trungMatKhauError" />
										</font>
									</div>
								</div>
								<div class="row form-group" >
									<div class="col-sm-12" style="text-align: center;"
										>
										<html:submit styleClass="btn btn-info" property="submit"
											value="Đăng ký"></html:submit>
									</div>
								</div>
	
							</div>
							<div class="col-lg-3" style="margin-top: 113px;">
								<div class="col-lg-12" style="height: 150px;">
									<label class="control-label"><span
										class="glyphicon glyphicon-picture"></span> Chọn ảnh đại diện
										:</label>
									<html:file styleId="input-1" property="file" styleClass="file"
										accept="image/*"></html:file>
								</div>
								<div class="col-sm-12">
									<font style="color: red"> <html:errors
											property="anhDaiDienError" />
									</font>
								</div>
							</div>
							
							</div>
						</html:form>
					</div>
				</div>
			</div>
		</div>

	</div>
	<!-- footer -->
	<div class="include" data-include="footer"></div>

	<script type="text/javascript">
		var includes = $(".include");
		jQuery.each(includes, function() {
			var file = $(this).data("include") + ".jsp";
			$(this).load(file);
		});
	</script>
	<script type="text/javascript">
		$("#input-1").fileinput({
			showRemove : false,
			showUpload : false,
			browseLabel : "Duyệt ảnh đại diện",
			previewFileType : "image"
		});
	</script>
</body>
</html>