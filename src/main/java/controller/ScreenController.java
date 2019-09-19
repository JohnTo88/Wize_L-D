package controller;

import java.io.File;
import java.net.URL;

import org.openqa.selenium.Keys;
import org.sikuli.script.FindFailed;
import org.sikuli.script.Screen;

import Ulties.TestLogger;

public class ScreenController  {

	public ScreenController(Screen s1)
	{
		s=s1;
	}
	
	private static URL resource = null;
	private static String tr2 = null;
	private static String spath = null;
	public  Screen s ;
	
	/**
	 * @author HANV
	 * This contructor is used to create a Screen Controller object ,which will make
	 * actions like a user on Website
	 * 
	 */
	
	
	
	
	/*
	 * ________________________ SYSTEM SECTION_______________________________
	 */

	public void sleep(double timeInSecond) {
		try {
			Thread.sleep((long) (timeInSecond * 1000));
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		}
	}

	/**
	 * getResource: Return absolute path to file (image, excel ... in resource
	 * folder
	 * 
	 * @param resourceName name of resource want to get absolute path
	 * 
	 * @author HANV
	 * 
	 * 
	 */
	public String getResource(String resourceName) {
		resource = ScreenController.class.getProtectionDomain().getCodeSource().getLocation();

		tr2 = resource.toString().replace("file:/", "").replace("%20", " ").replace("/", "\\").replace("target", "@");
		int l = tr2.indexOf("@");
		spath = tr2.substring(0, l).replace("@", "") + "src\\test\\resources\\" + resourceName;

		return spath;
	}

	/*
	 * ________________________ SIKULI SECTION_______________________________
	 */

	/**
	 * clickOn: simulator click on Windows
	 * 
	 * @author HANV
	 * @param image image name on resource
	 */
	public void clickOn(String image) {
		spath = getResource(image);
		try {
			s.click(spath);
			sleep(0.5);
		} catch (FindFailed e) {
			TestLogger.warn("Cannot find control : " + image);
		}
	}

	/**
	 * waitForObjectPresent: Wait for object appears on screen
	 * 
	 * @author HANV
	 * @param image wait image, unit: second
	 */
	public Boolean waitForObjectPresent(String image, int timeout) {

		TestLogger.info("Wait for control like " + image + " appears on about " + timeout);
		Boolean isControlExist = false;
		spath = getResource(image);
		File objectImage = new File(spath);
		if (objectImage.exists()) {
			try {
				for (int i = 1; i <= timeout * 2; i++) {
					try {
						s.wait(spath, 1);
						System.out.println(" Control appears! -> break wait for object");
						isControlExist = true;
						break;
					} catch (FindFailed e) {
						double time = timeout - (i * 0.5);
						System.out.print(" . . " + time);
						if (!e.toString().contains("can not find"))
							TestLogger.warn(e.toString());
					} finally {
						sleep(0.5);
					}
				}
			} catch (Exception e) {
				TestLogger.warn(e.toString());
			}
			System.out.println(" Stop waiting control appears");
		} else
			TestLogger.warn("\n\nCannot find image at " + spath + " on local machine, please check\n");
		return isControlExist;
	}

	/**
	 * Wait for object disappears on screen
	 * 
	 * @param image
	 * @param timeout
	 * @return true if object not found on screen
	 * @author HANV
	 */
	public boolean waitforObjectNotexist(String image, int timeout) {
		TestLogger.info("Wait for control like " + image + " disappears");
		Boolean isControlExist = false;
		spath = getResource(image);
		TestLogger.info("Wait for control like " + image + " disappear on about " + timeout + " seconds: ");
		for (int i = 1; i <= timeout * 2; i++) {
			try {
				s.wait(spath, 1);
				double time = timeout - (i * 0.5);
				System.out.print(" . . " + time);
				sleep(0.5);
			} catch (FindFailed e) {
				isControlExist = true;
				break;
			}
		}
		return isControlExist;
	}

	/**
	 * Double -click: use mouse to double click
	 * 
	 * @author HANV
	 * @param image image name
	 */
	public void doubleClick(String image) {
		spath = getResource(image);
		try {
			s.doubleClick(spath);
		} catch (FindFailed e) {
			TestLogger.error("The control " + image + "Not exist, please check image");
		}
	}

	/**
	 * rightlick: use mouse to right click
	 * @author HANV
	 * @param image image name
	 */
	public void rightClick(String image) {
		spath = getResource(image);
		try {
			s.rightClick(spath);
		} catch (FindFailed e) {
			TestLogger.warn("Cannot find control : " + image);
		}
	}

	/**
	 * hoverImage: hover mouse on media to view button Savior and download
	 *
	 * @author HANV
	 * @param image : image name
	 */
	public void hoverImage(String image) {
		spath = getResource(image);
		try {
			s.hover(spath);
		} catch (FindFailed e) {
			e.printStackTrace();
		}
	}
	
	public void typeTextOn(String content)
	{
		s.type(content);
	
	}
	
	
	

}