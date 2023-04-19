# Lokaverkefni Draugar

This is our simple version of pacman you can move by typing w,a,s or d and then hitting enter key


### Design patterns.
We are using the Template Method to make 4 (blinky, inky, pinky and clayde) different ghost with one superclass
since all the ghost are identical except for the algorithm that picks their next move.
the afram() function is used to move the ghosts and afarm() calls the drauaReikniritd() which is different for all the ghosts.


[LICENES](LICENES.md)

[Design](src/site/markdown/Design.md)

### How to run jar
you need to navigate to the draugar-1.0-SNAPSHOT.jar file (in the target folder) and then use the command 

- `java -jar draugar-1.0-SNAPSHOT.jar`


Maven:
- `mvn compile` compiles all implementation classes.
- `mvn test` runs all test cases (i.e. all classes with a name that either starts with `Test` or ends
  with `Test`, `Tests`, or `TestCase`).
- `mvn exec:java` runs CompositeMain


