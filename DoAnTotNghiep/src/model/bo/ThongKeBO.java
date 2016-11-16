package model.bo;

import java.util.ArrayList;

import model.bean.BaiViet;
import model.bean.ThanhVien;
import model.dao.ThongKeDAO;

public class ThongKeBO {
	/**
	 * Hàm lấy danh sách bảng xếp hạng thành viên
	 * 
	 * @return Danh sách thành viên
	 */
	public ArrayList<ThanhVien> bangXepHangThanhVien() {
		return new ThongKeDAO().bangXepHangThanhVien();
	}

	/**
	 * Hàm lấy danh sách bảng xếp hạng cộng tác viên
	 * 
	 * @return Danh sách thành viên
	 */

	public ArrayList<ThanhVien> bangXepHangCongTacVien() {
		return new ThongKeDAO().bangXepHangCongTacVien();
	}

	/**
	 * Hàm lấy danh sách bảng xếp hạng bài viết được xem nhiều nhât
	 * 
	 * @return Danh sách thành viên
	 */
	public ArrayList<BaiViet> bangXepHangBaiViet() {
		return new ThongKeDAO().bangXepHangBaiViet();
	}

	public ThanhVien thanhVienNew() {
		return new ThongKeDAO().thanhVienNew();
	}
	public String soThanhVien() {
		return new ThongKeDAO().soThanhVien();
	}
}
