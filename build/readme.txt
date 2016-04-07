#####################################################################
# Copyright (c) 2012-2016, iquesters - All Rights Reserved.
#####################################################################

#--------------------------------------------------------------------
# DISTRIBUTION ZIP CONTENTS
#--------------------------------------------------------------------
This distribution zip must contain the following directories and
files:

1. conf				<DIR>
2. jar				<DIR>
3. lib				<DIR>
4. setup			<DIR>
5. sql				<DIR>
6. src				<DIR>
7. war				<DIR>
8. LICENSE			<FILE>
9. readme.txt			<FILE>


1. conf				<DIR>
The conf directory will contain "<filename>.properties" file(s) in a
particular directory structure. These are configuration files which
are needed by the core to function properly. Detailed description of
each config file is provided in the conf file itself.


2. jar				<DIR>
The jar directory will contain the following jar file(s):
	a. core-<version>.jar
The core-<version>.jar needs to be used in classpath of projects
developed using the iquesters core framework.


3. lib				<DIR>
The lib directory will contain the supporting libraries required by
the core-<version>.jar to function properly. These jars needs to be
included in the classpath of artifacts developed using the iquesters
core framework.


4. setup			<DIR>
The setup directory will contain the following file(s):
	a. setup.xml			<FILE>
	b. setup.properties		<FILE>
	c. files				<DIR>
The setup files will help setting up projects that will be developed
using the iquesters core framework. Details of how to use the setup
files is mentioned below in the SETTING UP APPLICATION section.
 

5. sql				<DIR>
The sql directory will contain a set of directories named
"<version-number>" and each directory will contain "<filename>.sql"
file(s) if any database change needs to be applied for that
particular release version. There will also be a readme.txt with
usage instructions.


6. src				<DIR>
The src directory will contain a core-<version>_src.zip.
This zip contains the source code for the iquesters core framework.


7. war				<DIR>
The war directory will contain core-<version>.war file that will be
used to build the projects that will be developed using the iquesters
core framework.

8. LICENSE			<FILE>
The LICENSE file will contain license related information


9. readme.txt			<FILE>
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
   
4. Open setup.properties file and specify the directory location of
   the extracted core zip against the property "release.pkg.root".
   For example,
      If the distribution zip is extracted at D:/iquesters/core
      Then the release.pkg.root=D:/iquesters/core
   NOTE: D:/iquesters/core should contain all directories and files
         mentioned in DISTRIBUTION ZIP CONTENTS section

5. Run the setup.xml (ant script).
   This will create the required folder structure and copy other
   dependency files in your project. 