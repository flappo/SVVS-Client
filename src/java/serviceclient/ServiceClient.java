/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package serviceclient;

import business.webservice.SVVSService;
import business.webservice.TournamentServiceService;

/**
 *
 * @author Michael
 */
public class ServiceClient {
    
    public static void main(String args[]) {
        
        TournamentServiceService factory = new TournamentServiceService();
        SVVSService service = factory.getSVVSServicePort();
        
        for(String s : service.loadTournaments()) {
            System.out.println(s);
        }
        
    }
    
}
