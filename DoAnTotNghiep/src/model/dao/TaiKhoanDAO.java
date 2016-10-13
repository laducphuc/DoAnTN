package model.dao;

import java.sql.SQLException;

public class TaiKhoanDAO extends ConnectDAO{
	/**
	 * Thay đổi mật khẩu của tài khoản 
	 * @param maTaiKhoan
	 * @param matKhauMoi
	 * @return 
	 */
	public boolean doiMatKhau(String maTaiKhoan, String matKhauMoi){
		
		try {
			openConnection();
			final String SQL = String.format("UPDATE TAIKHOAN SET MatKhau = '%s' WHERE MaTaiKhoan = '%s'", matKhauMoi, maTaiKhoan);
			getStatement().executeUpdate(SQL);
			return true;
		} catch (SQLException e) {
			return false;
		} finally {
			closeConnection();
		}
	}

}
