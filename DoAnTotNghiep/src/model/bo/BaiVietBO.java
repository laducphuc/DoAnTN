package model.bo;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;

import common.Validations;
import model.bean.BaiViet;
import model.dao.BaiVietDAO;

public class BaiVietBO {
	/**
	 * Lấy danh sách những bài viết mới và những bài viết đã phân công nhưng
	 * chưa được công tác viên chấp nhân
	 * 
	 * @return
	 */
	public ArrayList<BaiViet> danhSachBaiVietChuaDich() {
		return new BaiVietDAO().danhSachBaiVietChuaDich();
	}

	/**
	 * Cập nhật trạng thái đã đăng cho bài viết
	 * 
	 * @param maBaiViet
	 * @return boolean
	 */
	public boolean capNhatTrangThaiDaDang(String maBaiViet) {
		return new BaiVietDAO().capNhatTrangThaiBaiViet(maBaiViet, "Da dang");
	}

	/**
	 * Cập nhật trạng thái phân công cho bài viết
	 * 
	 * @param maBaiViet
	 * @return boolean
	 */
	public boolean capNhatTrangThaiPhanCong(String maBaiViet) {
		return new BaiVietDAO().capNhatTrangThaiBaiViet(maBaiViet, "Phan cong");
	}

	/**
	 * Cập nhật trạng thái Đang dịch cho bài viết
	 * 
	 * @param maBaiViet
	 * @return boolean
	 */
	public boolean capNhatTrangThaiDangDich(String maBaiViet) {
		return new BaiVietDAO().capNhatTrangThaiBaiViet(maBaiViet, "Dang dich");
	}

	/**
	 * Cập nhật trạng thái Dịch xong cho bài viết
	 * 
	 * @param maBaiViet
	 * @return boolean
	 */
	public boolean capNhatTrangThaiDichXong(String maBaiViet) {
		return new BaiVietDAO().capNhatTrangThaiBaiViet(maBaiViet, "Dich xong");
	}

	/**
	 * Lấy danh sách phân công dịch bài theo thạng thái và được sắp
	 * xếp theo chiều giảm dần của ngày phân công
	 * 
	 * @return ArrayList<PhanCongDichBai>
	 */
	public ArrayList<BaiViet> danhSachBaiViet(String trangThai) {
		if ("Tatca".equals(trangThai) || trangThai == null) {
			ArrayList<BaiViet> dsBaiViet = new BaiVietDAO().danhSachBaiViet();
			if (dsBaiViet == null) {
				dsBaiViet = new ArrayList<BaiViet>();
			}
			return dsBaiViet;

		} else if ("Dadang".equals(trangThai) || "Da dang".equals(trangThai)) {
			ArrayList<BaiViet> dsBaiViet = new BaiVietDAO()
					.danhSachBaiViet("Da dang");
			if (dsBaiViet == null) {
				dsBaiViet = new ArrayList<BaiViet>();
			}
			return dsBaiViet;

		} else if ("Baimoi".equals(trangThai) || "Bai moi".equals(trangThai)) {
			ArrayList<BaiViet> dsBaiViet = new BaiVietDAO()
					.danhSachBaiViet("Bai moi");
			if (dsBaiViet == null) {
				dsBaiViet = new ArrayList<BaiViet>();
			}
			return dsBaiViet;

		} else if ("Dichxong".equals(trangThai)
				|| "Dich xong".equals(trangThai)) {
			ArrayList<BaiViet> dsBaiViet = new BaiVietDAO()
					.danhSachBaiViet("Dich xong");
			if (dsBaiViet == null) {
				dsBaiViet = new ArrayList<BaiViet>();
			}
			return dsBaiViet;
		} else {
			ArrayList<BaiViet> dsBaiViet = new BaiVietDAO()
					.danhSachBaiViet("Chuadich");
			if (dsBaiViet == null) {
				dsBaiViet = new ArrayList<BaiViet>();
			}
			return dsBaiViet;
		}
	}

