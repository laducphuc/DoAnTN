package action;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import form.CauHoiForm;
import model.bean.CauHoi;
import model.bo.CapDoBO;
import model.bo.CauHoiBO;

public class QuanLyCauHoiAction extends Action {
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");

		CauHoiForm cauHoiForm = (CauHoiForm) form;
		CauHoiBO cauHoiBO = new CauHoiBO();
		CapDoBO capDoBO = new CapDoBO();
		cauHoiForm.setListCapDo(capDoBO.listCapDo());
		String maCapDo = cauHoiForm.getMaCapDo();
		String timKiem = cauHoiForm.getTimKiem();
		ArrayList<CauHoi> listCauHoi = new ArrayList<CauHoi>();
		System.out.println("key:" + timKiem);
		if (maCapDo == null || "".equals(maCapDo)) {
			listCauHoi = cauHoiBO.listCauHoi();
		} else {
			listCauHoi = cauHoiBO.listCauHoi(maCapDo);
		}
		cauHoiForm.setListCauHoi(listCauHoi);
		return mapping.findForward("ds_cauhoi");
	}
}
