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
<title>Danh Sách Bài Test</title>
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
<style type="text/css">
</style>
<script type="text/javascript">
function disableF5(e) { if ((e.which || e.keyCode) == 116) e.preventDefault(); };
//To disable f5
 /* jQuery < 1.7 */
$(document).bind("keydown", disableF5);


	var ss = 1800;
	function countdown() {
		ss = ss - 1;
		if (ss < 0) {
			//alert("time over!");
			document.forms[0].submit();
		} else {
			var minute = Math.floor(ss / 60);
			var sec = ss % 60;
			if (sec < 10)
				document.getElementById("countdownsec").innerHTML = '0' + sec;
			else {
				document.getElementById("countdownsec").innerHTML = sec;
			}
			if (minute < 10)
				document.getElementById("countdownminute").innerHTML = '0'
						+ minute;
			else {
				document.getElementById("countdownminute").innerHTML = minute;
			}

			window.setTimeout("countdown()", 1000);
		}
	}
</script>
</head>
<body onload="countdown()" id="body">
   <nav class="navbar navbar-default navbar-fixed-top">
   <div class="container-fluid">
      <div class="navbar-header">
         <button type="button" class="navbar-toggle" data-toggle="collapse"
            data-target="#myNavbar">
            <span class="icon-bar"></span> <span class="icon-bar"></span> <span
               class="icon-bar"></span>
         </button>
         <a class="navbar-brand" href="index.jsp">Online Quiz Test</a>
      </div>
      <ul class="nav navbar-nav navbar-right">
      <logic:notEmpty name="thiForm" property="listCauHoi"> 
        <li><a href="#"><font size="5" color="blue">Time: <span id="countdownminute" style="color:blue;"></span>:<span id="countdownsec" style="color:blue;"></span></font></a></li>
        </logic:notEmpty>
        </ul>
   </div>
   </nav>
   
   <div class="container" style="margin-top: 60px">

      <div class="col-sm-12">
      <logic:notEmpty name="thiForm" property="listCauHoi"> 
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
                                    <label><html:checkbox property="chonPhuongAn"
                                          value="${soTTCH}-${soTTPA}">
                                          ${phuongAn }
                                       </html:checkbox></label>
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
                                       <label><html:checkbox property="chonPhuongAn"
                                             value="${soTTCH}-${soTTPA}">
                                             <html:img src="${imagePA}" />
                                          </html:checkbox></label>
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
                                    <label><html:radio property="chonPhuongAn${soTTCH}"
                                          value="${soTTCH}-${soTTPA}">
                                          ${phuongAn }
                                       </html:radio></label>
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
                                       <label><html:radio property="chonPhuongAn${soTTCH}"
                                             value="${soTTCH}-${soTTPA}">
                                             <html:img src="${imagePA}" />
                                          </html:radio></label>
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
                  
                  <div class="col-sm-offset-5 col-sm-5">
                     <html:submit styleClass="btn btn-default">Nộp bài</html:submit>
                  </div>
                  
               </html:form>


            </div>
      </logic:notEmpty>
      <logic:empty name="thiForm" property="listCauHoi"> 
       <div class="alert alert-info " style="text-align: center;"><h3>Server đang bảo trì, vui lòng quay lại sau</h3></div>
      </logic:empty>
         </div>
      </div>


   </div>



</body>
</html>