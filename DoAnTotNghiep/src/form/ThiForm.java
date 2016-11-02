package form;

import java.util.ArrayList;

import org.apache.struts.action.ActionForm;

import model.bean.BaiThi;
import model.bean.CapDo;
import model.bean.CauHoi;

public class ThiForm extends ActionForm {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String tenCapDo;
	private String soBaiThi;
	private ArrayList<BaiThi> listBaiThi;
	private ArrayList<CauHoi> listCauHoi;
	private String maCapDo;
	private String maDeThi;
	private ArrayList<CapDo> listCapDo;
	private String timKiem;
	
	public String getTimKiem() {
		return timKiem;
	}

	public void setTimKiem(String timKiem) {
		this.timKiem = timKiem;
	}

	public String getMaDeThi() {
		return maDeThi;
	}

	public void setMaDeThi(String maDeThi) {
		this.maDeThi = maDeThi;
	}

	public ArrayList<CapDo> getListCapDo() {
		return listCapDo;
	}

	public void setListCapDo(ArrayList<CapDo> listCapDo) {
		this.listCapDo = listCapDo;
	}

	public ArrayList<CauHoi> getListCauHoi() {
		return listCauHoi;
	}

	public void setListCauHoi(ArrayList<CauHoi> listCauHoi) {
		this.listCauHoi = listCauHoi;
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

	public String getSoBaiThi() {
		return soBaiThi;
	}

	public void setSoBaiThi(String soBaiThi) {
		this.soBaiThi = soBaiThi;
	}

	public ArrayList<BaiThi> getListBaiThi() {
		return listBaiThi;
	}

	public void setListBaiThi(ArrayList<BaiThi> listBaiThi) {
		this.listBaiThi = listBaiThi;
	}

}
