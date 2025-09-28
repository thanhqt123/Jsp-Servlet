package service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import domain.HoatDong;
import domain.ThanhVien;

public class HoatDongService {

	public HoatDongService() {

	}

	public boolean updateHoatDong(HoatDong hoatDong) {
		try (Connection conn = JDBCConnection.getConnection()) {
			String sql = "UPDATE HOAT_DONG SET "
					+ "TenHD = ?, "
					+ "MoTaHD = ?, "
					+ "NgayGioBD = ?, "
					+ "NgayGioKetThuc = ?, "
					+ "SoLuongToiThieuYC = ?, "
					+ "SoLuongToiDaYC = ?, "
					+ "ThoiHanDangKy = ?, "
					+ "MaTV = ?, "
					+ "TrangThai = ? "
					+ "WHERE MaHD = ?";
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setString(1, hoatDong.getTenHd());
			stmt.setString(2, hoatDong.getMoTa());
			stmt.setTimestamp(3, java.sql.Timestamp.valueOf(hoatDong.getNgayGioBd()));
			stmt.setTimestamp(4, java.sql.Timestamp.valueOf(hoatDong.getNgayGioKt()));
			stmt.setInt(5, hoatDong.getSoLuongToiThieuYc());
			stmt.setInt(6, hoatDong.getSoLuongToiDaYc());
			stmt.setTimestamp(7, java.sql.Timestamp.valueOf(hoatDong.getThoiHanDk()));
			stmt.setInt(8, hoatDong.getThanhVien().getMaTv());
			stmt.setString(9, hoatDong.getTrangThai());
			stmt.setInt(10, hoatDong.getMaHd());
			int rows = stmt.executeUpdate();
			if (rows > 0)
				return true;

		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	public int checkIdMember(int id) {
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;

		try {
			conn = JDBCConnection.getConnection();
			String sql = "SELECT * FROM THANH_VIEN WHERE MaTV=?";
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, id);
			rs = stmt.executeQuery();

			if (rs.next()) {
				return id;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (stmt != null)
					stmt.close();
				if (conn != null)
					conn.close();
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}
		return -1;
	}

	public void createHoatDong(HoatDong hoatDong) {

		try (Connection conn = JDBCConnection.getConnection()) {
			String sql = "INSERT INTO HOAT_DONG "
					+ "(TenHD, MoTaHD, NgayGioBD, NgayGioKetThuc, SoLuongToiThieuYC, SoLuongToiDaYC, ThoiHanDangKy, MaTV, TrangThai) "
					+ "VALUES (?, ?, ?, ?, ?, ?, ?, ?,?)";

			PreparedStatement stmt = conn.prepareStatement(sql);

			stmt.setString(1, hoatDong.getTenHd());
			stmt.setString(2, hoatDong.getMoTa());
			stmt.setTimestamp(3, java.sql.Timestamp.valueOf(hoatDong.getNgayGioBd()));
			stmt.setTimestamp(4, java.sql.Timestamp.valueOf(hoatDong.getNgayGioKt()));
			stmt.setInt(5, hoatDong.getSoLuongToiThieuYc());
			stmt.setInt(6, hoatDong.getSoLuongToiDaYc());
			stmt.setTimestamp(7, java.sql.Timestamp.valueOf(hoatDong.getThoiHanDk()));
			stmt.setInt(8, hoatDong.getThanhVien().getMaTv());
			stmt.setString(9, hoatDong.getTrangThai());

			int rs = stmt.executeUpdate();
			System.out.println("+============ " + rs);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public HoatDong findHoatDongById(int id) {
		HoatDong hd = new HoatDong();

		try (Connection conn = JDBCConnection.getConnection()) {
			String sql = "SELECT * FROM HOAT_DONG WHERE MaHd=?";
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setInt(1, id);
			ResultSet rs = stmt.executeQuery();
			if (rs.next()) {
				hd.setMaHd(rs.getInt("MaHD"));
				hd.setTenHd(rs.getString("TenHD"));
				hd.setMoTa(rs.getString("MoTaHD"));
				hd.setNgayGioBd(rs.getTimestamp("NgayGioBD").toLocalDateTime());
				hd.setNgayGioKt(rs.getTimestamp("NgayGioKetThuc").toLocalDateTime());
				hd.setSoLuongToiThieuYc(rs.getInt("SoLuongToiThieuYC"));
				hd.setSoLuongToiDaYc(rs.getInt("SoLuongToiDaYC"));
				hd.setThoiHanDk(rs.getTimestamp("ThoiHanDangKy").toLocalDateTime());
				hd.setTrangThai(rs.getString("TrangThai"));
				ThanhVienService thanhVienService = new ThanhVienService();
				ThanhVien tv = thanhVienService.findThanhVienById(rs.getInt("MaTV"));
				if (tv != null) {
					hd.setThanhVien(tv);
				}
			}
			return hd;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public List<HoatDong> getAllHoatDOng() {
		List<HoatDong> ds = new ArrayList<HoatDong>();

		try (Connection conn = JDBCConnection.getConnection()) {
			String sql = "SELECT * FROM HOAT_DONG";
			PreparedStatement stmt = conn.prepareStatement(sql);

			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				HoatDong hd = new HoatDong();
				hd.setMaHd(rs.getInt("MaHD"));
				hd.setTenHd(rs.getString("TenHD"));
				hd.setMoTa(rs.getString("MoTaHD"));
				hd.setNgayGioBd(rs.getTimestamp("NgayGioBD").toLocalDateTime());
				hd.setNgayGioKt(rs.getTimestamp("NgayGioKetThuc").toLocalDateTime());
				hd.setSoLuongToiThieuYc(rs.getInt("SoLuongToiThieuYC"));
				hd.setSoLuongToiDaYc(rs.getInt("SoLuongToiDaYC"));
				hd.setThoiHanDk(rs.getTimestamp("ThoiHanDangKy").toLocalDateTime());
				hd.setTrangThai(rs.getString("TrangThai"));
				ThanhVienService thanhVienService = new ThanhVienService();
				ThanhVien tv = thanhVienService.findThanhVienById(rs.getInt("MaTV"));
				if (tv != null) {
					hd.setThanhVien(tv);
				}

				ds.add(hd);

			}
			return ds;

		} catch (Exception e) {
			e.printStackTrace();
		}
		return ds;
	}
}
