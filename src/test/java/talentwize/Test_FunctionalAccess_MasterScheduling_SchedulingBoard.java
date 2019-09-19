package talentwize;

import java.lang.reflect.Method;

import org.openqa.selenium.WebDriver;
import org.sikuli.script.Screen;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Ulties.PropertyManager;
import Ulties.TestLogger;
import Ulties.TestManager;
import Ulties.TienIch;
import controller.ScreenController;
import controller.WebDriversManager;
import talentwize.pages.Administration;
import talentwize.pages.CompanyJobHistory;
import talentwize.pages.Dashboard;
import talentwize.pages.EmployeeList;
import talentwize.pages.Form_EditContractType;
import talentwize.pages.Form_EditCurrentPosition;
import talentwize.pages.Form_EditNewPosition;
import talentwize.pages.Form_EditPreviousPosition;
import talentwize.pages.Form_ExportSchedule;
import talentwize.pages.HomePage;
import talentwize.pages.MySchedule;
import talentwize.pages.Roles;
import talentwize.pages.ScheduleBoard;
import talentwize.pages.Users;

public class Test_FunctionalAccess_MasterScheduling_SchedulingBoard extends TestManager {

	HomePage homePage;
	WebDriver driver;
	PropertyManager propertyManager;
	Dashboard dashboard;
	Administration administration;
	Users users;
	Roles roles;
	String UserRoleName;
	EmployeeList employeeList;
	CompanyJobHistory companyJobHistory;
	Form_EditContractType editContractType;
	Form_EditPreviousPosition editPreviousPosition;
	Form_EditCurrentPosition editCurrentPosition;
	Form_EditNewPosition editNewPosition;
	MySchedule mySchedule;
	ScheduleBoard scheduleBoard;
	Form_ExportSchedule	formExportSchedule;
	
