package talentwize;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Ulties.PropertyManager;
import Ulties.TestLogger;
import Ulties.TestManager;
import Ulties.TienIch;
import controller.WebActions;
import controller.WebDriversManager;
import talentwize.pages.Administration;
import talentwize.pages.AssignRule;
import talentwize.pages.Dashboard;
import talentwize.pages.EmployeeList;
import talentwize.pages.Form_AddAssignRule;
import talentwize.pages.Form_AddKPIConfiguration;
import talentwize.pages.Form_AddKPIMapping;
import talentwize.pages.Form_AddKPIMappingForProject;
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

public class Test_FunctionalAccess_Performance_KPISettingsByProject extends TestManager {
	HomePage homePage;
	WebDriver driver;
	PropertyManager propertyManager;
	WebActions webActions;
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
	Form_AddKPIMappingForProject addKPIMappingForProject;
	Form_EditKPIMappingHistory editKPIMappingHistory;

	@BeforeTest
	public void KhoiTaoCacNguonTaiNguyen() {

		propertyManager = new PropertyManager();
		propertyManager.loadData();

		driver = WebDriversManager.moTrinhDuyet("chrome");
		homePage = new HomePage(driver);
		webActions = new WebActions(driver);
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
		addKPIMappingForProject = new Form_AddKPIMappingForProject(driver);
		editKPIMappingHistory = new Form_EditKPIMappingHistory(driver);
		homePage.moLinkWeb(propertyManager.getURL_TalentWize());

	}

	@Test(priority = 1)
	public void TT_3645() throws InterruptedException {
		TestLogger.info("==========TT_3645================");
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
		UserRoleName = "KPISettingsByProject|NoPermission" + TienIch.taoRandomSo(3);

		roles.createUserRoleNameWithRoleTypeAdmin(UserRoleName);
		
		TestLogger.info("4. Click on button Save");
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

		TestLogger.info("7. Open Performance menu >> KPI sub menu");
		
		administration.clickMenuPerformance();
				
		TestLogger.info("8. Check Permission");
		
		if (administration.isSubMenuKPISettingsByProjectDisplayed() == false) {
			setStatusTest("pass", "User CANNOT see/do:\r\n" + "KPI Settings By Project menu");
		} else {
			setStatusTest("fail", "User STILL see/do:\r\n" + "KPI Settings By Project menu");
		}
		TestLogger.info("==========TT_3645================");
	}

