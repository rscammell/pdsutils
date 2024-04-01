#!/bin/bash
#
# Get information about a PDS file using the PDSInfo class.
# java must be in your classpath for this command to execute successfully.
#
CLASSPATH=.
java org/roverguild/pdsutil/PDSInfo $1
