This sample project demonstrates some of the features of the OT/Equinox project.

[![Build Status](https://secure.travis-ci.org/BluWings/otequinox-sample.png)](http://travis-ci.org/BluWings/otequinox-sample)

## About

This sample project utilizes [Eclipse Object Teams](http://www.eclipse.org/objectteams) to
add some extra features to your Eclipse installation. OT/Equinox will be used to pimp the
existing MANIFEST.MF editor - which is part of the Eclipse PDE - in a pragmatic and easy
manner.

* Does it distract you to have preset the version / build qualifier of added Plug-In
dependencies automatically by Eclipse?
* Do you remove the version / build qualifier again and again to gain more flexibility
while programming?

The sample project adds a Button labeled "Remove versions" to the Dependencies Page of
the MANIFEST.MF editor. It implements several [Teams](http://www.objectteams.org/def/1.3/s1.html)
and [Roles](http://www.objectteams.org/def/1.3/s1.html) to achieve its purpose. When
clicking the "Remove versions" button the version / build qualifier of all added
depended plug-ins will be removed.

## LICENSE

[Eclipse Public License - v 1.0](http://www.eclipse.org/legal/epl-v10.html)

## INSTALLATION

### Requirements

* Eclipse Juno >= 4.2
* ObjectTeam / Development Tools >= 2.1.1
* ObjectTeam / Equinox >= 2.1.0

### Building

This sample project utilizes Maven Tycho.

    mvn package

When running from the project root directory four Maven sub modules will be build and the
result will be found in directory `net.bluwings.eclipse.pde.ui.repository/target`. The
built ZIP archive in there contains a valid Eclipse p2 Repository that can be used to
install software.

### Running

#### Development Environment

From within your Eclipse Development Environment you simply start the included launch
configuration `OT-Equinox Sample.launch`. Of course you have to clone the Git repository
and import the provided Eclipse plug-in projects in preparation.

#### Runtime Environment

From within your Eclipse Runtime Environment you have to install the built software. To
do so add a new Software Site (`Help` -> `Install New Software...` -> `Add...`) and choose
the built p2 Repository archive (see section `Building`). After installing the software
you have to restart Eclipse.

