# letterCraze - Team Technetium
CS3733 Class Project 

# Instructions
Run AppGame.java to launch the Game Application.

Run AppBuilder.java to launch the Builder Application.

## Game
Choose from one of 15 Levels in the Menu to Play.

New Levels will unlock if you achieve at least 1 star, and your progress will be saved.

Click on the Tiles to form words by chaining adjacent tiles.

####Buttons

Press the Submit Word button to submit a word, and remove its tiles.
    Tiles will float up in a submission, and the board will randomly fill empties

Press the Exit button to return to the main menu, without saving progress.

Press the Finish Level button to finish the level and save progress.

Press the Reset Button to reset the board, score, and submitted words (DOES NOT RESET TIMER)

Press the Undo Button to undo
    Tile Selection  -OR-
    Word Submission

###Puzzle Levels
You are only allowed to submit 'MaxWords' number of words in puzzle levels
However, you gain points based on how low the letter frequency is for each
Tile you select, and based on the length of the word.

You can only submit words of length 3 or greater.

###Lightning Levels
A timer will tick down as you play a lightning level, you cannot
submit any words after the timer runs out.

You can only submit words of length 3 or greater.

###Theme Levels
Theme Levels have a unique dictionary that corresponds to the Theme.

Each theme level has a predetermined number of words, you need
to submit all of the words to achieve 3 stars.

Tiles do not randomly refill after they have been emptied from a word submission

## Builder
Choose from one of the 15 Default levels to modify, or Create a new level by selecting one of the 3 create buttons at the botton of the menu.

If you create a new level, you can overwrite one of the previous names in the format
    [Puzzle,Lightning,Theme]_Level_[1-5]

Once you are editing a level, you may select or deselect any of the Tiles by clicking on them.
A Deselected Tile will blend with the background color.

***NOTE The builder will prevent you from creating an invalid board configuration i.e. a board with islands, or fewer than 9 tiles.***

###Buttons
The Exit Without Saving Button will remove any changes that you made and revert to the previous version of the level, then return to the main menu.

The Save button will Write the changes to disk and return to the main menu.

***In our latest implementation, both of the above buttons take a few seconds to execute, please wait for them, writing to disk is slow***

Each of the different levels will allow you to change the Value for 3 Stars. ***Press Enter to Save Changes before writing to disk***

***You can only set a 3 star value, the other two stars are calculated by the game based on this value***


###Puzzle Levels
The Puzzle Levels allow you to make changes to the Max Words in the Max Words text Field. ***Press Enter to Save Changes***


###Lightning Levels
The Lightning Levels allow you to make changes to the Time Limit. ***Press Enter to Save Changes***

###Theme Levels
For Theme Levels, You can change the Theme for the Level. ***Press Enter to Save Changes***
You can also add or remove words from the Dictionary (MAKE SURE THEY ARE SEPARATED BY COMMAS) ***Press SAVE WORDS to Save Changes***


## Testing
Tested using JUnit 4.12.

To run Tests, use JUnit 4 with ECLEmma on the 'tests' source folder.

***Our Tests averaged nearly 3 minutes (180 seconds) runtime on my i5-5200u in Arch Linux, please allow ample time for all the tests to run to completion***

We finished with 81.5% code coverage of our source folder.



