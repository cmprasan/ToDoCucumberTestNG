package Runner;

import Base.TestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;


@CucumberOptions(
		features={"src/test/resources/Features/TestToDo.feature"},
		glue = { "StepDefenitions", "Hooks" },
		plugin = {"pretty"},
		monochrome = true
		)

public class Runner extends TestNGCucumberTests {

}
