package it.polito.tdp.anagrammi.DAO;

public class TestDAO {

	public static void main(String[] args) {
		DAO dao = new DAO();
		
		String parola = "casa";
		boolean esito = dao.isCorrect(parola);
		System.out.println("ESITO = "+esito);

	}

}
