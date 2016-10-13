package model.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import model.bean.TaiKhoan;
import model.bean.ThanhVien;

public class ThanhVienDAO extends ConnectDAO {

	/**
	 * Hàm thêm mới thông tin của 1 thành viên vào database
	 * 
	 * @param thanhVien
	 * @return Thành công / Thất bại
	 */
	public boolean chenThanhVien(ThanhVien thanhVien) {
		try {
			String sql1 = "INSERT INTO THANHVIEN (MaThanhVien, TenThanhVien, GioiTinh, NgaySinh, DiaChi, SoDienThoai, Email, QuocTich, NgonNgu, MaCapDo, ChucVu, MaTrinhDo, SoSao, Anh) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
			PreparedStatement pst;
			openConnection();
			pst = getConnect().prepareStatement(sql1);
			pst.setString(1, thanhVien.getMaThanhVien());
			pst.setString(2, thanhVien.getTenThanhVien());
			pst.setString(3, thanhVien.getGioiTinh());
			pst.setString(4, thanhVien.getNgaySinh());
			pst.setString(5, thanhVien.getDiaChi());
			pst.setString(6, thanhVien.getSoDienThoai());
			pst.setString(7, thanhVien.getEmail());
			pst.setString(8, thanhVien.getQuocTich());
			pst.setString(9, thanhVien.getNgonNgu());
			pst.setString(10, thanhVien.getMaCapDo());
			pst.setString(11, thanhVien.getChucVu().toString());
			pst.setString(12, thanhVien.getMaTrinhDo());
			pst.setString(13, thanhVien.getSoSao() + "");
			pst.setString(14, thanhVien.getAnh());
			return !pst.execute();
		} catch (SQLException e) {
			return false;
		} finally {
			closeConnection();
		}
	}

	/**
	 * Cấp tài khoản mới cho thành viên
	 * 
	 * @param taiKhoan
	 * @return boolean
	 */
	public boolean chenTaiKhoai(TaiKhoan taiKhoan) {
		try {
			String sql1 = "INSERT INTO TAIKHOAN (MaTaiKhoan, TenTaiKhoan, MatKhau, MaThanhVien, TrangThai)"
					+ " VALUES (?, ?, ?, ?, ?)";
			PreparedStatement pst;
			openConnection();
			pst = getConnect().prepareStatement(sql1);
			pst.setString(1, taiKhoan.getMaTaiKhoan());
			pst.setString(2, taiKhoan.getTenTaiKhoan());
			pst.setString(3, taiKhoan.getMatKhau());
			pst.setString(4, taiKhoan.getMaThanhVien());
			pst.setString(5, taiKhoan.getTrangThai().toString());
			return !pst.execute();
		} catch (SQLException e) {
			return false;
		} finally {
			closeConnection();
		}
	}

