Feature: Pets APIs

  @get_pets
  Scenario: Get all the PETS
    When I want to know all the pets in the clinic
    Then I should receive 13 pets

  @add_pet
  Scenario: Add a new pet
    When I have Owner and Pet details
    Then I should add a pet to owner