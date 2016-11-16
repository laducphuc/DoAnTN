package model.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.sun.org.apache.regexp.internal.recompile;

import model.bean.BaiViet;
import model.bean.ThanhVien;

public class ThongKeDAO extends ConnectDAO {

	/**
	 * Hàm lấy danh sách bảng xếp hạng thành viên
	 * 
	 * @return Danh sách thành viên
	 */
	public ArrayList<ThanhVien> bangXepHangThanhVien() {
		try {
			ArrayList<ThanhVien> dsThanhVien = new ArrayList<ThanhVien>();
			final String SQL = "SELECT TV.MaThanhVien, TV.TenThanhVien,TK.TenTaiKhoan, CD.TenCapDo, SoSao, SBDG.SoBaiDongGop"
					+ " FROM THANHVIEN TV JOIN TAIKHOAN TK ON TK.MaThanhVien = TV.MaThanhVien"
					+ " JOIN CAPDO CD ON CD.MaCapDo = TV.MaCapDo" + " LEFT JOIN"
					+ " (SELECT MaThanhVien, COUNT(MaThanhVien) AS SoBaiDongGop" + " FROM BAIVIET"
					+ " GROUP BY MaThanhVien) AS SBDG ON TV.MaThanhVien = SBDG.MaThanhVien"
					+ " WHERE TV.ChucVu = 'False'" + " ORDER BY TV.MaCapDo DESC,SoSao DESC";
			openConnection();
			ResultSet rs = getStatement().executeQuery(SQL);

			while (rs.next()) {
				ThanhVien thanhVien = new ThanhVien();
				thanhVien.setMaThanhVien(rs.getString(1));
				thanhVien.setTenThanhVien(rs.getString(2));
				thanhVien.setTenTaiKhoan(rs.getString(3));
				thanhVien.setTenCapDo(rs.getString(4));
				thanhVien.setSoSao(Integer.parseInt(rs.getString(5)));
				if (rs.getString(6) != null) {
					thanhVien.setSoBaiDongGop(Integer.parseInt(rs.getString(6)));
				} else {
					thanhVien.setSoBaiDongGop(0);
				}
				dsThanhVien.add(thanhVien);

			}
			return dsThanhVien;
		} catch (SQLException e) {
			return null;
		} finally {
			closeConnection();
		}
	}

	/**
	 * Hàm lấy danh sách bảng xếp hạng cộng tác viên
	 * 
	 * @return Danh sách thành viên
	 */

	public ArrayList<ThanhVien> bangXepHangCongTacVien() {
		try {
			ArrayList<ThanhVien> dsThanhVien = new ArrayList<ThanhVien>();
			final String SQL = "SELECT thanhVien.MaThanhVien, TenThanhVien,SoSao,TenTaiKhoan,TenTrinhDo,SBV.SoBaiDongGop, SBD.SoBaiDaDich"
					+ " FROM THANHVIEN thanhVien" + " LEFT JOIN TAIKHOAN TK ON thanhVien.MaThanhVien = TK.MaThanhVien"
					+ " LEFT JOIN TRINHDO TD ON thanhVien.MaTrinhDo = TD.MaTrinhDo"
					+ " LEFT JOIN (SELECT TV.MaThanhVien, COUNT(BV.MaThanhVien) AS SoBaiDongGop"
					+ " FROM THANHVIEN TV LEFT JOIN BAIVIET BV ON TV.MaThanhVien = BV.MaThanhVien"
					+ " GROUP BY TV.MaThanhVien) AS SBV ON thanhVien.MaThanhVien = SBV.MaThanhVien"
					+ " LEFT JOIN (SELECT TV.MaThanhVien, COUNT(PC.MaThanhVien) AS SoBaiDaDich"
					+ " FROM THANHVIEN TV LEFT JOIN PHANCONGDICHBAI PC ON TV.MaThanhVien = PC.MaThanhVien"
					+ " WHERE PC.TrangThai = N'Dich xong'"
					+ " GROUP BY TV.MaThanhVien) AS SBD ON thanhVien.MaThanhVien = SBD.MaThanhVien"
					+ " WHERE thanhVien.ChucVu =  'True'"
					+ " GROUP BY thanhVien.MaThanhVien, TenThanhVien,SoSao,TenTaiKhoan,TenTrinhDo,SBV.SoBaiDongGop,SBD.SoBaiDaDich,thanhVien.MaTrinhDo"
					+ " ORDER BY thanhVien.MaTrinhDo DESC,SoSao DESC";
			openConnection();
			ResultSet rs = getStatement().executeQuery(SQL);

			while (rs.next()) {
				ThanhVien thanhVien = new ThanhVien();
				thanhVien.setMaThanhVien(rs.getString(1));
				thanhVien.setTenThanhVien(rs.getString(2));
				thanhVien.setSoSao(Integer.parseInt(rs.getString(3)));
				thanhVien.setTenTaiKhoan(rs.getString(4));
				thanhVien.setTenTrinhDo(rs.getString(5));

				if (rs.getString(6) != null) {
					thanhVien.setSoBaiDongGop(Integer.parseInt(rs.getString(6)));
				} else {
					thanhVien.setSoBaiDongGop(0);
				}
				if (rs.getString(7) != null) {
					thanhVien.setSoBaiDaDich(Integer.parseInt(rs.getString(7)));
				} else {
					thanhVien.setSoBaiDaDich(0);
				}
				dsThanhVien.add(thanhVien);

			}
			return dsThanhVien;
		} catch (SQLException e) {
			return null;
		} finally {
			closeConnection();
		}
	}

