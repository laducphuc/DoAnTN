package model.bo;

import model.dao.CapDoDAO;

public class CapDoBO {
	CapDoDAO capDoDAO = new CapDoDAO();

	public String getTenCDByPK(String maCapDo) {
		String capdo = "DANH SÁCH CÁC BÀI HỌC TRONG ";
		capdo += capDoDAO.getTenCDByPK(maCapDo);
		return capdo;
	}
}
