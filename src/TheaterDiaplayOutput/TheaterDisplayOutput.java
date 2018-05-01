/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TheaterDiaplayOutput;

import TheaterdataSource.TicketRequestSource;
import java.util.List;

/**
 *
 * @author vibhorpal
 * 
 * This class display the final output.
 */
public class TheaterDisplayOutput {

    public void displayOutput(List<TicketRequestSource> requestList) {
        for (TicketRequestSource request : requestList) {
            if (request.getrequestComplete()) {
                System.out.println(request.getCustomerName() + " " + "Row " + request.getTicketRowNo() + " " + "Section " + request.getTicketSectionNo());
            } else {
                if (request.getTicketRowNo() == -1 && request.getTicketRowNo() == -1) {
                    System.out.println(request.getCustomerName() + " " + "Call to split party.");
                } else {
                    System.out.println(request.getCustomerName() + " " + "Sorry, we can't handle your party.");

                }

            }
        }
    }
}
