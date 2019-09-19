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
import talentwize.pages.CompanyJobHistory;
import talentwize.pages.Dashboard;
import talentwize.pages.EmployeeList;
import talentwize.pages.Form_EditContractType;
import talentwize.pages.Form_EditCurrentPosition;
import talentwize.pages.Form_EditNewPosition;
import talentwize.pages.Form_EditPreviousPosition;
import talentwize.pages.HomePage;
import talentwize.pages.Roles;
import talentwize.pages.Users;

// BUG : http://10.17.14.203:8080/browse/TAL-536 
public class Test_FunctionalAccess_MyED_MyCompanyJobHistory extends TestManager {
	HomePage homePage;
	WebDriver driver;
	PropertyManager propertyManager;
	Dashboard dashboard;
	Administration administration;
	Users users;
	Roles roles;
	String UserRoleName;
	EmployeeList employeeList;
	CompanyJobHistory companyJobHistory;
	Form_EditContractType editContractType;
	Form_EditPreviousPosition editPreviousPosition;
	Form_EditCurrentPosition editCurrentPosition;
	Form_EditNewPosition editNewPosition;

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
		companyJobHistory = new CompanyJobHistory(driver);
		homePage.moLinkWeb(propertyManager.getURL_TalentWize());
		editContractType = new Form_EditContractType(driver);
		editPreviousPosition = new Form_EditPreviousPosition(driver);
		editCurrentPosition = new Form_EditCurrentPosition(driver);
		editNewPosition = new Form_EditNewPosition(driver);

	}

	@BeforeMethod
	public void PrintNameTestCase(Method method) {
		TestLogger.info("====== Begin Testcase : " + method.getName() + " ========");
	}

	@Test(priority = 1)
	public void TT_1482() throws InterruptedException {
		TestLogger.info("=================TT_1482=====================");
		TestLogger.info("1. Login with Administrator account.");
		homePage.SignInWith(propertyManager.getEmailAdmin1(), propertyManager.getPasswordAdmin1());
		if (dashboard.isDashboardMenuDisplayed() == true) {
			setStatusTest("pass", "Dang Nhap Thanh Cong");
		} else {
			setStatusTest("fail", "Dang Nhap khong Thanh Cong");
		}
		TestLogger.info("2. Go to Administration - User Management - Roles tab");
		administration.clickMenuAdministration();
		administration.clickMenuUserManagement();
		administration.openRolesTab();

		TestLogger.info("3. Create Automation User Role Name and Role Type is Admin :");
		UserRoleName = "MyED-MyCompanyJobHistory|NoPermission" + TienIch.taoRandomSo(3);

		roles.createUserRoleNameWithRoleTypeAdmin(UserRoleName);

		TestLogger.info("+ + Unchecked on My Company Job History | Read");

		roles.uncheckbox_Read_My_CompanyJobHisoty();

		TestLogger.info("5. Click Save button");
		roles.clickButtonSave();

		administration.openTabUsers();

		TestLogger.info("Assign role " + UserRoleName + " to employee : " + propertyManager.getEmailUserTW1());
		users.searchUsername(propertyManager.getEmailUserTW1());

		// Assign role Automation to this employee
		users.assignUserWithNewRole(propertyManager.getEmailUserTW1(), UserRoleName);

		TestLogger.info("6. Log out");

		dashboard.logout();

		TestLogger.info("7. Login with test account : " + propertyManager.getEmailUserTW1());

		homePage.SignInWith(propertyManager.getEmailUserTW1(), propertyManager.getPasswordUserTW1());

		TestLogger.info("8.Open Employee Data menu");

		administration.clickMenuEmployeeData();

		if (administration.isSubMenuCompanyJobHistoryDisplayed() == false) {
			setStatusTest("pass", "User CANNOT see/do:\r\n" + "1. Company Job History menu");
		} else {
			setStatusTest("fail", "User STILL see/do:\r\n" + "1. Company Job History menu");
		}
		TestLogger.info("=================End TT_1482=====================");
	}

	@Test(priority = 3)
	public void TT_1474() throws InterruptedException {
		TestLogger.info("=================TT_1474=====================");
		TestLogger.info("1. Login with Administrator account.");
		homePage.SignInWith(propertyManager.getEmailAdmin1(), propertyManager.getPasswordAdmin1());

		if (dashboard.isDashboardMenuDisplayed() == true) {
			setStatusTest("pass", "Dang Nhap Thanh Cong");
		} else {
			setStatusTest("fail", "Dang Nhap khong Thanh Cong");
		}

		TestLogger.info("2. Go to Administration - User Management - Roles tab");
		administration.clickMenuAdministration();
		administration.clickMenuUserManagement();
		administration.openRolesTab();

		TestLogger.info("3. Create Automation User Role Name and Role Type is Admin :");
		UserRoleName = "My ED|My Company Job History|Read" + TienIch.taoRandomSo(3);

		roles.createUserRoleNameWithRoleTypeAdmin(UserRoleName);
		TestLogger.info("4. Check on My Company Job History | Read");
		roles.uncheckbox_Read_My_CompanyJobHisoty();
		roles.checkbox_Read_My_CompanyJobHisoty();

		TestLogger.info("5. Click Save button");
		roles.clickButtonSave();

		administration.openTabUsers();

		TestLogger.info("Assign role " + UserRoleName + " to employee : " + propertyManager.getEmailUserTW1());
		users.searchUsername(propertyManager.getEmailUserTW1());

		// Assign role Automation to this employee
		users.assignUserWithNewRole(propertyManager.getEmailUserTW1(), UserRoleName);

		TestLogger.info("6. Log out");

		dashboard.logout();

		TestLogger.info("7. Login with test account : " + propertyManager.getEmailUserTW1());

		homePage.SignInWith(propertyManager.getEmailUserTW1(), propertyManager.getPasswordUserTW1());
		TestLogger.info("8.Open Employee Data menu");

		administration.clickMenuEmployeeData();

		administration.scrollToSubMenuCompanyJobHistory();
		if (administration.isSubMenuCompanyJobHistoryDisplayed() == true) {
			setStatusTest("pass", "User CAN see/do:\r\n" + "1. Company Job History menu");
		} else {
			setStatusTest("fail", "User Can not see/do:\r\n" + "1. Company Job History menu");
		}
		TestLogger.info("Click on Company Job History");
		administration.clickSubMenuCompanyJobHistory();
		if (companyJobHistory.islblCompanyJobHistoryDisplayed() == true
				&& companyJobHistory.isbtnAddPreviousPositionDisplayed() == false
				&& companyJobHistory.isbtnAddDisplayed() == false
				&& companyJobHistory.isbtnAddNewPositionDisplayed() == false
				&& companyJobHistory.isbtnDeleteNewPositionDisplayed() == false
				&& companyJobHistory.isbtnDeletePreviousPositionDisplayed() == false) {
			setStatusTest("pass",
					"User can see /do:\r\n" + "1. Company Job history menu\r\n" + "\r\n" + "\r\n"
							+ "User CANNOT see/do:\r\n" + "1. in Position Detail panel:\r\n"
							+ "+ Add new position btn\r\n" + "+ Edit btn\r\n" + "2. In Previous Position panel:\r\n"
							+ "+ Add Previous Position btn\r\n" + "+ Edit btn with each record\r\n" + "+ Delete btn\r\n"
							+ "3. In Contract Type panel\r\n" + "+ Add btn\r\n" + "+ Delete btn\r\n" + "\r\n" + "");
		} else {
			setStatusTest("fail",
					"User can NOT see /do:\r\n" + "1. Company Job history menu\r\n" + "\r\n" + "\r\n"
							+ "User Still see/do:\r\n" + "1. in Position Detail panel:\r\n"
							+ "+ Add new position btn\r\n" + "+ Edit btn\r\n" + "2. In Previous Position panel:\r\n"
							+ "+ Add Previous Position btn\r\n" + "+ Edit btn with each record\r\n" + "+ Delete btn\r\n"
							+ "3. In Contract Type panel\r\n" + "+ Add btn\r\n" + "+ Delete btn\r\n" + "\r\n" + "");
		}
		TestLogger.info("=================TT_651=====================");
	}

	@Test(priority = 2)
	public void TT_1468() throws InterruptedException {
		TestLogger.info("=================TT_1468=====================");
		TestLogger.info("1. Login with Administrator account.");
		homePage.SignInWith(propertyManager.getEmailAdmin1(), propertyManager.getPasswordAdmin1());

		if (dashboard.isDashboardMenuDisplayed() == true) {
			setStatusTest("pass", "Dang Nhap Thanh Cong");
		} else {
			setStatusTest("fail", "Dang Nhap khong Thanh Cong");
		}

		TestLogger.info("2. Go to Administration - User Management - Roles tab");
		administration.clickMenuAdministration();
		administration.clickMenuUserManagement();
		administration.openRolesTab();

		TestLogger.info("3. Create Automation User Role Name and Role Type is Admin :");
		UserRoleName = "My ED|My Company Job History|Create" + TienIch.taoRandomSo(3);

		roles.createUserRoleNameWithRoleTypeAdmin(UserRoleName);

		TestLogger.info("+ Check on My Company Job History | Read\r\n" + "+ Check on My Company Job History | Create");
		roles.uncheckbox_Read_My_CompanyJobHisoty();
		roles.checkbox_Create_My_CompanyJobHistory();

		TestLogger.info("5. Click Save button");
		roles.clickButtonSave();

		administration.openTabUsers();

		TestLogger.info("Assign role " + UserRoleName + " to employee : " + propertyManager.getEmailUserTW1());
		users.searchUsername(propertyManager.getEmailUserTW1());

		// Assign role Automation to this employee
		users.assignUserWithNewRole(propertyManager.getEmailUserTW1(), UserRoleName);

		TestLogger.info("6. Log out");

		dashboard.logout();

		TestLogger.info("7. Login with test account : " + propertyManager.getEmailUserTW1());

		homePage.SignInWith(propertyManager.getEmailUserTW1(), propertyManager.getPasswordUserTW1());

		TestLogger.info("8.Open Employee Data menu");

		administration.clickMenuEmployeeData();
		administration.scrollToSubMenuCompanyJobHistory();

		if (administration.isSubMenuCompanyJobHistoryDisplayed() == true) {
			setStatusTest("pass", "User CAN see/do:\r\n" + "1. Company Job History menu");
		} else {
			setStatusTest("fail", "User Can not see/do:\r\n" + "1. Company Job History menu");
		}
		TestLogger.info("Click on Company Job History");
		administration.clickSubMenuCompanyJobHistory();

		if (companyJobHistory.islblCompanyJobHistoryDisplayed() == true
				&& companyJobHistory.isbtnAddPreviousPositionDisplayed() == true
				&& companyJobHistory.isbtnHelpDisplayed() == true && companyJobHistory.isbtnAddDisplayed() == true
				&& companyJobHistory.isbtnAddNewPositionDisplayed() == true
				&& companyJobHistory.isbtnEditCurrentPositionDisplayed() == true
				&& companyJobHistory.isbtnEditNewPositionDisplayed() == false
				&& companyJobHistory.isbtnEditPreviousPositionDisplayed() == false
				&& companyJobHistory.isbtnDeleteNewPositionDisplayed() == false
				&& companyJobHistory.isbtnDeletePreviousPositionDisplayed() == false) {
			setStatusTest("pass",
					"User can see /do:\r\n" + "1. Company Job history menu\r\n" + "2. in Position Detail panel:\r\n"
							+ "  + Add new position btn\r\n" + "  + Edit btn in Current area\r\n"
							+ "3. In Previous Position panel:\r\n" + "   + Add Previous Position btnrecord\r\n"
							+ "4. In Contract Type panel\r\n" + " + Add btn\r\n" + "\r\n" + "User CANNOT see/do:\r\n"
							+ "1. in Position Detail panel:\r\n" + "  + Edit btn in New area\r\n"
							+ "3. In Previous Position panel:\r\n" + "   + Edit btn with each record\r\n"
							+ "   + Delete btn\r\n" + "4. In Contract Type panel\r\n"
							+ "   + Contract Type hyperlink\r\n" + " + Delete btn3");
		} else {
			setStatusTest("fail",
					"User can see /do:\r\n" + "1. Company Job history menu\r\n" + "2. in Position Detail panel:\r\n"
							+ "  + Add new position btn\r\n" + "  + Edit btn in Current area\r\n"
							+ "3. In Previous Position panel:\r\n" + "   + Add Previous Position btnrecord\r\n"
							+ "4. In Contract Type panel\r\n" + " + Add btn\r\n" + "\r\n" + "User CANNOT see/do:\r\n"
							+ "1. in Position Detail panel:\r\n" + "  + Edit btn in New area\r\n"
							+ "3. In Previous Position panel:\r\n" + "   + Edit btn with each record\r\n"
							+ "   + Delete btn\r\n" + "4. In Contract Type panel\r\n"
							+ "   + Contract Type hyperlink\r\n" + " + Delete btn3");
		}
		TestLogger.info("=================TT_1468=====================");
	}

	@Test(priority = 4)
	public void TT_1502() throws InterruptedException {
		TestLogger.info("=================TT_1502=====================");
		TestLogger.info("1. Login with Administrator account.");
		homePage.SignInWith(propertyManager.getEmailAdmin1(), propertyManager.getPasswordAdmin1());

		if (dashboard.isDashboardMenuDisplayed() == true) {
			setStatusTest("pass", "Dang Nhap Thanh Cong");
		} else {
			setStatusTest("fail", "Dang Nhap khong Thanh Cong");
		}

		TestLogger.info("2. Go to Administration - User Management - Roles tab");
		administration.clickMenuAdministration();
		administration.clickMenuUserManagement();
		administration.openRolesTab();

		TestLogger.info("3. Create Automation User Role Name and Role Type is Admin :");
		UserRoleName = "My ED|My Company Job History|Update" + TienIch.taoRandomSo(3);

		roles.createUserRoleNameWithRoleTypeAdmin(UserRoleName);

		TestLogger.info("+ Check on My Company Job History | Read\r\n" + "+ Check on My Company Job History | Update");

		roles.uncheckbox_Read_My_CompanyJobHisoty();
		TestLogger.info("4.Check on My-Company Job History | Update");
		roles.checkbox_Update_My_CompanyJobHistory();

		TestLogger.info("5. Click Save button");
		roles.clickButtonSave();

		administration.openTabUsers();

		TestLogger.info("Assign role " + UserRoleName + " to employee : " + propertyManager.getEmailUserTW1());
		users.searchUsername(propertyManager.getEmailUserTW1());

		// Assign role Automation to this employee
		users.assignUserWithNewRole(propertyManager.getEmailUserTW1(), UserRoleName);

		TestLogger.info("6. Log out");

		dashboard.logout();

		TestLogger.info("7. Login with test account : " + propertyManager.getEmailUserTW1());

		homePage.SignInWith(propertyManager.getEmailUserTW1(), propertyManager.getPasswordUserTW1());
		TestLogger.info("8.Open Employee Data menu");

		administration.clickMenuEmployeeData();
		administration.scrollToSubMenuCompanyJobHistory();

		if (administration.isSubMenuCompanyJobHistoryDisplayed() == true) {
			setStatusTest("pass", "User CAN see/do:\r\n" + "1. Company Job History menu");
		} else {
			setStatusTest("fail", "User Can not see/do:\r\n" + "1. Company Job History menu");
		}
		TestLogger.info("Click on Company Job History");
		administration.clickSubMenuCompanyJobHistory();

		if (companyJobHistory.islblCompanyJobHistoryDisplayed() == true
				&& companyJobHistory.isbtnAddPreviousPositionDisplayed() == false
				&& companyJobHistory.isbtnAddDisplayed() == false
				&& companyJobHistory.isbtnAddNewPositionDisplayed() == false
				&& companyJobHistory.isbtnDeleteNewPositionDisplayed() == false
				&& companyJobHistory.isbtnDeletePreviousPositionDisplayed() == false
				&& companyJobHistory.isbtnEditPreviousPositionDisplayed() == true
				&& companyJobHistory.isbtnEditCurrentPositionDisplayed() == true
				&& companyJobHistory.isbtnEditNewPositionDisplayed() == true
				&& companyJobHistory.ishplContractTypeDisplayed() == true) {
			setStatusTest("pass",
					"User can see /do:\r\n" + "1. Company Job history menu\r\n" + "2. in Position Detail panel:\r\n"
							+ "  + Edit btn in Current area\r\n" + "  + Edit btn in New area\r\n"
							+ "3. In Previous Position panel:\r\n" + "   + Edit btn with each record\r\n"
							+ "4. In Contract Type panel\r\n" + " + Contract Type Hyperlink\r\n" + "\r\n"
							+ "User CANNOT see/do:\r\n" + "1. in Position Detail panel:\r\n"
							+ "  + Add new position btn\r\n" + "2. In Previous Position panel:\r\n"
							+ "   + Add Previous Position btn\r\n" + "   + Delete btn\r\n"
							+ "3. In Contract Type panel\r\n" + " + Add btn\r\n" + " + Delete btn");
		} else {
			setStatusTest("fail",
					"User CAN NOT see /do:\r\n" + "1. Company Job history menu\r\n" + "2. in Position Detail panel:\r\n"
							+ "  + Edit btn in Current area\r\n" + "  + Edit btn in New area\r\n"
							+ "3. In Previous Position panel:\r\n" + "   + Edit btn with each record\r\n"
							+ "4. In Contract Type panel\r\n" + " + Contract Type Hyperlink\r\n" + "\r\n"
							+ "User Still see/do:\r\n" + "1. in Position Detail panel:\r\n"
							+ "  + Add new position btn\r\n" + "2. In Previous Position panel:\r\n"
							+ "   + Add Previous Position btn\r\n" + "   + Delete btn\r\n"
							+ "3. In Contract Type panel\r\n" + " + Add btn\r\n" + " + Delete btn");
		}
		// =========Edit Contract type================
		TestLogger.info("Click on Contract type Name");
		companyJobHistory.clickhplContractType();
		editContractType.clickButtonSave();
		if (companyJobHistory.ismsgUpdateContractTypeDisplayed() == true) {
			setStatusTest("pass", "User CAN see/do:\r\n message: Update contract type");
		} else {
			setStatusTest("fail", "User Can NOT see/do:\r\n message: Update contract type");
		}
		// =========Edit Previous Position===============
		TestLogger.info("Click Edit button");
		companyJobHistory.clickbtnEditPreviousPosition();
		editPreviousPosition.clickButtonSave();
		if (companyJobHistory.ismsgUpdatePreviousPositionDisplayed() == true) {
			setStatusTest("pass", "User CAN see/do:\r\n message: Update Previous Position");
		} else {
			setStatusTest("fail", "User Can NOT see/do:\r\n message: Update Previous Position");
		}
		// =========Edit Current Position===============
		TestLogger.info("Click Edit button");
		companyJobHistory.clickbtnEditCurrentPosition();
		editCurrentPosition.clickButtonSave();
		if (companyJobHistory.ismsgUpdateCurrrentPositionDisplayed() == true) {
			setStatusTest("pass", "User CAN see/do:\r\n message: Update Current Position");
		} else {
			setStatusTest("fail", "User Can NOT see/do:\r\n message: Update Current Position");
		}
		// =========Edit New Position===============
		TestLogger.info("Click Edit button");
		companyJobHistory.clickbtnEditNewPosition();
		editNewPosition.clickButtonSave();
		if (companyJobHistory.ismsgUpdateNewPositionDisplayed() == true) {
			setStatusTest("pass", "User CAN see/do:\r\n message: Update New Position");
		} else {
			setStatusTest("fail", "User Can NOT see/do:\r\n message: Update New Position");
		}
		TestLogger.info("=================TT_1502=====================");
	}

	@Test(priority = 5)
	public void TT_1501() throws InterruptedException {
		TestLogger.info("=================TT_1501=====================");
		TestLogger.info("1. Login with Administrator account.");
		homePage.SignInWith(propertyManager.getEmailAdmin1(), propertyManager.getPasswordAdmin1());

		if (dashboard.isDashboardMenuDisplayed() == true) {
			setStatusTest("pass", "Dang Nhap Thanh Cong");
		} else {
			setStatusTest("fail", "Dang Nhap khong Thanh Cong");
		}

		TestLogger.info("2. Go to Administration - User Management - Roles tab");
		administration.clickMenuAdministration();
		administration.clickMenuUserManagement();
		administration.openRolesTab();

		TestLogger.info("3. Create Automation User Role Name and Role Type is Admin :");
		UserRoleName = "My ED|My Company Job History|Delete" + TienIch.taoRandomSo(3);

		roles.createUserRoleNameWithRoleTypeAdmin(UserRoleName);
		TestLogger.info("+ Check on My Company Job History | Read\r\n" + "+ Check on My Company Job History | Delete");
		roles.uncheckbox_Read_My_CompanyJobHisoty();
		TestLogger.info("4. Check on My-Company Job History | Delete");
		roles.checkbox_Delete_My_CompanyJobHistory();

		TestLogger.info("5. Click Save button");
		roles.clickButtonSave();

		administration.openTabUsers();

		TestLogger.info("Assign role " + UserRoleName + " to employee : " + propertyManager.getEmailUserTW1());
		users.searchUsername(propertyManager.getEmailUserTW1());

		// Assign role Automation to this employee
		users.assignUserWithNewRole(propertyManager.getEmailUserTW1(), UserRoleName);

		TestLogger.info("6. Log out");

		dashboard.logout();

		TestLogger.info("7. Login with test account : " + propertyManager.getEmailUserTW1());

		homePage.SignInWith(propertyManager.getEmailUserTW1(), propertyManager.getPasswordUserTW1());
		TestLogger.info("8. Open Employee Data menu");
		administration.clickMenuEmployeeData();

		administration.scrollToSubMenuCompanyJobHistory();

		if (administration.isSubMenuCompanyJobHistoryDisplayed() == true) {
			setStatusTest("pass", "User CAN see/do:\r\n" + "1. Company Job History menu");
		} else {
			setStatusTest("fail", "User Can not see/do:\r\n" + "1. Company Job History menu");
		}
		TestLogger.info("Click on Company Job History");
		administration.clickSubMenuCompanyJobHistory();
		if (companyJobHistory.islblCompanyJobHistoryDisplayed() == true
				&& companyJobHistory.isbtnAddPreviousPositionDisplayed() == false
				&& companyJobHistory.isbtnAddDisplayed() == false
				&& companyJobHistory.isbtnAddNewPositionDisplayed() == false
				&& companyJobHistory.isbtnDeleteNewPositionDisplayed() == true
				&& companyJobHistory.isbtnDeletePreviousPositionDisplayed() == true
				&& companyJobHistory.isbtnEditPreviousPositionDisplayed() == false
				&& companyJobHistory.isbtnEditCurrentPositionDisplayed() == false
				&& companyJobHistory.isbtnEditNewPositionDisplayed() == false
				&& companyJobHistory.ishplContractTypeDisplayed() == false) {
			setStatusTest("pass",
					"User can see /do:\r\n" + "1. Company Job history menu\r\n" + "2. In Previous Position panel:\r\n"
							+ "   + Delete btn\r\n" + "3. In Contract Type panel\r\n" + " + Delete btn\r\n" + "\r\n"
							+ "User CANNOT see/do:\r\n" + "1. in Position Detail panel:\r\n"
							+ "  + Add new position btn\r\n" + "  + Edit btn\r\n" + "2. In Previous Position panel:\r\n"
							+ "   + Add Previous Position btn\r\n" + "   + Edit btn with each record\r\n"
							+ "3. In Contract Type panel\r\n" + " + Add btn\r\n" + " + Contract Type hyperlink ");
		} else {
			setStatusTest("fail", "User CANNOT see /do:\r\n" + "1. Company Job history menu\r\n"
					+ "2. In Previous Position panel:\r\n" + "   + Delete btn\r\n" + "3. In Contract Type panel\r\n"
					+ " + Delete btn\r\n" + "\r\n" + "User still see/do:\r\n" + "1. in Position Detail panel:\r\n"
					+ "  + Add new position btn\r\n" + "  + Edit btn\r\n" + "2. In Previous Position panel:\r\n"
					+ "   + Add Previous Position btn\r\n" + "   + Edit btn with each record\r\n"
					+ "3. In Contract Type panel\r\n" + " + Add btn\r\n" + " + Contract Type hyperlink");
		}
		TestLogger.info("=================TT_1501=====================");
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
