package database;

import java.util.List;

public interface IActivity {
	List<ITag> getTagList();
	String getName();
	String getContent();
	int getId();
}
