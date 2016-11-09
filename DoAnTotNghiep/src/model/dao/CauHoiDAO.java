package model.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import model.bean.CauHoi;

public class CauHoiDAO extends ConnectDAO {

	/**
	 * lấy danh sách câu hỏi
	 * 
	 * @return list câu hỏi
	 */
	public ArrayList<CauHoi> listCauHoi() {
		openConnection();
		ArrayList<CauHoi> listCauHoi = new ArrayList<CauHoi>();
		final String SQL = "SELECT * FROM CAUHOI INNER JOIN CAPDO ON CAUHOI.MaCapDo=CAPDO.MaCapDo";
		try {
			ResultSet rs = getStatement().executeQuery(SQL);
			CauHoi cauHoi;
			int i = 1;
			while (rs.next()) {
				cauHoi = new CauHoi();
				cauHoi.setMaCauHoi(rs.getString("MaCauHoi"));
				cauHoi.setMaCapDo(rs.getString("MaCapDo"));
				cauHoi.setNoiDung(rs.getString("NoiDung"));
				cauHoi.setStt(i + "");
				cauHoi.setTenCapDo(rs.getString("TenCapDo"));
				i++;
				listCauHoi.add(cauHoi);
			}
			return listCauHoi;
		} catch (SQLException e) {
			return null;
		} finally {
			closeConnection();
		}
	}

	/**
	 * lấy danh sách câu hỏi theo cấp độ
	 * 
	 * @return
	 */
	public ArrayList<CauHoi> listCauHoi(String maCapDo) {
		openConnection();
		ArrayList<CauHoi> listCauHoi = new ArrayList<CauHoi>();
		final String SQL = "SELECT * FROM CAUHOI INNER JOIN CAPDO ON CAUHOI.MaCapDo=CAPDO.MaCapDo WHERE CAUHOI.MaCapDo='"
				+ maCapDo + "'";
		try {
			ResultSet rs = getStatement().executeQuery(SQL);
			CauHoi cauHoi;
			int i = 1;
			while (rs.next()) {
				cauHoi = new CauHoi();
				cauHoi.setMaCauHoi(rs.getString("MaCauHoi"));
				cauHoi.setMaCapDo(rs.getString("MaCapDo"));
				cauHoi.setNoiDung(rs.getString("NoiDung"));
				cauHoi.setStt(i + "");
				cauHoi.setTenCapDo(rs.getString("TenCapDo"));
				i++;
				listCauHoi.add(cauHoi);
			}
			return listCauHoi;
		} catch (SQLException e) {
			return null;
		} finally {
			closeConnection();
		}
	}

	public CauHoi getCauHoi(String maCauHoi) {
		openConnection();
		String SQL = "SELECT * FROM CAUHOI WHERE MaCauHoi='" + maCauHoi + "'";
		CauHoi cauHoi = new CauHoi();
		System.out.println(SQL);
		try {
			ResultSet rs = getStatement().executeQuery(SQL);
			while (rs.next()) {
				cauHoi.setMaCauHoi(rs.getString("MaCauHoi"));
				cauHoi.setMaCapDo(rs.getString("MaCapDo"));
				cauHoi.setNoiDung(rs.getString("NoiDung"));
			}
			return cauHoi;
		} catch (SQLException e) {
			return null;
		} finally {
			closeConnection();
		}
	}

	/**
	 * insert cau hoi vao database
	 * 
	 * @param cauHoi
	 * @return
	 */
	public boolean addCauHoi(CauHoi cauHoi) {
		openConnection();
		String SQL = "INSERT INTO CAUHOI (NoiDung,MaCapDo,HinhAnh) values (N'" + cauHoi.getNoiDung() + "'," + "'"
				+ cauHoi.getMaCapDo() + "','" + cauHoi.getHinhAnh() + "')";
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
	 * get key moi insert vao db
	 * 
	 * @return
	 */
	public String getKey() {
		openConnection();
		String SQL = "SELECT MAX( MaCauHoi ) AS MaCauHoi FROM CAUHOI ";
		String maCauHoi = null;
		try {
			ResultSet rs = getStatement().executeQuery(SQL);
			while (rs.next()) {
				maCauHoi = rs.getString("MaCauHoi");
			}
			return maCauHoi;
		} catch (SQLException e) {
			return null;
		} finally {
			closeConnection();
		}
	}

	
	
	public boolean xoaCauHoi(String maCauHoi){
		openConnection();
		String SQL="delete from cauhoi where MaCauHoi='"+maCauHoi+"'";
		try {
			getStatement().executeUpdate(SQL);
			return true;
		} catch (SQLException e) {
			return false;
		}
		finally{
			closeConnection();
		}
	}
	
	public boolean xoaPhuongAn(String maCauHoi){
		openConnection();
		String SQL="delete from phuongan where MaCauHoi='"+maCauHoi+"'";
		try {
			getStatement().executeUpdate(SQL);
			return true;
		} catch (SQLException e) {
			return false;
		}
		finally{
			closeConnection();
		}
	}
}
