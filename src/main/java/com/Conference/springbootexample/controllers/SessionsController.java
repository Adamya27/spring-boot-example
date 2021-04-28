package com.Conference.springbootexample.controllers;

import com.Conference.springbootexample.models.Session;
import com.Conference.springbootexample.repositories.SessionRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/api/v1/sessions")
public class SessionsController {

    @Autowired
    private SessionRepository sessionRepository;

    @GetMapping
    public @ResponseBody List<Session> list(){
        return sessionRepository.findAll();
    }

    @GetMapping
    @RequestMapping("{id}")
    public @ResponseBody Session get(@PathVariable Long id){
        return sessionRepository.getOne(id);
    }

    @PostMapping
    public @ResponseBody Session create(@RequestBody final Session session){
        return sessionRepository.saveAndFlush(session);
    }


    @RequestMapping(value = "{id}", method = RequestMethod.PUT)
    public @ResponseBody Session update(@PathVariable Long id, @RequestBody final Session session){
        Session existingSession = sessionRepository.getOne(id);
        BeanUtils.copyProperties(session, existingSession, "session_id");
        return sessionRepository.saveAndFlush(existingSession);
    }


    @RequestMapping(value = "{id}", method = RequestMethod.DELETE)
    public @ResponseBody void delete(@PathVariable Long id){
         sessionRepository.deleteById(id);
    }

}
