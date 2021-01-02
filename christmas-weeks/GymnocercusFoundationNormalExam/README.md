# Gymnocercus Foundation Normal Exam

## Getting Started

- **Fork** this repository under your own account
- Clone your forked repository to your computer
- Create a `.gitignore` file so generated files won't be committed
- Commit your progress frequently and with descriptive commit messages
- All your answers and solutions should go in this repository
- Take care of style guide
- Take care of the naming of classes, fields, variables, files, etc.

## Keep in mind

- You can use any resource online, but **please work individually**

- **Don't just copy-paste** your answers and solutions,
  use your own words instead

- **Don't push your work** to GitHub until your mentor announces
  that the time is up

## Exercises


### Unique Characters

Create a function that takes a string as parameter
and returns a list with the unique letters of the given string.

Write 2 different unit test cases for the method.

#### Example

Input

```text
"anagram"
```

Output

```text
["n", "g", "r", "m"]
```

### Average temperature

Write a method which can read and parse a file containing information about
the average temperature of three European countries
to raise awareness of climate change.
Each line represents the average temperature of each country in the given year.
The actual year can be found at the end of each line.

The method should return the first coldest and hottest year in each country.

The application should write the data to the console as *key => value* pairs.

#### Example

[Example file can be found here.](./results.txt)

Output

```text
France => 1996, 2018
Sweden => 2004, 2017
Germany => 2000, 2017
```

### Fish tank

Now you are going to create a simple aquarium
where you can take care of your fishes.

#### Fish

Each fish has a name, weight and a color.

- The fish has a `status()` method. It should print the status for a fish. The implementation    should depend on the type of the fish.

  - For example: `Dory, weight: 9, color: blue, short-term memory loss: true`

- The fish has a `feed()` method. The implementation should depend
  on the type of the fish.

##### Clownfish

Clownfish, gains 1 gramm when fed and
has an additional color (color of the stripes).

##### Tang

Tang, gains 1 gramm when fed and can suffer short-term memory loss.

##### Kong

Kong, gains 2 grams when fed.

#### Aquarium

- It has an `addFish()` method where you can add fishes to the aquarium.

- It has a `feed()` method that feeds all the fishes in the aquarium:

  - Increases the weight of every fish with the amount of grams
    they gain when fed.

- It has a `removeFish()` a method that removes the big fishes:

  - A big fish's weight is at least 11 grams.

- The aquarium has a `getStatus()` method it should print
  the status for each fish.


## Command line exercise

- Take a look at this directory structure:

```text
pokedex
 └--generation-i
     |--grass
     |   |--bulbasaur.md
     |   └--oddish.md
     |--fire
     |   |--pidgey.md
     |   |--charmander.md
     |   └--vulpix.md
     └--water
         |--pyduck.md
         |--spearow.md
         └--squirtle.md
```

- Your task is to write commands in the correct order from the directory given below.
- Do it with less commands without chaining them together.
- Your current directory is `pokedex/`
  1. Change the `generation-i/` directory into a Git repository
  1. Rename `water/pyduck.md` to `water/pyduck.md`
  1. Create a directory in `generation-i/` named `flying`
  1. Move `fire/pidgey.md` to `flying/` directory
  1. Move `water/spearow.md` to `flying/` directory
  1. Create a file named `my-pokemon.txt`
  1. List all the files in `grass/` and redirect it to `my-pokemon.txt`
  1. Commit the changes from the `fire/` directory

- Solution:

```
cd generation-i
git init
mv water/pyduck.md water/psyduck.md
mkdir flying
mv fire/pidgey.md flying/
mv water/spearow.md flying/
touch my-pokemon.txt
ls grass/ >> my-pokemon.txt
cd flying
git commit m"Created mypokemon.txt and flying/ directory. Renamed psyduck.md, moved pidgey.md and sparow.md into flying/ directory."
```
