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
<title>Xem bài viết</title>
<link rel="stylesheet"
	href="font-awesome-4.4.0/css/font-awesome.min.css">
<link rel="stylesheet" href="css/songnguvietnhat3.css">
<link rel="stylesheet" href="css/bootstrap.min.css">
<link rel="stylesheet" href="css/star-rating.min.css">
<link rel="stylesheet" href="css/star-rating.css">
<link rel="stylesheet" href="css/style.css" />
<link rel="stylesheet" type="text/css"
	href="css/mycss/styleloginform.css">
<link rel="stylesheet" href="css/chart.css" />
<script src="js/jquery-1.11.2.min.js"></script>
<script src="js/bootstrap.min.js"></script>
<script src="js/star-rating.min.js"></script>
<script src="js/jquery.validate.js" type="text/javascript"></script>
<script src="js/jchart.js"></script>
<script type="text/javascript" src="js/my-include.js"></script>
<script type="text/javascript" src="js/fix-menu.js"></script>
<script type="text/javascript">
	function hienThiFormDangNhap() {
		$("#form-login").css("top", "20%");
		$(".overflow").show();
	}
	function tatFormDangNhap() {
		$("#form-login").css("top", "-100%");
		$(".overflow").hide();
	}
	$(document).ready(function() {
		console.log("runnn");
		var overflow = $(".overflow")[0];
		$(overflow).on("click", function() {
			console.log("runnn");
			tatFormDangNhap();
		});
	});
