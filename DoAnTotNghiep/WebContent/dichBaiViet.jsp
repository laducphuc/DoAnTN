<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>
<%@ taglib uri="http://struts.apache.org/tags-tiles" prefix="tiles"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Trang Cộng tác viên- Dịch bài viết</title>
<link rel="stylesheet" href="css/songnguvietnhat3.css">
<link rel="stylesheet" href="css/bootstrap.min.css">
<link rel="stylesheet" href="css/star-rating.min.css">
<link rel="stylesheet" href="css/style.css" />
<link rel="stylesheet" href="css/chart.css" />
<script src="js/jquery-1.11.2.min.js"></script>
<script src="js/bootstrap.min.js"></script>
<script src="js/star-rating.min.js"></script>
<script src="js/jchart.js"></script>
<script type="text/javascript" src="js/my-include.js"></script>
<script type="text/javascript" src="js/fix-menu.js"></script>
<script type="text/javascript" src="js/translate.js"></script>
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
							<li><html:link action="/them-bai-viet.do">Viết bài mới</html:link></li>

							<li><a href="#">Quản Lý bài Dịch <span class="caret"></span>
							</a>
								<ul class="mySubmenu">
									<li><html:link action="/bai-viet-chua-duyet.do">Bài mới được phân công</html:link></li>
									<li><html:link action="/bai-viet-nhan-dich.do">Bài Viết Đã Nhận Dịch</html:link></li>
								</ul></li>
							<li><html:link action="/dang-xuat.do">Đăng xuất</html:link></li>
						</ul></li>
				</logic:notEmpty>
			</ul>
		</div>
	</div>
	</div>
	<!--  body -->
	<div class="col-lg-3" id="form-tratu">
		<div class="col-lg-12" style="text-align: center">
			<label>Tra từ nhanh</label>
		</div>
		<div class="col-lg-12">
			<select id="source">
				<option value="jpn">Japanese</option>
				<option value="vie">Vietnamese</option>
			</select>
		</div>
		<div class="col-lg-12">
			<textarea id="mytext" rows="4" cols="35"></textarea>
		</div>
		<div class="col-lg-12">
			<select id="dest">
				<option value="vie">Vietnamese</option>
				<option value="jpn">Japanese</option>
			</select>
		</div>
		<div class="col-lg-12">
			<textarea id="result" rows="4" cols="35" disabled="disabled"></textarea>
		</div>
		<div class="col-lg-12" style="text-align: center; margin-top: 10px;">
			<input type="button" class="btn btn-default" value="Dịch"
				id="translate">
		</div>
	</div>

	<div class="col-lg-12">
		<div class="col-lg-12" style="margin-top: 20px; padding: 0px;">
			<div class="col-lg-12" style="padding: 0px">
				<div class="col-lg-9" style="padding: 0px">
					<!-- Bắt đầu thể hiển thị nội dung chương trình -->
					<div class="col-lg-12 divMain" style="background: white;">
						<div class="col-lg-0"></div>
						<div class="col-lg-12">
							<h3
								style="text-align: center; font-weight: bold; font-size: 30px">Dịch
								Bài Viết</h3>
							<bean:define id="baiviet" name="danhSachBaiVietForm"
								property="baiViet"></bean:define>
							<div>
								<div class="col-lg-6"
									style="margin-top: 10px; margin-bottom: 10px;">
									<h4>Tiêu Đề</h4>
									<div class="divMain" style="width: 395px; height: 50px;">
										<h5 class="title">
											<bean:write name="baiviet" property="tieuDeViet" />
										</h5>

									</div>
								</div>
								<div class="col-lg-6"
									style="margin-top: 10px; margin-bottom: 10px;">
									<h4>タイトル</h4>
									<div style="width: 395px;">
										<div class="form-group">
											<textarea class="form-control" rows="4" id="tieuDe"
												style="height: 50px; resize: none;"><bean:write
													name="danhSachBaiVietForm" property="tieuDeNhat" /> </textarea>
										</div>


									</div>
								</div>
							</div>
							<div>
								<div class="col-lg-6"
									style="margin-top: 10px; margin-bottom: 10px;">
									<h4>Mô Tả</h4>
									<div class="divMain" style="width: 395px; height: 100px;">
										<h5 class="title">
											<bean:write name="baiviet" property="moTaViet" />
										</h5>

									</div>
								</div>
								<div class="col-lg-6"
									style="margin-top: 10px; margin-bottom: 10px;">
									<h4>説明</h4>
									<div style="width: 395px;">
										<div class="form-group">
											<textarea class="form-control" rows="4" id="moTa"
												style="height: 100px; resize: none;"><bean:write
													name="danhSachBaiVietForm" property="moTaNhat" /></textarea>
										</div>


									</div>
								</div>
							</div>
							<div>
								<div class="col-lg-12"
									style="margin-top: 10px; margin-bottom: 10px;">
									<h4>Nội Dung Toàn bài Viết</h4>
									<div id="noiDungBaiViet" class="divMain"
										style="height: 300px; overflow: scroll;">
										<!-- 	<logic:iterate id="noiDungBaiViet" name="danhSachBaiVietForm"
											property="noiDungBaiViet">
											<h5 class="title">
												<bean:write name="noiDungBaiViet" />
											</h5>
										</logic:iterate>
									 -->
										<html:hidden styleId="noiDungViet" property="noiDungViet"
											name="baiviet" />
									</div>
								</div>
							</div>
							<div class="col-lg-12">
								<div class="col-lg-6"
									style="margin-top: 10px; margin-bottom: 10px;">
									<h4>Dịch Từng Câu</h4>
									<div class="divMain" style="width: 395px; height: 150px;">
										<h5 class="title" id="theh5"></h5>

									</div>
								</div>
								<div class="col-lg-6"
									style="margin-top: 10px; margin-bottom: 10px;">
									<h4>それぞれの文を翻訳します。</h4>
									<div style="width: 395px;">
										<div class="form-group">
											<textarea class="form-control" rows="4" id="noiDung"
												style="height: 150px; resize: none;" name="baidich"></textarea>
										</div>
									</div>
								</div>
							</div>
							<div class="col-lg-12">
								<div class="row form-group"
									style="margin-top: 10px; margin-right: -70px;">
									<div class="col-lg-offset-3 col-lg-3">
										<button class="btn btn-primary" id="prebt" type="reset"
											style="float: left;">Câu Trước &laquo;</button>
									</div>
									<div class="col-lg-3">
										<button class="btn btn-primary" id="nextbt" type="reset"
											style="float: left;">Câu Tiếp Theo &raquo;</button>
									</div>
								</div>
							</div>
							<div class="col-lg-12">
								<div class="col-lg-12">
									<div class="col-lg-12" style="padding-bottom: 10px;">
										<div class="col-lg-12">
											<div class=col-lg-12 style="margin-left: -40px;">

												<div tabindex="-1" class="modal fade" id="myModal"
													role="dialog" aria-hidden="true"
													aria-labelledby="myModalTitle">
													<div class="modal-dialog">
														<div class="modal-content">
															<div class="modal-header">
																<button class="close" aria-hidden="true" type="button"
																	data-dismiss="modal">×</button>
																<h4 class="modal-title" id="myModalTitle">Cập nhật
																	trạng thái bài viết</h4>
															</div>
															<html:form action="dich-bai-viet" styleId="dichForm"
																onsubmit="mysubmit()">
																<div class="modal-body">
																	<div class="form-group">
																		<label for="recipient-name" class="control-label">Tiêu
																			đề:</label>
																		<h5 class="title">
																			<bean:write name="baiviet" property="tieuDeViet" />
																		</h5>
																	</div>
																	<div class="form-group">
																		<label for="message-text" class="control-label">Trạng
																			Thái:</label>
																		<html:select property="trangThai"
																			name="danhSachBaiVietForm" styleId="select"
																			styleClass="form-control">
																			<option value="dichXong">Dịch xong</option>
																			<option value="dangDich">Đang dịch</option>
																		</html:select>
																	</div>
																</div>
																<div class="modal-footer">
																	<html:hidden property="tieuDeNhat"
																		name="danhSachBaiVietForm" styleId="tieuDeNhat" />
																	<html:hidden property="moTaNhat"
																		name="danhSachBaiVietForm" styleId="moTaNhat" />
																	<html:hidden property="noiDungNhat"
																		name="danhSachBaiVietForm" styleId="noiDungNhat" />
																	<html:hidden property="maBaiViet"
																		name="danhSachBaiVietForm" />
																	<html:hidden property="submit"
																		name="danhSachBaiVietForm" value="submit" />
																	<button class="btn btn-default" id="myModalClose"
																		type="button" data-dismiss="modal">Close</button>
																	<html:hidden property="trangThai" styleId="trangThai"
																		name="danhSachBaiVietForm" />
																	<html:hidden property="submit"
																		name="danhSachBaiVietForm" value="submit" />
																	<html:submit styleClass="btn btn-primary"
																		styleId="myModalSave" value="Cập Nhật"></html:submit>
																</div>
															</html:form>
														</div>
													</div>

												</div>
											</div>
										</div>
									</div>
								</div>
								<div class="col-lg-12">
									<div class="col-lg-4 "></div>
									<div class="col-lg-1"">
										<ul>
											<li><a class="btn btn-default" id="myModalLaunch"
												data-target="#myModal" data-toggle="modal">Lưu</a></li>
										</ul>
									</div>

									<div class="col-lg-2">
										<ul>
											<li><a href="#Foo" data-toggle="collapse"
												style="color: black;" class="btn btn-default" id="anHien">Đóng
													Khung Trao Đổi</a></li>
										</ul>
									</div>
								</div>
								<div class="col-lg-12 collapse in" id="Foo" data-spy="scroll"
									data-target="#myScrollspy" data-offset="20"
									style="height: 600px; margin-top: 10px; margin-bottom: 10px;">
									<div class="divMain" style="width: 800px; height: 600px;">
										<h4 style="padding-left: 15px; text-decoration: underline;">Bình
											Luận Bài Viết</h4>
										<bean:define id="tenTaiKhoan" name="dangNhapForm"
											property="tenTaiKhoan" scope="session"></bean:define>
										<div class="form-group">
											<html:form action="dich-bai-viet">
												<label class="col-sm-12" for="email"><bean:write
														name="tenTaiKhoan" /> </label>
												<img class="col-sm-2" alt="quypro" src="image/avatar.jpg"
													width="50px" height="50px">
												<div class="col-sm-10">
													<input type="text" class="form-control" id="email"
														name="noiDungBinhLuan"
														placeholder="Nhập bình luận của bạn">
												</div>
												<html:hidden property="ktBinhLuan"
													name="danhSachBaiVietForm" value="binhLuan" />
												<html:hidden property="maThanhVien"
													name="danhSachBaiVietForm" />
												<html:hidden property="maBaiViet" name="danhSachBaiVietForm" />
												<div class="form-group" style="margin-top: 5px;">
													<div class="col-sm-offset-2 col-sm-10">
														<html:submit styleClass="btn btn-default"
															style="float: right;margin-top: 10px;">Bình Luận</html:submit>
													</div>
												</div>
											</html:form>
										</div>
										<div class="col-lg-12"
											style="height: 400px; margin-top: 10px; margin-bottom: 10px;">
											<div class="divMain col-lg-12"
												style="height: 400px; overflow: scroll">
												<div class="col-lg-1"></div>
												<logic:iterate id="noiDungTraoDoi"
													name="danhSachBaiVietForm" property="danhSachTraoDoi">
													<div class="form-group divMain"
														style="margin-top: 20px; height: 70px; width: 730px;">
														<label class="col-sm-6" for="email">[<bean:write
																name="noiDungTraoDoi" property="chucVu" />]
														</label> <label class=col-sm-6
															style="text-align: right; padding-right: 20px;"><bean:write
																name="noiDungTraoDoi" property="ngayBinhLuan" /> </label>
														<div class="col-sm-1"
															style="width: 50px; height: 40px; margin-left: 10px;">
															<img alt="quypro" src="image/avatar1.jpg" width="50px"
																height="40px">
														</div>
														<div class="col-sm-10">
															<h5 class="title" style="margin-top: 15px;">
																<h5 style="font-weight: bold; display: inline;">
																	<bean:write name="noiDungTraoDoi"
																		property="tenTaiKhoan" />
																	:
																</h5>
																<bean:write name="noiDungTraoDoi"
																	property="noiDungBinhLuan" />
															</h5>
														</div>

													</div>
												</logic:iterate>
											</div>
										</div>
									</div>

								</div>

							</div>

							<div class="col-lg-0"></div>

						</div>
					</div>
				</div>
				<!-- body right -->
				<div class="col-lg-3" style="height: auto; padding-right: 0px;">
					<div class="col-lg-12 danhMuc"
						style="background-color: white; height: 130px">
						<div class="col-lg-12"
							style="background: url('image/menu2.png') no-repeat scroll 0px 10px; height: 46px; margin-left: 14px">
							<h5
								style="color: black; text-align: center; padding: 10px; margin: 0px; font-size: 1.2em">Bài
								Menu nhanh</h5>
							<ul>
								<li><html:link style="color: black;"
										action="/bai-viet-chua-duyet.do">Bài mới được phân công</html:link></li>
								<li><html:link style="color: black;"
										action="/bai-viet-nhan-dich.do">Bài Viết Đã Nhận Dịch</html:link></li>
							</ul>
						</div>
						<div class="col-lg-12"></div>
					</div>
				</div>
			</div>
		</div>

	</div>
	<!-- footer -->
	<div class="include" data-include="footer"></div>



	<script type="text/javascript">
	<%ArrayList<String> strList=(ArrayList<String>)request.getAttribute("noiDungBaiViet");%>
	var x=0;
	var noiDungBaiViet= [
		<%for (int i = 0; i < strList.size(); i++) {%> 
		<%="'"+strList.get(i)+"'"%>
		<%=(i + 1) < strList.size() ? ",":""%>
		<%}%>
		,'<p>Hết</p>'];
	console.log("noiDung"+noiDungBaiViet[0]);
	console.log("noiDung"+noiDungBaiViet[1]);
	<%ArrayList<String> strList1=(ArrayList<String>)request.getAttribute("noiDungBaiNhat");%>
	var noiDungBaiNhat= ["",
	<%for (int i = 0; i < strList1.size(); i++) {%>
	<%="'"+strList1.get(i)+"'"%>,
	<%}%>""];
		$(document).ready(
				function() {
					$("#theh5 p").remove();
					$("#theh5").append(noiDungBaiViet[0]);
					$("#noiDung").val(noiDungBaiNhat[1]);
					for(var i=noiDungBaiNhat.length-1;i<noiDungBaiViet.length;i++){
						noiDungBaiNhat.push("");
					}
					$("#population_chart").jChart(
							{
								name : "Đánh Giá Chi Tiết (Đơn vị : %)",
								headers : [ "5 sao", "4 sao", "3 sao", "2 sao",
										"1 sao" ],
								values : [ 25, 47, 88, 42, 42 ],
								footers : [ 10, 20, 30, 40, 50, 60, 70, 80, 90,
										100 ],
								colors : [ "#AAAAAA", "#555555", "#AAAAAA",
										"#555555", "#AAAAAA" ]
							});
				});
		$("#nextbt").click(function(){
			if(x>noiDungBaiViet.length-2)
				return;
			noiDungBaiNhat[x+1]=$("#noiDung").val();
			x++;
			$("#theh5 p").remove();
			$("#theh5").append(noiDungBaiViet[x]);
			$("#noiDung").val(noiDungBaiNhat[x+1]);
			
		});
		$("#prebt").click(function(){
			if(x===0)
				return;
			noiDungBaiNhat[x+1]=$("#noiDung").val();
			x--;
			$("#theh5 p").remove();
			$("#theh5").append(noiDungBaiViet[x]);
			$("#noiDung").val(noiDungBaiNhat[x+1]);
			
		});
		function mysubmit(){
			var y="";
			document.getElementById("tieuDeNhat").value = document.getElementById("tieuDe").value;
			document.getElementById("moTaNhat").value = document.getElementById("moTa").value;
			for(var i=1;i<noiDungBaiNhat.length-1;i++){
				y=y+noiDungBaiNhat[i]+" /// ";
			}
			document.getElementById("noiDungNhat").value=y;
			//alert(y);
		}
	</script>
	<script type="text/javascript">
		var noiDungViet=$("#noiDungViet").val();
		$("#noiDungBaiViet").append(noiDungViet);
	</script>
</body>
</html>