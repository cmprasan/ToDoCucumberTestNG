package Pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.By.ByXPath;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Base.DriverManager;
import Utility.Util;

public class ToDoPage extends DriverManager {

	@FindBy(xpath = "//*[@h1='todos']")
	WebElement todos;
	
	@FindBy(xpath = "//*[@placeholder='What needs to be done?']")
	WebElement whatToDo;
	
	@FindBy(xpath = "//ul[@class='todo-list']/li/div/label")
	List<WebElement> listItems;
	
	@FindBy(xpath = "//footer/span/strong")
	WebElement itemsLeft;

	@FindBy(xpath = "//label")
	List<WebElement> itemlabels;

	@FindBy(linkText="All")
	WebElement filterAll;
	
	@FindBy(linkText="Active")
	WebElement filterActive;
	
	@FindBy(linkText="Completed")
	WebElement filterCompleted;
	
	@FindBy(xpath = "//ul[@class='todo-list']")
	WebElement todolist;
	
	@FindBy(xpath = "//button[@class='clear-completed']")
	WebElement clearCompleted;
	
	public ToDoPage() {

		PageFactory.initElements(webDriver.get(), this);
	}
	
	public void todoadd(String todo) {
		Util.sendText(whatToDo, todo);
		Util.sendKeys(whatToDo, Keys.RETURN);
	}
	
	public boolean verifyListItem(String item, Integer num) {
		if(item.equalsIgnoreCase(listItems.get(num-1).getText())) {
			return true;
		}
		return false;
	}
	
	public boolean verifyItemLeft(Integer num) {
		if(itemsLeft.getText().equalsIgnoreCase(num.toString())) {
			return true;
		}
		return false;
	}
	
	public boolean verifyItemPresent() {
		if(Integer.parseInt(itemsLeft.getText()) > 1) {
			return true;
		}
		return false;
	}
	
	public void editItem(String original, String edited) throws InterruptedException {
		String eltXpath = "//label[text()='"+original+"']";
	    WebElement elt = webDriver.get().findElement(By.xpath(eltXpath));
	    Util.doubleclick(elt);
	    eltXpath = "//label[text()='"+original+"']//ancestor::div[@class='view']/following-sibling::input[@type='text']";
	    elt = webDriver.get().findElement(By.xpath(eltXpath));
	    elt.sendKeys(Keys.CONTROL, "a"); 
	    elt.sendKeys(edited);
	    Util.sendKeys(elt, Keys.RETURN);   
	}
	
	public boolean verifyItemEdited(String edited) {
		String eltXpath = "//label[text()='"+edited+"']";
		List<WebElement> elt = webDriver.get().findElements(By.xpath(eltXpath));
		//WebElement elt = webDriver.get().findElement(By.xpath(eltXpath));
		if(elt.size()>0) {
			return true;
		}
		return false;
	}
	
	public void hoverClickX(String item) {
		String eltXpath = "//label[text()='"+item+"']/following-sibling::button";
		WebElement elt = webDriver.get().findElement(By.xpath(eltXpath));

        JavascriptExecutor js = (JavascriptExecutor)webDriver.get();
        js.executeScript("arguments[0].click();", elt);    
	    //Util.click(elt);   
	}
	
	public boolean verifydelete(String item) {
		String eltXpath = "//label[text()='"+item+"']";
		List<WebElement> elt = webDriver.get().findElements(By.xpath(eltXpath)); 
		int eltcount = elt.size();
		if(eltcount < 1) {
			return true;
		}
		return false;
	}
	
	public void selectCheckbox(String item) {
		String eltXpath = "//label[text()='"+item+"']//ancestor::div[@class='view']/input[@type='checkbox']";
		WebElement elt = webDriver.get().findElement(By.xpath(eltXpath));   
	    Util.click(elt);   
	}
	
	public boolean verifyCompleted(String item) {
		String eltXpath = "//label[text()='"+item+"']//ancestor::div[@class='view']//ancestor::li[@class='todo completed']";
		List<WebElement> elt = webDriver.get().findElements(By.xpath(eltXpath)); 
		int eltcount = elt.size();
		if(eltcount > 0) {
			return true;
		}
		return false;
	}
	
	public boolean selectFilter(String filter) {
		if(filter.equalsIgnoreCase("Active")) {
			filterActive.click();
			return true;
		}else if(filter.equalsIgnoreCase("Completed")) {
			filterCompleted.click();
			return true;
		}else if(filter.equalsIgnoreCase("All")) {
			filterAll.click();
			return true;
		}else {
			return false;
		}
	}
	
	
	public boolean verifyFilter(String filter) {
		boolean flag=false;
		WebElement element = webDriver.get().findElement(By.xpath("//ul[@class='todo-list']"));
		List<WebElement> compElts = null;
		List<WebElement> actElts = null;
		List<WebElement> allElts;
		if(filter.equalsIgnoreCase("Active")) {
			actElts = element.findElements(By.xpath("//li[not(@class='todo')]"));
				if(actElts.size() < 1) {
					flag = true;
			 }else {flag = false;}
		}else if(filter.equalsIgnoreCase("Completed")) {
			compElts = element.findElements(By.xpath("//li[not(@class='todo completed')]"));
			if(compElts.size() < 1) {
				flag = true;
		 }else {flag = false;}
		}else if(filter.equalsIgnoreCase("All")) {
			allElts = element.findElements(By.xpath("//li[not(starts-with(@class,'todo'))]"));
			if(allElts.size() < 1) {
				allElts = element.findElements(By.xpath("//li[starts-with(@class,'todo')]"));
				if(allElts.size() == (compElts.size()+actElts.size())) {
					flag = true;
				}else {flag = false;}
		 }else {flag = false;}
		}
		if(flag=true) {
			return true;
		}else {
			return false;
		}
	}
	
	public void clickClearCompleted() {
		   Util.click(clearCompleted);
	}
	
	public boolean verifyClearCompleted() {
		   Util.click(filterCompleted);
		   WebElement element = webDriver.get().findElement(By.xpath("//ul[@class='todo-list']"));
			List<WebElement> compElts = null;
			compElts = element.findElements(By.xpath("//li[(@class='todo completed')]"));
					if(compElts.size() < 1) {
						Util.click(filterAll);
						return true;
				 }else {return false;}
	}

}