	ScreenController s;
	Screen screen;

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
		companyJobHistory = new CompanyJobHistory(driver);
		homePage.moLinkWeb(propertyManager.getURL_TalentWize());
		editContractType = new Form_EditContractType(driver);
		editPreviousPosition = new Form_EditPreviousPosition(driver);
		editCurrentPosition = new Form_EditCurrentPosition(driver);
		editNewPosition = new Form_EditNewPosition(driver);
		mySchedule = new MySchedule(driver);
		scheduleBoard = new ScheduleBoard(driver);
		formExportSchedule = new Form_ExportSchedule(driver);
		screen = new Screen();
		s = new ScreenController(screen);
	}

	@BeforeMethod
	public void PrintNameTestCase(Method method) {
		TestLogger.info("====== Begin Testcase : " + method.getName() + " ========");
	}

	// TAL-516
	@Test(priority = 1)
	public void TT_1212() throws InterruptedException {
		TestLogger.info("=================TT_1212 =====================");
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

		TestLogger.info("3. Create Automation User Role Name and Role Type is Admin :");
		UserRoleName = "Master Scheduling|Scheduling Board|No permission" + TienIch.taoRandomSo(3);

		roles.createUserRoleNameWithRoleTypeAdmin(UserRoleName);

		TestLogger.info("4. Unchecked on \r\n" + "Master Scheduling - Scheduling Board | Read");
		roles.uncheckbox_Read_MasterScheduling_SchedulingBoard();

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
		TestLogger.info("8. Open Master Scheduling");
		administration.clickMenuMasterScheduling();

		if (administration.isSubMenuScheduleBoardDisplayed() == false) {
			setStatusTest("pass", "User CANNOT see/do:\r\n" + "1. Menu Scheduling Board");
		} else {
			setStatusTest("fail", "User STILL CAN see/do:\r\n" + "1. Menu Scheduling Board ");
		}

		TestLogger.info("=================END TT_1212=====================");
	}

	@Test(priority = 2)
	public void TT_1200() throws InterruptedException {
		TestLogger.info("=================TT_1200 =====================");
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

		TestLogger.info("3. Create Automation User Role Name and Role Type is Admin :");
		UserRoleName = "Master Scheduling|Scheduling Board|Read" + TienIch.taoRandomSo(3);

		roles.createUserRoleNameWithRoleTypeAdmin(UserRoleName);

		TestLogger.info("4. Unchecked on \r\n" + "Master Scheduling - Scheduling Board | Read");
		TestLogger.info("+Check on \r\n" + "Master Scheduling - Scheduling Board | Read");

		roles.uncheckbox_Read_MasterScheduling_SchedulingBoard();
		roles.checkbox_Read_MasterScheduling_SchedulingBoard();

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
		
		TestLogger.info("8. Open Master Scheduling - Open Scheduling Board ");
		administration.clickMenuMasterScheduling();
		administration.clickSubMenuScheduleBoard();

		TestLogger.info("User can see /do:\r\n" 
				+ "1. Data table\r\n" 
				+ "2. Button Export");
				
		if (scheduleBoard.isProjectDataTabelDispalyed() == true) {
			setStatusTest("pass", "User can see /do:\r\n" + "1. Data table");
		} else {
			setStatusTest("fail", "User can NOT see /do:\r\n" + "1. Data table");
		}
		
		scheduleBoard.clickBtnWeek();
		if (scheduleBoard.isButtonExportDispalyed() == true) {
			setStatusTest("pass", "User can see /do:\r\n" + "2. Button Export");
		} else {
			setStatusTest("fail", "User can NOT see /do:\r\n" + "2. Button Export");
		}
				
		TestLogger.info("User cannot see/do " + "Add Schedule button");
		
		if (scheduleBoard.isBtnAddScheduleDispalyed() == false) {
			setStatusTest("pass", "User cannot see/do:\r\n" + "1. Add Schedule button");
		} else {
			setStatusTest("fail", "User STILL can see/do:\r\n" + "1. Add Schedule button");
		}
		
		
		TestLogger.info("9. Check export function");
		scheduleBoard.clickBtnExport();
		formExportSchedule.exportSchedule();
		
		if (s.waitForObjectPresent("masterScheduling.png", 10)) 
		{
			setStatusTest("pass", "Export report successfully");
		} else {
			setStatusTest("fail", "Export report NOT successfully");
		}
		

		TestLogger.info("=================END TT_1200=====================");
	}

	@Test(priority = 3)
	public void TT_1209() throws InterruptedException {
		TestLogger.info("=================TT_1209 =====================");
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

		TestLogger.info("3. Create Automation User Role Name and Role Type is Admin :");
		UserRoleName = "Master Scheduling|Scheduling Board|Update" + TienIch.taoRandomSo(3);

		roles.createUserRoleNameWithRoleTypeAdmin(UserRoleName);

		TestLogger.info("4. Unchecked on \r\n" + "Master Scheduling - Scheduling Board | Read");
		TestLogger.info("+Check on \r\n" + "Master Scheduling - Scheduling Board | Update");

		roles.uncheckbox_Read_MasterScheduling_SchedulingBoard();
		roles.checkbox_Update_MasterScheduling_SchedulingBoard();

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
		TestLogger.info("8. Open Master Scheduling - Open Scheduling Board ");
		administration.clickMenuMasterScheduling();
		administration.clickSubMenuScheduleBoard();

		TestLogger.info("User can see /do: " 
				+ "1. Data table\r\n" 
				+ "2. Add Schedule button\r\n"
				+ "3. Button Export");
		if (scheduleBoard.isProjectDataTabelDispalyed() == true) {
			setStatusTest("pass", "User can see /do:\r\n" + "1. Data table");
		} else {
			setStatusTest("fail", "User can NOT see /do:\r\n" + "1. Data table");
		}
		
		if (scheduleBoard.isBtnAddScheduleDispalyed() == true) {
			setStatusTest("pass", "User can see /do:\r\n" + "2. Add Schedule button");
		} else {
			setStatusTest("fail", "User can NOT see /do:\r\n" + "2. Add Schedule button");
		}
		
		scheduleBoard.clickBtnWeek();
		if (scheduleBoard.isButtonExportDispalyed() == true) {
			setStatusTest("pass", "User can see /do:\r\n" + "3. Button Export");
		} else {
			setStatusTest("fail", "User can NOT see /do:\r\n" + "3. Button Export");
		}

		TestLogger.info("3. Click on site hyperlink of a project\r\n" + "4. Click on Edit button\r\n"
				+ "5. Input data\r\n" + "6. Click Save button");

		scheduleBoard.clickFistLinkProject();
		scheduleBoard.clickButtonEdit();
		scheduleBoard.clickButtonSave();

		if (scheduleBoard.isMsgUpdateSuccessDisplayed() == true) {
			setStatusTest("pass", "Displays msg \"Update schedule successfully\"");
		} else {
			setStatusTest("fail", "DOES NOT Display msg \"Update schedule successfully\"");
		}

		TestLogger.info("=================END TT_1209=====================");
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
