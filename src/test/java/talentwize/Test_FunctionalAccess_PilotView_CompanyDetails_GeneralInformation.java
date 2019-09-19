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

public class Test_FunctionalAccess_PilotView_CompanyDetails_GeneralInformation extends TestManager {
	HomePage homePage;
	WebDriver driver;
	PropertyManager propertyManager;
	Dashboard dashboard;
	Administration administration;
	Users users;
	Roles roles;
	String UserRoleName;
	CompanyDetails companyDetails;
	EmployeeList employeeList;

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
		companyDetails = new CompanyDetails(driver);
		employeeList = new EmployeeList(driver);
		homePage.moLinkWeb(propertyManager.getURL_TalentWize());
	}

	@BeforeMethod
	public void PrintNameTestCase(Method method) {
		TestLogger.info("====== Begin Testcase : " + method.getName() + " ========");
	}

	@Test(priority = 1)
	public void TT_3615() throws InterruptedException {
		TestLogger.info("========== TT_3615================");
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
		UserRoleName = "ED_CompanyDetails_GeneralInfor|Update" + TienIch.taoRandomSo(3);

		roles.createUserRoleNameWithRoleTypeAdmin(UserRoleName);

		TestLogger.info("4. Click on button Save");
		roles.clickButtonSave();

		administration.openTabUsers();

		TestLogger.info("Assign role " + UserRoleName + " to employee : " + propertyManager.getEmailCuongUser());
		users.searchUsername(propertyManager.getEmailCuongUser());

		// Assign role Automation to this employee
		users.assignUserWithNewRole(propertyManager.getEmailCuongUser(), UserRoleName);

		TestLogger.info("5. Log out");

		dashboard.logout();

		TestLogger.info("6. Login with test account : " + propertyManager.getEmailCuongUser());

		homePage.SignInWith(propertyManager.getEmailCuongUser(), propertyManager.getPasswordCuongUser());

		TestLogger.info("7. Check Permission");
		administration.clickLogoTalentWize();
		administration.clickMenuEmployeeList();
		employeeList.clickItemEmployee();

		TestLogger.info("Expect : User CAN see /do:\r\n" + "1. block General Information:\r\n"
				+ "2. Button Edit in block General Information");

		if (administration.isSubMenuCompanyDetailsDisplayed() == true) {
			setStatusTest("pass", "User CAN see/do:\r\n" + "block General Information");
		} else {
			setStatusTest("fail", "User CANNOT see/do:\r\n" + "block General Information");
		}

		if (companyDetails.isBtnEditGeneralInformationDisplayed() == true) {
			setStatusTest("pass", "User CAN see/do:\r\n" + " Button Edit in block General Information");
		} else {
			setStatusTest("fail", "User CANNOT see/do:\r\n" + " Button Edit in block General Information");
		}

		TestLogger.info("8. Update data");

		companyDetails.clickBtnEditGeneralInformation();
		companyDetails.clickBtnSaveGeneralInformation();

		TestLogger.info("Expect : User CAN see /do:\r\n" + "Updated successfully");

		if (companyDetails.isMsgUpdateSuccessDisplayed() == true) {
			setStatusTest("pass", "User CAN see/do:\r\n" + "Updated successfully");
		} else {
			setStatusTest("fail", "User CANNOT see/do:\r\n" + "Updated successfully");
		}

		TestLogger.info("==========End TT_3615================");
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
