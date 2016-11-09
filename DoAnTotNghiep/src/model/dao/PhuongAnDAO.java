package model.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import common.StringProcess;
import model.bean.PhuongAn;

public class PhuongAnDAO extends ConnectDAO {

	/**
	 * them phoung an vao DB
	 * 
	 * @param listPhuongAn
	 * @return
	 */
	public boolean addListPhuongAn(ArrayList<PhuongAn> listPhuongAn) {
		openConnection();
		PhuongAn phuongAn;
		String[] sql = new String[listPhuongAn.size()];
		for (int i = 0; i < listPhuongAn.size(); i++) {
			phuongAn = listPhuongAn.get(i);
			sql[i] = String.format(
					"INSERT INTO PHUONGAN (MaCauHoi,NoiDung,TrangThai,HinhAnh) VALUES(%s, N'%s', N'%s', '%s')",
					phuongAn.getMaCauHoi(), phuongAn.getNoiDungPA(), phuongAn.getTrangThai(), phuongAn.getHinhAnh());
			System.out.println(sql[i]);
		}

		try {
			Statement stmt = getStatement();
			for (int i = 0; i < sql.length; i++) {
				stmt.executeUpdate(sql[i]);
			}

			return true;
		} catch (SQLException e) {
			return false;
		} finally {
			closeConnection();
		}
	}

	public ArrayList<PhuongAn> getPhuongAn(String maCauHoi) {
		openConnection();
		String SQL = "SELECT * from PHUONGAN WHERE MaCauHoi='" + maCauHoi + "'";
		ResultSet rs;
		try {
			rs = getStatement().executeQuery(SQL);
			ArrayList<PhuongAn> listPhuongAn = new ArrayList<PhuongAn>();
			PhuongAn phuongAn;
			while (rs.next()) {
				phuongAn = new PhuongAn();
				phuongAn.setMaCauHoi(rs.getString("MaCauHoi"));
				phuongAn.setMaPhuongAn(rs.getString("MaPhuongAn"));
				phuongAn.setNoiDungPA(rs.getString("NoiDung"));
				phuongAn.setHinhAnh(rs.getString("HinhAnh"));
				phuongAn.setTrangThai(rs.getString("TrangThai"));
				listPhuongAn.add(phuongAn);
			}
			
			return listPhuongAn;
		} catch (SQLException e) {
			return null;
		} finally {
			closeConnection();
		}
	}
}
