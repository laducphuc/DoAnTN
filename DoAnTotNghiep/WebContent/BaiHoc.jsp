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
<title>Bài Học</title>
<link rel="stylesheet"
	href="font-awesome-4.4.0/css/font-awesome.min.css">
<link rel="stylesheet" href="css/songnguvietnhat3.css">
<link rel="stylesheet" href="css/bootstrap.min.css">
<link rel="stylesheet" href="css/style.css" />
<script src="js/jquery-1.11.2.min.js"></script>
<script src="js/bootstrap.min.js"></script>
<script src="js/PaginationJS.js"></script>
<script type="text/javascript" src="js/my-include.js"></script>
<script type="text/javascript" src="js/fix-menu.js"></script>
<script src="ckeditor/ckeditor.js"></script>
<style type="text/css">
</style>
<style type="text/css">
.baihoc {
	background-position: center;
	background-size: cover;
}
</style>
<script type="text/javascript">
	function tuVung() {
		$('#tuVung').show();
		$('#nguPhap').hide();
		$('#nghe').hide();
	}
	function nghuPhap() {
	      $('#tuVung').hide();
	      $('#nguPhap').show();
	      $('#nghe').hide();
	      $('#cke_1_top').hide();
	      $('#cke_1_bottom').hide();
	   }
	function nghe() {
	      $('#tuVung').hide();
	      $('#nguPhap').hide();
	      $('#nghe').show();
	      $('#chitiet').hide();
	      $('#an').hide();
	   }
	function chiTiet() {
        $('#chitiet').show();
        $('#an').show();
        $('#hien').hide();
     }
	function an() {
        $('#chitiet').hide();
        $('#hien').show();
        $('#an').hide();
     }
	function play(x) {
        document.getElementById(x).play();
     }
</script>

</head>
<body onload="tuVung();">
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
						style="background: white; height: auto;">

						<div class="col-lg-12">
							<h5 style="font-size: 20px; text-align: left;">
								<i class="fa fa-use"></i>Minnano Nihongo
							</h5>
						</div>
						<div class="baihoc">
							<div class="col-sm-3">
								<button type="button"
									style="width: 128px; height: 100px; background-image: url('image/Source/tuvung.png'); background-color: #ddefdd;"
									class="btn-default" onclick="tuVung();" onfocus=""></button>
								<h4>Từ vựng</h4>
							</div>
							<div class="col-sm-3">
								<button type="button"
									style="width: 128px; height: 100px; background-image: url('image/Source/nguphap.png');"
									class="btn-default" onclick="nghuPhap();"></button>
								<h4>Ngữ pháp</h4>
							</div>
							<div class="col-sm-3">
								<button type="button"
									style="width: 128px; height: 100px; background-image: url('image/Source/nghe.png');"
									class="btn-default" onclick="nghe();"></button>
								<h4>Nghe</h4>
							</div>
							<!-- <div class="col-sm-3">
								<button type="button"
									style="width: 128px; height: 100px; background-image: url('image/Source/luyentap.png');"
									class="btn-default" onclick="ly();"></button>
								<h4>Luyện tập</h4>
							</div> -->
						</div>
						<div id="tuVung">
							<div class="col-lg-12" style="border-bottom: 1px solid blue;">
								<div class="col-lg-9">
									<h4>
										<i class="fa fa-list"></i> Danh sách từ vựng
									</h4>
								</div>
							</div>
							<div class="col-lg-12 thumbnail"
								style="min-height: 500px; padding: 0px;">
								<table class="table table-striped"
									style="width: 100%; display: block; position: absolute; white-space: nowrap; border-collapse: separate; height: 500px; overflow: auto;">
									<thead>
										<tr class="success">
											<th style="width: 5%">STT</th>
											<th style="width: 30%">Mục từ</th>
											<th style="width: 5%">Phát âm</th>
											<th style="width: 30%">Nghĩa</th>
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
												</tr>
											</logic:iterate>
										</logic:notEmpty>
									</tbody>
								</table>
							</div>
						</div>

						<!-- ====== -->
						<div id="nguPhap">
							<div class="col-lg-12" style="border-bottom: 1px solid blue;">
								<div class="col-lg-9">
									<h4>
										<i class="fa fa-list"></i> Ngữ Pháp
									</h4>
								</div>
							</div>
							<%-- <div class="col-lg-12 thumbnail"
								style="min-height: 500px; padding: 0px;">
								<html:textarea property="nguPhap" onchange="false"
									style="width:100%; height: 490px;" name="taoBaiHocForm"
									cols="10"></html:textarea>
							</div> --%>
							<div class="col-lg-12"
								style="margin-top: 10px; margin-bottom: 10px; height: 490px;">
								<html:textarea property="nguPhap" styleId="editor1" readonly="true"
									name="taoBaiHocForm" styleClass="form-control"
									style="width:100%; height:400px; padding-left:5px" cols="20"></html:textarea>
							</div>
						</div>
						<!-- ===== -->

						<div id="nghe">
							<div class="col-lg-12" style="border-bottom: 1px solid blue;">
								<div class="col-lg-9">
									<h4>
										<i class="fa fa-list"></i> Nghe
									</h4>
								</div>
							</div>
							<bean:define id="sound" name="taoBaiHocForm" property="file"></bean:define>
							<div class="col-lg-12 thumbnail">
								<audio controls> <source src="Sound/NguPhap/${sound}"
									type="audio/ogg"></audio>
							</div>
							<div class="col-lg-12">
								<button id="hien" class="btn btn-info" type="reset"
									onclick="chiTiet();">
									<i class="fa fa-times"></i> Chi tiết
								</button>
							</div>
							<div class="col-lg-12">
								<button id="an" class="btn btn-info" type="reset"
									onclick="an();">
									<i class="fa fa-times"></i> Ẩn
								</button>
							</div>
							<div class="col-lg-12">
								<p>
							</div>
							<div id="chitiet" class="col-lg-12 thumbnail"
								style="min-height: 500px; padding: 0px;">
								<html:textarea property="nghe" readonly="true"
									style="width:100%; height: 490px;" name="taoBaiHocForm"
									cols="10"></html:textarea>
							</div>
						</div>

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
      
      CKEDITOR.replace("editor1");
   </script>
</body>
</html>