	@Test(priority = 2)
	public void TT_3648() throws InterruptedException {
		TestLogger.info("==========TT_3648================");
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
		UserRoleName = "KPISettingsByProject|Create" + TienIch.taoRandomSo(3);

		roles.createUserRoleNameWithRoleTypeAdmin(UserRoleName);
		
		TestLogger.info("4. Check on Perfomance Permission - KPI Settings By Project | Create");
		roles.checkbox_Create_KPI_SettingsByProject();
		
		TestLogger.info("5. Click Save button");
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

		TestLogger.info("8. Go to Performance >> Go to KPI By Project");
		
		administration.clickMenuPerformance();
		administration.clickSubMenuKPIByProject();
		
		if (administration.isSubMenuKPISettingsByProjectDisplayed() == true) {
			setStatusTest("pass", "User CAN see/do:\r\n" + "KPI Settings By Project menu");
		} else {
			setStatusTest("fail", "User CAN NOT see/do:\r\n" + "KPI Settings By Project menu");
		}

		//=======================KPI Configuration================
		TestLogger.info("9. Go to KPI Settings >> KPI Configuration");
		
		administration.clickSubMenuKPISettingsByProject();
		
		TestLogger.info("Expect : User CAN see /do:\r\n"
					+	"1. KPI Configuration tab \r\n" 
					+ 	"2. Button Add \r\n" 
					+ 	"3. Link Edit Category \r\n" 
					+	"4. Link Edit KPI");
	
		if (kpiConfiguration.istblKPIsListDisplayed()== true) 
		{
			setStatusTest("pass", "User CAN see/do: " + "KPI Configuration tab");
		} else {
			setStatusTest("fail", "User CANNOT see/do: " + "KPI Configuration tab");
		}
		
		if (kpiConfiguration.isButtonAddDisplayed()== true) 
		{
			setStatusTest("pass", "User CAN see/do: " + "Button Add");
		} else {
			setStatusTest("fail", "User CANNOT see/do: " + "Button Add");
		}
		
		if (kpiConfiguration.islinkOfKPIConfigurationDisplayed()== true) 
		{
			setStatusTest("pass", "User CAN see/do: " + "Link Edit Category");
		} else {
			setStatusTest("fail", "User CANNOT see/do: " + "Link Edit Category");
		}
		
		if (kpiConfiguration.islinkOfKPIDisplayed()== true) 
		{
			setStatusTest("pass", "User CAN see/do: " + "Link Edit KPI\r\n");
		} else {
			setStatusTest("fail", "User CANNOT see/do: " + "Link Edit KPI");
		}
		
		TestLogger.info("Expect : User CANNOT see /do:\r\n"
					+ "1. Delete function\r\n"
					+ "2. Button Save in Edit Category\r\n"
					+ "3. Button Save in Edit KPI");
		
		if (kpiConfiguration.isBtnDeleteCategoryDisplayed()== false) 
		{
			setStatusTest("pass", "User CANNOT see/do: " + "Delete function");
		} else {
			setStatusTest("fail", "User CAN see/do: " + "Delete function");
		}
		
		kpiConfiguration.clickLinkOfCategory();
		if (editKPI.isButtonSaveDisplayed()== false) 
		{
			setStatusTest("pass", "User CANNOT see/do: " + "Button Save in Edit Category");
		} else {
			setStatusTest("fail", "User CAN see/do: " + "Button Save in Edit Category");
		}
		editKPI.clickButtonClose();
		
		kpiConfiguration.clickLinkOfKPI();
		if (editKPI.isButtonSaveDisplayed()== false) 
		{
			setStatusTest("pass", "User CANNOT see/do: " + "Button Save in Edit KPI\r\n");
		} else {
			setStatusTest("fail", "User CAN see/do: " + "Button Save in Edit KPI");
		}
		editKPI.clickButtonClose();
		
		TestLogger.info("10. Add KPI Configuration");
		
		kpiConfiguration.clickbtnAdd();
		addKPIConfiguration.addKPIConfiguration("009" + TienIch.taoRandomSo(3), "Test", "3", "1");
		
		if (kpiConfiguration.ismsgAddSuccessfullyDisplayed() == true) {
			setStatusTest("pass", "User CAN see/do message: " + "Added successfully");
		} else {
			setStatusTest("fail", "User CAN Not see/do message: " + "Added successfully");
		}
		
		// ==========================Rule Configuration==========
		TestLogger.info("11. Go to Rule Configuration");
		
		ruleConfiguration.clicktabRuleConfiguration();
		
		TestLogger.info("Expect : User CAN see /do:\r\n"
					+	"1. Rule Configuration tab \r\n" 
					+ 	"2. Button Add \r\n"
					+ 	"3. Link Edit Rule");
		
		if (ruleConfiguration.istabRuleConfigurationDisplayed()== true) 
		{
			setStatusTest("pass", "User CAN see/do: " + "Rule Configuration tab");
		} else {
			setStatusTest("fail", "User CANNOT see/do: " + "Rule Configuration tab");
		}
		
		if (ruleConfiguration.isButtonAddDisplayed()== true) 
		{
			setStatusTest("pass", "User CAN see/do: " + "Button Add");
		} else {
			setStatusTest("fail", "User CANNOT see/do: " + "Button Add");
		}
		
		if (ruleConfiguration.islinkOfRuleisplayed()== true) 
		{
			setStatusTest("pass", "User CAN see/do: " + "Link Edit Rule\r\n");
		} else {
			setStatusTest("fail", "User CANNOT see/do: " + "Link Edit Rule");
		}
		
		TestLogger.info("Expect : User CANNOT see /do:\r\n"
				+	"1. Delete function \r\n" 
				+ 	"2. Button Save in Edit Rule");
		
		if (ruleConfiguration.isbtnDeleteRuleDisplayed()== false) 
		{
			setStatusTest("pass", "User CANNOT see/do: " + "Delete function");
		} else {
			setStatusTest("fail", "User CAN see/do: " + "Delete function");
		}
		
		ruleConfiguration.clickLinkOfRule();
		if (editRuleConfiguration.isButtonSaveDisplayed()== false) 
		{
			setStatusTest("pass", "User CANNOT see/do: " + "Button Save in Edit Rule\r\n");
		} else {
			setStatusTest("fail", "User CAN see/do: " + "Button Save in Edit Rule");
		}
		editKPIList.clickButtonClose();
			
		// ============Add Rule Configuration===========
		TestLogger.info("12. Add Rule Configuration");
		
		ruleConfiguration.clickbtnAdd();
		addRuleConfiguration.addRuleConfiguration("999" + TienIch.taoRandomSo(3), "3", "Learn English");
				
		if (ruleConfiguration.ismsgAddSuccessfullyDisplayed() == true) {
			setStatusTest("pass", "User CAN see/do message: " + "Added successfully\r\n");
		} else {
			setStatusTest("fail", "User CAN Not see/do message: " + "Added successfully");
		}

		// ==========================Assign Rule==========
		TestLogger.info("13. Go to Assign Rule");
		
		assignRule.clicktabAssignRule();
		
		TestLogger.info("Expect : User CAN see /do:\r\n"
					+	"1. Assign Rule tab \r\n" 
					+ 	"2. Button Add");
		
		if (assignRule.istabAssignRuleDisplayed()== true) 
		{
			setStatusTest("pass", "User CAN see/do: " + "Rule Configuration tab");
		} else {
			setStatusTest("fail", "User CANNOT see/do: " + "Rule Configuration tab");
		}
		
		if (assignRule.isbtnAddDisplayed()== true) 
		{
			setStatusTest("pass", "User CAN see/do: " + "Button Add\r\n");
		} else {
			setStatusTest("fail", "User CANNOT see/do: " + "Button Add");
		}
		
		TestLogger.info("Expect : User CANNOT see /do:\r\n"
				+	"1. Delete function");
		
		if (assignRule.isbtnDeleteDisplayed()== false) 
		{
			setStatusTest("pass", "User CANNOT see/do: " + "Delete function\r\n");
		} else {
			setStatusTest("fail", "User CAN see/do: " + "Delete function");
		}
		
		// ============Add Assign Rule===========
		TestLogger.info("14. Assign Rule");
		
		assignRule.clickbtnAdd();
		addAssignRule.addAssignRuleToday();
		
		if (assignRule.ismsgAddLogSuccessfullyDisplayed() == true) {
			setStatusTest("pass", "User CAN see/do message: " + "Added successfully\r\n");
		} else {
			setStatusTest("fail", "User CAN Not see/do message: " + "Added successfully");
		}

		// ==========================Assign Rule==========

		// ==========================KPI Mapping==========
		TestLogger.info("15. Go to KPI Mapping");
		
		kpiMapping.clicktabKPIMapping();
		
		TestLogger.info("16. Add KPI Mapping");
		
		kpiMapping.clickbtnAdd();
		addAssignRule.clickBtnCancel();
		kpiMapping.clickbtnAdd();
		addKPIMappingForProject.addAssignRuleForProject();
		
		if (kpiMapping.ismsgAddKPIMappingSuccessfullyDisplayed() == true) {
			setStatusTest("pass", "User CAN see/do message: " + "Added successfully\r\n");
		} else {
			setStatusTest("fail", "User CAN Not see/do message: " + "Added successfully");
		}
			
		TestLogger.info("17. Check Permission");
		
		TestLogger.info("Expect : User CAN see /do:\r\n"
				+	"1. KPI Mapping tab\r\n"
				+	"2. Add  btn in KPI Mapping Board\r\n"
				+	"3. Add  btn in KPI Mapping Detail\r\n"
				+	"4. Button View Detail\r\n"
				+	"5. Button Back in KPI Mapping Detail\r\n"
				+	"6. Link Edit KPI Mapping");
	
		if (kpiMapping.istabKPIMappingDisplayed()== true) 
		{
		setStatusTest("pass", "User CAN see/do: " + "KPI Mapping tab");
		} else {
		setStatusTest("fail", "User CANNOT see/do: " + "KPI Mapping tab");
		}
	
		if (kpiMapping.isbtnAddDisplayed()== true) 
		{
		setStatusTest("pass", "User CAN see/do: " + "Add  btn in KPI Mapping Board");
		} else {
		setStatusTest("fail", "User CANNOT see/do: " + "Add  btn in KPI Mapping Board");
		}
		
		if (kpiMapping.isbtnViewDetailDisplayed()== true) 
		{
		setStatusTest("pass", "User CAN see/do: " + "Button View Detail");
		} else {
		setStatusTest("fail", "User CANNOT see/do: " + "Button View Detail");
		}
		
		kpiMapping.clickbtnViewDetail();
		if (kpiMappingHistory.isbtnAddDisplayed()== true) 
		{
		setStatusTest("pass", "User CAN see/do " + "Add  btn in KPI Mapping Detail");
		} else {
		setStatusTest("fail", "User CANNOT see/do: " + "Add  btn in KPI Mapping Detail");
		}
	
		if (kpiMappingHistory.isChkKPIHistoryDisplayed()== true) 
		{
		setStatusTest("pass", "User CAN see/do: " + "Link Edit KPI Mapping");
		} else {
		setStatusTest("fail", "User CANNOT see/do: " + "Link Edit KPI Mapping");
		}
		
		if (kpiMappingHistory.isbtnBackDisplayed()== true) 
		{
		setStatusTest("pass", "User CAN see/do: " + "Button Back in KPI Mapping Detail\r\n");
		} else {
		setStatusTest("fail", "User CANNOT see/do: " + "Button Back in KPI Mapping Detail");
		}
	
		TestLogger.info("Expect : User CANNOT see /do:\r\n"
			+	"1. Delete function\r\n"
			+ 	"2. Button Save in Update KPI Mapping");
	
		kpiMappingHistory.clickchkKPIHistory();
		if (editKPIMappingHistory.isButtonSaveDisplayed()== false) 
		{
		setStatusTest("pass", "User CANNOT see/do: " + "Button Save in Update KPI Mapping");
		} else {
		setStatusTest("fail", "User CAN see/do: " + "Button Save in Update KPI Mapping");
		}
		editKPI.clickButtonClose();
		
		kpiMappingHistory.clickbtnBack();
		if (kpiMapping.isbtnDeleteDisplayed()== false) 
		{
		setStatusTest("pass", "User CANNOT see/do: " + "Delete function");
		} else {
		setStatusTest("fail", "User CAN see/do: " + "Delete function");
		}
	
		TestLogger.info("==========TT_3648================");
	}

