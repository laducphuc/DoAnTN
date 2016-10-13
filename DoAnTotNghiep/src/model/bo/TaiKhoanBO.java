package model.bo;

import model.dao.TaiKhoanDAO;

public class TaiKhoanBO {
	/**
	 * Thay đổi mật khẩu của tài khoản 
	 * @param maTaiKhoan
	 * @param matKhauMoi
	 * @return 
	 */
	public boolean doiMatKhau(String maTaiKhoan, String matKhauMoi){
		return new TaiKhoanDAO().doiMatKhau(maTaiKhoan, matKhauMoi);
	}
}
