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
import talentwize.pages.Dashboard;
import talentwize.pages.EmployeeList;
import talentwize.pages.HomePage;
import talentwize.pages.Roles;
import talentwize.pages.Users;

public class Test_FunctionalAccess_PilotView_CompanyDetails_ReportTo extends TestManager {
	HomePage homePage;
	WebDriver driver;
	PropertyManager propertyManager;
	Dashboard dashboard;
	Administration administration;
	Users users;
	Roles roles;
	String UserRoleName;
	EmployeeList employeeList;
	CompanyDetails companyDetails;

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
		companyDetails = new CompanyDetails(driver);
		homePage.moLinkWeb(propertyManager.getURL_TalentWize());

	}

	@BeforeMethod
	public void PrintNameTestCase(Method method) {
		TestLogger.info("====== Begin Testcase : " + method.getName() + " ========");
	}

	@Test(priority = 1)
	public void TT_3618() throws InterruptedException {
		TestLogger.info("=================TT_3618 ====================");
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
		UserRoleName = "ED_CompanyDetails_ReportTo|NoPermission" + TienIch.taoRandomSo(3);

		roles.createUserRoleNameWithRoleTypeAdmin(UserRoleName);

		TestLogger.info("4. Uncheck on ED - Company Details - Report To | Read");
		roles.uncheckbox_Read_ED_CompanyDetails_ReportTo();

		TestLogger.info("5. Click Save button");
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

		TestLogger.info("8. Check Permission");
		administration.clickLogoTalentWize();
		administration.clickMenuEmployeeList();
		employeeList.searchEmployees("Cuong Automation");
		employeeList.clickEmployeeCuongAutomation();

		TestLogger.info("Expect : User CANNOT see /do: " + "block Report To");
		if (companyDetails.isLblReportToDisplayed() == false) {
			setStatusTest("pass", "User CANNOT see/do: " + "block Report To");
		} else {
			setStatusTest("fail", "User STILL CAN see/do: " + "block Report To");
		}

		TestLogger.info("=================END TT_3618====================");

	}

	@Test(priority = 2)
	public void TT_3616() throws InterruptedException {
		TestLogger.info("=================TT_3616 ====================");
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
		UserRoleName = "ED_CompanyDetails_ReportTo|Read" + TienIch.taoRandomSo(3);

		roles.createUserRoleNameWithRoleTypeAdmin(UserRoleName);

		TestLogger.info("4. Uncheck on ED - Company Details - Report To | Read");
		roles.uncheckbox_Read_ED_CompanyDetails_ReportTo();

		TestLogger.info("5. Check on ED - Company Details - Report To | Read");
		roles.checkbox_Read_ED_CompanyDetails_ReportTo();

		TestLogger.info("6. Click Save button");
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

		TestLogger.info("9. Check Permission");
		administration.clickLogoTalentWize();
		administration.clickMenuEmployeeList();
		employeeList.searchEmployees("Cuong Automation");
		employeeList.clickEmployeeCuongAutomation();

		TestLogger.info("Expect : User CAN see /do:\r\n" + "block Report To");

		if (companyDetails.isLblReportToDisplayed() == true) {
			setStatusTest("pass", "User CAN see/do:\r\n" + "block Report To");
		} else {
			setStatusTest("fail", "User CANNOT see/do:\r\n" + "block Report To");
		}

		TestLogger.info("Expect : User CANNOT see /do:\r\n" + "Button Edit in block Report To");

		if (companyDetails.isBtnEditReportToDisplayed() == false) {
			setStatusTest("pass", "User CANNOT see/do:\r\n" + "Button Edit in block Report To");
		} else {
			setStatusTest("fail", "User STILL CAN see/do:\r\n" + "Button Edit in block Report To");
		}

		TestLogger.info("=================END TT_3616====================");
	}

	@Test(priority = 3)
	public void TT_3617() throws InterruptedException {
		TestLogger.info("=================TT_3617 ====================");
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
		UserRoleName = "ED_CompanyDetails_ReportTo|Update" + TienIch.taoRandomSo(3);

		roles.createUserRoleNameWithRoleTypeAdmin(UserRoleName);

		TestLogger.info("4. Uncheck on ED - Company Details - Report To | Read");
		roles.uncheckbox_Read_ED_CompanyDetails_ReportTo();

		TestLogger.info("5. Check on ED - Company Details - Report To | Update");
		roles.checkbox_Update_ED_CompanyDetails_ReportTo();

		TestLogger.info("6. Click Save button");
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

		TestLogger.info("9. Check Permission");
		administration.clickLogoTalentWize();
		administration.clickMenuEmployeeList();
		employeeList.searchEmployees("Cuong Automation");
		employeeList.clickEmployeeCuongAutomation();

		TestLogger.info(
				"Expect : User CAN see /do:\r\n" + "1. block Report To\r\n" + "2. Button Edit in block Report To");

		if (companyDetails.isLblReportToDisplayed() == true) {
			setStatusTest("pass", "User CAN see/do:\r\n" + "block Report To");
		} else {
			setStatusTest("fail", "User CANNOT see/do:\r\n" + "block Report To");
		}

		if (companyDetails.isBtnEditReportToDisplayed() == true) {
			setStatusTest("pass", "User CAN see/do:\r\n" + "Button Edit in block Report To");
		} else {
			setStatusTest("fail", "User CANNOT see/do:\r\n" + "Button Edit in block Report To");
		}

		TestLogger.info("10. Update data");
		companyDetails.clickBtnEditReportTo();
		companyDetails.clickBtnSaveGeneralInformation();

		TestLogger.info("Expect : User CAN see /do:\r\n" + "Updated successfully");

		if (companyDetails.isMsgUpdateSuccessDisplayed() == true) {
			setStatusTest("pass", "User CAN see/do:\r\n" + "Updated successfully");
		} else {
			setStatusTest("fail", "User CANNOT see/do:\r\n" + "Updated successfully");
		}

		TestLogger.info("=================END TT_3617====================");

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
