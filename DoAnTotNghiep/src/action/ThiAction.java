package action;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import common.Common;
import form.ThiForm;
import model.bean.BaiThi;
import model.bean.CauHoi;
import model.bo.CapDoBO;
import model.bo.CauHoiBO;
import model.bo.DeThiBO;

public class ThiAction extends Action{
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		ThiForm thiForm = (ThiForm)form;
		DeThiBO deThiBO =new DeThiBO();
		String maDe=thiForm.getMaDeThi();
		BaiThi baiThi=deThiBO.getDeThi(maDe);
		CauHoiBO cauHoiBO=new CauHoiBO();
		HttpSession session=request.getSession();
		session.setAttribute("maDe", maDe);
		ArrayList<CauHoi> listCauHoi=new ArrayList<CauHoi>();
		ArrayList<CauHoi> listCauHoiRanDom=new ArrayList<CauHoi>();
		String[] maCauHoi=baiThi.getCauHoi().split("@@");
		CauHoi cauHoi;
		for(int i=0;i<maCauHoi.length;i++){
			cauHoi=new CauHoi();
			cauHoi=cauHoiBO.getCauHoi(maCauHoi[i]);
			listCauHoi.add(cauHoi);
		}
		listCauHoiRanDom=Common.randomCauHoi(listCauHoi);
		for(int i=0;i<listCauHoi.size();i++){
			listCauHoi.get(i).setSoThuTu(i+1+"");
		}
		thiForm.setTenDe(baiThi.getTenDe());
		session.setAttribute("listCauHoi", listCauHoiRanDom);
		thiForm.setListCauHoi(listCauHoiRanDom);
		CapDoBO bo=new CapDoBO();
		thiForm.setListCapDo(bo.listCapDo());
		return mapping.findForward("thi_online");
	}
}
