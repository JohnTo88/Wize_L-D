package talentwize.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import controller.WebActions;

public class Administration extends WebActions {

	By menuAdministrator = By.xpath("//span[contains(.,'Administration')]");
	By subMenuUserManagement = By.xpath("//span[contains(.,'User Management')]");
	By subMenuAuditLog = By.xpath("//span[contains(.,'Audit Log')]");
	By TabRoles = By.xpath("//tab-heading[contains(.,'Roles')]");
	By tabUsers = By.xpath("//tab-heading[contains(.,'Users')]");
	By tabRolesv2 = By
			.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Users'])[1]/following::tab-heading[1]");
	By subMenuOrganization = By.xpath("//span[contains(.,'Organization')]");
	By subMenuSites = By.xpath("//span[contains(.,'Sites')]");
    By menuCompanyDetails = By.xpath("//span[contains(.,'Company Details')]"); 
    
	By subMenuUnits = By.xpath("//span[contains(.,'Units')]");
	By subMenuJobTitle = By.xpath("(//span[contains(.,'Job Title')])[1]");
	By TabJobTitle = By.xpath("(//a[contains(.,'Job Title')])[2]");
	By TabJobCategory = By.xpath("//a[contains(.,'Job Category')]");
	By TabRoleLevel = By.xpath("//a[contains(.,'Role Level')]");
	By menuConfiguration = By.xpath("//span[contains(.,'Configuration')]");
	By subMenuDefault = By.xpath("//span[contains(.,'Default')]");
	By subMenuDomain = By.xpath("//span[contains(.,'Domain')]");
	By subMenuCodeIdenitySettings = By.xpath("//span[contains(.,'Code Identity Setting')]");
	By subMenuSelecInput = By.xpath("//span[contains(.,'Select Inputs')]");
	By subMenuNotification = By.xpath("//span[contains(.,'Notifications')]");
	By subMenuMentor = By.xpath("//span[contains(.,'Mentors')]");
	By subMenuBroadcast = By.xpath("(//span[contains(.,'Broadcast')])[1]");
	By subMenuCustomFields = By.xpath("//span[contains(.,'Custom Fields')]");
	By subMenuCharts = By.xpath("//span[contains(.,'Charts')]");
	By subMenuAzureLDAP = By.xpath("//span[contains(.,'Azure LDAP')]");
	By subMenuPowerBI = By.xpath("(//span[contains(.,'Power BI')])[1]");
	By menuLeave = By.xpath("//span[@class='nav-link text-ellipsis enable-tooltip ng-binding'][contains(.,'Leave')]");
	By subMenuLeaveCalendar = By.xpath("//span[contains(.,'Leave Calendar')]");
	By subLeaveSettings = By.xpath("//span[contains(.,'Leave Settings')]");
	By subMenuBalanceList = By.xpath("(//span[text()='Balance List'])");
	By subMenuListRequest = By.xpath("(//span[text()='Request List'])");
	By menuEmployeeList = By.xpath("(//span[contains(.,'Employee List')])[1]");
	
	By menuEmployeeData = By.xpath("//span[contains(.,'Employee Data')]");
	By subMenuPersonalDetails = By.xpath("//span[contains(.,'Personal Details')]");
	By subMenuSkills = By.xpath("//span[@class='text-ellipsis enable-tooltip ng-binding'][contains(.,'Skills')]");
	
	By logoTalenWize = By.xpath("(//img[contains(@alt,'.')])[1]");
	By subMenuContactDetails = By.xpath("//span[contains(.,'Contact Details')]");
	By subMenuOtherContact = By.xpath("//span[contains(.,'Other Contacts')]");
	By subMenuCompanyJobHistory = By.xpath("//span[contains(.,'Company Job History')]");
	By subMenuRemuneration = By.xpath("//span[contains(.,'Remuneration')]");
	By subMenuQualification = By.xpath("//span[contains(.,'Qualification')]");
	By subMenuWorkMobility = By.xpath("//span[contains(.,'Work Mobility')]");
	By menuProjectManagement = By.xpath(".//span[contains(.,'Project Management')]");
	By subMenuProjectDetail = By
			.xpath("//span[@class='text-ellipsis enable-tooltip ng-binding'][contains(.,'Project Detail')]");
	By tabProjectInfo = By.xpath("//a[@href='#/te/project-management/project-detail/projectinfo']");
	By tabProjectCapacity = By.xpath("//a[@href='#/te/project-management/project-detail/capacity']");
	By subMenuProjectBoard = By.xpath(".//span[@class='text-ellipsis enable-tooltip ng-binding'][contains(.,'Project Board')]");
	By subMenuDocuments = By.xpath("//span[contains(.,'Documents')]");
	By subMenuEmployment = By.xpath("//span[contains(.,'Employment')]");
	By subMenuProject = By.xpath("//span[contains(.,'Projects')]");
	By subMenuTasks = By.xpath("//span[contains(.,'Tasks')]");

	By subMenuAssets = By.xpath("//span[contains(.,'Assets')]");
	By menuPerformance = By.xpath("(//span[contains(.,'Performance')])[1]");
	By subMenuKPI = By.xpath("(//i[@class='fs-8 icon icon-arrow-right4 text'])[7]");
	By subMenuKPIBoard = By.xpath("//span[contains(.,'KPI Board')]");
	
	By subMenuKPIBoardByProject = By.xpath("(//span[contains(.,'KPI Board')])[2]");	
	By subMenuMyKPI = By.xpath("(//span[contains(.,'My KPI')])[2]");
	By subMenuKPISettings = By.xpath("//span[contains(.,'KPI Settings')]");
	By subMenuCheckIn = By.xpath("(//span[contains(.,'Check-in')])[1]");
	By subMenuCheckInBoard = By.xpath("//span[contains(.,'Check-in Board')]");
	By subMenuSeriesSettings = By.xpath("(//span[contains(.,'Series Settings')])[1]");
	By subMenuAppraisalBoard = By.xpath("//span[contains(.,'Appraisal Board')]");
	By subMenuMyAppraisal = By.xpath("//span[@class='text-ellipsis enable-tooltip ng-binding'][contains(.,'My Appraisal')]");
	
	By subMenuTrainingManagement = By.xpath("//span[contains(.,'Training Management')]");
	By subMenuProgram = By.xpath("(//span[contains(.,'Programs')])[1]");
	By subMenuCourses = By.xpath("(//span[contains(.,'Courses')])[1]");
	By subTabPrograms = By.xpath("(//a[contains(.,'Programs')])[2]");
	By subTabTrainingManagement = By.xpath("(//a[contains(.,'Training Management')])[2]");

	By subMenuMyAssignedTraining = By.xpath("(//span[contains(.,'My Assigned Training')])[2]");
	By subMeunuMyTraining = By.xpath("(//span[contains(.,'My Training')])[2]");

	By subMenuMyKPIByProject = By.xpath("(//span[contains(.,'My KPI')])[3]");
	
	By subMenuMyCheckIn = By.xpath("(//span[contains(.,'My Check-in')])[2]"); 
    By tabRoleLevel = By.xpath("//a[contains(.,'Role Level')]");
    By tabJobTile = By.xpath("(//a[contains(.,'Job Title')])[2]");
    By tabJobCategory = By.xpath("//a[contains(.,'Job Category')]");
    By tabRoleTitle = By.xpath("//a[contains(.,'Role Title')]");
	
	
	
	public void clickSubMenuMyKPIByProject() {
		waitForElementClickable(10, subMenuMyKPIByProject);
		clickByJavaScript(subMenuMyKPIByProject);
	}
	
	public boolean isSubMenuMyKPIByProjectDisplayed() {
		boolean flag = false;
		try {
			if (driver.findElement(subMenuMyKPIByProject).isDisplayed() == true) {

				flag = true;
			}
		} catch (Exception e) {
			return flag;
		}
		return flag;

	}

	
	
	public void clickTabJobTile() {
		waitForElementClickable(10, tabJobTile);
		clickByJavaScript(tabJobTile);
	}
	
	public void clickTabRoleLevel() {
		waitForElementClickable(10, tabRoleLevel);
		clickByJavaScript(tabRoleLevel);
	}
	
	public void clickTabJobCategory() {
		waitForElementClickable(10, tabJobCategory);
		clickByJavaScript(tabJobCategory);
		sleep(2);
	}
	
	public void clickTabRoleTitle() {
		waitForElementClickable(10, tabRoleTitle);
		clickByJavaScript(tabRoleTitle);

	}
	
