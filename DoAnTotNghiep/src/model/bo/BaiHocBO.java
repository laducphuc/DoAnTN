package model.bo;

import java.util.ArrayList;

import model.bean.BaiHoc;
import model.dao.BaiHocDAO;

public class BaiHocBO {
	BaiHocDAO baiHocDAO = new BaiHocDAO();

	/**
	 * lấy toàn bộ danh sách bài học
	 * 
	 * @return list bài học
	 */
	public ArrayList<BaiHoc> listBaiHoc() {
		return baiHocDAO.listBaiHoc();
	}

	/**
	 * lấy danh sách bài học theo mã cấp độ
	 * 
	 * @param maCapDo
	 * @return list bài học
	 */
	public ArrayList<BaiHoc> listBaiHocByCapDo(String maCapDo) {
		return baiHocDAO.listBaiHocByCapDo(maCapDo);
	}

	/**
	 * thêm mới bài học
	 * 
	 * @param baiHoc
	 * @return Boolean
	 */
	public boolean themBaiHoc(BaiHoc baiHoc) {
		return baiHocDAO.themBaiHoc(baiHoc);
	}

	/**
	 * tim kiem theo ten
	 * 
	 * @param search
	 * @return
	 */
	public ArrayList<BaiHoc> listBaiHocByName(String search) {
		return baiHocDAO.listBaiHocByName(search);
	}

	/**
	 * get danh sách câu hỏi theo từ khóa và mã cấp độ
	 * 
	 * @param search
	 * @param maCapDo
	 * @return
	 */
	public ArrayList<BaiHoc> listBaiHocByNamePK(String search, String maCapDo) {
		return baiHocDAO.listBaiHocByNamePK(search, maCapDo);
	}

	/**
	 * xóa bài học
	 */
	public boolean xoaBaiHoc(String maBaiHoc) {
		return baiHocDAO.xoaBaiHoc(maBaiHoc);
	}

	/**
	 * get bài học by mã bài học
	 * 
	 * @param maBaiHoc
	 * @return
	 */
	public BaiHoc getBaiHoc(String maBaiHoc) {
		return baiHocDAO.getBaiHoc(maBaiHoc);
	}

	/**
	 * sua bai hoc
	 */
	public boolean updateBaiHoc(BaiHoc baiHoc) {
		return baiHocDAO.updateBaiHoc(baiHoc);
	}
}
