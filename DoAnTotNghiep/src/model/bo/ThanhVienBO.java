package model.bo;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import common.Const;
import common.EnDeCryption;
import model.bean.TaiKhoan;
import model.bean.ThanhVien;
import model.dao.ThanhVienDAO;

public class ThanhVienBO {

	/**
	 * Thêm mới thông tin thành viên
	 * 
	 * @param thanhVien
	 * @return True/False
	 */
	public boolean chenThanhVien(ThanhVien thanhVien) {
		ThanhVienDAO thanhVienDAO = new ThanhVienDAO();
		thanhVien.setMaThanhVien(thanhVienDAO.tangMaThanhVien());
		thanhVien.setMaCapDo("CD00000001");
		thanhVien.setChucVu("0");
		thanhVien.setSoSao(0);
		if ("Nam".equals(thanhVien.getGioiTinh())) {
			thanhVien.setGioiTinh("True");
		} else {
			thanhVien.setGioiTinh("False");
		}

		TaiKhoan taiKhoan = new TaiKhoan();
		taiKhoan.setMaTaiKhoan(thanhVienDAO.tangMaTaiKhoan());
		taiKhoan.setTenTaiKhoan(thanhVien.getTenTaiKhoan());
		EnDeCryption enDeCryption = new EnDeCryption(Const.PATH);
		String matKhau = enDeCryption.encoding(thanhVien.getMaKhau());
		taiKhoan.setMatKhau(matKhau);
		taiKhoan.setMaThanhVien(thanhVien.getMaThanhVien());
		taiKhoan.setTrangThai(false);

		return thanhVienDAO.chenThanhVien(thanhVien) && thanhVienDAO.chenTaiKhoai(taiKhoan);
	}

	/**
	 * Thêm mới thông tin cộng tác viên
	 * 
	 * @param thanhVien
	 * @return True/False
	 */
	public boolean chenCongTacVien(ThanhVien thanhVien) {
		ThanhVienDAO thanhVienDAO = new ThanhVienDAO();
		thanhVien.setMaThanhVien(thanhVienDAO.tangMaThanhVien());
		thanhVien.setMaTrinhDo("TD00000001");
		thanhVien.setChucVu("2");
		thanhVien.setSoSao(0);
		if ("Nam".equals(thanhVien.getGioiTinh())) {
			thanhVien.setGioiTinh("True");
		} else {
			thanhVien.setGioiTinh("False");
		}

		TaiKhoan taiKhoan = new TaiKhoan();
		EnDeCryption enDeCryption = new EnDeCryption(Const.PATH);
		String matKhau = enDeCryption.encoding(thanhVien.getMaKhau());
		taiKhoan.setMaTaiKhoan(thanhVienDAO.tangMaTaiKhoan());
		taiKhoan.setTenTaiKhoan(thanhVien.getTenTaiKhoan());
		taiKhoan.setMatKhau(matKhau);
		taiKhoan.setMaThanhVien(thanhVien.getMaThanhVien());
		taiKhoan.setTrangThai(false);

		return thanhVienDAO.chenThanhVien(thanhVien) && thanhVienDAO.chenTaiKhoai(taiKhoan);
	}

	/**
	 * Lấy danh sách thành viên
	 * 
	 * @return ArrayList<ThanhVien>
	 */
	public ArrayList<ThanhVien> chonDanhSachThanhVien() {
		ArrayList<ThanhVien> danhSachThanhVien = new ArrayList<ThanhVien>();
		ArrayList<ThanhVien> danhSach = new ThanhVienDAO().chonDanhSach();
		System.out.println("size:" + danhSach.size());
		for (int i = 0; i < danhSach.size(); i++) {
			if ("0".equals(danhSach.get(i).getChucVu())) {
				danhSachThanhVien.add(danhSach.get(i));
			}
		}
		return danhSachThanhVien;
	}

