package database;

import java.util.List;

public abstract class ASchedule {
	private List<IActivity> activities;
	private String userName;
	
	public abstract List<IActivity> getActivityList();
	public void setActivityList(List<IActivity> activitiess){
		activities = activitiess;
	}
	public String getUsername() {
		return null;
	}
	public void setUserName(String username){
		userName = username;
	}
}
