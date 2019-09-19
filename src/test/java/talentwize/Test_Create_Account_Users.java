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
import talentwize.pages.Assets;
import talentwize.pages.Dashboard;
import talentwize.pages.EmployeeList;
import talentwize.pages.Form_AddAsset;
import talentwize.pages.Form_AddDependents;
import talentwize.pages.Form_AddEmergencyContact;
import talentwize.pages.Form_CreateNewEmployee;
import talentwize.pages.Form_Delegation_Site;
import talentwize.pages.HomePage;
import talentwize.pages.OtherContacts;
import talentwize.pages.PersonalDetails;
import talentwize.pages.Roles;
import talentwize.pages.Sites;
import talentwize.pages.Users;

public class Test_Create_Account_Users extends TestManager {
   
	
    // tk defautl : Admin nguyenvietha@tek-experts.com / Test@1234
	
	HomePage homePage;
	WebDriver driver;
	PropertyManager propertyManager;
	Dashboard dashboard;
	Administration administration;
	Users users;
	Roles roles;
	String UserRoleNameAdmin ="Admin";
	String UserRoleNameUser ="User";
	EmployeeList employeeList;
	OtherContacts otherContact;
	PersonalDetails personalDetails;
    Form_AddEmergencyContact  formAddEmergencyContact ; 
    Form_AddDependents formAddDependents;
    Assets assets ;
    Form_AddAsset formAddAsset;
    Form_CreateNewEmployee formCreateNewEmployee ; 
    Sites sites;
    Form_Delegation_Site formDelegateSite ; 
   
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
		assets = new Assets(driver);
		formCreateNewEmployee = new Form_CreateNewEmployee(driver);
	
