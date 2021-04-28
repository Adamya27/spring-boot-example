package com.Conference.springbootexample.repositories;

import com.Conference.springbootexample.models.Session;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SessionRepository extends JpaRepository<Session,Long> {
}
