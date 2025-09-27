package controller;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import domain.HoatDong;
import domain.ThanhVien;
import service.HoatDongService;
import service.ThanhVienService;

@WebServlet({ "/taoHoatDong", "/danhSachHoatDong" })
public class HoatDongController extends HttpServlet {
	HoatDongService hoatDongService = new HoatDongService();
	ThanhVienService thanhVienService = new ThanhVienService();

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String uri = request.getRequestURI();
		if (uri.endsWith("/taoHoatDong")) {
			request.getRequestDispatcher("TaoHoatDong.jsp").forward(request, response);
		} else if (uri.endsWith("/danhSachHoatDong")) {
			List<HoatDong> ds = hoatDongService.getAllHoatDOng();
			request.setAttribute("ds", ds);
			request.getRequestDispatcher("HoatDong.jsp").forward(request, response);

		}
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");

		String tenHd = request.getParameter("nameAcv");
		String moTaHd = request.getParameter("descAcv");
		String ngayBatDauStr = request.getParameter("startDate");
		String ngayKetThucStr = request.getParameter("endDate");
		String soLuongMax = request.getParameter("maxQuantity");
		String soLuongMin = request.getParameter("minQuantity");
		String thoiHanDkStr = request.getParameter("expiredRegis");
		String status = request.getParameter("statusAcv");
		String idMember = request.getParameter("idMember");

		HoatDongService hoatDongService = new HoatDongService();
		if (tenHd != null && moTaHd != null && ngayBatDauStr != null && ngayKetThucStr != null && soLuongMax != null
				&& soLuongMin != null && status != null && thoiHanDkStr != null) {
			System.err.println(1);
			LocalDateTime nbd = LocalDateTime.parse(ngayBatDauStr);
			LocalDateTime nkt = LocalDateTime.parse(ngayKetThucStr);
			LocalDateTime thdk = LocalDateTime.parse(thoiHanDkStr);

			Integer slmin = Integer.parseInt(soLuongMin);
			Integer slmax = Integer.parseInt(soLuongMax);
			Integer idmb = Integer.parseInt(idMember);

			HoatDong hoatDong = new HoatDong(tenHd, nbd, nkt, moTaHd, slmin, slmax, thdk, status);
			ThanhVien thanhVien = thanhVienService.findThanhVienById(idmb);
			if (thanhVien != null) {
				hoatDong.setThanhVien(thanhVien);
				hoatDongService.createHoatDong(hoatDong);
				response.sendRedirect(request.getContextPath() + "/danhSachHoatDong");
			} else {
				 request.setAttribute("error", "Mã thành viên không tồn tại!");
				 request.setAttribute("tenHd", tenHd);
				 request.setAttribute("moTaHd", moTaHd);
				 request.setAttribute("ngayBatDau", ngayBatDauStr);
				 request.setAttribute("ngayKetThuc", ngayKetThucStr);
				 request.setAttribute("soLuongMax", soLuongMax);
				 request.setAttribute("soLuongMin", soLuongMin);
				 request.setAttribute("thoiHanDk", thoiHanDkStr);
				 request.setAttribute("status", status);
				 request.setAttribute("idMember", idMember);

				 request.getRequestDispatcher("TaoHoatDong.jsp").forward(request, response);


			}


		}


	}
}
