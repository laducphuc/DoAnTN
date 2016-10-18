package model.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.bean.TuVung;

public class TuVungDAO extends ConnectDAO {
	/**
	 * 
	 * @return list all tu vung
	 */
	public ArrayList<TuVung> getAll() {
		ArrayList<TuVung> listTuVung = new ArrayList<TuVung>();
		String SQL = "SELECT * FROM TUVUNG";
		openConnection();
		try {
			ResultSet rs = getStatement().executeQuery(SQL);
			TuVung tuVung;
			int i = 1;
			while (rs.next()) {
				tuVung = new TuVung();
				tuVung.setMaTuVung(rs.getString("MaTu"));
				tuVung.setMucTu(rs.getString("MucTu"));
				tuVung.setDichNghia(rs.getString("DichNghia"));
				tuVung.setAmThanh(rs.getString("JP"));
				tuVung.setStt(i + "");
				listTuVung.add(tuVung);
				i++;
			}
			return listTuVung;
		} catch (SQLException e) {
			return null;
		} finally {
			closeConnection();
		}
	}

	/**
	 * 
	 * @param maTu
	 * @return get tu vung theo khoa MaTu
	 */
	public TuVung getByPK(String maTu) {
		String SQL = "SELECT * FROM TUVUNG WHERE MaTu='" + maTu + "'";
		openConnection();
		try {
			ResultSet rs = getStatement().executeQuery(SQL);
			TuVung tuVung = new TuVung();
			while (rs.next()) {
				tuVung.setMaTuVung(rs.getString("MaTu"));
				tuVung.setMucTu(rs.getString("MucTu"));
				tuVung.setDichNghia(rs.getString("DichNghia"));
				tuVung.setAmThanh(rs.getString("JP"));
			}
			return tuVung;
		} catch (SQLException e) {
			return null;
		} finally {
			closeConnection();
		}
	}

	/**
	 * 
	 * @param tuVung
	 */
	public void addTuVung(TuVung tuVung) {
		String SQL = "INSERT INTO TUVUNG (MucTu,JP,DichNghia) VALUES(?,?,?)";
		PreparedStatement ps;
		openConnection();
		try {
			ps = getConnect().prepareStatement(SQL);
			ps.setString(1, tuVung.getMucTu());
			ps.setString(2, tuVung.getAmThanh());
			ps.setString(3, tuVung.getDichNghia());
			ps.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeConnection();
		}
	}

	/**
	 * 
	 * @param tuVung
	 */
	public void updateTuVung(TuVung tuVung) {
		String SQL = "UPDATE TUVUNG SET MucTu='" + tuVung.getMucTu() + "' ,JP='" + tuVung.getAmThanh()
				+ "' ,DichNghia= N'" + tuVung.getDichNghia() + "' WHERE MaTu='" + tuVung.getMaTuVung() + "'";
		openConnection();
		try {
			getStatement().executeUpdate(SQL);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeConnection();
		}
	}
}
