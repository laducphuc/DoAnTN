package form;

import java.util.ArrayList;
import model.bean.ThanhVien;
import org.apache.struts.action.ActionForm;

@SuppressWarnings("serial")
public class DanhSachThanhVienForm extends ActionForm {
	
	private ArrayList<ThanhVien> danhSachThanhVien;
	private String tuKhoaTimKiem;
	private String noiDungTimKiem;
	private int soThanhVien;
	private boolean chucVu;
	
	public boolean isChucVu() {
		return chucVu;
	}
	public void setChucVu(boolean chucVu) {
		this.chucVu = chucVu;
	}
	public ArrayList<ThanhVien> getDanhSachThanhVien() {
		return danhSachThanhVien;
	}
	public void setDanhSachThanhVien(ArrayList<ThanhVien> danhSachThanhVien) {
		this.danhSachThanhVien = danhSachThanhVien;
		this.soThanhVien = this.danhSachThanhVien.size();
	}
	public String getTuKhoaTimKiem() {
		return tuKhoaTimKiem;
	}
	public void setTuKhoaTimKiem(String tuKhoaTimKiem) {
		this.tuKhoaTimKiem = tuKhoaTimKiem;
	}
	public String getNoiDungTimKiem() {
		return noiDungTimKiem;
	}
	public void setNoiDungTimKiem(String noiDungTimKiem) {
		this.noiDungTimKiem = noiDungTimKiem;
	}
	public int getSoThanhVien() {
		return soThanhVien;
	}
	public void setSoThanhVien(int soThanhVien) {
		this.soThanhVien = soThanhVien;
	}
}
