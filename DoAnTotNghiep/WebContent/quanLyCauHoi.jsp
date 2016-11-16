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
<title>Danh Sách Câu Hỏi</title>
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
		$('#showtabl').pageMe({
			pagerSelector : '#myPager',
			showPrevNext : true,
			hidePageNumbers : false,
			perPage : 10
		});
	});
</script>
 <script type="text/javascript">
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
									<i class="fa fa-list"></i> Danh sách câu hỏi
								</h4>
							</div>
						</div>
						<div class="col-lg-12">
							<div class="col-lg-9">
								<html:form action="/danh-sach-cau-hoi" method="post">
									<div class="row form-group">
										<label class="col-lg-3">Liệt kê theo:</label>
										<div class="col-lg-4">
											<html:select property="maCapDo" styleClass="form-control"
												onchange="submit();">
												<option value="">-- Chọn cấp độ --</option>
												<html:optionsCollection name="cauHoiForm"
													property="listCapDo" label="tenCapDo" value="maCapDo" />
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
											<th style="width: 10%">Mã câu hỏi</th>
											<th style="width: 60%">Nội dung</th>
											<th style="width: 20%">Đáp án</th>
											<th style="width: 10%">Tùy chọn</th>
										</tr>
									</thead>
									<tbody id="showtabl">
										<logic:notEmpty name="cauHoiForm" property="listCauHoi">
											<logic:iterate name="cauHoiForm" property="listCauHoi"
												id="baiHoc">
												<tr>
													<bean:define id="maCauHoi" name="baiHoc"
														property="maCauHoi"></bean:define>
													<td><bean:write property="maCauHoi" name="baiHoc" /></td>
													<td><bean:write property="noiDung" name="baiHoc" /></td>
													<logic:notEmpty name="baiHoc" property="listPhuongAn">
														<td><logic:iterate id="pa" name="baiHoc"
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
													<td>
														<ul>
															<li title="sửa câu hỏi" style="display: inline"><html:link
																	action="/sua-cau-hoi?maCauHoi=${maCauHoi}">
																	<span class="glyphicon glyphicon-edit"></span>
																</html:link></li>
															<li title="sửa từ vựng" style="display: inline"><html:link
																	action="/xoa-cau-hoi?maCauHoi=${maCauHoi}"
																	onclick="return confirm('Bạn muốn xóa câu hỏi này?');">
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
							<div class="col-lg-12"
								style="text-align: center; margin-bottom: 25px">
								<ul style="margin: 0px" class="pagination pagination-lg pager"
									id="myPager"></ul>
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