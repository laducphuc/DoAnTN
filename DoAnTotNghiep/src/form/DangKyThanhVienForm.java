package form;

import org.apache.struts.action.ActionForm;
import org.apache.struts.upload.FormFile;

@SuppressWarnings("serial")
public class DangKyThanhVienForm extends ActionForm {
	
	private String tenThanhVien;
	private int gioiTinh;
	private String ngaySinh;
	private String diaChi;
	private String soDienThoai;
	private String email;
	private String quocTich;
	private String ngonNgu;
	private String[] arrNgonNgu = { "Tiếng Nhật", "Tiếng Việt" };
	private String submit;
	private String tenTaiKhoan;
	private String matKhau;
	private String nhapLaiMatKhau;
	private String[] arrQuocTich = {

	"Brazil", "Brunei", "Canada", "Chile", "China", "Colombia", "Congo",
			"Cuba", "France", "Germany", "Ghana", "Hong Kong", "Hungary",
			"India", "Indonesia", "Iran", "Iraq", "Italy", "Japan", "Laos",
			"Malaysia", "Mexico", "Nepal", "New Zealand", "Pakistan",
			"Paraguay", "Peru", "Philippines", "Qatar", "Russia", "Singapore",
			" Korea", "Taiwan", "Thailand", "Vietnam",

	};
	private FormFile file;

	public FormFile getFile() {
		return file;
	}

	public void setFile(FormFile file) {
		this.file = file;
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

	public String[] getArrNgonNgu() {
		return arrNgonNgu;
	}

	public void setArrNgonNgu(String[] arrNgonNgu) {
		this.arrNgonNgu = arrNgonNgu;
	}

	public String getSubmit() {
		return submit;
	}

	public void setSubmit(String submit) {
		this.submit = submit;
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

	public String getNhapLaiMatKhau() {
		return nhapLaiMatKhau;
	}

	public void setNhapLaiMatKhau(String nhapLaiMatKhau) {
		this.nhapLaiMatKhau = nhapLaiMatKhau;
	}

	public String[] getArrQuocTich() {
		return arrQuocTich;
	}

	public void setArrQuocTich(String[] arrQuocTich) {
		this.arrQuocTich = arrQuocTich;
	}

}
