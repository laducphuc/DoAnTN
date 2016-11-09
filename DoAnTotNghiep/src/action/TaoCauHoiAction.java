package action;

import java.io.File;
import java.io.FileOutputStream;
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

import common.Const;
import common.StringProcess;
import form.TaoCauHoiForm;
import model.bean.CapDo;
import model.bean.CauHoi;
import model.bean.PhuongAn;
import model.bo.CapDoBO;
import model.bo.CauHoiBO;
import model.bo.PhuongAnBO;

public class TaoCauHoiAction extends Action {
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		TaoCauHoiForm taoCauHoiForm = (TaoCauHoiForm) form;
		CauHoiBO cauHoiBO = new CauHoiBO();
		CapDoBO capDoBO=new CapDoBO();
		ArrayList<CapDo> listCapDo = capDoBO.listCapDo();
		taoCauHoiForm.setListCapDo(listCapDo);
		ArrayList<FormFile> listFile = new ArrayList<FormFile>();
		ArrayList<Integer> listViTriHA = new ArrayList<Integer>();
		if (taoCauHoiForm.getHinhanhND() != null && !StringProcess.notVaild(taoCauHoiForm.getHinhanhND().toString())) {
			listFile.add(taoCauHoiForm.getHinhanhND());
			listViTriHA.add(0);
		}
		if (taoCauHoiForm.getHinhanhPA1() != null
				&& !StringProcess.notVaild(taoCauHoiForm.getHinhanhPA1().toString())) {
			listFile.add(taoCauHoiForm.getHinhanhPA1());
			listViTriHA.add(1);
		}

		if (taoCauHoiForm.getHinhanhPA2() != null
				&& !StringProcess.notVaild(taoCauHoiForm.getHinhanhPA2().toString())) {
			listFile.add(taoCauHoiForm.getHinhanhPA2());
			listViTriHA.add(2);
		}
		if (taoCauHoiForm.getHinhanhPA3() != null
				&& !StringProcess.notVaild(taoCauHoiForm.getHinhanhPA3().toString())) {
			listFile.add(taoCauHoiForm.getHinhanhPA3());
			listViTriHA.add(3);
		}
		if (taoCauHoiForm.getHinhanhPA4() != null
				&& !StringProcess.notVaild(taoCauHoiForm.getHinhanhPA4().toString())) {
			listFile.add(taoCauHoiForm.getHinhanhPA4());
			listViTriHA.add(4);
		}
		if (taoCauHoiForm.getHinhanhPA5() != null
				&& !StringProcess.notVaild(taoCauHoiForm.getHinhanhPA5().toString())) {
			listFile.add(taoCauHoiForm.getHinhanhPA5());
			listViTriHA.add(5);
		}
		String filePath = Const.PATH+"pictures\\CauHoi";
		Date date =new Date();
		ArrayList<String> listFileName = new ArrayList<String>();
		for (int i = 0; i < listFile.size(); i++) {
			listFileName.add(date.getTime() + i + listFile.get(i).getFileName());
		}

		System.out.println("============= list hinh anh: do dai list filename :" + listFileName.size());
		for (int i = 0; i < listFileName.size(); i++) {
			System.out.println(listFileName.get(i));
		}

		ArrayList<String> listHinhAnh = new ArrayList<String>();

