package action;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import form.ThemBaiHocForm;
import model.bean.BaiHoc;
import model.bean.TuVung;
import model.bo.BaiHocBO;
import model.bo.TuVungBO;

public class BaiHocAction extends Action {
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");
		ThemBaiHocForm baiHocForm = (ThemBaiHocForm) form;
		BaiHocBO baiHocBO = new BaiHocBO();
		TuVungBO tuVungBO = new TuVungBO();
		String maBaiHoc = baiHocForm.getMaBaiHoc();
		BaiHoc baiHoc = baiHocBO.getBaiHoc(maBaiHoc);
		String[] tuVung = baiHoc.getTuVung().split("@");
		ArrayList<TuVung> list = new ArrayList<TuVung>();
		TuVung tuVung1;
		for (int i = 0; i < tuVung.length; i++) {
			tuVung1=tuVungBO.getByPK(tuVung[i]);
			tuVung1.setStt(i+1+"");
			list.add(tuVung1);
		}
		baiHocForm.setListTuVung(list);
		baiHocForm.setNguPhap(baiHoc.getNguPhap());
		baiHocForm.setNghe(baiHoc.getNghe());
		baiHocForm.setFile(baiHoc.getSound());
		return mapping.findForward("bai_hoc");

	}
}
