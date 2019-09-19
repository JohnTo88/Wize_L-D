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
import talentwize.pages.Form_CreateGoalManagement;
import talentwize.pages.Form_EditGoalManagement;
import talentwize.pages.GoalManagement;
import talentwize.pages.GoalPreview;
import talentwize.pages.GoalReview;
import talentwize.pages.HomePage;
import talentwize.pages.Roles;
import talentwize.pages.Users;

//Bugs : TAL-480
public class Test_FunctionalAccess_Performance_GoalManagement extends TestManager {
	HomePage homePage;
	WebDriver driver;
	PropertyManager propertyManager;
	Dashboard dashboard;
	Administration administration;
	Users users;
	Roles roles;
	String UserRoleName;
	Form_CreateGoalManagement formCreateGoalManagement;
	GoalManagement goalManagement;
	GoalPreview goalPreview;
	GoalReview goalReview;
	Form_EditGoalManagement formEditGoalManagement;

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
		formCreateGoalManagement = new Form_CreateGoalManagement(driver);
		goalManagement = new GoalManagement(driver);
		goalPreview = new GoalPreview(driver);
		goalReview = new GoalReview(driver);
		formEditGoalManagement = new Form_EditGoalManagement(driver);
		homePage.moLinkWeb(propertyManager.getURL_TalentWize());
	}

	@BeforeMethod
	public void PrintNameTestCase(Method method) {
		TestLogger.info("====== Begin Testcase : " + method.getName() + " ========");
	}

	@Test(priority = 1)
	public void TT_1012() throws InterruptedException {
		TestLogger.info("========== TT_1012================");
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
		UserRoleName = "Permission|GoalManagement|NoPermission" + TienIch.taoRandomSo(3);

		roles.createUserRoleNameWithRoleTypeAdmin(UserRoleName);

		TestLogger.info("4. Uncheck Performance - Goal Management | Read");
		roles.uncheckbox_Read_GoalManagement();

		TestLogger.info("5. Click on button Save");
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

		TestLogger.info("9. Open Performance >> Goal >> Goal Management");
		administration.clickLogoTalentWize();
		administration.clickMenuPerformance();
		administration.clickMenuGoals();
		TestLogger.info("Expect : User can see /do:\r\n" + "Sub Goal Management Menu");
		if (administration.isSubMenuGoalManagementDisplayed() == false) {
			setStatusTest("pass", "User CANNOT see/do:\r\n" + "Sub Goal Management Menu");
		} else {
			setStatusTest("fail", "User STILL CAN see/do:\r\n" + "Sub Goal Management Menu");
		}

		TestLogger.info("==========End TT_1012================");
	}

	@Test(priority = 2)
	public void TT_1036() throws InterruptedException {
		TestLogger.info("========== TT_1036================");
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
		UserRoleName = "Permission|GoalManagement|Create" + TienIch.taoRandomSo(3);

		roles.createUserRoleNameWithRoleTypeAdmin(UserRoleName);

		TestLogger.info("4. Uncheck Performance - Goal Management | Read");
		roles.uncheckbox_Read_GoalManagement();

		TestLogger.info("5. Check Performance - Goal Management | Create");
		roles.checkbox_Create_GoalManagement();

		TestLogger.info("6. Click on button Save");
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

		TestLogger.info("9. Open Performance >> Goal >> Goal Management");
		administration.clickLogoTalentWize();
		administration.clickMenuPerformance();
		administration.clickMenuGoals();
		TestLogger.info("Expect : User can see /do:\r\n" + "Sub Goal Management Menu");
		if (administration.isSubMenuGoalManagementDisplayed() == true) {
			setStatusTest("pass", "User CAN see/do:\r\n" + "Sub Goal Management Menu");
		} else {
			setStatusTest("fail", "User CANNOT see/do:\r\n" + "Sub Goal Management Menu");
		}

		TestLogger.info("10. Create New Goal");
		administration.clickSubMenuGoadManagement();
		goalManagement.clickBtnCreate();
		formCreateGoalManagement.createGoalManagement("Test Automation", "Test ContentOfSpecificObjective",
				"Test ContentOfMeasurement");

		TestLogger.info("Expect : User can see /do:\r\n" + "Create goal successfully!");
		if (goalPreview.isMsgCreateGoalSuccessdDisplayed() == true) {
			setStatusTest("pass", "User CAN see/do:\r\n" + "Create goal successfully!");
		} else {
			setStatusTest("fail", "User CANNOT see/do:\r\n" + "Create goal successfully!");
		}

		TestLogger.info("11. Check Permission");
		goalPreview.clickBtnBack();
		TestLogger.info("Expect : User CAN see /do:\r\n" + "1. List of goal table \r\n"
				+ "2. View goal preview by click goal name hyperlink\r\n"
				+ "3. Action dropdown include : Review and unassigned members options\r\n" + "4. Goal Review page \r\n"
				+ "5. Create goal btn");

		if (goalManagement.isLblTitleGoalManagementDisplayed() == true) {
			setStatusTest("pass", "User CAN see/do:\r\n" + "List of goal table");
		} else {
			setStatusTest("fail", "User CANNOT see/do:\r\n" + "List of goal table");
		}

		if (goalManagement.isBtnCreateDisplayed() == true) {
			setStatusTest("pass", "User CAN see/do:\r\n" + "Create goal btn");
		} else {
			setStatusTest("fail", "User CANNOT see/do:\r\n" + "Create goal btn");
		}

		if (goalManagement.isLinkEditdDisplayed() == true) {
			setStatusTest("pass", "User CAN see/do:\r\n" + "View goal preview by click goal name hyperlink");
		} else {
			setStatusTest("fail", "User CANNOT see/do:\r\n" + "View goal preview by click goal name hyperlink");
		}

		goalManagement.clickBtnAction();
		if (goalManagement.isOptReviewdDisplayed() == true) {
			setStatusTest("pass", "User CAN see/do:\r\n" + "Action dropdown include : Review option");
		} else {
			setStatusTest("fail", "User CANNOT see/do:\r\n" + "Action dropdown include : Review option");
		}

		if (goalManagement.isOptUnassigndDisplayed() == true) {
			setStatusTest("pass", "User CAN see/do:\r\n" + "Action dropdown include : Unassigned members option");
		} else {
			setStatusTest("fail", "User CANNOT see/do:\r\n" + "Action dropdown include : Unassigned members option");
		}

		goalManagement.clickOptReview();
		if (goalManagement.isLblGoalReiewDisplayed() == true) {
			setStatusTest("pass", "User CAN see/do:\r\n" + "Action dropdown include : Goal Review page");
		} else {
			setStatusTest("fail", "User CANNOT see/do:\r\n" + "Action dropdown include : Goal Review page");
		}

		TestLogger.info("Expect : User CANNOT see /do:\r\n" + "1. Checkbox and delete button\r\n"
				+ "2. Unarchive/ Archive goal\r\n" + "3. Edit btn in Goal details page");
		if (goalManagement.isIcoDeleteDisplayed() == false) {
			setStatusTest("pass", "User CANNOT see/do:\r\n" + "Checkbox and delete button");
		} else {
			setStatusTest("fail", "User STILL CAN see/do:\r\n" + "Checkbox and delete button");
		}

		if (goalManagement.isOptArchiveDisplayed() == false) {
			setStatusTest("pass", "User CANNOT see/do:\r\n" + "Unarchive/ Archive goal");
		} else {
			setStatusTest("fail", "User STILL CAN see/do:\r\n" + "Unarchive/ Archive goal");
		}

		// click on Back
		goalManagement.clickOnButtonBack();
		goalManagement.clickLinkEdit();
		if (goalPreview.isBtnEditDisplayed() == false) {
			setStatusTest("pass", "User CANNOT see/do:\r\n" + "Edit btn in Goal details page");
		} else {
			setStatusTest("fail", "User STILL CAN see/do:\r\n" + "Edit btn in Goal details page");
		}

		TestLogger.info("==========End TT_1036================");
	}

	@Test(priority = 3)
	public void TT_1034() throws InterruptedException {
		TestLogger.info("========== TT_1034================");
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
		UserRoleName = "Permission|GoalManagement|Read" + TienIch.taoRandomSo(3);

		roles.createUserRoleNameWithRoleTypeAdmin(UserRoleName);

		TestLogger.info("4. Uncheck Performance - Goal Management | Read");
		roles.uncheckbox_Read_GoalManagement();

		TestLogger.info("5. Check Performance - Goal Management | Read");
		roles.checkbox_Read_GoalManagement();

		TestLogger.info("6. Click on button Save");
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

		TestLogger.info("9. Open Performance >> Goal >> Goal Management");
		administration.clickLogoTalentWize();
		administration.clickMenuPerformance();
		administration.clickMenuGoals();
		TestLogger.info("Expect : User can see /do:\r\n" + "Sub Goal Management Menu");
		if (administration.isSubMenuGoalManagementDisplayed() == true) {
			setStatusTest("pass", "User CAN see/do:\r\n" + "Sub Goal Management Menu");
		} else {
			setStatusTest("fail", "User CANNOT see/do:\r\n" + "Sub Goal Management Menu");
		}

		TestLogger.info("10. Check Permission");
		administration.clickSubMenuGoadManagement();
		TestLogger.info("Expect : User CAN see /do:\r\n" + "1. List of goal table \r\n"
				+ "2. View goal preview by click goal name hyperlink\r\n"
				+ "3. Action dropdown include : Review and unassigned members options\r\n" + "4. Goal Review page");

		if (goalManagement.isLblTitleGoalManagementDisplayed() == true) {
			setStatusTest("pass", "User CAN see/do:\r\n" + "List of goal table");
		} else {
			setStatusTest("fail", "User CANNOT see/do:\r\n" + "List of goal table");
		}

		if (goalManagement.isLinkEditdDisplayed() == true) {
			setStatusTest("pass", "User CAN see/do:\r\n" + "View goal preview by click goal name hyperlink");
		} else {
			setStatusTest("fail", "User CANNOT see/do:\r\n" + "View goal preview by click goal name hyperlink");
		}

		goalManagement.clickBtnAction();
		if (goalManagement.isOptReviewdDisplayed() == true) {
			setStatusTest("pass", "User CAN see/do:\r\n" + "Action dropdown include : Review option");
		} else {
			setStatusTest("fail", "User CANNOT see/do:\r\n" + "Action dropdown include : Review option");
		}

		if (goalManagement.isOptUnassigndDisplayed() == true) {
			setStatusTest("pass", "User CAN see/do:\r\n" + "Action dropdown include : Unassigned members option");
		} else {
			setStatusTest("fail", "User CANNOT see/do:\r\n" + "Action dropdown include : Unassigned members option");
		}

		goalManagement.clickOptReview();
		if (goalManagement.isLblGoalReiewDisplayed() == true) {
			setStatusTest("pass", "User CAN see/do:\r\n" + "Action dropdown include : Goal Review page");
		} else {
			setStatusTest("fail", "User CANNOT see/do:\r\n" + "Action dropdown include : Goal Review page");
		}

		TestLogger.info("Expect : User CANNOT see /do:\r\n" + "1. Checkbox and delete button\r\n"
				+ "2. Unarchive/ Archive goal\r\n" + "3. Edit btn in Goal details page\r\n" + "4. Create goal btn");
		goalReview.clickBtnBack();
		if (goalManagement.isBtnCreateDisplayed() == false) {
			setStatusTest("pass", "User CANNOT see/do:\r\n" + "Create goal btn");
		} else {
			setStatusTest("fail", "User STILL CAN see/do:\r\n" + "Create goal btn");
		}

		if (goalManagement.isIcoDeleteDisplayed() == false) {
			setStatusTest("pass", "User CANNOT see/do:\r\n" + "Checkbox and delete button");
		} else {
			setStatusTest("fail", "User STILL CAN see/do:\r\n" + "Checkbox and delete button");
		}

		if (goalManagement.isOptArchiveDisplayed() == false) {
			setStatusTest("pass", "User CANNOT see/do:\r\n" + "Unarchive/ Archive goal");
		} else {
			setStatusTest("fail", "User STILL CAN see/do:\r\n" + "Unarchive/ Archive goal");
		}

		goalManagement.clickLinkEdit();
		if (goalPreview.isBtnEditDisplayed() == false) {
			setStatusTest("pass", "User CANNOT see/do:\r\n" + "Edit btn in Goal details page");
		} else {
			setStatusTest("fail", "User STILL CAN see/do:\r\n" + "Edit btn in Goal details page");
		}

		TestLogger.info("==========End TT_1034================");
	}

	@Test(priority = 4)
	public void TT_1035() throws InterruptedException {
		TestLogger.info("========== TT_1035================");
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
		UserRoleName = "Permission|GoalManagement|Update" + TienIch.taoRandomSo(3);

		roles.createUserRoleNameWithRoleTypeAdmin(UserRoleName);

		TestLogger.info("4. Uncheck Performance - Goal Management | Read");
		roles.uncheckbox_Read_GoalManagement();

		TestLogger.info("5. Check Performance - Goal Management | Upadte");
		roles.checkbox_Update_GoalManagement();

		TestLogger.info("6. Click on button Save");
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

		TestLogger.info("9. Open Performance >> Goal >> Goal Management");
		administration.clickLogoTalentWize();
		administration.clickMenuPerformance();
		administration.clickMenuGoals();
		TestLogger.info("Expect : User can see /do:\r\n" + "Sub Goal Management Menu");
		if (administration.isSubMenuGoalManagementDisplayed() == true) {
			setStatusTest("pass", "User CAN see/do:\r\n" + "Sub Goal Management Menu");
		} else {
			setStatusTest("fail", "User CANNOT see/do:\r\n" + "Sub Goal Management Menu");
		}

		TestLogger.info("10. Update Goal");
		administration.clickSubMenuGoadManagement();
		goalManagement.clickLinkEdit();

		TestLogger.info("Expect : User can see /do:\r\n" + "Update goal successfully!");
		if (goalPreview.editAGoal() == true) {
			setStatusTest("pass", "User CAN see/do:\r\n" + "Update goal successfully!");
		} else {
			setStatusTest("fail", "User CANNOT see/do:\r\n" + "Update goal successfully!");
		}

		TestLogger.info("11. Check Permission");
		goalPreview.clickBtnBack();
		TestLogger.info("Expect : User CAN see /do:\r\n" + "1. List of goal table \r\n"
				+ "2. View goal preview by click goal name hyperlink\r\n"
				+ "3. Action dropdown include : Review and unassigned members options\r\n" + "4. Goal Review page \r\n"
				+ "5. Edit btn in Goal details page");

		if (goalManagement.isLblTitleGoalManagementDisplayed() == true) {
			setStatusTest("pass", "User CAN see/do:\r\n" + "List of goal table");
		} else {
			setStatusTest("fail", "User CANNOT see/do:\r\n" + "List of goal table");
		}

		if (goalManagement.isLinkEditdDisplayed() == true) {
			setStatusTest("pass", "User CAN see/do:\r\n" + "View goal preview by click goal name hyperlink");
		} else {
			setStatusTest("fail", "User CANNOT see/do:\r\n" + "View goal preview by click goal name hyperlink");
		}

		goalManagement.clickBtnAction();
		if (goalManagement.isOptReviewdDisplayed() == true) {
			setStatusTest("pass", "User CAN see/do:\r\n" + "Action dropdown include : Review option");
		} else {
			setStatusTest("fail", "User CANNOT see/do:\r\n" + "Action dropdown include : Review option");
		}

		if (goalManagement.isOptUnassigndDisplayed() == true) {
			setStatusTest("pass", "User CAN see/do:\r\n" + "Action dropdown include : Unassigned members option");
		} else {
			setStatusTest("fail", "User CANNOT see/do:\r\n" + "Action dropdown include : Unassigned members option");
		}

		goalManagement.clickOptReview();
		if (goalManagement.isLblGoalReiewDisplayed() == true) {
			setStatusTest("pass", "User CAN see/do:\r\n" + "Action dropdown include : Goal Review page");
		} else {
			setStatusTest("fail", "User CANNOT see/do:\r\n" + "Action dropdown include : Goal Review page");
		}

		goalReview.clickBtnBack();
		goalManagement.clickLinkEdit();
		if (goalPreview.isBtnEditDisplayed() == true) {
			setStatusTest("pass", "User CAN see/do:\r\n" + "Edit btn in Goal details page");
		} else {
			setStatusTest("fail", "User CANNOT see/do:\r\n" + "Edit btn in Goal details page");
		}

		TestLogger.info("Expect : User CANNOT see /do:\r\n" + "1. Checkbox and delete button\r\n"
				+ "2. Unarchive/ Archive goal\r\n" + "3. Create goal btn");
		goalPreview.clickBtnBack();
		if (goalManagement.isBtnCreateDisplayed() == false) {
			setStatusTest("pass", "User CANNOT see/do:\r\n" + "Create goal btn");
		} else {
			setStatusTest("fail", "User STILL CAN see/do:\r\n" + "Create goal btn");
		}

		if (goalManagement.isIcoDeleteDisplayed() == false) {
			setStatusTest("pass", "User CANNOT see/do:\r\n" + "Checkbox and delete button");
		} else {
			setStatusTest("fail", "User STILL CAN see/do:\r\n" + "Checkbox and delete button");
		}

		if (goalManagement.isOptArchiveDisplayed() == false) {
			setStatusTest("pass", "User CANNOT see/do:\r\n" + "Unarchive/ Archive goal");
		} else {
			setStatusTest("fail", "User STILL CAN see/do:\r\n" + "Unarchive/ Archive goal");
		}

		TestLogger.info("==========End TT_1035================");
	}

	@Test(priority = 5)
	public void TT_1037() throws InterruptedException {
		TestLogger.info("========== TT_1037================");
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
		UserRoleName = "Permission|GoalManagement|Delete" + TienIch.taoRandomSo(3);

		roles.createUserRoleNameWithRoleTypeAdmin(UserRoleName);

		TestLogger.info("4. Uncheck Performance - Goal Management | Read");
		roles.uncheckbox_Read_GoalManagement();

		TestLogger.info("5. Check Performance - Goal Management | Delete");
		roles.checkbox_Delete_GoalManagement();

		TestLogger.info("6. Click on button Save");
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

		TestLogger.info("9. Open Performance >> Goal >> Goal Management");
		administration.clickLogoTalentWize();
		administration.clickMenuPerformance();
		administration.clickMenuGoals();
		TestLogger.info("Expect : User can see /do:\r\n" + "Sub Goal Management Menu");
		if (administration.isSubMenuGoalManagementDisplayed() == true) {
			setStatusTest("pass", "User CAN see/do:\r\n" + "Sub Goal Management Menu");
		} else {
			setStatusTest("fail", "User CANNOT see/do:\r\n" + "Sub Goal Management Menu");
		}

		TestLogger.info("10. Check Permission");
		administration.clickSubMenuGoadManagement();
		TestLogger.info("Expect : User CAN see /do:\r\n" + "1. List of goal table \r\n"
				+ "2. View goal preview by click goal name hyperlink\r\n"
				+ "3. Action dropdown include : Review and unassigned members options\r\n" + "4. Goal Review page \r\n"
				+ "5. Checkbox and delete button");

		if (goalManagement.isLblTitleGoalManagementDisplayed() == true) {
			setStatusTest("pass", "User CAN see/do:\r\n" + "List of goal table");
		} else {
			setStatusTest("fail", "User CANNOT see/do:\r\n" + "List of goal table");
		}

		if (goalManagement.isIcoDeleteDisplayed() == true) {
			setStatusTest("pass", "User CAN see/do:\r\n" + "Checkbox and delete button");
		} else {
			setStatusTest("fail", "User CANNOT see/do:\r\n" + "Checkbox and delete button");
		}

		if (goalManagement.isLinkEditdDisplayed() == true) {
			setStatusTest("pass", "User CAN see/do:\r\n" + "View goal preview by click goal name hyperlink");
		} else {
			setStatusTest("fail", "User CANNOT see/do:\r\n" + "View goal preview by click goal name hyperlink");
		}

		goalManagement.clickBtnAction();
		if (goalManagement.isOptReviewdDisplayed() == true) {
			setStatusTest("pass", "User CAN see/do:\r\n" + "Action dropdown include : Review option");
		} else {
			setStatusTest("fail", "User CANNOT see/do:\r\n" + "Action dropdown include : Review option");
		}

		if (goalManagement.isOptUnassigndDisplayed() == true) {
			setStatusTest("pass", "User CAN see/do:\r\n" + "Action dropdown include : Unassigned members option");
		} else {
			setStatusTest("fail", "User CANNOT see/do:\r\n" + "Action dropdown include : Unassigned members option");
		}

		goalManagement.clickOptReview();
		if (goalManagement.isLblGoalReiewDisplayed() == true) {
			setStatusTest("pass", "User CAN see/do:\r\n" + "Action dropdown include : Goal Review page");
		} else {
			setStatusTest("fail", "User CANNOT see/do:\r\n" + "Action dropdown include : Goal Review page");
		}

		TestLogger.info("Expect : User CANNOT see /do:\r\n" + "1. Edit btn in Goal details page\r\n"
				+ "2. Unarchive/ Archive goal\r\n" + "3. Create goal btn");
		goalReview.clickBtnBack();
		goalManagement.clickLinkEdit();
		if (goalPreview.isBtnEditDisplayed() == false) {
			setStatusTest("pass", "User CANNOT see/do:\r\n" + "Edit btn in Goal details page");
		} else {
			setStatusTest("fail", "User CAN see/do:\r\n" + "Edit btn in Goal details page");
		}

		goalPreview.clickBtnBack();
		if (goalManagement.isBtnCreateDisplayed() == false) {
			setStatusTest("pass", "User CANNOT see/do:\r\n" + "Create goal btn");
		} else {
			setStatusTest("fail", "User STILL CAN see/do:\r\n" + "Create goal btn");
		}

		if (goalManagement.isOptArchiveDisplayed() == false) {
			setStatusTest("pass", "User CANNOT see/do:\r\n" + "Unarchive/ Archive goal");
		} else {
			setStatusTest("fail", "User STILL CAN see/do:\r\n" + "Unarchive/ Archive goal");
		}

		TestLogger.info("11. Delete Goal");
		goalManagement.deleteGoal();

		TestLogger.info("Expect : User can see /do:\r\n" + "Delelte goal successfully!");
		if (goalManagement.isMsgDeleteSuccessDisplayed() == true) {
			setStatusTest("pass", "User CAN see/do:\r\n" + "Delelte goal successfully!");
		} else {
			setStatusTest("fail", "User CANNOT see/do:\r\n" + "Delelte goal successfully!");
		}

		TestLogger.info("==========End TT_1037================");
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
