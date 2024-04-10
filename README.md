# pdsutils
 PDS Utilities is a Java application that's intended to make handling and parsing [Planetary Data System](https://pds.nasa.gov/) data files generated by the [2003-2004 Mars Exploration Rovers Mission](https://mars.nasa.gov/mer/) an easier task.

It was originally released on August 15, 2004, and has been untouched and unmaintained since then. It is presented here for historical purposes, and released under its original BSD license, with the [3-clause BSD license](https://opensource.org/license/bsd-3-clause) addition.

This software is neither endorsed nor supported by NASA, JPL, its research affiliates, or the United States Government. 

The original PDS Utilities site is no longer online, but is available in the [Wayback Machine](https://web.archive.org/web/20160511092408/http://hobbiton.thisside.net/pdsutils/) , and provides usage guidance and example input / output from the software. The as-released README file is also included in this repository.

Using pdsutils is simple. In addition to an API, command line scripts are provided.

To use the command line utility under UNIX-type systems, run getinfo.sh where $pdsfilename is substituted for the name of the PDS file:
```
./getinfo.sh $pdsfilename
```
To use the command line utility under DOS-type systems, run getinfo.bat, where %pdsfile% is the name of the PDS file to analyze:
```
getinfo %pdsfilename%
```

NOTE: For both DOS and UNIX-type systems, you must have the path to the java executable in your PATH variable.

Example script output:

```
PDS Label Information for file 1P136346286ETH1600P2550L7M1.IMG
--------------------------------------------------------------
 
Translated information
----------------------
 
Spacecraft: Spirit (MER-A)
Instrument: Pancam
Start Spacecraft Clock: 136346286
Product Type: Thumbnail EDR
Site: 16
Site Position: 00
Sequence Type: PMA & Remote Sensing instruments
Sequence operation: Pancam sequence
Camera eye: Left
Filter (wavelength/bandpass) nm @ -10C: L7 (432/32-short pass)
Creator: MIPL (OPGS) at JPL
Version: 1
Product type: PDS labeled camera image EDR/RDR
 
Raw PDS Label information
-------------------------
 
Spacecraft: 1
Instrument: P
Start Spacecraft Clock: 136346286
Product Type: ETH
Site: 16
Site Position: 00
Sequence Type: P
Sequence operation: 2550
Camera eye: L
Filter (wavelength/bandpass) nm @ -10C: 7
Creator: M
Version: 1
Product type: IMG
```
