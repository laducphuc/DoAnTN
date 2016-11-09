package model.bean;

import java.util.ArrayList;

public class CauHoi {

	private String maCauHoi, noiDung, maCapDo, tenCapDo,stt,hinhAnh,dapAn,soThuTu;
	private boolean laCheckBox;
	private ArrayList<PhuongAn> listPhuongAn;
	
	public ArrayList<PhuongAn> getListPhuongAn() {
		return listPhuongAn;
	}

	public void setListPhuongAn(ArrayList<PhuongAn> listPhuongAn) {
		this.listPhuongAn = listPhuongAn;
	}

	public String getDapAn() {
		return dapAn;
	}

	public void setDapAn(String dapAn) {
		this.dapAn = dapAn;
	}

	public String getMaCauHoi() {
		return maCauHoi;
	}

	public String getHinhAnh() {
		return hinhAnh;
	}

	public String getSoThuTu() {
		return soThuTu;
	}

	public void setSoThuTu(String soThuTu) {
		this.soThuTu = soThuTu;
	}

	public boolean getLaCheckBox() {
		return laCheckBox;
	}

	public void setLaCheckBox(boolean laCheckBox) {
		this.laCheckBox = laCheckBox;
	}

	public void setHinhAnh(String hinhAnh) {
		this.hinhAnh = hinhAnh;
	}

	public String getStt() {
		return stt;
	}

	public void setStt(String stt) {
		this.stt = stt;
	}

	public void setMaCauHoi(String maCauHoi) {
		this.maCauHoi = maCauHoi;
	}

	public String getNoiDung() {
		return noiDung;
	}

	public void setNoiDung(String noiDung) {
		this.noiDung = noiDung;
	}

	public String getMaCapDo() {
		return maCapDo;
	}

	public void setMaCapDo(String maCapDo) {
		this.maCapDo = maCapDo;
	}

	public String getTenCapDo() {
		return tenCapDo;
	}

	public void setTenCapDo(String tenCapDo) {
		this.tenCapDo = tenCapDo;
	}

}