	@Test(priority = 3)
	public void TT_3649() throws InterruptedException {
		TestLogger.info("==========TT_3649================");
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
		UserRoleName = "KPISettingsByProject|Read" + TienIch.taoRandomSo(3);

		roles.createUserRoleNameWithRoleTypeAdmin(UserRoleName);
		
		TestLogger.info("4. Check on Perfomance Permission - KPI Settings By Project | Read");
		roles.checkbox_Read_KPI_SettingsByProject();
		
		TestLogger.info("5. Click Save button");
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

		TestLogger.info("8. Go to Performance >> Go to KPI By Project");
		
		administration.clickMenuPerformance();
		administration.clickSubMenuKPIByProject();
		
		if (administration.isSubMenuKPISettingsByProjectDisplayed() == true) {
			setStatusTest("pass", "User CAN see/do: " + "KPI Settings menu");
		} else {
			setStatusTest("fail", "User CANNOT see/do: " + "KPI Settings menu");
		}
		// ==================KPI Configuration===============
		
		TestLogger.info("9. Go to KPI Settings >> KPI Configuration");
		
		administration.clickSubMenuKPISettingsByProject();
	
		TestLogger.info("Expect : User CAN see /do:\r\n"
					+	"1. KPI Configuration tab \r\n" 
					+ 	"2. Link Edit Category\r\n" 
					+	"3. Link Edit KPI");
	
		if (kpiConfiguration.istblKPIsListDisplayed()== true) 
		{
			setStatusTest("pass", "User CAN see/do: " + "KPI Configuration tab");
		} else {
			setStatusTest("fail", "User CANNOT see/do: " + "KPI Configuration tab");
		}
				
		if (kpiConfiguration.islinkOfKPIConfigurationDisplayed()== true) 
		{
			setStatusTest("pass", "User CAN see/do: " + "Link Edit Category");
		} else {
			setStatusTest("fail", "User CANNOT see/do: " + "Link Edit Category");
		}
		
		if (kpiConfiguration.islinkOfKPIDisplayed()== true) 
		{
			setStatusTest("pass", "User CAN see/do: " + "Link Edit KPI\r\n");
		} else {
			setStatusTest("fail", "User CANNOT see/do: " + "Link Edit KPI");
		}
		
		TestLogger.info("Expect : User CANNOT see /do:\r\n"
					+ "1. Delete function\r\n"
					+ "2. Button Save in Edit Category\r\n"
					+ "3. Button Save in Edit KPI\r\n"
					+ "4. Button Add ");
		
		if (kpiConfiguration.isButtonAddDisplayed()== false) 
		{
			setStatusTest("pass", "User CANNOT see/do: " + "Button Add");
		} else {
			setStatusTest("fail", "User CAN see/do: " + "Button Add");
		}
		
		if (kpiConfiguration.isBtnDeleteCategoryDisplayed()== false) 
		{
			setStatusTest("pass", "User CANNOT see/do: " + "Delete function");
		} else {
			setStatusTest("fail", "User CAN see/do: " + "Delete function");
		}
		
		kpiConfiguration.clickLinkOfCategory();
		if (editKPI.isButtonSaveDisplayed()== false) 
		{
			setStatusTest("pass", "User CANNOT see/do: " + "Button Save in Edit Category");
		} else {
			setStatusTest("fail", "User CAN see/do: " + "Button Save in Edit Category");
		}
		editKPI.clickButtonClose();
		
		kpiConfiguration.clickLinkOfKPI();
		if (editKPI.isButtonSaveDisplayed()== false) 
		{
			setStatusTest("pass", "User CANNOT see/do: " + "Button Save in Edit KPI\r\n");
		} else {
			setStatusTest("fail", "User CAN see/do: " + "Button Save in Edit KPI");
		}
		editKPI.clickButtonClose();
		
		// ==========================Rule Configuration==========
		
		TestLogger.info("10. Go to Rule Configuration");
		ruleConfiguration.clicktabRuleConfiguration();
		
		TestLogger.info("Expect : User CAN see /do:\r\n"
				+	"1. Rule Configuration tab \r\n" 
				+ 	"2. Link Edit Rule");
	
		if (ruleConfiguration.istabRuleConfigurationDisplayed()== true) 
		{
		setStatusTest("pass", "User CAN see/do: " + "Rule Configuration tab");
		} else {
		setStatusTest("fail", "User CANNOT see/do: " + "Rule Configuration tab");
		}
	
		if (ruleConfiguration.islinkOfRuleisplayed()== true) 
		{
		setStatusTest("pass", "User CAN see/do: " + "Link Edit Rule\r\n");
		} else {
		setStatusTest("fail", "User CANNOT see/do: " + "Link Edit Rule");
		}
	
		TestLogger.info("Expect : User CANNOT see /do:\r\n"
			+	"1. Delete function \r\n" 
			+ 	"2. Button Add \r\n"
			+ 	"3. Button Save in Edit Rule");
	
		if (ruleConfiguration.isButtonAddDisplayed()== false) 
		{
		setStatusTest("pass", "User CANNOT see/do: " + "Button Add");
		} else {
		setStatusTest("fail", "User CAN see/do: " + "Button Add");
		}
		
		if (ruleConfiguration.isbtnDeleteRuleDisplayed()== false) 
		{
		setStatusTest("pass", "User CANNOT see/do: " + "Delete function");
		} else {
		setStatusTest("fail", "User CAN see/do: " + "Delete function");
		}
	
		ruleConfiguration.clickLinkOfRule();
		if (editRuleConfiguration.isButtonSaveDisplayed()== false) 
		{
		setStatusTest("pass", "User CANNOT see/do: " + "Button Save in Edit Rule\r\n");
		} else {
		setStatusTest("fail", "User CAN see/do: " + "Button Save in Edit Rule");
		}
		editKPIList.clickButtonClose();
		// ==========================Rule Configuration==========
		
		// ==========================Assign Rule==========	
		TestLogger.info("11. Go to Assign Rule");
		
		assignRule.clicktabAssignRule();
		
		TestLogger.info("Expect : User CAN see /do:\r\n"
				+	"1. Assign Rule tab");
	
		if (assignRule.istabAssignRuleDisplayed()== true) 
		{
		setStatusTest("pass", "User CAN see/do: " + "Rule Configuration tab\r\n");
		} else {
		setStatusTest("fail", "User CANNOT see/do: " + "Rule Configuration tab");
		}
	
			
		TestLogger.info("Expect : User CANNOT see /do:\r\n"
				+	"1. Delete function \r\n" 
				+ 	"2. Button Add");
	
		if (assignRule.isbtnDeleteDisplayed()== false) 
		{
		setStatusTest("pass", "User CANNOT see/do: " + "Delete function");
		} else {
			setStatusTest("fail", "User CAN see/do: " + "Delete function");
		}
		
		if (assignRule.isbtnAddDisplayed()== false) 
		{
		setStatusTest("pass", "User CANNOT see/do: " + "Button Add\r\n");
		} else {
		setStatusTest("fail", "User CAN see/do: " + "Button Add");
		}
		
		// ==========================Assign Rule==========
		
		// ==========================KPI Mapping==========	
		TestLogger.info("12. Go to tab KPI Mapping");
		
		kpiMapping.clicktabKPIMapping();
		
		TestLogger.info("Expect : User CAN see /do:\r\n"
				+	"1. KPI Mapping tab\r\n"
				+	"2. Button View Detail\r\n"
				+	"3. Button Back in KPI Mapping Detail\r\n"
				+	"4. Link Edit KPI Mapping");
	
		if (kpiMapping.istabKPIMappingDisplayed()== true) 
		{
		setStatusTest("pass", "User CAN see/do: " + "KPI Mapping tab");
		} else {
		setStatusTest("fail", "User CANNOT see/do: " + "KPI Mapping tab");
		}
			
		if (kpiMapping.isbtnViewDetailDisplayed()== true) 
		{
		setStatusTest("pass", "User CAN see/do: " + "Button View Detail");
		} else {
		setStatusTest("fail", "User CANNOT see/do: " + "Button View Detail");
		}
		
		if (kpiMappingHistory.isbtnBackDisplayed()== true) 
		{
		setStatusTest("pass", "User CAN see/do: " + "Button Back in KPI Mapping Detail");
		} else {
		setStatusTest("fail", "User CANNOT see/do: " + "Button Back in KPI Mapping Detail");
		}
		
		kpiMapping.clickbtnViewDetail();
		if (kpiMappingHistory.isChkKPIHistoryDisplayed()== true) 
		{
		setStatusTest("pass", "User CAN see/do: " + "Link Edit KPI Mapping\r\n");
		} else {
		setStatusTest("fail", "User CANNOT see/do: " + "Link Edit KPI Mapping");
		}
		
		TestLogger.info("Expect : User CANNOT see /do:\r\n"
				+	"1. Delete function\r\n"
				+ 	"2. Add  btn in KPI Mapping Board\r\n"
				+	"3. Add  btn in KPI Mapping Detail\r\n"
				+	"4. Button Save in Update KPI Mapping");
	
		if (kpiMappingHistory.isbtnAddDisplayed()== false) 
		{
		setStatusTest("pass", "User CANNOT see/do " + "Add  btn in KPI Mapping Detail");
		} else {
		setStatusTest("fail", "User CAN see/do: " + "Add  btn in KPI Mapping Detail");
		}
		
		kpiMappingHistory.clickchkKPIHistory();
		if (editKPIMappingHistory.isButtonSaveDisplayed()== false) 
		{
		setStatusTest("pass", "User CANNOT see/do: " + "Button Save in Update KPI Mapping");
		} else {
		setStatusTest("fail", "User CAN see/do: " + "Button Save in Update KPI Mapping");
		}
		editKPI.clickButtonClose();
		
		kpiMappingHistory.clickbtnBack();
		if (kpiMapping.isbtnAddDisplayed()== false) 
		{
		setStatusTest("pass", "User CANNOT see/do: " + "Add  btn in KPI Mapping Board");
		} else {
		setStatusTest("fail", "User CAN see/do: " + "Add  btn in KPI Mapping Board");
		}
		
		if (kpiMapping.isbtnDeleteDisplayed()== false) 
		{
		setStatusTest("pass", "User CANNOT see/do: " + "Delete function");
		} else {
		setStatusTest("fail", "User CAN see/do: " + "Delete function");
		}
	
		// ==========================KPI Mapping==========
		TestLogger.info("==========TT_3649================");
	}
	
