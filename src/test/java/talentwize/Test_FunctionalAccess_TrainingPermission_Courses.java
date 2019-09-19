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
import talentwize.pages.Courses;
import talentwize.pages.Dashboard;
import talentwize.pages.Form_CourseInformation;
import talentwize.pages.Form_CreateCourse;
import talentwize.pages.Form_CreateNewCourse;
import talentwize.pages.HomePage;
import talentwize.pages.Roles;
import talentwize.pages.Users;

public class Test_FunctionalAccess_TrainingPermission_Courses extends TestManager {
	HomePage homePage;
	WebDriver driver;
	PropertyManager propertyManager;
	Dashboard dashboard;
	Administration administration;
	Users users;
	Roles roles;
	String UserRoleName;
	Courses courses;
	Form_CourseInformation formCourseInformation;
	Form_CreateNewCourse formCreateNewCourse;

	public static String nameOfCourse = "ABBBB";;

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
		courses = new Courses(driver);
		formCreateNewCourse = new Form_CreateNewCourse(driver);
		formCourseInformation = new Form_CourseInformation(driver);
		homePage.moLinkWeb(propertyManager.getURL_TalentWize());

	}

	@BeforeMethod
	public void PrintNameTestCase(Method method) {
		TestLogger.info("====== Begin Testcase : " + method.getName() + " ========");
	}

	@Test(priority = 1)
	public void TT_1177() throws InterruptedException {

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
		UserRoleName = "Training_Permission_Courses" + TienIch.taoRandomSo(3);
		roles.createUserRoleNameWithRoleTypeAdmin(UserRoleName);
		TestLogger.info("+Uncheck on Training Permission - Courses| Read\r\n"
				+ "+Check on Training Permission - Courses | Create");
		roles.uncheckbox_Read_TrainingPermission_Course();
		roles.checkbox_Create_TrainingPermission_Course();
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

		TestLogger.info("1. Open Training\r\n" + "2. Open Courses");
		administration.clickMenuTraining();
		administration.clickSubMenuCourses();

		if (courses.areLinkCourseNamesClickable() == true) {
			courses.clickFistLinkCourseName();

			formCourseInformation.sleep(5);

			if (formCourseInformation.isLabelCourseInformationDisplayed() == true) {
				setStatusTest("Pass", "User can see /do:\r\n" + "1. Data table\r\n"
						+ "2. Course Name hyperlink >> Course Information");

			} else {

				setStatusTest("Fail", "User can NOT see /do:\r\n" + "1. Data table\r\n"
						+ "2. Course Name hyperlink >> Course Information");
			}

			if (formCourseInformation.isBtnEditDisplayed() == false) {
				setStatusTest("pass",
						"User cannot see/do: 4. Course Name hyperlink >> Course Information >> Edit button");
			} else {
				setStatusTest("fail",
						"User STILL CAN see/do: 4. Course Name hyperlink >> Course Information >> Edit button");
			}

			formCourseInformation.clickButtonClose();

		}

		else {
			setStatusTest("Fail", "User can NOT see /do:\\r\\n\" + \r\n" + "\"1. Data table\\r\\n\" + \r\n"
					+ "\"2. Course Name hyperlink ");
		}

		if (courses.isIcoDeleteDisplayed() == false) {
			setStatusTest("pass", "User cannot see/do:\r\n" + "" + "2. Delete function");
		} else {
			setStatusTest("fail", "User STILL can see/do:\r\n" + "2. Delete function");
		}

		if (courses.isBtnAssignDisplayed() == false) {
			setStatusTest("pass", "User cannot see/do:\r\n" + "" + "3. Assign button");
		} else {
			setStatusTest("fail", "User STILL can see/do:\r\n" + "3. Assign button");
		}

		if (courses.isbtnCreateDisplayed() == true) {
			setStatusTest("pass", "User can see/do:\r\n" + "1. Create button");
		} else {
			setStatusTest("fail", "User STILL can NOT see/do:\r\n" + "1. Create button");
		}

		courses.clickButtonCreate();

		formCreateNewCourse.CreateNewCourse(nameOfCourse);

		if (courses.isMsgCreatedSucessDisplayed() == true) {
			setStatusTest("pass", "Displays msg \"Course created successfully\"");
		} else {
			setStatusTest("fail", "Does Not displays msg \"Course created successfully\"");
		}

	}

	@Test(priority = 2)
	public void TT_1175() throws InterruptedException {

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
		UserRoleName = "Training_Permission_Courses" + TienIch.taoRandomSo(3);
		roles.createUserRoleNameWithRoleTypeAdmin(UserRoleName);
		TestLogger.info("+Uncheck on Training Permission - Courses| Read\r\n"
				+ "+Check on Training Permission - Courses | Read");
		roles.uncheckbox_Read_TrainingPermission_Course();
		roles.checkbox_Read_TrainingPermission_Course();

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

		TestLogger.info("1. Open Training\r\n" + "2. Open Courses");
		administration.clickMenuTraining();
		administration.clickSubMenuCourses();

		if (courses.areLinkCourseNamesClickable() == true) {
			courses.clickFistLinkCourseName();

			if (formCourseInformation.isLabelCourseInformationDisplayed() == true) {
				setStatusTest("Pass", "User can see /do:\r\n" + "1. Data table\r\n"
						+ "2. Course Name hyperlink >> Course Information");

			} else {

				setStatusTest("Fail", "User can NOT see /do:\r\n" + "1. Data table\r\n"
						+ "2. Course Name hyperlink >> Course Information");
			}

			if (formCourseInformation.isBtnEditDisplayed() == false) {
				setStatusTest("pass",
						"User cannot see/do: 4. Course Name hyperlink >> Course Information >> Edit button");
			} else {
				setStatusTest("fail",
						"User STILL CAN see/do: 4. Course Name hyperlink >> Course Information >> Edit button");
			}

			formCourseInformation.clickButtonClose();
		}

		else {
			setStatusTest("Fail", "User can NOT see /do:\\r\\n\" + \r\n" + "\"1. Data table\\r\\n\" + \r\n"
					+ "\"2. Course Name hyperlink ");
		}

		if (courses.isbtnCreateDisplayed() == false) {
			setStatusTest("pass", "User cannot see/do:\r\n" + "1. Create button");
		} else {
			setStatusTest("fail", "User STILL can see/do:\r\n" + "1. Create button");
		}

		if (courses.isIcoDeleteDisplayed() == false) {
			setStatusTest("pass", "User cannot see/do:\r\n" + "" + "2. Delete function");
		} else {
			setStatusTest("fail", "User STILL can see/do:\r\n" + "2. Delete function");
		}

		if (courses.isBtnAssignDisplayed() == false) {
			setStatusTest("pass", "User cannot see/do:\r\n" + "" + "3. Assign button");
		} else {
			setStatusTest("fail", "User STILL can see/do:\r\n" + "3. Assign button");
		}

	}

	@Test(priority = 3)
	public void TT_1176() throws InterruptedException {

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
		UserRoleName = "Training_Permission_Courses" + TienIch.taoRandomSo(3);
		roles.createUserRoleNameWithRoleTypeAdmin(UserRoleName);
		TestLogger.info("+Uncheck on Training Permission - Courses| Read\r\n"
				+ "+Check on Training Permission - Courses | Update");
		roles.uncheckbox_Read_TrainingPermission_Course();
		roles.checkbox_Update_TrainingPermission_Course();

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

		TestLogger.info("1. Open Training\r\n" + "2. Open Courses");
		administration.clickMenuTraining();
		administration.clickSubMenuCourses();

		if (courses.isIcoDeleteDisplayed() == false) {
			setStatusTest("pass", "User cannot see/do:\r\n" + "" + "2. Delete function");
		} else {
			setStatusTest("fail", "User STILL can see/do:\r\n" + "2. Delete function");
		}

		if (courses.isbtnCreateDisplayed() == false) {
			setStatusTest("pass", "User cannot see/do:\r\n" + "1. Create button");
		} else {
			setStatusTest("fail", "User STILL can see/do:\r\n" + "1. Create button");
		}

		if (courses.isBtnAssignDisplayed() == true) {
			setStatusTest("pass", "User can see/do:\r\n" + "" + "3. Assign button");
		} else {
			setStatusTest("fail", "User STILL can NOT see/do:\r\n" + "3. Assign button");
		}

		if (courses.areLinkCourseNamesClickable() == true) {
			courses.clickFistLinkCourseName();

			if (formCourseInformation.isBtnEditDisplayed() == true) {
				setStatusTest("pass", "User can see /do:\r\n" + "" + ""
						+ "3. Program Name hyperlink >> Program Information >> Edit button ");
			} else {
				setStatusTest("fail", "User can NOT see /do:\r\n" + "" + ""
						+ "3. Program Name hyperlink >> Program Information >> Edit button ");
			}

			formCourseInformation.clickButtonEdit();
			formCourseInformation.chooseVersion();
			formCourseInformation.clickButtonSave();

			if (formCourseInformation.isMsgUpdateSuccessfulDisplayed() == true) {
				setStatusTest("Pass", "Displays msg \"Course updated successfully\"");
			} else {
				setStatusTest("Fail", "DOES NOT Display msg \"Course updated successfully\"");
			}

		}

		else {
			setStatusTest("fail", "links of Course names are not able to click");
		}

	}

	@Test(priority = 4)
	public void TT_1185() throws InterruptedException {

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
		UserRoleName = "Training_Permission_Courses" + TienIch.taoRandomSo(3);
		roles.createUserRoleNameWithRoleTypeAdmin(UserRoleName);
		TestLogger.info("+Uncheck on Training Permission - Courses| Read\r\n"
				+ "+Check on Training Permission - Courses | Delete");
		roles.uncheckbox_Read_TrainingPermission_Course();
		roles.checkbox_Delete_TrainingPermission_Course();

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

		TestLogger.info("1. Open Training\r\n" + "2. Open Courses");
		administration.clickMenuTraining();
		administration.clickSubMenuCourses();

		if (courses.isIcoDeleteDisplayed() == true) {
			setStatusTest("pass", "User cannot see/do:\r\n" + "" + "2. Delete function");
		} else {
			setStatusTest("fail", "User STILL can see/do:\r\n" + "2. Delete function");
		}

		if (courses.isbtnCreateDisplayed() == false) {
			setStatusTest("pass", "User cannot see/do:\r\n" + "1. Create button");
		} else {
			setStatusTest("fail", "User STILL can see/do:\r\n" + "1. Create button");
		}

		if (courses.isBtnAssignDisplayed() == false) {
			setStatusTest("pass", "User can NOT see/do:\r\n" + "" + "3. Assign button");
		} else {
			setStatusTest("fail", "User STILL can see/do:\r\n" + "3. Assign button");
		}

		if (courses.areLinkCourseNamesClickable() == true) {
			courses.clickFistLinkCourseName();

			if (formCourseInformation.isBtnEditDisplayed() == false) {
				setStatusTest("pass", "User can NOT see /do:\r\n" + "" + ""
						+ "3. Program Name hyperlink >> Program Information >> Edit button ");
			} else {
				setStatusTest("fail", "User still can  see /do:\r\n" + "" + ""
						+ "3. Program Name hyperlink >> Program Information >> Edit button ");
			}

		}

		else {
			setStatusTest("fail", "links of Course names are not able to click");
		}

		courses.searchCourse(nameOfCourse);
		courses.deleteCourse(nameOfCourse);

		if (courses.isMsgDeletedSucessDisplayed() == true) {
			setStatusTest("pass", "Displays msg \"Delete course successfully!\"");
		} else {
			setStatusTest("fail", "Does Not Display msg \"Delete course successfully!\"");
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
	public void closeBrowser() {
		driver.close();
	}
}
