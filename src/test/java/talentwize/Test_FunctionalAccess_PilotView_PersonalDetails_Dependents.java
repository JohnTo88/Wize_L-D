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

public class Test_FunctionalAccess_PilotView_PersonalDetails_Dependents extends TestManager {

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
	public void TT_1496() throws InterruptedException {
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
		UserRoleName = "Dependents | No permission" + TienIch.taoRandomSo(4);

		roles.createUserRoleNameWithRoleTypeAdmin(UserRoleName);

		TestLogger.info("+ UnChecked on ED Employee Data Permision - Personal Details - Dependents |Read");
		roles.uncheckbox_Read_ED_PersonalDetails_Dependents();

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

		TestLogger.info("User CANNOT see/do:\r\n" + "1.  Dependents block");

		if (personalDetails.isTableDependentsDisplayed() == false) {
			setStatusTest("pass", "User CANNOT see/do:\r\n" + "1.  Dependents block");

		} else {
			setStatusTest("fail", "User STILL CAN see/do:\r\n" + "1.  Dependents block");
		}

	}

	@Test(priority = 2)
	public void TT_1511() throws InterruptedException {
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
		UserRoleName = "Automation-Dependents-Create" + TienIch.taoRandomSo(3);

		roles.createUserRoleNameWithRoleTypeAdmin(UserRoleName);

		TestLogger.info("+ Checked on My Employee Data Permision -My Personal Details - Dependents | Create");
		roles.uncheckbox_Read_ED_PersonalDetails_Dependents();

		roles.checkbox_Create_ED_PersonalDetails_Dependents();

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

		if (personalDetails.isBlockDependentsDisplayed() == true
				&& personalDetails.isBtnAddDependentsDisplayed() == true
				&& personalDetails.isTableDependentsDisplayed() == true) {
			setStatusTest("pass", "User can see/do:\r\n" + "1. Personal Details menu\r\n" + "2. Dependents block\r\n"
					+ "3. dependents table\r\n" + "4. Add btn\r\n" + "");

		} else {
			setStatusTest("fail", "User can NOT see/do:\r\n" + "1. Personal Details menu\r\n"
					+ "2. Dependents block\r\n" + "3. dependents table\r\n" + "4. Add btn\r\n" + "");
		}

		personalDetails.clickButtonAddDependents();
		formAddDependents.addDepenents(TienIch.taoRandomChu(6));
		if (personalDetails.isMessageAddSuccessfullyDisplayed() == true) {
			setStatusTest("pass", "Added successfully");
		} else {
			setStatusTest("fail", "Added NOT successfully");
		}

	}

	@Test(priority = 3)
	public void TT_1499() throws InterruptedException {
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
		UserRoleName = "Automation-Dependents-Read" + TienIch.taoRandomSo(4);

		roles.createUserRoleNameWithRoleTypeAdmin(UserRoleName);

		TestLogger.info("+ Checked on My Employee Data Permision -My Personal Details - Dependents | Read");
		roles.uncheckbox_Read_ED_PersonalDetails_Dependents();

		roles.checkbox_Read_ED_PersonalDetails_Dependents();

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

		if (personalDetails.isBlockDependentsDisplayed() == true
				&& personalDetails.isTableDependentsDisplayed() == true) {
			setStatusTest("pass", "User can see/do:\r\n" + "1. Personal Details menu\r\n" + "2. Dependents block\r\n"
					+ "3. dependents table\r\n" + "" + "");

		} else {
			setStatusTest("fail", "User can NOT see/do:\r\n" + "1. Personal Details menu\r\n"
					+ "2. Dependents block\r\n" + "3. dependents table\r\n" + "" + "");
		}

		if (personalDetails.isBtnAddDependentsDisplayed() == false
				&& personalDetails.isIconDeleteDependentsDisplayed() == false
				&& personalDetails.isNumberHyperlinkDependentsDisplayed() == false) {
			setStatusTest("pass", "User CANNOT see/do:\r\n" + "1.  Add btn\r\n" + "2. Delete btn\r\n"
					+ "3. Name dependents hyperlink");
		} else {
			setStatusTest("fail", "User STILL CAN see/do:\r\n" + "1.  Add btn\r\n" + "2. Delete btn\r\n"
					+ "3. Name dependents hyperlink");
		}

	}

