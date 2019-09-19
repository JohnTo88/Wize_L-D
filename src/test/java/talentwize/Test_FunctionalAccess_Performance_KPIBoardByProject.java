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
import talentwize.pages.EmployeeList;
import talentwize.pages.Form_EditKPIDetail;
import talentwize.pages.HomePage;
import talentwize.pages.KPIBoardByProject;
import talentwize.pages.Roles;
import talentwize.pages.Users;

public class Test_FunctionalAccess_Performance_KPIBoardByProject extends TestManager {
	HomePage homePage;
	WebDriver driver;
	PropertyManager propertyManager;
	Dashboard dashboard;
	Administration administration;
	Users users;
	Roles roles;
	String UserRoleName;
	EmployeeList employeeList;
	KPIBoardByProject kpiBoardByProject;
	Form_EditKPIDetail editKPIDetail;

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
		kpiBoardByProject = new KPIBoardByProject(driver);
		editKPIDetail = new Form_EditKPIDetail(driver);
		homePage.moLinkWeb(propertyManager.getURL_TalentWize());

	}

	@BeforeMethod
	public void PrintNameTestCase(Method method) {
		TestLogger.info("====== Begin Testcase : " + method.getName() + " ========");
	}

	@Test(priority = 1)

	public void TT_4273() throws InterruptedException {
		TestLogger.info("1. Login with Administrator account.");

		homePage.SignInWith(propertyManager.getEmailCuongAdmin(), propertyManager.getPasswordCuongAdmin());

		if (dashboard.isDashboardMenuDisplayed() == true) {
			setStatusTest("pass", "Login Successfully!");
		} else {
			setStatusTest("fail", "Login Fail!");
		}

		TestLogger.info("2. Go to Administration - User Management - Roles tab");

		administration.clickMenuAdministration();
		administration.clickMenuUserManagement();
		administration.openRolesTab();

		TestLogger.info("Create Automation User Role Name and Role Type is Admin :");
		UserRoleName = "Performance|KPIBoardByProject|NoPermission" + TienIch.taoRandomSo(3);

		roles.createUserRoleNameWithRoleTypeAdmin(UserRoleName);

		TestLogger.info("3. Click Save button");
		roles.clickButtonSave();

		administration.openTabUsers();

		TestLogger.info("Assign role " + UserRoleName + " to employee : " + propertyManager.getEmailCuongUser());
		users.searchUsername(propertyManager.getEmailCuongUser());

		// Assign role Automation to this employee
		users.assignUserWithNewRole(propertyManager.getEmailCuongUser(), UserRoleName);

		TestLogger.info("4. Log out");

		dashboard.logout();

		TestLogger.info("5. Login with test account : " + propertyManager.getEmailCuongUser());

		homePage.SignInWith(propertyManager.getEmailCuongUser(), propertyManager.getPasswordCuongUser());
		administration.clickMenuPerformance();
	
		TestLogger.info("Expect : User CANNOT see/do: " + "KPI By Project menu");
		
		if (administration.isSubMenuKPIByProjectDisplayed() == false) {
			setStatusTest("pass", "User CANNOT see/do: " + "KPI By Project menu");
		} else {
			setStatusTest("fail", "User STILL CAN see/do: " + "KPI By Project menu");
		}
	}

	@Test(priority = 2)
	public void TT_4275() throws InterruptedException {
		TestLogger.info("1. Login with Administrator account.");

		homePage.SignInWith(propertyManager.getEmailCuongAdmin(), propertyManager.getPasswordCuongAdmin());

		if (dashboard.isDashboardMenuDisplayed() == true) {
			setStatusTest("pass", "Login Successfully!");
		} else {
			setStatusTest("fail", "Login Fail!");
		}

		TestLogger.info("2. Go to Administration - User Management - Roles tab");
		administration.clickMenuAdministration();
		administration.clickMenuUserManagement();
		administration.openRolesTab();

		TestLogger.info("Create Automation User Role Name and Role Type is Admin :");
		UserRoleName = "Performance|KPIBoardByProject|Create" + TienIch.taoRandomSo(3);

		roles.createUserRoleNameWithRoleTypeAdmin(UserRoleName);

		TestLogger.info("3. Check on Performance Permission - KPI Board - Project | Create");
		roles.checkbox_Create_KPIBoardByProject();

		TestLogger.info("4. Click Save button");
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
		
		TestLogger.info("7. Performance >> KPI By Project >> KPI Board");
		
		administration.clickMenuPerformance();
		administration.clickSubMenuKPIByProject();
		administration.clickSubMenuKPIBoardByProject();
		
		TestLogger.info("8. Check Permission");

		TestLogger.info("Expect : User CAN see/do: " + "Data table");
		
		if (administration.isSubMenuKPIByProjectDisplayed() == true) {
			setStatusTest("pass", "User CAN see/do: " + "KPI By Project menu");
		} else {
			setStatusTest("fail", "User CANNOT see/do: " + "Check-in Board menu");
		}
		
		TestLogger.info("Expect : User CANNOT see/do: " + "Edit button in KPI Detail");
		
		kpiBoardByProject.clickKPIDetails();
		if (editKPIDetail.isBtnEditDisplayed() == false) {
			setStatusTest("pass", "User CANNOT see/do: " + "Edit button in KPI Detail");
		} else {
			setStatusTest("fail", "User STILL CAN see/do: " + "Edit button in KPI Detail");
		}
	}

	@Test(priority = 3)
	public void TT_4274() throws InterruptedException {
		TestLogger.info("1. Login with Administrator account.");

		homePage.SignInWith(propertyManager.getEmailCuongAdmin(), propertyManager.getPasswordCuongAdmin());

		if (dashboard.isDashboardMenuDisplayed() == true) {
			setStatusTest("pass", "Login Successfully!");
		} else {
			setStatusTest("fail", "Login Fail!");
		}

		TestLogger.info("2. Go to Administration - User Management - Roles tab");
		administration.clickMenuAdministration();
		administration.clickMenuUserManagement();
		administration.openRolesTab();

		TestLogger.info("Create Automation User Role Name and Role Type is Admin :");
		UserRoleName = "Performance|KPIBoardByProject|Read" + TienIch.taoRandomSo(3);

		roles.createUserRoleNameWithRoleTypeAdmin(UserRoleName);

		TestLogger.info("3. Check on Performance Permission - KPI Board - Project | Read");
		roles.checkbox_Read_KPIBoardByProject();

		TestLogger.info("4. Click Save button");
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
		
		TestLogger.info("7. Performance >> KPI By Project >> KPI Board");
		
		administration.clickMenuPerformance();
		administration.clickSubMenuKPIByProject();
		administration.clickSubMenuKPIBoardByProject();
		
		TestLogger.info("8. Check Permission");

		TestLogger.info("Expect : User CAN see/do: " + "Data table");
		
		if (administration.isSubMenuKPIByProjectDisplayed() == true) {
			setStatusTest("pass", "User CAN see/do: " + "KPI By Project menu");
		} else {
			setStatusTest("fail", "User CANNOT see/do: " + "Check-in Board menu");
		}
		
		TestLogger.info("Expect : User CANNOT see/do: " + "Edit button in KPI Detail");
		
		kpiBoardByProject.clickKPIDetails();
		if (editKPIDetail.isBtnEditDisplayed() == false) {
			setStatusTest("pass", "User CANNOT see/do: " + "Edit button in KPI Detail");
		} else {
			setStatusTest("fail", "User STILL CAN see/do: " + "Edit button in KPI Detail");
		}
	}
	
	@Test(priority = 4)
	public void TT_4276() throws InterruptedException {
		TestLogger.info("1. Login with Administrator account.");

		homePage.SignInWith(propertyManager.getEmailCuongAdmin(), propertyManager.getPasswordCuongAdmin());

		if (dashboard.isDashboardMenuDisplayed() == true) {
			setStatusTest("pass", "Login Successfully!");
		} else {
			setStatusTest("fail", "Login Fail!");
		}

		TestLogger.info("2. Go to Administration - User Management - Roles tab");
		administration.clickMenuAdministration();
		administration.clickMenuUserManagement();
		administration.openRolesTab();

		TestLogger.info("Create Automation User Role Name and Role Type is Admin :");
		UserRoleName = "Performance|KPIBoardByProject|Update" + TienIch.taoRandomSo(3);

		roles.createUserRoleNameWithRoleTypeAdmin(UserRoleName);

		TestLogger.info("3. Check on Performance Permission - KPI Board - Project | Update");
		roles.checkbox_Update_KPIBoardByProject();

		TestLogger.info("4. Click Save button");
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
		
		TestLogger.info("7. Performance >> KPI By Project >> KPI Board");
		
		administration.clickMenuPerformance();
		administration.clickSubMenuKPIByProject();
		administration.clickSubMenuKPIBoardByProject();
		
		TestLogger.info("8. Check Permission");

		TestLogger.info("Expect : User CAN see/do: " 
				+ "1. Data table\r\n" 
				+ "2. Edit button in KPI Detail");
		
		if (administration.isSubMenuKPIByProjectDisplayed() == true) {
			setStatusTest("pass", "User CAN see/do: " + "KPI By Project menu");
		} else {
			setStatusTest("fail", "User CANNOT see/do: " + "Check-in Board menu");
		}

		kpiBoardByProject.clickKPIDetails();
		if (editKPIDetail.isBtnEditDisplayed() == true) {
			setStatusTest("pass", "User CAN see/do: " + "Edit button in KPI Detail");
		} else {
			setStatusTest("fail", "User CANNOT CAN see/do: " + "Edit button in KPI Detail");
		}
		
		TestLogger.info("9. Edit KPI");
		
		editKPIDetail.UpdateKPIDetail();
		
		TestLogger.info("Expect : User CAN see/do: " + "Displays msg: Update kpis successfully!");
		
		if (editKPIDetail.ismsgUpdateKPIDetailDisplayed() == true) {
			setStatusTest("pass", "User CAN see/do: " + "Displays msg: Update kpis successfully!");
		} else {
			setStatusTest("fail", "User CANNOT see/do: " + "Displays msg: Update kpis successfully!");
		}
	}
	
	@Test(priority = 5)
	public void TT_4277() throws InterruptedException {
		TestLogger.info("1. Login with Administrator account.");

		homePage.SignInWith(propertyManager.getEmailCuongAdmin(), propertyManager.getPasswordCuongAdmin());

		if (dashboard.isDashboardMenuDisplayed() == true) {
			setStatusTest("pass", "Login Successfully!");
		} else {
			setStatusTest("fail", "Login Fail!");
		}

		TestLogger.info("2. Go to Administration - User Management - Roles tab");
		administration.clickMenuAdministration();
		administration.clickMenuUserManagement();
		administration.openRolesTab();

		TestLogger.info("Create Automation User Role Name and Role Type is Admin :");
		UserRoleName = "Performance|KPIBoardByProject|Delete" + TienIch.taoRandomSo(3);

		roles.createUserRoleNameWithRoleTypeAdmin(UserRoleName);

		TestLogger.info("3. Check on Performance Permission - KPI Board - Project | Delete");
		roles.checkbox_Delete_KPIBoardByProject();

		TestLogger.info("4. Click Save button");
		roles.clickButtonSave();

		administration.openTabUsers();

		TestLogger.info("Assign role " + UserRoleName + " to employee : " + propertyManager.getEmailCuongUser());
		users.searchUsername(propertyManager.getPasswordCuongUser());

		// Assign role Automation to this employee
		users.assignUserWithNewRole(propertyManager.getEmailCuongUser(), UserRoleName);

		TestLogger.info("5. Log out");

		dashboard.logout();

		TestLogger.info("6. Login with test account : " + propertyManager.getEmailCuongUser());

		homePage.SignInWith(propertyManager.getEmailCuongUser(), propertyManager.getPasswordCuongUser());
		
		TestLogger.info("7. Performance >> KPI By Project >> KPI Board");
		
		administration.clickMenuPerformance();
		administration.clickSubMenuKPIByProject();
		administration.clickSubMenuKPIBoardByProject();
		
		TestLogger.info("8. Check Permission");

		TestLogger.info("Expect : User CAN see/do: " + "Data table");
		
		if (administration.isSubMenuKPIByProjectDisplayed() == true) {
			setStatusTest("pass", "User CAN see/do: " + "KPI By Project menu");
		} else {
			setStatusTest("fail", "User CANNOT see/do: " + "Check-in Board menu");
		}
		
		TestLogger.info("Expect : User CANNOT see/do: " + "Edit button in KPI Detail");
		
		kpiBoardByProject.clickKPIDetails();
		if (editKPIDetail.isBtnEditDisplayed() == false) {
			setStatusTest("pass", "User CANNOT see/do: " + "Edit button in KPI Detail");
		} else {
			setStatusTest("fail", "User STILL CAN see/do: " + "Edit button in KPI Detail");
		}
	}
	

	@AfterMethod(alwaysRun = true)
	public void finishTestCase(Method method) throws InterruptedException {
		// logout
		if (dashboard.isProfileDisplayed() == true) {
			dashboard.logout();
		}

		homePage.moLinkWeb(propertyManager.getURL_TalentWize());

		homePage.SignInWith(propertyManager.getEmailCuongUser(), propertyManager.getPasswordCuongUser());

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
