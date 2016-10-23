package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import form.ChonBaiForm;
import model.bo.BaiHocBO;

public class XoaBaiHocAction extends Action {
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");
		ChonBaiForm chonBaiForm = (ChonBaiForm) form;
		String maBai = chonBaiForm.getMaBaiHoc();
		BaiHocBO baiHocBO = new BaiHocBO();
		baiHocBO.xoaBaiHoc(maBai);
		return mapping.findForward("ds_bai_hoc");
	}
}
