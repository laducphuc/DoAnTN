<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>
<%@ taglib uri="http://struts.apache.org/tags-tiles" prefix="tiles"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<div id="tabMenu" class="col-lg-12 tabMenu" style="padding: 0px;">
	<logic:empty name="dangNhapForm" property="taiKhoan" scope="session">
		<div id="menuItems" class="col-lg-12">
			<ul>
				<li><a href="trang-gioi-thieu.do">Giới thiệu</a></li>
				<li><html:link action="/trang-chu.do">Trang chủ</html:link></li>
				<li class="dropdown"><a class="dropdown-toggle"
					data-toggle="dropdown" href="#">Danh Mục Bài Viết <span
						class="caret"></span></a>
					<ul class="dropdown-menu" style="text-align: left">
						<li><html:link
								action="/trang-chu.do?maDanhMuc=DM00000001&kiemTra=1"
								style="text-align: left">Xã Hội</html:link></li>
						<li><html:link
								action="/trang-chu.do?maDanhMuc=DM00000002&kiemTra=1"
								style="text-align: left">Thế Giới</html:link></li>
						<li><html:link
								action="/trang-chu.do?maDanhMuc=DM00000003&kiemTra=1"
								style="text-align: left">Giáo Dục</html:link></li>
						<li><html:link
								action="/trang-chu.do?maDanhMuc=DM00000004&kiemTra=1"
								style="text-align: left">Công Nghệ</html:link></li>
						<li><html:link
								action="/trang-chu.do?maDanhMuc=DM00000005&kiemTra=1"
								style="text-align: left">Thể Thao</html:link></li>
						<li><html:link
								action="/trang-chu.do?maDanhMuc=DM00000006&kiemTra=1"
								style="text-align: left">Giải Trí</html:link></li>
						<li><html:link
								action="/trang-chu.do?maDanhMuc=DM00000007&kiemTra=1"
								style="text-align: left">Sức Khỏe</html:link></li>
					</ul></li>
				<li><html:link action="/dang-ky-thanh-vien.do">Đăng ký thành viên</html:link></li>
				<li class="pull-right"><html:link href="#x"
						onclick="hienThiFormDangNhap()">Đăng Nhập</html:link></li>
			</ul>
		</div>
	</logic:empty>
	<logic:notEmpty name="dangNhapForm" property="taiKhoan" scope="session">
		<bean:define id="taiKhoan" name="dangNhapForm" property="taiKhoan"
			scope="session"></bean:define>
		<logic:equal value="3" name="taiKhoan" property="chucVu">
			<div id="menuItems" class="col-lg-12">
				<ul>
					<li><a href="trang-gioi-thieu.do">Giới thiệu</a></li>
					<li><html:link action="/trang-chu.do">Trang chủ</html:link></li>
					<li class="dropdown"><a class="dropdown-toggle"
						data-toggle="dropdown" href="#">Danh Mục Bài Viết <span
							class="caret"></span></a>
						<ul class="dropdown-menu" style="text-align: left">
							<li><html:link
									action="/trang-chu.do?maDanhMuc=DM00000001&kiemTra=1"
									style="text-align: left">Xã Hội</html:link></li>
							<li><html:link
									action="/trang-chu.do?maDanhMuc=DM00000002&kiemTra=1"
									style="text-align: left">Thế Giới</html:link></li>
							<li><html:link
									action="/trang-chu.do?maDanhMuc=DM00000003&kiemTra=1"
									style="text-align: left">Giáo Dục</html:link></li>
							<li><html:link
									action="/trang-chu.do?maDanhMuc=DM00000004&kiemTra=1"
									style="text-align: left">Công Nghệ</html:link></li>
							<li><html:link
									action="/trang-chu.do?maDanhMuc=DM00000005&kiemTra=1"
									style="text-align: left">Thể Thao</html:link></li>
							<li><html:link
									action="/trang-chu.do?maDanhMuc=DM00000006&kiemTra=1"
									style="text-align: left">Giải Trí</html:link></li>
							<li><html:link
									action="/trang-chu.do?maDanhMuc=DM00000007&kiemTra=1"
									style="text-align: left">Sức Khỏe</html:link></li>
						</ul></li>

					<li class="dropdown pull-right"><a class="dropdown-toggle"
						dropdown-toggle="dropdown" href="#"> <bean:define id="anh"
								name="taiKhoan" property="anh"></bean:define> <html:img
								src="avata/${anh }" styleClass="img-circle"
								style="width: 40px; height:40px" /> <bean:write name="taiKhoan"
								property="tenThanhVien" /> <span class="caret"></span></a>

						<ul class="dropdown-menu">
							<li><html:link action="/danh-sach-thanh-vien.do">Quản trị</html:link></li>
							<li><html:link action="/thong-tin-admin.do">Thông tin cá nhân</html:link></li>
							<li><html:link action="/dang-xuat.do">Đăng xuất</html:link></li>
						</ul></li>
				</ul>
			</div>
		</logic:equal>
		<logic:equal value="1" name="taiKhoan" property="chucVu">
			<div id="menuItems" class="col-lg-12">
				<ul>
					<li><a href="trang-gioi-thieu.do">Giới thiệu</a></li>
					<li><html:link style="width: 60px;" action="/trang-chu.do">Trang chủ</html:link></li>
					<li class="dropdown"><a class="dropdown-toggle"
						data-toggle="dropdown" href="#">Danh Mục Bài Viết <span
							class="caret"></span></a>
						<ul class="dropdown-menu" style="text-align: left">
							<li><html:link
									action="/trang-chu.do?maDanhMuc=DM00000001&kiemTra=1"
									style="text-align: left">Xã Hội</html:link></li>
							<li><html:link
									action="/trang-chu.do?maDanhMuc=DM00000002&kiemTra=1"
									style="text-align: left">Thế Giới</html:link></li>
							<li><html:link
									action="/trang-chu.do?maDanhMuc=DM00000003&kiemTra=1"
									style="text-align: left">Giáo Dục</html:link></li>
							<li><html:link
									action="/trang-chu.do?maDanhMuc=DM00000004&kiemTra=1"
									style="text-align: left">Công Nghệ</html:link></li>
							<li><html:link
									action="/trang-chu.do?maDanhMuc=DM00000005&kiemTra=1"
									style="text-align: left">Thể Thao</html:link></li>
							<li><html:link
									action="/trang-chu.do?maDanhMuc=DM00000006&kiemTra=1"
									style="text-align: left">Giải Trí</html:link></li>
							<li><html:link
									action="/trang-chu.do?maDanhMuc=DM00000007&kiemTra=1"
									style="text-align: left">Sức Khỏe</html:link></li>
						</ul></li>

					<li class="dropdown pull-right"><a class="dropdown-toggle"
						href="#"> <bean:define id="anh" name="taiKhoan" property="anh"></bean:define>
							<html:img src="avata/${anh }" styleClass="img-circle"
								style="width: 40px; height:40px" /> <bean:write name="taiKhoan"
								property="tenThanhVien" /> <span class="caret"></span>
					</a>

						<ul class="dropdown-menu">
							<li><html:link action="/xem-thong-tin-ca-nhan.do">Thông tin cá nhân</html:link></li>
							<li><html:link action="/them-bai-viet.do">Viết bài mới</html:link></li>

							<li><a href="#">Quản Lý bài Dịch <span class="caret"></span>
							</a>
								<ul class="mySubmenu">
									<li><html:link action="/bai-viet-chua-duyet.do">Bài mới được phân công</html:link></li>
									<li><html:link action="/bai-viet-nhan-dich.do">Bài Viết Đã Nhận Dịch</html:link></li>
								</ul></li>
							<li><html:link action="/dang-xuat.do">Đăng xuất</html:link></li>
						</ul></li>
				</ul>
			</div>
		</logic:equal>
		<logic:equal value="0" name="taiKhoan" property="chucVu">
			<div class="col-lg-12" id="menuItems">
				<ul>
					<li><a href="trang-gioi-thieu.do">Giới thiệu</a></li>
					<li><html:link action="/trang-chu.do">Trang chủ</html:link></li>
					<li class="dropdown"><a class="dropdown-toggle"
						data-toggle="dropdown" href="#">Danh Mục Bài Viết <span
							class="caret"></span></a>
						<ul class="dropdown-menu" style="text-align: left">
							<li><html:link
									action="/trang-chu.do?maDanhMuc=DM00000001&kiemTra=1"
									style="text-align: left">Xã Hội</html:link></li>
							<li><html:link
									action="/trang-chu.do?maDanhMuc=DM00000002&kiemTra=1"
									style="text-align: left">Thế Giới</html:link></li>
							<li><html:link
									action="/trang-chu.do?maDanhMuc=DM00000003&kiemTra=1"
									style="text-align: left">Giáo Dục</html:link></li>
							<li><html:link
									action="/trang-chu.do?maDanhMuc=DM00000004&kiemTra=1"
									style="text-align: left">Công Nghệ</html:link></li>
							<li><html:link
									action="/trang-chu.do?maDanhMuc=DM00000005&kiemTra=1"
									style="text-align: left">Thể Thao</html:link></li>
							<li><html:link
									action="/trang-chu.do?maDanhMuc=DM00000006&kiemTra=1"
									style="text-align: left">Giải Trí</html:link></li>
							<li><html:link
									action="/trang-chu.do?maDanhMuc=DM00000007&kiemTra=1"
									style="text-align: left">Sức Khỏe</html:link></li>
						</ul></li>

					<li class="dropdown pull-right"><a class="dropdown-toggle"
						data-toggle="dropdown" href="#"> <bean:define id="anh"
								name="taiKhoan" property="anh"></bean:define> <html:img
								src="avata/${anh }" styleClass="img-circle"
								style="width: 40px; height:40px" /> <bean:write name="taiKhoan"
								property="tenThanhVien" /> <span class="caret"></span>
					</a>
						<ul class="dropdown-menu">
							<li><html:link action="/xem-thong-tin-ca-nhan.do">Thông tin cá nhân</html:link></li>
							<li><html:link action="/them-bai-viet.do">Viết bài mới</html:link></li>
							<li><html:link action="/dang-xuat.do">Đăng xuất</html:link></li>
						</ul></li>
				</ul>
			</div>
		</logic:equal>
	</logic:notEmpty>
</div>