package com.springbootacademy.project1.controller;

import com.springbootacademy.project1.DTO.SportDTO;
import com.springbootacademy.project1.services.SportService;
import com.springbootacademy.project1.util.StandardResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/sport")
public class SportController {

    @Autowired
    private SportService sportService;

    @PostMapping("/save")
    public ResponseEntity<StandardResponse> saveSport(@RequestBody SportDTO sportDTO){
        sportService.saveSport(sportDTO);
        ResponseEntity<StandardResponse> responseEntity = new ResponseEntity<StandardResponse>(
                new StandardResponse(201,"Succesfully Saved",sportDTO), HttpStatus.CREATED);
        return responseEntity;
    }

    @DeleteMapping(path = "/delete",params = "id")
    public ResponseEntity<StandardResponse> deleteSport(@RequestParam(value = "id") int sportId){
        sportService.deleteSport(sportId);
        ResponseEntity<StandardResponse> responseEntity = new ResponseEntity<StandardResponse>(
                new StandardResponse(200,"Successfully Deleted",sportId),HttpStatus.OK);
        return responseEntity;
    }
}
