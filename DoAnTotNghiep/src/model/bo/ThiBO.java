package model.bo;

import java.util.ArrayList;
import java.util.Random;

import model.bean.CauHoi;
import model.bean.LichSu;
import model.bean.PhuongAn;
import model.dao.ThiDAO;

public class ThiBO {

	ThiDAO thiDAO = new ThiDAO();

	public ArrayList<CauHoi> getListCauHoi(String maChuong) {
		// TODO Auto-generated method stub
		ArrayList<CauHoi> listCauHoi = thiDAO.getListCauHoi(maChuong);
		if (listCauHoi != null) {
			// random 10 cau
			for (int i = 0; i < listCauHoi.size(); i++) {
				if (listCauHoi.size() > 2) {
					Random rd = new Random();
					int random = rd.nextInt(listCauHoi.size());
					listCauHoi.remove(random);
				} else {
					break;
				}
			}
			System.out.println("===========");
			for (int i = 0; i < listCauHoi.size(); i++) {
				System.out.println(listCauHoi.get(i).getNoiDung());
				ArrayList<PhuongAn> listPhuongAn = listCauHoi.get(i)
						.getListPhuongAn();
				for (int j = 0; j < listPhuongAn.size(); j++) {

					System.out.println("PA "
							+ listPhuongAn.get(j).getNoiDungPA());
				}
			}
			System.out.println("===========");
			// end random
		}

		// ktra moi cau co bao nhieu phuong an dung

		for (int i = 0; i < listCauHoi.size(); i++) {
			ArrayList<PhuongAn> listPhuongAn = listCauHoi.get(i)
					.getListPhuongAn();
			listCauHoi.get(i).setSoThuTu((i+1) +"");
			int indexCheck=0;
			System.out.println(listCauHoi.get(i).getSoThuTu());
			for (int j = 0; j < listPhuongAn.size(); j++) {
				listPhuongAn.get(j).setSoThuTuPA((j+1) +"");
				if(listPhuongAn.get(j).getTrangThai().equals("1")){
					indexCheck++;
				}
				System.out.println(listPhuongAn.get(j).getSoThuTuPA());
			}
			System.out.println("index= "+indexCheck);
			if(indexCheck>1){
				listCauHoi.get(i).setLaCheckBox(true);
			}else{
				listCauHoi.get(i).setLaCheckBox(false);
			}
		}

		return listCauHoi;
	}


	public void setLichSu(LichSu lichSu) {
		thiDAO.setLichSu(lichSu);
	}

}