	/**
	 * Tìm kiếm danh sách bài viết theo từ khóa và nội dung tìm kiếm và trạng
	 * thái của bài viết
	 * 
	 * @return Danh sách bài viết
	 */
	public ArrayList<BaiViet> timKiemDanhSachBaiViet(String trangThai,
			String tuKhoaTimKiem, String noiDungTimKiem) {
		if ("Tatca".equals(trangThai) || trangThai == null) {
			ArrayList<BaiViet> dsBaiViet = new BaiVietDAO()
					.timKiemDanhSachBaiViet(tuKhoaTimKiem, noiDungTimKiem);
			if (dsBaiViet == null) {
				dsBaiViet = new ArrayList<BaiViet>();
			}
			return dsBaiViet;
		} else if ("Dadang".equals(trangThai) || "Da dang".equals(trangThai)) {
			ArrayList<BaiViet> dsBaiViet = new BaiVietDAO()
					.timKiemDanhSachBaiViet("Da dang", tuKhoaTimKiem,
							noiDungTimKiem);
			if (dsBaiViet == null) {
				dsBaiViet = new ArrayList<BaiViet>();
			}
			return dsBaiViet;

		} else if ("Baimoi".equals(trangThai) || "Bai moi".equals(trangThai)) {
			ArrayList<BaiViet> dsBaiViet = new BaiVietDAO()
					.timKiemDanhSachBaiViet("Bai moi", tuKhoaTimKiem,
							noiDungTimKiem);
			if (dsBaiViet == null) {
				dsBaiViet = new ArrayList<BaiViet>();
			}
			return dsBaiViet;

		} else if ("Dichxong".equals(trangThai)
				|| "Dich xong".equals(trangThai)) {
			ArrayList<BaiViet> dsBaiViet = new BaiVietDAO()
					.timKiemDanhSachBaiViet("Dich xong", tuKhoaTimKiem,
							noiDungTimKiem);
			if (dsBaiViet == null) {
				dsBaiViet = new ArrayList<BaiViet>();
			}
			return dsBaiViet;
		} else {
			ArrayList<BaiViet> dsBaiViet = new BaiVietDAO()
					.timKiemDanhSachBaiViet("Chuadich", tuKhoaTimKiem,
							noiDungTimKiem);
			if (dsBaiViet == null) {
				dsBaiViet = new ArrayList<BaiViet>();
			}
			return dsBaiViet;
		}
	}

	public ArrayList<BaiViet> danhSachBaiViet() {
		return new BaiVietDAO().danhSachBaiViet();
	}

	/**
	 * Đếm tổng số lượng bài viết
	 * 
	 * @return int
	 */
	public int demTongSoBaiViet() {
		return new BaiVietDAO().demTongSoBaiViet();
	}

	/**
	 * Đếm tổng số lượng bài viết đã đăng
	 * 
	 * @return int
	 */
	public int demTongSoDaDich() {
		return new BaiVietDAO().demTongSoDaDang();
	}

	/**
	 * Đếm tổng số lượng bài viết chưa dịch
	 * 
	 * @return int
	 */
	public int demTongSoChuaDich() {
		return new BaiVietDAO().demTongSoChuaDich();
	}

	/**
	 * Đếm tổng số lượng bài viết mới
	 * 
	 * @return int
	 */
	public int demTongSoBaiMoi() {
		return new BaiVietDAO().demTongSoBaiMoi();
	}

	/**
	 * Đếm tổng số lượng bài viết dich xong
	 * 
	 * @return int
	 */
	public int demTongSoDichXong() {
		return new BaiVietDAO().demTongSoDichXong();
	}

