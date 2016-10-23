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
<title>Tạo bài học mới</title>
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
<script src="js/fileinput.js"></script>
<script type="text/javascript" src="js/my-include.js"></script>
<script type="text/javascript" src="js/fix-menu.js"></script>
<script type="text/javascript">
function clicking()
{
 window.location.href='/DoAnTotNghiep/tao-bai-hoc.do';
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
    var tong=$('.tong').val();
    for (var i = 0; i< tong; i++) {
      if(document.taoBaiHocForm["chonTuVung"][i].checked){
        flag++;
      }
    }
    if(flag==0){
    	alert ("Bạn chọn từ vựng");
    	return false;
    }
    else {
        return true;
    }
      
   
  }
</script>
<style type="text/css">
</style>
</head>
<body onload="hienThiForm()">
	<!-- header -->
	<div class="include" data-include="header"></div>
	<!-- menu -->
	<!-- =================form chọn từ vựng================ -->
	<!-- ================================================== -->
	<div class="overflow"></div>
	<div id="form" class="col-lg-12" style="margin-top: 40px">
		<div class="col-lg-12 divMain"
			style="background: white; height: auto;">
			<div class="col-lg-12" style="border-bottom: 1px solid blue;">
				<div class="col-lg-9">
					<h4>
						<i class="fa fa-list"></i> Danh sách từ vựng
					</h4>
				</div>
			</div>
			<html:form action="/chon-tu-vung" method="post"
				onsubmit="return checkTheBox()" enctype="multipart/form-data">
				<div class="col-lg-12 thumbnail"
					style="min-height: 400px; padding: 0px;">
					<table class="table table-striped"
						style="width: 100%; display: block; position: absolute; white-space: nowrap; border-collapse: separate; height: 400px; overflow: auto;">
						<thead>
							<tr class="success">
								<th style="width: 5%">STT</th>
								<th style="width: 30%">Mục từ</th>
								<th style="width: 5%">Phát âm</th>
								<th style="width: 50%">Nghĩa</th>
								<th style="width: 10%">Chọn</th>
							</tr>
						</thead>
						<tbody id="showtable">
							<logic:notEmpty name="taoBaiHocForm" property="listTuVung">
								<logic:iterate name="taoBaiHocForm" property="listTuVung"
									id="tuVung">
									<tr>
										<bean:define id="maTuVung" name="tuVung" property="maTuVung"></bean:define>
										<bean:define id="amThanh" name="tuVung" property="amThanh"></bean:define>
										<bean:define id="stt" name="tuVung" property="stt"></bean:define>
										<bean:define id="mucTu" name="tuVung" property="mucTu"></bean:define>
										<td><bean:write property="stt" name="tuVung" /></td>
										<td><bean:write property="mucTu" name="tuVung" /></td>
										<td><a href="javascript:;" onclick="play(${maTuVung});">
												<span class="glyphicon glyphicon-play-circle"></span>
										</a> <audio id=${maTuVung}> <source
												src="Sound/TuVung/${amThanh}" type="audio/ogg"></audio></td>
										<td><bean:write property="dichNghia" name="tuVung" /></td>
										<td><html:checkbox property="chonTuVung"
												value="${maTuVung}"></html:checkbox></td>
									</tr>
								</logic:iterate>
							</logic:notEmpty>
						</tbody>
					</table>
				</div>
				<html:submit styleClass="btn btn-primary" property="submit"
					value="submit" onclick="return checkTheBox();">Chọn</html:submit>
				<button class="btn btn-primary" type="reset" onclick="clicking();">
					Close</button>
			</html:form>
			<!--  -->
			<div class="col-lg-12"
				style="text-align: center; margin-bottom: 25px">
				<ul style="margin: 0px" class="pagination pagination-lg pager"
					id="myPager"></ul>
			</div>
		</div>
	</div>

	<html:hidden property="tongTuVung" name="taoBaiHocForm"
		styleClass="tong" />
	<!-- ================================================== -->
	<jsp:include page="dangNhapForm.jsp"></jsp:include>
	<!-- boby -->
	<!-- footer -->
	<div class="include" data-include="footer"></div>
</body>
</html>