/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package svvsclient;

import business.ControllerFactory2Remote;
import business.ControllerFactory3Remote;
import business.ControllerFactoryRemote;
import business.controller.JMS.IMessageController;
import business.controller.country.CountryControllerRemote;
import business.controller.departments.IDepartmentController;
import business.controller.person.IAuthentificationController;
import business.controller.person.IPersonController;
import business.controller.person.create.IPersonCreation;
import business.controller.person.delete.IPersonDelete;
import business.controller.person.edit.IPersonEdit;
import business.controller.role.EditPersonRole.IEditPersonRole;
import business.controller.role.IRoleController;
import business.controller.sport.ISportController;
import business.controller.team.ITeamController;
import business.controller.team.playerToTeam.IPlayerToTeam;
import business.controller.team.teamTOplayer.ITeamToPlayer;
import business.controller.touramentTeam.ITournamentTeamController;
import business.controller.tournament.Create.ITournamentCreation;
import business.controller.tournament.ITournamentController;
import business.controller.tournament.edit.ITournamentEdit;
import data.DTOs.ICountryDTO;
import data.DTOs.IDepartmentDTO;
import data.DTOs.IPersonDTO;
import data.DTOs.IRightDTO;
import data.DTOs.IRoleRightsDTO;
import data.DTOs.ISportDTO;
import data.DTOs.ITeamDTO;
import data.DTOs.ITournamentDTO;
import data.DTOs.ITournamentInviteDTO;
import java.rmi.RemoteException;
import java.util.List;
import javax.ejb.EJB;

/**
 *
 * @author phil
 */
public class Main {
    @EJB(name = "_cFactory3")
    private static ControllerFactory3Remote _cFactory3;
    @EJB(name = "_cFactory2")
    private static ControllerFactory2Remote _cFactory2;
    @EJB(name = "_cFactory")
    private static ControllerFactoryRemote _cFactory;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws RemoteException, Exception {
        // TODO code application logic here
        System.out.println("Client startet\n");
        System.out.println(_cFactory.isOk());
        System.out.println(_cFactory2.isOk());
        System.out.println(_cFactory3.isOk());

        CountryControllerRemote cc = _cFactory.getCountryController();
        List<ICountryDTO> countrylist = cc.getCountries();
        for (ICountryDTO icdto : countrylist) {
            System.out.println(icdto.getName() + "\n");
        }
        
        IEditPersonRole iepr = _cFactory3.getEditPersonRole();
        List<IRoleRightsDTO> iepRightsDTOs = iepr.loadRoleRights();
        for (IRoleRightsDTO iRoleRightsDTO : iepRightsDTOs) {
            System.out.println(iRoleRightsDTO.getName() + "\n");
        }
        
        IRoleController irc = _cFactory3.getRoleController();
        List<IRoleRightsDTO> irrrrr = irc.loadRoleRights();
        for (IRoleRightsDTO iRoleRightsDTO : irrrrr) {
             System.out.println(iRoleRightsDTO.getName() + "\n");
        }
        
        ITournamentController itcontroller = _cFactory3.getTournamentController();
        List<ITournamentDTO> tourlist = itcontroller.loadTournaments();
        for (ITournamentDTO iTournamentDTO : tourlist) {
            System.out.println(iTournamentDTO.getName() + "\n");
        }
        
        ITournamentEdit ite = _cFactory3.getTournamentEdit();
        
        ITournamentCreation iTournamentCreation = _cFactory3.getTournamentCreation();

        ITournamentTeamController ittc = _cFactory2.getTournamentTeamController();
        List<ITournamentInviteDTO> itidtos = ittc.loadTournamentTeams();
        for (ITournamentInviteDTO icdto : itidtos) {
            System.out.println(icdto.getTournament().getName() + "\n");
        }

        ITeamController itc = _cFactory2.getTeamController();
        List<ITeamDTO> teamlist = itc.loadTeams();
        for (ITeamDTO iTeamDTO : teamlist) {
            System.out.println(iTeamDTO.getName() + "\n");
        }
        
        ITeamToPlayer ittt = _cFactory2.getTeamToPlayer();
        
        IPlayerToTeam iptt = _cFactory2.getPlayerToTeam();

        IPersonCreation ipcreation = _cFactory.getPersonCreation();
        List<ICountryDTO> personcreatcountrylist = ipcreation.loadCountries();
        for (ICountryDTO icdto : personcreatcountrylist) {
            System.out.println(icdto.getName() + "\n");
        }

        List<ISportDTO> personcreatsportlist = ipcreation.loadSports();
        for (ISportDTO icdto : personcreatsportlist) {
            System.out.println(icdto.getName() + "\n");
        }

        IPersonDelete ipdel = _cFactory.getPersonDelete();

        IPersonEdit iPersonEdit = _cFactory.getPersonEdit();
        List<ICountryDTO> personeditcountrylist = iPersonEdit.loadCountries();
        for (ICountryDTO icdto : personeditcountrylist) {
            System.out.println(icdto.getName() + "\n");
        }

        IMessageController imsg = _cFactory.getMessageController();



        ISportController isc = _cFactory.getSportController();
        List<ISportDTO> sportlist = isc.getAllSports();
        for (ISportDTO iSportDTO : sportlist) {
            System.out.println(iSportDTO.getName() + "\n");
        }

        IDepartmentController idc = _cFactory.getDepartmentController();
        List<IDepartmentDTO> deplist = idc.loadDepartments();
        for (IDepartmentDTO iDepartmentDTO : deplist) {
            System.out.println(iDepartmentDTO.getName() + "\n");
        }

        IPersonController ipc = _cFactory.getPersonController();
        List<IPersonDTO> personlist = ipc.loadPersons();
        for (IPersonDTO iPersonDTO : personlist) {
            System.out.println(iPersonDTO.getFirstname() + " , " + iPersonDTO.getLastname() + "\n");
        }

        IAuthentificationController iac = _cFactory.getAuthentificationController();
        List<IRightDTO> iacRolelist = iac.getAllRights();
        for (IRightDTO iRightDTO : iacRolelist) {
            System.out.println(iRightDTO.getName() + "\n");
        }


    }
}
