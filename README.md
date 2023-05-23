# Conqueror Game

The Conqueror Game is a strategic empire-building game developed as part of the Computer Programming Lab at the German University in Cairo, under the supervision of Prof. Dr. Slim Abdennadher. The objective of the game is to conquer cities, manage resources, and lead armies to victory. In this game, players take on the role of a powerful ruler, commanding armies, constructing buildings, and making tactical decisions to expand their empire.
## Code Style
Model-View-Controller (MVC) was used where items are seperated for easier maintainance where Model contains the schema shape of items stored in database, View for the front-end methods and Controller for the back-end methods

## Game Mechanics

### Resource Management

- The game features two main resources: gold and food.
- Gold is used for various purposes, including building construction, army recruitment, and upgrades.
- Food is necessary for sustaining armies and preventing soldier losses.
- Players start the game with 5000 gold.
- Players need to manage their resources carefully to ensure a well-functioning empire.

### Army Management

- Players can control multiple armies to conquer cities and defend their territories.
- Armies consist of different unit types, including archers, infantry, and cavalry.
- Each unit has a level, current soldier count, and maximum soldier count.
- Armies can be stationed in cities, march towards targeted cities, or besiege enemy cities.
- Armies require food to maintain their soldier count, and insufficient food may lead to soldier losses.

### City Conquest

- The game world consists of multiple cities, each representing a strategic location to be conquered.
- Players can conquer cities by defeating their defending armies.
- Defending armies are controlled by the game's AI and have their own unit compositions and soldier counts.
- Once a city is conquered, players can manage and upgrade it, recruit new units, and station armies for defense.

### Turn-Based Gameplay

- The game is played in turns, with each turn representing a specific timeframe.
- Players have a limited number of turns to achieve victory, typically set to 50 turns.
- During each turn, players can perform various actions, including managing resources, commanding armies, and interacting with cities.
- The game world and its entities may change dynamically based on the player's actions and AI-controlled events.

### Battles and Auto-Resolve

- When engaging in battles, players can choose to either manually enter the battle or auto-resolve it.
- Manual battles allow players to control their armies and make tactical decisions.
- Auto-resolved battles simulate the outcome based on army compositions, levels, and other factors.
- Battle results are determined by a combination of unit strengths, tactics, and random factors.

## Game Implementation and Features

- The game is developed in Java using object-oriented programming principles.
- The game engine handles the core game logic, including resource management, army movements, battle simulations, and AI-controlled events.
- Graphical User Interface (GUI) elements are implemented to provide a visual representation of the game world, armies, cities, and battles.
- The GUI interacts with the game engine to reflect player actions and update game state.
- Exception handling and input validation are implemented to ensure a smooth and error-free gameplay experience.

## Getting Started

To play the Conqueror Game, follow these steps:

1. Clone the game repository
2. Compile the Java source code using a Java development environment such as Eclipse or IntelliJ.
3. Run the compiled game executable to launch the game.
4. Follow the on-screen instructions and use the provided GUI elements to interact with the game world.
5. Make strategic decisions, manage resources, lead armies, and conquer cities to achieve victory!

## Contributing

Contributions to the Conqueror Game project are welcome. If you have any suggestions, improvements, or bug fixes, please submit a pull request on GitHub.

## License

The Conqueror Game is released under the [MIT License](LICENSE.md). Feel free to use, modify, and distribute the game in accordance with the terms of the license.

