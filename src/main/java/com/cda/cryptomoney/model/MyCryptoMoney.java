package com.cda.cryptomoney.model;


import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MyCryptoMoney {
	
	private int id;
	private Date date;
	private int nombreUnite;
    private float prixAchat;
    private CryptoMoney cryptoId;

}
