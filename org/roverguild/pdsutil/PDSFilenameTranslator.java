package org.roverguild.pdsutil;

import java.util.Hashtable;
import java.io.File;

/**
 * The PDSFilenameTranslator class provides a set of utility
 * methods, which permit metadata contained within the NASA PDS
 * filename format to be extracted, and translated into useful, human readable
 * strings, per the guide located on page 13 of the document at:
 * <a href="http://pds-imaging.jpl.nasa.gov/Atlas/MER/documents/pancam_ug.pdf">
 * http://pds-imaging.jpl.nasa.gov/Atlas/MER/documents/pancam_ug.pdf</a>
 * <br><br>
 * Usage example:<br><br>
 * <code>
 * PDSFilenameTranslator example = new PDSFilenameTranslator("2F127262938EFF0218P1003R0M1");<br>
 * // Get the Spacecraft Identifier field name and translated value<br>
 * String scidFieldName = example.getSCIDName();<br>
 * String scidValue = example.getSCIDTranslation();<br>
 * // Print out the information<br>
 * System.out.println(scidFieldName + ": " + scidValue);<br>
 * </code>
 * @author <a href="mailto:rupe@sbcglobal.net">Rupert Scammell</a><br>
 * Project site: <a href="http://hobbiton.thisside.net/pdsutil">PDS Utilities Project Site</a>
 * @version 0.1 / 2004-08-15
 */

public class PDSFilenameTranslator {
	
	/**
	 * String containing PDS filename
	 */
	private String pdsFilename = new String();

	/**
	 * Set up Hashtable object which will contain 
	 * human readable versions of
	 * PDS data. 
	 */
	private Hashtable PDSData = new Hashtable();

	/**
	 * Constructor specifying PDS filename.
	 * @param pdsFN PDS filename string.
	 */
	public PDSFilenameTranslator(String pdsFN) {
		File pdsFile = new File(pdsFN);
		translate(pdsFile.getName());
	}

