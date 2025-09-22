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
public class HoatDongController extends HttpServlet{
	HoatDongService hoatDongService = new HoatDongService();
	 @Override
		protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 request.getRequestDispatcher("/WEB-INF/views/TaoHoatDong.jsp").forward(request, response);
	 }
    @Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	
//    	String name=request.getParameter("hoten");
//    	String email=request.getParameter("email");
//    	String gioTinh=request.getParameter("gioitinh");
//    	LocalDateTime ngaySinh=LocalDateTime.parse(request.getParameter("ngaySinh"));
//    	HoatDong hd = new HoatDong();
//    	hd.setTenHd(gioTinh);
//    	if(name!=null && email!=null && gioTinh!=null && ngaySinh!=null) {
//    		int a=1;
//    	}
    	
    	hoatDongService.createHoatDong();
    	
    	request.getRequestDispatcher("/WEB-INF/views/HoatDong.jsp").forward(request, response);
	}
}
