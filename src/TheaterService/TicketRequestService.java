/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TheaterService;

import TheaterdataSource.TicketRequestSource;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author vibhorpal
 * 
 * This class create whole list of available tickets request.
 */
public class TicketRequestService {

    public List<TicketRequestSource> getTicketRequests(String ticketRequests) throws NumberFormatException {

        List<TicketRequestSource> requestList = new ArrayList<TicketRequestSource>();
        TicketRequestSource request;
        String[] strRequest = ticketRequests.split(System.lineSeparator());

        for (String str : strRequest) {

            String[] strVal = str.split(" ");

            request = new TicketRequestSource();

            request.setCustomerName(strVal[0]);

            try {

                request.setNoOfTicketRequested(Integer.valueOf(strVal[1]));

            } catch (NumberFormatException nfe) {

                throw new NumberFormatException("'" + strVal[1] + "':" + "invalid ticket request.");
            }
            request.setRequestComplete(false);

            requestList.add(request);

        }

        return requestList;

    }
}
