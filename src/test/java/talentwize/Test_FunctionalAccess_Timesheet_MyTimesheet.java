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
import talentwize.pages.Dashboard;
import talentwize.pages.HomePage;
import talentwize.pages.MyTimesheet;
import talentwize.pages.Roles;
import talentwize.pages.Users;

public class Test_FunctionalAccess_Timesheet_MyTimesheet extends TestManager {
	HomePage homePage;
	WebDriver driver;
	PropertyManager propertyManager;
	Dashboard dashboard;
	Administration administration;
	Users users;
	Roles roles;
	String UserRoleName;
	MyTimesheet myTimesheet;

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
		myTimesheet = new MyTimesheet(driver);
		homePage.moLinkWeb(propertyManager.getURL_TalentWize());
	}

	@BeforeMethod
	public void PrintNameTestCase(Method method) {
		TestLogger.info("====== Begin Testcase : " + method.getName() + " ========");
	}

	@Test(priority = 1)
	public void TT_1125() throws InterruptedException {
		TestLogger.info("==========TT_1125================");
		TestLogger.info("1. Login with Administrator account.");
		homePage.SignInWith(propertyManager.getEmailCuongAdmin(), propertyManager.getPasswordCuongAdmin());

		if (dashboard.isDashboardMenuDisplayed() == true) {
			setStatusTest("pass", "Login successfully!");
		} else {
			setStatusTest("fail", "Login fail!");
		}

		TestLogger.info("2. Go to Administration - User Management - Roles tab");
		administration.clickMenuAdministration();
		administration.clickMenuUserManagement();
		administration.openRolesTab();

		TestLogger.info("3. Create Automation User Role Name and Role Type is Admin :");
		UserRoleName = "Permission|MyTimesheet|NoPermission" + TienIch.taoRandomSo(3);

		roles.createUserRoleNameWithRoleTypeUser(UserRoleName);

		TestLogger.info("4. Uncheck Timesheet - My Timesheet | Read");
		roles.unCheckbox_Read_Timesheet_MyTimesheet();

		TestLogger.info("5. Click on button Save");
		roles.clickButtonSave();

		administration.openTabUsers();

		TestLogger.info("Assign role " + UserRoleName + " to employee : " + propertyManager.getEmailCuongUser());
		users.searchUsername(propertyManager.getEmailCuongUser());

		// Assign role Automation to this employee
		users.assignUserWithNewRole(propertyManager.getEmailCuongUser(), UserRoleName);

		TestLogger.info("6. Log out");

		dashboard.logout();

		TestLogger.info("7. Login with test account : " + propertyManager.getEmailCuongUser());

		homePage.SignInWith(propertyManager.getEmailCuongUser(), propertyManager.getPasswordCuongUser());

		TestLogger.info("8. Check permission");
		administration.clickLogoTalentWize();

		TestLogger.info("Expect : User CANNOT see /do:\r\n" + "Menu Timesheet");
		if (administration.isMenuTimesheetDisplayed() == false) {
			setStatusTest("pass", "User CANNOT see/do:\r\n" + "Menu Timesheet");
		} else {
			setStatusTest("fail", "User STILL CAN see/do:\r\n" + "Menu Timesheet");
		}

		TestLogger.info("==========End TT_1125================");
	}

	@Test(priority = 2)
	public void TT_1172() throws InterruptedException {
		TestLogger.info("==========TT_1172================");
		TestLogger.info("1. Login with Administrator account.");
		homePage.SignInWith(propertyManager.getEmailCuongAdmin(), propertyManager.getPasswordCuongAdmin());

		if (dashboard.isDashboardMenuDisplayed() == true) {
			setStatusTest("pass", "Login successfully!");
		} else {
			setStatusTest("fail", "Login fail!");
		}

		TestLogger.info("2. Go to Administration - User Management - Roles tab");
		administration.clickMenuAdministration();
		administration.clickMenuUserManagement();
		administration.openRolesTab();

		TestLogger.info("3. Create Automation User Role Name and Role Type is Admin :");
		UserRoleName = "Permission|MyTimesheet|Read" + TienIch.taoRandomSo(3);

		roles.createUserRoleNameWithRoleTypeUser(UserRoleName);

		TestLogger.info("4. Uncheck Timesheet - My Timesheet | Read");
		roles.unCheckbox_Read_Timesheet_MyTimesheet();

		TestLogger.info("5.Check Timesheet - My Timesheet | Read");
		roles.checkbox_Read_Timesheet_MyTimesheet();

		TestLogger.info("6. Click on button Save");
		roles.clickButtonSave();

		administration.openTabUsers();

		TestLogger.info("Assign role " + UserRoleName + " to employee : " + propertyManager.getEmailCuongUser());
		users.searchUsername(propertyManager.getEmailCuongUser());

		// Assign role Automation to this employee
		users.assignUserWithNewRole(propertyManager.getEmailCuongUser(), UserRoleName);

		TestLogger.info("7. Log out");

		dashboard.logout();

		TestLogger.info("8. Login with test account : " + propertyManager.getEmailCuongUser());

		homePage.SignInWith(propertyManager.getEmailCuongUser(), propertyManager.getPasswordCuongUser());

		TestLogger.info("9. Timesheet >> My Timesheet");
		administration.clickLogoTalentWize();
		administration.clickMenuTimesheet();
		administration.clickSubMenuMyTimesheet();

		TestLogger.info("10. Check permission");
		TestLogger.info("Expect : User CAN see /do:\r\n" + "1. Data table");

		if (myTimesheet.isLblMyTimesheetDisplayed() == true) {
			setStatusTest("pass", "User CAN see/do:\r\n" + "Data table");
		} else {
			setStatusTest("fail", "User CANNOT see/do:\r\n" + "Data table");
		}

		TestLogger.info("Expect : User CANNOT see /do:\r\n" + "1. button Submit \r\n" + "2. button Edit");

		if (myTimesheet.isBtnSubmitDisplayed() == false) {
			setStatusTest("pass", "User CANNOT see/do:\r\n" + "button Submit");
		} else {
			setStatusTest("fail", "User STILL CAN see/do:\r\n" + "button Submit");
		}

		if (myTimesheet.isBtnEditDisplayed() == false) {
			setStatusTest("pass", "User CANNOT see/do:\r\n" + "button Edit");
		} else {
			setStatusTest("fail", "User STILL CAN see/do:\r\n" + "button Edit");
		}

		TestLogger.info("==========End TT_1172================");
	}

	@Test(priority = 3)
	public void TT_1250() throws InterruptedException {
		TestLogger.info("==========TT_1250================");
		TestLogger.info("1. Login with Administrator account.");
		homePage.SignInWith(propertyManager.getEmailCuongAdmin(), propertyManager.getPasswordCuongAdmin());

		if (dashboard.isDashboardMenuDisplayed() == true) {
			setStatusTest("pass", "Login successfully!");
		} else {
			setStatusTest("fail", "Login fail!");
		}

		TestLogger.info("2. Go to Administration - User Management - Roles tab");
		administration.clickMenuAdministration();
		administration.clickMenuUserManagement();
		administration.openRolesTab();

		TestLogger.info("3. Create Automation User Role Name and Role Type is Admin :");
		UserRoleName = "Permission|MyTimesheet|Update" + TienIch.taoRandomSo(3);

		roles.createUserRoleNameWithRoleTypeUser(UserRoleName);

		TestLogger.info("4. Uncheck Timesheet - My Timesheet | Read");
		roles.unCheckbox_Read_Timesheet_MyTimesheet();

		TestLogger.info("5.Check Timesheet - My Timesheet | Update");
		roles.checkbox_Update_Timesheet_MyTimesheet();

		TestLogger.info("6. Click on button Save");
		roles.clickButtonSave();

		administration.openTabUsers();

		TestLogger.info("Assign role " + UserRoleName + " to employee : " + propertyManager.getEmailCuongUser());
		users.searchUsername(propertyManager.getEmailCuongUser());

		// Assign role Automation to this employee
		users.assignUserWithNewRole(propertyManager.getEmailCuongUser(), UserRoleName);

		TestLogger.info("7. Log out");

		dashboard.logout();

		TestLogger.info("8. Login with test account : " + propertyManager.getEmailCuongUser());

		homePage.SignInWith(propertyManager.getEmailCuongUser(), propertyManager.getPasswordCuongUser());

		TestLogger.info("9. Open Timesheet Board >> Settings >> Task");
		administration.clickLogoTalentWize();
		administration.clickMenuTimesheet();
		administration.clickSubMenuMyTimesheet();

		TestLogger.info("10. Check permission with status = Draft");
		TestLogger.info(
				"Expect : User CAN see /do:\r\n" + "1. Data table\r\n" + "2. button Submit\r\n" + "3. button Edit");

		if (myTimesheet.isLblMyTimesheetDisplayed() == true) {
			setStatusTest("pass", "User CAN see/do:\r\n" + "Data table");
		} else {
			setStatusTest("fail", "User CANNOT see/do:\r\n" + "Data table");
		}

		if (myTimesheet.isBtnSubmitDisplayed() == true) {
			setStatusTest("pass", "User CAN see/do:\r\n" + "button Submit");
		} else {
			setStatusTest("fail", "User CANNOT see/do:\r\n" + "button Submit");
		}

		if (myTimesheet.isBtnEditDisplayed() == true) {
			setStatusTest("pass", "User CAN see/do:\r\n" + "button Edit");
		} else {
			setStatusTest("fail", "User CANNOT see/do:\r\n" + "button Edit");
		}

		TestLogger.info("11. Edit Timesheet");
		myTimesheet.editTimesheet("1111");

		TestLogger.info("Expect : User CAN see /do:\r\n" + "1. button Submit\r\n" + "2. button Edit");

		if (myTimesheet.isBtnSubmitDisplayed() == true) {
			setStatusTest("pass", "User CAN see/do:\r\n" + "button Submit");
		} else {
			setStatusTest("fail", "User CANNOT see/do:\r\n" + "button Submit");
		}

		if (myTimesheet.isBtnEditDisplayed() == true) {
			setStatusTest("pass", "User CAN see/do:\r\n" + "button Edit");
		} else {
			setStatusTest("fail", "User CANNOT see/do:\r\n" + "button Edit");
		}

		TestLogger.info("12. Check permission with status = Submit");
		myTimesheet.submitTimesheet("Test Automation");

		TestLogger.info("13. Submit Timesheet");
		TestLogger.info("Expect: User CAN see /do:\r\n" + "Timesheet submitted successfully!");

		if (myTimesheet.isMsgSubmitSuccessDisplayed() == true) {
			setStatusTest("pass", "User CAN see/do:\r\n" + "Timesheet submitted successfully!");
		} else {
			setStatusTest("fail", "User CANNOT see/do:\r\n" + "Timesheet submitted successfully!");
		}

		TestLogger.info(" : User CAN see /do:\r\n" + "1. Data table\r\n" + "2. button Cancel");

		if (myTimesheet.isLblMyTimesheetDisplayed() == true) {
			setStatusTest("pass", "User CAN see/do:\r\n" + "Data table");
		} else {
			setStatusTest("fail", "User CANNOT see/do:\r\n" + "Data table");
		}

		if (myTimesheet.isBtnCancelDisplayed() == true) {
			setStatusTest("pass", "User CAN see/do:\r\n" + "button Cancel");
		} else {
			setStatusTest("fail", "User CANNOT see/do:\r\n" + "button Cancel");
		}

		TestLogger.info("14. Cancel Timesheet");
		myTimesheet.cancelTimesheet("Test Automation");

		TestLogger.info("Expect : User CAN see /do:\r\n" + "Timesheet cancelled successfully");

		if (myTimesheet.isMsgCancelSuccessDisplayed() == true) {
			setStatusTest("pass", "User CAN see/do:\r\n" + "Timesheet cancelled successfully");
		} else {
			setStatusTest("fail", "User CANNOT see/do:\r\n" + "Timesheet cancelled successfully");
		}

		TestLogger.info("==========End TT_1250================");
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

	@AfterTest(alwaysRun = true)
	public void dongTrinhDuyet() {
		driver.close();
	}
}