	public void clickSubMenuTrainingManagement() {
		waitForElementClickable(10, subMenuTrainingManagement);
		clickByJavaScript(subMenuTrainingManagement);
	}
	
	public void clickSubMenuMyAssignedTraining() {
		waitForElementClickable(10, subMenuMyAssignedTraining);
		clickByJavaScript(subMenuMyAssignedTraining);
	}
	
	public void clickSubMenuDocument() {
		waitForElementClickable(10, subMenuDocuments);
		clickByJavaScript(subMenuDocuments);
	}
	
	public void clickSubMenuOrganization() {
		waitForElementClickable(10, subMenuOrganization);
		clickByJavaScript(subMenuOrganization);
	}
	
	
	public boolean isSubMenuMyAssignedTrainingDisplayed() {
		boolean flag = false;
		try {
			if (driver.findElement(subMenuMyAssignedTraining).isDisplayed() == true) {
				flag = true;
			}
		} catch (Exception e) {
			return flag;
		}
		return flag;
	}
	
	public boolean isSubMenuSubMenuJobTitleDisplayed() {
		boolean flag = false;
		try {
			if (driver.findElement(subMenuJobTitle).isDisplayed() == true) {
				flag = true;
			}
		} catch (Exception e) {
			return flag;
		}
		return flag;
	}

	public void clickSubMeunuMyTraining() {
		waitForElementClickable(10, subMeunuMyTraining);
		clickByJavaScript(subMeunuMyTraining);
	}
	
	public void clickSubMenuMyCheckIn() {
		waitForElementClickable(10, subMenuMyCheckIn);
		clickByJavaScript(subMenuMyCheckIn);
	}
	
	
	public boolean isSubMenuMyCheckInDisplayed() {
		boolean flag = false;
		try {
			if (driver.findElement(subMenuMyCheckIn).isDisplayed() == true) {

				flag = true;
			}
		} catch (Exception e) {
			return flag;
		}
		return flag;
	}
	
	
	public boolean isSubMenuMyTrainingDisplayed() {
		boolean flag = false;
		try {
			if (driver.findElement(subMeunuMyTraining).isDisplayed() == true) {

				flag = true;
			}
		} catch (Exception e) {
			return flag;
		}
		return flag;
	}
	
	By subMenuKPIByProject = By.xpath("//span[contains(.,'KPI By Project')]");
	By subMenuKPISettingsByProject = By.xpath("(//span[contains(.,'KPI Settings')])[2]");
	
	public void clickSubMenuKPIByProject() {
		waitForElementClickable(10, subMenuKPIByProject);
		clickByJavaScript(subMenuKPIByProject);
	}
	
	public void clickSubMenuKPISettingsByProject() {
		waitForElementClickable(10, subMenuKPISettingsByProject);
		clickByJavaScript(subMenuKPISettingsByProject);
	}
	
	public boolean isSubMenuKPIByProjectDisplayed() {
		boolean flag = false;
		try {
			if (driver.findElement(subMenuKPIByProject).isDisplayed() == true) {

				flag = true;
			}
		} catch (Exception e) {
			return flag;
		}
		return flag;
	}
	
	public boolean isSubMenuKPISettingsByProjectDisplayed() {
		boolean flag = false;
		try {
			if (driver.findElement(subMenuKPISettingsByProject).isDisplayed() == true) {

				flag = true;
			}
		} catch (Exception e) {
			return flag;
		}
		return flag;
	}
	
	//========My Balance List==================
	By subMenuMyBalanceList = By.xpath("(//span[contains(.,'My Balance List')])[1]"); 
	
	public void clickSubMenuMyBlanceList()
	{
		waitForElementClickable(5, subMenuMyBalanceList);
		clickByJavaScript(subMenuMyBalanceList);
	}
	
	public boolean isSubMenuMyBalanceListDisplayed() {
		boolean flag = false;
		try {
			if (driver.findElement(subMenuMyBalanceList).isDisplayed() == true) {
				flag = true;
			}
		} catch (Exception e) {
			return flag;
		}
		return flag;
	}
	
	//=====================
	
	By menuMasterScheduling = By.xpath("//span[contains(.,'Master Scheduling')]"); 
	By subMenuScheduleBoard = By.xpath("//span[contains(.,'Schedule Board')]"); 
	By subMenuMySchedule = By.xpath("//span[contains(.,'My Schedule')]");
	
	public boolean isMenuMasterSchedulingDisplayed() {
		boolean flag = false;
		try {
			if (driver.findElement(menuMasterScheduling).isDisplayed() == true) {
				flag = true;
			}
		} catch (Exception e) {
			return flag;
		}
		return flag;
	}
	
	public boolean isSubMenuScheduleBoardDisplayed() {
		boolean flag = false;
		try {
			if (driver.findElement(subMenuScheduleBoard).isDisplayed() == true) {
				flag = true;
			}
		} catch (Exception e) {
			return flag;
		}
		return flag;
	}
	
	public boolean isSubMenuMyScheduleDisplayed() {
		boolean flag = false;
		try {
			if (driver.findElement(subMenuMySchedule).isDisplayed() == true) {
				flag = true;
			}
		} catch (Exception e) {
			return flag;
		}
		return flag;
	}
	
	
	
	public void clickMenuMasterScheduling() {
		waitForElementClickable(10, menuMasterScheduling);
		clickByJavaScript(menuMasterScheduling);
	}
	
	public void clickSubMenuScheduleBoard() {
		waitForElementClickable(10, subMenuScheduleBoard);
		clickByJavaScript(subMenuScheduleBoard);
		sleep(4);
	}
	
	public void clickSubMenuMySchedule() {
		waitForElementClickable(10, subMenuMySchedule);
		clickByJavaScript(subMenuMySchedule);
	}
	public void clickSubMenuProgram() {
		sleep(2);
		clickByJavaScript(subMenuProgram);
	}
	
	public void clickSubMenuCourses() {
		waitForElementClickable(10, subMenuCourses);
		clickByJavaScript(subMenuCourses);
		sleep(2);
	}
	
	public boolean isSubMenuTrainingManagementDisplayed() {
		boolean flag = false;
		try {
			if (driver.findElement(subMenuTrainingManagement).isDisplayed() == true) {
				flag = true;
			}
		} catch (Exception e) {
			return flag;
		}
		return flag;
	}
	
	public boolean isMenuTrainingDisplayed() {
		boolean flag = false;
		try {
			if (driver.findElement(menuTraining).isDisplayed() == true) {
				flag = true;
			}
		} catch (Exception e) {
			return flag;
		}
		return flag;
	}
	
	public boolean isSubMenuProgramDisplayed() {
		boolean flag = false;
		try {
			if (driver.findElement(subMenuProgram).isDisplayed() == true) {
				flag = true;
			}
		} catch (Exception e) {
			return flag;
		}
		return flag;
	}
	
	
	
	public boolean isSubMenuCoursesDisplayed() {
		boolean flag = false;
		try {
			if (driver.findElement(subMenuCourses).isDisplayed() == true) {
				flag = true;
			}
		} catch (Exception e) {
			return flag;
		}
		return flag;
	}
	
	public boolean isSubTabProgramsDisplayed() {
		boolean flag = false;
		try {
			if (driver.findElement(subTabPrograms).isDisplayed() == true) {
				flag = true;
			}
		} catch (Exception e) {
			return flag;
		}
		return flag;
	}
	
	public boolean isSubTabTrainingManagementDisplayed() {
		boolean flag = false;
		try {
			if (driver.findElement(subTabTrainingManagement).isDisplayed() == true) {
				flag = true;
			}
		} catch (Exception e) {
			return flag;
		}
		return flag;
	}
	
	By subMenuProjectSettings = By.xpath("(//span[contains(.,'Project Settings')])[1]");
	By tabProjectCategory = By.xpath("//a[contains(.,'Project Category')]");
	By tabProjectGroup = By.xpath("//a[contains(.,'Project Group')]");
	By tabProjectStatus = By.xpath("//a[contains(.,'Project Status')]");
	By tabMemberStatus = By.xpath("//a[contains(.,'Member Status')]");
	By tabProjectRole = By.xpath("//a[contains(.,'Project Role')]");
	By menuGoals = By.xpath("//span[contains(.,'Goals')]");
	By subMenuGoalBoard = By.xpath("(//span[contains(.,'Goal Board')])[1]");
	By subMenuGoalManagement = By.xpath("(//span[contains(.,'Goal Management')])[1]");
	By subMenuMyGoal = By.xpath("(//span[contains(.,'My Goal')])[2]");

