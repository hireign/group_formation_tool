package util;

public interface Constants {
	
	public static final String selectCourses = "SELECT * from Course";
	public static final String selectUsers = "SELECT * from User, UserContactInfo where User.id = UserContactInfo.userID;";
	
	public static final String BANNERID = "bannerID";
	public static final String EMAILID = "email";
	public static final String ID = "userID";
	public static final String FIRSTNAME = "firstName";
	public static final String LASTNAME = "lastName";
	public static final String PASSWORD = "password";
	
	
	public static final int STUDENT_ROLE = 3;
	public static final int INSTRUCTOR_ROLE = 4;
	public static final int TA_ROLE = 5;
	
	public static final String COURSEID = "id";
	public static final String COURSENAME = "title";

	public static final String courseID = "courseID";
	public static final String roleID = "roleID";
	public static final String userID = "userID";

	public static final String ROLEID = "id";
	public static final String ROLEENAME = "role";
	
	public static final String DatabaseURL = "jdbc:mysql://db-5308.cs.dal.ca:3306/CSCI5308_23_PRODUCTION?autoreconnect=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
	
	public static final String DatabaseUserName = "CSCI5308_23_PRODUCTION_USER";
	
	public static final String DatabasePassword = "CSCI5308_23_PRODUCTION_23981";
	
//	public static final String DatabaseURL = "jdbc:mysql://localhost:3306/local_program";
//	public static final String DatabaseUserName = "root";
//	public static final String DatabasePassword = "root";
}
