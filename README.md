# P1-Tactical-Apes

## Table of Contents
- [About](https://github.com/tonyhieu/P1-Tactical-Apes/blob/main/README.md#about)
- [Contributers](https://github.com/tonyhieu/P1-Tactical-Apes/blob/main/README.md#contributers)
- [Database](https://github.com/tonyhieu/P1-Tactical-Apes/blob/main/README.md#database)
- [Simulations](https://github.com/tonyhieu/P1-Tactical-Apes/blob/main/README.md#simulations)

## About
Our project will be a series of different simulations which put data into a database. Some of our ideas for simulations are:
- [ ] Physics Pendulum
- [ ] Survival Game (akin to things like Kimi ga Shine or Danganronpa)

## Contributers
| GitHub Username | Person |
| --- | --- |
| [@VihanJ](https://github.com/VihanJ) | Vihan Jayaraman |
| [@EyaadM](https://github.com/eyaadm) | Eyaad Mir |
| [@YasaswiS](https://github.com/YasaswiS) | Yasaswi Singamneni |
| [@tonyhieu](https://github.com/tonyhieu) | Anthony Vo |

## Database
We will use databses in order to store data received from our simulations. For example, our physics simulations will store the velocity, acceleration, and position of an object at certain times. Our survival game simulation will store the winner of said games and their attributes.

## Simulations

### Physics Pendulum
To be added by Vihan and Yasaswi.

### Survival Game
In video games such as Danganronpa and Kimi ga Shine, the premise is that there is a game where multiple contestants who are forced to betray each other. The winner of said game will be the survivor(s). This simulation attempts to figure out who will win each game given a number of contestants with different attributes. Attributes are as follows:
- Intelligence
- Strength
- Sociability
- Empathy
- Pre-existing Relationships w/ Other Contestants
https://static.wikia.nocookie.net/kimi-ga-shine/images/2/22/Cara19-1.png/revision/latest/smart/width/200/height/200?cb=20190730223348
Each of these attributes will be on a scale from 1-10 aside from the relationships which will be set to strangers by default. By calculating each of these traits, we can predict who will be eliminated and what effect that will have on the other contestants. At the end, only 1-2 people will be left, and the winners will be put into the database along with their traits.