	By subMenuHeadCount = By.xpath("//span[contains(.,'Headcount')]");
	By subMenuQuota = By.xpath("(//a[contains(.,'Quota')])[1]");
	By subMenuActualVolume = By.xpath("(//span[contains(.,'Actual Volume')])");
	By subMenuCompanyDetails = By.xpath("(//span[contains(.,'Company Details')])");
	
	//=====================Talent Management==================================
	By subMenuMyCompetencies=By.xpath("//span[contains(.,'My Competencies')]");
	By tabCompetencyConfiguration=By.xpath("//tab-heading[contains(.,'Competency Configuration')]");
	By tabCompetencyMapping=By.xpath("//tab-heading[contains(.,'Competency Mapping')]");
	
	By menuTraining = By.xpath("(//span[contains(.,'Training')])[3]"); 
	By subMenuTrainingSettings = By.xpath("//span[contains(.,'Training Settings')]"); 
	
	public void clickSubMenuMyCompetencies() {
		waitForElementClickable(10, subMenuMyCompetencies);
		clickByJavaScript(subMenuMyCompetencies);
	}
	
	public void clickTabCompetencyConfiguration() {
		clickByJavaScript(tabCompetencyConfiguration);
	}
	public void clickTabCompetencyMapping() {
		clickByJavaScript(tabCompetencyMapping);
	}
	
	public void clickMenuTraining()
	{
		waitForElementClickable(10, menuTraining);
		clickByJavaScript(menuTraining);
	}
	
	public void clickSubMenuTrainingSettings()
	{
		clickByJavaScript(subMenuTrainingSettings);
	}
	
	public void clickMenuCompanyDetails()
	{
		clickByJavaScript(menuCompanyDetails);
	}
	
	public boolean isSubMenuCompetencySettingsDisplayed() {
		boolean flag = false;
		try {
			if (driver.findElement(subMenuCompetencySettings).isDisplayed() == true) {
				flag = true;
			}
		} catch (Exception e) {
			return flag;
		}
		return flag;
	}
	
	public boolean isSubMenuTrainingSettingsDisplayed() {
		boolean flag = false;
		try {
			if (driver.findElement(subMenuTrainingSettings).isDisplayed() == true) {
				flag = true;
			}
		} catch (Exception e) {
			return flag;
		}
		return flag;
	}
	
	
	public boolean isSubMenuMyCompetenciesDisplayed() {
		boolean flag = false;
		try {
			if (driver.findElement(subMenuMyCompetencies).isDisplayed() == true) {
				flag = true;
			}
		} catch (Exception e) {
			return flag;
		}
		return flag;
	}
	
	public boolean isTabCompetencyConfigurationDisplayed() {
		boolean flag = false;
		try {
			if (driver.findElement(tabCompetencyConfiguration).isDisplayed() == true) {

				flag = true;
			}
		} catch (Exception e) {
			return flag;
		}
		return flag;
	}
	
	//=====================Talent Report==================================
	By menuReports = By.xpath("//span[contains(.,'Reports')]");
	By subMenuTalentReport = By.xpath("//span[contains(.,'Talent Report')]");

	
	public void clickMenuReports()
	{
		clickByJavaScript(menuReports);
	}
		
	public void clickSubMenuTalentReport()
	{
		clickByJavaScript(subMenuTalentReport);
	}
	
	public boolean isMenuReportsDisplayed() {
		boolean flag = false;
		try {
			if (driver.findElement(menuReports).isDisplayed() == true) {
				flag = true;
			}
		} catch (Exception e) {
			return flag;
		}
		return flag;
	}
	
	public boolean isSubMenuTalentReportDisplayed() {
		boolean flag = false;
		try {
			if (driver.findElement(subMenuTalentReport).isDisplayed() == true) {
				flag = true;
			}
		} catch (Exception e) {
			return flag;
		}
		return flag;
	}	
	//============================
	
	//=====================Employee Report==================================
		By subMenuEmployeeReport = By.xpath("//span[contains(.,'Employee Report')]");
				
		public void clickSubMenuEmployeeReport()
		{
			waitForElementClickable(10, subMenuEmployeeReport);
			clickByJavaScript(subMenuEmployeeReport);
			sleep(2);
		}
		
		
		public boolean isSubMenuEmployeeReportDisplayed() {
			boolean flag = false;
			try {
				if (driver.findElement(subMenuEmployeeReport).isDisplayed() == true) {
					flag = true;
				}
			} catch (Exception e) {
				return flag;
			}
			return flag;
		}	
		//============================

	By subMenuProjectDetails = By.xpath("//span[contains(.,'Project Detail')]");
	By subMenuTargetVolume = By
			.xpath("//span[@class='text-ellipsis enable-tooltip ng-binding'][contains(.,'Target Volume')]");
	By tabProjectBoard = By.xpath("(//a[contains(.,'Project Board')])[2]");
	By tabTargetVolume = By.xpath("(//a[contains(.,'Target Volume')])[2]");
	By subMenuAppraisal = By.xpath("(//i[contains(@class,'fs-8 icon icon-arrow-right4 text')])[10]");
	By subMenuManagement = By.xpath("(//span[contains(.,'Management')])[4]");
	By tabAppraisals = By.xpath("//a[contains(.,'Appraisals')]");
	By subMenuManagement2 = By.xpath("(//span[@class='text-ellipsis enable-tooltip ng-binding'])[49]");


	//================TALENT MANAGEMENT================//
	
	By menuTalentManagement = By.xpath("//a[contains(.,'Talent Management')]");
	By subMenuCompetency = By.xpath("(//span[contains(.,'Competency')])[1]");
	By subMenuCompetencySettings = By.xpath("//span[contains(.,'Competency Settings')]");
	By tabCertificateConfiguration = By.xpath("//tab-heading[contains(.,'Certificate Configuration')]");
	By tabSkillConfiguration = By.xpath("//tab-heading[contains(.,'Skill Configuration')]");
	By tabCompetencyReviewSchedule = By.xpath("//tab-heading[contains(.,'Competency Review Schedule')]");
	By subMeunuCareerDevelopment = By.xpath("(//span[contains(.,'Career Development')])[2]");
	By subMenuDevelopmentBoard = By.xpath("//span[contains(.,'Development Board')]");
	By subMenuMyDevelopment = By.xpath("//span[contains(.,'My Development')]");
	By subMenuCompetencyBoard  = By.xpath("//span[contains(.,'Competency Board')]"); 

	public void clickMenuTalentManagement() {
		waitForElementClickable(10, menuTalentManagement);
		clickByJavaScript(menuTalentManagement);
	}
	
	public boolean isSubMenuCompetencyBoardDisplayed() {
		boolean flag = false;
		try {
			if (driver.findElement(subMenuCompetencyBoard).isDisplayed() == true) {
				flag = true;
			}
		} catch (Exception e) {
			return flag;
		}
		return flag;
	}

	public void clickSubMenuCompetency() {
		waitForElementClickable(10, subMenuCompetency);
		clickByJavaScript(subMenuCompetency);
	}

	public void clickSubMenuCompetencySettings() {
		waitForElementClickable(10, subMenuCompetencySettings);
		clickByJavaScript(subMenuCompetencySettings);
	}
	
	
	public void clickSubMenuCompetencyBoard() {
		waitForElementClickable(10, subMenuCompetencyBoard);
		clickByJavaScript(subMenuCompetencyBoard);
	}
	
	public void clickTabSkillConfiguration() {
		waitForElementClickable(10, tabSkillConfiguration);
		clickByJavaScript(tabSkillConfiguration);
	}
	
	public void clickTabCompetencyReviewSchedule() {
		waitForElementClickable(10, tabCompetencyReviewSchedule);
		clickByJavaScript(tabCompetencyReviewSchedule);
	}
	
	public boolean isTabCompetencyReviewScheduleDisplayed() {
		boolean flag = false;
		try {
			if (driver.findElement(tabCompetencyReviewSchedule).isDisplayed() == true) {
				flag = true;
			}
		} catch (Exception e) {
			return flag;
		}
		return flag;
	}
	
	//===================================================//


	By subMenuSuccessionPlanning = By.xpath("//span[contains(.,'Succession Planning')]");
	By subMenuSuccessionBoard = By.xpath("//span[contains(.,'Succession Board')]");
	By subMenuMySuccessors = By.xpath("//span[contains(.,'My Successors')]");
	By subMenuSuccession = By.xpath("//span[contains(.,'My Succession')]");
	By subMenuCareerDevelopment = By.xpath("(//span[contains(.,'Career Development')])[2]");
	By subMenuDevelopementBoard = By.xpath("//span[contains(.,'Development Board')]");

