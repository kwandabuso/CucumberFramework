package Engine;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ReadConfig {

	Properties pro;
	
	public ReadConfig()
	{
		File src = new File("./Configuration/config.properties");

		try {
			FileInputStream fis = new FileInputStream(src);
			pro = new Properties();
			pro.load(fis);
		} catch (Exception e) {
			System.out.println("Exception is " + e.getMessage());
		}
	}
	
	public String getApplicationURL()
	{
		String url=pro.getProperty("url");
		return url;
	}

	public String getfirstName()
	{
		String firstName = pro.getProperty("firstName");
		return firstName;
	}
	public String getlastName()
	{
		String lastName = pro.getProperty("lastName");
		return lastName;
	}
	public String getuserName()
	{
		String userName = pro.getProperty("userName");
		return userName;
	}
	public String getpassword()
	{
		String password = pro.getProperty("password");
		return password;
	}
	public String getcompany()
	{
		String company = pro.getProperty("company");
		return company;
	}
	public String getroleId()
	{
		String role = pro.getProperty("roleId");
		return role;
	}
	public String getemail()
	{
		String email = pro.getProperty("email");
		return email;
	}
	public String getmobilePhone()
	{
		String mobilePhone = pro.getProperty("mobilePhone");
		return mobilePhone;
	}
	
	public String getBrowser()
	{
	String chromepath=pro.getProperty("Browser");
	return chromepath;
	}

	public String getChromePath()
	{
		String chromepath=pro.getProperty("chromepath");
		return chromepath;
	}

	public String getIEPath()
	{
	String iepath=pro.getProperty("iepath");
	return iepath;
	}
	
	public String getFirefoxPath()
	{
	String firefoxpath=pro.getProperty("firefoxpath");
	return firefoxpath;
	}

	public String getDataSource()
	{
		String dataSource=pro.getProperty("IsReadFromExcelDataSource");
		return dataSource;
	}

	
}




