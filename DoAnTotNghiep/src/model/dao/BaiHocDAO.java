package model.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.bean.BaiHoc;

public class BaiHocDAO extends ConnectDAO {

	/**
	 * lấy danh sách bài học
	 * 
	 * @return list bài học
	 */
	public ArrayList<BaiHoc> listBaiHoc() {
		openConnection();
		ArrayList<BaiHoc> listBaiHoc = new ArrayList<BaiHoc>();
		final String SQL = "SELECT * FROM BAIHOC INNER JOIN CAPDO ON BAIHOC.MaCapDo=CAPDO.MaCapDo";
		try {
			ResultSet rs = getStatement().executeQuery(SQL);
			BaiHoc baihoc;
			int i = 1;
			while (rs.next()) {
				baihoc = new BaiHoc();
				baihoc.setMaBaiHoc(rs.getString("MaBaiHoc"));
				baihoc.setTenBaiHoc(rs.getString("TenBaiHoc"));
				baihoc.setMaCapDo(rs.getString("MaCapDo"));
				baihoc.setNghe(rs.getString("Nghe"));
				baihoc.setNguPhap(rs.getString("NguPhap"));
				baihoc.setSound(rs.getString("Sound"));
				baihoc.setTuVung(rs.getString("TuVung"));
				baihoc.setTenCapDo(rs.getString("TenCapDo"));
				baihoc.setStt(i + "");
				i++;
				listBaiHoc.add(baihoc);
			}
			return listBaiHoc;
		} catch (SQLException e) {
			return null;
		} finally {
			closeConnection();
		}
	}

	/**
	 * list bài học theo từ khóa
	 * 
	 * @return
	 */
	public ArrayList<BaiHoc> listBaiHocByName(String search) {
		openConnection();
		ArrayList<BaiHoc> listBaiHoc = new ArrayList<BaiHoc>();
		final String SQL = "SELECT * FROM BAIHOC " + "INNER JOIN CAPDO " + "ON BAIHOC.MaCapDo=CAPDO.MaCapDo "
				+ "WHERE TenBaiHoc COLLATE SQL_Latin1_General_Cp1_CI_AI like '%" + search
				+ "%' COLLATE SQL_Latin1_General_Cp1_CI_AI";
		System.out.println(SQL);
		try {
			ResultSet rs = getStatement().executeQuery(SQL);
			BaiHoc baihoc;
			int i = 1;
			while (rs.next()) {
				baihoc = new BaiHoc();
				baihoc.setMaBaiHoc(rs.getString("MaBaiHoc"));
				baihoc.setTenBaiHoc(rs.getString("TenBaiHoc"));
				baihoc.setMaCapDo(rs.getString("MaCapDo"));
				baihoc.setNghe(rs.getString("Nghe"));
				baihoc.setNguPhap(rs.getString("NguPhap"));
				baihoc.setSound(rs.getString("Sound"));
				baihoc.setTuVung(rs.getString("TuVung"));
				baihoc.setTenCapDo(rs.getString("TenCapDo"));
				baihoc.setStt(i + "");
				i++;
				listBaiHoc.add(baihoc);
			}
			return listBaiHoc;
		} catch (SQLException e) {
			return null;
		} finally {
			closeConnection();
		}
	}

	/**
	 * list bài học theo mã bài học
	 * 
	 * @return
	 */
	public BaiHoc getBaiHoc(String maBaiHoc) {
		openConnection();
		final String SQL = "SELECT * FROM BAIHOC " + "INNER JOIN CAPDO " + "ON BAIHOC.MaCapDo=CAPDO.MaCapDo "
				+ "WHERE MaBaiHoc =" + maBaiHoc;
		try {
			ResultSet rs = getStatement().executeQuery(SQL);
			BaiHoc baihoc = new BaiHoc();
			while (rs.next()) {
				baihoc.setMaBaiHoc(rs.getString("MaBaiHoc"));
				baihoc.setTenBaiHoc(rs.getString("TenBaiHoc"));
				baihoc.setMaCapDo(rs.getString("MaCapDo"));
				baihoc.setNghe(rs.getString("Nghe"));
				baihoc.setNguPhap(rs.getString("NguPhap"));
				baihoc.setSound(rs.getString("Sound"));
				baihoc.setTuVung(rs.getString("TuVung"));
				baihoc.setTenCapDo(rs.getString("TenCapDo"));
				baihoc.setMaCapDo(rs.getString("MaCapDo"));
			}
			return baihoc;
		} catch (SQLException e) {
			return null;
		} finally {
			closeConnection();
		}
	}

