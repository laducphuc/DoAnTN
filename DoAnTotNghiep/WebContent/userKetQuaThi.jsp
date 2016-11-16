<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>
<%@ taglib uri="http://struts.apache.org/tags-tiles" prefix="tiles"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Bootstrap Case</title>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="css/bootstrap.min.css">
<script src="js/jquery-1.11.2.min.js"></script>
<script src="js/bootstrap.min.js"></script>
<style type="text/css">
#form-tratu {
   height: 185px;
   background-color:none;
   background-repeat: no-repeat;
   background-size: 100% 100%;
   position: fixed;
   border: 0px solid #ddd;
   opacity: 0.9;
   top: 15%;
   right:4%;
   z-index:5;
   transition : right 0.75s;
   -moz-transition : right 0.75s;
   -webkit-transition : right 0.75s;
   box-shadow: 0px 0px 0px #888888;
}
</style>
</head>
<body>


	<nav class="navbar navbar-default">
	<div class="container-fluid">
		<div class="navbar-header">
			<button type="button" class="navbar-toggle" data-toggle="collapse"
				data-target="#myNavbar">
				<span class="icon-bar"></span> <span class="icon-bar"></span> <span
					class="icon-bar"></span>
			</button>
			<a class="navbar-brand" href="#">Online Quiz Test</a>
		</div>

	</div>
	</nav>
	<div class="container">
		<div class="col-sm-12">
			<div class="panel panel-info">
				<div class="panel-heading">
					<bean:write name="thiForm" property="tenDe" />
				</div>
				<div class="panel-body">
					<html:form action="/ketquathi">

						<logic:iterate id="cauhoi" name="thiForm" property="listCauHoi">
							<bean:define id="soTTCH" name="cauhoi" property="soThuTu"></bean:define>

							<label class="control-label col-sm-12"><font color="blue"><u>Câu
										số <bean:write name="cauhoi" property="soThuTu" /> :
								</u></font><br></br> </label>
							<!-- lay cau hoi ra -->
							<!-- kiem tra cau hoi co text k -->
							<logic:notEmpty name="cauhoi" property="noiDung">
								<label class="control-label col-sm-12"><bean:write
										name="cauhoi" property="noiDung" /></label>

							</logic:notEmpty>
							<!-- kiem tra cau hoi co hinh anh k -->
							<logic:notEmpty name="cauhoi" property="hinhAnh">
								<bean:define id="image" name="cauhoi" property="hinhAnh"></bean:define>
								<label class="control-label col-sm-12"><html:img
										src="${image}" /></label>
							</logic:notEmpty>
							<!-- lay danh sach phuong an -->
							<logic:iterate id="pa" name="cauhoi" property="listPhuongAn">
								<bean:define id="soTTPA" name="pa" property="soThuTuPA"></bean:define>

								<!-- kiem tra co phai nhieu phuong an dung k -->
								<logic:equal name="cauhoi" property="laCheckBox" value="true">
									<logic:notEmpty name="pa" property="noiDungPA">
										<div class="col-sm-12">
											<bean:define id="phuongAn" name="pa" property="noiDungPA"></bean:define>
											<div class="checkbox">



												<label class="col-sm-10"> <input type="checkbox"
													value="${soTTCH}-${soTTPA}"
													<logic:equal name="pa" property="coChon" value="1">
													 checked="checked" 
													 		</logic:equal>
													disabled="disabled">${phuongAn }</input>
												</label>




												<logic:equal name="pa" property="trangThai" value="1">
													<label class="col-sm-2"> <font color="green"
														size="3"><span class="glyphicon glyphicon-ok"></span></font>
													</label>
												</logic:equal>

												<logic:equal name="pa" property="trangThai" value="0">
													<label class="col-sm-2"> <font color="red" size="3"><span
															class="glyphicon glyphicon-remove"></span></font>
													</label>
												</logic:equal>

											</div>
											<logic:notEmpty name="pa" property="hinhAnh">
												<bean:define id="imagePA" name="pa" property="hinhAnh"></bean:define>
												<div class="col-sm-12">
													<label> <html:img src="${imagePA}" /></label>

												</div>
											</logic:notEmpty>
										</div>

									</logic:notEmpty>


									<logic:empty name="pa" property="noiDungPA">
										<logic:notEmpty name="pa" property="hinhAnh">
											<bean:define id="imagePA" name="pa" property="hinhAnh"></bean:define>
											<div class="col-sm-12">
												<div class="checkbox">
													<label class="col-sm-10"> <input type="checkbox"
														value="${soTTCH}-${soTTPA}"
														<logic:equal name="pa" property="coChon" value="1">
														checked="checked"
														</logic:equal>
														disabled="disabled">
													<html:img src="${imagePA}" /></input>
													</label>
													<logic:equal name="pa" property="trangThai" value="1">
														<label class="col-sm-2"> <font color="green"
															size="3"><span class="glyphicon glyphicon-ok"></span></font>
														</label>
													</logic:equal>

													<logic:equal name="pa" property="trangThai" value="0">
														<label class="col-sm-2"> <font color="red"
															size="3"><span class="glyphicon glyphicon-remove"></span></font>
														</label>
													</logic:equal>
												</div>
											</div>
										</logic:notEmpty>
									</logic:empty>

								</logic:equal>


								<!-- kiem tra co phai 1 phuong an dung k -->

								<logic:equal name="cauhoi" property="laCheckBox" value="false">
									<logic:notEmpty name="pa" property="noiDungPA">
										<div class="col-sm-12">
											<bean:define id="phuongAn" name="pa" property="noiDungPA"></bean:define>
											<div class="radio">
												<label class="col-sm-10"><html:radio disabled="true"
														property="chonPhuongAn${soTTCH}"
														value="${soTTCH}-${soTTPA}">
														${phuongAn }
													</html:radio></label>
												<logic:equal name="pa" property="trangThai" value="1">
													<label class="col-sm-2"> <font color="green"
														size="3"><span class="glyphicon glyphicon-ok"></span></font>
													</label>
												</logic:equal>

												<logic:equal name="pa" property="trangThai" value="0">
													<label class="col-sm-2"> <font color="red" size="3"><span
															class="glyphicon glyphicon-remove"></span></font>
													</label>
												</logic:equal>
											</div>

											<logic:notEmpty name="pa" property="hinhAnh">
												<bean:define id="imagePA" name="pa" property="hinhAnh"></bean:define>
												<div class="col-sm-12">
													<label> <html:img src="${imagePA}" /></label>
												</div>
											</logic:notEmpty>
										</div>
									</logic:notEmpty>

									<logic:empty name="pa" property="noiDungPA">
										<logic:notEmpty name="pa" property="hinhAnh">
											<bean:define id="imagePA" name="pa" property="hinhAnh"></bean:define>
											<div class="col-sm-12">
												<div class="radio">
													<label class="col-sm-10"><html:radio
															disabled="true" property="chonPhuongAn${soTTCH}"
															value="${soTTCH}-${soTTPA}">
															<html:img src="${imagePA}" />
														</html:radio></label>
													<logic:equal name="pa" property="trangThai" value="1">
														<label class="col-sm-2"> <font color="green"
															size="3"><span class="glyphicon glyphicon-ok"></span></font>
														</label>
													</logic:equal>

													<logic:equal name="pa" property="trangThai" value="0">
														<label class="col-sm-2"> <font color="red"
															size="3"><span class="glyphicon glyphicon-remove"></span></font>
														</label>
													</logic:equal>
												</div>

											</div>
										</logic:notEmpty>
									</logic:empty>
								</logic:equal>

							</logic:iterate>
							<div class="col-sm-12">
								<hr></hr>
							</div>

						</logic:iterate>



					</html:form>


				</div>

			</div>
			<div class="col-sm-3" id="form-tratu">
				<div class="panel panel-primary">

					<div class="panel-heading" >Kết quả thi</div>
					<div class="panel-body">
						<html:form action="/ketquathi">
							<label class="col-sm-12"> <font color="green" size="3">Kết
									quả bài thi trắc nghiệm</font>
							</label>
							<label class="col-sm-12">Tên đề thi: <bean:write
									name="thiForm" property="tenDe" /></label>
							<label class="col-sm-12">Số điểm: <bean:write
									name="thiForm" property="diemThi" />
							</label>

							<div class="col-sm-offset-4 col-sm-4">
								<html:submit styleClass="btn btn-default" value="Về trang chủ"
									property="btnSubmit"></html:submit>
							</div>
						</html:form>
					</div>
				</div>
			</div>
		</div>


	</div>



</body>
</html>