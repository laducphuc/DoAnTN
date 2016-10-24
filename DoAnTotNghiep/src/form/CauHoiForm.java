package form;

import java.util.ArrayList;

import org.apache.struts.action.ActionForm;

import model.bean.CapDo;
import model.bean.CauHoi;

public class CauHoiForm extends ActionForm{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String noiDung,maCapDo;
	private ArrayList<CapDo> listCapDo;
	private ArrayList<CauHoi> listCauHoi;

}
