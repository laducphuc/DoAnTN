package action;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
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

import common.Common;
import common.Const;
import form.TaoCauHoiForm;
import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;
import model.bean.CauHoi;
import model.bean.PhuongAn;
import model.bo.CauHoiBO;
import model.bo.PhuongAnBO;

public class TaoCauHoiFileAction extends Action {
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		TaoCauHoiForm taoCauHoiForm = (TaoCauHoiForm) form;
		CauHoiBO cauHoiBO = new CauHoiBO();
		if ("Submit".equals(taoCauHoiForm.getBtnSubmit())) {

			ActionErrors actionErrors = new ActionErrors();
			if (taoCauHoiForm.getFileInput().toString() == null) {
				actionErrors.add("saiFile", new ActionMessage("error.fileRong"));
			}
			saveErrors(request, actionErrors);
			if (actionErrors.size() > 0) {
				return mapping.findForward("tao_cau_hoi_nd");

			}
		}
		if ("Submit".equals(taoCauHoiForm.getBtnSubmit())) {
			FormFile fileData = taoCauHoiForm.getFileInput();
			Date date = new Date();
			String fileName = date.getTime() + fileData.getFileName();
			String filePath = Const.PATH + "\\data";
			if (Common.saveFile(fileData, fileName, filePath)) {
				Workbook workbook;
				try {
					// create workbook to open file
					workbook = Workbook.getWorkbook(new File(filePath + "\\" + fileName));
					// get sheet want read
					Sheet sheet = workbook.getSheet(0);
					// get number row and col contain data
					int rows = sheet.getRows();
					int cols = sheet.getColumns();

					System.out.println("Data in file:");
					// read data in each cell
					Cell cell = sheet.getCell(0, 0);
					String maCapDo = cell.getContents();
					CauHoi cauHoi;
					PhuongAnBO phuongAnBO = new PhuongAnBO();
					ArrayList<PhuongAn> listPhuongAn;
					for (int row = 1; row < rows; row++) {
						cauHoi = new CauHoi();
						listPhuongAn = new ArrayList<PhuongAn>();
						Cell cell1 = sheet.getCell(0, row);
						cauHoi.setMaCapDo(maCapDo);
						cauHoi.setNoiDung(cell1.getContents());
						cauHoiBO.addCauHoi(cauHoi);
						String maCauHoi = cauHoiBO.getKey();
						PhuongAn phuongAn;
						for (cols = 1; cols < 5; cols++) {
							phuongAn = new PhuongAn();
							Cell cell2 = sheet.getCell(cols, row);
							phuongAn.setMaCauHoi(maCauHoi);
							phuongAn.setNoiDungPA(cell2.getContents());
							phuongAn.setTrangThai("0");
							phuongAn.setHinhAnh("");
							listPhuongAn.add(phuongAn);
						}
						listPhuongAn.get(0).setTrangThai("1");
						phuongAnBO.addListPhuongAn(listPhuongAn);

					}
					// close
					workbook.close();
					return mapping.findForward("themOK");
				} catch (BiffException e) {
					ActionErrors actionErrors = new ActionErrors();
					actionErrors.add("saiFile", new ActionMessage("error.filesai"));
					saveErrors(request, actionErrors);
					System.out.println("File not found\n" + e.toString());
					return mapping.findForward("tao_cau_hoi_nd");
				} catch (IOException e) {
					System.out.println("File not found\n" + e.toString());
					ActionErrors actionErrors = new ActionErrors();
					actionErrors.add("saiFile", new ActionMessage("error.filenotfound"));
					saveErrors(request, actionErrors);
					return mapping.findForward("tao_cau_hoi_nd");
				}
			} else {
				return mapping.findForward("tao_cau_hoi_nd");
			}
		} else {
			return mapping.findForward("tao_cau_hoi_nd");
		}
	}
}
