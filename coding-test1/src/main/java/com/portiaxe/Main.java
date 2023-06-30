package com.portiaxe;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String args[]){

        List<Animal> animalList = new ArrayList<>();
        animalList.add(new Bird());
        animalList.add(new Dog());
        animalList.add(new Goat());

        for(Animal animal: animalList){
            animal.makeSound();
        }
    }
}
