package talentwize;

import java.lang.reflect.Method;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Ulties.PropertyManager;
import Ulties.TestLogger;
import Ulties.TestManager;
import Ulties.TienIch;
import controller.WebDriversManager;
import talentwize.pages.Administration;
import talentwize.pages.Assets;
import talentwize.pages.Dashboard;
import talentwize.pages.EmployeeList;
import talentwize.pages.Form_AddAsset;
import talentwize.pages.Form_AddDependents;
import talentwize.pages.Form_AddEmergencyContact;
import talentwize.pages.GoalList;
import talentwize.pages.HomePage;
import talentwize.pages.MyCheckIn;
import talentwize.pages.OtherContacts;
import talentwize.pages.PersonalDetails;
import talentwize.pages.Roles;
import talentwize.pages.Users;

public class Test_FunctionalAccess_PerformancePermission_Checkin_MyCheckin extends TestManager {

	HomePage homePage;
	WebDriver driver;
	PropertyManager propertyManager;
	Dashboard dashboard;
	Administration administration;
	Users users;
	Roles roles;
	String UserRoleName;
	EmployeeList employeeList;
	OtherContacts otherContact;
	PersonalDetails personalDetails;
    Form_AddEmergencyContact  formAddEmergencyContact ; 
    Form_AddDependents formAddDependents;
    Assets assets ;
    Form_AddAsset formAddAsset;
    MyCheckIn myCheckin; 
    GoalList goalList;
	@BeforeTest
	public void KhoiTaoCacNguonTaiNguyen() {
        
		propertyManager = new PropertyManager();
		propertyManager.loadData();
		driver = WebDriversManager.moTrinhDuyet("chrome");
		homePage = new HomePage(driver);
		dashboard = new Dashboard(driver);
		administration = new Administration(driver);
		roles = new Roles(driver);
		users = new Users(driver);
		employeeList = new EmployeeList(driver);
		otherContact = new OtherContacts(driver);
		personalDetails = new PersonalDetails(driver);
		formAddEmergencyContact = new Form_AddEmergencyContact(driver);
		formAddDependents = new Form_AddDependents(driver);
		assets = new Assets(driver);
		formAddAsset = new Form_AddAsset(driver);
		myCheckin = new MyCheckIn(driver);
		goalList = new GoalList(driver);
		homePage.moLinkWeb(propertyManager.getURL_TalentWize());
		
	}
	
	@BeforeMethod 
    public void PrintNameTestCase(Method method)
    {
    	TestLogger.info("====== Begin Testcase : " + method.getName() + " ========");
    }


	@Test(priority = 1)
	public void TT_1164() throws InterruptedException {
		TestLogger.info("1. Login with Administrator account.");
	
		homePage.SignInWith(propertyManager.getEmailAdmin(), propertyManager.getPasswordAdmin());

		if (dashboard.isDashboardMenuDisplayed() == true) {
			setStatusTest("pass", "Login successfully!");
		} else {
			setStatusTest("fail", "Login unsuccessfully!");
		}

		TestLogger.info("2. Go to Administration - User Management - Roles tab");
		administration.clickMenuAdministration();
		administration.clickMenuUserManagement();
		administration.openRolesTab();

		TestLogger.info("3. Create Automation User Role Name and Role Type is Admin :");
		UserRoleName = "Ngoc Auto " + TienIch.taoRandomSo(3);
		roles.createUserRoleNameWithRoleTypeAdmin(UserRoleName);

		TestLogger.info("+ + Unchecked on Performance Permission - Check-in - My Check-in | Read ");
		roles.uncheckbox_Read_MyCheckin();

		TestLogger.info("4. Click Save button");
		roles.clickButtonSave();

		administration.openTabUsers();

		TestLogger.info("5. Assign role " + UserRoleName + " to employee : " + propertyManager.getEmailUserTW());
		users.searchUsername(propertyManager.getEmailUserTW());

		// Assign role Automation to this employee
		users.assignUserWithNewRole(propertyManager.getEmailUserTW(), UserRoleName);

		TestLogger.info("6. Log out");
		dashboard.logout();

		TestLogger.info("7. Login with test account : " + propertyManager.getEmailUserTW());
		homePage.SignInWith(propertyManager.getEmailUserTW(), propertyManager.getPasswordUserTW());

		TestLogger.info("8. Open Performance >> Goals");
		administration.clickMenuPerformance();
		administration.clickSubMenuCheckIn();

		TestLogger.info("Expected: User CANNOT see/do:\r\n" + "User CANNOT see/do:\r\n" + 
				"1. My Check-In menu");
		if (administration.isSubMenuMyCheckInDisplayed() == false) {
			setStatusTest("pass", "User CANNOT see/do:\\r\\n\" + \r\n" + 
					"				\"1. My Check-In menu");
		} else {
			setStatusTest("fail", "User STILL CAN see/do:\\r\\n\" + \r\n" + 
					"				\"1. My Check-In menu");
		}

	}
	
