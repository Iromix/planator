package planat0r;

import java.util.List;

import database.ITag;

public interface IQuestion {
	//GUI interface
	public void leftPushed();
	public void rightPushed();
	public String getLeftText();
	public String getRightText();
	//Questioner interface
	public List<ITag> getPushedTags();
}
