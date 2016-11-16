package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.bo.ThanhVienBO;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import form.ThanhVienForm;

public class XoaThanhVienAction extends Action{
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");

		ThanhVienForm thanhVienForm = (ThanhVienForm) form;

		String maThanhVien = thanhVienForm.getMaThanhVien();
		String chucVu = thanhVienForm.getChucVu();
		
		ThanhVienBO thanhVienBO = new ThanhVienBO();
		if (thanhVienBO.xoaThanhVien(maThanhVien)){
			if ("0".equals(chucVu)){
				return mapping.findForward("xoaThanhVienThanhCong");
			} else {
				return mapping.findForward("xoaCongTacVienThanhCong");
			}
		} else {
			if ("0".equals(chucVu)){
				thanhVienForm.setThanhVien(thanhVienBO.chonThanhVien(maThanhVien));
				return mapping.findForward("xoaThanhVienThatBai");
			} else {
				thanhVienForm.setThanhVien(thanhVienBO.chonThanhVien(maThanhVien));
				return mapping.findForward("xoaCongTacVienThatBai");
			}
		}
	}
}
