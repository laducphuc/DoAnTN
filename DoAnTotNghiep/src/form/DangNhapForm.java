package form;

import model.bean.TaiKhoan;

import org.apache.struts.action.ActionForm;

@SuppressWarnings("serial")
public class DangNhapForm extends ActionForm {
	private String tenTaiKhoan;
	private String matKhau;
	private String thongBao;
	private String maThanhVien;
	private TaiKhoan taiKhoan;
	private String chucVu;
	private String submit;
	
	
	public String getSubmit() {
		return submit;
	}
	public void setSubmit(String submit) {
		this.submit = submit;
	}
	public String getChucVu() {
		return chucVu;
	}
	public void setChucVu(String chucVu) {
		this.chucVu = chucVu;
	}
	public TaiKhoan getTaiKhoan() {
		return taiKhoan;
	}
	public void setTaiKhoan(TaiKhoan taiKhoan) {
		this.taiKhoan = taiKhoan;
		this.tenTaiKhoan = taiKhoan.getTenTaiKhoan();
		this.matKhau = taiKhoan.getMatKhau();
		this.maThanhVien = taiKhoan.getMaThanhVien();
		this.chucVu = taiKhoan.getChucVu();
	}
	public String getMaThanhVien() {
		return maThanhVien;
	}
	public void setMaThanhVien(String maThanhVien) {
		this.maThanhVien = maThanhVien;
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
	public String getThongBao() {
		return thongBao;
	}
	public void setThongBao(String thongBao) {
		this.thongBao = thongBao;
	}	
}
