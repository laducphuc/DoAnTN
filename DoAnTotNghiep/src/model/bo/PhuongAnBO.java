package model.bo;

import java.util.ArrayList;

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
}
