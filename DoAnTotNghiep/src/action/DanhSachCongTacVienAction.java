package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import common.StringProcess;
import form.DanhSachThanhVienForm;
import model.bo.ThanhVienBO;

public class DanhSachCongTacVienAction extends Action {
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		response.setCharacterEncoding("UTF-8");
		DanhSachThanhVienForm dsThanhVienForm = (DanhSachThanhVienForm) form;
		String tuKhoaTimKiem = null;
		String noiDungTimKiem = null;		
		
		if (dsThanhVienForm.getNoiDungTimKiem() != null){
			String a=StringProcess.toUTF8(dsThanhVienForm.getNoiDungTimKiem());
			System.out.println("kết nối thành công"+a+"::"+dsThanhVienForm.getNoiDungTimKiem());
			tuKhoaTimKiem = dsThanhVienForm.getTuKhoaTimKiem();
			noiDungTimKiem = dsThanhVienForm.getNoiDungTimKiem();
		}
		
		ThanhVienBO thanhVienBO = new ThanhVienBO();
		if (tuKhoaTimKiem == null || tuKhoaTimKiem.length() == 0
				|| noiDungTimKiem == null || noiDungTimKiem.length() == 0) {
			dsThanhVienForm.setNoiDungTimKiem(noiDungTimKiem);
			dsThanhVienForm.setTuKhoaTimKiem(noiDungTimKiem);
			System.out.println(tuKhoaTimKiem + "/" + noiDungTimKiem);
			dsThanhVienForm.setDanhSachThanhVien(thanhVienBO.chonDanhSachCongTacVien());
		} else {
			dsThanhVienForm.setNoiDungTimKiem(noiDungTimKiem);
			dsThanhVienForm.setTuKhoaTimKiem(noiDungTimKiem);
			System.out.println(tuKhoaTimKiem + "/" + noiDungTimKiem);
			dsThanhVienForm.setDanhSachThanhVien(thanhVienBO.timKiemCongTacVien(tuKhoaTimKiem, noiDungTimKiem));
		 }
		return mapping.findForward("hienThiDanhSachCongTacVien");
	}
}
