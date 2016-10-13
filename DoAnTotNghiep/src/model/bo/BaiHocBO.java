package model.bo;

import java.util.ArrayList;

import model.bean.BaiHoc;
import model.dao.BaiHocDAO;

public class BaiHocBO {
	BaiHocDAO baiHocDAO=new BaiHocDAO();
	public ArrayList<BaiHoc> listBaiHoc() {
		return baiHocDAO.listBaiHoc();
	}
	
	public ArrayList<BaiHoc> listBaiHocByCapDo(String maCapDo) {
		return baiHocDAO.listBaiHocByCapDo(maCapDo);
	}

}
