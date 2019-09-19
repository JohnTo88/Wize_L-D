package talentwize.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import Ulties.TestLogger;
import controller.WebActions;

public class Roles extends WebActions {

	public Roles(WebDriver driver) {
		super(driver);
	}

	// list of checkbox READ which are marked as CHECKED
	By checkBoxs_Read_Checked = By.xpath(
			"(.//*[normalize-space(text()) and normalize-space(.)='Read'])/preceding-sibling::span[@class='icon icon-checkmark3 text-primary fs-20']");
	// list of All checkbox which are marked as CHECKED
	By checkBoxs_Checked = By.xpath("//span[@class='icon icon-checkmark3 text-primary fs-20']");
	// list of checkbox READ which are marked as UNCHECKED
	By checkBoxs_Read_Unchecked = By.xpath(
			"(.//*[normalize-space(text()) and normalize-space(.)='Read'])/preceding-sibling::span[@class='icon icon-checkmark3 text-primary fs-20 ng-hide']//parent::label");
	By btnSave = By.xpath("//button[text()='Save']");
	By btnBack = By.xpath("//button[text()='Back']");

	// ========== Administration - User Management - Users
	// ========================================
	By checkBox_Create_Row_1 = By
			.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Update'])[1]/following::label[1]");
	By checkBox_Update_Row_1 = By
			.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Read'])[1]/following::label[1]");
	By checkBox_Delete_Row_1 = By
			.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Create'])[2]/following::label[1]");
	By UnCheckBox_Read_Row_1 = By.xpath(
			"(.//*[normalize-space(text()) and normalize-space(.)='Administration - User Management - Users'])[1]/following::span[1]");

	// =========== Administration - User Management - Roles
	// =======================================
	By checkBox_Delete_Row_2 = By
			.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Create'])[3]/following::label[1]");

	By checkBox_Read_Row_2 = By.xpath(
			"(.//*[normalize-space(text()) and normalize-space(.)='Administration - User Management - Roles'])[1]/following::label[1]");

	By checkbox_Update_Row_2 = By
			.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Read'])[2]/following::label[1]");

	By UnCheckBox_Read_Row_2 = By.xpath(
			"(.//*[normalize-space(text()) and normalize-space(.)='Administration - User Management - Roles'])[1]/following::span[1]");

	By checkBox_Create_Row_2 = By
			.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Update'])[2]/following::label[1]");

	// ===================== Administration - Audit Log
	// ===============================
	By checkBox_Read_Row_3 = By.xpath("(//label[contains(.,'Read')])[3]");
	By UnCheckBox_Read_Row_3 = By.xpath("(//span[@ng-show='permission.allowReading'])[3]");

	// ==================== Import Member to Project ====================

	By checkbox_Read_ImportMemberToProject = By.xpath(
			"(.//*[normalize-space(text()) and normalize-space(.)='Import Member to Project'])[1]/following::label[1]");
	By uncheckbox_Read_ImportMemberToProject = By.xpath(
			"(.//*[normalize-space(text()) and normalize-space(.)='Import Member to Project'])[1]/following::span[1]");

	public void checkbox_Read_ImportMemberToProject() {
		clickByJavaScript(checkbox_Read_ImportMemberToProject);
	}

	public void uncheckbox_Read_ImportMemberToProject() {
		clickByJavaScript(uncheckbox_Read_ImportMemberToProject);
	}

	// =====================Administration - Audit Log - Authentication Log
	// ============
	By checkBox_Read_Row_4 = By.xpath("(//label[contains(.,'Read')])[4]");
	By checkBox_Read_Update_4 = By.xpath("(//label[contains(.,'Update')])[4]");
	By UnCheckBox_Read_Row_4 = By.xpath("(//span[@ng-show='permission.allowReading'])[4]");

	// ===================== Administration - Audit Log - AutoJob
	// ======================
	By checkBox_Read_Row_5 = By.xpath("(//label[contains(.,'Read')])[5]");
	By checkBox_Read_Update_5 = By.xpath("(//label[contains(.,'Update')])[5]");
	By UnCheckBox_Read_Row_5 = By.xpath("(//span[@ng-show='permission.allowReading'])[5]");

	// ===================== Administration - Organization - Sites
	// =====================
	By checkBox_Read_Row_6 = By.xpath("(//label[contains(.,'Read')])[6]");
	By checkBox_Read_Update_6 = By.xpath("(//label[contains(.,'Update')])[6]");
	By checkBox_Read_Delete_6 = By.xpath("(//label[contains(.,'Delete')])[6]");
	By checkBox_Create_Row_6 = By.xpath("(//label[contains(.,'Create')])[6]");

	// ===================== Administration - Organization - Units
	// ======================
	By checkBox_Read_Row_7 = By.xpath("(//label[contains(.,'Read')])[7]");
	By checkBox_Read_Update_7 = By.xpath("(//label[contains(.,'Update')])[7]");
	By checkBox_Read_Delete_7 = By.xpath("(//label[contains(.,'Delete')])[7]");
	By checkBox_Create_Row_7 = By.xpath("(//label[contains(.,'Create')])[7]");
	By UnCheckBox_Read_Row_7 = By.xpath("(//span[@ng-show='permission.allowReading'])[7]");

	// ===================== Administration - Organization - JobTitle
	// ===================
	By checkBox_Read_Row_8 = By.xpath("(//label[contains(.,'Read')])[8]");
	By checkBox_Read_Delete_8 = By.xpath("(//label[contains(.,'Delete')])[8]");
	By checkBox_Create_Row_8 = By.xpath("(//label[contains(.,'Create')])[8]");
	By checkBox_Read_Update_8 = By.xpath("(//label[contains(.,'Update')])[8]");
	By UnCheckBox_Read_Row_8 = By.xpath("(//span[@ng-show='permission.allowReading'])[8]");

	// =====================Administration - Configuration - Default
	// Settings============
	By checkbox_Read_Configuration_Default = By.xpath(
			"(.//*[normalize-space(text()) and normalize-space(.)='Administration - Configuration - Default Settings'])[1]/following::label[1]");
	By unCheckbox_Read_Configuration_Default = By.xpath(
			"(.//*[normalize-space(text()) and normalize-space(.)='Administration - Configuration - Default Settings'])[1]/following::span[1]");
	By checkbox_Update_Configuration_Default = By.xpath(
			"(.//*[normalize-space(text()) and normalize-space(.)='Administration - Configuration - Default Settings'])[1]/following::label[2]");
	By unCheckbox_Update_Configuration_Default = By.xpath(
			"(.//*[normalize-space(text()) and normalize-space(.)='Administration - Configuration - Default Settings'])[1]/following::span[2]");

	public void checkbox_Read_Configuration_Default() {
		clickByJavaScript(checkbox_Read_Configuration_Default);
	}

	public void unCheckbox_Read_Configuration_Default() {
		clickByJavaScript(unCheckbox_Read_Configuration_Default);
	}

	public void checkbox_Update_Configuration_Default() {
		clickByJavaScript(checkbox_Update_Configuration_Default);
	}

	public void unCheckbox_Update_Configuration_Default() {
		clickByJavaScript(unCheckbox_Update_Configuration_Default);
	}

	// =====================Administration - Configuration - Domain Settings
	// ============
	By checkBox_Read_Row_10 = By.xpath("(//label[contains(.,'Read')])[10]");
	By checkBox_Read_Delete_10 = By.xpath("(//label[contains(.,'Delete')])[10]");
	By checkBox_Create_Row_10 = By.xpath("(//label[contains(.,'Create')])[10]");
	By checkBox_Read_Update_10 = By.xpath("(//label[contains(.,'Update')])[10]");
	By UnCheckBox_Read_Row_10 = By.xpath("(//span[@ng-show='permission.allowReading'])[10]");

	// ===================== Administration - Configuration - Domain Settings
	// ============
	By checkBox_Read_Row_11 = By.xpath("(//label[contains(.,'Read')])[11]");
	By checkBox_Read_Update_11 = By.xpath("(//label[contains(.,'Update')])[11]");
	By UnCheckBox_Read_Row_11 = By.xpath("(//span[@ng-show='permission.allowReading'])[11]");

	// ==================== Administration - Configuration - Select Inputs
	// ==============
	By checkBox_Read_Row_12 = By.xpath("(//label[contains(.,'Read')])[12]");
	By checkBox_Read_Update_12 = By.xpath("(//label[contains(.,'Update')])[12]");
	By UnCheckBox_Read_Row_12 = By.xpath("(//span[@ng-show='permission.allowReading'])[12]");

	// ==================== Administration - Configuration - Notifications
	// =============
	By checkBox_Read_Row_13 = By.xpath("(//label[contains(.,'Read')])[13]");
	By checkBox_Read_Delete_13 = By.xpath("(//label[contains(.,'Delete')])[13]");
	By checkBox_Create_Row_13 = By.xpath("(//label[contains(.,'Create')])[13]");
	By checkBox_Read_Update_13 = By.xpath("(//label[contains(.,'Update')])[13]");

	// ==================== Administration - Configuration - Mentors
	// ====================
	By checkBox_Read_Row_14 = By.xpath("(//label[contains(.,'Read')])[14]");
	By checkBox_Read_Update_14 = By.xpath("(//label[contains(.,'Update')])[14]");
	By UnCheckBox_Read_Row_14 = By.xpath("(//span[@ng-show='permission.allowReading'])[14]");

	// ===================== Administration - Configuration - Broadcast
	// ==================
	By checkBox_Read_Row_15 = By.xpath("(//label[contains(.,'Read')])[15]");
	By checkBox_Read_Delete_15 = By.xpath("(//label[contains(.,'Delete')])[15]");
	By checkBox_Create_Row_15 = By.xpath("(//label[contains(.,'Create')])[15]");
	By checkBox_Read_Update_15 = By.xpath("(//label[contains(.,'Update')])[15]");
	By UnCheckBox_Read_Row_15 = By.xpath("(//span[@ng-show='permission.allowReading'])[15]");

	// ===================== Administration - Configuration - Custom Fields
	// ===============
	By checkBox_Read_Row_16 = By.xpath("(//label[contains(.,'Read')])[16]");
	By checkBox_Read_Delete_16 = By.xpath("(//label[contains(.,'Delete')])[16]");
	By checkBox_Create_Row_16 = By.xpath("(//label[contains(.,'Create')])[16]");
	By checkBox_Read_Update_16 = By.xpath("(//label[contains(.,'Update')])[16]");
	By UnCheckBox_Read_Row_16 = By.xpath("(//span[@ng-show='permission.allowReading'])[16]");

	// ===================== Administration - Configuration - Custom Fields
	// ===============
	By checkBox_Read_Row_17 = By.xpath("(//label[contains(.,'Read')])[17]");
	By checkBox_Read_Update_17 = By.xpath("(//label[contains(.,'Update')])[17]");
	By UnCheckBox_Read_Row_17 = By.xpath("(//span[@ng-show='permission.allowReading'])[17]");

	// ===================== Administration - Configuration - Azure LDAP
	// ==================
	By checkBox_Read_Row_18 = By.xpath("(//label[contains(.,'Read')])[18]");
	By checkBox_Read_Update_18 = By.xpath("(//label[contains(.,'Update')])[18]");
	By UnCheckBox_Read_Row_18 = By.xpath("(//span[@ng-show='permission.allowReading'])[18]");

	// ===================== Administration - Configuration - Power BI
	// ====================
	By checkBox_Read_Row_19 = By.xpath("(//label[contains(.,'Read')])[19]");
	By checkBox_Read_Update_19 = By.xpath("(//label[contains(.,'Update')])[19]");
	By UnCheckBox_Read_Row_19 = By.xpath("(//span[@ng-show='permission.allowReading'])[19]");

	// ===================== Administration - Configuration - Publish Filter
	// ==============
	By checkBox_Read_Row_20 = By.xpath("(//label[contains(.,'Read')])[20]");

	// ======== Leave - Configuration
	// ===================================================
	By checkBox_Read_Leave_Configuration = By.xpath(
			"(.//*[normalize-space(text()) and normalize-space(.)='Leave - Configuration'])[1]/following::label[1]");
	By checkBox_Read_Update_Leave_Configuration = By.xpath(
			"(.//*[normalize-space(text()) and normalize-space(.)='Leave - Configuration'])[1]/following::label[2]");
	By checkBox_Read_Create_Leave_Configuration = By.xpath(
			"(.//*[normalize-space(text()) and normalize-space(.)='Leave - Configuration'])[1]/following::label[3]");
	By checkBox_Read_Delete_Leave_Configuration = By.xpath(
			"(.//*[normalize-space(text()) and normalize-space(.)='Leave - Configuration'])[1]/following::label[4]");

	public void choose_Checkbox_Read_Leave_Configurations() {
		clickByJavaScript(checkBox_Read_Leave_Configuration);
	}

	public void choose_Checkbox_Create_Leave_Configurations() {
		clickByJavaScript(checkBox_Read_Create_Leave_Configuration);
	}

	public void choose_Checkbox_Update_Leave_Configurations() {
		clickByJavaScript(checkBox_Read_Update_Leave_Configuration);
	}

	public void choose_Checkbox_Delete_Leave_Configurations() {
		clickByJavaScript(checkBox_Read_Delete_Leave_Configuration);
	}
	// ============= Leave - Management
	// ============================================

	By checkBox_Read_Leave_Management = By.xpath(
			"(.//*[normalize-space(text()) and normalize-space(.)='Leave - Management'])[1]/following::label[1]");
	By checkBox_Update_Leave_Management = By.xpath(
			"(.//*[normalize-space(text()) and normalize-space(.)='Leave - Management'])[1]/following::label[2]");
	By checkBox_Delete_Leave_Management = By.xpath(
			"(.//*[normalize-space(text()) and normalize-space(.)='Leave - Management'])[1]/following::label[4]");
	By checkBox_Create_Leave_Management = By.xpath(
			"(.//*[normalize-space(text()) and normalize-space(.)='Leave - Management'])[1]/following::label[3]");

	public void choose_UnCheckbox_Update_Leave_Management() {
		clickByJavaScript(CheckBox_Leave_Management_Update);
	}

	public void choose_UnCheckbox_Create_Leave_Management() {
		clickByJavaScript(CheckBox_Leave_Management_Create);
	}

	public void choose_UnCheckbox_Delete_Leave_Management() {
		clickByJavaScript(CheckBox_Leave_Management_Delete);
	}

	// ============= Leave - Import Balance
	// =========================================
	By checkBox_Read_Leave_ImportBalance = By.xpath(
			"(.//*[normalize-space(text()) and normalize-space(.)='Leave - Import Balance'])[1]/following::label[1]");

	// ========================== Leave Permission =====================
	By unCheckBox_Read_LeaveConfiguration = By.xpath(
			"(.//*[normalize-space(text()) and normalize-space(.)='Leave - Configuration'])[1]/following::span[1]");

	public void click_Uncheckbox_Leave_Configurations() {
		clickByJavaScript(unCheckBox_Read_LeaveConfiguration);
	}

	By unCheckBox_Read_LeaveImportBalance = By.xpath(
			"(.//*[normalize-space(text()) and normalize-space(.)='Leave - Import Balance'])[1]/following::span[1]");
	By unCheckBox_Read_Leave_Calendar = By
			.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Leave - Calendar'])[1]/following::label[1]");
	By unCheckBox_Read_Leave_Calendar_Colleague = By.xpath(
			"(.//*[normalize-space(text()) and normalize-space(.)=concat('Leave - Calendar - Colleague', \"'\", 's leave')])[1]/following::span[1]");
	By unCheckBox_Read_Leave_SetTaken = By
			.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Leave - Set taken'])[1]/following::label[1]");
	By unCheckbox_Read_Leave_RevokeTaken = By.xpath(
			"(.//*[normalize-space(text()) and normalize-space(.)='Leave - Revoke taken'])[1]/following::label[1]");
	By uncheckbox_Read_Leave_Calendar_Colleague = By.xpath(
			"(.//*[normalize-space(text()) and normalize-space(.)=concat('Leave - Calendar - Colleague', \"'\", 's leave')])[1]/following::span[1]");

	public void click_Uncheckbox_Leave_Calendar() {
		clickByJavaScript(unCheckBox_Read_Leave_Calendar);
	}

	public void click_Uncheckbox_Leave_Calendar_Colleague_leave() {
		clickByJavaScript(uncheckbox_Read_Leave_Calendar_Colleague);
	}

	public void click_Uncheckbox_Leave_Set_Taken() {
		clickByJavaScript(unCheckBox_Read_Leave_SetTaken);
	}

	public void click_Uncheckbox_Leave_Revoke_Taken() {
		clickByJavaScript(unCheckbox_Read_Leave_RevokeTaken);
	}

	public void click_Uncheckbox_Leave_ImportBalance() {
		clickByJavaScript(unCheckBox_Read_LeaveImportBalance);
	}

	// ======== My Balance List
	// ===================================================
	By checkBox_Read_Leave_MyBalanceList = By.xpath(
			"(.//*[normalize-space(text()) and normalize-space(.)='Leave - My Balance List'])[1]/following::label[1]");

	By UncheckBox_Read_Leave_MyBalanceList = By.xpath(
			"(.//*[normalize-space(text()) and normalize-space(.)='Leave - My Balance List'])[1]/following::span[1]");

	public void checkBox_Read_Leave_MyBalanceList() {
		clickByJavaScript(checkBox_Read_Leave_MyBalanceList);
	}

	public void UncheckBox_Read_Leave_MyBalanceList() {
		clickByJavaScript(UncheckBox_Read_Leave_MyBalanceList);
	}
	
	
	// ========== Leave - Calendar & Leave - Calendar - Colleague's leave ================
	By checkbox_unRead_Leave_Calendar = By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Leave - Calendar'])[1]/following::span[1]");
	By checkbox_Read_Leave_Calendar = By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Leave - Calendar'])[1]/following::label[1]");

	By checkbox_unRead_Leave_Calendar_Colleague = By.xpath("(.//*[normalize-space(text()) and normalize-space(.)=concat('Leave - Calendar - Colleague', \"'\", 's leave')])[1]/following::span[1]");
	By checkbox_Read_Leave_Calendar_Colleague = By.xpath("(.//*[normalize-space(text()) and normalize-space(.)=concat('Leave - Calendar - Colleague', \"'\", 's leave')])[1]/following::label[1]");

	public void checkbox_unRead_Leave_Calendar() {
		clickByJavaScript(checkbox_unRead_Leave_Calendar);
	}

	public void checkbox_Read_Leave_Calendar() {
		clickByJavaScript(checkbox_Read_Leave_Calendar);
	}
	
	public void checkbox_unRead_Leave_Calendar_Colleague() {
		clickByJavaScript(checkbox_unRead_Leave_Calendar_Colleague);
	}

	public void checkbox_Read_Leave_Calendar_Colleague() {
		clickByJavaScript(checkbox_Read_Leave_Calendar_Colleague);
	}
	
	// ========== Data Access ==========================================
	By cbxSite = By.xpath("(//span[contains(@class,'icon icon-checkmark3 text-primary fs-20')])[21]");
	By cbxUnit = By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Unit'])[1]/preceding::label[1]");
	By cbxProject = By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Project'])[1]/preceding::label[1]");
	By cbxReportTo = By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Report To'])[1]/preceding::label[1]");
	By nameOfDataAccess = By.xpath("(//td[@class='ng-binding'])[2]");

	// =========== Employee List Permission =============================
	By unCheckbox_ViewEmployees = By.xpath("(//span[@ng-show='permission.permissionValue'])[1]");
	By checkbox_ViewEmployees = By.xpath("//label[contains(.,'View Employees')]");
	By unCheckbox_AddEmployees = By.xpath("(//span[@ng-show='permission.permissionValue'])[2]");
	By checkbox_AddEmployees = By.xpath("//label[contains(.,'Add Employees')]");
	By unCheckbox_DeleteEmployees = By.xpath("(//span[@ng-show='permission.permissionValue'])[3]");
	By checkbox_DeleteEmployees = By.xpath("//label[contains(.,'Delete Employees')]");
	By unCheckBbox_UpdateEmployeeInform = By.xpath("(//span[contains(.,'Update Employees Information')]");
	By checkbox_Update_EmployeesInform = By.xpath("//label[contains(.,'Update Employees Information')]");
	By checkbox_ED_TerminateEmployees = By.xpath("//label[contains(.,'ED - Terminate Employees')]");
	By checkboxViewEmployees = By.xpath(
			"(.//*[normalize-space(text()) and normalize-space(.)='Delete'])/following::span[text()='View Employees']");

	public void uncheck_View_Employees() {
		clickByJavaScript(unCheckbox_ViewEmployees);
	}

	public void check_View_Employees() {
		clickByJavaScript(checkbox_ViewEmployees);
	}

	public void check_Add_Employees() {
		clickByJavaScript(checkbox_AddEmployees);
	}

	public void check_Delete_Employees() {
		clickByJavaScript(checkbox_DeleteEmployees);
	}

	public void check_Update_EmployeeInformation() {
		clickByJavaScript(checkbox_Update_EmployeesInform);
	}

	public void uncheck_Ed_TerminateEmployee() {
		clickByJavaScript(checkbox_ED_TerminateEmployees);
	}

	public void uncheck_Add_Employees() {
		clickByJavaScript(unCheckbox_AddEmployees);
	}

	public void uncheck_Delete_Employees() {
		clickByJavaScript(unCheckbox_DeleteEmployees);
	}

	public void uncheck_Update_Employees_Information() {
		clickByJavaScript(unCheckBbox_UpdateEmployeeInform);
	}

	public void check_Ed_TerminateEmployees() {
		clickByJavaScript(checkbox_ED_TerminateEmployees);
	}

	// ============= ED - Personal Details ================================
	By unCheckBox_Update_ED_PersonalDetails = By.xpath(
			"(.//*[normalize-space(text()) and normalize-space(.)='ED - Personal Details'])[1]/following::span[3]");

	public void uncheck_Update_ED_PersonalDetails() {
		clickByJavaScript(unCheckBox_Update_ED_PersonalDetails);
	}

	// ============= ED - Contact Details ================================
	By unCheckBox_Update_ED_ContactDetails = By.xpath(
			"(.//*[normalize-space(text()) and normalize-space(.)='ED - Contact Details'])[1]/following::span[3]");
	By unCheckBox_Read_ED_ContactDetails = By.xpath(
			"(.//*[normalize-space(text()) and normalize-space(.)='ED - Contact Details'])[1]/following::span[1]");

	public void uncheck_Update_ED_ContactDetails() {
		clickByJavaScript(unCheckBox_Update_ED_ContactDetails);
	}

	public void uncheck_Read_ED_ContactDetails() {
		clickByJavaScript(unCheckBox_Read_ED_ContactDetails);
	}

	// ====== ED - Other Contacts - Emergency Contact ======================
	By uncheckbox_Read_ED_OtherContacts_Emergency_Contact = By.xpath(
			"(.//*[normalize-space(text()) and normalize-space(.)='ED - Other Contacts - Emergency Contact'])[1]/following::span[1]");
	By uncheckbox_Update_ED_OtherContacts_Emergency_Contact = By.xpath(
			"(.//*[normalize-space(text()) and normalize-space(.)='ED - Other Contacts - Emergency Contact'])[1]/following::span[3]");
	By uncheckbox_Create_ED_OtherContacts_Emergency_Contact = By.xpath(
			"(.//*[normalize-space(text()) and normalize-space(.)='ED - Other Contacts - Emergency Contact'])[1]/following::span[5]");
	By uncheckbox_Delete_ED_OtherContacts_Emergency_Contact = By.xpath(
			"(.//*[normalize-space(text()) and normalize-space(.)='ED - Other Contacts - Emergency Contact'])[1]/following::span[7]");
	By checkbox_Read_ED_OtherContacts_Emergency_Contact = By.xpath(
			"(.//*[normalize-space(text()) and normalize-space(.)='ED - Other Contacts - Emergency Contact'])[1]/following::label[1]");
	By checkbox_Update_ED_OtherContacts_Emergency_Contact = By.xpath(
			"(.//*[normalize-space(text()) and normalize-space(.)='ED - Other Contacts - Emergency Contact'])[1]/following::label[2]");
	By checkbox_Create_ED_OtherContacts_Emergency_Contact = By.xpath(
			"(.//*[normalize-space(text()) and normalize-space(.)='ED - Other Contacts - Emergency Contact'])[1]/following::label[3]");
	By checkbox_Delete_ED_OtherContacts_Emergency_Contact = By.xpath(
			"(.//*[normalize-space(text()) and normalize-space(.)='ED - Other Contacts - Emergency Contact'])[1]/following::label[4]");

	public void uncheck_Create_ED_OtherContacts_Emergency_Contact() {
		clickByJavaScript(uncheckbox_Create_ED_OtherContacts_Emergency_Contact);
	}

	public void uncheck_Read_ED_OtherContacts_Emergency_Contact() {
		clickByJavaScript(uncheckbox_Read_ED_OtherContacts_Emergency_Contact);
	}

	public void check_Read_ED_OtherContacts_Emergency_Contact() {
		clickByJavaScript(checkbox_Read_ED_OtherContacts_Emergency_Contact);
	}

	public void check_Update_ED_OtherContacts_Emergency_Contact() {
		clickByJavaScript(checkbox_Update_ED_OtherContacts_Emergency_Contact);
	}

	public void check_Create_ED_OtherContacts_Emergency_Contact() {
		clickByJavaScript(checkbox_Create_ED_OtherContacts_Emergency_Contact);
	}

	public void check_Delete_ED_OtherContacts_Emergency_Contact() {
		clickByJavaScript(checkbox_Delete_ED_OtherContacts_Emergency_Contact);
	}

	public void uncheck_Delete_ED_OtherContacts_Emergency_Contact() {
		clickByJavaScript(uncheckbox_Delete_ED_OtherContacts_Emergency_Contact);
	}

	//========== Training permission Courses ==============================
	
