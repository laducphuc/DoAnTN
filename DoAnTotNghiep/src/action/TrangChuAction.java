package action;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import common.StringProcess;
import form.DangNhapForm;
import form.TrangChuForm;
import model.bean.BaiViet;
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
		String kiemTra = trangChuForm.getKiemTra();
		System.out.println(kiemTra);
		String maDanhMuc = trangChuForm.getMaDanhMuc();
		String noiDungTimKiem = StringProcess.toUTF8(trangChuForm.getNoiDungTimKiem());
		System.out.println("noiDungTimKiem" + noiDungTimKiem);
		System.out.println(maDanhMuc);
		BaiVietBO baiVietBo = new BaiVietBO();
		ThongKeBO thongKeBo = new ThongKeBO();
		String avatar = baiVietBo.getAvarta();
		danhSachBaiViet = baiVietBo.danhSachBaiVietTrangChu();
		int soTrang = trangChuForm.getSoTrang();
		System.out.println("số trang" + soTrang);
		System.out.println("số size" + danhSachBaiViet.size());
		ArrayList<BaiViet> danhSachBaiVietHienThi = danhSachBaiViet;
		List<BaiViet> bXHBaiViet = thongKeBo.bangXepHangBaiViet();
		/*
		 * List<ThanhVien> bXHThanhVien = thongKeBo.bangXepHangThanhVien();
		 * List<ThanhVien> bXHCongTacVien = thongKeBo.bangXepHangCongTacVien();
		 * bXHBaiViet = danhSachBaiViet.subList(0, 5); bXHThanhVien =
		 * bXHThanhVien.subList(0, 3); bXHCongTacVien =
		 * bXHCongTacVien.subList(0, 3); System.out.println(avatar);
		 */
		trangChuForm.setAvatar(avatar);
		trangChuForm.setbXHBaiViet(bXHBaiViet);
		/*
		 * trangChuForm.setbXHThanhVien(bXHThanhVien);
		 * trangChuForm.setbXHCongTacVien(bXHCongTacVien);
		 */
		trangChuForm.setDanhSachBaiVietHienThi(danhSachBaiVietHienThi);
		trangChuForm.setDanhSachBaiVietMoiNhat(baiVietBo.chiaDanhSachCon(danhSachBaiVietHienThi, 3));
		int tam = (danhSachBaiViet.size() / 10) + 1;
		trangChuForm.setTongSoTrang(tam);
		try {
			DangNhapForm dangNhapForm = (DangNhapForm) request.getSession()
					.getAttribute("dangNhapForm");
			String chucVu = dangNhapForm.getTaiKhoan().getChucVu();
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