	/**
	 * Lâý thông tin bài viết theo mã bài viết
	 * 
	 * @param maBaiViet
	 * @return thông tin của bài viết
	 */
	public BaiViet thongTinBaiViet(String maBaiViet) {
		BaiVietDAO baiVietDAO = new BaiVietDAO();
		BaiViet baiViet = baiVietDAO.thongTinBaiViet(maBaiViet);
		String[] noiDungViet = { "" };
		if (baiViet.getNoiDungViet() != null) {
			noiDungViet = baiViet.getNoiDungViet().split("///");
		}
		// String[] noiDungNhat = { "" };
		// if (baiViet.getNoiDungNhat() != null) {
		// noiDungNhat = baiViet.getNoiDungNhat().split("///");
		// }

		ArrayList<String> arrNoiDungViet = new ArrayList<String>(
				Arrays.asList(noiDungViet));
		// ArrayList<String> arrNoiDungNhat = new ArrayList<String>(
		// Arrays.asList(noiDungNhat));
		ArrayList<String> arrNoiDungNhat = getNoiDungBaiNhat(baiViet);
		baiViet.setArrNoiDungViet(arrNoiDungViet);
		baiViet.setArrNoiDungNhat(arrNoiDungNhat);
		String noiDungVietDaXuLy = giaiXuLyNoiDung(baiViet.getNoiDungViet());
		if (baiViet.getNoiDungNhat() != null
				&& !("".equals(baiViet.getNoiDungNhat()))) {
			String noiDungNhatDaXuLy = xuLyNoiDung(baiViet.getNoiDungNhat());
			baiViet.setNoiDungNhat(noiDungNhatDaXuLy);
		}
		baiViet.setNoiDungViet(noiDungVietDaXuLy);
		return baiViet;
	}

	/**
	 * Xóa bài viết
	 * 
	 * @param maBaiViet
	 * @return
	 */
	public boolean xoaBaiViet(String maBaiViet) {
		return new BaiVietDAO().xoaBaiViet(maBaiViet);
	}

	/**
	 * Cập nhật bài viết chưa dịcn
	 * 
	 * @param baiViet
	 * @return
	 */
	public boolean capNhatBaiVietChuaDich(BaiViet baiViet) {
		return new BaiVietDAO().capNhatBaiVietChuaDich(baiViet);
	}

	/**
	 * Cập nhật bài viết đã được dịch
	 * 
	 * @param baiViet
	 * @return
	 */
	public boolean capNhatBaiVietDaDich(BaiViet baiViet) {
		return new BaiVietDAO().capNhatBaiVietDaDich(baiViet);
	}

	/**
	 * Lấy thống kê số sao của bài viết
	 * 
	 * @param maBaiViet
	 * @return
	 */
	public BaiViet layThongKeSaoBaiViet(String maBaiViet) {
		BaiViet baiViet = new BaiVietDAO().layThongKeSaoBaiViet(maBaiViet);
		float tongSao = baiViet.getSoSao1() + baiViet.getSoSao2()
				+ baiViet.getSoSao3() + baiViet.getSoSao4()
				+ baiViet.getSoSao5();
		baiViet.setPhanTramSao1((baiViet.getSoSao1() / tongSao) * 100);
		baiViet.setPhanTramSao2((baiViet.getSoSao2() / tongSao) * 100);
		baiViet.setPhanTramSao3((baiViet.getSoSao3() / tongSao) * 100);
		baiViet.setPhanTramSao4((baiViet.getSoSao4() / tongSao) * 100);
		baiViet.setPhanTramSao5((baiViet.getSoSao5() / tongSao) * 100);
		return baiViet;
	}

	/**
	 * Tăng lượt xem của bài viết
	 * 
	 * @param maBaiViet
	 * @return
	 */
	public boolean tangLuotXemBaiViet(String maBaiViet) {
		return new BaiVietDAO().tangLuotXemBaiViet(maBaiViet);
	}

	/*-----------------------------------------------------------------------------------------------------*/

	/**
	 * Lấy danh sác phân công dich bài của cộng tác viên theo chiều giảm
	 * dần của ngày phân công
	 * 
	 * @param maThanhVien
	 * @return
	 */
	public ArrayList<BaiViet> layDanhSachBaiVietChuaDuyet(String maThanhVien) {
		return new BaiVietDAO().layDanhSachBaiVietChuaDuyet(maThanhVien);
	}