	/**
	 * Populate the PDSData hashtable with human
	 * readable strings derived from the provided PDS filename
	 * string.
	 * @param filenameString PDS filename to translate.
	 */
	public void translate(String filenameString) {

		// First, break the PDS filename into usable strings.
		
		/**
		 * MER Rover Spacecraft Identifier
		 */
		String scid = filenameString.substring(0,1);
		
		/**
		 * MER science instrument identifier
		 */
		String inst = filenameString.substring(1,2);

		/**
		 * Starting Spacecraft Clock time
		 */
		String sclk = filenameString.substring(2,11);

		/**
		 * Product type identifier of input data
		 */
		String prod = filenameString.substring(11,14);

		/**
		 * Site location count
		 */
		String site = filenameString.substring(14,16);

		/**
		 * Position-within-Site count
		 */
		String pos = filenameString.substring(16,18);

		/**
		 * Sequence identifier
		 */
		String seq = filenameString.substring(18,23);

		/**
		 * Camera eye
		 */
		String eye = filenameString.substring(23,24);

		/**
		 * Spectral filter position
		 */
		String filt = filenameString.substring(24,25);

		/**
		 * Product creator indicator
		 */
		String who = filenameString.substring(25,26);

		/**
		 * Version identifier providing uniqueness for book keeping.
		 */
		String ver = filenameString.substring(26,27);

		/**
		 * PDS Product type extension
		 */
		String ext = filenameString.substring(28,31);


		/**
		 * Now, populate the PDSData Hashtable with nested
		 * Hashtables with the following format:
		 * key            value
		 * -----          ------
		 *  name          Name of the metadata item
		 *  raw           Raw metadata from PDS filename
		 *  translate     Human readable version of the metadata
		 */

		/**
		 * Spacecraft Identifier
		 */
		Hashtable scidHash = new Hashtable();
		scidHash.put("name", "Spacecraft");
		scidHash.put("raw", scid);
		
		if (scid.equals("1")) {
			scidHash.put("translate", "Spirit (MER-A)");
		}

		if (scid.equals("2")) {
			scidHash.put("translate", "Opportunity (MER-B)");
		}
		// Add scid data to master Hashtable.
		PDSData.put("scid", scidHash);

		/**
		 * MER science instrument identifier
		 */
		Hashtable instHash = new Hashtable();
		instHash.put("name", "Instrument");
		instHash.put("raw", inst);

		if (inst.equals("P")) {
			instHash.put("translate", "Pancam");
		}

		if (inst.equals("N")) {
			instHash.put("translate", "Navcam");
		}

		if (inst.equals("F")) {
			instHash.put("translate", "Front Hazcam");
		}

		if (inst.equals("R")) {
			instHash.put("translate", "Rear Hazcam");
		}

		if (inst.equals("M")) {
			instHash.put("translate", "Microscopic Imager");
		}

		if (inst.equals("E")) {
			instHash.put("translate", "EDLCam (Descent Imager)");
		}
		// Add inst data to master Hashtable
		PDSData.put("inst", instHash);

		/**
		 * Starting Spacecraft Clock time
		 */
		Hashtable sclkHash = new Hashtable();
		sclkHash.put("name", "Start Spacecraft Clock");
		sclkHash.put("raw", sclk);
		// TODO: Make human readable timestamp from epoch second value
		sclkHash.put("translate", sclk);
		// Add sclk data to master Hashtable
		PDSData.put("sclk", sclkHash);

		/**
		 * Product type identifier of input data
		 */
		Hashtable prodHash = new Hashtable();
		prodHash.put("name", "Product Type");
		prodHash.put("raw", prod);

		if (prod.equals("EFF")) {
			prodHash.put("translate", "Full frame EDR");
		}

		if (prod.equals("ESF")) {
			prodHash.put("translate", "Sub-frame EDR");
		}

		if (prod.equals("EDN")) {
			prodHash.put("translate", "Downsampled EDR");
		}

		if (prod.equals("ETH")) {
			prodHash.put("translate", "Thumbnail EDR");
		}

		if (prod.equals("ERS")) {
			prodHash.put("translate", "Row Summed EDR");
		}

		if (prod.equals("ECS")) {
			prodHash.put("translate", "Column Summed EDR");
		}

		if (prod.equals("ERP")) {
			prodHash.put("translate", "Reference Pixels EDR");
		}

		if (prod.equals("EHG")) {
			prodHash.put("translate", "Histogram EDR");
		}
		// Add prod data to master Hashtable
		PDSData.put("prod", prodHash);

		/**
		 * Site location count
		 */
		Hashtable siteHash = new Hashtable();
		siteHash.put("name", "Site");
		siteHash.put("raw", site);
		siteHash.put("translate", site);
		// Add site data to master Hashtable
		PDSData.put("site", siteHash);

		/**
		 * Position-within-site count
		 */
		Hashtable posHash = new Hashtable();
		posHash.put("name", "Site Position");
		posHash.put("raw", pos);
		posHash.put("translate", pos);
		// Add post data to master Hashtable
		PDSData.put("pos", posHash);

		/**
		 * Sequence type 
		*/
		String seqType = seq.substring(0,1);
		Hashtable seqTypeHash = new Hashtable();
		seqTypeHash.put("name", "Sequence Type");
		seqTypeHash.put("raw", seqType);

		if (seqType.equals("C")) {
			seqTypeHash.put("translate", "Cruise");
		}

		if (seqType.equals("D")) {
			seqTypeHash.put("translate", "IDD & RAT");
		}

		if (seqType.equals("E")) {
			seqTypeHash.put("translate", "Engineering");
		}

		if (seqType.equals("F")) {
			seqTypeHash.put("translate", "Flight Software (Sequence rejected)");
		}

		if (seqType.equals("G")) {
			seqTypeHash.put("translate", "(spare)");
		}

		if (seqType.equals("K")) {
			seqTypeHash.put("translate", "(spare)");
		}

		if (seqType.equals("M")) {
			seqTypeHash.put("translate", "Master (Surface only)");
		}

		if (seqType.equals("N")) {
			seqTypeHash.put("translate", "In-situ instruments (APXS,MB,MI)");
		}

		if (seqType.equals("P")) {
			seqTypeHash.put("translate", "PMA & Remote Sensing instruments");
		}

		if (seqType.equals("R")) {
			seqTypeHash.put("translate", "Rover Driving");
		}
		
		if (seqType.equals("S")) {
			seqTypeHash.put("translate", "Submaster");
		}

		if (seqType.equals("T")) {
			seqTypeHash.put("translate", "Test");
		}

		if (seqType.equals("W")) {
			seqTypeHash.put("translate", "Sequence triggered by Comms. Window");
		}

		if (seqType.equals("X")) {
			seqTypeHash.put("translate", "Contingency");
		}

		if (seqType.equals("Y")) {
			seqTypeHash.put("translate", "(spare)");
		}

		if (seqType.equals("Z")) {
			seqTypeHash.put("translate", "SCM Sequence");
		}
		// Add seqType data to master Hashtable
		PDSData.put("seqType", seqTypeHash);

		/**
		 * Sequence operation (only valid for seqType P)
		 */
		String seqOp = seq.substring(1,5);
		Hashtable seqOpHash = new Hashtable();
		seqOpHash.put("name", "Sequence operation");
		seqOpHash.put("raw", seqOp);
		
		if (!seqType.equals("P")) {
			seqOpHash.put("translate", "none");
		}
		else {
			Integer value = new Integer(seqOp);
			int v = value.intValue();
			
			if (v >= 0 && v <= 499) {
				seqOpHash.put("translate", "Misc. imaging setup/parm sequence");
			}
			if (v >= 500 && v <= 999) {
				seqOpHash.put("translate", "Unallocated");
			}

			if (v >= 1000 && v <= 1499) {
				seqOpHash.put("translate", "Hazcam sequence");
			}

			if (v >= 1500 && v <= 1999) {
				seqOpHash.put("translate", "Navcam sequence");
			}

			if (v >= 2000 && v <= 2899) {
				seqOpHash.put("translate", "Pancam sequence");
			}

			if (v >= 2900 && v <= 2999) {
				seqOpHash.put("translate", "MI sequence");
			}

			if (v >= 3000 && v <= 3999) {
				seqOpHash.put("translate", "Mini-TES sequence");
			}

			if (v >= 4000 && v <= 4095) {
				seqOpHash.put("translate", "Misc PMA actuation sequence");
			}
		}
		// Add seqOp data to master Hashtable
		PDSData.put("seqOp", seqOpHash);

		/**
		 * Camera eye
		 */
		Hashtable eyeHash = new Hashtable();
		eyeHash.put("name", "Camera eye");
		eyeHash.put("raw", eye);

		if (eye.equals("L")) {
			eyeHash.put("translate", "Left");
		}

		if (eye.equals("R")) {
			eyeHash.put("translate", "Right");
		}

		if (eye.equals("M")) {
			eyeHash.put("translate", "Monoscopic");
		}

		if (eye.equals("N")) {
			eyeHash.put("translate", "N/A");
		}

		// Add eye data to master Hashtable
		PDSData.put("eye", eyeHash);

		/**
		 * Spectral filter position
		 */
		Hashtable filtHash = new Hashtable();
		filtHash.put("name", "Filter (wavelength/bandpass) nm @ -10C");
		filtHash.put("raw", filt);

		if (eye.equals("L")) {

                        if (filt.equals("0")) {
                                filtHash.put("translate", "N/A or No Filter");
                        }

			if (filt.equals("1")) {
				filtHash.put("translate", "L1 (739/338-EMPTY)");
			}

			if (filt.equals("2")) {
				filtHash.put("translate", "L2 (753/20)");
			}

			if (filt.equals("3")) {
				filtHash.put("translate", "L3 (673/16)");
			}

			if (filt.equals("4")) {
				filtHash.put("translate", "L4 (601/17)");
			}

			if (filt.equals("5")) {
				filtHash.put("translate", "L5 (535/20)");
			}

			if (filt.equals("6")) {
				filtHash.put("translate", "L6 (482/30)");
			}

			if (filt.equals("7")) {
				filtHash.put("translate", "L7 (432/32-short pass)");
			}

			if (filt.equals("8")) {
				filtHash.put("translate", "L8 (440 Solar ND5/20)");
			}
		}

		if (eye.equals("R")) {

                        if (filt.equals("0")) {
                                filtHash.put("translate", "N/A or No Filter");
                        }

			if (filt.equals("1")) {
				filtHash.put("translate", "R1 (436/37-short pass)");
			}

			if (filt.equals("2")) {
				filtHash.put("translate", "R2 (754/20)");
			}

			if (filt.equals("3")) {
				filtHash.put("translate", "R3 (803/20)");
			}

			if (filt.equals("4")) {
				filtHash.put("translate", "R4 (864/17)");
			}

			if (filt.equals("5")) {
				filtHash.put("translate", "R5 (904/26)");
			}

			if (filt.equals("6")) {
				filtHash.put("translate", "R6 (934/25)");
			}

			if (filt.equals("7")) {
				filtHash.put("translate", "R7 (1009/38-long pass)");
			}

			if (filt.equals("8")) {
				filtHash.put("translate", "R8 (880 Solar ND5/20)");
			}
		}

		if (eye.equals("M")) {

			if (filt.equals("1")) {
				filtHash.put("translate", "MI window closed (500-700 nm resp)");
			}

			if (filt.equals("2")) {
				filtHash.put("translate", "MI window open (400-700 nm resp)");
			}
		}
		// Add filt data to master Hashtable
		PDSData.put("filt", filtHash);

		/**
		 * Product Creator indicator
		 */
		Hashtable whoHash = new Hashtable();
		whoHash.put("name", "Creator");
		whoHash.put("raw", who);
		
		if (who.equals("C")) {
			whoHash.put("translate", "Cornell University");
		}

		if (who.equals("F")) {
			whoHash.put("translate", "USGS at Flagstaff");
		}

		if (who.equals("M")) {
			whoHash.put("translate", "MIPL (OPGS) at JPL");
		}

		if (who.equals("S")) {
			whoHash.put("translate", "SOAS at JPL");
		}

		if (who.equals("X")) {
			whoHash.put("translate", "Other");
		}

		// Add who data to master Hashtable
		PDSData.put("who", whoHash);

		/**
		 * Version identifier
		 */
		Hashtable verHash = new Hashtable();
		verHash.put("name", "Version");
		verHash.put("raw", ver);
		verHash.put("translate", ver);
		// Add ver data to master Hashtable
		PDSData.put("ver", verHash);

		/**
		 * PDS Product type extension
		 */
		Hashtable extHash = new Hashtable();
		extHash.put("name", "Product type");
		extHash.put("raw", ext);
		
		if (ext.equals("IMG")) {
			extHash.put("translate", "PDS labeled camera image EDR/RDR");
		}

		if (ext.equals("JPG")) {
			extHash.put("translate", "non-PDS labeled JPEG image");
		}
		// Add ext data to master Hashtable
		PDSData.put("ext", extHash);

	}

