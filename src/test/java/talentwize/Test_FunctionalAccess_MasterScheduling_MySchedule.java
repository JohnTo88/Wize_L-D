package talentwize;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Ulties.PropertyManager;
import Ulties.TestLogger;
import Ulties.TestManager;
import Ulties.TienIch;
import controller.WebDriversManager;
import talentwize.pages.Administration;
import talentwize.pages.CompanyJobHistory;
import talentwize.pages.Dashboard;
import talentwize.pages.EmployeeList;
import talentwize.pages.Form_EditContractType;
import talentwize.pages.Form_EditCurrentPosition;
import talentwize.pages.Form_EditNewPosition;
import talentwize.pages.Form_EditPreviousPosition;
import talentwize.pages.HomePage;
import talentwize.pages.MySchedule;
import talentwize.pages.Roles;
import talentwize.pages.Users;

public class Test_FunctionalAccess_MasterScheduling_MySchedule extends TestManager {

	HomePage homePage;
	WebDriver driver;
	PropertyManager propertyManager;
	Dashboard dashboard;
	Administration administration;
	Users users;
	Roles roles;
	String UserRoleName;
	EmployeeList employeeList;
	CompanyJobHistory companyJobHistory;
	Form_EditContractType editContractType;
	Form_EditPreviousPosition editPreviousPosition;
	Form_EditCurrentPosition editCurrentPosition;
	Form_EditNewPosition editNewPosition;
    MySchedule mySchedule; 
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
		companyJobHistory = new CompanyJobHistory(driver);
		homePage.moLinkWeb(propertyManager.getURL_TalentWize());
		editContractType = new Form_EditContractType(driver);
		editPreviousPosition = new Form_EditPreviousPosition(driver);
		editCurrentPosition = new Form_EditCurrentPosition(driver);
		editNewPosition = new Form_EditNewPosition(driver);
		mySchedule = new MySchedule(driver);
	}

	@Test(priority = 1)
	public void TT_1220() throws InterruptedException {
		TestLogger.info("=================TT_1120 =====================");
		TestLogger.info("1. Login with Administrator account.");
		homePage.SignInWith(propertyManager.getEmailAdmin1(), propertyManager.getPasswordAdmin1());
		if (dashboard.isDashboardMenuDisplayed() == true) {
			setStatusTest("pass", "Dang Nhap Thanh Cong");
		} else {
			setStatusTest("fail", "Dang Nhap khong Thanh Cong");
		}
		TestLogger.info("2. Go to Administration - User Management - Roles tab");
		administration.clickMenuAdministration();
		administration.clickMenuUserManagement();
		administration.openRolesTab();

		TestLogger.info("3. Create Automation User Role Name and Role Type is Admin :");
		UserRoleName = "FunctionalAccess|Master Scheduling-My Schedule" + TienIch.taoRandomSo(3);

		roles.createUserRoleNameWithRoleTypeAdmin(UserRoleName);

		TestLogger.info("4. Unchecked on \r\n" + 
				"Master Scheduling - My Schedule | Read");
		roles.uncheckbox_Read_MasterScheduling_MySchedule();
		
		TestLogger.info("5. Click Save button");
		roles.clickButtonSave();

		administration.openTabUsers();

		TestLogger.info("Assign role " + UserRoleName + " to employee : " + propertyManager.getEmailUserTW1());
		users.searchUsername(propertyManager.getEmailUserTW1());

		// Assign role Automation to this employee
		users.assignUserWithNewRole(propertyManager.getEmailUserTW1(), UserRoleName);

		TestLogger.info("6. Log out");

		dashboard.logout();

		TestLogger.info("7. Login with test account : " + propertyManager.getEmailUserTW1());

		homePage.SignInWith(propertyManager.getEmailUserTW1(), propertyManager.getPasswordUserTW1());
        TestLogger.info("8. Open Master Scheduling");
		administration.clickMenuMasterScheduling();
		
		if (administration.isSubMenuMyScheduleDisplayed()==false)
		{
			setStatusTest("pass", "User CANNOT see/do:\r\n" + 
					"1. Menu My Schedule");
		}
		else
		{
			setStatusTest("fail", "User STILL CAN see/do:\r\n" + 
					"1. Menu My Schedule ");
		}

		TestLogger.info("=================END TT_1220=====================");
	}
	
	
	@Test(priority = 2)
	public void TT_1219() throws InterruptedException {
		TestLogger.info("=================TT_1119 =====================");
		TestLogger.info("1. Login with Administrator account.");
		homePage.SignInWith(propertyManager.getEmailAdmin1(), propertyManager.getPasswordAdmin1());
		if (dashboard.isDashboardMenuDisplayed() == true) {
			setStatusTest("pass", "Dang Nhap Thanh Cong");
		} else {
			setStatusTest("fail", "Dang Nhap khong Thanh Cong");
		}
		TestLogger.info("2. Go to Administration - User Management - Roles tab");
		administration.clickMenuAdministration();
		administration.clickMenuUserManagement();
		administration.openRolesTab();

		TestLogger.info("3. Create Automation User Role Name and Role Type is Admin :");
		UserRoleName = "FunctionalAccess|Master Scheduling-My Schedule" + TienIch.taoRandomSo(3);

		roles.createUserRoleNameWithRoleTypeAdmin(UserRoleName);

		TestLogger.info("4. checked on \r\n" + 
				"Master Scheduling - My Schedule | Read");
	
		TestLogger.info("5. Click Save button");
		roles.clickButtonSave();

		administration.openTabUsers();

		TestLogger.info("Assign role " + UserRoleName + " to employee : " + propertyManager.getEmailUserTW1());
		users.searchUsername(propertyManager.getEmailUserTW1());

		// Assign role Automation to this employee
		users.assignUserWithNewRole(propertyManager.getEmailUserTW1(), UserRoleName);

		TestLogger.info("6. Log out");

		dashboard.logout();

		TestLogger.info("7. Login with test account : " + propertyManager.getEmailUserTW1());

		homePage.SignInWith(propertyManager.getEmailUserTW1(), propertyManager.getPasswordUserTW1());
		
		TestLogger.info("1. Open Master Scheduling\r\n" + 
				"2. Open My Schedule"); 
		administration.clickMenuMasterScheduling();
		administration.clickSubMenuMySchedule();
		
		if (mySchedule.isCboxShowBreakTimeDispalyed()==true)
		{
			setStatusTest("pass", " User can see /do:\r\n" + 
					"1. Data table\r\n" + 
					"");
		}
		else
		{
			setStatusTest("fail", "User can NOT see /do:\r\n" + 
					"1. Data table\r\n" + 
					" ");
		}
		

		TestLogger.info("=================END TT_1219=====================");
	}
	
	
	
	
	@AfterMethod(alwaysRun = true)
	public void finishTestCase() throws InterruptedException {
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

	}

	@AfterTest (alwaysRun = true)
	public void dongTrinhDuyet() {
		driver.close();
	}
}
