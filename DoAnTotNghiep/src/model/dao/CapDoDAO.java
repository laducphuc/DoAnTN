package model.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CapDoDAO extends ConnectDAO {

	public String getTenCDByPK(String maCapDo) {
		openConnection();
		final String SQL = "SELECT TenCapDo FROM CapDo WHERE MaCapDo ='" + maCapDo + "'";
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
}
