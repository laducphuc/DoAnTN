package form;

import java.util.List;

import org.apache.struts.action.ActionForm;

public class ThemBaiHocForm extends ActionForm {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String maCapDo;
	private String tenBaiHoc;
	private String nguPhap;
	private List<String> listTuVung;
	private String nghe;
	private String sound;
	private String thongBao;
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

	public List<String> getListTuVung() {
		return listTuVung;
	}

	public void setListTuVung(List<String> listTuVung) {
		this.listTuVung = listTuVung;
	}

	public String getNghe() {
		return nghe;
	}

	public void setNghe(String nghe) {
		this.nghe = nghe;
	}

	public String getSound() {
		return sound;
	}

	public void setSound(String sound) {
		this.sound = sound;
	}

}
