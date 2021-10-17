### ABOUT THE PROJECT
**Battle** is an RPG which allows players to fight in turn based battles.
RPGs are battles fought with players abilities, their equipment and weapons they have.
This is a Random RPG where players are given random ability points, gear and equipment and pit them 
against each other for battles.

### LIST OF FEATURES
- Create players with abilities - "strength, constitution, charisma and dexterity", and equip them with different 
gears - "headgear, footwear, potions and belts" and weapons such as "katana, axe, broad sword, two hand sword and flail.
- each weapon and gear affects different abilities of players and work differently based on a players stats.
- Add players to arena to participate in a turn based battle.
- Players are only allowed into the arena with base stats and then randomly equipped by the system 
- with weapons and gear.
- A summary of each turn in the turn based battle is provided.
- Gears affect players abilities by enhancing or diminishing them.
- Players are restricted on the gear and type of gear they can use at a time.
- allow a rematch between players where players will be assigned new gear and equipment.

### HOW TO RUN AND USE THE PROGRAM

- **In terminal:** cd to .jar file
- **Type the command:** java -jar <fileName>.jar
- The application runs the driver automatically but takes in user input to reset the battle between
players.
- press 'y' to allow a rematch, press any other key to terminate.

### DESCRIPTION OF EXAMPLES
- _Example Run 1_
  - Create 2 players P1 and P2 and display their base stats
  - add players to arena and display their equipment and gears as assigned by the system.
  - start the turn based battle and display the results of reach turn.
- _Example Run 2_
  - Similar to _Example Run 1_ but allows for a rematch to see different outputs.
  - Players are equipped with different gears and weapons in rematch allowing a different player to win.
- _Example Run 3_
  - Shows a scenario where game does not end in 200 moves and terminates the game.
### DESIGN CHANGES
- addition of player interface to hide implementation from user.
- Implemented Factory methods to ensure more restrictive access to class.
- Addition of a random generator which mocks the Java's Random class.
- Created helper methods with private or package - private access to ensure code re-usability.
### ASSUMPTIONS
- All the equipment (headgear, potions, belts and footwear) available to a player will affect 
the players abilities throughout the battle.
- New equipment will be given to players in case of a re-match or a new match.
- Since most of the abilities, equipment, weapons and damage calculations are done at random,
  if there is no change in the game state for more than 200 turns, the battle is terminated.
- When a player receives a katana as weapon, it is assumed that the player received dual katanas.
- damage calculation for a katana is a random number 4 and 6 added to another random between 4 and 6.
- Total damage caused by a katana is in the range 8 - 12.
- It is the task of the battle system to ensure that all constraints are upheld.
- A player by default can use any number equipment. Players can also use every weapon to their fullest 
potential. 
- The battle system enforces constraints on players when they enter the arena.

### LIMITATIONS
- The Game has only one Arena, only 1 battle can take place at a time.
- For a new battle to start the old battle should be stopped.
- User cannot request information/ summary about a battle. Summary of a battle turn is provided by the 
battle system after every turn.
- Information about previous battles is not stored. Every battle is stand alone and independent.

### CITATIONS
- None.