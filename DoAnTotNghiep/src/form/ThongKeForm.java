package form;

import java.util.ArrayList;

import org.apache.struts.action.ActionForm;

import model.bean.BaiViet;
import model.bean.ThanhVien;

@SuppressWarnings("serial")
public class ThongKeForm extends ActionForm {
	private ArrayList<ThanhVien> danhSachThanhVien;
	private ArrayList<BaiViet> danhSachBaiViet;

	public ArrayList<BaiViet> getDanhSachBaiViet() {
		return danhSachBaiViet;
	}

	public void setDanhSachBaiViet(ArrayList<BaiViet> danhSachBaiViet) {
		this.danhSachBaiViet = danhSachBaiViet;
	}

	public ArrayList<ThanhVien> getDanhSachThanhVien() {
		return danhSachThanhVien;
	}

	public void setDanhSachThanhVien(ArrayList<ThanhVien> danhSachThanhVien) {
		this.danhSachThanhVien = danhSachThanhVien;
	}

}
