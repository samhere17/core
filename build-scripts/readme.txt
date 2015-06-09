#####################################################################
# Copyright (c) 2012-2015, iquesters - All Rights Reserved.
#####################################################################

#--------------------------------------------------------------------
# DISTRIBUTION ZIP CONTENTS
#--------------------------------------------------------------------
This distribution zip must contain the following directories and
files:

1. conf				<DIR>
2. db				<DIR>
3. jar				<DIR>
4. lib				<DIR>
5. setup			<DIR>
6. src				<DIR>
7. LICENSE			<FILE>
8. readme.txt			<FILE>


1. conf				<DIR>
The conf directory will contain "<filename>.conf" file(s) in a
particular directory structure. These are configuration files which
are needed by the core to function properly. Detailed description of
each conf file is provided in the conf file itself.


2. db				<DIR>
The db directory will either contain "<filename>.sql" file(s) if any
database patch needs to be applied for this particular release ver.
Otherwise it will contain a "no-db-changes.txt" file.


3. jar				<DIR>
The jar directory will contain the following jar file(s):
	a. core-<version>.jar
The core-<version>.jar needs to be used in classpath of projects
developed using the iquesters core framework.


4. lib				<DIR>
The lib directory will contain the supporting libraries required by
the core-<version>.jar to function properly. These jars needs to be
included in the classpath of artifacts developed using the iquesters
core framework.


5. setup			<DIR>
The setup directory will contain the following file(s):
	a. setup.xml
	b. setup.properties
The setup files will help setting up projects that will be developed
using the iquesters core framework. Details of how to use the setup
files is mentioned below in the SETTING UP APPLICATION section.
 

6. src				<DIR>
The src directory will contain a core-<version>_src.zip.
This zip contains the source code for the iquesters core framework.


7. LICENSE			<FILE>
The LICENSE file will contain license related information


8. readme.txt			<FILE>
The readme.txt file is the file you are reading now.


#--------------------------------------------------------------------
# SETTING UP APPLICATION
#--------------------------------------------------------------------
To build an application based on the iquesters core framework, the
following steps should be followed to setup the project:

1. Create a java project using any IDE.

2. Create a folder named "setup" in your project.

3. Copy setup.xml and setup.properties files from the core release
   package to the setup folder in your project.
   
4. Open setup.peoperties file and specify the directory location of
   the extracted core zip against the property "release.pkg.root".
   For example,
      If the distribution zip is extracted at D:/iquesters/core
      Then the release.pkg.root=D:/iquesters/core
   NOTE: D:/iquesters/core should contain all directories and files
         mentioned in DISTRIBUTION ZIP CONTENTS section

5. Run the setup.xml (ant script).
   This will create the required folder structure and copy other
   dependency files in your project.