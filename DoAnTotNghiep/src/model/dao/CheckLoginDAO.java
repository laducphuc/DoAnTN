package model.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import model.bean.TaiKhoan;

public class CheckLoginDAO extends ConnectDAO{
	public TaiKhoan checkLogin(String tenTaiKhoan, String matKhau){
		
		try {
			openConnection();
			String sql=	String.format("SELECT MaTaiKhoan, TenTaiKhoan, MatKhau, TV.MaThanhVien,"
					+ " TenThanhVien, ChucVu, TrangThai, SoNgayKhoa, NgayBatDauKhoa, Anh"
					+ " FROM TAIKHOAN TK JOIN THANHVIEN TV ON TK.MaThanhVien = TV.MaThanhVien"
					+ " WHERE TenTaiKhoan = '%s' AND MatKhau = '%s'", tenTaiKhoan, matKhau);
			TaiKhoan taiKhoan = new TaiKhoan();
			ResultSet rs = getStatement().executeQuery(sql);
			while(rs.next()){
				taiKhoan.setMaTaiKhoan(rs.getString(1));
				taiKhoan.setTenTaiKhoan(rs.getString(2));
				taiKhoan.setMatKhau(rs.getString(3));
				taiKhoan.setMaThanhVien(rs.getString(4));
				taiKhoan.setTenThanhVien(rs.getString(5));
				if (rs.getString(6) == null){
					taiKhoan.setChucVu("3");
				} else {
					taiKhoan.setChucVu(rs.getString(6));
				}
				taiKhoan.setTrangThai(rs.getBoolean(7));
				taiKhoan.setSoNgayKhoa(rs.getInt(8));
				taiKhoan.setNgayBatDauKhoa(rs.getString(9));
				taiKhoan.setAnh(rs.getString(10));
			}
			return taiKhoan;
		} catch (SQLException e) {
			return null;
		} finally {
			closeConnection();
		}
	}
	
	public static void main(String[] args) {
		System.out.println(new CheckLoginDAO().checkLogin("congtan", "123456"));
	}
}
