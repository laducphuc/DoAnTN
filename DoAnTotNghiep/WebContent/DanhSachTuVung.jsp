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
<title>Danh Sách Từ Vựng</title>
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

<script type="text/javascript">
	$(document).ready(function() {

		$('#showtable').pageMe({
			pagerSelector : '#myPager',
			showPrevNext : true,
			hidePageNumbers : false,
			perPage : 10
		});
		
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
										<th style="width: 50%">Nghĩa</th>
										<th style="width: 10%">Tùy chọn</th>
									</tr>
								</thead>
								<tbody id="showtable">
									<logic:notEmpty name="tuVungForm" property="listTuVung">
										<logic:iterate name="tuVungForm" property="listTuVung"
											id="tuVung">
											<tr>
												<bean:define id="maTuVung" name="tuVung" property="maTuVung"></bean:define>
												<bean:define id="amThanh" name="tuVung" property="amThanh"></bean:define>
												<td><bean:write property="stt" name="tuVung" /></td>
												<td><bean:write property="mucTu" name="tuVung" /></td>
												<td><a href="javascript:;" onclick="play(${maTuVung});">
														<span class="glyphicon glyphicon-play-circle"></span>
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
				<jsp:include page="menuCongTacVien.jsp"></jsp:include>
			</div>
		</div>

	</div>
	<!-- footer -->
	<div class="include" data-include="footer"></div>
</body>
</html>