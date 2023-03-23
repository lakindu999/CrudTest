package com.springbootacademy.project1.services;


import com.springbootacademy.project1.DTO.SportDTO;

public interface SportService {

    String saveSport(SportDTO sportDTO);

    String deleteSport(int sportId);

    SportDTO updateSport(SportDTO sportUpdateDTO);

    SportDTO viewById(int sportId);

    //String updateSport(SportUpdateDTO sportUpdateDTO);
}