	/**
	 * Getter method for Spacecraft Identifier translated value (scid)
         * @return a String containing the translated value of the Spacecraft
         * identifier.
	 */
	public String getSCIDTranslation() {
		Hashtable temp = (Hashtable)PDSData.get("scid");
		return (String)temp.get("translate");
        }

        /**
         * Getter method for Spacecraft Identifier raw value (scid)
         * @return a String containing the raw value of the Spacecraft ident.
         */
         public String getSCIDRaw() {
                 Hashtable temp = (Hashtable)PDSData.get("scid");
                 return (String)temp.get("raw");
         }

         /**
          * Getter method for Spacecraft Identifier field name (scid)
          * @return a String containing the field name for the Spacecraft
          * Identifier
          */
          public String getSCIDName() {
                  Hashtable temp = (Hashtable)PDSData.get("scid");
                  return (String)temp.get("name");
          }


	/**
	 * Getter method for MER science instrument ident translated value (inst)
         * @return a String containing the translated value of the MER science
         * instrument identifier 
	 */
	public String getINSTTranslation() {
		Hashtable temp = (Hashtable)PDSData.get("inst");
		return (String)temp.get("translate");
        }

        /**
         * Getter method for MER Science Instrument Identifier raw value (inst)
         * @return a String containing the raw value of the MER science 
         * instrument identifier
         */
         public String getINSTRaw() {
                 Hashtable temp = (Hashtable)PDSData.get("inst");
                 return (String)temp.get("raw");
         }