	/**
	 * Lấy danh sách phân công dich bài của cộng tác viên đã nhận dịch
	 * theo chiều giảm dần của ngày phân công
	 * 
	 * @param maThanhVien
	 * @return
	 */
	public ArrayList<BaiViet> layDanhSachBaiVietNhanDich(String maThanhVien) {
		return new BaiVietDAO().layDanhSachBaiVietNhanDich(maThanhVien);
	}

	/**
	 * Lấy thông tin bài viết trong danh sách bài viết
	 * 
	 * @param maBaiViet
	 * @param danhSachBaiViet
	 * @return
	 */
	public BaiViet getBaiViet(String maBaiViet,
			ArrayList<BaiViet> danhSachBaiViet) {
		// TODO Auto-generated method stub
		for (int i = 0; i < danhSachBaiViet.size(); i++) {
			if (danhSachBaiViet.get(i).getMaBaiViet().equals(maBaiViet))
				return danhSachBaiViet.get(i);
		}
		return null;
	}

	/**
	 * Lấy nội dung bài viết
	 * 
	 * @param baiViet
	 * @return
	 */
	public ArrayList<String> getNoiDungBaiViet(BaiViet baiViet) {
		ArrayList<String> noiDungBaiViet;
		String[] tam = baiViet.getNoiDungViet().split("///");
		noiDungBaiViet = new ArrayList<String>(Arrays.asList(tam));
		return noiDungBaiViet;

	}

	/**
	 * Cập nhật trạng thái
	 * 
	 * @param trangThai
	 * @param maBaiViet
	 * @return
	 */
	public boolean capNhatTrangThai(String trangThai, String maBaiViet) {
		// TODO Auto-generated method stub
		return new BaiVietDAO().capNhatTrangThai(trangThai, maBaiViet);
	}

	public boolean capNhatBaiDich(String maBaiViet, String tieuDeNhat,
			String moTaNhat, String noiDungNhat) {
		// TODO Auto-generated method stub
		return new BaiVietDAO().capNhatBaiDich(maBaiViet, tieuDeNhat, moTaNhat,
				noiDungNhat);
	}

	public ArrayList<String> getNoiDungBaiNhat(BaiViet baiViet) {
		// TODO Auto-generated method stub
		ArrayList<String> noiDungBaiNhat;
		// System.out.println(baiViet.getNoiDungNhat());
		try {
			String[] tam = baiViet.getNoiDungNhat().split("///");
			// System.out.println(tam[0]);
			noiDungBaiNhat = new ArrayList<String>(Arrays.asList(tam));
			return noiDungBaiNhat;
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
			noiDungBaiNhat = new ArrayList<String>();
			return noiDungBaiNhat;
		}
	}