</script>
</head>
<body>
	<!-- header -->
	<div class="include" data-include="header"></div>

	<!-- menu -->
	<jsp:include page="dangNhapForm.jsp"></jsp:include>
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
							<div class="col-lg-12" style="margin-top: 15px">
								<div class="col-lg-6" style="height: 264px;">
									<bean:define id="anh" name="baiViet" property="anh"></bean:define>
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
										<bean:write name="baiViet" property="moTaViet" />
									</h5>
								</div>
								<div class="col-lg-6" style="margin-top: 15px">
									<label class="control-label col-sm-12"
										style="text-align: left;"><i class="fa fa-file-text"></i>
										記事の説明:</label>
								</div>
								<div class="col-lg-6">
									<h5 class="title">
										<bean:write name="baiViet" property="moTaNhat" />
									</h5>
								</div>
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
							<div id="noiDungBaiViet" class="col-lg-6 divMain" style="height: auto;padding: 15px;">
								<html:hidden styleId="noiDung" property="noiDungViet" name="baiViet" />
							</div>
							<div class="col-lg-6 divMain" style="height: auto; padding: 15px;">
								<logic:iterate id="noiDungNhat" name="baiViet"
									property="arrNoiDungNhat">
									<h5
										style="margin-left: 5px; margin-right: 5px; margin-top: 15px; margin-bottom: 15px;">
										<bean:write name="noiDungNhat" />
									</h5>
								</logic:iterate>
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
									Dịch: <input id="rating-input1" type="number" class="rating"
										min=0 max=5 step=1 data-size="xs" value="${soSao}"
										data-rtl="false" data-default-caption="{rating} Sao"
										data-star-captions="{}" data-disabled="true">
								</h5>
							</div>
							<div class="col-lg-12" style="border-bottom: 2px solid #111111;"></div>
							<div class="col-lg-6"">
								<div id="population_chart" data-width="300 "></div>
							</div>
							<html:hidden styleId="sao1" name="baiViet"
								property="phanTramSao1" />
							<html:hidden styleId="sao2" name="baiViet"
								property="phanTramSao2" />
							<html:hidden styleId="sao3" name="baiViet"
								property="phanTramSao3" />
							<html:hidden styleId="sao4" name="baiViet"
								property="phanTramSao4" />
							<html:hidden styleId="sao5" name="baiViet"
								property="phanTramSao5" />
							<div class="col-lg-2"
								style="margin-top: 33px; margin-left: -30px;">
								<div>
									<h6 class="title1">
										<bean:write name="baiViet" property="soSao5" />
										lượt
									</h6>
									<h6 class="title1">
										<bean:write name="baiViet" property="soSao4" />
										lượt
									</h6>
									<h6 class="title1">
										<bean:write name="baiViet" property="soSao3" />
										lượt
									</h6>
									<h6 class="title1">
										<bean:write name="baiViet" property="soSao2" />
										lượt
									</h6>
									<h6 class="title1">
										<bean:write name="baiViet" property="soSao1" />
										lượt
									</h6>
								</div>
							</div>
							<div class="col-lg-4 divMain" style="margin-top: 10px;">
								<div>
									<h5 class="title"
										style="text-align: center; text-decoration: underline; font-weight: bold">Chú
										Thích</h5>
									<h5 class="title" style="font-weight: bold">5 sao : Tuyệt
										vời</h5>
									<h5 class="title" style="font-weight: bold">4 sao : Hay</h5>
									<h5 class="title" style="font-weight: bold">3 sao : Khá
										hay</h5>
									<h5 class="title" style="font-weight: bold">2 sao : Bình
										thường</h5>
									<h5 class="title" style="font-weight: bold">1 sao : Không
										hay</h5>
								</div>
							</div>

							<html:form action="/xem-bai-viet" method="post"
								onsubmit="getSoSao()">
								<div class="col-lg-12">
									<h5 class="title">
										Đánh Giá Của Bạn Về Bài Dịch:<input id="rating-input"
											type="number" class="rating" min=0 max=5 step=1
											data-size="xs" data-rtl="false" value="1"
											data-default-caption="{rating} Sao" data-star-captions="{}">
									</h5>
								</div>
								<div class="col-lg-12">
									<html:hidden property="daXem" name="baiVietForm" />
									<html:hidden property="maBaiViet" name="baiVietForm" />
									<html:hidden property="soSao" name="baiVietForm"
										styleId="soSao" />
									<i class="fa fa-balance-scale"></i>
									<html:submit styleClass="btn btn-info" property="submit"
										value="Đánh giá"></html:submit>
								</div>
								<div class="col-lg-12" style="margin-top: 5px;">
									<font style="color: red;"> <bean:write
											name="baiVietForm" property="thongBao" />
									</font>
								</div>
							</html:form>


							<div class="col-lg-12"
								style="border-bottom: 2px solid #111111; margin-top: 10px;"></div>
							<div class="col-lg-12" style="margin-top: 10px;">
								<html:form action="/xem-bai-viet" method="post">
									<i class="fa fa-thumbs-o-up"></i>
									<html:hidden property="maBaiViet" name="baiVietForm" />
									<html:hidden property="daXem" name="baiVietForm" />
									<html:hidden property="thich" name="baiVietForm" />
									<html:submit  styleClass="btn btn-primary" property="submit" value="Thích bài viết"></html:submit>
								</html:form>

								<bean:define id="thich" property="thich" name="baiVietForm"></bean:define>
								<logic:equal name="thich" value="daThich">
									<h5>
										Bạn và
										<bean:write name="baiViet" property="soThich" />
										người khác đã thích bài viết này
									</h5>
								</logic:equal>
								<logic:equal name="thich" value="chuaThich">
									<h5>
										Có
										<bean:write name="baiViet" property="soThich" />
										người thích bài viết này
									</h5>
								</logic:equal>
							</div>
							<div class="col-lg-12" id="tabMenu1" style="margin-top: 10px;">
								<div id="menuItems1"">
									<ul>
										<li><a class="btn btn-info" href="#Foo"
											data-toggle="collapse" style="color: black">Bình Luận</a></li>
									</ul>
								</div>
							</div>
							<div class="col-lg-12" style="border-bottom: 2px solid #111111;"></div>
						</div>

						<div class="col-lg-12 collapse" id="Foo" data-spy="scroll"
							data-target="#myScrollspy" data-offset="20"
							style="height: 600px; margin-top: 10px; margin-bottom: 10px;">
							<div class="col-lg-12 divMain"
								style="height: auto; margin-bottom: 25px;">
								<h4 style="padding-left: 15px; text-decoration: underline;">
									<i class="fa fa-comments-o"></i> Bình luận bài viết
								</h4>
								<logic:notEmpty name="dangNhapForm" scope="session">
									<logic:notEmpty property="taiKhoan" name="dangNhapForm"
										scope="session">
										<bean:define id="tenTaiKhoan" name="dangNhapForm"
											property="tenTaiKhoan" scope="session"></bean:define>
										<div class="form-group">
											<html:form action="/xem-bai-viet">
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
												<html:hidden property="daXem" name="baiVietForm" />
												<html:hidden property="maBaiViet" name="baiVietForm" />
												<div class="form-group">
													<div class="col-sm-offset-2 col-sm-10">
														<html:submit styleClass="btn btn-info" property="submit"
															value="Bình luận"
															style="float: right;margin-top: 10px;"></html:submit>
													</div>
												</div>
											</html:form>
										</div>
									</logic:notEmpty>
								</logic:notEmpty>
								<div class="col-lg-12 divMain"
									style="height: 600px; margin-top: 10px; margin-bottom: 25px; overflow: scroll">
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
												alt="Avatar ^_^" src="image/avatar1.png" width="80px"
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
						style="background: white; margin-top: 10px;">
						<div
							style="background: url('image/menu2.png') no-repeat scroll 0px 10px; width: 240px; height: 46px; padding-top: 14px; padding-left: 41px;">
							<h5
								style="color: black; padding: 0px; margin: 0px; font-size: 1.2em">Bài
								Viết Yêu Thích</h5>
						</div>

						<ul>
							<logic:iterate id="baiVietHot" name="baiVietForm"
								property="bXHBaiViet">
								<li style="margin-bottom: 30px;"><a href="#"
									style="color: black"><bean:write name="baiVietHot"
											property="tieuDeViet" /></a></li>
							</logic:iterate>
						</ul>
					</div>
					<div class="col-lg-12" style="height: 10px"></div>


				</div>
			</div>
		</div>
	</div>
	<!-- footer -->
	<div class="include" data-include="footer"></div>


	<script type="text/javascript">
		function getSoSao() {
			var soSao = $("#rating-input").val();
			document.getElementById("soSao").value = soSao;
		}
		var noiDung=$("#noiDung").val();
		$("#noiDungBaiViet").append(noiDung);
	</script>
</body>
</html>
