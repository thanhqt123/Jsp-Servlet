package service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDateTime;

import domain.ThanhVien;

public class ThanhVienService{
	public ThanhVien findThanhVienById(int id) {
		try (Connection conn = JDBCConnection.getConnection()){
			String sql="SELECT * FROM THANH_VIEN WHERE MaTV=?";
			PreparedStatement stmt=conn.prepareStatement(sql);
			stmt.setInt(1, id);
			
			ResultSet rs = stmt.executeQuery();
			if(rs.next()) {
				ThanhVien thanhVien = new ThanhVien();
				thanhVien.setMaTv(id);
				thanhVien.setHoTen(rs.getString("HoTen"));
				thanhVien.setEmail(rs.getString("Email"));
				thanhVien.setGioiTinh(rs.getBoolean("GioTinh"));
				thanhVien.setNgaySinh(rs.getTimestamp("NgaySinh").toLocalDateTime());
				return thanhVien;

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}