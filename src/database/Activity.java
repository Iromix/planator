package database;

import java.util.List;
/**
 * this entity represents an activity which can be a part of user's schedule
*/
public class Activity implements IActivity {

	private int id; 
	private String name;
	private String content;
	private List<ITag> tagList;
	
	Activity(int actId, String actName, String actContent, List<ITag> actTagList) {
		id = actId;
		name = actName;
		content = actContent;
		tagList = actTagList;
	}
	/**
	 * @return id of specific activity
	*/
	public int getId() {
		return id;
	}
	/**
	 * @return a list of tags connected with specific activity
	*/
	@Override
	public List<ITag> getTagList() {
		return tagList;
	}
	/**
	 * @return name of specific activity
	*/
	@Override
	public String getName() {
		return name;
	}
	/**
	 * @return content of specific activity
	*/
	@Override
	public String getContent() {
		return content;
	}

}