package controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.testng.annotations.Test;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import Ulties.TestLogger;

public class DatabaseManager {

	public static Connection con;
	public static String URL = "jdbc:sqlserver://10.17.14.206;databaseName=TravelTool_v2_Testing";
	public static String USERNAME = "traveltool";
	public static String PASSWORD = "Abc@12345";
	Statement smt;

	public static Connection taoKetNoi(String URL, String user, String password) {
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		System.out.println("Driver Loaded");
		try {
			con = DriverManager.getConnection(URL, user, password);

		} catch (SQLException e) {
			e.printStackTrace();
		}
		System.out.println("Connection created");

		return con;
	}

	public static String getLinkResetPassword(Connection con, String emailOrUserName, String linkOFWebSite_CW)
			throws SQLException {
		Statement smt = con.createStatement();
		System.out.println("Statement created");

		ResultSet rs = smt.executeQuery("SELECT * FROM CW_Yen.dbo.QueueEmail Where ToAddress='" + emailOrUserName
				+ "' and Subject='[CW] Reset Password' ORDER BY CreatedDate desc;");
		if (rs.next()) {
			System.out.println(" link of password reset found !");
		} else {
			System.out.println("No link of password reset found !");
			return "";
		}
		System.out.println("Query Executed");
		String data = rs.getString("BodyMessage");
		Document doc = Jsoup.parse(data);
		Elements links = doc.select("a[href*=" + linkOFWebSite_CW + "/Account/ResetPassword]");
		System.out.println(links.size());
		if (links.size() >= 1) {
			return links.first().attr("href");
		} else {
			return null;
		}

	}

	public static void update_UnLockUser(Connection con, String emailOrUserName)
			throws SQLException {
		Statement smt = con.createStatement();
		System.out.println("Statement created");
		smt.executeUpdate("UPDATE CW_Yen.dbo.AppUsers SET Status = 1, AccessFailedCount =0 Where Email='" + emailOrUserName + "';");
	
	}

	public static void update_LockUser(Connection con, String emailOrUserName)
			throws SQLException {
		Statement smt = con.createStatement();
		System.out.println("Statement created");
		smt.executeUpdate("UPDATE CW_Yen.dbo.AppUsers SET Status = 2 , AccessFailedCount = 5 Where Email='" + emailOrUserName + "';");
	}

	public static String getLinksetMyPassword(Connection con, String emailOrUserName, String linkOFWebSite_CW)
			throws SQLException {
		Statement smt = con.createStatement();
		System.out.println("Statement created");

		ResultSet rs = smt.executeQuery("SELECT * FROM CW_Yen.dbo.QueueEmail Where ToAddress='" + emailOrUserName
				+ "' and Subject='[CW] Create Account' ORDER BY CreatedDate desc;");
		if (rs.next()) {
			System.out.println(" link of set my password found !");
		} else {
			System.out.println("No link of my password found !");
			return "";
		}
		System.out.println("Query Executed");
		String data = rs.getString("BodyMessage");
		Document doc = Jsoup.parse(data);
		Elements links = doc.select("a[href*=" + linkOFWebSite_CW + "/Account/ResetPassword]");
		System.out.println(links.size());
		if (links.size() >= 1) {
			return links.first().attr("href");
		} else {
			return null;
		}

	}

	public static boolean checkEmailWithSubjectPasswordChangeSuccess(Connection con, String emailOrUserName)
			throws SQLException {
		Statement smt = con.createStatement();
		System.out.println("Statement created");

		ResultSet rs = smt.executeQuery("SELECT * FROM CW_Yen.dbo.QueueEmail Where ToAddress='" + emailOrUserName
				+ "' and Subject='[CW] Password Change Success' ORDER BY CreatedDate desc;");
		if (rs.next()) {
			System.out.println(" link of set my password found !");

		} else {
			System.out.println("No any links of my password found !");

		}

		System.out.println("Query Executed");
		String data = rs.getString("BodyMessage");
		Document doc = Jsoup.parse(data);
		Elements links = doc.select("title");
		System.out.println(links.size());
		TestLogger.info(links.first().text());
		if (links.size() >= 1 && (links.first().text().equals("Password Changed"))) {
			return true;
		} else {
			return false;
		}

	}