	/**
	 * Hàm lấy danh sách thành viên
	 * 
	 * @return Danh sách thành viên
	 */
	public ArrayList<ThanhVien> chonDanhSach() {
		try {
			ArrayList<ThanhVien> dsThanhVien = new ArrayList<ThanhVien>();
			final String SQL = "SELECT thanhVien.MaThanhVien, TenThanhVien, GioiTinh, NgaySinh, DiaChi, SoDienThoai, Email, QuocTich,"
					+ " NgonNgu, thanhVien.MaCapDo, ChucVu, thanhVien.MaTrinhDo, SoSao, TK.MaTaiKhoan, TenTaiKhoan, TenCapDo,"
					+ " TenTrinhDo, SBV.SoBaiDongGop,  SBD.SoBaiDaDich, SBL.SoBinhLuan"
					+ " FROM THANHVIEN thanhVien"
					+ " LEFT JOIN TAIKHOAN TK ON thanhVien.MaThanhVien = TK.MaThanhVien"
					+ " LEFT JOIN CAPDO CD ON thanhVien.MaCapDo = CD.MaCapDo"
					+ " LEFT JOIN TRINHDO TD ON thanhVien.MaTrinhDo = TD.MaTrinhDo"
					+ " LEFT JOIN (SELECT TV.MaThanhVien, COUNT(BV.MaThanhVien) AS SoBaiDongGop"
					+ " FROM THANHVIEN TV LEFT JOIN BAIVIET BV ON TV.MaThanhVien = BV.MaThanhVien"
					+ " GROUP BY TV.MaThanhVien) AS SBV ON thanhVien.MaThanhVien = SBV.MaThanhVien"
					+ " LEFT JOIN (SELECT TV.MaThanhVien, COUNT(PC.MaThanhVien) AS SoBaiDaDich"
					+ " FROM THANHVIEN TV LEFT JOIN PHANCONGDICHBAI PC ON TV.MaThanhVien = PC.MaThanhVien"
					+ " WHERE PC.TrangThai = N'Dich xong'"
					+ " GROUP BY TV.MaThanhVien) AS SBD ON thanhVien.MaThanhVien = SBD.MaThanhVien"
					+ " LEFT JOIN (SELECT TV.MaThanhVien, COUNT(BL.MaThanhVien) AS SoBinhLuan"
					+ " FROM THANHVIEN TV LEFT JOIN BINHLUAN BL ON TV.MaThanhVien = BL.MaThanhVien"
					+ " GROUP BY TV.MaThanhVien) AS SBL ON  thanhVien.MaThanhVien = SBL.MaThanhVien"
					+ " GROUP BY thanhVien.MaThanhVien, TenThanhVien, GioiTinh, NgaySinh, DiaChi, SoDienThoai, Email,"
					+ " QuocTich, NgonNgu, thanhVien.MaCapDo, ChucVu, thanhVien.MaTrinhDo, SoSao, TK.MaTaiKhoan,"
					+ " TenTaiKhoan, TenCapDo, TenTrinhDo, SBV.SoBaiDongGop,  SBD.SoBaiDaDich, SBL.SoBinhLuan";
			openConnection();
			ResultSet rs = getStatement().executeQuery(SQL);

			while (rs.next()) {
				ThanhVien thanhVien = new ThanhVien();
				thanhVien.setMaThanhVien(rs.getString(1));
				thanhVien.setTenThanhVien(rs.getString(2));
				if ("1".equals(rs.getString(3))) {
					thanhVien.setGioiTinh("Nam");
				} else {
					thanhVien.setGioiTinh("Nữ");
				}
				thanhVien.setNgaySinh(rs.getString(4));
				thanhVien.setDiaChi(rs.getString(5));
				thanhVien.setSoDienThoai(rs.getString(6));
				thanhVien.setEmail(rs.getString(7));
				thanhVien.setQuocTich(rs.getString(8));
				thanhVien.setNgonNgu(rs.getString(9));
				thanhVien.setMaCapDo(rs.getString(10));
				thanhVien.setMaTrinhDo(rs.getString(12));
				if (rs.getString(13) != null) {
					thanhVien.setSoSao(Integer.parseInt(rs.getString(13)));
				} else {
					thanhVien.setSoSao(0);
				}

				thanhVien.setMaTaiKhoan(rs.getString(14));
				thanhVien.setTenTaiKhoan(rs.getString(15));
				thanhVien.setTenCapDo(rs.getString(16));
				thanhVien.setTenTrinhDo(rs.getString(17));
				thanhVien.setSoBaiDongGop(Integer.parseInt(rs.getString(18)));
				if (rs.getString(19) != null) {
					thanhVien
							.setSoBaiDaDich(Integer.parseInt(rs.getString(19)));
				} else {
					thanhVien.setSoBaiDaDich(0);
				}
				if (rs.getString(11) != null) {
					if ("1".equals(rs.getString(11))) {
						thanhVien.setChucVu(true);
					} else {
						thanhVien.setChucVu(false);
					}
					thanhVien.setSoBinhLuan(Integer.parseInt(rs.getString(20)));
					dsThanhVien.add(thanhVien);
				}
			}
			return dsThanhVien;
		} catch (SQLException e) {
			return null;
		} finally {
			closeConnection();
		}
	}

