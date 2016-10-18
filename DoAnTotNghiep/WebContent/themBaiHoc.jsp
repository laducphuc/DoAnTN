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
<title>Thêm bài viết mới</title>
<link rel="stylesheet"
	href="font-awesome-4.4.0/css/font-awesome.min.css">
<link rel="stylesheet" href="css/bootstrap.min.css">
<link rel="stylesheet" href="css/songnguvietnhat3.css">
<link rel="stylesheet" href="css/style.css" />
<link rel="stylesheet" href="css/bootstrap-formhelpers.css">
<link rel="stylesheet" href="css/bootstrap-formhelpers.min.css">
<link rel="stylesheet" href="css/fileinput.css">
<link rel="stylesheet" href="css/datepicker.css">
<script src="js/jquery-1.11.2.min.js"></script>
<script src="js/bootstrap.min.js"></script>
<script src="js/bootstrap-formhelpers.js"></script>
<script src="js/bootstrap-formhelpers.min.js"></script>
<script src="js/bootstrap-datepicker.js"></script>
<script src="ckeditor/ckeditor.js"></script>
<script src="js/fileinput.js"></script>
<script type="text/javascript" src="js/my-include.js"></script>
<script type="text/javascript" src="js/fix-menu.js"></script>
<style type="text/css">
</style>
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
				<div class="col-lg-1"></div>
				<div class="col-lg-10" style="height: auto; padding: 0px">
					<div class="col-lg-12 divMain"
						style="height: auto; background-color: white;">
						<div class="col-lg-12">
							<div class="col-lg-12">
								<h4 style="font-size: 30px; text-align: center;">
									<i class="fa fa-users"></i> Bài viết mới
								</h4>
							</div>
							<html:form action="/tao-bai-hoc" method="post"
								onsubmit="mysubmit()" enctype="multipart/form-data">
								<div class="col-lg-2">
									<h4><span class="glyphicon glyphicon-align-justify"></span> Danh Mục :</h4>
								</div>
								<bean:define id="maThanhVien" property="maThanhVien"
									name="dangNhapForm"></bean:define>
								<div class="col-lg-12">
									<select class="form-control" id="danhMuc">
										<option value="DM00000001">Xã hội</option>
										<option value="DM00000002">Thế giới</option>
										<option value="DM00000003">Giáo dục</option>
										<option value="DM00000004">Công nghệ</option>
										<option value="DM00000005">Thể thao</option>
										<option value="DM00000006">Giải trí</option>
										<option value="DM00000007">Sức khỏe</option>
									</select>
								</div>
								<div class="col-lg-12">
									<h4><span class="glyphicon glyphicon-text-width"></span> Tiêu Đề</h4>
								</div>
								<div class="col-lg-12">
									<html:textarea styleClass="form-control" property="tenBaiHoc"
										style="width: 100%; resize: none" rows="2"></html:textarea>
								</div>
								<div class="col-sm-12">
									<font style="color: red;"> <html:errors
											property="tenBaiHocError" />
									</font>
								</div>
								<div class="col-lg-12">
									<h4><span class=" glyphicon glyphicon-asterisk"></span> Từ vựng</h4>
								</div>
								<div class="col-lg-12">
									<html:textarea styleClass="form-control" property="tenBaiHoc"
										style="width: 100%; resize: none" rows="3"></html:textarea>
								</div>
								<div class="col-sm-12">
									<font style="color: red;"> <html:errors
											property="moTaError" />
									</font>
								</div>
								<div class="col-lg-7"></div>
								<div class="col-lg-6"
									style="margin-bottom: 20px; margin-top: 20px">
									<div class="col-lg-12 divMain">
										<div class="col-lg-12"
											style="margin-bottom: 10px; margin-top: 35px;">
											<img alt="hinh anh" src="pictures/Japan_Vietnam.png"
												height="250px" width="100%"> <input type="text"
												style="width: 100%; margin-top: 21px;" class="form-control"
												value="Hình Ảnh Mặc Định" readonly="readonly">
										</div>
									</div>
								</div>

								<div class="col-lg-6"
									style="margin-bottom: 20px; margin-top: 20px">
									<div class="col-lg-12 divMain">

										<div class="col-lg-12"
											style="margin-bottom: 10px; margin-top: 10px">
											<html:file property="sound" 
												styleId="input-4" styleClass="file"></html:file>
										</div>
									</div>
								</div>
								
								<div class="col-lg-12">
									<h4>Ngữ pháp</h4>
								</div>
								<div class="col-lg-12"
									style="margin-top: 10px; margin-bottom: 10px;">
									<html:textarea property="nguPhap" styleId="editor1"
											styleClass="form-control"
											style="width:100%; height:500px; padding-left:5px"></html:textarea>
									<div class="col-sm-12">
										<font style="color: red;"> <html:errors
												property="nguPhapError" />
										</font>
									</div>
								</div>
								<div class="col-lg-6">
									<bean:write name="taoBaiHocForm" property="thongBao" />
								</div>
								<div class="col-lg-6"
									style="text-align: right; margin-bottom: 30px;">
									<!-- <html:hidden property="noiDungViet" name="baiVietForm"
										styleId="noiDungViet" /> -->
									<%-- <html:hidden property="submit" name="taoBaiHocForm"
										value="submit" /> --%>
									<%-- <html:hidden property="maThanhVien" name="taoBaiHocForm"
										value="${maThanhVien }" />
									<html:hidden property="maDanhMuc" name="taoBaiHocForm"
										styleId="maDanhMuc" /> --%>
									<html:submit styleClass="btn btn-primary" value="Lưu Bài Viết"></html:submit>
								</div>
							</html:form>
						</div>
					</div>
				</div>
				<!-- body right -->
				<div class="col-lg-1"></div>
			</div>
		</div>
	</div>
	<!-- footer -->
	<div class="include" data-include="footer"></div>


	<script type="text/javascript">
		var baiViet = new Array();
		var x = 0;
		$(document).ready(
				function() {
					$("#population_chart").jChart(
							{
								name : "Đánh Giá Chi Tiết (Đơn vị : %)",
								headers : [ "5 sao", "4 sao", "3 sao", "2 sao",
										"1 sao" ],
								values : [ 25, 47, 88, 42, 42 ],
								footers : [ 10, 20, 30, 40, 50, 60, 70, 80, 90,
										100 ],
								colors : [ "#AAAAAA", "#555555", "#AAAAAA",
										"#555555", "#AAAAAA" ]
							});
				});
		$("#input-4").fileinput({
			showCaption : true,
			browseLabel : "Duyệt ảnh mới",
			showPreview : true,
			showRemove : false,
			showUpload : false,
			showCancel : false
		});
		$("#nextbt").click(function() {
			var s = "";
			if ($("#baiViet").val() == "") {
				$("#baiViet").focus();
				return;
			}

			if (x == baiViet.length) {
				baiViet.push($("#baiViet").val());
				x++;
				$("#baiViet").val("");
			} else if (x + 1 == baiViet.length) {
				if ($("#baiViet").val() == "") {
					baiViet.splice(x, 1);
					x--;
				}

				$("#baiViet").val("");
				x++;
			} else {

				baiViet[x] = $("#baiViet").val();
				x++;
				$("#baiViet").val(baiViet[x]);
			}

			for (var i = 0; i < baiViet.length; i++)
				s += baiViet[i] + "\\\n";
			$("#noiDung").text(s);
			$("#baiViet").focus();
		});
		$("#prebt").click(function() {
			var s = "";
			if (x == 0) {
				baiViet[x] = $("#baiViet").val();
			} else {
				if (x == baiViet.length) {
					x--;
					$("#baiViet").val(baiViet[x]);
				} else {
					baiViet[x] = $("#baiViet").val();
					x--;
					$("#baiViet").val(baiViet[x]);
				}
			}
			for (var i = 0; i < baiViet.length; i++)
				s += baiViet[i] + "\\\n";
			$("#noiDung").text(s);
			$("#baiViet").focus();
		});
		function mysubmit() {
			var y = "";
			for (var i = 0; i < baiViet.length; i++) {
				y = y + baiViet[i] + " /// ";
			}
			$("#maDanhMuc").val($("#danhMuc option:selected").val());
			document.getElementById("noiDungViet").value = y;
			alert(y);

		}
		function nhanEnter() {
			var keyPressed = event.keyCode || event.which;

			//if ENTER is pressed
			if (keyPressed == 13) {
				event.preventDefault();

				var s = "";
				baiViet.push($("#baiViet").val());
				x++;
				for (var i = 0; i < baiViet.length; i++)
					s += baiViet[i] + "\\\n";
				$("#noiDung").text(s);
				$("#baiViet").empty();
				$("#baiViet").focus();
			} else {
				return false;
			}
		}
		CKEDITOR.replace("editor1");
	</script>
</body>
</html>