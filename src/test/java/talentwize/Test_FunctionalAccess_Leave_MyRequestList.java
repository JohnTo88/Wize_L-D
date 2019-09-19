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
import talentwize.pages.Form_ApplyLeave;
import talentwize.pages.HomePage;
import talentwize.pages.MyRequestList;
import talentwize.pages.Roles;
import talentwize.pages.Users;

public class Test_FunctionalAccess_Leave_MyRequestList extends TestManager {
	HomePage homePage;
	WebDriver driver;
	PropertyManager propertyManager;
	Dashboard dashboard;
	Administration administration;
	Users users;
	Roles roles;
	String UserRoleName;
	String NameOfProgram;
	MyRequestList myRequestList;
	Form_ApplyLeave form_ApplyLeave;

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
		myRequestList = new MyRequestList(driver);
		form_ApplyLeave = new Form_ApplyLeave(driver);
		homePage.moLinkWeb(propertyManager.getURL_TalentWize());
	}

	@BeforeMethod
	public void PrintNameTestCase(Method method) {
		TestLogger.info("====== Begin Testcase : " + method.getName() + " ========");
	}

	@Test(priority = 1)
	public void TT_1182() throws InterruptedException {
		TestLogger.info("========== TT_1182================");
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

		TestLogger.info("3. Create Automation User Role Name and Role Type is User :");
		UserRoleName = "Permission|MyRequestList|NoPermission" + TienIch.taoRandomSo(3);

		roles.createUserRoleNameWithRoleTypeUser(UserRoleName);

		TestLogger.info("4. Uncheck | Leave - My Request List | Read");
		roles.UnCheckBox_Read_Leave_MyRequestList();

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
		administration.clickMenuLeave();

		TestLogger.info("Expect : User CANNOT see /do:\r\n" + "Sub Menu My Request List");
		if (administration.isSubMenuMyAssignedTrainingDisplayed() == false) {
			setStatusTest("pass", "User CANNOT see/do:\r\n" + "Sub Menu My Request List");
		} else {
			setStatusTest("fail", "User CAN see/do:\r\n" + "Sub Menu My Request List");
		}

		TestLogger.info("==========End TT_1182================");
	}

	@Test(priority = 2)
	public void TT_1180() throws InterruptedException {
		TestLogger.info("========== TT_1180================");
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

		TestLogger.info("3. Create Automation User Role Name and Role Type is User :");
		UserRoleName = "Permission|MyRequestList|Create" + TienIch.taoRandomSo(3);

		roles.createUserRoleNameWithRoleTypeUser(UserRoleName);

		TestLogger.info("4. Uncheck | Leave - My Request List | Read");
		roles.UnCheckBox_Read_Leave_MyRequestList();

		TestLogger.info("5. Check | Leave - My Request List | Create");
		roles.CheckBox_Create_Leave_MyRequestList();

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

		TestLogger.info("9. Leave >> My Request List");
		administration.clickLogoTalentWize();
		administration.clickMenuLeave();
		administration.clickSubMenuMyRequestList();

		TestLogger.info("10. Apply Leave");
		myRequestList.clickBtnApplyLeave();
		form_ApplyLeave.applyLeave();

		TestLogger.info("Expect : User CAN see /do:\r\n" + "Apply leave successfully!");
		if (myRequestList.isMsgApplySuccessDisplayed() == true) {
			setStatusTest("pass", "User CAN see/do:\r\n" + "Apply leave successfully!");
		} else {
			setStatusTest("fail", "User CANNOT see/do:\r\n" + "Apply leave successfully!");
		}

		TestLogger.info("11. Check Permission");

		TestLogger.info("Expect : User CAN see /do:\r\n" + "1. Data table\r\n" + "2. button Apply Request\r\n"
				+ "3. hyperlink Date");

		if (administration.isSubTabMyRequestListDisplayed() == true) {
			setStatusTest("pass", "User CAN see/do:\r\n" + "Data table");
		} else {
			setStatusTest("fail", "User CANNOT see/do:\r\n" + "Data table");
		}

		if (myRequestList.isBtnApplyLeaveDisplayed() == true) {
			setStatusTest("pass", "User CAN see/do:\r\n" + "button Apply Request");
		} else {
			setStatusTest("fail", "User CANNOT see/do:\r\n" + "button Apply Request");
		}

		if (myRequestList.isLinkDateDisplayed() == true) {
			setStatusTest("pass", "User CAN see/do:\r\n" + "hyperlink Date");
		} else {
			setStatusTest("fail", "User CANNOT see/do:\r\n" + "hyperlink Date");
		}

		TestLogger.info("Expect : User CANNOT see /do:\r\n" + "button Cancel");

		if (myRequestList.isBtnCancelDisplayed() == false) {
			setStatusTest("pass", "User CANNOT see/do:\r\n" + "button Cancel");
		} else {
			setStatusTest("fail", "User STILL CAN see/do:\r\n" + "button Cancel");
		}
	}

	@Test(priority = 3)
	public void TT_1178() throws InterruptedException {
		TestLogger.info("========== TT_1178================");
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

		TestLogger.info("3. Create Automation User Role Name and Role Type is User :");
		UserRoleName = "Permission|MyRequestList|Read" + TienIch.taoRandomSo(3);

		roles.createUserRoleNameWithRoleTypeUser(UserRoleName);

		TestLogger.info("4. Uncheck | Leave - My Request List | Read");
		roles.UnCheckBox_Read_Leave_MyRequestList();

		TestLogger.info("5. Check | Leave - My Request List | Read");
		roles.CheckBox_Read_Leave_MyRequestList();

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

		TestLogger.info("9. Leave >> My Request List");
		administration.clickLogoTalentWize();
		administration.clickMenuLeave();
		administration.clickSubMenuMyRequestList();

		TestLogger.info("10. Check Permission");
		TestLogger.info("Expect : User CAN see /do:\r\n" + "1. Data table\r\n" + "2. hyperlink Date");

		if (administration.isSubTabMyRequestListDisplayed() == true) {
			setStatusTest("pass", "User CAN see/do:\r\n" + "Data table");
		} else {
			setStatusTest("fail", "User CANNOT see/do:\r\n" + "Data table");
		}

		if (myRequestList.isLinkDateDisplayed() == true) {
			setStatusTest("pass", "User CAN see/do:\r\n" + "hyperlink Date");
		} else {
			setStatusTest("fail", "User CANNOT see/do:\r\n" + "hyperlink Date");
		}

		TestLogger.info("Expect : User CANNOT see /do:\r\n" + "1. button Apply Request\r\n" + "2. button Cancel");

		if (myRequestList.isBtnCancelDisplayed() == false) {
			setStatusTest("pass", "User CANNOT see/do:\r\n" + "button Cancel");
		} else {
			setStatusTest("fail", "User STILL CAN see/do:\r\n" + "button Cancel");
		}

		if (myRequestList.isBtnApplyLeaveDisplayed() == false) {
			setStatusTest("pass", "User CANNOT see/do:\r\n" + "button Apply Request");
		} else {
			setStatusTest("fail", "User STILL CAN see/do:\r\n" + "button Apply Request");
		}
	}

	@Test(priority = 4)
	public void TT_1179() throws InterruptedException {
		TestLogger.info("========== TT_1179================");
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

		TestLogger.info("3. Create Automation User Role Name and Role Type is User :");
		UserRoleName = "Permission|MyRequestList|Update" + TienIch.taoRandomSo(3);

		roles.createUserRoleNameWithRoleTypeUser(UserRoleName);

		TestLogger.info("4. Uncheck | Leave - My Request List | Read");
		roles.UnCheckBox_Read_Leave_MyRequestList();

		TestLogger.info("5. Check | Leave - My Request List | Update");
		roles.CheckBox_Update_Leave_MyRequestList();

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

		TestLogger.info("9. Leave >> My Request List");
		administration.clickLogoTalentWize();
		administration.clickMenuLeave();
		administration.clickSubMenuMyRequestList();

		TestLogger.info("10. Check Permission");
		TestLogger.info(
				"Expect : User CAN see /do:\r\n" + "1. Data table\r\n" + "2. hyperlink Date\r\n" + "3. button Cancel");

		if (administration.isSubTabMyRequestListDisplayed() == true) {
			setStatusTest("pass", "User CAN see/do:\r\n" + "Data table");
		} else {
			setStatusTest("fail", "User CANNOT see/do:\r\n" + "Data table");
		}

		if (myRequestList.isLinkDateDisplayed() == true) {
			setStatusTest("pass", "User CAN see/do:\r\n" + "hyperlink Date");
		} else {
			setStatusTest("fail", "User CANNOT see/do:\r\n" + "hyperlink Date");
		}

		if (myRequestList.isBtnCancelDisplayed() == true) {
			setStatusTest("pass", "User CAN see/do:\r\n" + "button Cancel");
		} else {
			setStatusTest("fail", "User CANNOT see/do:\r\n" + "button Cancel");
		}

		TestLogger.info("Expect : User CANNOT see /do:\r\n" + "button Apply Request");

		if (myRequestList.isBtnApplyLeaveDisplayed() == false) {
			setStatusTest("pass", "User CANNOT see/do:\r\n" + "button Apply Request");
		} else {
			setStatusTest("fail", "User STILL CAN see/do:\r\n" + "button Apply Request");
		}

		TestLogger.info("11. Cancel Request");
		myRequestList.cancelRequest();

		TestLogger.info("Expect : User CAN see /do:\r\n" + "Cancel leave successfully!");

		if (myRequestList.isMsgCancelSuccessDisplayed() == true) {
			setStatusTest("pass", "User CAN see/do:\r\n" + "Cancel leave successfully!");
		} else {
			setStatusTest("fail", "User CANNOT see/do:\r\n" + "Cancel leave successfully!");
		}

		TestLogger.info("==========End TT_1179================");
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