	/**
	 * Hàm lấy danh sách bảng xếp hạng bài viết được xem nhi�?u nhât
	 * 
	 * @return Danh sách thành viên
	 */
	public ArrayList<BaiViet> bangXepHangBaiViet() {

		try {
			final String SQL = " SELECT  BV.MaBaiViet, BV.TieuDeViet,DM.TenDanhMucViet, TV.TenThanhVien,BV.NgayVietBai,BV.LuotXem"
					+ " FROM BAIVIET BV JOIN DANHMUC DM ON DM.MaDanhMuc=BV.MaDanhMuc"
					+ " JOIN THANHVIEN TV ON TV.MaThanhVien=BV.MaThanhVien" + " WHERE BV.TrangThai='Da dang'"
					+ " ORDER BY BV.LuotXem DESC";
			openConnection();
			ResultSet rs = getStatement().executeQuery(SQL);
			ArrayList<BaiViet> danhSachBaiViet = new ArrayList<BaiViet>();
			while (rs.next()) {
				BaiViet baiViet = new BaiViet();
				baiViet.setMaBaiViet(rs.getString(1));
				baiViet.setTieuDeViet(rs.getString(2));
				baiViet.setTenDanhMucViet(rs.getString(3));
				baiViet.setTenThanhVien(rs.getString(4));
				baiViet.setNgayVietBai(rs.getString(5));
				baiViet.setLuotXem(Integer.parseInt(rs.getString(6)));
				danhSachBaiViet.add(baiViet);
			}
			return danhSachBaiViet;
		} catch (SQLException e) {
			return null;
		} finally {
			closeConnection();
		}
	}

	public ThanhVien thanhVienNew() {
		String SQL = "select * from THANHVIEN order by MaThanhVien desc";
		openConnection();
		ThanhVien thanhVien = new ThanhVien();
		try {
			ResultSet rs = getStatement().executeQuery(SQL);
			rs.next();
			thanhVien.setMaThanhVien(rs.getString("MaThanhVien"));
			thanhVien.setTenThanhVien(rs.getString("TenThanhVien"));
			return thanhVien;
		} catch (SQLException e) {
			return null;
		} finally {
			closeConnection();
		}
	}
	public String soThanhVien() {
		String SQL="Select count(MaThanhVien) as Tong from THANHVIEN";
		openConnection();
		try {
			ResultSet rs=getStatement().executeQuery(SQL);
			rs.next();
			String resurt=rs.getString("Tong");
			return resurt;
		} catch (SQLException e) {
			return "";
		}
		finally{
			closeConnection();
		}
	}
	public static void main(String[] args) {
		System.out.println(new ThongKeDAO().bangXepHangBaiViet().get(0).getMaBaiViet());
	}

}
