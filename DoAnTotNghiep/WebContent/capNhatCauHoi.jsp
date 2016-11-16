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
<title>Trang Admin- Cập nhật thông tin cộng tác viên</title>
<link rel="stylesheet"
	href="font-awesome-4.4.0/css/font-awesome.min.css">
<link rel="stylesheet" href="css/bootstrap.min.css">
<link rel="stylesheet" href="css/songnguvietnhat3.css">
<link rel="stylesheet" href="css/style.css" />
<link rel="stylesheet" href="css/datepicker.css">
<link rel="stylesheet" href="css/fileinput.css">
<script src="js/jquery-1.11.2.min.js"></script>
<script src="js/bootstrap.min.js"></script>
<script src="js/fileinput.js"></script>
<script src="js/bootstrap-datepicker.js"></script>
<script type="text/javascript" src="js/my-include.js"></script>
<script type="text/javascript" src="js/fix-menu.js"></script>
<script type="text/javascript">
	$(document).ready(function() {
		$('#birthdate').datepicker({
			format : "yyyy-mm-dd"
		});
	});
</script>
<style type="text/css">
</style>
</head>
<body>
	<!-- header -->
	<div class="include" data-include="header"></div>
	<!-- menu -->
	<div class="col-lg-12" id="tabMenu">
		<div class="col-lg-12" id="menuItems">
			<ul>
				<li><a href="trang-gioi-thieu.do">Giới thiệu</a></li>
				<li><html:link style="width: 60px;" action="/trang-chu.do">Trang chủ</html:link></li>
				<li class="dropdown"><a class="dropdown-toggle"
					data-toggle="dropdown" href="#">Học theo giáo trình <span
						class="caret"></span></a>
					<ul class="dropdown-menu" style="text-align: left">
						<li><html:link action="/bai-hoc.do?maCapDo=CD001"
								style="text-align: left">Giáo trình N5</html:link></li>
						<li><html:link action="/bai-hoc.do?maCapDo=CD002"
								style="text-align: left">Giáo trình N4</html:link></li>
						<li><html:link action="/bai-hoc.do?maCapDo=CD003"
								style="text-align: left">Giáo trình N3</html:link></li>
						<li><html:link action="/bai-hoc.do?maCapDo=CD004"
								style="text-align: left">Giáo trình N2</html:link></li>
					</ul></li>
				<li class="dropdown"><a class="dropdown-toggle"
					data-toggle="dropdown" href="#">Luyện thi <span class="caret"></span></a>
					<ul class="dropdown-menu" style="text-align: left">
						<li><html:link action="/test.do?maCapDo=CD001"
								style="text-align: left">Đề luyện thi N5</html:link></li>
						<li><html:link action="/test.do?maCapDo=CD002"
								style="text-align: left">Đề luyện thi N4</html:link></li>
						<li><html:link action="/test.do?maCapDo=CD003"
								style="text-align: left">Đề luyện thi N3</html:link></li>
						<li><html:link action="/test.do?maCapDo=CD004"
								style="text-align: left">Đề luyện thi N2</html:link></li>
					</ul></li>
				<logic:notEmpty name="dangNhapForm" property="taiKhoan"
					scope="session">
					<bean:define id="taikhoan" property="taiKhoan" name="dangNhapForm"
						scope="session"></bean:define>
					<li class="dropdown pull-right"><a class="dropdown-toggle"
						href="#"> <bean:define id="anh" name="taikhoan" property="anh"></bean:define>
							<html:img src="avata/${anh }" styleClass="img-circle"
								style="width: 40px; height:40px" /> <bean:write name="taikhoan"
								property="tenThanhVien" /> <span class="caret"></span>
					</a>
						<ul class="dropdown-menu">
							<li><html:link action="/xem-thong-tin-ca-nhan.do">Thông tin cá nhân</html:link></li>
							<li><html:link action="/danh-sach-bai-hoc.do">Quản lý tài liệu</html:link></li>
							<li><html:link action="/danh-sach-de-thi.do">Quản lý đề thi</html:link></li>
							<li><html:link action="/list-tu-vung.do">Quản lý từ vựng</html:link></li>
							<li><html:link action="/danh-sach-cau-hoi.do">Quản lý câu hỏi</html:link></li>
							<li><html:link action="/dang-xuat.do">Đăng xuất</html:link></li>
						</ul></li>
				</logic:notEmpty>
			</ul>
		</div>
	</div>

	<!-- boby -->
	<div class="col-lg-12">

		<div class="col-lg-12" style="margin-top: 20px; padding: 0px;">
			<div class="col-lg-12" style="height: auto; padding: 0px">
				<!-- body main -->
				<div class="col-lg-9" style="height: auto; padding: 0px">
					<div class="col-lg-12 divMain"
						style="height: auto; background: white;">
						<div class="col-lg-1"></div>
						<bean:define id="maCauHoi" name="cauHoiForm" property="maCauHoi"></bean:define>
						<html:form
							action="/sua-cau-hoi?maCauHoi=${maCauHoi}"
							method="post" enctype="multipart/form-data">
							<div class="col-lg-8">
								<div class="col-lg-12">
									<h4
										style="font-size: 30px; margin-top: 30px; text-align: center;">
										<i class="fa fa-users"></i> Cập nhật câu hỏi
									</h4>
								</div>

								<div class="col-lg-12">
									<div class="row form-group" style="margin-top: 25px;">
										<label class="control-label col-sm-12"
											style="text-align: left;"><i class="fa fa-key"></i>
											Nội dung:</label>
										<div class="col-sm-12">
											<html:text name="cauHoiForm" property="noiDung"
												styleClass="form-control"></html:text>
										</div>
									</div>
									<div class="row form-group">
										<label class="control-label col-sm-12"
											style="text-align: left;"> <i class="fa fa-user"></i>
											Đán án đúng:
										</label>
										<div class="col-sm-12">
											<html:text name="cauHoiForm" property="dapAn1"
												styleClass="form-control"></html:text>
										</div>
										<div class="col-sm-12">
                                 <font style="color: red;"> <html:errors
                                       property="dapAn1Error" />
                                 </font>
                              </div>
									</div>
									<div class="row form-group">
										<label class="control-label col-sm-12"
											style="text-align: left;"><i class="fa fa-map-marker"></i>
											Đáp án sai:</label>
										<div class="col-sm-12">
											<html:text name="cauHoiForm" property="dapAn2"
												styleClass="form-control"></html:text>
										</div>
										<div class="col-sm-12">
											<font style="color: red;"> <html:errors
													property="dapAn2Error" />
											</font>
										</div>
									</div>
									<div class="row form-group">
                              <label class="control-label col-sm-12"
                                 style="text-align: left;"><i class="fa fa-map-marker"></i>
                                 Đáp án sai:</label>
                              <div class="col-sm-12">
                                 <html:text name="cauHoiForm" property="dapAn3"
                                    styleClass="form-control"></html:text>
                              </div>
                              <div class="col-sm-12">
                                 <font style="color: red;"> <html:errors
                                       property="dapAn3Error" />
                                 </font>
                              </div>
                           </div>
                           <div class="row form-group">
                              <label class="control-label col-sm-12"
                                 style="text-align: left;"><i class="fa fa-map-marker"></i>
                                 Đáp án sai:</label>
                              <div class="col-sm-12">
                                 <html:text name="cauHoiForm" property="dapAn4"
                                    styleClass="form-control"></html:text>
                              </div>
                              <div class="col-sm-12">
                                 <font style="color: red;"> <html:errors
                                       property="dapAn4Error" />
                                 </font>
                              </div>
                           </div>
									<div class="row form-group">
										<label class="control-label col-sm-12"
											style="text-align: left;"><i class="fa fa-user"></i>
											Cấp độ:</label>
										<div class="col-sm-12">
											<html:text name="cauHoiForm" property="tenCapDo"
												styleClass="form-control" disabled="true"></html:text>
										</div>
									</div>
								</div>
								<div class="col-sm-12"
									style="text-align: center; margin-top: 10px; margin-bottom: 30px;">
									<html:submit styleClass="btn btn-info" property="submit"
										value="Hoàn tất"></html:submit>
									<html:button styleClass="btn btn-info" property="button"
										value="Quay lại" onclick="history.go(-1);"></html:button>
								</div>
							</div>
						</html:form>
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
		$("#input-1").fileinput({
			showUpload : false,
			showRemove : false,
			browseLabel : "Duyệt ảnh đại diện",
			PreviewFileType : "image",
		});
	</script>
</body>
</html>