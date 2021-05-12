AP Computer Science Final Project - README 


Mask On!
Authors: Felicia Zhang, Roshni Parulekar-Martins, Emily Tumacder
Revision: 5/ 12/ 2021


Introduction: 
It’s the year 2020, and as we all know… there’s a COVID outbreak! In 《Mask On!》,  it’s your job to save the counties of California one at a time to help stop the spread. 
《Mask On!》was designed to take the user on a journey through the COVID pandemic of 2020 in a playful way. With colorful icons and fast-paced action, users must take themselves around the board of 《Mask On!》and clear the COVID cases in each county. By clicking on the map of California or the colored boxes, located on the top right of the screen, you can travel to a county to solve the COVID cases in. 
Each county has a different level of difficulty, based on real life “tiers” we are all familiar with: Yellow, Orange, Red, and Purple. Tiers will have different strategies to clear the level, however they all have one goal: bring the COVID count to 0! A COVID count of 0 can be achieved through curing all infected people on the board, vaccinating everyone on the board, masking everyone on the board, and/or a combination of all these 3 things. 
        Each tier has a multitude of interactive items, including average citizens, doctors, hospitals, factories, and so much more! 


Instructions:
General Rules: 
        Objective: Bring the Covid count to 0 in as little time as possible
        Key binds: WASD to move player, ‘Q’ to drop a person in your inventory, ‘E’ to mask people on the board
        Player: Run into people to pick them up. You can hold one person at a time. By running into specific buildings, you can drop people into the building. 
        Masks: Collectables objects you can obtain by running into the factory. You obtain 5 masks every time you visit the factory, which has a cooldown of 20s as they replenish the masks. 
        Hospital: You can drop infected (red) people off at the hospital by running into it. The people will stay in the hospital until they are cured. 
        Private Residences: No function, other than being an obstacle.
        Covid Tracker: The bar will increase and decrease based on the Covid count on the board. Try to make the tracker reach 0 (completely white). 
        Task Bar: See what recommended tasks you should complete in order to finish the level. 
        Inventory: View what you currently have. 
        Map: Click on the circles OR rectangles to visit a county in California, whose respective color relates to their Covid case count (tiers). 
Yellow Tier (level 1): 
Refer to general rules
Orange Tier (level  2):
Public Places: Run into these buildings while holding a doctor to convert it into a hospital. 
Doctor: Run into them to pick them up. Doctors are immune to Covid, and are needed to convert public buildings into hospitals.
Red Tier (level 3):
        Vaccine Clinics: Run into these buildings while holding an uninfected, unvaccinated person to vaccinate them. They will leave the clinic immune to Covid. 
        Vaccinated People: Run into them to pick them up. 
Purple Tier (level 4):
         There’s a new variant of Covid in town! We now need to employ researchers at our vaccine clinics to create a new vaccine. 
        Vaccine Clinics: Run into these closed buildings while holding a researcher to employ them. The clinic will open up after the researchers create the vaccine. 
        Researcher: Run into them to pick them up. Researchers are immune to Covid, and are needed to open up vaccine clinics


Features List:
Must-have Features:
* [COMPLETE] There will be a menu screen with the title, start button, and instructions. 
* [COMPLETE] We need an interactive map so that players can “go” to different counties in California. By clicking on a certain area of the map, they will be able to complete a tier. 
* [COMPLETE] In the main game screen, there will be a sidebar with your inventory, which will show how much ppe and/or masks you have; a task bar, for the extra tasks that need to be completed that level; and a COVID tracker, which will fluctuate depending on the number of people in the grid that are infected. There will also be a timer that shows how long the user took to complete a tier. 
* [COMPLETE] The main game screen will have a grid with people, hospital buildings, vaccination centers, private residences, public spaces, and a PPE factory.
* [COMPLETE] The people need to be able to move on their own across the grid. 


Want-to-have Features:
* [COMPLETE] Each character and building will have a different icon, reflective of what their character/building represents or what their character is wearing (PPE). 
* We would like to have constant background music playing, which may increase tempo as covid cases rise. 
* The infected people die after becoming infected for a certain period of time. If more than a certain number of people die, you must restart the task. 
* [COMPLETE] The Player is able to choose accessories (not including any PPE) to look how they want to.
* The SideBar has more specific tracking features, and it tracks the number of people in every situation, not just infected.


Stretch Features:
* We would like to have a multiplayer option, where two people can work together to solve the COVID crisis. 
* The county that your mouse is hovering over will light up. 
* We would like to have a game without the concept of a grid, just free placement of objects and people based on pixels.


Class List:
*organized  by packages*

DEFAULT 
* Main: runs the program, contains the main method, creates the window
* DrawingSurface: window
DISPLAY
* Map: shows California
* Menu: shows info and instruction
* Timer: keeps track of time in timed version
* Covid Tracker: a bar that changes depending on how many infected are on the screen (single color). 
* Inventory: a box that represents the player’s inventory. 
* TimerDisplay: an area that displays the current elapsed time
* GameComponent: a class used for polymorphism of all types of components on the tier, basically does nothing
* TaskBar: a box that details tasks the player should do to best complete the level, does not update, just there as a hint
* Location: a class that describes the location of components
* Tier: a class for a level, it has the grid for the game
TIER
   * PurpleTier: fourth level (hardest)
   * RedTier: third level
   * OrangeTier: second level
   * YellowTier: first level (easiest)
GAMECOMPONENTS PEOPLE
* Person: represents each individual in the population in the grid
   * Doctor: people who have skills to work in a hospital
   * Researcher: people who have skills to improve vaccines
   * Player: represents the user 
GAMECOMPONENTS PLACES
* Place: a general place object, shown as a private residence
* PublicPlace: a place that can be turned into a hospital under certain circumstances
* Factory: a place that creates masks for the player to pick up
* Hospital: a place you can take infected people to cure them
* VaccineClinic: a place you can take researchers to open up the clinics, and take uninfected people to vaccinate them


Credits:
Roshni:
UML, README, Main, Drawingsurface
------
Map, Display, Location, Menu
------
Person
------
Place
------
YellowTier, OrangeTier

Felicia:
UML, README
------
CovidTracker, TaskBar, TimerDisplay
------
Doctor
------
Factory, Hospital, VaccineClinic
-------
RedTier
	
Emily:
UML, README
------
Inventory, Tier
------
Player, Researcher
------
PublicPlace
------
PurpleTier
------- 
All icons that represent game components
	

External resources: 
* Processing library (external Java library)
* Pixilart.com (drawing software)
* Unsplash.com (image database, screen background)
* GridWorld (APCS Project, used as a reference for code) 
* Cliparts.co (image database, star images)
* Clipart-library.com (image database, California map)
* 1001 Fonts (timer font)