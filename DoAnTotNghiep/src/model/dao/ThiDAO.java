package model.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.bean.CauHoi;
import model.bean.LichSu;
import model.bean.PhuongAn;

public class ThiDAO extends ConnectDAO {

	public ArrayList<PhuongAn> getListPhuongAn(String maCauHoi) {

		ArrayList<PhuongAn> listPhuongAn = new ArrayList<PhuongAn>();
		PhuongAn phuongAn;
		openConnection();

		String sql = "SELECT * FROM PHUONGAN WHERE MaCauHoi='" + maCauHoi + "'";
		System.out.println(sql);
		ResultSet rs1 = null;
		try {
			rs1 = getStatement().executeQuery(sql);
			while (rs1.next()) {
				phuongAn = new PhuongAn();
				phuongAn.setMaCauHoi(rs1.getString("MaCauHoi"));
				phuongAn.setMaPhuongAn(rs1.getString("MaPhuongAn"));
				phuongAn.setNoiDungPA(rs1.getString("NoiDung"));
				phuongAn.setHinhAnh(rs1.getString("HinhAnh"));
				phuongAn.setTrangThai(rs1.getString("TrangThai"));
				listPhuongAn.add(phuongAn);
			}
			return listPhuongAn;

		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		} finally {
			closeConnection();
		}
	}

	public ArrayList<CauHoi> getListCauHoi(String maChuong) {

		ArrayList<CauHoi> listCauHoi = new ArrayList<CauHoi>();
		CauHoi cauHoi;
		ArrayList<PhuongAn> listPhuongAn = null;
		openConnection();
		String sql = "SELECT * FROM CAUHOI WHERE MaChuong='" + maChuong + "'";
		ResultSet rs = null;
		try {
			rs = getStatement().executeQuery(sql);

			while (rs.next()) {
				cauHoi = new CauHoi();
				cauHoi.setMaCauHoi(rs.getString("MaCauHoi"));
				cauHoi.setMaCapDo(rs.getString("MaCapDo"));
				cauHoi.setNoiDung(rs.getString("NoiDung"));
				cauHoi.setHinhAnh(rs.getString("HinhAnh"));
				listPhuongAn = getListPhuongAn(cauHoi.getMaCauHoi());
				cauHoi.setListPhuongAn(listPhuongAn);
				listCauHoi.add(cauHoi);
			}
			return listCauHoi;

		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		} finally {
			closeConnection();
		}

	}

	public void setLichSu(LichSu lichSu) {
		openConnection();
		String sql = "INSERT INTO LICHSUTHI VALUES('" + lichSu.getTenTaiKhoan() + "',"
				+ " GETDATE(),'" + lichSu.getDiem() + "')";
		System.out.println(sql);
		try {
			getStatement().executeUpdate(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeConnection();
		}
	}
}
