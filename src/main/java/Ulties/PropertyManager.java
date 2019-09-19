package Ulties;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

import org.testng.annotations.Test;

public class PropertyManager {
    
	public static String filePathToProperty =System.getProperty("user.dir")+"\\src\\test\\resources\\configuration.properties";
	public Properties prop ;
	static String email;
	static String password;
	
	public void loadData()
	{
		prop = new Properties();
		
		try {
			prop.load(new FileInputStream(new File(filePathToProperty)));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			TestLogger.info("Configuration properties file cannot be found");
			
		}
	
	}
	
	public String getSearchUserName()
	{
		return prop.getProperty("searchUserName");
		// return email;
	}
	
	public String getEmail()
	{
		return prop.getProperty("Email");
		// return email;
	}
	
	public String getPass()
	{
		return prop.getProperty("Password");
		// return password;
	}
	
	public String getMailLinhTinh()
	{
		return prop.getProperty("Emaillinhtinh");
	}
	
	public String getURL_TalentWize()
	{
		return prop.getProperty("URL_TalentWize");
	}
	
	public String getEmailAdmin()
	{
		return prop.getProperty("EmailAdmin");
	}
	
	public String getPasswordAdmin()
	{
		return prop.getProperty("PasswordAdmin");
	}
	
	
	public String getEmailNHN()
	{
		return prop.getProperty("EmailNHN");
	}
	
	public String getPasswordNHN()
	{
		return prop.getProperty("PasswordNHN");
	}
	
	public String getEmailUserTW()
	{
		return prop.getProperty("EmailUserTW");
	}
	
	public String getEmailUserLock()
	{
		return prop.getProperty("EmailUserLock");
	}
	
	public String getPasswordUserTW()
	{
		return prop.getProperty("PasswordUserTW");
	}
	
	
	public String getPassLinhTinh() {
		return prop.getProperty("Passwordlinhtinh");
	}
	
	public String getPassInActive() {
		return prop.getProperty("PassInActive");
	}
	
	public String getPassLocked() {
		return prop.getProperty("PasswordLocked");
	}
	
	public void setMailLocked(String mail)
	{
		prop.setProperty("MailLock", mail);
		try {
			FileOutputStream f = new FileOutputStream(new File(filePathToProperty));
			
			try {
				prop.store(f, "tieu de");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void setMailInActive(String mail)
	{
		prop.setProperty("Mailinactive", mail);
		try {
			FileOutputStream f = new FileOutputStream(new File(filePathToProperty));
			
			try {
				prop.store(f, "tieu de");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public String getMailLocked()
	{
		return prop.getProperty("MailLock");
	}
	
	public String getMailInActive()
	{
		return prop.getProperty("Mailinactive");
	}
	
	public void setNewPassword(String value)
	{
		prop.setProperty("Password", value);
		try {
			FileOutputStream f = new FileOutputStream(new File(filePathToProperty));
			
			try {
				prop.store(f, "tieu de");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
	}
	
	public void setPassLocked(String value)
	{
		prop.setProperty("PasswordLocked", value);
		try {
			FileOutputStream f = new FileOutputStream(new File(filePathToProperty));
			
			try {
				prop.store(f, "tieu de");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	
	public void setMailLinhTinh(String value)
	{
		prop.setProperty("Emaillinhtinh", value);
		try {
			FileOutputStream f = new FileOutputStream(new File(filePathToProperty));
			
			try {
				prop.store(f, "tieu de");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	
	public void setPasslLinhTinh(String value)
	{
		prop.setProperty("Passwordlinhtinh", value);
		try {
			FileOutputStream f = new FileOutputStream(new File(filePathToProperty));
			
			try {
				prop.store(f, "tieu de");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void setPasslInActive(String value)
	{
		prop.setProperty("PassInActive", value);
		try {
			FileOutputStream f = new FileOutputStream(new File(filePathToProperty));
			
			try {
				prop.store(f, "tieu de pass inActive");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public String getEmailAdmin1()
	{
		return prop.getProperty("EmailAdmin1");
	}
	
	public String getPasswordAdmin1()
	{
		return prop.getProperty("PasswordAdmin1");
	}
	
	public String getEmailAdmin2()
	{
		return prop.getProperty("EmailAdmin1");
	}
	
	public String getPasswordAdmin2()
	{
		return prop.getProperty("PasswordAdmin1");
	}
	
	public String getEmailUserTW1()
	{
		return prop.getProperty("EmailUserTW1");
	}
	public String getPasswordUserTW1()
	{
		return prop.getProperty("PasswordUserTW1");
	}
	
	public String getEmailUserTW2()
	{
		return prop.getProperty("EmailAdmin2");
	}
	public String getPasswordUserTW2()
	{
		return prop.getProperty("PasswordAdmin2");
	}
	
	public String getEmailCuongAdmin()
    {
        return prop.getProperty("EmailCuongAdmin");
    }

    public String getPasswordCuongAdmin()
    {
        return prop.getProperty("PasswordCuongAdmin");
    }

    public String getEmailCuongUser()
    {
        return prop.getProperty("EmailCuongUser");
    }

    public String getPasswordCuongUser()
    {
        return prop.getProperty("PasswordCuongUser");
    }
    
    public String getEmailCuongUser2()
    {
        return prop.getProperty("EmailCuongUser2");
    }

    public String getPasswordCuongUser2()
    {
        return prop.getProperty("PasswordCuongUser2");
    }
    
    public String getEmailAdminNgoc()
    {
        return prop.getProperty("EmailAdminNgoc");
    }

    public String getPasswordAdminNgoc()
    {
        return prop.getProperty("PasswordAdminNgoc");
    }

    public String getEmailUserChi()
    {
        return prop.getProperty("EmailUserChi");
    }

    public String getPasswordUserChi()
    {
        return prop.getProperty("PasswordUserChi");
    }
	
   
    
	
	@Test
	public void test()
	{
		PropertyManager pm = new PropertyManager();
		pm.loadData();
		pm.setNewPassword("23456789");
		TestLogger.info(pm.getPass());
	}
	
	
	
}
