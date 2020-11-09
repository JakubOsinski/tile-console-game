Rough 2d RPG game in java.

Working:
Chests - player can pick up chests to gain items & gold.
Maps - maps are easy to create and move in and out from.
Exits - exits put player in next or previous map zone.
Items & equipment - player can equip any of their possesed items if the item requirements are met.
Player attributes - implemented
Battle - not yet implemented
Monsters - not yet implemented

Game takes place on map and each map has its own index.
Every map is represented as 2d array of Fields class, Field class has its own Letter variable which shows what the field is on the map. 
Each Field in the arary is an element represented on the map
Player can walk into any coordinate in the map.
Map elements consist of letters representing different things. 
Letter X is empty space, E is exit to next or previous map zone, C is chest.
M is monster, N is for NPC(both not yet implemented)


Player has several key variables:
inventory consists of every Item player has picked up. There are 4 class of items: Helmets, Armors, Weapons and Rings.
eq is every item player is wearing currently. Only 1 item per item class is allowed.

var playerAttributes = Endurance, Intelligence, Strength, Dexterity, Luck. 
Endurance = max health + little bonus to defence.
Intelligence = max mana + spell power.
Strength = physical damage + weapon/armor requirements.
Dexterity = dodge + weapon/armor requirements.
Luck = TBD

var playerStats = max health, max mana, initiative, spell power, dodge bonus, defence, accuracy. Basically things infuenced by playerAttributes , player level and eq.
var playerGeneral = player level, current experience, experience required to next level.

var playerInfo; = level, current health, current mana, current initiative, current everything.

Battle:
Enemy like player, also has its own attributes and stats. 
During battle first person to act is based on iniative key in stats hashMap.
Thereupon comes a choice of just weapon attack or if there is a wish to use a spell if player/enemy has any.
First party to drop health to 0 loses. Player gains experience according to enemy level upon victory.




