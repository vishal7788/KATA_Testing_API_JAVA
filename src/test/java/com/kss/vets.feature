Feature: Vets APIs

  @create_vet
  Scenario Outline: Create a new vet
    When I have the specialties list
    Then I should create a vet <id> <firstname> <lastname> for each of the specialty
    Examples:
      |id|firstname  |lastname  |
      |0 |"Sarah"    |"Corner"  |
      |1 |"Tom"      |"Hanks"   |
      |2 |"Jennifer" |"Lawrence"|