/**
 * 
 */
package com.amc.sort;

/**
 * @author AMITAVA
 *
 */
public class Incident implements Comparable<Incident> {

	private String date;
	private String time;
	private String incidentNo;
	private String callerName;
	private String branch;
	private String status; 
	
	
	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public String getIncidentNo() {
		return incidentNo;
	}

	public void setIncidentNo(String incidentNo) {
		this.incidentNo = incidentNo;
	}

	public String getCallerName() {
		return callerName;
	}

	public void setCallerName(String callerName) {
		this.callerName = callerName;
	}

	public String getBranch() {
		return branch;
	}

	public void setBranch(String branch) {
		this.branch = branch;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public int compareTo(Incident o) {
		// TODO Auto-generated method stub
		return 0;
	}

	public static int compare(Incident incident, Incident incident2, int sortField) {
		// TODO Auto-generated method stub
		return 0;
	}


}
