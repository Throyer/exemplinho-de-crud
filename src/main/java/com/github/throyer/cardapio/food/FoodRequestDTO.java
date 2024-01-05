package com.github.throyer.cardapio.food;

public record FoodRequestDTO(
    String title,
    String image,
    Integer price
) { }
