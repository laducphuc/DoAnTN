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
<title>Bài viết nhận dịch</title>
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
<script type="text/javascript">
	$(document).ready(function() {

		$('#showtable').pageMe({
			pagerSelector : '#myPager',
			showPrevNext : true,
			hidePageNumbers : false,
			perPage : 2
		});
	});
</script>
</head>
<body >
	<!-- header -->
	<div class="include" data-include="header"></div>
	<!-- menu -->
	<div class="col-lg-12" id="tabMenu" >
			<div class="col-lg-12" id="menuItems">
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
	</div>

	<!-- boby -->
	<div class="col-lg-12">
		
		<div class="col-lg-12" style="margin-top: 20px; padding: 0px;">
			<div class="col-lg-12" style="height: auto; padding: 0px">
				<!-- body main -->
				<div class="col-lg-9" style="height: auto; padding: 0px">
					<div class="col-lg-12 divMain" style="height: auto;">
						<div class="col-lg-12">
							<h4 style="font-size: 30px; text-align: center;">
								<i class="fa fa-users"></i> Bài viết đã nhận dịch
							</h4>
						</div>
						<div class="col-lg-12" style="border-bottom: 1px solid blue;">
							<h4>
								<i class="fa fa-list"></i> Danh sách các bài viết bạn đã chấp
								nhận dịch (
								<bean:write name="danhSachBaiVietForm" property="soBaiViet" />
								)
							</h4>
						</div>
						<div class="col-lg-12 thumbnail" style="min-height: 500px; height: auto;">
							<table class="table table-striped"
								style="min-height: 450px; height:auto; display: block; position: absolute; white-space: nowrap; border-collapse: separate">
								<thead>
									<tr class="success">
										<th>Mã Bài Viết</th>
										<th width="15%">Tiêu Đề</th>
										<th>Thể Loại</th>
										<th width="20%">Mô Tả</th>
										<th>Ngày Phân Công</th>
										<th>Ngày Nhận Bài</th>
										<th>Hạn Dịch</th>
										<th>Dịch Bài</th>
									</tr>
								</thead>
								<tbody id="showtable">
									<bean:define id="maThanhVien" name="dangNhapForm"
										property="maThanhVien" scope="session"></bean:define>
									<logic:iterate id="danhSachBaiViet" name="danhSachBaiVietForm"
										property="danhSachBaiViet">
										<tr>
											<bean:define id="maBaiViet" name="danhSachBaiViet"
												property="maBaiViet"></bean:define>
											<td><bean:write name="danhSachBaiViet"
													property="maBaiViet" /></td>
											<td style="word-wrap: break-word; min-width: 200x; max-width: 200px; white-space: normal;"><bean:write name="danhSachBaiViet"
													property="tieuDeViet" /></td>
											<td width="12%"><bean:write name="danhSachBaiViet"
													property="tenDanhMucViet" /></td>
											<td style="word-wrap: break-word; min-width: 200x; max-width: 200px; white-space: normal;"><bean:write name="danhSachBaiViet"
													property="moTaViet" /></td>
											<td width="13%"><bean:write name="danhSachBaiViet"
													property="ngayPhanCong" /></td>
											<td width="13%"><bean:write name="danhSachBaiViet"
													property="ngayChapNhan" /></td>
											<td width="17%"><bean:write name="danhSachBaiViet"
													property="ngayHanDichBai" /></td>
											<td width="12%"><html:link
													style="color:black;text-decoration : underline;"
													action="/dich-bai-viet.do?maBaiViet=${maBaiViet}&maThanhVien=${maThanhVien }">
													<span class="glyphicon glyphicon-edit"></span>
												</html:link></td>
										</tr>
									</logic:iterate>
								</tbody>
							</table>
						</div>
						<div class="col-lg-12"
							style="text-align: center; margin-bottom: 25px">
							<div class="col-lg-4"></div>
							<div class="col-lg-4">
								<ul style="margin: 0px" class="pagination pagination-lg pager"
									id="myPager"></ul>
							</div>
						</div>
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