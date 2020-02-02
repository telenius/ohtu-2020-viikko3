package ohtu;

import java.util.ArrayList;
import java.util.Collections;

import com.google.gson.Gson;
import java.io.IOException;
import org.apache.http.client.fluent.Request;

public class Main {
    public static void main(String[] args) throws IOException {
        String url = "https://nhlstatisticsforohtu.herokuapp.com/players";
        
        String bodyText = Request.Get(url).execute().returnContent().asString();
                
        // System.out.println("json-muotoinen data:");
        // System.out.println( bodyText );

        Gson mapper = new Gson();
        Player[] players = mapper.fromJson(bodyText, Player[].class);
        
        // Vain suomalaiset, lasketaan samalla pisteiden summa
        ArrayList<Player> suomipelaajat = new ArrayList<Player>();
        for (Player player : players) {
        	if( player.getNationality().equals("FIN") ) {
        		suomipelaajat.add(player);
        		player.setPoints();
        	}
        }   
        players=null;
        
        
        System.out.println("\nSuomalaiset pelaajat :\n");
        
        Collections.sort(suomipelaajat);
        for (Player player : suomipelaajat) {
        	System.out.println(player);
        } 
        
    }
  
}

