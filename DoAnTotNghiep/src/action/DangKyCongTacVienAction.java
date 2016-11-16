package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.upload.FormFile;

import common.ManageImage;
import common.StringProcess;
import common.Validations;
import form.DangKyThanhVienForm;
import model.bean.ThanhVien;
import model.bo.ThanhVienBO;

public class DangKyCongTacVienAction extends Action {
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");
		DangKyThanhVienForm dangKyForm = (DangKyThanhVienForm) form;

		if (dangKyForm.getSubmit() != null) {
			String dangKy = dangKyForm.getSubmit();
			String tenThanhVien = dangKyForm.getTenThanhVien();
			String gioiTinh = null;
			if (dangKyForm.getGioiTinh() == 1) {
				gioiTinh = "Nam";
			} else {
				gioiTinh = "Nữ";
			}
			String ngaySinh = dangKyForm.getNgaySinh();
			String diaChi = dangKyForm.getDiaChi();
			String soDienThoai = dangKyForm.getSoDienThoai();
			String email = dangKyForm.getEmail();
			String tenTaiKhoan = dangKyForm.getTenTaiKhoan();
			String matKhau = dangKyForm.getMatKhau();
			String nhapLaiMatKhau = dangKyForm.getNhapLaiMatKhau();
			FormFile file = dangKyForm.getFile();
			ManageImage manageImage= new ManageImage();
			String anh = manageImage.luuAnhDaiDien(file, request,getServlet());
			ThanhVienBO thanhVienBO = new ThanhVienBO();

			// Nhấp vào button Thêm mới
			if ("Thêm mới".equals(dangKy)) {
				ActionErrors actionErrors = new ActionErrors();
				if (Validations.validateNull(tenThanhVien)) {
					actionErrors.add("tenThanhVienError", new ActionMessage(
							"error.tenThanhVien.Trong"));
				} else if (Validations.validateTenThanhVien(tenThanhVien)) {
					actionErrors.add("tenThanhVienError", new ActionMessage(
							"error.tenThanhVien.quaDoDai"));
				} else if (Validations.validateSpace(tenThanhVien)) {
					actionErrors.add("tenThanhVienError", new ActionMessage(
							"error.toanSpace"));
				}
				if (Validations.isAvataEmpty(anh)) {
					actionErrors.add("anhDaiDienError", new ActionMessage(
							"error.anhDaiDien.Trong"));
				}
				if (Validations.validateNull(ngaySinh)) {
					actionErrors.add("ngaySinhError", new ActionMessage(
							"error.ngaySinh.Trong"));
				} else if (!Validations.ktLonHonNgayHienTai(ngaySinh)) {
					actionErrors.add("ngaySinhError", new ActionMessage(
							"error.ngaySinh.Loi"));
				}
				if (Validations.validateNull(diaChi)) {
					actionErrors.add("diaChiError", new ActionMessage(
							"error.diaChi.Trong"));
				} else if (Validations.validateDiaChi(diaChi)) {
					actionErrors.add("diaChiError", new ActionMessage(
							"error.diaChi.quaDoDai"));
				} else if (Validations.validateSpace(diaChi)) {
					actionErrors.add("diaChiError", new ActionMessage(
							"error.toanSpace"));
				}

				if (Validations.validateNull(soDienThoai)) {
					actionErrors.add("soDienThoaiError", new ActionMessage(
							"error.soDienThoai.Trong"));
				} else if (Validations.validateSpace(soDienThoai)) {
					actionErrors.add("soDienThoaiError", new ActionMessage(
							"error.toanSpace"));
				} else if (!Validations.validatePhoneNumber(soDienThoai)) {
					actionErrors.add("soDienThoaiError", new ActionMessage(
							"error.soDienThoai.format"));
				}

				if (Validations.validateNull(email)) {
					actionErrors.add("emailError", new ActionMessage(
							"error.email.Trong"));
				} else if (Validations.validateSpace(email)) {
					actionErrors.add("emailError", new ActionMessage(
							"error.toanSpace"));
				} else if (!Validations.validateEmailAddress(email)) {
					actionErrors.add("emailError", new ActionMessage(
							"error.email.format"));
				}
				if (thanhVienBO.kiemTraEmailTonTai(email)) {
					actionErrors.add("emailError", new ActionMessage(
							"error.email.tonTai"));
				}

				if (Validations.validateNull(tenTaiKhoan)) {
					actionErrors.add("tenTaiKhoanError", new ActionMessage(
							"error.tenTaiKhoan.Trong"));
				} else if (Validations.validateTenTaiKhoan(tenTaiKhoan)) {
					actionErrors.add("tenTaiKhoanError", new ActionMessage(
							"error.tenTaiKhoan.quaDoDai"));
				} else if (Validations.validateSpace(tenTaiKhoan)) {
					actionErrors.add("tenTaiKhoanError", new ActionMessage(
							"error.toanSpace"));
				}
				if (Validations.validateNull(matKhau)) {
					actionErrors.add("matKhauError", new ActionMessage(
							"error.matKhau.Trong"));
				} else if (Validations.validateSpace(matKhau)) {
					actionErrors.add("matKhauError", new ActionMessage(
							"error.toanSpace"));
				}

				if (!Validations.validateTrungMatKhau(matKhau, nhapLaiMatKhau)) {
					actionErrors.add("trungMatKhauError", new ActionMessage(
							"error.trungMatKhau.loi"));
				}

				if (thanhVienBO.kiemTraTaiKhoan(tenTaiKhoan)) {
					actionErrors.add("tenTaiKhoanError", new ActionMessage(
							"error.tenTaiKhoanToiTai.loi"));
				}
				saveErrors(request, actionErrors);

				if (actionErrors.size() > 0) {
					return mapping.findForward("dangKyCongTacVien");
				}

				// Tạo đối tượng để lưu vào CSDL
				ThanhVien thanhVien = new ThanhVien();
				thanhVien.setTenThanhVien(tenThanhVien);
				thanhVien.setGioiTinh(gioiTinh);
				thanhVien.setNgaySinh(ngaySinh);
				thanhVien.setDiaChi(diaChi);
				thanhVien.setSoDienThoai(soDienThoai);
				thanhVien.setEmail(email);
				thanhVien.setTenTaiKhoan(tenTaiKhoan);
				thanhVien.setMaKhau(matKhau);
				thanhVien.setAnh(anh);
				
				if (thanhVienBO.chenCongTacVien(thanhVien)) {
					return mapping.findForward("dangKyCongTacVienThanhCong");
				} else {
					dangKyForm.setTenThanhVien(tenThanhVien);
					dangKyForm.setDiaChi(diaChi);
					return mapping.findForward("dangKyCongTacVien");
				}
			} else {
				dangKyForm.setTenThanhVien(tenThanhVien);
				dangKyForm.setDiaChi(diaChi);
				return mapping.findForward("dangKyCongTacVien");
			}
		} else {
			return mapping.findForward("dangKyCongTacVien");
		}
	}

}