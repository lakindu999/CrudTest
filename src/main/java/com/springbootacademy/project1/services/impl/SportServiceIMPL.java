package com.springbootacademy.project1.services.impl;

import com.springbootacademy.project1.DTO.SportDTO;
import com.springbootacademy.project1.entity.Sport;
import com.springbootacademy.project1.exception.NotFoundException;
import com.springbootacademy.project1.repo.SportRepo;
import com.springbootacademy.project1.services.SportService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SportServiceIMPL implements SportService {

    @Autowired
    private SportRepo sportRepo;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public String saveSport(SportDTO sportDTO) {
        Sport sport = modelMapper.map(sportDTO, Sport.class);
        sportRepo.save(sport);
        return "Saved";
    }

    @Override
    public String deleteSport(int sportId) {
        if (sportRepo.existsById(sportId)) {
            sportRepo.deleteById(sportId);
            return "Sport Deleted";
        } else {
            throw new RuntimeException("No Sport Found");
        }
    }

    @Override
    public SportDTO updateSport(SportDTO sportUpdateDTO) {
        if (sportRepo.existsById(sportUpdateDTO.getSportId())) {
            Sport sport = modelMapper.map(sportUpdateDTO, Sport.class);
            sportRepo.save(sport);
        } else {
            throw new RuntimeException("No Sport");
        }
        return null;
    }

    @Override
    public SportDTO viewById(int sportId) {
        if (sportRepo.existsById(sportId)){
            Sport sport = sportRepo.getReferenceById(sportId);
            SportDTO sportDTO =modelMapper.map(sport,SportDTO.class);
            return sportDTO;
        }
        else {
            //Used not found Exception
            throw new NotFoundException("No Customers");
        }
    }

}




