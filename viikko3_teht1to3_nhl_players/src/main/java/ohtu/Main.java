package ohtu;

import java.util.ArrayList;
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
        
        // Vain suomalaiset
        ArrayList<Player> suomipelaajat = new ArrayList<Player>();
        for (Player player : players) {
        	if( player.getNationality().equals("FIN") ) {
        		suomipelaajat.add(player);
        	}
        }   
        
        
        System.out.println("\nSuomalaiset pelaajat :\n");
        for (Player player : suomipelaajat) {
        	System.out.println(player);
        } 
        
    }
  
}

