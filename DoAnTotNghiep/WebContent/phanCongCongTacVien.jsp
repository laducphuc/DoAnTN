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
<title>Trang Admin- Phân công cộng tác viên dịch bài</title>
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
			perPage : 6
		});
	});
</script>

</head>
<body>
	<!-- header -->
	<div class="include" data-include="header"></div>
	<!-- menu -->
	<div id="tabMenu" class="col-lg-12">
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
						style="background: white; height: auto;">
						<div class="col-lg-12">
							<h4 style="font-size: 30px; text-align: center">
								<i class="fa fa-users"></i> Phân công Cộng tác viên
							</h4>
						</div>
						<!--  -->
						<html:form action="/phan-cong-cong-tac-vien" method="get">
							<div class="clo-lg-12">
								<div class="col-lg-3" style="margin-top: 20px;">
									<html:select property="tuKhoaTimKiem" styleClass="form-control">
										<option value="">-- Chọn thông tin --</option>
										<option value="MaThanhVien">Mã cộng tác viên</option>
										<option value="TenThanhVien">Tên cộng tác viên</option>
										<option value="TenTrinhDo">Trình độ</option>
										<option value="SoBaiDangNhan">Số bài đang nhận</option>
									</html:select>
								</div>
								<div class="col-lg-7" style="margin-top: 20px;">
									<html:text property="noiDungTimKiem" styleClass="form-control"></html:text>
								</div>
								<div class="col-lg-2" style="margin-top: 20px;">
									<html:submit styleClass="btn btn-info">Tìm kiếm</html:submit>
								</div>
							</div>
						</html:form>
						<!--  -->
						<div class="clo-lg-12">
							<div class="col-lg-7"></div>
							<div class="col-lg-2"></div>
						</div>
						<br>
						<div class="col-lg-12 bs-example" style="margin-top: 20px;">
							<div class="clo-lg-12">
								<h4>
									Danh sách cộng tác viên (
									<bean:write name="phanCongCongTacVienForm"
										property="soLuongCTV" />
									)
								</h4>
							</div>

							<!--  -->
							<div class="col-lg-12 thumbnail" style="min-height: 450px">
								<table class="table table-striped"
									style="width: 900px; min-height: 450px; display: block; position: absolute; white-space: nowrap; border-collapse: separate">
									<thead>
										<tr class="success">
											<th style="width: 10%;">Mã CTV</th>
											<th>Tên cộng tác viên</th>
											<th>Trình độ</th>
											<th>Số bài đang nhận</th>
											<th>Phân công dịch bài</th>
										</tr>
									</thead>
									<tbody id="showtable">
										<logic:iterate name="phanCongCongTacVienForm"
											property="danhSachThanhVien" id="thanhVien">
											<tr >
												<td scope="row"><bean:write name="thanhVien"
														property="maThanhVien" /></td>
												<td><bean:write name="thanhVien"
														property="tenThanhVien" /></td>
												<td><bean:write name="thanhVien" property="tenTrinhDo" />
												</td>
												<td style="text-align: center;"><bean:write
														name="thanhVien" property="soBaiDangNhan" /></td>
												<td style="text-align: center;"><bean:define
														id="maThanhVien" name="thanhVien" property="maThanhVien"></bean:define>
													<html:link
														action="/phan-cong-dich-bai?maThanhVien=${maThanhVien}">
														<span class="glyphicon glyphicon-edit"></span>
													</html:link></td>
											</tr>
										</logic:iterate>
									</tbody>
								</table>
							</div>
							<!--  -->
							<div class="col-lg-12"
								style="text-align: center; margin-bottom: 25px">
								<ul style="margin: 0px" class="pagination pagination-lg pager"
									id="myPager"></ul>
							</div>
						</div>
					</div>
				</div>

				<!-- body right -->
				<div class="col-lg-3" style="height: auto; padding-right: 0px;">
					<div class="col-lg-12 danhMuc"
						style="background: white; margin-top: 10px; margin-bottom: 20px;">
						<div
							style="background: url('image/menu2.png') no-repeat scroll 0px 10px; width: 240px; height: 46px; padding-top: 14px; padding-left: 41px;">
							<h5
								style="color: black; padding: 0px; margin: 0px; font-size: 1.2em">Thống
								kê</h5>
						</div>
						<ul>
							<li><html:link style="color: black;" action="/thong-ke.do">Bảng xếp hạng thành viên</html:link>
							</li>
							<li><html:link style="color: black;"
									action="/bang-xep-hang-cong-tac-vien.do">Bảng xếp hạng cộng tác viên</html:link>
							</li>
							<li><html:link style="color: black;"
									action="/bang-xep-hang-bai-viet.do">Bảng xếp hạng bài viết</html:link>
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