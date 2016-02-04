package database;

import java.util.List;

public interface IDatabase {
	Tag getTagById(int id);
	List<IActivity> getAllActivities();
	List<ITag> getAllTags();
	ASchedule getSchedule(String username);
	void saveSchedule(ASchedule schedule);
}