         /**
          * Getter method for MER science instrument Identifier field name (inst)
          * @return a String containing the field name for the MER science
          * instrument identifier 
          */
          public String getINSTName() {
                  Hashtable temp = (Hashtable)PDSData.get("inst");
                  return (String)temp.get("name");
          }


	/**
	 * Getter method for Starting Spacecraft Clock Time translated value (sclk)
         * @return a String containing the translated value of the Starting 
         * Spacecraft Clock Time 
	 */
	public String getSCLKTranslation() {
		Hashtable temp = (Hashtable)PDSData.get("sclk");
		return (String)temp.get("translate");
        }

        /**
         * Getter method for Starting Spacecraft Clock Time raw value (sclk)
         * @return a String containing the raw value of the Starting 
         * Spacecraft Clock Time 
         */
         public String getSCLKRaw() {
                 Hashtable temp = (Hashtable)PDSData.get("sclk");
                 return (String)temp.get("raw");
         }

         /**
          * Getter method for Starting Spacecraft Clock Time field name (sclk)
          * @return a String containing the field name for the Starting 
          * Spacecraft Clock Time 
          */
          public String getSCLKName() {
                  Hashtable temp = (Hashtable)PDSData.get("sclk");
                  return (String)temp.get("name");
          }

	/**
	 * Getter method for Product Type identifier translated value (prod)
         * @return a String containing the translated value of the Product 
         * Type identifier 
	 */
	public String getPRODTranslation() {
		Hashtable temp = (Hashtable)PDSData.get("prod");
		return (String)temp.get("translate");
        }

