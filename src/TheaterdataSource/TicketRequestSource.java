/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TheaterdataSource;

/**
 *
 * @author vibhorpal
 * 
 * It create data source for the tickets request.
 * It track customer name, number tickets requested, ticket request completion status, ticket's row number and section number.
 */
public class TicketRequestSource {

    private String customerName;
    private int noOfTicketRequested;
    private boolean requestComplete;
    private int ticketRowNo;
    private int ticketSectionNo;

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public int getNoOfTicketRequested() {
        return noOfTicketRequested;
    }

    public void setNoOfTicketRequested(int noOfTicketRequested) {
        this.noOfTicketRequested = noOfTicketRequested;
    }

    public boolean getrequestComplete() {
        return requestComplete;
    }

    public void setRequestComplete(boolean requestComplete) {
        this.requestComplete = requestComplete;
    }

    public int getTicketRowNo() {
        return ticketRowNo;
    }

    public void setTicketRowNo(int ticketRowNo) {
        this.ticketRowNo = ticketRowNo;
    }

    public int getTicketSectionNo() {
        return ticketSectionNo;
    }

    public void setTicketSectionNo(int ticketSectionNo) {
        this.ticketSectionNo = ticketSectionNo;
    }
}
