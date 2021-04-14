package it.polito.tdp.anagrammi;

import java.util.List;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import it.polito.tdp.anagrammi.model.Anagram5;
import it.polito.tdp.anagrammi.model.Esito;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class FXMLController {

	Anagram5 anag = new Anagram5 ();
	
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField txtParola;

    @FXML
    private TextArea txtCorretto;

    @FXML
    private TextArea txtErrato;

    @FXML
    void btnAnagramma(ActionEvent event) {
    	
    	//struttura dati delle mie permutazioni
		List <String> corretto = new ArrayList <String> ();
		List <String> errato = new ArrayList <String> ();
		
		String parola;
	 	try {
    		parola = txtParola.getText();
    	}catch (NullPointerException npe) { //se campo è nullo
    		txtCorretto.setText("Devi inserire una parola");
    		return;
    	}

		List <Esito> risultati = anag.anagrammi(parola);
		
		//SWITCH giusti e sbagliati
		for(Esito e: risultati) {
			if(e.isCorrettezza())
				corretto.add(e.getAnagramma()); //aggiungo solo la parola a quelle corrette
			else
				errato.add(e.getAnagramma());
		}
		
		//STAMPO le due liste:
		// 1. lista corretta
		String correttiString ="";
		for(String si: corretto)
			correttiString += si+"\n";
		txtCorretto.setText(correttiString);
		// 2. lista sbagliata
		String erratiString ="";
		for(String si: errato)
			erratiString += si+"\n";
		txtErrato.setText(erratiString);


    }

    @FXML
    void btnReset(ActionEvent event) {

    	txtParola.setText("");
    	txtCorretto.setText("");
    	txtErrato.setText("");

    	
    }

    @FXML
    void initialize() {
        assert txtParola != null : "fx:id=\"txtParola\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtCorretto != null : "fx:id=\"txtCorretto\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtErrato != null : "fx:id=\"txtErrato\" was not injected: check your FXML file 'Scene.fxml'.";

    }
    
    public void setModel (Anagram5 a) {
    	anag=a;
    }

}