	public void clickSubmenuCareerDevelopment() {
		clickByJavaScript(subMenuCareerDevelopment);
	}

	public void clickSubmenuDevelopementBoard() {
		clickByJavaScript(subMenuDevelopementBoard);
	}

	public void clickSubMenuSuccessionPlanning() {
		sleep(4);
		clickByJavaScript(subMenuSuccessionPlanning);
	}
	
	public void clickSubMenuSuccessionBoard() {
		clickByJavaScript(subMenuSuccessionBoard);
	}

	public void clickSubMenuMySuccessors() {
		clickByJavaScript(subMenuMySuccessors);
	}

	public void clickSubMenuMySuccession() {
		clickByJavaScript(subMenuSuccession);
	}


	public boolean isTabCertificateConfigurationDisplayed() {
		boolean flag = false;
		try {
			if (driver.findElement(tabCertificateConfiguration).isDisplayed() == true) {

				flag = true;
			}
		} catch (Exception e) {
			return flag;
		}
		return flag;
	}
	public boolean isTabCompetencyMappingDisplayed() {
		boolean flag = false;
		try {
			if (driver.findElement(tabCompetencyMapping).isDisplayed() == true) {

				flag = true;
			}
		} catch (Exception e) {
			return flag;
		}
		return flag;
	}
	public boolean isTabSkillConfigurationDisplayed() {
		boolean flag = false;
		try {
			if (driver.findElement(tabSkillConfiguration).isDisplayed() == true) {

				flag = true;
			}
		} catch (Exception e) {
			return flag;
		}
		return flag;
	}

	//================END TALENT MANAGEMENT================//
	
	//================REPORT================//
	
	By menuReport = By.xpath("//a[@ng-switch-when='true'][contains(.,'Reports')]");
	By subMenuAssetReport = By.xpath("//span[contains(.,'Asset Report')]");
	By subMenuTimesheetReport = By.xpath("//span[contains(.,'Timesheet Report')]");

	public void clickMenuReport() {
		clickByJavaScript(menuReport);
	}
	
	public boolean isSubMenuAssetReportDisplayed() {
		boolean flag = false;
		try {
			if (driver.findElement(subMenuAssetReport).isDisplayed() == true) {
				flag = true;
			}
		} catch (Exception e) {
			return flag;
		}
		return flag;
	}

	public void clickSubMenuAssetReport() {
		clickByJavaScript(subMenuAssetReport);
	}
	
	public boolean isSubmenuTimesheetReportDisplayed() {
		boolean flag = false;
		try {
			if (driver.findElement(subMenuTimesheetReport).isDisplayed() == true) {
				flag = true;
			}
		} catch (Exception e) {
			return flag;
		}
		return flag;
	}

	public void clickSubMenuTimesheetReport() {
		clickByJavaScript(subMenuTimesheetReport);
	}
	
	//================Leave REPORT================//
		By subMenuLeaveReport = By.xpath("	//span[contains(.,'Leave Report')]");

		public void clickSubMenuLeaveReport() 
		{
			clickByJavaScript(subMenuLeaveReport);
		}
		
		public boolean isSubMenuLeaveReportDisplayed() {
			boolean flag = false;
			try {
				if (driver.findElement(subMenuLeaveReport).isDisplayed() == true) {
					flag = true;
				}
			} catch (Exception e) {
				return flag;
			}
			return flag;
		}
	
	// ============= Capacity Report ==========
	
	By subMenuCapacityReport = By.xpath("//span[contains(.,'Capacity Report')]"); 
	By subMenuProjectReport = By.xpath("//span[contains(.,'Project Report')]");
	
	public boolean isSubmenuCapacityReportDisplayed() {
		boolean flag = false;
		try {
			if (driver.findElement(subMenuCapacityReport).isDisplayed() == true) {
				flag = true;
			}
		} catch (Exception e) {
			return flag;
		}
		return flag;
	}
	
	public boolean isSubmenuProjectReportDisplayed() {
		boolean flag = false;
		try {
			if (driver.findElement(subMenuProjectReport).isDisplayed() == true) {
				flag = true;
			}
		} catch (Exception e) {
			return flag;
		}
		return flag;
	}
	
	public void clickSubMenuCapacityReport() {
		clickByJavaScript(subMenuCapacityReport);
	}
	
	public void clickSubMenuProjectReport() {
		clickByJavaScript(subMenuProjectReport);
	}
	
	// ============= Training Report ==========
	
		By subMenuTrainingReport = By.xpath("//span[contains(.,'Training Report')]"); 
		
		public boolean isSubMenuTrainingReportDisplayed() {
			boolean flag = false;
			try {
				if (driver.findElement(subMenuTrainingReport).isDisplayed() == true) {
					flag = true;
				}
			} catch (Exception e) {
				return flag;
			}
			return flag;
		}
		
		public void clickSubMenuTrainingReport() {
			clickByJavaScript(subMenuTrainingReport);
		}

	//================END REPORT================//

	public Administration(WebDriver driver) {
		super(driver);
	}

	public void clickSubMenuManagement() {
		clickByJavaScript(subMenuManagement);
		sleep(5);
	}

	public void clickTabProjectCapacity() {
		waitForElementClickable(10, tabProjectCapacity);
		clickByJavaScript(tabProjectCapacity);
	}

	public void clickSubMenuTargetVolume() {
		clickByJavaScript(subMenuTargetVolume);
	}

	public void clickSubMenuActualVolume() {
		clickByJavaScript(subMenuActualVolume);
	}

	public void clickSubMenuAssets() {
		clickByJavaScript(subMenuAssets);
	}

	public void clickSubMenuQuota() {
		waitForElementClickable(10, subMenuQuota);
		clickByJavaScript(subMenuQuota);
		sleep(10);
	}

	public void clickSubMenuProjectDetails() {
		waitForElementClickable(10, subMenuProjectDetails);
		clickByJavaScript(subMenuProjectDetails);
	}

	public void clickSubHeadCount() {
		waitForElementClickable(10, subMenuHeadCount);
		clickByJavaScript(subMenuHeadCount);
		sleep(10);
	}

	public void clickMenuGoals() {
		clickByJavaScript(menuGoals);
	}

	public void clicksubMenuTargetVolume() {
		waitForElementClickable(5, subMenuTargetVolume);
		clickByJavaScript(subMenuTargetVolume);
		sleep(10);
	}

	public void clickMenuPerformance() {
		waitForElementClickable(10, menuPerformance);
		clickByJavaScript(menuPerformance);
	}

	public void clickSubMenuSeriesSettings() {
		waitForElementClickable(10, subMenuSeriesSettings);
		clickByJavaScript(subMenuSeriesSettings);

	}

	public void clickSubMenuGoadBoard() {
		waitForElementClickable(10, subMenuGoalBoard);
		clickByJavaScript(subMenuGoalBoard);

	}

	public void clickSubMenuGoadManagement() {
		waitForElementClickable(10, subMenuGoalManagement);
		clickByJavaScript(subMenuGoalManagement);
	}
	
	
	public void clickSubMenuMyGoal() {
		waitForElementClickable(10, subMenuMyGoal);
		clickByJavaScript(subMenuMyGoal);
	}
	
	public boolean isSubMenuMyGoalDisplayed() {
		boolean flag = false;
		try {
			if (driver.findElement(subMenuMyGoal).isDisplayed() == true) {
				flag = true;
			}
		} catch (Exception e) {
			return flag;
		}
		return flag;
	}

	public void clickSubMenuCompanyDetails() {
		
		clickByJavaScript(subMenuCompanyDetails);

	}

	public boolean isSubMenuSeriesSettingsDisplayed() {
		boolean flag = false;
		try {
			if (driver.findElement(subMenuSeriesSettings).isDisplayed() == true) {
				flag = true;
			}
		} catch (Exception e) {
			return flag;
		}
		return flag;
	}

	public boolean isSubMenuDevelopementBoardDisplayed() {
		boolean flag = false;
		try {
			if (driver.findElement(subMenuDevelopementBoard).isDisplayed() == true) {
				flag = true;
			}
		} catch (Exception e) {
			return flag;
		}
		return flag;
	}

