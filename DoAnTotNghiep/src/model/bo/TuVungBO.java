package model.bo;

import java.util.ArrayList;

import model.bean.TuVung;
import model.dao.TuVungDAO;

public class TuVungBO {
	TuVungDAO tuVungDAO = new TuVungDAO();

	public ArrayList<TuVung> getAll() {
		return tuVungDAO.getAll();
	}

	public TuVung getByPK(String maTu) {
		return tuVungDAO.getByPK(maTu);
	}

	public void addTuVung(TuVung tuVung) {
		tuVungDAO.addTuVung(tuVung);
	}

	public void updateTuVung(TuVung tuVung) {
		tuVungDAO.updateTuVung(tuVung);
	}
}
