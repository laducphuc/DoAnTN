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
<title>Trang Admin- Xem bài viết đã dịch</title>
<link rel="stylesheet"
	href="font-awesome-4.4.0/css/font-awesome.min.css">
<link rel="stylesheet" href="css/songnguvietnhat3.css">
<link rel="stylesheet" href="css/bootstrap.min.css">
<link rel="stylesheet" href="css/star-rating.min.css">
<link rel="stylesheet" href="css/star-rating.css">
<link rel="stylesheet" href="css/style.css" />
<link rel="stylesheet" href="css/chart.css" />
<script src="js/jquery-1.11.2.min.js"></script>
<script src="js/bootstrap.min.js"></script>
<script src="js/star-rating.min.js"></script>
<script src="js/jchart.js"></script>
<script type="text/javascript" src="js/my-include.js"></script>
<script type="text/javascript" src="js/fix-menu.js"></script>
<style type="text/css">
</style>
<script type="text/javascript">
	$(document).ready(function() {
		$("#population_chart").jChart({
			name : "Đánh Giá Chi Tiết (Đơn vị : %)",
			headers : [ "5 sao", "4 sao", "3 sao", "2 sao", "1 sao" ],
			values : [ 25, 47, 88, 42, 42 ],
			footers : [ 10, 20, 30, 40, 50, 60, 70, 80, 90, 100 ],
			colors : [ "#AAAAAA", "#555555", "#AAAAAA", "#555555", "#AAAAAA" ]
		});
	});
</script>
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
								style="width: 40px; height:40px" />
								 <bean:write name="taikhoan"
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
						<div class="col-lg-12" style="margin-top: 30px;">
							<bean:define id="baiViet" name="baiVietForm" property="baiViet"></bean:define>
							<div class="col-lg-6">
								<h4 style="font: bold; font-size: 30px">
									<bean:write name="baiViet" property="tieuDeViet" />
								</h4>
							</div>
							<div class="col-lg-6">
								<h4 style="font: bold; font-size: 30px">
									<bean:write name="baiViet" property="tieuDeNhat" />
								</h4>
							</div>
							<div class="col-lg-12">
								<h5 class="title">
									<i class="fa fa-user"></i> Tác giả:
									<bean:write name="baiViet" property="tenThanhVien" />
								</h5>
								<h5 class="title">
									<i class="fa fa-clock-o"></i> Ngày đăng:
									<bean:write name="baiViet" property="ngayVietBai" />
								</h5>
								<h5 class="title">
									<i class="fa fa-eye"></i> Lượt xem:
									<bean:write name="baiViet" property="luotXem" />
								</h5>
							</div>

							<div class="col-lg-6" style="height: 264px;">
								<bean:define id="anh" name="baiViet" property="anh"></bean:define>
								<img alt="Ảnh của bài viết" src="pictures/${anh }" width="390px"
									height="270px" style="border: 1px solid #725a65;">
							</div>

							<div class="col-lg-6">
								<label class="control-label col-sm-12" style="text-align: left;"><i
									class="fa fa-file-text"></i> Mô tả bài viết:</label>
							</div>
							<div class="col-lg-6">
								<h5 class="title">
									<bean:write name="baiViet" property="moTaViet" />
								</h5>
							</div>
							<div class="col-lg-6" style="margin-top: 15px">
								<label class="control-label col-sm-12" style="text-align: left;"><i
									class="fa fa-file-text"></i> 記事の説明:</label>
							</div>
							<div class="col-lg-6">
								<h5 class="title">
									<bean:write name="baiViet" property="moTaNhat" />
								</h5>
							</div>
							<div class="col-lg-12" style="height: 20px"></div>
							<div class="col-lg-6">
								<label class="control-label col-sm-12" style="text-align: left;">
									<i class="fa fa-text-width"></i> Nội dung bài viết:
								</label>
							</div>
							<div class="col-lg-6">
								<label class="control-label col-sm-12" style="text-align: left;"><i
									class="fa fa-text-width"></i> コンテンツの記事:</label>
							</div>
							<div class="col-lg-6">
								<div class="col-lg-12 divMain" style="height: auto;">
									<logic:iterate id="noiDungViet" name="baiViet"
										property="arrNoiDungViet">
										<h5 style="margin-left: 5px; margin-right: 5px; height: 90px;">
											<bean:write name="noiDungViet" />
										</h5>
									</logic:iterate>
								</div>
							</div>
							<div class="col-lg-6">
								<div class="col-lg-12 divMain" style="height: auto;">
									<logic:iterate id="noiDungNhat" name="baiViet"
										property="arrNoiDungNhat">
										<h5 style="margin-left: 5px; margin-right: 5px; height: 90px;">
											<bean:write name="noiDungNhat" />
										</h5>
									</logic:iterate>

								</div>
							</div>

							<div class="col-lg-12" style="margin-top: 20px">
								<h5 class="title">
									<i class="fa fa-user"></i> Người dịch:
									<bean:write name="baiViet" property="tenCongTacVien" />
								</h5>
							</div>
							<div class="col-lg-12">
								<h5 class="title">
									<bean:define id="soSao" name="baiViet" property="soSao"></bean:define>
									<i class="fa fa-creative-commons"></i> Đánh Giá Chung Về Bài
									Dịch: <input id="rating-input" type="number" class="rating"
										min=0 max=5 step=1 data-size="xs" value="${soSao}"
										data-rtl="false" data-default-caption="{rating} Sao"
										data-star-captions="{}" data-disabled="true">
								</h5>
							</div>
							<div class="col-lg-12">
								<div class="col-lg-5">
									<font style="color: red;"> <html:errors
											property="xoaBaiVietError" />
									</font>
								</div>
								<bean:define id="maBaiViet" name="baiViet" property="maBaiViet"></bean:define>
								<div class="clo-lg-7"
									style="margin-bottom: 30px; text-align: right;">
									<html:link styleClass="btn btn-primary"
										action="/dang-bai-viet?maBaiViet=${maBaiViet}">
										<i class="fa fa-check-circle-o"></i>
										Đăng bài</html:link>
									<html:link styleClass="btn btn-primary"
										action="/cap-nhat-bai-viet?maBaiViet=${maBaiViet}">
										<i class="fa fa-pencil-square-o"></i>
										Cập nhật bài viết</html:link>
									<html:link styleClass="btn btn-primary"
										action="/xoa-bai-viet?maBaiViet=${maBaiViet}"
										onclick="return confirm('Bạn có chắc chắn muốn xóa bài viết này không?')">
										<i class="fa fa-trash-o"></i>
										Xóa bài viết</html:link>
								</div>
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
