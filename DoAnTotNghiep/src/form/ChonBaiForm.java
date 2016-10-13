package form;

import java.util.ArrayList;

import org.apache.struts.action.ActionForm;

import model.bean.BaiHoc;

public class ChonBaiForm extends ActionForm{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	ArrayList<BaiHoc> listBaiHoc;
	private String maCapDo;
	private String soBaiHoc;
	private String tenCapDo;
	public String getTenCapDo() {
		return tenCapDo;
	}

	public void setTenCapDo(String tenCapDo) {
		this.tenCapDo = tenCapDo;
	}

	public ArrayList<BaiHoc> getListBaiHoc() {
		return listBaiHoc;
	}
	
	public String getSoBaiHoc() {
		return soBaiHoc;
	}

	public void setSoBaiHoc(String soBaiHoc) {
		this.soBaiHoc = soBaiHoc;
	}

	public void setListBaiHoc(ArrayList<BaiHoc> listBaiHoc) {
		this.listBaiHoc = listBaiHoc;
	}
	public String getMaCapDo() {
		return maCapDo;
	}
	public void setMaCapDo(String maCapDo) {
		this.maCapDo = maCapDo;
	}
}
