package com.example.backendendproject.Services;

import com.example.backendendproject.Dtos.DietDto;
import com.example.backendendproject.Exceptions.DeleteRecordException;
import com.example.backendendproject.Exceptions.NoRelatedObjectFoundException;
import com.example.backendendproject.Exceptions.RecordNotFoundException;
import com.example.backendendproject.Exceptions.UpdateRecordException;
import com.example.backendendproject.Models.Diet;
import com.example.backendendproject.Models.Goal;
import com.example.backendendproject.Repositories.DietRepository;
import com.example.backendendproject.Repositories.GoalRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class DietService {
    private final DietRepository repos;
    private final GoalRepository goalRepos;


    public DietService(DietRepository repos, GoalRepository goalRepos) {
        this.repos = repos;
        this.goalRepos = goalRepos;
    }
    public Long createDiet(DietDto dietDto, Long goalId) {
        if (goalRepos.findById(goalId).isPresent()) {
            Diet newDiet = new Diet();

            newDiet.setName(dietDto.name);
            newDiet.setDescription(dietDto.description);

            Goal goalObject = goalRepos.findById(goalId).get();
            newDiet.setGoal(goalObject);

            Diet savedDiet = repos.save(newDiet);

            return savedDiet.getId();
        } else {
            throw new NoRelatedObjectFoundException("No Goal found, make sure Goal has been created before adding Diet.");
        }
    }

    public Iterable<DietDto> getAllDiet() {
        Iterable<Diet> dietList = repos.findAll();
        ArrayList<DietDto> dietDtoList = new ArrayList<>();

        for (Diet diet : dietList) {
            DietDto newGoalDto = new DietDto(diet);
            dietDtoList.add(newGoalDto);
        }
        return dietDtoList;
    }

    public DietDto getDietById(Long id) {
        if (repos.findById(id).isPresent()) {
            Diet diet      = repos.findById(id).get();
            DietDto newDietDto = new DietDto();

            newDietDto.setDescription(diet.getDescription());
            newDietDto.setName(diet.getName());
            newDietDto.setGoal(diet.getGoal());

            return newDietDto;
        } else {
            throw new RecordNotFoundException("No Goal found with this ID");
        }
    }
    public void deleteDiet(Long id) {
        if (repos.findById(id).isPresent()) {
            repos.deleteById(id);
        } else {
            throw new DeleteRecordException("No Diet found with this ID");
        }
    }
    public DietDto updateDiet(Long id, Diet newDiet) {

        if(repos.findById(id).isPresent()) {
            newDiet.setId(id);
            repos.save(newDiet);
            return new DietDto(newDiet);
        }

        else {
            throw new UpdateRecordException("No Diet found with this ID");
        }
    }

}