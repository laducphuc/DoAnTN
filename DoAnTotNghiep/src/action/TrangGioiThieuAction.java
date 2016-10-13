package action;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.bean.BaiViet;
import model.bean.ThanhVien;
import model.bo.BaiVietBO;
import model.bo.ThanhVienBO;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import form.TrangChuForm;

public class TrangGioiThieuAction extends Action {

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		// TODO Auto-generated method stub
		response.setCharacterEncoding("utf-8");
		
		TrangChuForm trangChuForm=(TrangChuForm)form;
		BaiVietBO baiVietBO= new BaiVietBO();
		ThanhVienBO thanhVienBO= new ThanhVienBO();
		
		ArrayList<ArrayList<BaiViet>> danhSachBaiVietMoiNhat;
		ArrayList<ArrayList<ThanhVien>> topThanhVien, topCongTacVien;
		danhSachBaiVietMoiNhat=baiVietBO.danhSachBaiVietMoiNhat();
		topCongTacVien=thanhVienBO.danhSachTopCongTacVien();
		topThanhVien=thanhVienBO.danhSachTopThanhVien();
		trangChuForm.setDanhSachBaiVietMoiNhat(danhSachBaiVietMoiNhat);
		trangChuForm.setTopCongTacVien(topCongTacVien);
		trangChuForm.setTopThanhVien(topThanhVien);
		return mapping.findForward("trangGioiThieu");
	}
	
	
}
