/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TheaterService;

import TheaterdataSource.SeatLayoutSource;
import TheaterdataSource.SeatSectionSource;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author vibhorpal
 * 
 * This class create whole layout of available theater seats.
 * 
 */
public class TheaterSeatLayoutService {

    public SeatLayoutSource getSeatLayout(String rawLayout) throws NumberFormatException {

        SeatLayoutSource layout = new SeatLayoutSource();
        SeatSectionSource section;
        List<SeatSectionSource> sectionsList = new ArrayList<SeatSectionSource>();
        int totalCapacity = 0, val;
        String[] rows = rawLayout.split(System.lineSeparator());
        String[] rowSections;

        for (int i = 0; i < rows.length; i++) {

            rowSections = rows[i].split(" ");

            for (int j = 0; j < rowSections.length; j++) {

                try {

                    val = Integer.valueOf(rowSections[j]);

                } catch (NumberFormatException nfe) {

                    throw new NumberFormatException("'" + rowSections[j] + "'" + " is invalid section capacity. Please correct it.");

                }

                totalCapacity = totalCapacity + val;

                section = new SeatSectionSource();
                section.setRowNo(i + 1);
                section.setSectionNo(j + 1);
                section.setAvailableSeats(val);
                sectionsList.add(section);

            }

        }

        layout.setTotalCapacity(totalCapacity);
        layout.setAvailableSeats(totalCapacity);
        layout.setSections(sectionsList);

        return layout;

    }
}
