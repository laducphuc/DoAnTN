package model.bo;

import java.util.ArrayList;

import model.bean.CauHoi;
import model.dao.CauHoiDAO;

public class CauHoiBO {
	CauHoiDAO cauHoiDAO = new CauHoiDAO();

	/**
	 * lay toan bo danh sach cau hoi
	 * 
	 * @return
	 */
	public ArrayList<CauHoi> listCauHoi() {
		return cauHoiDAO.listCauHoi();
	}

	/**
	 * lay danh sach cau hoi theo ma cap do
	 * 
	 * @param maCapDo
	 * @return
	 */
	public ArrayList<CauHoi> listCauHoi(String maCapDo) {
		return cauHoiDAO.listCauHoi(maCapDo);
	}

	/**
	 * lay cau hoi theo ma cau hoi
	 * 
	 * @param maCauHoi
	 * @return
	 */
	public CauHoi getCauHoi(String maCauHoi) {
		return cauHoiDAO.getCauHoi(maCauHoi);
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
}
