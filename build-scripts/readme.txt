#####################################################################
# Copyright (c) 2012-2015, iquesters - All Rights Reserved.
#####################################################################

This distribution zip must contain the following directories and
files:

1. db				<DIR>
2. jar				<DIR>
3. lib				<DIR>
4. src				<DIR>
5. war				<DIR>
6. LICENSE			<FILE>
7. readme.txt			<FILE>


1. db				<DIR>
The db directory will either contain "<filename>.sql" file(s) if any
database patch needs to be applied for this particular release ver.
Otherwise it will contain a "no-db-changes.txt" file.


2. jar				<DIR>
The jar directory will contain the following jar files:
	a. core-<version>.jar
	b. core-<version>-conf.jar
The core-<version>.jar needs to be used in classpath of projects
developed using the iquesters core framework.


3. lib				<DIR>
The lib directory will contain the supporting libraries required by
the core-<version>.jar to function properly. These jars needs to be
included in the classpath of artifacts developed using the iquesters
core framework.


4. src				<DIR>
The src directory will contain a core-<version>_src.zip.
This zip contains the source code for the iquesters core framework.


5. war				<DIR>
The war directory will contain a core-<version>.war file.
This war file should be used to build your projects war file.
The build scripts of your project should unpack this war file and
and put in the required artifacts (class, jar, jsp, html, css, etc.)
and repack the contents to create a war file.


6. LICENSE			<FILE>
The LICENSE file will contain license related information


7. readme.txt			<FILE>
The readme.txt file is the file you are reading now.