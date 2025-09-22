package service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import domain.HoatDong;

public class HoatDongService {
	public void createHoatDong() {
		 try(Connection conn=JDBCConnection.getConnection()) {
			String sql="SELECT * FROM THANH_VIEN";
			
			PreparedStatement stmt=conn.prepareStatement(sql);
			
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next()) {
				 System.out.println(rs.getInt("matv")) ;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
