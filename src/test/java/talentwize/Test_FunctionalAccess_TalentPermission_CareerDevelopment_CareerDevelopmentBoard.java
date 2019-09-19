package talentwize;

import java.lang.reflect.Method;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Ulties.PropertyManager;
import Ulties.TestLogger;
import Ulties.TestManager;
import Ulties.TienIch;
import controller.WebDriversManager;
import talentwize.pages.Administration;
import talentwize.pages.CareerDevelopmentBoard;
import talentwize.pages.CareerDevelopmentUpdateProgress;
import talentwize.pages.Dashboard;
import talentwize.pages.Form_CreateCareerDevelopment;
import talentwize.pages.HomePage;
import talentwize.pages.MyCareerDevelopment;
import talentwize.pages.Roles;
import talentwize.pages.Users;

//Bug TAL-494
public class Test_FunctionalAccess_TalentPermission_CareerDevelopment_CareerDevelopmentBoard extends TestManager {
	HomePage homePage;
	WebDriver driver;
	PropertyManager propertyManager;
	Dashboard dashboard;
	Administration administration;
	Users users;
	Roles roles;
	String UserRoleName;
	CareerDevelopmentBoard careerDevelopmentBoard;
	MyCareerDevelopment myCareerDevelopment;
	Form_CreateCareerDevelopment formCreateCareerDevelopment;
	CareerDevelopmentUpdateProgress careerDevelopmentUpdateProgress;

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
		careerDevelopmentBoard = new CareerDevelopmentBoard(driver);
		myCareerDevelopment = new MyCareerDevelopment(driver);
		formCreateCareerDevelopment = new Form_CreateCareerDevelopment(driver);
		careerDevelopmentUpdateProgress = new CareerDevelopmentUpdateProgress(driver);
		homePage.moLinkWeb(propertyManager.getURL_TalentWize());
	}

	@Test(priority = 1)
	public void TT_1116() throws InterruptedException {
		TestLogger.info("=================TT_1116 ====================");
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
		UserRoleName = "Career Development Board|Read|No permission" + TienIch.taoRandomSo(3);

		roles.createUserRoleNameWithRoleTypeAdmin(UserRoleName);

		TestLogger.info("+ Unchecked on Talent Permission - Career Development - Career Development Board | Read");
		roles.uncheckbox_Read_CareerDevelopment_CareerDevelopmentBoard();

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

		TestLogger.info("Open Talent Management >> Development Board ");
		administration.clickMenuTalentManagement();
		administration.clickSubmenuCareerDevelopment();
		if (administration.isSubMenuDevelopementBoardDisplayed() == false) {
			setStatusTest("pass", "User CANNOT see/do:\r\n" + "1. Task menu");
		} else {
			setStatusTest("fail", "User STILL CAN see/do:\r\n" + "1. Task menu");
		}

		TestLogger.info("=================END TT_1116====================");

	}

	// Bug TAL-494
	@Test(priority = 2)
	public void TT_1114() throws InterruptedException {
		TestLogger.info("========== TT_1114================");
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
		UserRoleName = "Permission|CareerDevelopment|Create" + TienIch.taoRandomSo(3);

		roles.createUserRoleNameWithRoleTypeAdmin(UserRoleName);

		TestLogger.info("4. Uncheck Performance - Career Development Board | Read");
		roles.uncheckbox_Read_CareerDevelopment_CareerDevelopmentBoard();

		TestLogger.info("5. Check Performance - Career Development Board | Create");
		roles.checkbox_Create_CareerDevelopment_CareerDevelopmentBoard();

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

		TestLogger.info("9. Create Career Development");
		administration.clickLogoTalentWize();
		administration.clickMenuTalentManagement();
		administration.clickSubMenuCareerDevelopment();
		administration.clickSubMenuMyDevelopment();

		TestLogger.info("Expect : User can see /do:\r\n" + "Title Career Development");
		if (myCareerDevelopment.isLblMyCareerDisplayed() == true) {
			setStatusTest("pass", "User CAN see/do:\r\n" + "Title Career Development");
		} else {
			setStatusTest("fail", "User CANNOT see/do:\r\n" + "Title Career Development");
		}

		myCareerDevelopment.clickBtnCreate();
		formCreateCareerDevelopment.createCareerDevelopment("Tester", "Tester");
		formCreateCareerDevelopment.sumitCareerDevelopment("Description");

		TestLogger.info("Expect : User CAN see /do:\r\n" + "Create career development request successfully!");
		if (myCareerDevelopment.isMsgCreateCareerSuccessDisplayed() == true) {
			setStatusTest("pass", "User CAN see/do:\r\n" + "Create career development request successfully!");
		} else {
			setStatusTest("fail", "User CANNOT see/do:\r\n" + "Create career development request successfully!");
		}

		TestLogger.info("10. Log out");

		dashboard.logout();

		TestLogger.info("11. Login with test account : " + propertyManager.getEmailCuongUser2());

		homePage.SignInWith(propertyManager.getEmailCuongUser2(), propertyManager.getPasswordCuongUser2());

		TestLogger.info("12. Open Talent Management >> Development Board");
		administration.clicksubMenuDevelopmentBoard();
		careerDevelopmentBoard.fillTxtSearchRequestor("cuong automation");

		TestLogger.info("Expect : User CAN see /do:\r\n" + "1. Data table\r\n" + "2. Link Requestor\r\n"
				+ "3. button Manage\r\n" + "4. button Review");
		if (careerDevelopmentBoard.isLblCareerDevRequestDisplayed() == true) {
			setStatusTest("pass", "User CAN see/do:\r\n" + "Data table");
		} else {
			setStatusTest("fail", "User CANNOT see/do:\r\n" + "Data table");
		}

		if (careerDevelopmentBoard.isLinkEditDisplayed() == true) {
			setStatusTest("pass", "User CAN see/do:\r\n" + "Link Requestor");
		} else {
			setStatusTest("fail", "User CANNOT see/do:\r\n" + "Link Requestor");
		}

		if (careerDevelopmentBoard.isBtnManageDisplayed() == true) {
			setStatusTest("pass", "User CAN see/do:\r\n" + "button Manage");
		} else {
			setStatusTest("fail", "User CANNOT see/do:\r\n" + "button Manage");
		}

		careerDevelopmentBoard.filterStatusPeding("Pending");
		if (careerDevelopmentBoard.isBtnReviewDisplayed() == true) {
			setStatusTest("pass", "User CAN see/do:\r\n" + "button Review");
		} else {
			setStatusTest("fail", "User CANNOT see/do:\r\n" + "button Review");
		}

		TestLogger.info("13. Open Talent Management >> Development Board >> Click on button Review");
		careerDevelopmentBoard.clickBtnReview();

		TestLogger.info("Expect : User CAN see /do:\r\n" + "You do not have permission to approve.");
		if (careerDevelopmentBoard.isMsgErrorDisplayed() == true) {
			setStatusTest("pass", "User CAN see/do:\r\n" + "You do not have permission to approve.");
		} else {
			setStatusTest("fail", "User CANNOT see/do:\r\n" + "You do not have permission to approve.");
		}

		TestLogger.info("==========End TT_1114================");
	}

	@Test(priority = 3)
	public void TT_1113() throws InterruptedException {
		TestLogger.info("========== TT_1113================");
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
		UserRoleName = "Permission|CareerDevelopment|Update" + TienIch.taoRandomSo(3);

		roles.createUserRoleNameWithRoleTypeAdmin(UserRoleName);

		TestLogger.info("4. Uncheck Performance - Career Development Board | Read");
		roles.uncheckbox_Read_CareerDevelopment_CareerDevelopmentBoard();

		TestLogger.info("5. Check Performance - Career Development Board | Update");
		roles.checkbox_Update_CareerDevelopment_CareerDevelopmentBoard();

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

		TestLogger.info("9. Create Career Development");
		administration.clickLogoTalentWize();
		administration.clickMenuTalentManagement();
		administration.clickSubMenuCareerDevelopment();
		administration.clickSubMenuMyDevelopment();

		TestLogger.info("Expect : User can see /do:\r\n" + "Title Career Development");
		if (myCareerDevelopment.isLblMyCareerDisplayed() == true) {
			setStatusTest("pass", "User CAN see/do:\r\n" + "Title Career Development");
		} else {
			setStatusTest("fail", "User CANNOT see/do:\r\n" + "Title Career Development");
		}

		myCareerDevelopment.clickBtnCreate();
		formCreateCareerDevelopment.createCareerDevelopment("Tester", "Tester");
		formCreateCareerDevelopment.sumitCareerDevelopment("Description");

		TestLogger.info("Expect : User CAN see /do:\r\n" + "Create career development request successfully!");
		if (myCareerDevelopment.isMsgCreateCareerSuccessDisplayed() == true) {
			setStatusTest("pass", "User CAN see/do:\r\n" + "Create career development request successfully!");
		} else {
			setStatusTest("fail", "User CANNOT see/do:\r\n" + "Create career development request successfully!");
		}

		TestLogger.info("10. Log out");

		dashboard.logout();

		TestLogger.info("11. Login with test account : " + propertyManager.getEmailCuongUser2());

		homePage.SignInWith(propertyManager.getEmailCuongUser2(), propertyManager.getPasswordCuongUser2());

		TestLogger.info("12. Open Talent Management >> Development Board");
		administration.clicksubMenuDevelopmentBoard();
		careerDevelopmentBoard.fillTxtSearchRequestor("cuong automation");

		TestLogger.info("Expect : User CAN see /do:\r\n" + "1. Data table\r\n" + "2. Link Requestor\r\n"
				+ "3. button Manage\r\n" + "4. button Review");
		if (careerDevelopmentBoard.isLblCareerDevRequestDisplayed() == true) {
			setStatusTest("pass", "User CAN see/do:\r\n" + "Data table");
		} else {
			setStatusTest("fail", "User CANNOT see/do:\r\n" + "Data table");
		}

		if (careerDevelopmentBoard.isLinkEditDisplayed() == true) {
			setStatusTest("pass", "User CAN see/do:\r\n" + "Link Requestor");
		} else {
			setStatusTest("fail", "User CANNOT see/do:\r\n" + "Link Requestor");
		}

		if (careerDevelopmentBoard.isBtnManageDisplayed() == true) {
			setStatusTest("pass", "User CAN see/do:\r\n" + "button Manage");
		} else {
			setStatusTest("fail", "User CANNOT see/do:\r\n" + "button Manage");
		}

		careerDevelopmentBoard.filterStatusPeding("Pending");
		if (careerDevelopmentBoard.isBtnReviewDisplayed() == true) {
			setStatusTest("pass", "User CAN see/do:\r\n" + "button Review");
		} else {
			setStatusTest("fail", "User CANNOT see/do:\r\n" + "button Review");
		}

		TestLogger.info("13. Approve request");
		careerDevelopmentBoard.clickBtnReview();
		careerDevelopmentBoard.clickBtnApproveRequest();

		TestLogger.info("Expect : User CAN see /do:\r\n" + "Approve career development request successfully!");
		if (careerDevelopmentBoard.isMsgApproveSuccessDisplayed() == true) {
			setStatusTest("pass", "User CAN see/do:\r\n" + "Approve career development request successfully!");
		} else {
			setStatusTest("fail", "User CANNOT see/do:\r\n" + "Approve career development request successfully!");
		}

		TestLogger.info("14. Update progress");
		careerDevelopmentBoard.fillTxtSearchRequestor("cuong automation");
		careerDevelopmentBoard.filterStatusInProgress("In Progress");
		careerDevelopmentBoard.clickBtnManage();
		careerDevelopmentUpdateProgress.updateProgress("Comment test");

		TestLogger.info("Expect : User CAN see /do:\r\n" + "Submit successfully!");
		if (careerDevelopmentUpdateProgress.isMsgSummitSuccessDisplayed() == true) {
			setStatusTest("pass", "User CAN see/do:\r\n" + "Submit successfully!");
		} else {
			setStatusTest("fail", "User CANNOT see/do:\r\n" + "Submit successfully!");
		}

		TestLogger.info("==========End TT_1113================");
	}

	// Bug TAL-494
	@Test(priority = 4)
	public void TT_1112() throws InterruptedException {
		TestLogger.info("========== TT_1112================");
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
		UserRoleName = "Permission|CareerDevelopment|Read" + TienIch.taoRandomSo(3);

		roles.createUserRoleNameWithRoleTypeAdmin(UserRoleName);

		TestLogger.info("4. Uncheck Performance - Career Development Board | Read");
		roles.uncheckbox_Read_CareerDevelopment_CareerDevelopmentBoard();

		TestLogger.info("5. Check Performance - Career Development Board | Read");
		roles.checkbox_Read_CareerDevelopment_CareerDevelopmentBoard();

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

		TestLogger.info("9. Create Career Development");
		administration.clickLogoTalentWize();
		administration.clickMenuTalentManagement();
		administration.clickSubMenuCareerDevelopment();
		administration.clickSubMenuMyDevelopment();

		TestLogger.info("Expect : User can see /do:\r\n" + "Title Career Development");
		if (myCareerDevelopment.isLblMyCareerDisplayed() == true) {
			setStatusTest("pass", "User CAN see/do:\r\n" + "Title Career Development");
		} else {
			setStatusTest("fail", "User CANNOT see/do:\r\n" + "Title Career Development");
		}

		myCareerDevelopment.clickBtnCreate();
		formCreateCareerDevelopment.createCareerDevelopment("Tester", "Tester");
		formCreateCareerDevelopment.sumitCareerDevelopment("Description");

		TestLogger.info("Expect : User CAN see /do:\r\n" + "Create career development request successfully!");
		if (myCareerDevelopment.isMsgCreateCareerSuccessDisplayed() == true) {
			setStatusTest("pass", "User CAN see/do:\r\n" + "Create career development request successfully!");
		} else {
			setStatusTest("fail", "User CANNOT see/do:\r\n" + "Create career development request successfully!");
		}

		TestLogger.info("10. Log out");

		dashboard.logout();

		TestLogger.info("11. Login with test account : " + propertyManager.getEmailCuongUser2());

		homePage.SignInWith(propertyManager.getEmailCuongUser2(), propertyManager.getPasswordCuongUser2());

		TestLogger.info("12. Open Talent Management >> Development Board");
		administration.clicksubMenuDevelopmentBoard();
		careerDevelopmentBoard.fillTxtSearchRequestor("cuong automation");

		TestLogger.info(
				"Expect : User CAN see /do:\r\n" + "1. Data table\r\n" + "2. Link Requestor\r\n" + "3. button Manage");
		if (careerDevelopmentBoard.isLblCareerDevRequestDisplayed() == true) {
			setStatusTest("pass", "User CAN see/do:\r\n" + "Data table");
		} else {
			setStatusTest("fail", "User CANNOT see/do:\r\n" + "Data table");
		}

		if (careerDevelopmentBoard.isLinkEditDisplayed() == true) {
			setStatusTest("pass", "User CAN see/do:\r\n" + "Link Requestor");
		} else {
			setStatusTest("fail", "User CANNOT see/do:\r\n" + "Link Requestor");
		}

		if (careerDevelopmentBoard.isBtnManageDisplayed() == true) {
			setStatusTest("pass", "User CAN see/do:\r\n" + "button Manage");
		} else {
			setStatusTest("fail", "User CANNOT see/do:\r\n" + "button Manage");
		}

		careerDevelopmentBoard.filterStatusPeding("Pending");
		if (careerDevelopmentBoard.isBtnReviewDisplayed() == true) {
			setStatusTest("pass", "User CAN see/do:\r\n" + "button Review");
		} else {
			setStatusTest("fail", "User CANNOT see/do:\r\n" + "button Review");
		}

		TestLogger.info("13. Open Talent Management >> Development Board >> Click on button Review");
		careerDevelopmentBoard.clickBtnReview();

		TestLogger.info("Expect : User CAN see /do:\r\n" + "You do not have permission to approve.");
		if (careerDevelopmentBoard.isMsgErrorDisplayed() == true) {
			setStatusTest("pass", "User CAN see/do:\r\n" + "You do not have permission to approve.");
		} else {
			setStatusTest("fail", "User CANNOT see/do:\r\n" + "You do not have permission to approve.");
		}

		TestLogger.info("==========End TT_1112================");
	}

	// Bug TAL-494
	@Test(priority = 5)
	public void TT_1115() throws InterruptedException {
		TestLogger.info("========== TT_1115================");
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
		UserRoleName = "Permission|CareerDevelopment|Delete" + TienIch.taoRandomSo(3);

		roles.createUserRoleNameWithRoleTypeAdmin(UserRoleName);

		TestLogger.info("4. Uncheck Performance - Career Development Board | Read");
		roles.uncheckbox_Read_CareerDevelopment_CareerDevelopmentBoard();

		TestLogger.info("5. Check Performance - Career Development Board | Delete");
		roles.checkbox_Delete_CareerDevelopment_CareerDevelopmentBoard();

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

		TestLogger.info("9. Create Career Development");
		administration.clickLogoTalentWize();
		administration.clickMenuTalentManagement();
		administration.clickSubMenuCareerDevelopment();
		administration.clickSubMenuMyDevelopment();

		TestLogger.info("Expect : User can see /do:\r\n" + "Title Career Development");
		if (myCareerDevelopment.isLblMyCareerDisplayed() == true) {
			setStatusTest("pass", "User CAN see/do:\r\n" + "Title Career Development");
		} else {
			setStatusTest("fail", "User CANNOT see/do:\r\n" + "Title Career Development");
		}

		myCareerDevelopment.clickBtnCreate();
		formCreateCareerDevelopment.createCareerDevelopment("Tester", "Tester");
		formCreateCareerDevelopment.sumitCareerDevelopment("Description");

		TestLogger.info("Expect : User CAN see /do:\r\n" + "Create career development request successfully!");
		if (myCareerDevelopment.isMsgCreateCareerSuccessDisplayed() == true) {
			setStatusTest("pass", "User CAN see/do:\r\n" + "Create career development request successfully!");
		} else {
			setStatusTest("fail", "User CANNOT see/do:\r\n" + "Create career development request successfully!");
		}

		TestLogger.info("10. Log out");

		dashboard.logout();

		TestLogger.info("11. Login with test account : " + propertyManager.getEmailCuongUser2());

		homePage.SignInWith(propertyManager.getEmailCuongUser2(), propertyManager.getPasswordCuongUser2());

		TestLogger.info("12. Open Talent Management >> Development Board");
		administration.clicksubMenuDevelopmentBoard();
		careerDevelopmentBoard.fillTxtSearchRequestor("cuong automation");

		TestLogger.info("Expect : User CAN see /do:\r\n" + "1. Data table\r\n" + "2. Link Requestor\r\n"
				+ "3. button Manage\r\n" + "4. button Review");
		if (careerDevelopmentBoard.isLblCareerDevRequestDisplayed() == true) {
			setStatusTest("pass", "User CAN see/do:\r\n" + "Data table");
		} else {
			setStatusTest("fail", "User CANNOT see/do:\r\n" + "Data table");
		}

		if (careerDevelopmentBoard.isLinkEditDisplayed() == true) {
			setStatusTest("pass", "User CAN see/do:\r\n" + "Link Requestor");
		} else {
			setStatusTest("fail", "User CANNOT see/do:\r\n" + "Link Requestor");
		}

		if (careerDevelopmentBoard.isBtnManageDisplayed() == true) {
			setStatusTest("pass", "User CAN see/do:\r\n" + "button Manage");
		} else {
			setStatusTest("fail", "User CANNOT see/do:\r\n" + "button Manage");
		}

		careerDevelopmentBoard.filterStatusPeding("Pending");
		if (careerDevelopmentBoard.isBtnReviewDisplayed() == true) {
			setStatusTest("pass", "User CAN see/do:\r\n" + "button Review");
		} else {
			setStatusTest("fail", "User CANNOT see/do:\r\n" + "button Review");
		}

		TestLogger.info("13. Open Talent Management >> Development Board >> Click on button Review");
		careerDevelopmentBoard.clickBtnReview();

		TestLogger.info("Expect : User CAN see /do:\r\n" + "You do not have permission to approve.");
		if (careerDevelopmentBoard.isMsgErrorDisplayed() == true) {
			setStatusTest("pass", "User CAN see/do:\r\n" + "You do not have permission to approve.");
		} else {
			setStatusTest("fail", "User CANNOT see/do:\r\n" + "You do not have permission to approve.");
		}

		TestLogger.info("==========End TT_1115================");
	}

	@AfterMethod(alwaysRun = true)
	public void finishTestCase(Method nameMethod) throws InterruptedException {

		
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
	}

	@AfterTest (alwaysRun = true)
	public void dongTrinhDuyet() {
		driver.close();
	}
}
