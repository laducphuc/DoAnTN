package model.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import model.bean.BaiViet;

public class BaiVietDAO extends ConnectDAO {

	/**
	 * Lấy danh sách những bài viết mới và những bài viết đã phân công nhưng
	 * chưa được công tác viên chấp nhân
	 * 
	 * @return
	 */
	public ArrayList<BaiViet> danhSachBaiVietChuaDich() {

		try {
			final String SQL = "SELECT BV.MaBaiViet, BV.TieuDeViet, DM.TenDanhMucViet, TV.TenThanhVien, BV.NgayVietBai"
					+ " FROM BAIVIET BV JOIN THANHVIEN TV ON BV.MaThanhVien = TV.MaThanhVien"
					+ " JOIN DANHMUC DM ON BV.MaDanhMuc = DM.MaDanhMuc JOIN"
					+ " ((SELECT MaBaiViet FROM BAIVIET WHERE TrangThai = N'Bai moi') UNION"
					+ " ((SELECT BAIVIET.MaBaiViet FROM BAIVIET JOIN PHANCONGDICHBAI PC ON BAIVIET.MaBaiViet = PC.MaBaiViet"
					+ " WHERE PC.TrangThai = N'Qua han' OR PC.TrangThai = N'Tu choi') EXCEPT"
					+ " (SELECT BAIVIET.MaBaiViet FROM BAIVIET JOIN PHANCONGDICHBAI PC ON BAIVIET.MaBaiViet = PC.MaBaiViet"
					+ " WHERE PC.TrangThai != N'Qua han' AND PC.TrangThai != N'Tu choi'))) AS BV2 ON BV.MaBaiViet = BV2.MaBaiViet"
					+ " ORDER BY BV.NgayVietBai DESC";
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
				danhSachBaiViet.add(baiViet);
			}
			return danhSachBaiViet;
		} catch (SQLException e) {
			return null;
		} finally {
			closeConnection();
		}
	}

	/**
	 * Cập nhật trạng thái của bài viết
	 * 
	 * @param maBaiViet
	 * @param trangThai
	 * @return boolean
	 */
	public boolean capNhatTrangThaiBaiViet(String maBaiViet, String trangThai) {

		try {
			final String SQL = String.format("UPDATE BAIVIET SET TrangThai = N'%s' WHERE MaBaiViet = '%s'", trangThai,
					maBaiViet);
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
	 * Lấy toàn bộ danh sách bài viết
	 * 
	 * @return Danh sách bài viết
	 */
	public ArrayList<BaiViet> danhSachBaiViet() {

		try {
			openConnection();
			final String SQL = " SELECT BV.MaBaiViet, BV.TieuDeViet, DM.TenDanhMucViet, TV.TenThanhVien,"
					+ " BV.NgayVietBai, PC.TenThanhVien AS TenCongTacVien, BV.TrangThai"
					+ " FROM BAIVIET BV JOIN DANHMUC DM ON BV.MaDanhMuc = DM.MaDanhMuc"
					+ " JOIN THANHVIEN TV ON BV.MaThanhVien = TV.MaThanhVien" + " LEFT JOIN"
					+ " (SELECT PC.MaBaiViet, PC.MaThanhVien, TV.TenThanhVien"
					+ " FROM PHANCONGDICHBAI PC JOIN THANHVIEN TV ON TV.MaThanhVien = PC.MaThanhVien"
					+ " WHERE PC.TrangThai != 'Qua han' AND PC.TrangThai != 'Tu choi')"
					+ " AS PC ON BV.MaBaiViet = PC.MaBaiViet" + " ORDER BY BV.NgayVietBai DESC";
			ArrayList<BaiViet> danhSachBaiViet = new ArrayList<BaiViet>();
			ResultSet rs = getStatement().executeQuery(SQL);
			while (rs.next()) {
				BaiViet baiViet = new BaiViet();
				baiViet.setMaBaiViet(rs.getString(1));
				baiViet.setTieuDeViet(rs.getString(2));
				baiViet.setTenDanhMucViet(rs.getString(3));
				baiViet.setTenThanhVien(rs.getString(4));
				baiViet.setNgayVietBai(rs.getString(5));
				baiViet.setTenCongTacVien(rs.getString(6));
				baiViet.setTrangThai(rs.getString(7));
				danhSachBaiViet.add(baiViet);
			}
			return danhSachBaiViet;
		} catch (SQLException e) {
			return null;
		} finally {
			closeConnection();
		}
	}

	public ArrayList<BaiViet> danhSachBaiVietTrangChu() {
		ArrayList<BaiViet> danhSachBaiViet = new ArrayList<BaiViet>();
		try {
			final String SQL = "SELECT * FROM BAIVIET";
			openConnection();
			ResultSet rs = getStatement().executeQuery(SQL);
			BaiViet baiViet;
			while (rs.next()) {
				baiViet = new BaiViet();
				baiViet.setMaBaiViet(rs.getString("MaBaiViet"));
				baiViet.setTieuDeViet(rs.getString("TieuDeViet"));
				baiViet.setTieuDeNhat(rs.getString("TieuDeNhat"));
				baiViet.setMoTaViet(rs.getString("MoTaViet"));
				baiViet.setMoTaNhat(rs.getString("MoTaNhat"));
				baiViet.setNoiDungViet(rs.getString("NoiDungViet"));
				baiViet.setNoiDungNhat(rs.getString("NoiDungNhat"));
				baiViet.setTenDanhMucViet("NN");
				baiViet.setTenDanhMucNhat("VV");
				baiViet.setTenThanhVien(rs.getString("MaThanhVien"));
				baiViet.setNgayVietBai(rs.getString("NgayVietBai"));
				baiViet.setTenCongTacVien("Phuc");
				baiViet.setTrangThai(rs.getString("TrangThai"));
				baiViet.setAnh(rs.getString("Anh"));
				danhSachBaiViet.add(baiViet);
			}
			return danhSachBaiViet;
		} catch (SQLException e) {
			return null;
		} finally {
			closeConnection();
		}

	}

	/**
	 * Tìm kiếm danh sách bài viết theo từ khóa và nội dung tìm kiếm
	 * 
	 * @return Danh sách bài viết
	 */
	public ArrayList<BaiViet> timKiemDanhSachBaiViet(String tuKhoaTimKiem, String noiDungTimKiem) {

		try {
			openConnection();
			String SQL = " SELECT BV.MaBaiViet, BV.TieuDeViet, DM.TenDanhMucViet, TV.TenThanhVien,"
					+ " BV.NgayVietBai, PC.TenThanhVien AS TenCongTacVien, BV.TrangThai"
					+ " FROM BAIVIET BV JOIN DANHMUC DM ON BV.MaDanhMuc = DM.MaDanhMuc"
					+ " JOIN THANHVIEN TV ON BV.MaThanhVien = TV.MaThanhVien" + " LEFT JOIN"
					+ " (SELECT PC.MaBaiViet, PC.MaThanhVien, TV.TenThanhVien"
					+ " FROM PHANCONGDICHBAI PC JOIN THANHVIEN TV ON TV.MaThanhVien = PC.MaThanhVien"
					+ " WHERE PC.TrangThai != 'Qua han' AND PC.TrangThai != 'Tu choi')"
					+ " AS PC ON BV.MaBaiViet = PC.MaBaiViet";
			if ("TenThanhVien".equals(tuKhoaTimKiem)) {
				SQL = SQL.concat(" WHERE TV.TenThanhVien LIKE N'%" + noiDungTimKiem + "%'");
			} else if ("TenDanhMucViet".equals(tuKhoaTimKiem)) {
				SQL = SQL.concat(" WHERE DM.TenDanhMucViet LIKE N'%" + noiDungTimKiem + "%'");
			} else {
				SQL = SQL.concat(" WHERE BV." + tuKhoaTimKiem + " = N'" + noiDungTimKiem + "'");
			}
			SQL = SQL.concat(" ORDER BY BV.NgayVietBai DESC");
			ArrayList<BaiViet> danhSachBaiViet = new ArrayList<BaiViet>();
			ResultSet rs = getStatement().executeQuery(SQL);
			while (rs.next()) {
				BaiViet baiViet = new BaiViet();
				baiViet.setMaBaiViet(rs.getString(1));
				baiViet.setTieuDeViet(rs.getString(2));
				baiViet.setTenDanhMucViet(rs.getString(3));
				baiViet.setTenThanhVien(rs.getString(4));
				baiViet.setNgayVietBai(rs.getString(5));
				baiViet.setTenCongTacVien(rs.getString(6));
				baiViet.setTrangThai(rs.getString(7));
				danhSachBaiViet.add(baiViet);
			}
			return danhSachBaiViet;
		} catch (SQLException e) {
			return null;
		} finally {
			closeConnection();
		}
	}

	/**
	 * Tìm kiếm danh sách bài viết theo từ khóa và nội dung tìm kiếm và trạng
	 * thái của bài viết
	 * 
	 * @return Danh sách bài viết
	 */
	public ArrayList<BaiViet> timKiemDanhSachBaiViet(String trangThai, String tuKhoaTimKiem, String noiDungTimKiem) {

		try {
			openConnection();
			String SQL = " SELECT BV.MaBaiViet, BV.TieuDeViet, DM.TenDanhMucViet, TV.TenThanhVien,"
					+ " BV.NgayVietBai, PC.TenThanhVien AS TenCongTacVien, BV.TrangThai"
					+ " FROM BAIVIET BV JOIN DANHMUC DM ON BV.MaDanhMuc = DM.MaDanhMuc"
					+ " JOIN THANHVIEN TV ON BV.MaThanhVien = TV.MaThanhVien" + " LEFT JOIN"
					+ " (SELECT PC.MaBaiViet, PC.MaThanhVien, TV.TenThanhVien"
					+ " FROM PHANCONGDICHBAI PC JOIN THANHVIEN TV ON TV.MaThanhVien = PC.MaThanhVien"
					+ " WHERE PC.TrangThai != 'Qua han' AND PC.TrangThai != 'Tu choi')"
					+ " AS PC ON BV.MaBaiViet = PC.MaBaiViet";
			if ("Chuadich".equals(trangThai)) {
				SQL = SQL.concat(" WHERE (BV.TrangThai = N'Phan cong' OR BV.TrangThai = N'Dang dich')");
			} else {
				SQL = SQL.concat(" WHERE BV.TrangThai = N'" + trangThai + "'");
			}
			if ("TenThanhVien".equals(tuKhoaTimKiem)) {
				SQL = SQL.concat(" AND TV.TenThanhVien LIKE N'%" + noiDungTimKiem + "%'");
			} else if ("TenDanhMucViet".equals(tuKhoaTimKiem)) {
				SQL = SQL.concat(" AND DM.TenDanhMucViet LIKE N'%" + noiDungTimKiem + "%'");
			} else {
				SQL = SQL.concat(" AND BV." + tuKhoaTimKiem + " = N'" + noiDungTimKiem + "'");
			}
			SQL = SQL.concat(" ORDER BY BV.NgayVietBai DESC");
			ArrayList<BaiViet> danhSachBaiViet = new ArrayList<BaiViet>();
			ResultSet rs = getStatement().executeQuery(SQL);
			while (rs.next()) {
				BaiViet baiViet = new BaiViet();
				baiViet.setMaBaiViet(rs.getString(1));
				baiViet.setTieuDeViet(rs.getString(2));
				baiViet.setTenDanhMucViet(rs.getString(3));
				baiViet.setTenThanhVien(rs.getString(4));
				baiViet.setNgayVietBai(rs.getString(5));
				baiViet.setTenCongTacVien(rs.getString(6));
				baiViet.setTrangThai(rs.getString(7));
				danhSachBaiViet.add(baiViet);
			}
			return danhSachBaiViet;
		} catch (SQLException e) {
			return null;
		} finally {
			closeConnection();
		}
	}

	/**
	 * Lấy danh sách bài viết theo trang thái
	 * 
	 * @param trangThai
	 * @return
	 */
	public ArrayList<BaiViet> danhSachBaiViet(String trangThai) {

		try {
			openConnection();
			String SQL = " SELECT BV.MaBaiViet, BV.TieuDeViet, DM.TenDanhMucViet, TV.TenThanhVien,"
					+ " BV.NgayVietBai, PC.TenThanhVien AS TenCongTacVien, BV.TrangThai"
					+ " FROM BAIVIET BV JOIN DANHMUC DM ON BV.MaDanhMuc = DM.MaDanhMuc"
					+ " JOIN THANHVIEN TV ON BV.MaThanhVien = TV.MaThanhVien" + " LEFT JOIN"
					+ " (SELECT PC.MaBaiViet, PC.MaThanhVien, TV.TenThanhVien"
					+ " FROM PHANCONGDICHBAI PC JOIN THANHVIEN TV ON TV.MaThanhVien = PC.MaThanhVien"
					+ " WHERE PC.TrangThai != 'Qua han' AND PC.TrangThai != 'Tu choi')"
					+ " AS PC ON BV.MaBaiViet = PC.MaBaiViet";
			if ("Chuadich".equals(trangThai)) {
				SQL = SQL.concat(" WHERE BV.TrangThai = N'Phan cong' OR BV.TrangThai = N'Dang dich'");
			} else {
				SQL = SQL.concat(" WHERE BV.TrangThai = N'" + trangThai + "'");
			}
			SQL = SQL.concat(" ORDER BY BV.NgayVietBai DESC");
			ArrayList<BaiViet> danhSachBaiViet = new ArrayList<BaiViet>();
			ResultSet rs = getStatement().executeQuery(SQL);
			while (rs.next()) {
				BaiViet baiViet = new BaiViet();
				baiViet.setMaBaiViet(rs.getString(1));
				baiViet.setTieuDeViet(rs.getString(2));
				baiViet.setTenDanhMucViet(rs.getString(3));
				baiViet.setTenThanhVien(rs.getString(4));
				baiViet.setNgayVietBai(rs.getString(5));
				baiViet.setTenCongTacVien(rs.getString(6));
				baiViet.setTrangThai(rs.getString(7));
				danhSachBaiViet.add(baiViet);
			}
			return danhSachBaiViet;
		} catch (SQLException e) {
			return null;
		} finally {
			closeConnection();
		}
	}

	/**
	 * Đếm tổng số lượng bài viết
	 * 
	 * @return int
	 */
	public int demTongSoBaiViet() {
		try {
			final String SQL = "SELECT MaBaiViet FROM BAIVIET";
			openConnection();
			int dem = 0;
			ResultSet rs = getStatement().executeQuery(SQL);
			while (rs.next()) {
				dem++;
			}
			return dem;
		} catch (SQLException e) {
			return 0;
		} finally {
			closeConnection();
		}
	}

	/**
	 * Đếm tổng số lượng bài viết đã đăng
	 * 
	 * @return int
	 */
	@SuppressWarnings("finally")
	public int demTongSoDaDang() {
		int dem = 0;
		try {
			final String SQL = "SELECT COUNT(TrangThai) AS TongSoDaDang" + " FROM BAIVIET "
					+ " WHERE TrangThai = N'Da dang'" + " GROUP BY TrangThai";
			openConnection();
			ResultSet rs = getStatement().executeQuery(SQL);
			while (rs.next()) {
				if (rs.getString(1) != null) {
					dem = Integer.parseInt(rs.getString(1));
				}
			}
		} catch (SQLException e) {
			return 0;
		} finally {
			closeConnection();
			return dem;
		}

	}

	/**
	 * Đếm tổng số lượng bài viết chưa dịch
	 * 
	 * @return int
	 */
	@SuppressWarnings("finally")
	public int demTongSoChuaDich() {
		int dem = 0;
		try {
			final String SQL = "SELECT SUM(TONG.TongSoDaDang) SoBaiChuaDich"
					+ " FROM (SELECT COUNT(TrangThai) AS TongSoDaDang"
					+ " FROM BAIVIET WHERE TrangThai = N'Phan cong' OR TrangThai = N'Dang dich'"
					+ " GROUP BY TrangThai) AS TONG";
			openConnection();
			ResultSet rs = getStatement().executeQuery(SQL);
			while (rs.next()) {
				if (rs.getString(1) != null) {
					dem = Integer.parseInt(rs.getString(1));
				}
			}

		} catch (SQLException e) {
			return 0;
		} finally {
			closeConnection();
			return dem;
		}
	}

	/**
	 * Đếm tổng số lượng bài viết mới
	 * 
	 * @return int
	 */
	@SuppressWarnings("finally")
	public int demTongSoBaiMoi() {
		int dem = 0;
		try {
			final String SQL = "SELECT COUNT(TrangThai) AS TongSoDaDang" + " FROM BAIVIET WHERE TrangThai = N'Bai moi'"
					+ " GROUP BY TrangThai";
			openConnection();

			ResultSet rs = getStatement().executeQuery(SQL);
			while (rs.next()) {
				if (rs.getString(1) != null) {
					dem = Integer.parseInt(rs.getString(1));
				}
			}

		} catch (SQLException e) {
			return 0;
		} finally {
			closeConnection();
			return dem;
		}
	}

	/**
	 * Đếm tổng số lượng bài viết dich xong
	 * 
	 * @return int
	 */
	@SuppressWarnings("finally")
	public int demTongSoDichXong() {
		int dem = 0;
		try {
			final String SQL = "SELECT COUNT(TrangThai) AS TongSoDaDang"
					+ " FROM BAIVIET WHERE TrangThai = N'Dich xong'" + " GROUP BY TrangThai";
			openConnection();

			ResultSet rs = getStatement().executeQuery(SQL);
			while (rs.next()) {
				if (rs.getString(1) != null) {
					dem = Integer.parseInt(rs.getString(1));
				}
			}

		} catch (SQLException e) {
			return 0;
		} finally {
			closeConnection();
			return dem;
		}
	}

	/**
	 * Lâý thông tin bài viết theo mã bài viết
	 * 
	 * @param maBaiViet
	 * @return thông tin của bài viết
	 */
	public BaiViet thongTinBaiViet(String maBaiViet) {

		try {
			final String SQL = "SELECT BV.MaBaiViet, BV.TieuDeViet, BV.TieuDeNhat,"
					+ " BV.MoTaViet, BV.MoTaNhat, BV.NoiDungViet, BV.NoiDungNhat,"
					+ " DM.TenDanhMucViet, DM.TenDanhMucNhat, TV.TenThanhVien AS TenNguoiViet,"
					+ " BV.NgayVietBai, PC.TenThanhVien AS TenCongTacVien, BV.TrangThai, BV.LuotXem, BV.Anh, "
					+ " (CASE  WHEN  (SAOTB.SoSao IS NULL)   THEN '0'  ELSE SAOTB.SoSao  END) AS SoSaoTB, DM.MaDanhMuc, SOTHICH.SoThich"
					+ " FROM BAIVIET BV JOIN DANHMUC DM ON BV.MaDanhMuc = DM.MaDanhMuc"
					+ " JOIN THANHVIEN TV ON BV.MaThanhVien = TV.MaThanhVien" + " LEFT JOIN"
					+ " (SELECT PC.MaBaiViet, PC.MaThanhVien, TV.TenThanhVien"
					+ " FROM PHANCONGDICHBAI PC JOIN THANHVIEN TV ON TV.MaThanhVien = PC.MaThanhVien"
					+ " WHERE PC.TrangThai != 'Qua han' AND PC.TrangThai != 'Tu choi')"
					+ " AS PC ON BV.MaBaiViet = PC.MaBaiViet" + " JOIN" + " (SELECT BV.MaBaiViet,  AVG(SoSao)AS  SoSao"
					+ " FROM BAIVIET BV LEFT JOIN DANHGIA DG ON BV.MaBaiViet = DG.MaBaiViet"
					+ " GROUP BY BV.MaBaiViet)  AS SAOTB ON BV.MaBaiViet = SAOTB.MaBaiViet" + " JOIN"
					+ " (SELECT BV.MaBaiViet,  (CASE  WHEN  (SOLIKE.soLike IS NULL)   THEN '0'  ELSE SOLIKE.soLike  END) AS SoThich"
					+ " FROM BAIVIET BV LEFT JOIN (SELECT DG.MaBaiViet,  COUNT(DG.MaBaiViet) AS  SoLike FROM DANHGIA DG"
					+ " WHERE DG.Thich = 'True'"
					+ " GROUP BY DG.MaBaiViet) AS SOLIKE ON BV.MaBaiViet = SOLIKE.MaBaiViet ) AS SOTHICH ON BV.MaBaiViet = SOTHICH.MaBaiViet"
					+ " WHERE BV.MaBaiViet = '" + maBaiViet + "'";
			openConnection();
			ResultSet rs = getStatement().executeQuery(SQL);
			BaiViet baiViet = new BaiViet();
			while (rs.next()) {
				baiViet.setMaBaiViet(rs.getString(1));
				baiViet.setTieuDeViet(rs.getString(2));
				baiViet.setTieuDeNhat(rs.getString(3));
				baiViet.setMoTaViet(rs.getString(4));
				baiViet.setMoTaNhat(rs.getString(5));
				baiViet.setNoiDungViet(rs.getString(6));
				baiViet.setNoiDungNhat(rs.getString(7));
				baiViet.setTenDanhMucViet(rs.getString(8));
				baiViet.setTenDanhMucNhat(rs.getString(9));
				baiViet.setTenThanhVien(rs.getString(10));
				baiViet.setNgayVietBai(rs.getString(11));
				baiViet.setTenCongTacVien(rs.getString(12));
				baiViet.setTrangThai(rs.getString(13));
				if (rs.getString(14) == null) {
					baiViet.setLuotXem(0);
				} else {
					baiViet.setLuotXem(Integer.parseInt(rs.getString(14)));
				}
				baiViet.setAnh(rs.getString(15));
				baiViet.setSoSao(Integer.parseInt(rs.getString(16)));
				baiViet.setMaDanhMuc(rs.getString(17));
				baiViet.setSoThich(rs.getInt(18));
			}
			return baiViet;
		} catch (SQLException e) {
			return null;
		} finally {
			closeConnection();
		}

	}

	/**
	 * Xóa bài viết
	 * 
	 * @param maBaiViet
	 * @return
	 */
	@SuppressWarnings("finally")
	public boolean xoaBaiViet(String maBaiViet) {
		boolean is = false;
		try {
			openConnection();
			final String SQL1 = "DELETE DANHGIA WHERE MaBaiViet = '" + maBaiViet + "'";
			final String SQL2 = "DELETE BINHLUAN WHERE MaBaiViet = '" + maBaiViet + "'";
			final String SQL3 = "DELETE PHANCONGDICHBAI WHERE MaBaiViet = '" + maBaiViet + "'";
			final String SQL4 = "DELETE BAIVIET WHERE MaBaiViet = '" + maBaiViet + "'";
			getStatement().executeUpdate(SQL1);
			getStatement().executeUpdate(SQL2);
			getStatement().executeUpdate(SQL3);
			getStatement().executeUpdate(SQL4);
			is = true;
		} catch (SQLException e) {
			is = false;
		} finally {
			closeConnection();
			return is;
		}
	}

	/**
	 * Cập nhật bài viết chưa dịcn
	 * 
	 * @param baiViet
	 * @return
	 */
	public boolean capNhatBaiVietChuaDich(BaiViet baiViet) {
		try {
			openConnection();
			final String SQL = String.format(
					"UPDATE BAIVIET SET TieuDeViet = N'%s', MoTaViet = N'%s', NoiDungViet = N'%s' "
							+ " WHERE MaBaiViet = '%s'",
					baiViet.getTieuDeViet(), baiViet.getMoTaViet(), baiViet.getNoiDungViet(), baiViet.getMaBaiViet());
			getStatement().executeUpdate(SQL);
			return true;
		} catch (SQLException e) {
			return false;
		} finally {
			closeConnection();
		}
	}

	/**
	 * Cập nhật bài viết đã được dịch
	 * 
	 * @param baiViet
	 * @return
	 */
	public boolean capNhatBaiVietDaDich(BaiViet baiViet) {
		try {
			openConnection();
			final String SQL = String.format(
					"UPDATE BAIVIET SET TieuDeViet = N'%s', TieuDeNhat = N'%s', MoTaViet = N'%s', MoTaNhat = N'%s', NoiDungViet = N'%s', NoiDungNhat = N'%s' "
							+ " WHERE MaBaiViet = '%s'",
					baiViet.getTieuDeViet(), baiViet.getTieuDeNhat(), baiViet.getMoTaViet(), baiViet.getMoTaNhat(),
					baiViet.getNoiDungViet(), baiViet.getNoiDungNhat(), baiViet.getMaBaiViet());
			getStatement().executeUpdate(SQL);
			return true;
		} catch (SQLException e) {
			return false;
		} finally {
			closeConnection();
		}
	}

	/**
	 * Lấy thống kê số sao của bài viết
	 * 
	 * @param maBaiViet
	 * @return
	 */
	public BaiViet layThongKeSaoBaiViet(String maBaiViet) {

		try {
			openConnection();
			final String SQL = "SELECT BV.MaBaiViet, "
					+ " (CASE  WHEN  (SAO1.Sao1 IS NULL)   THEN '0'  ELSE SAO1.Sao1  END) AS Sao1,"
					+ " (CASE  WHEN  (SAO2.Sao2 IS NULL)   THEN '0'  ELSE SAO2.Sao2  END) AS Sao2,"
					+ " (CASE  WHEN  (SAO3.Sao3 IS NULL)   THEN '0'  ELSE SAO3.Sao3  END) AS Sao3,"
					+ " (CASE  WHEN  (SAO4.Sao4 IS NULL)   THEN '0'  ELSE SAO4.Sao4  END) AS Sao4,"
					+ " (CASE  WHEN  (SAO5.Sao5 IS NULL)   THEN '0'  ELSE SAO5.Sao5  END) AS Sao5" + " FROM BAIVIET BV"
					+ " LEFT JOIN" + " (SELECT BV.MaBaiViet, COUNT(DG.SoSao) AS Sao1"
					+ " FROM BAIVIET BV JOIN DANHGIA DG ON BV.MaBaiViet = DG.MaBaiViet" + " WHERE DG.SoSao = 1"
					+ " GROUP BY BV.MaBaiViet) AS SAO1 ON BV.MaBaiViet = SAO1.MaBaiViet" + " LEFT JOIN"
					+ " (SELECT BV.MaBaiViet, COUNT(DG.SoSao) AS Sao2"
					+ " FROM BAIVIET BV JOIN DANHGIA DG ON BV.MaBaiViet = DG.MaBaiViet" + " WHERE DG.SoSao = 2"
					+ " GROUP BY BV.MaBaiViet) AS SAO2 ON BV.MaBaiViet = SAO2.MaBaiViet" + " LEFT JOIN"
					+ " (SELECT BV.MaBaiViet, COUNT(DG.SoSao) AS Sao3"
					+ " FROM BAIVIET BV JOIN DANHGIA DG ON BV.MaBaiViet = DG.MaBaiViet" + " WHERE DG.SoSao = 3"
					+ " GROUP BY BV.MaBaiViet) AS SAO3 ON BV.MaBaiViet = SAO3.MaBaiViet" + " LEFT JOIN"
					+ " (SELECT BV.MaBaiViet, COUNT(DG.SoSao) AS Sao4"
					+ " FROM BAIVIET BV JOIN DANHGIA DG ON BV.MaBaiViet = DG.MaBaiViet" + " WHERE DG.SoSao = 4"
					+ " GROUP BY BV.MaBaiViet) AS SAO4 ON BV.MaBaiViet = SAO4.MaBaiViet" + " LEFT JOIN"
					+ " (SELECT BV.MaBaiViet, COUNT(DG.SoSao) AS Sao5"
					+ " FROM BAIVIET BV JOIN DANHGIA DG ON BV.MaBaiViet = DG.MaBaiViet" + " WHERE DG.SoSao = 5"
					+ " GROUP BY BV.MaBaiViet) AS SAO5 ON BV.MaBaiViet = SAO5.MaBaiViet" + " WHERE BV.MaBaiViet = '"
					+ maBaiViet + "'";
			ResultSet rs = getStatement().executeQuery(SQL);
			BaiViet baiViet = new BaiViet();
			while (rs.next()) {
				baiViet.setSoSao1(rs.getInt(2));
				baiViet.setSoSao2(rs.getInt(3));
				baiViet.setSoSao3(rs.getInt(4));
				baiViet.setSoSao4(rs.getInt(5));
				baiViet.setSoSao5(rs.getInt(6));
			}
			return baiViet;
		} catch (SQLException e) {
			return null;
		} finally {
			closeConnection();
		}
	}

	/**
	 * Tăng lượt xem của bài viết
	 * 
	 * @param maBaiViet
	 * @return
	 */
	public boolean tangLuotXemBaiViet(String maBaiViet) {

		try {
			openConnection();
			final String SQL = String.format("UPDATE BAIVIET SET LuotXem = LuotXem + 1 WHERE MaBaiViet = '%s'",
					maBaiViet);
			getStatement().executeUpdate(SQL);
			return true;
		} catch (SQLException e) {
			return false;
		} finally {
			closeConnection();
		}
	}

	/*-------------------------------------------------------------------------------------------------*/
	/**
	 * Lấy danh sác phân công dich bài của cộng tác viên theo chiều giảm
	 * dần của ngày phân công
	 * 
	 * @param maThanhVien
	 * @return
	 */
	public ArrayList<BaiViet> layDanhSachBaiVietChuaDuyet(String maThanhVien) {
		try {
			openConnection();
			final String SQL = "SELECT BV.MaBaiViet, BV.MoTaViet, DM.TenDanhMucViet, TV.MaThanhVien, TV.TenThanhVien, PC.NgayPhanCong, BV.tieuDeViet, "
					+ " PC.SoNgayDichbai, PC.NgayChapNhan,BV.NoiDungViet,BV.TieuDeNhat,BV.MoTaNhat,BV.NoiDungNhat"
					+ " FROM BAIVIET BV JOIN DANHMUC DM ON BV.MaDanhMuc = DM.MaDanhMuc"
					+ " JOIN PHANCONGDICHBAI PC ON BV.MaBaiViet = PC.MaBaiViet"
					+ " JOIN THANHVIEN TV ON PC.MaThanhVien = TV.MaThanhVien" + " WHERE PC.MaThanhVien='" + maThanhVien
					+ "' AND PC.TrangThai=N'Phan cong'" + " ORDER BY PC.NgayPhanCong DESC";
			ArrayList<BaiViet> danhSachBaiViet = new ArrayList<BaiViet>();
			ResultSet rs = getStatement().executeQuery(SQL);
			while (rs.next()) {
				BaiViet baiViet = new BaiViet();
				baiViet.setMaBaiViet(rs.getString(1));
				baiViet.setMoTaViet(rs.getString(2));
				baiViet.setTenDanhMucViet(rs.getString(3));
				baiViet.setMaThanhVien(rs.getString(4));
				baiViet.setNgayPhanCong(rs.getString(6));
				baiViet.setNgayHanNhanBai(congNgay(rs.getString(6), 3));
				baiViet.setTieuDeViet(rs.getString(7));
				baiViet.setNoiDungViet(rs.getString(10));
				baiViet.setTieuDeNhat(rs.getString(11));
				baiViet.setMoTaNhat(rs.getString(12));
				baiViet.setNoiDungNhat(rs.getString(13));
				danhSachBaiViet.add(baiViet);
			}
			return danhSachBaiViet;
		} catch (SQLException e) {
			System.out.println(e);
			return null;
		} finally {
			closeConnection();
		}
	}

	/**
	 * Lấy danh sách phân công dich bài của cộng tác viên đã nhận dịch
	 * theo chiều giảm dần của ngày phân công
	 * 
	 * @param maThanhVien
	 * @return
	 */
	public ArrayList<BaiViet> layDanhSachBaiVietNhanDich(String maThanhVien) {
		try {
			openConnection();
			final String SQL = "SELECT BV.MaBaiViet, BV.MoTaViet, DM.TenDanhMucViet, TV.MaThanhVien, TV.TenThanhVien, PC.NgayPhanCong, BV.tieuDeViet, PC.SoNgayDichbai, PC.NgayChapNhan, BV.NoiDungViet,BV.TieuDeNhat,BV.MoTaNhat,BV.NoiDungNhat"
					+ " FROM BAIVIET BV JOIN DANHMUC DM ON BV.MaDanhMuc = DM.MaDanhMuc"
					+ " JOIN PHANCONGDICHBAI PC ON BV.MaBaiViet = PC.MaBaiViet"
					+ " JOIN THANHVIEN TV ON PC.MaThanhVien = TV.MaThanhVien" + " WHERE (PC.MaThanhVien='" + maThanhVien
					+ "' and PC.TrangThai='Dang dich') or (PC.MaThanhVien='" + maThanhVien
					+ "' and PC.TrangThai='Dich xong')" + " ORDER BY PC.NgayPhanCong DESC";
			ArrayList<BaiViet> danhSachBaiViet = new ArrayList<BaiViet>();
			ResultSet rs = getStatement().executeQuery(SQL);
			while (rs.next()) {
				BaiViet baiViet = new BaiViet();
				baiViet.setMaBaiViet(rs.getString(1));
				baiViet.setMoTaViet(rs.getString(2));
				baiViet.setTenDanhMucViet(rs.getString(3));
				baiViet.setMaThanhVien(rs.getString(4));
				baiViet.setNgayPhanCong(rs.getString(6));
				baiViet.setNgayHanNhanBai(congNgay(rs.getString(6), 3));
				baiViet.setTieuDeViet(rs.getString(7));
				baiViet.setNgayChapNhan(rs.getString(9));
				baiViet.setNgayHanDichBai(congNgay(rs.getString(9), rs.getInt(8)));
				baiViet.setNoiDungViet(rs.getString(10));
				baiViet.setTieuDeNhat(rs.getString(11));
				baiViet.setMoTaNhat(rs.getString(12));
				baiViet.setNoiDungNhat(rs.getString(13));
				danhSachBaiViet.add(baiViet);
			}
			return danhSachBaiViet;
		} catch (SQLException e) {
			System.out.println(e);
			return null;
		} finally {
			closeConnection();
		}
	}

	/**
	 * Cộng ngày
	 * 
	 * @param ngay
	 * @param soNgayCong
	 * @return
	 */
	private static String congNgay(String ngay, int soNgayCong) {
		if (ngay == null) {
			return null;
		} else {
			SimpleDateFormat formatDate = new SimpleDateFormat("yyyy-MM-dd");
			try {
				Date dateChapNhan = formatDate.parse(ngay);
				Calendar calendar = Calendar.getInstance();
				calendar.setTime(dateChapNhan);
				calendar.add(Calendar.DATE, soNgayCong);

				return formatDate.format(calendar.getTime());
			} catch (Exception e) {
				return null;

			}
		}
	}

	public boolean capNhatTrangThai(String trangThai, String maBaiViet) {
		// TODO Auto-generated method stub
		try {
			String sql = String.format("UPDATE PHANCONGDICHBAI SET TrangThai = '%s' where MaBaiViet='%s'", trangThai,
					maBaiViet);
			openConnection();
			getStatement().executeUpdate(sql);
			System.out.println("cap nhat thanh cong");
			return true;
		} catch (SQLException e) {
			System.out.println("cap nhat that bai");
			return false;
		} finally {
			closeConnection();
		}
	}

	public boolean capNhatBaiDich(String maBaiViet, String tieuDeNhat, String moTaNhat, String noiDungNhat) {
		// TODO Auto-generated method stub
		try {
			String sql = String.format(
					"UPDATE BAIVIET SET TieuDeNhat = N'%s', MoTaNhat = N'%s', NoiDungNhat = N'%s' where MaBaiViet='%s'",
					tieuDeNhat, moTaNhat, noiDungNhat, maBaiViet);
			openConnection();
			getStatement().executeUpdate(sql);
			System.out.println("cap nhat bai viet thanh cong");
			return true;
		} catch (SQLException e) {
			System.out.println("cap nhat bai viet that bai");
			return false;
		} finally {
			closeConnection();
		}
	}

	public boolean themBinhLuan(String maBaiViet, String maThanhVien, String noiDungBinhLuan, String ngayGioHienTai,
			boolean trangThai) {
		// TODO Auto-generated method stub

		try {
			String sql = String.format("INSERT INTO BINHLUAN VALUES( N'%s', N'%s',N'%s',N'%s',N'%s')", maThanhVien,
					maBaiViet, ngayGioHienTai, trangThai, noiDungBinhLuan);
			openConnection();
			getStatement().executeUpdate(sql);
			System.out.println(sql);
			System.out.println("them binh luan thanh cong");
			return true;
		} catch (SQLException e) {
			System.out.println(e);
			System.out.println("them binh luan that bai");
			return false;
		} finally {
			closeConnection();
		}
	}

	public boolean themBaiViet(String maBaiViet, String maThanhVien, String tieuDeViet, String moTaViet,
			String noiDungViet, String anh, String ngayGioHienTai, String maDanhMuc) {
		// TODO Auto-generated method stub
		// maBaiViet = tangMa();
		try {
			String sql = String.format("INSERT INTO BAIVIET( MaBaiViet, MaThanhVien,TieuDeViet,"
					+ "MotaViet,NoiDungViet,Anh,NgayVietBai,TrangThai,"
					+ "maDanhMuc, LuotXem) VALUES (N'%s',N'%s',N'%s'," + "N'%s',N'%s',N'%s',N'%s','Bai moi',N'%s', 0)",
					maBaiViet, maThanhVien, tieuDeViet, moTaViet, noiDungViet, anh, ngayGioHienTai, maDanhMuc);
			openConnection();
			getStatement().executeUpdate(sql);
			return true;
		} catch (SQLException e) {
			System.out.println(e);
			System.out.println("them bai vien that bai");
			return false;
		} finally {
			closeConnection();
		}
	}

	/**
	 * Xóa bài viết
	 * 
	 * @param maBaiViet
	 * @return
	 */

	public String tangMa() {
		try {
			final String sql = "SELECT TOP 1 MaBaiViet From BAIVIET ORDER BY MaBaiViet DESC";
			openConnection();
			ResultSet rs = getStatement().executeQuery(sql);
			String maBaiViet = "";
			while (rs.next()) {
				maBaiViet = rs.getString(1);
			}
			if ("".equals(maBaiViet)) {
				return "BV00000001";
			} else {
				Long maMoi = Long.parseLong(maBaiViet.substring(2, 10).trim()) + 1;
				return String.format("BV%0" + 8 + "d", maMoi);
			}
		} catch (Exception e) {
			return null;
		} finally {
			closeConnection();
		}
	}

	public boolean capNhatBaiViet(String maBaiViet, String tieuDeViet, String moTaViet, String noiDungViet, String anh,
			String maDanhMuc) {
		// TODO Auto-generated method stub
		try {
			String sql = String.format(
					"UPDATE BAIVIET SET TieuDeViet = N'%s', MoTaViet = N'%s', NoiDungViet = N'%s', Anh = N'%s', maDanhMuc = N'%s' where MaBaiViet='%s'",
					tieuDeViet, moTaViet, noiDungViet, anh, maDanhMuc, maBaiViet);
			openConnection();
			getStatement().executeUpdate(sql);
			System.out.println("cap nhat bai viet thanh cong");
			return true;
		} catch (SQLException e) {
			System.out.println("cap nhat bai viet that bai");
			return false;
		} finally {
			closeConnection();
		}
	}

	/**
	 * lấy danh sách bài viết theo danh mục
	 */

	public ArrayList<BaiViet> danhSachBaiVietTheoDanhMuc(String maDanhMuc) {
		ArrayList<BaiViet> danhSachBaiViet = new ArrayList<BaiViet>();
		try {
			final String SQL = "SELECT BV.MaBaiViet, BV.TieuDeViet, BV.TieuDeNhat,"
					+ " BV.MoTaViet, BV.MoTaNhat, BV.NoiDungViet, BV.NoiDungNhat,"
					+ " DM.TenDanhMucViet, DM.TenDanhMucNhat, TV.TenThanhVien AS TenNguoiViet,"
					+ " BV.NgayVietBai, PC.TenThanhVien AS TenCongTacVien, BV.TrangThai, BV.LuotXem, BV.Anh, SAOTB.SoSao"
					+ " FROM BAIVIET BV JOIN DANHMUC DM ON BV.MaDanhMuc = DM.MaDanhMuc"
					+ " JOIN THANHVIEN TV ON BV.MaThanhVien = TV.MaThanhVien" + " LEFT JOIN"
					+ " (SELECT PC.MaBaiViet, PC.MaThanhVien, TV.TenThanhVien"
					+ " FROM PHANCONGDICHBAI PC JOIN THANHVIEN TV ON TV.MaThanhVien = PC.MaThanhVien"
					+ " WHERE PC.TrangThai != 'Qua han' AND PC.TrangThai != 'Tu choi')"
					+ " AS PC ON BV.MaBaiViet = PC.MaBaiViet" + " JOIN (SELECT BV.MaBaiViet,  AVG(SoSao)AS  SoSao"
					+ " FROM BAIVIET BV LEFT JOIN DANHGIA DG ON BV.MaBaiViet = DG.MaBaiViet"
					+ " GROUP BY BV.MaBaiViet)  AS SAOTB ON BV.MaBaiViet = SAOTB.MaBaiViet" + " WHERE BV.MaDanhMuc='"
					+ maDanhMuc + "' and BV.TrangThai='Da dang'";
			openConnection();
			ResultSet rs = getStatement().executeQuery(SQL);
			BaiViet baiViet;
			while (rs.next()) {
				baiViet = new BaiViet();
				baiViet.setMaBaiViet(rs.getString(1));
				baiViet.setTieuDeViet(rs.getString(2));
				baiViet.setTieuDeNhat(rs.getString(3));
				baiViet.setMoTaViet(rs.getString(4));
				baiViet.setMoTaNhat(rs.getString(5));
				baiViet.setNoiDungViet(rs.getString(6));
				baiViet.setNoiDungNhat(rs.getString(7));
				baiViet.setTenDanhMucViet(rs.getString(8));
				baiViet.setTenDanhMucNhat(rs.getString(9));
				baiViet.setTenThanhVien(rs.getString(10));
				baiViet.setNgayVietBai(rs.getString(11));
				baiViet.setTenCongTacVien(rs.getString(12));
				baiViet.setTrangThai(rs.getString(13));
				if (rs.getString(14) == null) {
					baiViet.setLuotXem(0);
				} else {
					baiViet.setLuotXem(Integer.parseInt(rs.getString(14)));
				}
				baiViet.setAnh(rs.getString(15));
				if (rs.getString(16) == null) {
					baiViet.setSoSao(0);
				} else {
					baiViet.setSoSao(Integer.parseInt(rs.getString(16)));
				}
				danhSachBaiViet.add(baiViet);
			}
			return danhSachBaiViet;
		} catch (SQLException e) {
			return null;
		} finally {
			closeConnection();
		}

	}

	public ArrayList<ArrayList<BaiViet>> danhSachBaiVietMoiNhat() {
		ArrayList<BaiViet> danhSachBaiViet = new ArrayList<BaiViet>();
		try {
			String sql = "select top 6 bv.MaBaiViet, bv.TieuDeViet, bv.TieuDeNhat, bv.MoTaViet, bv.MoTaNhat, bv.NgayVietBai, bv.Anh, tv.TenThanhVien"
					+ " from baiviet bv join thanhvien tv on bv.MaThanhVien = tv.MaThanhVien"
					+ " where bv.TrangThai = 'Da dang' " + " order by bv.NgayVietBai desc";
			openConnection();
			ResultSet rs = getStatement().executeQuery(sql);
			while (rs.next()) {
				BaiViet baiViet = new BaiViet();
				baiViet.setMaBaiViet(rs.getString(1));
				baiViet.setTieuDeViet(rs.getString(2));
				baiViet.setTieuDeNhat(rs.getString(3));
				baiViet.setMoTaViet(rs.getString(4));
				baiViet.setMoTaNhat(rs.getString(5));
				baiViet.setNgayVietBai(rs.getString(6));
				baiViet.setAnh(rs.getString(7));
				baiViet.setTenThanhVien(rs.getString(8));

				danhSachBaiViet.add(baiViet);
			}
			System.out.println("danh sach bai" + danhSachBaiViet.size());
			return chiaDanhSachCon(danhSachBaiViet, 2);
		} catch (Exception e) {
			return null;
		} finally {
			closeConnection();
		}
	}

	public ArrayList<ArrayList<BaiViet>> chiaDanhSachCon(ArrayList<BaiViet> danhSachCha, int soBai) {
		ArrayList<ArrayList<BaiViet>> danhSachDaChia = new ArrayList<ArrayList<BaiViet>>();
		ArrayList<BaiViet> danhSachCon = new ArrayList<BaiViet>();
		for (int i = 0; i < danhSachCha.size(); i++) {
			if (danhSachCon.size() == soBai) {
				danhSachDaChia.add(danhSachCon);
				danhSachCon = new ArrayList<BaiViet>();
			}
			danhSachCon.add(danhSachCha.get(i));
		}
		danhSachDaChia.add(danhSachCon);
		return danhSachDaChia;
	}

	public ArrayList<BaiViet> layDanhSachBaiVietTimKiem(String noiDungTimKiem) {
		try {
			openConnection();
			String sql = "select bv.MaBaiViet, bv.TieuDeViet, bv.TieuDeNhat, bv.MoTaViet, bv.MoTaNhat, "
					+ " dm.TenDanhMucViet, dm.TenDanhMucNhat, tv.TenThanhVien, bv.NgayVietBai, bv.Anh  "
					+ " from BAIVIET bv join ThanhVien tv on (bv.MaThanhVien = tv.MaThanhVien)"
					+ " join DANHMUC dm on (bv.MaDanhMuc=dm.MaDanhMuc)" + " where ((bv.TieuDeNhat like N'%"
					+ noiDungTimKiem + "%') or (bv.TieuDeViet like N'%" + noiDungTimKiem + "%') "
					+ " or (bv.MoTaViet like N'%" + noiDungTimKiem + "%') or (bv.MoTaNhat like N'%" + noiDungTimKiem
					+ "%') or (bv.NoiDungNhat like N'%" + noiDungTimKiem + "%')" + " or (bv.NoiDungViet like N'%"
					+ noiDungTimKiem + "%') or (tv.TenThanhVien like N'%" + noiDungTimKiem + "%')"
					+ " or (dm.TenDanhMucViet like N'%" + noiDungTimKiem + "%') or (dm.TenDanhMucNhat like N'%"
					+ noiDungTimKiem + "%')) and (bv.TrangThai='Da dang')";

			System.out.println("sql=" + sql);

			ResultSet rs = getStatement().executeQuery(sql);
			ArrayList<BaiViet> danhSachBaiVietTimKiem = new ArrayList<BaiViet>();
			while (rs.next()) {
				BaiViet baiViet = new BaiViet();
				baiViet.setMaBaiViet(rs.getString(1));
				baiViet.setTieuDeViet(rs.getString(2));
				baiViet.setTieuDeNhat(rs.getString(3));
				baiViet.setMoTaViet(rs.getString(4));
				baiViet.setMoTaNhat(rs.getString(5));
				baiViet.setTenDanhMucViet(rs.getString(6));
				baiViet.setTenDanhMucNhat(rs.getString(7));
				baiViet.setTenThanhVien(rs.getString(8));
				baiViet.setNgayVietBai(rs.getString(9));
				baiViet.setAnh(rs.getString(10));
				danhSachBaiVietTimKiem.add(baiViet);
			}
			return danhSachBaiVietTimKiem;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

}