	public boolean themBinhLuan(String maBaiViet, String maThanhVien,
			String noiDungBinhLuan, Boolean trangthai) {
		// TODO Auto-generated method stub
		Date date = new Date();
		String ngayGioHienTai = "";
		try {
			ngayGioHienTai = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")
					.format(date);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return new BaiVietDAO().themBinhLuan(maBaiViet, maThanhVien,
				noiDungBinhLuan, ngayGioHienTai, trangthai);
	}

	public boolean themBaiViet(String maBaiViet, String maThanhVien,
			String tieuDeViet, String moTaViet, String noiDungViet, String anh,
			String maDanhMuc) {
		// TODO Auto-generated method stub
		Date date = new Date();
		String ngayGioHienTai = "";
		try {
			ngayGioHienTai = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")
					.format(date);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new BaiVietDAO().themBaiViet(maBaiViet, maThanhVien, tieuDeViet,
				moTaViet, noiDungViet, anh, ngayGioHienTai, maDanhMuc);
	}

	public boolean capNhatBaiViet(String maBaiViet, String tieuDeViet,
			String moTaViet, String noiDungViet, String anh, String maDanhMuc) {
		// TODO Auto-generated method stub
		return new BaiVietDAO().capNhatBaiViet(maBaiViet, tieuDeViet, moTaViet,
				noiDungViet, anh, maDanhMuc);
	}

	public BaiViet getBaiViet(String maBaiViet) {
		// TODO Auto-generated method stub
		return new BaiVietDAO().thongTinBaiViet(maBaiViet);
	}

	public ArrayList<BaiViet> layDanhSachBaiViet() {
		// TODO Auto-generated method stub
		return new BaiVietDAO().danhSachBaiViet();
	}

	public ArrayList<BaiViet> danhSachBaiVietTrangChu() {
		return new BaiVietDAO().danhSachBaiVietTrangChu();
	}

	public ArrayList<BaiViet> layDanhSachBaiVietHienThi(
			ArrayList<BaiViet> danhSachBaiViet, int soTrang) {
		// TODO Auto-generated method stub
		ArrayList<BaiViet> danhSachBaiVietHienThi = new ArrayList<BaiViet>();
		for (int i = (soTrang - 1) * 9; i < (soTrang - 1) * 9 + 9; i++) {
			if (i < danhSachBaiViet.size())
				danhSachBaiVietHienThi.add(danhSachBaiViet.get(i));
		}
		return danhSachBaiVietHienThi;
	}

	public ArrayList<BaiViet> layDanhSachBaiVietTheoDanhMuc(String maDanhMuc) {
		// TODO Auto-generated method stub
		return new BaiVietDAO().danhSachBaiVietTheoDanhMuc(maDanhMuc);
	}

	public String getAvarta() {
		// TODO Auto-generated method stub
		return String.valueOf((int) (1 + Math.random() * 7));
	}

	// ---------------------------------------
	public String tangMa() {
		return new BaiVietDAO().tangMa();
	}

	/**
	 *
	 * @return : ArrayList<ArrayList<BaiViet>>
	 * */
	public ArrayList<ArrayList<BaiViet>> danhSachBaiVietMoiNhat() {
		return new BaiVietDAO().danhSachBaiVietMoiNhat();
	}

	/**
	 * @param: ArrayList<BaiViet> danhSachCha,
	 * @param : int so bai viet trong danh sach con
	 * @return : ArrayList<ArrayList<BaiViet>>()
	 * 
	 * */
	public ArrayList<ArrayList<BaiViet>> chiaDanhSachCon(
			ArrayList<BaiViet> danhSachCha, int soBai) {
		return new BaiVietDAO().chiaDanhSachCon(danhSachCha, soBai);
	}

	public ArrayList<BaiViet> layDanhSachBaiVietTimKiem(String noiDungTimKiem) {
		return new BaiVietDAO().layDanhSachBaiVietTimKiem(noiDungTimKiem);
	}

	public String xuLyNoiDung(String noiDung) {
		String str2 = noiDung.replaceAll(".</p>", ".</p>///");
		return str2;
	}

	public String giaiXuLyNoiDung(String noiDung) {
		String str2 = "";
		if (noiDung.indexOf(".</p>///") != -1) {
			str2 = noiDung.replaceAll(".</p>///", ".</p>");
		}
		if (noiDung.indexOf("///") != -1) {
			str2 = noiDung.replaceAll("///", "");
		}
		return str2;
	}

	public static void main(String[] args) {
		// BaiViet baiViet = new BaiVietBO().layThongKeSaoBaiViet("BV00000001");
		// baiViet.printSao();
		// baiViet.printPhanTram();
		String str = "Nokia Lumia 1520: Ra mắt vào cuối 2013 nhưng hiện tại 1520 vẫn là thiết bị chạy Windows Phone được đánh giá cao. ///Máy có màn hình 6 inch độ phân giải 1.080p, chip xử lý lõi tứ Snapdragron 800, RAM 2 GB, camera PureView 20 MP, bộ nhớ trong 32 GB có thể mở rộng và pin dung lượng 3.400 mAh có thể sạc không dây./// 1520 sẽ được cập nhật lên Windows 10 trong thời gian tới. Samsung Galaxy Mega 2: ///Có màn hình 6 inch,";
		BaiVietBO baiVietBO = new BaiVietBO();
		String str2 = baiVietBO.giaiXuLyNoiDung(str);
		System.out.println("" + str2);
	}
}
