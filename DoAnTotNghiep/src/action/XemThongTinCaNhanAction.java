package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.bean.ThanhVien;
import model.bo.TaiKhoanBO;
import model.bo.ThanhVienBO;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

import common.StringProcess;
import common.Validations;

import form.DangNhapForm;
import form.ThanhVienForm;

public class XemThongTinCaNhanAction extends Action {

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		ThanhVienForm thanhVienForm = (ThanhVienForm) form;
		DangNhapForm dangNhapForm = (DangNhapForm) request.getSession()
				.getAttribute("dangNhapForm");
		if (dangNhapForm != null) {
			String maThanhVien = dangNhapForm.getMaThanhVien();
			ThanhVienBO thanhVienBO = new ThanhVienBO();
			ThanhVien thanhVien = thanhVienBO.chonThanhVien(maThanhVien);
			if (thanhVienForm.getSubmit() != null) {
				if ("Đổi mật khẩu".equals(StringProcess.toUTF8(thanhVienForm
						.getSubmit()))) {

					String maTaiKhoan = dangNhapForm.getTaiKhoan()
							.getMaTaiKhoan();
					String matKhauCu = dangNhapForm.getTaiKhoan().getMatKhau();
					System.out.println("mkCu = " + matKhauCu);
					
					String nhapMatKhauCu = thanhVienForm.getMatKhauCu();
					String nhapMatKhauMoi = thanhVienForm.getMatKhauMoi();
					String nhapLaiMatKhau = thanhVienForm.getNhapLaiMatKhau();
					System.out.println("nmkCu = " + nhapMatKhauCu);
					ActionErrors actionErrors = new ActionErrors();
					if (Validations.validateNull(nhapMatKhauCu)) {
						actionErrors.add("maKhauCuError", new ActionMessage(
								"error.maKhauCu.Trong"));
						System.out.println("MKCu trong !");
					} else if (!Validations.validateTrungMatKhau(matKhauCu,
							nhapMatKhauCu)) {
						actionErrors.add("maKhauCuError", new ActionMessage(
								"error.maKhauCuError.khongTrung"));
						System.out.println("MKCu KTrung !");
					}
					if (Validations.validateNull(nhapMatKhauMoi)) {
						actionErrors.add("maKhauError", new ActionMessage(
								"error.matKhau.Trong"));
					} else if (Validations.validateSpace(nhapMatKhauMoi)) {
						actionErrors.add("matKhauError", new ActionMessage(
								"error.toanSpace"));
					}
					if (!Validations.validateTrungMatKhau(nhapMatKhauMoi,
							nhapLaiMatKhau)) {
						actionErrors.add("nhapLaiMatKhauMoiError",
								new ActionMessage("error.trungMatKhau.loi"));
					}
					saveErrors(request, actionErrors);

					if (actionErrors.size() > 0) {
						if (thanhVien.getChucVu() == true) {
							thanhVienForm.setThanhVien(thanhVien);
							return mapping
									.findForward("hienThiThongTinCaNhanCongTacVien");
						} else {
							thanhVienForm.setThanhVien(thanhVien);
							return mapping
									.findForward("hienThiThongTinCaNhanThanhVien");
						}
					}

					TaiKhoanBO taiKhoanBO = new TaiKhoanBO();
					if (taiKhoanBO.doiMatKhau(maTaiKhoan, nhapMatKhauMoi)) {
						return mapping.findForward("doiMatKhauThanhCong");
					} else {
						if (thanhVien.getChucVu() == true) {
							thanhVienForm.setThanhVien(thanhVien);
							return mapping
									.findForward("hienThiThongTinCaNhanCongTacVien");
						} else {
							thanhVienForm.setThanhVien(thanhVien);
							return mapping
									.findForward("hienThiThongTinCaNhanThanhVien");
						}
					}
				} else {
					if (thanhVien.getChucVu() == true) {
						thanhVienForm.setThanhVien(thanhVien);
						return mapping
								.findForward("hienThiThongTinCaNhanCongTacVien");
					} else {
						thanhVienForm.setThanhVien(thanhVien);
						return mapping
								.findForward("hienThiThongTinCaNhanThanhVien");
					}
				}
			} else {
				if (thanhVien.getChucVu() == true) {
					thanhVienForm.setThanhVien(thanhVien);
					return mapping
							.findForward("hienThiThongTinCaNhanCongTacVien");
				} else {
					thanhVienForm.setThanhVien(thanhVien);
					return mapping
							.findForward("hienThiThongTinCaNhanThanhVien");
				}
			}
		} else {
			return mapping.findForward("dangXuat");
		}

	}
}
