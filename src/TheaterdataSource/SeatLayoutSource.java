/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TheaterdataSource;

import java.util.List;

/**
 *
 * @author vibhorpal
 * 
 * This class create the seats layout data source and track status of seats available, seats used and section status.
 */
public class SeatLayoutSource {
    private int totalSeats;
    private int usableSeats;
    private List<SeatSectionSource> sections;

    public int getTotalCapacity() {
        return totalSeats;
    }

    public void setTotalCapacity(int totalCapacity) {
        this.totalSeats = totalCapacity;
    }

    public int getAvailableSeats() {
        return usableSeats;
    }

    public void setAvailableSeats(int availableSeats) {
        this.usableSeats = availableSeats;
    }

    public List<SeatSectionSource> getSections() {
        return sections;
    }

    public void setSections(List<SeatSectionSource> sections) {
        this.sections = sections;
    }
}
