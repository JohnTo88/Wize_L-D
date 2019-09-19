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
import talentwize.pages.CompanyDetails;
import talentwize.pages.ContactDetails;
import talentwize.pages.Dashboard;
import talentwize.pages.EmployeeList;
import talentwize.pages.Employment;
import talentwize.pages.Form_AddInterviewHistory;
import talentwize.pages.Form_CreateNewEmployee;
import talentwize.pages.Form_EditInterviewHistory;
import talentwize.pages.HomePage;
import talentwize.pages.PersonalDetails;
import talentwize.pages.Roles;
import talentwize.pages.Users;

public class Test_FunctionalAccess_EmploymentListPermission extends TestManager {

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
	Employment employment;
	Form_AddInterviewHistory formAddInterviewHistory;
	Form_EditInterviewHistory formEditInterviewHistory;
	CompanyDetails companyDetails;
	Form_CreateNewEmployee formCreateNewEmployee;

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
		employment = new Employment(driver);
		formEditInterviewHistory = new Form_EditInterviewHistory(driver);
		formAddInterviewHistory = new Form_AddInterviewHistory(driver);
		companyDetails = new CompanyDetails(driver);
		formCreateNewEmployee = new Form_CreateNewEmployee(driver);

		homePage.moLinkWeb(propertyManager.getURL_TalentWize());

	}

	@BeforeMethod
	public void PrintNameTestCase(Method method) {
		TestLogger.info("====== Begin Testcase : " + method.getName() + " ========");
	}

	// Bug : TAL-513
	@Test(priority = 1)
	public void TT_1235() throws InterruptedException {

		TestLogger.info("============= TT-1235 =================");
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
		UserRoleName = "Automation-ED-Employment_No_permission" + TienIch.taoRandomSo(4);

		roles.createUserRoleNameWithRoleTypeAdmin(UserRoleName);

		TestLogger.info("Unchecked all Employee List Permissions");

		roles.uncheck_View_Employees();

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
		TestLogger.info("Expect : User CANNOT see/do:\r\n" + "1. Menu Employee List");

		if (administration.isMenuEmployeeListDisplayed() == false) {
			setStatusTest("pass", "User CANNOT see/do:\r\n" + "1. Menu Employee List");
		} else {
			setStatusTest("fail", "User STILL CAN see/do:\r\n" + "1. Menu Employee List");
		}
		TestLogger.info("============= END TT-1235 =================");
	}

	@Test(priority = 2)
	public void TT_1222() throws InterruptedException {

		TestLogger.info("============= TT-1222 =================");
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
		UserRoleName = "Automation-ED-Employment_No_permission" + TienIch.taoRandomSo(4);

		roles.createUserRoleNameWithRoleTypeAdmin(UserRoleName);

		TestLogger.info("Unchecked all Employee List Permissions");

		roles.uncheck_View_Employees();
		TestLogger.info("+ Check on \r\n" + " Employee List Permission | View Employees");
		roles.check_View_Employees();
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
		TestLogger.info("8.Open Employee List");
		administration.clickMenuEmployeeList();
		TestLogger.info("Expect : User cannot see/do:\r\n" + "1. Import data button\r\n"
				+ "2. Create Employee button\r\n" + "3. Delete function\r\n" + "4. Click on employee's site");
		if (employeeList.isBtnImportDataDisplayed() == false && employeeList.isBtnCreateEmployeeDisplayed() == false
				&& employeeList.isBtnIconDeleteDisplayed() == false
				&& employeeList.isLinkslOfSiteNameClickable() == false) {
			setStatusTest("pass", "User cannot see/do:\r\n" + "1. Import data button\r\n"
					+ "2. Create Employee button\r\n" + "3. Delete function\r\n" + "4. Click on employee's site");

		} else {
			setStatusTest("fail", "User STILL can see/do:\r\n" + "1. Import data button\r\n"
					+ "2. Create Employee button\r\n" + "3. Delete function\r\n" + "4. Click on employee's site");
		}

		TestLogger.info("============= END TT-1222 =================");
	}

	@Test(priority = 3)
	public void TT_1228() throws InterruptedException {

		TestLogger.info("============= TT-1228 =================");
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
		UserRoleName = "Automation-ED-Employment_No_permission" + TienIch.taoRandomSo(4);

		roles.createUserRoleNameWithRoleTypeAdmin(UserRoleName);

		TestLogger.info("Unchecked all Employee List Permissions");

		roles.uncheck_View_Employees();
		TestLogger.info("+ Check on \r\n" + " Employee List Permission |Update Employees Information ");
		roles.check_Update_EmployeeInformation();

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
		TestLogger.info("8.Open Employee List");
		administration.clickMenuEmployeeList();
		TestLogger.info("Expect : User cannot see/do:\r\n" + "1. Import data button\r\n"
				+ "2. Create Employee button\r\n" + "3. Delete function");

		if (employeeList.isBtnImportDataDisplayed() == false && employeeList.isBtnCreateEmployeeDisplayed() == false
				&& employeeList.isBtnIconDeleteDisplayed() == false) {
			setStatusTest("pass", "User cannot see/do:\r\n" + "1. Import data button\r\n"
					+ "2. Create Employee button\r\n" + "3. Delete function");
		} else {
			setStatusTest("fail", "User STILL can see/do:\r\n" + "1. Import data button\r\n"
					+ "2. Create Employee button\r\n" + "3. Delete function");
		}

		TestLogger.info("Expect :User can see /do:\r\n" + "1. Data table\r\n" + "2. Clickable on employee's site\r\n"
				+ "3. Edit button");

		employeeList.searchEmployees(EmployeeList.NAME_OF_USER);
		employeeList.clickEmployeeNguyenVietNam();
		companyDetails.clickBtnEditGeneralInformation();
		companyDetails.clickBtnSaveGeneralInformation();

		if (companyDetails.isMsgUpdateSuccessDisplayed() == true) {
			setStatusTest("pass", "Displays msg \"Updated successfully\"");
		} else {
			setStatusTest("fail", "DOES NOT Display msg \"Updated successfully\"");
		}

		TestLogger.info("============= END TT-1228 =================");
	}

	@Test(priority = 4)
	public void TT_1232() throws InterruptedException {

		TestLogger.info("============= TT-1232 =================");
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
		UserRoleName = "Automation-ED-Employment_No_permission" + TienIch.taoRandomSo(4);

		roles.createUserRoleNameWithRoleTypeAdmin(UserRoleName);

		TestLogger.info("Unchecked all Employee List Permissions");

		roles.uncheck_View_Employees();
		TestLogger.info("+ Check on \r\n" + " Employee List Permission |Add Employees");
		roles.check_Add_Employees();
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
		TestLogger.info("8.Open Employee List");
		administration.clickMenuEmployeeList();
		TestLogger.info("Expect : User can see /do:\r\n" + "1. Data table\r\n" + "2. Import data button\r\n"
				+ "3. Create Employee button");
		if (employeeList.isBtnCreateEmployeeDisplayed() == true && employeeList.isBtnImportDataDisplayed() == true) {
			setStatusTest("pass", "User can see /do:\r\n" + "1. Data table\r\n" + "2. Import data button\r\n"
					+ "3. Create Employee button");
		} else {
			setStatusTest("fail", "User STILL can NOT see /do:\r\n" + "1. Data table\r\n" + "2. Import data button\r\n"
					+ "3. Create Employee button");
		}

		if (employeeList.isBtnIconDeleteDisplayed() == false && employeeList.isLinkslOfSiteNameClickable() == false) {
			setStatusTest("pass", "User cannot see/do:\r\n" + "1. Delete function\r\n" + "2. Click on employee's site");
		} else {
			setStatusTest("fail",
					"User STILL can see/do:\r\n" + "1. Delete function\r\n" + "2. Click on employee's site");
		}

		TestLogger.info(
				" Click on button \"Create Employee\"\r\n" + "3. Input data.\r\n" + "4. Click on button \"Create\"");

		employeeList.clickBtnCreate();

		formCreateNewEmployee.createNewEmployee(Form_CreateNewEmployee.FIST_NAME, Form_CreateNewEmployee.LAST_NAME,
				Form_CreateNewEmployee.ID_EMPLOYEEE);

		if (employeeList.isMsgCreateSuccessDisplayed() == true) {
			setStatusTest("pass", "Displays msg \"Employee has been created\"");
		} else {
			setStatusTest("fail", "DOES NOT Display msg \"Employee has been created\"");
		}

		TestLogger.info("============= END TT-1232 =================");
	}

	@Test(dependsOnMethods = "TT_1232")
	public void TT_1233() throws InterruptedException {

		TestLogger.info("============= TT-1233 =================");
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
		UserRoleName = "Automation-ED-Employment_No_permission" + TienIch.taoRandomSo(4);

		roles.createUserRoleNameWithRoleTypeAdmin(UserRoleName);

		TestLogger.info("Unchecked all Employee List Permissions");

		roles.uncheck_View_Employees();
		TestLogger.info("+ Check on \r\n" + " Employee List Permission |Delete Employees");
		roles.check_Delete_Employees();
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
		TestLogger.info("8.Open Employee List");
		administration.clickMenuEmployeeList();
		if (employeeList.isBtnIconDeleteDisplayed() == true) {
			setStatusTest("pass", "User can see /do:\r\n" + "1. Data table\r\n" + "2. Delete function");
		} else {
			setStatusTest("fail", "User can NOT see /do:\r\n" + "1. Data table\r\n" + "2. Delete function");
		}

		TestLogger.info("Expect : " + "User cannot see/do:\r\n" + "1. Import data button\r\n"
				+ "2. Create Employee button\r\n" + "3. Click on employee's site");

		if (employeeList.isBtnImportDataDisplayed() == false && employeeList.isBtnCreateEmployeeDisplayed() == false
				&& employeeList.isLinkslOfSiteNameClickable() == false) {
			setStatusTest("pass", "User cannot see/do:\r\n" + "1. Import data button\r\n"
					+ "2. Create Employee button\r\n" + "3. Click on employee's site");
		} else {
			setStatusTest("fail", "User STILL can see/do:\r\n" + "1. Import data button\r\n"
					+ "2. Create Employee button\r\n" + "3. Click on employee's site");
		}

		TestLogger.info("3. Check on a check box of an employee\r\n" + "4. Click on icon Delete.\r\n"
				+ "5. Click on button \"Yes\"");

		employeeList.deleteEmployee(Form_CreateNewEmployee.FIST_NAME + Form_CreateNewEmployee.LAST_NAME);

		if (employeeList.isMsgDeleteSuccessDisplayed() == true) {
			setStatusTest("pass", "Displays msg \"Deleted successfully!\"");
		} else {
			setStatusTest("fail", "DOES NOT Display msg \"Deleted successfully!\"");
		}

		TestLogger.info("============= END TT-1233 =================");
	}

	@Test(priority = 6)
	public void TT_1234() throws InterruptedException {

		TestLogger.info("============= TT-1234 =================");
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
		UserRoleName = "Terminate Employees" + TienIch.taoRandomSo(4);

		roles.createUserRoleNameWithRoleTypeAdmin(UserRoleName);

		TestLogger.info("Unchecked all Employee List Permissions");

		roles.uncheck_View_Employees();
		TestLogger.info("+ +Uncheck on Employee List Permission | View Employees\r\n"
				+ "+ Check on Employees Permission | ED - Terminate Employees");
		roles.check_Ed_TerminateEmployees();

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
		TestLogger.info("8.Open Employee List");
		administration.clickMenuEmployeeList();

		if (employeeList.isBtnIconDeleteDisplayed() == false && employeeList.isBtnImportDataDisplayed() == false
				&& employeeList.isBtnCreateEmployeeDisplayed() == false
				&& employeeList.isLinkslOfSiteNameClickable() == false) {
			setStatusTest("pass", "User cannot see/do:\r\n" + "1. Import data button\r\n"
					+ "2. Create Employee button\r\n" + "3. Click on employee's site\r\n" + "4. Delete function");
		} else {
			setStatusTest("fail", "User STILL can see/do:\r\n" + "1. Import data button\r\n"
					+ "2. Create Employee button\r\n" + "3. Click on employee's site\r\n" + "4. Delete function");
		}

		employeeList.clickFilterEmployeeStatus();
		employeeList.clickChooseTerminate();

		if (employeeList.isEmployeeStatusTerminatedDisplayed() == true) {
			setStatusTest("pass",
					"User can see /do:\r\n" + "1. Data table\r\n" + "2. Employee A with status Voluntary Terminated"
							+ "2 options: Terminated - Involuntary & Terminated - Voluntary");
		} else {
			setStatusTest("fail",
					"User can NOT see /do:\r\n" + "1. Data table\r\n" + "2. Employee A with status Voluntary Terminated"
							+ "2 options: Terminated - Involuntary & Terminated - Voluntary");
		}

		TestLogger.info("============= END TT-1234 =================");
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
