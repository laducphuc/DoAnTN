package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.bo.ThongKeBO;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import form.ThongKeForm;

public class ThongKeAction extends Action {
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");
		ThongKeForm thongkeForm = (ThongKeForm) form;

		ThongKeBO thongKeBO = new ThongKeBO();
		thongkeForm.setDanhSachThanhVien(thongKeBO.bangXepHangThanhVien());
		return mapping.findForward("hienThiBangXepHangThanhVien");
	}
}
