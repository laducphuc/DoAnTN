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
<title>Sửa bài học</title>
<link rel="stylesheet"
	href="font-awesome-4.4.0/css/font-awesome.min.css">
<link rel="stylesheet" href="css/bootstrap.min.css">
<link rel="stylesheet" href="css/songnguvietnhat3.css">
<link rel="stylesheet" href="css/style.css" />
<link rel="stylesheet" href="css/bootstrap-formhelpers.css">
<link rel="stylesheet" href="css/bootstrap-formhelpers.min.css">
<link rel="stylesheet" href="css/fileinput.css">
<link rel="stylesheet" href="css/datepicker.css">
<link rel="stylesheet" type="text/css"
	href="css/mycss/styleloginform.css">
<script src="js/jquery-1.11.2.min.js"></script>
<script src="js/bootstrap.min.js"></script>
<script src="js/bootstrap-formhelpers.js"></script>
<script src="js/bootstrap-formhelpers.min.js"></script>
<script src="ckeditor/ckeditor.js"></script>
<script src="js/fileinput.js"></script>
<script type="text/javascript" src="js/my-include.js"></script>
<script type="text/javascript">
function clicking()
{
 window.location.href='/DoAnTotNghiep/chon-tu-vung.do?kt=1';
}
	function hienThiForm() {
		$("#form").css("top", "10%");
		$(".overflow").show();
	}
	function tatFormDangNhap() {
		$("#form").css("top", "-100%");
		$(".overflow").hide();
	}
	function play(x) {
		document.getElementById(x).play();
	}
	function checkTheBox() {
		var flag = 0;
		var tong = $('.tong').val();
		for (var i = 0; i < tong; i++) {
			if (document.myform["chon[]"][i].checked) {
				var x = i + 1;
				var kt = "." + x;
				flag += $(kt).val() + "/n";
			}
		}
		if (flag == 0) {
			alert("Ban chua chon");
			return false;
		} else {
			$("#form").css("top", "-100%");
			$(".overflow").hide();
			alert(flag);
			return false;
		}

	}
