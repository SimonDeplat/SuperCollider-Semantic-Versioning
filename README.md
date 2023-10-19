# SuperCollider-Semantic-Versioning
A workspace to document and prototype SuperCollider's Semantic Versioning implementation.

## Context

As of autumn 2023, there's a consensus among SuperCollider's developers 
regarding **the current state of the Class Library**.

**The constant addition of new functionalities and classes
has led to a state commonly referred as 'dependency hell'** where
 implementing or correcting functionalities has become
more and more difficult due to most of the class files depending on other class files.

To fix this,
[user *scztt* proposed **rethinking the current Quark system**](https://scsynth.org/t/quark-versioning-dependency-management/8086/6)
 (SuperCollider's module system)
to be able to move some of the current core functionalities inside proper modules,
allowing  to reduce dependencies (among other things).

Such a task would improve SuperCollider's modularity, but **requires
to handle dependecy conflicts automatically**.

*scztt* proposed to implement **Semantic Versioning** into SuperCollider to be able
to track modules versions, dependencies and to ease conflicts resolution.

## Links and References

[The official semver specification](https://semver.org/)

[Python implementation of the semver system](https://github.com/python-semver/python-semver)

[NPM implementation of the semver system](https://github.com/npm/node-semver)

## Project Structure

This project contains :

- a **README.md** file, this one, that provides context and introduction to the topic.

- a **Notes.md** file referencing general remarks about the topic.

- a **SemanticVersioning folder** which is the Quark folder for the Semver implementation.

	- Containing **Classes/Versions.sc** which defines the `Version` class.

	- Containing **HelpSource/Classes/Version.schelp**, the associated documentation.

## TODO
- write the user API if needed, although the class usage seems self-explanatory.
- write code examples inside the schelp file, although the class usage seems self-explanatory.
- collectively decide how to deal with pre-release string comparisons.
- implement an automatic testing procedure if needed. Methods have been tested manually so far.
- a native english speaker should correct the documentation file.

## Licence

Just as SuperCollider, this content is licenced under [GNU GPL v3 Licence](https://github.com/SimonDeplat/SuperCollider-Semantic-Versioning/blob/main/LICENSE).
