package model.bo;

import model.dao.DanhGiaDAO;

public class DanhGiaBO {
	
	/**
	 * Xóa mã bài viết trong bảng DANHGIA
	 * @param maBaiViet
	 * @return
	 */
	public boolean xoaBaiViet(String maBaiViet){
		return new DanhGiaDAO().xoaBaiViet(maBaiViet);
	}
	
	/**
	 * Kiểm tra xem thành viên đã thích bài viết chưa?
	 * 
	 * @param maThanhVien
	 * @param maBaiViet
	 * @return
	 */
	public boolean kiemTraThichBaiViet(String maThanhVien, String maBaiViet){
		return new DanhGiaDAO().kiemTraThichBaiViet(maThanhVien, maBaiViet);
	}
	
	/**
	 * Xóa thích của thành viên với bài viết
	 * 
	 * @param maThanhVien
	 * @param maBaiViet
	 * @return
	 */
	public boolean xoaThichBaiViet(String maThanhVien, String maBaiViet){
		return new DanhGiaDAO().xoaThichBaiViet(maThanhVien, maBaiViet);
	}
	
	/**
	 * Thích bài viết
	 * 
	 * @param maThanhVien
	 * @param maBaiViet
	 * @return
	 */
	public boolean thichBaiViet(String maThanhVien, String maBaiViet){
		return new DanhGiaDAO().thichBaiViet(maThanhVien, maBaiViet);
	}
	
	/**
	 * Đánh giá bài viết 
	 * 
	 * @param maThanhVien
	 * @param maBaiViet
	 * @return
	 */
	public boolean danhGiaBaiViet(String maThanhVien, String maBaiViet, int soSao){
		return new DanhGiaDAO().danhGiaBaiViet(maThanhVien, maBaiViet, soSao);
	}
}
