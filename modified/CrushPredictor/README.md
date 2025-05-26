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

## Screenshots

"Enter the Secret Code"

![Screenshot (401)](https://github.com/user-attachments/assets/36d2e567-5386-44ab-80f0-9253d1d1eabc)

"Timeouts"

![Screenshot (411)](https://github.com/user-attachments/assets/5a8d4d13-0ccb-4fc7-8f80-51cf7f8dcf87)

![Screenshot (412)](https://github.com/user-attachments/assets/4e18f0c2-5486-42eb-b776-f3af763d47f1)



"Start"

![Screenshot (402)](https://github.com/user-attachments/assets/634266e0-57fb-4e6c-91dc-dc23c04d2ab0)

LEVEL 1

"Enter your name and crush's name"

![Screenshot (403)](https://github.com/user-attachments/assets/f501aa8a-e73c-4c56-a224-365ebc2b31d7)

"Please input both names"

![Screenshot (413)](https://github.com/user-attachments/assets/f0301612-0e9c-484e-a3c5-9b5a0257404c)


LEVEL 2 - Questions

q1 

![Screenshot (404)](https://github.com/user-attachments/assets/338addc5-84dc-46f9-8e3d-5218676260d8)

q2

![Screenshot (405)](https://github.com/user-attachments/assets/d4f92e92-9f60-4e45-a8af-fe9da51c9974)

q3

![Screenshot (406)](https://github.com/user-attachments/assets/40282dc7-ca0d-4856-bcf6-363f9f08990f)

q4

![Screenshot (407)](https://github.com/user-attachments/assets/1c8267ff-3eef-43e0-9977-25fa0da43da8)

q5

![Screenshot (408)](https://github.com/user-attachments/assets/74cb350b-47cc-492a-a774-5bd3fb70fc36)

LEVEL 3 - Generator

![Screenshot (410)](https://github.com/user-attachments/assets/410786aa-7437-46f4-9ff6-875341b3b90d)


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

