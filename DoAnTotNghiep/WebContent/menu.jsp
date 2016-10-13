<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>
<%@ taglib uri="http://struts.apache.org/tags-tiles" prefix="tiles"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<div id="tabMenu" class="col-lg-12 tabMenu" style="padding: 0px;">
	<%-- <logic:empty name="dangNhapForm" property="taiKhoan" scope="session"> --%>
	<div id="menuItems" class="col-lg-12">
		<ul>
			<li><a href="trang-gioi-thieu.do">Giới thiệu</a></li>
			<li><html:link action="/trang-chu.do">Trang chủ</html:link></li>
			<li class="dropdown"><a class="dropdown-toggle"
				data-toggle="dropdown" href="#">Học theo giáo trình <span
					class="caret"></span></a>
				<ul class="dropdown-menu" style="text-align: left">
					<li><html:link action="/bai-hoc.do?maCapDo=GT001"
							style="text-align: left">Giáo trình N5</html:link></li>
					<li><html:link action="/bai-hoc.do?maCapDo=GT002"
							style="text-align: left">Giáo trình N4</html:link></li>
					<li><html:link action="/bai-hoc.do?maCapDo=GT003"
							style="text-align: left">Giáo trình N3</html:link></li>
				</ul></li>
			<li class="dropdown"><a class="dropdown-toggle"
				data-toggle="dropdown" href="#">Luyện thi online <span
					class="caret"></span></a>
				<ul class="dropdown-menu" style="text-align: left">
					<li><html:link action="/test.do?maCapDo=GT001"
							style="text-align: left">Đề luyện thi N5</html:link></li>
					<li><html:link
							action="/test.do?maDanhMuc=DM00000002&kiemTra=1"
							style="text-align: left">Đề luyện thi N4</html:link></li>
					<li><html:link
							action="/test.do?maDanhMuc=DM00000003&kiemTra=1"
							style="text-align: left">Đề luyện thi N3</html:link></li>
				</ul></li>
			<li><html:link action="/dang-ky-thanh-vien.do">Đăng ký thành viên</html:link></li>
			<li class="pull-right"><html:link href="#x"
					onclick="hienThiFormDangNhap()">Đăng Nhập</html:link></li>
		</ul>
	</div>