package form;

import java.util.ArrayList;

import org.apache.struts.action.ActionForm;

import model.bean.CapDo;
import model.bean.CauHoi;

public class CauHoiForm extends ActionForm {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String noiDung, maCapDo,tenCapDo, maCauHoi, dapAn, timKiem;
	private ArrayList<CapDo> listCapDo;
	private ArrayList<CauHoi> listCauHoi;
	private String dapAn1, dapAn2, dapAn3, dapAn4;

	public String getTenCapDo() {
		return tenCapDo;
	}

	public void setTenCapDo(String tenCapDo) {
		this.tenCapDo = tenCapDo;
	}

	public String getDapAn1() {
		return dapAn1;
	}

	public void setDapAn1(String dapAn1) {
		this.dapAn1 = dapAn1;
	}

	public String getDapAn2() {
		return dapAn2;
	}

	public void setDapAn2(String dapAn2) {
		this.dapAn2 = dapAn2;
	}

	public String getDapAn3() {
		return dapAn3;
	}

	public void setDapAn3(String dapAn3) {
		this.dapAn3 = dapAn3;
	}

	public String getDapAn4() {
		return dapAn4;
	}

	public void setDapAn4(String dapAn4) {
		this.dapAn4 = dapAn4;
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

	public String getMaCauHoi() {
		return maCauHoi;
	}

	public String getTimKiem() {
		return timKiem;
	}

	public void setTimKiem(String timKiem) {
		this.timKiem = timKiem;
	}

	public void setMaCauHoi(String maCauHoi) {
		this.maCauHoi = maCauHoi;
	}

	public String getDapAn() {
		return dapAn;
	}

	public void setDapAn(String dapAn) {
		this.dapAn = dapAn;
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

}
