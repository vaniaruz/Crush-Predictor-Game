# Crush Predictor 

## Features

- Event-driven login system with 3 attempts
- Modern UI with coral color scheme
- Card-based layout for smooth transitions
- Animated text effects for predictions
- User-friendly navigation between levels
- Secure preference storage for login state

## Project Structure

- `Main.java`: Application entry point
- `LoginPanel.java`: Secret code authentication
- `Level1.java`: First interaction level
- `Level2.java`: Second interaction level
- `Level3.java`: Final prediction level

## Technical Details

- Built using Java Swing and AWT
- Built using Java Swing
- Uses CardLayout for screen transitions
- Implements Timer for animations
- Custom styling with colors and fonts
- Responsive layout with proper padding and spacing

## How to Play

1. **Login Screen**
   - Enter the secret code: "CRUSH" (Hint: It rhymes with LUSH!!!)
   - You have 3 attempts to enter the correct code
   - The code is case-insensitive (CRUSH, crush, Crush all work)
   - If you enter an incorrect code:
     - You'll see a red "Incorrect code!" message
     - The number of attempts left will be shown in red
     - You'll be locked out after 3 failed attempts
   - After entering the correct code, you'll be taken to the main game

2. **Game Flow**
   - The game consists of three levels:
     - **Level 1**: Initial interaction
     - **Level 2**: Further questions
     - **Level 3**: Final prediction
   - Each level has its own unique interface and questions

3. **Using the Game**
   - In Level 3, use the "Generate" button to get a random prediction
   - The prediction animation runs for about 1 second, showing different outcomes
   - The text will quickly cycle through various predictions before settling on one final result
   - Use the "Restart" button to:
     - Reset all levels
     - Clear the prediction
     - Go back to Level 1
   - The predictions are completely random and for entertainment purposes only

## Technical Details

- Built using Java Swing and AWT
- Uses CardLayout for screen transitions
- Implements Timer for animations
- Custom styling with colors and fonts
- Responsive layout with proper padding and spacing

## How to Run

1. Ensure you have Java JDK installed
2. Compile and run the Main.java file
3. Enter the secret code "CRUSH" to start the game
4. Follow the on-screen instructions to navigate through levels

## Project Structure

- `Main.java`: Entry point of the application
- `LoginPanel.java`: Initial login screen
- `Level1.java`: First level of the game
- `Level2.java`: Second level of the game
- `Level3.java`: Final level with predictions

## Dependencies

- Java Swing
- Java AWT
- Java Util (for Random)

## License

This project is for educational and entertainment purposes only.
