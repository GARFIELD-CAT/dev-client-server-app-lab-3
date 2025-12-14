package ru.yagunov.data_service.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import ru.yagunov.data.api.UserEventApi;
import ru.yagunov.data.model.UserEvent;
import ru.yagunov.data_service.repository.UserEventRepository;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class UserEventController implements UserEventApi {
    private final UserEventRepository userEventRepository;

    @Override
    public ResponseEntity<List<UserEvent>> eventsGet() {
        List<ru.yagunov.data_service.model.UserEvent> baseUserEvents = userEventRepository.findAll();

        List<UserEvent> serviceEvents = new ArrayList<>();
        for (ru.yagunov.data_service.model.UserEvent baseEvent : baseUserEvents) {
            UserEvent userEvent = new UserEvent();
            userEvent.setEventType(baseEvent.getEventType());
            userEvent.setEventTime(baseEvent.getEventTime());

            serviceEvents.add(userEvent);
        }

        return ResponseEntity.status(HttpStatus.OK).body(serviceEvents);
    }
}
