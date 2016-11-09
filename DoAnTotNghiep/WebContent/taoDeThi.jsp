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
<title>Tạo đề thi</title>
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
	function clicking() {
		window.location.href = '/DoAnTotNghiep/chon-tu-vung.do?kt=0';
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
			if (document.taoDeThiForm["chonCauHoi"][i].checked) {
				flag++;

			}
		}
		document.getElementById("soCauHoi").innerHTML = flag;
	}
</script>
<script type="text/javascript">
	function Chuyen() {
		$('#id').click();
	}
</script>
</head>
<body onload="checkTheBox();">
	<!-- header -->
	<div class="include" data-include="header"></div>
	<jsp:include page="dangNhapForm.jsp"></jsp:include>
	<!-- boby -->
	<div class="col-lg-12">

		<div class="col-lg-12" style="margin-top: 20px; padding: 0px;">
			<div class="col-lg-12" style="height: auto; padding: 0px">
				<!-- body main -->
				<div class="col-lg-9" style="height: auto; padding: 0px">
					<div class="col-lg-12 divMain"
						style="height: auto; background-color: white;">
						<div class="col-lg-12">
							<div class="col-lg-12">
								<h4 style="font-size: 30px; text-align: center;">
									<i class="fa fa-users"></i> Tạo đề thi
								</h4>
							</div>
							<html:form action="/tao-de-thi" method="post"
								enctype="multipart/form-data">
								<div class="col-lg-12">
									<h4>
										<span class="glyphicon glyphicon-align-justify"></span> Danh
										Mục :
									</h4>
								</div>
								<div class="col-lg-12">
									<html:select property="maCapDo" styleClass="form-control"
										onchange="Chuyen();">
										<option value="">-- Chọn cấp độ --</option>
										<html:optionsCollection name="taoDeThiForm"
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
										<span class="glyphicon glyphicon-text-width"></span> Tên đề
										thi:
									</h4>
								</div>
								<div class="col-sm-12">
									<html:text property="tenDeThi" name="taoDeThiForm"
										styleClass="form-control"></html:text>
								</div>
								<div class="col-sm-12">
									<font style="color: red;"> <html:errors
											property="tenDeThiError" />
									</font>
								</div>
								<div class="col-lg-3">
									<h4>
										<span class="glyphicon glyphicon-text-width"></span> Số câu
										hỏi đã chọn:
									</h4>

								</div>
								<div class="col-lg-8">
									<h4>
										<div id="soCauHoi" style="color: red;"></div>
									</h4>
								</div>
								<div class="col-lg-12">
									<table class="table table-striped"
										style="width: 100%; display: block; white-space: nowrap; border-collapse: separate; height: 400px; overflow: auto;">
										<thead>
											<tr class="success">
												<th style="width: 5%">STT</th>
												<th style="width: 30%">Mã câu hỏi</th>
												<th style="width: 5%">Nội dung</th>
												<th style="width: 50%">Đáp án</th>
												<th style="width: 10%">Tùy chọn</th>
											</tr>
										</thead>
										<tbody id="showtable">
											<logic:notEmpty name="taoDeThiForm" property="listCauHoi">
												<logic:iterate name="taoDeThiForm" property="listCauHoi"
													id="cauHoi">
													<tr>
														<bean:define id="maCauHoi" name="cauHoi"
															property="maCauHoi"></bean:define>
														<td><bean:write property="stt" name="cauHoi" /></td>
														<td><bean:write property="maCauHoi" name="cauHoi" /></td>
														<td><bean:write property="noiDung" name="cauHoi" /></td>
														<logic:notEmpty name="cauHoi" property="listPhuongAn">
														<td><logic:iterate id="pa" name="cauHoi"
																property="listPhuongAn">
																<logic:equal value="1" name="pa" property="trangThai">
																<logic:notEmpty name="pa" property="noiDungPA">
																	<bean:write name="pa" property="noiDungPA" />
																	<p></p>
																</logic:notEmpty>
																<!-- kiem tra cau hoi co hinh anh k -->
																<logic:notEmpty name="pa" property="hinhAnh">
																	<bean:define id="image" name="pa" property="hinhAnh"></bean:define>
																	<div class="hoverimage">
																		<p></p>
																		<html:img src="${image}" />
																	</div>
																</logic:notEmpty>
																</logic:equal>
															</logic:iterate></td>
															</logic:notEmpty>
														<td><html:checkbox property="chonCauHoi"
																value="${maCauHoi}" onchange="checkTheBox();"></html:checkbox></td>
													</tr>
												</logic:iterate>
											</logic:notEmpty>
										</tbody>
									</table>
									<div class="col-sm-12">
										<font style="color: red;"> <html:errors
												property="cauHoiError" />
										</font>
									</div>
								</div>
								<div class="col-lg-12">
									<p>
								</div>
								<div class="col-lg-12">
									<html:submit styleClass="btn btn-primary" property="submit"
										value="submit" styleId="id">Lưu</html:submit>
									<button type="submit" class="btn btn-primary"
										onclick="history.go(-1);">Quay lại</button>
								</div>
								<div class="col-lg-12">
									<p>
								</div>
							</html:form>
							<html:hidden property="tongCauHoi" name="taoDeThiForm"
								styleClass="tong" />
						</div>
					</div>
				</div>
				<jsp:include page="menuCongTacVien.jsp"></jsp:include>
				<!-- body right -->

				<div class="col-lg-1"></div>
			</div>
		</div>
	</div>
	<!-- footer -->
	<div class="include" data-include="footer"></div>
</body>
</html>