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
public class SportController<path> {

    @Autowired
    private SportService sportService;

    //save
    @PostMapping("/save")
    public ResponseEntity<StandardResponse> saveSport(@RequestBody SportDTO sportDTO) {
        sportService.saveSport(sportDTO);
        ResponseEntity<StandardResponse> responseEntity = new ResponseEntity<StandardResponse>(
                new StandardResponse(201, "Successfully Saved", sportDTO), HttpStatus.CREATED);
        return responseEntity;
    }
    //delete
    @DeleteMapping(path = "/delete", params = "id")
    public ResponseEntity<StandardResponse> deleteSport(@RequestParam(value = "id") int sportId) {
        sportService.deleteSport(sportId);
        ResponseEntity<StandardResponse> responseEntity = new ResponseEntity<StandardResponse>(
                new StandardResponse(200, "Successfully Deleted", sportId), HttpStatus.OK);
        return responseEntity;
    }

    //search by ID
    @GetMapping(path = "/view-by-id", params = "id")
    public ResponseEntity<StandardResponse> viewById(@RequestParam(value = "id") int sportId) {
        SportDTO sportDTO = sportService.viewById(sportId);
        ResponseEntity<StandardResponse> responseEntity = new ResponseEntity<StandardResponse>(
                new StandardResponse(200, "View Successfully", sportDTO), HttpStatus.ACCEPTED);
        return responseEntity;
    }

    //update
    @PutMapping(path = "/update")
    public ResponseEntity<StandardResponse> updateSport(@RequestBody  SportDTO sportDTO) {
        sportService.updateSport(sportDTO);
        ResponseEntity<StandardResponse> responseEntity = new ResponseEntity<StandardResponse>(
               new StandardResponse(200, "Update Successfully", sportDTO), HttpStatus.ACCEPTED);
        return responseEntity;
    }
}