		By uncheckbox_Read_TrainingPermission_Course = By.xpath(
				"(.//*[normalize-space(text()) and normalize-space(.)='Courses'])[2]/following::span[1]");
		By uncheckbox_Update_TrainingPermission_Course = By.xpath(
				"(.//*[normalize-space(text()) and normalize-space(.)='Courses'])[2]/following::span[3]");
		By uncheckbox_Create_TrainingPermission_Course = By.xpath(
				"(.//*[normalize-space(text()) and normalize-space(.)='Courses'])[2]/following::span[5]");
		By uncheckbox_Delete_TrainingPermission_Course = By.xpath(
				"(.//*[normalize-space(text()) and normalize-space(.)='Courses'])[2]/following::span[7]");
		By checkbox_Read_TrainingPermission_Course = By.xpath(
				"(.//*[normalize-space(text()) and normalize-space(.)='Courses'])[2]/following::label[1]");
		By checkbox_Update_TrainingPermission_Course = By.xpath(
				"(.//*[normalize-space(text()) and normalize-space(.)='Courses'])[2]/following::label[2]");
		By checkbox_Create_TrainingPermission_Course = By.xpath(
				"(.//*[normalize-space(text()) and normalize-space(.)='Courses'])[2]/following::label[3]");
		By checkbox_Delete_TrainingPermission_Course = By.xpath(
				"(.//*[normalize-space(text()) and normalize-space(.)='Courses'])[2]/following::label[4]");

		public void uncheckbox_Read_TrainingPermission_Course() {
			clickByJavaScript(uncheckbox_Read_TrainingPermission_Course);
		}

		public void uncheckbox_Update_TrainingPermission_Course() {
			clickByJavaScript(uncheckbox_Update_TrainingPermission_Course);
		}

		public void uncheckbox_Create_TrainingPermission_Course() {
			clickByJavaScript(uncheckbox_Create_TrainingPermission_Course);
		}

		public void uncheckbox_Delete_TrainingPermission_Course() {
			clickByJavaScript(uncheckbox_Delete_TrainingPermission_Course);
		}

		public void checkbox_Read_TrainingPermission_Course() {
			clickByJavaScript(checkbox_Read_TrainingPermission_Course);
		}

		public void checkbox_Update_TrainingPermission_Course() {
			clickByJavaScript(checkbox_Update_TrainingPermission_Course);
		}
		
		public void checkbox_Create_TrainingPermission_Course() {
			clickByJavaScript(checkbox_Create_TrainingPermission_Course);
		}

		public void checkbox_Delete_TrainingPermission_Course() {
			clickByJavaScript(checkbox_Delete_TrainingPermission_Course);
		}
	
	// =========== ED - Other Contacts - Dependents ========================

	By Uncheckbox_Read_ED_OtherContacts_Dependents = By.xpath(
			"(.//*[normalize-space(text()) and normalize-space(.)='ED - Other Contacts - Dependents'])[1]/following::span[1]");
	By checkbox_Read_ED_OtherContacts_Dependents = By.xpath(
			"(.//*[normalize-space(text()) and normalize-space(.)='ED - Other Contacts - Dependents'])[1]/following::label[1]");
	By checkbox_Update_ED_OtherContacts_Dependents = By.xpath(
			"(.//*[normalize-space(text()) and normalize-space(.)='ED - Other Contacts - Dependents'])[1]/following::label[2]");
	By checkbox_Create_ED_OtherContacts_Dependents = By.xpath(
			"(.//*[normalize-space(text()) and normalize-space(.)='ED - Other Contacts - Dependents'])[1]/following::label[3]");
	By checkbox_Delete_ED_OtherContacts_Dependents = By.xpath(
			"(.//*[normalize-space(text()) and normalize-space(.)='ED - Other Contacts - Dependents'])[1]/following::label[4]");
	By uncheckbox_Create_ED_OtherContacts_Dependents = By.xpath(
			"(.//*[normalize-space(text()) and normalize-space(.)='ED - Other Contacts - Dependents'])[1]/following::span[5]");
	By uncheckbox_Delete_ED_OtherContacts_Dependents = By.xpath(
			"(.//*[normalize-space(text()) and normalize-space(.)='ED - Other Contacts - Dependents'])[1]/following::span[7]");

	public void check_Read_ED_OtherContacts_Dependents() {
		clickByJavaScript(checkbox_Read_ED_OtherContacts_Dependents);
	}

	public void check_Update_ED_OtherContacts_Dependents() {
		clickByJavaScript(checkbox_Update_ED_OtherContacts_Dependents);
	}

	public void check_Create_ED_OtherContacts_Dependents() {
		clickByJavaScript(checkbox_Create_ED_OtherContacts_Dependents);
	}

	public void check_Delete_ED_OtherContacts_Dependents() {
		clickByJavaScript(checkbox_Delete_ED_OtherContacts_Dependents);

	}

	public void uncheck_Create_ED_OtherContacts_Dependents() {
		clickByJavaScript(uncheckbox_Create_ED_OtherContacts_Dependents);
	}

	public void uncheck_Read_ED_OtherContacts_Dependents() {
		clickByJavaScript(Uncheckbox_Read_ED_OtherContacts_Dependents);
	}

	public void uncheck_Delete_ED_OtherContacts_Dependents() {
		clickByJavaScript(uncheckbox_Delete_ED_OtherContacts_Dependents);
	}

	// ============= ED - Other Contacts ====================================

	By uncheck_Read_ED_OtherContacts = By.xpath(
			"(.//*[normalize-space(text()) and normalize-space(.)='ED - Other Contacts'])[1]/following::span[1]");
	By check_Read_ED_OtherContacts = By.xpath(
			"(.//*[normalize-space(text()) and normalize-space(.)='ED - Other Contacts'])[1]/following::label[1]");
	By CheckBox_ED_Other_Contact_Read = By.xpath("(//label[contains(.,'Read')])[24]");

	public void uncheck_Read_ED_OtherContacts() {
		clickByJavaScript(uncheck_Read_ED_OtherContacts);
	}

	public void check_Read_ED_OtherContacts() {
		clickByJavaScript(check_Read_ED_OtherContacts);
	}
    
	// ========= ED - Company Job History ===================================
	By uncheckbox_Read_ED_CompanyJobHisoty = By.xpath(
			"(.//*[normalize-space(text()) and normalize-space(.)='ED - Company Job History'])[1]/following::span[1]");
	By checkBox_Read_ED_CompanyJobHistory = By.xpath(
			"(.//*[normalize-space(text()) and normalize-space(.)='ED - Company Job History'])[1]/following::label[1]");
	By uncheckbox_Update_ED_CompanyJobHisoty = By.xpath(
			"(.//*[normalize-space(text()) and normalize-space(.)='ED - Company Job History'])[1]/following::span[3]");
	By checkBox_Update_ED_CompanyJobHistory = By.xpath(
			"(.//*[normalize-space(text()) and normalize-space(.)='ED - Company Job History'])[1]/following::label[2]");
	By uncheckbox_Create_ED_CompanyJobHisoty = By.xpath(
			"(.//*[normalize-space(text()) and normalize-space(.)='ED - Company Job History'])[1]/following::span[5]");
	By checkBox_Create_ED_CompanyJobHistory = By.xpath(
			"(.//*[normalize-space(text()) and normalize-space(.)='ED - Company Job History'])[1]/following::label[3]");
	By uncheckbox_Delete_ED_CompanyJobHisoty = By.xpath(
			"(.//*[normalize-space(text()) and normalize-space(.)='ED - Company Job History'])[1]/following::span[7]");
	By checkBox_Delete_ED_CompanyJobHistory = By.xpath(
			"(.//*[normalize-space(text()) and normalize-space(.)='ED - Company Job History'])[1]/following::label[4]");

	public void checkbox_Delete_ED_CompanyJobHistory() {
		clickByJavaScript(checkBox_Delete_ED_CompanyJobHistory);
	}

	public void unCheckbox_Delete_ED_CompanyJobHistory() {
		clickByJavaScript(uncheckbox_Delete_ED_CompanyJobHisoty);
	}

	public void checkbox_Update_ED_CompanyJobHistory() {
		clickByJavaScript(checkBox_Update_ED_CompanyJobHistory);
	}

	public void unCheckbox_Update_ED_CompanyJobHistory() {
		clickByJavaScript(uncheckbox_Update_ED_CompanyJobHisoty);
	}

	public void checkbox_Create_ED_CompanyJobHistory() {
		clickByJavaScript(checkBox_Create_ED_CompanyJobHistory);
	}

	public void unCheckbox_Create_ED_CompanyJobHistory() {
		clickByJavaScript(uncheckbox_Create_ED_CompanyJobHisoty);
	}

	public void uncheckbox_Read_ED_CompanyJobHisoty() {
		clickByJavaScript(uncheckbox_Read_ED_CompanyJobHisoty);
	}

	public void checkbox_Read_ED_CompanyJobHisoty() {
		clickByJavaScript(checkBox_Read_ED_CompanyJobHistory);
	}

	// ========= My ED - My Company Job History ======================

	By uncheckbox_Read_My_CompanyJobHisoty = By.xpath(
			"(.//*[normalize-space(text()) and normalize-space(.)='My Company Job History'])[1]/following::span[1]");
	By checkBox_Read_My_CompanyJobHistory = By.xpath(
			"(.//*[normalize-space(text()) and normalize-space(.)='My Company Job History'])[1]/following::label[1]");
	By uncheckbox_Update_My_CompanyJobHisoty = By.xpath(
			"(.//*[normalize-space(text()) and normalize-space(.)='My Company Job History'])[1]/following::span[3]");
	By checkBox_Update_My_CompanyJobHistory = By.xpath(
			"(.//*[normalize-space(text()) and normalize-space(.)='My Company Job History'])[1]/following::label[2]");
	By uncheckbox_Create_My_CompanyJobHisoty = By.xpath(
			"(.//*[normalize-space(text()) and normalize-space(.)='My Company Job History'])[1]/following::span[5]");
	By checkBox_Create_My_CompanyJobHistory = By.xpath(
			"(.//*[normalize-space(text()) and normalize-space(.)='My Company Job History'])[1]/following::label[3]");
	By uncheckbox_Delete_My_CompanyJobHisoty = By.xpath(
			"(.//*[normalize-space(text()) and normalize-space(.)='My Company Job History'])[1]/following::span[7]");
	By checkBox_Delete_My_CompanyJobHistory = By.xpath(
			"(.//*[normalize-space(text()) and normalize-space(.)='My Company Job History'])[1]/following::label[4]");

	public void checkbox_Delete_My_CompanyJobHistory() {
		clickByJavaScript(checkBox_Delete_My_CompanyJobHistory);
	}

	public void unCheckbox_Delete_My_CompanyJobHistory() {
		clickByJavaScript(uncheckbox_Delete_My_CompanyJobHisoty);
	}

	public void checkbox_Update_My_CompanyJobHistory() {
		clickByJavaScript(checkBox_Update_My_CompanyJobHistory);
	}

	public void unCheckbox_Update_My_CompanyJobHistory() {
		clickByJavaScript(uncheckbox_Update_My_CompanyJobHisoty);
	}

	public void checkbox_Create_My_CompanyJobHistory() {
		clickByJavaScript(checkBox_Create_My_CompanyJobHistory);
	}

	public void unCheckbox_Create_My_CompanyJobHistory() {
		clickByJavaScript(uncheckbox_Create_My_CompanyJobHisoty);
	}

	public void uncheckbox_Read_My_CompanyJobHisoty() {
		clickByJavaScript(uncheckbox_Read_My_CompanyJobHisoty);
	}

	public void checkbox_Read_My_CompanyJobHisoty() {
		clickByJavaScript(checkBox_Read_My_CompanyJobHistory);
	}
	
	//=========== Administration - Organization - JobTitle =====================

		By uncheckbox_Read_JobTitle = By.xpath(
				"(.//*[normalize-space(text()) and normalize-space(.)='Administration - Organization - JobTitle'])[1]/following::span[1]");
		By checkBox_Read_JobTitle = By.xpath(
				"(.//*[normalize-space(text()) and normalize-space(.)='Administration - Organization - JobTitle'])[1]/following::label[1]");
		By uncheckbox_Update_JobTitle = By.xpath(
				"(.//*[normalize-space(text()) and normalize-space(.)='Administration - Organization - JobTitle'])[1]/following::span[3]");
		By checkBox_Update_JobTitle = By.xpath(
				"(.//*[normalize-space(text()) and normalize-space(.)='Administration - Organization - JobTitle'])[1]/following::label[2]");
		By uncheckbox_Create_JobTitle = By.xpath(
				"(.//*[normalize-space(text()) and normalize-space(.)='Administration - Organization - JobTitle'])[1]/following::span[5]");
		By checkBox_Create_JobTitle = By.xpath(
				"(.//*[normalize-space(text()) and normalize-space(.)='Administration - Organization - JobTitle'])[1]/following::label[3]");
		By uncheckbox_Delete_JobTitle = By.xpath(
				"(.//*[normalize-space(text()) and normalize-space(.)='Administration - Organization - JobTitle'])[1]/following::span[7]");
		By checkBox_Delete_JobTitle = By.xpath(
				"(.//*[normalize-space(text()) and normalize-space(.)='Administration - Organization - JobTitle'])[1]/following::label[4]");

		public void uncheckbox_Read_JobTitle() {
			clickByJavaScript(uncheckbox_Read_JobTitle);
		}

		public void checkBox_Read_JobTitle() {
			clickByJavaScript(checkBox_Read_JobTitle);
		}

		public void uncheckbox_Update_JobTitle() {
			clickByJavaScript(uncheckbox_Update_JobTitle);
		}

		public void checkBox_Update_JobTitle() {
			clickByJavaScript(checkBox_Update_JobTitle);
		}

		public void uncheckbox_Create_JobTitle() {
			clickByJavaScript(uncheckbox_Create_JobTitle);
		}

		public void checkBox_Create_JobTitle() {
			clickByJavaScript(checkBox_Create_JobTitle);
		}

		public void uncheckbox_Delete_JobTitle() {
			clickByJavaScript(uncheckbox_Delete_JobTitle);
		}

		public void checkBox_Delete_JobTitle() {
			clickByJavaScript(checkBox_Delete_JobTitle);
		}

	// ========= ED - Qualification ===========================================
	By uncheckbox_Read_ED_Qualification = By
			.xpath("(.//*[normalize-space(text()) and normalize-space(.)='ED - Qualification'])[1]/following::span[1]");
	By checkBox_Read_ED_Qualification = By.xpath(
			"(.//*[normalize-space(text()) and normalize-space(.)='ED - Qualification'])[1]/following::label[1]");
	By uncheckbox_Update_ED_Qualification = By
			.xpath("(.//*[normalize-space(text()) and normalize-space(.)='ED - Qualification'])[1]/following::span[2]");
	By checkBox_Update_ED_Qualification = By.xpath(
			"(.//*[normalize-space(text()) and normalize-space(.)='ED - Qualification'])[1]/following::label[2]");
	By uncheckbox_Create_ED_Qualification = By.xpath(
			"(.//*[normalize-space(text()) and normalize-space(.)='ED - Qualification'])[1]/following::label[3]");
	By checkBox_Create_ED_Qualification = By.xpath(
			"(.//*[normalize-space(text()) and normalize-space(.)='ED - Qualification'])[1]/following::label[3]");
	By uncheckbox_Delete_ED_Qualification = By
			.xpath("(.//*[normalize-space(text()) and normalize-space(.)='ED - Qualification'])[1]/following::span[4]");
	By checkBox_Delete_ED_Qualification = By.xpath(
			"(.//*[normalize-space(text()) and normalize-space(.)='ED - Qualification'])[1]/following::label[4]");

	public void uncheck_Read_ED_Qualification() {
		clickByJavaScript(uncheckbox_Read_ED_Qualification);

	}

	public void check_Read_ED_Qualification() {
		clickByJavaScript(checkBox_Read_ED_Qualification);
	}

	public void uncheck_Update_ED_Qualification() {
		clickByJavaScript(uncheckbox_Update_ED_Qualification);
	}

	public void check_Update_ED_Qualification() {
		clickByJavaScript(checkBox_Update_ED_Qualification);
	}

	public void uncheck_Create_ED_Qualification() {
		clickByJavaScript(uncheckbox_Create_ED_Qualification);
	}

	public void check_Create_ED_Qualification() {
		waitForElementClickable(5, checkBox_Create_ED_Qualification);
		clickByJavaScript(checkBox_Create_ED_Qualification);
	}

	public void uncheck_Delete_ED_Qualification() {
		clickByJavaScript(uncheckbox_Delete_ED_Qualification);
	}

	public void check_Delete_ED_Qualification() {
		clickByJavaScript(checkBox_Delete_ED_Qualification);
	}

	// ========= My - Qualification ===========================================
	By uncheckbox_Read_My_Qualification = By
			.xpath("(.//*[normalize-space(text()) and normalize-space(.)='My Qualification'])[1]/following::span[1]");
	By checkBox_Read_My_Qualification = By
			.xpath("(.//*[normalize-space(text()) and normalize-space(.)='My Qualification'])[1]/following::label[1]");
	By uncheckbox_Update_My_Qualification = By
			.xpath("(.//*[normalize-space(text()) and normalize-space(.)='My Qualification'])[1]/following::span[2]");
	By checkBox_Update_My_Qualification = By
			.xpath("(.//*[normalize-space(text()) and normalize-space(.)='My Qualification'])[1]/following::label[2]");
	By uncheckbox_Create_My_Qualification = By
			.xpath("(.//*[normalize-space(text()) and normalize-space(.)='My Qualification'])[1]/following::label[3]");
	By checkBox_Create_My_Qualification = By
			.xpath("(.//*[normalize-space(text()) and normalize-space(.)='My Qualification'])[1]/following::label[3]");
	By uncheckbox_Delete_My_Qualification = By
			.xpath("(.//*[normalize-space(text()) and normalize-space(.)='My Qualification'])[1]/following::span[4]");
	By checkBox_Delete_My_Qualification = By
			.xpath("(.//*[normalize-space(text()) and normalize-space(.)='My Qualification'])[1]/following::label[4]");

	public void uncheck_Read_My_Qualification() {
		clickByJavaScript(uncheckbox_Read_My_Qualification);

	}

	public void check_Read_My_Qualification() {
		clickByJavaScript(checkBox_Read_My_Qualification);
	}

	public void uncheck_Update_My_Qualification() {
		clickByJavaScript(uncheckbox_Update_My_Qualification);
	}

	public void check_Update_My_Qualification() {
		clickByJavaScript(checkBox_Update_My_Qualification);
	}

	public void uncheck_Create_My_Qualification() {
		clickByJavaScript(uncheckbox_Create_My_Qualification);
	}

	public void check_Create_My_Qualification() {
		waitForElementClickable(5, checkBox_Create_ED_Qualification);
		clickByJavaScript(checkBox_Create_My_Qualification);
	}

	public void uncheck_Delete_My_Qualification() {
		clickByJavaScript(uncheckbox_Delete_My_Qualification);
	}

	public void check_Delete_My_Qualification() {
		clickByJavaScript(checkBox_Delete_My_Qualification);
	}

	// ========== Leave - Management
	// ============================================

	By unCheckbox_Read_LeaveManagement = By
			.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Leave - Management'])[1]/following::span[1]");
	By CheckBox_Leave_Management_Read = By.xpath(
			"(.//*[normalize-space(text()) and normalize-space(.)='Leave - Management'])[1]/following::label[1]");
	By CheckBox_Leave_Management_Update = By.xpath(
			"(.//*[normalize-space(text()) and normalize-space(.)='Leave - Management'])[1]/following::label[2]");
	By CheckBox_Leave_Management_Create = By.xpath(
			"(.//*[normalize-space(text()) and normalize-space(.)='Leave - Management'])[1]/following::label[3]");
	By CheckBox_Leave_Management_Delete = By.xpath(
			"(.//*[normalize-space(text()) and normalize-space(.)='Leave - Management'])[1]/following::label[4]");

	By checkbox_Read_LeaveManagement = By.xpath(
			"(.//*[normalize-space(text()) and normalize-space(.)='Leave - Management'])[1]/following::label[1]");

	public void choose_UnCheckbox_Read_Leave_Management() {
		clickByJavaScript(CheckBox_Leave_Management_Read);
	}

	public void click_Uncheckbox_Leave_Management() {
		clickByJavaScript(unCheckbox_Read_LeaveManagement);
	}

	public void click_CheckBox_Read_Leave_Management() {
		clickByJavaScript(checkbox_Read_LeaveManagement);
	}

	public void choose_Checkbox_Read_Leave_Management() {
		clickByJavaScript(checkBox_Read_Leave_Management);
	}

	public void choose_Checkbox_Update_Leave_Management() {
		clickByJavaScript(checkBox_Update_Leave_Management);
	}

	public void choose_Checkbox_Delete_Leave_Management() {
		clickByJavaScript(checkBox_Delete_Leave_Management);
	}

	public void choose_Checkbox_Create_Leave_Management() {
		clickByJavaScript(checkBox_Create_Leave_Management);
	}

	// ============ Leave Permission
	// ===============================================

	By CheckBox_Employee_List_Permission_Add = By
			.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Delete'])[35]/following::label[2]");
	By CheckBox_Employee_List_Permission_Delete = By
			.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Delete'])[35]/following::label[3]");
	By CheckBox_Employee_List_Permission_Update_Employees_Information = By
			.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Delete'])[35]/following::label[4]");

	public void choose_UnCheckbox_Employee_List_Permission_Add() {
		clickByJavaScript(CheckBox_Employee_List_Permission_Add);
	}

	public void choose_UnCheckbox_Employee_List_Permission_Delete() {
		clickByJavaScript(CheckBox_Employee_List_Permission_Delete);
	}

	public void choose_UnCheckbox_Employee_List_Permission_Update_Employees_Information() {
		clickByJavaScript(CheckBox_Employee_List_Permission_Update_Employees_Information);
	}

	// ========== Leave - My Request List
	// ============================================

	By UnCheckBox_Read_Leave_MyRequestList = By.xpath(
			"(.//*[normalize-space(text()) and normalize-space(.)='Leave - My Request List'])[1]/following::span[1]");
	By CheckBox_Read_Leave_MyRequestList = By.xpath(
			"(.//*[normalize-space(text()) and normalize-space(.)='Leave - My Request List'])[1]/following::label[1]");
	By CheckBox_Update_Leave_MyRequestList = By.xpath(
			"(.//*[normalize-space(text()) and normalize-space(.)='Leave - My Request List'])[1]/following::label[2]");
	By CheckBox_Create_Leave_MyRequestList = By.xpath(
			"(.//*[normalize-space(text()) and normalize-space(.)='Leave - My Request List'])[1]/following::label[3]");

	public void UnCheckBox_Read_Leave_MyRequestList() {
		clickByJavaScript(UnCheckBox_Read_Leave_MyRequestList);
	}

	public void CheckBox_Read_Leave_MyRequestList() {
		clickByJavaScript(CheckBox_Read_Leave_MyRequestList);
	}

	public void CheckBox_Update_Leave_MyRequestList() {
		clickByJavaScript(CheckBox_Update_Leave_MyRequestList);
	}

	public void CheckBox_Create_Leave_MyRequestList() {
		clickByJavaScript(CheckBox_Create_Leave_MyRequestList);
	}

	// ============ED Work
	// Mobility==============================================
	By checkBox_Read_ED_WorkMobility = By.xpath(
			"(.//*[normalize-space(text()) and normalize-space(.)='ED - Work Mobility'])[1]/following::label[1]");
	By checkBox_Update_ED_WorkMobility = By.xpath(
			"(.//*[normalize-space(text()) and normalize-space(.)='ED - Work Mobility'])[1]/following::label[2]");
	By checkBox_Create_ED_WorkMobility = By.xpath(
			"(.//*[normalize-space(text()) and normalize-space(.)='ED - Work Mobility'])[1]/following::label[3]");
	By checkBox_Delete_ED_WorkMobility = By.xpath(
			"(.//*[normalize-space(text()) and normalize-space(.)='ED - Work Mobility'])[1]/following::label[4]");
	By uncheckBox_Read_ED_WorkMobility = By
			.xpath("(.//*[normalize-space(text()) and normalize-space(.)='ED - Work Mobility'])[1]/following::span[1]");
	By uncheckBox_Update_ED_WorkMobility = By
			.xpath("(.//*[normalize-space(text()) and normalize-space(.)='ED - Work Mobility'])[1]/following::span[2]");
	By uncheckBox_Create_ED_WorkMobility = By
			.xpath("(.//*[normalize-space(text()) and normalize-space(.)='ED - Work Mobility'])[1]/following::span[3]");
	By uncheckBox_Delete_ED_WorkMobility = By
			.xpath("(.//*[normalize-space(text()) and normalize-space(.)='ED - Work Mobility'])[1]/following::span[4]");

	public void uncheck_Read_ED_WorkMobility() {
		clickByJavaScript(uncheckBox_Read_ED_WorkMobility);

	}

	public void check_Read_ED_WorkMobility() {
		clickByJavaScript(checkBox_Read_ED_WorkMobility);
	}

	public void uncheck_Update_ED_WorkMobility() {
		clickByJavaScript(uncheckBox_Update_ED_WorkMobility);

	}

	public void check_Update_ED_WorkMobility() {
		clickByJavaScript(checkBox_Update_ED_WorkMobility);
	}

	public void uncheck_Create_ED_WorkMobility() {
		clickByJavaScript(uncheckBox_Create_ED_WorkMobility);

	}

	public void check_Create_ED_WorkMobility() {
		clickByJavaScript(checkBox_Create_ED_WorkMobility);
	}

	public void uncheck_Delete_ED_WorkMobility() {
		clickByJavaScript(uncheckBox_Delete_ED_WorkMobility);

	}

	public void check_Delete_ED_WorkMobility() {
		clickByJavaScript(checkBox_Delete_ED_WorkMobility);
	}

	// ========== Project Detail - Project Member List ============

	By uncheckBox_Read_ProjectMemberList = By.xpath(
			"(.//*[normalize-space(text()) and normalize-space(.)='Project Detail - Project Member List'])[1]/following::span[1]");
	By uncheckBox_Update_ProjectMemberList = By.xpath(
			"(.//*[normalize-space(text()) and normalize-space(.)='Project Detail - Project Member List'])[1]/following::span[3]");
	By uncheckBox_Create_ProjectMemberList = By.xpath(
			"(.//*[normalize-space(text()) and normalize-space(.)='Project Detail - Project Member List'])[1]/following::span[5]");
	By uncheckBox_Delete_ProjectMemberList = By.xpath(
			"(.//*[normalize-space(text()) and normalize-space(.)='Project Detail - Project Member List'])[1]/following::span[7]");

	By checkBox_Read_ProjectMemberList = By.xpath(
			"(.//*[normalize-space(text()) and normalize-space(.)='Project Detail - Project Member List'])[1]/following::label[1]");

