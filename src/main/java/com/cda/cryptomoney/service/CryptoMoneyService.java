package com.cda.cryptomoney.service;

import javax.servlet.http.HttpServletRequest;

public interface CryptoMoneyService {

	HttpServletRequest add(HttpServletRequest req);

	HttpServletRequest all(HttpServletRequest req);

	HttpServletRequest get(HttpServletRequest req);

	HttpServletRequest del(HttpServletRequest req);

	HttpServletRequest set(HttpServletRequest req);


	
}