	/**
	 * Lấy danh sách cộng tác viên
	 * 
	 * @return ArrayList<ThanhVien>
	 */
	public ArrayList<ThanhVien> chonDanhSachCongTacVien() {
		ArrayList<ThanhVien> danhSachCongTacVien = new ArrayList<ThanhVien>();
		ArrayList<ThanhVien> danhSach = new ThanhVienDAO().chonDanhSach();
		for (int i = 0; i < danhSach.size(); i++) {
			if ("2".equals(danhSach.get(i).getChucVu())) {
				danhSachCongTacVien.add(danhSach.get(i));
			}
		}
		return danhSachCongTacVien;
	}

	/**
	 * Lấy thông tin của thành viên tương ứng với maThanhVien
	 * 
	 * @param maThanhVien
	 * @return ThanhVien
	 */
	public ThanhVien chonThanhVien(String maThanhVien) {
		return new ThanhVienDAO().chonThanhVien(maThanhVien);
	}

	/**
	 * Tìm kiếm thông tin cộng tác viên theo từ khóa tìm kiếm
	 * 
	 * @param tuKhoaTimKiem
	 * @param noiDungTimKiem
	 * @return ArrayList<ThanhVien>
	 */
	public ArrayList<ThanhVien> timKiemCongTacVien(String tuKhoaTimKiem, String noiDungTimKiem) {
		ArrayList<ThanhVien> danhSachCongTacVien = new ArrayList<ThanhVien>();
		ArrayList<ThanhVien> danhSach = new ThanhVienDAO().timKiem(tuKhoaTimKiem, noiDungTimKiem);
		for (int i = 0; i < danhSach.size(); i++) {
			if ("2".equals(danhSach.get(i).getChucVu())) {
				danhSachCongTacVien.add(danhSach.get(i));
			}
		}
		return danhSachCongTacVien;
	}

	/**
	 * Tìm kiếm thông tin thành viên theo từ khóa tìm kiếm
	 * 
	 * @param tuKhoaTimKiem
	 * @param noiDungTimKiem
	 * @return ArrayList<ThanhVien>
	 */
	public ArrayList<ThanhVien> timKiemThanhVien(String tuKhoaTimKiem, String noiDungTimKiem) {
		ArrayList<ThanhVien> danhSachThanhVien = new ArrayList<ThanhVien>();
		ArrayList<ThanhVien> danhSach = new ThanhVienDAO().timKiem(tuKhoaTimKiem, noiDungTimKiem);
		for (int i = 0; i < danhSach.size(); i++) {
			if ("0".equals(danhSach.get(i).getChucVu())) {
				danhSachThanhVien.add(danhSach.get(i));
			}
		}
		return danhSachThanhVien;
	}

	/**
	 * Cập nhật thông tin thành viên
	 * 
	 * @param thanhVien
	 * @return True/False
	 */
	public boolean capNhatThanhVien(ThanhVien thanhVien) {

		if ("Nam".equals(thanhVien.getGioiTinh())) {
			thanhVien.setGioiTinh("True");
		} else {
			thanhVien.setGioiTinh("False");
		}
		return new ThanhVienDAO().capNhatThanhVien(thanhVien);
	}

	/**
	 * Khóa tất cả các tài khoản của thành viên
	 * 
	 * @param maThanhVien
	 * @param soNgayKhoa
	 * @return True/False
	 */
	public boolean khoaTaiKhoan(String maThanhVien, int soNgayKhoa) {
		SimpleDateFormat dateformat = new SimpleDateFormat("MM-dd-yyyy");
		String ngayBatDauKhoa = dateformat.format(new Date());
		return new ThanhVienDAO().khoaTaiKhoan(maThanhVien, soNgayKhoa, ngayBatDauKhoa);
	}

	/**
	 * Hàm mở khóa tất cả các tài khoản của thành viên
	 * 
	 * @param maThanhVien
	 * @return True/False
	 */
	public boolean moKhoaTaiKhoan(String maThanhVien) {
		return new ThanhVienDAO().moKhoaTaiKhoan(maThanhVien);
	}

	/**
	 * Hàm kiểm tra tên tài khoản đã tồn tại trong database hay chưa
	 * 
	 * @param tenTaiKhoan
	 * @return Nếu có thì return về true / Không có return false
	 */
	public boolean kiemTraTaiKhoan(String tenTaiKhoan) {
		return new ThanhVienDAO().kiemTraTaiKhoan(tenTaiKhoan);
	}

