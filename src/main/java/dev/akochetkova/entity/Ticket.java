package dev.akochetkova.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonSetter;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class Ticket {

    private String origin;
    private String destination;

    @JsonSetter("departure_date")
    @JsonFormat(pattern = "dd.MM.yy")
    private LocalDate departureDate;

    @JsonSetter("departure_time")
    @JsonFormat(pattern = "H:mm")
    private LocalTime departureTime;

    @JsonSetter("arrival_date")
    @JsonFormat(pattern = "dd.MM.yy")
    private LocalDate arrivalDate;

    @JsonSetter("arrival_time")
    @JsonFormat(pattern = "H:mm")
    private LocalTime arrivalTime;

    public LocalDateTime getArrivalDateTime() {
        return LocalDateTime.of(arrivalDate, arrivalTime);
    }

    public LocalDateTime getDepartureDateTime() {
        return LocalDateTime.of(departureDate, departureTime);
    }

}
