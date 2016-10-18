package model.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.bean.CapDo;

public class CapDoDAO extends ConnectDAO {

	public String getTenCDByPK(String maCapDo) {
		openConnection();
		String SQL = "SELECT TenCapDo FROM CapDo WHERE MaCapDo ='" + maCapDo + "'";
		try {
			ResultSet rs = getStatement().executeQuery(SQL);
			String tenCapDo = "";
			while (rs.next()) {
				tenCapDo = rs.getString("TenCapDo");
			}
			return tenCapDo;
		} catch (SQLException e) {
			return null;
		} finally {
			closeConnection();
		}
	}

	public ArrayList<CapDo> listCapDo() {
		openConnection();
		String SQL = "SELECT * FROM CAPDO";
		ArrayList<CapDo> listCapDo = new ArrayList<CapDo>();
		CapDo capDo;
		try {
			ResultSet rs = getStatement().executeQuery(SQL);
			while (rs.next()) {
				capDo = new CapDo();
				capDo.setMaCapDo(rs.getString("MaCapDo"));
				capDo.setTenCapDo(rs.getString("TenCapDo"));
				listCapDo.add(capDo);
			}
			return listCapDo;
		} catch (SQLException e) {
			return null;
		} finally {
			closeConnection();
		}
	}
}
