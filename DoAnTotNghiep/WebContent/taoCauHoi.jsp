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
<script src="js/jquery-1.11.2.min.js"></script>
<script src="js/bootstrap.min.js"></script>
<script src="js/PaginationJS.js"></script>
<script type="text/javascript" src="js/my-include.js"></script>
<script type="text/javascript" src="js/fix-menu.js"></script>
<script src="ckeditor/ckeditor.js"></script>
<script type="text/javascript">
	function handleSelect() {
		var e = document.getElementById("selectSoPA");
		var strUser = e.options[e.selectedIndex].value;
		var pan = [ 'pan1', 'pan2', 'pan3', 'pan4', 'pan5' ];
		var dan = [ 'dan1', 'dan2', 'dan3', 'dan4', 'dan5' ];
		var hAnh = [ 'hinhanhPA1', 'hinhanhPA2', 'hinhanhPA3', 'hinhanhPA4',
				'hinhanhPA5' ];

		for (var chiso = 1; chiso < (dan.length + 1); chiso++) {
			if ((chiso) == strUser) {
				for (var chiso2 = 0; chiso2 < (chiso); chiso2++) {
					document.getElementById(pan[chiso2]).disabled = false;
					document.getElementById(dan[chiso2]).disabled = false;
					document.getElementById(hAnh[chiso2]).disabled = false;
				}
				for (var chiso3 = (chiso); chiso3 < dan.length; chiso3++) {

					document.getElementById(pan[chiso3]).value = "";
					document.getElementById(dan[chiso3]).checked = false;
					document.getElementById(hAnh[chiso3]).value = "";
					document.getElementById(pan[chiso3]).disabled = true;
					document.getElementById(dan[chiso3]).disabled = true;
					document.getElementById(hAnh[chiso3]).disabled = true;
				}
			}
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
				<div class="col-lg-9" style="height: auto; padding: 0px">
					<div class="col-lg-12 divMain"
						style="background: white; height: auto;">
						<br></br>
						<div class="panel panel-info">
							<div class="panel-heading">Tạo câu hỏi</div>
							
								<div class="container">
									<html:form styleClass="form-horizontal" action="/tao-cau-hoi"
										method="post" enctype="multipart/form-data">
										<div class="form-group">
											<br></br> <label class="control-label col-sm-2" for="email">Nội
												dung câu hỏi:</label>
											<div class="col-sm-6">
												<html:textarea property="noiDung" styleClass="form-control"
													rows="5"></html:textarea>
												<font color="red"><html:errors
														property="saiNoiDungCH" /></font>

												<html:file property="hinhanhND" styleId="ndHinh"
													accept="image/*"></html:file>
												<font color="red"><html:errors property="saiHinhAnh0" /></font>
												<font color="red"><html:errors
														property="saiDinhDangHA0" /></font>
											</div>
											<label class="control-label col-sm-1" for="email"><font
												color="red">*</font></label>
										</div>
										<div class="form-group">
											<label class="control-label col-sm-2" for="email">Số
												lượng phương án:</label>
											<div class="col-sm-6">
												<html:select styleId="selectSoPA" styleClass="form-control"
													property="soPAChon" onchange="handleSelect()">
													<html:option value="2">2</html:option>
													<html:option value="3">3</html:option>
													<html:option value="4">4</html:option>
													<html:option value="5">5</html:option>
												</html:select>
											</div>
											<label class="control-label col-sm-1" for="email"><font
												color="red">*</font></label>
										</div>
										<div class="form-group">
											<label class="control-label col-sm-2" for="pwd">Phương
												án 1:</label>
											<div class="col-sm-6">
												<html:text styleId="pan1" property="phuongAn1"
													styleClass="form-control"></html:text>
												<font color="red"><html:errors
														property="saiPhuongAn1" /></font>
												<html:file property="hinhanhPA1" styleId="hinhanhPA1"
													accept="image/*"></html:file>
												<font color="red"><html:errors property="saiHinhAnh1" /></font>
												<font color="red"><html:errors
														property="saiDinhDangHA1" /></font>
											</div>
											<label class="control-label col-sm-1" for="email"><font
												color="red">*</font></label>
										</div>

										<div class="form-group">
											<label class="control-label col-sm-2" for="pwd">Phương
												án 2:</label>
											<div class="col-sm-6">
												<html:text styleId="pan2" property="phuongAn2"
													styleClass="form-control"></html:text>
												<font color="red"><html:errors
														property="saiPhuongAn2" /></font>
												<html:file property="hinhanhPA2" styleId="hinhanhPA2"
													accept="image/*"></html:file>
												<font color="red"><html:errors property="saiHinhAnh2" /></font>
												<font color="red"><html:errors
														property="saiDinhDangHA2" /></font>
											</div>
											<label class="control-label col-sm-1" for="email"><font
												color="red">*</font></label>
										</div>

										<div class="form-group">
											<label class="control-label col-sm-2" for="pwd">Phương
												án 3:</label>
											<div class="col-sm-6">
												<html:text styleId="pan3" property="phuongAn3"
													styleClass="form-control"></html:text>
												<font color="red"><html:errors
														property="saiPhuongAn3" /></font>
												<html:file property="hinhanhPA3" styleId="hinhanhPA3"
													accept="image/*"></html:file>
												<font color="red"><html:errors property="saiHinhAnh3" /></font>
												<font color="red"><html:errors
														property="saiDinhDangHA3" /></font>
											</div>
											<label class="control-label col-sm-1" for="email"><font
												color="red">*</font></label>
										</div>
										<div class="form-group">
											<label class="control-label col-sm-2" for="pwd">Phương
												án 4:</label>
											<div class="col-sm-6">
												<html:text styleId="pan4" property="phuongAn4"
													styleClass="form-control"></html:text>
												<font color="red"><html:errors
														property="saiPhuongAn4" /></font>
												<html:file property="hinhanhPA4" styleId="hinhanhPA4"
													accept="image/*"></html:file>
												<font color="red"><html:errors property="saiHinhAnh4" /></font>
												<font color="red"><html:errors
														property="saiDinhDangHA4" /></font>
											</div>
											<label class="control-label col-sm-1" for="email"><font
												color="red">*</font></label>
										</div>
										<div class="form-group">
											<label class="control-label col-sm-2" for="pwd">Phương
												án 5:</label>
											<div class="col-sm-6">
												<html:text styleId="pan5" property="phuongAn5"
													styleClass="form-control"></html:text>
												<font color="red"><html:errors
														property="saiPhuongAn5" /></font>
												<html:file property="hinhanhPA5" styleId="hinhanhPA5"
													accept="image/*"></html:file>
												<font color="red"><html:errors property="saiHinhAnh5" /></font>
												<font color="red"><html:errors
														property="saiDinhDangHA5" /></font>
											</div>
											<label class="control-label col-sm-1" for="email"><font
												color="red">*</font></label>
										</div>
										<div class="form-group">
											<label class="control-label col-sm-2" for="pwd">Đáp
												án:</label>
											<div class="col-sm-6">
												<label class="checkbox-inline"> <html:checkbox
														styleId="dan1" property="dapAn" value="1">Phương án 1</html:checkbox>
												</label> <label class="checkbox-inline"> <html:checkbox
														styleId="dan2" property="dapAn" value="2">Phương án 2</html:checkbox>
												</label> <label class="checkbox-inline"> <html:checkbox
														styleId="dan3" property="dapAn" value="3">Phương án 3</html:checkbox>
												</label>
											</div>
											<label class="control-label col-sm-1" for="email"><font
												color="red">*</font></label>
										</div>

										<div class="form-group">
											<label class="control-label col-sm-2" for="pwd"></label>
											<div class="col-sm-6">
												<label class="checkbox-inline"> <html:checkbox
														styleId="dan4" property="dapAn" value="4">Phương án 4</html:checkbox>
												</label> <label class="checkbox-inline"> <html:checkbox
														styleId="dan5" disabled="true" property="dapAn" value="5">Phương án 5</html:checkbox>

												</label>
											</div>
										</div>
										<div class="form-group">
											<label class="control-label col-sm-2" for="pwd"></label>
											<div class="col-sm-6">
												<font color="red"><html:errors property="saiDapAn" /></font>
											</div>
										</div>
										<div class="form-group">
											<label class="control-label col-sm-2" for="pwd">Chọn
												cấp độ:</label>
											<div class="col-sm-6">
												<html:select property="maCapDo" styleClass="form-control">
													<html:optionsCollection name="taoCauHoiForm"
														property="listCapDo" value="maCapDo" label="tenCapDo" />
												</html:select>
											</div>
											<label class="control-label col-sm-1" for="email"><font
												color="red">*</font></label>
										</div>

										<div class="form-group">
											<div class="col-sm-offset-2 col-sm-10">
												<html:submit styleClass="btn btn-default"
													property="btnSubmit" value="Submit"></html:submit>
												<button type="submit" class="btn btn-default"
													onclick="history.go(-1);">Trở về</button>
												<br></br>
											</div>
										</div>
									</html:form>
								</div>
						</div>
					</div>
				</div>
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