package action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import form.BaiVietForm;
import form.DangNhapForm;
import model.bean.BaiViet;
import model.bean.TaiKhoan;
import model.bo.BaiVietBO;
import model.bo.DanhGiaBO;
import model.bo.ThongKeBO;

public class XemBaiVietAction extends Action {

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		BaiVietForm baiVietForm = (BaiVietForm) form;
		String maBaiViet = baiVietForm.getMaBaiViet();
		try {
			DangNhapForm dangNhapForm = (DangNhapForm) request.getSession()
					.getAttribute("dangNhapForm");
			if (dangNhapForm != null && dangNhapForm.getTaiKhoan() != null) {
				TaiKhoan taiKhoan = dangNhapForm.getTaiKhoan();
				System.out.println("tk=====" + taiKhoan.getChucVu());

				System.out.println("maBaiViet = " + maBaiViet);
				BaiVietBO baiVietBO = new BaiVietBO();
				DanhGiaBO danhGiaBO = new DanhGiaBO();
				String maThanhVien = dangNhapForm.getMaThanhVien();
				String daXem = baiVietForm.getDaXem();
				if (daXem == null) {
					baiVietBO.tangLuotXemBaiViet(maBaiViet);
				}
				ThongKeBO thongKeBo = new ThongKeBO();
				List<BaiViet> bXHBaiViet = thongKeBo.bangXepHangBaiViet();
				BaiViet baiViet = baiVietBO.thongTinBaiViet(maBaiViet);
				if (danhGiaBO.kiemTraThichBaiViet(maThanhVien, maBaiViet)) {
					baiVietForm.setThich("daThich");
					baiViet.setSoThich(baiViet.getSoThich() - 1);
				} else {
					baiVietForm.setThich("chuaThich");
				}

				bXHBaiViet = bXHBaiViet.subList(0, 5);
				baiVietForm.setBaiViet(baiViet);
				baiVietForm.setDaXem("daXem");
				return mapping.findForward("xemBaiViet");
			} else {
				BaiVietBO baiVietBO = new BaiVietBO();
				BaiViet baiViet = baiVietBO.thongTinBaiViet(maBaiViet);
				ThongKeBO thongKeBo = new ThongKeBO();
				List<BaiViet> bXHBaiViet = thongKeBo.bangXepHangBaiViet();
				bXHBaiViet = bXHBaiViet.subList(0, 5);
				baiVietForm.setBaiViet(baiViet);
				return mapping.findForward("xemBaiViet");
			}
		} catch (Exception e) {
			e.printStackTrace();
			return mapping.findForward("dangNhap");
		}

	}
}