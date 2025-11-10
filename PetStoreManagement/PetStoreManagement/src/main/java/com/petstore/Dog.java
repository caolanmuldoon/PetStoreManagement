package com.petstore;

class Dog extends Pet {
    private final String breed;

    public Dog(String name, int age, String colour, double weight, String breed) {
        super(name, age, colour, weight);
        this.breed = breed;
    }

    @Override
    public String speak() {
        return "Woof! I am " + name + ", a " + age + " year old " + breed;
    }

    public String getBreed() {
        return breed;
    }
}