	/**
	 * Hàm xóa thông tin thành viên
	 * 
	 * @param maThanhVien
	 * @return boolean
	 */
	public boolean xoaThanhVien(String maThanhVien) {
		ThanhVienDAO thanhVienDAO = new ThanhVienDAO();
		return (thanhVienDAO.xoaTaiKhoan(maThanhVien)) && (thanhVienDAO.xoaThanhVien(maThanhVien));
	}

	/**
	 * Hàm danh sách phân công cộng tác viên
	 * 
	 * @param tuKhoaTimKiem
	 * @param noiDungTimKiem
	 * @return Thông tin phân công cộng tác viên
	 */
	public ArrayList<ThanhVien> danhSachPhanCongCTV() {
		return new ThanhVienDAO().danhSachPhanCongCTV();
	}

	/**
	 * Hàm tìm kiếm thông tin phân công cộng tác viên
	 * 
	 * @param tuKhoaTimKiem
	 * @param noiDungTimKiem
	 * @return Thông tin phân công cộng tác viên
	 */
	public ArrayList<ThanhVien> timKiemPhanCongCTV(String tuKhoaTimKiem, String noiDungTimKiem) {
		return new ThanhVienDAO().timKiemPhanCongCTV(tuKhoaTimKiem, noiDungTimKiem);
	}

	/**
	 * Lấy thông tin của cộng tác viên trong màn hình phân công bài vết
	 * 
	 * @param maThanhVien
	 * @return ThanhVien
	 */
	public ThanhVien thongTinPhanCongCTVDichBai(String maThanhVien) {
		return new ThanhVienDAO().thongTinPhanCongCTVDichBai(maThanhVien);
	}

	/**
	 * Hàm kiểm tra email đã tồn tại trong database hay chưa
	 * 
	 * @param Email
	 * @return Nếu có thì return về true / Không có return false
	 */
	public boolean kiemTraEmailTonTai(String email) {
		return new ThanhVienDAO().kiemTraEmailTonTai(email);
	}

	/**
	 * Đánh giá thành viên
	 * 
	 * @param maThanhVien
	 * @param tenCapDo
	 * @param soSao
	 */
	public boolean danhGiaThanhVien(String maThanhVien, String tenCapDo, int soSao) {
		// TODO Auto-generated method stub
		return new ThanhVienDAO().danhGiaThanhVien(maThanhVien, tenCapDo, soSao);
	}

	/**
	 * Đánh giá cộng tác viên
	 * 
	 * @param maThanhVien
	 * @param tenTrinhDo
	 * @param soSao
	 */
	public boolean danhGiaCongTacVien(String maThanhVien, String tenTrinhDo, int soSao) {
		// TODO Auto-generated method stub
		return new ThanhVienDAO().danhGiaCongTacVien(maThanhVien, tenTrinhDo, soSao);
	}

	public ArrayList<ArrayList<ThanhVien>> danhSachTopCongTacVien() {
		return new ThanhVienDAO().danhSachTopCongTacVien();
	}

	public ArrayList<ArrayList<ThanhVien>> danhSachTopThanhVien() {
		return new ThanhVienDAO().danhSachTopThanhVien();
	}

	public void capNhatMatKhauAdmin(String maThanhVien, String matKhauMoi) {
		EnDeCryption enDeCryption = new EnDeCryption(Const.PATH);
		String matKhau = enDeCryption.encoding(matKhauMoi);
		new ThanhVienDAO().capNhatMatKhauAdmin(maThanhVien, matKhau);
	}

	public void capNhatTenThanhVien(String maThanhVien, String tenThanhVien) {
		new ThanhVienDAO().capNhatTenThanhVien(maThanhVien, tenThanhVien);
	}

	public void capNhatAnhDaiDien(String maThanhVien, String anh) {
		new ThanhVienDAO().capNhatAnhDaiDien(maThanhVien, anh);
	}
}
