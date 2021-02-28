package com.cda.cryptomoney.service.impl;

import javax.servlet.http.HttpServletRequest;

import com.cda.cryptomoney.dao.CryptoRepository;
import com.cda.cryptomoney.dao.impl.CryptoRepositoryImpl;
import com.cda.cryptomoney.model.CryptoMoney;
import com.cda.cryptomoney.service.CryptoMoneyService;

public class CryptoServiceImpl implements CryptoMoneyService {

	private  CryptoMoney cryptoMoney = new CryptoMoney();
	private final CryptoRepository cryptoRepository = new CryptoRepositoryImpl();

	@Override
	public HttpServletRequest add(HttpServletRequest req) {
		boolean vrai = true;
		String message = "";
		if (req.getParameter("nom") == null || req.getParameter("nom").equals("")) {
			message += "Le nom ne peut pas etre vide <br>";
			vrai = false;
		}
		if (req.getParameter("label") == null || req.getParameter("label").equals("")) {
			message += "Le label ne peut pas etre vide <br>";
			vrai = false;
		}
		if (req.getParameter("prix") == null || !req.getParameter("prix").toString().matches("\\d+\\.\\d{2,2}|\\d+")) {
			message += "Le prix ne peut pas etre vide et doit etre un nombre réel avec une pricision de 2 chiffre apres la vergule <br>";
			vrai = false;
		}

		if (vrai) {
			cryptoMoney.setNom(req.getParameter("nom"));
			cryptoMoney.setLabel(req.getParameter("label"));
			cryptoMoney.setPrix(Float.parseFloat(req.getParameter("prix")));
			req.setAttribute("money", cryptoRepository.save(cryptoMoney));
			req.setAttribute("chemin", "WEB-INF/crypto/get.jsp");
		} else {
			req.setAttribute("message", message);
			req.setAttribute("chemin", "WEB-INF/crypto/add.jsp");
		}
		return req;
	}

	@Override
	public HttpServletRequest all(HttpServletRequest req) {
		req.setAttribute("moneys", cryptoRepository.getAll());
		return req;
	}

	@Override
	public HttpServletRequest get(HttpServletRequest req) {
		if (req.getParameter("id") != null && req.getParameter("id").toString().matches("\\d+")) {
			int id = Integer.parseInt(req.getParameter("id").toString());
			req.setAttribute("money", cryptoRepository.getOneById(id));
		}
		return req;
	}

	@Override
	public HttpServletRequest set(HttpServletRequest req) {
		boolean vrai = true;
		int id=0;
		String message = "";
		if (req.getParameter("id") != null && req.getParameter("id").toString().matches("\\d+")) {
			id = Integer.parseInt(req.getParameter("id").toString());
			cryptoMoney = cryptoRepository.getOneById(id);
		}
		if (req.getParameter("nom") == null || req.getParameter("nom").equals("")) {
			message += "Le nom ne peut pas etre vide <br>";
			vrai = false;
		}
		if (req.getParameter("label") == null || req.getParameter("label").equals("")) {
			message += "Le label ne peut pas etre vide <br>";
			vrai = false;
		}
		if (req.getParameter("prix") == null || !req.getParameter("prix").toString().matches("\\d+\\.\\d{2,2}|\\d+")) {
			message += "Le prix ne peut pas etre vide et doit etre un nombre réel avec une pricision de 2 chiffre apres la vergule <br>";
			vrai = false;
		}

		if (vrai && cryptoMoney!=null) {
			cryptoMoney.setNom(req.getParameter("nom"));
			cryptoMoney.setLabel(req.getParameter("label"));
			cryptoMoney.setPrix(Float.parseFloat(req.getParameter("prix")));
			req.setAttribute("money", cryptoRepository.setOneById(id,cryptoMoney));
			req.setAttribute("chemin", "WEB-INF/crypto/get.jsp");
		} else {		
			message += "L'id a était modifier <br>";
			req.setAttribute("message", message);
			req.setAttribute("chemin", "WEB-INF/crypto/set.jsp");
		}
		return req;
	}

	@Override
	public HttpServletRequest del(HttpServletRequest req) {
		if (req.getParameter("id") != null && req.getParameter("id").toString().matches("\\d+")) {
			int id = Integer.parseInt(req.getParameter("id").toString());
			cryptoRepository.deleteOneById(id);
			req.setAttribute("moneys", cryptoRepository.getAll());
		}
		return req;
	}

}
