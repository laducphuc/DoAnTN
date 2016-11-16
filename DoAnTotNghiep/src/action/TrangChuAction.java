package action;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import form.DangNhapForm;
import form.TrangChuForm;
import model.bean.BaiViet;
import model.bean.ThanhVien;
import model.bo.BaiVietBO;
import model.bo.ThongKeBO;

public class TrangChuAction extends Action {

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=UTF-8");
		TrangChuForm trangChuForm = (TrangChuForm) form;
		System.out.println("kết nối thành công trang chủ");
		ArrayList<BaiViet> danhSachBaiViet;
		BaiVietBO baiVietBo = new BaiVietBO();
		ThongKeBO thongKeBo = new ThongKeBO();
		danhSachBaiViet = baiVietBo.danhSachBaiVietTrangChu();
		ArrayList<BaiViet> danhSachBaiVietHienThi = danhSachBaiViet;
		ThanhVien thanhVienMoi=thongKeBo.thanhVienNew();
		trangChuForm.setThanhVienMoi(thanhVienMoi.getTenThanhVien());
		trangChuForm.setDanhSachBaiVietHienThi(danhSachBaiVietHienThi);
		trangChuForm.setSoThanhVien(thongKeBo.soThanhVien());
		trangChuForm.setDanhSachBaiVietMoiNhat(baiVietBo.chiaDanhSachCon(danhSachBaiVietHienThi, 3));
		int tam = (danhSachBaiViet.size() / 10) + 1;
		trangChuForm.setTongSoTrang(tam);
		try {
			DangNhapForm dangNhapForm = (DangNhapForm) request.getSession()
					.getAttribute("dangNhapForm");
			String chucVu = dangNhapForm.getTaiKhoan().getChucVu();
			System.out.println("chuc vu :"+chucVu);
			if ("0".equals(chucVu)) {
				return mapping.findForward("trangChuThanhVien");
			} else if ("1".equals(chucVu)) {
				System.out.println("CTVien");
				return mapping.findForward("trangChuCongTacVien");
			} else {
				return mapping.findForward("trangChuAdmin");
			}
		} catch (Exception e) {
			return mapping.findForward("trangChu");
		}
	}
}
