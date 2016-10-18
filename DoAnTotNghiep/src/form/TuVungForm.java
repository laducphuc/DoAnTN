package form;

import java.util.ArrayList;

import org.apache.struts.action.ActionForm;
import org.apache.struts.upload.FormFile;

import model.bean.TuVung;

public class TuVungForm extends ActionForm {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String maTu;
	private String mucTu;
	private FormFile amThanh;
	private String dichNghia;
	private TuVung tuVung;
	private String submit;

	public String getSubmit() {
		return submit;
	}

	public void setSubmit(String submit) {
		this.submit = submit;
	}

	private ArrayList<TuVung> listTuVung;

	public String getMaTu() {
		return maTu;
	}

	public void setMaTu(String maTu) {
		this.maTu = maTu;
	}

	public String getMucTu() {
		return mucTu;
	}

	public void setMucTu(String mucTu) {
		this.mucTu = mucTu;
	}

	public FormFile getAmThanh() {
		return amThanh;
	}

	public void setAmThanh(FormFile amThanh) {
		this.amThanh = amThanh;
	}

	public String getDichNghia() {
		return dichNghia;
	}

	public void setDichNghia(String dichNghia) {
		this.dichNghia = dichNghia;
	}

	public TuVung getTuVung() {
		return tuVung;
	}

	public void setTuVung(TuVung tuVung) {
		this.tuVung = tuVung;
	}

	public ArrayList<TuVung> getListTuVung() {
		return listTuVung;
	}

	public void setListTuVung(ArrayList<TuVung> listTuVung) {
		this.listTuVung = listTuVung;
	}

}
