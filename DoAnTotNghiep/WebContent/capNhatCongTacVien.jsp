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
<title>Trang Admin- Cập nhật thông tin cộng tác viên</title>
<link rel="stylesheet"
	href="font-awesome-4.4.0/css/font-awesome.min.css">
<link rel="stylesheet" href="css/bootstrap.min.css">
<link rel="stylesheet" href="css/songnguvietnhat3.css">
<link rel="stylesheet" href="css/style.css" />
<link rel="stylesheet" href="css/datepicker.css">
<link rel="stylesheet" href="css/fileinput.css">
<script src="js/jquery-1.11.2.min.js"></script>
<script src="js/bootstrap.min.js"></script>
<script src="js/fileinput.js"></script>
<script src="js/bootstrap-datepicker.js"></script>
<script type="text/javascript" src="js/my-include.js"></script>
<script type="text/javascript" src="js/fix-menu.js"></script>
<script type="text/javascript">
	$(document).ready(function() {
		$('#birthdate').datepicker({
			format : "yyyy-mm-dd"
		});
	});
</script>
<style type="text/css">
</style>
</head>
<body>
	<!-- header -->
	<div class="include" data-include="header"></div>
	<!-- menu -->
	<div class="col-lg-12" id="tabMenu">
		<div class="col-lg-12" id="menuItems">
			<bean:define id="taiKhoanSession" name="dangNhapForm"
				property="taiKhoan" scope="session"></bean:define>
			<bean:define id="chucVuSession" name="taiKhoanSession"
				property="chucVu"></bean:define>
			<logic:equal name="chucVuSession" value="1">
				<ul>
					<li style="color: blue; width: 180px;"><html:link
							action="trang-chu.do">Trang chủ</html:link></li>
					<li><html:link action="/them-bai-viet.do">Viết bài mới</html:link></li>
					<li class="dropdown"><a class="dropdown-toggle"
						data-toggle="dropdown" href="#">Quản Lý bài Dịch <span
							class="caret"></span></a>
						<ul class="dropdown-menu">
							<li><html:link
									action="/bai-viet-chua-duyet.do?maThanhVien=${maThanhVien}">Bài Viết Chưa Duyệt</html:link></li>
							<li><html:link
									action="/bai-viet-nhan-dich.do?maThanhVien=${maThanhVien}">Bài Viết Đã Nhận</html:link></li>
						</ul></li>
					<li><html:link action="/xem-thong-tin-ca-nhan.do">Thông Tin Cá Nhân</html:link></li>
					<li><html:link action="/dang-xuat">Đăng xuất</html:link></li>
				</ul>
			</logic:equal>
			<logic:equal name="chucVuSession" value="3">
				<ul>
					<li style="color: blue; width: 180px;"><html:link
							action="trang-chu.do">Trang chủ</html:link></li>
					<li style="width: 180px;"><html:link
							action="/danh-sach-thanh-vien.do">Quản lý thành viên</html:link>
					</li>
					<li style="width: 180px;"><html:link
							action="/danh-sach-cong-tac-vien.do">Quản lý cộng tác viên</html:link>
					</li>
					<li style="width: 180px;"><html:link
							action="/quan-ly-phan-cong-dich-bai.do?trangThai=Tatca">Phân công dịch bài</html:link></li>
					<li style="width: 180px;"><html:link
							action="/quan-ly-bai-viet.do?trangThai=Tatca">Quản lý bài viết</html:link></li>
					<logic:notEmpty name="dangNhapForm" property="taiKhoan"
						scope="session">
						<bean:define id="taikhoan" name="dangNhapForm" property="taiKhoan"
							scope="session"></bean:define>
						<li class="dropdown pull-right"><a class="dropdown-toggle"
							dropdown-toggle="dropdown" href="#"> <bean:define id="anh"
									name="taikhoan" property="anh"></bean:define> <html:img
									src="avata/${anh }" styleClass="img-circle"
									style="width: 40px; height:40px" /> <bean:write
									name="taikhoan" property="tenThanhVien" /> <span class="caret"></span></a>

							<ul class="dropdown-menu">
								<li><html:link action="/thong-tin-admin.do">Thông tin cá nhân</html:link></li>
								<li><html:link action="/dang-xuat.do">Đăng xuất</html:link></li>
							</ul></li>
					</logic:notEmpty>

				</ul>
			</logic:equal>
		</div>
	</div>
	</div>

	<!-- boby -->
	<div class="col-lg-12">

		<div class="col-lg-12" style="margin-top: 20px; padding: 0px;">
			<div class="col-lg-12" style="height: auto; padding: 0px">
				<!-- body main -->
				<div class="col-lg-9" style="height: auto; padding: 0px">
					<div class="col-lg-12 divMain"
						style="height: auto; background: white;">
						<div class="col-lg-1"></div>
						<bean:define id="maThanhVien" name="thanhVienForm"
							property="maThanhVien"></bean:define>
						<bean:define id="chucVu" name="thanhVienForm" property="chucVu"></bean:define>
						<html:form
							action="/cap-nhat-thanh-vien?maThanhVien=${maThanhVien}&chucVu=${chucVu}"
							method="post" enctype="multipart/form-data">
							<div class="col-lg-8">
								<div class="col-lg-12">
									<h4 style="font-size: 30px; margin-top: 30px; text-align: center;">
										<i class="fa fa-users"></i> Cập nhật thông tin cộng tác
										viên
									</h4>
								</div>

								<div class="col-lg-12">
									<div class="row form-group" style="margin-top: 25px;">
										<label class="control-label col-sm-12"
											style="text-align: left;"><i class="fa fa-key"></i>
											Mã thành viên:</label>
										<div class="col-sm-12">
											<html:text name="thanhVienForm" property="maThanhVien"
												styleClass="form-control" disabled="true"></html:text>
										</div>
									</div>
									<div class="row form-group">
										<label class="control-label col-sm-12"
											style="text-align: left;"> <i class="fa fa-user"></i>
											Họ Tên:
										</label>
										<div class="col-sm-8">
											<html:text name="thanhVienForm" property="tenThanhVien"
												styleClass="form-control"></html:text>
										</div>
										<div class="col-sm-4">
											<html:radio name="thanhVienForm" property="gioiTinh"
												value="1" style="margin-right: 10px;">Nam</html:radio>
											<html:radio name="thanhVienForm" property="gioiTinh"
												value="0" style="margin: 0px 10px 0px 30px;">Nữ</html:radio>
										</div>
									</div>
									<div class="row form-group">
										<label class="control-label col-sm-12"
											style="text-align: left;"><i
											class="fa fa-birthday-cake"></i> Ngày sinh:</label>
										<div class="col-sm-12">
											<html:text name="thanhVienForm" property="ngaySinh"
												styleId="birthdate" styleClass="form-control"></html:text>
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
										<div class="col-sm-12">
											<html:text name="thanhVienForm" property="diaChi"
												styleClass="form-control"></html:text>
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
										<div class="col-sm-12">
											<html:text name="thanhVienForm" property="soDienThoai"
												styleClass="form-control"></html:text>
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
										<div class="col-sm-12">
											<html:text name="thanhVienForm" property="email"
												styleClass="form-control"></html:text>
										</div>
										<div class="col-sm-12">
											<font style="color: red;"> <html:errors
													property="emailError" />
											</font>
										</div>
									</div>
									<div class="row form-group">
										<label class="control-label col-sm-12"
											style="text-align: left;"><i class="fa fa-user"></i>
											Tên đăng nhập:</label>
										<div class="col-sm-12">
											<html:text name="thanhVienForm" property="tenTaiKhoan"
												styleClass="form-control" disabled="true"></html:text>
										</div>
									</div>
								</div>
								<div class="col-sm-12"
									style="text-align: center; margin-top: 10px; margin-bottom: 30px;">
									<html:submit styleClass="btn btn-info" property="submit"
										value="Hoàn tất"></html:submit>
									<html:button styleClass="btn btn-info" property="button"
										value="Quay lại" onclick="history.go(-1);"></html:button>
								</div>

							</div>
							<div class="col-lg-3" style="margin-top: 97px">
								<div class="col-lg-12">
									<label>Cập nhật ảnh đại diện</label>
								</div>
								<div class="col-lg-12">
									<html:file styleId="input-1" styleClass="file" property="file"
										accept="image/*"></html:file>
								</div>
							</div>
						</html:form>
					</div>
				</div>

				<!-- body right -->
				<div class="col-lg-3" style="height: auto; padding-right: 0px;">
					<div class="col-lg-12 thanhVienNoiBat">
						<div class="col-lg-12" style="text-align: center;">
							<label> Thống Kê</label>
						</div>
						<div class="col-lg-12">
							<hr style="border: 1px solid #ddd; margin: 2px 0px;">
						</div>

						<ul>
							<li><html:link action="/thong-ke.do">
									<span class="glyphicon glyphicon-minus"></span>  Bảng xếp hạng thành viên</html:link>
							</li>
							<li><html:link action="/bang-xep-hang-cong-tac-vien.do">
									<span class="glyphicon glyphicon-minus"></span>  Bảng xếp hạng cộng tác viên</html:link>
							</li>
							<li><html:link action="/bang-xep-hang-bai-viet.do">
									<span class="glyphicon glyphicon-minus"></span>  Bảng xếp hạng bài viết</html:link>
							</li>
						</ul>
					</div>
				</div>
			</div>
		</div>
	</div>
	<!-- footer -->
	<div class="include" data-include="footer"></div>
	
	
	<script type="text/javascript">
		$("#input-1").fileinput({
			showUpload: false,
			showRemove : false,
			browseLabel : "Duyệt ảnh đại diện",
			PreviewFileType: "image",
		});
	</script>
</body>
</html>