	By checkBox_Update_ProjectMemberList = By.xpath(
			"(.//*[normalize-space(text()) and normalize-space(.)='Project Detail - Project Member List'])[1]/following::label[2]");
	By checkBox_Create_ProjectMemberList = By.xpath(
			"(.//*[normalize-space(text()) and normalize-space(.)='Project Detail - Project Member List'])[1]/following::label[3]");
	By checkBox_Delete_ProjectMemberList = By.xpath(
			"(.//*[normalize-space(text()) and normalize-space(.)='Project Detail - Project Member List'])[1]/following::label[4]");

	By checkBox_Read_ImportMemberToProject = By.xpath(
			"(.//*[normalize-space(text()) and normalize-space(.)='Import Member to Project'])[1]/following::label[1]");

	public void uncheckBox_Read_ProjectMemberList() {
		waitForElementClickable(5, uncheckBox_Read_ProjectMemberList);
		clickByJavaScript(uncheckBox_Read_ProjectMemberList);
	}

	public void uncheckBox_Update_ProjectMemberList() {
		clickByJavaScript(uncheckBox_Update_ProjectMemberList);
	}

	public void uncheckBox_Create_ProjectMemberList() {
		clickByJavaScript(uncheckBox_Create_ProjectMemberList);
	}

	public void uncheckBox_Delete_ProjectMemberList() {
		clickByJavaScript(uncheckBox_Delete_ProjectMemberList);
	}

	public void checkBox_Read_ProjectMemberList() {
		waitForElementClickable(5, checkBox_Read_ProjectMemberList);
		clickByJavaScript(checkBox_Read_ProjectMemberList);
	}

	public void checkBox_Update_ProjectMemberList() {
		clickByJavaScript(checkBox_Update_ProjectMemberList);
	}

	public void checkBox_Create_ProjectMemberList() {
		clickByJavaScript(checkBox_Create_ProjectMemberList);
	}

	public void checkBox_Delete_ProjectMemberList() {
		clickByJavaScript(checkBox_Delete_ProjectMemberList);
	}

	public void checkBox_Read_ImportMemberToProject() {
		clickByJavaScript(checkBox_Read_ImportMemberToProject);
	}

	// =============================CREATE ROLE & DELETE ROLE
	// ==============================================
	By btnCreate = By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Roles'])[1]/following::button[2]");
	By buttonCreate = By.xpath(".//button[@ng-click='openUserModel()']");
	By txtUserRoleName = By
			.xpath("(.//*[normalize-space(text()) and normalize-space(.)='User Role Name*'])[1]/following::input[1]");
	By ArrowRoleType = By
			.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Role Type*'])[1]/following::span[1]");
	By optionRoleType_Admin = By
			.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Select Role Type...'])[1]/following::div[5]");
	By optionRoleType_Manager = By
			.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Select Role Type...'])[1]/following::div[6]");
	By optionRoleType_User = By
			.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Select Role Type...'])[1]/following::div[8]");

	By searchRoles = By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Roles'])[1]/following::input[3]");

	By buttonExport = By
			.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Create'])[1]/following::button[1]");

	By buttonViewUser = By
			.xpath("//button[contains(.,'View Users')]");

	By iconDelete = By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Create'])[1]/following::i[2]");

	By checkbox_delete_role = By
			.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Action'])[1]/following::input[1]");

	By button_Alert_Delete_Role = By
			.xpath("(.//*[normalize-space(text()) and normalize-space(.)='*Required'])[1]/following::button[1]");

	// ============= Actual Volume ============
	By uncheckbox_Read_ActualVolume = By
			.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Actual Volume'])[2]/following::span[1]");
	By uncheckbox_Update_ActualVolume = By
			.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Actual Volume'])[2]/following::span[2]");
	By checkbox_Read_ActualVolume = By
			.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Actual Volume'])[2]/following::label[1]");
	By checkbox_Update_ActualVolume = By
			.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Actual Volume'])[2]/following::label[2]");

	public void uncheckbox_Read_ActualVolume() {
		clickByJavaScript(uncheckbox_Read_ActualVolume);
	}

	public void uncheckbox_Update_ActualVolume() {
		clickByJavaScript(uncheckbox_Update_ActualVolume);
	}

	public void checkbox_Read_ActualVolume() {
		clickByJavaScript(checkbox_Read_ActualVolume);
	}

	public void checkbox_Update_ActualVolume() {
		clickByJavaScript(checkbox_Update_ActualVolume);
	}

	// =============== KPI Settings ============

	By uncheckbox_Read_KPISettings = By
			.xpath("(.//*[normalize-space(text()) and normalize-space(.)='KPI Settings'])[3]/following::span[1]");
	By uncheckbox_Update_KPISettings = By
			.xpath("(.//*[normalize-space(text()) and normalize-space(.)='KPI Settings'])[3]/following::span[3]");
	By uncheckbox_Create_KPISettings = By
			.xpath("(.//*[normalize-space(text()) and normalize-space(.)='KPI Settings'])[3]/following::span[5]");
	By uncheckbox_Delete_KPISettings = By
			.xpath("(.//*[normalize-space(text()) and normalize-space(.)='KPI Settings'])[3]/following::span[7]");
	By checkbox_Read_KPISettings = By
			.xpath("(.//*[normalize-space(text()) and normalize-space(.)='KPI Settings'])[3]/following::label[1]");
	By checkbox_Update_KPISettings = By
			.xpath("(.//*[normalize-space(text()) and normalize-space(.)='KPI Settings'])[3]/following::label[2]");
	By checkbox_Create_KPISettings = By
			.xpath("(.//*[normalize-space(text()) and normalize-space(.)='KPI Settings'])[3]/following::label[3]");
	By checkbox_Delete_KPISettings = By
			.xpath("(.//*[normalize-space(text()) and normalize-space(.)='KPI Settings'])[3]/following::label[4]");

	// =============Project Management Permission - Project Detail - Project
	// Info
	// ======
	By checkbox_Read_ProjectDetail_ProjectInfo = By.xpath(
			"(.//*[normalize-space(text()) and normalize-space(.)='Project Detail - Project Info'])[1]/following::label[1]");
	By uncheckbox_Read_ProjectDetail_ProjectInfo = By.xpath(
			"(.//*[normalize-space(text()) and normalize-space(.)='Project Detail - Project Info'])[1]/following::span[1]");

	public void uncheck_Read_ProjectDetail_ProjectInfo() {
		clickByJavaScript(uncheckbox_Read_ProjectDetail_ProjectInfo);
	}

	public void check_Read_ProjectDetail_ProjectInfo() {
		clickByJavaScript(checkbox_Read_ProjectDetail_ProjectInfo);
	}

	// =============Project Management Permission - Project Detail - Project
	// Capacity====

	By checkbox_Update_ProjectDetail_ProjectCapacity = By.xpath(
			"(.//*[normalize-space(text()) and normalize-space(.)='Project Detail - Project Capacity'])[1]/following::label[2]");
	By uncheckbox_Update_ProjectDetail_ProjectCapacity = By.xpath(
			"(.//*[normalize-space(text()) and normalize-space(.)='Project Detail - Project Capacity'])[1]/following::span[2]");
	By checkbox_Create_ProjectDetail_ProjectCapacity = By.xpath(
			"(.//*[normalize-space(text()) and normalize-space(.)='Project Detail - Project Capacity'])[1]/following::label[3]");
	By uncheckbox_Create_ProjectDetail_ProjectCapacity = By.xpath(
			"(.//*[normalize-space(text()) and normalize-space(.)='Project Detail - Project Capacity'])[1]/following::span[3]");
	By checkbox_Delete_ProjectDetail_ProjectCapacity = By.xpath(
			"(.//*[normalize-space(text()) and normalize-space(.)='Project Detail - Project Capacity'])[1]/following::label[4]");
	By uncheckbox_Delete_ProjectDetail_ProjectCapacity = By.xpath(
			"(.//*[normalize-space(text()) and normalize-space(.)='Project Detail - Project Capacity'])[1]/following::span[4]");

	By checkbox_Read_ProjectDetail_ProjectCapacity = By.xpath(
			"(.//*[normalize-space(text()) and normalize-space(.)='Project Detail - Project Capacity'])[1]/following::label[1]");
	By uncheckbox_Read_ProjectDetail_ProjectCapacity = By.xpath(
			"(.//*[normalize-space(text()) and normalize-space(.)='Project Detail - Project Capacity'])[1]/following::span[1]");

	public void uncheck_Read_ProjectDetail_ProjectCapacity() {
		clickByJavaScript(uncheckbox_Read_ProjectDetail_ProjectCapacity);
	}

	public void check_Read_ProjectDetail_ProjectCapacity() {
		clickByJavaScript(checkbox_Read_ProjectDetail_ProjectCapacity);
	}

	public void uncheck_Update_ProjectDetail_ProjectCapacity() {
		clickByJavaScript(uncheckbox_Update_ProjectDetail_ProjectCapacity);
	}

	public void check_Update_ProjectDetail_ProjectCapacity() {
		clickByJavaScript(checkbox_Update_ProjectDetail_ProjectCapacity);
	}

	public void uncheck_Create_ProjectDetail_ProjectCapacity() {
		clickByJavaScript(uncheckbox_Create_ProjectDetail_ProjectCapacity);
	}

	public void check_Create_ProjectDetail_ProjectCapacity() {
		clickByJavaScript(checkbox_Create_ProjectDetail_ProjectCapacity);
	}

	public void uncheck_Delete_ProjectDetail_ProjectCapacity() {
		clickByJavaScript(uncheckbox_Delete_ProjectDetail_ProjectCapacity);
	}

	public void check_Delete_ProjectDetail_ProjectCapacity() {
		clickByJavaScript(checkbox_Delete_ProjectDetail_ProjectCapacity);
	}

	// ============= Target Volume
	// =======================================================
	By checkbox_Read_Target_Volume = By
			.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Target Volume'])[2]/following::label[1]");
	By uncheckbox_Read_Target_Volume = By
			.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Target Volume'])[2]/following::span[1]");
	By checkbox_Update_Target_Volume = By
			.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Target Volume'])[2]/following::label[2]");
	By uncheckbox_Update_Target_Volume = By
			.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Target Volume'])[2]/following::span[2]");

	public void uncheck_Update_Target_Volume() {
		clickByJavaScript(uncheckbox_Update_Target_Volume);
	}

	public void check_Update_Target_Volume() {
		clickByJavaScript(checkbox_Update_Target_Volume);
	}

	public void uncheck_Read_Target_Volume() {
		clickByJavaScript(uncheckbox_Read_Target_Volume);
	}

	public void check_Read_Target_Volume() {
		clickByJavaScript(checkbox_Read_Target_Volume);
	}

	// =============== My ED - Personal Details - Dependents ============

	By uncheckbox_Read_My_PersonalDetails_Dependents = By.xpath(
			"(.//*[normalize-space(text()) and normalize-space(.)='My Personal Details - Dependents'])[1]/following::span[1]");
	By uncheckbox_Update_My_PersonalDetails_Dependents = By.xpath(
			"(.//*[normalize-space(text()) and normalize-space(.)='My Personal Details - Dependents'])[1]/following::span[3]");

	By uncheckbox_Create_My_PersonalDetails_Dependents = By.xpath(
			"(.//*[normalize-space(text()) and normalize-space(.)='My Personal Details - Dependents'])[1]/following::span[5]");
	By uncheckbox_Delete_My_PersonalDetails_Dependents = By.xpath(
			"(.//*[normalize-space(text()) and normalize-space(.)='My Personal Details - Dependents'])[1]/following::span[7]");
	By checkbox_Read_My_PersonalDetails_Dependents = By.xpath(
			"(.//*[normalize-space(text()) and normalize-space(.)='My Personal Details - Dependents'])[1]/following::label[1]");
	By checkbox_Update_My_PersonalDetails_Dependents = By.xpath(
			"(.//*[normalize-space(text()) and normalize-space(.)='My Personal Details - Dependents'])[1]/following::label[2]");
	By checkbox_Create_My_PersonalDetails_Dependents = By.xpath(
			"(.//*[normalize-space(text()) and normalize-space(.)='My Personal Details - Dependents'])[1]/following::label[3]");
	By checkbox_Delete_My_PersonalDetails_Dependent = By.xpath(
			"(.//*[normalize-space(text()) and normalize-space(.)='My Personal Details - Dependents'])[1]/following::label[4]");

	public void uncheckbox_Read_My_PersonalDetails_Dependents() {
		clickByJavaScript(uncheckbox_Read_My_PersonalDetails_Dependents);
	}

	public void checkbox_Read_My_PersonalDetails_Dependents() {
		clickByJavaScript(checkbox_Read_My_PersonalDetails_Dependents);
	}

	public void checkbox_Update_My_PersonalDetails_Dependents() {
		clickByJavaScript(checkbox_Update_My_PersonalDetails_Dependents);
	}

	public void checkbox_Create_My_PersonalDetails_Dependents() {
		clickByJavaScript(checkbox_Create_My_PersonalDetails_Dependents);
	}

	public void checkbox_Delete_My_PersonalDetails_Dependent() {
		clickByJavaScript(checkbox_Delete_My_PersonalDetails_Dependent);
	}

	// =============== ED - Personal Details - Dependents ============

	By uncheckbox_Read_ED_PersonalDetails_Dependents = By.xpath(
			"(.//*[normalize-space(text()) and normalize-space(.)='ED - Personal Details - Dependents'])[1]/following::span[1]");
	By uncheckbox_Update_ED_PersonalDetails_Dependents = By.xpath(
			"(.//*[normalize-space(text()) and normalize-space(.)='ED - Personal Details - Dependents'])[1]/following::span[3]");

	By uncheckbox_Create_ED_PersonalDetails_Dependents = By.xpath(
			"(.//*[normalize-space(text()) and normalize-space(.)='ED - Personal Details - Dependents'])[1]/following::span[5]");
	By uncheckbox_Delete_ED_PersonalDetails_Dependents = By.xpath(
			"(.//*[normalize-space(text()) and normalize-space(.)='ED - Personal Details - Dependents'])[1]/following::span[7]");
	By checkbox_Read_ED_PersonalDetails_Dependents = By.xpath(
			"(.//*[normalize-space(text()) and normalize-space(.)='ED - Personal Details - Dependents'])[1]/following::label[1]");
	By checkbox_Update_ED_PersonalDetails_Dependents = By.xpath(
			"(.//*[normalize-space(text()) and normalize-space(.)='ED - Personal Details - Dependents'])[1]/following::label[2]");
	By checkbox_Create_ED_PersonalDetails_Dependents = By.xpath(
			"(.//*[normalize-space(text()) and normalize-space(.)='ED - Personal Details - Dependents'])[1]/following::label[3]");
	By checkbox_Delete_ED_PersonalDetails_Dependent = By.xpath(
			"(.//*[normalize-space(text()) and normalize-space(.)='ED - Personal Details - Dependents'])[1]/following::label[4]");

	public void uncheckbox_Read_ED_PersonalDetails_Dependents() {
		clickByJavaScript(uncheckbox_Read_ED_PersonalDetails_Dependents);
	}

	public void checkbox_Read_ED_PersonalDetails_Dependents() {
		clickByJavaScript(checkbox_Read_ED_PersonalDetails_Dependents);
	}

	public void checkbox_Update_ED_PersonalDetails_Dependents() {
		clickByJavaScript(checkbox_Update_ED_PersonalDetails_Dependents);
	}

	public void checkbox_Create_ED_PersonalDetails_Dependents() {
		clickByJavaScript(checkbox_Create_ED_PersonalDetails_Dependents);
	}

	public void checkbox_Delete_ED_PersonalDetails_Dependent() {
		clickByJavaScript(checkbox_Delete_ED_PersonalDetails_Dependent);
	}

	// ============== ED - Personal Details - Emergency Contact
	// ==================
	By uncheckbox_Read_ED_PersonalDetails_EmergencyContact = By.xpath(
			"(.//*[normalize-space(text()) and normalize-space(.)='ED - Personal Details - Emergency Contact'])[1]/following::span[1]");
	By uncheckbox_ED_PersonalDetails_EmergencyContact = By.xpath(
			"(.//*[normalize-space(text()) and normalize-space(.)='ED - Personal Details - Emergency Contact'])[1]/following::span[2]");

	By uncheckbox_Create_ED_PersonalDetails_EmergencyContact = By.xpath(
			"(.//*[normalize-space(text()) and normalize-space(.)='ED - Personal Details - Emergency Contact'])[1]/following::span[3]");
	By uncheckbox_Delete_ED_PersonalDetails_EmergencyContact = By.xpath(
			"(.//*[normalize-space(text()) and normalize-space(.)='ED - Personal Details - Emergency Contact'])[1]/following::span[4]");
	By checkbox_Read_ED_PersonalDetails_EmergencyContact = By.xpath(
			"(.//*[normalize-space(text()) and normalize-space(.)='ED - Personal Details - Emergency Contact'])[1]/following::label[1]");
	By checkbox_Update_ED_PersonalDetails_EmergencyContact = By.xpath(
			"(.//*[normalize-space(text()) and normalize-space(.)='ED - Personal Details - Emergency Contact'])[1]/following::label[2]");
	By checkbox_Create_ED_PersonalDetails_EmergencyContact = By.xpath(
			"(.//*[normalize-space(text()) and normalize-space(.)='ED - Personal Details - Emergency Contact'])[1]/following::label[3]");
	By checkbox_Delete_ED_PersonalDetails_EmergencyContact = By.xpath(
			"(.//*[normalize-space(text()) and normalize-space(.)='ED - Personal Details - Emergency Contact'])[1]/following::label[4]");

	public void uncheck_Read_ED_PersonalDetails_EmergencyContact() {
		clickByJavaScript(uncheckbox_Read_ED_PersonalDetails_EmergencyContact);
	}

	public void check_Read_ED_PersonalDetails_EmergencyContact() {
		clickByJavaScript(uncheckbox_ED_PersonalDetails_EmergencyContact);
	}

	public void check_Update_ED_PersonalDetails_EmergencyContact() {
		clickByJavaScript(checkbox_Update_ED_PersonalDetails_EmergencyContact);
	}

	public void check_Create_ED_PersonalDetails_EmergencyContact() {
		clickByJavaScript(checkbox_Create_ED_PersonalDetails_EmergencyContact);
	}

	public void check_Delete_ED_PersonalDetails_EmergencyContact() {
		clickByJavaScript(checkbox_Delete_ED_PersonalDetails_EmergencyContact);
	}

	// ============== My - Personal Details - Emergency Contact
	// ==================
	By uncheckbox_Read_My_PersonalDetails_EmergencyContact = By.xpath(
			"(.//*[normalize-space(text()) and normalize-space(.)='My Personal Details - Emergency Contact'])[1]/following::span[1]");
	By uncheckbox_My_PersonalDetails_EmergencyContact = By.xpath(
			"(.//*[normalize-space(text()) and normalize-space(.)='My Personal Details - Emergency Contact'])[1]/following::span[2]");

	By uncheckbox_Create_My_PersonalDetails_EmergencyContact = By.xpath(
			"(.//*[normalize-space(text()) and normalize-space(.)='My Personal Details - Emergency Contact'])[1]/following::span[3]");
	By uncheckbox_Delete_My_PersonalDetails_EmergencyContact = By.xpath(
			"(.//*[normalize-space(text()) and normalize-space(.)='My Personal Details - Emergency Contact'])[1]/following::span[4]");
	By checkbox_Read_My_PersonalDetails_EmergencyContact = By.xpath(
			"(.//*[normalize-space(text()) and normalize-space(.)='My Personal Details - Emergency Contact'])[1]/following::label[1]");
	By checkbox_Update_My_PersonalDetails_EmergencyContact = By.xpath(
			"(.//*[normalize-space(text()) and normalize-space(.)='My Personal Details - Emergency Contact'])[1]/following::label[2]");
	By checkbox_Create_My_PersonalDetails_EmergencyContact = By.xpath(
			"(.//*[normalize-space(text()) and normalize-space(.)='My Personal Details - Emergency Contact'])[1]/following::label[3]");
	By checkbox_Delete_My_PersonalDetails_EmergencyContact = By.xpath(
			"(.//*[normalize-space(text()) and normalize-space(.)='My Personal Details - Emergency Contact'])[1]/following::label[4]");

	public void uncheck_Read_My_PersonalDetails_EmergencyContact() {
		clickByJavaScript(uncheckbox_Read_My_PersonalDetails_EmergencyContact);
	}

	public void check_Read_My_PersonalDetails_EmergencyContact() {
		clickByJavaScript(checkbox_Read_My_PersonalDetails_EmergencyContact);
	}

	public void check_Update_My_PersonalDetails_EmergencyContact() {
		clickByJavaScript(checkbox_Update_My_PersonalDetails_EmergencyContact);
	}

	public void check_Create_My_PersonalDetails_EmergencyContact() {
		clickByJavaScript(checkbox_Create_My_PersonalDetails_EmergencyContact);
	}

	public void check_Delete_My_PersonalDetails_EmergencyContact() {
		clickByJavaScript(checkbox_Delete_My_PersonalDetails_EmergencyContact);
	}

	// ============== My Company Details - General Information ======

	By uncheckbox_Read_My_CompanyDetails_GeneralInformation = By.xpath(
			"(.//*[normalize-space(text()) and normalize-space(.)='My Company Details - General Information'])[1]/following::span[1]");
	By checkbox_Read_My_CompanyDetails_GeneralInformation = By.xpath(
			"(.//*[normalize-space(text()) and normalize-space(.)='My Company Details - General Information'])[1]/following::label[1]");
	By uncheckbox_Update_My_CompanyDetails_GeneralInformation = By.xpath(
			"(.//*[normalize-space(text()) and normalize-space(.)='My Company Details - General Information'])[1]/following::span[3]");
	By checkbox_Update_My_CompanyDetails_GeneralInformation = By.xpath(
			"(.//*[normalize-space(text()) and normalize-space(.)='My Company Details - General Information'])[1]/following::label[2]");

	public void uncheckbox_Read_My_CompanyDetails_GeneralInformation() {
		clickByJavaScript(uncheckbox_Read_My_CompanyDetails_GeneralInformation);
	}

	public void checkbox_Read_My_CompanyDetails_GeneralInformation() {
		clickByJavaScript(checkbox_Read_My_CompanyDetails_GeneralInformation);
	}

	public void uncheckbox_Update_My_CompanyDetails_GeneralInformation() {
		clickByJavaScript(uncheckbox_Update_My_CompanyDetails_GeneralInformation);
	}

	public void checkbox_Update_My_CompanyDetails_GeneralInformation() {
		clickByJavaScript(checkbox_Update_My_CompanyDetails_GeneralInformation);
	}

	// ============== My Company Details - General Information ======
	By uncheckbox_Read_My_PersonalDetails_GeneralInformation = By.xpath(
			"(.//*[normalize-space(text()) and normalize-space(.)='My Personal Details - General Information'])[1]/following::span[1]");
	By checkbox_Read_My_PersonalDetails_GeneralInformation = By.xpath(
			"(.//*[normalize-space(text()) and normalize-space(.)='My Personal Details - General Information'])[1]/following::label[1]");
	By uncheckbox_Update_My_PersonalDetails_GeneralInformation = By.xpath(
			"(.//*[normalize-space(text()) and normalize-space(.)='My Personal Details - General Information'])[1]/following::span[3]");
	By checkbox_Update_My_PersonalDetails_GeneralInformation = By.xpath(
			"(.//*[normalize-space(text()) and normalize-space(.)='My Personal Details - General Information'])[1]/following::label[2]");

	public void uncheckbox_Read_My_PersonalDetails_GeneralInformation() {
		clickByJavaScript(uncheckbox_Read_My_PersonalDetails_GeneralInformation);
	}

	public void checkbox_Read_My_PersonalDetails_GeneralInformation() {
		clickByJavaScript(checkbox_Read_My_PersonalDetails_GeneralInformation);
	}

	public void uncheckbox_Update_My_PersonalDetails_GeneralInformation() {
		clickByJavaScript(uncheckbox_Update_My_PersonalDetails_GeneralInformation);
	}

	public void checkbox_Update_My_PersonalDetails_GeneralInformation() {
		clickByJavaScript(checkbox_Update_My_PersonalDetails_GeneralInformation);
	}

	
	// ================ MY EMPLOYEE DATA - MY SKILL =============== //

	By checkbox_Read_MySkill = By.xpath(
			"(.//*[normalize-space(text()) and normalize-space(.)='My Skill'])[1]/following::label[1]");
	By checkbox_Update_MySkill = By.xpath(
			"(.//*[normalize-space(text()) and normalize-space(.)='My Skill'])[1]/following::label[2]");
	By checkbox_Create_MySkill = By.xpath(
			"(.//*[normalize-space(text()) and normalize-space(.)='My Skill'])[1]/following::label[3]");
	By checkbox_Delete_MySkill = By.xpath(
			"(.//*[normalize-space(text()) and normalize-space(.)='My Skill'])[1]/following::label[4]");
	
	public void checkbox_Read_MySkill() {
		
		clickByJavaScript(checkbox_Read_MySkill);
	}
	public void checkbox_Update_MySkill() {
		clickByJavaScript(checkbox_Update_MySkill);
	}
	public void checkbox_Create_MySkill() {
		clickByJavaScript(checkbox_Create_MySkill);
	}
	public void checkbox_Delete_MySkill() {
		clickByJavaScript(checkbox_Delete_MySkill);
	}
	
	// ============ED Work
	// Mobility==============================================
	By checkBox_Read_MyED_WorkMobility = By
			.xpath("(.//*[normalize-space(text()) and normalize-space(.)='My Work Mobility'])[1]/following::label[1]");
	By checkBox_Update_MyED_WorkMobility = By
			.xpath("(.//*[normalize-space(text()) and normalize-space(.)='My Work Mobility'])[1]/following::label[2]");
	By checkBox_Create_MyED_WorkMobility = By
			.xpath("(.//*[normalize-space(text()) and normalize-space(.)='My Work Mobility'])[1]/following::label[3]");
	By checkBox_Delete_MyED_WorkMobility = By
			.xpath("(.//*[normalize-space(text()) and normalize-space(.)='My Work Mobility'])[1]/following::label[4]");
	By uncheckBox_Read_MyED_WorkMobility = By
			.xpath("(.//*[normalize-space(text()) and normalize-space(.)='My Work Mobility'])[1]/following::span[1]");
	By uncheckBox_Update_MyED_WorkMobility = By
			.xpath("(.//*[normalize-space(text()) and normalize-space(.)='My Work Mobility'])[1]/following::span[2]");
	By uncheckBox_Create_MyED_WorkMobility = By
			.xpath("(.//*[normalize-space(text()) and normalize-space(.)='My Work Mobility'])[1]/following::span[3]");
	By uncheckBox_Delete_MyED_WorkMobility = By
			.xpath("(.//*[normalize-space(text()) and normalize-space(.)='My Work Mobility'])[1]/following::span[4]");

