package action;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import form.ThiForm;
import model.bean.BaiThi;
import model.bo.CapDoBO;
import model.bo.DeThiBO;

public class QuanLyDeThiAction extends Action {
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");
		ArrayList<BaiThi> listDeThi=new ArrayList<BaiThi>();
		ThiForm thiForm =(ThiForm) form;
		DeThiBO deThiBO= new DeThiBO();
		CapDoBO capDoBO = new CapDoBO();
		thiForm.setListCapDo(capDoBO.listCapDo());
		String maCapDo = thiForm.getMaCapDo();
		String timKiem = thiForm.getTimKiem();
		System.out.println("key:"+ timKiem);
		if (maCapDo == null || "".equals(maCapDo)) {
			if (timKiem == null || "".equals(timKiem)) {
				listDeThi = deThiBO.listDeThi();
			} else {
				listDeThi = deThiBO.listDeThiByName(timKiem);
			}
		} else {
			if (timKiem == null || "".equals(timKiem)) {
				listDeThi = deThiBO.listDeThiByCapDo(maCapDo);
			} else {
				listDeThi = deThiBO.listDeThiByNamePK(timKiem, maCapDo);
			}
		}
		thiForm.setListBaiThi(listDeThi);
		return mapping.findForward("ds_dethi");
	}
}
