package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import form.DangNhapForm;
import form.ThanhVienForm;
import model.bean.ThanhVien;
import model.bo.ThanhVienBO;

public class ThongTinThanhVienAction extends Action{

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");
		ThanhVienForm thanhVienForm = (ThanhVienForm) form;
		try {
			DangNhapForm dangNhapForm = (DangNhapForm) request.getSession().getAttribute("dangNhapForm");
			String capQuyen = dangNhapForm.getChucVu();
			ThanhVienBO thanhVienBO = new ThanhVienBO();
			if ("3".equals(capQuyen)){
				String maThanhVien = thanhVienForm.getMaThanhVien();
				boolean chucVu = thanhVienForm.isChucVu();
				System.out.println("maThanhVien"+maThanhVien);
				System.out.println("chucVu"+chucVu);
				if (chucVu == false){
					ThanhVien thanhVien = thanhVienBO.chonThanhVien(maThanhVien);
					thanhVienForm.setThanhVien(thanhVien);
					if (thanhVien != null){
						return mapping.findForward("hienThiThongTinThanhVien");
					} else {
						return mapping.findForward("loiHienThiThongTinThanhVien");
					}
				} else {
					ThanhVien thanhVien = thanhVienBO.chonThanhVien(maThanhVien);
					thanhVienForm.setThanhVien(thanhVien);
					if (thanhVien != null){
						return mapping.findForward("hienThiThongTinCongTacVien");
					} else {
						return mapping.findForward("loiHienThiThongTinCongTacVien");
					}
				}
			} else if ("1".equals(capQuyen)){
				String maThanhVien = dangNhapForm.getMaThanhVien();
				ThanhVien thanhVien = thanhVienBO.chonThanhVien(maThanhVien);
				thanhVienForm.setThanhVien(thanhVien);
				return mapping.findForward("thongTinCongTacVien");
			} else {
				String maThanhVien = dangNhapForm.getMaThanhVien();
				ThanhVien thanhVien = thanhVienBO.chonThanhVien(maThanhVien);
				thanhVienForm.setThanhVien(thanhVien);
				return mapping.findForward("thongTinThanhVien");
			}
		} catch (Exception e) {
			return mapping.findForward("dangNhap");
		}
		
		
		
		
	}
}