	public void checkBox_Read_MyED_WorkMobility() {
		waitForElementClickable(5, checkBox_Read_MyED_WorkMobility);
		clickByJavaScript(checkBox_Read_MyED_WorkMobility);

	}

	public void checkBox_Update_MyED_WorkMobility() {
		clickByJavaScript(checkBox_Update_MyED_WorkMobility);
	}

	public void checkBox_Create_MyED_WorkMobility() {
		clickByJavaScript(checkBox_Create_MyED_WorkMobility);

	}

	public void checkBox_Delete_MyED_WorkMobility() {
		clickByJavaScript(checkBox_Delete_MyED_WorkMobility);
	}

	public void uncheckBox_Read_MyED_WorkMobility() {
		clickByJavaScript(uncheckBox_Read_MyED_WorkMobility);

	}

	public void uncheckBox_Update_MyED_WorkMobility() {
		clickByJavaScript(uncheckBox_Update_MyED_WorkMobility);
	}

	public void uncheckBox_Create_MyED_WorkMobility() {
		clickByJavaScript(uncheckBox_Create_MyED_WorkMobility);

	}

	public void uncheckBox_Delete_MyED_WorkMobility() {
		clickByJavaScript(uncheckBox_Delete_MyED_WorkMobility);
	}

	// ============== ED - Personal Details - General Information ======
	By uncheckbox_Read_ED_PersonalDetails_GeneralInformation = By.xpath(
			"(.//*[normalize-space(text()) and normalize-space(.)='ED - Personal Details - General Information'])[1]/following::span[1]");
	By checkbox_Read_ED_PersonalDetails_GeneralInformation = By.xpath(
			"(.//*[normalize-space(text()) and normalize-space(.)='ED - Personal Details - General Information'])[1]/following::label[1]");
	By uncheckbox_Update_ED_PersonalDetails_GeneralInformation = By.xpath(
			"(.//*[normalize-space(text()) and normalize-space(.)='ED - Personal Details - General Information'])[1]/following::span[3]");
	By checkbox_Update_ED_PersonalDetails_GeneralInformation = By.xpath(
			"(.//*[normalize-space(text()) and normalize-space(.)='ED - Personal Details - General Information'])[1]/following::label[2]");

	public void uncheckbox_Read_ED_PersonalDetails_GeneralInformation() {
		clickByJavaScript(uncheckbox_Read_ED_PersonalDetails_GeneralInformation);
	}

	public void checkbox_Read_ED_PersonalDetails_GeneralInformation() {
		clickByJavaScript(checkbox_Read_ED_PersonalDetails_GeneralInformation);
	}

	public void uncheckbox_Update_ED_PersonalDetails_GeneralInformation() {
		clickByJavaScript(uncheckbox_Update_ED_PersonalDetails_GeneralInformation);
	}

	public void checkbox_Update_ED_PersonalDetails_GeneralInformation() {
		clickByJavaScript(checkbox_Update_ED_PersonalDetails_GeneralInformation);
	}


	// ============ Project Permission =======================
	By uncheckbox_Read_ProjectPermission = By
			.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Project Permission'])[1]/following::span[1]");
	By checkbox_Read_ProjectPermission = By.xpath(
			"(.//*[normalize-space(text()) and normalize-space(.)='Project Permission'])[1]/following::label[1]");
	By uncheckbox_Update_ProjectPermission = By
			.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Project Permission'])[1]/following::span[3]");
	By checkbox_Update_ProjectPermission = By.xpath(
			"(.//*[normalize-space(text()) and normalize-space(.)='Project Permission'])[1]/following::label[2]");

	public void uncheckbox_Read_ProjectPermission() {
		clickByJavaScript(uncheckbox_Read_ProjectPermission);
	}

	public void checkbox_Read_ProjectPermission() {
		clickByJavaScript(checkbox_Read_ProjectPermission);
	}

	public void uncheckbox_Update_ProjectPermission() {
		clickByJavaScript(uncheckbox_Update_ProjectPermission);
	}

	public void checkbox_Update_ProjectPermission() {
		clickByJavaScript(checkbox_Update_ProjectPermission);
	}

	// ========== Project Board ===================

	By uncheckbox_Read_ProjectBoard = By
			.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Project Board'])[2]/following::span[1]");
	By checkbox_Read_ProjectBoard = By
			.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Project Board'])[2]/following::label[1]");
	By uncheckbox_Update_ProjectBoard = By
			.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Project Board'])[2]/following::span[3]");
	By checkbox_Update_ProjectBoard = By
			.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Project Board'])[2]/following::label[2]");

	By uncheckbox_Create_ProjectBoard = By
			.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Project Board'])[2]/following::span[5]");
	By checkbox_Create_ProjectBoard = By
			.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Project Board'])[2]/following::label[3]");

	By uncheckbox_Delete_ProjectBoard = By
			.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Project Board'])[2]/following::span[7]");
	By checkbox_Delete_ProjectBoard = By
			.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Project Board'])[2]/following::label[4]");

	public void uncheckbox_Read_ProjectBoard() {
		clickByJavaScript(uncheckbox_Read_ProjectBoard);
	}

	public void checkbox_Read_ProjectBoard() {
		clickByJavaScript(checkbox_Read_ProjectBoard);
	}

	public void checkbox_Update_ProjectBoard() {
		clickByJavaScript(checkbox_Update_ProjectBoard);
	}

	public void checkbox_Create_ProjectBoard() {
		clickByJavaScript(checkbox_Create_ProjectBoard);
	}

	public void checkbox_Delete_ProjectBoard() {
		clickByJavaScript(checkbox_Delete_ProjectBoard);
	}

	public void uncheckbox_Create_ProjectBoard() {
		clickByJavaScript(uncheckbox_Create_ProjectBoard);
	}

	// ========== Project Management ===================

	By uncheckbox_Read_ProjectManagement = By
			.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Project Management'])[2]/following::span[1]");
	By checkbox_Read_ProjectManagement = By.xpath(
			"(.//*[normalize-space(text()) and normalize-space(.)='Project Management'])[2]/following::label[1]");
	By uncheckbox_Update_ProjectManagement = By
			.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Project Management'])[2]/following::span[3]");
	By checkbox_Update_ProjectManagement = By.xpath(
			"(.//*[normalize-space(text()) and normalize-space(.)='Project Management'])[2]/following::label[2]");

	By uncheckbox_Create_ProjectManagement = By
			.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Project Management'])[2]/following::span[5]");
	By checkbox_Create_ProjectManagement = By.xpath(
			"(.//*[normalize-space(text()) and normalize-space(.)='Project Management'])[2]/following::label[3]");

	By uncheckbox_Delete_ProjectManagement = By
			.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Project Management'])[2]/following::span[7]");
	By checkbox_Delete_ProjectManagement = By.xpath(
			"(.//*[normalize-space(text()) and normalize-space(.)='Project Management'])[2]/following::label[4]");

	public void uncheckbox_Read_ProjectManagement() {
		clickByJavaScript(uncheckbox_Read_ProjectManagement);

	}

	public void checkbox_Read_ProjectManagement() {
		clickByJavaScript(checkbox_Read_ProjectManagement);
	}

	public void uncheckbox_Update_ProjectManagement() {
		clickByJavaScript(uncheckbox_Update_ProjectManagement);
	}

	public void checkbox_Update_ProjectManagement() {
		clickByJavaScript(checkbox_Update_ProjectManagement);
	}

	public void uncheckbox_Create_ProjectManagement() {
		clickByJavaScript(uncheckbox_Create_ProjectManagement);

	}

	public void checkbox_Create_ProjectManagement() {
		clickByJavaScript(checkbox_Create_ProjectManagement);
	}

	public void uncheckbox_Delete_ProjectBoard() {
		clickByJavaScript(uncheckbox_Delete_ProjectBoard);
	}

	public void uncheckbox_Delete_ProjectManagement() {
		clickByJavaScript(uncheckbox_Delete_ProjectManagement);

	}

	public void checkbox_Delete_ProjectManagement() {
		clickByJavaScript(checkbox_Delete_ProjectManagement);
	}

	// ============== My Personal Details - Address ==================

	By uncheckbox_Read_My_PersonalDetails_Address = By.xpath(
			"(.//*[normalize-space(text()) and normalize-space(.)='My Personal Details - Address'])[1]/following::span[1]");
	By checkbox_Read_My_PersonalDetails_Address = By.xpath(
			"(.//*[normalize-space(text()) and normalize-space(.)='My Personal Details - Address'])[1]/following::label[1]");
	By uncheckbox_Update_My_PersonalDetails_Address = By.xpath(
			"(.//*[normalize-space(text()) and normalize-space(.)='My Personal Details - Address'])[1]/following::span[3]");
	By checkbox_Update_My_PersonalDetails_Address = By.xpath(
			"(.//*[normalize-space(text()) and normalize-space(.)='My Personal Details - Address'])[1]/following::label[2]");

	public void uncheckbox_Read_My_PersonalDetails_Address() {
		clickByJavaScript(uncheckbox_Read_My_PersonalDetails_Address);
	}

	public void checkbox_Read_My_PersonalDetails_Address() {
		clickByJavaScript(uncheckbox_Read_My_PersonalDetails_Address);
	}

	public void uncheckbox_Update_My_PersonalDetails_Address() {
		clickByJavaScript(uncheckbox_Update_My_PersonalDetails_Address);
	}

	public void checkbox_Update_My_PersonalDetails_Address() {
		clickByJavaScript(checkbox_Update_My_PersonalDetails_Address);
	}

	// ============== ED - Personal Details - Address ==================

	By uncheckbox_Read_ED_PersonalDetails_Address = By.xpath(
			"(.//*[normalize-space(text()) and normalize-space(.)='ED - Personal Details - Address'])[1]/following::span[1]");
	By checkbox_Read_ED_PersonalDetails_Address = By.xpath(
			"(.//*[normalize-space(text()) and normalize-space(.)='ED - Personal Details - Address'])[1]/following::label[1]");
	By uncheckbox_Update_ED_PersonalDetails_Address = By.xpath(
			"(.//*[normalize-space(text()) and normalize-space(.)='ED - Personal Details - Address'])[1]/following::span[3]");
	By checkbox_Update_ED_PersonalDetails_Address = By.xpath(
			"(.//*[normalize-space(text()) and normalize-space(.)='ED - Personal Details - Address'])[1]/following::label[2]");

	public void uncheckbox_Read_ED_PersonalDetails_Address() {
		clickByJavaScript(uncheckbox_Read_ED_PersonalDetails_Address);
	}

	public void checkbox_Read_ED_PersonalDetails_Address() {
		clickByJavaScript(checkbox_Read_ED_PersonalDetails_Address);
	}

	public void uncheckbox_Update_ED_PersonalDetails_Address() {
		clickByJavaScript(uncheckbox_Update_ED_PersonalDetails_Address);
	}

	public void checkbox_Update_ED_PersonalDetails_Address() {
		clickByJavaScript(checkbox_Update_ED_PersonalDetails_Address);
	}

	// ============== My Company Details - Report To ==================

	By uncheckbox_Read_My_CompanyDetails_ReportTo = By.xpath(
			"(.//*[normalize-space(text()) and normalize-space(.)='My Company Details - Report To'])[1]/following::span[1]");
	By checkbox_Read_My_CompanyDetails_ReportTo = By.xpath(
			"(.//*[normalize-space(text()) and normalize-space(.)='My Company Details - Report To'])[1]/following::label[1]");
	By uncheckbox_Update_My_CompanyDetails_ReportTo = By.xpath(
			"(.//*[normalize-space(text()) and normalize-space(.)='My Company Details - Report To'])[1]/following::span[3]");
	By checkbox_Update_My_CompanyDetails_ReportTo = By.xpath(
			"(.//*[normalize-space(text()) and normalize-space(.)='My Company Details - Report To'])[1]/following::label[2]");

	public void uncheckbox_Read_My_CompanyDetails_ReportTo() {
		clickByJavaScript(uncheckbox_Read_My_CompanyDetails_ReportTo);
	}

	public void checkbox_Read_My_CompanyDetails_ReportTo() {
		clickByJavaScript(checkbox_Read_My_CompanyDetails_ReportTo);
	}

	public void uncheckbox_Update_My_CompanyDetails_ReportTo() {
		clickByJavaScript(uncheckbox_Update_My_CompanyDetails_ReportTo);
	}

	public void checkbox_Update_My_CompanyDetails_ReportTo() {
		clickByJavaScript(checkbox_Update_My_CompanyDetails_ReportTo);
	}

	// =========== My Company Details - Client Employee Data ==========
	By uncheckbox_Read_My_CompanyDetails_ClientEmployeeData = By.xpath(
			"(.//*[normalize-space(text()) and normalize-space(.)='My Company Details - Client Employee Data'])[1]/following::span[1]");
	By checkbox_Read_My_CompanyDetails_ClientEmployeeData = By.xpath(
			"(.//*[normalize-space(text()) and normalize-space(.)='My Company Details - Client Employee Data'])[1]/following::label[1]");

	public void uncheckbox_Read_My_PersonalDetails_ClientEmployeeData() {
		clickByJavaScript(uncheckbox_Read_My_CompanyDetails_ClientEmployeeData);
	}

	public void checkbox_Read_My_PersonalDetails_ClientEmployeeData() {
		clickByJavaScript(checkbox_Read_My_CompanyDetails_ClientEmployeeData);
	}

	// ==== My Personal Details - Contact Information =========
	By uncheckbox_Read_My_PersonalDetails_ContactInformation = By.xpath(
			"(.//*[normalize-space(text()) and normalize-space(.)='My Personal Details - Contact Information'])[1]/following::span[1]");
	By checkbox_Read_My_PersonalDetails_ContactInformation = By.xpath(
			"(.//*[normalize-space(text()) and normalize-space(.)='My Personal Details - Contact Information'])[1]/following::label[1]");
	By uncheckbox_Update_My_PersonalDetails_ContactInformation = By.xpath(
			"(.//*[normalize-space(text()) and normalize-space(.)='My Personal Details - Contact Information'])[1]/following::span[3]");
	By checkbox_Update_My_PersonalDetails_ContactInformation = By.xpath(
			"(.//*[normalize-space(text()) and normalize-space(.)='My Personal Details - Contact Information'])[1]/following::label[2]");

	public void uncheckbox_Read_My_PersonalDetails_ContactInformation() {
		clickByJavaScript(uncheckbox_Read_My_PersonalDetails_ContactInformation);
	}

	public void checkbox_Read_My_PersonalDetails_ContactInformation() {
		clickByJavaScript(checkbox_Read_My_PersonalDetails_ContactInformation);
	}

	public void uncheckbox_Update_My_PersonalDetails_ContactInformation() {
		clickByJavaScript(uncheckbox_Update_My_PersonalDetails_ContactInformation);
	}

	public void checkbox_Update_My_PersonalDetails_ContactInformation() {
		clickByJavaScript(checkbox_Update_My_PersonalDetails_ContactInformation);
	}

	// ==== ED - Personal Details - Contact Information =========
	By uncheckbox_Read_ED_PersonalDetails_ContactInformation = By.xpath(
			"(.//*[normalize-space(text()) and normalize-space(.)='ED - Personal Details - Contact Information'])[1]/following::span[1]");
	By checkbox_Read_ED_PersonalDetails_ContactInformation = By.xpath(
			"(.//*[normalize-space(text()) and normalize-space(.)='ED - Personal Details - Contact Information'])[1]/following::label[1]");
	By uncheckbox_Update_ED_PersonalDetails_ContactInformation = By.xpath(
			"(.//*[normalize-space(text()) and normalize-space(.)='ED - Personal Details - Contact Information'])[1]/following::span[3]");
	By checkbox_Update_ED_PersonalDetails_ContactInformation = By.xpath(
			"(.//*[normalize-space(text()) and normalize-space(.)='ED - Personal Details - Contact Information'])[1]/following::label[2]");

	public void uncheckbox_Read_ED_PersonalDetails_ContactInformation() {
		clickByJavaScript(uncheckbox_Read_ED_PersonalDetails_ContactInformation);
	}

	public void checkbox_Read_ED_PersonalDetails_ContactInformation() {
		clickByJavaScript(checkbox_Read_ED_PersonalDetails_ContactInformation);
	}

	public void uncheckbox_Update_ED_PersonalDetails_ContactInformation() {
		clickByJavaScript(uncheckbox_Update_ED_PersonalDetails_ContactInformation);
	}

	public void checkbox_Update_ED_PersonalDetails_ContactInformation() {
		clickByJavaScript(checkbox_Update_ED_PersonalDetails_ContactInformation);
	}

	// ================= CHECK-In Management ========================
	By uncheckbox_Read_Checkin_Management = By.xpath(
			"(.//*[normalize-space(text()) and normalize-space(.)='Check-in Management'])[2]/following::span[1]");
	By checkbox_Read_Checkin_Management = By.xpath(
			"(.//*[normalize-space(text()) and normalize-space(.)='Check-in Management'])[2]/following::label[1]");
	By uncheckbox_Update_Checkin_Management = By.xpath(
			"(.//*[normalize-space(text()) and normalize-space(.)='Check-in Management'])[2]/following::span[2]");
	By checkbox_Update_Checkin_Management = By.xpath(
			"(.//*[normalize-space(text()) and normalize-space(.)='Check-in Management'])[2]/following::label[2]");

	public void uncheckbox_Read_Checkin_Management() {
		clickByJavaScript(uncheckbox_Read_Checkin_Management);
	}

	public void checkbox_Read_Checkin_Management() {
		clickByJavaScript(checkbox_Read_Checkin_Management);
	}

	public void uncheckbox_Update_Checkin_Management() {
		clickByJavaScript(uncheckbox_Update_Checkin_Management);
	}

	public void checkbox_Update_Checkin_Management() {
		clickByJavaScript(checkbox_Update_Checkin_Management);
	}

	// ================= My CHECK-In  ========================
		By uncheckbox_Read_MyCheckin = By.xpath(
				"(.//*[normalize-space(text()) and normalize-space(.)='My Check-in'])[3]/following::span[1]");
		By checkbox_Read_MyCheckin = By.xpath(
				"(.//*[normalize-space(text()) and normalize-space(.)='My Check-in'])[3]/following::label[1]");
		By uncheckbox_Update_MyCheckin = By.xpath(
				"(.//*[normalize-space(text()) and normalize-space(.)='My Check-in'])[3]/following::span[3]");
		By checkbox_Update_MyCheckin = By.xpath(
				"(.//*[normalize-space(text()) and normalize-space(.)='My Check-in'])[3]/following::label[2]");

		public void uncheckbox_Read_MyCheckin() {
			clickByJavaScript(uncheckbox_Read_MyCheckin);
		}

		public void checkbox_Read_MyCheckin() {
			clickByJavaScript(checkbox_Read_MyCheckin);
		}

		public void uncheckbox_Update_MyCheckin() {
			clickByJavaScript(uncheckbox_Update_MyCheckin);
		}

		public void checkbox_Update_MyCheckin() {
			clickByJavaScript(checkbox_Update_MyCheckin);
		}
	
	// ========================Check-In Setting
	// ==================================

	By uncheckbox_Read_CheckInSetting = By
			.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Check-in Setting'])[1]/following::span[1]");
	By uncheckbox_Update_CheckInSetting = By
			.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Check-in Setting'])[1]/following::span[2]");
	By uncheckbox_Create_CheckInSetting = By
			.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Check-in Setting'])[1]/following::span[3]");
	By uncheckbox_Delete_CheckInSetting = By
			.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Check-in Setting'])[1]/following::span[4]");
	By checkbox_Read_CheckInSetting = By
			.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Check-in Setting'])[1]/following::label[1]");
	By checkbox_Update_CheckInSetting = By
			.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Check-in Setting'])[1]/following::label[2]");
	By checkbox_Create_CheckInSetting = By
			.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Check-in Setting'])[1]/following::label[3]");
	By checkbox_Delete_CheckInSetting = By
			.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Check-in Setting'])[1]/following::label[4]");

	public void uncheckbox_Read_CheckInSetting() {
		clickByJavaScript(uncheckbox_Read_CheckInSetting);
	}

	public void uncheckbox_Update_CheckInSetting() {
		clickByJavaScript(uncheckbox_Update_CheckInSetting);
	}

	public void uncheckbox_Create_CheckInSetting() {
		clickByJavaScript(uncheckbox_Create_CheckInSetting);
	}

	public void uncheckbox_Delete_CheckInSetting() {
		clickByJavaScript(uncheckbox_Delete_CheckInSetting);
	}

	public void checkbox_Read_CheckInSetting() {
		clickByJavaScript(checkbox_Read_CheckInSetting);
	}

	public void checkbox_Update_CheckInSetting() {
		clickByJavaScript(checkbox_Update_CheckInSetting);
	}

	public void checkbox_Create_CheckInSetting() {
		clickByJavaScript(checkbox_Create_CheckInSetting);
	}

	public void checkbox_Delete_CheckInSetting() {
		clickByJavaScript(checkbox_Delete_CheckInSetting);
	}

	// ============= Project Settings ===============
	By uncheckbox_Read_ProjectSettings = By
			.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Project Settings'])[2]/following::span[1]");
	By uncheckbox_Update_ProjectSettings = By
			.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Project Settings'])[2]/following::span[2]");
	By uncheckbox_Create_ProjectSettings = By
			.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Project Settings'])[2]/following::span[3]");
	By uncheckbox_Delete_ProjectSettings = By
			.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Project Settings'])[2]/following::span[4]");
	By checkbox_Read_ProjectSettings = By
			.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Project Settings'])[2]/following::label[1]");
	By checkbox_Update_ProjectSettings = By
			.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Project Settings'])[2]/following::label[2]");
	By checkbox_Create_ProjectSettings = By
			.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Project Settings'])[2]/following::label[3]");
	By checkbox_Delete_ProjectSettings = By
			.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Project Settings'])[2]/following::label[4]");

	public void uncheckbox_Read_ProjectSettings() {
		clickByJavaScript(uncheckbox_Read_ProjectSettings);
	}

	public void uncheckbox_Update_ProjectSettings() {
		clickByJavaScript(uncheckbox_Update_ProjectSettings);
	}

	public void uncheckbox_Create_ProjectSettings() {
		clickByJavaScript(uncheckbox_Create_ProjectSettings);
	}

	public void uncheckbox_Delete_ProjectSettings() {
		clickByJavaScript(uncheckbox_Delete_ProjectSettings);
	}

	public void checkbox_Read_ProjectSettings() {
		clickByJavaScript(checkbox_Read_ProjectSettings);
	}

	public void checkbox_Update_ProjectSettings() {
		clickByJavaScript(checkbox_Update_ProjectSettings);
	}

	public void checkbox_Create_ProjectSettings() {
		clickByJavaScript(checkbox_Create_ProjectSettings);
	}

	public void checkbox_Delete_ProjectSettings() {
		clickByJavaScript(checkbox_Delete_ProjectSettings);
	}

	// ============== ED - Documents ==================
	By uncheckbox_Read_ED_Document = By
			.xpath("(.//*[normalize-space(text()) and normalize-space(.)='ED - Documents'])[1]/following::span[1]");
	By checkBox_Read_ED_Document = By
			.xpath("(.//*[normalize-space(text()) and normalize-space(.)='ED - Documents'])[1]/following::label[1]");

	public void uncheck_Read_ED_Documents() {
		clickByJavaScript(uncheckbox_Read_ED_Document);
	}

	public void check_Read_ED_Documents() {
		clickByJavaScript(checkBox_Read_ED_Document);
	}

	// ============== My Documents ==================
	By uncheckbox_Read_My_Document = By
			.xpath("(.//*[normalize-space(text()) and normalize-space(.)='My Documents'])[1]/following::span[1]");
	By checkBox_Read_My_Document = By
			.xpath("(.//*[normalize-space(text()) and normalize-space(.)='My Documents'])[1]/following::label[1]");

	By uncheckbox_Update_My_Document = By
			.xpath("(.//*[normalize-space(text()) and normalize-space(.)='My Documents'])[1]/following::span[3]");
	By checkBox_Update_My_Document = By
			.xpath("(.//*[normalize-space(text()) and normalize-space(.)='My Documents'])[1]/following::label[2]");

	By uncheckbox_Create_My_Document = By
			.xpath("(.//*[normalize-space(text()) and normalize-space(.)='My Documents'])[1]/following::span[5]");
	By checkBox_Create_My_Document = By
			.xpath("(.//*[normalize-space(text()) and normalize-space(.)='My Documents'])[1]/following::label[3]");

	By uncheckbox_Delete_My_Document = By
			.xpath("(.//*[normalize-space(text()) and normalize-space(.)='My Documents'])[1]/following::span[7]");
	By checkBox_Delete_My_Document = By
			.xpath("(.//*[normalize-space(text()) and normalize-space(.)='My Documents'])[1]/following::label[4]");

	public void uncheck_Read_My_Document() {
		clickByJavaScript(uncheckbox_Read_My_Document);
	}

	public void check_Read_My_Document() {
		clickByJavaScript(checkBox_Read_My_Document);
	}

	public void uncheckbox_Update_My_Document() {
		clickByJavaScript(uncheckbox_Update_My_Document);
	}

	public void checkBox_Update_My_Document() {
		clickByJavaScript(checkBox_Update_My_Document);
	}

	public void uncheckbox_Create_My_Document() {
		clickByJavaScript(uncheckbox_Update_My_Document);
	}

	public void checkBox_Create_My_Document() {
		clickByJavaScript(checkBox_Create_My_Document);
	}

	public void uncheckbox_Delete_My_Document() {
		clickByJavaScript(uncheckbox_Delete_My_Document);
	}

	public void checkBox_Delete_My_Document() {
		clickByJavaScript(checkBox_Delete_My_Document);
	}

	// =============== ED - Employement ===============
	By uncheckbox_Read_ED_Employment = By
			.xpath("(.//*[normalize-space(text()) and normalize-space(.)='ED - Employement'])[1]/following::span[1]");