	public boolean isSubMenuMySuccessorsDisplayed() {
		boolean flag = false;
		try {
			if (driver.findElement(subMenuMySuccessors).isDisplayed() == true) {
				flag = true;
			}
		} catch (Exception e) {
			return flag;
		}
		return flag;
	}

	public boolean isSubMenuSuccessionDisplayed() {
		boolean flag = false;
		try {
			if (driver.findElement(subMenuSuccession).isDisplayed() == true) {
				flag = true;
			}
		} catch (Exception e) {
			return flag;
		}
		return flag;
	}

	public boolean isSubMenuProjectDetailsDisplayed() {
		boolean flag = false;
		try {
			if (driver.findElement(subMenuProjectDetails).isDisplayed() == true) {
				flag = true;
			}
		} catch (Exception e) {
			return flag;
		}
		return flag;
	}

	public boolean isSubMenuActualVolumeDisplayed() {
		boolean flag = false;
		try {
			if (driver.findElement(subMenuActualVolume).isDisplayed() == true) {
				flag = true;
			}
		} catch (Exception e) {
			return flag;
		}
		return flag;
	}

	public boolean isSubMenuHeadCountDisplayed() {
		boolean flag = false;
		try {
			if (driver.findElement(subMenuHeadCount).isDisplayed() == true) {
				flag = true;
			}
		} catch (Exception e) {
			return flag;
		}
		return flag;
	}

	public boolean isSubMenuProjectSettingsDisplayed() {
		boolean flag = false;
		try {
			if (driver.findElement(subMenuProjectSettings).isDisplayed() == true) {
				flag = true;
			}
		} catch (Exception e) {
			return flag;
		}
		return flag;
	}

	public boolean isSubMenuGoalBoardDisplayed() {
		boolean flag = false;
		try {
			if (driver.findElement(subMenuGoalBoard).isDisplayed() == true) {
				flag = true;
			}
		} catch (Exception e) {
			return flag;
		}
		return flag;
	}

	public boolean isSubMenuGoalManagementDisplayed() {
		boolean flag = false;
		try {
			if (driver.findElement(subMenuGoalManagement).isDisplayed() == true) {
				flag = true;
			}
		} catch (Exception e) {
			return flag;
		}
		return flag;
	}

	public void clickSubMenuProjectSettings() {
		clickByJavaScript(subMenuProjectSettings);
	}

	public void clickTabProjectCategory() {
		clickByJavaScript(tabProjectCategory);
	}

	public void clickTabProjecGroup() {
		clickByJavaScript(tabProjectGroup);
	}

	public void clickTabProjectStatus() {
		clickByJavaScript(tabProjectStatus);
	}

	public void clickTabMemberStatus() {
		clickByJavaScript(tabMemberStatus);
	}

	public void clickTabProjectRole() {
		clickByJavaScript(tabProjectRole);
	}

	public boolean isSubMenuCompanyDetailsDisplayed() {
		boolean flag = false;
		try {
			waitForElementClickable(5, subMenuCompanyDetails);
			if (driver.findElement(subMenuCompanyDetails).isDisplayed() == true) {
				flag = true;
			}
		} catch (Exception e) {
			return flag;
		}
		return flag;
	}

	public void clickSubMenuCheckIn() {
		clickByJavaScript(subMenuCheckIn);
	}

	public void clickSubMenuCheckInBoard() {
		waitForElementClickable(5, subMenuCheckInBoard);
		clickByJavaScript(subMenuCheckInBoard);
	}

	public void clickSubMenuKPIBoard() {
		waitForElementClickable(10, subMenuKPIBoard);
		clickByJavaScript(subMenuKPIBoard);
	}

	public boolean isSubMenuKPIBoardDisplayed() {
		boolean flag = false;
		try {
			if (driver.findElement(subMenuKPIBoard).isDisplayed() == true) {
				flag = true;
			}
		} catch (Exception e) {
			return flag;
		}
		return flag;
	}
	
	public void clickSubMenuKPIBoardByProject() {
		waitForElementClickable(10, subMenuKPIBoardByProject);
		clickByJavaScript(subMenuKPIBoardByProject);
	}

	public boolean isSubMenuKPIBoardByProjectDisplayed() {
		boolean flag = false;
		try {
			if (driver.findElement(subMenuKPIBoardByProject).isDisplayed() == true) {
				flag = true;
			}
		} catch (Exception e) {
			return flag;
		}
		return flag;
	}
	
	
	public boolean isSubMenuKPIByProjectDisplayed1() {
		boolean flag = false;
		try {
			if (driver.findElement(subMenuKPIByProject).isDisplayed() == true) {
				flag = true;
			}
		} catch (Exception e) {
			return flag;
		}
		return flag;
	}
		
	
	public boolean isSubMenuMyKPIDisplayed() {
		boolean flag = false;
		try {
			if (driver.findElement(subMenuMyKPI).isDisplayed() == true) {
				flag = true;
			}
		} catch (Exception e) {
			return flag;
		}
		return flag;
	}
	
	public void clickSubMenuMyKPI() {
		waitForElementClickable(10, subMenuMyKPI);
		clickByJavaScript(subMenuMyKPI);
	}

	public boolean isSubMenuCheckInBoardDisplayed() {
		boolean flag = false;
		try {
			if (driver.findElement(subMenuCheckInBoard).isDisplayed() == true) {
				flag = true;
			}
		} catch (Exception e) {
			return flag;
		}
		return flag;
	}

	public void clickSubMenuKPISettings() {
		waitForElementClickable(10, subMenuKPISettings);
		clickByJavaScript(subMenuKPISettings);
	}

	public void clickSubMenuKPI() {
		waitForElementClickable(10, subMenuKPI);
		clickByJavaScript(subMenuKPI);
	}

	public boolean isSubMenuKPISettingsDisplayed() {
		boolean flag = false;
		try {
			sleep(3);
			if (driver.findElement(subMenuKPISettings).isDisplayed() == true) {
				flag = true;
			}
		} catch (Exception e) {
			return flag;
		}
		return flag;
	}

	public boolean isSubMenuPersonalDetailsDisplayed() {
		boolean flag = false;
		try {
			if (driver.findElement(subMenuPersonalDetails).isDisplayed() == true) {
				flag = true;
			}
		} catch (Exception e) {
			return flag;
		}
		return flag;
	}
	
	public boolean isSubMenuSkillsDisplayed() {
		boolean flag = false;
		try {
			if (driver.findElement(subMenuSkills).isDisplayed() == true) {
				flag = true;
			}
		} catch (Exception e) {
			return flag;
		}
		return flag;
	}
	
	public void clickSubMenuSkills() {
		clickByJavaScript(subMenuSkills);
	}

	public void clickMenuProjects() {
		clickByJavaScript(subMenuProject);
	}

	public boolean isSubMenuProjectDisplayed() {
		boolean flag = false;
		try {
			if (driver.findElement(subMenuProject).isDisplayed() == true) {
				flag = true;
			}
		} catch (Exception e) {
			return flag;
		}
		return flag;
	}

	public boolean isSubMenuAssetsDisplayed() {
		boolean flag = false;
		try {
			if (driver.findElement(subMenuAssets).isDisplayed() == true) {
				flag = true;
			}
		} catch (Exception e) {
			return flag;
		}
		return flag;
	}

	public boolean isSubMenuTasksDisplayed() {
		boolean flag = false;
		try {
			if (driver.findElement(subMenuTasks).isDisplayed() == true) {
				flag = true;
			}
		} catch (Exception e) {
			return flag;
		}
		return flag;
	}

	public boolean isSubMenuCompanyJobHistoryDisplayed() {
		boolean flag = false;
		try {
			sleep(10);
			if (driver.findElement(subMenuCompanyJobHistory).isDisplayed() == true) {
				flag = true;
			}
		} catch (Exception e) {
			return flag;
		}
		return flag;
	}

	public boolean isSubMenuOtherContactDisplayed() {
		boolean flag = false;
		try {
			if (driver.findElement(subMenuOtherContact).isDisplayed() == true) {
				flag = true;
			}
		} catch (Exception e) {
			return flag;
		}
		return flag;
	}

	public void clickSubMenuTasks() {
		waitForElementClickable(10, subMenuTasks);
		clickByJavaScript(subMenuTasks);
	}

	public boolean isSubMenuEmploymentDisplayed() {
		boolean flag = false;
		try {
			if (driver.findElement(subMenuEmployment).isDisplayed() == true) {
				flag = true;
			}
		} catch (Exception e) {
			return flag;
		}
		return flag;
	}

