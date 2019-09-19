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
import talentwize.pages.TimesheetDetail;
import talentwize.pages.TimesheetManagement;
import talentwize.pages.Users;

public class Test_TimesheetPermission_Timesheet_Management extends TestManager {
	HomePage homePage;
	WebDriver driver;
	PropertyManager propertyManager;
	Dashboard dashboard;
	Administration administration;
	Users users;
	Roles roles;
	String UserRoleName;
	String NameOfTask;
	MyTimesheet myTimesheet;
	TimesheetDetail timesheetDetail;
	TimesheetManagement timesheetManagement;

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
		timesheetManagement = new TimesheetManagement(driver);
		myTimesheet = new MyTimesheet(driver);
		timesheetDetail = new TimesheetDetail(driver);
		homePage.moLinkWeb(propertyManager.getURL_TalentWize());
	}

	@BeforeMethod
	public void PrintNameTestCase(Method method) {
		TestLogger.info("====== Begin Testcase : " + method.getName() + " ========");
	}

	@Test(priority = 1)
	public void TT_1139() throws InterruptedException {
		TestLogger.info("==========TT_1139================");
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
		UserRoleName = "Permission|TimesheetManagement|NoPermission" + TienIch.taoRandomSo(3);

		roles.createUserRoleNameWithRoleTypeAdmin(UserRoleName);

		TestLogger.info("4. Uncheck Timesheet - Management | Read");
		roles.unCheckbox_Read_Timesheet_Management();

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
		administration.clickMenuTimesheet();

		TestLogger.info("Expect : User CANNOT see /do:\r\n" + "1. Data table");
		if (administration.isSubMenuTimesheetBoardDisplayed() == false) {
			setStatusTest("pass", "User CANNOT see/do:\r\n" + "Data table");
		} else {
			setStatusTest("fail", "User STILL CAN see/do:\r\n" + "Data table");
		}

		TestLogger.info("==========End TT_1139================");
	}

	@Test(priority = 2)
	public void TT_1137() throws InterruptedException {
		TestLogger.info("==========TT_1137================");
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
		UserRoleName = "Permission|TimesheetManagement|Create" + TienIch.taoRandomSo(3);

		roles.createUserRoleNameWithRoleTypeAdmin(UserRoleName);

		TestLogger.info("4. Uncheck Timesheet - Management | Read");
		roles.unCheckbox_Read_Timesheet_Management();

		TestLogger.info("5. Check Timesheet - Management | Create");
		roles.checkbox_Create_Timesheet_Management();

		TestLogger.info("6. Click on button Save");
		roles.clickButtonSave();

		administration.openTabUsers();

		TestLogger.info("Assign role " + UserRoleName + " to employee : " + propertyManager.getEmailCuongUser());
		users.searchUsername(propertyManager.getEmailCuongUser());

		// Assign role Automation to this employee
		users.assignUserWithNewRole(propertyManager.getEmailCuongUser(), UserRoleName);

		TestLogger.info("7. Log out");

		dashboard.logout();

		TestLogger.info("8. Login with test account : " + propertyManager.getEmailCuongUser2());

		homePage.SignInWith(propertyManager.getEmailCuongUser2(), propertyManager.getPasswordCuongUser2());

		TestLogger.info("9. Create Timesheet");
		administration.clickLogoTalentWize();
		administration.clickMenuTimesheet();
		administration.clickSubMenuMyTimesheet();
		myTimesheet.createTimesheet("11112", "Test Automation");

		TestLogger.info("10. Log out");

		dashboard.logout();

		TestLogger.info("11. Login with test account : " + propertyManager.getEmailCuongUser());

		homePage.SignInWith(propertyManager.getEmailCuongUser(), propertyManager.getPasswordCuongUser());

		TestLogger.info("12. Open Timesheet Board >> Timesheet Detail");
		administration.clickLogoTalentWize();
		administration.clickMenuTimesheet();
		administration.clickSubMenuTimesheetBoard();
		timesheetManagement.fillTxtSearchEmployee("Cuong Automation 2");
		timesheetManagement.clickLinkDetail();

		TestLogger.info("Expect : User CAN see /do:\r\n" + "1. Data table\r\n" + "2. button Export");

		if (timesheetDetail.isLblTimesheetDetailDisplayed() == true) {
			setStatusTest("pass", "User CAN see/do:\r\n" + "Data table");
		} else {
			setStatusTest("fail", "User CANNOT see/do:\r\n" + "Data table");
		}

		if (timesheetDetail.isBtnExportDisplayed() == true) {
			setStatusTest("pass", "User CAN see/do:\r\n" + "button Export");
		} else {
			setStatusTest("fail", "User CANNOT see/do:\r\n" + "button Export");
		}

		TestLogger.info("Expect : User CANNOT see /do:\r\n" + "1. button Reject\r\n" + "2. button Approve\r\n"
				+ "3. button Delete");

		if (timesheetDetail.isBtnRejectDisplayed() == false) {
			setStatusTest("pass", "User CANNOT see/do:\r\n" + "button Reject");
		} else {
			setStatusTest("fail", "User STILL CAN see/do:\r\n" + "button Reject");
		}

		if (timesheetDetail.isBtnApproveDisplayed() == false) {
			setStatusTest("pass", "User CANNOT see/do:\r\n" + "button Approve");
		} else {
			setStatusTest("fail", "User STILL CAN see/do:\r\n" + "button Approve");
		}

		if (timesheetDetail.isBtnDeleteDisplayed() == false) {
			setStatusTest("pass", "User CANNOT see/do:\r\n" + "button Delete");
		} else {
			setStatusTest("fail", "User STILL CAN see/do:\r\n" + "button Delete");
		}

		TestLogger.info("==========End TT_1137================");
	}

	@Test(priority = 3)
	public void TT_1135() throws InterruptedException {
		TestLogger.info("==========TT_1135================");
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
		UserRoleName = "Permission|TimesheetManagement|Read" + TienIch.taoRandomSo(3);

		roles.createUserRoleNameWithRoleTypeAdmin(UserRoleName);

		TestLogger.info("4. Uncheck Timesheet - Management | Read");
		roles.unCheckbox_Read_Timesheet_Management();

		TestLogger.info("5. Check Timesheet - Management | Read");
		roles.checkbox_Read_Timesheet_Management();

		TestLogger.info("6. Click on button Save");
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

		TestLogger.info("8. Open Timesheet Board >> Timesheet Detail");
		administration.clickLogoTalentWize();
		administration.clickMenuTimesheet();
		administration.clickSubMenuTimesheetBoard();
		timesheetManagement.fillTxtSearchEmployee("Cuong Automation 2");
		timesheetManagement.clickLinkDetail();

		TestLogger.info("Expect : User CAN see /do:\r\n" + "1. Data table\r\n" + "2. button Export");

		if (timesheetDetail.isLblTimesheetDetailDisplayed() == true) {
			setStatusTest("pass", "User CAN see/do:\r\n" + "Data table");
		} else {
			setStatusTest("fail", "User CANNOT see/do:\r\n" + "Data table");
		}

		if (timesheetDetail.isBtnExportDisplayed() == true) {
			setStatusTest("pass", "User CAN see/do:\r\n" + "button Export");
		} else {
			setStatusTest("fail", "User CANNOT see/do:\r\n" + "button Export");
		}

		TestLogger.info("Expect : User CANNOT see /do:\r\n" + "1. button Reject\r\n" + "2. button Approve\r\n"
				+ "3. button Delete");

		if (timesheetDetail.isBtnRejectDisplayed() == false) {
			setStatusTest("pass", "User CANNOT see/do:\r\n" + "button Reject");
		} else {
			setStatusTest("fail", "User STILL CAN see/do:\r\n" + "button Reject");
		}

		if (timesheetDetail.isBtnApproveDisplayed() == false) {
			setStatusTest("pass", "User CANNOT see/do:\r\n" + "button Approve");
		} else {
			setStatusTest("fail", "User STILL CAN see/do:\r\n" + "button Approve");
		}

		if (timesheetDetail.isBtnDeleteDisplayed() == false) {
			setStatusTest("pass", "User CANNOT see/do:\r\n" + "button Delete");
		} else {
			setStatusTest("fail", "User STILL CAN see/do:\r\n" + "button Delete");
		}

		TestLogger.info("==========End TT_1135================");
	}

	@Test(priority = 4)
	public void TT_1136() throws InterruptedException {
		TestLogger.info("==========TT_1136================");
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
		UserRoleName = "Permission|TimesheetManagement|Update" + TienIch.taoRandomSo(3);

		roles.createUserRoleNameWithRoleTypeAdmin(UserRoleName);

		TestLogger.info("4. Uncheck Timesheet - Management | Read");
		roles.unCheckbox_Read_Timesheet_Management();

		TestLogger.info("5.Check Timesheet - Management | Update");
		roles.checkbox_Update_Timesheet_Management();

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

		TestLogger.info("9. Open Timesheet Board >> Timesheet Detail");
		administration.clickLogoTalentWize();
		administration.clickMenuTimesheet();
		administration.clickSubMenuTimesheetBoard();
		timesheetManagement.fillTxtSearchEmployee("Cuong Automation 2");
		timesheetManagement.clickLinkDetail();

		TestLogger.info("Expect : User CAN see /do:\r\n" + "1. Data table\r\n" + "2. button Export\r\n"
				+ "3. button Reject\r\n" + "4. button Approve");

		if (timesheetDetail.isLblTimesheetDetailDisplayed() == true) {
			setStatusTest("pass", "User CAN see/do:\r\n" + "Data table");
		} else {
			setStatusTest("fail", "User CANNOT see/do:\r\n" + "Data table");
		}

		if (timesheetDetail.isBtnExportDisplayed() == true) {
			setStatusTest("pass", "User CAN see/do:\r\n" + "button Export");
		} else {
			setStatusTest("fail", "User CANNOT see/do:\r\n" + "button Export");
		}

		if (timesheetDetail.isBtnRejectDisplayed() == true) {
			setStatusTest("pass", "User CAN see/do:\r\n" + "button Reject");
		} else {
			setStatusTest("fail", "User CANNOT see/do:\r\n" + "button Reject");
		}

		if (timesheetDetail.isBtnApproveDisplayed() == true) {
			setStatusTest("pass", "User CAN see/do:\r\n" + "button Approve");
		} else {
			setStatusTest("fail", "User CANNOT see/do:\r\n" + "button Approve");
		}

		TestLogger.info("Expect : User CANNOT see /do:\r\n" + "1. button Delete");

		if (timesheetDetail.isBtnDeleteDisplayed() == false) {
			setStatusTest("pass", "User CANNOT see/do:\r\n" + "button Delete");
		} else {
			setStatusTest("fail", "User STILL CAN see/do:\r\n" + "button Delete");
		}

		TestLogger.info("10. Reject timesheet");
		timesheetDetail.rejectTimesheet("Test Automation");

		TestLogger.info("Expect : User CAN see /do:\r\n" + "Reject timesheet successfully!");

		if (timesheetDetail.isMsgRejectSuccessDisplayed() == true) {
			setStatusTest("pass", "User CAN see/do:\r\n" + "Reject timesheet successfully!");
		} else {
			setStatusTest("fail", "User CANNOT see/do:\r\n" + "Reject timesheet successfully!");
		}

		TestLogger.info("12. Log out");

		dashboard.logout();

		TestLogger.info("13. Login with test account : " + propertyManager.getEmailCuongUser2());

		homePage.SignInWith(propertyManager.getEmailCuongUser2(), propertyManager.getPasswordCuongUser2());

		TestLogger.info("14. Create Timesheet");
		administration.clickLogoTalentWize();
		administration.clickMenuTimesheet();
		administration.clickSubMenuMyTimesheet();
		myTimesheet.createTimesheet("1111", "Test Automation");

		TestLogger.info("15. Log out");

		dashboard.logout();

		TestLogger.info("16. Login with test account : " + propertyManager.getEmailCuongUser());

		homePage.SignInWith(propertyManager.getEmailCuongUser(), propertyManager.getPasswordCuongUser());

		TestLogger.info("17. Approve timesheet");
		administration.clickLogoTalentWize();
		administration.clickMenuTimesheet();
		administration.clickSubMenuTimesheetBoard();
		timesheetManagement.fillTxtSearchEmployee("Cuong Automation 2");
		timesheetManagement.clickLinkDetail();
		timesheetDetail.aprroveTimesheet("Test Automation");

		TestLogger.info("Expect : User CAN see /do:\r\n" + "Approve timesheet successfully!");

		if (timesheetDetail.isMsgApproveSuccessDisplayed() == true) {
			setStatusTest("pass", "User CANNOT see/do:\r\n" + "Approve timesheet successfully!");
		} else {
			setStatusTest("fail", "User STILL CAN see/do:\r\n" + "Approve timesheet successfully!");
		}

		TestLogger.info("==========End TT_1136================");
	}

	@Test(priority = 5)
	public void TT_1138() throws InterruptedException {
		TestLogger.info("==========TT_1138================");
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
		UserRoleName = "Permission|TimesheetManagement|Delete" + TienIch.taoRandomSo(3);

		roles.createUserRoleNameWithRoleTypeAdmin(UserRoleName);

		TestLogger.info("4. Uncheck Timesheet - Management | Read");
		roles.unCheckbox_Read_Timesheet_Management();

		TestLogger.info("5.Check Timesheet - Management | Delete");
		roles.checkbox_Delete_Timesheet_Management();

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

		TestLogger.info("9. Open Timesheet Board >> Timesheet Detail");
		administration.clickLogoTalentWize();
		administration.clickMenuTimesheet();
		administration.clickSubMenuTimesheetBoard();
		timesheetManagement.fillTxtSearchEmployee("Cuong Automation 2");
		timesheetManagement.clickLinkDetail();

		TestLogger.info(
				"Expect : User CAN see /do:\r\n" + "1. Data table\r\n" + "2. button Export\r\n" + "3. button Delete");

		if (timesheetDetail.isLblTimesheetDetailDisplayed() == true) {
			setStatusTest("pass", "User CAN see/do:\r\n" + "Data table");
		} else {
			setStatusTest("fail", "User CANNOT see/do:\r\n" + "Data table");
		}

		if (timesheetDetail.isBtnExportDisplayed() == true) {
			setStatusTest("pass", "User CAN see/do:\r\n" + "button Export");
		} else {
			setStatusTest("fail", "User CANNOT see/do:\r\n" + "button Export");
		}

		if (timesheetDetail.isBtnDeleteDisplayed() == true) {
			setStatusTest("pass", "User CAN see/do:\r\n" + "button Delete");
		} else {
			setStatusTest("fail", "User CANNOT see/do:\r\n" + "button Delete");
		}

		TestLogger.info("Expect : User CANNOT see /do:\r\n" + "1. button Reject\r\n" + "2. button Approve");

		if (timesheetDetail.isBtnRejectDisplayed() == false) {
			setStatusTest("pass", "User CANNOT see/do:\r\n" + "button Reject");
		} else {
			setStatusTest("fail", "User STILL CAN see/do:\r\n" + "button Reject");
		}

		if (timesheetDetail.isBtnApproveDisplayed() == false) {
			setStatusTest("pass", "User CANNOT see/do:\r\n" + "button Approve");
		} else {
			setStatusTest("fail", "User STILL CAN see/do:\r\n" + "button Approve");
		}

		TestLogger.info("10. Delete timesheet");
		timesheetDetail.deleteTimesheet();

		TestLogger.info("Expect : User CAN see /do:\r\n" + "Delete broadcast message successfully");

		if (timesheetDetail.isMsgDeleteSuccessDisplayed() == true) {
			setStatusTest("pass", "User CAN see/do:\r\n" + "Delete broadcast message successfully");
		} else {
			setStatusTest("fail", "User CANNOT see/do:\r\n" + "Delete broadcast message successfully");
		}

		TestLogger.info("==========End TT_1138================");
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
