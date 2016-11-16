package form;

import java.util.ArrayList;

import org.apache.struts.action.ActionForm;
import org.apache.struts.upload.FormFile;

import model.bean.BaiViet;

@SuppressWarnings("serial")
public class BaiVietForm extends ActionForm {
	private BaiViet baiViet;
	private String maBaiViet;
	private String noiDungViet;
	private String noiDungNhat;
	private String moTaViet;
	private String moTaNhat;
	private String tieuDeViet;
	private String tieuDeNhat;
	private String maThanhVien;
	private String thongBao;
	private String submit;
	private int soCau = 0;
	private String thich;
	private int soSao;
	private String daXem;
	private String trangThai;
	private FormFile file;
	private String maDanhMuc;
	private String fileName;
	private String ngayVietBai;
	private String anh;
	private ArrayList<String> noiDungBaiViet;
	private ArrayList<String> arrNoiDungViet;
	private ArrayList<String> arrNoiDungNhat;
	public String getTrangThai() {
		return trangThai;
	}

	

	public void setTrangThai(String trangThai) {
		this.trangThai = trangThai;
	}

	public ArrayList<String> getArrNoiDungViet() {
		return arrNoiDungViet;
	}

	public void setArrNoiDungViet(ArrayList<String> arrNoiDungViet) {
		this.arrNoiDungViet = arrNoiDungViet;
	}

	public ArrayList<String> getArrNoiDungNhat() {
		return arrNoiDungNhat;
	}

	public void setArrNoiDungNhat(ArrayList<String> arrNoiDungNhat) {
		this.arrNoiDungNhat = arrNoiDungNhat;
	}

	
	
	public String getDaXem() {
		return daXem;
	}

	public void setDaXem(String daXem) {
		this.daXem = daXem;
	}

	public int getSoSao() {
		return soSao;
	}

	public void setSoSao(int soSao) {
		this.soSao = soSao;
	}

	public String getNoiDungNhat() {
		return noiDungNhat;
	}

	public String getThich() {
		return thich;
	}


	public void setThich(String thich) {
		this.thich = thich;
	}


	public void setNoiDungNhat(String noiDungNhat) {
		this.noiDungNhat = noiDungNhat;
	}

	public String getMoTaNhat() {
		return moTaNhat;
	}

	public void setMoTaNhat(String moTaNhat) {
		this.moTaNhat = moTaNhat;
	}

	public String getTieuDeNhat() {
		return tieuDeNhat;
	}

	public void setTieuDeNhat(String tieuDeNhat) {
		this.tieuDeNhat = tieuDeNhat;
	}

	public int getSoCau() {
		return soCau;
	}

	public void setSoCau(int soCau) {
		this.soCau = soCau;
	}

	public ArrayList<String> getNoiDungBaiViet() {
		return noiDungBaiViet;
	}

	public void setNoiDungBaiViet(ArrayList<String> noiDungBaiViet) {
		this.noiDungBaiViet = noiDungBaiViet;
	}

	public String getNgayVietBai() {
		return ngayVietBai;
	}

	public void setNgayVietBai(String ngayVietBai) {
		this.ngayVietBai = ngayVietBai;
	}

	public String getAnh() {
		return anh;
	}

	public void setAnh(String anh) {
		this.anh = anh;
	}

	public FormFile getFile() {
		return file;
	}

	public void setFile(FormFile file) {
		this.file = file;
	}

	public String getMaDanhMuc() {
		return maDanhMuc;
	}

	public void setMaDanhMuc(String maDanhMuc) {
		this.maDanhMuc = maDanhMuc;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getSubmit() {
		return submit;
	}

	public void setSubmit(String submit) {
		this.submit = submit;
	}

	public String getThongBao() {
		return thongBao;
	}

	public void setThongBao(String thongBao) {
		this.thongBao = thongBao;
	}

	public String getMaThanhVien() {
		return maThanhVien;
	}

	public void setMaThanhVien(String maThanhVien) {
		this.maThanhVien = maThanhVien;
	}

	public String getMoTaViet() {
		return moTaViet;
	}

	public void setMoTaViet(String moTaViet) {
		this.moTaViet = moTaViet;
	}

	public String getNoiDungViet() {
		return noiDungViet;
	}

	public void setNoiDungViet(String noiDungViet) {
		this.noiDungViet = noiDungViet;
	}

	public String getTieuDeViet() {
		return tieuDeViet;
	}

	public void setTieuDeViet(String tieuDeViet) {
		this.tieuDeViet = tieuDeViet;
	}

	public BaiViet getBaiViet() {
		return baiViet;
	}

	public void setBaiViet(BaiViet baiViet) {
		this.baiViet = baiViet;
		this.maBaiViet = baiViet.getMaBaiViet();
		this.noiDungViet = baiViet.getNoiDungViet();
		this.moTaViet = baiViet.getMoTaViet();
		this.tieuDeViet = baiViet.getTieuDeViet();
		this.soCau = baiViet.getArrNoiDungViet().size();
		this.maDanhMuc = baiViet.getMaDanhMuc();
		this.arrNoiDungNhat = baiViet.getArrNoiDungNhat();
		this.arrNoiDungViet = baiViet.getArrNoiDungViet();
	}

	public String getMaBaiViet() {
		return maBaiViet;
	}

	public void setMaBaiViet(String maBaiViet) {
		this.maBaiViet = maBaiViet;
	}

}