	By checkbox_Read_ED_Employment = By
			.xpath("(.//*[normalize-space(text()) and normalize-space(.)='ED - Employement'])[1]/following::label[1]");
	By checkbox_Update_ED_Employment = By
			.xpath("(.//*[normalize-space(text()) and normalize-space(.)='ED - Employement'])[1]/following::label[2]");
	By checkbox_Create_ED_Employment = By
			.xpath("(.//*[normalize-space(text()) and normalize-space(.)='ED - Employement'])[1]/following::label[3]");
	By checkbox_Delete_ED_Employment = By
			.xpath("(.//*[normalize-space(text()) and normalize-space(.)='ED - Employement'])[1]/following::label[4]");

	public void checkbox_Read_ED_Employment() {
		clickByJavaScript(checkbox_Read_ED_Employment);
	}

	public void checkbox_Update_ED_Employment() {
		clickByJavaScript(checkbox_Update_ED_Employment);
	}

	public void checkbox_Create_ED_Employment() {
		clickByJavaScript(checkbox_Create_ED_Employment);
	}

	public void checkbox_Delete_ED_Employment() {
		clickByJavaScript(checkbox_Delete_ED_Employment);
	}

	public void choose_UnCheckbox_Read_ED_Employment() {
		clickByJavaScript(uncheckbox_Read_ED_Employment);
	}

	// =============== My - Employement ===============
	By uncheckbox_Read_My_Employment = By
			.xpath("(.//*[normalize-space(text()) and normalize-space(.)='My Employement'])[1]/following::span[1]");

	By checkbox_Read_My_Employment = By
			.xpath("(.//*[normalize-space(text()) and normalize-space(.)='My Employement'])[1]/following::label[1]");
	By checkbox_Update_My_Employment = By
			.xpath("(.//*[normalize-space(text()) and normalize-space(.)='My Employement'])[1]/following::label[2]");
	By checkbox_Create_My_Employment = By
			.xpath("(.//*[normalize-space(text()) and normalize-space(.)='My Employement'])[1]/following::label[3]");
	By checkbox_Delete_My_Employment = By
			.xpath("(.//*[normalize-space(text()) and normalize-space(.)='My Employement'])[1]/following::label[4]");

	public void checkbox_Read_My_Employment() {
		clickByJavaScript(checkbox_Read_My_Employment);
	}

	public void checkbox_Update_My_Employment() {
		clickByJavaScript(checkbox_Update_My_Employment);
	}

	public void checkbox_Create_My_Employment() {
		clickByJavaScript(checkbox_Create_My_Employment);
	}

	public void checkbox_Delete_My_Employment() {
		clickByJavaScript(checkbox_Delete_My_Employment);
	}

	public void uncheckbox_Read_My_Employment() {
		clickByJavaScript(uncheckbox_Read_My_Employment);
	}

	// ====================== Goal Board ==========================

	By uncheckbox_Read_Checkin_Board = By
			.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Check-in Board'])[2]/following::span[1]");

	By checkbox_Read_Checkin_Board = By
			.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Check-in Board'])[2]/following::label[1]");

	By checkbox_Update_Checkin_Board = By
			.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Check-in Board'])[2]/following::label[2]");

	By checkbox_Create_Checkin_Board = By
			.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Check-in Board'])[2]/following::label[3]");

	By checkbox_Delete_Checkin_Board = By
			.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Check-in Board'])[2]/following::label[4]");

	public void uncheckbox_Read_Checkin_Board() {
		clickByJavaScript(uncheckbox_Read_Checkin_Board);
	}

	public void checkbox_Read_Checkin_Board() {
		clickByJavaScript(checkbox_Read_Checkin_Board);
	}

	public void checkbox_Update_Checkin_Board() {
		clickByJavaScript(checkbox_Update_Checkin_Board);
	}

	public void checkbox_Create_Checkin_Board() {
		clickByJavaScript(checkbox_Create_Checkin_Board);
	}

	public void checkbox_Delete_Checkin_Board() {
		clickByJavaScript(checkbox_Delete_Checkin_Board);
	}

	// ====================== Goal Board ==========================

	By uncheckbox_Read_GoalBoard = By
			.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Goal Board'])[2]/following::span[1]");

	By checkbox_Read_GoalBoard = By
			.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Goal Board'])[2]/following::label[1]");

	By checkbox_Update_GoalBoard = By
			.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Goal Board'])[2]/following::label[2]");

	By checkbox_Create_GoalBoard = By
			.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Goal Board'])[2]/following::label[3]");

	By checkbox_Delete_GoalBoard = By
			.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Goal Board'])[2]/following::label[4]");

	public void uncheckbox_Read_GoalBoard() {
		clickByJavaScript(uncheckbox_Read_GoalBoard);
	}

	public void checkbox_Read_GoalBoard() {
		clickByJavaScript(checkbox_Read_GoalBoard);
	}

	public void checkbox_Update_GoalBoard() {
		clickByJavaScript(checkbox_Update_GoalBoard);
	}

	public void checkbox_Create_GoalBoard() {
		clickByJavaScript(checkbox_Create_GoalBoard);
	}

	public void checkbox_Delete_GoalBoard() {
		clickByJavaScript(checkbox_Delete_GoalBoard);
	}

	// ====================== Goal Management ==========================

	By uncheckbox_Read_GoalManagement = By
			.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Goal Management'])[2]/following::span[1]");

	By checkbox_Read_GoalManagement = By
			.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Goal Management'])[2]/following::label[1]");

	By checkbox_Update_GoalManagement = By
			.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Goal Management'])[2]/following::label[2]");

	By checkbox_Create_GoalManagement = By
			.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Goal Management'])[2]/following::label[3]");

	By checkbox_Delete_GoalManagement = By
			.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Goal Management'])[2]/following::label[4]");

	public void uncheckbox_Read_GoalManagement() {
		clickByJavaScript(uncheckbox_Read_GoalManagement);
	}

	public void checkbox_Read_GoalManagement() {
		clickByJavaScript(checkbox_Read_GoalManagement);
	}

	public void checkbox_Update_GoalManagement() {
		clickByJavaScript(checkbox_Update_GoalManagement);
	}

	public void checkbox_Create_GoalManagement() {
		clickByJavaScript(checkbox_Create_GoalManagement);
	}

	public void checkbox_Delete_GoalManagement() {
		clickByJavaScript(checkbox_Delete_GoalManagement);
	}
	
	// =================== MY GOAL ================ //
	
	By uncheckbox_Read_MyGoal = By.xpath(
			"(.//*[normalize-space(text()) and normalize-space(.)='My Goal'])[3]/following::span[1]");
	By checkbox_Read_MyGoal = By.xpath(
			"(.//*[normalize-space(text()) and normalize-space(.)='My Goal'])[3]/following::label[1]");
	By checkbox_Update_MyGoal = By.xpath(
			"(.//*[normalize-space(text()) and normalize-space(.)='My Goal'])[3]/following::label[2]");
	By checkbox_Create_MyGoal = By.xpath(
			"(.//*[normalize-space(text()) and normalize-space(.)='My Goal'])[3]/following::label[3]");
	By checkbox_Delete_MyGoal = By.xpath(
			"(.//*[normalize-space(text()) and normalize-space(.)='My Goal'])[3]/following::label[4]");
	
	public void uncheckbox_Read_MyGoal() {
		clickByJavaScript(uncheckbox_Read_MyGoal);
	}
	
	public void checkbox_Read_MyGoal() {
		clickByJavaScript(checkbox_Read_MyGoal);
	}
	
	public void checkbox_Update_MyGoal() {
		clickByJavaScript(checkbox_Update_MyGoal);
	}
	
	public void checkbox_Create_MyGoal() {
		clickByJavaScript(checkbox_Create_MyGoal);
	}
	
	public void checkbox_Delete_MyGoal() {
		clickByJavaScript(checkbox_Delete_MyGoal);
	}

	// ====================== Appraisal - Management - List 1
	// ==========================

	By checkbox_Read_uncheckbox_Read_AppraisalManagementList = By.xpath(
			"(.//*[normalize-space(text()) and normalize-space(.)='Appraisal - Management - List'])[1]/following::label[1]");

	By checkbox_Update_uncheckbox_Read_AppraisalManagementList = By.xpath(
			"(.//*[normalize-space(text()) and normalize-space(.)='Appraisal - Management - List'])[1]/following::label[2]");

	By checkbox_Create_uncheckbox_Read_AppraisalManagementList = By.xpath(
			"(.//*[normalize-space(text()) and normalize-space(.)='Appraisal - Management - List'])[1]/following::label[3]");

	By checkbox_Delete_uncheckbox_Read_AppraisalManagementList = By.xpath(
			"(.//*[normalize-space(text()) and normalize-space(.)='Appraisal - Management - List'])[1]/following::label[4]");

	By checkbox_Read_AppraisalManagementList = By.xpath(
			"(.//*[normalize-space(text()) and normalize-space(.)='Appraisal - Management - List'])[1]/following::label[1]");
	By uncheckbox_Read_AppraisalManagementList = By.xpath(
			"(.//*[normalize-space(text()) and normalize-space(.)='Appraisal - Management - List'])[1]/following::span[1]");
	By checkbox_Update_AppraisalManagementList = By.xpath(
			"(.//*[normalize-space(text()) and normalize-space(.)='Appraisal - Management - List'])[1]/following::label[2]");
	By checkbox_Create_AppraisalManagementList = By.xpath(
			"(.//*[normalize-space(text()) and normalize-space(.)='Appraisal - Management - List'])[1]/following::label[3]");
	By checkbox_Delete_AppraisalManagementList = By.xpath(
			"(.//*[normalize-space(text()) and normalize-space(.)='Appraisal - Management - List'])[1]/following::label[4]");
	By uncheckbox_Create_AppraisalManagementList = By.xpath(
			"(.//*[normalize-space(text()) and normalize-space(.)='Appraisal - Management - List'])[1]/following::span[5]");
	By uncheckbox_Update_AppraisalManagementList = By.xpath(
			"(.//*[normalize-space(text()) and normalize-space(.)='Appraisal - Management - List'])[1]/following::span[3]");
	By uncheckbox_Delete_AppraisalManagementList = By.xpath(
			"(.//*[normalize-space(text()) and normalize-space(.)='Appraisal - Management - List'])[1]/following::span[7]");

	public void checkbox_Read_AppraisalManagementList() {
		clickByJavaScript(checkbox_Read_AppraisalManagementList);
	}

	public void uncheckbox_Read_AppraisalManagementList() {
		clickByJavaScript(uncheckbox_Read_AppraisalManagementList);
	}

	public void checkbox_Create_AppraisalManagementList() {
		clickByJavaScript(checkbox_Create_AppraisalManagementList);
	}

	public void uncheckbox_Create_AppraisalManagementList() {
		clickByJavaScript(uncheckbox_Create_AppraisalManagementList);
	}

	public void checkbox_Update_AppraisalManagementList() {
		clickByJavaScript(checkbox_Update_AppraisalManagementList);
	}

	public void uncheckbox_Update_AppraisalManagementList() {
		clickByJavaScript(uncheckbox_Update_AppraisalManagementList);
	}

	public void checkbox_Delete_AppraisalManagementList() {
		clickByJavaScript(checkbox_Delete_AppraisalManagementList);
	}

	public void uncheckbox_Delete_AppraisalManagementList() {
		clickByJavaScript(uncheckbox_Delete_AppraisalManagementList);
	}

	// ====================== Appraisal - Management - Cycle
	// ==========================

	By uncheckbox_Read_AppraisalManagementCycle = By.xpath(
			"(.//*[normalize-space(text()) and normalize-space(.)='Appraisal - Management - Cycle'])[1]/following::span[1]");

	By checkbox_Read_uncheckbox_Read_AppraisalManagementCycle = By.xpath(
			"(.//*[normalize-space(text()) and normalize-space(.)='Appraisal - Management - Cycle'])[1]/following::label[1]");

	By checkbox_Update_uncheckbox_Read_AppraisalManagementCycle = By.xpath(
			"(.//*[normalize-space(text()) and normalize-space(.)='Appraisal - Management - Cycle'])[1]/following::label[2]");

	By checkbox_Create_uncheckbox_Read_AppraisalManagementCycle = By.xpath(
			"(.//*[normalize-space(text()) and normalize-space(.)='Appraisal - Management - Cycle'])[1]/following::label[3]");

	By checkbox_Delete_uncheckbox_Read_AppraisalManagementCycle = By.xpath(
			"(.//*[normalize-space(text()) and normalize-space(.)='Appraisal - Management - Cycle'])[1]/following::label[4]");

	By checkbox_Read_AppraisalManagementCycle = By.xpath(
			"(.//*[normalize-space(text()) and normalize-space(.)='Appraisal - Management - Cycle'])[1]/following::label[1]");

	public void uncheckbox_Read_AppraisalManagementCycle() {
		clickByJavaScript(uncheckbox_Read_AppraisalManagementCycle);
	}

	public void checkbox_Read_AppraisalManagementCycle() {
		clickByJavaScript(checkbox_Read_uncheckbox_Read_AppraisalManagementCycle);
	}

	public void checkbox_Update_AppraisalManagementCycle() {
		clickByJavaScript(checkbox_Update_uncheckbox_Read_AppraisalManagementCycle);
	}

	public void checkbox_Create_AppraisalManagementCycle() {
		clickByJavaScript(checkbox_Create_uncheckbox_Read_AppraisalManagementCycle);
	}

	public void checkbox_Delete_AppraisalManagementCycle() {
		clickByJavaScript(checkbox_Delete_uncheckbox_Read_AppraisalManagementCycle);
	}
	
	// ============== MY APPRAISAL =============//
	
	By uncheckbox_Read_MyAppraisal = By.xpath(
			"(.//*[normalize-space(text()) and normalize-space(.)='My Appraisal'])[3]/following::span[1]");
	
	public void uncheckbox_Read_MyAppraisal() {
		clickByJavaScript(uncheckbox_Read_MyAppraisal);
	}

	// ============== Head Count ===============================================
	By uncheckbox_Read_HeadCount = By
			.xpath("(.//*[normalize-space(text()) and normalize-space(.)='HeadCount'])[1]/following::span[1]");

	public void uncheckbox_Read_HeadCount() {
		clickByJavaScript(uncheckbox_Read_HeadCount);
	}

	// ======================== ED - Tasks
	// ======================================
	By uncheckbox_Read_ED_Tasks = By
			.xpath("(.//*[normalize-space(text()) and normalize-space(.)='ED - Tasks'])[1]/following::span[1]");

	By checkbox_Read_ED_Tasks = By
			.xpath("(.//*[normalize-space(text()) and normalize-space(.)='ED - Tasks'])[1]/following::label[1]");

	By checkbox_Update_ED_Tasks = By
			.xpath("(.//*[normalize-space(text()) and normalize-space(.)='ED - Tasks'])[1]/following::label[2]");

	By checkbox_Create_ED_Tasks = By
			.xpath("(.//*[normalize-space(text()) and normalize-space(.)='ED - Tasks'])[1]/following::label[3]");

	By checkbox_Delete_ED_Tasks = By
			.xpath("(.//*[normalize-space(text()) and normalize-space(.)='ED - Tasks'])[1]/following::label[4]");

	public void choose_UnCheckbox_Read_ED_Tasks() {
		clickByJavaScript(uncheckbox_Read_ED_Tasks);
	}

	public void choose_checkbox_Read_ED_Tasks() {
		clickByJavaScript(checkbox_Read_ED_Tasks);

	}

	public void choose_checkbox_Update_ED_Tasks() {
		clickByJavaScript(checkbox_Update_ED_Tasks);

	}

	public void choose_checkbox_Create_ED_Tasks() {
		clickByJavaScript(checkbox_Create_ED_Tasks);

	}

	public void choose_checkbox_Delete_ED_Tasks() {
		clickByJavaScript(checkbox_Delete_ED_Tasks);

	}

	// ======================== My - Tasks
	// ======================================
	By uncheckbox_Read_My_Tasks = By
			.xpath("(.//*[normalize-space(text()) and normalize-space(.)='My Tasks'])[1]/following::span[1]");

	By checkbox_Read_My_Tasks = By
			.xpath("(.//*[normalize-space(text()) and normalize-space(.)='My Tasks'])[1]/following::label[1]");

	By checkbox_Update_My_Tasks = By
			.xpath("(.//*[normalize-space(text()) and normalize-space(.)='My Tasks'])[1]/following::label[2]");

	By checkbox_Create_My_Tasks = By
			.xpath("(.//*[normalize-space(text()) and normalize-space(.)='My Tasks'])[1]/following::label[3]");

	By checkbox_Delete_My_Tasks = By
			.xpath("(.//*[normalize-space(text()) and normalize-space(.)='My Tasks'])[1]/following::label[4]");

	public void uncheckbox_Read_My_Tasks() {
		clickByJavaScript(uncheckbox_Read_My_Tasks);
	}

	public void checkbox_Read_My_Tasks() {
		clickByJavaScript(checkbox_Read_My_Tasks);

	}

	public void checkbox_Update_My_Tasks() {
		clickByJavaScript(checkbox_Update_My_Tasks);

	}

	public void checkbox_Create_My_Tasks() {
		clickByJavaScript(checkbox_Create_My_Tasks);

	}

	public void checkbox_Delete_My_Tasks() {
		clickByJavaScript(checkbox_Delete_My_Tasks);

	}

	// ===================== ED - Projects =====================================

	By unCheckbox_Read_ED_Project = By
			.xpath("(.//*[normalize-space(text()) and normalize-space(.)='ED - Projects'])[1]/following::span[1]");

	By checkbox_Read_ED_Project = By
			.xpath("(.//*[normalize-space(text()) and normalize-space(.)='ED - Projects'])[1]/following::label[1]");
	By unCheckbox_Update_ED_Project = By
			.xpath("(.//*[normalize-space(text()) and normalize-space(.)='ED - Projects'])[1]/following::span[2]");

	By checkbox_Update_ED_Project = By
			.xpath("(.//*[normalize-space(text()) and normalize-space(.)='ED - Projects'])[1]/following::label[2]");

	By unCheckbox_Create_ED_Project = By
			.xpath("(.//*[normalize-space(text()) and normalize-space(.)='ED - Projects'])[1]/following::span[3]");

	By checkbox_Create_ED_Project = By
			.xpath("(.//*[normalize-space(text()) and normalize-space(.)='ED - Projects'])[1]/following::label[3]");

	By unCheckbox_Delete_ED_Project = By
			.xpath("(.//*[normalize-space(text()) and normalize-space(.)='ED - Projects'])[1]/following::span[4]");

	By checkbox_Delete_ED_Project = By
			.xpath("(.//*[normalize-space(text()) and normalize-space(.)='ED - Projects'])[1]/following::label[4]");

	public void uncheck_Read_ED_Projects() {
		clickByJavaScript(unCheckbox_Read_ED_Project);
	}

	public void check_Read_ED_Projects() {
		clickByJavaScript(unCheckbox_Read_ED_Project);
	}

	public void uncheck_Create_ED_Projects() {
		clickByJavaScript(unCheckbox_Create_ED_Project);
	}

	public void check_Create_ED_Projects() {
		clickByJavaScript(checkbox_Create_ED_Project);
	}

	public void uncheck_Update_ED_Projects() {
		clickByJavaScript(unCheckbox_Update_ED_Project);
	}

	public void check_Update_ED_Projects() {
		clickByJavaScript(checkbox_Update_ED_Project);
	}

	public void uncheck_Delete_ED_Projects() {
		clickByJavaScript(unCheckbox_Delete_ED_Project);
	}

	public void check_Delete_ED_Projects() {
		clickByJavaScript(checkbox_Delete_ED_Project);
	}

	public void unCheckbox_Read_ED_Project() {
		clickByJavaScript(unCheckbox_Read_ED_Project);
	}

	// ===================== My - Projects =====================================

	By unCheckbox_Read_My_Project = By
			.xpath("(.//*[normalize-space(text()) and normalize-space(.)='My Projects'])[1]/following::span[1]");

	By checkbox_Read_My_Project = By
			.xpath("(.//*[normalize-space(text()) and normalize-space(.)='My Projects'])[1]/following::label[1]");
	By unCheckbox_Update_My_Project = By
			.xpath("(.//*[normalize-space(text()) and normalize-space(.)='My Projects'])[1]/following::span[2]");

	By checkbox_Update_My_Project = By
			.xpath("(.//*[normalize-space(text()) and normalize-space(.)='My Projects'])[1]/following::label[2]");

	By unCheckbox_Create_My_Project = By
			.xpath("(.//*[normalize-space(text()) and normalize-space(.)='My Projects'])[1]/following::span[3]");

	By checkbox_Create_My_Project = By
			.xpath("(.//*[normalize-space(text()) and normalize-space(.)='My Projects'])[1]/following::label[3]");

	By unCheckbox_Delete_My_Project = By
			.xpath("(.//*[normalize-space(text()) and normalize-space(.)='My Projects'])[1]/following::span[4]");

	By checkbox_Delete_My_Project = By
			.xpath("(.//*[normalize-space(text()) and normalize-space(.)='My Projects'])[1]/following::label[4]");

	public void unCheckbox_Read_My_Project() {
		clickByJavaScript(unCheckbox_Read_My_Project);
	}

	public void checkbox_Read_My_Project() {
		clickByJavaScript(checkbox_Read_My_Project);
	}

	public void checkbox_Update_My_Project() {
		clickByJavaScript(checkbox_Update_My_Project);
	}

	public void checkbox_Create_My_Project() {
		clickByJavaScript(checkbox_Create_My_Project);
	}

	public void checkbox_Delete_My_Project() {
		clickByJavaScript(checkbox_Delete_My_Project);
	}

	// ================= ED - Assets
	// ===============================================

	By unCheckbox_Read_ED_Assets = By
			.xpath("(.//*[normalize-space(text()) and normalize-space(.)='ED - Assets'])[1]/following::span[1]");

	By checkbox_Read_ED_Assets = By
			.xpath("(.//*[normalize-space(text()) and normalize-space(.)='ED - Assets'])[1]/following::label[1]");

	By unCheckbox_Update_ED_Assets = By
			.xpath("(.//*[normalize-space(text()) and normalize-space(.)='ED - Assets'])[1]/following::span[2]");

	By checkbox_Update_ED_Assets = By
			.xpath("(.//*[normalize-space(text()) and normalize-space(.)='ED - Assets'])[1]/following::label[2]");

	By unCheckbox_Create_ED_Assets = By
			.xpath("(.//*[normalize-space(text()) and normalize-space(.)='ED - Assets'])[1]/following::span[3]");

	By checkbox_Create_ED_Assets = By
			.xpath("(.//*[normalize-space(text()) and normalize-space(.)='ED - Assets'])[1]/following::label[3]");

	By unCheckbox_Delete_ED_Assets = By
			.xpath("(.//*[normalize-space(text()) and normalize-space(.)='ED - Assets'])[1]/following::span[4]");

	By checkbox_Delete_ED_Assets = By
			.xpath("(.//*[normalize-space(text()) and normalize-space(.)='ED - Assets'])[1]/following::label[4]");

	public void checkbox_Update_ED_Assets() {
		clickByJavaScript(checkbox_Update_ED_Assets);
	}

	public void unCheckbox_Update_ED_Assets() {
		clickByJavaScript(unCheckbox_Update_ED_Assets);
	}

	public void checkbox_Create_ED_Assets() {
		clickByJavaScript(checkbox_Create_ED_Assets);
	}

	public void unCheckbox_Create_ED_Assets() {
		clickByJavaScript(unCheckbox_Create_ED_Assets);
	}

	public void checkbox_Delete_ED_Assets() {
		clickByJavaScript(checkbox_Delete_ED_Assets);
	}

	public void unCheckbox_Delete_ED_Assets() {
		clickByJavaScript(unCheckbox_Delete_ED_Assets);
	}

	public void checkbox_Read_ED_Assets() {
		clickByJavaScript(checkbox_Read_ED_Assets);
	}

	public void unCheckbox_Read_ED_Assets() {
		clickByJavaScript(unCheckbox_Read_ED_Assets);
	}

	// ============== KPI Board ============================================
	By checkbox_Read_Employee_KPI = By
			.xpath("(.//*[normalize-space(text()) and normalize-space(.)='KPI Board'])[3]/following::label[1]");

	By unCheckbox_Read_Employee_KPI = By
			.xpath("(.//*[normalize-space(text()) and normalize-space(.)='KPI Board'])[3]/following::span[1]");

	By checkbox_Update_Employee_KPI = By
			.xpath("(.//*[normalize-space(text()) and normalize-space(.)='KPI Board'])[3]/following::label[2]");

	By unCheckbox_Update_Employee_KPI = By
			.xpath("(.//*[normalize-space(text()) and normalize-space(.)='KPI Board'])[3]/following::span[3]");

	public void checkbox_Read_Employee_KPI() {
		clickByJavaScript(checkbox_Read_Employee_KPI);
	}

	public void unCheckbox_Read_Employee_KPI() {
		clickByJavaScript(unCheckbox_Read_Employee_KPI);
	}

	public void checkbox_Update_Employee_KPI() {
		clickByJavaScript(checkbox_Update_Employee_KPI);
	}

	public void unCheckbox_Update_Employee_KPI() {
		clickByJavaScript(unCheckbox_Update_Employee_KPI);
	}
	
	// ================ MY KPI =================== //
	
	By uncheckbox_Read_MyKPI = By.xpath(
			"(.//*[normalize-space(text()) and normalize-space(.)='My KPI'])[4]/following::span[1]");
	
	public void uncheckbox_Read_MyKPI() {
		clickByJavaScript(uncheckbox_Read_MyKPI);
	}
	

	// ================ MY KPI by Project =================== //
	
	By uncheckbox_Read_MyKPIbyProject = By.xpath(
				"(.//*[normalize-space(text()) and normalize-space(.)='My KPI - Project'])[1]/following::span[1]");
		
	public void uncheckbox_Read_MyKPIbyProject() {
		clickByJavaScript(uncheckbox_Read_MyKPIbyProject);
	}
		
	By checkbox_Read_MyKPIbyProject = By.xpath(
				"(.//*[normalize-space(text()) and normalize-space(.)='My KPI - Project'])[1]/following::label[1]");
		
	public void checkbox_Read_MyKPIbyProject() {
		clickByJavaScript(checkbox_Read_MyKPIbyProject);
	}

	// ============== KPI Board By Project ============================================
		By checkbox_Read_KPIBoardByProject = By
				.xpath("(.//*[normalize-space(text()) and normalize-space(.)='KPI Board - Project'])[1]/following::label[1]");