</script>
<style type="text/css">
</style>
</head>
<body>
	<!-- header -->
	<div class="include" data-include="header"></div>
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
									<i class="fa fa-users"></i> Sửa bài học
								</h4>
							</div>
							<html:form action="/sua-bai-hoc" method="post"
								onsubmit="mysubmit()" enctype="multipart/form-data">
								<div class="col-lg-12">
									<h4>
										<span class="glyphicon glyphicon-align-justify"></span> Danh
										Mục :
									</h4>
								</div>
								<div class="col-lg-12">
									<html:select property="maCapDo" styleClass="form-control">
										<option value="">-- Chọn cấp độ --</option>
										<html:optionsCollection name="taoBaiHocForm"
											property="listCapDo" label="tenCapDo" value="maCapDo" />
									</html:select>
								</div>
								<div class="col-sm-12">
                           <font style="color: red;"> <html:errors
                                 property="capDoError" />
                           </font>
                        </div>
								<div class="col-lg-12">
									<h4>
										<span class="glyphicon glyphicon-text-width"></span> Tên bài
										học:
									</h4>
								</div>
								<div class="col-sm-12">
									<html:text property="tenBaiHoc" name="taoBaiHocForm" styleClass="form-control"></html:text>
								</div>
								<div class="col-sm-12">
									<font style="color: red;"> <html:errors
											property="tenBaiHocError" />
									</font>
								</div>
								<div class="col-lg-12">
									<h4>
										<span class="glyphicon glyphicon-text-width"></span> Từ vựng:
									</h4>
								</div>
								<div class="col-lg-12">
									<table class="table table-striped"
										style="width: 100%; display: block;  white-space: nowrap; border-collapse: separate; height: 400px; overflow: auto;">
										<thead>
											<tr class="success">
												<th style="width: 5%">STT</th>
												<th style="width: 30%">Mục từ</th>
												<th style="width: 5%">Phát âm</th>
												<th style="width: 50%">Nghĩa</th>
												<th style="width: 10%">Tùy chọn</th>
											</tr>
										</thead>
										<tbody id="showtable">
											<logic:notEmpty name="taoBaiHocForm" property="listTuVung">
												<logic:iterate name="taoBaiHocForm" property="listTuVung"
													id="tuVung">
													<tr>
														<bean:define id="maTuVung" name="tuVung"
															property="maTuVung"></bean:define>
														<bean:define id="amThanh" name="tuVung" property="amThanh"></bean:define>
														<td><bean:write property="stt" name="tuVung" /></td>
														<td><bean:write property="mucTu" name="tuVung" /></td>
														<td><a href="javascript:;"
															onclick="play(${maTuVung});"> <span
																class="glyphicon glyphicon-play-circle"></span>
														</a> <audio id=${maTuVung}> <source
																src="Sound/TuVung/${amThanh}" type="audio/ogg"></audio></td>
														<td><bean:write property="dichNghia" name="tuVung" /></td>
														<td>
															<ul>
																<li title="sửa từ vựng" style="display: inline"><html:link
																		action="/sua-tu-vung?maTuVung=${maTuVung}">
																		<span class="glyphicon glyphicon-edit"></span>
																	</html:link></li>
																<li title="sửa từ vựng" style="display: inline"><html:link
																		action="/xoa-tu-vung?maTuVung=${maTuVung}"
																		onclick="return confirm('Bạn muốn xóa từ vựng này?');">
																		<span class="glyphicon glyphicon-trash"></span>
																	</html:link></li>
															</ul>
														</td>
													</tr>
												</logic:iterate>
											</logic:notEmpty>
										</tbody>
									</table>
									<div class="col-sm-12">
                           <font style="color: red;"> <html:errors
                                 property="tuVungError" />
                           </font>
                        </div>
									<button class="btn btn-info" type="reset" onclick="clicking();">
										<i class="fa fa-plus"></i> Thêm Từ vựng
									</button>
								</div>
								<div class="col-lg-12">
									<h4><i class="fa fa-tasks"></i> Ngữ pháp</h4>
								</div>
								<div class="col-lg-12"
									style="margin-top: 10px; margin-bottom: 10px;">
									<html:textarea property="nguPhap" styleId="editor1" name="taoBaiHocForm"
										styleClass="form-control"
										style="width:100%; height:500px; padding-left:5px"></html:textarea>
									<div class="col-sm-12">
										<font style="color: red;"> <html:errors
												property="nguPhapError" />
										</font>
									</div>
								</div>
								<div class="col-lg-12" style="border-bottom: 1px solid #725a65;">
									<h4> <i class="fa fa-caret-square-o-right"></i>Nghe</h4>
								</div>
								<div class="col-lg-12">
									<h5>Mô tả</h5>
								</div>
								<div class="col-lg-12"
									style="margin-top: 10px; margin-bottom: 10px;">
									<html:textarea property="nghe" styleId="editor"
										styleClass="form-control" name="taoBaiHocForm"
										style="width:100%; height:200px; padding-left:5px"></html:textarea>
									<div class="col-sm-12">
										<font style="color: red;"> <html:errors
												property="ngheError" />
										</font>
									</div>
								</div>
								<div class="col-lg-12">
									<h5>
										<i class="fa fa-caret-square-o-right"></i> Sound:
									</h5>
								</div>
								<div class="col-lg-10">
									<html:file styleId="input-1" property="sound" styleClass="file" name="taoBaiHocForm"
										accept="audio/*"></html:file>
								</div>
								<div class="col-lg-2">
									<samp style="color: red">(*)</samp>
								</div>
								<div class="col-lg-12">
									<font style="color: red;"> <html:errors
											property="amthanhError" />
									</font>
								</div>
								<div class="col-lg-12"><p></div>
								<div class="col-lg-12">
								<html:submit styleClass="btn btn-primary" property="submit"
                           value="Submit">Chọn</html:submit>
								</div>
								<div class="col-lg-12"><p></div>
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
	<script type="text/javascript">
		$("#input-1").fileinput({
			showRemove : false,
			showUpload : false,
			browseLabel : "Sound",
			previewFileType : "audio"
		});
	</script>
</body>
</html>