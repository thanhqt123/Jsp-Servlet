package service;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import domain.HoatDong;

public class HoatDongService {

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
					+ "(TenHD, MoTa, NgayGioBD, NgayGioKT, SoLuongToiThieuYC, SoLuongToiDaYC, ThoiHanDK, MaTV) "
					+ "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

			PreparedStatement stmt = conn.prepareStatement(sql);

			stmt.setString(1, hoatDong.getTenHd());
			stmt.setString(2, hoatDong.getMoTa());
			stmt.setTimestamp(3, java.sql.Timestamp.valueOf(hoatDong.getNgayGioBd()));
			stmt.setTimestamp(4, java.sql.Timestamp.valueOf(hoatDong.getNgayGioKt()));
			stmt.setInt(5, hoatDong.getSoLuongToiThieuYc());
			stmt.setInt(6, hoatDong.getSoLuongToiDaYc());
			stmt.setTimestamp(7, java.sql.Timestamp.valueOf(hoatDong.getThoiHanDk()));
			stmt.setInt(8, 1);

			int rs = stmt.executeUpdate();
			System.out.println("+============ " + rs);

		} catch (Exception e) {
			e.printStackTrace();

		}

	}
}
