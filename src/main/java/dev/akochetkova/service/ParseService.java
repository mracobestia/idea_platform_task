package dev.akochetkova.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import dev.akochetkova.entity.TicketList;
import dev.akochetkova.exceptions.ReadingJSONFileException;

import java.io.IOException;
import java.io.InputStream;

public class ParseService {

    private final ObjectMapper mapper;

    public ParseService() {
        this.mapper = new ObjectMapper();
        mapper.registerModule(new JavaTimeModule());
    }

    public TicketList parseJSON() {
        InputStream inputStream = getClass().getClassLoader().getResourceAsStream("resources/tickets.json");

        if(inputStream != null) {
            try {
                return mapper.readValue(inputStream, TicketList.class);
            } catch (IOException ex) {
                 throw new ReadingJSONFileException(ex.getMessage());
            }
        } else {
            throw new ReadingJSONFileException("There are no file to read.");
        }
    }
}
