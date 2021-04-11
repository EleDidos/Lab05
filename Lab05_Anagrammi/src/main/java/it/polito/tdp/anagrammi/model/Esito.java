package it.polito.tdp.anagrammi.model;

/** parola_anagrammata + giusto_o_sbagliato **/

public class Esito {

	private String anagramma;
	private boolean correttezza;
	
	public String getAnagramma() {
		return anagramma;
	}
	public void setAnagramma(String anagramma) {
		this.anagramma = anagramma;
	}
	public boolean isCorrettezza() {
		return correttezza;
	}
	public void setCorrettezza(boolean correttezza) {
		this.correttezza = correttezza;
	}
	public Esito(String anagramma, boolean correttezza) {
		super();
		this.anagramma = anagramma;
		this.correttezza = correttezza;
	}
	
	
	
}
