package form;

import java.util.ArrayList;
import java.util.List;

import model.bean.BaiViet;
import model.bean.ThanhVien;

import org.apache.struts.action.ActionForm;

@SuppressWarnings("serial")
public class TrangChuForm extends ActionForm {

	public String getAvatar() {
		return avatar;
	}

	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}

	public List<BaiViet> getbXHBaiViet() {
		return bXHBaiViet;
	}

	public void setbXHBaiViet(List<BaiViet> bXHBaiViet) {
		this.bXHBaiViet = bXHBaiViet;
	}

	public List<ThanhVien> getbXHThanhVien() {
		return bXHThanhVien;
	}

	public void setbXHThanhVien(List<ThanhVien> bXHThanhVien) {
		this.bXHThanhVien = bXHThanhVien;
	}

	public List<ThanhVien> getbXHCongTacVien() {
		return bXHCongTacVien;
	}

	public void setbXHCongTacVien(List<ThanhVien> bXHCongTacVien) {
		this.bXHCongTacVien = bXHCongTacVien;
	}


	public String getKiemTra() {
		return kiemTra;
	}

	public void setKiemTra(String kiemTra) {
		this.kiemTra = kiemTra;
	}

	public String getMaDanhMuc() {
		return maDanhMuc;
	}

	public void setMaDanhMuc(String maDanhMuc) {
		this.maDanhMuc = maDanhMuc;
	}

	
	public int getTrangCuoi() {
		return trangCuoi;
	}

	public void setTrangCuoi(int trangCuoi) {
		this.trangCuoi = trangCuoi;
	}

	public ArrayList<Integer> getTongSoTrang() {
		return tongSoTrang;
	}

	public void setTongSoTrang(int soTrang) {
		for(int i=1;i<=soTrang;i++)
		tongSoTrang.add(i);
		setTrangCuoi(tongSoTrang.size());
	}

	public ArrayList<BaiViet> getDanhSachBaiVietHienThi() {
		return danhSachBaiVietHienThi;
	}

	public void setDanhSachBaiVietHienThi(ArrayList<BaiViet> danhSachBaiVietHienThi) {
		this.danhSachBaiVietHienThi = danhSachBaiVietHienThi;
	}

	public int getSoTrang() {
		return soTrang;
	}

	public void setSoTrang(int sotrang) {
		this.soTrang = sotrang;
	}

	public ArrayList<BaiViet> getDanhSachBaiViet() {
		return danhSachBaiViet;
	}

	public void setDanhSachBaiViet(ArrayList<BaiViet> danhSachBaiViet) {
		this.danhSachBaiViet = danhSachBaiViet;
	}
	
	public ArrayList<ArrayList<BaiViet>> getDanhSachBaiVietMoiNhat() {
		return danhSachBaiVietMoiNhat;
	}

	public void setDanhSachBaiVietMoiNhat(
			ArrayList<ArrayList<BaiViet>> danhSachBaiVietMoiNhat) {
		this.danhSachBaiVietMoiNhat = danhSachBaiVietMoiNhat;
	}
	
	public ArrayList<ArrayList<ThanhVien>> getTopThanhVien() {
		return topThanhVien;
	}

	public void setTopThanhVien(ArrayList<ArrayList<ThanhVien>> topThanhVien) {
		this.topThanhVien = topThanhVien;
	}

	public ArrayList<ArrayList<ThanhVien>> getTopCongTacVien() {
		return topCongTacVien;
	}

	public void setTopCongTacVien(ArrayList<ArrayList<ThanhVien>> topCongTacVien) {
		this.topCongTacVien = topCongTacVien;
	}
	public String getNoiDungTimKiem() {
		return noiDungTimKiem;
	}

	public void setNoiDungTimKiem(String noiDungTimKiem) {
		this.noiDungTimKiem = noiDungTimKiem;
	}

	public void setTongSoTrang(ArrayList<Integer> tongSoTrang) {
		this.tongSoTrang = tongSoTrang;
	}

	private ArrayList<BaiViet> danhSachBaiViet,danhSachBaiVietHienThi;
	private ArrayList<ArrayList<BaiViet>> danhSachBaiVietMoiNhat;
	private ArrayList<ArrayList<ThanhVien>> topThanhVien, topCongTacVien;
	List<ThanhVien> bXHThanhVien,bXHCongTacVien;
	List<BaiViet> bXHBaiViet;
	private ArrayList<Integer> tongSoTrang=new ArrayList<Integer>();
	private int soTrang=1,trangCuoi=0;
	String maDanhMuc,kiemTra="0",avatar="1";
	private String noiDungTimKiem;
	private String submit;
}
