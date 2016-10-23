package action;

import java.util.ArrayList;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.upload.FormFile;

import common.Const;
import common.FileManage;
import common.StringProcess;
import form.ThemBaiHocForm;
import model.bean.BaiHoc;
import model.bean.TuVung;
import model.bo.BaiHocBO;
import model.bo.CapDoBO;
import model.bo.TuVungBO;

public class SuaBaiHocAction extends Action {

	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");
		ThemBaiHocForm baiHocForm = (ThemBaiHocForm) form;
		CapDoBO capDoBO = new CapDoBO();
		TuVungBO tuVungBO = new TuVungBO();
		BaiHocBO baiHocBO=new BaiHocBO();
		String maBaiHoc=baiHocForm.getMaBaiHoc();
		BaiHoc baihoc=baiHocBO.getBaiHoc(maBaiHoc);
		baiHocForm.setTongTuVung(tuVungBO.getAll().size());
		HttpSession session = request.getSession();
		baiHocForm.setListCapDo(capDoBO.listCapDo());
		ArrayList<TuVung> listTuVung = new ArrayList<TuVung>();
		listTuVung = (ArrayList<TuVung>) session.getAttribute("sessionTuVung");
		FormFile file;
		if ("Submit".equals(baiHocForm.getSubmit())) {
			baiHocForm.setListTuVung(listTuVung);
			ActionErrors actionErrors = new ActionErrors();
			if (StringProcess.notVaild(baiHocForm.getMaCapDo())) {
				actionErrors.add("capDoError", new ActionMessage("error.tv.muctutrong"));
			}
			if (StringProcess.notVaild(baiHocForm.getTenBaiHoc())) {
				actionErrors.add("tenBaiHocError", new ActionMessage("error.tv.tentrong"));
			}
			if (listTuVung == null) {
				actionErrors.add("tuVungError", new ActionMessage("error.tv.tuvungtrong"));
			}
			if (StringProcess.notVaild(baiHocForm.getNguPhap())) {
				actionErrors.add("nguPhapError", new ActionMessage("error.tv.nguphaptrong"));
			}
			if (StringProcess.notVaild(baiHocForm.getSound().toString())) {
				actionErrors.add("amthanhError", new ActionMessage("error.tv.amthanhtrong"));
			}
			if (StringProcess.notVaild(baiHocForm.getNghe())) {
				actionErrors.add("ngheError", new ActionMessage("error.tv.nghetrong"));
			}
			saveErrors(request, actionErrors);
			if (actionErrors.size() > 0) {
				return mapping.findForward("themError");
			}
		}
		if ("Submit".equals(baiHocForm.getSubmit())) {
			baiHocForm.setListTuVung(listTuVung);
			file = baiHocForm.getSound();
			Date date =new Date();
			String fileName = date.getTime()+file.getFileName();
			String filePath = Const.PATH + "Sound\\NguPhap";
			BaiHoc baiHoc=new BaiHoc();
			String tuVung="";
			for(int i=0;i<listTuVung.size();i++){
				tuVung+=listTuVung.get(i).getMaTuVung()+"@";
			}
			if (FileManage.saveFile(file, fileName, filePath)) {
				baiHoc.setMaCapDo(baiHocForm.getMaCapDo());
				baiHoc.setNghe(baiHocForm.getNghe());
				baiHoc.setNguPhap(baiHocForm.getNguPhap());
				baiHoc.setSound(fileName);
				baiHoc.setTenBaiHoc(baiHocForm.getTenBaiHoc());
				baiHoc.setTuVung(tuVung);
				baiHoc.setMaBaiHoc(baihoc.getMaBaiHoc());
				baiHocBO.updateBaiHoc(baiHoc);
				return mapping.findForward("themOK");
			} else {
				return mapping.findForward("themError");
			}
		}else{
			baiHocForm.setTenBaiHoc(baihoc.getTenBaiHoc());
			baiHocForm.setMaCapDo(baihoc.getMaCapDo());
			baiHocForm.setNghe(baihoc.getNghe());
			baiHocForm.setNguPhap(baihoc.getNguPhap());
			String [] tuVung=baihoc.getTuVung().split("@");
			ArrayList<TuVung> list =new ArrayList<TuVung>();
			for(int i=0;i<tuVung.length;i++){
				list.add(tuVungBO.getByPK(tuVung[i]));
			}
			baiHocForm.setListTuVung(list);
			return mapping.findForward("themBaiHoc");
		}
		

	}

}
