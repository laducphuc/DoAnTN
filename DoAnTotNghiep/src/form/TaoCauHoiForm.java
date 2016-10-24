package form;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.upload.FormFile;

import model.bean.CapDo;
import model.bean.CauHoi;

public class TaoCauHoiForm extends ActionForm {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private ArrayList<CapDo> listCapDo;
	private ArrayList<CauHoi> listCauHoi;
	private String[] soLuongPhuongAn = { "2", "3", "4", "5" };
	private String soPAChon; // so luong phuong an da chon
	private String noiDung;
	private String phuongAn1;
	private String phuongAn2;
	private String phuongAn3;
	private String phuongAn4;
	private String phuongAn5;
	private String dapAn[]; // nhung phuong an dung
	private String maCapDo;
	private FormFile hinhanhND;
	private FormFile hinhanhPA1;
	private FormFile hinhanhPA2;
	private FormFile hinhanhPA3;
	private FormFile hinhanhPA4;
	private FormFile hinhanhPA5;
	private String btnSubmit;

	public String getSoPAChon() {
		return soPAChon;
	}

	public void setSoPAChon(String soPAChon) {
		this.soPAChon = soPAChon;
	}

	public String[] getSoLuongPhuongAn() {
		return soLuongPhuongAn;
	}

	public void setSoLuongPhuongAn(String[] soLuongPhuongAn) {
		this.soLuongPhuongAn = soLuongPhuongAn;
	}

	public String getPhuongAn1() {
		return phuongAn1;
	}

	public void setPhuongAn1(String phuongAn1) {
		this.phuongAn1 = phuongAn1;
	}

	public String getPhuongAn2() {
		return phuongAn2;
	}

	public void setPhuongAn2(String phuongAn2) {
		this.phuongAn2 = phuongAn2;
	}

	public String getPhuongAn3() {
		return phuongAn3;
	}

	public void setPhuongAn3(String phuongAn3) {
		this.phuongAn3 = phuongAn3;
	}

	public String getPhuongAn4() {
		return phuongAn4;
	}

	public void setPhuongAn4(String phuongAn4) {
		this.phuongAn4 = phuongAn4;
	}

	public String getPhuongAn5() {
		return phuongAn5;
	}

	public void setPhuongAn5(String phuongAn5) {
		this.phuongAn5 = phuongAn5;
	}

	public String[] getDapAn() {
		return dapAn;
	}

	public void setDapAn(String[] dapAn) {
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

	public FormFile getHinhanhND() {
		return hinhanhND;
	}

	public void setHinhanhND(FormFile hinhanhND) {
		this.hinhanhND = hinhanhND;
	}

	public FormFile getHinhanhPA1() {
		return hinhanhPA1;
	}

	public void setHinhanhPA1(FormFile hinhanhPA1) {
		this.hinhanhPA1 = hinhanhPA1;
	}

	public FormFile getHinhanhPA2() {
		return hinhanhPA2;
	}

	public void setHinhanhPA2(FormFile hinhanhPA2) {
		this.hinhanhPA2 = hinhanhPA2;
	}

	public FormFile getHinhanhPA3() {
		return hinhanhPA3;
	}

	public void setHinhanhPA3(FormFile hinhanhPA3) {
		this.hinhanhPA3 = hinhanhPA3;
	}

	public FormFile getHinhanhPA4() {
		return hinhanhPA4;
	}

	public void setHinhanhPA4(FormFile hinhanhPA4) {
		this.hinhanhPA4 = hinhanhPA4;
	}

	public FormFile getHinhanhPA5() {
		return hinhanhPA5;
	}

	public void setHinhanhPA5(FormFile hinhanhPA5) {
		this.hinhanhPA5 = hinhanhPA5;
	}

	public String getBtnSubmit() {
		return btnSubmit;
	}

	public void setBtnSubmit(String btnSubmit) {
		this.btnSubmit = btnSubmit;
	}

	@Override
	public void reset(ActionMapping mapping, HttpServletRequest request) {
		try {
			request.setCharacterEncoding("UTF-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
