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
import talentwize.pages.CareerDevelopmentBoard;
import talentwize.pages.Dashboard;
import talentwize.pages.Form_CreateCareerDevelopment;
import talentwize.pages.Form_EditCareerDevelopment;
import talentwize.pages.HomePage;
import talentwize.pages.MyCareerDevelopment;
import talentwize.pages.Roles;
import talentwize.pages.Users;

//Bug : TAL-534
public class Test_TalentPermission_CareerDevelopment_MyCareerDevelopment extends TestManager {
	HomePage homePage;
	WebDriver driver;
	PropertyManager propertyManager;
	Dashboard dashboard;
	Administration administration;
	Users users;
	Roles roles;
	String UserRoleName;
	String NameOfProgram;
	MyCareerDevelopment myCareerDevelopment;
	Form_EditCareerDevelopment formEditCareerDevelopment;
	Form_CreateCareerDevelopment formCreateCareerDevelopment;
	CareerDevelopmentBoard careerDevelopmentBoard;

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
		myCareerDevelopment = new MyCareerDevelopment(driver);
		formEditCareerDevelopment = new Form_EditCareerDevelopment(driver);
		formCreateCareerDevelopment = new Form_CreateCareerDevelopment(driver);
		careerDevelopmentBoard = new CareerDevelopmentBoard(driver);
		homePage.moLinkWeb(propertyManager.getURL_TalentWize());
	}

	@BeforeMethod
	public void PrintNameTestCase(Method method) {
		TestLogger.info("====== Begin Testcase : " + method.getName() + " ========");
	}

	@Test(priority = 1)
	public void TT_1173() throws InterruptedException {
		TestLogger.info("========== TT_1173================");
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

		TestLogger.info("3. Create Automation User Role Name and Role Type is User :");
		UserRoleName = "Permission|MyCareerDevelopment|NoPermission" + TienIch.taoRandomSo(3);

		roles.createUserRoleNameWithRoleTypeUser(UserRoleName);

		TestLogger.info("4. Uncheck | Career Development - My Career Development | Read");
		roles.uncheckbox_Read_CareerDevelopment_MyCareerDevelopment();

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

		TestLogger.info("8. Check permission");
		administration.clickLogoTalentWize();
		administration.clickMenuTalentManagement();

		TestLogger.info("Expect : User CANNOT see /do:\r\n" + "Sub Menu Career Development");
		if (administration.isSubMeunuCareerDevelopmentDisplayed() == false) {
			setStatusTest("pass", "User CANNOT see/do:\r\n" + "Sub Menu Career Development");
		} else {
			setStatusTest("fail", "User CAN see/do:\r\n" + "Sub Menu Career Development");
		}

		TestLogger.info("==========End TT_1173================");
	}

	// Case 1171 : cần thêm step để vào lại account admin để check xem account của
	// thằng User đó có career list
	// có cái nào đang có status là In Progress không để tiến hành canceled lại path
	// Career đó,
	// nếu không khi mình tạo Create Career Development mới nó sẽ báo không thể tạo
	// được
	@Test(priority = 2)
	public void TT_1171() throws InterruptedException {
		TestLogger.info("========== TT_1171================");
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

		TestLogger.info("3. Create Automation User Role Name and Role Type is User :");
		UserRoleName = "Permission|MyCareerDevelopment|Create" + TienIch.taoRandomSo(3);

		roles.createUserRoleNameWithRoleTypeUser(UserRoleName);

		TestLogger.info("4. Uncheck | Career Development - My Career Development | Read");
		roles.uncheckbox_Read_CareerDevelopment_MyCareerDevelopment();

		TestLogger.info("5. Check | Career Development - My Career Development | Create");
		roles.checkbox_Create_CareerDevelopment_MyCareerDevelopment();

		TestLogger.info("6. Click on button Save");
		roles.clickButtonSave();

		administration.openTabUsers();

		TestLogger.info("Assign role " + UserRoleName + " to employee : " + propertyManager.getEmailCuongUser());
		users.searchUsername(propertyManager.getEmailCuongUser());

		// Assign role Automation to this employee
		users.assignUserWithNewRole(propertyManager.getEmailCuongUser(), UserRoleName);

		TestLogger.info("9. Talent Management >>  Career Development >> My Development");
		administration.clickLogoTalentWize();
		administration.clickMenuTalentManagement();
		administration.clickSubMenuCareerDevelopment();

		TestLogger.info("7. Log out");

		dashboard.logout();

		TestLogger.info("8. Login with test account : " + propertyManager.getEmailCuongUser());

		homePage.SignInWith(propertyManager.getEmailCuongUser(), propertyManager.getPasswordCuongUser());

		TestLogger.info("9. Talent Management >>  Career Development >> My Development");
		administration.clickLogoTalentWize();
		administration.clickMenuTalentManagement();
		administration.clickSubMenuCareerDevelopment();
		administration.clickSubMenuMyDevelopment();

		TestLogger.info("10. Create Career Development");
		myCareerDevelopment.clickBtnCreate();
		formCreateCareerDevelopment.createCareerDevelopment("Tester", "Tester");
		formCreateCareerDevelopment.sumitCareerDevelopment("Description");

		TestLogger.info("Expect : User CAN see /do:\r\n" + "Create career development request successfully!");
		if (myCareerDevelopment.isMsgCreateCareerSuccessDisplayed() == true) {
			setStatusTest("pass", "User CAN see/do:\r\n" + "Create career development request successfully!");
		} else {
			setStatusTest("fail", "User CANNOT see/do:\r\n" + "Create career development request successfully!");
		}

		TestLogger.info("11. Check permission");

		TestLogger.info(
				"Expect : User CAN see /do:\r\n" + "1. Data table\r\n" + "2. link Position\r\n" + "3. button Create");

		if (myCareerDevelopment.isLblMyCareerDisplayed() == true) {
			setStatusTest("pass", "User CAN see/do:\r\n" + "Data table");
		} else {
			setStatusTest("fail", "User CANNOT see/do:\r\n" + "Data table");
		}

		if (myCareerDevelopment.isLinkPositionDisplayed() == true) {
			setStatusTest("pass", "User CAN see/do:\r\n" + "link Position");
		} else {
			setStatusTest("fail", "User CAN see/do:\r\n" + "link Position");
		}

		if (myCareerDevelopment.isBtnCreateDisplayed() == true) {
			setStatusTest("pass", "User CAN see/do:\r\n" + "button Create");
		} else {
			setStatusTest("fail", "User CANNOT see/do:\r\n" + "button Create");
		}

		TestLogger.info("Expect : User CANNOT see /do:\r\n" + "1. Edit function (Status = In Progress)\r\n"
				+ "2. button Cancel Request (Status = Pending)");

		if (myCareerDevelopment.isBtnCancelRequestDisplayed() == false) {
			setStatusTest("pass", "User CANNOT see/do:\r\n" + "button Cancel Request (Status = Pending)");
		} else {
			setStatusTest("fail", "User STILL CAN see/do:\r\n" + "button Cancel Request (Status = Pending)");
		}

		myCareerDevelopment.clickLinkPosition();
		if (formEditCareerDevelopment.isBtnEditDisplayed() == false) {
			setStatusTest("pass", "User CANNOT see/do:\r\n" + "Edit function (Status = In Progress)");
		} else {
			setStatusTest("fail", "User STILL CAN see/do:\r\n" + "Edit function (Status = In Progress)");
		}

		TestLogger.info("==========End TT_1171================");
	}

	@Test(priority = 3)
	public void TT_1170() throws InterruptedException {
		TestLogger.info("========== TT_1170================");
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

		TestLogger.info("3. Create Automation User Role Name and Role Type is User :");
		UserRoleName = "Permission|MyCareerDevelopment|Read" + TienIch.taoRandomSo(3);

		roles.createUserRoleNameWithRoleTypeAdmin(UserRoleName);

		TestLogger.info("4. Uncheck | Career Development - My Career Development | Read");
		roles.uncheckbox_Read_CareerDevelopment_MyCareerDevelopment();

		TestLogger.info("5. Check | Career Development - My Career Development | Read");
		roles.checkbox_Read_CareerDevelopment_MyCareerDevelopment();

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

		TestLogger.info("9. Talent Management >>  Career Development >> My Development");
		administration.clickLogoTalentWize();
		administration.clickMenuTalentManagement();
		administration.clickSubMenuCareerDevelopment();
		administration.clickSubMenuMyDevelopment();

		TestLogger.info("10. Check permission");

		TestLogger.info("Expect : User CAN see /do:\r\n" + "1. Data table\r\n" + "2. Link Position");

		if (myCareerDevelopment.isLblMyCareerDisplayed() == true) {
			setStatusTest("pass", "User CAN see/do:\r\n" + "Data table");
		} else {
			setStatusTest("fail", "User CANNOT see/do:\r\n" + "Data table");
		}

		if (myCareerDevelopment.isLinkPositionDisplayed() == true) {
			setStatusTest("pass", "User CAN see/do:\r\n" + "link Position");
		} else {
			setStatusTest("fail", "User CAN see/do:\r\n" + "link Position");
		}

		TestLogger.info("Expect : User CANNOT see /do:\r\n" + "1. Edit function (Status = In Progress)\r\n"
				+ "2. button Cancel Request (Status = Pending)\r\n" + "3. button Create");

		if (myCareerDevelopment.isBtnCreateDisplayed() == false) {
			setStatusTest("pass", "User CAN see/do:\r\n" + "button Create");
		} else {
			setStatusTest("fail", "User CANNOT see/do:\r\n" + "button Create");
		}

		if (myCareerDevelopment.isBtnCancelRequestDisplayed() == false) {
			setStatusTest("pass", "User CANNOT see/do:\r\n" + "button Cancel Request (Status = Pending)");
		} else {
			setStatusTest("fail", "User STILL CAN see/do:\r\n" + "button Cancel Request (Status = Pending)");
		}

		myCareerDevelopment.clickLinkPosition();
		if (formEditCareerDevelopment.isBtnEditDisplayed() == false) {
			setStatusTest("pass", "User CANNOT see/do:\r\n" + "Edit function (Status = In Progress)");
		} else {
			setStatusTest("fail", "User STILL CAN see/do:\r\n" + "Edit function (Status = In Progress)");
		}

		TestLogger.info("==========End TT_1170================");
	}

	// Bug : TAL-534
	@Test(priority = 4)
	public void TT_1168() throws InterruptedException {
		TestLogger.info("========== TT_1168================");
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

		TestLogger.info("3. Create Automation User Role Name and Role Type is User :");
		UserRoleName = "Permission|MyCareerDevelopment|Update" + TienIch.taoRandomSo(3);

		roles.createUserRoleNameWithRoleTypeAdmin(UserRoleName);

		TestLogger.info("4. Uncheck | Career Development - My Career Development | Read");
		roles.uncheckbox_Read_CareerDevelopment_MyCareerDevelopment();

		TestLogger.info("5. Check | Career Development - My Career Development | Update");
		roles.checkbox_Update_CareerDevelopment_MyCareerDevelopment();

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

		TestLogger.info("9. Talent Management >>  Career Development >> My Development");
		administration.clickLogoTalentWize();
		administration.clickMenuTalentManagement();
		administration.clickSubMenuCareerDevelopment();
		administration.clickSubMenuMyDevelopment();

		TestLogger.info("10. Check permission");

		TestLogger.info("Expect : User CAN see /do:\r\n" + "1. Data table\r\n" + "2. link Position\r\n"
				+ "3. button Cancel Request (Status = Pending)");

		if (myCareerDevelopment.isLblMyCareerDisplayed() == true) {
			setStatusTest("pass", "User CAN see/do:\r\n" + "Data table");
		} else {
			setStatusTest("fail", "User CANNOT see/do:\r\n" + "Data table");
		}

		if (myCareerDevelopment.isLinkPositionDisplayed() == true) {
			setStatusTest("pass", "User CAN see/do:\r\n" + "Data table");
		} else {
			setStatusTest("fail", "User CANNOT see/do:\r\n" + "Data table");
		}

		if (myCareerDevelopment.isBtnCancelRequestDisplayed() == true) {
			setStatusTest("pass", "User CAN see/do:\r\n" + "button Cancel Request (Status = Pending)");
		} else {
			setStatusTest("fail", "User CANNOT see/do:\r\n" + "button Cancel Request (Status = Pending)");
		}

		TestLogger.info("Expect : User CANNOT see /do:\r\n" + "button Create");

		if (myCareerDevelopment.isBtnCreateDisplayed() == false) {
			setStatusTest("pass", "User CANNOT see/do:\r\n" + "button Create");
		} else {
			setStatusTest("fail", "User STILL CAN see/do:\r\n" + "button Create");
		}

		TestLogger.info("11. Cancel Request");
		if (myCareerDevelopment.isBtnCancelRequestDisplayed() == true) {
			myCareerDevelopment.cancelRequest();
		}

		TestLogger.info("Expect : User CAN see /do:\r\n" + "Stauts Cancel");
		if (myCareerDevelopment.isLblStatusCancelDisplayed() == true) {
			setStatusTest("pass", "User CAN see/do:\r\n" + "Stauts Cancel");
		} else {
			setStatusTest("fail", "User CANNOT see/do:\r\n" + "Stauts Cancel");
		}

		TestLogger.info("12. Log out");

		dashboard.logout();

		TestLogger.info("13. Login with Administrator account.");
		homePage.SignInWith(propertyManager.getEmailCuongAdmin(), propertyManager.getPasswordCuongAdmin());

		if (dashboard.isDashboardMenuDisplayed() == true) {
			setStatusTest("pass", "Login successfully!");
		} else {
			setStatusTest("fail", "Login fail!");
		}

		TestLogger.info("14. Go to Administration - User Management - Roles tab");
		administration.clickMenuAdministration();
		administration.clickMenuUserManagement();
		administration.openRolesTab();

		TestLogger.info("15. Create Automation User Role Name and Role Type is User :");
		UserRoleName = "Permission|MyCareerDevelopment|Full" + TienIch.taoRandomSo(3);

		roles.createUserRoleNameWithRoleTypeAdmin(UserRoleName);

		TestLogger.info("16. Uncheck | Career Development - My Career Development | Read");
		roles.uncheckbox_Read_CareerDevelopment_MyCareerDevelopment();

		TestLogger.info("17. Check | Career Development - My Career Development | Create + Update");
		roles.checkbox_Update_CareerDevelopment_MyCareerDevelopment();
		roles.checkbox_Create_CareerDevelopment_MyCareerDevelopment();

		TestLogger.info("18. Click on button Save");
		roles.clickButtonSave();

		administration.openTabUsers();

		TestLogger.info("Assign role " + UserRoleName + " to employee : " + propertyManager.getEmailCuongUser());
		users.searchUsername(propertyManager.getEmailCuongUser());

		// Assign role Automation to this employee
		users.assignUserWithNewRole(propertyManager.getEmailCuongUser(), UserRoleName);

		TestLogger.info("19. Log out");

		dashboard.logout();

		TestLogger.info("20. Login with test account : " + propertyManager.getEmailCuongUser());

		homePage.SignInWith(propertyManager.getEmailCuongUser(), propertyManager.getPasswordCuongUser());

		TestLogger.info("21. Talent Management >>  Career Development >> My Development");
		administration.clickLogoTalentWize();
		administration.clickMenuTalentManagement();
		administration.clickSubMenuCareerDevelopment();
		administration.clickSubMenuMyDevelopment();

		TestLogger.info("22. Create Career Development");
		myCareerDevelopment.clickBtnCreate();
		formCreateCareerDevelopment.createCareerDevelopment("Tester", "Tester");
		formCreateCareerDevelopment.sumitCareerDevelopment("Description");

		TestLogger.info("23. Log out");

		dashboard.logout();

		TestLogger.info("24. Login with test account : " + propertyManager.getEmailCuongAdmin());

		homePage.SignInWith(propertyManager.getEmailCuongAdmin(), propertyManager.getPasswordCuongAdmin());

		TestLogger.info("25. Talent Management >>  Career Development >> Menu Developement Board");
		administration.clickLogoTalentWize();
		administration.clickMenuTalentManagement();
		administration.clickSubMenuCareerDevelopment();
		administration.clickSubmenuDevelopementBoard();

		TestLogger.info("26. Approve Request");
		careerDevelopmentBoard.filterStatusPeding("Pending");
		careerDevelopmentBoard.clickBtnReview();
		careerDevelopmentBoard.clickBtnApproveRequest();

		TestLogger.info("Expect : User CAN see /do:\r\n" + "Approve career development request successfully!");
		if (careerDevelopmentBoard.isMsgApproveSuccessDisplayed() == true) {
			setStatusTest("pass", "User CAN see/do:\r\n" + "Approve career development request successfully!");
		} else {
			setStatusTest("fail", "User CANNOT see/do:\r\n" + "Approve career development request successfully!");
		}

		TestLogger.info("27. Log out");

		dashboard.logout();

		TestLogger.info("28. Login with test account : " + propertyManager.getEmailCuongUser());

		homePage.SignInWith(propertyManager.getEmailCuongUser(), propertyManager.getPasswordCuongUser());

		TestLogger.info("29. Talent Management >>  Career Development >> My Development");
		administration.clickLogoTalentWize();
		administration.clickMenuTalentManagement();
		administration.clickSubMenuCareerDevelopment();
		administration.clickSubMenuMyDevelopment();

		TestLogger.info("30. Update Progress");
		if (myCareerDevelopment.isLinkPositionInprogressDisplayed() == true) {
			myCareerDevelopment.clickLinkPositionInprogress();
		}

		if (formEditCareerDevelopment.isBtnEditDisplayed() == true) {
			setStatusTest("pass", "User CAN see/do:\r\n" + "Edit function (Status = In Progress)");
		} else {
			setStatusTest("fail", "User CANNOT see/do:\r\n" + "Edit function (Status = In Progress)");
		}

		formEditCareerDevelopment.updateProgress("Test Automation");

		TestLogger.info("Expect : User CAN see /do:\r\n" + "Submit successfully!");
		if (formEditCareerDevelopment.isMsgSummitSuccessDisplayed() == true) {
			setStatusTest("pass", "User CAN see/do:\r\n" + "Submit successfully!");
		} else {
			setStatusTest("fail", "User CANNOT see/do:\r\n" + "Submit successfully!");
		}

		TestLogger.info("==========End TT_1168================");
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