		sites = new Sites(driver);
		formDelegateSite = new Form_Delegation_Site(driver);
		homePage.moLinkWeb(propertyManager.getURL_TalentWize());
		

	}
	
    @BeforeMethod 
    public void PrintNameTestCase(Method method)
    {
    	TestLogger.info("====== Begin Testcase : " + method.getName() + " ========");
    }
	
	@Test(priority = 1)
	public void TK_NGUYENVIETNAM_USER() throws InterruptedException {
		TestLogger.info("1. Login with Administrator account.");
		homePage.SignInWith(propertyManager.getEmailAdmin(), propertyManager.getPasswordAdmin());

		if (dashboard.isDashboardMenuDisplayed() == true) {
			setStatusTest("pass", "Dang Nhap Thanh Cong");
		} else {
			setStatusTest("fail", "Dang Nhap khong Thanh Cong");
		}
        
		TestLogger.info("2. Open Employee List ");
		administration.clickMenuEmployeeList();
		TestLogger.info("3. Click Button Create Employee");
		employeeList.clickBtnCreate();
        TestLogger.info("4. Fill FistName , Mid name and Last Name and account login");
        formCreateNewEmployee.createNewEmployeeWithFullInformation("Nguyen", "Viet", "Nam", "TV109", "nguyenvietnam");
        
        TestLogger.info("5. Go to Administration - User Management - Roles tab");
		administration.clickMenuAdministration();
		administration.clickMenuUserManagement();
		
		administration.openTabUsers();

		TestLogger.info("Assign role " + UserRoleNameUser + " to employee : " + propertyManager.getEmailUserTW());
		users.searchUsername(propertyManager.getEmailUserTW());

		// Assign role Automation to this employee
		users.assignUserWithNewRole(propertyManager.getEmailUserTW(), UserRoleNameUser);
		
		administration.clickMenuOgranization();
		administration.clickMenuSites();
		sites.clickButtonManageSite("VNM");
		formDelegateSite.chooseUserDelegate("Nguyen Viet Nam");
	    formDelegateSite.waitForFormDelegationDisappear();
	    
		TestLogger.info("6. Log out");
		dashboard.logout();
        
	}
	
	@Test(priority = 2)
	public void TK_NGUYENVIETLOCK_USER() throws InterruptedException {
		TestLogger.info("1. Login with Administrator account.");
		homePage.SignInWith(propertyManager.getEmailAdmin(), propertyManager.getPasswordAdmin());

		if (dashboard.isDashboardMenuDisplayed() == true) {
			setStatusTest("pass", "Dang Nhap Thanh Cong");
		} else {
			setStatusTest("fail", "Dang Nhap khong Thanh Cong");
		}
        
		TestLogger.info("2. Open Employee List ");
		administration.clickMenuEmployeeList();
		TestLogger.info("3. Click Button Create Employee");
		employeeList.clickBtnCreate();
        TestLogger.info("4. Fill FistName , Mid name and Last Name and account login");
        formCreateNewEmployee.createNewEmployeeWithFullInformation("Nguyen", "Viet", "Lock", "TV10012", "nguyenvietlock");
        
        TestLogger.info("5. Go to Administration - User Management - Roles tab");
		administration.clickMenuAdministration();
		administration.clickMenuUserManagement();
		administration.openTabUsers();

		TestLogger.info("Assign role " + UserRoleNameUser + " to employee : " + propertyManager.getEmailUserLock());
		users.searchUsername(propertyManager.getEmailUserLock());

		// Assign role Automation to this employee
		users.assignUserWithNewRole(propertyManager.getEmailUserLock(), UserRoleNameUser);
		
		administration.clickMenuOgranization();
		administration.clickMenuSites();
		sites.clickButtonManageSite("VNM");
		formDelegateSite.chooseUserDelegate("Nguyen Viet Lock");
	    formDelegateSite.waitForFormDelegationDisappear();
	    
		TestLogger.info("6. Log out");
		
        
	}
	
	@Test(priority = 3)
	public void TK_HOANGTHILAN_ADMIN() throws InterruptedException {
		TestLogger.info("1. Login with Administrator account.");
		homePage.SignInWith(propertyManager.getEmailAdmin(), propertyManager.getPasswordAdmin());

		if (dashboard.isDashboardMenuDisplayed() == true) {
			setStatusTest("pass", "Dang Nhap Thanh Cong");
		} else {
			setStatusTest("fail", "Dang Nhap khong Thanh Cong");
		}
        
		TestLogger.info("2. Open Employee List ");
		administration.clickMenuEmployeeList();
		TestLogger.info("3. Click Button Create Employee");
		employeeList.clickBtnCreate();
        TestLogger.info("4. Fill FistName , Mid name and Last Name and account login");
        formCreateNewEmployee.createNewEmployeeWithFullInformation("Hoang", "Thi", "Lan", "TV12299", "lanadmin");
        
        TestLogger.info("5. Go to Administration - User Management - Roles tab");
		administration.clickMenuAdministration();
		administration.clickMenuUserManagement();
		administration.openTabUsers();

		TestLogger.info("Assign role " + UserRoleNameAdmin + " to employee : " + propertyManager.getEmailAdmin1());
		users.searchUsername(propertyManager.getEmailAdmin1());

		// Assign role Automation to this employee
		users.assignUserWithNewRole(propertyManager.getEmailAdmin1(), UserRoleNameAdmin); 
		
		administration.clickMenuOgranization();
		administration.clickMenuSites();
		sites.clickButtonManageSite("VNM");
		formDelegateSite.chooseUserDelegate("Hoang Thi Lan");
	    formDelegateSite.waitForFormDelegationDisappear();
	    
		TestLogger.info("6. Log out");
	
        
	}
	
	@Test(priority = 4)
	public void TK_HOANGLAN_USER() throws InterruptedException {
		TestLogger.info("1. Login with Administrator account.");
		homePage.SignInWith(propertyManager.getEmailAdmin(), propertyManager.getPasswordAdmin());

		if (dashboard.isDashboardMenuDisplayed() == true) {
			setStatusTest("pass", "Dang Nhap Thanh Cong");
		} else {
			setStatusTest("fail", "Dang Nhap khong Thanh Cong");
		}
        
		TestLogger.info("2. Open Employee List ");
		administration.clickMenuEmployeeList();
		TestLogger.info("3. Click Button Create Employee");
		employeeList.clickBtnCreate();
        TestLogger.info("4. Fill FistName , Mid name and Last Name and account login");
        formCreateNewEmployee.createNewEmployeeWithFullInformation("Lan", "", "User", "TV110", "lanuser");
        
        TestLogger.info("5. Go to Administration - User Management - Roles tab");
		administration.clickMenuAdministration();
		administration.clickMenuUserManagement();
		administration.openTabUsers();

		TestLogger.info("Assign role " + UserRoleNameUser + " to employee : " + propertyManager.getEmailUserTW1());
		users.searchUsername(propertyManager.getEmailUserTW1());

		// Assign role Automation to this employee
		users.assignUserWithNewRole(propertyManager.getEmailUserTW1(), UserRoleNameUser); 
		
		administration.clickMenuOgranization();
		administration.clickMenuSites();
		sites.clickButtonManageSite("VNM");
		formDelegateSite.chooseUserDelegate("Lan User");
	    formDelegateSite.waitForFormDelegationDisappear();
	    
		TestLogger.info("6. Log out");
		
        
	}
	
	
	@Test(priority = 5)
	public void TK_NGUYENNAMVIET_ADMIN() throws InterruptedException {
		TestLogger.info("1. Login with Administrator account.");
		homePage.SignInWith(propertyManager.getEmailAdmin(), propertyManager.getPasswordAdmin());

		if (dashboard.isDashboardMenuDisplayed() == true) {
			setStatusTest("pass", "Dang Nhap Thanh Cong");
		} else {
			setStatusTest("fail", "Dang Nhap khong Thanh Cong");
		}
        
		TestLogger.info("2. Open Employee List ");
		administration.clickMenuEmployeeList();
		TestLogger.info("3. Click Button Create Employee");
		employeeList.clickBtnCreate();
        TestLogger.info("4. Fill FistName , Mid name and Last Name and account login");
        formCreateNewEmployee.createNewEmployeeWithFullInformation("Nguyen", "Nam", "Viet", "TV1999", "nguyennamviet");
        
        TestLogger.info("5. Go to Administration - User Management - Roles tab");
		administration.clickMenuAdministration();
		administration.clickMenuUserManagement();
		administration.openTabUsers();

		TestLogger.info("Assign role " + UserRoleNameAdmin + " to employee : " + propertyManager.getEmailAdmin2());
		users.searchUsername(propertyManager.getEmailAdmin2());

		// Assign role Automation to this employee
		users.assignUserWithNewRole(propertyManager.getEmailAdmin2(), UserRoleNameAdmin); 
		
		administration.clickMenuOgranization();
		administration.clickMenuSites();
		sites.clickButtonManageSite("VNM");
		formDelegateSite.chooseUserDelegate("Nguyen Nam Viet");
	    formDelegateSite.waitForFormDelegationDisappear();
	    
		TestLogger.info("6. Log out");
	
        
	}
	
	@Test(priority = 6)
	public void TK_NGUYENHHOANGNAM_USER() throws InterruptedException {
		TestLogger.info("1. Login with Administrator account.");
		homePage.SignInWith(propertyManager.getEmailAdmin(), propertyManager.getPasswordAdmin());

		if (dashboard.isDashboardMenuDisplayed() == true) {
			setStatusTest("pass", "Dang Nhap Thanh Cong");
		} else {
			setStatusTest("fail", "Dang Nhap khong Thanh Cong");
		}
        
		TestLogger.info("2. Open Employee List ");
		administration.clickMenuEmployeeList();
		TestLogger.info("3. Click Button Create Employee");
		employeeList.clickBtnCreate();
        TestLogger.info("4. Fill FistName , Mid name and Last Name and account login");
        formCreateNewEmployee.createNewEmployeeWithFullInformation("Nguyen", "Hoang", "Nam", "TV111", "nguyenhoangnam");
        
        TestLogger.info("5. Go to Administration - User Management - Roles tab");
		administration.clickMenuAdministration();
		administration.clickMenuUserManagement();
		administration.openTabUsers();

		TestLogger.info("Assign role " + UserRoleNameUser + " to employee : " + propertyManager.getEmailNHN());
		users.searchUsername(propertyManager.getEmailNHN());

		// Assign role Automation to this employee
		users.assignUserWithNewRole(propertyManager.getEmailNHN(), UserRoleNameUser); 
		
		administration.clickMenuOgranization();
		administration.clickMenuSites();
		sites.clickButtonManageSite("VNM");
		formDelegateSite.chooseUserDelegate("Nguyen Hoang Nam");
	    formDelegateSite.waitForFormDelegationDisappear();
	    
		TestLogger.info("6. Log out");
	
        
	}
	
	@Test(priority = 7)
	public void TK_CUONGNGUYEN_ADMIN() throws InterruptedException {
		TestLogger.info("1. Login with Administrator account.");
		homePage.SignInWith(propertyManager.getEmailAdmin(), propertyManager.getPasswordAdmin());

		if (dashboard.isDashboardMenuDisplayed() == true) {
			setStatusTest("pass", "Dang Nhap Thanh Cong");
		} else {
			setStatusTest("fail", "Dang Nhap khong Thanh Cong");
		}
        
		TestLogger.info("2. Open Employee List ");
		administration.clickMenuEmployeeList();
		TestLogger.info("3. Click Button Create Employee");
		employeeList.clickBtnCreate();
        TestLogger.info("4. Fill FistName , Mid name and Last Name and account login");
        formCreateNewEmployee.createNewEmployeeWithFullInformation("Cuong", "", "Nguyen", "TV0399", "cuong.nguyen-manh");
        
        TestLogger.info("5. Go to Administration - User Management - Roles tab");
		administration.clickMenuAdministration();
		administration.clickMenuUserManagement();
		administration.openTabUsers();

		TestLogger.info("Assign role " + UserRoleNameAdmin + " to employee : " + propertyManager.getEmailCuongAdmin());
		users.searchUsername(propertyManager.getEmailCuongAdmin());

		// Assign role Automation to this employee
		users.assignUserWithNewRole(propertyManager.getEmailCuongAdmin(), UserRoleNameAdmin); 
		
		administration.clickMenuOgranization();
		administration.clickMenuSites();
		sites.clickButtonManageSite("VNM");
		formDelegateSite.chooseUserDelegate("Cuong Nguyen");
	    formDelegateSite.waitForFormDelegationDisappear();
		TestLogger.info("6. Log out");
	
	}
	
	
	@Test(priority = 8)
	public void TK_CUONG_USER1() throws InterruptedException {
		TestLogger.info("1. Login with Administrator account.");
		homePage.SignInWith(propertyManager.getEmailAdmin(), propertyManager.getPasswordAdmin());

		if (dashboard.isDashboardMenuDisplayed() == true) {
			setStatusTest("pass", "Dang Nhap Thanh Cong");
		} else {
			setStatusTest("fail", "Dang Nhap khong Thanh Cong");
		}
        
		TestLogger.info("2. Open Employee List ");
		administration.clickMenuEmployeeList();
		TestLogger.info("3. Click Button Create Employee");
		employeeList.clickBtnCreate();
        TestLogger.info("4. Fill FistName , Mid name and Last Name and account login");
        formCreateNewEmployee.createNewEmployeeWithFullInformation("Cuong","", "Automation 1", "TV6666","cuong.automation1");
        
        TestLogger.info("5. Go to Administration - User Management - Roles tab");
		administration.clickMenuAdministration();
		administration.clickMenuUserManagement();
		administration.openTabUsers();

		TestLogger.info("Assign role " + UserRoleNameUser + " to employee : " + propertyManager.getEmailCuongUser());
		users.searchUsername(propertyManager.getEmailCuongUser());

		// Assign role Automation to this employee
		users.assignUserWithNewRole(propertyManager.getEmailCuongUser(), UserRoleNameUser); 
		
		administration.clickMenuOgranization();
		administration.clickMenuSites();
		sites.clickButtonManageSite("VNM");
		formDelegateSite.chooseUserDelegate("Cuong Automation");
	    formDelegateSite.waitForFormDelegationDisappear();
		TestLogger.info("6. Log out");
	
	}
	
	@Test(priority = 9)
	public void TK_CUONG_USER2() throws InterruptedException {
		TestLogger.info("1. Login with Administrator account.");
		homePage.SignInWith(propertyManager.getEmailAdmin(), propertyManager.getPasswordAdmin());

		if (dashboard.isDashboardMenuDisplayed() == true) {
			setStatusTest("pass", "Dang Nhap Thanh Cong");
		} else {
			setStatusTest("fail", "Dang Nhap khong Thanh Cong");
		}
        
		TestLogger.info("2. Open Employee List ");
		administration.clickMenuEmployeeList();
		TestLogger.info("3. Click Button Create Employee");
		employeeList.clickBtnCreate();
        TestLogger.info("4. Fill FistName , Mid name and Last Name and account login");
        formCreateNewEmployee.createNewEmployeeWithFullInformation("Cuong","", "Automation 2", "TV12324","cuong.automation2");
        
        TestLogger.info("5. Go to Administration - User Management - Roles tab");
		administration.clickMenuAdministration();
		administration.clickMenuUserManagement();
		administration.openTabUsers();

		TestLogger.info("Assign role " + UserRoleNameUser + " to employee : " + propertyManager.getEmailCuongUser2());
		users.searchUsername(propertyManager.getEmailCuongUser2());

		// Assign role Automation to this employee
		users.assignUserWithNewRole(propertyManager.getEmailCuongUser2(), UserRoleNameUser); 
		
		administration.clickMenuOgranization();
		administration.clickMenuSites();
		sites.clickButtonManageSite("VNM");
		formDelegateSite.chooseUserDelegate("Cuong Automation 2");
	    formDelegateSite.waitForFormDelegationDisappear();
		TestLogger.info("6. Log out");
	
	}
	
	
	@Test(priority = 10)
	public void TK_NGOC_ADMIN() throws InterruptedException {
		TestLogger.info("1. Login with Administrator account.");
		homePage.SignInWith(propertyManager.getEmailAdmin(), propertyManager.getPasswordAdmin());

		if (dashboard.isDashboardMenuDisplayed() == true) {
			setStatusTest("pass", "Dang Nhap Thanh Cong");
		} else {
			setStatusTest("fail", "Dang Nhap khong Thanh Cong");
		}
        
		TestLogger.info("2. Open Employee List ");
		administration.clickMenuEmployeeList();
		TestLogger.info("3. Click Button Create Employee");
		employeeList.clickBtnCreate();
        TestLogger.info("4. Fill FistName , Mid name and Last Name and account login");
        formCreateNewEmployee.createNewEmployeeWithFullInformation("Ngoc","", "Nguyen", "TV1079","ngoc.nguyen");
        
        TestLogger.info("5. Go to Administration - User Management - Roles tab");
		administration.clickMenuAdministration();
		administration.clickMenuUserManagement();
		administration.openTabUsers();

		TestLogger.info("Assign role " + UserRoleNameAdmin + " to employee : " + propertyManager.getEmailAdminNgoc());
		users.searchUsername(propertyManager.getEmailAdminNgoc());

		// Assign role Automation to this employee
		users.assignUserWithNewRole(propertyManager.getEmailAdminNgoc(), UserRoleNameAdmin); 
		
		administration.clickMenuOgranization();
		administration.clickMenuSites();
		sites.clickButtonManageSite("VNM");
		formDelegateSite.chooseUserDelegate("Ngoc Nguyen");
	    formDelegateSite.waitForFormDelegationDisappear();
		TestLogger.info("6. Log out");
	
	}
	
	@Test(priority = 11)
	public void TK_CHI_USER() throws InterruptedException {
		TestLogger.info("1. Login with Administrator account.");
		homePage.SignInWith(propertyManager.getEmailAdmin(), propertyManager.getPasswordAdmin());

		if (dashboard.isDashboardMenuDisplayed() == true) {
			setStatusTest("pass", "Dang Nhap Thanh Cong");
		} else {
			setStatusTest("fail", "Dang Nhap khong Thanh Cong");
		}
        
		TestLogger.info("2. Open Employee List ");
		administration.clickMenuEmployeeList();
		TestLogger.info("3. Click Button Create Employee");
		employeeList.clickBtnCreate();
        TestLogger.info("4. Fill FistName , Mid name and Last Name and account login");
        formCreateNewEmployee.createNewEmployeeWithFullInformation("Vu","Khanh", "Chi", "TV5455","chi.vu-khanh");
        
        TestLogger.info("5. Go to Administration - User Management - Roles tab");
		administration.clickMenuAdministration();
		administration.clickMenuUserManagement();
		administration.openTabUsers();

		TestLogger.info("Assign role " + UserRoleNameUser + " to employee : " + propertyManager.getEmailUserChi());
		users.searchUsername(propertyManager.getEmailUserChi());

		// Assign role Automation to this employee
		users.assignUserWithNewRole(propertyManager.getEmailUserChi(), UserRoleNameUser); 
		
		administration.clickMenuOgranization();
		administration.clickMenuSites();
		sites.clickButtonManageSite("VNM");
		formDelegateSite.chooseUserDelegate("Vu Khanh Chi");
	    formDelegateSite.waitForFormDelegationDisappear();
		TestLogger.info("6. Log out");
	
	}
	
	

	@AfterMethod(alwaysRun = true)
	public void finishTestCase(Method method) throws InterruptedException {
		// logout
		if (dashboard.isProfileDisplayed() == true) {
			dashboard.logout();
		}
	
		TestLogger.info("====== End Testcase : " + method.getName() + " ======");
	}

	@AfterTest (alwaysRun = true)
	public void dongTrinhDuyet() {
		driver.close();
	}
	
}
