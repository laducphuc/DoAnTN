<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>
<%@ taglib uri="http://struts.apache.org/tags-tiles" prefix="tiles"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Danh Sách Đề Thi</title>
<link rel="stylesheet"
	href="font-awesome-4.4.0/css/font-awesome.min.css">
<link rel="stylesheet" href="css/bootstrap.min.css">
<link rel="stylesheet" href="css/songnguvietnhat3.css">
<link rel="stylesheet" href="css/style.css" />
<link rel="stylesheet" href="css/bootstrap-formhelpers.css">
<link rel="stylesheet" href="css/bootstrap-formhelpers.min.css">
<link rel="stylesheet"
	href="font-awesome-4.4.0/css/font-awesome.min.css">
<script src="js/jquery-1.11.2.min.js"></script>
<script src="js/bootstrap.min.js"></script>
<script src="js/bootstrap-formhelpers.js"></script>
<script src="js/bootstrap-formhelpers.min.js"></script>
<script type="text/javascript" src="js/my-include.js"></script>
<script type="text/javascript" src="js/fix-menu.js"></script>
<script type="text/javascript">
	 $(document).ready(function() {
		$('#showtable').pageMe({
			pagerSelector : '#myPager',
			showPrevNext : true,
			hidePageNumbers : false,
			perPage : 10
		});
		$('#showtablelk').pageMe({
			pagerSelector : '#myPagerlk',
			showPrevNext : true,
			hidePageNumbers : false,
			perPage : 10
		});
	}); 
	function submit() {
		$('#id').click();
	}
</script>

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
				<div class="col-lg-9" style="height: auto; padding: 0px">
					<div class="col-lg-12 divMain"
						style="background: white; height: auto;">
						<div class="col-lg-12">
							<div class="col-lg-9">
								<h4>
									<i class="fa fa-list"></i> Danh sách đề thi
								</h4>
							</div>
						</div>
						<div class="col-lg-12">
							<div class="col-lg-9">
								<html:form action="/danh-sach-de-thi" method="post">
									<div class="row form-group">
										<div class="col-sm-3">
											<div class="input-group">
												<html:text property="timKiem" styleClass="form-control"></html:text>
											</div>
										</div>
										<label class="col-lg-3">Liệt kê theo:</label>
										<div class="col-lg-4">
											<html:select property="maCapDo" styleClass="form-control"
												onchange="submit();">
												<option value="">-- Chọn cấp độ --</option>
												<html:optionsCollection name="thiForm" property="listCapDo"
													label="tenCapDo" value="maCapDo" />
											</html:select>
										</div>
										<div class="col-lg-2">
											<html:submit styleClass="btn btn-primary" styleId="id">Xem</html:submit>
										</div>
									</div>
								</html:form>
							</div>
							<div class="col-lg-12 thumbnail"
								style="min-height: 500px; padding: 0px;">
								<table class="table table-striped"
									style="width: 100%; display: block; position: absolute; white-space: nowrap; border-collapse: separate; height: 500px; overflow: auto;">
									<thead>
										<tr class="success">
											<th style="width: 20%">STT</th>
											<th style="width: 40%">Tên đề thi</th>
											<th style="width: 40%">Cấp độ</th>
											<th style="width: 20%">Tùy chọn</th>
										</tr>
									</thead>
									<tbody id="showtable">
										<logic:notEmpty name="thiForm" property="listBaiThi">
											<logic:iterate name="thiForm" property="listBaiThi"
												id="baiHoc">
												<tr>
													<bean:define id="maDe" name="baiHoc" property="maDe"></bean:define>
													<td><bean:write property="stt" name="baiHoc" /></td>
													<td><bean:write property="tenDe" name="baiHoc" /></td>
													<td><bean:write property="tenCapDo" name="baiHoc" /></td>
													<td>
														<ul>
															<li title="sửa đề thi" style="display: inline"><html:link
																	action="/sua-de-thi?maDeThi=${ma}">
																	<span class="glyphicon glyphicon-edit"></span>
																</html:link></li>
															<li title="sửa từ vựng" style="display: inline"><html:link
																	action="/xoa-de-thi?maDeThi=${maDe}"
																	onclick="return confirm('Bạn muốn xóa đề thi này?');">
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
							<div class="row" style="text-align: center;">
								<div class="col-lg-4"></div>
								<div class="col-lg-4">
									<ul style="margin: 0px" class="pagination pagination-lg pager"
										id="myPager"></ul>
								</div>
							</div>
							<!--  -->
						</div>
					</div>

				</div>
				<!-- body right -->
				<jsp:include page="menuCongTacVien.jsp"></jsp:include>
				<!-- footer -->
				<div class="include" data-include="footer"></div>
			</div>
		</div>
	</div>
</body>
</html>