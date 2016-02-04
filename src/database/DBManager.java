package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 * This class is responsible for connecting and retrieving needed data from the database.
*/
public class DBManager implements IDatabase {
	
	private Connection con;
	
	public DBManager() {
		connect();
	}
	/**
     * executes a SQL query to the database
     * @param SQL query string
     * @return ResultSet from database
    */
	public ResultSet exec(String query) {

        Statement st = null;
        ResultSet rs = null;
		
        try {
            st = con.createStatement();
            rs = st.executeQuery(query);
            
            return rs;
            
        } catch (SQLException ex) {
            //Logger lgr = Logger.getLogger(ConnectionManager.class.getName());
            //lgr.log(Level.SEVERE, ex.getMessage(), ex);
        	return null;
        }
	}
	/**
     * connects to the database 
    */
    public void connect() {

        String url = "jdbc:mysql://localhost:3306/test";
        String user = "root";
        String password = "";

        try {
            con = DriverManager.getConnection(url, user, password);

        } catch (SQLException ex) {
            Logger lgr = Logger.getLogger(DBManager.class.getName());
            lgr.log(Level.SEVERE, ex.getMessage(), ex);

        }
//        finally {
//            try {
//
//                if (con != null) {
//                    con.close();
//                }
//
//            } catch (SQLException ex) {
//                Logger lgr = Logger.getLogger(DBManager.class.getName());
//                lgr.log(Level.WARNING, ex.getMessage(), ex);
//            }
//        }
    }
    /**
     * get a specific tag by it's ID 
     * @param ID of needed tag
     * @return Tag object representing retreived tag
    */
    public Tag getTagById(int id) { 
		try {
	        Statement st = con.createStatement();
	        ResultSet rs = st.executeQuery("SELECT * FROM tags WHERE tag_id =" + id);
			
	        if (rs.next()) {
	            String tagName = rs.getString(2);
	            
	            Tag result = new Tag(id, tagName);
	            return result;
	        }
		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
			return null;
		}
		return null;
    }
    /**
     * get all activites stored in the database
     * @return list of activities 
    */
	public List<IActivity> getAllActivities() {
		List<IActivity> result = new ArrayList<IActivity>();
		try {
	        Statement st = con.createStatement();
	        ResultSet rs = st.executeQuery("SELECT * FROM activities");
			
	        while (rs.next()) {
	        	int id = rs.getInt(1);
	            String aName = rs.getString(2);
	            String aContent = rs.getString(3);
	        
	            List<ITag> tags = getTagsByActivityId(id);
	            Activity a = new Activity(id, aName, aContent, tags);
	            result.add(a);
	        }
		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
			return null;
		}
		return result;		
	}
    /**
     * get all tags stored in the database
     * @return list of tags 
    */
	public List<ITag> getAllTags() {
		List<ITag> result = new ArrayList<ITag>();
		try {
	        Statement st = con.createStatement();
	        ResultSet rs = st.executeQuery("SELECT * FROM tags");
			
	        while (rs.next()) {
	        	int id = rs.getInt(1);
	            String tagName = rs.getString(2);
	            
	            Tag t = new Tag(id, tagName);
	            result.add(t);
	        }
		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
			return null;
		}
		return result;
	}
    /**
     * save ready schedule to the database
     * @param entity representing schedule 
    */
	public void saveSchedule(ASchedule schedule) {
		try {
			Statement st = con.createStatement();
			String username = schedule.getUsername(); 
			if (username == null) {
				username = "domyslnyuser";
			}
	        int r = st.executeUpdate("insert into `schedules`(schedule_id, username) VALUES (NULL, '" + username + "')", Statement.RETURN_GENERATED_KEYS);
	        ResultSet keys = st.getGeneratedKeys();
	        keys.next();
	        int id = keys.getInt(1);
			Iterator<IActivity> it = schedule.getActivityList().iterator();
	        while (it.hasNext()) {
	        	IActivity a = it.next();
				Statement st2 = con.createStatement();
		        int r2 = st2.executeUpdate("insert into schedule_activity values(" + id + ", " + a.getId() + ")");
	        }
		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
		}
	}
    /**
     * get schedule of user by his/her username
     * @return specific schedule 
    */
	public ASchedule getSchedule(String username) {
		return null;
	}
    /**
     * get tags associated with specific activity
     * @param id of activity
     * @return list of tags 
    */
	public List<ITag> getTagsByActivityId(int id) {
        
		try {
			Statement st2 = con.createStatement();
	        ResultSet rs2 = st2.executeQuery("SELECT * FROM activity_tag, tags WHERE activity_id=" + id + " and tags.tag_id = activity_tag.tag_id");
			
	        List<ITag> tags = new ArrayList<ITag>();
	        while (rs2.next()) {
	        	int tagId = rs2.getInt(1);
	            String tagName = rs2.getString(4);
	            
	            tags.add(new Tag(tagId, tagName));
	        }
	        return tags;
		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
			return null;
		}
	}
}