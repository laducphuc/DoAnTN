package action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.bean.TaiKhoan;
import model.bo.CheckLoginBO;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import form.DangNhapForm;

public class DangNhapAction extends Action {

	@SuppressWarnings("unchecked")
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		DangNhapForm dangNhapForm = (DangNhapForm) form;
		String tenTaiKhoan = dangNhapForm.getTenTaiKhoan();
		String matKhau = dangNhapForm.getMatKhau();
		System.out.println("taiKhoan"+tenTaiKhoan);
		System.out.println("matKhau"+matKhau);
		if (tenTaiKhoan == null || tenTaiKhoan.length() == 0 || matKhau == null
				|| matKhau.length() == 0) {
			JSONArray jsonArray= new JSONArray();
			JSONObject jsonObject= new JSONObject();
			jsonObject.put("thongBao", "Tài khoản hoặc mật khẩu trống !");
			jsonObject.put("ketQua", "dangNhapThatBai");
			jsonArray.add(jsonObject);
			PrintWriter write=response.getWriter();
			write.println(""+jsonArray.toString());
			write.flush();
			write.close();
			return null;
		} else {
			CheckLoginBO checkLoginBO = new CheckLoginBO();
			TaiKhoan taiKhoan = checkLoginBO.checkLogin(tenTaiKhoan, matKhau);
			if (taiKhoan != null) {
				JSONArray jsonArray= new JSONArray();
				JSONObject jsonObject= new JSONObject();
				PrintWriter write=response.getWriter();
				if ("3".equals(taiKhoan.getChucVu())) {
					dangNhapForm.setTaiKhoan(taiKhoan);
					jsonObject.put("ketQua", "dangNhapThanhCong");
					jsonArray.add(jsonObject);
					write.println(""+jsonArray.toString());
					write.flush();
					write.close();
					return null;
				} else if (taiKhoan.getTrangThai() == true) {
					jsonObject.put("ketQua", "dangNhapThatBai");
					jsonObject.put("thongBao", "Tài khoản của bạn đã bị khóa ngày" + taiKhoan.getNgayBatDauKhoa()
							+ "bạn phải chờ thêm " + taiKhoan.getSoNgayConLai()+" ngày nữa");
					jsonArray.add(jsonObject);
					write.println(""+jsonArray.toString());
					write.flush();
					write.close();
					return null;
				} else if ("1".equals(taiKhoan.getChucVu())) {
					dangNhapForm.setTaiKhoan(taiKhoan);
					jsonObject.put("ketQua", "dangNhapThanhCong");
					jsonArray.add(jsonObject);
					write.println(""+jsonArray.toString());
					write.flush();
					write.close();
					return null;
				} else {
					dangNhapForm.setTaiKhoan(taiKhoan);
					jsonObject.put("ketQua", "dangNhapThanhCong");
					jsonArray.add(jsonObject);
					write.println(""+jsonArray.toString());
					write.flush();
					write.close();
					return null;
				}
			} else {
				JSONArray jsonArray= new JSONArray();
				JSONObject jsonObject= new JSONObject();
				jsonObject.put("ketQua", "dangNhapThatBai");
				jsonObject.put("thongBao", "Tài khoản hoặc mật khẩu không đúng");
				jsonArray.add(jsonObject);
				PrintWriter write=response.getWriter();
				write.println(""+jsonArray.toString());
				write.flush();
				write.close();
				return null;
			}
		}
	}
}
