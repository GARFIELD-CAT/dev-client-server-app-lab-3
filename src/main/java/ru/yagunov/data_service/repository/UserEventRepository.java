package ru.yagunov.data_service.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.yagunov.data_service.model.UserEvent;

public interface UserEventRepository extends JpaRepository<UserEvent, Long> {
}