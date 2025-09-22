package domain;

import java.time.LocalDateTime;
import java.util.List;

public class ThanhVien {
	private int maTv;
	private String hoTen;
	private LocalDateTime ngaySinh;
	private String email;
	
	private List<ThamGia> danhSachThamGia;  //  Liên kết N-N qua bảng trung gian
	
	

	public List<ThamGia> getDanhSachThamGia() {
		return danhSachThamGia;
	}

	public void setDanhSachThamGia(List<ThamGia> danhSachThamGia) {
		this.danhSachThamGia = danhSachThamGia;
	}

	public int getMaTv() {
		return maTv;
	}

	public void setMaTv(int maTv) {
		this.maTv = maTv;
	}

	public String getHoTen() {
		return hoTen;
	}

	public void setHoTen(String hoTen) {
		this.hoTen = hoTen;
	}

	public LocalDateTime getNgaySinh() {
		return ngaySinh;
	}

	public void setNgaySinh(LocalDateTime ngaySinh) {
		this.ngaySinh = ngaySinh;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
