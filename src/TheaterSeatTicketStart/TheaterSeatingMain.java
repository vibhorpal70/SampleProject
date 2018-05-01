/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TheaterSeatTicketStart;

import TheaterController.RequestController;
import TheaterDiaplayOutput.TheaterDisplayOutput;
import TheaterdataSource.TicketRequestSource;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author vibhorpal
 * 
 * This class is the start of project and it performs 3 task:
 * 1. Get Input.
 * 2. Call the controller of the project to process input.
 * 3. Display final output.
 */
public class TheaterSeatingMain {

    public static void main(String[] args) {
        // TODO code application logic here
        String userLayoutInput;
        String userTicketRequestInput;
        StringBuilder theaterLayoutStr = new StringBuilder();
        StringBuilder ticketRequestsStr = new StringBuilder();
        // Start of Input
        System.out.println("Please enter Theater Layout and then on new line enter 'ok' to exit.\n");

        Scanner input = new Scanner(System.in);

        while ((userLayoutInput = input.nextLine()) != null && !userLayoutInput.equals("ok")) {
            theaterLayoutStr.append(userLayoutInput + System.lineSeparator());
        }

        System.out.println("Please enter Ticket Requests and then on new line enter 'ok' to exit.\n");

        while ((userTicketRequestInput = input.nextLine()) != null && !userTicketRequestInput.equals("ok")) {
            ticketRequestsStr.append(userTicketRequestInput + System.lineSeparator());
        }

        input.close();
        // Input End

        // Input Processing Start
        RequestController controller = new RequestController();
        TheaterDisplayOutput displayOutput = new TheaterDisplayOutput();
        try {
            List<TicketRequestSource> finalOutput = controller.finalOutputController(theaterLayoutStr.toString(), ticketRequestsStr.toString());
            // Input Processing End

            // Ouput Display Start
            System.out.println("\nOutput.\n");
            displayOutput.displayOutput(finalOutput);
            // Ouput Display End
        } catch (NumberFormatException nfe) {
            System.out.println(nfe.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    }
    

