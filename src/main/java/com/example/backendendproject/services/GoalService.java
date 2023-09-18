package com.example.backendendproject.Services;

import com.example.backendendproject.Dtos.GoalDto;
import com.example.backendendproject.Exceptions.DeleteRecordException;
import com.example.backendendproject.Exceptions.RecordNotFoundException;
import com.example.backendendproject.Exceptions.UpdateRecordException;
import com.example.backendendproject.Models.Goal;
import com.example.backendendproject.Repositories.GoalRepository;
import org.springframework.stereotype.Service;
import java.util.ArrayList;

@Service
public class GoalService {
    private final GoalRepository repos;

    public GoalService(GoalRepository repos) {
        this.repos = repos;
    }

    public GoalDto goalToGoalDto(Goal goal) {
        GoalDto newGoal = new GoalDto();

        newGoal.setDiet(goal.getDiet());
        newGoal.setName(goal.getName());
        newGoal.setDescription(goal.getDescription());

        return newGoal;
    }

    public Long createGoal(GoalDto goalDto) {
        Goal newGoal = new Goal();

        newGoal.setName(goalDto.name);
        newGoal.setDescription(goalDto.description);
        newGoal.setDiet(goalDto.diet);

        Goal savedGoal = repos.save(newGoal);
        return newGoal.getId();
    }
    public Iterable<GoalDto> getAllGoals() {
        Iterable<Goal> goalList = repos.findAll();
        ArrayList<GoalDto> goalDtoList = new ArrayList<>();

        for (Goal goal : goalList) {
            GoalDto newGoalDto = goalToGoalDto(goal);
            goalDtoList.add(newGoalDto);
        }
        return goalDtoList;
    }

    public void deleteGoal(Long id) {
        if (repos.findById(id).isPresent()) {
            repos.deleteById(id);
        } else {
            throw new DeleteRecordException("No Goal found with this ID");
        }
    }
    public GoalDto getGoalDtoById(Long id) {
        if (repos.findById(id).isPresent()) {
            Goal goal = repos.findById(id).get();
            GoalDto newGoalDto = goalToGoalDto(goal);
            return newGoalDto;
        } else {
            throw new RecordNotFoundException("No Goal found with this ID");
        }
    }

    public GoalDto updateGoal(Long id, Goal newGoal) {
        if(repos.findById(id).isPresent()) {
            newGoal.setId(id);
            Goal goal = repos.save(newGoal);
            return goalToGoalDto(goal);
        } else {
            throw new UpdateRecordException("No Goal found with this ID");
        }
    }
}