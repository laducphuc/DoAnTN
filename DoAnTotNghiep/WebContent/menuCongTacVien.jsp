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
<title>Danh Sách Từ Vựng</title>
<link rel="stylesheet"
   href="font-awesome-4.4.0/css/font-awesome.min.css">
<link rel="stylesheet" href="css/songnguvietnhat3.css">
<link rel="stylesheet" href="css/style.css" />
<script src="js/jquery-1.11.2.min.js"></script>
<script src="js/bootstrap.min.js"></script>
<div class="col-lg-3" style="height: auto; padding-right: 0px;">
	<div class="col-lg-12 thanhVienNoiBat">
		<div class="col-lg-12" style="text-align: center;">
			<label> Quản lý</label>
		</div>
		<div class="col-lg-12">
			<hr style="border: 1px solid #ddd; margin: 2px 0px;">
		</div>

		<ul>
			<li><html:link action="/tao-tu-vung.do">
					<span class="glyphicon glyphicon-minus"></span>  Tạo mới từ vựng</html:link>
			</li>
			<li><html:link action="/tao-bai-hoc.do">
					<span class="glyphicon glyphicon-minus"></span>  Tạo mới bài học</html:link>
			</li>
			<li><html:link action="/tao-de-thi.do">
					<span class="glyphicon glyphicon-minus"></span>  Tạo mới đề thi</html:link>
			</li>
			<li><html:link action="/chon.do">
               <span class="glyphicon glyphicon-minus"></span>  Tạo mới câu hỏi</html:link>
         </li>
		</ul>
	</div>
</div>