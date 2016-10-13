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
<title>Trang CTV- Xem bài viết được phân công</title>
<link rel="stylesheet"
	href="font-awesome-4.4.0/css/font-awesome.min.css">
<link rel="stylesheet" href="css/bootstrap.min.css">
<link rel="stylesheet" href="css/songnguvietnhat3.css">
<link rel="stylesheet" href="css/style.css" />
<link rel="stylesheet" href="css/bootstrap-formhelpers.css">
<link rel="stylesheet" href="css/bootstrap-formhelpers.min.css">
<link rel="stylesheet" href="css/datepicker.css">
<script src="js/jquery-1.11.2.min.js"></script>
<script src="js/bootstrap.min.js"></script>
<script src="js/bootstrap-formhelpers.js"></script>
<script src="js/bootstrap-formhelpers.min.js"></script>
<script src="js/bootstrap-datepicker.js"></script>
<script type="text/javascript" src="js/my-include.js"></script>
<script type="text/javascript" src="js/fix-menu.js"></script>
<style type="text/css">
</style>
</head>

<body >
	<!-- header -->
	<div class="include" data-include="header"></div>
	<!-- menu -->
	<div class="col-lg-12" id="tabMenu">
	
			<div class="col-lg-12" id="menuItems">
					<ul>
					<li><html:link action="/trang-gioi-thieu.do">Giới thiệu</html:link></li>
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
	</div>


	<!-- boby -->
	<div class="col-lg-12">
	
		<div class="col-lg-12" style="margin-top: 20px; padding: 0px;">
			<div class="col-lg-12" style="height: auto; padding: 0px">
				<!-- body main -->
				<div class="col-lg-9" style="height: auto; padding: 0px">
					<div class="col-lg-12 divMain"
						style="height: auto; background: white;">
						<!-- Bài viết -->
						<div class="col-lg-12">
							<bean:define id="baiviet" name="baiVietForm" property="baiViet"></bean:define>
							<div class="col-lg-6">
								<h4 style="font: bold; font-size: 30px">
									<bean:write name="baiviet" property="tieuDeViet" />
								</h4>
							</div>
							<div class="col-lg-12">
								<h5>
									Ngày nhận bài:
									<bean:write name="baiviet" property="ngayChapNhan" />
								</h5>
								<h5>
									Hạn nhận bài:
									<bean:write name="baiviet" property="ngayHanNhanBai" />
								</h5>
							</div>
							<div class="col-lg-12" style="margin-top: 15px">
								<div class="col-lg-6" style="height: 264px;">
									<bean:define id="anh" name="baiviet" property="anh"></bean:define>
									<img alt="Ảnh của bài viết" src="pictures/${anh }"
										width="390px" height="270px"
										style="border: 1px solid #725a65;">
								</div>
								<div class="col-lg-6">
									<label class="control-label col-sm-12"
										style="text-align: left;"><i class="fa fa-file-text"></i>
										Mô tả bài viết:</label>
								</div>
								<div class="col-lg-6">
									<h5 class="title">
										<bean:write name="baiviet" property="moTaViet" />
									</h5>
								</div>
							</div>

							<div id="noiDungBaiViet" class="col-lg-12 divMain"
								style="height: auto; margin-top: 25px;">
								<html:hidden styleId="noiDung" property="noiDungViet" name="baiviet" />
							<!--<logic:iterate id="arrNoiDungViet" name="baiviet"
									property="arrNoiDungViet">
										<bean:write name="arrNoiDungViet" />
								</logic:iterate> -->
							</div>
							<div class="col-lg-12">
								<font style="color: red;"> <bean:write name="baiVietForm"
										property="thongBao"></bean:write>
								</font>
							</div>
							<div class="form-group col-lg-12" style="margin-top: 10px;">
								<div>
									<bean:define id="maBaiViet" name="baiviet" property="maBaiViet"></bean:define>
									<html:form
										action="/xem-bai-viet-duoc-phan-cong?maBaiViet=${maBaiViet}">
										<html:submit property="submit" styleClass="btn btn-primary"
											style="float: right;" value="Chấp nhận"></html:submit>
									</html:form>
								</div>
								<div style="margin-left: 10px;">

									<html:form
										action="/xem-bai-viet-duoc-phan-cong?maBaiViet=${maBaiViet}">
										<html:submit property="submit" styleClass="btn btn-primary"
											style="float: right;" value="Từ chối"></html:submit>
									</html:form>
								</div>
							</div>


							<!-- Bình luận bài viết -->
							<div class="col-lg-12 divMain"
								style="height: auto; margin-bottom: 25px;">
								<h4 style="padding-left: 15px; text-decoration: underline;">
									<i class="fa fa-comments-o"></i> Bình luận bài viết
								</h4>
								<bean:define id="tenTaiKhoan" name="dangNhapForm"
									property="tenTaiKhoan" scope="session"></bean:define>
								<div class="form-group">
									<html:form action="/xem-bai-viet-duoc-phan-cong">
										<label class="col-sm-12" for="email"><bean:write
												name="tenTaiKhoan" /> </label>
										<img class="col-sm-2 divMain" alt=" Avartar ^_^"
											style="text-align: center;" src="image/avatar.jpg"
											width="30px" height="100px">
										<div class="col-sm-10">
											<input type="text" class="form-control" id="email"
												style="height: 50px;" name="noiDungBinhLuan"
												placeholder="Nhập bình luận của bạn">
										</div>
										<html:hidden property="maBaiViet" name="baiVietForm" />
										<div class="form-group">
											<div class="col-sm-offset-2 col-sm-10">
												<html:submit styleClass="btn btn-info" property="submit"
													value="Bình luận" style="float: right;margin-top: 10px;"></html:submit>
											</div>
										</div>
									</html:form>
								</div>
								<div class="col-lg-12 divMain"
									style="height: 600px; margin-top: 10px; margin-bottom: 25px; overflow: scroll;">
									<logic:iterate id="binhLuan" name="baiVietForm"
										property="danhSachBinhLuan">
										<div class="col-lg-12 divMain"
											style="margin-left: 15px; margin-right: 15px; margin-top: 10px; height: auto;">
											<label class="col-sm-6" for="email">[<bean:write
													name="binhLuan" property="chucVu" />]
											</label><label class=col-sm-6
												style="text-align: right; padding-right: 20px;"><bean:write
													name="binhLuan" property="ngayBinhLuan" /> </label> <img
												class="col-sm-1 divMain"
												style="margin-left: 10px; margin-bottom: 5px;"
												alt="Avatar ^_^" src="image/anhCtv1.jpg" width="80px"
												height="60px">
											<div class="col-sm-10">
												<h5 class="title"
													style="margin-top: 15px; margin-bottom: 5px;">
													<h5 style="font-weight: bold; display: inline;">
														<bean:write name="binhLuan" property="tenTaiKhoan" />
														:
													</h5>
													<bean:write name="binhLuan" property="noiDungBinhLuan" />
												</h5>
											</div>
										</div>
									</logic:iterate>
								</div>
							</div>
						</div>

					</div>

				</div>
				<!-- body right -->
				<div class="col-lg-3" style="height: auto; padding-right: 0px;">
					<div class="col-lg-12 danhMuc"
						style="background-color: white; height: 500px">
						<div class="col-lg-12"
							style="background: url('image/menu2.png') no-repeat scroll 0px 10px; height: 46px; margin-left: 14px">
							<h5
								style="color: black; text-align: center; padding: 10px; margin: 0px; font-size: 1.2em">Bài
								viết xem nhiều nhất</h5>
						</div>
						<div class="col-lg-12"></div>
					</div>
					<div class="col-lg-12" style="height: 10px"></div>

					<div class="col-lg-12 danhMuc"
						style="background-color: white; height: 500px">
						<div class="col-lg-12"
							style="background: url('image/menu2.png') no-repeat scroll 0px 10px; height: 46px; margin-left: 14px">
							<h5
								style="color: black; text-align: center; padding: 10px; margin: 0px; font-size: 1.2em">Bài
								viết xem nhiều nhất</h5>
						</div>
						<div class="col-lg-12"></div>
					</div>
				</div>
			</div>
		</div>
		<!-- footer -->
		<div class="include" data-include="footer"></div>

	<script type="text/javascript">
		var noiDung= $("#noiDung").val();
		console.log("noiDung ="+noiDung);
		$("#noiDungBaiViet").append(noiDung);
	</script>
</body>
</html>
