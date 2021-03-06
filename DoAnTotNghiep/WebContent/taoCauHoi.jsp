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
<title>Tạo câu hỏi mới</title>
<link rel="stylesheet"
	href="font-awesome-4.4.0/css/font-awesome.min.css">
<link rel="stylesheet" href="css/songnguvietnhat3.css">
<link rel="stylesheet" href="css/bootstrap.min.css">
<link rel="stylesheet" href="css/style.css" />
<link rel="stylesheet" href="css/fileinput.css">
<script src="js/jquery-1.11.2.min.js"></script>
<script src="js/fileinput.js"></script>
<script src="js/bootstrap.min.js"></script>
<script src="js/PaginationJS.js"></script>
<script type="text/javascript" src="js/my-include.js"></script>
<script type="text/javascript" src="js/fix-menu.js"></script>
<script src="ckeditor/ckeditor.js"></script>
<script type="text/javascript">
	function clicking() {
		window.location.href = '/DoAnTotNghiep/tao-cau-hoi.do';
	}
	function clicking2() {
	      window.location.href = '/DoAnTotNghiep/tao-cau-hoi-file.do';
	   }
</script>
</head>
<body onload="onload();">
	<!-- header -->
	<div class="include" data-include="header"></div>
	<jsp:include page="dangNhapForm.jsp"></jsp:include>
	<!-- boby -->
	<div class="col-lg-12">
		<div class="col-lg-12" style="margin-top: 20px; padding: 0px;">
			<div class="col-lg-12" style="height: auto; padding: 0px">
				<div class="col-lg-9" style="height: auto; padding: 0px">
					<div class="col-lg-12 divMain"
						style="background: white; height: auto;">
						<br></br>
						<div class="panel panel-info">
							<div class="panel-heading">Tạo câu hỏi</div>
							<div class="container" id="select">
								<br> <br>
								<button type="submit" class="btn btn-primary"
									onclick="clicking2();">Input bằng File</button>
								<button type="submit" class="btn btn-primary"
									onclick="clicking();">Input bằng tay</button>
								<br> <br>
							</div>
						</div>
					</div>
				</div>
				<jsp:include page="menuCongTacVien.jsp"></jsp:include>
			</div>
		</div>
	</div>
	<!-- footer -->
	<div class="include" data-include="footer"></div>
</body>
<script type="text/javascript">
	var includes = $(".include");
	jQuery.each(includes, function() {
		var file = $(this).data("include") + ".jsp";
		$(this).load(file);
	});
</script>
<script type="text/javascript">
	$("#input-1").fileinput({
		showRemove : false,
		showUpload : false,
		browseLabel : "Sound",
		previewFileType : "audio"
	});
</script>