package model.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

public class DanhGiaDAO extends ConnectDAO{
	
	/**
	 * Xóa mã bài viết trong bảng DANHGIA
	 * @param maBaiViet
	 * @return
	 */
	public boolean xoaBaiViet(String maBaiViet){
		
		try {
			final String SQL = "DELETE DANHGIA WHERE MaBaiViet = '" + maBaiViet + "'";
			openConnection();
			getStatement().executeUpdate(SQL);
			return true;
		} catch (SQLException e) {
			return false;
		} finally {
			closeConnection();
		}
	}
	
	/**
	 * Kiểm tra xem thành viên đã thích bài viết chưa?
	 * 
	 * @param maThanhVien
	 * @param maBaiViet
	 * @return
	 */
	public boolean kiemTraThichBaiViet(String maThanhVien, String maBaiViet){
		
		try {
			openConnection();
			final String SQL = String.format("SELECT MaThanhVien "
					+ " FROM DANHGIA"
					+ " WHERE MaThanhVien = '%s' AND MaBaiViet = '%s' AND Thich = 'True'", maThanhVien, maBaiViet);
			ResultSet rs = getStatement().executeQuery(SQL);
			while (rs.next()) {
				return true;
			}
			return false; 
		} catch (SQLException e) {
			return false;
		} finally {
			closeConnection();
		}
		
	}
	
	
	/**
	 * Thích bài viết
	 * 
	 * @param maThanhVien
	 * @param maBaiViet
	 * @return
	 */
	public boolean thichBaiViet(String maThanhVien, String maBaiViet){
		openConnection();
		boolean kiemTraLoi = false;
		boolean isReturn = true;
		try {
			final String INSERT = String.format("INSERT INTO DANHGIA (MaThanhVien, MaBaiViet, Thich)"
					+ " VALUES ('%s', '%s', 'True')", maThanhVien, maBaiViet);
			getStatement().executeUpdate(INSERT);
		} catch (SQLException e) {
			kiemTraLoi = true;
		}
		
		if (kiemTraLoi){
			try {
				final String SQL = String.format("UPDATE DANHGIA SET Thich = 'True'"
						+ " WHERE MaThanhVien = '%s' AND MaBaiViet = '%s'", maThanhVien, maBaiViet);
				getStatement().executeUpdate(SQL);
			} catch (SQLException e) {
				isReturn = false;
			} 
		}
		closeConnection();
		return isReturn;
		
	}
	
	/**
	 * Xóa thích của thành viên với bài viết
	 * 
	 * @param maThanhVien
	 * @param maBaiViet
	 * @return
	 */
	public boolean xoaThichBaiViet(String maThanhVien, String maBaiViet){
		
		try {
			openConnection();
			final String SQL = String.format("UPDATE DANHGIA SET Thich = 'False'"
					+ " WHERE MaThanhVien = '%s' AND MaBaiViet = '%s'", maThanhVien, maBaiViet);
			getStatement().executeUpdate(SQL);
			return true; 
		} catch (SQLException e) {
			return false;
		} finally {
			closeConnection();
		}
	}
	
	/**
	 * Đánh giá bài viết 
	 * 
	 * @param maThanhVien
	 * @param maBaiViet
	 * @return
	 */
	public boolean danhGiaBaiViet(String maThanhVien, String maBaiViet, int soSao){
		openConnection();
		boolean kiemTraLoi = false;
		boolean isReturn = true;
		try {
			final String INSERT = String.format("INSERT INTO DANHGIA (MaThanhVien, MaBaiViet, SoSao, Thich)"
					+ " VALUES ('%s', '%s', %s,'False')", maThanhVien, maBaiViet, soSao);
			getStatement().executeUpdate(INSERT);
		} catch (SQLException e) {
			kiemTraLoi = true;
		}
		
		if (kiemTraLoi){
			try {
				final String SQL = String.format("UPDATE DANHGIA SET SoSao = %s"
						+ " WHERE MaThanhVien = '%s' AND MaBaiViet = '%s'", soSao, maThanhVien, maBaiViet);
				getStatement().executeUpdate(SQL);
			} catch (SQLException e) {
				isReturn = false;
			} 
		}
		closeConnection();
		return isReturn;
	}
}
