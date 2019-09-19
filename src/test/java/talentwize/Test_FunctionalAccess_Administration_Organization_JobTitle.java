package talentwize;

import java.lang.reflect.Method;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
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
import talentwize.pages.Dashboard;
import talentwize.pages.EmployeeList;
import talentwize.pages.Form_AddCategory;
import talentwize.pages.Form_AddJobTitle;
import talentwize.pages.Form_AddRoleLevel;
import talentwize.pages.Form_AddRoleTitle;
import talentwize.pages.Form_EditCategory;
import talentwize.pages.Form_EditContractType;
import talentwize.pages.Form_EditCurrentPosition;
import talentwize.pages.Form_EditJobTitle;
import talentwize.pages.Form_EditNewPosition;
import talentwize.pages.Form_EditPreviousPosition;
import talentwize.pages.Form_EditRoleLevel;
import talentwize.pages.Form_EditRoleTitle;
import talentwize.pages.HomePage;
import talentwize.pages.Roles;
import talentwize.pages.TabJobCategory;
import talentwize.pages.TabJobTitle;
import talentwize.pages.TabRoleLevel;
import talentwize.pages.TabRoleTitle;
import talentwize.pages.Users;


public class Test_FunctionalAccess_Administration_Organization_JobTitle extends TestManager {
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
	TabRoleTitle tabRoleTitle ; 
	TabRoleLevel tabRoleLevel; 
	TabJobTitle tabJobTitle ; 
	TabJobCategory tabJobCategory ; 
	Form_AddRoleTitle formAddRoleTitle ; 
	Form_AddJobTitle formAddJobTitle ; 
	Form_AddCategory formAddCatefory;
	Form_AddRoleLevel formAddRoleLevel;
	
	 
	Form_EditRoleTitle formEditRoleTitle ; 
	Form_EditJobTitle formEditJobTitle ; 
	Form_EditCategory formEditCatefory;
	Form_EditRoleLevel formEditRoleLevel;
	

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
		tabRoleTitle = new TabRoleTitle(driver);
		tabRoleLevel = new TabRoleLevel(driver); 
		tabJobTitle = new TabJobTitle(driver); 
		tabJobCategory = new TabJobCategory(driver);
		
		formAddRoleTitle = new Form_AddRoleTitle(driver);
		formAddJobTitle = new Form_AddJobTitle(driver); 
		formAddCatefory = new Form_AddCategory(driver); 
		formAddRoleLevel = new Form_AddRoleLevel(driver);
		
