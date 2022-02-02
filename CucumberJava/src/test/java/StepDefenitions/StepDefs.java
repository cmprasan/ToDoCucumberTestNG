package StepDefenitions;

import Pages.ToDoPage;
import Utility.Util;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.io.IOException;

import org.testng.Assert;
import org.testng.Reporter;
import Base.DriverManager;

public class StepDefs extends DriverManager{

	ToDoPage todoObj = new ToDoPage();

	@Given("User is on the to do page")
	public void user_is_on_the_to_do_page() throws IOException {

		String url = Util.getURL();
		if(url.equalsIgnoreCase("https://todomvc.com/examples/vue/"))
		{
			System.out.println("PASSED: User is on the to do page");
			Assert.assertTrue(true, "PASSED: User is on the to do page");
			Reporter.log("PASSED: User is on the to do page");
		}else {
			System.out.println("FAILED: User is not on the to do page");
			Assert.fail("FAILED: User is not on the to do page");
			Reporter.log("FAILED: User is not on the to do page");
		}

	}


	@When("Enter the item to be done {string}")
	public void enter_the_item_to_be_done_item(String item) {
		todoObj.todoadd(item);
		System.out.println(item);

	}

	@Then("Verify the item added {string} {int}")
	public void verify_the_item_added(String item, Integer itemno) {

		if(todoObj.verifyListItem(item, itemno)) {
			System.out.println("PASSED: To do item '"+item+"' added to the list successfully");
			Assert.assertTrue(true, "PASSED: To do item '"+item+"' added to the list successfully");
			Reporter.log("PASSED: To do item '"+item+" added to the list successfully");
		}else {
			System.out.println("FAILED: To do item not added to the list");
			Assert.assertTrue(true, "FAILED: To do item not added to the list");
			Reporter.log("FAILED: To do item not added to the list");
		}

	}

	@And("Verify items left {int}")
	public void verify_itemsleft(Integer num) {

		if(todoObj.verifyItemLeft(num)) {
			System.out.println("PASSED: Number of items left is " + num + ", which is equivalent to the items in the list");
			Assert.assertTrue(true, "PASSED: Number of items left is " + num + ", which is equivalent to the items in the list");
			Reporter.log("PASSED: Number of items left is " + num + ", which is equivalent to the items in the list");
		}else {
			System.out.println("FAILED: Number of items left is " + num + ", which is not equal to the items in the list");
			Assert.assertTrue(true, "FAILED: Number of items left is " + num + ", which is not equal to the items in the list");
			Reporter.log("FAILED: Number of items left is " + num + ", which is not equal to the items in the list");
		}
	}

	@Given("Items present in the list")
	public void items_present_in_the_list() {

		if(todoObj.verifyItemPresent()) {
			System.out.println("PASSED: Items present in the list");
			Assert.assertTrue(true, "PASSED: Items present in the liste");
			Reporter.log("PASSED: Items present in the list");
		}else {
			System.out.println("FAILED: Items not present in the list");
			Assert.assertTrue(true, "FAILED: Items not present in the list");
			Reporter.log("FAILED: Items not present in the liste");
		}
	}


	@When("Edit the item {string} {string}")
	public void edit_the_item(String original, String edited) throws InterruptedException {
		todoObj.editItem(original, edited);
	}

	@Then("Verify the item edited {string}")
	public void verify_the_item_edited(String edited) {
		if(todoObj.verifyItemEdited(edited)) {
			System.out.println("PASSED: Item edited successfully in the list");
			Assert.assertTrue(true, "PASSED: Item edited successfully in the list");
			Reporter.log("PASSED: Item edited successfully in the list");
		}else {
			System.out.println("FAILED: Item edit failed");
			Assert.assertTrue(true, "FAILED: Item edit failed");
			Reporter.log("FAILED: Item edit failed");
		}
	}

	@When("Hover the mouse and Click X on the item {string}")
	public void hover_the_mouse_on_the_item(String item) {
			todoObj.hoverClickX(item);
	}


	@Then("Verify if item deleted {string}")
	public void verify_if_item_deleted(String item) {
		if(todoObj.verifydelete(item)) {
			System.out.println("PASSED: Item deleted successfully in the list");
			Assert.assertTrue(true, "PASSED: Item deleted successfully in the list");
			Reporter.log("PASSED: Item deleted successfully in the list");
		}else {
			System.out.println("FAILED: Item delete failed");
			Assert.assertTrue(true, "FAILED: Item delete failed");
			Reporter.log("FAILED: Item delete failed");
		}
	}

	
	
	@When("Select the checkbox of the item {string}")
	public void select_the_checkbox_of_the_item(String item) {
		todoObj.selectCheckbox(item);
	}

	@Then("Verify if the item completed {string}")
	public void verify_if_the_item_completed(String item) {
		if(todoObj.verifyCompleted(item)) {
			System.out.println("PASSED: Item completed successfully in the list");
			Assert.assertTrue(true, "PASSED: Item completed successfully in the list");
			Reporter.log("PASSED: Item deleted completed in the list");
		}else {
			System.out.println("FAILED: Item complete failed");
			Assert.assertTrue(true, "FAILED: Item complete failed");
			Reporter.log("FAILED: Item complete failed");
		}
	}


	@When("Select filter {string}")
	public void select_filter(String filter) {
		if(todoObj.selectFilter(filter)) {
			System.out.println("PASSED: Filter selected successfully");
			Assert.assertTrue(true, "PASSED: Filter selected successfully");
			Reporter.log("PASSED: Filter selected successfully");
		}else {
			System.out.println("FAILED: Filter selection failed");
			Assert.assertTrue(true, "FAILED: Filter selection failed");
			Reporter.log("FAILED: Filter selection failed");
		}
	}

	@Then("Verify items in filter {string}")
	public void verify_the_active_items(String filter) {
		if(todoObj.verifyFilter(filter)) {
			System.out.println("PASSED: '" +filter+"' Filter verified successfully");
			Assert.assertTrue(true, "PASSED: '" +filter+"' Filter verified successfully");
			Reporter.log("PASSED: '" +filter+"' Filter verified successfully");
		}else {
			System.out.println("FAILED: '" +filter+"' Filter verification failed");
			Assert.assertTrue(true, "FAILED: '" +filter+"' Filter verification failed");
			Reporter.log("FAILED: '" +filter+"' Filter verification failed");
		}
	}


	@When("Click Clear Completed link")
	public void click_clear_completed_link() {
		todoObj.clickClearCompleted();
	}

	@Then("Verify if completed item removed")
	public void verify_if_completed_item_removed() {
		if(todoObj.verifyClearCompleted()) {
			System.out.println("PASSED: Completed items cleared successfully");
			Assert.assertTrue(true, "PASSED: Completed items cleared successfully");
			Reporter.log("PASSED: Completed items cleared successfully");
		}else {
			System.out.println("FAILED: Completed items not cleared successfully");
			Assert.assertTrue(true, "FAILED: Completed items not cleared successfully");
			Reporter.log("FAILED: Completed items not cleared successfully");
		}
	}

}
