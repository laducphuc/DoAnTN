package action;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import form.ThemBaiHocForm;
import model.bean.TuVung;
import model.bo.TuVungBO;

public class ChonTuVungAction extends Action {
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");
		ThemBaiHocForm themBaiHocForm = (ThemBaiHocForm) form;
		TuVungBO tuVungBO = new TuVungBO();
		String kt=themBaiHocForm.getKt();
		System.out.println("kiem tra:"+kt);
		themBaiHocForm.setListTuVung(tuVungBO.getAll());
		themBaiHocForm.setTongTuVung(tuVungBO.getAll().size());
		if ("submit".equals(themBaiHocForm.getSubmit())) {
			themBaiHocForm.setKt(kt);
			String[] chonTuVung = themBaiHocForm.getChonTuVung();
			ArrayList<TuVung> listTuVung = new ArrayList<TuVung>();
			if (chonTuVung != null) {
				for (int i = 0; i < chonTuVung.length; i++) {
					listTuVung.add(tuVungBO.getByPK(chonTuVung[i]));
				}
			}
			HttpSession session = request.getSession();
			session.setAttribute("sessionTuVung", listTuVung);
			System.out.println("kt:" + themBaiHocForm.getKt());
			if ("1".equals(themBaiHocForm.getKt())) {
				return mapping.findForward("sua_bh");
			}
			if ("0".equals(themBaiHocForm.getKt())) {
				return mapping.findForward("themOK");
			}
		}
		return mapping.findForward("themNG");
	}
}
