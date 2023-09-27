/**
 * A demo of the capabilities of the java.util.regex package 
 */
package com.amc.demo.regex;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FilenameFilter;
import java.util.Scanner;
import java.util.Stack;
import java.util.regex.Pattern;

import org.apache.log4j.Logger;

/**
 * This class may be used to search a series of 
 * regular expressions from a series of files. The files are 
 * searched in threads. The number of threads to be used is 
 * determined dynamically on the basis of the number of files 
 * and the number of search patterns.
 * 
 * @author 109365:Amitava Chakraborty:Architect - iTCG
 *
 */
public class RegexDemo implements Runnable{

	private static final Logger logger = Logger.getLogger(RegexDemo.class);
	private String []regexps=null;
	private File []files=null;
	private Pattern []patterns=null;
	private boolean []status=null;
	private Stack stack=new Stack();
	/**
	 * Default Constructor. 
	 */
	public RegexDemo()
	{
		super();
	}
	
	/**
	 * Constructs a full object using a full array of the search patterns and 
	 * the files to be searched.
	 * @param regexps  	An array of 'Search Patterns' to be search within the files.
	 * @param files		An array of files to be searched
	 */
	public RegexDemo(String []regexps, File []files)
	{
		super();
		this.regexps=regexps;
		this.files=files;
	}
	
	/**
	 * This method performs the search on a fully constructed object. 
	 */
	public String searchPatterns()
	{
		StringBuffer resultBuffer = new StringBuffer();
		patterns=new Pattern[regexps.length];
		for (int i = 0; i < patterns.length; i++) {
			patterns[i]=Pattern.compile(regexps[i]);
		}
		
		Thread []threads = new Thread[calculateNoOfThreads()];
		for (int i = 0; i < threads.length; i++) {
			threads[i]=new Thread(this);
			threads[i].start();
		}
		return resultBuffer.toString();
	}
	
	/**
	 * Calculates optimum no of threads to be used.
	 * Algorithm : 'the number of files' for the time being
	 * @return No of threads needed.
	 */
	private int calculateNoOfThreads()
	{
		for (int i = 0; i < files.length; i++) {
			stack.push(files[i]);
		}
		return(files.length);
	}
	/**
	 * This method searches all the search patterns supplied in an array in an  
	 * array of files.
	 * @param regexps  	An array of 'Search Patterns' to be search within the files.
	 * @param files		An array of files to be searched
	 * @return 			Search result in String
	 */
	public String searchPatterns(String []regexps, File []files)
	{
		this.regexps=regexps;
		this.files=files;
		return searchPatterns();
	}

	
	public static void main(String[] args) {
		String []patterns = {"public"};
		File file = new File("D:\\Programs\\Java\\JExplorer_bak");
		File []filenames = file.listFiles(
			new FilenameFilter(){
			
				public boolean accept(File arg0, String arg1) {
					// TODO Auto-generated method stub
					return false;
				}
			
			});
		RegexDemo demo = new RegexDemo(patterns,filenames);
		demo.searchPatterns();
	}

	public File[] getFiles() {
		return files;
	}

	public void setFiles(File[] files) {
		this.files = files;
	}

	public String[] getRegexps() {
		return regexps;
	}

	public void setRegexps(String[] regexps) {
		this.regexps = regexps;
	}
	
	private File getNextFile()
	{
		return (File)stack.pop();
	}
	public void run()
	{
		try {
			Scanner scanner = new Scanner(getNextFile());
			while (scanner.hasNext(patterns[0])) {
				System.out.println(scanner.next());
			};
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
