/**
 * 
 */
package action;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import form.ThiForm;
import model.bean.CauHoi;
import model.bean.PhuongAn;
import model.bo.DeThiBO;

public class KetQuaThiAction extends Action {

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		ThiForm thiForm = (ThiForm) form;
		DeThiBO deThiBO=new DeThiBO();
		System.out.println(thiForm.getBtnSubmit());
		if ("Về trang chủ".equals(thiForm.getBtnSubmit())) {
			return mapping.findForward("ve_trang_chu");
		}

		HttpSession session = request.getSession();
		thiForm.setListCauHoi((ArrayList<CauHoi>) session.getAttribute("listCauHoi"));
		ArrayList<CauHoi> listCauHoi = (ArrayList<CauHoi>) session.getAttribute("listCauHoi");
		String maDe = (String) session.getAttribute("maDe");
		thiForm.setTenDe(deThiBO.getDeThi(maDe).getTenDe());
		String[] ketQuaThi = thiForm.getChonPhuongAn();
		int diemSo = 0;
		int soThuTuCH = 0;
		int soThuTuPA = 0;

		// System.out.println(ketQuaThi.length);
		if (ketQuaThi != null) {

			System.out.println("start===============checkbox");

			for (int i = 0; i < ketQuaThi.length; i++) {
				String[] ketQuaThi1 = ketQuaThi[i].split("-");
				soThuTuCH = Integer.valueOf(ketQuaThi1[0]);
				soThuTuPA = Integer.valueOf(ketQuaThi1[1]);

				System.out.println(listCauHoi.get(soThuTuCH - 1).getNoiDung());
				ArrayList<PhuongAn> listPhuongAn = listCauHoi.get(soThuTuCH - 1).getListPhuongAn();
				listPhuongAn.get(soThuTuPA - 1).setCoChon("1");
				// System.out.println(listPhuongAn.get(soThuTuPA-1).getNoiDungPA()+"
				// "+listPhuongAn.get(soThuTuPA-1).isCoChon());
				for (int j = 0; j < listPhuongAn.size(); j++) {
					System.out.println(listPhuongAn.get(j).getNoiDungPA() + " " + listPhuongAn.get(j).getCoChon());
				}
			}
			System.out.println("stop====================");
		} else {
			System.out.println("chua chon");
		}

		String[] arrChonPhuongAn = new String[10];
		arrChonPhuongAn[0] = thiForm.getChonPhuongAn1();
		arrChonPhuongAn[1] = thiForm.getChonPhuongAn2();
		arrChonPhuongAn[2] = thiForm.getChonPhuongAn3();
		arrChonPhuongAn[3] = thiForm.getChonPhuongAn4();
		arrChonPhuongAn[4] = thiForm.getChonPhuongAn5();
		arrChonPhuongAn[5] = thiForm.getChonPhuongAn6();
		arrChonPhuongAn[6] = thiForm.getChonPhuongAn7();
		arrChonPhuongAn[7] = thiForm.getChonPhuongAn8();
		arrChonPhuongAn[8] = thiForm.getChonPhuongAn9();
		arrChonPhuongAn[9] = thiForm.getChonPhuongAn10();
		System.out.println("ket qua chon==========================");
		for (int i = 0; i < arrChonPhuongAn.length; i++) {
			if (arrChonPhuongAn != null) {
				System.out.println(arrChonPhuongAn[i]);
			}
		}
		System.out.println("radio=============");
		// lay string[] chonPhuongAn
		for (int i = 0; i < arrChonPhuongAn.length; i++) {
			if (arrChonPhuongAn[i] != null) {
				String[] ketQuaThi1 = arrChonPhuongAn[i].split("-");
				soThuTuCH = Integer.valueOf(ketQuaThi1[0]);
				soThuTuPA = Integer.valueOf(ketQuaThi1[1]);
				System.out.println(listCauHoi.get(soThuTuCH - 1).getNoiDung());
				ArrayList<PhuongAn> listPhuongAn = listCauHoi.get(soThuTuCH - 1).getListPhuongAn();
				listPhuongAn.get(soThuTuPA - 1).setCoChon("1");
				// System.out.println(listPhuongAn.get(soThuTuPA-1).getNoiDungPA()+"
				// "+listPhuongAn.get(soThuTuPA-1).isCoChon());
				for (int j = 0; j < listPhuongAn.size(); j++) {
					System.out.println(listPhuongAn.get(j).getNoiDungPA() + " " + listPhuongAn.get(j).getCoChon());
				}
			}
		}

		// ======================cham diem
		System.out.println("//======================gan gia tri");
		boolean flag;
		for (int i = 0; i < listCauHoi.size(); i++) {
			ArrayList<PhuongAn> listPhuongAn = listCauHoi.get(i).getListPhuongAn();
			for (int j = 0; j < listPhuongAn.size(); j++) {
				System.out.println(listPhuongAn.get(j).getNoiDungPA() + " " + listPhuongAn.get(j).getCoChon());
				if (listPhuongAn.get(j).getCoChon() == null) {
					listPhuongAn.get(j).setCoChon("0");
				}
				System.out.println(
						"sau khi set " + listPhuongAn.get(j).getNoiDungPA() + " " + listPhuongAn.get(j).getCoChon());
			}
		}
		System.out.println("//======================cham diem");
		for (int i = 0; i < listCauHoi.size(); i++) {
			System.out.println("Diem so " + diemSo);
			flag = true;
			ArrayList<PhuongAn> listPhuongAn = listCauHoi.get(i).getListPhuongAn();
			for (int j = 0; j < listPhuongAn.size(); j++) {
				System.out.println(listPhuongAn.get(j).getCoChon() + " so sanh " + listPhuongAn.get(j).getTrangThai());
				if (!(listPhuongAn.get(j).getCoChon().equals(listPhuongAn.get(j).getTrangThai()))) {
					System.out.println("sai cau " + (i + 1));
					flag = false;
					break;
				}
			}
			if (flag) {
				System.out.println("dung cau " + (i + 1));
				diemSo++;
			}
		}

		thiForm.setDiemThi(diemSo);

		// insert vao bang lich su

		// lay ten tai khoan
		/*
		 * String tenTaiKhoan=(String)session.getAttribute("user");
		 * if(tenTaiKhoan==null){ return mapping.findForward("loi"); }
		 */
		return mapping.findForward("ket_qua_thi");
	}
}
