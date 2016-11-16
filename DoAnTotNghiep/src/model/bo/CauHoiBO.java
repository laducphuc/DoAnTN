package model.bo;

import java.util.ArrayList;

import model.bean.CauHoi;
import model.dao.CauHoiDAO;

public class CauHoiBO {
	CauHoiDAO cauHoiDAO = new CauHoiDAO();
	PhuongAnBO phuongAnBo = new PhuongAnBO();

	/**
	 * lay toan bo danh sach cau hoi
	 * 
	 * @return
	 */
	public ArrayList<CauHoi> listCauHoi() {
		ArrayList<CauHoi> listCauHoi = cauHoiDAO.listCauHoi();

		for (int i = 0; i < listCauHoi.size(); i++) {
			String maCauHoi = listCauHoi.get(i).getMaCauHoi();
			listCauHoi.get(i).setListPhuongAn(phuongAnBo.getPhuongAn(maCauHoi));
		}
		return listCauHoi;
	}

	/**
	 * lay danh sach cau hoi theo ma cap do
	 * 
	 * @param maCapDo
	 * @return
	 */
	public ArrayList<CauHoi> listCauHoi(String maCapDo) {
		ArrayList<CauHoi> listCauHoi = cauHoiDAO.listCauHoi(maCapDo);
		for (int i = 0; i < listCauHoi.size(); i++) {
			String maCauHoi = listCauHoi.get(i).getMaCauHoi();
			listCauHoi.get(i).setListPhuongAn(phuongAnBo.getPhuongAn(maCauHoi));
		}
		return listCauHoi;
	}

	/**
	 * lay cau hoi theo ma cau hoi
	 * 
	 * @param maCauHoi
	 * @return
	 */
	public CauHoi getCauHoi(String maCauHoi) {
		CauHoi cauHoi = cauHoiDAO.getCauHoi(maCauHoi);
		cauHoi.setListPhuongAn(phuongAnBo.getPhuongAn(maCauHoi));
		return cauHoi;
	}

	/**
	 * insert cau hoi vao database
	 * 
	 * @param cauHoi
	 * @return
	 */
	public boolean addCauHoi(CauHoi cauHoi) {
		return cauHoiDAO.addCauHoi(cauHoi);
	}

	/**
	 * get key moi insert vao db
	 * 
	 * @return
	 */
	public String getKey() {
		return cauHoiDAO.getKey();
	}

	/**
	 * xoa cau hoi
	 */
	public boolean xoaCauHoi(String maCauHoi) {
		if (cauHoiDAO.xoaPhuongAn(maCauHoi)) {
			return cauHoiDAO.xoaCauHoi(maCauHoi);
		} else {
			return false;
		}
	}
}
