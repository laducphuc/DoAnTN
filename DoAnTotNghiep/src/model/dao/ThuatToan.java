package model.dao;

import java.sql.Connection;
import java.util.ArrayList;

import model.bean.BaiViet;
import model.bean.ThanhVien;

public class ThuatToan {
	
	private ThuatToanDAO thuatToanDAO;
	private ArrayList<ThanhVien> danhSachCongTacVien;
	private ArrayList<BaiViet> danhSachBaiVietMoi;
	private int N=100;
	private int[][] phanCong= new int[N][];
	
	
	public ThuatToan(){
		thuatToanDAO= new ThuatToanDAO();
		danhSachCongTacVien=thuatToanDAO.danhSachCongTacVien();
		danhSachBaiVietMoi=thuatToanDAO.danhSachBaiVietMoi();
		
	}
	
	public void khoiTao(){
		 
	}
	public void danhGia(){
		
	}
	public void luaChon(){
		
	}
	public void laiGhep(){
		
	}
	public void dotBien(){
		
	}
}
