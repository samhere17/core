#####################################################################
# Copyright (c) 2012-2015, iquesters - All Rights Reserved.
#####################################################################

#--------------------------------------------------------------------
# SQL DIRECTORY CONTENTS
#--------------------------------------------------------------------
This sql directory must contain a set of directories named
"<version-number>" and each directory will contain "<filename>.sql"
file(s) if any database change needs to be applied for that
particular release version.

#--------------------------------------------------------------------
# SETTING UP DATABASE
#--------------------------------------------------------------------
1. SQL files needs to run in an ascending order of version.
2. The DDLs should be run before the DMLs.
3. There might be a need to follow some specific instructions in case
of some sql files. In such a case such instructions will be provided
in the sql files itself.