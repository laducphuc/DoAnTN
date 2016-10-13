package common;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Validations {

	public static boolean validateEmailAddress(String emailAddress) {
		String regex = "[(a-zA-Z-0-9-\\_\\+\\.)]+@[(a-z-A-z)]+\\.[(a-zA-z)]{2,3}";
		return emailAddress.matches(regex);
	}

	public static boolean validatekt(String emailAddress) {
		String regex = "[a-zA-Z]";
		return emailAddress.matches(regex);
	}

	public static boolean validatePhoneNumber(String phoneNumber) {
		String regex = "(0\\d{9,11})";
		return phoneNumber.matches(regex);

	}

	public static boolean validateSpace(String str) {
		if (str == null) {
			return false;
		} else {
			return "".equals(str.trim());
		}
	}
	public static boolean validateSpace2(String str){
		if(str==null){
			return true;
		}
		return "".equals(str.trim());
	}
	public static boolean validateDate(String strDate1, String strDate2) {
		if (strDate1 == null || strDate2 == null) {
			return true;
		}
		SimpleDateFormat formatDate = new SimpleDateFormat("dd/MM/yyyy");
		formatDate.setLenient(false);
		try {
			Date date1 = formatDate.parse(strDate1);
			Date date2 = formatDate.parse(strDate2);
			if (date1.after(date2)) {
				return true;
			} else {
				return false;
			}
		} catch (ParseException e) {
			return true;
		}
	}

	public static boolean validateDate(String strDate) {
		if (strDate == null) {
			return true;
		}
		SimpleDateFormat formatDate = new SimpleDateFormat("dd/MM/yyyy");
		formatDate.setLenient(false);
		try {
			formatDate.parse(strDate);
		} catch (ParseException e) {
			return true;
		}
		return false;
	}

	public static boolean validateTenThanhVien(String str) {
		if (str.length() > 30)
			return true;
		return false;
	}

	public static boolean validateDiaChi(String str) {
		if (str.length() > 50)
			return true;
		return false;
	}

	public static boolean validateTenTaiKhoan(String str) {
		if (str.length() > 25)
			return true;
		return false;
	}

	public static boolean validateNull(String str) {
		if (str == null || str.length() == 0)
			return true;
		return false;
	}

	public static boolean validateTrungMatKhau(String matKhau,
			String matKhauNhapLai) {
		if (matKhau.equals(matKhauNhapLai))
			return true;
		return false;
	}

	public static boolean validateNumber(String str) {
		try {
			Double.parseDouble(str);
			return false;
		} catch (NumberFormatException e) {
			return true;
		}

	}

	public static boolean isNumber(String str) {
		try {
			Integer.parseInt(str);
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	public static boolean isAvataEmpty(String fileName){
		return "".equals(fileName);
	}
	/**
	 * Kiểm tra ngay có lớn hơn ngày hiện tại không?
	 * @param strNgayKiemTra
	 * @return true: Nếu <= ngày hiện tại
	 * 		false : Nếu  > ngày hiện tại
	 */
	public static boolean ktLonHonNgayHienTai(String strNgayKiemTra){
		SimpleDateFormat formatDate = new SimpleDateFormat("yyyy-MM-dd");
		try {
			Date ngayKiemTra = formatDate.parse(strNgayKiemTra);
			Calendar calendarKiemTra = Calendar.getInstance();
			calendarKiemTra.setTime(ngayKiemTra); // Ngày chấp nhận
			//calendar.add(Calendar.DATE, 5); // Cộng thêm
			
			Date ngayHienTai = new Date();
			Calendar calendarHienTai = Calendar.getInstance();
			calendarHienTai.setTime(ngayHienTai);
			return calendarKiemTra.before(calendarHienTai);
		} catch (ParseException e) {
			return false;
		}
														
	}

	public static void main(String[] args) {

		// String emailAddress = "nguyetitbkdn@gmail.com";
		// String mobileNumber = "016397307734";
		// String brithday = "25/12/1993";
		// String a = "nguyet";
		// String b = "123";
		// String c = "#ng";
		// System.out.println(Validations.validatekt(a));
		// System.out.println(Validations.validatekt(b));
		// System.out.println(Validations.validatekt(c));
		// System.out.println(Validations.validateDate("29/12/2015",
		// "28/12/2015"));
//		System.out.println(ktLonHonNgayHienTai("2015-08-18"));
		
		System.out.println(validateTrungMatKhau("1234", "1234"));
	}
}
