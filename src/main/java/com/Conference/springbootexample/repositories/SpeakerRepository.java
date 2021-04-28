package com.Conference.springbootexample.repositories;

import com.Conference.springbootexample.models.Speaker;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SpeakerRepository extends JpaRepository<Speaker,Long> {
}
