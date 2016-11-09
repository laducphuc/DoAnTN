package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import form.ThiForm;
import model.bo.DeThiBO;

public class XoaDeThiAction extends Action {
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");
		ThiForm thiForm =(ThiForm) form;
		DeThiBO deThiBO= new DeThiBO();
		deThiBO.xoaDeThi(thiForm.getMaDeThi());
		return mapping.findForward("ds_cauhoi");
	}
}
