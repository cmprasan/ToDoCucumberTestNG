#Author Prasanna Mani
Feature: Manage To Do list

  Scenario Outline: Create a list
    Given User is on the to do page
    When Enter the item to be done <item>
    Then Verify the item added <item> <itemsleft>
    And Verify items left <itemsleft>

    Examples: 
      | item                         | itemsleft |
      | "Drop kid at the school"     |         1 |
      | "Doctor appointment at 12PM" |         2 |
      | "Meeting at 2PM"             |         3 |
      | "Pick up from school"        |         4 |

  Scenario Outline: Edit item
    Given Items present in the list
    When Edit the item <original> <edited>
    Then Verify the item edited <edited>
    And Verify items left <itemsleft>

    Examples: 
      | original                 | edited                              | itemsleft |
      | "Drop kid at the school" | "Drop kid at the school before 8AM" |         4 |

  Scenario Outline: Delete item
    Given Items present in the list
    When Hover the mouse and Click X on the item <item>
    Then Verify if item deleted <item>
    And Verify items left <itemsleft>

    Examples: 
      | item                                | itemsleft |
      | "Drop kid at the school before 8AM" |         3 |

  Scenario Outline: Complete item
    Given Items present in the list
    When Select the checkbox of the item <item>
    Then Verify if the item completed <item>
    And Verify items left <itemsleft>

    Examples: 
      | item                         | itemsleft |
      | "Doctor appointment at 12PM" |         2 |

  Scenario Outline: Verify filters
    Given Items present in the list
    When Select filter <filter>
    Then Verify items in filter <filter>
    And Verify items left <itemsleft>

    Examples: 
      | filter      | itemsleft |
      | "Active"    |         2 |
      | "Completed" |         2 |
      | "All"       |         2 |

  Scenario Outline: Clear completed item
    Given Items present in the list
    When Click Clear Completed link
    Then Verify if completed item removed
    And Verify items left <itemsleft>

    Examples: 
      | itemsleft |
      |         2 |
