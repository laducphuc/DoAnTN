package action;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

import common.StringProcess;
import form.TaoDeThiForm;
import model.bean.BaiThi;
import model.bean.CauHoi;
import model.bo.CapDoBO;
import model.bo.CauHoiBO;
import model.bo.DeThiBO;

public class TaoDeThiAction extends Action {
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=UTF-8");
		TaoDeThiForm taoDeThiForm = (TaoDeThiForm) form;
		CapDoBO capDoBO = new CapDoBO();
		CauHoiBO cauHoiBO = new CauHoiBO();
		taoDeThiForm.setListCapDo(capDoBO.listCapDo());
		String maCapDo = taoDeThiForm.getMaCapDo();
		if (maCapDo!=null &&!"".equals(maCapDo)) {
			ArrayList<CauHoi> listCauHoi = cauHoiBO.listCauHoi(maCapDo);
			taoDeThiForm.setListCauHoi(listCauHoi);
			taoDeThiForm.setTongCauHoi(taoDeThiForm.getListCauHoi().size()+"");
		}
		if ("submit".equals(taoDeThiForm.getSubmit())) {
			ActionErrors actionErrors = new ActionErrors();
			if (StringProcess.notVaild(taoDeThiForm.getMaCapDo())) {
				actionErrors.add("capDoError", new ActionMessage("error.tv.muctutrong"));
			}
			if (taoDeThiForm.getChonCauHoi() == null) {
				actionErrors.add("cauHoiError", new ActionMessage("error.tv.cauhoirong"));
			}
			if (StringProcess.notVaild(taoDeThiForm.getTenDeThi())) {
				actionErrors.add("tenDeThiError", new ActionMessage("error.tv.tenderong"));
			}
			saveErrors(request, actionErrors);
			if (actionErrors.size() > 0) {
				return mapping.findForward("themError");
			}
		}
		if ("submit".equals(taoDeThiForm.getSubmit())) {
			String[] chonCauHoi = taoDeThiForm.getChonCauHoi();
			String cauHoi="";
			if (chonCauHoi != null) {
				for (int i = 0; i < chonCauHoi.length; i++) {
					cauHoi+=chonCauHoi[i]+"@@";
				}
			}
			BaiThi baiThi=new BaiThi();
			baiThi.setCauHoi(cauHoi);
			baiThi.setTenDe(taoDeThiForm.getTenDeThi());
			baiThi.setMaCapDo(taoDeThiForm.getMaCapDo());
			DeThiBO deThiBO=new DeThiBO();
			deThiBO.themDeThi(baiThi);
			return mapping.findForward("themOK");
		}
		return mapping.findForward("tao-de-thi");
	}

}
