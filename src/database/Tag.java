package database;
/**
 * this entity represents a tag, which is likely to be associated with an activity
 * */
public class Tag implements ITag {

	int id;
	String name;
	
	Tag(int tagId, String tagName) {
		id = tagId;
		name = tagName;
	}
	/**
	 * @return id of specific tag
	*/
	@Override
	public int getId() {
		return id;
	}
	/**
	 * @return name of specific tag
	*/
	@Override
	public String getName() {
		return name;
	}
}
