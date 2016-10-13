package model.bean;

public class TaiKhoan {
	private String maTaiKhoan;
	private String tenTaiKhoan;
	private String matKhau;
	private String maThanhVien;
	private String tenThanhVien;
	private String chucVu;
	private Boolean trangThai;
	private int soNgayKhoa;
	private String ngayBatDauKhoa;
	private int soNgayConLai;
	private String anh;
	
	public String getAnh() {
		return anh;
	}

	public void setAnh(String anh) {
		this.anh = anh;
	}

	public int getSoNgayConLai() {
		return soNgayConLai;
	}

	public void setSoNgayConLai(int soNgayConLai) {
		this.soNgayConLai = soNgayConLai;
	}

	public String getTenThanhVien() {
		return tenThanhVien;
	}

	public void setTenThanhVien(String tenThanhVien) {
		this.tenThanhVien = tenThanhVien;
	}

	public String getChucVu() {
		return chucVu;
	}

	public void setChucVu(String chucVu) {
		this.chucVu = chucVu;
	}

	public String getNgayBatDauKhoa() {
		return ngayBatDauKhoa;
	}

	public void setNgayBatDauKhoa(String ngayBatDauKhoa) {
		this.ngayBatDauKhoa = ngayBatDauKhoa;
	}

	public String getMaTaiKhoan() {
		return maTaiKhoan;
	}

	public void setMaTaiKhoan(String maTaiKhoan) {
		this.maTaiKhoan = maTaiKhoan;
	}

	public String getTenTaiKhoan() {
		return tenTaiKhoan;
	}

	public void setTenTaiKhoan(String tenTaiKhoan) {
		this.tenTaiKhoan = tenTaiKhoan;
	}

	public String getMatKhau() {
		return matKhau;
	}

	public void setMatKhau(String matKhau) {
		this.matKhau = matKhau;
	}

	public String getMaThanhVien() {
		return maThanhVien;
	}

	public void setMaThanhVien(String maThanhVien) {
		this.maThanhVien = maThanhVien;
	}

	public Boolean getTrangThai() {
		return trangThai;
	}

	public void setTrangThai(Boolean trangThai) {
		this.trangThai = trangThai;
	}

	public int getSoNgayKhoa() {
		return soNgayKhoa;
	}

	public void setSoNgayKhoa(int soNgayKhoa) {
		this.soNgayKhoa = soNgayKhoa;
	}
	
	public String toString(){
		return maTaiKhoan + "/" + tenTaiKhoan + "/" + maTaiKhoan + "/" + maThanhVien + "/" + trangThai + "/" + soNgayKhoa;
	}
}