        /**
         * Getter method for Product Type identifier raw value (prod)
         * @return a String containing the raw value of the Product 
         * Type identifier 
         */
         public String getPRODRaw() {
                 Hashtable temp = (Hashtable)PDSData.get("prod");
                 return (String)temp.get("raw");
         }

         /**
          * Getter method for Product Type identifier field name (prod)
          * @return a String containing the field name for the Product 
          * Type identifier 
          */
          public String getPRODName() {
                  Hashtable temp = (Hashtable)PDSData.get("prod");
                  return (String)temp.get("name");
          }


	/**
	 * Getter method for Site location count translated value (site)
         * @return a String containing the translated value of the Site 
         * location count, which indicates the rover's location.
	 */
	public String getSITETranslation() {
		Hashtable temp = (Hashtable)PDSData.get("site");
		return (String)temp.get("translate");
        }

        /**
         * Getter method for Site location count raw value (site)
         * @return a String containing the raw value of the Site 
         * location count, which indicates the rover's location. 
         */
         public String getSITERaw() {
                 Hashtable temp = (Hashtable)PDSData.get("site");
                 return (String)temp.get("raw");
         }

         /**
          * Getter method for Site location count field name (site)
          * @return a String containing the field name for the Site location 
          * count. 
          */
          public String getSITEName() {
                  Hashtable temp = (Hashtable)PDSData.get("site");
                  return (String)temp.get("name");
          }


	/**
	 * Getter method for Position-within-Site count translated value (pos)
         * @return a String containing the translated value of the  
         * Position-within-site count, which indicates the rover's position
         * within a particular site. 
	 */
	public String getPOSTranslation() {
		Hashtable temp = (Hashtable)PDSData.get("pos");
		return (String)temp.get("translate");
        }

