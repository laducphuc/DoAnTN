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

public class QuanLyBaiHocAction extends Action {
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");
		ArrayList<BaiHoc> listBaiHoc = new ArrayList<BaiHoc>();
		ChonBaiForm chonBaiForm = (ChonBaiForm) form;
		BaiHocBO baiHocBO = new BaiHocBO();
		CapDoBO capDoBO = new CapDoBO();
		chonBaiForm.setListCapDo(capDoBO.listCapDo());
		String maCapDo = chonBaiForm.getMaCapDo();
		String timKiem = chonBaiForm.getTimKiem();
		System.out.println("key:"+ timKiem);
		if (maCapDo == null || "".equals(maCapDo)) {
			if (timKiem == null || "".equals(timKiem)) {
				listBaiHoc = baiHocBO.listBaiHoc();
			} else {
				listBaiHoc = baiHocBO.listBaiHocByName(timKiem);
			}
		} else {
			if (timKiem == null || "".equals(timKiem)) {
				listBaiHoc = baiHocBO.listBaiHocByCapDo(maCapDo);
			} else {
				listBaiHoc = baiHocBO.listBaiHocByNamePK(timKiem, maCapDo);
			}
		}
		chonBaiForm.setListBaiHoc(listBaiHoc);
		return mapping.findForward("ds_baihoc");
	}
}
