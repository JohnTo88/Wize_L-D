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
import talentwize.pages.CheckInBoard;
import talentwize.pages.Dashboard;
import talentwize.pages.Form_CheckIn_Detail;
import talentwize.pages.HomePage;
import talentwize.pages.Roles;
import talentwize.pages.Users;

public class Test_FunctionalAccess_Performance_CheckIn_Board extends TestManager {
	HomePage homePage;
	WebDriver driver;
	PropertyManager propertyManager;
	Dashboard dashboard;
	Administration administration;
	Users users;
	Roles roles;
	String UserRoleName;
	CheckInBoard checkInBoard;
	Form_CheckIn_Detail formCheckInDetail;

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
		checkInBoard = new CheckInBoard(driver);
		formCheckInDetail = new Form_CheckIn_Detail(driver);
		homePage.moLinkWeb(propertyManager.getURL_TalentWize());
	}

	@BeforeMethod
	public void PrintNameTestCase(Method method) {
		TestLogger.info("====== Begin Testcase : " + method.getName() + " ========");
	}

	@Test(priority = 1)
	public void TT_1009() throws InterruptedException {
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
		UserRoleName = "Performance|Check-in Board|NoPermission" + TienIch.taoRandomSo(3);

		roles.createUserRoleNameWithRoleTypeAdmin(UserRoleName);

		TestLogger.info("4. Uncheck on Performance -Check-in Board | Read");
		roles.uncheckbox_Read_Checkin_Board();

		TestLogger.info("5. Click on button Save");
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

		TestLogger.info("9. Open Performance menu >> Check-in sub menu");
		
		administration.clickLogoTalentWize();
		administration.clickMenuPerformance();
		administration.clickSubMenuCheckIn();

		TestLogger.info("10. Check permission");
		
		TestLogger.info("Expect : User CANNOT see /do: " + "Check-in Board menu ");
		if (administration.isSubMenuCheckInBoardDisplayed() == false)
		{
			setStatusTest("pass", "User CANNOT see/do: " + "Check-in Board menu");
		} else {
			setStatusTest("fail", "User CAN see/do: " + "Check-in Board menu");
		}

}

	@Test(priority = 2)
	public void TT_1022() throws InterruptedException {
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
		UserRoleName = "Performance|Check-in Board|Read" + TienIch.taoRandomSo(3);

		roles.createUserRoleNameWithRoleTypeAdmin(UserRoleName);

		TestLogger.info("4. Uncheck on Performance -Check-in Board | Read");
		roles.uncheckbox_Read_Checkin_Board();

		TestLogger.info("5. Check on Performance -Check-in Board | Read");
		roles.checkbox_Read_Checkin_Board();

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

		TestLogger.info("9. Open Performance menu >> Go to Check-in >> Go to Check-in Board");
		
		administration.clickLogoTalentWize();
		administration.clickMenuPerformance();
		administration.clickSubMenuCheckIn();
		
		TestLogger.info("10. Check Permission");
		
		TestLogger.info("Expect : User CAN see /do:\r\n" + 
				"1. Check-in Board menu\r\n" + 
				"2. Check-in table \r\n" + 
				"3. Export button\r\n" + 
				"4. View check-in detail ");

		if (administration.isSubMenuCheckInBoardDisplayed() == true) {
			setStatusTest("pass", "User CAN see/do: " + "Check-in Board menu");
		} else {
			setStatusTest("fail", "User CANNOT see/do: " + "Check-in Board menu");
		}

		administration.clickSubMenuCheckInBoard();
		if (checkInBoard.isCheckinTableDisplayed() == true) {
			setStatusTest("pass", "User CAN see/do: " + "Check-in table");
		} else {
			setStatusTest("fail", "User CANNOT see/do: " + "Check-in table");
		}

		if (checkInBoard.isButtonExportDisplayed() == true) {
			setStatusTest("pass", "User CAN see/do: " + "Export button");
		} else {
			setStatusTest("fail", "User CANNOT see/do: " + "Export button");
		}
		
		checkInBoard.clickLinkOfCheckInDetails();
		if (formCheckInDetail.isLblNamesDisplayed() == true) {
			setStatusTest("pass", "User CAN see/do: " + " View check-in detail");
		} else {
			setStatusTest("fail", "User CANNOT see/do: " + " View check-in detail");
		}

		TestLogger.info("Expect : User CANNOT see /do: " + "Button Submit with evaluator ");
		if (formCheckInDetail.isBtnSubmitDisplayed() == false) {
			setStatusTest("pass", "User CANNOT see/do:\r\n" + "Button Submit with evaluator ");
		} else {
			setStatusTest("fail", "User STILL CAN see/do:\r\n" + "Button Submit with evaluator ");
		}

	}

	@Test(priority = 3)
	public void TT_1021() throws InterruptedException {
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
		UserRoleName = "Performance|Check-in Board|Update" + TienIch.taoRandomSo(3);

		roles.createUserRoleNameWithRoleTypeAdmin(UserRoleName);

		TestLogger.info("4. Uncheck on Performance -Check-in Board | Read");
		roles.uncheckbox_Read_Checkin_Board();

		TestLogger.info("5. Check on Performance -Check-in Board | Update");
		roles.checkbox_Update_Checkin_Board();

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

		TestLogger.info("9. Open Performance menu >> Go to Check-in >> Go to Check-in Board");
		
		administration.clickLogoTalentWize();
		administration.clickMenuPerformance();
		administration.clickSubMenuCheckIn();
		
		TestLogger.info("10. Check Permission");
		
		TestLogger.info("Expect : User CAN see /do:\r\n" + 
				"1. Check-in Board menu\r\n" + 
				"2. Check-in table \r\n" + 
				"3. Export button\r\n" + 
				"4. View check-in detail\r\n" +
				"5. Button Submit with evaluator");

		if (administration.isSubMenuCheckInBoardDisplayed() == true) {
			setStatusTest("pass", "User CAN see/do: " + "Check-in Board menu");
		} else {
			setStatusTest("fail", "User CANNOT see/do: " + "Check-in Board menu");
		}

		administration.clickSubMenuCheckInBoard();
		if (checkInBoard.isCheckinTableDisplayed() == true) {
			setStatusTest("pass", "User CAN see/do: " + "Check-in table");
		} else {
			setStatusTest("fail", "User CANNOT see/do: " + "Check-in table");
		}

		if (checkInBoard.isButtonExportDisplayed() == true) {
			setStatusTest("pass", "User CAN see/do: " + "Export button");
		} else {
			setStatusTest("fail", "User CANNOT see/do: " + "Export button");
		}
		
		checkInBoard.clickLinkOfCheckInDetails();
		if (formCheckInDetail.isLblNamesDisplayed() == true) {
			setStatusTest("pass", "User CAN see/do: " + " View check-in detail");
		} else {
			setStatusTest("fail", "User CANNOT see/do: " + " View check-in detail");
		}

		if (formCheckInDetail.isBtnSubmitDisplayed() == true) {
			setStatusTest("pass", "User CAN see/do: " + "Button Submit with evaluator ");
		} else {
			setStatusTest("fail", "User CANNOT see/do: " + "Button Submit with evaluator ");
		}
		
		TestLogger.info("11. Input Comment");
		formCheckInDetail.submitComment("Test Automation");
		
		TestLogger.info("Expect : User CAN see /do: " + "Message: Update check-in successfully!");
		if (formCheckInDetail.isMsgCMSuccessDisplayed() == true) {
			setStatusTest("pass", "User CAN see/do: " + "Message: Update check-in successfully!");
		} else {
			setStatusTest("fail", "User CANNOT see/do: " + "Message: Update check-in successfully!");
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

	@AfterTest(alwaysRun = true)
	public void dongTrinhDuyet() {
		driver.close();
	}
}
