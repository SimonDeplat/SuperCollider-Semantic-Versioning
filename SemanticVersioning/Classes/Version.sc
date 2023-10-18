Version : Object {

	var majorVersion = 0;
	var minorVersion = 1;
	var patchVersion = 0;
	var preReleaseVersion = nil;
	var buildVersion = nil;

	*new { |semverString = "0.1.0"|
		^super.new.init(semverString);
	}

	init { |semverString|
		// Convert the given string into an event
		var semverAsEvent
		= Version.prSemverStringToEvent(semverString);
		// Assign version specifications
		// to the instance
		majorVersion = semverAsEvent[\major];
		minorVersion = semverAsEvent[\minor];
		patchVersion = semverAsEvent[\patch];
		preReleaseVersion = semverAsEvent[\preRelease];
		buildVersion = semverAsEvent[\build];
	}

	// Converts a semver string
	// into an event for further manipulations
	// Expects a correct semver string
	*prSemverStringToEvent { |semverString|
		// This is an event and not a list because
		// 4th element could be either
		// a pre-release or a build information
		var semverAsEvent = (
			major: nil,
			minor: nil,
			patch: nil,
			preRelease: nil,
			build: nil
		);
		var semver = semverString;
		var split;

		// Checking if semver string
		// contains build information
		if("[[.+.]]".matchRegexp(semver)) {
			var split = semver.split($+);
			semverAsEvent[\build] = split[1];
			semver = split[0];
		};

		// Checking if semver string
		// contains pre-release information
		// This needs a particular algorithm
		// because several hyphens are tolerated,
		// with only the first one delimiting
		// version numbers from pre-release
		// identifier
		if("[[.-.]]".matchRegexp(semver)) {
			var position = 0;
			var delimiterReached = false;
			var semverString = "";
			var releaseString = "";
			while { position < semver.size } {
				if(delimiterReached.not) {
					if(semver[position] != $-) {
						semverString =
						semverString ++ semver[position];
					} {
						delimiterReached = true;
					};
				} {
					releaseString =
					releaseString ++ semver[position];
				};
				position = position + 1;
			};
			semverAsEvent[\preRelease] = releaseString;
			semver = semverString;
		};

		// Separating Major / Minor / Patch
		split = semver.split($.);
		semverAsEvent[\major] = split[0];
		semverAsEvent[\minor] = split[1];
		semverAsEvent[\patch] = split[2];

		// Return the event
		^semverAsEvent
	}

	// Version specification getters
	major {
		^majorVersion
	}

	minor {
		^minorVersion
	}

	patch {
		^patchVersion
	}

	preRelease {
		^preReleaseVersion
	}

	build {
		^buildVersion
	}

	// Semver String getter
	string {
		var string = "";
		string = string ++ majorVersion.asString;
		string = string ++ ".";
		string = string ++ minorVersion.asString;
		string = string ++ ".";
		string = string ++ patchVersion.asString;
		// Append pre-release if needed
		if(preReleaseVersion.notNil) {
			string = string ++ "-";
			string = string ++ preReleaseVersion.asString;
		};
		// Append build if needed
		if(buildVersion.notNil) {
			string = string ++ "+";
			string = string ++ buildVersion.asString;
		};
		// Return
		^string
	}

}