	@Test(priority = 4)
	public void TT_3650() throws InterruptedException {
		TestLogger.info("==========TT_3650================");
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
		UserRoleName = "KPISettingsByProject|Update" + TienIch.taoRandomSo(3);

		roles.createUserRoleNameWithRoleTypeAdmin(UserRoleName);
		
		TestLogger.info("4. Check on Perfomance Permission - KPI Settings By Project | Update");
		roles.checkbox_Update_KPI_SettingsByProject();;
		
		TestLogger.info("5. Click Save button");
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

		TestLogger.info("8. Go to Performance >> Go to KPI By Project");
		
		administration.clickMenuPerformance();
		administration.clickSubMenuKPIByProject();
		
		if (administration.isSubMenuKPISettingsByProjectDisplayed() == true) {
			setStatusTest("pass", "User CAN see/do:\r\n" + "KPI Settings By Project menu");
		} else {
			setStatusTest("fail", "User CAN NOT see/do:\r\n" + "KPI Settings By Project menu");
		}

		//=======================KPI Configuration================
		TestLogger.info("9. Go to KPI Settings >> KPI Configuration");
		
		administration.clickSubMenuKPISettingsByProject();
		
		TestLogger.info("Expect : User CAN see /do:\r\n"
					+	"1. KPI Configuration tab \r\n" 
					+ 	"2. Button Save in Edit Category\r\n"
					+ 	"3. Button Save in Edit KPI \r\n" 
					+ 	"4. Link Edit Category \r\n" 
					+	"5. Link Edit KPI");
	
		if (kpiConfiguration.istblKPIsListDisplayed()== true) 
		{
			setStatusTest("pass", "User CAN see/do: " + "KPI Configuration tab");
		} else {
			setStatusTest("fail", "User CANNOT see/do: " + "KPI Configuration tab");
		}
		
		
		if (kpiConfiguration.islinkOfKPIConfigurationDisplayed()== true) 
		{
			setStatusTest("pass", "User CAN see/do: " + "Link Edit Category");
		} else {
			setStatusTest("fail", "User CANNOT see/do: " + "Link Edit Category");
		}
		
		if (kpiConfiguration.islinkOfKPIDisplayed()== true) 
		{
			setStatusTest("pass", "User CAN see/do: " + "Link Edit KPI");
		} else {
			setStatusTest("fail", "User CANNOT see/do: " + "Link Edit KPI");
		}
		
		kpiConfiguration.clickLinkOfCategory();
		if (editKPI.isButtonSaveDisplayed()== true) 
		{
			setStatusTest("pass", "User CAN see/do: " + "Button Save in Edit Category");
		} else {
			setStatusTest("fail", "User CANNOT see/do: " + "Button Save in Edit Category");
		}
		editKPI.clickButtonCancel();
		
		kpiConfiguration.clickLinkOfKPI();
		if (editKPI.isButtonSaveDisplayed()== true) 
		{
			setStatusTest("pass", "User CAN see/do: " + "Button Save in Edit KPI\r\n");
		} else {
			setStatusTest("fail", "User CANNOT see/do: " + "Button Save in Edit KPI");
		}
		editKPI.clickButtonCancel();
		
		TestLogger.info("Expect : User CANNOT see /do:\r\n"
					+ "1. Delete function\r\n"
					+ "2. Button Add");
		
		if (kpiConfiguration.isButtonAddDisplayed()== false) 
		{
			setStatusTest("pass", "User CANNOT see/do: " + "Button Add");
		} else {
			setStatusTest("fail", "User CAN see/do: " + "Button Add");
		}
		
		if (kpiConfiguration.isBtnDeleteCategoryDisplayed()== false) 
		{
			setStatusTest("pass", "User CANNOT see/do: " + "Delete function\r\n");
		} else {
			setStatusTest("fail", "User CAN see/do: " + "Delete function");
		}

		TestLogger.info("10. Update KPI Configuration");
		
		kpiConfiguration.clickchkCategory();
		editKPIList.clickButtonSave();
		
		if (kpiConfiguration.ismsgUpdateKPISuccessfullyDisplayed() == true) {
			setStatusTest("pass", "User CAN see/do message: " + "Updated successfully\r\n");
		} else {
			setStatusTest("fail", "User CAN Not see/do message: " + "Updated successfully");
		}
		
		// ==========================Rule Configuration==========
		TestLogger.info("11. Go to tab Rule Configuration");
		
		ruleConfiguration.clicktabRuleConfiguration();
		
		TestLogger.info("Expect : User CAN see /do:\r\n"
				+	"1. Rule Configuration tab \r\n" 
				+ 	"2. Link Edit Rule \r\n"
				+ 	"3. Button Save in Edit Rule");
	
		if (ruleConfiguration.istabRuleConfigurationDisplayed()== true) 
		{
		setStatusTest("pass", "User CAN see/do: " + "Rule Configuration tab");
		} else {
		setStatusTest("fail", "User CANNOT see/do: " + "Rule Configuration tab");
		}
	
		if (ruleConfiguration.islinkOfRuleisplayed()== true) 
		{
		setStatusTest("pass", "User CAN see/do: " + "Link Edit Rule");
		} else {
		setStatusTest("fail", "User CANNOT see/do: " + "Link Edit Rule");
		}
		
		ruleConfiguration.clickLinkOfRule();
		if (editRuleConfiguration.isButtonSaveDisplayed()== true) 
		{
		setStatusTest("pass", "User CAN see/do: " + "Button Save in Edit Rule\r\n");
		} else {
		setStatusTest("fail", "User CANNOT see/do: " + "Button Save in Edit Rule");
		}
		editKPIList.clickButtonCancel();
	
		TestLogger.info("Expect : User CANNOT see /do:\r\n"
			+	"1. Delete function \r\n" 
			+ 	"2. Button Add");
	
		if (ruleConfiguration.isButtonAddDisplayed()== false) 
		{
		setStatusTest("pass", "User CANNOT see/do: " + "Button Add");
		} else {
		setStatusTest("fail", "User CAN see/do: " + "Button Add");
		}
		
		if (ruleConfiguration.isbtnDeleteRuleDisplayed()== false) 
		{
		setStatusTest("pass", "User CANNOT see/do: " + "Delete function\r\n");
		} else {
		setStatusTest("fail", "User CAN see/do: " + "Delete function");
		}
	
		TestLogger.info("12. Update Rule Configuration");
		
		ruleConfiguration.clickchkRule();
		editKPIList.clickButtonSave();
				
		if (ruleConfiguration.ismsgUpdateSuccessfullyDisplayed() == true) {
			setStatusTest("pass", "User CAN see/do message: " + "Updated successfully\r\n");
		} else {
			setStatusTest("fail", "User CAN Not see/do message: " + "Updated successfully");
		}
		// ==========================Rule Configuration==========
		
		// ==========================Assign Rule==========
		
		TestLogger.info("13. Go to tab Assign Rule");
		assignRule.clicktabAssignRule();
		
		TestLogger.info("Expect : User CAN see /do:\r\n"
				+	"1. Assign Rule tab");
	
		if (assignRule.istabAssignRuleDisplayed()== true) 
		{
		setStatusTest("pass", "User CAN see/do: " + "Rule Configuration tab\r\n");
		} else {
		setStatusTest("fail", "User CANNOT see/do: " + "Rule Configuration tab");
		}
			
		TestLogger.info("Expect : User CANNOT see /do:\r\n"
				+	"1. Delete function \r\n" 
				+ 	"2. Button Add");
	
		if (assignRule.isbtnDeleteDisplayed()== false) 
		{
		setStatusTest("pass", "User CANNOT see/do: " + "Delete function");
		} else {
			setStatusTest("fail", "User CAN see/do: " + "Delete function");
		}
		
		if (assignRule.isbtnAddDisplayed()== false) 
		{
		setStatusTest("pass", "User CANNOT see/do: " + "Button Add\r\n");
		} else {
		setStatusTest("fail", "User CAN see/do: " + "Button Add");
		}
		// ==========================Assign Rule==========
		
		// ==========================KPI Mapping==========
		
		TestLogger.info("14. Go to tab KPI Mapping");
		kpiMapping.clicktabKPIMapping();
		
		TestLogger.info("Expect : User CAN see /do:\r\n"
				+	"1. KPI Mapping tab\r\n"
				+	"2. Button View Detail\r\n"
				+	"3. Button Back in KPI Mapping Detail\r\n"
				+	"4. Link Edit KPI Mapping\r\n"
				+	"5. Button Save in Update KPI Mapping");
	
		if (kpiMapping.istabKPIMappingDisplayed()== true) 
		{
		setStatusTest("pass", "User CAN see/do: " + "KPI Mapping tab");
		} else {
		setStatusTest("fail", "User CANNOT see/do: " + "KPI Mapping tab");
		}
			
		if (kpiMapping.isbtnViewDetailDisplayed()== true) 
		{
		setStatusTest("pass", "User CAN see/do: " + "Button View Detail");
		} else {
		setStatusTest("fail", "User CANNOT see/do: " + "Button View Detail");
		}
		
		kpiMapping.clickbtnViewDetail();
		if (kpiMappingHistory.isChkKPIHistoryDisplayed()== true) 
		{
		setStatusTest("pass", "User CAN see/do: " + "Link Edit KPI Mapping");
		} else {
		setStatusTest("fail", "User CANNOT see/do: " + "Link Edit KPI Mapping");
		}
		
		if (kpiMappingHistory.isbtnBackDisplayed()== true) 
		{
		setStatusTest("pass", "User CAN see/do: " + "Button Back in KPI Mapping Detail\r\n");
		} else {
		setStatusTest("fail", "User CANNOT see/do: " + "Button Back in KPI Mapping Detail");
		}
		
		kpiMappingHistory.clickchkKPIHistory();
		if (editKPIMappingHistory.isButtonSaveDisplayed()== true) 
		{
		setStatusTest("pass", "User CAN see/do: " + "Button Save in Update KPI Mapping");
		} else {
		setStatusTest("fail", "User CANNOT see/do: " + "Button Save in Update KPI Mapping");
		}
		editKPIMappingHistory.clickButtonCancel();

		TestLogger.info("Expect : User CANNOT see /do:\r\n"
				+	"1. Delete function\r\n"
				+ 	"2. Add  btn in KPI Mapping Board\r\n"
				+	"3. Add  btn in KPI Mapping Detail");
	
		if (kpiMappingHistory.isbtnAddDisplayed()== false) 
		{
		setStatusTest("pass", "User CANNOT see/do " + "Add  btn in KPI Mapping Detail");
		} else {
		setStatusTest("fail", "User CAN see/do: " + "Add  btn in KPI Mapping Detail");
		}
		
		kpiMappingHistory.clickbtnBack();
		if (kpiMapping.isbtnAddDisplayed()== false) 
		{
		setStatusTest("pass", "User CANNOT see/do: " + "Add  btn in KPI Mapping Board");
		} else {
		setStatusTest("fail", "User CAN see/do: " + "Add  btn in KPI Mapping Board");
		}
		
		if (kpiMapping.isbtnDeleteDisplayed()== false) 
		{
		setStatusTest("pass", "User CANNOT see/do: " + "Delete function\r\n");
		} else {
		setStatusTest("fail", "User CAN see/do: " + "Delete function");
		}
		// ============Edit KPI Mapping History===========
		
		TestLogger.info("18. Update KPI Mapping");
		
		kpiMapping.clickbtnViewDetail();
		kpiMappingHistory.clickchkKPIHistory();
		editKPIMappingHistory.clickButtonSave();
			
		if (kpiMapping.ismsgUpdateSuccessfullyDisplayed() == true) {
			setStatusTest("pass", "User CAN see/do KPI Mapping History");
		} else {
			setStatusTest("fail", "User CAN Not see/do KPI Mapping History");
		}
		// ==========================KPI Mapping==========
		TestLogger.info("==========TT_3650================");
	}