		By unCheckbox_Read_KPIBoardByProject = By
				.xpath("(.//*[normalize-space(text()) and normalize-space(.)='KPI Board - Project'])[1]/following::span[1]");

		By checkbox_Update_KPIBoardByProject = By
				.xpath("(.//*[normalize-space(text()) and normalize-space(.)='KPI Board - Project'])[1]/following::label[2]");

		By unCheckbox_Update_KPIBoardByProject = By
				.xpath("(.//*[normalize-space(text()) and normalize-space(.)='KPI Board - Project'])[1]/following::span[3]");
		
		By checkbox_Create_KPIBoardByProject = By
				.xpath("(.//*[normalize-space(text()) and normalize-space(.)='KPI Board - Project'])[1]/following::label[3]");

		By unCheckbox_Create_KPIBoardByProject = By
				.xpath("(.//*[normalize-space(text()) and normalize-space(.)='KPI Board - Project'])[1]/following::span[5]");

		By checkbox_Delete_KPIBoardByProject = By
				.xpath("(.//*[normalize-space(text()) and normalize-space(.)='KPI Board - Project'])[1]/following::label[4]");

		By unCheckbox_Delete_KPIBoardByProject = By
				.xpath("(.//*[normalize-space(text()) and normalize-space(.)='KPI Board - Project'])[1]/following::span[7]");

		public void checkbox_Read_KPIBoardByProject() {
			clickByJavaScript(checkbox_Read_KPIBoardByProject);
		}

		public void unCheckbox_Read_KPIBoardByProject() {
			clickByJavaScript(unCheckbox_Read_KPIBoardByProject);
		}

		public void checkbox_Update_KPIBoardByProject() {
			clickByJavaScript(checkbox_Update_KPIBoardByProject);
		}

		public void unCheckbox_Update_KPIBoardByProject() {
			clickByJavaScript(unCheckbox_Update_KPIBoardByProject);
		}
		
		public void checkbox_Create_KPIBoardByProject() {
			clickByJavaScript(checkbox_Create_KPIBoardByProject);
		}

		public void unCheckbox_Create_KPIBoardByProject() {
			clickByJavaScript(unCheckbox_Create_KPIBoardByProject);
		}

		public void checkbox_Delete_KPIBoardByProject() {
			clickByJavaScript(checkbox_Delete_KPIBoardByProject);
		}

		public void unCheckbox_Delete_KPIBoardByProject() {
			clickByJavaScript(unCheckbox_Delete_KPIBoardByProject);
		}


	// ============== Training Permission - Training Management
	// ============================================
	By checkbox_Read_TrainingManagement = By.xpath(
			"(.//*[normalize-space(text()) and normalize-space(.)='Training Management'])[2]/following::label[1]");

	By uncheckbox_Read_TrainingManagement = By.xpath(
			"(.//*[normalize-space(text()) and normalize-space(.)='Training Management'])[2]/following::span[1]");

	By checkbox_Update_TrainingManagement = By.xpath(
			"(.//*[normalize-space(text()) and normalize-space(.)='Training Management'])[2]/following::label[2]");

	By checkbox_Delete_TrainingManagement = By.xpath(
			"(.//*[normalize-space(text()) and normalize-space(.)='Training Management'])[2]/following::label[4]");

	public void checkbox_Read_TrainingManagement() {
		clickByJavaScript(checkbox_Read_TrainingManagement);
	}

	public void uncheckbox_Read_TrainingManagement() {
		clickByJavaScript(uncheckbox_Read_TrainingManagement);
	}

	public void checkbox_Update_TrainingManagement() {
		clickByJavaScript(checkbox_Update_TrainingManagement);
	}

	public void checkbox_Delete_TrainingManagement() {
		clickByJavaScript(checkbox_Delete_TrainingManagement);
	}

	// ============== Training Permission - Programs
	// ============================================
	By checkbox_Read_Programs = By
			.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Programs'])[2]/following::label[1]");
	By uncheckbox_Read_Programs = By
			.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Programs'])[2]/following::span[1]");
	By checkbox_Update_Programs = By
			.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Programs'])[2]/following::label[2]");
	By uncheckbox_Update_Programs = By
			.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Programs'])[2]/following::span[3]");
	By checkbox_Create_Programs = By
			.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Programs'])[2]/following::label[3]");
	By uncheckbox_Create_Programs = By
			.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Programs'])[2]/following::span[5]]");
	By checkbox_Delete_Programs = By
			.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Programs'])[2]/following::label[4]");
	By uncheckbox_Delete_Programs = By
			.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Programs'])[2]/following::span[7]");

	public void checkbox_Read_Programs() {
		clickByJavaScript(checkbox_Read_Programs);
	}

	public void uncheckbox_Read_Programs() {
		clickByJavaScript(uncheckbox_Read_Programs);
	}

	public void checkbox_Update_Programs() {
		clickByJavaScript(checkbox_Update_Programs);
	}

	public void unCheckbox_Update_Programs() {
		clickByJavaScript(uncheckbox_Update_Programs);
	}

	public void checkbox_Create_Programs() {
		clickByJavaScript(checkbox_Create_Programs);
	}

	public void unCheckbox_Create_Programs() {
		clickByJavaScript(uncheckbox_Create_Programs);
	}

	public void checkbox_Delete_Programs() {
		clickByJavaScript(checkbox_Delete_Programs);
	}

	public void unCheckbox_Delete_Programs() {
		clickByJavaScript(uncheckbox_Delete_Programs);
	}

	// ============== Training Permission - My Assigned Training
	// ============================================
	By checkbox_Read_MyAssignedTraining = By.xpath(
			"(.//*[normalize-space(text()) and normalize-space(.)='My Assigned Training'])[3]/following::label[1]");

	By uncheckbox_Read_MyAssignedTraining = By.xpath(
			"(.//*[normalize-space(text()) and normalize-space(.)='My Assigned Training'])[3]/following::span[1]");

	public void checkbox_Read_MyAssignedTraining() {
		clickByJavaScript(checkbox_Read_MyAssignedTraining);
	}

	public void uncheckbox_Read_MyAssignedTraining() {
		clickByJavaScript(uncheckbox_Read_MyAssignedTraining);
	}

	// ============== KPI Settings By Unit ============================================
	By checkbox_Read_KPI_Settings = By
			.xpath("(.//*[normalize-space(text()) and normalize-space(.)='KPI Settings'])[2]/following::label[1]");
	By unCheckbox_Read_KPI_Settings = By
			.xpath("(.//*[normalize-space(text()) and normalize-space(.)='KPI Settings'])[2]/following::span[1]");
	By checkbox_Update_KPI_Settings = By
			.xpath("(.//*[normalize-space(text()) and normalize-space(.)='KPI Settings'])[2]/following::label[2]");
	By unCheckbox_Update_KPI_Settings = By
			.xpath("(.//*[normalize-space(text()) and normalize-space(.)='KPI Settings'])2]/following::span[2]");
	By checkbox_Create_KPI_Settings = By
			.xpath("(.//*[normalize-space(text()) and normalize-space(.)='KPI Settings'])[2]/following::label[3]");
	By unCheckbox_Create_KPI_Settings = By
			.xpath("(.//*[normalize-space(text()) and normalize-space(.)='KPI Settings'])[2]/following::span[3]");
	By checkbox_Delete_KPI_Settings = By
			.xpath("(.//*[normalize-space(text()) and normalize-space(.)='KPI Settings'])[2]/following::label[4]");
	By unCheckbox_Delete_KPI_Settings = By
			.xpath("(.//*[normalize-space(text()) and normalize-space(.)='KPI Settings'])[2]/following::span[4]");

	public void uncheck_Read_KPISettings() {
		clickByJavaScript(uncheckbox_Read_KPISettings);
	}

	public void check_Read_KPISettings() {
		clickByJavaScript(checkbox_Read_KPISettings);
	}

	public void check_Update_KPISettings() {
		clickByJavaScript(checkbox_Update_KPISettings);
	}

	public void check_Create_KPISettings() {
		clickByJavaScript(checkbox_Create_KPISettings);
	}

	public void check_Delete_KPISettings() {
		clickByJavaScript(checkbox_Delete_KPISettings);
	}
	
	// ============== KPI Settings By Project ============================================
		By checkbox_Read_KPI_SettingsByProject = By
				.xpath("(.//*[normalize-space(text()) and normalize-space(.)='KPI Settings - Project'])[1]/following::label[1]");
		By unCheckbox_Read_KPI_SettingsByProject = By
				.xpath("(.//*[normalize-space(text()) and normalize-space(.)='KPI Settings - Project'])[1]/following::span[1]");
		By checkbox_Update_KPI_SettingsByProject = By
				.xpath("(.//*[normalize-space(text()) and normalize-space(.)='KPI Settings - Project'])[1]/following::label[2]");
		By unCheckbox_Update_KPI_SettingsByProject = By
				.xpath("(.//*[normalize-space(text()) and normalize-space(.)='KPI Settings - Project'])[1]/following::span[2]");
		By checkbox_Create_KPI_SettingsByProject = By
				.xpath("(.//*[normalize-space(text()) and normalize-space(.)='KPI Settings - Project'])[1]/following::label[3]");
		By unCheckbox_Create_KPI_SettingsByProject = By
				.xpath("(.//*[normalize-space(text()) and normalize-space(.)='KPI Settings - Project'])[1]/following::span[3]");
		By checkbox_Delete_KPI_SettingsByProject = By
				.xpath("(.//*[normalize-space(text()) and normalize-space(.)='KPI Settings - Project'])[1]/following::label[4]");
		By unCheckbox_Delete_KPI_SettingsByProject = By
				.xpath("(.//*[normalize-space(text()) and normalize-space(.)='KPI Settings - Project'])[1]/following::span[4]");

		public void unCheckbox_Read_KPI_SettingsByProject() {
			clickByJavaScript(unCheckbox_Read_KPI_SettingsByProject);
		}

		public void checkbox_Read_KPI_SettingsByProject() {
			clickByJavaScript(checkbox_Read_KPI_SettingsByProject);
		}

		public void checkbox_Update_KPI_SettingsByProject() {
			clickByJavaScript(checkbox_Update_KPI_SettingsByProject);
		}

		public void checkbox_Create_KPI_SettingsByProject() {
			clickByJavaScript(checkbox_Create_KPI_SettingsByProject);
		}

		public void checkbox_Delete_KPI_SettingsByProject() {
			clickByJavaScript(checkbox_Delete_KPI_SettingsByProject);
		}

	// ============== Timesheet - Management
	// ============================================
	By checkbox_Read_Timesheet_Management = By.xpath(
			"(.//*[normalize-space(text()) and normalize-space(.)='Timesheet - Management'])[1]/following::label[1]");

	By unCheckbox_Read_Timesheet_Management = By.xpath(
			"(.//*[normalize-space(text()) and normalize-space(.)='Timesheet - Management'])[1]/following::span[1]");

	By checkbox_Update_Timesheet_Management = By.xpath(
			"(.//*[normalize-space(text()) and normalize-space(.)='Timesheet - Management'])[1]/following::label[2]");

	By unCheckbox_Update_Timesheet_Management = By.xpath(
			"(.//*[normalize-space(text()) and normalize-space(.)='Timesheet - Management'])[1]/following::span[3]");

	By checkbox_Create_Timesheet_Management = By.xpath(
			"(.//*[normalize-space(text()) and normalize-space(.)='Timesheet - Management'])[1]/following::label[3]");

	By unCheckbox_Create_Timesheet_Management = By.xpath(
			"(.//*[normalize-space(text()) and normalize-space(.)='Timesheet - Management'])[1]/following::span[5]");

	By checkbox_Delete_Timesheet_Management = By.xpath(
			"(.//*[normalize-space(text()) and normalize-space(.)='Timesheet - Management'])[1]/following::label[4]");

	By unCheckbox_Delete_Timesheet_Management = By.xpath(
			"(.//*[normalize-space(text()) and normalize-space(.)='Timesheet - Management'])[1]/following::span[7]");

	public void checkbox_Read_Timesheet_Management() {
		clickByJavaScript(checkbox_Read_Timesheet_Management);
	}

	public void unCheckbox_Read_Timesheet_Management() {
		clickByJavaScript(unCheckbox_Read_Timesheet_Management);
	}

	public void checkbox_Update_Timesheet_Management() {
		clickByJavaScript(checkbox_Update_Timesheet_Management);
	}

	public void unCheckbox_Update_Timesheet_Management() {
		clickByJavaScript(unCheckbox_Update_Timesheet_Management);
	}

	public void checkbox_Create_Timesheet_Management() {
		clickByJavaScript(checkbox_Create_Timesheet_Management);
	}

	public void unCheckbox_Create_Timesheet_Management() {
		clickByJavaScript(unCheckbox_Create_Timesheet_Management);
	}

	public void checkbox_Delete_Timesheet_Management() {
		clickByJavaScript(checkbox_Delete_Timesheet_Management);
	}

	public void unCheckbox_Delete_Timesheet_Management() {
		clickByJavaScript(unCheckbox_Delete_Timesheet_Management);
	}

	// ============== Timesheet - Configuration
	// ============================================
	By checkbox_Read_Timesheet_Configuration = By.xpath(
			"(.//*[normalize-space(text()) and normalize-space(.)='Timesheet - Configuration'])[1]/following::label[1]");

	By unCheckbox_Read_Timesheet_Configuration = By.xpath(
			"(.//*[normalize-space(text()) and normalize-space(.)='Timesheet - Configuration'])[1]/following::span[1]");

	By checkbox_Update_Timesheet_Configuration = By.xpath(
			"(.//*[normalize-space(text()) and normalize-space(.)='Timesheet - Configuration'])[1]/following::label[2]");

	By unCheckbox_Update_Timesheet_Configuration = By.xpath(
			"(.//*[normalize-space(text()) and normalize-space(.)='Timesheet - Configuration'])[1]/following::span[2]");

	By checkbox_Create_Timesheet_Configuration = By.xpath(
			"(.//*[normalize-space(text()) and normalize-space(.)='Timesheet - Configuration'])[1]/following::label[3]");

	By unCheckbox_Create_Timesheet_Configuration = By.xpath(
			"(.//*[normalize-space(text()) and normalize-space(.)='Timesheet - Configuration'])[1]/following::span[3]");

	By checkbox_Delete_Timesheet_Configuration = By.xpath(
			"(.//*[normalize-space(text()) and normalize-space(.)='Timesheet - Configuration'])[1]/following::label[4]");

	By unCheckbox_Delete_Timesheet_Configuration = By.xpath(
			"(.//*[normalize-space(text()) and normalize-space(.)='Timesheet - Configuration'])[1]/following::span[4]");

	public void checkbox_Read_Timesheet_Configuration() {
		clickByJavaScript(checkbox_Read_Timesheet_Configuration);
	}

	public void unCheckbox_Read_Timesheet_Configuration() {
		clickByJavaScript(unCheckbox_Read_Timesheet_Configuration);
	}

	public void checkbox_Update_Timesheet_Configuration() {
		clickByJavaScript(checkbox_Update_Timesheet_Configuration);
	}

	public void unCheckbox_Update_Timesheet_Configuration() {
		clickByJavaScript(unCheckbox_Update_Timesheet_Configuration);
	}

	public void checkbox_Create_Timesheet_Configuration() {
		clickByJavaScript(checkbox_Create_Timesheet_Configuration);
	}

	public void unCheckbox_Create_Timesheet_Configuration() {
		clickByJavaScript(unCheckbox_Create_Timesheet_Configuration);
	}

	public void checkbox_Delete_Timesheet_Configuration() {
		clickByJavaScript(checkbox_Delete_Timesheet_Configuration);
	}

	public void unCheckbox_Delete_Timesheet_Configuration() {
		clickByJavaScript(unCheckbox_Delete_Timesheet_Configuration);
	}

	// ============== Timesheet - Management
	// ============================================
	By checkbox_Read_Timesheet_MyTimesheet = By.xpath(
			"(.//*[normalize-space(text()) and normalize-space(.)='Timesheet - My Timesheet'])[1]/following::label[1]");

	By unCheckbox_Read_Timesheet_MyTimesheet = By.xpath(
			"(.//*[normalize-space(text()) and normalize-space(.)='Timesheet - My Timesheet'])[1]/following::span[1]");

	By checkbox_Update_Timesheet_MyTimesheet = By.xpath(
			"(.//*[normalize-space(text()) and normalize-space(.)='Timesheet - My Timesheet'])[1]/following::label[2]");

	public void checkbox_Read_Timesheet_MyTimesheet() {
		clickByJavaScript(checkbox_Read_Timesheet_MyTimesheet);
	}

	public void unCheckbox_Read_Timesheet_MyTimesheet() {
		clickByJavaScript(unCheckbox_Read_Timesheet_MyTimesheet);
	}

	public void checkbox_Update_Timesheet_MyTimesheet() {
		clickByJavaScript(checkbox_Update_Timesheet_MyTimesheet);
	}

	// =============Project Management Permission - Quota Management====
	By checkbox_Read_QuotaManagement = By
			.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Quota Management'])[1]/following::label[1]");
	By uncheckbox_Read_QuotaManagement = By
			.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Quota Management'])[1]/following::span[1]");
	By checkbox_Update_QuotaManagement = By
			.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Quota Management'])[1]/following::label[2]");
	By uncheckbox_Update_QuotaManagement = By
			.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Quota Management'])[1]/following::span[2]");
	By checkbox_Create_QuotaManagement = By
			.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Quota Management'])[1]/following::label[3]");
	By uncheckbox_Create_QuotaManagement = By
			.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Quota Management'])[1]/following::span[3]");
	By checkbox_Delete_QuotaManagement = By
			.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Quota Management'])[1]/following::label[4]");
	By uncheckbox_Delete_QuotaManagement = By
			.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Quota Management'])[1]/following::span[4]");

	public void uncheck_Read_QuotaManagement() {
		clickByJavaScript(uncheckbox_Read_QuotaManagement);
	}

	public void check_Read_QuotaManagement() {
		clickByJavaScript(checkbox_Read_QuotaManagement);
	}

	public void uncheck_Update_QuotaManagement() {
		clickByJavaScript(uncheckbox_Update_QuotaManagement);
	}

	public void check_Update_QuotaManagement() {
		clickByJavaScript(checkbox_Update_QuotaManagement);
	}

	public void uncheck_Create_QuotaManagement() {
		clickByJavaScript(uncheckbox_Create_QuotaManagement);
	}

	public void check_Create_QuotaManagement() {
		clickByJavaScript(checkbox_Create_QuotaManagement);
	}

	public void uncheck_Delete_QuotaManagement() {
		clickByJavaScript(uncheckbox_Delete_QuotaManagement);
	}

	public void check_Delete_QuotaManagement() {
		clickByJavaScript(checkbox_Delete_QuotaManagement);
	}

	// =============Talent Permission - Competency - Settings - Competency Review
	// Schedule=======//

	By uncheckbox_Read_CompetencySettings_CompetencyReviewSchedule = By.xpath(
			"(.//*[normalize-space(text()) and normalize-space(.)='Competency - Settings - Competency Review Schedule'])[1]/following::span[1]");
	By checkbox_Read_CompetencySettings_CompetencyReviewSchedule = By.xpath(
			"(.//*[normalize-space(text()) and normalize-space(.)='Competency - Settings - Competency Review Schedule'])[1]/following::label[1]");

	public void uncheckbox_Read_CompetencySettings_CompetencyReviewSchedule() {
		clickByJavaScript(uncheckbox_Read_CompetencySettings_CompetencyReviewSchedule);
	}

	public void checkbox_Read_CompetencySettings_CompetencyReviewSchedule() {
		clickByJavaScript(checkbox_Read_CompetencySettings_CompetencyReviewSchedule);
	}

	// ==========================================================================//

	// =============Talent Permission - Competency - Settings - Certificate/Skill
	// Configuration====//

	By uncheckbox_Read_CompetencySettings_Certificate_SkillConfiguration = By.xpath(
			"(.//*[normalize-space(text()) and normalize-space(.)='Competency - Settings - Certificate/Skill Configuration'])[1]/following::span[1]");
	By checkbox_Read_CompetencySettings_Certificate_SkillConfiguration = By.xpath(
			"(.//*[normalize-space(text()) and normalize-space(.)='Competency - Settings - Certificate/Skill Configuration'])[1]/following::label[1]");
	By checkbox_Update_CompetencySettings_Certificate_SkillConfiguration = By
			.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Competency - Settings - Certificate/Skill Configuration'])[1]/following::label[2]");
	By checkbox_Create_CompetencySettings_Certificate_SkillConfiguration = By
			.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Competency - Settings - Certificate/Skill Configuration'])[1]/following::label[3]");
	By checkbox_Delete_CompetencySettings_Certificate_SkillConfiguration = By
			.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Competency - Settings - Certificate/Skill Configuration'])[1]/following::label[4]");

	public void uncheck_Read_CompetencySettings_Certificate_SkillConfiguration() {
		clickByJavaScript(uncheckbox_Read_CompetencySettings_Certificate_SkillConfiguration);
	}

	public void checkbox_Read_CompetencySettings_Certificate_SkillConfiguration() {
		clickByJavaScript(checkbox_Read_CompetencySettings_Certificate_SkillConfiguration);
	}

	public void checkbox_Update_CompetencySettings_Certificate_SkillConfiguration() {
		clickByJavaScript(checkbox_Update_CompetencySettings_Certificate_SkillConfiguration);
	}

	public void checkbox_Create_CompetencySettings_Certificate_SkillConfiguration() {
		clickByJavaScript(checkbox_Create_CompetencySettings_Certificate_SkillConfiguration);
	}

	public void checkbox_Delete_CompetencySettings_Certificate_SkillConfiguration() {
		clickByJavaScript(checkbox_Delete_CompetencySettings_Certificate_SkillConfiguration);
	}

	// ==========================================================================//

	// =============Talent Permission - Competency - My Competencies=======

	By UnCheckbox_Read_TalentPermission_MyCompetencies = By
			.xpath("(.//*[normalize-space(text()) and normalize-space(.)='My Competencies'])[2]/following::span[1]");

	By Checkbox_Read_TalentPermission_MyCompetencies = By
			.xpath("(.//*[normalize-space(text()) and normalize-space(.)='My Competencies'])[2]/following::label[1]");

	public void UnCheckbox_Read_TalentPermission_MyCompetencies() {
		clickByJavaScript(UnCheckbox_Read_TalentPermission_MyCompetencies);
	}

	public void Checkbox_Read_TalentPermission_MyCompetencies() {
		clickByJavaScript(Checkbox_Read_TalentPermission_MyCompetencies);
	}

	// ==========================================================================//

	// ============= Career Development - Career Development Board====
	By checkbox_Read_CareerDevelopment_CareerDevelopmentBoard = By.xpath(
			"(.//*[normalize-space(text()) and normalize-space(.)='Career Development - Career Development Board'])[1]/following::label[1]");
	By uncheckbox_Read_CareerDevelopment_CareerDevelopmentBoard = By.xpath(
			"(.//*[normalize-space(text()) and normalize-space(.)='Career Development - Career Development Board'])[1]/following::span[1]");
	By checkbox_Update_CareerDevelopment_CareerDevelopmentBoard = By.xpath(
			"(.//*[normalize-space(text()) and normalize-space(.)='Career Development - Career Development Board'])[1]/following::label[2]");
	By uncheckbox_Update_CareerDevelopment_CareerDevelopmentBoard = By.xpath(
			"(.//*[normalize-space(text()) and normalize-space(.)='Career Development - Career Development Board'])[1]/following::span[4]");
	By checkbox_Create_CareerDevelopment_CareerDevelopmentBoard = By.xpath(
			"(.//*[normalize-space(text()) and normalize-space(.)='Career Development - Career Development Board'])[1]/following::label[3]");
	By uncheckbox_Create_CareerDevelopment_CareerDevelopmentBoard = By.xpath(
			"(.//*[normalize-space(text()) and normalize-space(.)='Career Development - Career Development Board'])[1]/following::span[6]");
	By checkbox_Delete_CareerDevelopment_CareerDevelopmentBoard = By.xpath(
			"(.//*[normalize-space(text()) and normalize-space(.)='Career Development - Career Development Board'])[1]/following::label[4]");
	By uncheckbox_Delete_CareerDevelopment_CareerDevelopmentBoard = By.xpath(
			"(.//*[normalize-space(text()) and normalize-space(.)='Career Development - Career Development Board'])[1]/following::span[8]");

	public void uncheckbox_Read_CareerDevelopment_CareerDevelopmentBoard() {
		clickByJavaScript(uncheckbox_Read_CareerDevelopment_CareerDevelopmentBoard);
	}

	public void checkbox_Read_CareerDevelopment_CareerDevelopmentBoard() {
		clickByJavaScript(checkbox_Read_CareerDevelopment_CareerDevelopmentBoard);
	}

	public void checkbox_Update_CareerDevelopment_CareerDevelopmentBoard() {
		clickByJavaScript(checkbox_Update_CareerDevelopment_CareerDevelopmentBoard);
	}

	public void uncheckbox_Update_CareerDevelopment_CareerDevelopmentBoard() {
		clickByJavaScript(uncheckbox_Update_CareerDevelopment_CareerDevelopmentBoard);
	}

	public void checkbox_Create_CareerDevelopment_CareerDevelopmentBoard() {
		clickByJavaScript(checkbox_Create_CareerDevelopment_CareerDevelopmentBoard);
	}

	public void uncheckbox_Create_CareerDevelopment_CareerDevelopmentBoard() {
		clickByJavaScript(uncheckbox_Create_CareerDevelopment_CareerDevelopmentBoard);
	}

	public void checkbox_Delete_CareerDevelopment_CareerDevelopmentBoard() {
		clickByJavaScript(checkbox_Delete_CareerDevelopment_CareerDevelopmentBoard);
	}

	public void uncheckbox_Delete_CareerDevelopment_CareerDevelopmentBoard() {
		clickByJavaScript(uncheckbox_Delete_CareerDevelopment_CareerDevelopmentBoard);
	}

	// ============= Career Development - My Career Development ===
	By checkbox_Read_CareerDevelopment_MyCareerDevelopment = By.xpath(
			"(.//*[normalize-space(text()) and normalize-space(.)='My Career Development'])[2]/following::label[1]");

	By uncheckbox_Read_CareerDevelopment_MyCareerDevelopment = By.xpath(
			"(.//*[normalize-space(text()) and normalize-space(.)='My Career Development'])[2]/following::span[1]");

