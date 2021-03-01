package com.cda.cryptomoney.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cda.cryptomoney.model.CryptoMoney;
import com.cda.cryptomoney.service.CryptoMoneyService;
import com.cda.cryptomoney.service.impl.CryptoServiceImpl;
import com.cda.cryptomoney.service.impl.MyCryptoService;

@WebServlet("/index.html")
public class MyCryptoMoneyController extends HttpServlet{

	private MyCryptoService myCryptoService = new MyCryptoService();
	private CryptoMoneyService cryptoService = new CryptoServiceImpl();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setAttribute("menu", "mymoney");
		String action = req.getParameter("action") != null ? req.getParameter("action").toString() : "";

		System.out.println(action);

		switch (action) {

		case "add":
			
			req.getRequestDispatcher("WEB-INF/mycrypto/add.jsp").forward(cryptoService.all(req), resp);
			break;

		case "set":
			req= cryptoService.all(req);
			req.getRequestDispatcher("WEB-INF/mycrypto/set.jsp").forward(myCryptoService.get(req), resp);
			break;

		case "del":			
			req.getRequestDispatcher("WEB-INF/mycrypto/all.jsp").forward(myCryptoService.del(req), resp);
			break;

		case "get":
			req.getRequestDispatcher("WEB-INF/mycrypto/get.jsp").forward(myCryptoService.get(req), resp);
			break;

		default:	
			req.setAttribute("menu", "accueil");
			req.getRequestDispatcher("WEB-INF/mycrypto/all.jsp").forward(myCryptoService.all(req), resp);
			break;
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setAttribute("menu", "mymoney");
		String action = req.getParameter("action") != null ? req.getParameter("action").toString() : "";

		System.out.println(action);

		switch (action) {

		case "add":	
			System.out.println("controller");
			req= myCryptoService.add(req);
			System.out.println(req.getAttribute("chemin").toString());
			req.getRequestDispatcher(req.getAttribute("chemin").toString()).forward(req, resp);
			break;

		case "set":
			req= myCryptoService.set(req);
			System.out.println(req.getAttribute("chemin").toString());
			req.getRequestDispatcher(req.getAttribute("chemin").toString()).forward(req, resp);
			break;			
		default:
			doGet(req,resp);
			break;

		}
	}
}
