package it.polito.tdp.anagrammi.model;

import java.util.ArrayList;
import java.util.List;

import it.polito.tdp.anagrammi.DAO.DAO;

public class Anagram5 {
	

		
	//DAO
		DAO dao = new DAO();
		
		
		/** PROCEDURA PUBBLICA **/
		public List <Esito> anagrammi (String parola){
			List<Esito> risultato = new ArrayList<>() ;
			permuta("",parola,0,risultato); //LANCIA LA RICORSIONE
			return risultato;
		}
		
		
		/** procedura INTERNA RICORSIVA che dall'esterno non si vede
		 *  @param livello = lunghezza della soluzione parziale
		 *  @param lettere = lettere della parola iniziale che sono ancora da utilizzare (che dobbiamo ancora permutare)
		 *  @param parziale = stringa che contiene l'anagramma incompleto in fase di costruzione
		 */
		private void permuta (String parziale, String lettere, int livello, List<Esito> risultato) {
			
			/** A: condizione di terminazione --> quando arriva qui, la PARZIALE è una SOLUZIONE DI DIM CORRETTA
			 * non c'è da aggiungere nessun altro carattere, li ho aggiunti tutti **/
			if (lettere.length()==0) {
				
				/** C: devo però controllare che questa soluzione di lunghezza giusta, esista davvero **/
				if(dao.isCorrect(parziale)) {
					risultato.add(new Esito(parziale,true)); //creo anagramma con esito positivo
				} else {
					risultato.add(new Esito(parziale,false));
				}
					
			} else {
			
				for(int pos=0; pos<lettere.length(); pos++) {
					
					// 1. prendo un singolo carattere della stringa in posizione pos
					char tentativo = lettere.charAt(pos); 
					
					
					/** B: genero nuova soluzione parziale **/
					
					// 2. creo COPIA di parziale precedente non sporcato + nuovo carattere che sto tentando
					String nuovaParziale = parziale + tentativo; 
					
					
						// 3. tolgo carattere tentativo dalle lettere ancora da provare
						String nuovaLettere = lettere.substring(0, pos)+lettere.substring(pos+1);
						
						// 4. permuto con un problema più corto e una soluzione parziale più lunga
						permuta(nuovaParziale, nuovaLettere, livello+1,risultato);
						
						/** D: backracking **/
						// 5. BACKTRACKING qui NON SERVE: rimetti a posto "parziale" togliendo l'ultimo carattere aggiunto come tentativo
						//    e "lettere" rimettendo il carattere di tentativo
						//    serve solo se sporco la soluzione parziale, 
						//    qui mi conviene creare una copia della parziale prima di sporcarla
						// **********************
						// LIV 1 : parziale = nuova_parziale_liv0
						// liv 1 : lettere = nuove_lettere_liv0
					
				} //for
				
			} //else
		} //permuta


}//anagram 5
