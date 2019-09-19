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
import talentwize.pages.HomePage;
import talentwize.pages.OtherContacts;
import talentwize.pages.PersonalDetails;
import talentwize.pages.Roles;
import talentwize.pages.Users;

public class Test_FunctionalAccess_MyED_MyAssets extends TestManager {

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
	Form_AddEmergencyContact formAddEmergencyContact;
	Form_AddDependents formAddDependents;
	Assets assets;
	Form_AddAsset formAddAsset;

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
		homePage.moLinkWeb(propertyManager.getURL_TalentWize());

	}

	@BeforeMethod
	public void PrintNameTestCase(Method method) {
		TestLogger.info("====== Begin Testcase : " + method.getName() + " ========");
	}

	@Test(priority = 1)
	public void TT_1466() throws InterruptedException {
		TestLogger.info("1. Login with Administrator account.");
		homePage.SignInWith(propertyManager.getEmailAdmin(), propertyManager.getPasswordAdmin());

		if (dashboard.isDashboardMenuDisplayed() == true) {
			setStatusTest("pass", "Dang Nhap Thanh Cong");
		} else {
			setStatusTest("fail", "Dang Nhap khong Thanh Cong");
		}

		TestLogger.info("2. Go to Administration - User Management - Roles tab");
		administration.clickMenuAdministration();
		administration.clickMenuUserManagement();
		administration.openRolesTab();

		TestLogger.info("Create Automation User Role Name and Role Type is Admin :");
		UserRoleName = "My Assets| No permission" + TienIch.taoRandomSo(4);

		roles.createUserRoleNameWithRoleTypeAdmin(UserRoleName);

		TestLogger.info("+ Unchecked on My Assets| Read");
		roles.unCheckbox_Read_My_Assets();

		TestLogger.info("5. Click Save button");
		roles.clickButtonSave();
		administration.openTabUsers();

		TestLogger.info("Assign role " + UserRoleName + " to employee : " + propertyManager.getEmailUserTW());
		users.searchUsername(propertyManager.getEmailUserTW());

		// Assign role Automation to this employee
		users.assignUserWithNewRole(propertyManager.getEmailUserTW(), UserRoleName);

		TestLogger.info("6. Log out");

		dashboard.logout();

		TestLogger.info("7. Login with test account : " + propertyManager.getEmailUserTW());

		homePage.SignInWith(propertyManager.getEmailUserTW(), propertyManager.getPasswordUserTW());

		TestLogger.info("Open Employee Data menu");
		administration.clickMenuEmployeeData();

		if (administration.isSubMenuAssetsDisplayed() == false) {
			setStatusTest("pass", "User can NOT see /do:\r\n" + "User CANNOT see/do:\r\n" + "1. Assets menu");
		} else {
			setStatusTest("fail", "User STILL can see /do:\r\n" + "User STILL CAN see/do:\r\n" + "1. Assets menu");
		}

	}

	@Test(priority = 2)
	public void TT_1470() throws InterruptedException {
		TestLogger.info("1. Login with Administrator account.");
		homePage.SignInWith(propertyManager.getEmailAdmin(), propertyManager.getPasswordAdmin());

		if (dashboard.isDashboardMenuDisplayed() == true) {
			setStatusTest("pass", "Dang Nhap Thanh Cong");
		} else {
			setStatusTest("fail", "Dang Nhap khong Thanh Cong");
		}

		TestLogger.info("2. Go to Administration - User Management - Roles tab");
		administration.clickMenuAdministration();
		administration.clickMenuUserManagement();
		administration.openRolesTab();

		TestLogger.info("Create Automation User Role Name and Role Type is Admin :");
		UserRoleName = "My Assets|Create" + TienIch.taoRandomSo(4);

		roles.createUserRoleNameWithRoleTypeAdmin(UserRoleName);

		TestLogger.info("+ check on My Assets|Read");
		roles.unCheckbox_Read_My_Assets();
		TestLogger.info("+ check on My Assets| Create");
		roles.checkbox_Create_My_Assets();
		TestLogger.info("5. Click Save button");
		roles.clickButtonSave();
		administration.openTabUsers();

		TestLogger.info("Assign role " + UserRoleName + " to employee : " + propertyManager.getEmailUserTW());
		users.searchUsername(propertyManager.getEmailUserTW());

		// Assign role Automation to this employee
		users.assignUserWithNewRole(propertyManager.getEmailUserTW(), UserRoleName);

		TestLogger.info("6. Log out");

		dashboard.logout();

		TestLogger.info("7. Login with test account : " + propertyManager.getEmailUserTW());

		homePage.SignInWith(propertyManager.getEmailUserTW(), propertyManager.getPasswordUserTW());

		TestLogger.info("Open Employee Data menu");
		administration.clickMenuEmployeeData();

		if (administration.isSubMenuAssetsDisplayed() == true) {
			setStatusTest("pass", "User can see /do:\r\n" + "" + "1. Assets menu");
		} else {
			setStatusTest("fail", "User STILL can see /do:\r\n" + "" + "1. Assets menu");
		}

		administration.clickSubMenuAssets();

		if (assets.isButtonAddDisplayed() == true) {
			setStatusTest("pass", "User can see /do:\r\n" + "1. Assets menu\r\n" + "2. Add  btn");
		} else {
			setStatusTest("fail", "User can NOT see /do:\r\n" + "1. Assets menu\r\n" + "2. Add  btn");
		}

		if (assets.isIconDeleteDisplayed() == false && assets.isLinksOfSerialNumberDisplayed() == false) {
			setStatusTest("pass",
					"User CANNOT see/do:\r\n" + "" + "2. Clickable on Serial Number name\r\n" + "4. Delete btn");
		} else {
			setStatusTest("fail",
					"User STILL CAN see/do:\r\n" + "" + "2. Clickable on Serial Number name\r\n" + "4. Delete btn");
		}

		TestLogger.info("Click on Add btn\r\n" + "Input all mandatory fields\r\n" + "Click Save btn");
		assets.clickButtonAdd();
		formAddAsset.addAsset(TienIch.taoRandomSovaChu(12));

		if (assets.isTextAddedSuccesfullDisplayed() == true) {
			setStatusTest("pass", "The system displays msg: Added successfully");
		} else {
			setStatusTest("fail", "The system DOES NOT displays msg: Added successfully");
		}

	}

	@Test(priority = 3)
	public void TT_1472() throws InterruptedException {
		TestLogger.info("1. Login with Administrator account.");
		homePage.SignInWith(propertyManager.getEmailAdmin(), propertyManager.getPasswordAdmin());

		if (dashboard.isDashboardMenuDisplayed() == true) {
			setStatusTest("pass", "Dang Nhap Thanh Cong");
		} else {
			setStatusTest("fail", "Dang Nhap khong Thanh Cong");
		}

		TestLogger.info("2. Go to Administration - User Management - Roles tab");
		administration.clickMenuAdministration();
		administration.clickMenuUserManagement();
		administration.openRolesTab();

		TestLogger.info("Create Automation User Role Name and Role Type is Admin :");
		UserRoleName = "ED-Assets|Read" + TienIch.taoRandomSo(3);

		roles.createUserRoleNameWithRoleTypeAdmin(UserRoleName);

		TestLogger.info("+ Check on My Assets| Read");
		roles.unCheckbox_Read_My_Assets();
		roles.checkbox_Read_My_Assets();

		TestLogger.info("5. Click Save button");
		roles.clickButtonSave();
		administration.openTabUsers();

		TestLogger.info("Assign role " + UserRoleName + " to employee : " + propertyManager.getEmailUserTW());
		users.searchUsername(propertyManager.getEmailUserTW());

		// Assign role Automation to this employee
		users.assignUserWithNewRole(propertyManager.getEmailUserTW(), UserRoleName);

		TestLogger.info("6. Log out");

		dashboard.logout();

		TestLogger.info("7. Login with test account : " + propertyManager.getEmailUserTW());

		homePage.SignInWith(propertyManager.getEmailUserTW(), propertyManager.getPasswordUserTW());

		TestLogger.info("8. Open Employee Data menu");
		administration.clickMenuEmployeeData();

		if (administration.isSubMenuAssetsDisplayed() == true) {
			setStatusTest("pass", "User can see /do:\r\n" + "" + "1. Assets menu");
		} else {
			setStatusTest("fail", "User STILL can see /do:\r\n" + "" + "1. Assets menu");
		}

		administration.clickSubMenuAssets();
		if (assets.isButtonAddDisplayed() == false && assets.isIconDeleteDisplayed() == false
				&& assets.isLinksOfSerialNumberDisplayed() == false) {
			setStatusTest("pass", "User CANNOT see/do:\r\n" + "1. Add  btn\r\n"
					+ "2. Clickable on Serial Number name\r\n" + "4. Delete btn");
		} else {
			setStatusTest("fail", "User STILL CAN see/do:\r\n" + "1. Add  btn\r\n"
					+ "2. Clickable on Serial Number name\r\n" + "4. Delete btn");
		}

	}

	@Test(priority = 4)
	public void TT_1469() throws InterruptedException {
		TestLogger.info("1. Login with Administrator account.");
		homePage.SignInWith(propertyManager.getEmailAdmin(), propertyManager.getPasswordAdmin());

		if (dashboard.isDashboardMenuDisplayed() == true) {
			setStatusTest("pass", "Dang Nhap Thanh Cong");
		} else {
			setStatusTest("fail", "Dang Nhap khong Thanh Cong");
		}

		TestLogger.info("2. Go to Administration - User Management - Roles tab");
		administration.clickMenuAdministration();
		administration.clickMenuUserManagement();
		administration.openRolesTab();

		TestLogger.info("Create Automation User Role Name and Role Type is Admin :");
		UserRoleName = "ED-Assets|Update" + TienIch.taoRandomSo(3);

		roles.createUserRoleNameWithRoleTypeAdmin(UserRoleName);

		TestLogger.info("+ Check on My Assets | Read\r\n" + "+ Check on My Assets| Update");
		roles.unCheckbox_Read_My_Assets();
		roles.checkbox_Update_My_Assets();
		TestLogger.info("5. Click Save button");
		roles.clickButtonSave();
		administration.openTabUsers();

		TestLogger.info("Assign role " + UserRoleName + " to employee : " + propertyManager.getEmailUserTW());
		users.searchUsername(propertyManager.getEmailUserTW());

		// Assign role Automation to this employee
		users.assignUserWithNewRole(propertyManager.getEmailUserTW(), UserRoleName);

		TestLogger.info("6. Log out");

		dashboard.logout();

		TestLogger.info("7. Login with test account : " + propertyManager.getEmailUserTW());

		homePage.SignInWith(propertyManager.getEmailUserTW(), propertyManager.getPasswordUserTW());

		TestLogger.info("8.Open Employee Data menu");
		administration.clickMenuEmployeeData();

		if (administration.isSubMenuAssetsDisplayed() == true) {
			setStatusTest("pass", "User can see /do:\r\n" + "" + "1. Assets menu");
		} else {
			setStatusTest("fail", "User STILL can see /do:\r\n" + "" + "1. Assets menu");
		}

		administration.clickSubMenuAssets();

		if (assets.isButtonAddDisplayed() == false && assets.isIconDeleteDisplayed() == false) {
			setStatusTest("pass", "User CANNOT see/do:\r\n" + "1. Add  btn\r\n" + "4. Delete btn");
		} else {
			setStatusTest("fail", "User CAN see/do:\r\n" + "1. Add  btn\r\n" + "4. Delete btn");
		}

		if (assets.isLinksOfSerialNumberDisplayed() == true && assets.isButtonAssignDisplayed() == true) {
			setStatusTest("pass", "User can see /do:\r\n" + "1. Assets menu\r\n"
					+ "2. Clickable on Serial Number name\r\n" + "3. Assign btn");
		} else {
			setStatusTest("fail", "User can see NOT /do:\r\n" + "1. Assets menu\r\n"
					+ "2. Clickable on Serial Number name\r\n" + "3. Assign btn");
		}

		TestLogger.info("Click on Series number hyperlink\r\n" + "Click Save btn");

		assets.clickOnFistLinkOfSerialNumber();
		formAddAsset.addAsset(TienIch.taoRandomSovaChu(12));

		if (assets.isTextUpdatedSuccesfullDisplayed() == true) {
			setStatusTest("pass", "The system displays msg: Added successfully");
		} else {
			setStatusTest("fail", "The system DOES NOT displays msg: Added successfully");
		}

	}

	@Test(priority = 5)
	public void TT_1467() throws InterruptedException {
		TestLogger.info("1. Login with Administrator account.");
		homePage.SignInWith(propertyManager.getEmailAdmin(), propertyManager.getPasswordAdmin());

		if (dashboard.isDashboardMenuDisplayed() == true) {
			setStatusTest("pass", "Dang Nhap Thanh Cong");
		} else {
			setStatusTest("fail", "Dang Nhap khong Thanh Cong");
		}

		TestLogger.info("2. Go to Administration - User Management - Roles tab");
		administration.clickMenuAdministration();
		administration.clickMenuUserManagement();
		administration.openRolesTab();

		TestLogger.info("Create Automation User Role Name and Role Type is Admin :");
		UserRoleName = "My Assets|Delete" + TienIch.taoRandomSo(3);

		roles.createUserRoleNameWithRoleTypeAdmin(UserRoleName);

		TestLogger.info("+ Check on My Assets | Read\r\n" + "+ Check on My Assets| Delete");

		roles.unCheckbox_Read_My_Assets();
		TestLogger.info("+ checked on My Assets| Delete");
		roles.checkbox_Delete_My_Assets();
		TestLogger.info("5. Click Save button");
		roles.clickButtonSave();

		administration.openTabUsers();

		TestLogger.info("Assign role " + UserRoleName + " to employee : " + propertyManager.getEmailUserTW());
		users.searchUsername(propertyManager.getEmailUserTW());

		// Assign role Automation to this employee
		users.assignUserWithNewRole(propertyManager.getEmailUserTW(), UserRoleName);

		TestLogger.info("6. Log out");

		dashboard.logout();

		TestLogger.info("7. Login with test account : " + propertyManager.getEmailUserTW());

		homePage.SignInWith(propertyManager.getEmailUserTW(), propertyManager.getPasswordUserTW());

		TestLogger.info("8.Open Employee Data menu");

		administration.clickMenuEmployeeData();

		if (administration.isSubMenuAssetsDisplayed() == true) {
			setStatusTest("pass", "User can see /do:\r\n" + "" + "1. Assets menu");
		} else {
			setStatusTest("fail", "User STILL can see /do:\r\n" + "" + "1. Assets menu");
		}

		administration.clickSubMenuAssets();

		if (assets.isButtonAddDisplayed() == false && assets.isLinksOfSerialNumberDisplayed() == false) {
			setStatusTest("pass", "User CANNOT see/do:\r\n" + "1. Add  btn\r\n" + "2. Clickable on Serial Number name");
		} else {
			setStatusTest("fail",
					"User STILL CAN see/do:\r\n" + "1. Add  btn\r\n" + "2. Clickable on Serial Number name");
		}

		if (assets.isIconDeleteDisplayed() == true) {
			assets.deleteSerialNumber();
		}

		if (assets.isTextDeletedSuccessfulDisplayed() == true) {
			setStatusTest("pass", "The system displays msg: Deleted successfully");
		} else {
			setStatusTest("fail", "The system does NOT display msg: Deleted successfully");
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
