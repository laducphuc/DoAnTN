package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.bean.ThanhVien;
import model.bo.ThanhVienBO;

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
import form.DangNhapForm;
import form.ThanhVienForm;

public class CapNhatThanhVienAction extends Action {

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");

		ThanhVienForm thanhVienForm = (ThanhVienForm) form;
		DangNhapForm dangNhapForm = (DangNhapForm) request.getSession()
				.getAttribute("dangNhapForm");
		if (dangNhapForm != null) {
			String capQuyen = dangNhapForm.getChucVu();
			System.out.println("Capquyen = " + capQuyen);
			String maThanhVien = thanhVienForm.getMaThanhVien();
			String chucVu = thanhVienForm.isChucVu();

			ThanhVienBO thanhVienBO = new ThanhVienBO();

			if (thanhVienForm.getSubmit() != null) {
				String hoanTat = StringProcess
						.toUTF8(thanhVienForm.getSubmit());
				System.out.println("HoanTat = " + hoanTat);

				String tenThanhVien = StringProcess.toUTF8(thanhVienForm
						.getTenThanhVien());
				String ngaySinh = thanhVienForm.getNgaySinh();
				String gioiTinh;
				if (thanhVienForm.getGioiTinh() == 1) {
					gioiTinh = "Nam";
				} else {
					gioiTinh = "Nữ";
				}

				String diaChi = StringProcess.toUTF8(thanhVienForm.getDiaChi());
				String quocTich = thanhVienForm.getQuocTich();
				String ngonNgu = StringProcess.toUTF8(thanhVienForm
						.getNgonNgu());
				String soDienThoai = thanhVienForm.getSoDienThoai();
				String email = thanhVienForm.getEmail();
				FormFile file=thanhVienForm.getFile();
				
				if ("Hoàn tất".equals(hoanTat)) {

					ActionErrors actionErrors = new ActionErrors();
					if (Validations.validateNull(tenThanhVien)) {
						actionErrors.add("tenThanhVienError",
								new ActionMessage("error.tenThanhVien.Trong"));
					} else if (Validations.validateTenThanhVien(tenThanhVien)) {
						actionErrors
								.add("tenThanhVienError", new ActionMessage(
										"error.tenThanhVien.quaDoDai"));
					} else if (Validations.validateSpace(tenThanhVien)) {
						actionErrors.add("tenThanhVienError",
								new ActionMessage("error.toanSpace"));
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
					if (!Validations.ktLonHonNgayHienTai(ngaySinh)) {
						actionErrors.add("ngaySinhError", new ActionMessage(
								"error.ngaySinh.Loi"));
					}
					if (Validations.validateNull(soDienThoai)) {
						actionErrors.add("soDienThoaiError", new ActionMessage(
								"error.soDienThoai.Trong"));
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

					saveErrors(request, actionErrors);

					if (actionErrors.size() > 0) {
						if ("3".equals(capQuyen)) {
							if ("0".equals(chucVu)){
								thanhVienForm.setThanhVien(thanhVienBO
										.chonThanhVien(maThanhVien));
								return mapping
										.findForward("capNhatThanhVienAdmin");
							} else {
								thanhVienForm.setThanhVien(thanhVienBO
										.chonThanhVien(maThanhVien));
								return mapping
										.findForward("capNhatCongTacVienAdmin");
							}
						} else if ("1".equals(capQuyen)) {
							thanhVienForm.setThanhVien(thanhVienBO
									.chonThanhVien(maThanhVien));
							return mapping.findForward("capNhatCongTacVien");
						} else {
							thanhVienForm.setThanhVien(thanhVienBO
									.chonThanhVien(maThanhVien));
							return mapping.findForward("capNhatThanhVien");
						}
					}

					ThanhVien thanhVien = new ThanhVien();

					thanhVien.setMaThanhVien(maThanhVien);
					thanhVien.setTenThanhVien(tenThanhVien);
					thanhVien.setNgaySinh(ngaySinh);
					thanhVien.setGioiTinh(gioiTinh);
					thanhVien.setDiaChi(diaChi);
					thanhVien.setQuocTich(quocTich);
					thanhVien.setNgonNgu(ngonNgu);
					thanhVien.setSoDienThoai(soDienThoai);
					thanhVien.setEmail(email);

					if (thanhVienBO.capNhatThanhVien(thanhVien)) {
						if(file.getFileName()!=""){
							ManageImage.xoaAnhDaiDien(dangNhapForm.getTaiKhoan().getAnh(), getServlet());
							String anhDaiDien= ManageImage.luuAnhDaiDien(file, request, getServlet());
							thanhVienBO.capNhatAnhDaiDien(maThanhVien, anhDaiDien);
						}
						if ("3".equals(capQuyen)) {
							if ("0".equals(chucVu)){
								return mapping
										.findForward("capNhatThanhVienAdminThanhCong");
							} else {
								return mapping
										.findForward("capNhatCongTacVienAdminThanhCong");
							}
						} else if ("1".equals(capQuyen)) {
							return mapping
									.findForward("capNhatCongTacVienThanhCong");
						} else {
							return mapping
									.findForward("capNhatThanhVienThanhCong");
						}

					} else {
						if ("3".equals(capQuyen)) {
							if ("0".equals(chucVu)){
								thanhVienForm.setThanhVien(thanhVienBO
										.chonThanhVien(maThanhVien));
								return mapping
										.findForward("capNhatThanhVienAdmin");
							} else {
								thanhVienForm.setThanhVien(thanhVienBO
										.chonThanhVien(maThanhVien));
								return mapping
										.findForward("capNhatCongTacVienAdmin");
							}
						} else if ("1".equals(capQuyen)) {
							thanhVienForm.setThanhVien(thanhVienBO
									.chonThanhVien(maThanhVien));
							return mapping.findForward("capNhatCongTacVien");
						} else {
							thanhVienForm.setThanhVien(thanhVienBO
									.chonThanhVien(maThanhVien));
							return mapping.findForward("capNhatThanhVien");
						}

					}
				} else {
					if ("3".equals(capQuyen)) {
						if ("0".equals(chucVu)){
							thanhVienForm.setThanhVien(thanhVienBO
									.chonThanhVien(maThanhVien));
							return mapping.findForward("capNhatThanhVienAdmin");
						} else {
							thanhVienForm.setThanhVien(thanhVienBO
									.chonThanhVien(maThanhVien));
							return mapping
									.findForward("capNhatCongTacVienAdmin");
						}
					} else if ("1".equals(capQuyen)) {
						thanhVienForm.setThanhVien(thanhVienBO
								.chonThanhVien(maThanhVien));
						return mapping.findForward("capNhatCongTacVien");
					} else {
						thanhVienForm.setThanhVien(thanhVienBO
								.chonThanhVien(maThanhVien));
						return mapping.findForward("capNhatThanhVien");
					}
				}
			} else {
				if ("3".equals(capQuyen)) {
					if ("0".equals(chucVu)){
						thanhVienForm.setThanhVien(thanhVienBO
								.chonThanhVien(maThanhVien));
						return mapping.findForward("capNhatThanhVienAdmin");
					} else {
						thanhVienForm.setThanhVien(thanhVienBO
								.chonThanhVien(maThanhVien));
						return mapping.findForward("capNhatCongTacVienAdmin");
					}
				} else if ("1".equals(capQuyen)) {
					thanhVienForm.setThanhVien(thanhVienBO
							.chonThanhVien(maThanhVien));
					return mapping.findForward("capNhatCongTacVien");
				} else {
					thanhVienForm.setThanhVien(thanhVienBO
							.chonThanhVien(maThanhVien));
					return mapping.findForward("capNhatThanhVien");
				}
			}
		}else {
			return mapping.findForward("dangNhap");
		}
	}
}
