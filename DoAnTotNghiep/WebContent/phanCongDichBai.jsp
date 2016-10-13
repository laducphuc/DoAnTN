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
<title>Trang Admin- Phân công bài viết cần dịch cho CTV</title>
<link rel="stylesheet"
	href="font-awesome-4.4.0/css/font-awesome.min.css">
<link rel="stylesheet" href="css/bootstrap.min.css">
<link rel="stylesheet" href="css/songnguvietnhat3.css">
<link rel="stylesheet" href="css/style.css" />
<link rel="stylesheet" href="css/datepicker.css">
<script src="js/jquery-1.11.2.min.js"></script>
<script src="js/bootstrap.min.js"></script>
<script src="js/bootstrap-formhelpers.js"></script>
<script src="js/bootstrap-formhelpers.min.js"></script>
<script src="js/bootstrap-datepicker.js"></script>
<script src="js/PaginationJS.js"></script>
<script type="text/javascript" src="js/my-include.js"></script>
<script type="text/javascript" src="js/fix-menu.js"></script>
<script type="text/javascript">
	$(document).ready(function() {
		$('#ngay').datepicker({
			format : "yyyy-mm-dd"
		});
	});

	$(document).ready(function() {

		$('#showtable').pageMe({
			pagerSelector : '#myPager',
			showPrevNext : true,
			hidePageNumbers : false,
			perPage : 4
		});
	});
</script>
<style type="text/css">
</style>
</head>
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
						style="height: auto; background: white;">
						<div class="col-lg-1"></div>
						<div class="col-lg-10">
							<html:form action="/phan-cong-dich-bai" method="post">
								<div class="col-lg-12">
									<h4
										style="font-size: 30px; margin-top: 30px; margin-left: 140px;">
										<i class="fa fa-users"></i> Phân công dịch bài
									</h4>
								</div>
								<div class="col-lg-12" style="border-bottom: 1px solid #725a65;">
									<h4>
										<i class="fa fa-info"></i> Thông tin thành viên
									</h4>
								</div>
								<html:hidden property="maThanhVien" name="phanCongDichBaiForm" />
								<div class="row form-group">
									<label class="control-label col-sm-12"
										style="text-align: left;"><i class="fa fa-user"></i>
										Tên cộng tác viên:</label>
									<div class="col-sm-8">
										<html:text name="phanCongDichBaiForm" property="tenThanhVien"
											styleClass="form-control" disabled="true"></html:text>
									</div>
									<div class="col-sm-4">
										<html:radio name="phanCongDichBaiForm" property="gioiTinh"
											value="1" disabled="true" style="margin-right: 10px;">Nam</html:radio>
										<html:radio name="phanCongDichBaiForm" property="gioiTinh"
											value="0" disabled="true" style="margin: 0px 10px 0px 30px;">Nữ</html:radio>
									</div>
								</div>

								<div class="row form-group">
									<label class="control-label col-sm-12"
										style="text-align: left;"><i class="fa fa-language"></i>
										Ngôn ngữ:</label>
									<div class="col-sm-12">
										<html:text name="phanCongDichBaiForm" property="ngonNgu"
											styleClass="form-control" disabled="true"></html:text>
									</div>

								</div>
								<div class="row form-group">
									<label class="control-label col-sm-12"
										style="text-align: left;"><i class="fa fa-file-text-o"></i>
										Tổng số bài đã dịch:</label>
									<div class="col-sm-12">
										<html:text name="phanCongDichBaiForm" property="soBaiDaDich"
											styleClass="form-control" disabled="true"></html:text>
									</div>
								</div>
								<div class="row form-group">
									<label class="control-label col-sm-12"
										style="text-align: left;"><i class="fa fa-calendar-o"></i>
										Ngày phân công dịch:</label>
									<div class="col-sm-12">
										<html:text name="phanCongDichBaiForm" property="ngayPhanCong"
											styleId="ngay" styleClass="form-control" disabled="true"></html:text>
									</div>
								</div>
								<div class="row form-group">
									<label class="control-label col-sm-12"
										style="text-align: left;"><i
										class="fa fa-sort-numeric-asc"></i> Số ngày dịch bài:</label>
									<div class="col-lg-12">
										<html:select name="phanCongDichBaiForm"
											property="soNgayDichBai" styleClass="form-control">
											<option value="3">3 ngày</option>
											<option value="5">5 ngày</option>
											<option value="7">7 ngày</option>
											<option value="10">10 ngày</option>
										</html:select>
									</div>
								</div>

								<div class="row form-group">
									<label class="control-label col-sm-12"
										style="text-align: left;"><i class="fa fa-comment"></i>
										Ghi chú thêm:</label>
									<div class="col-sm-12">
										<html:textarea styleClass="form-control"
											name="phanCongDichBaiForm"
											style="height: 120px; resize: none;"
											property="noiDungBinhLuan" cols="80" rows="2"></html:textarea>
									</div>
								</div>

								<div class="col-lg-12" style="border-bottom: 1px solid #725a65;">
									<h4>
										<i class="fa fa-list"></i> Danh sách bài chưa dịch
									</h4>
								</div>

								<!-- danh sach bai chua dich -->
								<div class="col-lg-12 thumbnail" style="min-height: 350px">
									<table class="table table-striped"
										style="min-height: 450px; display: block; white-space: nowrap; border-collapse: separate">
										<thead>
											<tr class="success">
												<th style="width: 10%;">Mã bài viết</th>
												<th>Tên bài viết</th>
												<th>Thể loại</th>
												<th>Người viết</th>
												<th>Ngày đăng</th>
												<th>Phân công</th>
												<th></th>
											</tr>
										</thead>
										<tbody id="showtable">
											<logic:iterate name="phanCongDichBaiForm"
												property="danhSachBaiViet" id="baiViet">
												<tr>
													<td scope="row"><bean:write name="baiViet"
															property="maBaiViet" /></td>
													<td
														style="word-wrap: break-word; min-width: 200x; max-width: 200px; white-space: normal;"><bean:write
															name="baiViet" property="tieuDeViet" /></td>
													<td><bean:write name="baiViet"
															property="tenDanhMucViet" /></td>
													<td><bean:write name="baiViet" property="tenThanhVien" />
													</td>
													<td><bean:write name="baiViet" property="ngayVietBai" />
													</td>
													<td style="text-align: center;"><bean:define
															id="maBaiViet" name="baiViet" property="maBaiViet"></bean:define>
														<html:multibox name="phanCongDichBaiForm"
															property="arrMaBaiViet">
															<bean:write name="maBaiViet" />
														</html:multibox></td>
												</tr>
											</logic:iterate>
										</tbody>
									</table>
								</div>
								<div class="col-lg-12" style="text-align: center;">
									<ul style="margin: 0px" class="pagination pagination-lg pager"
										id="myPager"></ul>
								</div>
								<div class="col-sm-12">
									<font style="color: red;"> <html:errors
											property="chuaChonBaiVietError" />
									</font>
								</div>
								<div class="row form-group"
									style="float: right; margin-right: 3px;">
									<div class="clo-sm-6">
										<html:submit styleClass="btn btn-info" property="submit"
											value="Phân công dịch"></html:submit>
										<html:link styleClass="btn btn-info"
											action="/phan-cong-cong-tac-vien">Quay lại</html:link>
									</div>
								</div>
							</html:form>
						</div>
						<div class="col-lg-1"></div>
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