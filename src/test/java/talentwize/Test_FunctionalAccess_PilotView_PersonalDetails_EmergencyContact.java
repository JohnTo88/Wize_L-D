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
import talentwize.pages.Form_AddEmergencyContact;
import talentwize.pages.HomePage;
import talentwize.pages.PersonalDetails;
import talentwize.pages.Roles;
import talentwize.pages.Users;

public class Test_FunctionalAccess_PilotView_PersonalDetails_EmergencyContact extends TestManager {
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
	Form_AddEmergencyContact formAddEmergencyContact;

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
		formAddEmergencyContact = new Form_AddEmergencyContact(driver);

		homePage.moLinkWeb(propertyManager.getURL_TalentWize());

	}

	@BeforeMethod
	public void PrintNameTestCase(Method method) {
		TestLogger.info("====== Begin Testcase : " + method.getName() + " ========");
	}

	@Test(priority = 1)
	public void TT_1500() throws InterruptedException {
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
		UserRoleName = "Automation-Dependents-Create" + TienIch.taoRandomSo(4);

		roles.createUserRoleNameWithRoleTypeAdmin(UserRoleName);

		TestLogger.info("+UnCheck on ED - Personal Details - Emergency Contact | Read");
		roles.uncheckbox_Read_ED_PersonalDetails_Dependents();
		roles.uncheck_Read_ED_PersonalDetails_EmergencyContact();

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

		if (personalDetails.isTableEmergencyContactDisplayed() == false) {
			setStatusTest("pass", "User CANNOT see/do:\r\n" + "1.  Emergency Contact block");

		} else {
			setStatusTest("fail", "User STILL CAN see/do:\r\n" + "1.  Emergency Contact block");
		}

	}

	@Test(priority = 2)
	public void TT_1503() throws InterruptedException {
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
		UserRoleName = "Automation-Dependents-Create" + TienIch.taoRandomSo(4);

		roles.createUserRoleNameWithRoleTypeAdmin(UserRoleName);

		TestLogger.info("+ Checked on My Employee Data Permision -My Personal Details - Emergency Contact |Create");
		roles.uncheckbox_Read_ED_PersonalDetails_Dependents();
		roles.uncheck_Read_ED_PersonalDetails_EmergencyContact();
		roles.check_Create_ED_PersonalDetails_EmergencyContact();

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

		if (personalDetails.isTableEmergencyContactDisplayed() == true
				&& personalDetails.isBtnAddEmergencyContactsDisplayed() == true) {
			setStatusTest("pass", "User can see/do:\r\n" + "1. Personal Details menu\r\n"
					+ "2. Emergency Contact block \r\n" + "3. Add btn");

		} else {
			setStatusTest("fail", "User can NOT see/do:\r\n" + "" + "1. Personal Details menu\r\n"
					+ "2. Emergency Contact block \r\n" + "3. Add btn");
		}

		TestLogger.info("User CANNOT see/do:\r\n"
				+ "1.  name contact hyperlink and open edit Emergency contact pop up\r\n" + "2.  delete btn");

		personalDetails.clickButtonAddEmergencyContact();
		formAddEmergencyContact.addEmergencyContact(TienIch.taoRandomChu(8), TienIch.taoRandomChu(5),
				Form_AddEmergencyContact.MobilePhoneNumber);

		if (personalDetails.isMessageAddSuccessfullyDisplayed() == true) {
			setStatusTest("pass", "Msg \"Added successfully\"");
		} else {
			setStatusTest("fail", "DOES SHOW Msg \"Added successfully\"");
		}

		if (personalDetails.isNumberHyperlinkEmergencyContactDisplayed() == false) {
			setStatusTest("pass", "User CANNOT see/do:\r\n"
					+ "1.  name contact hyperlink and open edit Emergency contact pop up\r\n" + "2.  delete btn");
		} else {
			setStatusTest("fail", "User STIL CAN see/do:\r\n"
					+ "1.  name contact hyperlink and open edit Emergency contact pop up\r\n" + "2.  delete btn");
		}

	}

	@Test(priority = 3)
	public void TT_1506() throws InterruptedException {
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
		UserRoleName = "Automation-Dependents-Create" + TienIch.taoRandomSo(4);

		roles.createUserRoleNameWithRoleTypeAdmin(UserRoleName);

		TestLogger.info("+ Checked on My Employee Data Permision -My Personal Details - Emergency Contact |Read");
		roles.uncheckbox_Read_ED_PersonalDetails_Dependents();
		roles.uncheck_Read_ED_PersonalDetails_EmergencyContact();
		roles.check_Read_ED_PersonalDetails_EmergencyContact();

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

		if (personalDetails.isTableEmergencyContactDisplayed() == true) {
			setStatusTest("pass",
					"User can see/do:\r\n" + "1. Personal Details menu\r\n" + "2. Emergency Contact block \r\n" + "");

		} else {
			setStatusTest("fail",
					"User can NOT see/do:\r\n" + "" + "1. Personal Details menu\r\n" + "2. Emergency Contact block");
		}

		TestLogger.info("User CANNOT see/do:\r\n" + "1. Edit btn \r\n" + "2. create btn\r\n" + "3. delete btn\r\n"
				+ "4. name contact hyperlink");

		if (personalDetails.isNumberHyperlinkEmergencyContactDisplayed() == false
				&& personalDetails.isBtnAddEmergencyContactsDisplayed() == false) {
			setStatusTest("pass", "User CANNOT see/do:\\r\\n\" + \r\n" + "				\"1. Edit btn \\r\\n\" + \r\n"
					+ "				\"2. create btn\\r\\n\" + \r\n" + "				\"3. delete btn\\r\\n\" + \r\n"
					+ "				\"4. name contact hyperlink");
		} else {
			setStatusTest("fail", "User STILL CAN see/do:\\r\\n\" + \r\n"
					+ "				\"1. Edit btn \\r\\n\" + \r\n" + "				\"2. create btn\\r\\n\" + \r\n"
					+ "				\"3. delete btn\\r\\n\" + \r\n" + "				\"4. name contact hyperlink");
		}

	}

	@Test(priority = 4)
	public void TT_1510() throws InterruptedException {
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
		UserRoleName = "Pilot View|Personal Details|Emergency|Update" + TienIch.taoRandomSo(3);

		roles.createUserRoleNameWithRoleTypeAdmin(UserRoleName);

		TestLogger.info("+ Checked on My Employee Data Permision -My Personal Details - Emergency Contact |Update");
		roles.uncheckbox_Read_ED_PersonalDetails_Dependents();
		roles.uncheck_Read_ED_PersonalDetails_EmergencyContact();
		roles.check_Update_ED_PersonalDetails_EmergencyContact();

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
		administration.scrollToBottomPage();

		if (personalDetails.isTableEmergencyContactDisplayed() == true
				&& personalDetails.isNumberHyperlinkEmergencyContactDisplayed() == true) {
			setStatusTest("pass",
					"User can see/do:\r\n" + "1. Personal Details menu\r\n" + "2. Emergency Contact block \r\n"
							+ "3.  name contact hyperlink and open edit Emergency contact pop up");

		} else {
			setStatusTest("fail",
					"User can NOT see/do:\r\n" + "1. Personal Details menu\r\n" + "2. Emergency Contact block \r\n"
							+ "3. name contact hyperlink and open edit Emergency contact pop up");
		}

		TestLogger.info("User CANNOT see/do:\r\n" + "1.  Add btn\r\n" + "2.  delete btn");

		if (personalDetails.isIconDeleteEmergencyContactDisplayed() == false
				&& personalDetails.isBtnAddEmergencyContactsDisplayed() == false) {
			setStatusTest("pass", "User CANNOT see/do:\r\n" + "1.  Add btn\r\n" + "2.  delete btn\r\n" + "");
		} else {
			setStatusTest("fail", "User STILL CAN see/do:\r\n" + "1.  Add btn\r\n" + "2.  delete btn\r\n" + "");
		}

	}

	@Test(priority = 5)
	public void TT_1509() throws InterruptedException {
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
		UserRoleName = "Pilot View|Personal Details|Emergency|Delete" + TienIch.taoRandomSo(3);

		roles.createUserRoleNameWithRoleTypeAdmin(UserRoleName);

		TestLogger.info("+ Checked on My Employee Data Permision -My Personal Details - Emergency Contact |Update");
		roles.uncheckbox_Read_ED_PersonalDetails_Dependents();
		roles.uncheck_Read_ED_PersonalDetails_EmergencyContact();
		roles.check_Delete_ED_PersonalDetails_EmergencyContact();

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
		administration.scrollToBottomPage();

		if (personalDetails.isTableEmergencyContactDisplayed() == true
				&& personalDetails.isIconDeleteEmergencyContactDisplayed() == true) {
			setStatusTest("pass", "User can see/do:\r\n" + "1. Personal Details menu\r\n"
					+ "2. Emergency Contact block \r\n" + "3. delete btn");

		} else {
			setStatusTest("fail", "User can NOT see/do:\r\n" + "" + "1. Personal Details menu\r\n"
					+ "2. Emergency Contact block \r\n" + "3. delete btn");
		}

		TestLogger.info("User CANNOT see/do:\r\n"
				+ "1.  name contact hyperlink and open edit Emergency contact pop up\r\n" + "2.  Add btn");

		if (personalDetails.isNumberHyperlinkEmergencyContactDisplayed() == false
				&& personalDetails.isBtnAddEmergencyContactsDisplayed() == false) {
			setStatusTest("pass", "User CANNOT see/do:\r\n"
					+ "1.  name contact hyperlink and open edit Emergency contact pop up\r\n" + "2.  Add btn");
		} else {
			setStatusTest("fail", "User STILL CAN see/do:\r\n"
					+ "1.  name contact hyperlink and open edit Emergency contact pop up\r\n" + "2.  Add btn");
		}

		personalDetails.deleteEmergencyContact();
		if (personalDetails.isMessageDeletedSuccessfullyDisplayed() == true) {
			setStatusTest("pass", "Msg \"Deleted successfully\"");
		} else {
			setStatusTest("fail", "DOES NOT SHOR Msg \"Deleted successfully\"");
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
