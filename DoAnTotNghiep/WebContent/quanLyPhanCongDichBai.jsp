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
<title>Trang Admin- Quản lý phân công dịch bài</title>
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
			perPage : 4
		});
	});
</script>

</head>
<body>
	<!-- header -->
	<div class="include" data-include="header"></div>
	<!-- menu -->
	<div id="tabMenu" class="col-lg-12" style="padding: 0px;">
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
						style="background: white; height: auto;">

						<div class="col-lg-12">
							<h4 style="font-size: 30px; text-align: center;">
								<i class="fa fa-users"></i> Quản lý Phân công dịch bài
							</h4>
						</div>
						<!--  -->
						<bean:define id="trangThai" name="quanLyPhanCongDichBaiForm"
							property="trangThai"></bean:define>
						<html:form action="/quan-ly-phan-cong-dich-bai?" method="get">
							<div class="col-lg-12">

								<div class="col-lg-3" style="margin-top: 20px;">
									<html:select property="tuKhoaTimKiem" styleClass="form-control">
										<option value="">-- Chọn thông tin --</option>
										<option value="MaBaiViet">Mã bài viết</option>
										<option value="TenDanhMucViet">Thể loại</option>
										<option value="TenThanhVien">Người dịch</option>
										<option value="NgayPhanCong">Ngày phân công</option>
									</html:select>
								</div>

								<div class="col-lg-7" style="margin-top: 20px;">
									<html:text property="noiDungTimKiem" styleClass="form-control"></html:text>
								</div>

								<div class="col-lg-2" style="margin-top: 20px;">
									<html:submit styleClass="btn btn-info">Tìm kiếm</html:submit>
								</div>
							</div>
							<div class="col-lg-12">
								<html:hidden name="quanLyPhanCongDichBaiForm"
									property="trangThai" styleClass="form-control"></html:hidden>
							</div>
						</html:form>
						<!--  -->

						<div class="col-lg-12" style="margin-top: 20px">
							<div class="col-lg-3">
								<html:link styleClass="btn btn-info"
									action="/phan-cong-cong-tac-vien">Phân công cộng tác viên</html:link>
							</div>
							<div class="col-lg-7"></div>
							<div class="col-lg-2"></div>
						</div>

						<br>

						<div class="col-lg-12 bs-example" style="margin-top: 20px">
							<div class="col-lg-12">
								<html:link action="/quan-ly-phan-cong-dich-bai?trangThai=Tatca">Tất cả (<bean:write
										name="quanLyPhanCongDichBaiForm" property="tongSoPhanCong" />) | </html:link>
								<html:link
									action="/quan-ly-phan-cong-dich-bai?trangThai=Dichxong">Bài đã dịch (<bean:write
										name="quanLyPhanCongDichBaiForm" property="tongSoDaDich" />) | </html:link>
								<html:link
									action="/quan-ly-phan-cong-dich-bai?trangThai=Dangdich">Bài đang dịch (<bean:write
										name="quanLyPhanCongDichBaiForm" property="tongSoDangDich" />) | </html:link>
								<html:link action="/quan-ly-phan-cong-dich-bai?trangThai=Tuchoi">Bài từ chối (<bean:write
										name="quanLyPhanCongDichBaiForm" property="tongSoTuChoi" />) | </html:link>
								<html:link
									action="/quan-ly-phan-cong-dich-bai?trangThai=Chuanhan">Bài chưa nhận (<bean:write
										name="quanLyPhanCongDichBaiForm" property="tongSoChuaNhan" />) | </html:link>
								<html:link
									action="/quan-ly-phan-cong-dich-bai?trangThai=Quanhan">Quá hạn (<bean:write
										name="quanLyPhanCongDichBaiForm" property="tongSoQuaHan" />)</html:link>
								<html:link
									action="/quan-ly-phan-cong-dich-bai?trangThai=Quanhan">Bài mới (<bean:write
										name="quanLyPhanCongDichBaiForm" property="tongSoQuaHan" />)</html:link>
							</div>


							<!--  -->
							<div class="col-lg-12 thumbnail" style="min-height: 550px">
								<table class="table table-striped"
									style="width: 900px; min-height: 450px; display: block; position: absolute; white-space: nowrap; border-collapse: separate">
									<thead>
										<tr class="success">
											<th>Mã bài viết</th>
											<th>Tên bài viết</th>
											<th>Thể loại</th>
											<th>Người dịch</th>
											<th>Ngày phân công</th>
											<th>Hạn dịch bài</th>
											<th>Tình trạng</th>
											<th>Duyệt bài</th>
										</tr>
									</thead>
									<tbody id="showtable">
										<logic:iterate name="quanLyPhanCongDichBaiForm"
											property="danhSachPhanCong" id="phanCong">
											<tr>
												<td><bean:write name="phanCong" property="maBaiViet" /></td>
												<td
													style="word-wrap: break-word; min-width: 300x; max-width: 400px; white-space: normal;"><bean:write
														name="phanCong" property="tieuDeViet" /></td>
												<td><bean:write name="phanCong" property="tenDanhMuc" />
												</td>
												<td><bean:write name="phanCong" property="tenThanhVien" />
												</td>
												<td><bean:write name="phanCong" property="ngayPhanCong" />
												</td>
												<td><bean:write name="phanCong"
														property="ngayTraBaiDich" /></td>
												<td><bean:write name="phanCong" property="trangThai" />
												</td>
												<td style="text-align: center;"><bean:define
														id="maBaiViet" name="phanCong" property="maBaiViet"></bean:define>
													<html:link action="/duyet-bai-dich?&maBaiViet=${maBaiViet}">
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