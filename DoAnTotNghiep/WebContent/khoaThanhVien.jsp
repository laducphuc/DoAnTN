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
<title>Trang Admin- Khóa thành viên</title>
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

<body>
	<!-- header -->
	<div class="include" data-include="header"></div>
	<!-- menu -->
	<div class="col-lg-12" id="tabMenu">
		<div class="col-lg-12" id="menuItems">
			<ul>
				<li style="color: blue; width: 180px;"><html:link
						action="trang-chu.do">Trang chủ</html:link></li>
				<li style="width: 180px;"><html:link
						action="/danh-sach-thanh-vien.do">Quản lý thành viên</html:link>
				</li>
				<li style="width: 180px;"><html:link
						action="/danh-sach-cong-tac-vien.do">Quản lý cộng tác viên</html:link>
				</li>

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
								style="width: 40px; height:40px" /> <bean:write name="taikhoan"
								property="tenThanhVien" /> <span class="caret"></span></a>

						<ul class="dropdown-menu">
							<li><html:link action="/thong-tin-admin.do">Thông tin cá nhân</html:link></li>
							<li><html:link action="/dang-xuat.do">Đăng xuất</html:link></li>
						</ul></li>
				</logic:notEmpty>
			</ul>
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
						<div class="col-lg-2"></div>
						<div class="col-lg-8">
							<div class="col-lg-12">
								<h4
									style="font-size: 30px; margin-top: 30px; margin-left: 150px;">
									<i class="fa fa-users"></i> Khóa thành viên
								</h4>
							</div>
							<bean:define id="maThanhVien" name="thanhVienForm"
								property="maThanhVien"></bean:define>
							<bean:define id="chucVu" name="thanhVienForm" property="chucVu"></bean:define>
							<html:form
								action="/khoa-thanh-vien?maThanhVien=${maThanhVien}&chucVu=${chucVu}"
								method="post">
								<div class="row form-group">
									<label class="control-label col-sm-12"
										style="text-align: left;"><i class="fa fa-key"></i> Mã
										thành viên:</label>
									<div class="col-sm-12">
										<html:text name="thanhVienForm" property="maThanhVien"
											styleClass="form-control" disabled="true"></html:text>
									</div>
								</div>
								<div class="row form-group">
									<label class="control-label col-sm-12"
										style="text-align: left;"><i class="fa fa-user"></i>
										Họ Tên:</label>
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
									<label class="control-label col-sm-12"
										style="text-align: left;"><i
										class="fa fa-birthday-cake"></i> Ngày sinh:</label>
									<div class="col-sm-12">
										<html:text name="thanhVienForm" property="ngaySinh"
											styleClass="form-control" disabled="true"></html:text>
									</div>
								</div>
								<div class="row form-group">
									<label class="control-label col-sm-12"
										style="text-align: left;"><i class="fa fa-map-marker"></i>
										Địa chỉ:</label>
									<div class="col-sm-12">
										<html:text name="thanhVienForm" property="diaChi"
											styleClass="form-control" disabled="true"></html:text>
									</div>
								</div>
								<div class="row form-group">
									<label class="control-label col-sm-12"
										style="text-align: left;"><i class="fa fa-globe"></i>
										Quốc tịch:</label>
									<div class="col-sm-12">
										<html:text name="thanhVienForm" property="quocTich"
											styleClass="form-control" disabled="true"></html:text>
									</div>
								</div>
								<div class="row form-group">
									<label class="control-label col-sm-12"
										style="text-align: left;"><i class="fa fa-language"></i>
										Ngôn ngữ:</label>
									<div class="col-sm-12">
										<html:text name="thanhVienForm" property="ngonNgu"
											styleClass="form-control" disabled="true"></html:text>
									</div>

								</div>
								<div class="row form-group">
									<label class="control-label col-sm-12"
										style="text-align: left;"><i class="fa fa-phone"></i>
										Số điện thoại:</label>
									<div class="col-sm-12">
										<html:text name="thanhVienForm" property="soDienThoai"
											styleClass="form-control" disabled="true"></html:text>
									</div>
								</div>
								<div class="row form-group">
									<label class="control-label col-sm-12"
										style="text-align: left;"><i class="fa fa-envelope-o"></i>
										Email:</label>
									<div class="col-sm-12">
										<html:text name="thanhVienForm" property="email"
											styleClass="form-control" disabled="true"></html:text>
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
								<div class="row form-group">
									<label class="control-label col-sm-12"
										style="text-align: left;"><i
										class="fa fa-balance-scale"></i> Cấp độ:</label>
									<div class="col-sm-12">
										<html:text name="thanhVienForm" property="tenCapDo"
											styleClass="form-control" disabled="true"></html:text>
									</div>
								</div>
								<div class="row form-group">
									<label class="control-label col-sm-12"
										style="text-align: left;"><i class="fa fa-star-o"></i>
										Số sao:</label>
									<div class="col-sm-12">
										<html:text name="thanhVienForm" property="soSao"
											styleClass="form-control" disabled="true"></html:text>
									</div>
								</div>
								<div class="row form-group">
									<label class="control-label col-sm-12"
										style="text-align: left;"><i class="fa fa-file-text-o"></i>
										Số bài đóng góp:</label>
									<div class="col-sm-12">
										<html:text name="thanhVienForm" property="soBaiDongGop"
											styleClass="form-control" disabled="true"></html:text>
									</div>
								</div>
								<div class="row form-group">
									<label class="control-label col-sm-12"
										style="text-align: left;"><i class="fa fa-key"></i>
										Số ngày bị khóa:</label>
									<div class="col-sm-12">
										<html:select property="soNgayKhoa" name="thanhVienForm"
											styleClass="form-control">
											<option value="1">1 ngày</option>
											<option value="5">5 ngày</option>
											<option value="7">7 ngày</option>
											<option value="14">14 ngày</option>
											<option value="30">30 ngày</option>
										</html:select>
									</div>
								</div>

								<div class="row form-group">
									<div class="col-sm-12" style=" text-align: center;">
										<html:submit styleClass="btn btn-info" property="submit"
											value="Khóa tài khoản"></html:submit>
									</div>
								</div>
							</html:form>
						</div>
						<div class="col-lg-2"></div>
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

</body>
</html>