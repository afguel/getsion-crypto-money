package com.cda.cryptomoney.modele;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MyCryptoMoney {
	
	private int id;
	private float nombreUnite;
    private float prixAchat;
    private int cryptoId;

}
