package action;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
import form.TuVungForm;
import model.bean.TuVung;
import model.bo.TuVungBO;

public class TuVungAction extends Action {
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");
		TuVungBO tuVungBO = new TuVungBO();
		TuVungForm tuVungForm = (TuVungForm) form;
		TuVung tuVung = new TuVung();
		FormFile file;
		if ("Submit".equals(tuVungForm.getSubmit())) {
			ActionErrors actionErrors = new ActionErrors();

			if (StringProcess.notVaild(tuVungForm.getMucTu())) {
				actionErrors.add("mucTuError", new ActionMessage("error.tv.muctutrong"));
			}
			if (StringProcess.notVaild(tuVungForm.getDichNghia())) {
				actionErrors.add("dichNghiaError", new ActionMessage("error.tv.dichnghiatrong"));
			}
			if (tuVungForm.getAmThanh() == null || StringProcess.notVaild(tuVungForm.getAmThanh().toString())) {
				actionErrors.add("amthanhError", new ActionMessage("error.tv.amthanhtrong"));
			}
			saveErrors(request, actionErrors);
			if (actionErrors.size() > 0) {
				return mapping.findForward("themTVerror");
			}
		}
		if ("Submit".equals(tuVungForm.getSubmit())) {

			file = tuVungForm.getAmThanh();
			Date date =new Date();
			String fileName = date.getTime()+file.getFileName();
			String filePath = Const.PATH + "Sound\\TuVung";
			System.out.println(fileName);
			if (FileManage.saveFile(file, fileName, filePath)) {
				tuVung.setMucTu(tuVungForm.getMucTu());
				tuVung.setDichNghia(tuVungForm.getDichNghia());
				tuVung.setAmThanh(fileName);
				tuVungBO.addTuVung(tuVung);
				return mapping.findForward("themOK");
			} else {
				return mapping.findForward("themTVerror");
			}
		} else {
			return mapping.findForward("themTuVung");
		}

	}
}
