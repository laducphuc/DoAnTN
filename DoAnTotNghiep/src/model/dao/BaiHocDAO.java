package model.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.bean.BaiHoc;

public class BaiHocDAO extends ConnectDAO{

	public ArrayList<BaiHoc> listBaiHoc() {
		openConnection();
		ArrayList<BaiHoc> listBaiHoc = new ArrayList<BaiHoc>();
		final String SQL = "SELECT * FROM BaiHoc";
		try {
			ResultSet rs = getStatement().executeQuery(SQL);
			BaiHoc baihoc;
			while (rs.next()) {
				baihoc = new BaiHoc();
				baihoc.setMaBaiHoc(rs.getString("MaBaiHoc"));
				baihoc.setTenBaiHoc(rs.getString("TenBaiHoc"));
				baihoc.setMaCapDo(rs.getString("MaCapDo"));
				listBaiHoc.add(baihoc);
			}
			return listBaiHoc;
		} catch (SQLException e) {
			return null;
		} finally {
			closeConnection();
		}
	}
	
	public ArrayList<BaiHoc> listBaiHocByCapDo(String maCapDo) {
		openConnection();
		ArrayList<BaiHoc> listBaiHoc = new ArrayList<BaiHoc>();
		String SQL = "SELECT * FROM BaiHoc WHERE MaCapDo ='"+maCapDo+"'";
		try {
			System.out.println("capdo:"+maCapDo);
			System.out.println("SQL:"+SQL);
			ResultSet rs = getStatement().executeQuery(SQL);
			BaiHoc baihoc;
			while (rs.next()) {
				baihoc = new BaiHoc();
				baihoc.setMaBaiHoc(rs.getString("MaBaiHoc"));
				baihoc.setTenBaiHoc(rs.getString("TenBaiHoc"));
				baihoc.setMaCapDo(rs.getString("MaCapDo"));
				listBaiHoc.add(baihoc);
			}			return listBaiHoc;
		} catch (SQLException e) {
			return null;
		} finally {
			closeConnection();
		}
	}
}
