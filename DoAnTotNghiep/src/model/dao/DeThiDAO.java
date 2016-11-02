package model.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.bean.BaiThi;

public class DeThiDAO extends ConnectDAO {

	public ArrayList<BaiThi> listDeThi() {
		openConnection();
		ArrayList<BaiThi> listBaiThi = new ArrayList<BaiThi>();
		final String SQL = "SELECT * FROM DETHI INNER JOIN CAPDO ON DETHI.MaCapDo=CAPDO.MaCapDo";
		try {
			ResultSet rs = getStatement().executeQuery(SQL);
			BaiThi baiThi;
			int i = 1;
			while (rs.next()) {
				baiThi = new BaiThi();
				baiThi.setMaDe(rs.getString("MaDeThi"));
				baiThi.setCauHoi(rs.getString("CauHoi"));
				baiThi.setMaCapDo(rs.getString("MaCapDo"));
				baiThi.setTenDe(rs.getString("TenDeTHi"));
				baiThi.setTenCapDo(rs.getString("TenCapDo"));
				baiThi.setStt(i + "");
				i++;
				listBaiThi.add(baiThi);
			}
			return listBaiThi;
		} catch (SQLException e) {
			return null;
		} finally {
			closeConnection();
		}
	}

	public ArrayList<BaiThi> listDeThiByName(String search) {
		openConnection();
		ArrayList<BaiThi> listBaiThi = new ArrayList<BaiThi>();
		final String SQL = "SELECT * FROM DETHI " + "INNER JOIN CAPDO " + "ON DETHI.MaCapDo=CAPDO.MaCapDo "
				+ "WHERE TenDeThi COLLATE SQL_Latin1_General_Cp1_CI_AI like '%" + search
				+ "%' COLLATE SQL_Latin1_General_Cp1_CI_AI";
		try {
			ResultSet rs = getStatement().executeQuery(SQL);
			BaiThi baiThi;
			int i = 1;
			while (rs.next()) {
				baiThi = new BaiThi();
				baiThi.setMaDe(rs.getString("MaDeThi"));
				baiThi.setCauHoi(rs.getString("CauHoi"));
				baiThi.setMaCapDo(rs.getString("MaCapDo"));
				baiThi.setTenDe(rs.getString("TenDeTHi"));
				baiThi.setTenCapDo(rs.getString("TenCapDo"));
				baiThi.setStt(i + "");
				i++;
				listBaiThi.add(baiThi);
			}
			return listBaiThi;
		} catch (SQLException e) {
			return null;
		} finally {
			closeConnection();
		}
	}

	public BaiThi getDeThi(String maDe) {
		openConnection();
		final String SQL = "SELECT * FROM DETHI " + "INNER JOIN CAPDO " + "ON DETHI.MaCapDo=CAPDO.MaCapDo "
				+ "WHERE MaDeThi='" + maDe + "'";
		try {
			ResultSet rs = getStatement().executeQuery(SQL);
			BaiThi baiThi = new BaiThi();
			while (rs.next()) {
				baiThi.setMaDe(rs.getString("MaDeThi"));
				baiThi.setCauHoi(rs.getString("CauHoi"));
				baiThi.setMaCapDo(rs.getString("MaCapDo"));
				baiThi.setTenDe(rs.getString("TenDeTHi"));
				baiThi.setTenCapDo(rs.getString("TenCapDo"));
			}
			return baiThi;
		} catch (SQLException e) {
			return null;
		} finally {
			closeConnection();
		}
	}

	public ArrayList<BaiThi> listDeThiByNamePK(String search, String maCapDo) {
		openConnection();
		ArrayList<BaiThi> listBaiThi = new ArrayList<BaiThi>();
		final String SQL = "SELECT * FROM DETHI INNER JOIN CAPDO ON DETHI.MaCapDo=CAPDO.MaCapDo "
				+ "WHERE DETHI.MaCapDo='" + maCapDo + "' AND TenDeTHi COLLATE SQL_Latin1_General_Cp1_CI_AI like '%"
				+ search + "%' COLLATE SQL_Latin1_General_Cp1_CI_AI";
		try {
			ResultSet rs = getStatement().executeQuery(SQL);
			BaiThi baiThi;
			int i = 1;
			while (rs.next()) {
				baiThi = new BaiThi();
				baiThi.setMaDe(rs.getString("MaDeThi"));
				baiThi.setCauHoi(rs.getString("CauHoi"));
				baiThi.setMaCapDo(rs.getString("MaCapDo"));
				baiThi.setTenDe(rs.getString("TenDeTHi"));
				baiThi.setTenCapDo(rs.getString("TenCapDo"));
				baiThi.setStt(i + "");
				i++;
				listBaiThi.add(baiThi);
			}
			return listBaiThi;
		} catch (SQLException e) {
			return null;
		} finally {
			closeConnection();
		}
	}

	public ArrayList<BaiThi> listDeThiByCapDo(String maCapDo) {
		openConnection();
		ArrayList<BaiThi> listBaiThi = new ArrayList<BaiThi>();
		final String SQL = "SELECT * FROM DETHI INNER JOIN CAPDO ON DETHI.MaCapDo=CAPDO.MaCapDo "
				+ " WHERE DETHI.MaCapDo='" + maCapDo + "'";
		try {
			ResultSet rs = getStatement().executeQuery(SQL);
			BaiThi baiThi;
			int i = 1;
			while (rs.next()) {
				baiThi = new BaiThi();
				baiThi.setMaDe(rs.getString("MaDeThi"));
				baiThi.setCauHoi(rs.getString("CauHoi"));
				baiThi.setMaCapDo(rs.getString("MaCapDo"));
				baiThi.setTenDe(rs.getString("TenDeTHi"));
				baiThi.setTenCapDo(rs.getString("TenCapDo"));
				baiThi.setStt(i + "");
				i++;
				listBaiThi.add(baiThi);
			}
			return listBaiThi;
		} catch (SQLException e) {
			return null;
		} finally {
			closeConnection();
		}
	}

	public boolean themDeThi(BaiThi baiThi) {
		openConnection();
		String SQL = "INSERT INTO DETHI (MaCapDo,TenDeThi,CauHoi) " + "values ('"
				+ baiThi.getMaCapDo() + "',N'" + baiThi.getTenDe() + "','" + baiThi.getCauHoi() + "')";
		try {
			getStatement().executeUpdate(SQL);
			return true;
		} catch (SQLException e) {
			return false;
		} finally {
			closeConnection();
		}
	}

	/**
	 * xóa de thi
	 */
	public boolean xoaDeThi(String maDe) {
		openConnection();
		String SQL = "DELETE FROM DETHI WHERE MaDeThi=" + maDe;
		try {
			getStatement().executeUpdate(SQL);
			return true;
		} catch (SQLException e) {
			return false;
		} finally {
			closeConnection();
		}
	}

	/**
	 * sua de thi
	 */
	public boolean updateDeThi(BaiThi baiThi) {
		openConnection();
		String SQL = "UPDATE BAIHOC SET MaCapDo='" + baiThi.getMaCapDo() + "',TenDeThi=N'" + baiThi.getTenDe()
				+ "',CauHoi=N'" + baiThi.getCauHoi() + "'";
		try {
			getStatement().executeUpdate(SQL);
			return true;
		} catch (SQLException e) {
			return false;
		}
		finally {
			closeConnection();
		}
	}
}
