package com.cda.cryptomoney.dao.impl;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.cda.cryptomoney.dao.CryptoRepository;
import com.cda.cryptomoney.dao.MyCryptoRepository;
import com.cda.cryptomoney.model.MyCryptoMoney;



public class MyCryptoRepositoryImpl extends AbstractDAO implements MyCryptoRepository{

     private final CryptoRepository cryptoRepository = new CryptoRepositoryImpl();

	@Override
	public List<MyCryptoMoney> getAll() {
		ArrayList<MyCryptoMoney> MyCryptoMoneys = new ArrayList<>();
		String request = "select * from mycryptomoney;";
		try {
			result = this.statement.executeQuery(request);
			while (result.next()) {
				MyCryptoMoney myCryptoMoney = new MyCryptoMoney(result.getInt("id"),
						          result.getDate("date"),
								  result.getInt("nombreUnite"),
								  result.getFloat("prixAchat"),
								  cryptoRepository.getOneById(result.getInt("cryptoId")));			
				MyCryptoMoneys.add(myCryptoMoney);
			}
		} catch (SQLException e) {
			
		}	
		return MyCryptoMoneys;
	}

	@Override
	public MyCryptoMoney save(MyCryptoMoney MyCryptoMoney) {
		System.out.println("repo");
		System.out.println(MyCryptoMoney.getCryptoId());
		request = "INSERT INTO mycryptomoney (date,nombreUnite,prixAchat, cryptoId) VALUES (?,?,?,?);";
		try {
			ps = connexion.prepareStatement(request, PreparedStatement.RETURN_GENERATED_KEYS);
			ps.setDate(1,  MyCryptoMoney.getDate());
			ps.setInt(2, MyCryptoMoney.getNombreUnite() );
			ps.setFloat(3, MyCryptoMoney.getPrixAchat());
			ps.setInt(4, MyCryptoMoney.getCryptoId().getId());
			
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
		String request = "select * from mycryptomoney where id =  ?";
		MyCryptoMoney MyCryptoMoney = null;
		try {
			ps = connexion.prepareStatement(request);
			ps.setInt(1, id);
			result = ps.executeQuery();
			result.next();
			MyCryptoMoney = new MyCryptoMoney(result.getInt("id"),
					  result.getDate("date"),
					  result.getInt("nombreUnite"),
					  result.getFloat("prixAchat"),
					  cryptoRepository.getOneById(result.getInt("cryptoId")));	
		} catch (SQLException e) {
			
		}
		
		return MyCryptoMoney;

	}
	
	@Override
	public MyCryptoMoney getOneByCrypto(int id) {
		String request = "select * from mycryptomoney where cryptoId =  ?";
		MyCryptoMoney MyCryptoMoney = null;
		try {
			ps = connexion.prepareStatement(request);
			ps.setInt(1, id);
			result = ps.executeQuery();
			result.next();
			MyCryptoMoney = new MyCryptoMoney(result.getInt("id"),
					  result.getDate("date"),
					  result.getInt("nombreUnite"),
					  result.getFloat("prixAchat"),
					  cryptoRepository.getOneById(result.getInt("cryptoId")));	
		} catch (SQLException e) {
			
		}
		
		return MyCryptoMoney;
	}


	@Override
	public MyCryptoMoney setOneById(int id, MyCryptoMoney MyCryptoMoney) {
		System.out.println("je suis la");
		request = "UPDATE mycryptomoney set nombreUnite= ? , "
				+ "prixAchat = ? ,"
				+ "cryptoId = ? "
				+ " where id = ?;";
		try {
			ps = connexion.prepareStatement(request, PreparedStatement.RETURN_GENERATED_KEYS);
			ps.setInt(1, MyCryptoMoney.getNombreUnite() );
			ps.setFloat(2, MyCryptoMoney.getPrixAchat());
			ps.setInt(3, MyCryptoMoney.getCryptoId().getId());
			ps.setInt(4, id);
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		return getOneById(id);
	}

	@Override
	public boolean deleteOneById(int id) {		
		request = "DELETE FROM mycryptomoney WHERE id = ?;";
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
