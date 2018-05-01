/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TheaterService;

import TheaterSubService.TheaterSeatAllotmentService;
import TheaterdataSource.SeatLayoutSource;
import TheaterdataSource.SeatSectionSource;
import TheaterdataSource.TicketRequestSource;
import java.util.List;

/**
 *
 * @author vibhorpal
 * 
 * This class create whole layout of available theater seats.
 * This service is very important. 
 * It takes output of "Theater Seating  Layout Service" and "Ticket Request Service"  as an input. 
 * It process the input and gives the final output.
 */
public class TicketProcessService {

    private void completeRequest(TicketRequestSource request, SeatSectionSource section, SeatLayoutSource layout) {
        request.setTicketRowNo(section.getRowNo());
        request.setTicketSectionNo(section.getSectionNo());
        section.setAvailableSeats(section.getAvailableSeats() - request.getNoOfTicketRequested());
        layout.setAvailableSeats(layout.getAvailableSeats() - request.getNoOfTicketRequested());
        request.setRequestComplete(true);
    }

    public List<TicketRequestSource> processTicketRequests(SeatLayoutSource layout, List<TicketRequestSource> requestList) {

        for (int i = 0; i < requestList.size(); i++) {

            TicketRequestSource request = requestList.get(i);
            System.out.println(request.getCustomerName() + " " + request.getNoOfTicketRequested());

            if (request.getrequestComplete()) {
                continue;
            }

            /*
             * -2 is an indicate that request cannot be completed.
             */
            if (request.getNoOfTicketRequested() > layout.getAvailableSeats()) {

                request.setTicketRowNo(-2);
                request.setTicketSectionNo(-2);
                continue;

            }

            List<SeatSectionSource> sections = layout.getSections();

            for (int j = 0; j < sections.size(); j++) {

                SeatSectionSource section = sections.get(j);

                if (request.getNoOfTicketRequested() == section.getAvailableSeats()) {
                    completeRequest(request, section, layout);
                    break;
                } else if (request.getNoOfTicketRequested() < section.getAvailableSeats()) {

                    TheaterSeatAllotmentService obj = new TheaterSeatAllotmentService();
                    int requestNo = obj.friendRequest(requestList, section.getAvailableSeats() - request.getNoOfTicketRequested(), i);

                    if (requestNo != -1) {
                        completeRequest(request, section, layout);
                        TicketRequestSource complementRequest = requestList.get(requestNo);
                        completeRequest(complementRequest, section, layout);
                        break;

                    } else {
                        int sectionNo = obj.sectionByAvailableSeat(sections, request.getNoOfTicketRequested());

                        if (sectionNo >= 0) {

                            SeatSectionSource perferctSection = sections.get(sectionNo);
                            completeRequest(request, perferctSection, layout);
                            break;
                        } else {
                            completeRequest(request, section, layout);

                            request.setTicketRowNo(section.getRowNo());
                            request.setTicketSectionNo(section.getSectionNo());
                            section.setAvailableSeats(section.getAvailableSeats() - request.getNoOfTicketRequested());
                            layout.setAvailableSeats(layout.getAvailableSeats() - request.getNoOfTicketRequested());
                            request.setRequestComplete(true);
                            break;

                        }

                    }

                }

            }

            /*
             * -1 is an indicate to split the party.
             */
            if (!request.getrequestComplete()) {

                request.setTicketRowNo(-1);
                request.setTicketSectionNo(-1);

            }

        }

        return requestList;
    }
}