	public boolean isSubMenuContactDetailsDisplayed() {
		boolean flag = false;
		try {
			if (driver.findElement(subMenuContactDetails).isDisplayed() == true) {
				flag = true;
			}
		} catch (Exception e) {
			return flag;
		}
		return flag;
	}

	public void clickTabProjectInfo() {
		waitForElementClickable(10, tabProjectInfo);
		clickByJavaScript(tabProjectInfo);
	}

	public void clickSubMenuProjectBoard() {
		WebElement element = driver.findElement(subMenuProjectBoard);
		scrollToElement(element);
		waitForElementClickable(10, subMenuProjectBoard);
		clickByJavaScript(subMenuProjectBoard);
		sleep(3);
	}

	public boolean isSubMenuProjectBoardDisplayed() {
		boolean flag = false;
		try {
			if (driver.findElement(subMenuProjectBoard).isDisplayed() == true) {
				flag = true;
			}
		} catch (Exception e) {
			return flag;
		}
		return flag;
	}

	public void clickSubMenuPersonalDetails() {
		waitForElementClickable(10, subMenuPersonalDetails);
		clickByJavaScript(subMenuPersonalDetails);
		sleep(1);
	}

	public void clickSubMenuCompanyJobHistory() {
		waitForElementClickable(5, subMenuCompanyJobHistory);
		clickByJavaScript(subMenuCompanyJobHistory);
	}

	public void clickSubMenuOtherContact() {
		waitForElementClickable(10, subMenuOtherContact);
		clickByJavaScript(subMenuOtherContact);
		sleep(3);
	}

	public void clickSubMenuContactDetails() {
		waitForElementClickable(10, subMenuContactDetails);
		clickByJavaScript(subMenuContactDetails);
	}

	public void clickMenuProjectManagement() {
		waitForElementClickable(10, menuProjectManagement);
		clickByJavaScript(menuProjectManagement);
		sleep(2);
	}

	public void clickSubMenuProjectDetail() {
		waitForElementClickable(5, subMenuProjectDetail);
		clickByJavaScript(subMenuProjectDetail);
	}

	public void clickLogoTalentWize() {
		waitForElementClickable(15, logoTalenWize);
		clickByJavaScript(logoTalenWize);
		sleep(3);
		clickByJavaScript(logoTalenWize);
		sleep(3);
	}

	public boolean isSubMenuPowerBIDisplayed() {
		boolean flag = false;
		try {
			if (driver.findElement(subMenuPowerBI).isDisplayed() == true) {
				flag = true;
			}
		} catch (Exception e) {
			return flag;
		}
		return flag;
	}

	public void clickMenuEmployeeData() {
		waitForElementClickable(10, menuEmployeeData);
		clickByJavaScript(menuEmployeeData);
	}

	public void clickMenuEmployeeList() {
		waitForElementClickable(10, menuEmployeeList);
		clickByJavaScript(menuEmployeeList);
	}

	public boolean isMenuEmployeeListDisplayed() {
		boolean flag = false;
		try {
			if (driver.findElement(menuEmployeeList).isDisplayed() == true) {
				flag = true;
			}
		} catch (Exception e) {
			return flag;
		}
		return flag;
	}

	public boolean isSubMenuLeaveSettingsDisplayed() {
		boolean flag = false;
		try {
			if (driver.findElement(subLeaveSettings).isDisplayed() == true) {
				flag = true;
			}
		} catch (Exception e) {
			return flag;
		}
		return flag;
	}

	public boolean isSubMenuBalanceListDisplayed() {
		boolean flag = false;
		try {
			if (driver.findElement(subMenuBalanceList).isDisplayed() == true) {
				flag = true;
			}
		} catch (Exception e) {
			return flag;
		}
		return flag;
	}

	public boolean isSubMenuRequestListDisplayed() {
		boolean flag = false;
		try {
			if (driver.findElement(subMenuListRequest).isDisplayed() == true) {
				flag = true;
			}
		} catch (Exception e) {
			return flag;
		}
		return flag;
	}

	public void clickSubMenuListRequest() {
		waitForElementClickable(10, subMenuListRequest);
		clickByJavaScript(subMenuListRequest);
	}

	public void clickSubMenuBalanceList() {
		waitForElementClickable(10, subMenuBalanceList);
		clickByJavaScript(subMenuBalanceList);
	}

	public void clickSubMenuLeaveSettings() {
		waitForElementClickable(10, subLeaveSettings);
		clickByJavaScript(subLeaveSettings);
	}

	public void clickSubMenuAzureLDAP() {
		waitForElementClickable(10, subMenuAzureLDAP);
		clickByJavaScript(subMenuAzureLDAP);
	}

	public void clickMenuLeave() {
		waitForElementClickable(10, menuLeave);
		clickByJavaScript(menuLeave);
	}

	public void clickSubMenuLeaveCalendar() {
		waitForElementClickable(10, subMenuLeaveCalendar);
		clickByJavaScript(subMenuLeaveCalendar);
	}

	public boolean isSubMenuLeaveCalendarDisplayed() {
		boolean flag = false;
		try {
			if (driver.findElement(subMenuLeaveCalendar).isDisplayed() == true) {
				flag = true;
			}
		} catch (Exception e) {
			return flag;
		}
		return flag;
	}

	public void clickSubMenuPowerBI() {
		waitForElementClickable(10, subMenuPowerBI);
		clickByJavaScript(subMenuPowerBI);
	}

	public void clickSubMenuCustomFields() {
		waitForElementClickable(10, subMenuCustomFields);
		clickByJavaScript(subMenuCustomFields);
	}

	public void clickSubMenuCharts() {
		waitForElementClickable(10, subMenuCharts);
		clickByJavaScript(subMenuCharts);
	}

	public void clickSunMenuMentor() {
		waitForElementClickable(10, subMenuMentor);
		clickByJavaScript(subMenuMentor);
	}

	public boolean isSubMenuAzureLDADisplayed() {
		boolean flag = false;
		try {
			if (driver.findElement(subMenuAzureLDAP).isDisplayed() == true) {
				flag = true;
			}
		} catch (Exception e) {
			return flag;
		}
		return flag;
	}

	public boolean isSubMenuChartsDisplayed() {
		boolean flag = false;
		try {
			if (driver.findElement(subMenuCharts).isDisplayed() == true) {
				flag = true;
			}
		} catch (Exception e) {
			return flag;
		}
		return flag;
	}

	public boolean isSubMenuDomainDisplayed() {
		boolean flag = false;
		try {
			if (driver.findElement(subMenuDomain).isDisplayed() == true) {
				flag = true;
			}
		} catch (Exception e) {
			return flag;
		}
		return flag;
	}

	public boolean isSubMenuCustomFieldsDisplayed() {
		boolean flag = false;
		try {
			if (driver.findElement(subMenuCustomFields).isDisplayed() == true) {
				flag = true;
			}
		} catch (Exception e) {
			return flag;
		}
		return flag;
	}

	public boolean isMenuBoardcastDisplayed() {
		boolean flag = false;
		try {
			if (driver.findElement(subMenuBroadcast).isDisplayed() == true) {
				flag = true;
			}
		} catch (Exception e) {
			return flag;
		}
		return flag;
	}

	public boolean isMenuMentorDisplayed() {
		boolean flag = false;
		try {
			if (driver.findElement(subMenuMentor).isDisplayed() == true) {
				flag = true;
			}
		} catch (Exception e) {
			return flag;
		}
		return flag;
	}

	public boolean isSubMenuNotificationDisplayed() {
		boolean flag = false;
		try {
			if (driver.findElement(subMenuNotification).isDisplayed() == true) {
				flag = true;
			}
		} catch (Exception e) {
			return flag;
		}
		return flag;
	}

	public boolean isSubMenuCodeIdenitySettingsDisplayed() {
		boolean flag = false;
		try {
			if (driver.findElement(subMenuCodeIdenitySettings).isDisplayed() == true) {
				flag = true;
			}
		} catch (Exception e) {
			return flag;
		}
		return flag;
	}

	public void openRolesTab() {

		waitForElementClickable(10, TabRoles);
		clickByJavaScript(TabRoles);
		sleep(5);
	}

	public void openTabJobTitle() {
		waitForElementClickable(10, TabJobTitle);
		clickByJavaScript(TabJobTitle);
		sleep(5);
	}

	public void openTabJobCategory() {
		waitForElementClickable(10, TabJobCategory);
		clickByJavaScript(TabJobCategory);
		sleep(5);
	}

