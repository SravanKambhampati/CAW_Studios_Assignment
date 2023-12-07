package stepDefinitionsFile;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.json.simple.parser.ParseException;

import io.cucumber.java.en.*;
import stepsFile.steps;

public class stepDefinitions {
	steps stepsObject = new steps();

	@Given("I open the Dynamic Table Application")
	public void i_open_the_Dynamic_Table_Application() throws InterruptedException {
		stepsObject.openApplication();
	}

	@When("Insert the values by reading JSON file")
	public void insert_the_values_by_reading_JSON_file()
			throws FileNotFoundException, IOException, ParseException, InterruptedException {
		stepsObject.insertValuesIntoTheTable();
	}

	@Then("Verify if all the values are inserted inside the table")
	public void verify_if_all_the_values_are_inserted_inside_the_table() {
		stepsObject.assertTheInsertedValues();
	}
}
