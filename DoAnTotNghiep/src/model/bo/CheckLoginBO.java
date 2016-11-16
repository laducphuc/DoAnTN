package model.bo;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import common.Const;
import common.EnDeCryption;
import model.bean.TaiKhoan;
import model.dao.CheckLoginDAO;

public class CheckLoginBO {
	
	/**
	 * Kiểm tra đăng nhập
	 * @param tenTaiKhoan
	 * @param matKhau
	 * @return Thông tin của tài khoản
	 */
	public TaiKhoan checkLogin(String tenTaiKhoan, String matKhau){
		EnDeCryption enDeCryption = new EnDeCryption(Const.PATH);
		String maHoa = enDeCryption.encoding(matKhau);
		TaiKhoan taiKhoan = new CheckLoginDAO().checkLogin(tenTaiKhoan, maHoa);
		if (taiKhoan != null && taiKhoan.getMaTaiKhoan() != null){
			if (taiKhoan.getTrangThai() == true){
				taiKhoan.setSoNgayConLai(soNgayConLai(taiKhoan.getSoNgayKhoa(), taiKhoan.getNgayBatDauKhoa()));
			}
			return taiKhoan;
		} else {
			return null;
		}
		
	}
	
	
	/**
	 * Tính số ngày còn tại khi biết số ngày khóa và ngày bắt đầu bị khóa
	 * @param soNgayKhoa
	 * @param ngayBatDauKhoa
	 * @return
	 */
	private static int soNgayConLai(int soNgayKhoa, String ngayBatDauKhoa) {
		if (ngayBatDauKhoa == null) {
			return 0;
		} else {
			SimpleDateFormat formatDate = new SimpleDateFormat("yyyy-MM-dd");
			try {
				Date dateBatDauKhoa = formatDate.parse(ngayBatDauKhoa);
				Calendar calendarNgayMoKhoa = Calendar.getInstance();
				calendarNgayMoKhoa.setTime(dateBatDauKhoa);
				calendarNgayMoKhoa.add(Calendar.DATE, soNgayKhoa); 
				String ngayMoKhoa = formatDate.format(calendarNgayMoKhoa.getTime());
				String ngayHienTai = formatDate.format(new Date());
				long d1 = 0;
				long d2 = 0;
				d1 = formatDate.parse(ngayMoKhoa).getTime();
				d2 = formatDate.parse(ngayHienTai).getTime();
				return (int) Math.abs((d1-d2)/(1000*60*60*24));
			} catch (Exception e) {
				return soNgayKhoa;
			}
		}
	}
	
	public static void main(String[] args) {
		System.out.println(soNgayConLai(7, "2015-8-20"));
	}
}