	@Test(priority = 5)
	public void TT_3652() throws InterruptedException {
		TestLogger.info("==========TT_3652================");
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
		UserRoleName = "KPISettingsByProject|Delete" + TienIch.taoRandomSo(3);

		roles.createUserRoleNameWithRoleTypeAdmin(UserRoleName);
		
		TestLogger.info("4.Check on Perfomance Permission - KPI Settings By Project | Delete");
		roles.checkbox_Delete_KPI_SettingsByProject();
		
		TestLogger.info("5. Click Save button");
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

		TestLogger.info("8. Go to Performance >> Go to KPI By Project");
		
		administration.clickMenuPerformance();
		administration.clickSubMenuKPIByProject();
		
		if (administration.isSubMenuKPISettingsByProjectDisplayed() == true) {
			setStatusTest("pass", "User CAN see/do:\r\n" + "KPI Settings menu");
		} else {
			setStatusTest("fail", "User CAN NOT see/do:\r\n" + "KPI Settings menu");
		}
		// ===============KPI Configuration=======================
		TestLogger.info("9. Go to KPI Settings");
		
		administration.clickSubMenuKPISettingsByProject();
		
		TestLogger.info("Expect : User CAN see /do:\r\n"
				+	"1. KPI Configuration tab \r\n" 
				+ 	"2. Link Edit Category\r\n" 
				+	"3. Link Edit KPI\r\n"
				+ 	"4. Delete function");

		if (kpiConfiguration.istblKPIsListDisplayed()== true) 
		{
		setStatusTest("pass", "User CAN see/do: " + "KPI Configuration tab");
		} else {
		setStatusTest("fail", "User CANNOT see/do: " + "KPI Configuration tab");
		}
			
		if (kpiConfiguration.islinkOfKPIConfigurationDisplayed()== true) 
		{
		setStatusTest("pass", "User CAN see/do: " + "Link Edit Category");
		} else {
		setStatusTest("fail", "User CANNOT see/do: " + "Link Edit Category");
		}
	
		if (kpiConfiguration.islinkOfKPIDisplayed()== true) 
		{
		setStatusTest("pass", "User CAN see/do: " + "Link Edit KPI\r\n");
		} else {
		setStatusTest("fail", "User CANNOT see/do: " + "Link Edit KPI");
		}
		
		if (kpiConfiguration.isBtnDeleteCategoryDisplayed()== true) 
		{
		setStatusTest("pass", "User CAN see/do: " + "Delete function");
		} else {
		setStatusTest("fail", "User CANNOT see/do: " + "Delete function");
		}
	
		TestLogger.info("Expect : User CANNOT see /do:\r\n"
				+ "1. Button Save in Edit Category\r\n"
				+ "2. Button Save in Edit KPI\r\n"
				+ "3. Button Add ");
	
		if (kpiConfiguration.isButtonAddDisplayed()== false) 
		{
		setStatusTest("pass", "User CANNOT see/do: " + "Button Add");
		} else {
		setStatusTest("fail", "User CAN see/do: " + "Button Add");
		}
	
		kpiConfiguration.clickLinkOfCategory();
		if (editKPI.isButtonSaveDisplayed()== false) 
		{
		setStatusTest("pass", "User CANNOT see/do: " + "Button Save in Edit Category");
		} else {
		setStatusTest("fail", "User CAN see/do: " + "Button Save in Edit Category");
		}
		editKPI.clickButtonClose();
	
		kpiConfiguration.clickLinkOfKPI();
		if (editKPI.isButtonSaveDisplayed()== false) 
		{
		setStatusTest("pass", "User CANNOT see/do: " + "Button Save in Edit KPI\r\n");
		} else {
		setStatusTest("fail", "User CAN see/do: " + "Button Save in Edit KPI");
		}
		editKPI.clickButtonClose();
		
		TestLogger.info("11. Delete KPI Configuration");
		
		kpiConfiguration.deleteKPI();
				
		if (kpiConfiguration.ismsgDeleteKPIDisplayed() == true) {
			setStatusTest("pass", "User CAN NOT see/do message: Deleted Successfully\r\n");
		} else {
			setStatusTest("fail", "User Still see/do message: Deleted Successfully");
		}
		
		// ==========================Rule Configuration==========
		TestLogger.info("12. Go to tab Rule Configuration");
		
		ruleConfiguration.clicktabRuleConfiguration();
		
		TestLogger.info("Expect : User CAN see /do:\r\n"
				+	"1. Rule Configuration tab \r\n" 
				+ 	"2. Link Edit Rule\r\n"
				+ 	"3. Delete function");
	
		if (ruleConfiguration.istabRuleConfigurationDisplayed()== true) 
		{
		setStatusTest("pass", "User CAN see/do: " + "Rule Configuration tab");
		} else {
		setStatusTest("fail", "User CANNOT see/do: " + "Rule Configuration tab");
		}
	
		if (ruleConfiguration.isbtnDeleteRuleDisplayed()== true) 
		{
		setStatusTest("pass", "User CAN see/do: " + "Delete function");
		} else {
		setStatusTest("fail", "User CANNOT see/do: " + "Delete function");
		}
		
		if (ruleConfiguration.islinkOfRuleisplayed()== true) 
		{
		setStatusTest("pass", "User CAN see/do: " + "Link Edit Rule\r\n");
		} else {
		setStatusTest("fail", "User CANNOT see/do: " + "Link Edit Rule");
		}
	
		TestLogger.info("Expect : User CANNOT see /do:\r\n"
			+	"1. Button Add \r\n"
			+ 	"2. Button Save in Edit Rule");
	
		if (ruleConfiguration.isButtonAddDisplayed()== false) 
		{
		setStatusTest("pass", "User CANNOT see/do: " + "Button Add");
		} else {
		setStatusTest("fail", "User CAN see/do: " + "Button Add");
		}
	
		ruleConfiguration.clickLinkOfRule();
		if (editRuleConfiguration.isButtonSaveDisplayed()== false) 
		{
		setStatusTest("pass", "User CANNOT see/do: " + "Button Save in Edit Rule\r\n");
		} else {
		setStatusTest("fail", "User CAN see/do: " + "Button Save in Edit Rule");
		}
		editKPIList.clickButtonClose();
		// ============Delete Rule Configuration===========
		
		TestLogger.info("14. Delete Rule Configuration");
		
		ruleConfiguration.deleteRule();
		
		if (ruleConfiguration.ismsgDeleteSuccessfullyDisplayed() == true) {
			setStatusTest("pass", "User CAN see/do message:\r\n" + "Delete successfully\r\n");
		} else {
			setStatusTest("fail", "User CAN Not see/do message:\r\n" + "Delete successfully");
		}
		
		// ==========================Rule Configuration==========
		
		// ==========================Assign Rule==========
		
		TestLogger.info("15. Go to Assign Rule");
		
		assignRule.clicktabAssignRule();
		
		TestLogger.info("Expect : User CAN see /do:\r\n"
				+	"1. Assign Rule tab\r\n"
				+ 	"2. Delete function");
	
		if (assignRule.istabAssignRuleDisplayed()== true) 
		{
		setStatusTest("pass", "User CAN see/do: " + "Rule Configuration tab\r\n");
		} else {
		setStatusTest("fail", "User CANNOT see/do: " + "Rule Configuration tab");
		}
		
		if (assignRule.isbtnDeleteDisplayed()== true) 
		{
		setStatusTest("pass", "User CAN see/do: " + "Delete function\r\n");
		} else {
			setStatusTest("fail", "User CANNOT see/do: " + "Delete function");
		}
	
			
		TestLogger.info("Expect : User CANNOT see /do:\r\n"
				+	"1. Button Add");
		
		if (assignRule.isbtnAddDisplayed()== false) 
		{
		setStatusTest("pass", "User CANNOT see/do: " + "Button Add\r\n");
		} else {
		setStatusTest("fail", "User CAN see/do: " + "Button Add");
		}
		
		// ============Delete Rule Configuration===========
		TestLogger.info("17. Delete Assign Rule");
		
			if (assignRule.isLblKPISettingsDisplayed() == false) {
			setStatusTest("pass", "User CANNOT see/do : " + "Data in table\r\n");
		} else {
			setStatusTest("fail", "User STILL CAN see/do :" + "Data in table");
		}
	
		// ==========================Rule Configuration==========
		
		// ==========================KPI Mapping==========
		TestLogger.info("18. Go to tab KPI Mapping");
		
		kpiMapping.clicktabKPIMapping();
		
		TestLogger.info("Expect : User CAN see /do:\r\n"
				+	"1. KPI Mapping tab\r\n"
				+	"2. Button View Detail\r\n"
				+	"3. Button Back in KPI Mapping Detail\r\n"
				+	"4. Link Edit KPI Mapping\r\n"
				+ 	"5. Delete function");
	
		if (kpiMapping.istabKPIMappingDisplayed()== true) 
		{
		setStatusTest("pass", "User CAN see/do: " + "KPI Mapping tab");
		} else {
		setStatusTest("fail", "User CANNOT see/do: " + "KPI Mapping tab");
		}
			
		if (kpiMapping.isbtnViewDetailDisplayed()== true) 
		{
		setStatusTest("pass", "User CAN see/do: " + "Button View Detail");
		} else {
		setStatusTest("fail", "User CANNOT see/do: " + "Button View Detail");
		}
		
		if (kpiMapping.isbtnDeleteDisplayed()== true) 
		{
		setStatusTest("pass", "User CAN see/do: " + "Delete function\r\n");
		} else {
		setStatusTest("fail", "User CANNOT see/do: " + "Delete function");
		}
		
		kpiMapping.clickbtnViewDetail();
		if (kpiMappingHistory.isChkKPIHistoryDisplayed()== true) 
		{
		setStatusTest("pass", "User CAN see/do: " + "Link Edit KPI Mapping");
		} else {
		setStatusTest("fail", "User CANNOT see/do: " + "Link Edit KPI Mapping");
		}
		
		if (kpiMappingHistory.isbtnBackDisplayed()== true) 
		{
		setStatusTest("pass", "User CAN see/do: " + "Button Back in KPI Mapping Detail\r\n");
		} else {
		setStatusTest("fail", "User CANNOT see/do: " + "Button Back in KPI Mapping Detail");
		}
	
		TestLogger.info("Expect : User CANNOT see /do:\r\n"
				+	"1. Add  btn in KPI Mapping Board\r\n"
				+	"2. Add  btn in KPI Mapping Detail\r\n"
				+	"3. Button Save in Update KPI Mapping");
	
		if (kpiMappingHistory.isbtnAddDisplayed()== false) 
		{
		setStatusTest("pass", "User CANNOT see/do " + "Add  btn in KPI Mapping Detail");
		} else {
		setStatusTest("fail", "User CAN see/do: " + "Add  btn in KPI Mapping Detail");
		}
		
		kpiMappingHistory.clickchkKPIHistory();
		if (editKPIMappingHistory.isButtonSaveDisplayed()== false) 
		{
		setStatusTest("pass", "User CANNOT see/do: " + "Button Save in Update KPI Mapping");
		} else {
		setStatusTest("fail", "User CAN see/do: " + "Button Save in Update KPI Mapping");
		}
		editKPI.clickButtonClose();
		
		kpiMappingHistory.clickbtnBack();
		if (kpiMapping.isbtnAddDisplayed()== false) 
		{
		setStatusTest("pass", "User CANNOT see/do: " + "Add  btn in KPI Mapping Board\r\n");
		} else {
		setStatusTest("fail", "User CAN see/do: " + "Add  btn in KPI Mapping Board");
		}

		// ============Open KPI Mapping History===========
		
		TestLogger.info("19. Delete KPI Mappng");
		
		kpiMapping.clickbtnViewDetail();
		kpiMappingHistory.deleteKPIMappingHistory();
		
		if (kpiMapping.ismsgDeleteSuccessfullyDisplayed() == true) {
			setStatusTest("pass", "User CAN see/do message: Delete Successfully");
		} else {
			setStatusTest("fail", "User CAN Not see/do message: Delete Successfully");
		}
		// ==========================KPI Mapping==========
		TestLogger.info("==========TT_3652================");
	}

	@AfterMethod(alwaysRun = true)
	public void finishTestCase() throws InterruptedException {
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

	}

	@AfterTest (alwaysRun = true)
	public void dongTrinhDuyet() {
		driver.close();
	}
}
