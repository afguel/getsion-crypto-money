package com.cda.cryptomoney.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cda.cryptomoney.service.CryptoMoneyService;
import com.cda.cryptomoney.service.impl.CryptoServiceImpl;

@WebServlet("/money")
public class CryptoMoneyController extends HttpServlet {
	
	CryptoMoneyService cryptoMoneyService = new CryptoServiceImpl();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("menu", "money");
		String action = req.getParameter("action") != null ? req.getParameter("action").toString() : "";


		switch (action) {

		case "add":
			req.getRequestDispatcher("WEB-INF/crypto/add.jsp").forward(req, resp);
			break;

		case "set":
			req.getRequestDispatcher("WEB-INF/crypto/set.jsp").forward(cryptoMoneyService.get(req), resp);
			break;

		case "del":			
			req.getRequestDispatcher("WEB-INF/crypto/all.jsp").forward(cryptoMoneyService.del(req), resp);
			break;

		case "get":
			req.getRequestDispatcher("WEB-INF/crypto/get.jsp").forward(cryptoMoneyService.get(req), resp);
			break;

		default:			
			req.getRequestDispatcher("WEB-INF/crypto/all.jsp").forward(cryptoMoneyService.all(req), resp);
			break;
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setAttribute("menu", "money");
		String action = req.getParameter("action") != null ? req.getParameter("action").toString() : "";


		switch (action) {

		case "add":	
			req= cryptoMoneyService.add(req);
			req.getRequestDispatcher(req.getAttribute("chemin").toString()).forward(req, resp);
			break;

		case "set":
			req= cryptoMoneyService.set(req);
			req.getRequestDispatcher(req.getAttribute("chemin").toString()).forward(req, resp);
			break;			
		default:
			doGet(req,resp);
			break;

		}
	}

}