	public void openTabJobLevel() {
		waitForElementClickable(10, TabRoleLevel);
		clickByJavaScript(TabRoleLevel);
		sleep(5);
	}

	public void clickMenuUserManagement() {

		if (isUserManagementDisplayed() == false) {
			clickMenuAdministration();
		}
        sleep(3);
        
		// waitForElementClickable(10, subMenuUserManagement);
		clickByJavaScript(subMenuUserManagement);
	}

	public void clickMenuConfiguration() {

		if (isMenuConfigurationDisplayed() == false) {
			clickMenuAdministration();
		}

		waitForElementClickable(10, menuConfiguration);
		clickByJavaScript(menuConfiguration);
	}

	public void clickMenuDefault() {
		waitForElementClickable(10, subMenuDefault);
		clickByJavaScript(subMenuDefault);
	}

	public boolean isUserManagementDisplayed() {

		boolean flag = false;

		try {

			if (driver.findElement(subMenuUserManagement).isDisplayed() == true) {
				flag = true;

			}

		} catch (Exception e) {
			return flag;
		}
		return flag;

	}

	public void clickSubMenuDomain() {
		waitForElementClickable(10, subMenuDomain);
		clickByJavaScript(subMenuDomain);
	}

	public void clickSubMenuEmployment() {
		waitForElementClickable(10, subMenuEmployment);
		clickByJavaScript(subMenuEmployment);
	}

	public void clickSubMenuSelecInput() {
		waitForElementClickable(10, subMenuSelecInput);
		clickByJavaScript(subMenuSelecInput);
	}

	public void clickSubMenuBoardcast() {
		waitForElementClickable(10, subMenuBroadcast);
		clickByJavaScript(subMenuBroadcast);
	}

	public void clickSubMenuNotifications() {
		waitForElementClickable(10, subMenuNotification);
		clickByJavaScript(subMenuNotification);
	}

	public boolean isSubMenuSelectInputDisplayed() {

		boolean flag = false;

		try {

			if (driver.findElement(subMenuSelecInput).isDisplayed() == true) {
				flag = true;

			}

		} catch (Exception e) {
			return flag;
		}
		return flag;

	}

	public boolean isAdministrationDisplayed() {

		boolean flag = false;

		try {
			sleep(6);
			if (driver.findElement(menuAdministrator).isDisplayed() == true) {
				flag = true;

			}

		} catch (Exception e) {
			return flag;
		}
		return flag;

	}

	public boolean isMenuDefaultsDisplayed() {

		boolean flag = false;

		try {

			if (driver.findElement(subMenuDefault).isDisplayed() == true) {
				flag = true;

			}

		} catch (Exception e) {
			return flag;
		}
		return flag;

	}

	public boolean isMenuConfigurationDisplayed() {
		boolean flag = false;

		try {

			if (driver.findElement(menuConfiguration).isDisplayed() == true) {
				flag = true;

			}

		} catch (Exception e) {
			return flag;
		}
		return flag;
	}

	public boolean isMenuJobTitleDisplayed() {
		boolean flag = false;

		try {

			if (driver.findElement(subMenuJobTitle).isDisplayed() == true) {
				flag = true;

			}

		} catch (Exception e) {
			return flag;
		}
		return flag;
	}

	public boolean isTabJobTitleDisplayed() {
		boolean flag = false;

		try {

			if (driver.findElement(TabJobTitle).isDisplayed() == true) {
				flag = true;

			}

		} catch (Exception e) {
			return flag;
		}
		return flag;
	}

	public boolean isTabJobCategoryDisplayed() {
		boolean flag = false;

		try {

			if (driver.findElement(TabJobCategory).isDisplayed() == true) {
				flag = true;

			}

		} catch (Exception e) {
			return flag;
		}
		return flag;
	}

	public boolean isTabRoleLevelDisplayed() {
		boolean flag = false;

		try {

			if (driver.findElement(TabRoleLevel).isDisplayed() == true) {
				flag = true;

			}

		} catch (Exception e) {
			return flag;
		}
		return flag;
	}

	public boolean isMenuOgranizationDisplayed() {

		boolean flag = false;

		try {

			if (driver.findElement(subMenuOrganization).isDisplayed() == true) {
				flag = true;

			}

		} catch (Exception e) {
			return flag;
		}
		return flag;

	}

	public boolean isMenuSitesDisplayed() {

		boolean flag = false;

		try {

			if (driver.findElement(subMenuSites).isDisplayed() == true) {
				flag = true;

			}

		} catch (Exception e) {
			return flag;
		}
		return flag;

	}

	public void clickSubMenuCodeIdenitySettings() {
		waitForElementClickable(10, subMenuCodeIdenitySettings);
		clickByJavaScript(subMenuCodeIdenitySettings);
	}

	public void clickMenuAdministration() {
		sleep(3);
		clickByJavaScript(menuAdministrator);
	}

	public void clickMenuOgranization() {

		if (isMenuOgranizationDisplayed() == false) {
			clickMenuAdministration();
		}
		waitForElementClickable(10, subMenuOrganization);
		clickByJavaScript(subMenuOrganization);
	}

	public void clickMenuSites() {
		if (isMenuSitesDisplayed() == false) {
			clickMenuAdministration();
		}

		waitForElementClickable(10, subMenuSites);
		clickByJavaScript(subMenuSites);
	}

	public void clickMenuJobTitle() {
		if (isMenuJobTitleDisplayed() == false) {
			clickMenuOgranization();
		}

		waitForElementClickable(10, subMenuJobTitle);
		clickByJavaScript(subMenuJobTitle);
	}

	public void clickMenuUnits() {
		if (isMenuUnitsDisplayed() == false) {
			clickMenuOgranization();
		}

		waitForElementClickable(10, subMenuUnits);
		clickByJavaScript(subMenuUnits);
	}

	public void clickMenuAuditLog() {
		waitForElementClickable(10, subMenuAuditLog);
		clickByJavaScript(subMenuAuditLog);
	}

	public boolean isAuditLogDisplayed() {
		boolean flag = false;

		try {

			if (driver.findElement(subMenuAuditLog).isDisplayed() == true) {
				flag = true;

			}

		} catch (Exception e) {
			return flag;
		}
		return flag;

	}

	public boolean isMenuUnitsDisplayed() {

		boolean flag = false;

		try {

			if (driver.findElement(subMenuUnits).isDisplayed() == true) {
				flag = true;

			}

		} catch (Exception e) {
			return flag;
		}
		return flag;

	}

	public void openRolesTabv2() {
		waitForElementClickable(10, tabRolesv2);
		clickByJavaScript(tabRolesv2);
	}

	public void openTabUsers() {
		waitForElementClickable(10, tabUsers);
		clickByJavaScript(tabUsers);
	}

	public boolean isTabRolesDisplayed() {
		try {
			if (driver.findElement(TabRoles).isDisplayed() == true) {
				return true;
			} else {
				return false;
			}
		} catch (Exception e) {

			return false;
		}
	}

	public void scrollToSubMenuCompanyJobHistory() {
		scrollToElement(driver.findElement(subMenuCompanyJobHistory));
		sleep(1);
	}

	public boolean isSubMenuRemunerationDisplayed() {
		boolean flag = false;
		try {
			if (driver.findElement(subMenuRemuneration).isDisplayed() == true) {
				flag = true;
			}
		} catch (Exception e) {
			return flag;
		}
		return flag;
	}

	public void clickSubMenuQualification() {
		waitForElementClickable(10, subMenuQualification);
		clickByJavaScript(subMenuQualification);
	}

	public void clickSubMenuWorkMobility() {
		waitForElementClickable(10, subMenuWorkMobility);
		clickByJavaScript(subMenuWorkMobility);
	}

	public boolean isSubMenuQualificationDisplayed() {
		boolean flag = false;
		try {
			if (driver.findElement(subMenuQualification).isDisplayed() == true) {
				flag = true;
			}
		} catch (Exception e) {
			return flag;
		}
		return flag;
	}

	public boolean isSubMenuWorkMobilityDisplayed() {
		boolean flag = false;
		try {
			if (driver.findElement(subMenuWorkMobility).isDisplayed() == true) {
				flag = true;
			}
		} catch (Exception e) {
			return flag;
		}
		return flag;
	}

	public boolean isSubMenuDocumentDisplayed() {
		boolean flag = false;
		try {
			sleep(5);
			if (driver.findElement(subMenuDocuments).isDisplayed() == true) {
				flag = true;
			}
		} catch (Exception e) {
			return flag;
		}
		return flag;
	}

