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

[PureData's package manager](https://github.com/pure-data/deken)