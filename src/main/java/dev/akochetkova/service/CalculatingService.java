package dev.akochetkova.service;

import dev.akochetkova.entity.Ticket;

import java.time.temporal.ChronoUnit;
import java.util.List;

public class CalculatingService {

    private final List<Ticket> ticketList;

    public CalculatingService(List<Ticket> ticketList) {
        this.ticketList = ticketList;
    }

    public double calculateMidFlightTime() {

        return ticketList.stream()
                .mapToLong(ticket -> ChronoUnit.MINUTES.between(ticket.getDepartureDateTime(), ticket.getArrivalDateTime()))
                .average().orElse(0);

    }

    public long calculate90PercentileFlightTime() {
        long[] flightTimes = ticketList.stream()
                .mapToLong(ticket -> ChronoUnit.MINUTES.between(ticket.getDepartureDateTime(), ticket.getArrivalDateTime()))
                .sorted()
                .toArray();
        return percentile90(flightTimes);
    }

    private long percentile90(long[] flightTimes) {
        int index = (int) Math.ceil(90 / 100.0 * flightTimes.length);
        return flightTimes[index-1];
    }

}