        /**
         * Getter method for Position-within-Site count raw value (pos)
         * @return a String containing the raw value of the 
         * Position-within-Site count, which indicates the rover's position
         * within a particular site. 
         */
         public String getPOSRaw() {
                 Hashtable temp = (Hashtable)PDSData.get("pos");
                 return (String)temp.get("raw");
         }

         /**
          * Getter method for Site location count field name (site)
          * @return a String containing the field name for the 
          * Position-within-Site count. 
          */
          public String getPOSName() {
                  Hashtable temp = (Hashtable)PDSData.get("pos");
                  return (String)temp.get("name");
          }


	/**
	 * Getter method for Sequence Type translated value (seqType)
         * @return a String containing the translated value of the 
         * Sequence Type, which describes the type of command sequence
         * which was executed. 
	 */
	public String getSeqTypeTranslation() {
		Hashtable temp = (Hashtable)PDSData.get("seqType");
		return (String)temp.get("translate");
        }

        /**
         * Getter method for Sequence Type raw value (seqType)
         * @return a String containing the raw value of the  
         * Sequence Type, which indicates the type of command sequence
         * which was executed. 
         */
         public String getSeqTypeRaw() {
                 Hashtable temp = (Hashtable)PDSData.get("seqType");
                 return (String)temp.get("raw");
         }

         /**
          * Getter method for Sequence Type field name (seqType)
          * @return a String containing the field name for the 
          * Sequence Type. 
          */
          public String getSeqTypeName() {
                  Hashtable temp = (Hashtable)PDSData.get("seqType");
                  return (String)temp.get("name");
          }


	/**
	 * Getter method for Sequence Operation translated value (seqOp)
         * @return a String containing the translated value of the 
         * Sequence Operation, which describes the MER science instrument
         * used to obtain data within this PDS file. 
	 */
	public String getSeqOpTranslation() {
		Hashtable temp = (Hashtable)PDSData.get("seqOp");
		return (String)temp.get("translate");
        }

        /**
         * Getter method for Sequence Operation raw value (seqOp)
         * @return a String containing the raw value of the  
         * Sequence Operation, which describes the MER science instrument 
         * used to obtain data within this PDS file. 
         */
         public String getSeqOpRaw() {
                 Hashtable temp = (Hashtable)PDSData.get("seqOp");
                 return (String)temp.get("raw");
         }

         /**
          * Getter method for Sequence Operation field name (seqOp)
          * @return a String containing the field name for the 
          * Sequence Operation. 
          */
          public String getSeqOpName() {
                  Hashtable temp = (Hashtable)PDSData.get("seqOp");
                  return (String)temp.get("name");
          }


	/**
	 * Getter method for Camera Eye translated value (eye)
         * @return a String containing the translated value of the 
         * Camera Eye, which specifies whether the left or right
         * camera was used to obtain the data within the PDS file
         * (or whether the camera is monoscopic, like the MI) 
	 */
	public String getEYETranslation() {
		Hashtable temp = (Hashtable)PDSData.get("eye");
		return (String)temp.get("translate");
        }

        /**
         * Getter method for Camera Eye raw value (eye)
         * @return a String containing the raw value of the 
         * Camera Eye, which specifies whether the left or right
         * camera was used to obtain the data within the PDS file
         * (or whether the camera is monoscopic, like the MI) 
         */
         public String getEYERaw() {
                 Hashtable temp = (Hashtable)PDSData.get("eye");
                 return (String)temp.get("raw");
         }

         /**
          * Getter method for Camera Eye field name (eye)
          * @return a String containing the field name for the 
          * Camera Eye. 
          */
          public String getEYEName() {
                  Hashtable temp = (Hashtable)PDSData.get("eye");
                  return (String)temp.get("name");
          }


	/**
	 * Getter method for Spectral filter position translated value (filt)
         * @return a String containing the translated value of the 
         * Spectral filter position, which describes the
         * filter on the MER PanCam used to obtain the data within this
         * PDS file, if it's a PanCam image, or in cases where the file
         * contains data from the Microscopic Imager, whether the MI window
         * was open or closed.
         * In cases where the PDS data within the file is not from either
         * the PanCam or the MI, this function will return "No Filter - N/A". 
	 */
	public String getFILTTranslation() {
		Hashtable temp = (Hashtable)PDSData.get("filt");
		return (String)temp.get("translate");
        }

