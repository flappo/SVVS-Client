
package business.webservice;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the business.webservice package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _LoadTournamentResponse_QNAME = new QName("http://webservice.business/", "loadTournamentResponse");
    private final static QName _IsFinished_QNAME = new QName("http://webservice.business/", "isFinished");
    private final static QName _LoadTournaments_QNAME = new QName("http://webservice.business/", "loadTournaments");
    private final static QName _LoadTournament_QNAME = new QName("http://webservice.business/", "loadTournament");
    private final static QName _LoadTournamentsResponse_QNAME = new QName("http://webservice.business/", "loadTournamentsResponse");
    private final static QName _IsFinishedResponse_QNAME = new QName("http://webservice.business/", "isFinishedResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: business.webservice
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link IsFinishedResponse }
     * 
     */
    public IsFinishedResponse createIsFinishedResponse() {
        return new IsFinishedResponse();
    }

    /**
     * Create an instance of {@link LoadTournaments }
     * 
     */
    public LoadTournaments createLoadTournaments() {
        return new LoadTournaments();
    }

    /**
     * Create an instance of {@link LoadTournamentsResponse }
     * 
     */
    public LoadTournamentsResponse createLoadTournamentsResponse() {
        return new LoadTournamentsResponse();
    }

    /**
     * Create an instance of {@link LoadTournament }
     * 
     */
    public LoadTournament createLoadTournament() {
        return new LoadTournament();
    }

    /**
     * Create an instance of {@link IsFinished }
     * 
     */
    public IsFinished createIsFinished() {
        return new IsFinished();
    }

    /**
     * Create an instance of {@link LoadTournamentResponse }
     * 
     */
    public LoadTournamentResponse createLoadTournamentResponse() {
        return new LoadTournamentResponse();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link LoadTournamentResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservice.business/", name = "loadTournamentResponse")
    public JAXBElement<LoadTournamentResponse> createLoadTournamentResponse(LoadTournamentResponse value) {
        return new JAXBElement<LoadTournamentResponse>(_LoadTournamentResponse_QNAME, LoadTournamentResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link IsFinished }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservice.business/", name = "isFinished")
    public JAXBElement<IsFinished> createIsFinished(IsFinished value) {
        return new JAXBElement<IsFinished>(_IsFinished_QNAME, IsFinished.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link LoadTournaments }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservice.business/", name = "loadTournaments")
    public JAXBElement<LoadTournaments> createLoadTournaments(LoadTournaments value) {
        return new JAXBElement<LoadTournaments>(_LoadTournaments_QNAME, LoadTournaments.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link LoadTournament }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservice.business/", name = "loadTournament")
    public JAXBElement<LoadTournament> createLoadTournament(LoadTournament value) {
        return new JAXBElement<LoadTournament>(_LoadTournament_QNAME, LoadTournament.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link LoadTournamentsResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservice.business/", name = "loadTournamentsResponse")
    public JAXBElement<LoadTournamentsResponse> createLoadTournamentsResponse(LoadTournamentsResponse value) {
        return new JAXBElement<LoadTournamentsResponse>(_LoadTournamentsResponse_QNAME, LoadTournamentsResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link IsFinishedResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservice.business/", name = "isFinishedResponse")
    public JAXBElement<IsFinishedResponse> createIsFinishedResponse(IsFinishedResponse value) {
        return new JAXBElement<IsFinishedResponse>(_IsFinishedResponse_QNAME, IsFinishedResponse.class, null, value);
    }

}