	public static boolean checkMailChangePasswordSuccess(Connection con, String emailOrUserName) throws SQLException {
		Statement smt = con.createStatement();
		System.out.println("Statement created");

		ResultSet rs = smt.executeQuery("SELECT * FROM CW_Yen.dbo.QueueEmail Where ToAddress='" + emailOrUserName
				+ "' and Subject='[CW] Password Change Success' ORDER BY CreatedDate desc;");
		if (rs.next()) {
			System.out.println(" link of password reset found !");
		} else {
			System.out.println("No link of password reset found !");
		}
		System.out.println("Query Executed");
		String data = rs.getString("BodyMessage");
		Document doc = Jsoup.parse(data);
		Elements links = doc.select("span");
		System.out.println(links.size());
		if (links.size() >= 1 && (links.first().text().equals("Ha Nguyen"))) {
			return true;
		} else {
			return false;
		}
        
	}
	
	public static String getConTentColumnContentEmailFromSendEmail(Connection con,String valueEmail) throws SQLException
	{
		Statement smt = con.createStatement();
		System.out.println("Statement created");

		ResultSet rs = smt.executeQuery("SELECT * FROM TravelTool_v2_Testing.dbo.SendEmail Where Creator='" + valueEmail
				+ "'ORDER BY CreatedDate desc;");
		if (rs.next()) {
			System.out.println(" data found !");
		} else {
			System.out.println("No data found !");
			return "";
		}
		System.out.println("Query Executed");
		String data = rs.getString("ContentEmail");
		
		return data;
	}
	
	public static String getContentColumnSubjectFromSendEmail(Connection con,String valueEmail) throws SQLException
	{
		Statement smt = con.createStatement();
		System.out.println("Statement created");

		ResultSet rs = smt.executeQuery("SELECT * FROM TravelTool_v2_Testing.dbo.SendEmail Where Creator='" + valueEmail
				+ "'ORDER BY CreatedDate desc;");
		if (rs.next()) {
			System.out.println(" data found !");
		} else {
			System.out.println("No data found !");
			return "";
		}
		System.out.println("Query Executed");
		String data = rs.getString("Subject");
		return data;
	}
	
	
	public static String getRoleIdFromSendEmail(Connection con,String valueEmail) throws SQLException
	{
		Statement smt = con.createStatement();
		System.out.println("Statement created");

		ResultSet rs = smt.executeQuery("SELECT * FROM TravelTool_v2_Testing.dbo.SendEmail Where Creator='" + valueEmail
				+ "'ORDER BY CreatedDate desc;");
		if (rs.next()) {
			System.out.println(" data found !");
		} else {
			System.out.println("No data found !");
			return "";
		}
		System.out.println("Query Executed");
		String data = rs.getString("RoleId");
		return data;
	}
	
	public static String getContentEmailFromRoleId(Connection con ,String RoleId ,String Creator) throws SQLException 
	{
		Statement smt = con.createStatement();
		System.out.println("Statement created");

		ResultSet rs = smt.executeQuery("SELECT * FROM TravelTool_v2_Testing.dbo.SendEmail Where Creator='" + Creator + "' AND RoleId ='" + RoleId + "' ORDER BY CreatedDate desc;");
		if (rs.next()) {
			System.out.println(" data found !");
		} else {
			System.out.println("No data found !");
			return "";
		}
		System.out.println("Query Executed");
		String data = rs.getString("ContentEmail");
		return data;
	}
	
	public static String getContentOnJsonElement(String dataFromColumnContentEmail, String nameOfWantedJsonElement)
	{
		System.out.println(dataFromColumnContentEmail);
		JsonParser k = new JsonParser();
	    JsonObject element =k.parse(dataFromColumnContentEmail).getAsJsonObject();
	    if (!element.isJsonNull())
	    {
	       System.out.println(element.get(nameOfWantedJsonElement)); 
	       return element.get(nameOfWantedJsonElement).toString();
	    }
	    else
	    {
	    	System.out.println("NO Data !");
	    	return "";
	    }
			
	}
	
	@Test
	public void testContentEmail()
	{
		Connection con = DatabaseManager.taoKetNoi(URL, USERNAME, PASSWORD);
		try {
			String data = DatabaseManager.getContentColumnSubjectFromSendEmail(con, "tetttco@gmail.com");
			
			System.out.println(data);
			JsonParser k = new JsonParser();
		    JsonObject element =k.parse(data).getAsJsonObject();
		    if (!element.isJsonNull())
		    {
		       System.out.println(element.get("Subject")); 
		    }
		    else
		    {
		    	System.out.println("NO Data !");
		    }
				
		} catch (SQLException e) {
	
			e.printStackTrace();
		}
		
	}

}
