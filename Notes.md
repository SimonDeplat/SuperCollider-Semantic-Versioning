# Notes

To integrate with SuperCollider architecture,
the Semantic Versioning will be an **.sc file defining a class
that provides semantic versioning utilities**.

The name of the class is likely to be `Version` to retain clarity.

---
One of the requirements of *semver* is to have a **strict syntax**.

As such, it might be a good idea **to prevent the user from manipulating
the semver string directly**, delegating the responsibility of such manipulations
to the class :

```
var version = Version().load(myQuark);
version = version.incrementPatch;
myQuark.updateVersion;
```

**Update :** current implementation follows this guideline using *.bumpMajor*,
*.bumpMinor* and *.bumpPatch* to increment versions. Due to *pre-release* and *build*
being `String` literals, bumping them is unsupported.
They have a traditionnal setter instead. This could be revised in the future.

---
The semver needs to support `<`, `>`, `<=`, `>=`, `==` operands.

The semver string is likely to be converted to variables using regexps.
I don't know how we can implement comparison between words, for example to determine if
`1.0.0-alpha` is more recent than `1.0.0-beta`.

**Update :** current implementation supports comparisons. As mentionned, pre-release 
comparisons is unsupported.

---
How the semver string is stored inside a Quark remains open. It will likely
be inspired by current semver implementation inside other projects.

A `VersionConstraint` class might be needed to perform dependecies checks.