	/**
	 * Hàm lấy thông tin của 1 thành viên khi biết mã thành viên của
	 * thành viên đó
	 * 
	 * @param maThanhVien
	 * @return Thông tin thành viên
	 */
	public ThanhVien chonThanhVien(String maThanhVien) {
		try {
			final String SQL = "SELECT thanhVien.MaThanhVien, TenThanhVien, GioiTinh, NgaySinh, DiaChi, SoDienThoai, Email, QuocTich,"
					+ " NgonNgu, thanhVien.MaCapDo, ChucVu, thanhVien.MaTrinhDo, SoSao, TK.MaTaiKhoan, TenTaiKhoan, TenCapDo,"
					+ " TenTrinhDo, SBV.SoBaiDongGop,  SBD.SoBaiDaDich, SBL.SoBinhLuan"
					+ " FROM THANHVIEN thanhVien"
					+ " LEFT JOIN TAIKHOAN TK ON thanhVien.MaThanhVien = TK.MaThanhVien"
					+ " LEFT JOIN CAPDO CD ON thanhVien.MaCapDo = CD.MaCapDo"
					+ " LEFT JOIN TRINHDO TD ON thanhVien.MaTrinhDo = TD.MaTrinhDo"
					+ " LEFT JOIN (SELECT TV.MaThanhVien, COUNT(BV.MaThanhVien) AS SoBaiDongGop"
					+ " FROM THANHVIEN TV LEFT JOIN BAIVIET BV ON TV.MaThanhVien = BV.MaThanhVien"
					+ " GROUP BY TV.MaThanhVien) AS SBV ON thanhVien.MaThanhVien = SBV.MaThanhVien"
					+ " LEFT JOIN (SELECT TV.MaThanhVien, COUNT(PC.MaThanhVien) AS SoBaiDaDich"
					+ " FROM THANHVIEN TV LEFT JOIN PHANCONGDICHBAI PC ON TV.MaThanhVien = PC.MaThanhVien"
					+ " WHERE PC.TrangThai = N'Dich xong'"
					+ " GROUP BY TV.MaThanhVien) AS SBD ON thanhVien.MaThanhVien = SBD.MaThanhVien"
					+ " LEFT JOIN (SELECT TV.MaThanhVien, COUNT(BL.MaThanhVien) AS SoBinhLuan"
					+ " FROM THANHVIEN TV LEFT JOIN BINHLUAN BL ON TV.MaThanhVien = BL.MaThanhVien"
					+ " GROUP BY TV.MaThanhVien) AS SBL ON  thanhVien.MaThanhVien = SBL.MaThanhVien"
					+ " WHERE thanhVien.MaThanhVien = '"
					+ maThanhVien
					+ "'"
					+ " GROUP BY thanhVien.MaThanhVien, TenThanhVien, GioiTinh, NgaySinh, DiaChi, SoDienThoai, Email,"
					+ " QuocTich, NgonNgu, thanhVien.MaCapDo, ChucVu, thanhVien.MaTrinhDo, SoSao, TK.MaTaiKhoan,"
					+ " TenTaiKhoan, TenCapDo, TenTrinhDo, SBV.SoBaiDongGop,  SBD.SoBaiDaDich, SBL.SoBinhLuan";
			openConnection();
			ResultSet rs = getStatement().executeQuery(SQL);
			ThanhVien thanhVien = new ThanhVien();
			while (rs.next()) {
				thanhVien.setMaThanhVien(rs.getString(1));
				thanhVien.setTenThanhVien(rs.getString(2));
				if ("1".equals(rs.getString(3))) {
					thanhVien.setGioiTinh("Nam");
				} else {
					thanhVien.setGioiTinh("Nữ");
				}
				thanhVien.setNgaySinh(rs.getString(4));
				thanhVien.setDiaChi(rs.getString(5));
				thanhVien.setSoDienThoai(rs.getString(6));
				thanhVien.setEmail(rs.getString(7));
				thanhVien.setQuocTich(rs.getString(8));
				thanhVien.setNgonNgu(rs.getString(9));
				thanhVien.setMaCapDo(rs.getString(10));
				if ("1".equals(rs.getString(11))) {
					thanhVien.setChucVu(true);
				} else {
					thanhVien.setChucVu(false);
				}
				thanhVien.setMaTrinhDo(rs.getString(12));
				thanhVien.setSoSao(Integer.parseInt(rs.getString(13)));
				thanhVien.setMaTaiKhoan(rs.getString(14));
				thanhVien.setTenTaiKhoan(rs.getString(15));
				thanhVien.setTenCapDo(rs.getString(16));
				thanhVien.setTenTrinhDo(rs.getString(17));
				thanhVien.setSoBaiDongGop(Integer.parseInt(rs.getString(18)));
				if (rs.getString(19) != null) {
					thanhVien
							.setSoBaiDaDich(Integer.parseInt(rs.getString(19)));
				} else {
					thanhVien.setSoBaiDaDich(0);
				}
				thanhVien.setSoBinhLuan(Integer.parseInt(rs.getString(20)));
			}
			return thanhVien;
		} catch (SQLException e) {
			return null;
		} finally {
			closeConnection();
		}
	}

