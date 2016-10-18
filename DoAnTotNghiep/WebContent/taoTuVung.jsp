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
<title>Tạo từ vựng</title>
<link rel="stylesheet"
	href="font-awesome-4.4.0/css/font-awesome.min.css">
<link rel="stylesheet" href="css/bootstrap.min.css">
<link rel="stylesheet" href="css/songnguvietnhat3.css">
<link rel="stylesheet" href="css/style.css" />
<link rel="stylesheet" href="css/bootstrap-formhelpers.css">
<link rel="stylesheet" href="css/bootstrap-formhelpers.min.css">
<link rel="stylesheet"
	href="font-awesome-4.4.0/css/font-awesome.min.css">
<link rel="stylesheet" href="css/datepicker.css">
<link rel="stylesheet" href="css/fileinput.css">
<script src="js/jquery-1.11.2.min.js"></script>
<script src="js/fileinput.js"></script>
<script src="js/bootstrap.min.js"></script>
<script src="js/bootstrap-formhelpers.js"></script>
<script src="js/bootstrap-formhelpers.min.js"></script>
<script src="js/bootstrap-datepicker.js"></script>
<script type="text/javascript" src="js/my-include.js"></script>
<script type="text/javascript" src="js/fix-menu.js"></script>
<script type="text/javascript">
	$(document).ready(function() {
		$('#haha').datepicker({
			format : "yyyy-mm-dd"
		});
	});
</script>

</head>

<body>

	<!-- header -->
	<div class="include" data-include="header"></div>
	<!-- menu -->
	<jsp:include page="dangNhapForm.jsp"></jsp:include>
	<!-- boby -->
	<div class="col-lg-12">
		<div class="col-lg-1"
			style="height: auto; margin-right: 14px; margin-top: 20px;"></div>

		<div class="col-lg-10" style="margin-top: 20px; padding: 0px;">
			<div class="col-lg-12" style="height: auto; padding: 0px;">
				<!-- body main -->
				<div class="col-lg-12" style="height: auto; padding: 0px;">
					<div class="col-lg-12 divMain" style="height: auto;">
						<html:form action="/tao-tu-vung" method="post"
							enctype="multipart/form-data">
							<div class="col-lg-12">
								<h4
									style="font-size: 30px; margin-top: 30px; text-align: center;">
									<i class="fa fa-users"></i> Từ vựng
								</h4>
							</div>
							<div class="col-lg-12">
								<div class="col-lg-8">

									<div class="col-lg-12"
										style="border-bottom: 1px solid #725a65;">
										<h4>
											<i class="fa fa-info"></i> Tạo mới từ vựng
										</h4>
									</div>

									<div class="row form-group">
										<label class="control-label col-sm-12"
											style="text-align: left;"><i class="fa fa-commenting-o"></i>
											Mục từ:</label>
										<div class="col-sm-7">
											<html:text property="mucTu" styleClass="form-control"></html:text>
										</div>
										<div class="col-sm-1">
											<samp style="color: red">(*)</samp>
										</div>
										<div class="col-sm-12">
											<font style="color: red;"> <html:errors
													property="mucTuError" />
											</font>
										</div>
									</div>
									<div class="row form-group">
										<label class="control-label col-sm-12"
											style="text-align: left;"><i class="fa fa-commenting"></i>
											Dịch nghĩa:</label>
										<div class="col-sm-7">
											<html:text property="dichNghia" styleClass="form-control"></html:text>
										</div>
										<div class="col-sm-1">
											<samp style="color: red">(*)</samp>
										</div>
										<div class="col-sm-12">
											<font style="color: red;"> <html:errors
													property="dichNghiaError" />
											</font>
										</div>
									</div>
									<div class="row form-group">
										<label class="control-label col-sm-12"
											style="text-align: left;"><i class="fa fa-caret-square-o-right"></i>
											Phát âm:</label>
										<div class="col-sm-11">
											<html:file  styleId="input-1" property="amThanh"
												styleClass="file" accept="audio/*"></html:file>
										</div>
										<div class="col-sm-1">
											<samp style="color: red">(*)</samp>
										</div>
										<div class="col-sm-12">
											<font style="color: red;"> <html:errors
													property="amthanhError" />
											</font>
										</div>
									</div>
									<div class="row form-group">
										<div class="col-sm-12" style="text-align: center;">
											<html:submit styleClass="btn btn-info" property="submit"
												value="Submit"></html:submit>
										</div>
									</div>
								</div>
							</div>
						</html:form>
					</div>
				</div>
			</div>
		</div>

	</div>
	<!-- footer -->
	<div class="include" data-include="footer"></div>

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
</body>
</html>