package model.bo;

import java.util.ArrayList;

import common.Common;
import model.bean.PhuongAn;
import model.dao.PhuongAnDAO;

public class PhuongAnBO {

	PhuongAnDAO phuongAnDAO = new PhuongAnDAO();

	/**
	 * them phoung an vao DB
	 * 
	 * @param listPhuongAn
	 * @return
	 */
	public boolean addListPhuongAn(ArrayList<PhuongAn> listPhuongAn) {
		return phuongAnDAO.addListPhuongAn(listPhuongAn);
	}

	public ArrayList<PhuongAn> getPhuongAn(String maCauHoi) {
		ArrayList<PhuongAn> listPA = Common.randomPhuongAn(phuongAnDAO.getPhuongAn(maCauHoi));
		for (int i = 0; i < listPA.size(); i++) {
			listPA.get(i).setSoThuTuPA(i + 1 + "");
		}
		return listPA;
	}
}
