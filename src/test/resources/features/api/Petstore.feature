Feature: API operations on PetStore

  @GetApi
  Scenario: Get pet details
    Given I prepare the GET request for "petStore" API
    When   I hit "getPetDetails" api
    Then  I validate list of pets with available status received in response

  @PostAPI
  Scenario: Add new available pet to store
    Given I prepare the POST request for "petStore" API
    When  I hit post addNewPet api
    Then  I validate new pet added succesfully

  @UpdateAPI
  Scenario: Update pet details
    Given I prepare the PUT request for "petStore" API
    When I hit put updatePetStatus API
    Then I verify request is successful
    
