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
import controller.WebDriversManager;
import talentwize.pages.Administration;
import talentwize.pages.Dashboard;
import talentwize.pages.HomePage;
import talentwize.pages.Roles;
import talentwize.pages.Users;

// BUG : TAL-609
public class Test_FunctionalAcess_Administration_UserManagement_Users_Roles extends TestManager {

	HomePage homePage;
	WebDriver driver;
	PropertyManager propertyManager;
	Dashboard dashboard;
	Administration administration;
	Users users;
	Roles roles;
	String UserRoleName;

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

	}

	@BeforeMethod
	public void PrintNameTestCase(Method method) {
		TestLogger.info("====== Begin Testcase : " + method.getName() + " ========");
	}

	@Test(priority = 1)
	public void TT_39() throws InterruptedException {
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
		UserRoleName = "Automation-Management-User-Read" + System.currentTimeMillis();

		roles.createUserRoleNameWithRoleTypeAdmin(UserRoleName);

		TestLogger.info("Uncheck All Checkbox ");
		roles.uncheck_All_Checkbox_Row_1();

		TestLogger.info("4. Check on Administration - User Management - Users | Read");
		TestLogger.info("Choose only checkbox Read on Automation - Admin - User Management - Users - Read");

		roles.choose_Checkbox_Read__With_Row_Number(1);
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

		TestLogger.info("8. Veryfy Permission : User can see/do:" + "1. Administration menu" + "2. User Management menu"
				+ "3. Tab Users in user management." + "4. Can click on Export button to export data.");
		administration.openTabUsers();

		if (users.isSeachUsernameDisplayed() == true && (users.isButtonExportClickable() == true)) {
			setStatusTest("pass", "User can see/do : 1. Administration menu" + "2. User Management menu"
					+ "3. Tab Users in user management" + "4. Can click on Export button to export data.");
		} else {
			setStatusTest("fail", "User CAN NOT see/do : " + "1. Administration menu" + "2. User Management menu"
					+ "3. Tab Users in user management." + "4. Can click on Export button to export data.");
		}

		TestLogger.info("User CANNOT see/do" + "1. Button Create "
				+ "2. Click on a User name >> the system shows error msg You do not have permission to edit user info.");

		if (users.isButtonCreateDisplayed() == false) {
			setStatusTest("pass", "User CANNOT see/do :" + " 1. Button Create ");
		} else {
			setStatusTest("fail", "User STILL CAN see/do : " + "1. Button Create");
		}

		users.searchUsername(propertyManager.getEmailUserTW());
		users.clickOnlinkUserName(propertyManager.getEmailUserTW());

		if (users.getMessageError().equalsIgnoreCase("You do not have permission to edit user info.")) {
			setStatusTest("pass",
					" 2.Click on a User name >> the system shows error msg : You do not have permission to edit user info");
		} else {
			setStatusTest("pass",
					" 2. Click on a User name >> the system DOES NOT show error msg : You do not have permission to edit user info");
		}

	}

	@Test(priority = 2)
	public void TT_138() throws InterruptedException {
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
		administration.openRolesTabv2();

		TestLogger.info("Create Automation User Role Name and Role Type is Admin :");
		UserRoleName = "Automation-Management-User-Create" + System.currentTimeMillis();

		roles.createUserRoleNameWithRoleTypeAdmin(UserRoleName);

		TestLogger.info("Uncheck All Checkbox ");
		roles.uncheck_All_Checkbox_Row_1();

		TestLogger.info("4. Check on Administration - User Management - Users | Create");
		TestLogger.info("Choose only checkbox Read on Automation - Admin - User Management - Users - Create");

		roles.choose_Checkbox_Create_With_Row_Number1();

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

		TestLogger.info("8. Veryfy Permission : User can see/do:" + "1. Administration menu" + "2. User Management menu"
				+ "3. Tab Users in user management." + "4. Can click on Export button to export data."
				+ "5. Button Create ");

		administration.openTabUsers();

		if (users.isSeachUsernameDisplayed() == true && (users.isButtonExportClickable() == true)
				&& (users.isButtonCreateDisplayed() == true)) {
			setStatusTest("pass",
					"User can see/do : 1. Administration menu" + "2. User Management menu"
							+ "3. Tab Users in user management"
							+ "4. Can click on Export button to export data. 5. Button Create ");
		} else {
			setStatusTest("fail",
					"User CAN NOT see/do : " + "1. Administration menu" + "2. User Management menu"
							+ "3. Tab Users in user management."
							+ "4. Can click on Export button to export data. 5. Button Create ");
		}

		TestLogger.info("User CANNOT see/do" + " 1. Delete button ( Trash icon) "
				+ "2. Click on a User name >> the system shows error msg You do not have permission to edit user info.");

		if (users.isIconDeleteDisplayed() == false) {
			setStatusTest("pass", "User CANNOT see/do\" + \" 1. Delete button ( Trash icon) ");
		} else {
			setStatusTest("fail", "User STILL CAN see do " + " 1. Delete button ( Trash icon) ");
		}

		users.searchUsername(propertyManager.getEmailUserTW());
		users.clickOnlinkUserName(propertyManager.getEmailUserTW());

		if (users.getMessageError().equalsIgnoreCase("You do not have permission to edit user info.")) {
			setStatusTest("pass",
					" 2.Click on a User name >> the system shows error msg : You do not have permission to edit user info");
		} else {
			setStatusTest("pass",
					" 2. Click on a User name >> the system DOES NOT show error msg : You do not have permission to edit user info");
		}
	}

	@Test(priority = 3)
	public void TT_140() throws InterruptedException {
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
		administration.openRolesTabv2();

		TestLogger.info("Create Automation User Role Name and Role Type is Admin :");
		UserRoleName = "Automation-Management-User-Update" + System.currentTimeMillis();

		roles.createUserRoleNameWithRoleTypeAdmin(UserRoleName);

		TestLogger.info("Uncheck All Checkbox ");
		roles.uncheck_All_Checkbox_Row_1();
		roles.uncheck_All_Checkbox_Row_2();

		TestLogger.info("4. Check on Administration - User Management - Users | Update");
		TestLogger.info("Choose only checkbox Read on Automation - Admin - User Management - Users - Update");

		roles.choose_Checkbox_Read__With_Row_Number(2);
		roles.choose_Checkbox_Update_With_Row_Number1();

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

		TestLogger.info("8. Veryfy Permission : User can see/do:" + "1. Administration menu" + "2. User Management menu"
				+ "3. Tab Users in user management." + "4. Can click on Export button to export data.");

		administration.openTabUsers();

		if (users.isSeachUsernameDisplayed() == true && (users.isButtonExportClickable() == true)
				&& (users.isButtonCreateDisplayed() == false && (users.isIconDeleteDisplayed() == false))) {
			setStatusTest("pass", "User can see/do : 1. Administration menu" + "2. User Management menu"
					+ "3. Tab Users in user management"
					+ "4. Can click on Export button to export data.  User CAN NOT see/do : 1. Button Create 2. Delete button (Trash icon)");
		} else {
			setStatusTest("fail", "User CAN NOT see/do : " + "1. Administration menu" + "2. User Management menu"
					+ "3. Tab Users in user management."
					+ "4. Can click on Export button to export data. User STILL CAN see/do : 1. Button Create 2. Delete button (Trash icon)");
		}

		TestLogger.info("9 .Click on a User name ");
		TestLogger.info("10. Click on Edit button");
		TestLogger.info("11. Click on Save button");

		users.searchUsername(propertyManager.getEmailUserTW());
		users.clickOnlinkUserName(propertyManager.getEmailUserTW());
		users.clickButtonEdit();
		users.clickButtonSaveRole();

		TestLogger.info("8. Veryfy  : the system show msg: Updated successful!");
		if (users.messageUpdateSuccessIsDisplayed() == true) {
			setStatusTest("pass", "the system show msg: Updated successful!");
		} else {
			setStatusTest("fail", "the system DOES NOT show msg: Updated successful!");
		}

	}

	@Test(priority = 4)
	public void TT_141() throws InterruptedException {
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
		administration.openRolesTabv2();

		TestLogger.info("Create Automation User Role Name and Role Type is Admin :");
		UserRoleName = "Automation-Management-User-Delete" + System.currentTimeMillis();

		roles.createUserRoleNameWithRoleTypeAdmin(UserRoleName);

		TestLogger.info("Uncheck All Checkbox ");
		roles.uncheck_All_Checkbox_Row_1();
		roles.uncheck_All_Checkbox_Row_2();

		TestLogger.info("4. Check on Administration - User Management - Users | Delete");
		TestLogger.info("Choose only checkbox Read on Automation - Admin - User Management - Users - Delete");

		roles.choose_Checkbox_Delete_With_Row_Number1();

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

		TestLogger.info("8. Veryfy Permission : User can see/do:" + "1. Administration menu" + "2. User Management menu"
				+ "3. Tab Users in user management."
				+ "4. Can click on Export button to export data. 5. Delete button ( Trash icon)");

		administration.openTabUsers();

		if (users.isSeachUsernameDisplayed() == true && (users.isButtonExportClickable() == true)
				&& (users.isButtonCreateDisplayed() == false && (users.isIconDeleteDisplayed() == true))) {
			setStatusTest("pass",
					"User can see/do : 1. Administration menu" + "2. User Management menu"
							+ "3. Tab Users in user management"
							+ "4. Can click on Export button to export data. 5. Delete button (Trash icon)");
		} else {
			setStatusTest("fail",
					"User CAN NOT see/do : " + "1. Administration menu" + "2. User Management menu"
							+ "3. Tab Users in user management."
							+ "4. Can click on Export button to export data. 5. Delete button (Trash icon)");
		}

		TestLogger.info("2.User CANNOT see:  Button Create ");
		if (users.isButtonCreateDisplayed() == false) {
			setStatusTest("pass", "User CANNOT see/do :" + " 2. Button Create ");
		} else {
			setStatusTest("fail", "User STILL CAN see/do : " + "2. Button Create");
		}

		TestLogger.info(
				"1. Click on a User name >> the system shows error msg \"You do not have permission to edit user info\".");

		users.searchUsername(propertyManager.getEmailUserTW());
		users.clickOnlinkUserName(propertyManager.getEmailUserTW());

		if (users.getMessageError().equalsIgnoreCase("You do not have permission to edit user info.")) {
			setStatusTest("pass",
					" 1.Click on a User name >> the system shows error msg : You do not have permission to edit user info");
		} else {
			setStatusTest("pass",
					" 1. Click on a User name >> the system DOES NOT show error msg : You do not have permission to edit user info");
		}

	}

	@Test(priority = 5)
	public void TT_142() throws InterruptedException {
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
		administration.openRolesTabv2();

		TestLogger.info("Create Automation User Role Name and Role Type is Admin :");
		UserRoleName = "Automation-Management-Roles-Delete" + System.currentTimeMillis();

		roles.createUserRoleNameWithRoleTypeAdmin(UserRoleName);

		TestLogger.info("Uncheck All Checkbox ");
		roles.uncheck_All_Checkbox_Row_1();
		roles.uncheck_All_Checkbox_Row_2();

		TestLogger.info("4. Check on Administration - User Management - Roles | Delete");
		TestLogger.info("Choose only checkbox Read on Automation - Admin - User Management - Roles - Delete");

		roles.choose_Checkbox_Read__With_Row_Number(1);

		roles.choose_Checkbox_Delete_With_Row_Number2();

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

		TestLogger.info("Open User management screen : Verify permission");

		TestLogger.info("User can see/do:\r\n" + "1. Administration menu\r\n" + "2. User Management menu\r\n"
				+ "3. Tab Roles in user management.\r\n" + "5. Can click on Export button to export data.");

		if (roles.isSearchRolesDisplayed() == true && (roles.isButtonExportClickable() == true)
				&& (roles.isIconDeleteDisplayed() == true)) {
			setStatusTest("pass",
					"User can see/do : 1. Administration menu" + "2. User Management menu"
							+ "3. Tab Roles in user management"
							+ "5. Can click on Export button to export data. 8.Delete button");
		} else {
			setStatusTest("fail",
					"User CAN NOT see/do : " + "1. Administration menu" + "2. User Management menu"
							+ "3. Tab Roles in user management."
							+ "5. Can click on Export button to export data. 8.Delete button");
		}

		TestLogger.info(
				"Verify that : 6.User can do :  Click on View User button to view list of user who apply this role. ");
		// search information with role = UserRoleName

		administration.openRolesTabv2();
		roles.searchRoles(UserRoleName);
		roles.clickButtonViewUser();

		if (users.checkLinkUsernameAvaiable(propertyManager.getEmailUserTW())) {
			administration.openRolesTabv2();
			setStatusTest("pass", "User can do :  Click on View User button to view list of user who apply this role.");
		} else {
			administration.openRolesTabv2();
			setStatusTest("fail",
					"User can NOT do :  Click on View User button to view list of user who apply this role.");
		}

		roles.searchRoles(UserRoleName);
		roles.clickLinkUserRoleName(UserRoleName);
		if (roles.getStringFromUserRoleName().equalsIgnoreCase(UserRoleName)) {
			setStatusTest("pass", "User can Click on User Role Name to view role detail");
		} else {
			setStatusTest("fail", "User can NOT Click on User Role Name to view role detail");
		}

		administration.openTabUsers();
		administration.openRolesTabv2();

		if (roles.isButtonSaveDisplayed() == false) {
			setStatusTest("pass", "1. In role detail screen, user cannot edit anything, don't see Save button.");
		} else {
			setStatusTest("fail", "1. In role detail screen, user Stil edit anything, see Save button.");
		}

		if (roles.isButtonCreateDisplayed() == false) {
			setStatusTest("pass", "User CAN NOT see button");
		} else {
			setStatusTest("fail", "User STILL CAN  see button");
		}
		
		

	}

	@Test(priority = 6)
	public void TT_143() throws InterruptedException {
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
		administration.openRolesTabv2();

		TestLogger.info("Create Automation User Role Name and Role Type is Admin :");
		UserRoleName = "Automation-Management-Roles-Read" + System.currentTimeMillis();

		roles.createUserRoleNameWithRoleTypeAdmin(UserRoleName);

		TestLogger.info("Uncheck All Checkbox ");
		roles.uncheck_All_Checkbox_Row_1();
		roles.uncheck_All_Checkbox_Row_2();

		TestLogger.info("4. Check on Administration - User Management - Roles | Read");
		TestLogger.info("Choose only checkbox Read on Automation - Admin - User Management - Roles - Read");

		roles.choose_Checkbox_Read__With_Row_Number(1);

		roles.choose_Checkbox_Read_With_Row_Number2();

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

		TestLogger.info("Open User management screen : Verify permission");

		TestLogger.info("User can see/do:\r\n" + "1. Administration menu\r\n" + "2. User Management menu\r\n"
				+ "3. Tab Roles in user management.\r\n" + "5. Can click on Export button to export data.");

		if (roles.isSearchRolesDisplayed() == true && (roles.isButtonExportClickable() == true)) {
			setStatusTest("pass", "User can see/do : 1. Administration menu" + "2. User Management menu"
					+ "3. Tab Roles in user management" + "5. Can click on Export button to export data.");
		} else {
			setStatusTest("fail", "User CAN NOT see/do : " + "1. Administration menu" + "2. User Management menu"
					+ "3. Tab Roles in user management." + "5. Can click on Export button to export data.");
		}

		TestLogger.info(
				"Verify that : 6.User can do :  Click on View User button to view list of user who apply this role. ");
		// search information with role = UserRoleName

		administration.openRolesTabv2();
		roles.searchRoles(UserRoleName);
		roles.clickButtonViewUser();

		if (users.checkLinkUsernameAvaiable(propertyManager.getEmailUserTW())) {
			administration.openRolesTabv2();
			setStatusTest("pass", "User can do :  Click on View User button to view list of user who apply this role.");
		} else {
			administration.openRolesTabv2();
			setStatusTest("fail",
					"User can NOT do :  Click on View User button to view list of user who apply this role.");
		}

		roles.searchRoles(UserRoleName);
		roles.clickLinkUserRoleName(UserRoleName);
		if (roles.getStringFromUserRoleName().equalsIgnoreCase(UserRoleName)) {
			setStatusTest("pass", "User can Click on User Role Name to view role detail");
		} else {
			setStatusTest("fail", "User can NOT Click on User Role Name to view role detail");
		}

		administration.openTabUsers();
		administration.openRolesTabv2();

		if (roles.isButtonSaveDisplayed() == false) {
			setStatusTest("pass", "1. In role detail screen, user cannot edit anything, don't see Save button.");
		} else {
			setStatusTest("fail", "1. In role detail screen, user Stil edit anything, see Save button.");
		}

		if (roles.isButtonCreateDisplayed() == false) {
			setStatusTest("pass", "User CAN NOT see button");
		} else {
			setStatusTest("fail", "User STILL CAN  see button");
		}

		if (roles.isCheckboxDeleteRole() == false) {
			setStatusTest("pass", "3. User CAN NOT see Delete button");
		} else {
			setStatusTest("fail", "3 .User still can see Delete button");
		}
		
		
	}

	@Test(priority = 7)
	public void TT_144() throws InterruptedException {
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
		administration.openRolesTabv2();

		TestLogger.info("Create Automation User Role Name and Role Type is Admin :");
		UserRoleName = "Automation-Management-Roles-Create" + System.currentTimeMillis();

		roles.createUserRoleNameWithRoleTypeAdmin(UserRoleName);

		TestLogger.info("Uncheck All Checkbox ");
		roles.uncheck_All_Checkbox_Row_1();
		roles.uncheck_All_Checkbox_Row_2();

		TestLogger.info("4. Check on Administration - User Management - Roles |Create");
		TestLogger.info("Choose only checkbox Read on Automation - Admin - User Management - Roles - Create");

		roles.choose_Checkbox_Read__With_Row_Number(1);

		roles.choose_Checkbox_Create_With_Row_Number2();

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

		TestLogger.info("Open User management screen : Verify permission");

		TestLogger.info("User can see/do:\r\n" + "1. Administration menu\r\n" + "2. User Management menu\r\n"
				+ "3. Tab Roles in user management.\r\n" + "5. Can click on Export button to export data.");

		if (roles.isSearchRolesDisplayed() == true && (roles.isButtonExportClickable() == true)) {
			setStatusTest("pass", "User can see/do : 1. Administration menu" + "2. User Management menu"
					+ "3. Tab Roles in user management" + "5. Can click on Export button to export data.");
		} else {
			setStatusTest("fail", "User CAN NOT see/do : " + "1. Administration menu" + "2. User Management menu"
					+ "3. Tab Roles in user management." + "5. Can click on Export button to export data.");
		}

		TestLogger.info(
				"Verify that : 6.User can do :  Click on View User button to view list of user who apply this role. ");
		// search information with role = UserRoleName

		administration.openRolesTabv2();
		roles.searchRoles(UserRoleName);
		roles.clickButtonViewUser();

		if (users.checkLinkUsernameAvaiable(propertyManager.getEmailUserTW())) {
			administration.openRolesTabv2();
			setStatusTest("pass", "User can do :  Click on View User button to view list of user who apply this role.");
		} else {
			administration.openRolesTabv2();
			setStatusTest("fail",
					"User can NOT do :  Click on View User button to view list of user who apply this role.");
		}

		roles.searchRoles(UserRoleName);
		roles.clickLinkUserRoleName(UserRoleName);
		if (roles.getStringFromUserRoleName().equalsIgnoreCase(UserRoleName)) {
			setStatusTest("pass", "User can Click on User Role Name to view role detail");
		} else {
			setStatusTest("fail", "User can NOT Click on User Role Name to view role detail");
		}

		administration.openTabUsers();
		administration.openRolesTabv2();

		if (roles.isButtonSaveDisplayed() == false) {
			setStatusTest("pass", "1. In role detail screen, user cannot edit anything, don't see Save button.");
		} else {
			setStatusTest("fail", "1. In role detail screen, user Stil edit anything, see Save button.");
		}

		if (roles.isButtonCreateDisplayed() == true) {
			setStatusTest("pass", "User can see Create button");
		} else {
			setStatusTest("fail", "User CAN NOT Create see button");
		}

		if (roles.isCheckboxDeleteRole() == false) {
			setStatusTest("pass", "3. User CAN NOT see Delete button");
		} else {
			setStatusTest("fail", "3 .User still can see Delete button");
		}
	}

	// BUG : TAL-609
	@Test(priority = 8)
	public void TT_145() throws InterruptedException {
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
		administration.openRolesTabv2();

		TestLogger.info("Create Automation User Role Name and Role Type is Admin :");
		UserRoleName = "Automation-Management-Roles-Update" + System.currentTimeMillis();

		roles.createUserRoleNameWithRoleTypeAdmin(UserRoleName);

		TestLogger.info("Uncheck All Checkbox ");
		roles.uncheck_All_Checkbox_Row_1();
		roles.uncheck_All_Checkbox_Row_2();

		TestLogger.info("4. Check on Administration - User Management - Roles |Update");
		TestLogger.info("Choose only checkbox Read on Automation - Admin - User Management - Roles - Update");

		roles.choose_Checkbox_Read__With_Row_Number(1);

		roles.choose_Checkbox_Update_With_Row_Number2();

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

		TestLogger.info("Open User management screen : Verify permission");

		TestLogger.info("User can see/do:\r\n" + "1. Administration menu\r\n" + "2. User Management menu\r\n"
				+ "3. Tab Roles in user management.\r\n" + "5. Can click on Export button to export data.");

		if (roles.isSearchRolesDisplayed() == true && (roles.isButtonExportClickable() == true)) {
			setStatusTest("pass", "User can see/do : 1. Administration menu" + "2. User Management menu"
					+ "3. Tab Roles in user management" + "5. Can click on Export button to export data.");
		} else {
			setStatusTest("fail", "User CAN NOT see/do : " + "1. Administration menu" + "2. User Management menu"
					+ "3. Tab Roles in user management." + "5. Can click on Export button to export data.");
		}

		TestLogger.info(
				"Verify that : 6.User can do :  Click on View User button to view list of user who apply this role. ");
		// search information with role = UserRoleName

		administration.openRolesTabv2();
		roles.searchRoles(UserRoleName);
		roles.clickButtonViewUser();

		if (users.checkLinkUsernameAvaiable(propertyManager.getEmailUserTW())) {
			administration.openRolesTabv2();
			setStatusTest("pass", "User can do :  Click on View User button to view list of user who apply this role.");
		} else {
			administration.openRolesTabv2();
			setStatusTest("fail",
					"User can NOT do :  Click on View User button to view list of user who apply this role.");
		}

		roles.searchRoles(UserRoleName);
		roles.clickLinkUserRoleName(UserRoleName);
		if (roles.getStringFromUserRoleName().equalsIgnoreCase(UserRoleName)) {
			setStatusTest("pass", "User can Click on User Role Name to view role detail");
		} else {
			setStatusTest("fail", "User can NOT Click on User Role Name to view role detail");
		}

		if (roles.isButtonSaveDisplayed() == true) {
			setStatusTest("pass", ".In role detail screen, user can edit anything, and save successfully");
		} else {
			setStatusTest("fail", " In role detail screen, user CAN NOT edit anything because Save is NOT avaiable !");
		}

		administration.openTabUsers();
		administration.openRolesTabv2();

		if (roles.isButtonCreateDisplayed() == false) {
			setStatusTest("pass", "User can NOT see Create button");
		} else {
			setStatusTest("fail", "User STILL CAN see Create see button");
		}

		if (roles.isCheckboxDeleteRole() == false) {
			setStatusTest("pass", "3. User CAN NOT see Delete button");
		} else {
			setStatusTest("fail", "3 .User still can see Delete button");
		}
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
