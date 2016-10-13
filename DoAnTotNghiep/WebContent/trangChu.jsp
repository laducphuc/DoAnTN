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
<title>Trang chủ</title>

<link rel="stylesheet" href="css/bootstrap.min.css">
<link rel="stylesheet" href="css/style.css" />
<link rel="stylesheet" href="css/songnguvietnhat3.css">
<link rel="stylesheet"
	href="font-awesome-4.4.0/css/font-awesome.min.css">
<link rel="stylesheet" href="css/songnguok.css" type="text/css">
<script src="js/jquery-1.11.2.min.js"></script>
<script src="js/bootstrap.min.js"></script>
<script src="js/jquery.validate.js" type="text/javascript"></script>
<script type="text/javascript" src="js/main.js"></script>
<script type="text/javascript" src="js/my-include.js"></script>
<script type="text/javascript" src="js/my-carousel.js"></script>
<script type="text/javascript" src="js/fix-menu.js"></script>
<script type="text/javascript" src="js/translate.js"></script>


</head>
<body>
	<!-- header -->
	<div class="include" data-include="header"></div>
	<jsp:include page="dangNhapForm.jsp"></jsp:include>
	<!-- menu -->

	<!-- form translate -->
	<div class="col-lg-3" id="form-tratu">
		<div class="col-lg-12" style="text-align: center">
			<label>Tra từ nhanh</label>
		</div>
		<div class="col-lg-12">
			<select id="source">
				<option value="jpn">Japanese</option>
				<option value="vie">Vietnamese</option>
			</select>
		</div>
		<div class="col-lg-12">
			<textarea id="mytext" rows="4" cols="35"></textarea>
		</div>
		<div class="col-lg-12">
			<select id="dest">
				<option value="vie">Vietnamese</option>
				<option value="jpn">Japanese</option>
			</select>
		</div>
		<div class="col-lg-12">
			<textarea id="result" rows="4" cols="35" disabled="disabled"></textarea>
		</div>
		<div class="col-lg-12" style="text-align: center; margin-top: 10px;">
			<input type="button" class="btn btn-default" value="Dịch"
				id="translate">
		</div>
	</div>
	<!-- body -->
	<div class="col-lg-12">
		<div class="col-lg-12" style="margin-top: 20px; padding: 0px;">
			<div class="col-lg-12" style="height: auto; padding: 0px">
				<div class="col-lg-9" style="height: auto; padding: 0px">
					<!-- Bắt đầu thể hiển thị nội dung chương trình -->
					<div class="col-lg-12">
						<div id="myCarousel" class="carousel slide" data-ride="carousel">
							<!-- Indicators -->
							<!-- Wrapper for slides -->
							<div class="carousel-inner">
								<logic:iterate id="baiViet" name="trangChuForm"
									property="danhSachBaiVietHienThi">
									<bean:define id="anh1" property="anh" name="baiViet"></bean:define>
									<bean:define id="ma" property="maBaiViet" name="baiViet"></bean:define>
									<div class="item">
										<html:link action="xem-bai-viet.do?maBaiViet=${ma }">
											<html:img src="pictures/${anh1 }" />
										</html:link>
										<div class="carousel-caption"></div>
									</div>
								</logic:iterate>

							</div>

							<!-- Controls -->
							<a class="left carousel-control" href="#myCarousel" role="button"
								data-slide="prev"> <span
								class="glyphicon glyphicon-chevron-left"></span>
							</a> <a class="right carousel-control" href="#myCarousel"
								role="button" data-slide="next"> <span
								class="glyphicon glyphicon-chevron-right"></span>
							</a>
						</div>
					</div>

					<div class="col-lg-12 divMain"
						style="background: white; height: auto;">
						<logic:iterate id="danhSachCon" name="trangChuForm"
							property="danhSachBaiVietMoiNhat">
							<div class="col-lg-12">
								<logic:iterate id="baiViet" name="danhSachCon">
									<bean:define id="anh" property="anh" name="baiViet"></bean:define>
									<bean:define id="maBaiViet" property="maBaiViet" name="baiViet"></bean:define>
									<div class="noidung col-lg-4 divMain">
										<div class="noidunghienthi col-lg-12" style="height: 220px;">
											<html:link action="xem-bai-viet.do?maBaiViet=${maBaiViet }"
												style="color: #1E90FF; font-size: 1.3em">
												<bean:write name="baiViet" property="tieuDeViet" />
											</html:link>
											<img alt="Noi Dung" src="pictures/${anh }" width="100"
												height="57"> <br>

											<p>
												<em><bean:write name="baiViet" property="ngayVietBai" />
												</em>
											</p>

											<p style="padding: 5px; color: black;">
												<bean:write name="baiViet" property="moTaNhat" />
											</p>
										</div>
										<p style="padding-left: 10px; padding-top: 10px;">

											<span class="hinhdoctiep"> <a
												href="xem-bai-viet?maBaiViet=${maBaiViet }"></a>
											</span>
										</p>
										<p class="binhchonoo" style="margin: 0px; float: left;">
											Danh Mục:
											<bean:write name="baiViet" property="tenDanhMucViet" />
										</p>

									</div>
								</logic:iterate>
							</div>
						</logic:iterate>
						<div class="col-lg-1"></div>
						<div class="col-lg-12">
							<div class="col-lg-3"></div>
							<bean:define id="trangCuoi" property="trangCuoi"
								name="trangChuForm"></bean:define>
							<div class="container col-lg-8">
								<div class="row">
									<ul class="pagination paper">
										<li><a href="trang-chu.do?soTrang=1">Trang đầu</a></li>
										<li><a href="#">&laquo;</a></li>
										<logic:iterate id="soTrang" property="tongSoTrang"
											name="trangChuForm">
											<li><a href="trang-chu.do?soTrang=${soTrang }"><bean:write
														name="soTrang" /> </a></li>
										</logic:iterate>
										<li><a href="#">&raquo;</a></li>
										<li><a href="trang-chu.do?soTrang=${trangCuoi }">Trang
												cuối</a></li>
									</ul>
								</div>
							</div>
						</div>
					</div>
				</div>
				<!-- Kết thúc thể hiển thị nội dung chương trình -->
				<!-- body right -->
				<div class="col-lg-3">
					<div class="col-lg-12 thanhVienNoiBat">
						<div class="col-lg-12">
							<label><span class="glyphicon glyphicon-user"></span>
								Cộng Tác Viên Nổi Bật</label>
						</div>
						<div class="col-lg-12">
							<hr style="border: 1px solid #ddd; margin: 2px 0px;">
						</div>
						<logic:iterate id="thanhVien" name="trangChuForm"
							property="bXHCongTacVien">
							<div class="col-lg-12">

								<h6>
									<span class="glyphicon glyphicon-minus"></span>
									<bean:write name="thanhVien" property="tenThanhVien" />
								</h6>
							</div>
						</logic:iterate>

						<div class="col-lg-12" style="margin-top: 20px;">
							<label><span class="glyphicon glyphicon-user"></span>
								Thành Viên Nổi Bật</label>
						</div>
						<div class="col-lg-12">
							<hr style="border: 1px solid #ddd; margin: 2px 0px;">
						</div>
						<logic:iterate id="thanhVien" name="trangChuForm"
							property="bXHThanhVien">
							<div class="col-lg-12">

								<h6>
									<span class="glyphicon glyphicon-minus"></span>
									<bean:write name="thanhVien" property="tenThanhVien" />
								</h6>
							</div>
						</logic:iterate>
					</div>
					<bean:define id="avatar" property="avatar" name="trangChuForm"></bean:define>
					<div class="col-lg-12"
						style="background:url('gif/${avatar }.gif') no-repeat;height: 300px; margin-top:20px; ">
					</div>
					<div class="col-lg-12 thanhVienNoiBat" style="margin-top: 20px;">
						<div class="col-lg-12">
							<label><span class="glyphicon glyphicon-book"></span> Bài
								Viết Được Yêu Thích</label>
						</div>
						<div class="col-lg-12">
							<hr style="border: 1px solid #ddd; margin: 2px 0px;">
						</div>

						<ul>
							<logic:iterate id="baiVietHot" name="trangChuForm"
								property="bXHBaiViet">
								<bean:define id="mabv" property="maBaiViet" name="baiVietHot"></bean:define>
								<li><html:link action="/xem-bai-viet.do?maBaiViet=${mabv }">
										<span class="glyphicon glyphicon-minus"></span>
										<bean:write name="baiVietHot" property="tieuDeViet" />
									</html:link></li>
							</logic:iterate>
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