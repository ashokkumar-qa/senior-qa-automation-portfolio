

Feature: Automobile Insurance Quote

Scenario: Submit a valid insurance quote

Given the user is on the automobile insurance page

When the user enters valid vehicle details
And the user enters valid insurant details
And the user enters valid product details
And the user selects a price option
And the user submits the quote

Then the quote should be submitted successfully