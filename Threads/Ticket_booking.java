package Threads;

class TicketCounter {
    int availableTickets = 10;

    synchronized void bookTicket(String customerName, int noOfTickets) {
        if (availableTickets >= noOfTickets) {
            availableTickets -= noOfTickets;
            System.out.println(customerName + " booked " + noOfTickets + " tickets. Remaining tickets: " + availableTickets);

            if (availableTickets == 0) {
                refil_ticket();  // <-- call refill here, not in thread condition
            }

        } else {
            System.out.println(customerName + " failed to book tickets. Not enough tickets!");
        }
    }

    // synchronized so multiple threads don't refill at once
    synchronized void refil_ticket() {
        availableTickets += 5;
        System.out.println("Tickets refilled by system. Now available tickets: " + availableTickets);
    }
}

class BookingAgent extends Thread {
    TicketCounter ticketCounter;
    String name;
    int tickets;

    BookingAgent(TicketCounter ticketCounter, String name, int tickets) {
        this.ticketCounter = ticketCounter;
        this.name = name;
        this.tickets = tickets;
    }

    public void run() {
        ticketCounter.bookTicket(name, tickets);
    }
}

public class Ticket_booking {
    public static void main(String[] args) throws Exception {
        TicketCounter ticketCounter = new TicketCounter();

        BookingAgent t1Agent = new BookingAgent(ticketCounter, "ALI", 0);
        BookingAgent t2Agent = new BookingAgent(ticketCounter, "AHMED", 4);
        BookingAgent t3Agent = new BookingAgent(ticketCounter, "AZAN", 3);
        BookingAgent t4Agent = new BookingAgent(ticketCounter, "SHARJEEL", 1);
        BookingAgent t5Agent = new BookingAgent(ticketCounter, "HARIS", 2);

        t1Agent.start();
        t2Agent.start();
        t3Agent.start();
        t4Agent.start();
        t5Agent.start();

        t1Agent.join();
        t2Agent.join();
        t3Agent.join();
        t4Agent.join();
        t5Agent.join();

        System.out.println("Booking closed. Remaining tickets: " + ticketCounter.availableTickets);
    }
}