	By checkbox_Update_CareerDevelopment_MyCareerDevelopment = By.xpath(
			"(.//*[normalize-space(text()) and normalize-space(.)='My Career Development'])[2]/following::label[2]");

	By checkbox_Create_CareerDevelopment_MyCareerDevelopment = By.xpath(
			"(.//*[normalize-space(text()) and normalize-space(.)='My Career Development'])[2]/following::label[3]");

	By checkbox_Delete_CareerDevelopment_MyCareerDevelopment = By.xpath(
			"(.//*[normalize-space(text()) and normalize-space(.)='My Career Development'])[2]/following::label[4]");

	public void checkbox_Read_CareerDevelopment_MyCareerDevelopment() {
		clickByJavaScript(checkbox_Read_CareerDevelopment_MyCareerDevelopment);
	}

	public void uncheckbox_Read_CareerDevelopment_MyCareerDevelopment() {
		clickByJavaScript(uncheckbox_Read_CareerDevelopment_MyCareerDevelopment);
	}

	public void checkbox_Update_CareerDevelopment_MyCareerDevelopment() {
		clickByJavaScript(checkbox_Update_CareerDevelopment_MyCareerDevelopment);
	}

	public void checkbox_Create_CareerDevelopment_MyCareerDevelopment() {
		clickByJavaScript(checkbox_Create_CareerDevelopment_MyCareerDevelopment);
	}

	public void checkbox_Delete_CareerDevelopment_MyCareerDevelopment() {
		clickByJavaScript(checkbox_Delete_CareerDevelopment_MyCareerDevelopment);
	}

	// ============= Succession Planning - Succession Planning Board====
	By checkbox_Read_SuccessionPlanning_SuccessionPlanningBoard = By.xpath(
			"(.//*[normalize-space(text()) and normalize-space(.)='Succession Planning - Succession Planning Board'])[1]/following::label[1]");
	By uncheckbox_Read_SuccessionPlanning_SuccessionPlanningBoard = By.xpath(
			"(.//*[normalize-space(text()) and normalize-space(.)='Succession Planning - Succession Planning Board'])[1]/following::span[1]");
	By checkbox_Update_SuccessionPlanning_SuccessionPlanningBoard = By.xpath(
			"(.//*[normalize-space(text()) and normalize-space(.)='Succession Planning - Succession Planning Board'])[1]/following::label[2]");
	By uncheckbox_Update_SuccessionPlanning_SuccessionPlanningBoard = By.xpath(
			"(.//*[normalize-space(text()) and normalize-space(.)='Succession Planning - Succession Planning Board'])[1]/following::span[4]");
	By checkbox_Create_SuccessionPlanning_SuccessionPlanningBoard = By.xpath(
			"(.//*[normalize-space(text()) and normalize-space(.)='Succession Planning - Succession Planning Board'])[1]/following::label[3]");
	By uncheckbox_Create_SuccessionPlanning_SuccessionPlanningBoard = By.xpath(
			"(.//*[normalize-space(text()) and normalize-space(.)='Succession Planning - Succession Planning Board'])[1]/following::span[6]");
	By checkbox_Delete_SuccessionPlanning_SuccessionPlanningBoard = By.xpath(
			"(.//*[normalize-space(text()) and normalize-space(.)='Succession Planning - Succession Planning Board'])[1]/following::label[4]");
	By uncheckbox_Delete_SuccessionPlanning_SuccessionPlanningBoard = By.xpath(
			"(.//*[normalize-space(text()) and normalize-space(.)='Succession Planning - Succession Planning Board'])[1]/following::span[8]");

	public void checkbox_Read_SuccessionPlanning_SuccessionPlanningBoard() {
		clickByJavaScript(checkbox_Read_SuccessionPlanning_SuccessionPlanningBoard);
	}

	public void uncheckbox_Read_SuccessionPlanning_SuccessionPlanningBoard() {
		clickByJavaScript(uncheckbox_Read_SuccessionPlanning_SuccessionPlanningBoard);
	}

	public void checkbox_Update_SuccessionPlanning_SuccessionPlanningBoard() {
		clickByJavaScript(checkbox_Update_SuccessionPlanning_SuccessionPlanningBoard);
	}

	public void uncheckbox_Update_SuccessionPlanning_SuccessionPlanningBoard() {
		clickByJavaScript(uncheckbox_Update_SuccessionPlanning_SuccessionPlanningBoard);
	}

	public void checkbox_Create_SuccessionPlanning_SuccessionPlanningBoard() {
		clickByJavaScript(checkbox_Create_SuccessionPlanning_SuccessionPlanningBoard);
	}

	public void uncheckbox_Create_SuccessionPlanning_SuccessionPlanningBoard() {
		clickByJavaScript(uncheckbox_Create_SuccessionPlanning_SuccessionPlanningBoard);
	}

	public void checkbox_Delete_SuccessionPlanning_SuccessionPlanningBoard() {
		clickByJavaScript(checkbox_Delete_SuccessionPlanning_SuccessionPlanningBoard);
	}

	public void uncheckbox_Delete_SuccessionPlanning_SuccessionPlanningBoard() {
		clickByJavaScript(uncheckbox_Delete_SuccessionPlanning_SuccessionPlanningBoard);
	}

	// ==========================================================================

	public void createUserRoleNameWithRoleTypeAdmin(String UserRoleName) throws InterruptedException {
		clickByJavaScript(btnCreate);
		waitForPageLoaded();

		if (isElementVisible(UnCheckBox_Read_Row_1) == false) {
			clickByJavaScript(btnBack);
			waitForElementClickable(btnCreate);
			clickByJavaScript(btnCreate);
			waitForPageLoaded();
		}
		waitForElementClickable(10, txtUserRoleName);
		typeText(txtUserRoleName, UserRoleName);
		clickByJavaScript(ArrowRoleType);
		waitForElementClickable(10, optionRoleType_Admin);
		clickByJavaScript(optionRoleType_Admin);
		clickByJavaScript(cbxSite);
		sleep(2);
	}

	public void createUserRoleNameWithRoleTypeManager(String UserRoleName) throws InterruptedException {
		clickByJavaScript(btnCreate);
		waitForPageLoaded();

		if (isElementVisible(UnCheckBox_Read_Row_1) == false) {
			clickByJavaScript(btnBack);
			waitForElementClickable(btnCreate);
			clickByJavaScript(btnCreate);
			waitForPageLoaded();
		}
		waitForElementClickable(10, txtUserRoleName);
		typeText(txtUserRoleName, UserRoleName);
		clickByJavaScript(ArrowRoleType);
		waitForElementClickable(10, optionRoleType_Manager);
		clickByJavaScript(optionRoleType_Manager);
		// click CheckBox Site
		waitForElementClickable(10, cbxSite);
		clickByJavaScript(cbxSite);
	}

	public void createUserRoleNameWithRoleTypeUser(String UserRoleName) throws InterruptedException {
		clickByJavaScript(btnCreate);
		waitForPageLoaded();

		if (isElementVisible(UnCheckBox_Read_Row_1) == false) {
			clickByJavaScript(btnBack);
			waitForElementClickable(btnCreate);
			clickByJavaScript(btnCreate);
			waitForPageLoaded();
		}
		waitForElementClickable(10, txtUserRoleName);
		typeText(txtUserRoleName, UserRoleName);
		clickByJavaScript(ArrowRoleType);
		waitForElementClickable(10, optionRoleType_User);
		clickByJavaScript(optionRoleType_User);
	}

	public void createUserRoleNameWithDataAccessUnitInRoleTypeAdmin(String UserRoleName) throws InterruptedException {
		clickByJavaScript(btnCreate);
		waitForPageLoaded();

		if (isElementVisible(UnCheckBox_Read_Row_1) == false) {
			clickByJavaScript(btnBack);
			waitForElementClickable(btnCreate);
			clickByJavaScript(btnCreate);
			waitForPageLoaded();
		}
		waitForElementClickable(10, txtUserRoleName);
		typeText(txtUserRoleName, UserRoleName);
		clickByJavaScript(ArrowRoleType);
		waitForElementClickable(10, optionRoleType_Admin);
		clickByJavaScript(optionRoleType_Admin);
		// click CheckBox Unit
		waitForElementClickable(10, cbxUnit);
		clickByJavaScript(cbxUnit);
	}

	public void createUserRoleNameWithDataAccessUnitInRoleTypeManager(String UserRoleName) throws InterruptedException {
		clickByJavaScript(btnCreate);
		waitForPageLoaded();

		if (isElementVisible(UnCheckBox_Read_Row_1) == false) {
			clickByJavaScript(btnBack);
			waitForElementClickable(btnCreate);
			clickByJavaScript(btnCreate);
			waitForPageLoaded();
		}
		waitForElementClickable(10, txtUserRoleName);
		typeText(txtUserRoleName, UserRoleName);
		clickByJavaScript(ArrowRoleType);
		waitForElementClickable(10, optionRoleType_Manager);
		clickByJavaScript(optionRoleType_Manager);
		// click CheckBox Unit
		waitForElementClickable(10, cbxUnit);
		clickByJavaScript(cbxUnit);
	}

	public void createUserRoleNameWithDataAccessProjectInRoleTypeAdmin(String UserRoleName)
			throws InterruptedException {
		clickByJavaScript(btnCreate);
		waitForPageLoaded();

		if (isElementVisible(UnCheckBox_Read_Row_1) == false) {
			clickByJavaScript(btnBack);
			waitForElementClickable(btnCreate);
			clickByJavaScript(btnCreate);
			waitForPageLoaded();
		}
		waitForElementClickable(10, txtUserRoleName);
		typeText(txtUserRoleName, UserRoleName);
		clickByJavaScript(ArrowRoleType);
		waitForElementClickable(10, optionRoleType_Admin);
		clickByJavaScript(optionRoleType_Admin);
		// click CheckBox Project
		waitForElementClickable(10, cbxProject);
		clickByJavaScript(cbxProject);
	}

	public void createUserRoleNameWithDataAccessProjectInRoleTypeManager(String UserRoleName)
			throws InterruptedException {
		clickByJavaScript(btnCreate);
		waitForPageLoaded();

		if (isElementVisible(UnCheckBox_Read_Row_1) == false) {
			clickByJavaScript(btnBack);
			waitForElementClickable(btnCreate);
			clickByJavaScript(btnCreate);
			waitForPageLoaded();
		}
		waitForElementClickable(10, txtUserRoleName);
		typeText(txtUserRoleName, UserRoleName);
		clickByJavaScript(ArrowRoleType);
		waitForElementClickable(10, optionRoleType_Manager);
		clickByJavaScript(optionRoleType_Manager);
		// click CheckBox Project
		waitForElementClickable(10, cbxProject);
		clickByJavaScript(cbxProject);
	}

	public String getNameOfUnitDataAccess() throws InterruptedException {
		if (isElementVisible(nameOfDataAccess) == true) {
			return driver.findElement(nameOfDataAccess).getText();
		} else
			return "";

	}

	public void createUserRoleNameWithDataAccessReportToInRoleTypeAdmin(String UserRoleName)
			throws InterruptedException {
		clickByJavaScript(btnCreate);
		waitForPageLoaded();

		if (isElementVisible(UnCheckBox_Read_Row_1) == false) {
			clickByJavaScript(btnBack);
			waitForElementClickable(btnCreate);
			clickByJavaScript(btnCreate);
			waitForPageLoaded();
		}
		waitForElementClickable(10, txtUserRoleName);
		typeText(txtUserRoleName, UserRoleName);
		clickByJavaScript(ArrowRoleType);
		waitForElementClickable(10, optionRoleType_Admin);
		clickByJavaScript(optionRoleType_Admin);
		// click CheckBox Report To
		waitForElementClickable(10, cbxReportTo);
		clickByJavaScript(cbxReportTo);
	}

	public void createUserRoleNameWithDataAccessReportToInRoleTypeManager(String UserRoleName)
			throws InterruptedException {
		clickByJavaScript(btnCreate);
		waitForPageLoaded();

		if (isElementVisible(UnCheckBox_Read_Row_1) == false) {
			clickByJavaScript(btnBack);
			waitForElementClickable(btnCreate);
			clickByJavaScript(btnCreate);
			waitForPageLoaded();
		}
		waitForElementClickable(10, txtUserRoleName);
		typeText(txtUserRoleName, UserRoleName);
		clickByJavaScript(ArrowRoleType);
		waitForElementClickable(10, optionRoleType_Manager);
		clickByJavaScript(optionRoleType_Manager);
		// click CheckBox Report To
		waitForElementClickable(10, cbxReportTo);
		clickByJavaScript(cbxReportTo);
	}

	public void createUserRoleNameWithDataAccessAllInRoleTypeAdmin(String UserRoleName) throws InterruptedException {
		clickByJavaScript(btnCreate);
		waitForPageLoaded();

		if (isElementVisible(UnCheckBox_Read_Row_1) == false) {
			clickByJavaScript(btnBack);
			waitForElementClickable(btnCreate);
			clickByJavaScript(btnCreate);
			waitForPageLoaded();
		}
		waitForElementClickable(10, txtUserRoleName);
		typeText(txtUserRoleName, UserRoleName);
		clickByJavaScript(ArrowRoleType);
		waitForElementClickable(10, optionRoleType_Admin);
		clickByJavaScript(optionRoleType_Admin);
		// choose All Checkbox of Data Access
		chooseDataAccesAll();
	}

	public void createUserRoleNameWithDataAccessAllInRoleTypeManager(String UserRoleName) throws InterruptedException {
		clickByJavaScript(btnCreate);
		waitForPageLoaded();

		if (isElementVisible(UnCheckBox_Read_Row_1) == false) {
			clickByJavaScript(btnBack);
			waitForElementClickable(btnCreate);
			clickByJavaScript(btnCreate);
			waitForPageLoaded();
		}
		waitForElementClickable(10, txtUserRoleName);
		typeText(txtUserRoleName, UserRoleName);
		clickByJavaScript(ArrowRoleType);
		waitForElementClickable(10, optionRoleType_Manager);
		clickByJavaScript(optionRoleType_Manager);
		// choose All Checkbox of Data Access
		chooseDataAccesAll();

	}

	public void chooseDataAccesAll() {
		waitForElementClickable(10, cbxSite);
		clickByJavaScript(cbxSite);
		clickByJavaScript(cbxUnit);
		clickByJavaScript(cbxProject);
		clickByJavaScript(cbxReportTo);
	}

	public void chooseCheckSite() {
		waitForElementClickable(10, cbxSite);
		clickByJavaScript(cbxSite);
	}

	public void chooseCheckUnit() {
		waitForElementClickable(10, cbxUnit);
		clickByJavaScript(cbxUnit);
	}

	public void chooseCheckProject() {
		waitForElementClickable(10, cbxProject);
		clickByJavaScript(cbxProject);
	}

	public void chooseCheckReportTo() {
		waitForElementClickable(10, cbxReportTo);
		clickByJavaScript(cbxReportTo);
	}

	public void UnCheckAllCheckboxModule_Administrator_Permision() {
		List<WebElement> list = driver.findElements(checkBoxs_Read_Checked);
		for (WebElement element : list) {
			if (element.getAttribute("ng-show").equals("permission.allowReading")
					&& (element.getAttribute("class").equals("icon icon-checkmark3 text-primary fs-20"))) {
				clickOnElement(element);

			}
		}

		if (driver.findElement(checkboxViewEmployees).isDisplayed()) {
			clickByJavaScript(checkboxViewEmployees);
		}
	}

	public void uncheck_All_Checkbox_Row_1() {
		try {
			if (driver.findElement(UnCheckBox_Read_Row_1).isDisplayed() == false) {
				driver.navigate().refresh();
			}
			waitForElementClickable(UnCheckBox_Read_Row_1);
			clickByJavaScript(UnCheckBox_Read_Row_1);
		} catch (Exception e) {
		}

	}

	public void uncheck_All_Checkbox_Row_3() {
		clickByJavaScript(UnCheckBox_Read_Row_3);
	}

	public void uncheck_All_Checkbox_Row_4() {
		clickByJavaScript(UnCheckBox_Read_Row_4);
	}

	public void uncheck_All_Checkbox_Row_5() {
		clickByJavaScript(UnCheckBox_Read_Row_5);
	}

	public void uncheck_All_Checkbox_Row_7() {
		clickByJavaScript(UnCheckBox_Read_Row_7);
	}

	public void uncheck_All_Checkbox_Row_8() {
		clickByJavaScript(UnCheckBox_Read_Row_8);
	}

	public void uncheck_All_Checkbox_Row_10() {
		clickByJavaScript(UnCheckBox_Read_Row_10);
	}

	public void uncheck_All_Checkbox_Row_11() {
		clickByJavaScript(UnCheckBox_Read_Row_11);
	}

	public void uncheck_All_Checkbox_Row_12() {
		clickByJavaScript(UnCheckBox_Read_Row_12);
	}

	public void uncheck_All_Checkbox_Row_14() {
		clickByJavaScript(UnCheckBox_Read_Row_14);
	}

	public void uncheck_All_Checkbox_Row_15() {
		clickByJavaScript(UnCheckBox_Read_Row_15);
	}

	public void uncheck_All_Checkbox_Row_16() {
		clickByJavaScript(UnCheckBox_Read_Row_16);
	}

	public void uncheck_All_Checkbox_Row_18() {
		clickByJavaScript(UnCheckBox_Read_Row_18);
	}

	public void uncheck_All_Checkbox_Row_19() {
		clickByJavaScript(UnCheckBox_Read_Row_19);
	}

	public void uncheck_All_Checkbox_Row_17() {
		clickByJavaScript(UnCheckBox_Read_Row_17);
	}

	public void click_CheckBox_Read_On_Row_(int NoOfRow) {
		driver.findElement(By.xpath("//label[contains(.,'Read')])[" + NoOfRow + "]")).click();
	}
	
	
	
	

	public void click_uncheck_Read_On_Row(int noOfRow) {
		driver.findElement(By.xpath("(//span[@ng-show='permission.allowReading'])[" + noOfRow + "]")).click();
	}

	public void uncheck_All_Checkbox_Row_2() {
		clickByJavaScript(UnCheckBox_Read_Row_2);
	}

	public void Delete_Role() {
		sleep(2);
		clickByJavaScript(checkbox_delete_role);
		sleep(2);
		clickByJavaScript(iconDelete);
		sleep(2);
		clickByJavaScript(button_Alert_Delete_Role);
	}

