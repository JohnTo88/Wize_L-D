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
import talentwize.pages.Roles;
import talentwize.pages.TabCompetencyReviewSchedule;
import talentwize.pages.Users;

public class Test_FunctionalAccess_TalentPermission_CompetencySettings_CompetencyReviewSchedule extends TestManager {
	HomePage homePage;
	WebDriver driver;
	PropertyManager propertyManager;
	Dashboard dashboard;
	Administration administration;
	Users users;
	Roles roles;
	String UserRoleName;
	TabCompetencyReviewSchedule tabCompetencyReviewSchedule;

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
		homePage.moLinkWeb(propertyManager.getURL_TalentWize());
		tabCompetencyReviewSchedule = new TabCompetencyReviewSchedule(driver);
	}

	@BeforeMethod
	public void PrintNameTestCase(Method method) {
		TestLogger.info("====== Begin Testcase : " + method.getName() + " ========");
	}

	@Test(priority = 1)
	public void TT_1098() throws InterruptedException {
		TestLogger.info("=================TT_1098====================");
		TestLogger.info("1. Login with Administrator account.");

		homePage.SignInWith(propertyManager.getEmailAdminNgoc(), propertyManager.getPasswordAdminNgoc());

		if (dashboard.isDashboardMenuDisplayed() == true) {
			setStatusTest("pass", "Login successfully!");
		} else {
			setStatusTest("fail", "Login unsuccessfully!");
		}

		TestLogger.info("2. Go to Administration - User Management - Roles tab");
		administration.clickMenuAdministration();
		administration.clickMenuUserManagement();
		administration.openRolesTab();

		TestLogger.info("3. Create Automation User Role Name and Role Type is Admin :");
		UserRoleName = "Ngoc Auto " + TienIch.taoRandomSo(3);
		roles.createUserRoleNameWithRoleTypeAdmin(UserRoleName);

		TestLogger.info("+ Unchecked on Competency - Settings - Competency Review Schedule | Read");
		roles.uncheckbox_Read_CompetencySettings_CompetencyReviewSchedule();

		TestLogger.info("4. Click Save button");
		roles.clickButtonSave();

		administration.openTabUsers();

		TestLogger.info("5. Assign role " + UserRoleName + " to employee : " + propertyManager.getEmailUserChi());
		users.searchUsername(propertyManager.getEmailUserChi());

		// Assign role Automation to this employee
		users.assignUserWithNewRole(propertyManager.getEmailUserChi(), UserRoleName);

		TestLogger.info("6. Log out");
		dashboard.logout();

		TestLogger.info("7. Login with test account : " + propertyManager.getEmailUserChi());
		homePage.SignInWith(propertyManager.getEmailUserChi(), propertyManager.getPasswordUserChi());

		TestLogger.info("8. Open Talent Management >> Competency >> Competency Settings");
		administration.clickMenuTalentManagement();
		administration.clickSubMenuCompetency();
		administration.clickSubMenuCompetencySettings();

		TestLogger.info("Expected: User CANNOT see/do:\r\n" + "1. Data table in tab Competency Review Schedule");
		if (administration.isTabCompetencyReviewScheduleDisplayed() == false) {
			setStatusTest("pass", "User CANNOT see/do:\r\n" + "Tab Competency Review Schedule");
		} else {
			setStatusTest("fail", "User CAN see/do:\r\n" + "Tab Competency Review Schedule");
		}

		TestLogger.info("=================END TT_1098====================");
	}

	@Test(priority = 2)
	public void TT_1094() throws InterruptedException {
		TestLogger.info("=================TT_1094====================");
		TestLogger.info("1. Login with Administrator account.");

		homePage.SignInWith(propertyManager.getEmailAdminNgoc(), propertyManager.getPasswordAdminNgoc());

		if (dashboard.isDashboardMenuDisplayed() == true) {
			setStatusTest("pass", "Login successfully!");
		} else {
			setStatusTest("fail", "Login unsuccessfully!");
		}

		TestLogger.info("2. Go to Administration - User Management - Roles tab");
		administration.clickMenuAdministration();
		administration.clickMenuUserManagement();
		administration.openRolesTab();

		TestLogger.info("3. Create Automation User Role Name and Role Type is Admin :");
		UserRoleName = "Ngoc Auto " + TienIch.taoRandomSo(3);
		roles.createUserRoleNameWithRoleTypeAdmin(UserRoleName);

		TestLogger.info("+ Unchecked on Competency - Settings - Competency Review Schedule | Read");
		roles.uncheckbox_Read_CompetencySettings_CompetencyReviewSchedule();
		TestLogger.info("+ Checked on Competency - Settings - Competency Review Schedule | Read");
		roles.checkbox_Read_CompetencySettings_CompetencyReviewSchedule();

		TestLogger.info("4. Click Save button");
		roles.clickButtonSave();

		administration.openTabUsers();

		TestLogger.info("5. Assign role " + UserRoleName + " to employee : " + propertyManager.getEmailUserChi());
		users.searchUsername(propertyManager.getEmailUserChi());

		// Assign role Automation to this employee
		users.assignUserWithNewRole(propertyManager.getEmailUserChi(), UserRoleName);

		TestLogger.info("6. Log out");
		dashboard.logout();

		TestLogger.info("7. Login with test account : " + propertyManager.getEmailUserChi());
		homePage.SignInWith(propertyManager.getEmailUserChi(), propertyManager.getPasswordUserChi());

		TestLogger.info("8. Open Talent Management >> Competency >> Competency Settings >> Competency Review Schedule");
		administration.clickMenuTalentManagement();
		administration.clickSubMenuCompetency();
		administration.clickSubMenuCompetencySettings();
		administration.clickTabCompetencyReviewSchedule();

		TestLogger.info("Expected: User CAN see/do:\r\n" + "1. Settings screen");
		if (tabCompetencyReviewSchedule.isLblSettingsDisplayed() == true) {
			setStatusTest("pass", "User CAN see/do:\r\n" + "Title Settings");
		} else {
			setStatusTest("fail", "User CANNOT see/do:\r\n" + "Title Settings");
		}

		TestLogger.info("Expected: User CANNOT see/do:\r\n" + "1. Create button\r\n");
		if (tabCompetencyReviewSchedule.isBtnCreateDisplayed() == false) {
			setStatusTest("pass", "User CANNOT see/do:\r\n" + "Button Create in tab Competency Review Schedule");
		} else {
			setStatusTest("fail", "User CAN see/do:\r\n" + "Button Create in tab Competency Review Schedule");
		}

		TestLogger.info("=================END TT_1094====================");
	}

	@Test(priority = 3)
	public void TT_1095() throws InterruptedException {
		TestLogger.info("=================TT_1095====================");
		TestLogger.info("1. Login with Administrator account.");

		homePage.SignInWith(propertyManager.getEmailAdminNgoc(), propertyManager.getPasswordAdminNgoc());

		if (dashboard.isDashboardMenuDisplayed() == true) {
			setStatusTest("pass", "Login successfully!");
		} else {
			setStatusTest("fail", "Login unsuccessfully!");
		}

		TestLogger.info("2. Go to Administration - User Management - Roles tab");
		administration.clickMenuAdministration();
		administration.clickMenuUserManagement();
		administration.openRolesTab();

		TestLogger.info("3. Create Automation User Role Name and Role Type is Admin :");
		UserRoleName = "Ngoc Auto " + TienIch.taoRandomSo(3);
		roles.createUserRoleNameWithRoleTypeAdmin(UserRoleName);

		TestLogger.info("4. Click Save button");
		roles.clickButtonSave();

		administration.openTabUsers();

		TestLogger.info("5. Assign role " + UserRoleName + " to employee : " + propertyManager.getEmailUserChi());
		users.searchUsername(propertyManager.getEmailUserChi());

		// Assign role Automation to this employee
		users.assignUserWithNewRole(propertyManager.getEmailUserChi(), UserRoleName);

		TestLogger.info("6. Log out");
		dashboard.logout();

		TestLogger.info("7. Login with test account : " + propertyManager.getEmailUserChi());
		homePage.SignInWith(propertyManager.getEmailUserChi(), propertyManager.getPasswordUserChi());

		TestLogger.info("8. Open Talent Management >> Competency >> Competency Settings >> Competency Review Schedule");
		administration.clickMenuTalentManagement();
		administration.clickSubMenuCompetency();
		administration.clickSubMenuCompetencySettings();
		administration.clickTabCompetencyReviewSchedule();

		TestLogger.info("Expected: User CAN see/do:\r\n" + "1. Settings screen\r\n" + "2. Create/Edit button");
		if (tabCompetencyReviewSchedule.isLblSettingsDisplayed() == true) {
			setStatusTest("pass", "User CAN see/do:\r\n" + "Title Settings");
		} else {
			setStatusTest("fail", "User CANNOT see/do:\r\n" + "Title Settings");
		}

		if (tabCompetencyReviewSchedule.isBtnCreateDisplayed() == true
				|| tabCompetencyReviewSchedule.isBtnEditDisplayed()) {
			setStatusTest("pass", "User CAN see/do:\r\n" + "Create button or Edit button");
		} else {
			setStatusTest("fail", "User CANNOT see/do:\r\n" + "Create button or Edit button");
		}

		TestLogger.info("9. Create/Edit Review Schedule");
		if (tabCompetencyReviewSchedule.isBtnCreateDisplayed() == true) {
			tabCompetencyReviewSchedule.clickBtnCreate();
			tabCompetencyReviewSchedule.fillScheduleDate("10-Mar-2019");
			tabCompetencyReviewSchedule.clickBtnSave();

			if (tabCompetencyReviewSchedule.isMsgAddScheduleSuccessDisplayed() == true) {
				setStatusTest("pass", "User CAN see/do:\r\n" + "Create Review Schedule");
			} else {
				setStatusTest("fail", "User CANNOT see/do:\r\n" + "Create Review Schedule");
			}
		}

		if (tabCompetencyReviewSchedule.isBtnEditDisplayed() == true) {
			tabCompetencyReviewSchedule.clickBtnEdit();
			tabCompetencyReviewSchedule.clickBtnSave();

			if (tabCompetencyReviewSchedule.isMsgEditScheduleSuccessDisplayed() == true) {
				setStatusTest("pass", "User CAN see/do:\r\n" + "Edit Review Schedule");
			} else {
				setStatusTest("fail", "User CANNOT see/do:\r\n" + "Edit Review Schedule");
			}
		}

		TestLogger.info("=================END TT_1095====================");
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
