package action;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import form.TuVungForm;
import model.bean.TuVung;
import model.bo.TuVungBO;

public class DanhSachTuVungAction extends Action {
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");
		ArrayList<TuVung> listTuVung = new ArrayList<TuVung>();
		TuVungBO tuVungBO = new TuVungBO();
		listTuVung = tuVungBO.getAll();
		TuVungForm tuVungForm = (TuVungForm) form;
		tuVungForm.setListTuVung(listTuVung);
		return mapping.findForward("danhsachtuvung");
	}
}
