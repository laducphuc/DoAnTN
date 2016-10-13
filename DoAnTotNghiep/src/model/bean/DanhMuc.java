package model.bean;

public class DanhMuc {
	private String maDanhMuc;
	private String tenDanhMucViet;
	private String tenDanhMucNhat;

	public String getMaDanhMuc() {
		return maDanhMuc;
	}

	public void setMaDanhMuc(String maDanhMuc) {
		this.maDanhMuc = maDanhMuc;
	}

	public String getTenDanhMucViet() {
		return tenDanhMucViet;
	}

	public void setTenDanhMucViet(String tenDanhMucViet) {
		this.tenDanhMucViet = tenDanhMucViet;
	}

	public String getTenDanhMucNhat() {
		return tenDanhMucNhat;
	}

	public void setTenDanhMucNhat(String tenDanhMucNhat) {
		this.tenDanhMucNhat = tenDanhMucNhat;
	}
	
	public String toString(){
		return maDanhMuc + "/" + tenDanhMucViet + "/" + tenDanhMucNhat;
	}

	public DanhMuc(String maDanhMuc, String tenDanhMucViet,
			String tenDanhMucNhat) {
		super();
		this.maDanhMuc = maDanhMuc;
		this.tenDanhMucViet = tenDanhMucViet;
		this.tenDanhMucNhat = tenDanhMucNhat;
	}
	
	public DanhMuc(String maDanhMuc, String tenDanhMucViet) {
		super();
		this.maDanhMuc = maDanhMuc;
		this.tenDanhMucViet = tenDanhMucViet;
	}
	
	
}
