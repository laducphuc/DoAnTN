<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>
<%@ taglib uri="http://struts.apache.org/tags-tiles" prefix="tiles"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8" />
<meta name="author" content="NguyetNT BK" />
<title>Website Tin Tức - Dịch Thuật Việt - Nhật</title>

<link rel="stylesheet" type="text/css" href="css/bootstrap.min.css">
<link rel="stylesheet" type="text/css"
	href="css/mycss/styleintroduce.css">
<link rel="stylesheet"
	href="font-awesome-4.4.0/css/font-awesome.min.css">
<script src="js/jquery-1.11.2.min.js"></script>
<script src="js/bootstrap.min.js"></script>

<script type="text/javascript">
	$(document).ready(function() {
		var documentEl = $(document);
		var anhGioiThieu = $("#anhGioiThieu");
		documentEl.on("scroll", function() {
			var currscrollpos = $(documentEl).scrollTop();
			$(anhGioiThieu).css("Top", "0" + -currscrollpos / 4 + "px");
		});
	});
</script>
<script type="text/javascript">
	$(document).ready(function() {
		var documentEl = $(document);
		var flagBlack = true;
		documentEl.on("scroll", function() {
			var currscrollpos = $(documentEl).scrollTop();
			console.log("" + currscrollpos);
			if (currscrollpos >= 100 && flagBlack == true) {
				$("#divBaiMoi").css("bottom", "0");
				$("#divBaiMoi").css("background-color", "white");
				flagBlack = false;
			}
		});
	});
</script>
<script type="text/javascript">
	$(document).ready(function() {
		var documentEl = $(document);
		var flagDivCTV = true;
		var flagDivTV = true;
		documentEl.on("scroll", function() {
			var currscrollpos = $(documentEl).scrollTop();
			if (currscrollpos >= 530 && flagDivCTV == true) {
				$("#divCTV").css("bottom", "0");
				$("#divCTV").css("background-color", "white");
				flagDivCTV = false;
			}
			if (currscrollpos >= 930 && flagDivTV == true) {
				$("#divTV").css("bottom", "0");
				$("#divTV").css("background-color", "white");
				flagTV = false;
			}
		});
	});
