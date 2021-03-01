package com.cda.cryptomoney.service.impl;



import java.sql.Date;

import javax.servlet.http.HttpServletRequest;

import com.cda.cryptomoney.dao.CryptoRepository;
import com.cda.cryptomoney.dao.MyCryptoRepository;
import com.cda.cryptomoney.dao.impl.CryptoRepositoryImpl;
import com.cda.cryptomoney.dao.impl.MyCryptoRepositoryImpl;
import com.cda.cryptomoney.model.CryptoMoney;
import com.cda.cryptomoney.model.MyCryptoMoney;
import com.cda.cryptomoney.service.CryptoMoneyService;



public class MyCryptoService implements CryptoMoneyService{
	
	
	private  MyCryptoMoney myCryptoMoney = new MyCryptoMoney();
	private  CryptoMoney cryptoMoney = new CryptoMoney();
	private final MyCryptoRepository myCryptoRepository = new MyCryptoRepositoryImpl();
	private final CryptoRepository cryptoRepository = new CryptoRepositoryImpl();
	
	

	@Override
	public HttpServletRequest add(HttpServletRequest req) {				
		boolean vrai = true;
		String message = "";
		if (req.getParameter("nombre") == null && !req.getParameter("nombre").toString().matches("\\d+")) {
			message += "Le nombre ne peut pas etre vide <br>";
			vrai = false;
		}
		if (req.getParameter("criptoId") == null && !req.getParameter("cryptoId").toString().matches("\\d+")) {
			message += "La money ne peut pas etre vide  <br>";
			vrai = false;
		}

		if (vrai) {
			int id = Integer.parseInt(req.getParameter("cryptoId"));
			myCryptoMoney = myCryptoRepository.getOneByCrypto(id);			
			boolean exist = myCryptoMoney == null?false:true;
			cryptoMoney = cryptoRepository.getOneById(id);
			if(exist) {
				
				int nombre = Integer.parseInt(req.getParameter("nombre"));
				float prix = ((myCryptoMoney.getNombreUnite()*myCryptoMoney.getPrixAchat())+
						(nombre *cryptoMoney.getPrix()))/(myCryptoMoney.getNombreUnite()+nombre);
				prix=(float) (((int)(prix*100)) /100.0);
				myCryptoMoney.setNombreUnite(myCryptoMoney.getNombreUnite()+nombre);
				myCryptoMoney.setPrixAchat(prix);
				myCryptoMoney = myCryptoRepository.setOneById(myCryptoMoney.getId(),myCryptoMoney);
			}else {				
				myCryptoMoney = new MyCryptoMoney();
				myCryptoMoney.setNombreUnite(Integer.parseInt(req.getParameter("nombre")));
				myCryptoMoney.setDate(new Date(System.currentTimeMillis()));
				myCryptoMoney.setPrixAchat(cryptoMoney.getPrix());
				myCryptoMoney.setCryptoId(cryptoMoney);
				myCryptoMoney = myCryptoRepository.save(myCryptoMoney);
			}			
			req.setAttribute("mycrypto", myCryptoMoney);
			req.setAttribute("chemin", "WEB-INF/mycrypto/get.jsp");
		} else {
			req.setAttribute("message", message);
			req.setAttribute("chemin", "WEB-INF/mycrypto/add.jsp");
		}
		return req;
	}

	@Override
	public HttpServletRequest all(HttpServletRequest req) {
		System.out.println(myCryptoRepository.getAll().size());
		req.setAttribute("moneys", myCryptoRepository.getAll());
		return req;
	}

	@Override
	public HttpServletRequest get(HttpServletRequest req) {
		if (req.getParameter("id") != null && req.getParameter("id").toString().matches("\\d+")) {
			int id = Integer.parseInt(req.getParameter("id").toString());
			req.setAttribute("mycrypto", myCryptoRepository.getOneById(id));
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
			myCryptoMoney = myCryptoRepository.getOneById(id);
		}
		if (req.getParameter("nombre") == null && !req.getParameter("nombre").toString().matches("\\d+")) {
			message += "Le nombre ne peut pas etre vide <br>";
			vrai = false;
		}
		

		if (vrai && myCryptoMoney!=null) {
			myCryptoMoney = myCryptoRepository.getOneById(id);
			myCryptoMoney.setNombreUnite(Integer.parseInt(req.getParameter("nombre").toString()));
			req.setAttribute("mycrypto", myCryptoRepository.setOneById(id,myCryptoMoney));
			req.setAttribute("chemin", "WEB-INF/mycrypto/get.jsp");
		} else {		
			message += "L'id a était modifier <br>";
			req.setAttribute("message", message);
			req.setAttribute("chemin", "WEB-INF/mycrypto/set.jsp");
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
	
	
	

}