	/**
	 * list bài học theo từ khóa
	 * 
	 * @return
	 */
	public ArrayList<BaiHoc> listBaiHocByNamePK(String search, String maCapDo) {
		openConnection();
		ArrayList<BaiHoc> listBaiHoc = new ArrayList<BaiHoc>();
		final String SQL = "SELECT * FROM BAIHOC INNER JOIN CAPDO ON BAIHOC.MaCapDo=CAPDO.MaCapDo " + "WHERE MaCapDo="
				+ maCapDo + "TenBaiHoc COLLATE SQL_Latin1_General_Cp1_CI_AI like '%" + search
				+ "%' COLLATE SQL_Latin1_General_Cp1_CI_AI";
		System.out.println(SQL);
		try {
			ResultSet rs = getStatement().executeQuery(SQL);
			BaiHoc baihoc;
			int i = 1;
			while (rs.next()) {
				baihoc = new BaiHoc();
				baihoc.setMaBaiHoc(rs.getString("MaBaiHoc"));
				baihoc.setTenBaiHoc(rs.getString("TenBaiHoc"));
				baihoc.setMaCapDo(rs.getString("MaCapDo"));
				baihoc.setNghe(rs.getString("Nghe"));
				baihoc.setNguPhap(rs.getString("NguPhap"));
				baihoc.setSound(rs.getString("Sound"));
				baihoc.setTuVung(rs.getString("TuVung"));
				baihoc.setTenCapDo(rs.getString("TenCapDo"));
				baihoc.setStt(i + "");
				i++;
				listBaiHoc.add(baihoc);
			}
			return listBaiHoc;
		} catch (SQLException e) {
			return null;
		} finally {
			closeConnection();
		}
	}

	/**
	 * lay danh sách bài học theo mã cấp độ
	 * 
	 * @param maCapDo
	 * @return
	 */
	public ArrayList<BaiHoc> listBaiHocByCapDo(String maCapDo) {
		openConnection();
		ArrayList<BaiHoc> listBaiHoc = new ArrayList<BaiHoc>();
		String SQL = "SELECT * FROM BAIHOC " + "INNER JOIN CAPDO ON BAIHOC.MaCapDo=CAPDO.MaCapDo " + "WHERE BAIHOC.MaCapDo ='"
				+ maCapDo + "'";
		try {
			System.out.println("capdo:" + maCapDo);
			System.out.println("SQL:" + SQL);
			ResultSet rs = getStatement().executeQuery(SQL);
			BaiHoc baihoc;
			int i = 1;
			while (rs.next()) {
				baihoc = new BaiHoc();
				baihoc.setMaBaiHoc(rs.getString("MaBaiHoc"));
				baihoc.setTenBaiHoc(rs.getString("TenBaiHoc"));
				baihoc.setMaCapDo(rs.getString("MaCapDo"));
				baihoc.setNghe(rs.getString("Nghe"));
				baihoc.setNguPhap(rs.getString("NguPhap"));
				baihoc.setSound(rs.getString("Sound"));
				baihoc.setTuVung(rs.getString("TuVung"));
				baihoc.setTenCapDo(rs.getString("TenCapDo"));
				baihoc.setStt(i + "");
				i++;
				listBaiHoc.add(baihoc);
			}
			return listBaiHoc;
		} catch (SQLException e) {
			return null;
		} finally {
			closeConnection();
		}
	}

	/**
	 * thêm bài học
	 * 
	 * @param baiHoc
	 * @return
	 */
	public boolean themBaiHoc(BaiHoc baiHoc) {
		openConnection();
		String SQL = "INSERT INTO BAIHOC (MaCapDo,TenBaiHoc,TuVung,NguPhap,Nghe,Sound) " + "values ('"
				+ baiHoc.getMaCapDo() + "',N'" + baiHoc.getTenBaiHoc() + "','" + baiHoc.getTuVung() + "',N'"
				+ baiHoc.getNguPhap() + "',N'" + baiHoc.getNghe() + "','" + baiHoc.getSound() + "')";
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
	 * xóa bài học
	 */
	public boolean xoaBaiHoc(String maBaiHoc) {
		openConnection();
		String SQL = "DELETE FROM BAIHOC WHERE MaBaiHoc=" + maBaiHoc;
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
	 * sua bai hoc
	 */
	public boolean updateBaiHoc(BaiHoc baiHoc) {
		openConnection();
		String SQL = "UPDATE BAIHOC SET MaCapDo='" + baiHoc.getMaCapDo() + "',TenBaiHoc=N'" + baiHoc.getTenBaiHoc()
				+ "',TuVung=N'" + baiHoc.getTuVung() + "',Nghe=N'" + baiHoc.getNghe() + "',Sound='" + baiHoc.getSound()
				+ "'";
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
