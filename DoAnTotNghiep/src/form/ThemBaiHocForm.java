package form;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.upload.FormFile;

import model.bean.CapDo;
import model.bean.TuVung;

public class ThemBaiHocForm extends ActionForm {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String maCapDo;
	private String tenBaiHoc;
	private String nguPhap;
	private ArrayList<TuVung> listTuVung;
	private String tuVung;
	private String nghe;
	private FormFile sound;
	private String thongBao;
	private int tongTuVung;
	private ArrayList<CapDo> listCapDo;
	private String[] chonTuVung;
	private String submit;
	private String maBaiHoc;
	private String kt;
	private String file;

	public String getFile() {
		return file;
	}

	public void setFile(String file) {
		this.file = file;
	}

	public String getKt() {
		return kt;
	}

	public void setKt(String kt) {
		this.kt = kt;
	}

	public String getMaBaiHoc() {
		return maBaiHoc;
	}

	public void setMaBaiHoc(String maBaiHoc) {
		this.maBaiHoc = maBaiHoc;
	}

	public String getSubmit() {
		return submit;
	}

	public void setSubmit(String submit) {
		this.submit = submit;
	}

	public String[] getChonTuVung() {
		return chonTuVung;
	}

	public void setChonTuVung(String[] chonTuVung) {
		this.chonTuVung = chonTuVung;
	}

	public int getTongTuVung() {
		return tongTuVung;
	}

	public void setTongTuVung(int tongTuVung) {
		this.tongTuVung = tongTuVung;
	}

	public ArrayList<CapDo> getListCapDo() {
		return listCapDo;
	}

	public void setListCapDo(ArrayList<CapDo> listCapDo) {
		this.listCapDo = listCapDo;
	}

	public String getTuVung() {
		return tuVung;
	}

	public void setTuVung(String tuVung) {
		this.tuVung = tuVung;
	}

	public String getThongBao() {
		return thongBao;
	}

	public void setThongBao(String thongBao) {
		this.thongBao = thongBao;
	}

	public String getMaCapDo() {
		return maCapDo;
	}

	public void setMaCapDo(String maCapDo) {
		this.maCapDo = maCapDo;
	}

	public String getTenBaiHoc() {
		return tenBaiHoc;
	}

	public void setTenBaiHoc(String tenBaiHoc) {
		this.tenBaiHoc = tenBaiHoc;
	}

	public String getNguPhap() {
		return nguPhap;
	}

	public void setNguPhap(String nguPhap) {
		this.nguPhap = nguPhap;
	}

	public ArrayList<TuVung> getListTuVung() {
		return listTuVung;
	}

	public void setListTuVung(ArrayList<TuVung> listTuVung) {
		this.listTuVung = listTuVung;
	}

	public String getNghe() {
		return nghe;
	}

	public void setNghe(String nghe) {
		this.nghe = nghe;
	}

	public FormFile getSound() {
		return sound;
	}

	public void setSound(FormFile sound) {
		this.sound = sound;
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
