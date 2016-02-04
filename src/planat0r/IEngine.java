package planat0r;

import java.util.List;

import database.ASchedule;
import database.IActivity;
import database.ITag;

public interface IEngine {
	public List<Question> getQuestions();
	public List<ITag> submitAnswers(List<Question> questions);
	public void submitTags(List<ITag> tags);
	public List<IActivity> generateActivities();
	public ASchedule submitActivties(List <IActivity> activities);
	public ASchedule getSchedule(String username);
	public void setUserName(String userName);
}
