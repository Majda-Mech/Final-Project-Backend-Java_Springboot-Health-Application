package com.example.backendendproject.Dtos;

import com.example.backendendproject.Models.Diet;
import lombok.Getter;
import lombok.Setter;
import javax.validation.constraints.NotBlank;

@Getter
@Setter
public class GoalDto {
    @NotBlank(message = "Please specify Goal: 'Build Muscle','Conditioning', 'LoseWeight'")
    public String name;
    @NotBlank(message = "Empty field! Describe the goal: gain more strength, gain muscle, more time spend in gym")
    public String description;
    public Diet diet;

}