	@Test(priority = 4)
	public void TT_1508() throws InterruptedException {
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
		UserRoleName = "Automation-Dependents-Read" + TienIch.taoRandomSo(4);

		roles.createUserRoleNameWithRoleTypeAdmin(UserRoleName);

		TestLogger.info("+ Checked on ED Employee Data Permision -My Personal Details - Dependents |Update");
		roles.uncheckbox_Read_ED_PersonalDetails_Dependents();

		roles.checkbox_Update_ED_PersonalDetails_Dependents();

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

		TestLogger.info("User can see/do:\r\n" + "1. Personal Details menu\r\n" + "2. Dependents block\r\n"
				+ "3. dependents table\r\n" + "4. Name dependents hyperlink");

		if (personalDetails.isBlockDependentsDisplayed() == true && personalDetails.isTableDependentsDisplayed() == true
				&& personalDetails.isNumberHyperlinkDependentsDisplayed() == true) {
			setStatusTest("pass", "User can see/do:\r\n" + "1. Personal Details menu\r\n" + "2. Dependents block\r\n"
					+ "3. dependents table\r\n" + "4. Name dependents hyperlink" + "");

		} else {
			setStatusTest("fail", "User can NOT see/do:\r\n" + "1. Personal Details menu\r\n"
					+ "2. Dependents block\r\n" + "3. dependents table\r\n" + "4. Name dependents hyperlink" + "");
		}

		if (personalDetails.isBtnAddDependentsDisplayed() == false
				&& personalDetails.isIconDeleteDependentsDisplayed() == false) {
			setStatusTest("pass", "User CANNOT see/do:\r\n" + "1.  Add btn\r\n" + "2. Delete btn\r\n" + "");
		} else {
			setStatusTest("fail", "User STILL CAN see/do:\r\n" + "1.  Add btn\r\n" + "2. Delete btn\r\n" + "");
		}

		TestLogger.info("Click Name dependents hyperlink >> update data >> save ");
		personalDetails.clickOnFistHyperlinkDependents();
		formAddDependents.clickButonSave();
		if (personalDetails.isMessageUpdateSuccessDisplayed() == true) {
			setStatusTest("pass", "Updated successfully");
		} else {
			setStatusTest("fail", " DOES NOT SHOW : Updated successfully");
		}
	}

	@Test(priority = 5)
	public void TT_1507() throws InterruptedException {
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
		UserRoleName = "Automation-Dependents-Read" + TienIch.taoRandomSo(4);

		roles.createUserRoleNameWithRoleTypeAdmin(UserRoleName);

		TestLogger.info("+ Checked on ED Employee Data Permision -My Personal Details - Dependents |Delete");
		roles.uncheckbox_Read_ED_PersonalDetails_Dependents();

		roles.checkbox_Delete_ED_PersonalDetails_Dependent();

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

		TestLogger.info("User can see/do:\r\n" + "1. Personal Details menu\r\n" + "2. Dependents block\r\n"
				+ "3. dependents table\r\n" + "4. Delete btn");

		if (personalDetails.isBlockDependentsDisplayed() == true && personalDetails.isTableDependentsDisplayed() == true
				&& personalDetails.isIconDeleteDependentsDisplayed() == true) {
			setStatusTest("pass", "User can see/do:\r\n" + "1. Personal Details menu\r\n" + "2. Dependents block\r\n"
					+ "3. dependents table\r\n" + "4. Delete btn" + "");

		} else {
			setStatusTest("fail", "User can NOT see/do:\r\n" + "1. Personal Details menu\r\n"
					+ "2. Dependents block\r\n" + "3. dependents table\r\n" + "4. Delete btn" + "");
		}

		if (personalDetails.isNumberHyperlinkDependentsDisplayed() == false
				&& personalDetails.isBtnAddDependentsDisplayed() == false) {
			setStatusTest("pass", "User CANNOT see/do:\r\n" + "1.  Name dependents hyperlink\r\n" + "2. Add btn");
		} else {
			setStatusTest("fail", "User STILL CAN see/do:\r\n" + "1.  Name dependents hyperlink\r\n" + "2. Add btn");
		}

		TestLogger.info("Check any record >> click delete btn >> click \"Yes\" btn");
		personalDetails.deleteDependents();
		if (personalDetails.isMessageDeletedSuccessfullyDisplayed() == true) {
			setStatusTest("pass", "Deleted successfully");
		} else {
			setStatusTest("fail", "Deleted NOT successfully");
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
