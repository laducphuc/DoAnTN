package form;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;

import model.bean.CapDo;
import model.bean.CauHoi;

public class TaoDeThiForm extends ActionForm {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String tenDeThi, maCapDo, cauHoi, maCauHoi, kt, submit, tongCauHoi;
	private ArrayList<CapDo> listCapDo;
	private ArrayList<CauHoi> listCauHoi;
	String[] chonCauHoi;

	public String getKt() {
		return kt;
	}

	public String getTongCauHoi() {
		return tongCauHoi;
	}

	public void setTongCauHoi(String tongCauHoi) {
		this.tongCauHoi = tongCauHoi;
	}

	public String getSubmit() {
		return submit;
	}

	public void setSubmit(String submit) {
		this.submit = submit;
	}

	public void setKt(String kt) {
		this.kt = kt;
	}

	public String[] getChonCauHoi() {
		return chonCauHoi;
	}

	public void setChonCauHoi(String[] chonCauHoi) {
		this.chonCauHoi = chonCauHoi;
	}

	public String getMaCauHoi() {
		return maCauHoi;
	}

	public void setMaCauHoi(String maCauHoi) {
		this.maCauHoi = maCauHoi;
	}

	public ArrayList<CauHoi> getListCauHoi() {
		return listCauHoi;
	}

	public void setListCauHoi(ArrayList<CauHoi> listCauHoi) {
		this.listCauHoi = listCauHoi;
	}

	public String getTenDeThi() {
		return tenDeThi;
	}

	public void setTenDeThi(String tenDeThi) {
		this.tenDeThi = tenDeThi;
	}

	public String getMaCapDo() {
		return maCapDo;
	}

	public void setMaCapDo(String maCapDo) {
		this.maCapDo = maCapDo;
	}

	public String getCauHoi() {
		return cauHoi;
	}

	public void setCauHoi(String cauHoi) {
		this.cauHoi = cauHoi;
	}

	public ArrayList<CapDo> getListCapDo() {
		return listCapDo;
	}

	public void setListCapDo(ArrayList<CapDo> listCapDo) {
		this.listCapDo = listCapDo;
	}

	@Override
	public void reset(ActionMapping mapping, HttpServletRequest request) {
		try {
			request.setCharacterEncoding("UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
	}
}
