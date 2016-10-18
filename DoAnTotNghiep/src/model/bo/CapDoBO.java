package model.bo;

import java.util.ArrayList;

import model.bean.CapDo;
import model.dao.CapDoDAO;

public class CapDoBO {
	CapDoDAO capDoDAO = new CapDoDAO();

	/**
	 * get Cấp độ theo mã cấp độ
	 * 
	 * @param maCapDo
	 * @return Cấp Độ
	 */
	public String getTenCDByPK(String maCapDo) {
		String capdo = "DANH SÁCH CÁC BÀI HỌC TRONG ";
		capdo += capDoDAO.getTenCDByPK(maCapDo);
		return capdo;
	}

	/**
	 * danh sách cấp độ
	 * 
	 * @return
	 */
	public ArrayList<CapDo> listCapDo() {
		return capDoDAO.listCapDo();
	}
}
