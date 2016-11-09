package form;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;

import model.bean.BaiThi;
import model.bean.CapDo;
import model.bean.CauHoi;

public class ThiForm extends ActionForm {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String tenCapDo,tenDe;
	private String soBaiThi;
	private ArrayList<BaiThi> listBaiThi;
	private ArrayList<CauHoi> listCauHoi;
	private String maCapDo;
	private String maDeThi;
	private ArrayList<CapDo> listCapDo;
	private String timKiem;
	private String btnSubmit;
	private String[] chonPhuongAn;
	private String chonPhuongAn1;
	private String chonPhuongAn2;
	private String chonPhuongAn3;
	private String chonPhuongAn4;
	private String chonPhuongAn5;
	private String chonPhuongAn6;
	private String chonPhuongAn7;
	private String chonPhuongAn8;
	private String chonPhuongAn9;
	private String chonPhuongAn10;
	private String chonPhuongAn11;
	private String chonPhuongAn12;
	private String chonPhuongAn13;
	private String chonPhuongAn14;
	private String chonPhuongAn15;
	private String chonPhuongAn16;
	private String chonPhuongAn17;
	private String chonPhuongAn18;
	private String chonPhuongAn19;
	private String chonPhuongAn20;
	private String chonPhuongAn21;
	private String chonPhuongAn22;
	private String chonPhuongAn23;
	private String chonPhuongAn24;
	private String chonPhuongAn25;
	private String chonPhuongAn26;
	private String chonPhuongAn27;
	private String chonPhuongAn28;
	private String chonPhuongAn29;
	private String chonPhuongAn30;
	private String chonPhuongAn33;
	
	public String getChonPhuongAn11() {
		return chonPhuongAn11;
	}

	public void setChonPhuongAn11(String chonPhuongAn11) {
		this.chonPhuongAn11 = chonPhuongAn11;
	}

	public String getChonPhuongAn12() {
		return chonPhuongAn12;
	}

	public void setChonPhuongAn12(String chonPhuongAn12) {
		this.chonPhuongAn12 = chonPhuongAn12;
	}

	public String getChonPhuongAn13() {
		return chonPhuongAn13;
	}

	public void setChonPhuongAn13(String chonPhuongAn13) {
		this.chonPhuongAn13 = chonPhuongAn13;
	}

	public String getChonPhuongAn14() {
		return chonPhuongAn14;
	}

	public void setChonPhuongAn14(String chonPhuongAn14) {
		this.chonPhuongAn14 = chonPhuongAn14;
	}

	public String getChonPhuongAn15() {
		return chonPhuongAn15;
	}

	public void setChonPhuongAn15(String chonPhuongAn15) {
		this.chonPhuongAn15 = chonPhuongAn15;
	}

	public String getChonPhuongAn16() {
		return chonPhuongAn16;
	}

	public void setChonPhuongAn16(String chonPhuongAn16) {
		this.chonPhuongAn16 = chonPhuongAn16;
	}

	public String getChonPhuongAn17() {
		return chonPhuongAn17;
	}

	public void setChonPhuongAn17(String chonPhuongAn17) {
		this.chonPhuongAn17 = chonPhuongAn17;
	}

	public String getChonPhuongAn18() {
		return chonPhuongAn18;
	}

	public void setChonPhuongAn18(String chonPhuongAn18) {
		this.chonPhuongAn18 = chonPhuongAn18;
	}

	public String getChonPhuongAn19() {
		return chonPhuongAn19;
	}

	public void setChonPhuongAn19(String chonPhuongAn19) {
		this.chonPhuongAn19 = chonPhuongAn19;
	}

	public String getChonPhuongAn20() {
		return chonPhuongAn20;
	}

	public void setChonPhuongAn20(String chonPhuongAn20) {
		this.chonPhuongAn20 = chonPhuongAn20;
	}

	public String getChonPhuongAn21() {
		return chonPhuongAn21;
	}

	public void setChonPhuongAn21(String chonPhuongAn21) {
		this.chonPhuongAn21 = chonPhuongAn21;
	}

	public String getChonPhuongAn22() {
		return chonPhuongAn22;
	}

	public void setChonPhuongAn22(String chonPhuongAn22) {
		this.chonPhuongAn22 = chonPhuongAn22;
	}

	public String getChonPhuongAn23() {
		return chonPhuongAn23;
	}

	public void setChonPhuongAn23(String chonPhuongAn23) {
		this.chonPhuongAn23 = chonPhuongAn23;
	}

	public String getChonPhuongAn24() {
		return chonPhuongAn24;
	}

	public void setChonPhuongAn24(String chonPhuongAn24) {
		this.chonPhuongAn24 = chonPhuongAn24;
	}

	public String getChonPhuongAn25() {
		return chonPhuongAn25;
	}