		for (int i = 0; i < listFile.size(); i++) {
			if (listFile.get(i) != null) {
				if (!("").equals(listFileName.get(i))) {
					listHinhAnh.add("images/" + listFileName.get(i) + "." + listViTriHA.get(i));
				}
			}
		}
		if ("Submit".equals(taoCauHoiForm.getBtnSubmit())) {

			ActionErrors actionErrors = new ActionErrors();
			if (StringProcess.notVaild(taoCauHoiForm.getNoiDung())) {
				actionErrors.add("saiNoiDungCH", new ActionMessage("error.noiDungCH"));
			}
			int soPhuongAnChon = Integer.valueOf(taoCauHoiForm.getSoPAChon());
			if (soPhuongAnChon >= 1 && StringProcess.notVaild(taoCauHoiForm.getPhuongAn1())) {
				actionErrors.add("saiPhuongAn1", new ActionMessage("error.phuongAn"));
			}
			if (soPhuongAnChon >= 2 && StringProcess.notVaild(taoCauHoiForm.getPhuongAn2())) {
				actionErrors.add("saiPhuongAn2", new ActionMessage("error.phuongAn"));
			}
			if (soPhuongAnChon >= 3 && StringProcess.notVaild(taoCauHoiForm.getPhuongAn3())) {
				actionErrors.add("saiPhuongAn3", new ActionMessage("error.phuongAn"));
			}
			if (soPhuongAnChon >= 4 && StringProcess.notVaild(taoCauHoiForm.getPhuongAn4())) {
				actionErrors.add("saiPhuongAn4", new ActionMessage("error.phuongAn"));
			}
			if (soPhuongAnChon >= 5 && StringProcess.notVaild(taoCauHoiForm.getPhuongAn5())) {
				actionErrors.add("saiPhuongAn5", new ActionMessage("error.phuongAn"));
			}
			
			// check chon dap an chua
			if (taoCauHoiForm.getDapAn() == null) {
				actionErrors.add("saiDapAn", new ActionMessage("error.dapAn"));
			}
			
			// check sai dinh dang
			for (int i = 0; i < listHinhAnh.size(); i++) {
				System.out.println(listHinhAnh.get(i));
				String[] checkHA = listHinhAnh.get(i).split("\\.");
				int chiso = Integer.valueOf(checkHA[checkHA.length - 1]);
				if (!(checkHA[checkHA.length - 2].equals("jpg")) && !(checkHA[checkHA.length - 2].equals("png"))
						&& !(checkHA[checkHA.length - 2].equals("PNG"))) {
					actionErrors.add("saiDinhDangHA" + chiso, new ActionMessage("error.saiDinhDangHA"));
				}
			}

			saveErrors(request, actionErrors);
			if (actionErrors.size() > 0) {
				return mapping.findForward("tao_cau_hoi_nd");

			}
		}
		if ("Submit".equals(taoCauHoiForm.getBtnSubmit())) {

			// save image
			for (int i = 0; i < listFile.size(); i++) {
				if (listFile.get(i) != null) {
					if (!("").equals(listFileName.get(i))) {
						File newFile = new File(filePath, listFileName.get(i));
						if (!newFile.exists()) {
							FileOutputStream fos = new FileOutputStream(newFile);
							fos.write(listFile.get(i).getFileData());
							fos.flush();
							fos.close();
							System.out.println("finish");
						} else {
							System.out.println("trung vi tri thu " + (i));
						}
					}
				}
			}

			// them cau hoi vao db
			CauHoi cauHoi = new CauHoi();
			cauHoi.setNoiDung(taoCauHoiForm.getNoiDung());
			cauHoi.setHinhAnh(taoCauHoiForm.getHinhanhND().toString());
			cauHoi.setMaCapDo(taoCauHoiForm.getMaCapDo());
			if (listHinhAnh.size() >= 1) {
				String[] hACH = listHinhAnh.get(0).split("\\.");
				if (hACH[hACH.length - 1].equals("0")) {
					cauHoi.setHinhAnh(listHinhAnh.get(0).substring(0, listHinhAnh.get(0).length() - 2));
					System.out.println("hinh anh trong cau hoi " + cauHoi.getHinhAnh());
				}
			}
			cauHoiBO.addCauHoi(cauHoi);
			String maCauHoi = cauHoiBO.getKey();
			System.out.println("Ma cau hoi moi" + maCauHoi);
			// them phuong an vao db
			ArrayList<PhuongAn> listPhuongAn = new ArrayList<PhuongAn>();
			PhuongAn phuongAn;
			// phuong an 1
			if (taoCauHoiForm.getPhuongAn1() != null) {
				phuongAn = new PhuongAn();
				phuongAn.setMaCauHoi(maCauHoi);
				phuongAn.setNoiDungPA(taoCauHoiForm.getPhuongAn1());

				if (listHinhAnh.size() >= 1) {
					for (int i = 0; i < listHinhAnh.size(); i++) {
						String[] hinhAnhCH = listHinhAnh.get(i).split("\\.");
						if (hinhAnhCH[hinhAnhCH.length - 1].equals("1")) {
							phuongAn.setHinhAnh(listHinhAnh.get(i).substring(0, listHinhAnh.get(i).length() - 2));
							break;
						}
					}
				}

				for (int i = 0; i < taoCauHoiForm.getDapAn().length; i++) {
					if ("1".equals(taoCauHoiForm.getDapAn()[i])) {
						phuongAn.setTrangThai("1");
						break;
					}
				}
				if (phuongAn.getTrangThai() == null) {
					System.out.println("set trang thai1");
					phuongAn.setTrangThai("0");
				}
				if (phuongAn.getHinhAnh() == null) {
					phuongAn.setHinhAnh("");
				}
				listPhuongAn.add(phuongAn);
			}
			// phuong an 2
			if (taoCauHoiForm.getPhuongAn2() != null) {
				phuongAn = new PhuongAn();
				phuongAn.setMaCauHoi(maCauHoi);
				phuongAn.setNoiDungPA(taoCauHoiForm.getPhuongAn2());

				if (listHinhAnh.size() >= 1) {
					for (int i = 0; i < listHinhAnh.size(); i++) {
						String[] hinhAnhCH = listHinhAnh.get(i).split("\\.");
						if (hinhAnhCH[hinhAnhCH.length - 1].equals("2")) {
							phuongAn.setHinhAnh(listHinhAnh.get(i).substring(0, listHinhAnh.get(i).length() - 2));
							break;
						}
					}
				}
				for (int i = 0; i < taoCauHoiForm.getDapAn().length; i++) {
					if ("2".equals(taoCauHoiForm.getDapAn()[i])) {
						phuongAn.setTrangThai("1");
						break;
					}
				}
				if (phuongAn.getTrangThai() == null) {
					phuongAn.setTrangThai("0");
				}
				if (phuongAn.getHinhAnh() == null) {
					phuongAn.setHinhAnh("");
				}
				listPhuongAn.add(phuongAn);
			}

			// phuong an 3
			if (taoCauHoiForm.getPhuongAn3() != null) { // sua
				phuongAn = new PhuongAn();
				phuongAn.setMaCauHoi(maCauHoi);
				phuongAn.setNoiDungPA(taoCauHoiForm.getPhuongAn3()); // sua
				if (listHinhAnh.size() >= 1) {
					for (int i = 0; i < listHinhAnh.size(); i++) {
						String[] hinhAnhCH = listHinhAnh.get(i).split("\\.");
						if (hinhAnhCH[hinhAnhCH.length - 1].equals("3")) { // sua
							phuongAn.setHinhAnh(listHinhAnh.get(i).substring(0, listHinhAnh.get(i).length() - 2));
							break;
						}
					}
				}

				for (int i = 0; i < taoCauHoiForm.getDapAn().length; i++) {
					if ("3".equals(taoCauHoiForm.getDapAn()[i])) { // sua
						phuongAn.setTrangThai("1");
						break;
					}
				}
				if (phuongAn.getTrangThai() == null) {
					System.out.println("set trang thai2");
					phuongAn.setTrangThai("0");
				}
				if (phuongAn.getHinhAnh() == null) {
					System.out.println("set hinh anh2");
					phuongAn.setHinhAnh("");
				}
				listPhuongAn.add(phuongAn);
			}

			// phuong an 4
			if (taoCauHoiForm.getPhuongAn4() != null) { // sua
				phuongAn = new PhuongAn();
				phuongAn.setMaCauHoi(maCauHoi);
				phuongAn.setNoiDungPA(taoCauHoiForm.getPhuongAn4()); // sua

				if (listHinhAnh.size() >= 1) {
					for (int i = 0; i < listHinhAnh.size(); i++) {
						String[] hinhAnhCH = listHinhAnh.get(i).split("\\.");
						if (hinhAnhCH[hinhAnhCH.length - 1].equals("4")) { // sua
							phuongAn.setHinhAnh(listHinhAnh.get(i).substring(0, listHinhAnh.get(i).length() - 2));
							break;
						}
					}
				}

				for (int i = 0; i < taoCauHoiForm.getDapAn().length; i++) {
					if ("4".equals(taoCauHoiForm.getDapAn()[i])) { // sua
						phuongAn.setTrangThai("1");
						break;
					}
				}
				if (phuongAn.getTrangThai() == null) {
					System.out.println("set trang thai2");
					phuongAn.setTrangThai("0");
				}
				if (phuongAn.getHinhAnh() == null) {
					System.out.println("set hinh anh2");
					phuongAn.setHinhAnh("");
				}
				listPhuongAn.add(phuongAn);
			}

			// phuong an 5
			if (taoCauHoiForm.getPhuongAn5() != null) { // sua
				phuongAn = new PhuongAn();
				phuongAn.setMaCauHoi(maCauHoi);
				phuongAn.setNoiDungPA(taoCauHoiForm.getPhuongAn5()); // sua

				if (listHinhAnh.size() >= 1) {
					for (int i = 0; i < listHinhAnh.size(); i++) {
						String[] hinhAnhCH = listHinhAnh.get(i).split("\\.");
						if (hinhAnhCH[hinhAnhCH.length - 1].equals("5")) { // sua
							phuongAn.setHinhAnh(listHinhAnh.get(i).substring(0, listHinhAnh.get(i).length() - 2));
							break;
						}
					}
				}

				for (int i = 0; i < taoCauHoiForm.getDapAn().length; i++) {
					if ("5".equals(taoCauHoiForm.getDapAn()[i])) { // sua
						phuongAn.setTrangThai("1");
						break;
					}
				}
				if (phuongAn.getTrangThai() == null) {
					System.out.println("set trang thai2");
					phuongAn.setTrangThai("0");
				}
				if (phuongAn.getHinhAnh() == null) {
					System.out.println("set hinh anh2");
					phuongAn.setHinhAnh("");
				}
				listPhuongAn.add(phuongAn);
			}

			PhuongAnBO phuongAnBO=new PhuongAnBO();
			phuongAnBO.addListPhuongAn(listPhuongAn);
			System.out.println("them thanh cong");
			return mapping.findForward("themOK");
		} else {
			return mapping.findForward("tao_cau_hoi_nd");
		}
	}
}