	/**
	 * Hàm tìm kiếm thông tin thành viên
	 * 
	 * @param tuKhoaTimKiem
	 * @param noiDungTimKiem
	 * @return Thông tin thành viên
	 */
	public ArrayList<ThanhVien> timKiem(String tuKhoaTimKiem,
			String noiDungTimKiem) {

		try {
			ArrayList<ThanhVien> danhSachThanhVien = new ArrayList<ThanhVien>();

			String sql = "SELECT thanhVien.MaThanhVien, TenThanhVien, GioiTinh, NgaySinh, DiaChi, SoDienThoai, Email, QuocTich, NgonNgu, thanhVien.MaCapDo, ChucVu, thanhVien.MaTrinhDo, SoSao, TK.MaTaiKhoan, TenTaiKhoan, TenCapDo, TenTrinhDo"
					+ " FROM (THANHVIEN thanhVien LEFT OUTER JOIN TAIKHOAN TK ON thanhVien.MaThanhVien = TK.MaThanhVien)"
					+ " LEFT OUTER JOIN CAPDO CD ON thanhVien.MaCapDo = CD.MaCapDo"
					+ " LEFT OUTER JOIN TRINHDO TD ON thanhVien.MaTrinhDo = TD.MaTrinhDo";

			if ("TenTaiKhoan".equals(tuKhoaTimKiem)) {
				sql = sql.concat(" WHERE TK." + tuKhoaTimKiem + " = N'"
						+ noiDungTimKiem + "'");
			} else {
				sql = sql.concat(" WHERE thanhVien." + tuKhoaTimKiem
						+ " LIKE N'%" + noiDungTimKiem + "%'");
			}
			openConnection();
			openConnection();
			ResultSet rs = getStatement().executeQuery(sql);
			while (rs.next()) {
				ThanhVien thanhVien = new ThanhVien();
				thanhVien.setMaThanhVien(rs.getString(1));
				thanhVien.setTenThanhVien(rs.getString(2));
				if ("1".equals(rs.getString(3))) {
					thanhVien.setGioiTinh("Nam");
				} else {
					thanhVien.setGioiTinh("Nữ");
				}
				thanhVien.setNgaySinh(rs.getString(4));
				thanhVien.setDiaChi(rs.getString(5));
				thanhVien.setSoDienThoai(rs.getString(6));
				thanhVien.setEmail(rs.getString(7));
				thanhVien.setQuocTich(rs.getString(8));
				thanhVien.setNgonNgu(rs.getString(9));
				thanhVien.setMaCapDo(rs.getString(10));
				thanhVien.setMaTrinhDo(rs.getString(12));
				try {
					thanhVien.setSoSao(Integer.parseInt(rs.getString(13)));
				} catch (Exception e) {
					e.printStackTrace();
				}
				thanhVien.setMaTaiKhoan(rs.getString(14));
				thanhVien.setTenTaiKhoan(rs.getString(15));
				thanhVien.setTenCapDo(rs.getString(16));
				thanhVien.setTenTrinhDo(rs.getString(17));
				if (rs.getString(11) != null) {
					if ("1".equals(rs.getString(11))) {
						thanhVien.setChucVu(true);
					} else {
						thanhVien.setChucVu(false);
					}
					danhSachThanhVien.add(thanhVien);
				}
			}
			return danhSachThanhVien;
		} catch (SQLException e) {
			return null;
		} finally {
			closeConnection();
		}
	}

	/**
	 * Hàm cập nhật thông tin thành viên
	 * 
	 * @param thanhVien
	 * @return True/False
	 */
	public boolean capNhatThanhVien(ThanhVien thanhVien) {
		try {
			final String sql = String
					.format("UPDATE THANHVIEN SET TenThanhVien = N'%s', GioiTinh = '%s', NgaySinh = '%s', DiaChi = N'%s', SoDienThoai = '%s',Email = N'%s',QuocTich = N'%s',NgonNgu = N'%s' WHERE MaThanhVien = '%s'",
							thanhVien.getTenThanhVien(),
							thanhVien.getGioiTinh(), thanhVien.getNgaySinh(),
							thanhVien.getDiaChi(), thanhVien.getSoDienThoai(),
							thanhVien.getEmail(), thanhVien.getQuocTich(),
							thanhVien.getNgonNgu(), thanhVien.getMaThanhVien());
			openConnection();
			getStatement().executeUpdate(sql);
			return true;
		} catch (SQLException e) {
			return false;
		} finally {
			closeConnection();
		}
	}

	/**
	 * Hàm xóa thông tin thành viên
	 * 
	 * @param maThanhVien
	 * @return True/False
	 */
	public boolean xoaThanhVien(String maThanhVien) {

		try {
			final String sql = "DELETE THANHVIEN WHERE MaThanhVien = '"
					+ maThanhVien + "'";
			openConnection();
			getStatement().executeUpdate(sql);
			return true;
		} catch (SQLException e) {
			return false;
		} finally {
			closeConnection();
		}

	}

