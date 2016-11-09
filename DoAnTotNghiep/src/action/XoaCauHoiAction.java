package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import form.CauHoiForm;
import model.bo.CauHoiBO;

public class XoaCauHoiAction extends Action {
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");

		CauHoiForm cauHoiForm = (CauHoiForm) form;
		CauHoiBO cauHoiBO=new CauHoiBO();
		cauHoiBO.xoaCauHoi(cauHoiForm.getMaCauHoi());
		return mapping.findForward("ds_cauhoi");
	}
}
