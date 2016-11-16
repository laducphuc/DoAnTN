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
								<div class="item">
									<html:img src="pictures/hinh2.jpg" />
									<div class="carousel-caption"></div>
								</div>
								<div class="item">
									<html:img src="pictures/hinh3.jpg" />
									<div class="carousel-caption"></div>
								</div>
								<div class="item">
									<html:img src="pictures/hinh4.jpg" />
									<div class="carousel-caption"></div>
								</div>
								<div class="item">
									<html:img src="pictures/hinh5.jpg" />
									<div class="carousel-caption"></div>
								</div>
								<div class="item">
									<html:img src="pictures/inh6.jpg" />
									<div class="carousel-caption"></div>
								</div>
								<div class="item">
									<html:img src="pictures/hinh7.jpg" />
									<div class="carousel-caption"></div>
								</div>
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
						<!-- nội dung trang chủ -->
						<div class="col-lg-12">
							<div class="col-lg-12">
								<br>
							</div>
							<div class="col-lg-3">
								<html:image src="image/Source/Capture.PNG">
								</html:image>
							</div>
							<div class="col-lg-8">
								<p style="padding: 5px; color: black;">
								<h4>Tiếng Nhật có 3 loại chữ viết: Hiragana, Katakana, và
									Kanji. Hiragana và Katakana là loại chữ biểu âm, mỗi chữ biểu
									thị một âm tiết. Hãy học các chữ cái tiếng Nhật! Đây là bước
									đầu tiên để đọc và viết tiếng Nhật.</h4>
								</p>
							</div>
						</div>
						<div class="col-lg-12">
							<br>
						</div>
						<div class="col-lg-12">
							<ul class="nav nav-tabs">
								<li class="active"><a data-toggle="tab" href="#home">Hiragana</a></li>
								<li><a data-toggle="tab" href="#menu1">Katakana</a></li>
							</ul>

							<div class="tab-content">
								<div id="home" class="tab-pane fade in active">
									<h3>Hiragana</h3>
									<html:image src="image/Source/hira1.PNG"></html:image>
									<html:image src="image/Source/hira2.PNG"></html:image>
									<html:image src="image/Source/hira3.PNG"></html:image>
								</div>
								<div id="menu1" class="tab-pane fade">
									<h3>Katakana</h3>
									<html:image src="image/Source/kata1.PNG"></html:image>
									<html:image src="image/Source/kata2.PNG"></html:image>
									<html:image src="image/Source/kata3.PNG"></html:image>
								</div>
							</div>
						</div>
						<div class="col-lg-1"></div>

					</div>
				</div>
				<!-- Kết thúc thể hiển thị nội dung chương trình -->
				<!-- body right -->
				<div class="col-lg-3">
					<div >
						<iframe width="298" height="240"
							src="https://www.youtube.com/embed/nU1aGSdZmA4"> </iframe>
					</div>

					<div class="col-lg-12"
						style="background: url('gif/1.gif') no-repeat; height: 300px; margin-top: 20px;">
					</div>
					<div class="col-lg-12 thanhVienNoiBat" style="margin-top: 20px;">
						<div class="col-lg-12">
							<label><span class="glyphicon glyphicon-user"></span>
								Thống kê thành viên</label>
						</div>

						<table class="table table-striped">
							<tr>
								<td><h5>Tổng số thành viên</h5> </td>
								<td><span class="badge"><bean:write name="trangChuForm" property="soThanhVien" /></span></td>
							</tr>
							<tr>
								<td><h5>Thành viên mới nhất</h5></td>
								<td><span class="badge">
								<logic:notEmpty name="trangChuForm" property="thanhVienMoi">
								<bean:write name="trangChuForm" property="thanhVienMoi" />
								</logic:notEmpty>
								</span></td>
							</tr>
						</table>
					</div>
				</div>
			</div>
		</div>
	</div>
	<!-- footer -->
	<div class="include" data-include="footer"></div>

</body>
</html>