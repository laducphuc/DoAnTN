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
					<span class="glyphicon glyphicon-minus"></span>  Thống kê thành viên</html:link>
			</li>
			<li><html:link action="/bang-xep-hang-cong-tac-vien.do">
					<span class="glyphicon glyphicon-minus"></span>  Tài liệu</html:link></li>
		</ul>
	</div>
</div>