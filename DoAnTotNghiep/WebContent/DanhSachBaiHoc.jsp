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
<title>Danh Sách Bài Học</title>
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
</script>

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
				<div class="col-lg-9" style="height: auto; padding: 0px">
					<div class="col-lg-12 divMain"
						style="background: white; height: auto;">

						<div class="col-lg-12">
							<h4 style="font-size: 30px; text-align: center;">
								<i class="fa fa-use"></i>Giáo trình Minnano Nihongo
							</h4>
						</div>
						<div class="col-lg-12" style="border-bottom: 1px solid blue;">
							<h4>
								<i class="fa fa-list"></i> Danh sách bài học (
								<bean:write name="chonBaiForm" property="soBaiHoc" />
								)
							</h4>
						</div>
						<div class="col-lg-12 thumbnail" style="min-height: 500px;padding: 0px; ">
							<table class="table table-striped"
								style="width: 100%; display: block; position: absolute; white-space: nowrap; border-collapse: separate; height: 500px; overflow: auto;">
								<thead>
									<tr class="success">
										<th style="width: 10%"><bean:write name="chonBaiForm"
												property="tenCapDo" /></th>
									</tr>
								</thead>
								<tbody id="showtable">
									<logic:notEmpty name="chonBaiForm" property="listBaiHoc">
										<logic:iterate name="chonBaiForm" property="listBaiHoc"
											id="baiHoc">
											<tr>
												<td><bean:define id="maBaiHoc" name="baiHoc"
														property="maBaiHoc"></bean:define> <html:link
														action="/chi-tiet-bai-hoc?maBaiHoc=${maBaiHoc}">
														<bean:write property="tenBaiHoc" name="baiHoc" />
														</span>
													</html:link></td>
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