</script>
</head>
<body>
	<div id="anhGioiThieu">
		<div class="khungGioiThieu">
			<h1 id="tieuDe">Dịch Thuật Việt - Nhật</h1>
			<html:link styleClass="m-btn" action="/trang-chu.do">Trang chủ</html:link>
			<html:link styleClass="m-btn" action="/dang-nhap.do">Đăng nhập</html:link>
		</div>
	</div>
	<div class="outBlack">
		<div class="container black" id="divBaiMoi">
			<div class="row">
				<div class="col-lg-offset-1 col-lg-2">
					<html:link action="/trang-chu">
						<input class=" m-btn-title " type="button"
							value="Bài Viết Mới Nhất" />
					</html:link>
				</div>
			</div>
			<div class="row">
				<div class="col-lg-offset-1 col-lg-10">
					<div id="slideBaiMoi" class="carousel slide" data-ride="carousel">
						<div class="carousel-inner">
							<logic:iterate id="danhSachCon" name="trangChuForm"
								property="danhSachBaiVietMoiNhat" indexId="myIndex">
								<logic:equal value="0" name="myIndex">
									<div class="item active">
										<div class="row">
											<logic:iterate id="baiViet" name="danhSachCon">
												<div class="col-lg-6">
													<div class="itemBaiMoi">
														<div class="row">
															<div class="col-lg-6">
																<h5 class="col-lg-12">
																	<bean:define id="maBaiViet" name="baiViet"
																		property="maBaiViet"></bean:define>
																	<html:link
																		action="/xem-bai-viet.do?maBaiViet=${maBaiViet }">
																		<bean:write name="baiViet" property="tieuDeNhat" />
																	</html:link>
																</h5>
																<h5 class="col-lg-12 my-ellipsis">
																	<bean:write name="baiViet" property="tieuDeViet" />
																</h5>
															</div>
															<div class="col-lg-6">
																<bean:define id="anh" name="baiViet" property="anh"></bean:define>
																<img alt="hinh" src="pictures/${anh }"
																	style="width: 100%; height: 100px;">
															</div>

														</div>
														<div class="row">
															<p class="col-lg-6">
																<bean:write name="baiViet" property="ngayVietBai" />
															</p>
															<p class="col-lg-6">
																Nguười đăng :
																<bean:write name="baiViet" property="tenThanhVien" />
															</p>
														</div>
														<div class="row">
															<p class="col-lg-12 my-ellipsis">
																<bean:write name="baiViet" property="moTaNhat" />
															</p>
														</div>
														<div class="row">
															<p class="col-lg-12">
																<html:link
																	action="/xem-bai-viet.do?maBaiViet=${maBaiViet}">Xem thêm <span
																		class="glyphicon glyphicon-chevron-right"></span>
																</html:link>
															</p>
														</div>
													</div>
												</div>
											</logic:iterate>
										</div>
									</div>
								</logic:equal>
								<logic:notEqual value="0" name="myIndex">
									<div class="item">
										<div class="row">
											<logic:iterate id="baiViet" name="danhSachCon">
												<div class="col-lg-6">
													<div class="itemBaiMoi">
														<div class="row">
															<div class="col-lg-6">
																<h5 class="col-lg-12">
																	<bean:define id="maBaiViet" name="baiViet"
																		property="maBaiViet"></bean:define>
																	<html:link
																		action="/xem-bai-viet.do?maBaiViet=${maBaiViet }">
																		<bean:write name="baiViet" property="tieuDeNhat" />
																	</html:link>
																</h5>
																<h5 class="col-lg-12 my-ellipsis">
																	<bean:write name="baiViet" property="tieuDeViet" />
																</h5>
															</div>
															<div class="col-lg-6">
																<bean:define id="anh" name="baiViet" property="anh"></bean:define>
																<img alt="hinh" src="pictures/${anh }"
																	style="width: 100%; height: 100px;">
															</div>

														</div>
														<div class="row">
															<p class="col-lg-6">
																<bean:write name="baiViet" property="ngayVietBai" />
															</p>
															<p class="col-lg-6">
																Người đăng :
																<bean:write name="baiViet" property="tenThanhVien" />
															</p>
														</div>
														<div class="row">
															<p class="col-lg-12 my-ellipsis">
																<bean:write name="baiViet" property="moTaNhat" />
															</p>
														</div>
														<div class="row">
															<p class="col-lg-12">
																<html:link
																	action="/xem-bai-viet.do?maBaiViet=${maBaiViet}">Xem thêm <span
																		class="glyphicon glyphicon-chevron-right"></span>
																</html:link>
															</p>
														</div>
													</div>
												</div>
											</logic:iterate>
										</div>
									</div>
								</logic:notEqual>
							</logic:iterate>
						</div>
						<!-- Controls -->
						<a class="left carousel-control" href="#slideBaiMoi" role="button"
							data-slide="prev"> <span
							class="glyphicon glyphicon-chevron-left"></span>
						</a> <a class="right carousel-control" href="#slideBaiMoi"
							role="button" data-slide="next"> <span
							class="glyphicon glyphicon-chevron-right"></span>
						</a>
					</div>
				</div>
			</div>
			<div class="row">
				<hr class="col-lg-offset-1 col-lg-10">
			</div>
		</div>
	</div>
	<div class="outBlack">
		<div class="container black" id="divCTV">
			<div class="row">
				<div class="col-lg-offset-1 col-lg-2">
					<html:link action="/trang-chu">
						<input class="m-btn-title" type="button"
							value="Cộng Tác Viên nổi bật" />
					</html:link>
				</div>
			</div>
			<div class="row">
				<div class="col-lg-offset-1 col-lg-10">
					<div id="slideCongTacVien" class="carousel slide"
						data-ride="carousel">
						<div class="carousel-inner">
							<logic:iterate id="danhSachCon" name="trangChuForm"
								property="topCongTacVien" indexId="myIndex">
								<logic:equal value="0" name="myIndex">
									<div class="item active">
										<div class="row">
											<logic:iterate id="thanhVien" name="danhSachCon">
												<div class="col-lg-3">
													<bean:define id="anh" name="thanhVien" property="anh"></bean:define>
													<div class="info">
														<h6>
															<i class="fa fa-user"> <bean:write name="thanhVien"
																	property="tenThanhVien" /></i>
														</h6>
														<h6>
															<i class="fa fa-birthday-cake"> <bean:write
																	name="thanhVien" property="ngaySinh" /></i>
														</h6>
														<h6>
															<i class="fa fa-balance-scale"> <bean:write
																	name="thanhVien" property="tenTrinhDo" /></i>
														</h6>
														<h6>
															<i class="fa fa-star-o"> <bean:write name="thanhVien"
																	property="soSao" /></i>
														</h6>
													</div>
													<img class="img-circle" alt="hinh" src="avata/${anh }">
													<h6>
														<bean:write name="thanhVien" property="tenThanhVien" />
													</h6>
												</div>
											</logic:iterate>
										</div>
									</div>
								</logic:equal>
								<logic:notEqual value="0" name="myIndex">
									<div class="item">
										<div class="row">
											<logic:iterate id="thanhVien" name="danhSachCon">
												<div class="col-lg-3">
													<bean:define id="anh" name="thanhVien" property="anh"></bean:define>
													<div class="info">
														<h6>
															<i class="fa fa-user"> <bean:write name="thanhVien"
																	property="tenThanhVien" /></i>
														</h6>
														<h6>
															<i class="fa fa-birthday-cake"> <bean:write
																	name="thanhVien" property="ngaySinh" /></i>
														</h6>
														<h6>
															<i class="fa fa-balance-scale"> <bean:write
																	name="thanhVien" property="tenTrinhDo" /></i>
														</h6>
														<h6>
															<i class="fa fa-star-o"> <bean:write name="thanhVien"
																	property="soSao" /></i>
														</h6>
													</div>
													<img class="img-circle" alt="hinh" src="avata/${anh }">
													<h6>
														<bean:write name="thanhVien" property="tenThanhVien" />
													</h6>
												</div>
											</logic:iterate>
										</div>
									</div>
								</logic:notEqual>
							</logic:iterate>
						</div>

						<!-- Controls -->
						<a class="left carousel-control" href="#slideCongTacVien"
							role="button" data-slide="prev"> <span
							class="glyphicon glyphicon-chevron-left"></span>
						</a> <a class="right carousel-control" href="#slideCongTacVien"
							role="button" data-slide="next"> <span
							class="glyphicon glyphicon-chevron-right"></span>
						</a>
					</div>
				</div>
			</div>
			<div class="row">
				<hr class="col-lg-offset-1 col-lg-10">
			</div>
		</div>
	</div>
	<div class="outBlack">
		<div class="container black" id="divTV">
			<div class="row">
				<div class="col-lg-offset-1 col-lg-2">
					<html:link action="/trang-chu">
						<input class="m-btn-title" type="button"
							value="Thành Viên nổi bật" />
					</html:link>
				</div>
			</div>
			<div class="row">
				<div class="col-lg-offset-1 col-lg-10">
					<div id="slideThanhVien" class="carousel slide"
						data-ride="carousel">
						<div class="carousel-inner">
							<logic:iterate id="danhSachCon" name="trangChuForm"
								property="topThanhVien" indexId="myIndex">
								<logic:equal value="0" name="myIndex">
									<div class="item active">
										<div class="row">
											<logic:iterate id="thanhVien" name="danhSachCon">
												<bean:define id="anh" name="thanhVien" property="anh"></bean:define>
												<div class="col-lg-3">
													<div class="info">
														<h6>
															<i class="fa fa-user"> <bean:write name="thanhVien"
																	property="tenThanhVien" /></i>
														</h6>
														<h6>
															<i class="fa fa-birthday-cake"> <bean:write
																	name="thanhVien" property="ngaySinh" /></i>
														</h6>
														<h6>
															<i class="fa fa-balance-scale"> <bean:write
																	name="thanhVien" property="tenCapDo" /></i>
														</h6>
														<h6>
															<i class="fa fa-star-o"> <bean:write name="thanhVien"
																	property="soSao" /></i>
														</h6>
													</div>
													<img class="img-circle" alt="hinh" src="avata/${anh }">
													<h6>
														<bean:write name="thanhVien" property="tenThanhVien" />
													</h6>
												</div>
											</logic:iterate>
										</div>
									</div>
								</logic:equal>
								<logic:notEqual value="0" name="myIndex">
									<div class="item">
										<div class="row">
											<logic:iterate id="thanhVien" name="danhSachCon">
												<bean:define id="anh" name="thanhVien" property="anh"></bean:define>
												<div class="col-lg-3">
													<div class="info">
														<h6>
															<i class="fa fa-user"> <bean:write name="thanhVien"
																	property="tenThanhVien" /></i>
														</h6>
														<h6>
															<i class="fa fa-birthday-cake"> <bean:write
																	name="thanhVien" property="ngaySinh" /></i>
														</h6>
														<h6>
															<i class="fa fa-balance-scale"> <bean:write
																	name="thanhVien" property="tenCapDo" /></i>
														</h6>
														<h6>
															<i class="fa fa-star-o"> <bean:write name="thanhVien"
																	property="soSao" /></i>
														</h6>
													</div>
													<img class="img-circle" alt="hinh" src="avata/${anh }">
													<h6>
														<bean:write name="thanhVien" property="tenThanhVien" />
													</h6>
												</div>
											</logic:iterate>
										</div>
									</div>
								</logic:notEqual>
							</logic:iterate>
						</div>

						<!-- Controls -->
						<a class="left carousel-control" href="#slideThanhVien"
							role="button" data-slide="prev"> <span
							class="glyphicon glyphicon-chevron-left"></span>
						</a> <a class="right carousel-control" href="#slideThanhVien"
							role="button" data-slide="next"> <span
							class="glyphicon glyphicon-chevron-right"></span>
						</a>
					</div>
				</div>
			</div>
			<div class="row">
				<hr class="col-lg-offset-1 col-lg-10">
			</div>
		</div>
	</div>

	<div class="col-lg-12 footer" style="text-align: center;">
		<a href=""><h5 style="font-weight: bold">
				<span class="glyphicon glyphicon-earphone"></span> Liên hệ với ban
				quản trị
			</h5></a>
	</div>


</body>
</html>