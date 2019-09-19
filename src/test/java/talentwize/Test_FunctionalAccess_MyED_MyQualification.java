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
import talentwize.pages.CompanyJobHistory;
import talentwize.pages.ContactDetails;
import talentwize.pages.Dashboard;
import talentwize.pages.EmployeeList;
import talentwize.pages.Form_AddEducation;
import talentwize.pages.Form_AddLanguage;
import talentwize.pages.Form_AddLicense;
import talentwize.pages.Form_AddPreviousWorkExperience;
import talentwize.pages.Form_UpdateEducation;
import talentwize.pages.Form_UpdateLanguage;
import talentwize.pages.Form_UpdateLicense;
import talentwize.pages.Form_UpdatePreviousWorkExperience;
import talentwize.pages.HomePage;
import talentwize.pages.PersonalDetails;
import talentwize.pages.Qualification;
import talentwize.pages.Roles;
import talentwize.pages.Users;

public class Test_FunctionalAccess_MyED_MyQualification extends TestManager {
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
	Qualification qualification;
	Form_AddPreviousWorkExperience addpreviouswork;
	Form_AddEducation addeducation;
	Form_AddLanguage addlanguage;
	Form_AddLicense addlicense;
	Form_UpdatePreviousWorkExperience updatepreviouswork;
	Form_UpdateEducation updateeducation;
	Form_UpdateLanguage updatelanguage;
	Form_UpdateLicense updatelicense;

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
		qualification = new Qualification(driver);
		addpreviouswork = new Form_AddPreviousWorkExperience(driver);
		addeducation = new Form_AddEducation(driver);
		addlanguage = new Form_AddLanguage(driver);
		addlicense = new Form_AddLicense(driver);
		updatepreviouswork = new Form_UpdatePreviousWorkExperience(driver);
		updateeducation = new Form_UpdateEducation(driver);
		updatelanguage = new Form_UpdateLanguage(driver);
		updatelicense = new Form_UpdateLicense(driver);
		homePage.moLinkWeb(propertyManager.getURL_TalentWize());

	}

	@BeforeMethod
	public void PrintNameTestCase(Method method) {
		TestLogger.info("====== Begin Testcase : " + method.getName() + " ========");
	}

	@Test(priority = 1)
	public void TT_1471() throws InterruptedException {
		TestLogger.info("==========TT_606================");
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
		UserRoleName = "Automation-My ED-Qualification|No Permission" + TienIch.taoRandomSo(3);

		roles.createUserRoleNameWithRoleTypeAdmin(UserRoleName);

		TestLogger.info("+ UnCheck on My ED - Qualification | read");
		roles.uncheck_Read_My_Qualification();

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

		administration.clickMenuEmployeeData();

		administration.scrollToSubMenuCompanyJobHistory();
		if (administration.isSubMenuQualificationDisplayed() == false) {
			setStatusTest("pass", "User CANNOT see/do:\r\n" + "Qualification menu");
		} else {
			setStatusTest("fail", "User STILL see/do:\r\n" + "Qualificationmenu");
		}
		TestLogger.info("==========END TT_1471================");
	}

	@Test(priority = 2)
	public void TT_1497() throws InterruptedException {
		TestLogger.info("==========TT_1497================");
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
		UserRoleName = "Automation-Automation-ED-Qualification|Create" + TienIch.taoRandomSo(3);

		roles.createUserRoleNameWithRoleTypeAdmin(UserRoleName);

		roles.uncheck_Read_My_Qualification();
		TestLogger.info("+ Check on My ED - Qualification | Create");
		roles.check_Create_My_Qualification();
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

		administration.clickMenuEmployeeData();

		administration.scrollToSubMenuCompanyJobHistory();
		if (administration.isSubMenuQualificationDisplayed() == true) {
			setStatusTest("pass", "User CAN see/do:\r\n" + "Qualification menu");
		} else {
			setStatusTest("fail", "User CAN Not see/do:\r\n" + "Qualification menu");
		}

		TestLogger.info("Click on Qualification");
		administration.clickSubMenuQualification();
		if (qualification.isbtnDeleteEducationDisplayed() == true
				&& qualification.isbtnDeleteLanguageDisplayed() == true
				&& qualification.isbtnDeleteLicenseDisplayed() == true
				&& qualification.isbtnDeleteWorkDisplayed() == true
				&& qualification.isLinkOfEducationDisplayed() == true
				&& qualification.isLinkOfLanguageDisplayed() == true && qualification.isLinkOfLicenseDisplayed() == true
				&& qualification.isLinkOfWorkDisplayed() == true) {
			setStatusTest("fail", "User Still see/do:\r\n" + "1. Delete btn in 4 panels\r\n"
					+ "2.  Clickable on Company name/ Education name / Language / Licenses Certificates");
		} else {
			setStatusTest("pass", "User CANNOT see/do:\r\n" + "1. Delete btn in 4 panels\r\n"
					+ "2.  Clickable on Company name/ Education name / Language / Licenses Certificates");
		}
		// ============Add previous work===========
		TestLogger.info("Click on Add button of Previous Work Experience");
		qualification.clickbtnAddWork();
		addpreviouswork.addPreviousWorkExperience("Company Name", "Developer", "01-Feb-2015", "31-Dec-2020");
		if (qualification.isMsgAddedSuccessfullyDisplayed() == true) {
			setStatusTest("pass", "User CAN see/do message:\r\n" + "Added successfully");
		} else {
			setStatusTest("fail", "User CAN Not see/do message:\r\n" + "Added successfully");
		}
		// ============Add Education================
		TestLogger.info("Click on Add button of Education");
		qualification.clickbtnAddEducation();
		addeducation.addEducation("technical", "Rmit");
		if (qualification.isMsgAddedSuccessfullyDisplayed() == true) {
			setStatusTest("pass", "User CAN see/do message:\r\n" + "Added successfully");
		} else {
			setStatusTest("fail", "User CAN Not see/do message:\r\n" + "Added successfully");
		}
		// ============Add Language================
		TestLogger.info("Click on Add button of Language");
		qualification.clickbtnAddLanguage();
		addlanguage.addLanguage();
		if (qualification.isMsgAddedSuccessfullyDisplayed() == true) {
			setStatusTest("pass", "User CAN see/do message:\r\n" + "Added successfully");
		} else {
			setStatusTest("fail", "User CAN Not see/do message:\r\n" + "Added successfully");
		}
		// ============Add License================
		TestLogger.info("Click on Add button of License");
		qualification.clickbtnAddLicense();
		addlicense.addLicense("Tester", "01-Dec-2015");
		if (qualification.isMsgAddedSuccessfullyDisplayed() == true) {
			setStatusTest("pass", "User CAN see/do message:\r\n" + "Added successfully");
		} else {
			setStatusTest("fail", "User CAN Not see/do message:\r\n" + "Added successfully");
		}
		TestLogger.info("==========TT_1497================");
	}

	@Test(priority = 3)
	public void TT_1485() throws InterruptedException {
		TestLogger.info("==========TT_1485================");
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
		UserRoleName = "Automation-Automation-ED-Qualification|Read" + TienIch.taoRandomSo(3);

		roles.createUserRoleNameWithRoleTypeAdmin(UserRoleName);

		TestLogger.info("+ UnCheck on My ED - Qualification | read");
		roles.uncheck_Read_My_Qualification();
		TestLogger.info("+ Check on My ED - Qualification | read");
		roles.check_Read_My_Qualification();
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

		administration.clickMenuEmployeeData();

		administration.scrollToSubMenuCompanyJobHistory();
		if (administration.isSubMenuQualificationDisplayed() == true) {
			setStatusTest("pass", "User CAN see/do:\r\n" + "1. Company Job History menu");
		} else {
			setStatusTest("fail", "User CAN Not see/do:\r\n" + "1. Company Job History menu");
		}

		TestLogger.info("Click on Qualification");
		administration.clickSubMenuQualification();
		if (qualification.isbtnAddEducationDisplayed() == true && qualification.isbtnAddLanguageDisplayed() == true
				&& qualification.isbtnAddLicenseDisplayed() == true && qualification.isbtnAddWorkDisplayed() == true
				&& qualification.isbtnDeleteEducationDisplayed() == true
				&& qualification.isbtnDeleteLanguageDisplayed() == true
				&& qualification.isbtnDeleteLicenseDisplayed() == true
				&& qualification.isbtnDeleteWorkDisplayed() == true
				&& qualification.isLinkOfEducationDisplayed() == true
				&& qualification.isLinkOfLanguageDisplayed() == true && qualification.isLinkOfLicenseDisplayed() == true
				&& qualification.isLinkOfWorkDisplayed() == true) {
			setStatusTest("fail",
					"User Still see/do:\r\n" + "1. Add buttons in 4 panels\r\n" + "2. Delete btn in 4 panels\r\n"
							+ "3.  Clickable on Company name/ Education name / Language / Licenses Certificates");
		} else {
			setStatusTest("pass",
					"User CANNOT see/do:\r\n" + "1. Add buttons in 4 panels\r\n" + "2. Delete btn in 4 panels\r\n"
							+ "3.  Clickable on Company name/ Education name / Language / Licenses Certificates");
		}
		TestLogger.info("==========END TT_1485================");
	}

	@Test(priority = 4)
	public void TT_1494() throws InterruptedException {
		TestLogger.info("==========TT_1494================");
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
		UserRoleName = "Automation-ED-Qualification|Update" + TienIch.taoRandomSo(3);

		roles.createUserRoleNameWithRoleTypeAdmin(UserRoleName);
		TestLogger.info("+ UnCheck on My ED - Qualification | read");
		roles.uncheck_Read_My_Qualification();
		TestLogger.info("+ Check on My ED - Qualification | Update");
		roles.check_Update_My_Qualification();
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

		administration.clickMenuEmployeeData();

		administration.scrollToSubMenuCompanyJobHistory();
		if (administration.isSubMenuQualificationDisplayed() == true) {
			setStatusTest("pass", "User CAN see/do:\r\n" + "Qualification menu");
		} else {
			setStatusTest("fail", "User CAN Not see/do:\r\n" + "Qualification menu");
		}

		TestLogger.info("Click on Qualification");
		administration.clickSubMenuQualification();
		if (qualification.isbtnDeleteEducationDisplayed() == true
				&& qualification.isbtnDeleteLanguageDisplayed() == true
				&& qualification.isbtnDeleteLicenseDisplayed() == true
				&& qualification.isbtnDeleteWorkDisplayed() == true
				&& qualification.isLinkOfEducationDisplayed() == true
				&& qualification.isLinkOfLanguageDisplayed() == true && qualification.isLinkOfLicenseDisplayed() == true
				&& qualification.isLinkOfWorkDisplayed() == true) {
			setStatusTest("fail", "User Still see/do:\r\n" + "1. Delete btn in 4 panels\r\n"
					+ "2.  Clickable on Company name/ Education name / Language / Licenses Certificates");
		} else {
			setStatusTest("pass", "User CANNOT see/do:\r\n" + "1. Delete btn in 4 panels\r\n"
					+ "2.  Clickable on Company name/ Education name / Language / Licenses Certificates");
		}
		// ============Update previous work===========
		TestLogger.info("Click on link of Previous Work Experience");
		qualification.clickLinkOfWork();
		updatepreviouswork.clickButtonSave();
		if (qualification.isMsgUpdateSuccessfullyDisplayed() == true) {
			setStatusTest("pass", "User CAN see/do message:\r\n" + "Updated successfully");
		} else {
			setStatusTest("fail", "User CAN Not see/do message:\r\n" + "Updated successfully");
		}
		// ============Update Education===========
		TestLogger.info("Click on link of Education");
		qualification.clickLinkOfEducation();
		updateeducation.clickButtonSave();
		if (qualification.isMsgUpdateSuccessfullyDisplayed() == true) {
			setStatusTest("pass", "User CAN see/do message:\r\n" + "Updated successfully");
		} else {
			setStatusTest("fail", "User CAN Not see/do message:\r\n" + "Updated successfully");
		}
		// ============Update Language===========
		TestLogger.info("Click on link of Language");
		qualification.clickLinkOfLanguage();
		updatelanguage.clickButtonSave();
		if (qualification.isMsgUpdateSuccessfullyDisplayed() == true) {
			setStatusTest("pass", "User CAN see/do message:\r\n" + "Updated successfully");
		} else {
			setStatusTest("fail", "User CAN Not see/do message:\r\n" + "Updated successfully");
		}
		// ============Update License===========
		TestLogger.info("Click on link of License");
		qualification.clickLinkOfLicense();
		updatelicense.clickButtonSave();
		if (qualification.isMsgUpdateSuccessfullyDisplayed() == true) {
			setStatusTest("pass", "User CAN see/do message:\r\n" + "Updated successfully");
		} else {
			setStatusTest("fail", "User CAN Not see/do message:\r\n" + "Updated successfully");
		}
		TestLogger.info("==========TT_1494================");
	}

	@Test(priority = 5)
	public void TT_1481() throws InterruptedException {
		TestLogger.info("==========TT_1481================");
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
		UserRoleName = "Automation-ED-Qualification|Delete" + TienIch.taoRandomSo(3);

		roles.createUserRoleNameWithRoleTypeAdmin(UserRoleName);
		TestLogger.info("+ UnCheck on My ED - Qualification | read");
		roles.uncheck_Read_My_Qualification();
		TestLogger.info("+ Check on My ED - Qualification |Delete");
		roles.check_Delete_My_Qualification();
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

		administration.clickMenuEmployeeData();

		administration.scrollToSubMenuCompanyJobHistory();
		if (administration.isSubMenuQualificationDisplayed() == true) {
			setStatusTest("pass", "User CAN see/do:\r\n" + "Qualification menu");
		} else {
			setStatusTest("fail", "User CAN Not see/do:\r\n" + "Qualification menu");
		}

		TestLogger.info("Click on Qualification");
		administration.clickSubMenuQualification();
		if (qualification.isbtnDeleteEducationDisplayed() == true
				&& qualification.isbtnDeleteLanguageDisplayed() == true
				&& qualification.isbtnDeleteLicenseDisplayed() == true
				&& qualification.isbtnDeleteWorkDisplayed() == true) {
			setStatusTest("pass", "User can see/do:\r\n" + "1. Delete btn in 4 panels\r\n");
		} else {
			setStatusTest("fail", "User CANNOT see/do:\r\n" + "1. Delete btn in 4 panels\r\n");
		}
		// ============Delete previous work===========
		TestLogger.info("Delete Previous Work Experience");
		qualification.deletePreviousWorkExperience();
		if (qualification.isMsgDeleteSuccessfullyDisplayed() == true) {
			setStatusTest("pass", "User CAN see/do message:\r\n" + "Delete successfully");
		} else {
			setStatusTest("fail", "User CAN Not see/do message:\r\n" + "Delete successfully");
		}
		// ============Delete Education===========
		TestLogger.info("Delete Education");
		qualification.deleteEducation();
		if (qualification.isMsgDeleteSuccessfullyDisplayed() == true) {
			setStatusTest("pass", "User CAN see/do message:\r\n" + "Delete successfully");
		} else {
			setStatusTest("fail", "User CAN Not see/do message:\r\n" + "Delete successfully");
		}
		// ============Delete Language===========
		TestLogger.info("Delete Language");
		qualification.deleteLanguage();
		if (qualification.isMsgDeleteSuccessfullyDisplayed() == true) {
			setStatusTest("pass", "User CAN see/do message:\r\n" + "Delete successfully");
		} else {
			setStatusTest("fail", "User CAN Not see/do message:\r\n" + "Delete successfully");
		}
		// ============Delete License===========
		TestLogger.info("Delete License");
		qualification.deleteLicense();
		if (qualification.isMsgDeleteSuccessfullyDisplayed() == true) {
			setStatusTest("pass", "User CAN see/do message:\r\n" + "Delete successfully");
		} else {
			setStatusTest("fail", "User CAN Not see/do message:\r\n" + "Delete successfully");
		}
		TestLogger.info("==========TT_1481================");
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
