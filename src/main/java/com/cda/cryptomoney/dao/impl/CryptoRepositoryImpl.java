package com.cda.cryptomoney.dao.impl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.cda.cryptomoney.dao.CryptoRepository;
import com.cda.cryptomoney.modele.CryptoMoney;

public class CryptoRepositoryImpl extends AbstractDAO implements CryptoRepository{
	

	@Override
	public List<CryptoMoney> getAll() {
		ArrayList<CryptoMoney> CryptoMoneys = new ArrayList<>();
		String request = "select * from CryptoMoney ;";
		try {
			result = this.statement.executeQuery(request);
			while (result.next()) {
				CryptoMoney cryptoMoney = new CryptoMoney(result.getInt("id"),
								  result.getString("nom"),
								  result.getString("label "),
								  result.getFloat(" prix"));			
				CryptoMoneys.add(cryptoMoney);
			}
		} catch (SQLException e) {
			
		}	
		return CryptoMoneys;
	}

	@Override
	public CryptoMoney save(CryptoMoney CryptoMoney) {
		
		request = "INSERT INTO CryptoMoney (nom,label,prix) VALUES (?,?,?);";
		try {
			ps = connexion.prepareStatement(request, PreparedStatement.RETURN_GENERATED_KEYS);
			ps.setString(1, CryptoMoney.getNom() );
			ps.setString(2, CryptoMoney.getLabel());
			ps.setFloat(3, CryptoMoney.getPrix());
			ps.executeUpdate();
			ResultSet resultat = ps.getGeneratedKeys();
			if (resultat.next()) {
				CryptoMoney.setId(resultat.getInt(1));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return CryptoMoney;
	}

	@Override
	public CryptoMoney getOneById(int id) {
		String request = "select * from CryptoMoney where id =  ?";
		CryptoMoney CryptoMoney = null;
		try {
			ps = connexion.prepareStatement(request);
			ps.setInt(1, id);
			result = ps.executeQuery();
			result.next();
			CryptoMoney = new CryptoMoney(result.getInt("id"),
					  result.getString("nom"),
					  result.getString("label"),
					  result.getFloat("prix"));	
		} catch (SQLException e) {
			
		}
		
		return CryptoMoney;

	}

	@Override
	public CryptoMoney setOneById(int id, CryptoMoney CryptoMoney) {

		request = "UPDATE SpecificAutoPart set nom= ? , "
				+ "label = ? ,"
				+ "prix = ? "
				+ " where id = ?;";
		try {
			ps = connexion.prepareStatement(request, PreparedStatement.RETURN_GENERATED_KEYS);
			ps.setString(1, CryptoMoney.getNom() );
			ps.setString(2, CryptoMoney.getLabel());
			ps.setFloat(3, CryptoMoney.getPrix());
			ps.setInt(4, id);
			ps.executeUpdate();
		} catch (SQLException e) {
			return null;
		}
		return getOneById(id);
	}

	@Override
	public boolean deleteOneById(int id) {		
		request = "DELETE FROM CryptoMoney WHERE id = ?;";
		try {
			ps = connexion.prepareStatement(request);
			ps.setInt(1, id);
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}	

}
