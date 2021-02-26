package com.cda.cryptomoney.modele;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CryptoMoney {
	
	private int id;
	private String nom;
	private String label;
	private float prix;
 
}
