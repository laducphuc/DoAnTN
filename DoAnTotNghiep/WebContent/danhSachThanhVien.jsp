<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>
<%@ taglib uri="http://struts.apache.org/tags-tiles" prefix="tiles"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="UTF-8">
<title>Trang Admin- Danh sách thành viên</title>
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
			perPage : 10
		});
	});
</script>

</head>
<body>
	<!-- header -->
	<div class="include" data-include="header"></div>
	<!-- menu -->
	<div id="tabMenu" class="col-lg-12 tabMenu" style="padding: 0px;">
		<div id="menuItems" class="col-lg-12">

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
						style="background: white; height: auto;">

						<div class="col-lg-12">
							<h4 style="font-size: 30px; text-align: center;">
								<i class="fa fa-users"></i> Quản lý thành viên
							</h4>
						</div>

						<html:form action="/danh-sach-thanh-vien" method="get">
							<div class="col-lg-12" style="margin-top: 20px">
								<div class="col-lg-3">
									<html:select property="tuKhoaTimKiem" styleClass="form-control"
										style="width: 180px">
										<option value="">-- Chọn thông tin --</option>
										<option value="MaThanhVien">Mã thành viên</option>
										<option value="TenThanhVien">Tên thành viên</option>
										<option value="TenTaiKhoan">Tên đăng nhập</option>
										<option value="GioiTinh">Giới tình</option>
									</html:select>
								</div>
								<div class="col-lg-7">
									<html:text property="noiDungTimKiem" styleClass="form-control"></html:text>
								</div>
								<div class="col-lg-2">
									<html:submit styleClass="btn btn-info">Tìm kiếm</html:submit>
								</div>
							</div>
						</html:form>
						<div class="col-lg-12" style="margin-top: 20px">
							<div class="col-lg-3">
								<html:link styleClass="btn btn-info" style="width: 180px"
									action="/dang-ky-thanh-vien">
									<i class="fa fa-plus"></i>
									Thêm thành viên mới</html:link>
							</div>
							<div class="col-lg-7"></div>
							<div class="col-lg-2"></div>
						</div>
						<div class="col-lg-12" style="border-bottom: 1px solid blue;">
							<h4>
								<i class="fa fa-list"></i> Danh sách thành viên (
								<bean:write name="danhSachThanhVienForm" property="soThanhVien" />
								)
							</h4>
						</div>
						<div class="col-lg-12" style="min-height: 500px; padding: 0px;">
							<table class="table table-striped"
								style="width: 100%; display: block; position: absolute; white-space: nowrap; border-collapse: separate; height: 500px; overflow: auto;">
								<thead>
									<tr class="success">
										<th style="width: 10%">Mã thành viên</th>
										<th>Tên thành viên</th>
										<th>Tên đăng nhập</th>
										<th>Giới tính</th>
										<th>Loại thành viên</th>
										<th>Xem</th>

									</tr>
								</thead>
								<tbody id="showtable">
									<logic:iterate name="danhSachThanhVienForm"
										property="danhSachThanhVien" id="thanhVien">
										<tr>
											<td scope="row"><bean:write name="thanhVien"
													property="maThanhVien" /></td>
											<td><bean:write name="thanhVien" property="tenThanhVien" /></td>
											<td><bean:write name="thanhVien" property="tenTaiKhoan" />
											</td>
											<td><bean:write name="thanhVien" property="gioiTinh" />
											</td>
											<td><bean:write name="thanhVien" property="tenCapDo" />
											</td>
											<td><bean:define id="maThanhVien" name="thanhVien"
													property="maThanhVien"></bean:define> <bean:define
													id="chucVu" name="thanhVien" property="chucVu"></bean:define>
												<html:link
													action="/thong-tin-thanh-vien?maThanhVien=${maThanhVien}&chucVu=${chucVu}">
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
		<div class="col-lg-1"></div>
	</div>
	<!-- footer -->
	<div class="include" data-include="footer"></div>

</body>
</html>