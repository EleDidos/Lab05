package it.polito.tdp.anagrammi.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;



public class DAO {
	

	public boolean isCorrect(String parziale) {
		
		final String sql = "SELECT id "
				+ "FROM parola "
				+ "WHERE nome = ?";
		
		int id = -1; // se esiste la parola nel vocabolario, a questo ID verrà associato l'int corrispondente

		try {
			Connection conn = ConnectDB.getConnection();
			PreparedStatement st = conn.prepareStatement(sql);
			st.setString(1, parziale); //passo il possibile anagramma alla query
			
			/************ scatena l'eccezione QUI ************/
			ResultSet rs = st.executeQuery();
			if(rs.next())
				id=rs.getInt("id"); //se non trova nulla cosa fa???

			conn.close();
		} catch (SQLException e) {
			throw new RuntimeException("Errore DB", e);
		}
		
		if(id!=-1) // esiste
			return true;
		else
			return false;
		
	}

}
