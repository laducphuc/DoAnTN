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
<title>Thông tin cá nhân cộng tác viên</title>
<link rel="stylesheet"
	href="font-awesome-4.4.0/css/font-awesome.min.css">
<link rel="stylesheet" href="css/songnguvietnhat3.css">
<link rel="stylesheet" href="css/bootstrap.min.css">
<link rel="stylesheet" href="css/style.css" />
<script src="js/jquery-1.11.2.min.js"></script>
<script src="js/bootstrap.min.js"></script>
<script src="js/PaginationJS.js"></script>
<script type="text/javascript" src="js/my-include.js"></script>
<script type="text/javascript" src="js/fix-menu.js"></script>
<style type="text/css">
</style>
</head>

<body ">
		<!-- header -->
	<div class="include" data-include="header"></div>
	<!-- menu -->
	<div id="tabMenu" class="col-lg-12 tabMenu" style="padding: 0px;">
		<div id="menuItems" class="col-lg-12">
				<ul>
				<li ><a href="trang-gioi-thieu.do">Giới thiệu</a></li>
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
					<bean:define id="taikhoan" property="taiKhoan" name="dangNhapForm"
						scope="session"></bean:define>
					<li class="dropdown pull-right"><a class="dropdown-toggle"
						href="#"> <bean:define id="anh" name="taikhoan"
								property="anh"></bean:define> <html:img src="avata/${anh }"
								styleClass="img-circle" style="width: 40px; height:40px" /> <bean:write
								name="taikhoan" property="tenThanhVien" /> <span class="caret"></span>
					</a>

						<ul class="dropdown-menu">
							<li><html:link action="/xem-thong-tin-ca-nhan.do">Thông tin cá nhân</html:link></li>
							<li><html:link action="/them-bai-viet.do">Viết bài mới</html:link></li>

							<li><a href="#">Quản Lý bài Dịch <span class="caret"></span>
							</a>
								<ul class="mySubmenu">
									<li><html:link action="/bai-viet-chua-duyet.do">Bài mới được phân công</html:link></li>
									<li><html:link action="/bai-viet-nhan-dich.do">Bài Viết Đã Nhận Dịch</html:link></li>
								</ul></li>
							<li><html:link action="/dang-xuat.do">Đăng xuất</html:link></li>
						</ul></li>
				</logic:notEmpty>
				</ul>
			</div>
		</div>

	<!-- boby -->
	<div class="col-lg-12">
		

		<div class="col-lg-12" style="margin-top: 20px; padding: 0px;">
			<div class="col-lg-12" style="height: auto; padding: 0px">
				<!-- body main -->
				<div class="col-lg-9" style="height: auto; padding: 0px">
					<div class="col-lg-12 divMain" style="height: auto; background: white;">
						<div class="col-lg-2"></div>
						<div class="col-lg-8">
							<div class="col-lg-12">
								<h4 style="font-size: 30px; margin-top: 30px; text-align: center;">
									<i class="fa fa-users"></i> Thông tin cá nhân CTV
								</h4>
							</div>
							<div class="col-lg-12" style="border-bottom: 1px solid #725a65;">
								<h4>
								</h4>
							</div>
							<div class="row form-group" style="margin-top: 25px;">
								<label class="control-label col-sm-12" style="text-align: left;"><i
									class="fa fa-key"></i> Mã thành viên:</label>
								<div class="col-sm-12">
									<html:text name="thanhVienForm" property="maThanhVien"
										styleClass="form-control" disabled="true"></html:text>
								</div>
							</div>
							<div class="row form-group">
								<label class="control-label col-sm-12" style="text-align: left;">
									<i class="fa fa-user"></i> Họ Tên:
								</label>
								<div class="col-sm-8">
									<html:text name="thanhVienForm" property="tenThanhVien"
										styleClass="form-control" disabled="true"></html:text>
								</div>
								<div class="col-sm-4">
									<html:radio name="thanhVienForm" property="gioiTinh" value="1"
										disabled="true" style="margin-right: 10px;">Nam</html:radio>
									<html:radio name="thanhVienForm" property="gioiTinh" value="0"
										disabled="true" style="margin: 0px 10px 0px 30px;">Nữ</html:radio>
								</div>
							</div>
							<div class="row form-group">
								<label class="control-label col-sm-12" style="text-align: left;"><i
									class="fa fa-birthday-cake"></i> Ngày sinh:</label>
								<div class="col-sm-12">
									<html:text name="thanhVienForm" property="ngaySinh"
										styleClass="form-control" disabled="true"></html:text>
								</div>
							</div>
							<div class="row form-group">
								<label class="control-label col-sm-12" style="text-align: left;"><i
									class="fa fa-map-marker"></i> Địa chỉ:</label>
								<div class="col-sm-12">
									<html:text name="thanhVienForm" property="diaChi"
										styleClass="form-control" disabled="true"></html:text>
								</div>
							</div>
							<div class="row form-group">
								<label class="control-label col-sm-12" style="text-align: left;"><i
									class="fa fa-globe"></i> Quốc tịch:</label>
								<div class="col-sm-12">
									<html:text name="thanhVienForm" property="quocTich"
										styleClass="form-control" disabled="true"></html:text>
								</div>
							</div>
							<div class="row form-group">
								<label class="control-label col-sm-12" style="text-align: left;"><i
									class="fa fa-language"></i> Ngôn ngữ:</label>
								<div class="col-sm-12">
									<html:text name="thanhVienForm" property="ngonNgu"
										styleClass="form-control" disabled="true"></html:text>
								</div>

							</div>
							<div class="row form-group">
								<label class="control-label col-sm-12" style="text-align: left;"><i
									class="fa fa-phone"></i> Số điện thoại:</label>
								<div class="col-sm-12">
									<html:text name="thanhVienForm" property="soDienThoai"
										styleClass="form-control" disabled="true"></html:text>
								</div>
							</div>
							<div class="row form-group">
								<label class="control-label col-sm-12" style="text-align: left;">
									<i class="fa fa-envelope-o"></i> Email:
								</label>
								<div class="col-sm-12">
									<html:text name="thanhVienForm" property="email"
										styleClass="form-control" disabled="true"></html:text>
								</div>
							</div>
							<div class="row form-group">
								<label class="control-label col-sm-12" style="text-align: left;"><i
									class="fa fa-user"></i> Tên đăng nhập:</label>
								<div class="col-sm-12">
									<html:text name="thanhVienForm" property="tenTaiKhoan"
										styleClass="form-control" disabled="true"></html:text>
								</div>
							</div>
							<div class="row form-group">
								<label class="control-label col-sm-12" style="text-align: left;"><i
									class="fa fa-balance-scale"></i> Trình độ:</label>
								<div class="col-sm-12">
									<html:text name="thanhVienForm" property="tenTrinhDo"
										styleClass="form-control" disabled="true"></html:text>
								</div>
							</div>
							<div class="row form-group">
								<label class="control-label col-sm-12" style="text-align: left;">
									<i class="fa fa-star-o"></i> Số sao:
								</label>
								<div class="col-sm-12">
									<html:text name="thanhVienForm" property="soSao"
										styleClass="form-control" disabled="true"></html:text>
								</div>
							</div>
							<div class="row form-group">
								<label class="control-label col-sm-12" style="text-align: left;"><i
									class="fa fa-file-text-o"></i> Số bài đóng góp:</label>
								<div class="col-sm-12">
									<html:text name="thanhVienForm" property="soBaiDongGop"
										styleClass="form-control" disabled="true"></html:text>
								</div>
							</div>
							<div class="row form-group">
									<label class="control-label col-sm-12"
										style="text-align: left;"><i class="fa fa-file-text-o"></i>
										Số bài đã dịch:</label>
									<div class="col-sm-12">
										<html:text name="thanhVienForm" property="soBaiDaDich"
											styleClass="form-control" disabled="true"></html:text>
									</div>
								</div>
							<div class="row form-group"
								style="text-align: right; margin-right: 3px;">
								<bean:define id="maThanhVien" name="dangNhapForm" scope="session"
										property="maThanhVien"></bean:define>
										<bean:define id="chucVu" name="thanhVienForm"
										property="chucVu"></bean:define>
								<html:link styleClass="btn btn-primary"
									action="/cap-nhat-thanh-vien?maThanhVien=${maThanhVien}&chucVu=${chucVu}">
									<i class="fa fa-pencil-square-o"></i>
											Cập nhật</html:link>
							</div>
							<div class="col-lg-12"
								style="border-bottom: 1px solid #725a65; margin-top: 10px;">
								<h4>
									<i class="fa fa-info"></i> Thay đổi mật khẩu
								</h4>
							</div>
							<html:form
								action="/xem-thong-tin-ca-nhan"
								method="post">
								<div class="row form-group">
									<label class="control-label col-sm-12"
										style="text-align: left;"><i class="fa fa-file-text-o"></i>
										Mật khẩu cũ:</label>
									<div class="col-sm-12">
										<html:password name="thanhVienForm" property="matKhauCu"
											styleClass="form-control"></html:password>
									</div>
									<div class="col-sm-12">
										<font style="color: red;"> <html:errors
												property="maKhauCuError" />
										</font>
									</div>
								</div>
								<div class="row form-group">
									<label class="control-label col-sm-12"
										style="text-align: left;"><i class="fa fa-file-text-o"></i>
										Mật khẩu mới:</label>
									<div class="col-sm-12">
										<html:password name="thanhVienForm" property="matKhauMoi"
											styleClass="form-control"></html:password>
									</div>
									<div class="col-sm-12">
										<font style="color: red;"> <html:errors
												property="maKhauError" />
										</font>
									</div>
								</div>
								<div class="row form-group">
									<label class="control-label col-sm-12"
										style="text-align: left;"><i class="fa fa-file-text-o"></i>
										Nhập lại mật khẩu:</label>
									<div class="col-sm-12">
										<html:password name="thanhVienForm" property="nhapLaiMatKhau"
											styleClass="form-control"></html:password>
									</div>
									<div class="col-sm-12">
										<font style="color: red;"> <html:errors
												property="nhapLaiMatKhauMoiError" />
										</font>
									</div>
								</div>
								<div class="row form-group"
									style="text-align: right; margin-top: 10px; margin-bottom: 30px; margin-right: 3px">
									<html:submit styleClass="btn btn-primary" property="submit"
										value="Đổi mật khẩu"></html:submit>
								</div>
							</html:form>
						</div>
						<div class="col-lg-2"></div>
					</div>
				</div>

				<!-- body right -->
				<div class="col-lg-3" style="height: auto; padding-right: 0px;">
					<div class="col-lg-12 danhMuc"
						style="background-color: white; height: 130px">
						<div class="col-lg-12"
							style="background: url('image/menu2.png') no-repeat scroll 0px 10px; height: 46px; margin-left: 14px">
							<h5
								style="color: black; text-align: center; padding: 10px; margin: 0px; font-size: 1.2em">Bài
								Menu nhanh</h5>
							<ul>
								<li><html:link style="color: black;"
										action="/bai-viet-chua-duyet.do">Bài mới được phân công</html:link></li>
								<li><html:link style="color: black;"
										action="/bai-viet-nhan-dich.do">Bài Viết Đã Nhận Dịch</html:link></li>
							</ul>
						</div>
						<div class="col-lg-12"></div>
					</div>
				</div>
			</div>
		</div>
		
	</div>
	<!-- footer -->
	<div class="include" data-include="footer"></div>

	
</body>
</html>