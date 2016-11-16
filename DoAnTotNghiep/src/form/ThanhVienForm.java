package form;

import model.bean.ThanhVien;

import org.apache.struts.action.ActionForm;
import org.apache.struts.upload.FormFile;

@SuppressWarnings("serial")
public class ThanhVienForm extends ActionForm {
	private String maThanhVien;
	private String tenThanhVien;
	private int gioiTinh;
	private String ngaySinh;
	private String diaChi;
	private String soDienThoai;
	private String email;
	private String maCapDo;
	private String tenCapDo;
	private String maTrinhDo;
	private String tenTrinhDo;
	private String chucVu;
	private String tenTaiKhoan;
	private ThanhVien thanhVien;
	private String submit;
	private String soNgayKhoa;
	private String matKhauCu;
	private String matKhauMoi;
	private String nhapLaiMatKhau;
	private String matKhauLoi;
	private String matKhauMoiLoi;
	private String nhapLaiMatKhauLoi;
	private String tenThanhVienLoi;
	private FormFile file;
	
	public String getTenThanhVienLoi() {
		return tenThanhVienLoi;
	}

	public void setTenThanhVienLoi(String tenThanhVienLoi) {
		this.tenThanhVienLoi = tenThanhVienLoi;
	}

	public FormFile getFile() {
		return file;
	}

	public void setFile(FormFile file) {
		this.file = file;
	}

	public String getMatKhauLoi() {
		return matKhauLoi;
	}

	public void setMatKhauLoi(String matKhauLoi) {
		this.matKhauLoi = matKhauLoi;
	}

	public String getMatKhauMoiLoi() {
		return matKhauMoiLoi;
	}

	public void setMatKhauMoiLoi(String matKhauMoiLoi) {
		this.matKhauMoiLoi = matKhauMoiLoi;
	}

	public String getNhapLaiMatKhauLoi() {
		return nhapLaiMatKhauLoi;
	}

	public void setNhapLaiMatKhauLoi(String nhapLaiMatKhauLoi) {
		this.nhapLaiMatKhauLoi = nhapLaiMatKhauLoi;
	}

	public String getMatKhauCu() {
		return matKhauCu;
	}

	public void setMatKhauCu(String matKhauCu) {
		this.matKhauCu = matKhauCu;
	}

	public String getMatKhauMoi() {
		return matKhauMoi;
	}

	public void setMatKhauMoi(String matKhauMoi) {
		this.matKhauMoi = matKhauMoi;
	}

	public String getNhapLaiMatKhau() {
		return nhapLaiMatKhau;
	}

	public void setNhapLaiMatKhau(String nhapLaiMatKhau) {
		this.nhapLaiMatKhau = nhapLaiMatKhau;
	}

	public String getMaTrinhDo() {
		return maTrinhDo;
	}

	public void setMaTrinhDo(String maTrinhDo) {
		this.maTrinhDo = maTrinhDo;
	}

	public String getTenTrinhDo() {
		return tenTrinhDo;
	}

	public void setTenTrinhDo(String tenTrinhDo) {
		this.tenTrinhDo = tenTrinhDo;
	}

	public String getChucVu() {
		return chucVu;
	}

	public void setChucVu(String chucVu) {
		this.chucVu = chucVu;
	}

	public String getSubmit() {
		return submit;
	}

	public void setSubmit(String submit) {
		this.submit = submit;
	}

	public String getSoNgayKhoa() {
		return soNgayKhoa;
	}

	public void setSoNgayKhoa(String soNgayKhoa) {
		this.soNgayKhoa = soNgayKhoa;
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

	public int getGioiTinh() {
		return gioiTinh;
	}

	public void setGioiTinh(int gioiTinh) {
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

	public String getTenTaiKhoan() {
		return tenTaiKhoan;
	}

	public void setTenTaiKhoan(String tenTaiKhoan) {
		this.tenTaiKhoan = tenTaiKhoan;
	}

	public ThanhVien getThanhVien() {
		return thanhVien;
	}

	public void setThanhVien(ThanhVien thanhVien) {
		this.thanhVien = thanhVien;
	
		maThanhVien = thanhVien.getMaThanhVien();
		tenThanhVien = thanhVien.getTenThanhVien();
		if ("Nam".equals(thanhVien.getGioiTinh())) {
			gioiTinh = 1;
		} else {
			gioiTinh = 0;
		}
		ngaySinh = thanhVien.getNgaySinh();
		diaChi = thanhVien.getDiaChi();
		soDienThoai = thanhVien.getSoDienThoai();
		email = thanhVien.getEmail();
		maCapDo = thanhVien.getMaCapDo();
		tenCapDo = thanhVien.getTenCapDo();
		maTrinhDo = thanhVien.getMaTrinhDo();
		tenTrinhDo = thanhVien.getTenTrinhDo();
		chucVu = thanhVien.getChucVu();
		tenTaiKhoan = thanhVien.getTenTaiKhoan();
	}

}
