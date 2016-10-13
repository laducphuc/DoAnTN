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
	private String quocTich;
	private String ngonNgu;
	private String maCapDo;
	private String tenCapDo;
	private String maTrinhDo;
	private String tenTrinhDo;
	private boolean chucVu;
	private int soSao;
	private int soBaiDongGop;
	private int soBaiDaDich;
	private int soBinhLuan;
	private String tenTaiKhoan;
	private ThanhVien thanhVien;
	private String[] arrNgonNgu = { "Tiếng Nhật", "Tiếng Việt" };
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

	private String[] arrQuocTich = {

	"Brazil", "Brunei", "Canada", "Chile", "China", "Colombia", "Congo",
			"Cuba", "France", "Germany", "Ghana", "Hong Kong", "Hungary",
			"India", "Indonesia", "Iran", "Iraq", "Italy", "Japan", "Laos",
			"Malaysia", "Mexico", "Nepal", "New Zealand", "Pakistan",
			"Paraguay", "Peru", "Philippines", "Qatar", "Russia", "Singapore",
			" Korea", "Taiwan", "Thailand", "Vietnam",

	};
	
	
	
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

	public boolean isChucVu() {
		return chucVu;
	}

	public void setChucVu(boolean chucVu) {
		this.chucVu = chucVu;
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

	public String[] getArrQuocTich() {
		return arrQuocTich;
	}

	public void setArrQuocTich(String[] arrQuocTich) {
		this.arrQuocTich = arrQuocTich;
	}

	public String[] getArrNgonNgu() {
		return arrNgonNgu;
	}

	public void setArrNgonNgu(String[] arrNgonNgu) {
		this.arrNgonNgu = arrNgonNgu;
	}

	public int getSoBaiDongGop() {
		return soBaiDongGop;
	}

	public void setSoBaiDongGop(int soBaiDongGop) {
		this.soBaiDongGop = soBaiDongGop;
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

	public String getTenCapDo() {
		return tenCapDo;
	}

	public void setTenCapDo(String tenCapDo) {
		this.tenCapDo = tenCapDo;
	}

	public int getSoSao() {
		return soSao;
	}

	public void setSoSao(int soSao) {
		this.soSao = soSao;
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
		quocTich = thanhVien.getQuocTich();
		ngonNgu = thanhVien.getNgonNgu();
		maCapDo = thanhVien.getMaCapDo();
		tenCapDo = thanhVien.getTenCapDo();
		maTrinhDo = thanhVien.getMaTrinhDo();
		tenTrinhDo = thanhVien.getTenTrinhDo();
		chucVu = thanhVien.getChucVu();
		soSao = thanhVien.getSoSao();
		soBaiDongGop = thanhVien.getSoBaiDongGop();
		soBaiDaDich = thanhVien.getSoBaiDaDich();
		soBinhLuan = thanhVien.getSoBinhLuan();
		tenTaiKhoan = thanhVien.getTenTaiKhoan();
	}

}
