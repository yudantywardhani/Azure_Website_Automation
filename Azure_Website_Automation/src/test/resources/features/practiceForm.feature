@practice
Feature: Test automation practice form

  Background: Azure Websites Automation Page
    Given browser is open
    And user is on Automation page
    And user set delay 5 seconds

  @Textarea
  Scenario Outline: Textarea Practice
    When user enters <name>, <number>, <email>, <pass> and <address>
    Then user clicks submit button
    And close browser

    Examples: 
      | name  | number       | email          | pass        | address                                                                                        |
      | Hawlo | 082290909090 | hawlo@mail.com | P@ssw0rd123 | Jl. Ir. H. Juanda, RT.04/RW.01, Paledang, Kecamatan Bogor Tengah, Kota Bogor, Jawa Barat 16122 |

  @CheckBox&RadioButton
  Scenario Outline: CheckBox & RadioButton practice
    When user clicks <gender> gender
    And user clicks first box <list1>
    And user clicks second box <list2>
    Then the selection gender is <gender>
    Then the selection days are <list1> and <list2>
    And close browser

    Examples: 
      | gender | list1  | list2  | expected_gender | expected_list1 | expected_list2 |
      | female | monday | friday | female          | monday         | friday         |

  @DropDown
  Scenario Outline: DropDown practice
    When users selects <option> from the dropdown
    Then the selected option is <expected_option>
    And close browser

    Examples: 
      | option | expected_option |
      | Italy  | Italy           |

  @UploadFile
  Scenario Outline: File input practice
    When users uploads file <file>
    And close browser

    Examples: 
      | file                                   |
      | C:\\Users\\asus\\Downloads\\images.jpg |