	public void setChonPhuongAn25(String chonPhuongAn25) {
		this.chonPhuongAn25 = chonPhuongAn25;
	}

	public String getChonPhuongAn26() {
		return chonPhuongAn26;
	}

	public void setChonPhuongAn26(String chonPhuongAn26) {
		this.chonPhuongAn26 = chonPhuongAn26;
	}

	public String getChonPhuongAn27() {
		return chonPhuongAn27;
	}

	public void setChonPhuongAn27(String chonPhuongAn27) {
		this.chonPhuongAn27 = chonPhuongAn27;
	}

	public String getChonPhuongAn28() {
		return chonPhuongAn28;
	}

	public void setChonPhuongAn28(String chonPhuongAn28) {
		this.chonPhuongAn28 = chonPhuongAn28;
	}

	public String getChonPhuongAn29() {
		return chonPhuongAn29;
	}

	public void setChonPhuongAn29(String chonPhuongAn29) {
		this.chonPhuongAn29 = chonPhuongAn29;
	}

	public String getChonPhuongAn30() {
		return chonPhuongAn30;
	}

	public void setChonPhuongAn30(String chonPhuongAn30) {
		this.chonPhuongAn30 = chonPhuongAn30;
	}

	public String getChonPhuongAn33() {
		return chonPhuongAn33;
	}

	public void setChonPhuongAn33(String chonPhuongAn33) {
		this.chonPhuongAn33 = chonPhuongAn33;
	}

	private int diemThi;
	private ArrayList<String> listPhuongAn;
	public String[] getChonPhuongAn() {
		return chonPhuongAn;
	}

	public String getTenDe() {
		return tenDe;
	}

	public void setTenDe(String tenDe) {
		this.tenDe = tenDe;
	}

	public String getChonPhuongAn1() {
		return chonPhuongAn1;
	}

	public void setChonPhuongAn1(String chonPhuongAn1) {
		this.chonPhuongAn1 = chonPhuongAn1;
	}

	public String getChonPhuongAn2() {
		return chonPhuongAn2;
	}

	public void setChonPhuongAn2(String chonPhuongAn2) {
		this.chonPhuongAn2 = chonPhuongAn2;
	}

	public String getChonPhuongAn3() {
		return chonPhuongAn3;
	}

	public void setChonPhuongAn3(String chonPhuongAn3) {
		this.chonPhuongAn3 = chonPhuongAn3;
	}

	public String getChonPhuongAn4() {
		return chonPhuongAn4;
	}

	public void setChonPhuongAn4(String chonPhuongAn4) {
		this.chonPhuongAn4 = chonPhuongAn4;
	}

	public String getChonPhuongAn5() {
		return chonPhuongAn5;
	}

	public void setChonPhuongAn5(String chonPhuongAn5) {
		this.chonPhuongAn5 = chonPhuongAn5;
	}

	public String getChonPhuongAn6() {
		return chonPhuongAn6;
	}

	public void setChonPhuongAn6(String chonPhuongAn6) {
		this.chonPhuongAn6 = chonPhuongAn6;
	}

	public String getChonPhuongAn7() {
		return chonPhuongAn7;
	}

	public void setChonPhuongAn7(String chonPhuongAn7) {
		this.chonPhuongAn7 = chonPhuongAn7;
	}

	public String getChonPhuongAn8() {
		return chonPhuongAn8;
	}

	public void setChonPhuongAn8(String chonPhuongAn8) {
		this.chonPhuongAn8 = chonPhuongAn8;
	}

	public String getChonPhuongAn9() {
		return chonPhuongAn9;
	}

	public void setChonPhuongAn9(String chonPhuongAn9) {
		this.chonPhuongAn9 = chonPhuongAn9;
	}

	public String getChonPhuongAn10() {
		return chonPhuongAn10;
	}

	public void setChonPhuongAn10(String chonPhuongAn10) {
		this.chonPhuongAn10 = chonPhuongAn10;
	}

	public int getDiemThi() {
		return diemThi;
	}

	public void setDiemThi(int diemThi) {
		this.diemThi = diemThi;
	}

	public ArrayList<String> getListPhuongAn() {
		return listPhuongAn;
	}

	public void setListPhuongAn(ArrayList<String> listPhuongAn) {
		this.listPhuongAn = listPhuongAn;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public void setChonPhuongAn(String[] chonPhuongAn) {
		this.chonPhuongAn = chonPhuongAn;
	}

	public String getBtnSubmit() {
		return btnSubmit;
	}

	public void setBtnSubmit(String btnSubmit) {
		this.btnSubmit = btnSubmit;
	}

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

	@Override
	public void reset(ActionMapping mapping, HttpServletRequest request) {
		try {
			request.setCharacterEncoding("UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
	}
}
