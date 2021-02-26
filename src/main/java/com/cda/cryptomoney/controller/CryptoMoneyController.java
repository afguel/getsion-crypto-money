package com.cda.cryptomoney.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/money")
public class CryptoMoneyController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String action = req.getParameter("action") != null ? req.getParameter("action").toString() : "";
		
		System.out.println(action);

		switch (action) {

		case "add":
			req.getRequestDispatcher("WEB-INF/crypto/add.jsp").forward(req, resp);
			break;

		case "set":
			req.getRequestDispatcher("WEB-INF/crypto/set.jsp").forward(req, resp);
			break;

		case "del":
			req.getRequestDispatcher("WEB-INF/crypto/all.jsp").forward(req, resp);
			break;

		case "get":
			req.getRequestDispatcher("WEB-INF/crypto/get.jsp").forward(req, resp);
			break;

		default:

			break;
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		req.getRequestDispatcher("WEB-INF/crypto/all.jsp").forward(req, resp);

	}

}
