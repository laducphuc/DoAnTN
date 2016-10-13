package model.bean;

public class ThanhVien {
	private String maThanhVien;
	private String tenThanhVien;
	private String gioiTinh;
	private String ngaySinh;
	private String diaChi;
	private String soDienThoai;
	private String email;
	private String quocTich;
	private String ngonNgu;
	private String maCapDo;
	private String tenCapDo;
	private Boolean chucVu;
	private String maTrinhDo;
	private String tenTrinhDo;
	private int soSao;
	private String maTaiKhoan;
	private String tenTaiKhoan;
	private String maKhau;
	private int soBaiDongGop;
	private int soBaiDaDich;
	private int soBinhLuan;
	private int soBaiDangNhan;
	private String anh;
	
	public String getAnh() {
		return anh;
	}

	public void setAnh(String anh) {
		this.anh = anh;
	}
	public int getSoBaiDangNhan() {
		return soBaiDangNhan;
	}

	public void setSoBaiDangNhan(int soBaiDangNhan) {
		this.soBaiDangNhan = soBaiDangNhan;
	}

	public String getMaKhau() {
		return maKhau;
	}

	public void setMaKhau(String maKhau) {
		this.maKhau = maKhau;
	}

	public int getSoBaiDongGop() {
		return soBaiDongGop;
	}

	public void setSoBaiDongGop(int soBaiDongGop) {
		this.soBaiDongGop = soBaiDongGop;
	}

	public int getSoBaiDaDich() {
		return soBaiDaDich;
	}

	public void setSoBaiDaDich(int soBaiDaDich) {
		this.soBaiDaDich = soBaiDaDich;
	}

	public int getSoBinhLuan() {
		return soBinhLuan;
	}

	public void setSoBinhLuan(int soBinhLuan) {
		this.soBinhLuan = soBinhLuan;
	}

	public String getTenCapDo() {
		return tenCapDo;
	}

	public void setTenCapDo(String tenCapDo) {
		this.tenCapDo = tenCapDo;
	}

	public String getTenTrinhDo() {
		return tenTrinhDo;
	}

	public void setTenTrinhDo(String tenTrinhDo) {
		this.tenTrinhDo = tenTrinhDo;
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

	public String getMaThanhVien() {
		return maThanhVien;
	}

	public void setMaThanhVien(String maThanhVien) {
		this.maThanhVien = maThanhVien;
	}

	public String getTenThanhVien() {
		return tenThanhVien;
	}

	public void setTenThanhVien(String tenThanhVien) {
		this.tenThanhVien = tenThanhVien;
	}

	public String getGioiTinh() {
		return gioiTinh;
	}

	public void setGioiTinh(String gioiTinh) {
		this.gioiTinh = gioiTinh;
	}

	public String getNgaySinh() {
		return ngaySinh;
	}

	public void setNgaySinh(String ngaySinh) {
		this.ngaySinh = ngaySinh;
	}

	public String getDiaChi() {
		return diaChi;
	}

	public void setDiaChi(String diaChi) {
		this.diaChi = diaChi;
	}

	public String getSoDienThoai() {
		return soDienThoai;
	}

	public void setSoDienThoai(String soDienThoai) {
		this.soDienThoai = soDienThoai;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getQuocTich() {
		return quocTich;
	}

	public void setQuocTich(String quocTich) {
		this.quocTich = quocTich;
	}

	public String getNgonNgu() {
		return ngonNgu;
	}

	public void setNgonNgu(String ngonNgu) {
		this.ngonNgu = ngonNgu;
	}

	public String getMaCapDo() {
		return maCapDo;
	}

	public void setMaCapDo(String maCapDo) {
		this.maCapDo = maCapDo;
	}

	public Boolean getChucVu() {
		return chucVu;
	}

	public void setChucVu(Boolean chucVu) {
		this.chucVu = chucVu;
	}

	public String getMaTrinhDo() {
		return maTrinhDo;
	}

	public void setMaTrinhDo(String maTrinhDo) {
		this.maTrinhDo = maTrinhDo;
	}

	public int getSoSao() {
		return soSao;
	}

	public void setSoSao(int soSao) {
		this.soSao = soSao;
	}

	public String toString() {
		return maThanhVien + "/" + tenThanhVien + "/" + gioiTinh + "/" + diaChi
				+ "/" + ngaySinh + "/" + email + "/" + quocTich + "/" + ngonNgu
				+ "/" + maCapDo + "/" + maTrinhDo + "/" + chucVu + "/" + soSao + "/" + tenTaiKhoan;
	}
}
