/**
 * 
 */
package com.amc.film;

/**
 * @author Amitava Chakraborty
 * Here is your key: 40c1f6e7
 * Please append it to all of your API requests,
 * OMDb API: http://www.omdbapi.com/?i=tt3896198&apikey=40c1f6e7
 *
 */
public class Configuration {

	public static final String APIKEY="40c1f6e7";
	public static String []filmNames={
			"BERLIN+JERUSALEM",
			"Castaway",
			"COLD+MOUNTAIN",
			"DON'T+LET+ME+DIE+ON+A+SUNDAY",
			"EL+CID",
			"EQUINOX",
			"GENERATION",
			"HOLLOW+REED",
			"LITTLE+BIG+MAN",
			"LOOKING+FOR+RICHARD",
			"MAN+OF+MARBLE",
			"MIDNIGHTEXPRESS",
			"Ms.+45+(ANGEL+OF+VENGEANCE)",
			"Octopussy",
			"PYGMALION",
			"RAW+DEAL",
			"RUNAWAY+TRAIN",
			"SANTA+SANGRE",
			"SORRY,+WRONG+NUMBER",
			"THE+ADJUSTER",
			"The+Adventures+Of+SherlockHolmes",
			"THE+AMERICANIZATION+OF+EMILY",
			"The+Casebook+Of+Sherlock+Holmes",
			"THE+COMMITMENTS",
			"The+Eligible+Bachelor",
			"THE+ENGLISH+PATIENT",
			"THE+LADYKILLERS",
			"The+Last+Vampyre",
			"THE+MANIN+THE+WHITE+SUIT",
			"The+Master+Blackmailer",
			"The+Memoirs+Of+Sherlock+Holmes",
			"THE+MIRACLE+WORKER",
			"THE+PICTURE+OF+DORIAN+GREY",
			"THE+PRIVATE+LIFE+OF+HENRY+VIII",
			"The+Return+Of+SherlockHolmes",
			"The+Sign+Of+Four",
			"THE+SWEET+SMELL+OF+SUCCESS",
			"THE+TALENTED+Mr.+RIPLEY",
			"THE+TRACKER",
			"The+X+Files+Movie",
			"THEY+DRIVE+BY+NIGHT",
			"WHISKY+GALORE+!+(TIGHT+LITTLE+ISLAND)",
			"YANA'S+FRIENDS",
			"YOLNGU+BOY"};
	
	public static String buildURI(String params) {
		return "http://www.omdbapi.com/?"+params+"&apikey="+APIKEY;
	}

}
