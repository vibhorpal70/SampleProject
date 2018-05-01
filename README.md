# SolutionTheaterSeating

Problem 3: Theatre Seating

You run a small theater and each month, you have patrons mail in requests for pre-sale tickets.  You need to process these ticket requests and either tell them where their party will sit or explain to the patron why you can't complete their order.

You have a few rules that you need to follow when you fill the orders:
1.	Fill as many orders as possible
2.	Put parties as close to the front as possible.
3.	If there are not enough seats available in the theater to handle a party, tell them "Sorry, we can't handle your party."
4.	Each party must sit in a single row in a single section.  If they won't fit, tell them "Call to split party".

Your program must parse a theater layout and a list of ticket requests and produce a list of tickets or explanations in the same order as the requests.

The theater layout is made up of 1 or more rows.  Each row is made up of 1 or more sections separated by a space.

After the theater layout, there is one empty line, followed by 1 or more theater requests.  The theater request is made up of a name followed by a space and the number of requested tickets.

# Solution

### Project Structure:

This Application has 4 layers:

1. Input Output layer: This layer takes input and display output.

* TheaterSeatTicketStart.TheaterSeatingMain.java: This class contains the *main() and it is the start of application. It performs 3 tasks:

Get Input.

Call the controller of the application to process input.

Display final output.

* TheaterDiaplayOutput.TheaterDisplayOutput.java : Display the final output.

2. Controller layer: This layer intiate the services as per the requirement input.

*TheaterController.RequestController.java: This class is the controller class of the application and it initiate following services:
+ Create "Theater Seating  Layout Service" to create whole layout of theater seats.
+ Create "Ticket Request Service" to create tickets request.
+ Create "Ticket Process Service": This service is very important.
     It takes above 2 service output as an input. It process the input and gives the final output.

3. Service layer: This layer give services as per different request.
* TheaterService.TheaterSeatLayoutService.java : This service class create whole layout of available theater seats.
* TheaterService.TicketRequestService.java : This service class create whole list of available tickets request.
* TheaterService.TicketProcessService.java :This service class is very important. 
  It takes object of "TheaterSeatingLayoutService.java" and "TicketRequestService.java"  as an input. 
  It process the input and gives the final output.

4. Data Source layer: This layer forms the data source as their repective service. 
* TheaterdataSource.SeatLayoutSource.java : This class create the seats layout data source and track status of seats available, seats used and section status.
* TheaterdataSource.SeatSectionSource.java: This class create the seat's section data source.It track status of section's row number, section number and available seats in section.
* TheaterdataSource.TicketRequestSource.java : It create data source for the tickets request.It track customer name, number tickets requested, ticket request completion status, ticket's row number and section number.  

### Sample Input Output:

```
Please enter Theater Layout and then on new line enter 'ok' to exit.

6 6
3 5 5 3
4 6 6 4
2 8 8 2
6 6
ok

Please enter Ticket Requests and then on new line enter 'ok' to exit.

Smith 2
Jones 5
Davis 6
Wilson 100
Johnson 3
Williams 4
Brown 8
Miller 12
ok

Output.

Smith Row 1 Section 1
Jones Row 2 Section 2
Davis Row 1 Section 2
Wilson Sorry, we can't handle your party.
Johnson Row 2 Section 1
Williams Row 1 Section 1
Brown Row 4 Section 2
Miller Call to split party.
```
