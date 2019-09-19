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
import talentwize.pages.MyKPI;
import talentwize.pages.Roles;
import talentwize.pages.Users;

public class Test_FunctionalAccess_PerformancePermission_MyKPIByProject extends TestManager {
	HomePage homePage;
	WebDriver driver;
	PropertyManager propertyManager;
	Dashboard dashboard;
	Administration administration;
	Users users;
	Roles roles;
	String UserRoleName;
	MyKPI myKpi;

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
		homePage.moLinkWeb(propertyManager.getURL_TalentWize());
		myKpi = new MyKPI(driver);
	}

	@BeforeMethod
	public void PrintNameTestCase(Method method) {
		TestLogger.info("====== Begin Testcase : " + method.getName() + " ========");
	}

	@Test(priority = 1)
	public void TT_3667() throws InterruptedException {
		TestLogger.info("1. Login with Administrator account.");

		homePage.SignInWith(propertyManager.getEmailCuongAdmin(), propertyManager.getPasswordCuongAdmin());

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
		UserRoleName = "Performance|MyKPIbyProject|NoPermission" + TienIch.taoRandomSo(3);
		
		roles.createUserRoleNameWithRoleTypeAdmin(UserRoleName);

		TestLogger.info("4. Click Save button");
		roles.clickButtonSave();

		administration.openTabUsers();

		TestLogger.info("5. Assign role " + UserRoleName + " to employee : " + propertyManager.getEmailCuongUser());
		users.searchUsername(propertyManager.getEmailCuongUser());

		// Assign role Automation to this employee
		users.assignUserWithNewRole(propertyManager.getEmailCuongUser(), UserRoleName);

		TestLogger.info("6. Log out");
		dashboard.logout();

		TestLogger.info("7. Login with test account : " + propertyManager.getEmailCuongUser());
		homePage.SignInWith(propertyManager.getEmailCuongUser(), propertyManager.getPasswordCuongUser());

		TestLogger.info("8. Go To Performance");
		administration.clickMenuPerformance();
			
		TestLogger.info("Expected: User CANNOT see/do: " + "Data table in KPI By Project");
		if (administration.isSubMenuMyKPIByProjectDisplayed() == false) {
			setStatusTest("pass", "User CANNOT see/do: " + "Data table in KPI By Project");
		} else {
			setStatusTest("fail", "User CAN see/do: " + "Data table in KPI By Project");
		}

	}

	@Test(priority = 2)
	public void TT_3668() throws InterruptedException {
		TestLogger.info("1. Login with Administrator account.");

		homePage.SignInWith(propertyManager.getEmailCuongAdmin(), propertyManager.getPasswordCuongAdmin());

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
		UserRoleName = "Performance|MyKPIbyProject|Read" + TienIch.taoRandomSo(3);
		
		roles.createUserRoleNameWithRoleTypeAdmin(UserRoleName);
		
		TestLogger.info("4. Checked on Performance Permission - My KPI by Project | Read");
		roles.checkbox_Read_MyKPIbyProject();

		TestLogger.info("5. Click Save button");
		roles.clickButtonSave();

		administration.openTabUsers();

		TestLogger.info("6. Assign role " + UserRoleName + " to employee : " + propertyManager.getEmailCuongUser());
		users.searchUsername(propertyManager.getEmailCuongUser());

		// Assign role Automation to this employee
		users.assignUserWithNewRole(propertyManager.getEmailCuongUser(), UserRoleName);

		TestLogger.info("6. Log out");
		dashboard.logout();

		TestLogger.info("7. Login with test account : " + propertyManager.getEmailCuongUser());
		homePage.SignInWith(propertyManager.getEmailCuongUser(), propertyManager.getPasswordCuongUser());

		TestLogger.info("8. Open Performance >> KPI By Project >> My KPI By Project");
		administration.clickMenuPerformance();
		administration.clickSubMenuKPIByProject();
		
		TestLogger.info("Expected: User CAN see/do: " + "Data table in My KPI By Project");
		if (administration.isSubMenuMyKPIByProjectDisplayed() == true) {
			setStatusTest("pass", "User CAN see/do: " + "Data table in My KPI By Project");
		} else {
			setStatusTest("fail", "User CANNOT see/do: " + "Data table in My KPI By Project");
		}
	}

	@AfterMethod(alwaysRun = true)
	public void finishTestCase(Method method) throws InterruptedException {
		// logout
		if (dashboard.isProfileDisplayed() == true) {
			dashboard.logout();
		}

		homePage.moLinkWeb(propertyManager.getURL_TalentWize());

		homePage.SignInWith(propertyManager.getEmailCuongUser(), propertyManager.getPasswordCuongUser());

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
