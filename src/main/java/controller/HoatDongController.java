package controller;

import java.io.IOException;
import java.time.LocalDateTime;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import domain.HoatDong;
import service.HoatDongService;

@WebServlet("/hoatDong")
public class HoatDongController extends HttpServlet {
	HoatDongService hoatDongService = new HoatDongService();

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/views/TaoHoatDong.jsp").forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String tenHd = request.getParameter("nameAcv");
		String moTaHd = request.getParameter("descAcv");
		String ngayBatDauStr = request.getParameter("startDate");
		String ngayKetThucStr = request.getParameter("endDate");
		String soLuongMax = request.getParameter("maxQuantity");
		String soLuongMin = request.getParameter("minQuantity");
		String thoiHanDkStr = request.getParameter("expiredRegis");
		String status = request.getParameter("statusAcv");
//		String idMember=request.getParameter("idMember");

		HoatDongService hoatDongService = new HoatDongService();
		if (tenHd != null && moTaHd != null && ngayBatDauStr != null && ngayKetThucStr != null && soLuongMax != null
				&& soLuongMin != null && status != null && thoiHanDkStr != null) {
			System.err.println(1);
			LocalDateTime nbd=LocalDateTime.parse(ngayBatDauStr);
			LocalDateTime nkt=LocalDateTime.parse(ngayKetThucStr);
			LocalDateTime thdk=LocalDateTime.parse(thoiHanDkStr);
			
			Integer slmin= Integer.parseInt(soLuongMin);
			Integer slmax= Integer.parseInt(soLuongMax);
//			Integer idmb=Integer.parseInt(idMember);
			
			HoatDong hoatDong = new HoatDong(tenHd, nbd, nkt, moTaHd,slmin,slmax,thdk,status);
			
			hoatDongService.createHoatDong(hoatDong);
			
		}else {
			System.out.println(2);
		}

		request.getRequestDispatcher("/WEB-INF/views/HoatDong.jsp").forward(request, response);
	}
}
