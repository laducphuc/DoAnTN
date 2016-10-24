package model.dao;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import model.bean.PhuongAn;

public class PhuongAnDAO extends ConnectDAO{

	/**
	 * them phoung an vao DB
	 * @param listPhuongAn
	 * @return
	 */
	public boolean addListPhuongAn(ArrayList<PhuongAn> listPhuongAn) {
		openConnection();
		PhuongAn phuongAn;
		String[] sql = new String[listPhuongAn.size()];
		for (int i = 0; i < listPhuongAn.size(); i++) {
			phuongAn = listPhuongAn.get(i);
			sql[i] = String.format("INSERT INTO PHUONGAN VALUES(%s, N'%s', N'%s', %s)",phuongAn.getMaCauHoi(), phuongAn.getNoiDungPA(), phuongAn.getTrangThai(),phuongAn.getHinhAnh());
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
		}
		finally{
			closeConnection();
		}
	}
}
