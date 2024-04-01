#!/bin/bash

# This shell script is used to build the classes and
# Javadocs for the PDS Utilties software.

CLASSPATH=.
javac org/roverguild/pdsutil/*.java
javadoc -d doc/ -author -version org.roverguild.pdsutil
 
