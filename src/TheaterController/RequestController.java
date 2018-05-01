/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TheaterController;

import TheaterService.TheaterSeatLayoutService;
import TheaterService.TicketProcessService;
import TheaterService.TicketRequestService;
import TheaterdataSource.SeatLayoutSource;
import TheaterdataSource.TicketRequestSource;
import java.util.List;

/**
 *
 * @author vibhorpal
 * 
 * This class is the controller class of the project and it perform following task:
 * 1. Create "Theater Seating  Layout Service" to create whole layout of theater seats.
 * 2. Create "Ticket Request Service" to create tickets request.
 * 3. Create "Ticket Process Service": This service is very important.
 *    It takes above 2 service output as an input. It process the input and gives the final output.
 */
public class RequestController {

    TheaterSeatLayoutService tslsObj;
    TicketRequestService trObj;
    TicketProcessService tpObj;
    SeatLayoutSource theaterLayout;
    List<TicketRequestSource> tickectRequestList;

    public TheaterSeatLayoutService getTslsObj() {
        return tslsObj;
    }

    public void setTslsObj(TheaterSeatLayoutService tslsObj) {
        this.tslsObj = tslsObj;
    }

    public TicketRequestService getTrObj() {
        return trObj;
    }

    public void setTrObj(TicketRequestService trObj) {
        this.trObj = trObj;
    }

    public TicketProcessService getTpObj() {
        return tpObj;
    }

    public void setTpObj(TicketProcessService tpObj) {
        this.tpObj = tpObj;
    }

    public SeatLayoutSource getTheaterLayout() {
        return theaterLayout;
    }

    public void setTheaterLayout(SeatLayoutSource theaterLayout) {
        this.theaterLayout = theaterLayout;
    }

    public List<TicketRequestSource> getTickectRequestList() {
        return tickectRequestList;
    }

    public void setTickectRequestList(List<TicketRequestSource> requests) {
        this.tickectRequestList = requests;
    }

    public List<TicketRequestSource> finalOutputController(String rawLayout, String ticketRequests) {
        List<TicketRequestSource> outputList;
        setTslsObj(new TheaterSeatLayoutService());
        setTrObj(new TicketRequestService());
        setTpObj(new TicketProcessService());
        setTheaterLayout(getTslsObj().getSeatLayout(rawLayout));
        setTickectRequestList(getTrObj().getTicketRequests(ticketRequests));
        outputList = getTpObj().processTicketRequests(getTheaterLayout(), getTickectRequestList());
        return outputList;
    }

    public RequestController() {
    }
}
