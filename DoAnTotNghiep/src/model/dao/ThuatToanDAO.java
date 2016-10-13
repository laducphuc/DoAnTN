package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.sun.corba.se.spi.orbutil.fsm.Guard.Result;

import model.bean.BaiViet;
import model.bean.ThanhVien;

public class ThuatToanDAO {

	private ConnectDAO connection;
	private Connection conn;
	
	public ThuatToanDAO(){
		connection= new ConnectDAO();
		conn=connection.getConnect();
	}
	
	public ArrayList<ThanhVien> danhSachCongTacVien(){
		try {
			conn=connection.getConnect();
			String sql="select MaThanhVien, TenThanhVien, MaTrinhDo "
					+ " from THANHVIEN where ChucVu= ?";
			PreparedStatement pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, 1);
			ResultSet rs=pstmt.executeQuery();
			ArrayList<ThanhVien> danhSachCongTacVien = new ArrayList<ThanhVien>();
			while(rs.next()){
				ThanhVien thanhVien= new ThanhVien();
				thanhVien.setMaThanhVien(rs.getString(1));
				thanhVien.setTenThanhVien(rs.getString(2));
				thanhVien.setMaTrinhDo(rs.getString(3));
				danhSachCongTacVien.add(thanhVien);
			}
			return danhSachCongTacVien;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		finally{
			connection.closeConnection();
		}
	}

	public ArrayList<BaiViet> danhSachBaiVietMoi() {
		try {
			conn=connection.getConnect();
			String sql="select MaBaiViet, SoNgayDichBai "
					+ " from BAIVIET "
					+ " where TrangThai = 'Bai moi'";
			PreparedStatement pstmt= conn.prepareStatement(sql);
			ResultSet rs=pstmt.executeQuery();
			ArrayList<BaiViet> danhSachBaiVietMoi = new ArrayList<BaiViet>();
			
			while(rs.next()){
				BaiViet baiViet= new BaiViet();
				baiViet.setMaBaiViet(rs.getString(1));
				baiViet.setSoNgayDichBai(rs.getInt(2));
				danhSachBaiVietMoi.add(baiViet);
			}
			return danhSachBaiVietMoi;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		finally{
			connection.closeConnection();
		}
	}
}