	/**
	 * Xóa tất cả các tài khoản của thành viên có mã thành viên tương
	 * ứng
	 * 
	 * @param maThanhVien
	 * @return boolean
	 */
	public boolean xoaTaiKhoan(String maThanhVien) {
		try {
			final String SQL = String.format(
					"DELETE TAIKHOAN WHERE MaThanhVien = '%s'", maThanhVien);
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
	 * Hàm khóa tất cả các tài khoản của thành viên
	 * 
	 * @param maThanhVien
	 * @param soNgayKhoa
	 * @param ngayBatDauKhoa
	 * @return True/False
	 */
	public boolean khoaTaiKhoan(String maThanhVien, int soNgayKhoa,
			String ngayBatDauKhoa) {
		try {
			final String sql = String
					.format("UPDATE TAIKHOAN SET TrangThai = 'True', SoNgayKhoa = %s, NgayBatDauKhoa = '%s'"
							+ " WHERE MaThanhVien = '%s'", soNgayKhoa,
							ngayBatDauKhoa, maThanhVien);
			openConnection();
			getStatement().executeUpdate(sql);
			return true;
		} catch (SQLException e) {
			return false;
		} finally {
			closeConnection();
		}
	}

	/**
	 * Hàm mở khóa tất cả các tài khoản của thành viên
	 * 
	 * @param maThanhVien
	 * @return True/False
	 */
	public boolean moKhoaTaiKhoan(String maThanhVien) {
		try {
			final String sql = String.format(
					"UPDATE TAIKHOAN SET TrangThai = 'False', SoNgayKhoa = 0"
							+ " WHERE MaThanhVien = '%s'", maThanhVien);
			openConnection();
			getStatement().executeUpdate(sql);
			return true;
		} catch (SQLException e) {
			return false;
		} finally {
			closeConnection();
		}
	}

	/**
	 * Hàm tự động tăng mã thành viên
	 * 
	 * @return String
	 */
	public String tangMaThanhVien() {
		try {
			final String sql = "SELECT TOP 1 MaThanhVien From THANHVIEN ORDER BY MaThanhVien DESC";
			openConnection();
			ResultSet rs = getStatement().executeQuery(sql);
			String maThanhVien = "";
			while (rs.next()) {
				maThanhVien = rs.getString(1);
			}
			if ("".equals(maThanhVien)) {
				return "TV00000001";
			} else {
				Long maMoi = Long
						.parseLong(maThanhVien.substring(2, 10).trim()) + 1;
				return String.format("TV%0" + 8 + "d", maMoi);
			}
		} catch (Exception e) {
			return null;
		} finally {
			closeConnection();
		}
	}

	/**
	 * Hàm tự động tăng mã tài khoản
	 * 
	 * @return String
	 */
	public String tangMaTaiKhoan() {
		try {
			final String sql = "SELECT TOP 1 MaTaiKhoan From TAIKHOAN ORDER BY MaTaiKhoan DESC";
			openConnection();
			ResultSet rs = getStatement().executeQuery(sql);
			String maThanhVien = "";
			while (rs.next()) {
				maThanhVien = rs.getString(1);
			}
			if ("".equals(maThanhVien)) {
				return "TK00000001";
			} else {
				Long maMoi = Long
						.parseLong(maThanhVien.substring(2, 10).trim()) + 1;
				return String.format("TK%0" + 8 + "d", maMoi);
			}
		} catch (Exception e) {
			return null;
		} finally {
			closeConnection();
		}
	}

	/**
	 * Hàm kiểm tra tên tài khoản đã tồn tại trong database hay chưa
	 * 
	 * @param tenTaiKhoan
	 * @return Nếu có thì return về true / Không có return false
	 */
	public boolean kiemTraTaiKhoan(String tenTaiKhoan) {
		try {
			final String sql = String
					.format("SELECT TenTaiKhoan FROM TAIKHOAN WHERE TenTaiKhoan = '%s'",
							tenTaiKhoan);
			openConnection();
			ResultSet rs = getStatement().executeQuery(sql);
			while (rs.next()) {
				return true;
			}
		} catch (SQLException e) {
			return true;
		}
		return false;
	}

	/**
	 * Lấy danh sách đã phân công dịch bài
	 * 
	 * @return
	 */
	public ArrayList<ThanhVien> danhSachPhanCongCTV() {
		try {
			ArrayList<ThanhVien> dsThanhVien = new ArrayList<ThanhVien>();
			final String SQL = "SELECT TV.MaThanhVien, TV.TenThanhVien, TD.TenTrinhDo, DX.SoBaiDangNhan"
					+ " FROM THANHVIEN TV JOIN TRINHDO TD ON TV.MaTrinhDo = TD.MaTrinhDo"
					+ " LEFT JOIN (SELECT TV.MaThanhVien, COUNT(PC.MaThanhVien) AS SoBaiDangNhan"
					+ " FROM THANHVIEN TV JOIN PHANCONGDICHBAI PC ON TV.MaThanhVien = PC.MaThanhVien"
					+ " WHERE PC.TrangThai = N'Dang dich'"
					+ " GROUP BY TV.MaThanhVien, PC.TrangThai) AS DX ON TV.MaThanhVien = DX.MaThanhVien"
					+ " WHERE TV.ChucVu = 'True'"
					+ " GROUP BY TV.MaThanhVien, TV.TenThanhVien, TD.TenTrinhDo, DX.SoBaiDangNhan";
			openConnection();
			ResultSet rs = getStatement().executeQuery(SQL);

			while (rs.next()) {
				ThanhVien thanhVien = new ThanhVien();
				thanhVien.setMaThanhVien(rs.getString(1));
				thanhVien.setTenThanhVien(rs.getString(2));
				thanhVien.setTenTrinhDo(rs.getString(3));
				if (rs.getString(4) != null) {
					thanhVien
							.setSoBaiDangNhan(Integer.parseInt(rs.getString(4)));
				} else {
					thanhVien.setSoBaiDangNhan(0);
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
	 * Hàm tìm kiếm thông tin phân công cộng tác viên
	 * 
	 * @param tuKhoaTimKiem
	 * @param noiDungTimKiem
	 * @return Thông tin phân công cộng tác viên
	 */
	public ArrayList<ThanhVien> timKiemPhanCongCTV(String tuKhoaTimKiem,
			String noiDungTimKiem) {

		try {
			openConnection();
			ArrayList<ThanhVien> danhSachThanhVien = new ArrayList<ThanhVien>();

			String SQL = "SELECT TV.MaThanhVien, TV.TenThanhVien, TD.TenTrinhDo, DX.SoBaiDangNhan"
					+ " FROM THANHVIEN TV JOIN TRINHDO TD ON TV.MaTrinhDo = TD.MaTrinhDo"
					+ " LEFT JOIN (SELECT TV.MaThanhVien, COUNT(PC.MaThanhVien) AS SoBaiDangNhan"
					+ " FROM THANHVIEN TV JOIN PHANCONGDICHBAI PC ON TV.MaThanhVien = PC.MaThanhVien"
					+ " WHERE PC.TrangThai = N'Dang dich'"
					+ " GROUP BY TV.MaThanhVien, PC.TrangThai) AS DX ON TV.MaThanhVien = DX.MaThanhVien"
					+ " WHERE TV.ChucVu = 'True'";
			if ("MaThanhVien".equals(tuKhoaTimKiem)
					|| "TenThanhVien".equals(tuKhoaTimKiem)) {
				SQL = SQL.concat(" AND TV." + tuKhoaTimKiem + " LIKE N'%"
						+ noiDungTimKiem + "%'");
			} else if ("TenTrinhDo".equals(tuKhoaTimKiem)) {
				SQL = SQL.concat(" AND TD.TenTrinhDo LIKE N'%" + noiDungTimKiem
						+ "%'");
			} else {
				if (Integer.parseInt(noiDungTimKiem) != 0) {
					SQL = SQL.concat(" AND DX.SoBaiDangNhan = "
							+ noiDungTimKiem);
				} else {
					SQL = SQL.concat(" AND DX.SoBaiDangNhan IS NULL");
				}

			}
			SQL = SQL
					.concat(" GROUP BY TV.MaThanhVien, TV.TenThanhVien, TD.TenTrinhDo, DX.SoBaiDangNhan");

			ResultSet rs = getStatement().executeQuery(SQL);
			while (rs.next()) {
				ThanhVien thanhVien = new ThanhVien();
				thanhVien.setMaThanhVien(rs.getString(1));
				thanhVien.setTenThanhVien(rs.getString(2));
				thanhVien.setTenTrinhDo(rs.getString(3));
				if (rs.getString(4) != null) {
					thanhVien
							.setSoBaiDangNhan(Integer.parseInt(rs.getString(4)));
				} else {
					thanhVien.setSoBaiDangNhan(0);
				}
				danhSachThanhVien.add(thanhVien);
			}
			return danhSachThanhVien;
		} catch (SQLException e) {
			return null;
		} finally {
			closeConnection();
		}
	}

	/**
	 * Lấy thông tin của cộng tác viên trong màn hình phân công bài vết
	 * 
	 * @param maThanhVien
	 * @return ThanhVien
	 */
	public ThanhVien thongTinPhanCongCTVDichBai(String maThanhVien) {

		try {
			final String SQL = "SELECT TV2.MaThanhVien, TV2.TenThanhVien, TV2.GioiTinh, TV2.NgonNgu, SBD.SoBaiDaDich"
					+ " FROM (SELECT MaThanhVien, TenThanhVien, NgonNgu, GioiTinh FROM THANHVIEN"
					+ " WHERE ChucVu = 'True') AS TV2 LEFT JOIN (SELECT TV.MaThanhVien, COUNT(PC.MaThanhVien) AS SoBaiDaDich"
					+ " FROM THANHVIEN TV LEFT JOIN PHANCONGDICHBAI PC ON TV.MaThanhVien = PC.MaThanhVien"
					+ " WHERE PC.TrangThai = N'Dich xong'"
					+ " GROUP BY TV.MaThanhVien) AS SBD ON TV2.MaThanhVien = SBD.MaThanhVien"
					+ " WHERE TV2.MaThanhVien = '" + maThanhVien + "'";
			openConnection();
			ResultSet rs = getStatement().executeQuery(SQL);
			ThanhVien thanhVien = new ThanhVien();
			while (rs.next()) {
				thanhVien.setMaThanhVien(rs.getString(1));
				thanhVien.setTenThanhVien(rs.getString(2));
				thanhVien.setGioiTinh(rs.getString(3));
				thanhVien.setNgonNgu(rs.getString(4));
				if (rs.getString(5) != null) {
					thanhVien.setSoBaiDaDich(Integer.parseInt(rs.getString(5)));
				} else {
					thanhVien.setSoBaiDaDich(0);
				}
			}
			return thanhVien;
		} catch (SQLException e) {
			return null;
		} finally {
			closeConnection();
		}
	}

	/**
	 * Hàm kiểm tra email đã tồn tại trong database hay chưa
	 * 
	 * @param Email
	 * @return Nếu có thì return về true / Không có return false
	 */
	public boolean kiemTraEmailTonTai(String email) {
		try {
			final String sql = String.format(
					"SELECT Email FROM THANHVIEN WHERE Email = '%s'", email);
			openConnection();
			ResultSet rs = getStatement().executeQuery(sql);
			while (rs.next()) {
				return true;
			}
		} catch (SQLException e) {
			return true;
		}
		return false;
	}

	/**
	 * Đánh giá thành viên tương ứng với tên cấp độ và số sao
	 * 
	 * @param maThanhVien
	 * @param tenCapDo
	 * @param soSao
	 */
	public boolean danhGiaThanhVien(String maThanhVien, String tenCapDo,
			int soSao) {
		// TODO Auto-generated method stub
		try {
			openConnection();
			String sql = "select MaCapDo from CAPDO where TenCapDo=N'"
					+ tenCapDo + "'";
			System.out.println(sql);
			ResultSet rs = getStatement().executeQuery(sql);
			rs.next();
			String maCapDo = rs.getString("maCapDo");
			sql = String
					.format("update THANHVIEN set MaCapDo='%s',SoSao=%d where MaThanhVien='%s'",
							maCapDo, soSao, maThanhVien);
			getStatement().executeUpdate(sql);
			// System.out.println(sql);
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("danh gia khong thanh cong ctv");
			// System.out.println(e);
			return false;
		} finally {
			closeConnection();
		}
	}

	/**
	 * Đánh giá cộng tác viên tương ứng với tên cấp độ và số sao
	 * 
	 * @param maThanhVien
	 * @param tenTrinhDo
	 * @param soSao
	 */
	public boolean danhGiaCongTacVien(String maThanhVien, String tenTrinhDo,
			int soSao) {
		// TODO Auto-generated method stub
		try {
			openConnection();
			String sql = "select MaTrinhDo from TRINHDO where TenTrinhDo=N'"
					+ tenTrinhDo + "'";
			System.out.println(sql);
			ResultSet rs = getStatement().executeQuery(sql);
			rs.next();
			String maTrinhDo = rs.getString("maTrinhDo");
			System.out.println(maTrinhDo);
			sql = String
					.format("update THANHVIEN set MaTrinhDo='%s',SoSao=%d where MaThanhVien='%s'",
							maTrinhDo, soSao, maThanhVien);
			getStatement().executeUpdate(sql);
			// System.out.println(sql);
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("danh gia khong thanh cong ctv");
			// System.out.println(e);
			return false;
		} finally {
			closeConnection();
		}
	}

	public static void main(String[] args) {
		// ArrayList<ThanhVien> dsThanhVien = new
		// ThanhVienDAO().timKiem("MaThanhVien", "thanhVien00000002");
		// for (int i = 0; i < dsThanhVien.size(); i++) {
		// System.out.println(dsThanhVien.get(i).toString());
		// }

		// ThanhVien thanhVien = new ThanhVienDAO().chonThanhVien("TV00000001");
		// thanhVien.setMaKhau("123456");
		// System.out.println(new ThanhVienBO().chenThanhVien(thanhVien));
		// thanhVien.setTenThanhVien("Nguyệt DAO");
		// System.out.println(new ThanhVienBO().capNhatThanhVien(thanhVien));

		// ThanhVien thanhvien = new
		// ThanhVienDAO().chonThanhVien("thanhVien00000001");
		// System.out.println(thanhvien.toString());
		// thanhvien.setMaThanhVien("thanhVien00000009");
		// System.out.println(new ThanhVienDAO().chenThanhVien(thanhvien));

		// System.out.println(new
		// ThanhVienDAO().khoaTaiKhoan("thanhVien00000001", 5));

		// System.out.println(new ThanhVienDAO().tangMaTaiKhoan());

		// System.out.println("Tân");

		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		Calendar c = Calendar.getInstance();
		c.setTime(new Date()); // Now use today date.
		c.add(Calendar.DATE, 5); // Adding 5 days
		String output = sdf.format(c.getTime());
		System.out.println(output);
	}

	/**
	 * 
	 * return danhSachTopCongTacVien ArrayList<ArrayList<ThanhVien>> 
	 */
	
	public ArrayList<ArrayList<ThanhVien>> danhSachTopCongTacVien() {
		try {
			openConnection();
			String sql="select top 8 tv.MaThanhVien, tv.TenThanhVien, "
					+ " tv.GioiTinh, tv.NgaySinh, tv.DiaChi, tv.SoDienThoai, tv.Email, "
					+ " tv.QuocTich, tv.NgonNgu, td.TenTrinhDo, tv.SoSao, tv.Anh "
					+ " from THANHVIEN tv join TRINHDO td on tv.MaTrinhDo = td.MaTrinhDo "
					+ " where tv.ChucVu=1 "
					+ " order by tv.SoSao desc";
			
			ResultSet rs= getStatement().executeQuery(sql);		
			ArrayList<ThanhVien> danhSachTopCongTacVien = new ArrayList<ThanhVien>();
			
			while(rs.next()){
				ThanhVien thanhVien= new ThanhVien();
				thanhVien.setMaThanhVien(rs.getString(1));
				thanhVien.setTenThanhVien(rs.getString(2));
				thanhVien.setGioiTinh(rs.getString(3));
				thanhVien.setNgaySinh(rs.getString(4));
				thanhVien.setDiaChi(rs.getString(5));
				thanhVien.setSoDienThoai(rs.getString(6));
				thanhVien.setEmail(rs.getString(7));
				thanhVien.setQuocTich(rs.getString(8));
				thanhVien.setNgonNgu(rs.getString(9));
				thanhVien.setTenTrinhDo(rs.getString(10));
				thanhVien.setSoSao(Integer.valueOf(rs.getString(11)));
				thanhVien.setAnh(rs.getString(12));
			//	System.out.println(""+thanhVien.getMaThanhVien()+thanhVien.getTenThanhVien());
				danhSachTopCongTacVien.add(thanhVien);
			}
			return chiaDanhSachCon(danhSachTopCongTacVien);
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * 
	 * return danhSachTopThanhVien ArrayList<ArrayList<ThanhVien>> 
	 */
	public ArrayList<ArrayList<ThanhVien>> danhSachTopThanhVien() {
		try {
			openConnection();
			String sql="select top 8 tv.MaThanhVien, tv.TenThanhVien, "
					+ " tv.GioiTinh, tv.NgaySinh, tv.DiaChi, tv.SoDienThoai, tv.Email, "
					+ " tv.QuocTich, tv.NgonNgu, cd.TenCapDo, tv.SoSao, tv.Anh "
					+ " from THANHVIEN tv join CAPDO cd on tv.MaCapDo = cd.MaCapDo "
					+ " where tv.ChucVu=0 "
					+ " order by tv.SoSao desc";
			
			ResultSet rs=getStatement().executeQuery(sql);
			ArrayList<ThanhVien> danhSachTopThanhVien = new ArrayList<ThanhVien>();
			
			while(rs.next()){
				ThanhVien thanhVien= new ThanhVien();
				thanhVien.setMaThanhVien(rs.getString(1));
				thanhVien.setTenThanhVien(rs.getString(2));
				thanhVien.setGioiTinh(rs.getString(3));
				thanhVien.setNgaySinh(rs.getString(4));
				thanhVien.setDiaChi(rs.getString(5));
				thanhVien.setSoDienThoai(rs.getString(6));
				thanhVien.setEmail(rs.getString(7));
				thanhVien.setQuocTich(rs.getString(8));
				thanhVien.setNgonNgu(rs.getString(9));
				thanhVien.setTenCapDo(rs.getString(10));
				thanhVien.setSoSao(Integer.valueOf(rs.getString(11)));
				thanhVien.setAnh(rs.getString(12));
				//System.out.println(""+thanhVien.getMaThanhVien()+thanhVien.getTenThanhVien());
				danhSachTopThanhVien.add(thanhVien);
			}
			return chiaDanhSachCon(danhSachTopThanhVien);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	
	/**
	 * 
	 * chia danh sach cha thanh cac danh sach con DEFAULT size danhSachCon=4
	 * @param ArrayList<ThanhVien> danhSachCha
	 * @return ArrayList<ArrayList<ThanhVien>> danhSachDaChia
	 * 
	 * */
	public ArrayList<ArrayList<ThanhVien>> chiaDanhSachCon(ArrayList<ThanhVien> danhSachCha ){
		ArrayList<ThanhVien> danhSachCon= new ArrayList<ThanhVien>();
		ArrayList<ArrayList<ThanhVien>> danhSachDaChia= new ArrayList<ArrayList<ThanhVien>>();
		for(int i=0; i<danhSachCha.size(); i++){
			if(danhSachCon.size()==4){
				danhSachDaChia.add(danhSachCon);
				danhSachCon= new ArrayList<ThanhVien>();
				danhSachCon.add(danhSachCha.get(i));
			}else
			danhSachCon.add(danhSachCha.get(i));
		}
		danhSachDaChia.add(danhSachCon);
		//System.out.println(""+danhSachDaChia.size());
		return danhSachDaChia;
	}

	public void capNhatMatKhauAdmin(String maThanhVien, String matKhauMoi) {
		try {
			openConnection();
			String sql="update TAIKHOAN set MatKhau='"+matKhauMoi+"'"
					+ " where MaThanhVien ='"+maThanhVien+"'";
			getStatement().executeUpdate(sql);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void capNhatTenThanhVien(String maThanhVien, String tenThanhVien) {
		try {
			openConnection();
			String sql="update THANHVIEN set TenThanhVien='"+tenThanhVien+"'"
					+ " where MaThanhVien='"+maThanhVien+"'";
			getStatement().executeUpdate(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void capNhatAnhDaiDien(String maThanhVien, String anh) {
		try {
			openConnection();
			String sql="update THANHVIEN set Anh='"+anh+"'"
					+ " where MaThanhVien='"+maThanhVien+"'";
			getStatement().executeUpdate(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