		formEditRoleTitle = new Form_EditRoleTitle(driver); 
		formEditJobTitle = new Form_EditJobTitle(driver); 
		formEditCatefory = new Form_EditCategory(driver); 
		formEditRoleLevel = new Form_EditRoleLevel(driver); 
		
		

	}

	@BeforeMethod
	public void PrintNameTestCase(Method method) {
		TestLogger.info("====== Begin Testcase : " + method.getName() + " ========");
	}

	@Test(priority = 1)
	public void TT_4281() throws InterruptedException {
	
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
		UserRoleName = "Organization-Job Title|NoPermission" + TienIch.taoRandomSo(3);

		roles.createUserRoleNameWithRoleTypeAdmin(UserRoleName);

		TestLogger.info("+ Uncheck on\r\n" + 
				"+ Administration - Organization - JobTitle | Read");

		roles.uncheckbox_Read_JobTitle();

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

		TestLogger.info("8.Access to Administration >> Organization");

		administration.clickMenuAdministration();
	    
		if (administration.isMenuOgranizationDisplayed() ==false)
		{
			administration.clickMenuAdministration();
		}
		else
		{
		administration.clickSubMenuOrganization();
		}

		if (administration.isMenuJobTitleDisplayed() == false) {
			setStatusTest("pass", "User CANNOT see/do:\r\n" + 
					"- Module Job Title");
		} else {
			setStatusTest("fail", "User STILL CAN see/do:\r\n" + 
					"- Module Job Title");
		}
		
	}
	
	@Test(priority = 2)
	public void TT_4284() throws InterruptedException {
	
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
		UserRoleName = "Organization-Job Title|Create" + TienIch.taoRandomSo(3);

		roles.createUserRoleNameWithRoleTypeAdmin(UserRoleName);

		TestLogger.info("+ Uncheck on\r\n" + 
				"+ Administration - Organization - JobTitle | Read");

		roles.uncheckbox_Read_JobTitle();
		
		TestLogger.info("Check on Administration - Organization - JobTitle | Create");
		
		roles.checkBox_Create_JobTitle();

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

		TestLogger.info("8.Access to Administration >> Organization");

		administration.clickMenuAdministration();
	    
		if (administration.isMenuOgranizationDisplayed() ==false)
		{
			administration.clickMenuAdministration();
		}
		else
		{
		administration.clickSubMenuOrganization();
		}

		administration.clickMenuJobTitle();
		
		TestLogger.info("Access  to Administration - Organization - Job Title - Role Title tab");
		administration.clickTabRoleTitle(); 
		
		if (tabRoleTitle.isButtonAddDisplayed()==true)
		{
			setStatusTest("Pass", "User CAN see/do:\r\n" + 
					"1. Add button");
		}
		else
		{
			setStatusTest("Fail", "User CAN NOT see/do:\r\n" + 
					"1. Add button");
		}
		
		if (tabRoleTitle.areLinksRoleTitleDisplayed()==false && tabRoleTitle.isIconDeleteDisplayed()==false)
		{
			setStatusTest("Pass", "User CANNOT see/do:\r\n" + 
					"1. Edit function\r\n" + 
					"2. Delete button");
		}
		else
		{
			setStatusTest("Fail", "User STILL CAN see/do:\r\n" + 
					"1. Edit function\r\n" + 
					"2. Delete button");
		}
		
		tabRoleTitle.clickButtonAdd(); 
		formAddRoleTitle.AddRoleTitle(TienIch.taoRandomChu(12));
		
		if (tabRoleTitle.isMsgAddedSuccessDisplayed()==true)
		{
			setStatusTest("pass", "Created successfully");
		}
		else
		{
			setStatusTest("fail", "NOT Created successfully");
		}
		
		TestLogger.info("11. Access  to Administration - Organization - Job Title - Role Level tab\r\n" + 
				"2. Create a Role Level");
		administration.clickTabRoleLevel();
		
		if (tabRoleLevel.isButtonAddDisplayed()==true)
		{
			setStatusTest("Pass", "User CAN see/do:\r\n" + 
					"1. Add button");
		}
		else
		{
			setStatusTest("Fail", "User CAN NOT see/do:\r\n" + 
					"1. Add button");
		}
		
		if (tabRoleLevel.areLinksRoleLevelDisplayed()==false && tabRoleLevel.isIconDeleteDisplayed()==false)
		{
			setStatusTest("Pass", "User CANNOT see/do:\r\n" + 
					"1. Edit function\r\n" + 
					"2. Delete button");
		}
		else
		{
			setStatusTest("Fail", "User STILL CAN see/do:\r\n" + 
					"1. Edit function\r\n" + 
					"2. Delete button");
		}
		
		tabRoleLevel.clickButtonAdd(); 
		formAddRoleLevel.AddRoleTitle(TienIch.taoRandomChu(12));
		
		if (tabRoleLevel.isMsgAddedSuccessDisplayed()==true)
		{
			setStatusTest("pass", "Created successfully");
		}
		else
		{
			setStatusTest("fail", "NOT Created successfully");
		}
		
		TestLogger.info("13. Access  to Administration - Organization - Job Title - Job Title tab");
		
		administration.clickTabJobTile(); 
		
		if (tabJobTitle.isButtonAddDisplayed()==true && tabJobTitle.isButtonExportDisplayed()==true)
		{
			setStatusTest("Pass", "User CAN see/do:\r\n" + 
					"1. Add button\r\n" + 
					"2. Export button");
		}
		else
		{
			setStatusTest("Fail", "User CAN NOT see/do:\r\n" + 
					"1. Add button\r\n" + 
					"2. Export button");
		}
		
		if (tabJobTitle.areLinksJobTitleDisplayed()==false && tabJobTitle.isIconDeleteDisplayed()==false)
		{
			setStatusTest("pass", "User CANNOT see/do:\r\n" + 
					"1. Edit function\r\n" + 
					"2. Delete button");
		}
		else
		{
			setStatusTest("fail", "User STILL CAN see/do:\r\n" + 
					"1. Edit function\r\n" + 
					"2. Delete button");
		}
		
		tabJobTitle.clickButtonAdd(); 
		formAddJobTitle.AddJobTitle(TienIch.taoRandomChu(12));
		if (tabJobTitle.isMsgAddedSuccessDisplayed()==true)
		{
			setStatusTest("pass", "Create successfully");
		}
		else
		{
			setStatusTest("fail", "Create NOT successfully");
		}
		
		
		
		TestLogger.info("14. Access  to Administration - Organization - Job Title - Job Category tab"); 
		administration.clickTabJobCategory(); 
		if (tabJobCategory.isButtonAddDisplayed()==true)
		{
			setStatusTest("pass", "User CAN see/do:\r\n" + 
					"1. Add button");
		}
		else
		{
			setStatusTest("fail", "User CAN NOT see/do:\r\n" + 
					"1. Add button");
		}
		
		if (tabJobCategory.areLinksJobCategoryDisplayed()==false && tabJobCategory.isIconDeleteDisplayed()==false)
		{
			setStatusTest("pass", "User CANNOT see/do:\r\n" + 
					"1. Edit function\r\n" + 
					"2. Delete button");
		}
		else
		{
			setStatusTest("fail", "User STILL CAN see/do:\r\n" + 
					"1. Edit function\r\n" + 
					"2. Delete button");
		}
		
		tabJobCategory.clickButtonAdd();
		
		formAddCatefory.AddCategory(TienIch.taoRandomChu(13));
		if (tabJobCategory.isMsgAddedSuccessDisplayed()==true)
		{
			setStatusTest("pass", "Create successfully");
		}
		else
		{
			setStatusTest("fail", "Create NOT successfully ");
		}
			
	}
	
	@Test(priority = 3)
	public void TT_4282() throws InterruptedException {
	
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
		UserRoleName = "Organization-Job Title|Create" + TienIch.taoRandomSo(3);

		roles.createUserRoleNameWithRoleTypeAdmin(UserRoleName);

		TestLogger.info("+ Uncheck on\r\n" + 
				"+ Administration - Organization - JobTitle | Read");

		roles.uncheckbox_Read_JobTitle();
		
		TestLogger.info("Check on Administration - Organization - JobTitle | Read");
		
		roles.checkBox_Read_JobTitle();

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

		TestLogger.info("8.Access to Administration >> Organization");

		administration.clickMenuAdministration();
	    
		if (administration.isMenuOgranizationDisplayed() ==false)
		{
			administration.clickMenuAdministration();
		}
		else
		{
		administration.clickSubMenuOrganization();
		}

		administration.clickMenuJobTitle();
		
		TestLogger.info("Access  to Administration - Organization - Job Title - Role Title tab");
		administration.clickTabRoleTitle(); 
		
		
		
		if (tabRoleTitle.isButtonAddDisplayed()==false)
		{
			setStatusTest("Pass", "User CAN NOT see/do:\r\n" + 
					"1. Add button");
		}
		else
		{
			setStatusTest("Fail", "User STILL CAN  see/do:\r\n" + 
					"1. Add button");
		}
		
		if (tabRoleTitle.areLinksRoleTitleDisplayed()==false && tabRoleTitle.isIconDeleteDisplayed()==false)
		{
			setStatusTest("Pass", "User CANNOT see/do:\r\n" + 
					"1. Edit function\r\n" + 
					"2. Delete button");
		}
		else
		{
			setStatusTest("Fail", "User STILL CAN see/do:\r\n" + 
					"1. Edit function\r\n" + 
					"2. Delete button");
		}
		
		TestLogger.info("11. Access  to Administration - Organization - Job Title - Role Level tab\r\n" + 
				"2. Create a Role Level");
		administration.clickTabRoleLevel();
		
		if (tabRoleLevel.isButtonAddDisplayed()==false)
		{
			setStatusTest("Pass", "User CAN NOT see/do:\r\n" + 
					"1. Add button");
		}
		else
		{
			setStatusTest("Fail", "User STILL CAN see/do:\r\n" + 
					"1. Add button");
		}
		
		if (tabRoleLevel.areLinksRoleLevelDisplayed()==false && tabRoleLevel.isIconDeleteDisplayed()==false)
		{
			setStatusTest("Pass", "User CANNOT see/do:\r\n" + 
					"1. Edit function\r\n" + 
					"2. Delete button");
		}
		else
		{
			setStatusTest("Fail", "User STILL CAN see/do:\r\n" + 
					"1. Edit function\r\n" + 
					"2. Delete button");
		}
		
		
		
		TestLogger.info("13. Access  to Administration - Organization - Job Title - Job Title tab");
		
		administration.clickTabJobTile(); 
		
		if (tabJobTitle.isButtonAddDisplayed()==false)
		{
			setStatusTest("Pass", "User CAN NOT see/do:\r\n" + 
					"1. Add button\r\n" + 
					"");
		}
		else
		{
			setStatusTest("Fail", "User STILL CAN see/do:\r\n" + 
					"1. Add button\r\n" + 
					"");
		}
		
		if (tabJobTitle.isButtonExportDisplayed()==true)
		{
			setStatusTest("pass", "User CAN see/do:\r\n" + 
					"" + 
					"2. Export button");
		}
		else
		{
			setStatusTest("fail", "User CAN NOT see/do:\r\n" + 
					"" + 
					"2. Export button");
		}
		
		if (tabJobTitle.areLinksJobTitleDisplayed()==false && tabJobTitle.isIconDeleteDisplayed()==false)
		{
			setStatusTest("pass", "User CANNOT see/do:\r\n" + 
					"1. Edit function\r\n" + 
					"2. Delete button");
		}
		else
		{
			setStatusTest("fail", "User STILL CAN see/do:\r\n" + 
					"1. Edit function\r\n" + 
					"2. Delete button");
		}
		
	
		TestLogger.info("14. Access  to Administration - Organization - Job Title - Job Category tab"); 
		administration.clickTabJobCategory(); 
		if (tabJobCategory.isButtonAddDisplayed()==false)
		{
			setStatusTest("pass", "User CAN see/do:\r\n" + 
					"1. Add button");
		}
		else
		{
			setStatusTest("fail", "User CAN NOT see/do:\r\n" + 
					"1. Add button");
		}
		
		if (tabJobCategory.areLinksJobCategoryDisplayed()==false && tabJobCategory.isIconDeleteDisplayed()==false)
		{
			setStatusTest("pass", "User CANNOT see/do:\r\n" + 
					"1. Edit function\r\n" + 
					"2. Delete button");
		}
		else
		{
			setStatusTest("fail", "User STILL CAN see/do:\r\n" + 
					"1. Edit function\r\n" + 
					"2. Delete button");
		}
		
		
	}
	
	@Test(priority = 4)
	public void TT_4285() throws InterruptedException {
	
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
		UserRoleName = "Organization-Job Title|Create" + TienIch.taoRandomSo(3);

		roles.createUserRoleNameWithRoleTypeAdmin(UserRoleName);

		TestLogger.info("+ Uncheck on\r\n" + 
				"+ Administration - Organization - JobTitle | Read");

		roles.uncheckbox_Read_JobTitle();
		
		TestLogger.info("Check on Administration - Organization - JobTitle | Update");
		
		roles.checkBox_Update_JobTitle();

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

		TestLogger.info("8.Access to Administration >> Organization");

		administration.clickMenuAdministration();
	    
		if (administration.isMenuOgranizationDisplayed() ==false)
		{
			administration.clickMenuAdministration();
		}
		else
		{
		administration.clickSubMenuOrganization();
		}

		administration.clickMenuJobTitle();
		
		TestLogger.info("Access  to Administration - Organization - Job Title - Role Title tab");
		administration.clickTabRoleTitle(); 
		
		if (tabRoleTitle.isButtonAddDisplayed()==false)
		{
			setStatusTest("Pass", "User CAN NOT see/do:\r\n" + 
					"1. Add button");
		}
		else
		{
			setStatusTest("Fail", "User STILL CAN  see/do:\r\n" + 
					"1. Add button");
		}
		
		if (tabRoleTitle.isIconDeleteDisplayed()==false)
		{
			setStatusTest("Pass", "User CANNOT see/do:\r\n" + 
					"" + 
					"2. Delete button");
		}
		else
		{
			setStatusTest("Fail", "User STILL CAN see/do:\r\n" + 
					"" + 
					"2. Delete button");
		}
		
		if (tabRoleTitle.areLinksRoleTitleDisplayed()==true )
		{
			setStatusTest("pass", "User CAN see/do:\r\n" + 
					"1. Edit function");
		}
		else
		{
			setStatusTest("fail", "User CAN NOT see/do:\r\n" + 
					"1. Edit function");
		}
		
		tabRoleTitle.clickFistLinkRoleTitle();
		formEditRoleTitle.editRoleTitle(TienIch.taoRandomChu(12));
		
		if (tabRoleTitle.isMsgUpdateSuccessDisplayed()==true)
		{
			setStatusTest("pass", "Update successfully");
		}
		else
		{
			setStatusTest("fail", "Update NOT successfully"); 
		}
		
	
		TestLogger.info("11. Access  to Administration - Organization - Job Title - Role Level tab\r\n" + 
				"2. Create a Role Level");
		administration.clickTabRoleLevel();
		
		if (tabRoleLevel.isButtonAddDisplayed()==false)
		{
			setStatusTest("Pass", "User CAN NOT see/do:\r\n" + 
					"1. Add button");
		}
		else
		{
			setStatusTest("Fail", "User STILL CAN see/do:\r\n" + 
					"1. Add button");
		}
		
		if ( tabRoleLevel.isIconDeleteDisplayed()==false)
		{
			setStatusTest("Pass", "User CANNOT see/do:\r\n" + 
					"" + 
					"2. Delete button");
		}
		else
		{
			setStatusTest("Fail", "User STILL CAN see/do:\r\n" + 
					"" + 
					"2. Delete button");
		}
		
		if (tabRoleLevel.areLinksRoleLevelDisplayed()==true)
		{
			setStatusTest("pass", "User CAN see/do:\r\n" + 
					"1. Edit function");
		}
		else
		{
			setStatusTest("fail", "User CAN NOT see/do:\r\n" + 
					"1. Edit function");
		}
		
		tabRoleLevel.clickFistLinkRoleLevel();  
		formEditRoleLevel.editRoleLevel(TienIch.taoRandomChu(12));
		
		if (tabRoleLevel.isMsgUpdateSuccessDisplayed()==true)
		{
			setStatusTest("pass", "Update successfully");
		}
		else
		{
			setStatusTest("fail", "Update NOT successfully ");
		}
		
		
		TestLogger.info("13. Access  to Administration - Organization - Job Title - Job Title tab");
		
		administration.clickTabJobTile(); 
		
		if (tabJobTitle.isButtonAddDisplayed()==false)
		{
			setStatusTest("Pass", "User CAN NOT see/do:\r\n" + 
					"1. Add button\r\n" + 
					"");
		}
		else
		{
			setStatusTest("Fail", "User STILL CAN see/do:\r\n" + 
					"1. Add button\r\n" + 
					"");
		}
		
		if (tabJobTitle.isButtonExportDisplayed()==true)
		{
			setStatusTest("pass", "User CAN see/do:\r\n" + 
					"" + 
					"2. Export button");
		}
		else
		{
			setStatusTest("fail", "User CAN NOT see/do:\r\n" + 
					"" + 
					"2. Export button");
		}
		
		if ( tabJobTitle.isIconDeleteDisplayed()==false)
		{
			setStatusTest("pass", "User CANNOT see/do:\r\n" + 
					"" + 
					"2. Delete button");
		}
		else
		{
			setStatusTest("fail", "User STILL CAN see/do:\r\n" + 
					"" + 
					"2. Delete button");
		}
		
		if (tabJobTitle.areLinksJobTitleDisplayed()==true)
		{
			setStatusTest("pass", "User CAN see/do:\r\n" + 
					"1. Edit function");
		}
		else
		{
			setStatusTest("fail", "User CAN NOT see/do:\r\n" + 
					"1. Edit function");
		}
		
		tabJobTitle.clickFistLinkJobTitle();
		formEditJobTitle.clickButtonSave(); 
		if (tabJobTitle.isMsgUpdateSuccessDisplayed()==true)
		{
			setStatusTest("pass", "Update successfully");
		}
		else
		{
			setStatusTest("fail", "Update NOT successfully");
		}
		
		
		
		TestLogger.info("14. Access  to Administration - Organization - Job Title - Job Category tab"); 
		administration.clickTabJobCategory(); 
		if (tabJobCategory.isButtonAddDisplayed()==false)
		{
			setStatusTest("pass", "User CAN see/do:\r\n" + 
					"1. Add button");
		}
		else
		{
			setStatusTest("fail", "User CAN NOT see/do:\r\n" + 
					"1. Add button");
		}
		
		if ( tabJobCategory.isIconDeleteDisplayed()==false)
		{
			setStatusTest("pass", "User CANNOT see/do:\r\n" + 
					"" + 
					"2. Delete button");
		}
		else
		{
			setStatusTest("fail", "User STILL CAN see/do:\r\n" + 
					"" + 
					"2. Delete button");
		} 
		
		if (tabJobCategory.areLinksJobCategoryDisplayed()==true)
		{
		    setStatusTest("pass", "User CAN see/do:\r\n" + 
		    		"1. Edit function");
		}
		else
		{
			setStatusTest("fail", "User CAN NOT see/do:\r\n" + 
					"1. Edit function");
		}
		
		
		tabJobCategory.clickFistLinkJobCategory(); 
		formEditCatefory.clickButtonSave(); 
		
		if (tabJobCategory.isMsgUpdateSuccessDisplayed()==true)
		{
			setStatusTest("pass", "Update successfully");
		}
		else
		{
			setStatusTest("fail", "Update NOT successfully");
		}
		
		
	}
	
	
	@Test(priority = 5)
	public void TT_4286() throws InterruptedException {
	
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
		UserRoleName = "Organization-Job Title|Create" + TienIch.taoRandomSo(3);

		roles.createUserRoleNameWithRoleTypeAdmin(UserRoleName);

		TestLogger.info("+ Uncheck on\r\n" + 
				"+ Administration - Organization - JobTitle | Read");

		roles.uncheckbox_Read_JobTitle();
		
		TestLogger.info("Check on Administration - Organization - JobTitle | Delete");
		
		roles.checkBox_Delete_JobTitle();

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

		TestLogger.info("8.Access to Administration >> Organization");

		administration.clickMenuAdministration();
	    
		if (administration.isMenuOgranizationDisplayed() ==false)
		{
			administration.clickMenuAdministration();
		}
		else
		{
		administration.clickSubMenuOrganization();
		}

		administration.clickMenuJobTitle();
		
		TestLogger.info("Access  to Administration - Organization - Job Title - Role Title tab");
		administration.clickTabRoleTitle(); 
		
		if (tabRoleTitle.isButtonAddDisplayed()==false)
		{
			setStatusTest("Pass", "User CAN NOT see/do:\r\n" + 
					"1. Add button");
		}
		else
		{
			setStatusTest("Fail", "User STILL CAN  see/do:\r\n" + 
					"1. Add button");
		}
		
		if (tabRoleTitle.isIconDeleteDisplayed()==true)
		{
			setStatusTest("Pass", "User CAN see/do:\r\n" + 
					"" + 
					"2. Delete button");
		}
		else
		{
			setStatusTest("Fail", "User STILL CAN NOT see/do:\r\n" + 
					"" + 
					"2. Delete button");
		}
		
		if (tabRoleTitle.areLinksRoleTitleDisplayed()==false )
		{
			setStatusTest("pass", "User CAN NOT see/do:\r\n" + 
					"1. Edit function");
		}
		else
		{
			setStatusTest("fail", "User STILL CAN see/do:\r\n" + 
					"1. Edit function");
		}
		
		tabRoleTitle.deleteRoleTitle();
		
		if (tabRoleTitle.isMsgDeleteSuccessDisplayed()==true)
		{
			setStatusTest("pass", "Delete successfully");
		}
		else
		{
			setStatusTest("fail", "Delete NOT successfully"); 
		}
		
	
		TestLogger.info("11. Access  to Administration - Organization - Job Title - Role Level tab\r\n" + 
				"2. Create a Role Level");
		administration.clickTabRoleLevel();
		
		if (tabRoleLevel.isButtonAddDisplayed()==false)
		{
			setStatusTest("Pass", "User CAN NOT see/do:\r\n" + 
					"1. Add button");
		}
		else
		{
			setStatusTest("Fail", "User STILL CAN see/do:\r\n" + 
					"1. Add button");
		}
		
		if ( tabRoleLevel.isIconDeleteDisplayed()==true)
		{
			setStatusTest("Pass", "User CAN see/do:\r\n" + 
					"" + 
					"2. Delete button");
		}
		else
		{
			setStatusTest("Fail", "User STILL CAN NOT see/do:\r\n" + 
					"" + 
					"2. Delete button");
		}
		
		if (tabRoleLevel.areLinksRoleLevelDisplayed()==false)
		{
			setStatusTest("pass", "User CAN NOT see/do:\r\n" + 
					"1. Edit function");
		}
		else
		{
			setStatusTest("fail", "User CAN  see/do:\r\n" + 
					"1. Edit function");
		}
		
		tabRoleLevel.deleteRoleLevel();  
		
		
		if (tabRoleLevel.isMsgDeleteSuccessDisplayed()==true)
		{
			setStatusTest("pass", "Delete successfully");
		}
		else
		{
			setStatusTest("fail", "Delete NOT successfully ");
		}
		
		
		TestLogger.info("13. Access  to Administration - Organization - Job Title - Job Title tab");
		
		administration.clickTabJobTile(); 
		
		if (tabJobTitle.isButtonAddDisplayed()==false)
		{
			setStatusTest("Pass", "User CAN NOT see/do:\r\n" + 
					"1. Add button\r\n" + 
					"");
		}
		else
		{
			setStatusTest("Fail", "User STILL CAN see/do:\r\n" + 
					"1. Add button\r\n" + 
					"");
		}
		
		if (tabJobTitle.isButtonExportDisplayed()==true)
		{
			setStatusTest("pass", "User CAN see/do:\r\n" + 
					"" + 
					"2. Export button");
		}
		else
		{
			setStatusTest("fail", "User CAN NOT see/do:\r\n" + 
					"" + 
					"2. Export button");
		}
		
		if ( tabJobTitle.isIconDeleteDisplayed()==true)
		{
			setStatusTest("pass", "User CAN see/do:\r\n" + 
					"" + 
					"2. Delete button");
		}
		else
		{
			setStatusTest("fail", "User STILL CAN NOT see/do:\r\n" + 
					"" + 
					"2. Delete button");
		}
		
		if (tabJobTitle.areLinksJobTitleDisplayed()==false)
		{
			setStatusTest("pass", "User CAN NOT see/do:\r\n" + 
					"1. Edit function");
		}
		else
		{
			setStatusTest("fail", "User CAN see/do:\r\n" + 
					"1. Edit function");
		}
		
		tabJobTitle.deleteJobTitle();
		if (tabJobTitle.isMsgDeleteSuccessDisplayed()==true)
		{
			setStatusTest("pass", "Delete successfully");
		}
		else
		{
			setStatusTest("fail", "Delete NOT successfully");
		}
		
		
		TestLogger.info("14. Access  to Administration - Organization - Job Title - Job Category tab"); 
		administration.clickTabJobCategory(); 
		if (tabJobCategory.isButtonAddDisplayed()==false)
		{
			setStatusTest("pass", "User CAN see/do:\r\n" + 
					"1. Add button");
		}
		else
		{
			setStatusTest("fail", "User CAN NOT see/do:\r\n" + 
					"1. Add button");
		}
		
		if ( tabJobCategory.isIconDeleteDisplayed()==true)
		{
			setStatusTest("pass", "User CAN see/do:\r\n" + 
					"" + 
					"2. Delete button");
		}
		else
		{
			setStatusTest("fail", "User STILL CAN NOT see/do:\r\n" + 
					"" + 
					"2. Delete button");
		} 
		
		if (tabJobCategory.areLinksJobCategoryDisplayed()==false)
		{
		    setStatusTest("pass", "User CAN NOT see/do:\r\n" + 
		    		"1. Edit function");
		}
		else
		{
			setStatusTest("fail", "User CAN see/do:\r\n" + 
					"1. Edit function");
		}
		
		
		tabJobCategory.deleteJobCategory();
		 
		
		if (tabJobCategory.isMsgDeleteSuccessDisplayed()==true)
		{
			setStatusTest("pass", "Delele successfully");
		}
		else
		{
			setStatusTest("fail", "Delele NOT successfully");
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
