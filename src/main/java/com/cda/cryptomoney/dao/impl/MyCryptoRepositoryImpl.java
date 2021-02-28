package com.cda.cryptomoney.dao.impl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.cda.cryptomoney.dao.MyCryptoRepository;
import com.cda.cryptomoney.model.MyCryptoMoney;



public class MyCryptoRepositoryImpl extends AbstractDAO implements MyCryptoRepository{



	@Override
	public List<MyCryptoMoney> getAll() {
		ArrayList<MyCryptoMoney> MyCryptoMoneys = new ArrayList<>();
		String request = "select * from MyCryptoMoney ;";
		try {
			result = this.statement.executeQuery(request);
			while (result.next()) {
				MyCryptoMoney myCryptoMoney = new MyCryptoMoney(result.getInt("id"),
								  result.getInt("nombreUnite"),
								  result.getFloat("prixAchat"),
								  result.getInt("cryptoId"));			
				MyCryptoMoneys.add(myCryptoMoney);
			}
		} catch (SQLException e) {
			
		}	
		return MyCryptoMoneys;
	}

	@Override
	public MyCryptoMoney save(MyCryptoMoney MyCryptoMoney) {
		
		request = "INSERT INTO MyCryptoMoney (nom,label,prix) VALUES (?,?,?);";
		try {
			ps = connexion.prepareStatement(request, PreparedStatement.RETURN_GENERATED_KEYS);
			ps.setInt(1, MyCryptoMoney.getNombreUnite() );
			ps.setFloat(2, MyCryptoMoney.getPrixAchat());
			ps.setInt(3, MyCryptoMoney.getCryptoId());
			ps.executeUpdate();
			ResultSet resultat = ps.getGeneratedKeys();
			if (resultat.next()) {
				MyCryptoMoney.setId(resultat.getInt(1));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return MyCryptoMoney;
	}

	@Override
	public MyCryptoMoney getOneById(int id) {
		String request = "select * from MyCryptoMoney where id =  ?";
		MyCryptoMoney MyCryptoMoney = null;
		try {
			ps = connexion.prepareStatement(request);
			ps.setInt(1, id);
			result = ps.executeQuery();
			result.next();
			MyCryptoMoney = new MyCryptoMoney(result.getInt("id"),
					  result.getInt("nombreUnite"),
					  result.getFloat("prixAchat"),
					  result.getInt("cryptoId"));	
		} catch (SQLException e) {
			
		}
		
		return MyCryptoMoney;

	}

	@Override
	public MyCryptoMoney setOneById(int id, MyCryptoMoney MyCryptoMoney) {

		request = "UPDATE SpecificAutoPart set nombreUnite= ? , "
				+ "prixAchat = ? ,"
				+ "cryptoId = ? "
				+ " where id = ?;";
		try {
			ps = connexion.prepareStatement(request, PreparedStatement.RETURN_GENERATED_KEYS);
			ps.setInt(1, MyCryptoMoney.getNombreUnite() );
			ps.setFloat(2, MyCryptoMoney.getPrixAchat());
			ps.setInt(3, MyCryptoMoney.getCryptoId());
			ps.setInt(4, id);
			ps.executeUpdate();
		} catch (SQLException e) {
			return null;
		}
		return getOneById(id);
	}

	@Override
	public boolean deleteOneById(int id) {		
		request = "DELETE FROM MyCryptoMoney WHERE id = ?;";
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
