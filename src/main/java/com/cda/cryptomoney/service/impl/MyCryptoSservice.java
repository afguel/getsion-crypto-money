package com.cda.cryptomoney.service.impl;

import javax.servlet.http.HttpServletRequest;

import com.cda.cryptomoney.dao.CryptoRepository;
import com.cda.cryptomoney.dao.MyCryptoRepository;
import com.cda.cryptomoney.dao.impl.CryptoRepositoryImpl;
import com.cda.cryptomoney.dao.impl.MyCryptoRepositoryImpl;
import com.cda.cryptomoney.model.MyCryptoMoney;
import com.cda.cryptomoney.service.CryptoMoneyService;



public class MyCryptoSservice implements CryptoMoneyService{
	
	
	private  MyCryptoMoney myCryptoMoney = new MyCryptoMoney();
	private final MyCryptoRepository myCryptoRepository = new MyCryptoRepositoryImpl();
	private final CryptoRepository cryptoRepository = new CryptoRepositoryImpl();
	
	

	@Override
	public HttpServletRequest add(HttpServletRequest req) {
		req=allCrypto(req);
		boolean vrai = true;
		String message = "";
		if (req.getParameter("nombre") == null && !req.getParameter("nombre").toString().matches("\\d+")) {
			message += "Le nombre ne peut pas etre vide <br>";
			vrai = false;
		}
		if (req.getParameter("prix") == null && !req.getParameter("prix").toString().matches("\\d+\\.\\d{2,2}|\\d+")) {
			message += "Le prix ne peut pas etre vide et doit etre un nombre réel avec une pricision de 2 chiffre apres la vergule <br>";
			vrai = false;
		}
		if (req.getParameter("criptoId") == null && !req.getParameter("criptoId").toString().matches("\\d+")) {
			message += "La money ne peut pas etre vide  <br>";
			vrai = false;
		}

		if (vrai) {
			myCryptoMoney.setNombreUnite(Integer.parseInt(req.getParameter("nombre")));
			myCryptoMoney.setPrixAchat(Float.parseFloat(req.getParameter("prix")));
			myCryptoMoney.setCryptoId(Integer.parseInt(req.getParameter("criptoId")));
			req.setAttribute("mycrypto", myCryptoRepository.save(myCryptoMoney));
			req.setAttribute("chemin", "WEB-INF/crypto/get.jsp");
		} else {
			req.setAttribute("message", message);
			req.setAttribute("chemin", "WEB-INF/crypto/add.jsp");
		}
		return req;
	}

	@Override
	public HttpServletRequest all(HttpServletRequest req) {
		req=allCrypto(req);
		System.out.println(myCryptoRepository.getAll().size());
		req.setAttribute("moneys", myCryptoRepository.getAll());
		return req;
	}

	@Override
	public HttpServletRequest get(HttpServletRequest req) {
		req=allCrypto(req);
		if (req.getParameter("id") != null && req.getParameter("id").toString().matches("\\d+")) {
			int id = Integer.parseInt(req.getParameter("id").toString());
			req.setAttribute("money", myCryptoRepository.getOneById(id));
		}
		return req;
	}

	@Override
	public HttpServletRequest set(HttpServletRequest req) {
		req=allCrypto(req);
		boolean vrai = true;
		int id=0;
		String message = "";
		if (req.getParameter("id") == null && req.getParameter("id").toString().matches("\\d+")) {
			id = Integer.parseInt(req.getParameter("id").toString());
			myCryptoMoney = myCryptoRepository.getOneById(id);
		}
		if (req.getParameter("nombre") == null && !req.getParameter("nombre").toString().matches("\\d+")) {
			message += "Le nombre ne peut pas etre vide <br>";
			vrai = false;
		}
		if (req.getParameter("prix") == null && !req.getParameter("prix").toString().matches("\\d+\\.\\d{2,2}|\\d+")) {
			message += "Le prix ne peut pas etre vide et doit etre un nombre réel avec une pricision de 2 chiffre apres la vergule <br>";
			vrai = false;
		}
		if (req.getParameter("criptoId") == null && !req.getParameter("criptoId").toString().matches("\\d+")) {
			message += "La money ne peut pas etre vide  <br>";
			vrai = false;
		}

		if (vrai && myCryptoMoney!=null) {
			myCryptoMoney.setNombreUnite(Integer.parseInt(req.getParameter("nombre")));
			myCryptoMoney.setPrixAchat(Float.parseFloat(req.getParameter("prix")));
			myCryptoMoney.setCryptoId(Integer.parseInt(req.getParameter("criptoId")));
			req.setAttribute("crypto", myCryptoRepository.setOneById(id,myCryptoMoney));
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
			myCryptoRepository.deleteOneById(id);
			req.setAttribute("moneys", myCryptoRepository.getAll());
		}
		return req;
	}
	
	public HttpServletRequest allCrypto(HttpServletRequest req) {		
		req.setAttribute("crypto", cryptoRepository.getAllMap());
		return req;
	}
	

}
