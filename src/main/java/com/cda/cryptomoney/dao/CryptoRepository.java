package com.cda.cryptomoney.dao;

import java.util.HashMap;

import com.cda.cryptomoney.model.CryptoMoney;

public interface CryptoRepository extends Repository<CryptoMoney> {

	public CryptoMoney getOneByNom(String nom);

}
