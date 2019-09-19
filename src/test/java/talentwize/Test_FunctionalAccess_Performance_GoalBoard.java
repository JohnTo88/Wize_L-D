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
import talentwize.pages.CheckInBoard;
import talentwize.pages.CreateGoal;
import talentwize.pages.Dashboard;
import talentwize.pages.EmployeeList;
import talentwize.pages.Form_EditKPIDetail;
import talentwize.pages.GoalBoard;
import talentwize.pages.GoalPreview;
import talentwize.pages.HomePage;
import talentwize.pages.KPIBoard;
import talentwize.pages.Roles;
import talentwize.pages.Users;

public class Test_FunctionalAccess_Performance_GoalBoard extends TestManager {
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
	Form_EditKPIDetail editKPIDetail;
	GoalBoard goalBoard;
	CreateGoal createGoal;
	CheckInBoard checkinBoard;
	GoalPreview goalPreview;

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
		editKPIDetail = new Form_EditKPIDetail(driver);
		checkinBoard = new CheckInBoard(driver);
		goalBoard = new GoalBoard(driver);
		createGoal = new CreateGoal(driver);
		goalPreview = new GoalPreview(driver);
		homePage.moLinkWeb(propertyManager.getURL_TalentWize());

	}

	@BeforeMethod
	public void PrintNameTestCase(Method method) {
		TestLogger.info("====== Begin Testcase : " + method.getName() + " ========");
	}

	@Test(priority = 1)
	public void TT_964() throws InterruptedException {
		TestLogger.info("=================TT_964====================");
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
		UserRoleName = "Goal Board| No permission" + TienIch.taoRandomSo(3);

		roles.createUserRoleNameWithRoleTypeAdmin(UserRoleName);

		TestLogger.info("+ unchecked all Perfomance Permission - Goal Board ");
		roles.uncheckbox_Read_GoalBoard();

		TestLogger.info("5. Click Save button");
		roles.clickButtonSave();

		administration.openTabUsers();

		TestLogger.info("Assign role " + UserRoleName + " to employee : " + propertyManager.getEmailUserTW());
		users.searchUsername(propertyManager.getEmailUserTW());

		// Assign role Automation to this employee
		users.assignUserWithNewRole(propertyManager.getEmailUserTW(), UserRoleName);

		TestLogger.info("6. Log out");

		dashboard.logout();

		TestLogger.info("7. Login with test account : " + propertyManager.getEmailUserTW1());

		homePage.SignInWith(propertyManager.getEmailUserTW(), propertyManager.getPasswordUserTW());
		administration.clickMenuPerformance();
		administration.clickMenuGoals();
		TestLogger.info("Expect :User CANNOT see/do:\r\n" + "1. Goal Board menu ");
		if (administration.isSubMenuGoalBoardDisplayed() == false) {
			setStatusTest("pass", "User CANNOT see/do:\\r\\n\" + \r\n" + "				\"1. Goal Board menu");
		} else {
			setStatusTest("fail", "User STILL CAN see/do:\r\n" + "1. Goal Board menu");
		}
		TestLogger.info("=================TT_964====================");

	}

	@Test(priority = 2)
	public void TT_962() throws InterruptedException {
		TestLogger.info("================= BEGIN - TT_962====================");
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
		UserRoleName = "Goal Board|Create" + TienIch.taoRandomSo(3);

		roles.createUserRoleNameWithRoleTypeAdmin(UserRoleName);

		TestLogger.info("+ Check on Performance Permission - Goal Board | Create");
		roles.uncheckbox_Read_GoalBoard();
		roles.checkbox_Create_GoalBoard();
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
		administration.clickMenuPerformance();
		administration.clickMenuGoals();
		administration.clickSubMenuGoadBoard();
		// choose Goal Type = Invidual
		goalBoard.clickOnGoadType();
		goalBoard.chooseInvidual();
		goalBoard.waitForPageLoaded();

		TestLogger.info("Expect :User CAN see/do:\r\n" + "1. Goal Board menu ");
		if (administration.isSubMenuGoalBoardDisplayed() == true) {
			setStatusTest("pass", "User can see/do:\\r\\n\" + \r\n" + "				\"1. Goal Board menu");
		} else {
			setStatusTest("fail", "User STILL CAN NOT see/do:\r\n" + "1. Goal Board menu");
		}

		if (goalBoard.isBtnCreateGoalDisplayed() == true && goalBoard.isBtnCloneDisplayed() == true
				&& goalBoard.isBtnExportDisplayed() == true) {
			setStatusTest("pass", "User can see /do:\r\n" + "1. Goal Board menu\r\n" + "2. Create goal btn\r\n"
					+ "3. Clone btn\r\n" + "4. List of goal table \r\n" + "5. Export button");
		} else {
			setStatusTest("fail", "User can NOT see /do:\r\n" + "1. Goal Board menu\r\n" + "2. Create goal btn\r\n"
					+ "3. Clone btn\r\n" + "4. List of goal table \r\n" + "5. Export button");
		}

		if (goalBoard.isIconDeleteDisplayed() == false && goalBoard.isListCheckboxDisplayed() == false) {
			setStatusTest("pass", "User CANNOT see/do:\r\n" + "1. Checkbox and delete btn");
		} else {
			setStatusTest("fail",
					"User STILL CANsee/do:\\r\\n\" + \r\n" + "					\"1. Checkbox and delete btn");
		}

		TestLogger.info("6. View goal detail by click goal name hyperlink");
		goalBoard.clickOnFistHyperlink();

		if (goalPreview.isBtnBackDisplayed() == true && goalPreview.isBtnCloneDisplayed() == true) {
			setStatusTest("pass",
					"User can see : 7. Back btn in Goal details page\r\n" + "8. Clone btn in Goal details page");
		} else {
			setStatusTest("fail", "User can NOT see : 7. Back btn in Goal details page\\r\\n\" + \r\n"
					+ "					\"8. Clone btn in Goal details page");
		}

		if (goalPreview.isBtnEditDisplayed() == false && goalPreview.isBtnUpdateProgressDisplayed() == false) {
			setStatusTest("pass", "User CANNOT see/do:\r\n" + "1. Checkbox and delete btn\r\n"
					+ "2. Edit btn in Goal details page\r\n" + "3. Update Progress btn in Goal details page");
		} else {
			setStatusTest("fail", "User STILL CAN see/do:\r\n" + "1. Checkbox and delete btn\r\n"
					+ "2. Edit btn in Goal details page\r\n" + "3. Update Progress btn in Goal details page");
		}
		TestLogger.info("Click Create button >>Input correct data in create form >> save");
		goalPreview.clickButtonBack();

		goalBoard.clickOnButtonCreateGoal();

		if (createGoal.createAGoal() == true) {
			setStatusTest("pass", "Added successfully");
		} else {
			setStatusTest("fail", "Added NOT successfully");
		}

		TestLogger.info("=================END - TT_962====================");

	}

	@Test(priority = 3)
	public void TT_960() throws InterruptedException {
		TestLogger.info("================= BEGIN - TT_960====================");
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
		UserRoleName = "Goal Board|Create" + TienIch.taoRandomSo(3);

		roles.createUserRoleNameWithRoleTypeAdmin(UserRoleName);

		TestLogger.info("+ Check on Performance Permission - Goal Board | Read");
		roles.uncheckbox_Read_GoalBoard();
		roles.checkbox_Read_GoalBoard();
		TestLogger.info("5. Click Save button");
		roles.clickButtonSave();
		administration.openTabUsers();

		TestLogger.info("Assign role " + UserRoleName + " to employee : " + propertyManager.getEmailUserTW());
		users.searchUsername(propertyManager.getEmailUserTW());

		// Assign role Automation to this employee
		users.assignUserWithNewRole(propertyManager.getEmailUserTW(), UserRoleName);

		TestLogger.info("6. Log out");

		dashboard.logout();

		TestLogger.info("7. Login with test account : " + propertyManager.getEmailUserTW1());

		homePage.SignInWith(propertyManager.getEmailUserTW(), propertyManager.getPasswordUserTW());
		administration.clickMenuPerformance();
		administration.clickMenuGoals();

		TestLogger.info("Expect :User CAN see/do:\r\n" + "1. Goal Board menu ");
		if (administration.isSubMenuGoalBoardDisplayed() == true) {
			administration.clickSubMenuGoadBoard();
			setStatusTest("pass", "User can see/do:\\r\\n\" + \r\n" + "				\"1. Goal Board menu");
		} else {
			setStatusTest("fail", "User STILL CAN NOT see/do:\r\n" + "1. Goal Board menu");
		}

		if (goalBoard.isBtnExportDisplayed() == true)
			setStatusTest("pass", "User can see /do: 3. Export button");
		else
			setStatusTest("fail", "\"User can NOT see /do: 3. Export button");

		if (goalBoard.isBtnCreateGoalDisplayed() == false && goalBoard.isBtnCloneDisplayed() == false
				&& goalBoard.isListCheckboxDisplayed() == false && goalBoard.isIconDeleteDisplayed() == false) {
			setStatusTest("pass", "User CANNOT see/do:\r\n" + "1. Create goal btn\r\n" + "2. Clone btn\r\n"
					+ "3. Checkbox and delete button");
		} else {
			setStatusTest("fail", "User STILL CAN see/do:\r\n" + "1. Create goal btn\r\n" + "2. Clone btn\r\n"
					+ "3. Checkbox and delete button");
		}

		goalBoard.clickOnFistHyperlink();
		if (goalPreview.isBtnBackDisplayed() == true) {
			setStatusTest("pass", "4. View goal detail by click goal name hyperlink\r\n" + "5. Back btn");
		} else {
			setStatusTest("fail", "4. View goal detail by click goal name hyperlink\r\n" + "5. Back btn");
		}

		if (goalPreview.isBtnEditDisplayed() == false && goalPreview.isBtnUpdateProgressDisplayed() == false) {
			setStatusTest("pass", " User CANNOT see/do: 4. Edit btn in Goal details page\r\n"
					+ "5. Update Progress btn in Goal details page");
		} else {
			setStatusTest("fail", " User STILL CAN see/do: 4. Edit btn in Goal details page\r\n"
					+ "5. Update Progress btn in Goal details page");
		}

		TestLogger.info("=================END - TT_960====================");

	}

	@Test(priority = 4)
	public void TT_961() throws InterruptedException {
		TestLogger.info("================= BEGIN - TT_961====================");
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
		UserRoleName = "Goal Board|Create" + TienIch.taoRandomSo(3);

		roles.createUserRoleNameWithRoleTypeAdmin(UserRoleName);

		TestLogger.info("+ Check on Performance Permission - Goal Board | Update");
		roles.uncheckbox_Read_GoalBoard();
		roles.checkbox_Update_GoalBoard();
		TestLogger.info("5. Click Save button");
		roles.clickButtonSave();
		administration.openTabUsers();

		TestLogger.info("Assign role " + UserRoleName + " to employee : " + propertyManager.getEmailUserTW());
		users.searchUsername(propertyManager.getEmailUserTW());

		// Assign role Automation to this employee
		users.assignUserWithNewRole(propertyManager.getEmailUserTW(), UserRoleName);

		TestLogger.info("6. Log out");

		dashboard.logout();

		TestLogger.info("7. Login with test account : " + propertyManager.getEmailUserTW1());

		homePage.SignInWith(propertyManager.getEmailUserTW(), propertyManager.getPasswordUserTW());
		administration.clickMenuPerformance();
		administration.clickMenuGoals();

		TestLogger.info("Expect :User CAN see/do:\r\n" + "1. Goal Board menu ");
		if (administration.isSubMenuGoalBoardDisplayed() == true) {
			administration.clickSubMenuGoadBoard();
			setStatusTest("pass", "User can see/do:\\r\\n\" + \r\n" + "				\"1. Goal Board menu");
		} else {
			setStatusTest("fail", "User STILL CAN NOT see/do:\r\n" + "1. Goal Board menu");
		}

		if (goalBoard.isBtnExportDisplayed() == true)
			setStatusTest("pass", "User can see /do: 3. Export button");
		else
			setStatusTest("fail", "\"User can NOT see /do: 3. Export button");

		if (goalBoard.isBtnCreateGoalDisplayed() == false && goalBoard.isBtnCloneDisplayed() == false
				&& goalBoard.isListCheckboxDisplayed() == false && goalBoard.isIconDeleteDisplayed() == false) {
			setStatusTest("pass", "User CANNOT see/do:\r\n" + "1. Create goal btn\r\n" + "2. Clone btn\r\n"
					+ "3. Checkbox and delete button");
		} else {
			setStatusTest("fail", "User STILL CAN see/do:\r\n" + "1. Create goal btn\r\n" + "2. Clone btn\r\n"
					+ "3. Checkbox and delete button");
		}

		goalBoard.clickOnFistHyperlink();

		if (goalPreview.isBtnEditDisplayed() == true) {
			setStatusTest("pass", " User CAN see/do: 4. Edit btn in Goal details page\r\n"
					+ "5. Update Progress btn in Goal details page");
		} else {
			setStatusTest("fail", " User CAN NOT see/do: 4. Edit btn in Goal details page\r\n"
					+ "5. Update Progress btn in Goal details page");
		}

		if (goalPreview.editAGoal() == true) {
			setStatusTest("pass", "Edit successfully");
		} else {
			setStatusTest("fail", "Edit NOT successfully");
		}

		TestLogger.info("=================END - TT_961====================");

	}

	@Test(priority = 5)
	public void TT_963() throws InterruptedException {
		TestLogger.info("================= BEGIN - TT_963====================");
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
		UserRoleName = "Goal Board|Create" + TienIch.taoRandomSo(3);

		roles.createUserRoleNameWithRoleTypeAdmin(UserRoleName);

		TestLogger.info("+ Check on Performance Permission - Goal Board | Delete");
		roles.uncheckbox_Read_GoalBoard();
		roles.checkbox_Delete_GoalBoard();
		TestLogger.info("5. Click Save button");
		roles.clickButtonSave();
		administration.openTabUsers();

		TestLogger.info("Assign role " + UserRoleName + " to employee : " + propertyManager.getEmailUserTW());
		users.searchUsername(propertyManager.getEmailUserTW());

		// Assign role Automation to this employee
		users.assignUserWithNewRole(propertyManager.getEmailUserTW(), UserRoleName);

		TestLogger.info("6. Log out");

		dashboard.logout();

		TestLogger.info("7. Login with test account : " + propertyManager.getEmailUserTW1());

		homePage.SignInWith(propertyManager.getEmailUserTW(), propertyManager.getPasswordUserTW());
		administration.clickMenuPerformance();
		administration.clickMenuGoals();

		TestLogger.info("Expect :User CAN see/do:\r\n" + "1. Goal Board menu ");
		if (administration.isSubMenuGoalBoardDisplayed() == true) {
			administration.clickSubMenuGoadBoard();
			setStatusTest("pass", "User can see/do:\\r\\n\" + \r\n" + "				\"1. Goal Board menu");
		} else {
			setStatusTest("fail", "User STILL CAN NOT see/do:\r\n" + "1. Goal Board menu");
		}

		if (goalBoard.isBtnExportDisplayed() == true)
			setStatusTest("pass", "User can see /do: 3. Export button");
		else
			setStatusTest("fail", "\"User can NOT see /do: 3. Export button");

		if (goalBoard.isListCheckboxDisplayed() == true && goalBoard.isIconDeleteDisplayed() == true) {
			setStatusTest("pass", "User can see /do: 4. Checkbox and delete button");
		} else {
			setStatusTest("fail", "USER CAN NOT SEE : 4. Checkbox and delete button");
		}

		if (goalBoard.isBtnCreateGoalDisplayed() == false && goalBoard.isBtnCloneDisplayed() == false) {
			setStatusTest("pass", "User CANNOT see/do:\r\n" + "1. Create goal btn\r\n" + "2. Clone btn");
		} else {
			setStatusTest("fail", "User STILL CAN see/do:\r\n" + "1. Create goal btn\r\n" + "2. Clone btn");
		}

		goalBoard.clickOnFistHyperlink();

		if (goalPreview.isBtnBackDisplayed() == true && goalPreview.isBtnEditDisplayed() == false
				&& goalPreview.isBtnUpdateProgressDisplayed() == false) {
			setStatusTest("pass", "User CANNOT see/do:\r\n" + "" + "3. Edit btn in Goal details page\r\n"
					+ "4. Update Progress btn in Goal details page");
		} else {
			setStatusTest("fail", "User STILL CAN see/do:\r\n" + "" + "3. Edit btn in Goal details page\r\n"
					+ "4. Update Progress btn in Goal details page");
		}

		goalPreview.clickButtonBack();

		if (goalBoard.deleteAGoal() == true) {
			setStatusTest("pass", "Delete Successfully");
		} else {
			setStatusTest("fail", "Delete NOT Successfully");
		}

		TestLogger.info("=================END - TT_963====================");

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
