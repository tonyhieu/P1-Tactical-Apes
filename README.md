# P1-Tactical-Apes

## Table of Contents
- [About](https://github.com/tonyhieu/P1-Tactical-Apes/blob/main/README.md#about)
- [Contributers](https://github.com/tonyhieu/P1-Tactical-Apes/blob/main/README.md#contributers)
- [Database](https://github.com/tonyhieu/P1-Tactical-Apes/blob/main/README.md#database)
- [Simulations](https://github.com/tonyhieu/P1-Tactical-Apes/blob/main/README.md#simulations)
- [Scrum Board](https://github.com/tonyhieu/P1-Tactical-Apes/projects) (The goals completed are specified in here)
- [Grading](https://github.com/tonyhieu/P1-Tactical-Apes/blob/main/README.md#grading)
- [Run Code](https://github.com/tonyhieu/P1-Tactical-Apes/blob/main/runcode.md) (Document that shows how to run the code)
## About
Our project will be a series of different simulations which put data into a database. Some of our ideas for simulations are:
- [ ] Physics Pendulum (both single and double pendulum systems)
- [ ] Survival Game (akin to things like Kimi ga Shine or Danganronpa)

## Contributors
| GitHub Username | Person |
| --- | --- |
| [@VihanJ](https://github.com/VihanJ) | Vihan Jayaraman |
| [@EyaadM](https://github.com/eyaadm) | Eyaad Mir |
| [@YasaswiS](https://github.com/YasaswiS) | Yasaswi Singamneni |
| [@tonyhieu](https://github.com/tonyhieu) | Anthony Vo |



## Database
We will use databases in order to store data received from our simulations. For example, our physics simulations will store the velocity, acceleration, and position of an object at certain times. Our survival game simulation will store the winner of said games and their attributes.

## Simulations

### Physics Pendulum
<p align="center">
  <img width="400" height="300" src="https://rotations.berkeley.edu/wp-content/uploads/2017/10/double-pendulum.png">
</p>

This simulation will simulate the chaotic double pendulum as seen [here](https://rotations.berkeley.edu/wp-content/uploads/2017/10/double-pendulum.png) and allow the user to edit things such as the mass of each pendulum, the length of the pendulum, and the starting position. We will store info about acceleration, velocity postion, forces, angles, and others at a regular interval in a database, so that they can be used for visualsations and analysis.

### Survival Game

<p align="center">
  <img src="media/souHiyori.png">
</p>

In video games such as Danganronpa and Kimi ga Shine, the premise is that there is a game where multiple contestants who are forced to betray each other. The winner of said game will be the survivor(s). This simulation attempts to figure out who will win each game given a number of contestants with different attributes. Attributes are as follows:
- Intelligence
- Strength
- Sociability
- Empathy
- Pre-existing Relationships w/ Other Contestants

Each of these attributes will be on a scale from 0-10 aside from the relationships which will be set to strangers by default. By calculating each of these traits, we can predict who will be eliminated and what effect that will have on the other contestants. At the end, only 1-2 people will be left, and the winners will be put into the database along with their traits.

### Project Plan/Timeline 

Fridays: Update Changelog with weekly coding updates. Commit all finished/debugged code. Update any images/GIF's to reflect the newest version of the project. 

-Midterm: Physics pendulum and survival game projects with functioning MVC and Source Code. Physics pendulum base simulation complete. Start adding user editable settings, start adding the functionality to save data periodically to database.

-N@TM: Complete the physics pendulum simulation, show exmple of simultion running and analysis of data. Finish survival game simulation projects with online web support.

-Final: Add and complete additional simulations. Topics will be chosen after current simulations are completed.

# Grading
## AP CSA Reflection + FRQ Playground
[Eyaad and Anthony Journal](https://docs.google.com/document/d/1_TAdjjngp_0zO604YmFBRjesVqBiyebn3PxdbbQfVCM/edit?usp=sharing)

[Vihan and Yasaswi Journal](https://docs.google.com/document/d/1pfqB4SIPHMkJ73QtPpQTaguTV1aGAqH_RgjdxjifUO4/edit?usp=sharing)

## Scrum Team Cards/Tickets

Scrum Master Grade: (19/20) Our Individual Tickets are listed in the table below. Our goals and their current statuses are specified in the [scrum board on the project tab](https://github.com/tonyhieu/P1-Tactical-Apes/projects), but we will provide an overview with our main goals below:

- Created main menu with buttons for all the simulations
- Have the algorithms for the simulations coded
- Have the code for each simulation seperated into MVC

[Here](https://github.com/tonyhieu/P1-Tactical-Apes/blob/main/runcode.md) is a link to the document that specifies how to run our code.

| Person | Goals Completed/Accomplishments | Evidence |
| --- | --- | --- |
| Vihan Jayaraman | Finished animation panel and button to start animation for single pendulum simulation | [Animation](https://github.com/tonyhieu/P1-Tactical-Apes/blob/4589e3c6742e65c2e6849489821be1517fb70aef/src/SinglePendulum/PendulumDisplay.java#L1) [StartButton](https://github.com/tonyhieu/P1-Tactical-Apes/blob/4589e3c6742e65c2e6849489821be1517fb70aef/src/SinglePendulum/SinglePendulumView.java#L54) |
| Eyaad Mir | Finished death game view | [Ticket](https://github.com/tonyhieu/P1-Tactical-Apes/blob/main/src/DeathGame/DeathGameView.java) |
| [Yasaswi Singamneni](https://github.com/tonyhieu/P1-Tactical-Apes/projects/3) | Added code to calculate next frame of the Double Pendulum simulation| [Ticket](https://github.com/tonyhieu/P1-Tactical-Apes/blob/main/src/DoublePendulum/DoublePendulumControl.java#L25) |
| Anthony Vo | Upgraded UI, completed Model portion of Survival Game | [Ticket](https://github.com/tonyhieu/P1-Tactical-Apes/projects/1#card-52951565) |
