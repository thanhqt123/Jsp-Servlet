package controller;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import domain.HoatDong;
import domain.ThanhVien;
import service.HoatDongService;
import service.ThanhVienService;

@WebServlet({ "/taoHoatDong", "/danhSachHD", "/suaHoatDong" })
public class HoatDongController extends HttpServlet {
	private static final Logger logger = Logger.getLogger(HoatDongController.class.getName());
	static {
		try {
			// Tạo thư mục logs nếu chưa tồn tại
			File logDir = new File("logs");
			if (!logDir.exists()) {
				logDir.mkdirs();
			}

			// Ghi log vào file
			FileHandler fh = new FileHandler("logs/messages.log", true); // true = append
			fh.setFormatter(new SimpleFormatter());
			logger.addHandler(fh);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	static {
		try {
			// Tạo thư mục logs nếu chưa tồn tại
			File logDir = new File("logs");
			if (!logDir.exists()) {
				logDir.mkdirs();
			}

			// Ghi log vào file
			FileHandler fh = new FileHandler("logs/messages.log", true); // true = append
			fh.setFormatter(new SimpleFormatter());
			logger.addHandler(fh);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	HoatDongService hoatDongService = new HoatDongService();
	ThanhVienService thanhVienService = new ThanhVienService();

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println(System.getProperty("user.dir"));

		String uri = request.getRequestURI();
		if (uri.endsWith("/taoHoatDong")) {
			request.getRequestDispatcher("taoHoatDong.jsp").forward(request, response);
		} else if (uri.endsWith("/danhSachHD")) {

			List<HoatDong> ds = hoatDongService.getAllHoatDOng();
			request.setAttribute("ds", ds);
			request.getRequestDispatcher("danhSachHD.jsp").forward(request, response);

		} else if (uri.endsWith("/suaHoatDong")) {
			String id = request.getParameter("id");

			if (id != null) {
				HoatDong hd = hoatDongService.findHoatDongById(Integer.parseInt(id));
				if (hd != null) {
					request.setAttribute("hd", hd);
					request.getRequestDispatcher("suaHoatDong.jsp").forward(request, response);
				}

			}

		}
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		String uri = request.getRequestURI();
		if (uri.endsWith("/taoHoatDong")) {
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
					response.sendRedirect(request.getContextPath() + "/danhSachHD");
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

					request.getRequestDispatcher("taoHoatDong.jsp").forward(request, response);

				}

			}
		} else if (uri.endsWith("/suaHoatDong")) {
			String id = request.getParameter("id");
			System.out.println("Im be here");
			if (id != null) {
				HoatDong hoatDong = hoatDongService.findHoatDongById(Integer.parseInt(id));

				String tenHd = request.getParameter("nameAcv");
				String moTaHd = request.getParameter("descAcv");
				String ngayBatDauStr = request.getParameter("startDate");
				String ngayKetThucStr = request.getParameter("endDate");
				String soLuongMax = request.getParameter("maxQuantity");
				String soLuongMin = request.getParameter("minQuantity");
				String thoiHanDkStr = request.getParameter("expiredRegis");
				String status = request.getParameter("statusAcv");
				String idMember = request.getParameter("idMember");

				hoatDong.setMaHd(Integer.parseInt(id));
				hoatDong.setTenHd(tenHd);
				hoatDong.setNgayGioBd(LocalDateTime.parse(ngayBatDauStr));
				hoatDong.setNgayGioKt(LocalDateTime.parse(ngayKetThucStr));
				hoatDong.setMoTa(moTaHd);
				hoatDong.setSoLuongToiDaYc(Integer.parseInt(soLuongMax));
				hoatDong.setSoLuongToiThieuYc(Integer.parseInt(soLuongMin));
				hoatDong.setThoiHanDk(LocalDateTime.parse(thoiHanDkStr));
				hoatDong.setTrangThai(status);
				hoatDong.setThanhVien(thanhVienService.findThanhVienById(Integer.parseInt(idMember)));

				boolean isUpdated = hoatDongService.updateHoatDong(hoatDong);

				if (isUpdated) {
					logger.info("Update thanh cong");
				} else {
					logger.info("update that bai");
				}
				response.sendRedirect(request.getContextPath() + "/danhSachHD");

			}
		}

	}

}
