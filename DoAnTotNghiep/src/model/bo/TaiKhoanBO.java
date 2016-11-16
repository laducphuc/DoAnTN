package model.bo;

import common.Const;
import common.EnDeCryption;
import model.dao.TaiKhoanDAO;

public class TaiKhoanBO {
	/**
	 * Thay đổi mật khẩu của tài khoản
	 * 
	 * @param maTaiKhoan
	 * @param matKhauMoi
	 * @return
	 */
	public boolean doiMatKhau(String maTaiKhoan, String matKhauMoi) {
		EnDeCryption enDeCryption = new EnDeCryption(Const.PATH);
		String matKhau = enDeCryption.encoding(matKhauMoi);
		return new TaiKhoanDAO().doiMatKhau(maTaiKhoan, matKhau);
	}
}
