package com.example.backendendproject.Dtos;

import com.example.backendendproject.Models.Diet;
import com.example.backendendproject.Models.Goal;
import com.example.endprojectsmechapplication.Models.Diet;
import com.example.endprojectsmechapplication.Models.Goal;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

@Setter
@Getter
public class DietDto {
    @NotBlank(message = "Please enter a Diet name: 'Low KCal','High Kcal','BMR Kcal'")
    public String name;
    @NotBlank(message = "Please specify diet:'Client focus on high Kcal food!'")
    public String description;

    public Goal goal;

    public DietDto(String name, String description, Goal goal) {
        this.name = name;
        this.description = description;
        this.goal = goal;
    }

    public DietDto() {
    }

    public DietDto(Diet newDiet) {
    }
}