	@Test(priority = 2)
	public void TT_1162() throws InterruptedException {
		TestLogger.info("1. Login with Administrator account.");
	
		homePage.SignInWith(propertyManager.getEmailAdmin(), propertyManager.getPasswordAdmin());

		if (dashboard.isDashboardMenuDisplayed() == true) {
			setStatusTest("pass", "Login successfully!");
		} else {
			setStatusTest("fail", "Login unsuccessfully!");
		}

		TestLogger.info("2. Go to Administration - User Management - Roles tab");
		administration.clickMenuAdministration();
		administration.clickMenuUserManagement();
		administration.openRolesTab();

		TestLogger.info("3. Create Automation User Role Name and Role Type is Admin :");
		UserRoleName = "Ngoc Auto " + TienIch.taoRandomSo(3);
		roles.createUserRoleNameWithRoleTypeAdmin(UserRoleName);

		TestLogger.info("+ + Unchecked on Performance Permission - Check-in - My Check-in | Read ");
		TestLogger.info("+ + Checked on Performance Permission - Check-in - My Check-in | Read ");
		roles.uncheckbox_Read_MyCheckin();
		roles.checkbox_Read_MyCheckin();

		TestLogger.info("4. Click Save button");
		roles.clickButtonSave();

		administration.openTabUsers();

		TestLogger.info("5. Assign role " + UserRoleName + " to employee : " + propertyManager.getEmailUserTW());
		users.searchUsername(propertyManager.getEmailUserTW());

		// Assign role Automation to this employee
		users.assignUserWithNewRole(propertyManager.getEmailUserTW(), UserRoleName);

		TestLogger.info("6. Log out");
		dashboard.logout();

		TestLogger.info("7. Login with test account : " + propertyManager.getEmailUserTW());
		homePage.SignInWith(propertyManager.getEmailUserTW(), propertyManager.getPasswordUserTW());

		TestLogger.info("8. Performance >> Check-in");
		administration.clickMenuPerformance();
		administration.clickSubMenuCheckIn();

		TestLogger.info("Expected: User CANNOT see/do:\r\n" + "User CANNOT see/do:\r\n" + 
				"1. My Check-In menu");
		if (administration.isSubMenuMyCheckInDisplayed() == true) {
			setStatusTest("pass", "User CAN see/do:\\r\\n\" + \r\n" + 
					"				\"1. My Check-In menu");
		} else {
			setStatusTest("fail", "User STILL CAN NOT see/do:\\r\\n\" + \r\n" + 
					"				\"1. My Check-In menu");
		}

	}
	
	@Test(priority = 3)
	public void TT_1163() throws InterruptedException {
		TestLogger.info("1. Login with Administrator account.");
	
		homePage.SignInWith(propertyManager.getEmailAdmin(), propertyManager.getPasswordAdmin());

		if (dashboard.isDashboardMenuDisplayed() == true) {
			setStatusTest("pass", "Login successfully!");
		} else {
			setStatusTest("fail", "Login unsuccessfully!");
		}

		TestLogger.info("2. Go to Administration - User Management - Roles tab");
		administration.clickMenuAdministration();
		administration.clickMenuUserManagement();
		administration.openRolesTab();

		TestLogger.info("3. Create Automation User Role Name and Role Type is Admin :");
		UserRoleName = "Ngoc Auto " + TienIch.taoRandomSo(3);
		roles.createUserRoleNameWithRoleTypeAdmin(UserRoleName);

		TestLogger.info("+ + Unchecked on Performance Permission - Check-in - My Check-in | Read ");
		TestLogger.info("+ + Checked on Performance Permission - Check-in - My Check-in | Update ");
		roles.uncheckbox_Read_MyCheckin();
		roles.checkbox_Update_MyCheckin();
		
		TestLogger.info("4. Click Save button");
		roles.clickButtonSave();

		administration.openTabUsers();

		TestLogger.info("5. Assign role " + UserRoleName + " to employee : " + propertyManager.getEmailUserTW());
		users.searchUsername(propertyManager.getEmailUserTW());

		// Assign role Automation to this employee
		users.assignUserWithNewRole(propertyManager.getEmailUserTW(), UserRoleName);

		TestLogger.info("6. Log out");
		dashboard.logout();

		TestLogger.info("7. Login with test account : " + propertyManager.getEmailUserTW());
		homePage.SignInWith(propertyManager.getEmailUserTW(), propertyManager.getPasswordUserTW());

		TestLogger.info("8. Performance >> Check-in >> My Check-in >> My Check-in form");
		administration.clickMenuPerformance();
		administration.clickSubMenuCheckIn();
		administration.clickSubMenuMyCheckIn();
		
		myCheckin.clickIconHistoryCheckin(); 
		
		goalList.fillComment(TienIch.taoRandomChu(20));
		
		if (myCheckin.isMsgAddedSuccessDisplayed()==true)
		{
			setStatusTest("pass", "Displays msg \"Add comment successfully!\"");
		}
		else
		{
			setStatusTest("fail", "DOES NOT Display msg \"Add comment successfully!\"");
		}
		
	}
	

	@AfterMethod(alwaysRun = true)
	public void finishTestCase(Method method) throws InterruptedException {
		// logout
		if (dashboard.isProfileDisplayed() == true) {
			dashboard.logout();
		}

		homePage.moLinkWeb(propertyManager.getURL_TalentWize());
		
		homePage.SignInWith(propertyManager.getEmailAdmin(), propertyManager.getPasswordAdmin());
	
		administration.clickMenuAdministration();
		administration.clickMenuUserManagement();
		administration.openRolesTab();
		roles.searchRoles(UserRoleName);
		roles.Delete_Role();

		if (dashboard.isProfileDisplayed() == true) {
			dashboard.logout();
		}
		
	    TestLogger.info("====== End Testcase : " + method.getName() + " ======");
		
	}
	
	

	@AfterTest (alwaysRun = true)
	public void dongTrinhDuyet() {
		driver.close();
	}
	

}
