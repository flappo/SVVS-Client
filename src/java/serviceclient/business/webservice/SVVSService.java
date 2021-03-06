
package business.webservice;

import java.util.List;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.Action;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.4-b01
 * Generated source version: 2.2
 * 
 */
@WebService(name = "SVVSService", targetNamespace = "http://webservice.business/")
@XmlSeeAlso({
    ObjectFactory.class
})
public interface SVVSService {


    /**
     * 
     * @param arg0
     * @return
     *     returns boolean
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "isFinished", targetNamespace = "http://webservice.business/", className = "business.webservice.IsFinished")
    @ResponseWrapper(localName = "isFinishedResponse", targetNamespace = "http://webservice.business/", className = "business.webservice.IsFinishedResponse")
    @Action(input = "http://webservice.business/SVVSService/isFinishedRequest", output = "http://webservice.business/SVVSService/isFinishedResponse")
    public boolean isFinished(
        @WebParam(name = "arg0", targetNamespace = "")
        int arg0);

    /**
     * 
     * @return
     *     returns java.util.List<java.lang.String>
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "loadTournaments", targetNamespace = "http://webservice.business/", className = "business.webservice.LoadTournaments")
    @ResponseWrapper(localName = "loadTournamentsResponse", targetNamespace = "http://webservice.business/", className = "business.webservice.LoadTournamentsResponse")
    @Action(input = "http://webservice.business/SVVSService/loadTournamentsRequest", output = "http://webservice.business/SVVSService/loadTournamentsResponse")
    public List<String> loadTournaments();

    /**
     * 
     * @param arg0
     * @return
     *     returns java.util.List<java.lang.String>
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "loadTournament", targetNamespace = "http://webservice.business/", className = "business.webservice.LoadTournament")
    @ResponseWrapper(localName = "loadTournamentResponse", targetNamespace = "http://webservice.business/", className = "business.webservice.LoadTournamentResponse")
    @Action(input = "http://webservice.business/SVVSService/loadTournamentRequest", output = "http://webservice.business/SVVSService/loadTournamentResponse")
    public List<String> loadTournament(
        @WebParam(name = "arg0", targetNamespace = "")
        int arg0);

}
