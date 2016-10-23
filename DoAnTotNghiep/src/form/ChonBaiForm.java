package form;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;

import model.bean.BaiHoc;
import model.bean.CapDo;

public class ChonBaiForm extends ActionForm{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	ArrayList<BaiHoc> listBaiHoc;
	private String maCapDo;
	private String soBaiHoc;
	private String tenCapDo;
	private ArrayList<CapDo> listCapDo;
	private String timKiem;
	private String maBaiHoc;
	
	public String getMaBaiHoc() {
		return maBaiHoc;
	}

	public void setMaBaiHoc(String maBaiHoc) {
		this.maBaiHoc = maBaiHoc;
	}

	public String getTenCapDo() {
		return tenCapDo;
	}

	public ArrayList<CapDo> getListCapDo() {
		return listCapDo;
	}

	public void setListCapDo(ArrayList<CapDo> listCapDo) {
		this.listCapDo = listCapDo;
	}

	public String getTimKiem() {
		return timKiem;
	}

	public void setTimKiem(String timKiem) {
		this.timKiem = timKiem;
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
