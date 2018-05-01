/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TheaterSubService;

import TheaterdataSource.SeatSectionSource;
import TheaterdataSource.TicketRequestSource;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 *
 * @author vibhorpal
 * 
 * This class is a sub service for "TicketProcessService" and helps to fulfill the request with the available seats and requests.
 */
public class TheaterSeatAllotmentService {

    public int friendRequest(List<TicketRequestSource> requests, int complementSeats, int currentRequestIndex) {

        int requestNo = -1;

        for (int i = currentRequestIndex + 1; i < requests.size(); i++) {

            TicketRequestSource request = requests.get(i);

            if (!request.getrequestComplete() && request.getNoOfTicketRequested() == complementSeats) {

                requestNo = i;
                break;

            }

        }

        return requestNo;
    }

    /*
     * Find section on priority of available seats
     * 
     */
    public int sectionByAvailableSeat(List<SeatSectionSource> sections, int availableSeats) {
        int i = 0;
        SeatSectionSource section = new SeatSectionSource();
        section.setAvailableSeats(availableSeats);

        Comparator<SeatSectionSource> byAvailableSeats = new Comparator<SeatSectionSource>() {
            public int compare(SeatSectionSource o1, SeatSectionSource o2) {
                return o1.getAvailableSeats() - o2.getAvailableSeats();
            }
        };
        int sectionNo = Collections.binarySearch(sections, section, byAvailableSeats);
        return sectionNo;
    }
}
