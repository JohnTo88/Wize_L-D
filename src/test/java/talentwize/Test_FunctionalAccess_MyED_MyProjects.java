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
import talentwize.pages.Form_AddDependents;
import talentwize.pages.Form_AddEmergencyContact;
import talentwize.pages.Form_AddEmployeeToTheProject;
import talentwize.pages.HomePage;
import talentwize.pages.OtherContacts;
import talentwize.pages.PersonalDetails;
import talentwize.pages.Projects;
import talentwize.pages.Roles;
import talentwize.pages.Users;

// Cần tạo trước dữ liệu Test gồm tên Project là Automation và phải tạo Project Role ,
// rồi gán Role này cho dự án có tên là Automation thì mới chạy OK được .

public class Test_FunctionalAccess_MyED_MyProjects extends TestManager {

	HomePage homePage;
	WebDriver driver;
	PropertyManager propertyManager;
	Dashboard dashboard;
	Administration administration;
	Users users;
	Roles roles;
	String UserRoleName;
	EmployeeList employeeList;
	OtherContacts otherContact;
	PersonalDetails personalDetails;
	Form_AddEmergencyContact formAddEmergencyContact;
	Form_AddDependents formAddDependents;
	Form_AddEmployeeToTheProject formAddEmployeeToTheProject;
	Projects projects;

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
		otherContact = new OtherContacts(driver);
		personalDetails = new PersonalDetails(driver);
		formAddEmergencyContact = new Form_AddEmergencyContact(driver);
		formAddDependents = new Form_AddDependents(driver);
		formAddEmployeeToTheProject = new Form_AddEmployeeToTheProject(driver);
		projects = new Projects(driver);
		homePage.moLinkWeb(propertyManager.getURL_TalentWize());

	}

	@BeforeMethod
	public void PrintNameTestCase(Method method) {
		TestLogger.info("====== Begin Testcase : " + method.getName() + " ========");
	}

	@Test(priority = 1)
	public void TT_1465() throws InterruptedException {
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
		UserRoleName = "ED-Other Contacts|Update" + TienIch.taoRandomSo(3);

		roles.createUserRoleNameWithRoleTypeAdmin(UserRoleName);

		TestLogger.info("+  My ED - Projects | No permission");
		roles.unCheckbox_Read_My_Project();
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

		administration.clickMenuEmployeeData();

		if (administration.isSubMenuProjectDisplayed() == false) {
			setStatusTest("pass", "User can see /do:\r\n" + "1. Projects menu");
		} else {
			setStatusTest("fail", "User can NOT see /do:\r\n" + "1. Projects menu");
		}

	}

	@Test(priority = 2)
	public void TT_1492() throws InterruptedException {
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
		UserRoleName = "My ED-Project|Create" + TienIch.taoRandomSo(3);

		roles.createUserRoleNameWithRoleTypeAdmin(UserRoleName);

		TestLogger.info("+  My ED-Projects| Create");
		roles.unCheckbox_Read_My_Project();

		TestLogger.info("+ Check on My ED - Projects | Create");
		roles.checkbox_Create_My_Project();
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

		administration.clickMenuEmployeeData();

		if (administration.isSubMenuProjectDisplayed() == true) {
			setStatusTest("pass", "User can see /do:\r\n" + "1. Projects menu");
		} else {
			setStatusTest("fail", "User can NOT see /do:\r\n" + "1. Projects menu");
		}

		administration.clickMenuProjects();

		if (projects.isButtonAddDispalayed() == true) {
			setStatusTest("pass", "User CAN see/do:\r\n" + "1. Add  btn");
		} else {
			setStatusTest("fail", "User STILL CAN NOT see/do:\r\n" + "1. Add  btn");
		}

		projects.clickButtonAdd();

		formAddEmployeeToTheProject.addEmployeeToTheProject("Automation");

		if (projects.isTxtAddedSusscessfulDisplayed() == true) {
			setStatusTest("pass", "The system display msg: Employee added successfully!");
		} else {
			setStatusTest("fail", "The system DOES NOT display msg: Employee added successfully!");
		}

	}

	@Test(priority = 3)
	public void TT_1498() throws InterruptedException {
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
		UserRoleName = "ED-Project|Read" + TienIch.taoRandomSo(3);

		roles.createUserRoleNameWithRoleTypeAdmin(UserRoleName);

		TestLogger.info("+  ED-Projects|Read permission");
		roles.unCheckbox_Read_My_Project();
		roles.checkbox_Read_My_Project();
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

		administration.clickMenuEmployeeData();

		if (administration.isSubMenuProjectDisplayed() == true) {
			setStatusTest("pass", "User can see /do:\r\n" + "1. Projects menu");
		} else {
			setStatusTest("fail", "User can NOT see /do:\r\n" + "1. Projects menu");
		}

		administration.clickMenuProjects();

		if (projects.isButtonAddDispalayed() == false && projects.isIconDeletedDispalayed() == false) {
			setStatusTest("pass",
					"User CANNOT see/do:\r\n" + "1. Add  btn\r\n" + "2. Action btn\r\n" + "3. Delete btn");
		} else {
			setStatusTest("fail",
					"User STILL CANs ee/do:\r\n" + "1. Add  btn\r\n" + "2. Action btn\r\n" + "3. Delete btn");
		}

	}

	@Test(priority = 4)
	public void TT_1490() throws InterruptedException {
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
		UserRoleName = "ED-Project|Update" + TienIch.taoRandomSo(3);

		roles.createUserRoleNameWithRoleTypeAdmin(UserRoleName);

		TestLogger.info("+  My ED-Projects|Update");
		roles.unCheckbox_Read_My_Project();
		roles.checkbox_Read_My_Project();

		TestLogger.info("+ Check on ED - Projects | Update");
		roles.checkbox_Update_My_Project();
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
		TestLogger.info("8. Open Employee List screen >> Click on Employee Name to open Pilot view");
		administration.clickMenuEmployeeData();

		if (administration.isSubMenuProjectDisplayed() == true) {
			setStatusTest("pass", "User can see /do:\r\n" + "1. Projects menu");
		} else {
			setStatusTest("fail", "User can NOT see /do:\r\n" + "1. Projects menu");
		}

		administration.clickMenuProjects();

		if (projects.isButtonAddDispalayed() == false) {
			setStatusTest("pass", "User CAN NOT see/do:\r\n" + "1. Add  btn\r\n" + "");
		} else {
			setStatusTest("fail", "User STILL CAN see/do:\r\n" + "1. Add  btn\r\n" + "");
		}

		projects.clickButtonAction();
		if (projects.isAddNewAssignmentDispalayed() == false && projects.isIconDeletedDispalayed() == false) {
			setStatusTest("pass", "User CANNOT see/do:\r\n" + "1. Add  btn\r\n"
					+ "2. Action btn >> Add new Assignment\r\n" + "3. Delete btn");
		} else {
			setStatusTest("fail", "User STILL CAN see/do:\r\n" + "1. Add  btn\r\n"
					+ "2. Action btn >> Add new Assignment\r\n" + "3. Delete btn");
		}

		if (projects.isEditCurrentAssignmentDispalayed() == true) {
			setStatusTest("pass", "User CAN see/do:\r\n" + "3. Action btn >> Edit Current Assignment\r\n" + "");
		} else {
			setStatusTest("fail", "User CAN NOT see/do:\r\n" + "3. Action btn >> Edit Current Assignment\r\n" + "");
		}

		TestLogger.info("9. Click on Action btn >> Edit Current Assignment btn\r\n" + "Click Save btn");
		projects.clickButtonEditCurrentAssignment();

		formAddEmployeeToTheProject.clickButtonSave();

		if (projects.isTxtUpdatedSusscessfulDispalayed() == true) {
			setStatusTest("pass", "The system display msg: Employee added successfully!");
		} else {
			setStatusTest("fail", "The system DOES NOT display msg: Employee added successfully!");
		}

	}

	@Test(priority = 5)
	public void TT_1488() throws InterruptedException {
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
		UserRoleName = "ED-Project|Update" + TienIch.taoRandomSo(3);

		roles.createUserRoleNameWithRoleTypeAdmin(UserRoleName);

		TestLogger.info("+ My ED-Projects|Delete");
		roles.uncheck_Read_ED_Projects();
		roles.check_Read_ED_Projects();

		TestLogger.info("+ Check on ED - Projects |Delete");
		roles.check_Delete_ED_Projects();
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
		TestLogger.info("8. Open Employee List screen >> Click on Employee Name to open Pilot view");
		administration.clickMenuEmployeeList();
		employeeList.searchEmployees("Nguyen Viet Nam");
		employeeList.clickEmployeeNguyenVietNam();

		if (administration.isSubMenuProjectDisplayed() == true) {
			setStatusTest("pass", "User can see /do:\r\n" + "1. Projects menu");
		} else {
			setStatusTest("fail", "User can NOT see /do:\r\n" + "1. Projects menu");
		}

		administration.clickMenuProjects();

		if (projects.isButtonAddDispalayed() == false) {
			setStatusTest("pass", "User CAN NOT see/do:\r\n" + "1. Add  btn\r\n" + "");
		} else {
			setStatusTest("fail", "User STILL CAN see/do:\r\n" + "1. Add  btn\r\n" + "");
		}

		if (projects.isButtonActionDispalayed() == false) {
			setStatusTest("pass", "User CAN NOT see/do:\r\n" + "" + "2. Action btn ");
		} else {
			setStatusTest("fail", "User STILL CAN see/do:\r\n" + "" + "2. Action btn ");
		}

		if (projects.isIconDeletedDispalayed() == true) {
			setStatusTest("pass", "User CAN see/do:\r\n" + "2. Delete btn" + "");
		} else {
			setStatusTest("fail", "User CAN NOT see/do:\r\n" + "2. Delete btn" + "");
		}

		TestLogger.info("9. Select a Project records \r\n" + "Click Yes btn");

		projects.deleteProjectName();

		if (projects.isTxtDeletedSusscessfulDispalayed() == true) {
			setStatusTest("pass", "The system display msg: Deleted successfully!");
		} else {
			setStatusTest("fail", "The system DOES NOT display msg: Deleted successfully!");
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
