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
import talentwize.pages.Appraisal;
import talentwize.pages.AppraisalCycle;
import talentwize.pages.CompanyJobHistory;
import talentwize.pages.ContactDetails;
import talentwize.pages.Dashboard;
import talentwize.pages.EmployeeList;
import talentwize.pages.Form_Appraisal_Information;
import talentwize.pages.Form_Create_Appraisal;
import talentwize.pages.HomePage;
import talentwize.pages.PersonalDetails;
import talentwize.pages.ProjectInfo;
import talentwize.pages.Roles;
import talentwize.pages.Users;

public class Test_FunctionalAccess_Performance_Appraisal_Management_List extends TestManager {
	HomePage homePage;
	WebDriver driver;
	PropertyManager propertyManager;
	Dashboard dashboard;
	Administration administration;
	Users users;
	Roles roles;
	String UserRoleName;
	EmployeeList employeeList;
	PersonalDetails personalDetails;
	ContactDetails contactDetails;
	CompanyJobHistory companyJobHistory;
	ProjectInfo projectInfo;
	Appraisal appraisal;
	Form_Appraisal_Information appraisalInformation;
	Form_Create_Appraisal createAppraisal;
	AppraisalCycle appraisalCycle;

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
		personalDetails = new PersonalDetails(driver);
		contactDetails = new ContactDetails(driver);
		companyJobHistory = new CompanyJobHistory(driver);
		homePage.moLinkWeb(propertyManager.getURL_TalentWize());
		projectInfo = new ProjectInfo(driver);
		appraisal = new Appraisal(driver);
		appraisalInformation = new Form_Appraisal_Information(driver);
		createAppraisal = new Form_Create_Appraisal(driver);
		appraisalCycle = new AppraisalCycle(driver);

	}

	@BeforeMethod
	public void PrintNameTestCase(Method method) {
		TestLogger.info("====== Begin Testcase : " + method.getName() + " ========");
	}

	@Test(priority = 1)
	public void TT_1033() throws InterruptedException {
		TestLogger.info("==========TT_1033================");
		TestLogger.info("1. Login with Administrator account.");
		homePage.SignInWith(propertyManager.getEmailAdmin1(), propertyManager.getPasswordAdmin1());

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
		UserRoleName = "Permission|Appraisal|Management|List|Read" + TienIch.taoRandomSo(3);

		roles.createUserRoleNameWithRoleTypeAdmin(UserRoleName);

		TestLogger.info("4.1 Uncheck on Performance Permission - Appraisal - Management - List| read");
		roles.uncheckbox_Read_AppraisalManagementList();
		TestLogger.info("4.2  Check on Performance Permission - Appraisal - Management - List| Read");
		roles.checkbox_Read_AppraisalManagementList();

		TestLogger.info("5. Click Save button");
		roles.clickButtonSave();

		administration.openTabUsers();

		TestLogger.info("Assign role " + UserRoleName + " to employee : " + propertyManager.getEmailUserTW1());
		users.searchUsername(propertyManager.getEmailUserTW1());

		// Assign role Automation to this employee
		users.assignUserWithNewRole(propertyManager.getEmailUserTW1(), UserRoleName);

		TestLogger.info("6. Log out");

		dashboard.logout();

		TestLogger.info("7. Login with test account : " + propertyManager.getEmailUserTW1());

		homePage.SignInWith(propertyManager.getEmailUserTW1(), propertyManager.getPasswordUserTW1());

		administration.clickLogoTalentWize();
		administration.clickMenuPerformance();
		administration.clickSubMenuAppraisal();
		administration.clickSubMenuManagement();

		TestLogger.info("8. Open Performance menu >> select Apraisal submenu >> Select  Management >> Appraisals tab");
		if (appraisal.istabAppraisalsDisplayed() == true && appraisal.istblAppraisalsDisplayed() == true
				&& appraisal.isIconDeleteDisplayed() == false && appraisal.isButtonCreateDisplayed() == false
				&& appraisal.isButtonViewDetailDisplayed() == true) {
			setStatusTest("pass", "User can see /do:\r\n" + "1. Appraisal| Management menu and Appraisal tab\r\n"
					+ "2. Appraisal table \r\n" + "3. View Appraisal Information screen by click Employee name\r\n"
					+ "4. View detail btn\r\n" + "5.View Appraisal form by click view detail btn\r\n" + "\r\n"
					+ "User CANNOT see/do:\r\n" + "1. Add btn\r\n" + "2. Checkbox and delete btn");
		} else {
			setStatusTest("fail", "User can see /do:\r\n" + "1. Appraisal| Management menu and Appraisal tab\r\n"
					+ "2. Appraisal table \r\n" + "3. View Appraisal Information screen by click Employee name\r\n"
					+ "4. View detail btn\r\n" + "5.View Appraisal form by click view detail btn\r\n" + "\r\n"
					+ "User CANNOT see/do:\r\n" + "1. Add btn\r\n" + "2. Checkbox and delete btn");
		}
		appraisal.clickOnFistLinkOfEmployee();
		if (appraisalInformation.isButtonEditDisplayed() == true) {
			setStatusTest("fail", "User Still see/do:\r\n" + "Edit button");
		} else {
			setStatusTest("pass", "User CAN NOT see/do:\r\n" + "Edit button");
		}
		appraisalInformation.clickButtonClose();
		TestLogger.info("==========TT_1033================");
	}

	@Test(priority = 2)
	public void TT_1031() throws InterruptedException {
		TestLogger.info("==========TT_1031================");
		TestLogger.info("1. Login with Administrator account.");
		homePage.SignInWith(propertyManager.getEmailAdmin1(), propertyManager.getPasswordAdmin1());

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
		UserRoleName = "Permission|Appraisal|Management|List|Create" + TienIch.taoRandomSo(3);

		roles.createUserRoleNameWithRoleTypeAdmin(UserRoleName);

		TestLogger.info("4.1 Uncheck on Performance Permission - Appraisal - Management - List| read");
		roles.uncheckbox_Read_AppraisalManagementList();
		TestLogger.info("4.2  Check on Performance Permission - Appraisal - Management - List| Create");
		roles.checkbox_Create_AppraisalManagementList();

		TestLogger.info("5. Click Save button");
		roles.clickButtonSave();

		administration.openTabUsers();

		TestLogger.info("Assign role " + UserRoleName + " to employee : " + propertyManager.getEmailUserTW1());
		users.searchUsername(propertyManager.getEmailUserTW1());

		// Assign role Automation to this employee
		users.assignUserWithNewRole(propertyManager.getEmailUserTW1(), UserRoleName);

		TestLogger.info("6. Log out");

		dashboard.logout();

		TestLogger.info("7. Login with test account : " + propertyManager.getEmailUserTW1());

		homePage.SignInWith(propertyManager.getEmailUserTW1(), propertyManager.getPasswordUserTW1());

		TestLogger.info("8. Open Performance menu >> select Apraisal submenu >> Select Management >> Appraisals tab");

		administration.clickLogoTalentWize();
		administration.clickMenuPerformance();
		administration.clickSubMenuAppraisal();
		administration.clickSubMenuManagement();

		TestLogger.info("9. Create New Appraisal");

		appraisal.clickButtonCreate();
		createAppraisal.CreateAppraisal_Step1();
		createAppraisal.CreateAppraisal_Step2();
		createAppraisal.clickButtonSave();

		if (appraisal.isTextAddedSuccesfullDisplayed() == true) {
			setStatusTest("pass", "User Still see/do:\r\n" + "message create appraisal");
		} else {
			setStatusTest("fail", "User CAN see/do:\r\n" + "message create appraisal");
		}

		TestLogger.info("10. Check Permission");

		TestLogger.info("User can see /do:\r\n" + "1. Appraisal| Management menu and Appraisal tab\r\n"
				+ "2. Appraisal table \r\n" + "3. View Appraisal Information screen by click Appraisal name\r\n"
				+ "4. View detail btn\r\n" + "5. View Appraisal form by click view detail btn\r\n" + "6. Create btn");

		if (appraisal.istabAppraisalsDisplayed() == true) {
			setStatusTest("pass", "User CAN see/do :" + "Appraisal| Management menu and Appraisal tab");
		} else {
			setStatusTest("fail", "User CANNOT see/do :" + "Appraisal| Management menu and Appraisal tab");
		}

		if (appraisal.istblAppraisalsDisplayed() == true) {
			setStatusTest("pass", "User CAN see/do :" + "Appraisal table");
		} else {
			setStatusTest("fail", "User CANNOT see/do :" + "Appraisal table");
		}

		if (appraisal.isButtonCreateDisplayed() == true) {
			setStatusTest("pass", "User CAN see/do :" + "Create btn");
		} else {
			setStatusTest("fail", "User CANNOT see/do :" + "Create btn");
		}

		if (appraisal.isButtonViewDetailDisplayed() == true) {
			setStatusTest("pass", "User CAN see/do :" + "View detail btn");
		} else {
			setStatusTest("fail", "User CANNOT see/do :" + "View detail btn");
		}

		appraisal.clickBtnViewDetail();
		if (appraisalInformation.isSubTabAppraisalFormDisplayed() == true) {
			setStatusTest("pass", "User CAN see/do :" + "View Appraisal form by click view detail btn");
		} else {
			setStatusTest("fail", "User CANNOT see/do :" + "View Appraisal form by click view detail btn");
		}
		appraisalInformation.clickBtnBackAppraisal();

		appraisal.clickOnFistLinkOfEmployee();
		if (appraisalInformation.isLblAppraisalInfoDisplayed() == true) {
			setStatusTest("pass", "User CAN see/do :" + "View Appraisal Information screen by click Appraisal name");
		} else {
			setStatusTest("fail", "User CANNOT see/do :" + "View Appraisal Information screen by click Appraisal name");
		}

		TestLogger.info("User can NOT see /do:\r\n" + "1. Edit button\r\n" + "2. Checkbox and delete btn");

		if (appraisalInformation.isButtonEditDisplayed() == false) {
			setStatusTest("pass", "User CANNOT see/do :" + "Edit button");
		} else {
			setStatusTest("fail", "User STILL CAN see/do :" + "Edit button");
		}
		appraisalInformation.clickButtonClose();

		if (appraisal.isIconDeleteDisplayed() == false) {
			setStatusTest("pass", "User CANNOT see/do :" + "Checkbox and delete btn");
		} else {
			setStatusTest("fail", "User STILL CAN see/do :" + "Checkbox and delete btn");
		}

		TestLogger.info("==========TT_1031================");
	}

	@Test(priority = 3)
	public void TT_1032() throws InterruptedException {
		TestLogger.info("==========TT_1032================");
		TestLogger.info("1. Login with Administrator account.");
		homePage.SignInWith(propertyManager.getEmailAdmin1(), propertyManager.getPasswordAdmin1());

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
		UserRoleName = "Permission|Appraisal|Management|List|Update" + TienIch.taoRandomSo(3);

		roles.createUserRoleNameWithRoleTypeAdmin(UserRoleName);

		TestLogger.info("4.1 Uncheck on Performance Permission - Appraisal - Management - List| read");
		roles.uncheckbox_Read_AppraisalManagementList();
		TestLogger.info("4.2  Check on Performance Permission - Appraisal - Management - List| Update");
		roles.checkbox_Update_AppraisalManagementList();

		TestLogger.info("5. Click Save button");
		roles.clickButtonSave();

		administration.openTabUsers();

		TestLogger.info("Assign role " + UserRoleName + " to employee : " + propertyManager.getEmailUserTW1());
		users.searchUsername(propertyManager.getEmailUserTW1());

		// Assign role Automation to this employee
		users.assignUserWithNewRole(propertyManager.getEmailUserTW1(), UserRoleName);

		TestLogger.info("6. Log out");

		dashboard.logout();

		TestLogger.info("7. Login with test account : " + propertyManager.getEmailUserTW1());

		homePage.SignInWith(propertyManager.getEmailUserTW1(), propertyManager.getPasswordUserTW1());

		administration.clickLogoTalentWize();
		administration.clickMenuPerformance();
		administration.clickSubMenuAppraisal();
		administration.clickSubMenuManagement();

		TestLogger.info("8. Open Performance menu >> select Apraisal submenu >> Select  Management >> Appraisals tab");
		if (appraisal.istabAppraisalsDisplayed() == true && appraisal.istblAppraisalsDisplayed() == true
				&& appraisal.isIconDeleteDisplayed() == false && appraisal.isButtonCreateDisplayed() == false
				&& appraisal.isButtonViewDetailDisplayed() == true) {
			setStatusTest("pass",
					"User can see /do:\r\n" + "1. Appraisal| Management menu and Appraisal tab\r\n"
							+ "2. Appraisal table \r\n"
							+ "3. View Appraisal Information screen and EDIT button by click employee name\r\n"
							+ "4. View detail btn\r\n" + "5.View Appraisal form by click view detail button\r\n"
							+ "\r\n" + "User CANNOT see/do:\r\n" + "1. Add btn\r\n" + "2. Checkbox and delete btn  ");
		} else {
			setStatusTest("fail",
					"User CAN NOT see /do:\r\n" + "1. Appraisal| Management menu and Appraisal tab\r\n"
							+ "2. Appraisal table \r\n"
							+ "3. View Appraisal Information screen and EDIT button by click employee name\r\n"
							+ "4. View detail btn\r\n" + "5.View Appraisal form by click view detail button\r\n"
							+ "\r\n" + "User CAN see/do:\r\n" + "1. Add btn\r\n" + "2. Checkbox and delete btn ");
		}
		appraisal.clickOnFistLinkOfEmployee();

		if (appraisalInformation.isButtonEditDisplayed() == true) {
			setStatusTest("pass", "User CAN see/do:\r\n" + "Edit button");
		} else {
			setStatusTest("fail", "User CAN NOT see/do:\r\n" + "Edit button");
		}
		appraisalInformation.clickButtonEdit();
		createAppraisal.clickButtonNext_Step1();
		createAppraisal.clickButtonNext_Step2();
		createAppraisal.clickButtonSave();
		if (appraisal.isTextUpdatedSuccesfullDisplayed() == true) {
			setStatusTest("pass", "User Still see/do:\r\n" + "message update appraisal");
		} else {
			setStatusTest("fail", "User CAN see/do:\r\n" + "message update appraisal");
		}
		TestLogger.info("==========TT_1032================");
	}

	@Test(priority = 4)
	public void TT_1030() throws InterruptedException {
		TestLogger.info("==========TT_1030================");
		TestLogger.info("1. Login with Administrator account.");
		homePage.SignInWith(propertyManager.getEmailAdmin1(), propertyManager.getPasswordAdmin1());

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
		UserRoleName = "Permission|Appraisal|Management|List|Delete" + TienIch.taoRandomSo(3);

		roles.createUserRoleNameWithRoleTypeAdmin(UserRoleName);

		TestLogger.info("4.1 Uncheck on Performance Permission - Appraisal - Management - List| read");
		roles.uncheckbox_Read_AppraisalManagementList();
		TestLogger.info("4.2  Check on Performance Permission - Appraisal - Management - List| Delete");
		roles.checkbox_Delete_AppraisalManagementList();

		TestLogger.info("5. Click Save button");
		roles.clickButtonSave();

		administration.openTabUsers();

		TestLogger.info("Assign role " + UserRoleName + " to employee : " + propertyManager.getEmailUserTW1());
		users.searchUsername(propertyManager.getEmailUserTW1());

		// Assign role Automation to this employee
		users.assignUserWithNewRole(propertyManager.getEmailUserTW1(), UserRoleName);

		TestLogger.info("6. Log out");

		dashboard.logout();

		TestLogger.info("7. Login with test account : " + propertyManager.getEmailUserTW1());

		homePage.SignInWith(propertyManager.getEmailUserTW1(), propertyManager.getPasswordUserTW1());

		administration.clickLogoTalentWize();
		administration.clickMenuPerformance();
		administration.clickSubMenuAppraisal();
		administration.clickSubMenuManagement();

		TestLogger.info("8. Open Performance menu >> select Apraisal submenu >> Select  Management >> Appraisals tab");
		if (appraisal.istabAppraisalsDisplayed() == true && appraisal.istblAppraisalsDisplayed() == true
				&& appraisal.isIconDeleteDisplayed() == true && appraisal.isButtonCreateDisplayed() == false
				&& appraisal.isButtonViewDetailDisplayed() == true) {
			setStatusTest("pass", "User can see /do:\r\n" + "1. Appraisal| Management menu and Appraisal tab\r\n"
					+ "2. Appraisal table \r\n" + "3. View Appraisal Information screen  by click Appraisal name\r\n"
					+ "4. View detail btn\r\n" + "5.View Appraisal Form by click view detail button\r\n"
					+ "6. Checkbox and delete btn\r\n" + "\r\n" + "User CANNOT see/do:\r\n" + "1. Edit button\r\n"
					+ "2. Add btn  ");
		} else {
			setStatusTest("fail", "User CAN NOT see /do:\r\n" + "1. Appraisal| Management menu and Appraisal tab\r\n"
					+ "2. Appraisal table \r\n" + "3. View Appraisal Information screen  by click Appraisal name\r\n"
					+ "4. View detail btn\r\n" + "5.View Appraisal Form by click view detail button\r\n"
					+ "6. Checkbox and delete btn\r\n" + "\r\n" + "User STILL see/do:\r\n" + "1. Edit button\r\n"
					+ "2. Add btn  ");
		}
		appraisal.clickchkFirstEmployee();
		appraisal.clickiconDelete();
		appraisal.clickButtonYes();
		if (appraisal.isTextDeletedSuccessfulDisplayed() == true) {
			setStatusTest("pass", "User Still see/do:\r\n" + "message delete appraisal");
		} else {
			setStatusTest("fail", "User CAN see/do:\r\n" + "message delete appraisal");
		}
		TestLogger.info("==========TT_1030================");
	}

	@Test(priority = 5)
	public void TT_1013() throws InterruptedException {
		TestLogger.info("==========TT_1013================");
		TestLogger.info("1. Login with Administrator account.");
		homePage.SignInWith(propertyManager.getEmailAdmin1(), propertyManager.getPasswordAdmin1());

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
		UserRoleName = "Appraisal|Management|List|NoPermission" + TienIch.taoRandomSo(3);

		roles.createUserRoleNameWithRoleTypeAdmin(UserRoleName);

		TestLogger.info("4.1 Uncheck on Performance Permission - Appraisal - Management - List| read");
		roles.uncheckbox_Read_AppraisalManagementList();

		TestLogger.info("5. Click Save button");
		roles.clickButtonSave();

		administration.openTabUsers();

		TestLogger.info("Assign role " + UserRoleName + " to employee : " + propertyManager.getEmailUserTW1());
		users.searchUsername(propertyManager.getEmailUserTW1());

		// Assign role Automation to this employee
		users.assignUserWithNewRole(propertyManager.getEmailUserTW1(), UserRoleName);

		TestLogger.info("6. Log out");

		dashboard.logout();

		TestLogger.info("7. Login with test account : " + propertyManager.getEmailUserTW1());

		homePage.SignInWith(propertyManager.getEmailUserTW1(), propertyManager.getPasswordUserTW1());

		TestLogger.info("8. Open Performance menu >> Appraisal Management menu ");

		administration.clickLogoTalentWize();
		administration.clickMenuPerformance();
		administration.clickSubMenuAppraisal();
		administration.clickSubMenuManagement();

		TestLogger.info("9. Check Permission");

		TestLogger.info("User can NOT see /do:\r\n" + "1. Appraisal table in Appraisals tab");

		if (appraisalCycle.istblAppraisalsCycleDisplayed() == true) {
			setStatusTest("pass", "User CAN see/do :" + "Appraisal| Management menu and Appraisal tab");
		} else {
			setStatusTest("fail", "User CANNOT see/do :" + "Appraisal| Management menu and Appraisal tab");
		}

		TestLogger.info("==========TT_1013================");
	}

	@Test(priority = 6)
	public void TT_1014() throws InterruptedException {
		TestLogger.info("==========TT_1014================");
		TestLogger.info("1. Login with Administrator account.");
		homePage.SignInWith(propertyManager.getEmailAdmin1(), propertyManager.getPasswordAdmin1());

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
		UserRoleName = "Appraisal|Management|List|NoPermission" + TienIch.taoRandomSo(3);

		roles.createUserRoleNameWithRoleTypeAdmin(UserRoleName);

		TestLogger.info("4.1 Uncheck on Performance Permission - Appraisal - Management - List| read");
		roles.uncheckbox_Read_AppraisalManagementList();
		TestLogger.info("4.2 Uncheck on Performance Permission - Appraisal - Management - Cycle| read");
		roles.uncheckbox_Read_AppraisalManagementCycle();

		TestLogger.info("5. Click Save button");
		roles.clickButtonSave();

		administration.openTabUsers();

		TestLogger.info("Assign role " + UserRoleName + " to employee : " + propertyManager.getEmailUserTW1());
		users.searchUsername(propertyManager.getEmailUserTW1());

		// Assign role Automation to this employee
		users.assignUserWithNewRole(propertyManager.getEmailUserTW1(), UserRoleName);

		TestLogger.info("6. Log out");

		dashboard.logout();

		TestLogger.info("7. Login with test account : " + propertyManager.getEmailUserTW1());

		homePage.SignInWith(propertyManager.getEmailUserTW1(), propertyManager.getPasswordUserTW1());

		administration.clickLogoTalentWize();
		administration.clickMenuPerformance();
		administration.clickSubMenuAppraisal();

		TestLogger.info("8. Open Performance menu >> Appraisal sub menu");
		if (administration.isSubMenuManagementDisplayed() == false) {
			setStatusTest("pass", "User can NOT see /do:\r\n" + "1. Appraisal | Management menu\r\n");
		} else {
			setStatusTest("fail", "User STILL see /do:\r\n" + "1. Appraisal | Management menu\r\n");
		}
		TestLogger.info("==========TT_1014================");
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
