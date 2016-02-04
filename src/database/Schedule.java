package database;

import java.util.List;
/**
 * this entity represents a schedule which consists of activities
*/
public class Schedule extends ASchedule{

	Schedule(String u, List<IActivity> al) {
		username = u;
		activityList = al;
	}
	public Schedule(){
		
	}

	String username;
	/**
	 * @return username of schedule's owner
	*/
	public String getUsername() {
		return username;
	}
	/**
	 * sets schedule owner
	 * @param name of current user
	*/
	public void setUsername(String username) {
		this.username = username;
	}
	
	List<IActivity> activityList;
	/**
	 * @param list of activities
	 * sets which activities will belong to the schedule
	*/
	public void setActivityList(List<IActivity> activityList) {
		this.activityList = activityList;
	}
	/**
	 * @return list of activites belonging to the schedule
	*/
	@Override
	public List<IActivity> getActivityList() {
		return activityList;
	}
	
	

}