	public void scrollToSubMenuDocument() {
		scrollToElement(driver.findElement(subMenuDocuments));
	}

	public void scrollTosubMenuEmployment() {
		scrollToElement(driver.findElement(subMenuEmployment));
	}

	public boolean istabProjectInfoDisplayed() {
		boolean flag = false;
		try {
			if (driver.findElement(tabProjectInfo).isDisplayed() == true) {
				flag = true;
			}
		} catch (Exception e) {
			return flag;
		}
		return flag;
	}

	public void scrollTosubMenuProjectDetail() {
		scrollToElement(driver.findElement(subMenuProjectDetail));
	}

	public void scrollTosubMenuProjectSettings() {
		scrollToElement(driver.findElement(subMenuProjectSettings));
	}

	public boolean isSubMenuTargetVolumeDisplayed() {
		boolean flag = false;
		try {
			if (driver.findElement(subMenuTargetVolume).isDisplayed() == true) {
				flag = true;
			}
		} catch (Exception e) {
			return flag;
		}
		return flag;
	}

	public void clickTabProjectBoard() {
		waitForElementClickable(10, tabProjectBoard);
		clickByJavaScript(tabProjectBoard);
	}

	public void clickTabTargetVolume() {
		waitForElementClickable(10, tabTargetVolume);
		clickByJavaScript(tabTargetVolume);
	}

	public boolean istabProjectCapacityDisplayed() {
		boolean flag = false;
		try {
			waitForElementPresent(10, tabProjectCapacity);
			if (driver.findElement(tabProjectCapacity).isDisplayed() == true) {
				flag = true;
			}
		} catch (Exception e) {
			return flag;
		}
		return flag;
	}

	public boolean isSubMenuQuotaDisplayed() {
		boolean flag = false;
		try {
			if (driver.findElement(subMenuQuota).isDisplayed() == true) {
				flag = true;
			}
		} catch (Exception e) {
			return flag;
		}
		return flag;
	}

	
	public void clickSubMenuCareerDevelopment() {
		waitForElementClickable(10, subMeunuCareerDevelopment);
		clickByJavaScript(subMeunuCareerDevelopment);
	}

	public boolean isSubMeunuCareerDevelopmentDisplayed() {
		boolean flag = false;
		try {
			if (driver.findElement(subMeunuCareerDevelopment).isDisplayed() == true) {
				flag = true;
			}
		} catch (Exception e) {
			return flag;
		}
		return flag;
	}

	public void clickTabAppraisals() {
		waitForElementClickable(10, tabAppraisals);
		clickByJavaScript(tabAppraisals);
		sleep(3);
	}

	public boolean isSubMenuManagementDisplayed() {
		boolean flag = false;
		try {
			sleep(5);
			if (driver.findElement(subMenuManagement2).isDisplayed() == true) {

				flag = true;
			}
		} catch (Exception e) {
			return flag;
		}
		return flag;
	}

	
	public void clicksubMenuDevelopmentBoard() {
		waitForElementClickable(10, subMenuDevelopmentBoard);
		clickByJavaScript(subMenuDevelopmentBoard);
	}

	public boolean isMenuDevelopmentBoardDisplayed() {
		boolean flag = false;
		try {
			if (driver.findElement(subMenuDevelopmentBoard).isDisplayed() == true) {
				flag = true;
			}
		} catch (Exception e) {
			return flag;
		}
		return flag;
	}

	public void clickSubMenuAppraisal() {
		waitForElementClickable(10, subMenuAppraisal);
		clickByJavaScript(subMenuAppraisal);
	}

	public boolean isSubMenuAppraisalDisplayed() {
		boolean flag = false;
		try {
			if (driver.findElement(subMenuAppraisal).isDisplayed() == true) {

				flag = true;
			}
		} catch (Exception e) {
			return flag;
		}
		return flag;
	}
	
	public void clickSubMenuMyAppraisal() {
		waitForElementClickable(10, subMenuMyAppraisal);
		clickByJavaScript(subMenuMyAppraisal);
	}

	public boolean isSubMenuMyAppraisalDisplayed() {
		boolean flag = false;
		try {
			if (driver.findElement(subMenuMyAppraisal).isDisplayed() == true) {

				flag = true;
			}
		} catch (Exception e) {
			return flag;
		}
		return flag;
	}

	
	public void clickSubMenuMyDevelopment() {
		waitForElementClickable(10, subMenuMyDevelopment);
		clickByJavaScript(subMenuMyDevelopment);
	}

	public boolean isSubMenuMyDevelopmentDisplayed() {
		boolean flag = false;
		try {
			if (driver.findElement(subMenuMyDevelopment).isDisplayed() == true) {
				flag = true;
			}
		} catch (Exception e) {
			return flag;
		}
		return flag;
	}

	public void clickSubMenuAppraisalManagement() {
		waitForElementClickable(10, subMenuManagement);
		clickByJavaScript(subMenuManagement);
	}

	public boolean isSubMenuAppraisalManagementDisplayed() {
		boolean flag = false;
		try {
			if (driver.findElement(subMenuManagement).isDisplayed() == true) {


				flag = true;
			}
		} catch (Exception e) {
			return flag;
		}
		return flag;
	}

	public void clickSubMenuAppraisalBoard() {
		waitForElementClickable(10, subMenuAppraisalBoard);
		clickByJavaScript(subMenuAppraisalBoard);
	}
	
	//=====================Timsheet==================================
	By menuTimesheet = By.xpath("(//span[contains(.,'Timesheet')])[2]");
	By subMenuTimesheetBoard = By.xpath("//a[contains(.,'Timesheet Board')]");
	By tabTimesheetBoard = By.xpath("(//span[contains(.,'Timesheet Board')])[2]");
	By subMenuMyTimesheet = By.xpath("(//span[contains(.,'My Timesheet')])[2]");

	public void clickMenuTimesheet() 
	{
		waitForElementClickable(10, menuTimesheet);
		clickByJavaScript(menuTimesheet);
	}
	
	public void clickSubMenuTimesheetBoard() 
	{
		waitForElementClickable(10, subMenuTimesheetBoard);
		clickByJavaScript(subMenuTimesheetBoard);
		sleep(2);
	}
	
	public void clickSubMenuMyTimesheet() 
	{
		waitForElementClickable(10, subMenuMyTimesheet);
		clickByJavaScript(subMenuMyTimesheet);
	}
	
	public boolean isMenuTimesheetDisplayed() {
		boolean flag = false;
		try {
			if (driver.findElement(menuTimesheet).isDisplayed() == true) {


				flag = true;
			}
		} catch (Exception e) {
			return flag;
		}
		return flag;
	}
	
	public boolean isSubMenuTimesheetBoardDisplayed() {
		boolean flag = false;
		try {
			if (driver.findElement(subMenuTimesheetBoard).isDisplayed() == true) {


				flag = true;
			}
		} catch (Exception e) {
			return flag;
		}
		return flag;
	}
	
	public boolean isTabTimesheetBoardDisplayed() {
		boolean flag = false;
		try {
			if (driver.findElement(tabTimesheetBoard).isDisplayed() == true) {


				flag = true;
			}
		} catch (Exception e) {
			return flag;
		}
		return flag;
	}
	

//==================Leave - My Request List================
	By subTabMyRequestList = By.xpath("(//a[contains(.,'My Request List')])[2]");
	By subMenuMyRequestList = By.xpath("(//span[contains(.,'My Request List')])[1]");
	
	public void clickSubMenuMyRequestList()
	{
		waitForElementClickable(5, subMenuMyRequestList);
		clickByJavaScript(subMenuMyRequestList);
	}

	public boolean isSubMenuMyTimesheetDisplayed() {
		boolean flag = false;
		try {
			if (driver.findElement(subMenuMyTimesheet).isDisplayed() == true) {


				flag = true;
			}
		} catch (Exception e) {
			return flag;
		}
		return flag;
	}


	
	public boolean isSubMenuMyRequestListDisplayed() {
		boolean flag = false;
		try {
			if (driver.findElement(subMenuMyRequestList).isDisplayed() == true) {
				flag = true;
			}
		} catch (Exception e) {
			return flag;
		}
		return flag;
	}
	
	public boolean isSubTabMyRequestListDisplayed() {
		boolean flag = false;
		try {
			if (driver.findElement(subTabMyRequestList).isDisplayed() == true) {
				flag = true;
			}
		} catch (Exception e) {
			return flag;
		}
		return flag;
	}
}
