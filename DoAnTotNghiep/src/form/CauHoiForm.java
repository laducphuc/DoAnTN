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

	private String noiDung, maCapDo, maCauHoi, dapAn, timKiem;
	private ArrayList<CapDo> listCapDo;
	private ArrayList<CauHoi> listCauHoi;

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
