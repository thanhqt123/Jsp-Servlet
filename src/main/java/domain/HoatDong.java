package domain;


import java.time.LocalDateTime;
import java.util.List;

public class HoatDong {
	private int maHd;
	private String tenHd;
	private LocalDateTime ngayGioBd;
	private LocalDateTime ngayGioKt;

	private int soLuongToiThieuYc;
	private int soLuongToiDaYc;

	private LocalDateTime thoiHanDk;
	private String trangThai;
	private String lyDoHuy;
	private List<ThamGia> danhSachThamGia;   //  Liên kết N-N qua bảng trung gian

	public int getMaHd() {
		return maHd;
	}

	public void setMaHd(int maHd) {
		this.maHd = maHd;
	}

	public String getTenHd() {
		return tenHd;
	}

	public void setTenHd(String tenHd) {
		this.tenHd = tenHd;
	}

	public LocalDateTime getNgayGioBd() {
		return ngayGioBd;
	}

	public void setNgayGioBd(LocalDateTime ngayGioBd) {
		this.ngayGioBd = ngayGioBd;
	}

	public LocalDateTime getNgayGioKt() {
		return ngayGioKt;
	}

	public void setNgayGioKt(LocalDateTime ngayGioKt) {
		this.ngayGioKt = ngayGioKt;
	}

	public int getSoLuongToiThieuYc() {
		return soLuongToiThieuYc;
	}

	public void setSoLuongToiThieuYc(int soLuongToiThieuYc) {
		this.soLuongToiThieuYc = soLuongToiThieuYc;
	}

	public int getSoLuongToiDaYc() {
		return soLuongToiDaYc;
	}

	public void setSoLuongToiDaYc(int soLuongToiDaYc) {
		this.soLuongToiDaYc = soLuongToiDaYc;
	}

	public LocalDateTime getThoiHanDk() {
		return thoiHanDk;
	}

	public void setThoiHanDk(LocalDateTime thoiHanDk) {
		this.thoiHanDk = thoiHanDk;
	}

	public String getTrangThai() {
		return trangThai;
	}

	public void setTrangThai(String trangThai) {
		this.trangThai = trangThai;
	}

	public String getLyDoHuy() {
		return lyDoHuy;
	}

	public void setLyDoHuy(String lyDoHuy) {
		this.lyDoHuy = lyDoHuy;
	}

	public List<ThamGia> getDanhSachThamGia() {
		return danhSachThamGia;
	}

	public void setDanhSachThamGia(List<ThamGia> danhSachThamGia) {
		this.danhSachThamGia = danhSachThamGia;
	}

}
