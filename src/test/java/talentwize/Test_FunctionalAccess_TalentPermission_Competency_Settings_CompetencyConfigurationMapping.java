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
import talentwize.pages.CompetencyConfiguration;
import talentwize.pages.CompetencyMapping;
import talentwize.pages.ContactDetails;
import talentwize.pages.Dashboard;
import talentwize.pages.EmployeeList;
import talentwize.pages.Form_AddCompetencyConfiguration;
import talentwize.pages.Form_AddCompetencyMapping;
import talentwize.pages.Form_EditCompetencyConfiguration;
import talentwize.pages.Form_EditCompetencyMapping;
import talentwize.pages.HomePage;
import talentwize.pages.PersonalDetails;
import talentwize.pages.Roles;
import talentwize.pages.Users;

public class Test_FunctionalAccess_TalentPermission_Competency_Settings_CompetencyConfigurationMapping
		extends TestManager {
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
	CompetencyConfiguration competencyConfiguration;
	CompetencyMapping competencyMapping;
	Form_AddCompetencyConfiguration addCompetencyConfiguration;
	Form_AddCompetencyMapping addCompetencyMapping;
	Form_EditCompetencyConfiguration editCompetencyConfiguration;
	Form_EditCompetencyMapping editCompetencyMapping;

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
		competencyConfiguration = new CompetencyConfiguration(driver);
		competencyMapping = new CompetencyMapping(driver);
		homePage.moLinkWeb(propertyManager.getURL_TalentWize());
		addCompetencyConfiguration = new Form_AddCompetencyConfiguration(driver);
		addCompetencyMapping = new Form_AddCompetencyMapping(driver);
		editCompetencyConfiguration = new Form_EditCompetencyConfiguration(driver);
		editCompetencyMapping = new Form_EditCompetencyMapping(driver);

	}

	@BeforeMethod
	public void PrintNameTestCase(Method method) {
		TestLogger.info("====== Begin Testcase : " + method.getName() + " ========");
	}

	@Test(priority = 1)
	public void TT_1111() throws InterruptedException {
		TestLogger.info("==========TT_1111================");
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
		UserRoleName = "CompetencyConfiguration|Mapping|NoPermission" + TienIch.taoRandomSo(3);

		roles.createUserRoleNameWithRoleTypeAdmin(UserRoleName);

		TestLogger
				.info("4.1 Uncheck Talent Permission - Competency - Settings - Competency Configuration/Mapping| read");
		roles.uncheckbox_Read_Competency_Settings_CompetencyConfiguration_Mapping();

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
		administration.clickMenuTalentManagement();
		administration.clickSubMenuCompetency();
		administration.clickSubMenuCompetencySettings();

		TestLogger.info("8. Open Talent Management >> Competency Settings >> Competency Configuration");
		if (administration.isTabCompetencyConfigurationDisplayed() == false) {
			setStatusTest("pass", "User can NOT see /do:\r\n" + "Competency Configuration tab");
		} else {
			setStatusTest("fail", "User STILL see /do:\r\n" + "Competency Configuration tab");
		}

		TestLogger.info("9. Open Talent Management >> Competency Settings >> Competency Mapping");
		if (administration.isTabCompetencyMappingDisplayed() == false) {
			setStatusTest("pass", "User can NOT see /do:\r\n" + "Competency Mapping tab");
		} else {
			setStatusTest("fail", "User STILL see /do:\r\n" + "Competency Mapping tab");
		}
		TestLogger.info("==========TT_1111================");
	}

	@Test(priority = 2)
	public void TT_1107() throws InterruptedException {
		TestLogger.info("==========TT_1107================");
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
		UserRoleName = "CompetencyConfiguration|Mapping|Read" + TienIch.taoRandomSo(3);

		roles.createUserRoleNameWithRoleTypeAdmin(UserRoleName);

		TestLogger
				.info("4.1 Uncheck Talent Permission - Competency - Settings - Competency Configuration/Mapping| read");
		roles.uncheckbox_Read_Competency_Settings_CompetencyConfiguration_Mapping();
		TestLogger.info(
				"4.2 + Check on Talent Permission - Competency - Settings - Competency Configuration/Mapping  | Read");
		roles.checkbox_Read_Competency_Settings_CompetencyConfiguration_Mapping();

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
		administration.clickMenuTalentManagement();
		administration.clickSubMenuCompetency();
		administration.clickSubMenuCompetencySettings();
		administration.clickTabCompetencyConfiguration();

		TestLogger.info("8. Open Talent Management >> Competency Settings >> Competency Configuration");
		if (competencyConfiguration.isButtonAddDisplayed() == false
				&& competencyConfiguration.isButtonDeleteDisplayed() == false
				&& competencyConfiguration.isChkNameDisplayed() == false
		// && competencyConfiguration.isTblCompetencySettingsDisplayed()==true
		) {
			setStatusTest("pass", "User can see /do:\r\n" + "1. Data table\r\n" + "\r\n" + "User CANNOT see/do\r\n"
					+ "1. button Add\r\n" + "2. Edit function\r\n" + "3. Delete function");
		} else {
			setStatusTest("fail", "User can NOT see /do:\r\n" + "1. Data table\r\n" + "\r\n" + "User STILL see/do\r\n"
					+ "1. button Add\r\n" + "2. Edit function\r\n" + "3. Delete function");
		}

		administration.clickTabCompetencyMapping();
		TestLogger.info("9. Open Talent Management >> Competency Settings >> Competency Mapping");
		if (competencyMapping.isButtonAddDisplayed() == false && competencyMapping.isButtonDeleteDisplayed() == false
				&& competencyMapping.isChkNameDisplayed() == false
				&& competencyMapping.isTblCompetencyMappingDisplayed() == true) {
			setStatusTest("pass", "User can see /do:\r\n" + "1. Data table\r\n" + "\r\n" + "User CANNOT see/do\r\n"
					+ "1. button Add\r\n" + "2. Edit function\r\n" + "3. Delete function");
		} else {
			setStatusTest("fail", "User can NOT see /do:\r\n" + "1. Data table\r\n" + "\r\n" + "User STILL see/do\r\n"
					+ "1. button Add\r\n" + "2. Edit function\r\n" + "3. Delete function");
		}
		TestLogger.info("==========TT_1107================");
	}

	@Test(priority = 3)
	public void TT_1109() throws InterruptedException {
		TestLogger.info("==========TT_1109================");
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

		TestLogger
				.info("4.1 Uncheck Talent Permission - Competency - Settings - Competency Configuration/Mapping| read");
		roles.uncheckbox_Read_Competency_Settings_CompetencyConfiguration_Mapping();
		TestLogger.info(
				"4.2 + Check on Talent Permission - Competency - Settings - Competency Configuration/Mapping  | Create");
		roles.checkbox_Create_Competency_Settings_CompetencyConfiguration_Mapping();

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
		administration.clickMenuTalentManagement();
		administration.clickSubMenuCompetency();
		administration.clickSubMenuCompetencySettings();
		administration.clickTabCompetencyConfiguration();

		// Open Competency Configuration tab
		TestLogger.info("8. Open Talent Management >> Competency Settings >> Competency Configuration");
		if (competencyConfiguration.isButtonAddDisplayed() == true
				&& competencyConfiguration.isButtonDeleteDisplayed() == false
				&& competencyConfiguration.isCheckboxNameDisplayed() == false
		// && competencyConfiguration.isTblCompetencySettingsDisplayed()==true
		) {
			setStatusTest("pass", "User can see /do:\r\n" + "1. Data table\r\n" + "2. Add button\r\n" + "\r\n"
					+ "User CANNOT see/do\r\n" + "1. Edit function\r\n" + "2. Delete function");
		} else {
			setStatusTest("fail", "User CAN NOT see /do:\r\n" + "1. Data table\r\n" + "2. Add button\r\n" + "\r\n"
					+ "User STILL see/do\r\n" + "1. Edit function\r\n" + "2. Delete function");
		}

		// Add Competency Configuration
		TestLogger.info("Steps 9: " + "1. Open Talent Management \r\n" + "2. Open Competency Settings \r\n"
				+ "3. Open Competency Configuration\r\n" + "4. Click on button Add\r\n" + "5. Input data.\r\n"
				+ "6. Click on button \"Save\"");
		competencyConfiguration.clickButtonAdd();
		addCompetencyConfiguration.addCompetency("A" + TienIch.taoRandomSo(3));
		if (competencyConfiguration.isMsgAddCompetencyConfigurationDisplayed() == true) {
			setStatusTest("pass", "User can see /do:\r\n" + "Add Competency Configuration");
		} else {
			setStatusTest("fail", "User CAN NOT see /do:\r\n" + "Add Competency Configuration");
		}

		// Open Competency Mapping tab
		administration.clickTabCompetencyMapping();
		TestLogger.info("10. Open Talent Management >> Competency Settings >> Competency Mapping");
		if (competencyMapping.isButtonAddDisplayed() == true && competencyMapping.isButtonDeleteDisplayed() == false
				&& competencyMapping.isChkNameDisplayed() == false
				&& competencyMapping.isTblCompetencyMappingDisplayed() == true) {
			setStatusTest("pass", "User can see /do:\r\n" + "1. Data table\r\n" + "2. Add button\r\n" + "\r\n"
					+ "User CANNOT see/do\r\n" + "1. Edit function\r\n" + "2. Delete function");
		} else {
			setStatusTest("fail", "User can NOT see /do:\r\n" + "1. Data table\r\n" + "2. Add button\r\n" + "\r\n"
					+ "User STILL see/do\r\n" + "1. Edit function\r\n" + "2. Delete function");
		}

		// Add Competency Mapping
		TestLogger.info("Steps 11: " + "1. Open Talent Management \r\n" + "2. Open Competency Settings \r\n"
				+ "3. Open Competency Mapping\r\n" + "4. Click on button Add\r\n" + "5. Input data.\r\n"
				+ "6. Click on button \"Save\"");
		competencyMapping.clickButtonAdd();
		addCompetencyMapping.addCompetencyMapping("Tek Academy");
		if (competencyMapping.isMsgAddCompetencyMappingDisplayed() == true) {
			setStatusTest("pass", "User can see /do:\r\n" + "Add Competency Mapping");
		} else {
			setStatusTest("fail", "User CAN NOT see /do:\r\n" + "Add Competency Mapping");
		}

		TestLogger.info("==========TT_1109================");
	}

	@Test(priority = 4)
	public void TT_1108() throws InterruptedException {
		TestLogger.info("==========TT_1108================");
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

		TestLogger
				.info("4.1 Uncheck Talent Permission - Competency - Settings - Competency Configuration/Mapping| read");
		roles.uncheckbox_Read_Competency_Settings_CompetencyConfiguration_Mapping();
		TestLogger.info(
				"4.2 + Check on Talent Permission - Competency - Settings - Competency Configuration/Mapping | Update");
		roles.checkbox_Update_Competency_Settings_CompetencyConfiguration_Mapping();

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
		administration.clickMenuTalentManagement();
		administration.clickSubMenuCompetency();
		administration.clickSubMenuCompetencySettings();
		administration.clickTabCompetencyConfiguration();

		// Open Competency Configuration tab
		TestLogger.info("8. Open Talent Management >> Competency Settings >> Competency Configuration");
		if (competencyConfiguration.isButtonAddDisplayed() == false
				&& competencyConfiguration.isButtonDeleteDisplayed() == false
				&& competencyConfiguration.isChkNameDisplayed() == true
		// && competencyConfiguration.isTblCompetencySettingsDisplayed()==true
		) {
			setStatusTest("pass", "User can see /do:\r\n" + "1. Data table\r\n" + "2. Edit function\r\n" + "\r\n"
					+ "User CANNOT see/do\r\n" + "1. button Add\r\n" + "2. Delete function");
		} else {
			setStatusTest("fail", "User can NOT see /do:\r\n" + "1. Data table\r\n" + "2. Edit function\r\n" + "\r\n"
					+ "User STILL see/do\r\n" + "1. button Add\r\n" + "2. Delete function");
		}

		// Update Competency Configuration
		TestLogger.info("Steps 9: " + "1. Open Talent Management \r\n" + "2. Open Competency Settings \r\n"
				+ "3. Open Competency Configuration\r\n" + "4. Click on link Competency name\r\n" + "5. Edit data.\r\n"
				+ "6. Click on button \"Save\"");
		competencyConfiguration.clickChkName();
		editCompetencyConfiguration.clickButtonSave();
		if (competencyConfiguration.isMsgUpdateCompetencyConfigurationDisplayed() == true) {
			setStatusTest("pass", "User can see /do:\r\n" + "Update Competency Configuration");
		} else {
			setStatusTest("fail", "User CAN NOT see /do:\r\n" + "Update Competency Configuration");
		}

		// Open Competency Mapping tab
		administration.clickTabCompetencyMapping();
		TestLogger.info("10. Open Talent Management >> Competency Settings >> Competency Mapping");
		if (competencyMapping.isButtonAddDisplayed() == false && competencyMapping.isButtonDeleteDisplayed() == false
				&& competencyMapping.isChkNameDisplayed() == true
				&& competencyMapping.isTblCompetencyMappingDisplayed() == true) {
			setStatusTest("pass", "User can see /do:\r\n" + "1. Data table\r\n" + "2. Edit function\r\n" + "\r\n"
					+ "User CANNOT see/do\r\n" + "1. button Add\r\n" + "2. Delete function");
		} else {
			setStatusTest("fail", "User CAN NOT see /do:\r\n" + "1. Data table\r\n" + "2. Edit function\r\n" + "\r\n"
					+ "User STILL see/do\r\n" + "1. button Add\r\n" + "2. Delete function");
		}

		// Update Competency Mapping
		TestLogger.info("Steps 11: " + "1. Open Talent Management \r\n" + "2. Open Competency Settings \r\n"
				+ "3. Open Competency Mapping\r\n" + "4. Click on link Competency mapping name\r\n"
				+ "5. Edit data.\r\n" + "6. Click on button \"Save\"");
		competencyMapping.clickChkName();
		editCompetencyMapping.editCompetencyMapping();
		if (competencyMapping.isMsgUpdateCompetencyMappingDisplayed() == true) {
			setStatusTest("pass", "User can see /do:\r\n" + "Update Competency Mapping");
		} else {
			setStatusTest("fail", "User CAN NOT see /do:\r\n" + "Update Competency Mapping");
		}

		TestLogger.info("==========TT_1108================");
	}

	@Test(priority = 5)
	public void TT_1110() throws InterruptedException {
		TestLogger.info("==========TT_1110================");
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

		TestLogger
				.info("4.1 Uncheck Talent Permission - Competency - Settings - Competency Configuration/Mapping| read");
		roles.uncheckbox_Read_Competency_Settings_CompetencyConfiguration_Mapping();
		TestLogger.info(
				"4.2 + Check on Talent Permission - Competency - Settings - Competency Configuration/Mapping | Delete");
		roles.checkbox_Delete_Competency_Settings_CompetencyConfiguration_Mapping();

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
		administration.clickMenuTalentManagement();
		administration.clickSubMenuCompetency();
		administration.clickSubMenuCompetencySettings();
		administration.clickTabCompetencyConfiguration();

		// Open Competency Configuration tab
		TestLogger.info("8. Open Talent Management >> Competency Settings >> Competency Configuration");
		if (competencyConfiguration.isButtonAddDisplayed() == false
				&& competencyConfiguration.isButtonDeleteDisplayed() == true
				&& competencyConfiguration.isChkNameDisplayed() == false
		// && competencyConfiguration.isTblCompetencySettingsDisplayed()==true
		) {
			setStatusTest("pass", "User can see /do:\r\n" + "1. Data table\r\n" + "2. Delete fuction\r\n" + "\r\n"
					+ "User CANNOT see/do\r\n" + "1. Edit fucntion\r\n" + "2. Add button");
		} else {
			setStatusTest("fail", "User can see /do:\r\n" + "1. Data table\r\n" + "2. Delete fuction\r\n" + "\r\n"
					+ "User CANNOT see/do\r\n" + "1. Edit fucntion\r\n" + "2. Add button");
		}

		// Delete Competency Configuration
		TestLogger.info("Steps 9: " + "1. Open Talent Management \r\n" + "2. Open Competency Settings \r\n"
				+ "3. Open Competency Configuration\r\n" + "4. Choose Competency name\r\n" + "5. Click Delete icon");
		competencyConfiguration.clickCheckboxName();
		competencyConfiguration.clickButtonDelete();
		competencyConfiguration.clickButtonYes();
		if (competencyConfiguration.isMsgDeleteCompetencyConfigurationDisplayed() == true) {
			setStatusTest("pass", "User can see /do:\r\n" + "Delete Competency Configuration");
		} else {
			setStatusTest("fail", "User CAN NOT see /do:\r\n" + "Delete Competency Configuration");
		}

		// Open Competency Mapping tab
		administration.clickTabCompetencyMapping();
		TestLogger.info("10. Open Talent Management >> Competency Settings >> Competency Mapping");
		if (competencyMapping.isButtonAddDisplayed() == false && competencyMapping.isButtonDeleteDisplayed() == true
				&& competencyMapping.isChkNameDisplayed() == false
				&& competencyMapping.isTblCompetencyMappingDisplayed() == true) {
			setStatusTest("pass", "User can see /do:\r\n" + "1. Data table\r\n" + "2. Delete fuction\r\n" + "\r\n"
					+ "User CANNOT see/do\r\n" + "1. Edit fucntion\r\n" + "2. Add button");
		} else {
			setStatusTest("fail", "User can NOT see /do:\r\n" + "1. Data table\r\n" + "2. Delete fuction\r\n" + "\r\n"
					+ "User STILL see/do\r\n" + "1. Edit fucntion\r\n" + "2. Add button");
		}

		// Find Competency Mapping before delete
		competencyMapping.fillSearchforMapping("Engineer L1");
		// Delete Competency Mapping
		TestLogger.info("Steps 11: " + "1. Open Talent Management \r\n" + "2. Open Competency Settings \r\n"
				+ "3. Open Competency Mapping\r\n" + "4. Choose Competency mapping name\r\n"
				+ "5. Click on Delete icon");
		competencyMapping.clickcheckboxName();
		competencyMapping.clickButtonDelete();
		competencyMapping.clickButtonYes();
		if (competencyMapping.isMsgDeleteCompetencyMappingDisplayed() == true) {
			setStatusTest("pass", "User can see /do:\r\n" + "Delete Competency Mapping");
		} else {
			setStatusTest("fail", "User CAN NOT see /do:\r\n" + "Delete Competency Mapping");
		}

		TestLogger.info("==========TT_1110================");
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
