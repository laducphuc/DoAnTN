package action;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import form.ChonBaiForm;
import model.bean.BaiHoc;
import model.bo.BaiHocBO;
import model.bo.CapDoBO;

public class ChonBaiAction extends Action {
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");
		ArrayList<BaiHoc> listBaiHoc = new ArrayList<BaiHoc>();
		ChonBaiForm chonBaiForm = (ChonBaiForm) form;
		BaiHocBO baiHocBO = new BaiHocBO();
		CapDoBO capDoBO = new CapDoBO();
		String maCapDo = chonBaiForm.getMaCapDo();
		if (maCapDo == null || "".equals(maCapDo)) {
			listBaiHoc = baiHocBO.listBaiHoc();
		} else {
			listBaiHoc = baiHocBO.listBaiHocByCapDo(maCapDo);
			System.out.println("ma cap do:"+maCapDo);
		}
		String tenCapDo = capDoBO.getTenCDByPK(maCapDo);
		chonBaiForm.setTenCapDo(tenCapDo);
		chonBaiForm.setListBaiHoc(listBaiHoc);
		return mapping.findForward("chon_bai");
	}
}
