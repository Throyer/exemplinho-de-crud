package com.github.throyer.cardapio.controller;

import com.github.throyer.cardapio.food.Food;
import com.github.throyer.cardapio.food.FoodRepository;
import com.github.throyer.cardapio.food.FoodRequestDTO;
import com.github.throyer.cardapio.food.FoodResponseDTO;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/food")
@AllArgsConstructor
public class FoodController {
    private final FoodRepository repository;

    @GetMapping
    public List<FoodResponseDTO> getAll() {
        return repository.findAll()
            .stream().map(FoodResponseDTO::new)
                .toList();
    }

    @PostMapping
    public FoodResponseDTO saveFood(@RequestBody FoodRequestDTO data) {
        return new FoodResponseDTO(repository.save(new Food(data)));
    }
}
