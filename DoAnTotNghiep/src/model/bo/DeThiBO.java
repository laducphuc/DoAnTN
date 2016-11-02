package model.bo;

import java.util.ArrayList;

import model.bean.BaiThi;
import model.dao.DeThiDAO;

public class DeThiBO {
	DeThiDAO deThiDAO = new DeThiDAO();

	/**
	 * get all de thi
	 * 
	 * @return danh sach de thi
	 */
	public ArrayList<BaiThi> listDeThi() {
		return deThiDAO.listDeThi();
	}

	/**
	 * get list de thi theo ten de
	 * 
	 * @param search
	 * @return
	 */
	public ArrayList<BaiThi> listDeThiByName(String search) {
		return deThiDAO.listDeThiByName(search);
	}

	/**
	 * get de thi theo ma de
	 * 
	 * @param maDe
	 * @return
	 */
	public BaiThi getDeThi(String maDe) {
		return deThiDAO.getDeThi(maDe);
	}

	/**
	 * search theo ten va cap do
	 * 
	 * @param search
	 * @param maCapDo
	 * @return
	 */
	public ArrayList<BaiThi> listDeThiByNamePK(String search, String maCapDo) {
		return deThiDAO.listDeThiByNamePK(search, maCapDo);
	}

	/**
	 * list de thi theo cap do
	 * 
	 * @param maCapDo
	 * @return
	 */
	public ArrayList<BaiThi> listDeThiByCapDo(String maCapDo) {
		return deThiDAO.listDeThiByCapDo(maCapDo);
	}

	/**
	 * them moi de thi
	 * 
	 * @param baiThi
	 * @return
	 */
	public boolean themDeThi(BaiThi baiThi) {
		return deThiDAO.themDeThi(baiThi);
	}

	/**
	 * xóa de thi
	 */
	public boolean xoaDeThi(String maDe) {
		return deThiDAO.xoaDeThi(maDe);
	}

	/**
	 * sua de thi
	 */
	public boolean updateDeThi(BaiThi baiThi) {
		return deThiDAO.updateDeThi(baiThi);
	}
}
