package dev.akochetkova;

import dev.akochetkova.entity.TicketList;
import dev.akochetkova.service.CalculatingService;
import dev.akochetkova.service.ParseService;

public class Main {

    public static void main(String[] args) {
        ParseService service = new ParseService();
        TicketList ticketList = service.parseJSON();

        CalculatingService calculatingService = new CalculatingService(ticketList.getTickets());
        double average = calculatingService.calculateMidFlightTime();
        long percentile = calculatingService.calculate90PercentileFlightTime();

        System.out.println("Average flight time in minutes: " + average);
        System.out.println("90 percentile flight time in minutes: " + percentile);
    }

}
