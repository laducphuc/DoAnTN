<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>
<%@ taglib uri="http://struts.apache.org/tags-tiles" prefix="tiles"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Header</title>
</head>
<body>
	<div class="col-lg-12" style="height: 170px; padding: 0px;">
		<div class="col-lg-2"
			style="padding: 0px; margin-top: 10px; text-align: right;">
			<html:img styleClass="img-circle" alt="Hinh" src="image/bg6.jpg"
				height="150px" width="150px"></html:img>
		</div>
		<div class="col-lg-10">
			<div class="row">
				<h1 class="col-lg-offset-1 col-lg-9"
					style="font-family: Playfair Display; font-weight: bold; color: #FF0000">Dịch
					Thuật Việt - Nhật</h1>
			</div>
			<div class="row">
				<h3 class="col-lg-offset-2"
					style="font-family: Playfair Display; color: #8B4513; font-size: 12;">Cộng
					đồng chia sẻ tin tức, hỗ trợ dịch thuật Việt-Nhật</h3>
			</div>
			<div class="row">
				<html:form action="/trang-chu">
					<div class="col-lg-offset-8 col-lg-3" style="padding-left: 45px;">
						<html:text property="noiDungTimKiem" styleClass="form-control"
							style="box-shadow: 2px 2px 5px #888888"></html:text>
					</div>
					<div class="col-lg-1" style="height: 34px; padding: 0px;">
						<button type="submit" style="background-color: transparent;border: none;">
							<span id="my-search" class="glyphicon glyphicon-search"></span>
						</button>
					</div>
				</html:form>
			</div>
		</div>
	</div>

</body>
</html>