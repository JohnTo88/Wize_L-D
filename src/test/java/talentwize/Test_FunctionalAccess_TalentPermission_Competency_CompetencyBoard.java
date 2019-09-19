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
import talentwize.pages.CompetencyBoard;
import talentwize.pages.Dashboard;
import talentwize.pages.EmployeeList;
import talentwize.pages.Form_AddSerries;
import talentwize.pages.Form_SkillEvaluation;
import talentwize.pages.HomePage;
import talentwize.pages.KPIBoard;
import talentwize.pages.Roles;
import talentwize.pages.SeriesSettings;
import talentwize.pages.TabPersonalSkillMatrix;
import talentwize.pages.TabSkillMatrix;
import talentwize.pages.Users;

public class Test_FunctionalAccess_TalentPermission_Competency_CompetencyBoard extends TestManager {

	HomePage homePage;
	WebDriver driver;
	PropertyManager propertyManager;
	Dashboard dashboard;
	Administration administration;
	Users users;
	Roles roles;
	String UserRoleName;
	EmployeeList employeeList;
	KPIBoard kPIBoard;
	SeriesSettings seriesSettings;
	Form_AddSerries formAddSerries;
	TabSkillMatrix tabSkillMatrix;
	TabPersonalSkillMatrix tabPersonalSkillMatrix;
	CompetencyBoard competencyBoard;
	Form_SkillEvaluation formSkillEvalution;

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
		kPIBoard = new KPIBoard(driver);
		seriesSettings = new SeriesSettings(driver);
		formAddSerries = new Form_AddSerries(driver);
		tabSkillMatrix = new TabSkillMatrix(driver);
		tabPersonalSkillMatrix = new TabPersonalSkillMatrix(driver);
		competencyBoard = new CompetencyBoard(driver);
		formSkillEvalution = new Form_SkillEvaluation(driver);
		homePage.moLinkWeb(propertyManager.getURL_TalentWize());

	}

	@BeforeMethod
	public void PrintNameTestCase(Method method) {
		TestLogger.info("====== Begin Testcase : " + method.getName() + " ========");
	}

	@Test(priority = 1)
	public void TT_1051() throws InterruptedException {

		TestLogger.info("=============== TT-1051 ===============");
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
		UserRoleName = "Automation-View Employee" + TienIch.taoRandomSo(5);

		roles.createUserRoleNameWithRoleTypeAdmin(UserRoleName);

		TestLogger.info("+ Unchecked on Talent Permission - Competency - Competency Board | Read ");
		roles.uncheckbox_Read_Competency_CompetencyBoard();

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
		administration.clickMenuTalentManagement();

		administration.clickSubMenuCompetency();

		if (administration.isSubMenuCompetencyBoardDisplayed() == false) {
			setStatusTest("pass", "User CANNOT see/do:\r\n" + "1. Task menu");
		} else {
			setStatusTest("fail", "User STILL CAN see/do:\r\n" + "1. Task menu");
		}

		TestLogger.info("=============== TT-1051 ===============");
	}

	@Test(priority = 2)
	public void TT_1047() throws InterruptedException {

		TestLogger.info("=============== TT-1047 ===============");
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
		UserRoleName = "Automation-View Employee" + TienIch.taoRandomSo(5);

		roles.createUserRoleNameWithRoleTypeAdmin(UserRoleName);

		TestLogger.info("+ checked on Talent Permission - Competency - Competency Board | Read ");
		roles.uncheckbox_Read_Competency_CompetencyBoard();
		roles.checkbox_Read_Competency_CompetencyBoard();
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

		TestLogger.info("8.Open Talent Managemenet >> Competency Board");

		administration.clickMenuTalentManagement();

		administration.clickSubMenuCompetency();

		administration.clickSubMenuCompetencyBoard();

		if (competencyBoard.isBtnSettingsDisplayed() == false) {
			setStatusTest("pass", "User CANNOT see/do\r\n" + "1. button Settings ");
		} else {
			setStatusTest("fail", "User STILL CAN see/do\r\n" + "1. button Settings ");
		}

		competencyBoard.searchEmployee(CompetencyBoard.NAME_OF_EMPLOYEE);
		competencyBoard.clickOnFistLinkOfEmployee();

		TestLogger.info(
				"9. Open Talent Management >> Competency Board >> Click on hyperlink empoyee name >> sub tab Skill Matrix");

		if (tabSkillMatrix.isBtnEvulateDisplayed() == false) {
			setStatusTest("pass", "User CANNOT see/do\r\n" + "1. button \"Evaluate\" in column Status");
		} else {
			setStatusTest("fail", "User STILL CAN see/do\r\n" + "1. button \"Evaluate\" in column Status");
		}

		TestLogger.info(
				"10.Open Talent Management >> Competency Board >> Click on hyperlink empoyee name >> sub tab Personal Skill Matrix");

		tabSkillMatrix.clickTabPersonalSkillMatrix();

		if (tabPersonalSkillMatrix.isBtnEvulateDisplayed() == false) {
			setStatusTest("pass", "User CANNOT see/do\r\n" + "1. button \"Evaluate\" in column Status");
		} else {
			setStatusTest("fail", "User STILL CAN see/do\r\n" + "1. button \"Evaluate\" in column Status");
		}
		TestLogger.info("=============== TT-1047 ===============");
	}

	@Test(priority = 3)
	public void TT_1048() throws InterruptedException {

		TestLogger.info("=============== TT-1048 ===============");
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
		UserRoleName = "Automation-View Employee" + TienIch.taoRandomSo(5);

		roles.createUserRoleNameWithRoleTypeAdmin(UserRoleName);

		TestLogger.info("+ checked on Talent Permission - Competency - Competency Board | Update ");
		roles.uncheckbox_Read_Competency_CompetencyBoard();
		roles.checkbox_Update_Competency_CompetencyBoard();
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

		TestLogger.info("8.Open Talent Managemenet >> Competency Board");

		administration.clickMenuTalentManagement();

		administration.clickSubMenuCompetency();

		administration.clickSubMenuCompetencyBoard();

		if (competencyBoard.isBtnSettingsDisplayed() == false) {
			setStatusTest("pass", "User CANNOT see/do\r\n" + "1. button Settings ");
		} else {
			setStatusTest("fail", "User STILL CAN see/do\r\n" + "1. button Settings ");
		}

		competencyBoard.searchEmployee(CompetencyBoard.NAME_OF_EMPLOYEE);
		competencyBoard.clickOnFistLinkOfEmployee();

		TestLogger.info(
				"9. Open Talent Management >> Competency Board >> Click on hyperlink empoyee name >> sub tab Skill Matrix");

		if (tabSkillMatrix.isBtnEvulateDisplayed() == true) {
			setStatusTest("pass", "User CAN see/do\r\n" + "1. button \"Evaluate\" in column Status");
		} else {
			setStatusTest("fail", "User STILL CAN NOT see/do\r\n" + "1. button \"Evaluate\" in column Status");
		}

		TestLogger.info("5. Click on button \"Evaluate\"\r\n" + "6. Click on button \"OK\"");

		tabSkillMatrix.clickButtonEvulate();
		formSkillEvalution.clickButtonOK();

		if (formSkillEvalution.isMessageSuccessDisplayed() == true) {
			setStatusTest("pass", "Displays msg \"Update client successfully\"");
		} else {
			setStatusTest("fail", "");
		}

		TestLogger.info(
				"10.Open Talent Management >> Competency Board >> Click on hyperlink empoyee name >> sub tab Personal Skill Matrix");

		tabSkillMatrix.clickTabPersonalSkillMatrix();

		if (tabPersonalSkillMatrix.isBtnEvulateDisplayed() == true) {
			setStatusTest("pass", "User CAN see/do\r\n" + "1. button \"Evaluate\" in column Status");
		} else {
			setStatusTest("fail", "User STILL CAN NOT see/do\r\n" + "1. button \"Evaluate\" in column Status");
		}

		TestLogger.info("=============== TT-1048 ===============");
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
