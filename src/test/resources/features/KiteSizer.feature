Feature: Size a motherfucking kite
    
    Scenario: Size mah kite
        Given I weigh 95 pounds
        And I normally kite in 20 knots of wind
        When I calculate kite size
        Then my kite size should be 4
        
    Scenario: Size mah kite
        Given I weigh 95 pounds
        And I normally kite in 19 knots of wind
        When I calculate kite size
        Then my kite size should be 4
        
    Scenario: Size mah kite
        Given I weigh 95 pounds
        And I normally kite in 21 knots of wind
        When I calculate kite size
        Then my kite size should be 4
        
    Scenario: Size mah kite
        Given I weigh 95 pounds
        And I normally kite in 2 knots of wind
        When I calculate kite size
        Then the wind is too low to calculate a kite size
        