	public void choose_Checkbox_Read__With_Row_Number(int numberRow) {
		scrollToTopPage();
		WebElement element = driver
				.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Read'])[" + numberRow
						+ "]/preceding-sibling::span[@class='icon icon-checkmark3 text-primary fs-20 ng-hide']//parent::label"));
		clickOnElement(element);
	}

	public void choose_Checkbox_Create_With_Row_Number1() {
		scrollToTopPage();
		clickByJavaScript(checkBox_Create_Row_1);

	}

	public void choose_Checkbox_Update_With_Row_Number1() {
		scrollToTopPage();
		clickByJavaScript(checkBox_Update_Row_1);
	}

	public void choose_Checkbox_Update_With_Row_Number17() {
		scrollToTopPage();
		clickByJavaScript(checkBox_Read_Update_17);
	}

	public void choose_Checkbox_Delete_With_Row_Number1() {
		scrollToTopPage();
		clickByJavaScript(checkBox_Delete_Row_1);
	}

	public void choose_Checkbox_Delete_With_Row_Number2() {
		scrollToTopPage();
		clickByJavaScript(checkBox_Delete_Row_2);
	}

	public void choose_Checkbox_Read_With_Row_Number2() {
		scrollToTopPage();
		clickByJavaScript(checkBox_Read_Row_2);
	}

	public void choose_Checkbox_Read_With_Row_Number3() {
		scrollToTopPage();
		clickByJavaScript(checkBox_Read_Row_3);
	}

	public void choose_Checkbox_Read_With_Row_Number4() {
		scrollToTopPage();
		clickByJavaScript(checkBox_Read_Row_4);
	}

	public void choose_Checkbox_Read_With_Row_Number5() {
		scrollToTopPage();
		clickByJavaScript(checkBox_Read_Row_5);
	}

	public void choose_Checkbox_Read_With_Row_Number6() {
		scrollToTopPage();
		clickByJavaScript(checkBox_Read_Row_6);
	}

	public void choose_Checkbox_Read_With_Row_Number7() {
		scrollToTopPage();
		clickByJavaScript(checkBox_Read_Row_7);
	}

	public void choose_Checkbox_Read_With_Row_Number8() {
		scrollToTopPage();
		clickByJavaScript(checkBox_Read_Row_8);
	}

	public void choose_Checkbox_Read_With_Row_Number10() {
		scrollToTopPage();
		clickByJavaScript(checkBox_Read_Row_10);
	}

	public void choose_Checkbox_Read_With_Row_Number11() {
		scrollToTopPage();
		clickByJavaScript(checkBox_Read_Row_11);
	}

	public void choose_Checkbox_Read_With_Row_Number12() {
		scrollToTopPage();
		clickByJavaScript(checkBox_Read_Row_12);
	}

	public void choose_Checkbox_Read_With_Row_Number13() {
		scrollToTopPage();
		clickByJavaScript(checkBox_Read_Row_13);
	}

	public void choose_Checkbox_Read_With_Row_Number14() {
		scrollToTopPage();
		clickByJavaScript(checkBox_Read_Row_14);
	}

	public void choose_Checkbox_Read_With_Row_Number15() {
		scrollToTopPage();
		clickByJavaScript(checkBox_Read_Row_15);
	}

	public void choose_Checkbox_Read_With_Row_Number16() {
		scrollToTopPage();
		clickByJavaScript(checkBox_Read_Row_16);
	}

	public void choose_Checkbox_Read_With_Row_Number17() {
		scrollToTopPage();
		clickByJavaScript(checkBox_Read_Row_17);
	}

	public void choose_Checkbox_Read_With_Row_Number18() {
		scrollToTopPage();
		clickByJavaScript(checkBox_Read_Row_18);
	}

	public void choose_Checkbox_Read_With_Row_Number19() {
		scrollToTopPage();
		clickByJavaScript(checkBox_Read_Row_19);
	}

	public void choose_Checkbox_Read_Leave_ImportBalance() {
		clickByJavaScript(checkBox_Read_Leave_ImportBalance);
	}

	public void choose_Checkbox_Create_With_Row_Number7() {
		scrollToTopPage();
		clickByJavaScript(checkBox_Create_Row_7);
	}

	public void choose_Checkbox_Create_With_Row_Number10() {
		scrollToTopPage();
		clickByJavaScript(checkBox_Create_Row_10);
	}

	public void choose_Checkbox_Create_With_Row_Number15() {
		scrollToTopPage();
		clickByJavaScript(checkBox_Create_Row_15);
	}

	public void choose_Checkbox_Create_With_Row_Number6() {
		scrollToTopPage();
		clickByJavaScript(checkBox_Create_Row_6);
	}

	public void choose_Checkbox_Update_With_Row_Number8() {
		scrollToTopPage();
		clickByJavaScript(checkBox_Read_Update_8);
	}

	public void choose_Checkbox_Update_With_Row_Number10() {
		scrollToTopPage();
		clickByJavaScript(checkBox_Read_Update_10);
	}

	public void choose_Checkbox_Update_With_Row_Number11() {
		scrollToTopPage();
		clickByJavaScript(checkBox_Read_Update_11);
	}

	public void choose_Checkbox_Update_With_Row_Number12() {
		scrollToTopPage();
		clickByJavaScript(checkBox_Read_Update_12);
	}

	public void choose_Checkbox_Update_With_Row_Number13() {
		scrollToTopPage();
		clickByJavaScript(checkBox_Read_Update_13);
	}

	public void choose_Checkbox_Update_With_Row_Number14() {
		scrollToTopPage();
		clickByJavaScript(checkBox_Read_Update_14);
	}

	public void choose_Checkbox_Update_With_Row_Number15() {
		scrollToTopPage();
		clickByJavaScript(checkBox_Read_Update_15);
	}

	public void choose_Checkbox_Update_With_Row_Number16() {
		scrollToTopPage();
		clickByJavaScript(checkBox_Read_Update_16);
	}

	public void choose_Checkbox_Update_With_Row_Number18() {
		scrollToTopPage();
		clickByJavaScript(checkBox_Read_Update_18);
	}

	public void choose_Checkbox_Update_With_Row_Number19() {
		scrollToTopPage();
		clickByJavaScript(checkBox_Read_Update_19);
	}

	public void choose_Checkbox_Update_With_Row_Number4() {
		scrollToTopPage();
		clickByJavaScript(checkBox_Read_Update_4);
	}

	public void choose_Checkbox_Update_With_Row_Number6() {
		scrollToTopPage();
		clickByJavaScript(checkBox_Read_Update_6);
	}

	public void choose_Checkbox_Update_With_Row_Number7() {
		scrollToTopPage();
		clickByJavaScript(checkBox_Read_Update_7);
	}

	public void choose_Checkbox_Delete_With_Row_Number6() {
		scrollToTopPage();
		clickByJavaScript(checkBox_Read_Delete_6);
	}

	public void choose_Checkbox_Delete_With_Row_Number10() {
		scrollToTopPage();
		clickByJavaScript(checkBox_Read_Delete_10);
	}

	public void choose_Checkbox_Delete_With_Row_Number13() {
		scrollToTopPage();
		clickByJavaScript(checkBox_Read_Delete_13);
	}

	public void choose_Checkbox_Delete_With_Row_Number15() {
		scrollToTopPage();
		clickByJavaScript(checkBox_Read_Delete_15);
	}

	public void choose_Checkbox_Delete_With_Row_Number16() {
		scrollToTopPage();
		clickByJavaScript(checkBox_Read_Delete_16);
	}

	public void choose_Checkbox_Delete_With_Row_Number7() {
		scrollToTopPage();
		clickByJavaScript(checkBox_Read_Delete_7);
	}

	public void choose_Checkbox_Delete_With_Row_Number8() {
		scrollToTopPage();
		clickByJavaScript(checkBox_Read_Delete_8);
	}

	public void choose_Checkbox_Update_With_Row_Number5() {
		scrollToTopPage();
		clickByJavaScript(checkBox_Read_Update_5);
	}

	public void choose_Checkbox_Create_With_Row_Number2() {
		scrollToTopPage();
		clickByJavaScript(checkBox_Create_Row_2);
	}

	public void choose_Checkbox_Create_With_Row_Number8() {
		scrollToTopPage();
		clickByJavaScript(checkBox_Create_Row_8);
	}

	public void choose_Checkbox_Create_With_Row_Number13() {
		scrollToTopPage();
		clickByJavaScript(checkBox_Create_Row_13);
	}

	public void choose_Checkbox_Create_With_Row_Number16() {
		scrollToTopPage();
		clickByJavaScript(checkBox_Create_Row_16);
	}

	public void choose_Checkbox_Update_With_Row_Number2() {
		scrollToTopPage();
		clickByJavaScript(checkbox_Update_Row_2);
	}

	public void clickButtonSave() {
		waitForElementClickable(5, btnSave);
		clickByJavaScript(btnSave);
		sleep(3);
	}

	public void searchRoles(String nameRoles) {
		try {
			waitForElementVisible(10, searchRoles);
			goTextOn(searchRoles, nameRoles);

		} catch (InterruptedException e) {

		}

	}

	public boolean isSearchRolesDisplayed() {
		try {
			if (isElementVisible(searchRoles) == true)
				return true;
			else
				return false;
		} catch (Exception e) {

			return false;
		}
	}

	public boolean isButtonCreateDisplayed() {
		try {
			if (driver.findElement(btnCreate).isDisplayed() == true) {
				return true;
			} else {
				return false;
			}
		} catch (Exception e) {

			return false;
		}
	}

	public void clickButtonViewUser() throws InterruptedException {
		if (isElementVisible(buttonViewUser) == true)
			clickByJavaScript(buttonViewUser);
		else
			TestLogger.info("Button View Users is not Avaiable !");
	}

	public void clickLinkUserRoleName(String userRoleName) throws InterruptedException {
		if (isElementVisible(By.linkText(userRoleName))) {
			clickByJavaScript(By.linkText(userRoleName));
		} else {
			TestLogger.info("Can't found this link of User Role Name ");
		}
	}

	public String getStringFromUserRoleName() throws InterruptedException {
		waitForElementClickable(10, txtUserRoleName);
		if (isElementVisible(txtUserRoleName)) {
			return driver.findElement(txtUserRoleName).getAttribute("value");
		} else {
			return "";
		}
	}

	public boolean isButtonExportClickable() throws InterruptedException {
		try {
			if (driver.findElement(buttonExport).isDisplayed() == true) {
				return true;
			} else {
				return false;
			}
		} catch (Exception e) {

			return false;
		}
	}

	public boolean isIconDeleteDisplayed() {

		try {
			if (driver.findElement(iconDelete).isDisplayed() == true) {
				return true;
			} else {
				return false;
			}
		} catch (Exception e) {

			return false;
		}
	}

	public boolean isCheckboxDeleteRole() {

		try {
			if (driver.findElement(checkbox_delete_role).isDisplayed() == true) {
				return true;
			} else {
				return false;
			}
		} catch (Exception e) {

			return false;
		}
	}

	public boolean isButtonSaveDisplayed() throws InterruptedException {
		try {
			if (driver.findElement(btnSave).isDisplayed() == true) {
				return true;
			} else {
				return false;
			}
		} catch (Exception e) {

			return false;
		}
	}

	// =========== My Successor =======================
	By checkbox_Read_MySuccessor = By
			.xpath("(.//*[normalize-space(text()) and normalize-space(.)='My Successor'])[1]/following::label[1]");
	By uncheckbox_Read_MySuccessor = By
			.xpath("(.//*[normalize-space(text()) and normalize-space(.)='My Successor'])[1]/following::span[1]");

	public void checkbox_Read_MySuccessor() {
		clickByJavaScript(checkbox_Read_MySuccessor);
	}

	public void uncheckbox_Read_MySuccessor() {
		clickByJavaScript(uncheckbox_Read_MySuccessor);
	}

	// =========== My Succession =======================
	By checkbox_Read_MySuccession = By
			.xpath("(.//*[normalize-space(text()) and normalize-space(.)='My Succession'])[2]/following::label[1]");
	By uncheckbox_Read_MySuccession = By
			.xpath("(.//*[normalize-space(text()) and normalize-space(.)='My Succession'])[2]/following::span[1]");

	public void checkbox_Read_MySuccession() {
		clickByJavaScript(checkbox_Read_MySuccession);
	}

	public void uncheckbox_Read_MySuccession() {
		clickByJavaScript(uncheckbox_Read_MySuccession);
	}

	// ============== Competency - Settings - Competency Configuration/Mapping
	// ===========

	By checkbox_Read_Competency_Settings_CompetencyConfiguration_Mapping = By.xpath(
			"(.//*[normalize-space(text()) and normalize-space(.)='Competency - Settings - Competency Configuration/Mapping'])[1]/following::label[1]");
	By uncheckbox_Read_Competency_Settings_CompetencyConfiguration_Mapping = By.xpath(
			"(.//*[normalize-space(text()) and normalize-space(.)='Competency - Settings - Competency Configuration/Mapping'])[1]/following::span[1]");

	public void checkbox_Read_Competency_Settings_CompetencyConfiguration_Mapping() {
		clickByJavaScript(checkbox_Read_Competency_Settings_CompetencyConfiguration_Mapping);
	}

	public void uncheckbox_Read_Competency_Settings_CompetencyConfiguration_Mapping() {
		clickByJavaScript(uncheckbox_Read_Competency_Settings_CompetencyConfiguration_Mapping);
	}

	By checkbox_Update_Competency_Settings_CompetencyConfiguration_Mapping = By.xpath(
			"(.//*[normalize-space(text()) and normalize-space(.)='Competency - Settings - Competency Configuration/Mapping'])[1]/following::label[2]");
	By uncheckbox_Update_Competency_Settings_CompetencyConfiguration_Mapping = By.xpath(
			"(.//*[normalize-space(text()) and normalize-space(.)='Competency - Settings - Competency Configuration/Mapping'])[1]/following::span[2]");

	public void checkbox_Update_Competency_Settings_CompetencyConfiguration_Mapping() {
		clickByJavaScript(checkbox_Update_Competency_Settings_CompetencyConfiguration_Mapping);
	}

	public void uncheckbox_Update_Competency_Settings_CompetencyConfiguration_Mapping() {
		clickByJavaScript(uncheckbox_Update_Competency_Settings_CompetencyConfiguration_Mapping);
	}

	By checkbox_Create_Competency_Settings_CompetencyConfiguration_Mapping = By.xpath(
			"(.//*[normalize-space(text()) and normalize-space(.)='Competency - Settings - Competency Configuration/Mapping'])[1]/following::label[3]");
	By uncheckbox_Create_Competency_Settings_CompetencyConfiguration_Mapping = By.xpath(
			"(.//*[normalize-space(text()) and normalize-space(.)='Competency - Settings - Competency Configuration/Mapping'])[1]/following::span[3]");

	public void checkbox_Create_Competency_Settings_CompetencyConfiguration_Mapping() {
		clickByJavaScript(checkbox_Create_Competency_Settings_CompetencyConfiguration_Mapping);
	}

	public void uncheckbox_Create_Competency_Settings_CompetencyConfiguration_Mapping() {
		clickByJavaScript(uncheckbox_Create_Competency_Settings_CompetencyConfiguration_Mapping);
	}

	By checkbox_Delete_Competency_Settings_CompetencyConfiguration_Mapping = By.xpath(
			"(.//*[normalize-space(text()) and normalize-space(.)='Competency - Settings - Competency Configuration/Mapping'])[1]/following::label[4]");
	By uncheckbox_Delete_Competency_Settings_CompetencyConfiguration_Mapping = By.xpath(
			"(.//*[normalize-space(text()) and normalize-space(.)='Competency - Settings - Competency Configuration/Mapping'])[1]/following::span[4]");

	public void checkbox_Delete_Competency_Settings_CompetencyConfiguration_Mapping() {
		clickByJavaScript(checkbox_Delete_Competency_Settings_CompetencyConfiguration_Mapping);
	}

	public void uncheckbox_Delete_Competency_Settings_CompetencyConfiguration_Mapping() {
		clickByJavaScript(uncheckbox_Delete_Competency_Settings_CompetencyConfiguration_Mapping);
	}
	// ==================================================

	// ====================Personal Performance Management
	// Import==============================
	By checkbox_Read_PersonalPerformanceManagementImport = By.xpath(
			"(.//*[normalize-space(text()) and normalize-space(.)='Personal Performance Management Import'])[1]/following::label[1]");
	By uncheckbox_Read_PersonalPerformanceManagementImport = By.xpath(
			"(.//*[normalize-space(text()) and normalize-space(.)='Personal Performance Management Import'])[1]/following::span[1]");

	public void checkbox_Read_PersonalPerformanceManagementImport() {
		clickByJavaScript(checkbox_Read_PersonalPerformanceManagementImport);
	}

	public void uncheckbox_Read_PersonalPerformanceManagementImport() {
		clickByJavaScript(uncheckbox_Read_PersonalPerformanceManagementImport);
	}

	// =================Competency - Competency Board =============================
	By checkbox_Read_Competency_CompetencyBoard = By.xpath(
			"(.//*[normalize-space(text()) and normalize-space(.)='Competency - Competency Board'])[1]/following::label[1]");
	By uncheckbox_Read_Competency_CompetencyBoard = By.xpath(
			"(.//*[normalize-space(text()) and normalize-space(.)='Competency - Competency Board'])[1]/following::span[1]");

	By checkbox_Update_Competency_CompetencyBoard = By.xpath(
			"(.//*[normalize-space(text()) and normalize-space(.)='Competency - Competency Board'])[1]/following::label[2]");
	By uncheckbox_Update_Competency_CompetencyBoard = By.xpath(
			"(.//*[normalize-space(text()) and normalize-space(.)='Competency - Competency Board'])[1]/following::span[3]");

	public void checkbox_Read_Competency_CompetencyBoard() {
		clickByJavaScript(checkbox_Read_Competency_CompetencyBoard);
	}

	public void uncheckbox_Read_Competency_CompetencyBoard() {
		clickByJavaScript(uncheckbox_Read_Competency_CompetencyBoard);
	}

	public void checkbox_Update_Competency_CompetencyBoard() {
		clickByJavaScript(checkbox_Update_Competency_CompetencyBoard);
	}

	public void uncheckbox_Update_Competency_CompetencyBoard() {
		clickByJavaScript(uncheckbox_Update_Competency_CompetencyBoard);
	}

	// ============= Training Settings ==========

	By checkbox_Read_TrainingSettings = By
			.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Training Settings'])[2]/following::label[1]");
	By uncheckbox_Read_TrainingSettings = By
			.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Training Settings'])[2]/following::span[1]");

	By checkbox_Update_TrainingSettings = By
			.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Training Settings'])[2]/following::label[2]");
	By uncheckbox_Update_TrainingSettings = By
			.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Training Settings'])[2]/following::span[3]");

	public void checkbox_Read_TrainingSettings() {
		clickByJavaScript(checkbox_Read_TrainingSettings);
	}

	public void uncheckbox_Read_TrainingSettings() throws InterruptedException {
		waitForElementVisible(5, uncheckbox_Read_TrainingSettings);
		clickByJavaScript(uncheckbox_Read_TrainingSettings);
	}

	public void checkbox_Update_TrainingSettings() throws InterruptedException {
		waitForElementVisible(5, checkbox_Update_TrainingSettings);
		clickByJavaScript(checkbox_Update_TrainingSettings);
	}

	public void uncheckbox_Update_TrainingSettings() {
		clickByJavaScript(uncheckbox_Update_TrainingSettings);
	}

	// ============= My Training ==========

	By checkbox_Read_MyTraining = By.xpath(
			"(.//*[normalize-space(text()) and normalize-space(.)='My Training - My Personal Training Courses'])[1]/following::span[1]");
	By uncheckbox_Read_MyTraining = By.xpath(
			"(.//*[normalize-space(text()) and normalize-space(.)='My Training - My Personal Training Courses'])[1]/following::label[1]");

	By checkbox_Update_MyTraining = By.xpath(
			"(.//*[normalize-space(text()) and normalize-space(.)='My Training - My Personal Training Courses'])[1]/following::span[3]");

	By checkbox_Create_MyTraining = By.xpath(
			"(.//*[normalize-space(text()) and normalize-space(.)='My Training - My Personal Training Courses'])[1]/following::span[5]");

	By checkbox_Delete_MyTraining = By.xpath(
			"(.//*[normalize-space(text()) and normalize-space(.)='My Training - My Personal Training Courses'])[1]/following::span[7]");

	public void checkbox_Read_MyTraining() {
		clickByJavaScript(checkbox_Read_MyTraining);
	}

	public void uncheckbox_Read_MyTraining() {
		clickByJavaScript(uncheckbox_Read_MyTraining);
	}

	public void checkbox_Update_MyTraining() {
		clickByJavaScript(checkbox_Update_MyTraining);
	}

	public void checkbox_Create_MyTraining() {
		clickByJavaScript(checkbox_Create_MyTraining);
	}

	public void checkbox_Delete_MyTraining() {
		clickByJavaScript(checkbox_Delete_MyTraining);
	}

	// ==================== Master Scheduling - My Schedule ======================

	By checkbox_Read_MasterScheduling_MySchedule = By.xpath(
			"(.//*[normalize-space(text()) and normalize-space(.)='Master Scheduling - My Schedule'])[1]/following::label[1]");
	By uncheckbox_Read_MasterScheduling_MySchedule = By.xpath(
			"(.//*[normalize-space(text()) and normalize-space(.)='Master Scheduling - My Schedule'])[1]/following::span[1]");

	public void checkbox_Read_MasterScheduling_MySchedule() {
		clickByJavaScript(checkbox_Read_MasterScheduling_MySchedule);
	}

	public void uncheckbox_Read_MasterScheduling_MySchedule() {
		clickByJavaScript(uncheckbox_Read_MasterScheduling_MySchedule);
	}

	// ====================Master Scheduling - Scheduling Board
	// ======================

	By checkbox_Read_MasterScheduling_SchedulingBoard = By.xpath(
			"(.//*[normalize-space(text()) and normalize-space(.)='Master Scheduling - Scheduling Board'])[1]/following::label[1]");
	By uncheckbox_Read_MasterScheduling_SchedulingBoard = By.xpath(
			"(.//*[normalize-space(text()) and normalize-space(.)='Master Scheduling - Scheduling Board'])[1]/following::span[1]");
	By checkbox_Update_MasterScheduling_SchedulingBoard = By.xpath(
			"(.//*[normalize-space(text()) and normalize-space(.)='Master Scheduling - Scheduling Board'])[1]/following::label[2]");
	By uncheckbox_Update_MasterScheduling_SchedulingBoard = By.xpath(
			"(.//*[normalize-space(text()) and normalize-space(.)='Master Scheduling - Scheduling Board'])[1]/following::span[3]");

	public void checkbox_Read_MasterScheduling_SchedulingBoard() {
		waitForElementClickable(5, checkbox_Read_MasterScheduling_SchedulingBoard);
		clickByJavaScript(checkbox_Read_MasterScheduling_SchedulingBoard);
	}

	public void uncheckbox_Read_MasterScheduling_SchedulingBoard() {
		waitForElementClickable(5, uncheckbox_Read_MasterScheduling_SchedulingBoard);
		clickByJavaScript(uncheckbox_Read_MasterScheduling_SchedulingBoard);
	}

	public void checkbox_Update_MasterScheduling_SchedulingBoard() {
		clickByJavaScript(checkbox_Update_MasterScheduling_SchedulingBoard);
	}

	public void uncheckbox_Update_MasterScheduling_SchedulingBoard() {
		clickByJavaScript(uncheckbox_Update_MasterScheduling_SchedulingBoard);
	}

	// ======================Master Scheduling - Recommend
	// Coverage===========================

	By checkbox_Read_MasterScheduling_RecommendCoverage = By.xpath(
			"(.//*[normalize-space(text()) and normalize-space(.)='Master Scheduling - Recommend Coverage'])[1]/following::label[1]");
	By uncheckbox_Read_MasterScheduling_RecommendCoverage = By.xpath(
			"(.//*[normalize-space(text()) and normalize-space(.)='Master Scheduling - Recommend Coverage'])[1]/following::span[1]");
	By checkbox_Update_MasterScheduling_RecommendCoverage = By.xpath(
			"(.//*[normalize-space(text()) and normalize-space(.)='Master Scheduling - Recommend Coverage'])[1]/following::label[2]");
	By uncheckbox_Update_MasterScheduling_RecommendCoverage = By.xpath(
			"(.//*[normalize-space(text()) and normalize-space(.)='Master Scheduling - Recommend Coverage'])[1]/following::span[3]");

	public void checkbox_Read_MasterScheduling_RecommendCoverage() {
		clickByJavaScript(checkbox_Read_MasterScheduling_RecommendCoverage);
	}

	public void uncheckbox_Read_MasterScheduling_RecommendCoverage() {
		clickByJavaScript(uncheckbox_Read_MasterScheduling_RecommendCoverage);
	}

	public void checkbox_Update_MasterScheduling_RecommendCoverage() {
		clickByJavaScript(checkbox_Update_MasterScheduling_RecommendCoverage);
	}

	public void uncheckbox_Update_MasterScheduling_RecommendCoverage() {
		clickByJavaScript(uncheckbox_Update_MasterScheduling_RecommendCoverage);
	}

	// ================REPORT================//

	By uncheckbox_Read_AssetReport = By
			.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Asset Report'])[2]/following::span[1]");
	By uncheckbox_Read_TimesheetReport = By
			.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Timesheet Report'])[2]/following::span[1]");

	public void uncheckbox_Read_AssetReport() {
		clickByJavaScript(uncheckbox_Read_AssetReport);
	}

	public void uncheckbox_Read_TimesheetReport() {
		waitForElementClickable(10, uncheckbox_Read_TimesheetReport);
		clickByJavaScript(uncheckbox_Read_TimesheetReport);
	}

	// ================REPORT================//

	// ====================== Talent - Report ======================

	By checkbox_Read_TalentReport = By
			.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Talent Report'])[2]/following::label[1]");

	By uncheckbox_Read_TalentReport = By
			.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Talent Report'])[2]/following::span[1]");

	public void checkbox_Read_TalentReport() {
		clickByJavaScript(checkbox_Read_TalentReport);
	}

	public void uncheckbox_Read_TalentReport() {
		clickByJavaScript(uncheckbox_Read_TalentReport);
	}

	// ============= Capacity Report ==================
	By checkbox_Read_CapacityReport = By
			.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Capacity Report'])[2]/following::label[1]");

	By uncheckbox_Read_CapacityReport = By
			.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Capacity Report'])[2]/following::span[1]");

	public void checkbox_Read_CapacityReport() {
		clickByJavaScript(checkbox_Read_CapacityReport);
	}

	public void uncheckbox_Read_CapacityReport() {
		clickByJavaScript(uncheckbox_Read_CapacityReport);
	}

	// ============= Project Report ==================
	By checkbox_Read_ProjectReport = By
			.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Project Report'])[2]/following::label[1]");

	By uncheckbox_Read_ProjectReport = By
			.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Project Report'])[2]/following::span[1]");

	public void checkbox_Read_ProjectReport() {
		clickByJavaScript(checkbox_Read_ProjectReport);
	}

	public void uncheckbox_Read_ProjectReport() {
		clickByJavaScript(uncheckbox_Read_ProjectReport);
	}

	// ============= Training Report ==================
	By checkbox_Read_TrainingReport = By
			.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Training - Report'])[1]/following::label[1]");

	By uncheckbox_Read_TrainingReport = By
			.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Training - Report'])[1]/following::span[1]");

	public void checkbox_Read_TrainingReport() {
		clickByJavaScript(checkbox_Read_TrainingReport);
	}

	public void uncheckbox_Read_TrainingReport() {
		clickByJavaScript(uncheckbox_Read_TrainingReport);
	}

	// ============= Leave Report ==================
	By checkbox_Read_LeaveReport = By
			.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Leave Report'])[2]/following::label[1]");

	By uncheckbox_Read_LeaveReport = By
			.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Leave Report'])[2]/following::span[1]");

	public void checkbox_Read_LeaveReport() {
		clickByJavaScript(checkbox_Read_LeaveReport);
	}

	public void uncheckbox_Read_LeaveReport() {
		clickByJavaScript(uncheckbox_Read_LeaveReport);
	}

	// ============= Employee Report ==================
	By checkbox_Read_EmployeeReport = By
			.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Employee Report'])[2]/following::label[1]");

	By uncheckbox_Read_EmployeeReport = By
			.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Employee Report'])[2]/following::span[1]");

	public void checkbox_Read_EmployeeReport() {
		clickByJavaScript(checkbox_Read_EmployeeReport);
	}

	public void uncheckbox_Read_EmployeeReport() {
		clickByJavaScript(uncheckbox_Read_EmployeeReport);
	}

	// ============== My Employee Data permission ===========

	// ============ My Assets ==============
	By unCheckbox_Read_My_Assets = By
			.xpath("(.//*[normalize-space(text()) and normalize-space(.)='My Assets'])[1]/following::span[1]");

	By checkbox_Read_My_Assets = By
			.xpath("(.//*[normalize-space(text()) and normalize-space(.)='My Assets'])[1]/following::label[1]");

	By unCheckbox_Update_My_Assets = By
			.xpath("(.//*[normalize-space(text()) and normalize-space(.)='My Assets'])[1]/following::span[3]");

	By checkbox_Update_My_Assets = By
			.xpath("(.//*[normalize-space(text()) and normalize-space(.)='My Assets'])[1]/following::label[2]");

	By unCheckbox_Create_My_Assets = By
			.xpath("(.//*[normalize-space(text()) and normalize-space(.)='My Assets'])[1]/following::span[5]");

	By checkbox_Create_My_Assets = By
			.xpath("(.//*[normalize-space(text()) and normalize-space(.)='My Assets'])[1]/following::label[3]");

	By unCheckbox_Delete_My_Assets = By
			.xpath("(.//*[normalize-space(text()) and normalize-space(.)='My Assets'])[1]/following::span[7]");

	By checkbox_Delete_My_Assets = By
			.xpath("(.//*[normalize-space(text()) and normalize-space(.)='My Assets'])[1]/following::label[4]");

	public void unCheckbox_Read_My_Assets() throws InterruptedException {
		waitForElementVisible(10, unCheckbox_Read_My_Assets);
		clickByJavaScript(unCheckbox_Read_My_Assets);
	}

	public void checkbox_Read_My_Assets() throws InterruptedException {
		waitForElementVisible(10, checkbox_Read_My_Assets);
		clickByJavaScript(checkbox_Read_My_Assets);
	}

	public void unCheckbox_Update_My_Assets() {
		clickByJavaScript(unCheckbox_Update_My_Assets);
	}

	public void checkbox_Update_My_Assets() {
		clickByJavaScript(checkbox_Update_My_Assets);
	}

	public void unCheckbox_Create_My_Assets() {
		clickByJavaScript(unCheckbox_Create_My_Assets);
	}

	public void checkbox_Create_My_Assets() {
		clickByJavaScript(checkbox_Create_My_Assets);
	}

	public void checkbox_Delete_My_Assets() {
		clickByJavaScript(unCheckbox_Delete_My_Assets);
	}

	public void unCheckbox_Delete_My_Assets() {
		clickByJavaScript(unCheckbox_Delete_My_Assets);
	}
	// =======================================

	// ============== Pilot View - Company Details - Report To ==================

	By uncheckbox_Read_ED_CompanyDetails_ReportTo = By.xpath(
			"(.//*[normalize-space(text()) and normalize-space(.)='ED - Company Details - Report To'])[1]/following::span[1]");
	By checkbox_Read_ED_CompanyDetails_ReportTo = By.xpath(
			"(.//*[normalize-space(text()) and normalize-space(.)='ED - Company Details - Report To'])[1]/following::label[1]");
	By uncheckbox_Update_ED_CompanyDetails_ReportTo = By.xpath(
			"(.//*[normalize-space(text()) and normalize-space(.)='ED - Company Details - Report To'])[1]/following::span[3]");
	By checkbox_Update_ED_CompanyDetails_ReportTo = By.xpath(
			"(.//*[normalize-space(text()) and normalize-space(.)='ED - Company Details - Report To'])[1]/following::label[2]");

	public void uncheckbox_Read_ED_CompanyDetails_ReportTo() {
		clickByJavaScript(uncheckbox_Read_ED_CompanyDetails_ReportTo);
	}

	public void checkbox_Read_ED_CompanyDetails_ReportTo() {
		clickByJavaScript(checkbox_Read_ED_CompanyDetails_ReportTo);
	}

	public void uncheckbox_Update_ED_CompanyDetails_ReportTo() {
		clickByJavaScript(uncheckbox_Update_ED_CompanyDetails_ReportTo);
	}

	public void checkbox_Update_ED_CompanyDetails_ReportTo() {
		clickByJavaScript(checkbox_Update_ED_CompanyDetails_ReportTo);
	}

	// =========== ED - Company Details - Client Employee Data ==========
	By uncheckbox_Read_ED_CompanyDetails_ClientEmployeeData = By.xpath(
			"(.//*[normalize-space(text()) and normalize-space(.)='ED - Company Details - Client Employee Data'])[1]/following::span[1]");
	By checkbox_Read_ED_CompanyDetails_ClientEmployeeData = By.xpath(
			"(.//*[normalize-space(text()) and normalize-space(.)='ED - Company Details - Client Employee Data'])[1]/following::label[1]");

	public void uncheckbox_Read_ED_CompanyDetails_ClientEmployeeData() {
		clickByJavaScript(uncheckbox_Read_ED_CompanyDetails_ClientEmployeeData);
	}

	public void checkbox_Read_ED_CompanyDetails_ClientEmployeeData() {
		clickByJavaScript(checkbox_Read_ED_CompanyDetails_ClientEmployeeData);
	}

	// ==================== ED - Company Details - General Information
	// ======================

	By Checkbox_Update_ED_CompanyDetails_GeneralInformation = By.xpath(
			"(.//*[normalize-space(text()) and normalize-space(.)='ED - Company Details - General Information'])[1]/following::label[2]");
	By UnCheckbox_Update_CompanyDetails_GeneralInformation = By.xpath(
			"(.//*[normalize-space(text()) and normalize-space(.)='ED - Company Details - General Information'])[1]/following::span[2]");

	public void Checkbox_Update_ED_CompanyDetails_GeneralInformation() {
		clickByJavaScript(Checkbox_Update_ED_CompanyDetails_GeneralInformation);
	}

	public void UnCheckbox_Update_CompanyDetails_GeneralInformation() {
		clickByJavaScript(UnCheckbox_Update_CompanyDetails_GeneralInformation);
	}

}
