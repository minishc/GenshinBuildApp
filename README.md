# GenshinBuildApp

This web app is for theorycrafting builds for characters in Genshin Impact. You can create an account and save characters, weapons,
and artifacts to your account. You will be able to combine your characters, weapons, and artifacts to make a build
and look at the stats for the build with a stat sheet similar to what you would see in game. All of the character, weapon, and artifact
art is the sole property of HoYoverse and was obtained through the wiki at https://genshin-impact.fandom.com/wiki/Genshin_Impact_Wiki <br>

#### Characters:
You can view all characters that are in the game as of the first half of patch 2.7. Each character has a simple character-page
that shows their base stats. In order to save characters you must have an account and be logged in.

#### Weapons:
You can view all weapons that are in the game as of the first half of patch 2.7.
In order to save weapons you must have an account and be logged in.

#### Artifacts: 
In order to view any of the Artifacts pages you must be logged in because each artifact is linked to a user account. 
There are two ways to save artifacts to your account. The first is to fill out the form on the webpage for each artifact, a warning - this will be slow.
The other way is to upload a .csv in the following format:
<br>{Artifact Set},{Artifact Slot},{Mainstat Name},{Mainstat Value},{Substat1 Name},{Substat1 Value}, ... ,
                {Substat4 Name},{Substat4 Value}{End of Line}
<br>
A few notes:
- It is encouraged to list slots as just "flower", "plume", etc. as the application will handle any conversions
- There is no need to enter the unique name that each artifact has, there is a JavaScript object for looking these up
- Enter the set name the way it appears on the artifact set bonus
- There are some formatting things for stats to be aware of
  - The stat names should be as the appear on the artifact unless they are for HP+X.XX%, ATK+X.XX%, or DEF+X.XX%
    - In these cases append a '%' character to the HP/ATK/DEF stat name
  - Do not enter any percentage signs after the stat values, this is handled by the application
- The artifacts in this application are all assumed to be 5 star, level 20 artifacts because it is primarily intended for theorycrafting

#### User Stories:<br>
- As a user I want to be able to add characters, weapons, and artifacts that I own to my account<br>
- As an admin I want to be able to view data from the database in browser<br>
- As a user I want to be able to quickly navigate to making a build<br>
- As an admin I want to be able to view/remove all data that is in the database<br>
- As an admin I want utilities that will validate artifacts entered by the user are valid before adding them to the database<br>
- As an admin I want to be able to remove/disable user accounts<br>
- As a user I want a feature to optimize a build for a certain stat with my account's equipment<br>
- As a user I want to be able to login with a username and password<br>
- As a user I want my builds to be shown via a stat screen like would be shown in game<br>
