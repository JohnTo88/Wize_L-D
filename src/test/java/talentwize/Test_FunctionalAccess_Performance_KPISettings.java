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
import talentwize.pages.AssignRule;
import talentwize.pages.Dashboard;
import talentwize.pages.EmployeeList;
import talentwize.pages.Form_AddAssignRule;
import talentwize.pages.Form_AddKPIConfiguration;
import talentwize.pages.Form_AddKPIMapping;
import talentwize.pages.Form_AddRuleConfiguration;
import talentwize.pages.Form_EditKPI;
import talentwize.pages.Form_EditKPIList;
import talentwize.pages.Form_EditKPIMappingHistory;
import talentwize.pages.Form_EditRuleConfiguration;
import talentwize.pages.HomePage;
import talentwize.pages.KPIConfiguration;
import talentwize.pages.KPIMapping;
import talentwize.pages.KPIMappingHistory;
import talentwize.pages.Roles;
import talentwize.pages.RuleConfiguration;
import talentwize.pages.Users;

public class Test_FunctionalAccess_Performance_KPISettings extends TestManager {
	HomePage homePage;
	WebDriver driver;
	PropertyManager propertyManager;
	Dashboard dashboard;
	Administration administration;
	Users users;
	Roles roles;
	String UserRoleName;
	EmployeeList employeeList;
	KPIConfiguration kpiConfiguration;
	RuleConfiguration ruleConfiguration;
	AssignRule assignRule;
	KPIMapping kpiMapping;
	KPIMappingHistory kpiMappingHistory;
	Form_AddKPIConfiguration addKPIConfiguration;
	Form_EditKPI editKPI;
	Form_EditKPIList editKPIList;
	Form_EditRuleConfiguration editRuleConfiguration;
	Form_AddRuleConfiguration addRuleConfiguration;
	Form_AddAssignRule addAssignRule;
	Form_AddKPIMapping addKPIMapping;
	Form_EditKPIMappingHistory editKPIMappingHistory;

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
		kpiConfiguration = new KPIConfiguration(driver);
		ruleConfiguration = new RuleConfiguration(driver);
		assignRule = new AssignRule(driver);
		kpiMapping = new KPIMapping(driver);
		kpiMappingHistory = new KPIMappingHistory(driver);
		editKPI = new Form_EditKPI(driver);
		editKPIList = new Form_EditKPIList(driver);
		addKPIConfiguration = new Form_AddKPIConfiguration(driver);
		editRuleConfiguration = new Form_EditRuleConfiguration(driver);
		addRuleConfiguration = new Form_AddRuleConfiguration(driver);
		addAssignRule = new Form_AddAssignRule(driver);
		addKPIMapping = new Form_AddKPIMapping(driver);
		editKPIMappingHistory = new Form_EditKPIMappingHistory(driver);
		homePage.moLinkWeb(propertyManager.getURL_TalentWize());

	}

	@BeforeMethod
	public void PrintNameTestCase(Method method) {
		TestLogger.info("====== Begin Testcase : " + method.getName() + " ========");
	}

	@Test(priority = 1)
	public void TT_1007() throws InterruptedException {
		TestLogger.info("==========TT_1007================");
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
		UserRoleName = "Performance|KPISettings|NoPermission" + TienIch.taoRandomSo(3);

		roles.createUserRoleNameWithRoleTypeAdmin(UserRoleName);
		TestLogger.info("+ UnCheck all Perfomance Permission - KPI Settings| read");
		roles.uncheck_Read_KPISettings();

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
		administration.clickSubMenuKPI();
		if (administration.isSubMenuKPISettingsDisplayed() == false) {
			setStatusTest("pass", "User CANNOT see/do:\r\n" + "KPI Settings menu");
		} else {
			setStatusTest("fail", "User STILL see/do:\r\n" + "KPI Settings menu");
		}
		TestLogger.info("==========TT_1007================");
	}

	// Bug : http://10.17.14.203:8080/browse/TAL-768
	@Test(priority = 2)
	public void TT_1006() throws InterruptedException {
		TestLogger.info("==========TT_1006================");
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
		UserRoleName = "Performance|KPISettings|Create" + TienIch.taoRandomSo(3);

		roles.createUserRoleNameWithRoleTypeAdmin(UserRoleName);
		TestLogger.info("+ UnCheck KPI Settings | read");
		roles.uncheck_Read_KPISettings();
		TestLogger.info("+ Check on KPI Settings | Create");
		roles.check_Create_KPISettings();
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

		administration.clickMenuPerformance();
		administration.clickSubMenuKPI();
		if (administration.isSubMenuKPISettingsDisplayed() == true) {
			setStatusTest("pass", "User CAN see/do:\r\n" + "KPI Settings menu");
		} else {
			setStatusTest("fail", "User CAN NOT see/do:\r\n" + "KPI Settings menu");
		}

		TestLogger.info("Click on KPI Settings");
		administration.clickSubMenuKPISettings();
		if (kpiConfiguration.istabKPISettingsDisplayed() == true && kpiConfiguration.istblKPIsListDisplayed() == true
				&& kpiConfiguration.isbtnSearchDisplayed() == true && kpiConfiguration.isTxtSearchDisplayed() == true
				&& kpiConfiguration.islinkOfKPIConfigurationDisplayed() == true
				&& kpiConfiguration.islinkOfKPIDisplayed() == true && kpiConfiguration.isButtonAddDisplayed() == true
				&& kpiConfiguration.isButtonKPIBoardDisplayed() == true
				&& kpiConfiguration.isBtnDeleteCategoryDisplayed() == false) {
			setStatusTest("pass", "User can see /do:\r\n" + "1. KPI Settings menu\r\n"
					+ "2. List of KPIs List table \r\n" + "3. Search function\r\n"
					+ "4. View Edit KPI category by click KPI category hyperlink but it is disable all field \r\n"
					+ "5. View Edit KPI by click KPI name hyperlink but it is disable all fields\r\n"
					+ "7. KPI Board button\r\n" + "8. Add  btn and add successfully KPI category and KPI \r\n" + "\r\n"
					+ "User CANNOT see/do:\r\n" + "2. Checkbox and delete button");
		} else {
			setStatusTest("fail", "User CANNOT see /do:\\r\\n\" + \r\n"
					+ "					\"1. KPI Settings menu\\r\\n\" + \r\n"
					+ "					\"2. List of KPIs List table \\r\\n\" + \r\n"
					+ "					\"3. Search function\\r\\n\" + \r\n"
					+ "					\"4. View Edit KPI category by click KPI category hyperlink but it is disable all field \\r\\n\" + \r\n"
					+ "					\"5. View Edit KPI by click KPI name hyperlink but it is disable all fields\\r\\n\" + \r\n"
					+ "					\"7. KPI Board button\\r\\n\" + \r\n"
					+ "					\"8. Add  btn and add successfully KPI category and KPI \\r\\n\" + \r\n"
					+ "					\"\\r\\n\" + \r\n" + "					\"User Still see/do:\\r\\n\" + \r\n"
					+ "					\"2. Checkbox and delete button");
		}

		TestLogger.info("Click on KPI Settings hyperlink");
		kpiConfiguration.clickchkCategory();
		if (editKPIList.isButtonCloseDisplayed() == true) {
			setStatusTest("pass", "User CAN see/do Close button");
		} else {
			setStatusTest("fail", "User CAN Not see/do Close button");
		}
		TestLogger.info("Click on Close button");
		editKPIList.clickButtonClose();
		// ============Add KPI===========
		TestLogger.info("Click on Add button of KPI");
		kpiConfiguration.clickbtnAdd();
		addKPIConfiguration.addKPIConfiguration("009" + TienIch.taoRandomSo(3), "Test", "3", "1");
		if (kpiConfiguration.ismsgAddSuccessfullyDisplayed() == true) {
			setStatusTest("pass", "User CAN see/do message:\r\n" + "Added successfully");
		} else {
			setStatusTest("fail", "User CAN Not see/do message:\r\n" + "Added successfully");
		}
		// ==========================Rule Configuration==========
		TestLogger.info("Click on tab Rule Configuration");
		ruleConfiguration.clicktabRuleConfiguration();
		if (ruleConfiguration.isButtonKPIBoardDisplayed() == true && ruleConfiguration.isButtonAddDisplayed() == true
				&& ruleConfiguration.istabRuleConfigurationDisplayed() == true
				&& ruleConfiguration.isttxtSearchDisplayed() == true
				&& ruleConfiguration.isbtnDeleteRuleDisplayed() == false
				&& ruleConfiguration.isstoreItemDisplayed() == true) {
			setStatusTest("pass",
					"User can see /do:\r\n" + "1. KPI Settings menu\r\n" + "2. Rule List table \r\n"
							+ "3. Search codes function\r\n"
							+ "4. View Edit Rule by click Rule code hyperlink but it is disable all fields \r\n"
							+ "7. Sort function\r\n" + "8. Add btn and add Rule successfully\r\n" + "\r\n"
							+ "User CANNOT see/do:\r\n" + "1. Checkbox and delete button");
		} else {
			setStatusTest("fail",
					"User Can not see /do:\r\n" + "1. KPI Settings menu\r\n" + "2. Rule List table \r\n"
							+ "3. Search codes function\r\n"
							+ "4. View Edit Rule by click Rule code hyperlink but it is disable all fields \r\n"
							+ "7. Sort function\r\n" + "8. Add btn and add Rule successfully\r\n" + "\r\n"
							+ "User still see/do:\r\n" + "1. Checkbox and delete button");
		}
		TestLogger.info("Click on Rule Configuration hyperlink");
		ruleConfiguration.clickchkRule();
		if (editRuleConfiguration.isButtonSaveDisplayed() == false) {
			setStatusTest("pass", "User CAN see/do Close button");
		} else {
			setStatusTest("fail", "User CAN Not see/do Close button");
		}
		TestLogger.info("Click on Close button");
		editKPIList.clickButtonClose();
		// ============Add Rule Configuration===========
		TestLogger.info("Click on Add button of Rule Configuration");
		ruleConfiguration.clickbtnAdd();
		addRuleConfiguration.addRuleConfiguration("999" + TienIch.taoRandomSo(3), "3", "Learn English");
		if (ruleConfiguration.ismsgAddSuccessfullyDisplayed() == true) {
			setStatusTest("pass", "User CAN see/do message:\r\n" + "Added successfully");
		} else {
			setStatusTest("fail", "User CAN Not see/do message:\r\n" + "Added successfully");
		}
		// ==========================Rule Configuration==========
		// ==========================Assign Rule==========
		TestLogger.info("Click on tab Assign Rule");
		assignRule.clicktabAssignRule();
		if (assignRule.islblKPISettingsDisplayed() == true && assignRule.islblLogListDisplayed() == true
				&& assignRule.istxtSearchDisplayed() == true && assignRule.ischkLogListDisplayed() == true
				&& assignRule.isbtnKPIBoardDisplayed() == true && assignRule.isbtnAddDisplayed() == true
				&& assignRule.isbtnDeleteDisplayed() == false) {
			setStatusTest("pass",
					"User can see /do:\r\n" + "1. KPI Settings menu\r\n" + "2. Log List table \r\n"
							+ "3. Search  function\r\n" + "4. Sort function\r\n"
							+ "5. Add button and add Assign Rule successfully\r\n" + "\r\n" + "User CANNOT see/do:\r\n"
							+ "1. Checkbox and delete button");
		} else {
			setStatusTest("fail",
					"User can NOT see /do:\r\n" + "1. KPI Settings menu\r\n" + "2. Log List table \r\n"
							+ "3. Search  function\r\n" + "4. Sort function\r\n"
							+ "5. Add button and add Assign Rule successfully\r\n" + "\r\n" + "User Still see/do:\r\n"
							+ "1. Checkbox and delete button");
		}
		// *****************************************************************************
		// ============Add Assign Rule===========
		TestLogger.info("Choose month");
		assignRule.chooseMonth();
		TestLogger.info("Click on Add Assign Rule");
		assignRule.clickbtnAdd();
		addAssignRule.addAssignRuleToday();
		if (assignRule.ismsgAddLogSuccessfullyDisplayed() == true) {
			setStatusTest("pass", "User CAN see/do message:\r\n" + "Added successfully");
		} else {
			setStatusTest("fail", "User CAN Not see/do message:\r\n" + "Added successfully");
		}

		// ==========================Assign Rule==========
		// ==========================KPI Mapping==========
		TestLogger.info("Click on tab KPI Mapping");
		kpiMapping.clicktabKPIMapping();

		// ============Add KPI Mapping===========
		TestLogger.info("Click on Add KPI Mapping");
		kpiMapping.clickbtnAdd();
		TestLogger.info("Add Assign Rule");
		addKPIMapping.addAssignRule();
		if (kpiMapping.ismsgAddKPIMappingSuccessfullyDisplayed() == true) {
			setStatusTest("pass", "User CAN see/do message:\r\n" + "Added successfully");
		} else {
			setStatusTest("fail", "User CAN Not see/do message:\r\n" + "Added successfully");
		}
		// ==========================KPI Mapping==========
		kpiMapping.clicktabKPIMapping();
		if (kpiMapping.istabKPIMappingDisplayed() == true && kpiMapping.islblNameDisplayed() == true
				&& kpiMapping.ischkSortDisplayed() == true && kpiMapping.isbtnViewDetailDisplayed() == true
				&& kpiMapping.isbtnAddDisplayed() == true && kpiMapping.isbtnKPIBoardDisplayed() == true
				&& kpiMapping.isbtnDeleteDisplayed() == false) {
			setStatusTest("pass", "User can see /do:\r\n" + "1. KPI Settings menu\r\n"
					+ "2. KPI mapping List table \r\n" + "3. Filter function\r\n" + "4. Sort function\r\n"
					+ "5. View Detail button\r\n" + "//6. view screen successfully  by click view detail btn\r\n"
					+ "//7. List \"KPI Mapping History\"\r\n"
					+ "//8. View \"Group Mapping Info\" screen successfully by click record KPI mapping history \r\n"
					+ "9. Add  btn //and add KPI mapping successfully\r\n" + "\r\n" + "User CANNOT see/do:\r\n"
					+ "1.  Checkbox and delete button");
		} else {
			setStatusTest("fail", "User can see /do:\r\n" + "1. KPI Settings menu\r\n"
					+ "2. KPI mapping List table \r\n" + "3. Filter function\r\n" + "4. Sort function\r\n"
					+ "5. View Detail button\r\n" + "6. view screen successfully  by click view detail btn\r\n"
					+ "7. List \"KPI Mapping History\"\r\n"
					+ "8. View \"Group Mapping Info\" screen successfully by click record KPI mapping history \r\n"
					+ "9. Add  btn and add KPI mapping successfully\r\n" + "\r\n" + "User CANNOT see/do:\r\n"
					+ "1.  Checkbox and delete button");
		}
		TestLogger.info("==========TT_1006================");
	}

	@Test(priority = 3)
	public void TT_1005() throws InterruptedException {
		TestLogger.info("==========TT_1005================");
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
		UserRoleName = "Performance|KPISettings|Update" + TienIch.taoRandomSo(3);

		roles.createUserRoleNameWithRoleTypeAdmin(UserRoleName);
		TestLogger.info("+ UnCheck KPI Settings | read");
		roles.uncheck_Read_KPISettings();
		TestLogger.info("+ Check on KPI Settings | Update");
		roles.check_Update_KPISettings();
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

		administration.clickMenuPerformance();
		administration.clickSubMenuKPI();
		if (administration.isSubMenuKPISettingsDisplayed() == true) {
			setStatusTest("pass", "User CAN see/do:\r\n" + "KPI Settings menu");
		} else {
			setStatusTest("fail", "User CAN NOT see/do:\r\n" + "KPI Settings menu");
		}

		TestLogger.info("Click on KPI Settings");
		administration.clickSubMenuKPISettings();
		if (kpiConfiguration.istabKPISettingsDisplayed() == true && kpiConfiguration.istblKPIsListDisplayed() == true
				&& kpiConfiguration.isbtnSearchDisplayed() == true && kpiConfiguration.isTxtSearchDisplayed() == true
				&& kpiConfiguration.islinkOfKPIConfigurationDisplayed() == true
				&& kpiConfiguration.islinkOfKPIDisplayed() == true && kpiConfiguration.isButtonAddDisplayed() == false
				&& kpiConfiguration.isButtonKPIBoardDisplayed() == true
				&& kpiConfiguration.isBtnDeleteCategoryDisplayed() == false) {
			setStatusTest("pass",
					"User can see /do:\r\n" + "1. KPI Settings menu\r\n" + "2. List of KPIs List table \r\n"
							+ "3. Search function\r\n"
							+ "4. View and  Edit KPI category successfully by click KPI category hyperlink \r\n"
							+ "5. View and Edit successfully KPI by click KPI name hyperlink\r\n"
							+ "6. Save and cancel button in Edit category and KPI pop up\r\n" + "7. KPI Board button"
							+ "User CANNOT see/do:\r\n" + "1. Add btn 2. Checkbox and delete button");
		} else {
			setStatusTest("fail",
					"User CANNOT see /do:\\r\\n\" + \r\n" + "1. KPI Settings menu\r\n"
							+ "2. List of KPIs List table \r\n" + "3. Search function\r\n"
							+ "4. View and  Edit KPI category successfully by click KPI category hyperlink \r\n"
							+ "5. View and Edit successfully KPI by click KPI name hyperlink\r\n"
							+ "6. Save and cancel button in Edit category and KPI pop up\r\n" + "7. KPI Board button"
							+ "					\"1. Add btn 2. Checkbox and delete button");
		}

		TestLogger.info("Click on KPI Settings hyperlink");
		kpiConfiguration.clickchkCategory();
		if (editKPIList.isButtonSaveDisplayed() == true && editKPIList.isButtonCancelDisplayed() == true) {
			setStatusTest("pass", "User CAN see/do Save and Cancel buttons");
		} else {
			setStatusTest("fail", "User CAN Not see/do Save and Cancel buttons");
		}
		TestLogger.info("Click on Save button");
		editKPIList.clickButtonSave();
		if (kpiConfiguration.ismsgUpdateKPISuccessfullyDisplayed() == true) {
			setStatusTest("pass", "User CAN see/do message:\r\n" + "Updated successfully");
		} else {
			setStatusTest("fail", "User CAN Not see/do message:\r\n" + "Updated successfully");
		}
		// ==========================Rule Configuration==========
		TestLogger.info("Click on tab Rule Configuration");
		ruleConfiguration.clicktabRuleConfiguration();
		if (ruleConfiguration.isButtonKPIBoardDisplayed() == true && ruleConfiguration.isButtonAddDisplayed() == false
				&& ruleConfiguration.istabRuleConfigurationDisplayed() == true
				&& ruleConfiguration.isttxtSearchDisplayed() == true
				&& ruleConfiguration.isbtnDeleteRuleDisplayed() == false
				&& ruleConfiguration.isstoreItemDisplayed() == true) {
			setStatusTest("pass",
					"User can see /do:\r\n" + "1. KPI Settings menu\r\n" + "2. Rule List table \r\n"
							+ "3. Search codes function\r\n" + "4. View Edit Rule by click Rule code hyperlink  \r\n"
							+ "7. Sort function\r\n" + "8. Add btn and add Rule successfully\r\n" + "\r\n"
							+ "User CANNOT see/do:\r\n" + "1. Checkbox and delete button 2. Add button");
		} else {
			setStatusTest("fail",
					"User Can not see /do:\r\n" + "1. KPI Settings menu\r\n" + "2. Rule List table \r\n"
							+ "3. Search codes function\r\n" + "4. View Edit Rule by click Rule code hyperlink "
							+ "7. Sort function\r\n" + "8. Add btn and add Rule successfully\r\n" + "\r\n"
							+ "User still see/do:\r\n" + "1. Checkbox and delete button 2.Add button");
		}
		TestLogger.info("Click on Rule Configuration hyperlink");
		ruleConfiguration.clickchkRule();
		if (editRuleConfiguration.isButtonSaveDisplayed() == true
				&& editRuleConfiguration.isButtonCancelDisplayed() == true) {
			setStatusTest("pass", "User CAN see/do Save and Cancel buttons");
		} else {
			setStatusTest("fail", "User CAN Not see/do Save and Cancel buttons");
		}
		TestLogger.info("Click on Save button");
		editKPIList.clickButtonSave();
		// ============Add Rule Configuration===========
		if (ruleConfiguration.ismsgUpdateSuccessfullyDisplayed() == true) {
			setStatusTest("pass", "User CAN see/do message:\r\n" + "Updated successfully");
		} else {
			setStatusTest("fail", "User CAN Not see/do message:\r\n" + "Updated successfully");
		}
		// ==========================Rule Configuration==========
		// ==========================Assign Rule==========
		TestLogger.info("Click on tab Assign Rule");
		assignRule.clicktabAssignRule();
		if (assignRule.islblKPISettingsDisplayed() == true && assignRule.islblLogListDisplayed() == true
				&& assignRule.istxtSearchDisplayed() == true && assignRule.ischkLogListDisplayed() == true
				&& assignRule.isbtnKPIBoardDisplayed() == true && assignRule.isbtnAddDisplayed() == false
				&& assignRule.isbtnDeleteDisplayed() == false) {
			setStatusTest("pass",
					"User can see /do:\r\n" + "1. KPI Settings menu\r\n" + "2. Log List table \r\n"
							+ "3. Search  function\r\n" + "4. Sort function\r\n" + "\r\n" + "User CANNOT see/do:\r\n"
							+ "1. Checkbox and delete button 2. Add button");
		} else {
			setStatusTest("fail",
					"User can NOT see /do:\r\n" + "1. KPI Settings menu\r\n" + "2. Log List table \r\n"
							+ "3. Search  function\r\n" + "4. Sort function\r\n" + "\r\n" + "User Still see/do:\r\n"
							+ "1. Checkbox and delete button 2. Add button");
		}
		// ==========================Assign Rule==========
		// ==========================KPI Mapping==========
		TestLogger.info("Click on tab KPI Mapping");
		kpiMapping.clicktabKPIMapping();
		if (kpiMapping.istabKPIMappingDisplayed() == true && kpiMapping.islblNameDisplayed() == true
				&& kpiMapping.ischkSortDisplayed() == true && kpiMapping.isbtnViewDetailDisplayed() == true
				&& kpiMapping.isbtnAddDisplayed() == false && kpiMapping.isbtnKPIBoardDisplayed() == true
				&& kpiMapping.isbtnDeleteDisplayed() == false) {
			setStatusTest("pass", "User can see /do:\r\n" + "1. KPI Settings menu\r\n"
					+ "2. KPI mapping List table \r\n" + "3. Filter function\r\n" + "4. Sort function\r\n"
					+ "5. View Detail button\r\n" + "6. view screen successfully  by click view detail btn\r\n"
					+ "7. List \"KPI Mapping History\"\r\n"
					+ "8. View \"Group Mapping Info\" screen successfully by click record KPI mapping history \r\n"
					+ "User CANNOT see/do:\r\n" + "1.  Checkbox and delete button 2. Add button");
		} else {
			setStatusTest("fail", "User can see /do:\r\n" + "1. KPI Settings menu\r\n"
					+ "2. KPI mapping List table \r\n" + "3. Filter function\r\n" + "4. Sort function\r\n"
					+ "5. View Detail button\r\n" + "6. view screen successfully  by click view detail btn\r\n"
					+ "7. List \"KPI Mapping History\"\r\n"
					+ "8. View \"Group Mapping Info\" screen successfully by click record KPI mapping history \r\n"
					+ "User CANNOT see/do:\r\n" + "1.  Checkbox and delete button 2. Add button");
		}
		// ============Edit KPI Mapping History===========
		TestLogger.info("Click on View Detail button");
		kpiMapping.clickbtnViewDetail();
		if (kpiMappingHistory.islblKPIHistoryDisplayed() == true) {
			setStatusTest("pass", "User CAN see/do KPI Mapping History");
		} else {
			setStatusTest("fail", "User CAN Not see/do KPI Mapping History");
		}
		TestLogger.info("Click on Period hyperlink");
		kpiMappingHistory.clickchkKPIHistory();
		TestLogger.info("Click on Save button");
		editKPIMappingHistory.clickButtonSave();
		if (kpiMapping.ismsgUpdateSuccessfullyDisplayed() == true) {
			setStatusTest("pass", "User CAN see/do KPI Mapping History");
		} else {
			setStatusTest("fail", "User CAN Not see/do KPI Mapping History");
		}
		// ==========================KPI Mapping==========
		TestLogger.info("==========TT_1005================");
	}

	@Test(priority = 4)
	public void TT_1041() throws InterruptedException {
		TestLogger.info("==========TT_1041================");
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
		UserRoleName = "Performance|KPISettings|Delete" + TienIch.taoRandomSo(3);

		roles.createUserRoleNameWithRoleTypeAdmin(UserRoleName);
		TestLogger.info("+ UnCheck KPI Settings | read");
		roles.uncheck_Read_KPISettings();
		TestLogger.info("+ Check on KPI Settings | Delete");
		roles.check_Delete_KPISettings();
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

		administration.clickMenuPerformance();
		administration.clickSubMenuKPI();
		if (administration.isSubMenuKPISettingsDisplayed() == true) {
			setStatusTest("pass", "User CAN see/do:\r\n" + "KPI Settings menu");
		} else {
			setStatusTest("fail", "User CAN NOT see/do:\r\n" + "KPI Settings menu");
		}
		// ===============KPI Configuration=======================
		TestLogger.info("Click on KPI Settings");
		administration.clickSubMenuKPISettings();
		if (kpiConfiguration.istabKPISettingsDisplayed() == true && kpiConfiguration.istblKPIsListDisplayed() == true
				&& kpiConfiguration.isbtnSearchDisplayed() == true && kpiConfiguration.isTxtSearchDisplayed() == true
				&& kpiConfiguration.islinkOfKPIConfigurationDisplayed() == true
				&& kpiConfiguration.islinkOfKPIDisplayed() == true && kpiConfiguration.isButtonAddDisplayed() == false
				&& kpiConfiguration.isButtonKPIBoardDisplayed() == true
				&& kpiConfiguration.isBtnDeleteCategoryDisplayed() == true) {
			setStatusTest("pass", "User can see /do:\r\n" + "1. KPI Settings menu\r\n"
					+ "2. List of KPIs List table \r\n" + "3. Search function\r\n"
					+ "4. View and  Edit KPI category successfully by click KPI category hyperlink \r\n"
					+ "5. View and Edit successfully KPI by click KPI name hyperlink\r\n"
					+ "6. Save and cancel button in Edit category and KPI pop up\r\n" + "7. KPI Board button"
					+ "User CANNOT see/do:\r\n" + "1. Add  btn\r\n"
					+ "2. Save and cancel button in Edit category and KPI pop up\r\n" + "3. Edit Category and KPI");
		} else {
			setStatusTest("fail", "User CANNOT see /do:\\r\\n\" + \r\n" + "1. KPI Settings menu\r\n"
					+ "2. List of KPIs List table \r\n" + "3. Search function\r\n"
					+ "4. View and  Edit KPI category successfully by click KPI category hyperlink \r\n"
					+ "5. View and Edit successfully KPI by click KPI name hyperlink\r\n"
					+ "6. Save and cancel button in Edit category and KPI pop up\r\n" + "7. KPI Board button"
					+ "User Still see/do:\r\n" + "1. Add  btn\r\n"
					+ "2. Save and cancel button in Edit category and KPI pop up\r\n" + "3. Edit Category and KPI");
		}

		TestLogger.info("Click on KPI Settings hyperlink");
		kpiConfiguration.clickchkCategory();
		if (editKPIList.isButtonSaveDisplayed() == false) {
			setStatusTest("pass", "User CAN NOT see/do Save and Cancel buttons");
		} else {
			setStatusTest("fail", "User Still see/do Save and Cancel buttons");
		}
		TestLogger.info("Click on Close button");
		editKPIList.clickButtonClose();
		TestLogger.info("Delete KPI Configuration");
		kpiConfiguration.deleteCategory();
		if (kpiConfiguration.ismsgDeleteKPIDisplayed() == true) {
			setStatusTest("pass", "User CAN NOT see/do message: Deleted Successfully");
		} else {
			setStatusTest("fail", "User Still see/do message: Deleted Successfully");
		}
		// ==========================Assign Rule==========
		TestLogger.info("Click on tab Assign Rule");
		assignRule.clicktabAssignRule();
		if (assignRule.islblKPISettingsDisplayed() == true && assignRule.islblLogListDisplayed() == true
				&& assignRule.istxtSearchDisplayed() == true && assignRule.ischkLogListDisplayed() == true
				&& assignRule.isbtnKPIBoardDisplayed() == true && assignRule.isbtnAddDisplayed() == false
				&& assignRule.isbtnDeleteDisplayed() == true) {
			setStatusTest("pass",
					"User can see /do:\r\n" + "1. KPI Settings menu\r\n" + "2. Log List table \r\n"
							+ "3. Search  function\r\n" + "4. Sort function\r\n" + "5. Checkbox and delete button"
							+ "\r\n" + "User CANNOT see/do:\r\n" + " 1. Add button");
		} else {
			setStatusTest("fail",
					"User can NOT see /do:\r\n" + "1. KPI Settings menu\r\n" + "2. Log List table \r\n"
							+ "3. Search  function\r\n" + "4. Sort function\r\n" + "5. Checkbox and delete button"
							+ "\r\n" + "User Still see/do:\r\n" + "1. Add button");
		}
		// ============Delete Assign Rule===========
		TestLogger.info("Choose Month");
		assignRule.chooseMonth();
		TestLogger.info("Delete Assign Rule");
		assignRule.deleteAssignRule();
		if (assignRule.ismsgDeleteSuccessfullyDisplayed() == true) {
			setStatusTest("pass", "User CAN see/do message:\r\n" + "Delete successfully");
		} else {
			setStatusTest("fail", "User CAN Not see/do message:\r\n" + "Delete successfully");
		}
		// ==========================Assign Rule==========
		// ==========================Rule Configuration==========
		TestLogger.info("Click on tab Rule Configuration");
		ruleConfiguration.clicktabRuleConfiguration();
		if (ruleConfiguration.isButtonKPIBoardDisplayed() == true && ruleConfiguration.isButtonAddDisplayed() == false
				&& ruleConfiguration.istabRuleConfigurationDisplayed() == true
				&& ruleConfiguration.isttxtSearchDisplayed() == true
				&& ruleConfiguration.isbtnDeleteRuleDisplayed() == true
				&& ruleConfiguration.isstoreItemDisplayed() == true) {
			setStatusTest("pass",
					"User can see /do:\r\n" + "1. KPI Settings menu\r\n" + "2. Rule List table \r\n"
							+ "3. Search codes function\r\n" + "4. View Edit Rule by click Rule code hyperlink  \r\n"
							+ "1. Checkbox and delete button" + "7. Sort function\r\n"
							+ "8. Add btn and add Rule successfully\r\n" + "\r\n" + "User CANNOT see/do:\r\n"
							+ " 2. Add button");
		} else {
			setStatusTest("fail",
					"User Can not see /do:\r\n" + "1. KPI Settings menu\r\n" + "2. Rule List table \r\n"
							+ "3. Search codes function\r\n" + "4. View Edit Rule by click Rule code hyperlink "
							+ "7. Sort function\r\n" + "8. Add btn and add Rule successfully\r\n" + "\r\n"
							+ "1. Checkbox and delete button " + "User still see/do:\r\n" + "2.Add button");
		}
		TestLogger.info("Click on Rule Configuration hyperlink");
		ruleConfiguration.clickchkRule();
		if (editRuleConfiguration.isButtonSaveDisplayed() == false) {
			setStatusTest("pass", "User CAN NOT see/do Save and Cancel buttons");
		} else {
			setStatusTest("fail", "User Still see/do Save and Cancel buttons");
		}
		TestLogger.info("Click on Close button");
		editKPIList.clickButtonClose();
		// ============Delete Rule Configuration===========
		TestLogger.info("Delete Rule Configuration");
		ruleConfiguration.deleteRule();
		if (ruleConfiguration.ismsgDeleteSuccessfullyDisplayed() == true) {
			setStatusTest("pass", "User CAN see/do message:\r\n" + "Delete successfully");
		} else {
			setStatusTest("fail", "User CAN Not see/do message:\r\n" + "Delete successfully");
		}
		// ==========================Rule Configuration==========
		// ==========================KPI Mapping==========
		TestLogger.info("Click on tab KPI Mapping");
		kpiMapping.clicktabKPIMapping();
		if (kpiMapping.istabKPIMappingDisplayed() == true && kpiMapping.islblNameDisplayed() == true
				&& kpiMapping.ischkSortDisplayed() == true && kpiMapping.isbtnViewDetailDisplayed() == true
				&& kpiMapping.isbtnAddDisplayed() == false && kpiMapping.isbtnKPIBoardDisplayed() == true
				&& kpiMapping.isbtnDeleteDisplayed() == true) {
			setStatusTest("pass", "User can see /do:\r\n" + "1. KPI Settings menu\r\n"
					+ "2. KPI mapping List table \r\n" + "3. Filter function\r\n" + "4. Sort function\r\n"
					+ "5. View Detail button\r\n" + "6. view screen successfully  by click view detail btn\r\n"
					+ "7. List \"KPI Mapping History\"\r\n"
					+ "8. View \"Group Mapping Info\" screen successfully by click record KPI mapping history \r\n"
					+ "9.  Checkbox and delete button" + "User CANNOT see/do:\r\n" + " 2. Add button");
		} else {
			setStatusTest("fail", "User can see /do:\r\n" + "1. KPI Settings menu\r\n"
					+ "2. KPI mapping List table \r\n" + "3. Filter function\r\n" + "4. Sort function\r\n"
					+ "5. View Detail button\r\n" + "6. view screen successfully  by click view detail btn\r\n"
					+ "7. List \"KPI Mapping History\"\r\n"
					+ "8. View \"Group Mapping Info\" screen successfully by click record KPI mapping history \r\n"
					+ "1.  Checkbox and delete button" + "User CANNOT see/do:\r\n" + " 2. Add button");
		}
		// ============Open KPI Mapping History===========
		TestLogger.info("Search " + Form_AddKPIMapping.JobTile);
		kpiMapping.searchMappings(Form_AddKPIMapping.JobTile);
		TestLogger.info("Click on View Detail button");
		kpiMapping.clickbtnViewDetail();
		if (kpiMappingHistory.islblKPIHistoryDisplayed() == true) {
			setStatusTest("pass", "User CAN see/do KPI Mapping History");
		} else {
			setStatusTest("fail", "User CAN Not see/do KPI Mapping History");
		}
		TestLogger.info("Delete " + addKPIMapping.JobTile);
		kpiMappingHistory.deleteKPIMappingHistory();
		if (kpiMapping.ismsgDeleteSuccessfullyDisplayed() == true) {
			setStatusTest("pass", "User CAN see/do message: Delete Successfully");
		} else {
			setStatusTest("fail", "User CAN Not see/do message: Delete Successfully");
		}
		// ==========================KPI Mapping==========
		TestLogger.info("==========TT_1041================");
	}

	@Test(priority = 5)
	public void TT_975() throws InterruptedException {
		TestLogger.info("==========TT_975================");
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
		UserRoleName = "Performance|KPISettings|Read" + TienIch.taoRandomSo(3);

		roles.createUserRoleNameWithRoleTypeAdmin(UserRoleName);
		TestLogger.info("+ UnCheck all Perfomance Permission - KPI Settings| read");
		roles.uncheck_Read_KPISettings();
		TestLogger.info("+ Check on KPI Settings | Read");
		roles.check_Read_KPISettings();
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

		administration.clickMenuPerformance();
		administration.clickSubMenuKPI();
		if (administration.isSubMenuKPISettingsDisplayed() == true) {
			setStatusTest("pass", "User CAN see/do:\r\n" + "KPI Settings menu");
		} else {
			setStatusTest("fail", "User CAN NOT see/do:\r\n" + "KPI Settings menu");
		}
		// ==================KPI Configuration===============
		TestLogger.info("Click on KPI Settings");
		administration.clickSubMenuKPISettings();
		if (kpiConfiguration.istabKPISettingsDisplayed() == true && kpiConfiguration.istblKPIsListDisplayed() == true
				&& kpiConfiguration.isbtnSearchDisplayed() == true && kpiConfiguration.isTxtSearchDisplayed() == true
				&& kpiConfiguration.islinkOfKPIConfigurationDisplayed() == true
				&& kpiConfiguration.islinkOfKPIDisplayed() == true && kpiConfiguration.isButtonAddDisplayed() == false
				&& kpiConfiguration.isButtonKPIBoardDisplayed() == true
				&& kpiConfiguration.isBtnDeleteCategoryDisplayed() == false) {
			setStatusTest("pass", "User can see /do:\r\n" + "1. KPI Settings menu\r\n"
					+ "2. List of KPIs List table \r\n" + "3. Search function\r\n"
					+ "4. View Edit KPI category by click KPI category hyperlink but it is disable all field \r\n"
					+ "5. View Edit KPI by click KPI name hyperlink but it is disable all fields\r\n"
					+ "7. KPI Board button\r\n" + "8. Add  btn and add successfully KPI category and KPI \r\n" + "\r\n"
					+ "User CANNOT see/do:\r\n" + "2. Checkbox and delete button");
		} else {
			setStatusTest("fail", "User CANNOT see /do:\\r\\n\" + \r\n"
					+ "					\"1. KPI Settings menu\\r\\n\" + \r\n"
					+ "					\"2. List of KPIs List table \\r\\n\" + \r\n"
					+ "					\"3. Search function\\r\\n\" + \r\n"
					+ "					\"4. View Edit KPI category by click KPI category hyperlink but it is disable all field \\r\\n\" + \r\n"
					+ "					\"5. View Edit KPI by click KPI name hyperlink but it is disable all fields\\r\\n\" + \r\n"
					+ "					\"7. KPI Board button\\r\\n\" + \r\n"
					+ "					\"8. Add  btn and add successfully KPI category and KPI \\r\\n\" + \r\n"
					+ "					\"\\r\\n\" + \r\n" + "					\"User Still see/do:\\r\\n\" + \r\n"
					+ "					\"2. Checkbox and delete button");
		}

		TestLogger.info("Click on KPI Settings hyperlink");
		kpiConfiguration.clickchkCategory();
		if (editKPIList.isButtonCloseDisplayed() == true) {
			setStatusTest("pass", "User CAN see/do Close button");
		} else {
			setStatusTest("fail", "User CAN Not see/do Close button");
		}
		TestLogger.info("Click on Close button");
		editKPIList.clickButtonClose();
		// ==========================Rule Configuration==========
		TestLogger.info("Click on tab Rule Configuration");
		ruleConfiguration.clicktabRuleConfiguration();
		if (ruleConfiguration.isButtonKPIBoardDisplayed() == true && ruleConfiguration.isButtonAddDisplayed() == false
				&& ruleConfiguration.istabRuleConfigurationDisplayed() == true
				&& ruleConfiguration.isttxtSearchDisplayed() == true
				&& ruleConfiguration.isbtnDeleteRuleDisplayed() == false
				&& ruleConfiguration.isstoreItemDisplayed() == true) {
			setStatusTest("pass",
					"User can see /do:\r\n" + "1. KPI Settings menu\r\n" + "2. Rule List table \r\n"
							+ "3. Search codes function\r\n"
							+ "4. View Edit Rule by click Rule code hyperlink but it is disable all fields \r\n"
							+ "7. Sort function\r\n" + "8. Add btn and add Rule successfully\r\n" + "\r\n"
							+ "User CANNOT see/do:\r\n" + "1. Checkbox and delete button");
		} else {
			setStatusTest("fail",
					"User Can not see /do:\r\n" + "1. KPI Settings menu\r\n" + "2. Rule List table \r\n"
							+ "3. Search codes function\r\n"
							+ "4. View Edit Rule by click Rule code hyperlink but it is disable all fields \r\n"
							+ "7. Sort function\r\n" + "8. Add btn and add Rule successfully\r\n" + "\r\n"
							+ "User still see/do:\r\n" + "1. Checkbox and delete button");
		}
		TestLogger.info("Click on Rule Configuration hyperlink");
		ruleConfiguration.clickchkRule();
		if (editRuleConfiguration.isButtonSaveDisplayed() == false) {
			setStatusTest("pass", "User CAN see/do Close button");
		} else {
			setStatusTest("fail", "User CAN Not see/do Close button");
		}
		TestLogger.info("Click on Close button");
		editKPIList.clickButtonClose();
		// ==========================Rule Configuration==========
		// ==========================Assign Rule==========
		TestLogger.info("Click on tab Assign Rule");
		assignRule.clicktabAssignRule();
		if (assignRule.islblKPISettingsDisplayed() == true && assignRule.islblLogListDisplayed() == true
				&& assignRule.istxtSearchDisplayed() == true && assignRule.ischkLogListDisplayed() == true
				&& assignRule.isbtnKPIBoardDisplayed() == true && assignRule.isbtnAddDisplayed() == false
				&& assignRule.isbtnDeleteDisplayed() == false) {
			setStatusTest("pass",
					"User can see /do:\r\n" + "1. KPI Settings menu\r\n" + "2. Log List table \r\n"
							+ "3. Search  function\r\n" + "4. Sort function\r\n"
							+ "5. Add button and add Assign Rule successfully\r\n" + "\r\n" + "User CANNOT see/do:\r\n"
							+ "1. Checkbox and delete button");
		} else {
			setStatusTest("fail",
					"User can NOT see /do:\r\n" + "1. KPI Settings menu\r\n" + "2. Log List table \r\n"
							+ "3. Search  function\r\n" + "4. Sort function\r\n"
							+ "5. Add button and add Assign Rule successfully\r\n" + "\r\n" + "User Still see/do:\r\n"
							+ "1. Checkbox and delete button");
		}
		// *****************************************************************************
		// ==========================Assign Rule==========
		// ==========================KPI Mapping==========
		TestLogger.info("Click on tab KPI Mapping");
		kpiMapping.clicktabKPIMapping();
		if (kpiMapping.istabKPIMappingDisplayed() == true && kpiMapping.islblNameDisplayed() == true
				&& kpiMapping.ischkSortDisplayed() == true && kpiMapping.isbtnViewDetailDisplayed() == true
				&& kpiMapping.isbtnAddDisplayed() == false && kpiMapping.isbtnKPIBoardDisplayed() == true
				&& kpiMapping.isbtnDeleteDisplayed() == false) {
			setStatusTest("pass", "User can see /do:\r\n" + "1. KPI Settings menu\r\n"
					+ "2. KPI mapping List table \r\n" + "3. Filter function\r\n" + "4. Sort function\r\n"
					+ "5. View Detail button\r\n" + "//6. view screen successfully  by click view detail btn\r\n"
					+ "//7. List \"KPI Mapping History\"\r\n"
					+ "//8. View \"Group Mapping Info\" screen successfully by click record KPI mapping history \r\n"
					+ "9. Add  btn //and add KPI mapping successfully\r\n" + "\r\n" + "User CANNOT see/do:\r\n"
					+ "1.  Checkbox and delete button");
		} else {
			setStatusTest("fail", "User can see /do:\r\n" + "1. KPI Settings menu\r\n"
					+ "2. KPI mapping List table \r\n" + "3. Filter function\r\n" + "4. Sort function\r\n"
					+ "5. View Detail button\r\n" + "6. view screen successfully  by click view detail btn\r\n"
					+ "7. List \"KPI Mapping History\"\r\n"
					+ "8. View \"Group Mapping Info\" screen successfully by click record KPI mapping history \r\n"
					+ "9. Add  btn and add KPI mapping successfully\r\n" + "\r\n" + "User CANNOT see/do:\r\n"
					+ "1.  Checkbox and delete button");
		}
		// ==========================KPI Mapping==========
		TestLogger.info("==========TT_975================");
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