        /**
         * Getter method for Spectral filter position raw value (filt)
         * @return a String containing the raw value of the  
         * Spectral filter position, which describes the
         * filter on the MER PanCam used to obtain the data within this
         * PDS file, if it's a PanCam image, or in cases where the file
         * contains data from the Microscopic Imager, whether the MI window
         * was open or closed.
         * In cases where the PDS data within the file is not from either
         * the PanCam or the MI, this function will return a filter value of 0.
         */
         public String getFILTRaw() {
                 Hashtable temp = (Hashtable)PDSData.get("filt");
                 return (String)temp.get("raw");
         }

         /**
          * Getter method for Spectral filter position field name (filt)
          * @return a String containing the field name for the 
          * Spectral filter position. 
          */
          public String getFILTName() {
                  Hashtable temp = (Hashtable)PDSData.get("filt");
                  return (String)temp.get("name");
          }


	/**
	 * Getter method for Product Creator indicator (who)
         * @return a String containing the translated value of the 
         * Product Creator indicator, which describes the creator of 
         * this PDS product.
	 */
	public String getWHOTranslation() {
		Hashtable temp = (Hashtable)PDSData.get("who");
		return (String)temp.get("translate");
        }

        /**
         * Getter method for Product Creator indicator raw value (who)
         * @return a String containing the raw value of the  
         * Product Creator indicator, which describes the creator of 
         * this PDS product.
         */
         public String getWHORaw() {
                 Hashtable temp = (Hashtable)PDSData.get("who");
                 return (String)temp.get("raw");
         }

         /**
          * Getter method for Product Creator indicator field name (who) 
          * @return a String containing the field name for the 
          * Product Creator indicator. 
          */
          public String getWHOName() {
                  Hashtable temp = (Hashtable)PDSData.get("who");
                  return (String)temp.get("name");
          }

	/**
	 * Getter method for Version identifier translated value (ver)
         * @return a String containing the translated value of the 
         * Version identifier, which describes the version of this
         * PDS product.  For now, the raw and translated versions of the
         * Version identifier are the same, but this method is here
         * for the sake of completeness.
	 */
	public String getVERTranslation() {
		Hashtable temp = (Hashtable)PDSData.get("ver");
		return (String)temp.get("translate");
        }

        /**
         * Getter method for Version identifier raw value (ver)
         * @return a String containing the raw value of the  
         * Version identifier, which describes the version of this
         * PDS product.
         */
         public String getVERRaw() {
                 Hashtable temp = (Hashtable)PDSData.get("ver");
                 return (String)temp.get("raw");
         }

         /**
          * Getter method for Version identifier field name (ver)
          * @return a String containing the field name for the 
          * Version identifier. 
          */
          public String getVERName() {
                  Hashtable temp = (Hashtable)PDSData.get("ver");
                  return (String)temp.get("name");
          }

	/**
	 * Getter method for PDS product type extension (ext) 
         * @return a String containing the translated value of the 
         * PDS product type extension, describing the type of data
         * product contained within the file. 
	 */
	public String getEXTTranslation() {
		Hashtable temp = (Hashtable)PDSData.get("ext");
		return (String)temp.get("translate");
        }

        /**
         * Getter method for PDS product type raw value (ext)
         * @return a String containing the raw value of the  
         * PDS product type, describing the type of data product
         * contained within the file. 
         */
         public String getEXTRaw() {
                 Hashtable temp = (Hashtable)PDSData.get("ext");
                 return (String)temp.get("raw");
         }

         /**
          * Getter method for PDS product type field name (ext)
          * @return a String containing the field name for the 
          * PDS product type. 
          */
          public String getEXTName() {
                  Hashtable temp = (Hashtable)PDSData.get("ext");
                  return (String)temp.get("name");
          }

}

	
