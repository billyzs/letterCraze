# letterCraze
CS3733 Class Project

# Instructions
Run AppGame.java to launch the Game Application.

Run AppBuilder.java to launch the Builder Application.

## Game
Choose from one of 15 Levels in the Menu to Play.

New Levels will unlock if you achieve at least 1 star, and your progress will be saved.

Click on the Tiles to form words, using adjacent tiles.

Press the Submit Word button to submit a word, and remove its tiles.
    *Tiles will float up in a submission, and the board will randomly
     fill new tiles (except in theme levels)

Press the Exit button to return to the main menu, without saving progress.

Press the Finish Level button to finish the level and save progress.

Press the Reset Button to reset the board, score, and submitted words (DOES NOT RESET TIMER)

Press the Undo Button to undo
    *Tile Selection  -OR-
    *Word Submission

Puzzle Levels
    *You are only allowed to submit 'MaxWords' number of words in puzzle levels
    However, you gain points based on how low the letter frequency is for
    each Tile you select, and based on the length of the word.
    *You can only submit words of length 3 or greater.

Lightning Levels
    *A timer will tick down as you play a lightning level, you cannot
    submit any words after the timer runs out.
    
    *You can only submit words of length 3 or greater.

Theme Levels
    *Theme Levels have a dictionary that corresponds to the Theme.
    Each theme level has a predetermined number of words, you need to 
    all of the words to achieve 3 stars.
    *Tiles do not randomly refill after they have been emptied from a word submission

## Builder


## Testing
Tested using JUnit 4.12.

