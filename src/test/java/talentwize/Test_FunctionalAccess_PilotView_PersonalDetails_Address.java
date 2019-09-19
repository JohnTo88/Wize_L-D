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
import talentwize.pages.ContactDetails;
import talentwize.pages.Dashboard;
import talentwize.pages.EmployeeList;
import talentwize.pages.Form_AddDependents;
import talentwize.pages.HomePage;
import talentwize.pages.PersonalDetails;
import talentwize.pages.Roles;
import talentwize.pages.Users;

public class Test_FunctionalAccess_PilotView_PersonalDetails_Address extends TestManager {

	HomePage homePage;
	WebDriver driver;
	PropertyManager propertyManager;
	Dashboard dashboard;
	Administration administration;
	Users users;
	Roles roles;
	String UserRoleName;
	EmployeeList employeeList;
	PersonalDetails personalDetails;
	ContactDetails contactDetails;
	Form_AddDependents formAddDependents;

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
		personalDetails = new PersonalDetails(driver);
		contactDetails = new ContactDetails(driver);
		formAddDependents = new Form_AddDependents(driver);
		homePage.moLinkWeb(propertyManager.getURL_TalentWize());

	}

	@BeforeMethod
	public void PrintNameTestCase(Method method) {
		TestLogger.info("====== Begin Testcase : " + method.getName() + " ========");
	}

	@Test(priority = 1)
	public void TT_1514() throws InterruptedException {
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
		UserRoleName = "Automation-MyPersonalDetails-Address-Update" + TienIch.taoRandomSo(2);

		roles.createUserRoleNameWithRoleTypeAdmin(UserRoleName);

		TestLogger.info("+ Checked on ED Employee Data Permision -ED Personal Details-Adress|Update");
		roles.uncheckbox_Read_ED_PersonalDetails_Address();

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
		TestLogger.info("8.Open Employee List >> Pilot View of Employee A");

		administration.clickMenuEmployeeList();
		employeeList.searchEmployees(EmployeeList.NAME_OF_USER);
		employeeList.clickItemEmployeeNVN();
		administration.clickSubMenuPersonalDetails();

		if (personalDetails.isBtnEditAddressDisplayed() == false) {
			setStatusTest("pass", "User CANNOT see/do:\r\n" + "1. Edit btn");

		} else {
			setStatusTest("fail", "User STILL CAN see/do:\r\n" + "1. Edit btn");
		}

		if (personalDetails.isTxtAddressStreetDisplayed() == false) {
			setStatusTest("pass", "User can NOT see/do:\r\n" + "2. Address block and data of employee");
		} else {
			setStatusTest("fail", "User can STILLT see/do:\r\n" + "" + "2. Address block and data of employee");
		}

	}

	@Test(priority = 2)
	public void TT_1513() throws InterruptedException {
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
		UserRoleName = "Automation-MyPersonalDetails-Address-Update" + TienIch.taoRandomSo(2);

		roles.createUserRoleNameWithRoleTypeAdmin(UserRoleName);

		TestLogger.info("+ Checked on ED Employee Data Permision -ED Personal Details-Adress|Update");
		roles.uncheckbox_Read_ED_PersonalDetails_GeneralInformation();
		roles.checkbox_Read_ED_PersonalDetails_GeneralInformation();

		roles.uncheckbox_Read_ED_PersonalDetails_ContactInformation();
		roles.checkbox_Read_ED_PersonalDetails_ContactInformation();

		roles.uncheckbox_Read_ED_PersonalDetails_Address();
		roles.checkbox_Read_ED_PersonalDetails_Address();

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
		TestLogger.info("8.Open Employee List >> Pilot View of Employee A");

		administration.clickMenuEmployeeList();
		employeeList.searchEmployees(EmployeeList.NAME_OF_USER);
		employeeList.clickItemEmployeeNVN();
		administration.clickSubMenuPersonalDetails();

		if (personalDetails.isBtnEditAddressDisplayed() == false) {
			setStatusTest("pass", "User CANNOT see/do:\r\n" + "1. Edit btn");

		} else {
			setStatusTest("fail", "User STILL CAN see/do:\r\n" + "1. Edit btn");
		}

		if (personalDetails.isTitleAddressStreetDisplayed() == true) {
			setStatusTest("pass",
					"User can see/do:\r\n" + "1. Personal Details menu\r\n" + "2. Address block and data of employee");
		} else {
			setStatusTest("fail", "User can NOT see/do:\r\n" + "1. Personal Details menu\r\n"
					+ "2. Address block and data of employee");
		}

	}

	@Test(priority = 3)
	public void TT_1460() throws InterruptedException {
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
		UserRoleName = "Automation-MyPersonalDetails-Address-Update" + TienIch.taoRandomSo(2);

		roles.createUserRoleNameWithRoleTypeAdmin(UserRoleName);

		TestLogger.info("+ Checked on ED Employee Data Permision -ED Personal Details-Adress|Update");
		roles.uncheckbox_Read_ED_PersonalDetails_GeneralInformation();
		roles.checkbox_Read_ED_PersonalDetails_GeneralInformation();
		roles.uncheckbox_Read_ED_PersonalDetails_ContactInformation();
		roles.checkbox_Read_ED_PersonalDetails_ContactInformation();

		roles.uncheckbox_Read_ED_PersonalDetails_Address();

		roles.checkbox_Update_ED_PersonalDetails_Address();

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
		TestLogger.info("8.Open Employee List >> Pilot View of Employee A");

		administration.clickMenuEmployeeList();
		employeeList.searchEmployees(EmployeeList.NAME_OF_USER);
		employeeList.clickItemEmployeeNVN();
		administration.clickSubMenuPersonalDetails();

		if (personalDetails.isBtnEditAddressDisplayed() == true) {
			setStatusTest("pass", "User can see/do:\r\n" + "1. Personal Details menu\r\n"
					+ "2. Address block and data of employee\r\n" + "3. Edit btn");

		} else {
			setStatusTest("fail", "User can NOT see/do:\r\n" + "" + "1. Personal Details menu\r\n"
					+ "2. Address block and data of employee\r\n" + "3. Edit btn");
		}

		personalDetails.clickButtonEditAddress();
		personalDetails.addAddress(TienIch.taoRandomChu(10), TienIch.taoRandomChu(9));

		if (personalDetails.isMessageUpdateSuccessDisplayed() == true) {
			setStatusTest("pass", "Updated successfully");
		} else {
			setStatusTest("fail", "Updated NOT successfully");
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
