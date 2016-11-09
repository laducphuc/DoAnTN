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
import model.bo.DeThiBO;

public class ChonBaiThiAction extends Action {
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=UTF-8");
		ThiForm thiForm = (ThiForm) form;
		ArrayList<BaiThi> listBaiThi=new ArrayList<BaiThi>();
		DeThiBO deThiBo=new DeThiBO();
		String maCapDo=thiForm.getMaCapDo();
		listBaiThi=deThiBo.listDeThiByCapDo(maCapDo);
		thiForm.setListBaiThi(listBaiThi);
		thiForm.setSoBaiThi(listBaiThi.size()+"");
		return mapping.findForward("bai_thi");
	}

}
