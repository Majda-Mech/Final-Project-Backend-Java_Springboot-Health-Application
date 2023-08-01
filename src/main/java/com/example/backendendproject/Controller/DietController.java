package com.example.backendendproject.Controller;

import com.example.backendendproject.Dtos.DietDto;
import com.example.backendendproject.Models.Diet;
import com.example.backendendproject.Services.DietService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;

@RestController
@RequestMapping("/diets")
public class DietController {
    private final DietService dietService;

    public DietController(DietService dietService){
        this.dietService = dietService;
    }

    @PostMapping("/{goalId}")
    public ResponseEntity<String> createDiet(@Valid @PathVariable Long goalId, @RequestBody DietDto dietDto, BindingResult br) {
        Long savedDiet = dietService.createDiet(dietDto, goalId);
        if (br.hasErrors()) {
            StringBuilder sb = new StringBuilder();
            for (FieldError fe : br.getFieldErrors()) {
                sb.append(fe.getField() + ":");
                sb.append(fe.getDefaultMessage());
                sb.append("\n");
            }
            return new ResponseEntity<>(sb.toString(), HttpStatus.BAD_REQUEST);
        } else {
            URI uri = URI.create(
                    ServletUriComponentsBuilder
                            .fromCurrentContextPath()
                            .path("/diets/" + savedDiet).toUriString());
            return ResponseEntity.created(uri).body("Diet is created");
        }
    }

    @GetMapping("")
    public ResponseEntity<Iterable<DietDto>> getAllDiets() {
        return ResponseEntity.ok(dietService.getAllDiet());
    }

    @GetMapping("{id}")
    public ResponseEntity<DietDto> getDietById(@PathVariable Long id) {
        return ResponseEntity.ok(dietService.getDietById(id));
    }

    @PutMapping("{id}")
    public ResponseEntity<String> updateDiet(@PathVariable Long id, @RequestBody Diet newDiet) {
        dietService.updateDiet(id, newDiet);
        return ResponseEntity.ok().body("Diet has been Updated");
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Object> deleteDiet(@PathVariable Long id) {
        dietService.deleteDiet(id);
        return ResponseEntity.ok().body("Diet has been Deleted");
    }
}
