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
<style type="text/css">
</style>
<style type="text/css">
.baihoc {
	background-position: center;
	background-size: cover;
}
</style>
<script type="text/javascript">
	$(document).ready(function() {

		$('#showtable').pageMe({
			pagerSelector : '#myPager',
			showPrevNext : true,
			hidePageNumbers : false,
			perPage : 10
		});

		$('.audio').hide();
	});

	function play(x) {
		document.getElementById(x).play();
	}
</script>

</head>
<body>
	<!-- header -->
	<div class="include" data-include="header"></div>
	<%-- <jsp:include page="menu.jsp"></jsp:include> --%>
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
							<div class="col-sm-3" >
								<button type="button"
									style="width: 128px; height: 100px; background-image: url('image/Source/tuvung.png');
									background-color: #ddefdd;"
									class="btn-default" onclick="ly();" onfocus=""></button>
								<h4>Từ vựng</h4>
							</div>
							<div class="col-sm-3">
								<button type="button"
									style="width: 128px; height: 100px; background-image: url('image/Source/nguphap.png');"
									class="btn-default" onclick="ly();"></button>
								<h4>Ngữ pháp</h4>
							</div>
							<div class="col-sm-3">
								<button type="button"
									style="width: 128px; height: 100px; background-image: url('image/Source/nghe.png');"
									class="btn-default" onclick="ly();"></button>
								<h4>Nghe</h4>
							</div>
							<div class="col-sm-3">
								<button type="button"
									style="width: 128px; height: 100px; background-image: url('image/Source/luyentap.png');"
									class="btn-default" onclick="ly();"></button>
								<h4>Luyện tập</h4>
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
										<th style="width: 60%">Nghĩa</th>
									</tr>
								</thead>
								<tbody id="showtable">
									<tr>
										<td>1</td>
										<td>111</td>
										<td><a href="javascript:;" onclick="play(1);"> <span
												class="glyphicon glyphicon-play-circle"></span>
										</a> <audio id="1"> <source src="Sound/TuVung/anata.mp3"
												type="audio/ogg"></audio></td>
										<td>1111111</td>
									</tr>
								</tbody>
							</table>
						</div>

						<!--  -->
						<div class="col-lg-12"
							style="text-align: center; margin-bottom: 25px">
							<ul style="margin: 0px" class="pagination pagination-lg pager"
								id="myPager"></ul>
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
</body>
</html>