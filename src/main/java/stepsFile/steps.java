package stepsFile;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

import org.json.simple.parser.ParseException;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import Utilities.Person;
import Utilities.driverConfiguration;
import Utilities.dataExtraction;

public class steps {
	private static String jsonFilePath = "src/test/resources/TestData/TestData.json";
	driverConfiguration launch = new driverConfiguration();
	WebDriver driver = driverConfiguration.getDriver();
	dataExtraction de = new dataExtraction();
	static Logger logger = Logger.getLogger(steps.class.getName());
	
/**
 * This method opens the application and prints the page title
 * @throws InterruptedException
 */
	public void openApplication() throws InterruptedException {
		driver.get("https://testpages.herokuapp.com/styled/tag/dynamic-table.html");
		logger.info("We are opening the application");
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(5,TimeUnit.SECONDS);
		logger.info(driver.getTitle());
	}
	
	/**
	 * This method inserts the json data in the input field
	 * @throws InterruptedException
	 */
	public void insertValuesIntoTheTable()
			throws FileNotFoundException, IOException, ParseException, InterruptedException {
		Object data = dataExtraction.getRawJsonData(jsonFilePath);
		driver.findElement(By.xpath("//summary[contains(text(),'Table Data')]")).click();
		driver.findElement(By.id("jsondata")).clear();
		driver.findElement(By.id("jsondata")).sendKeys(data.toString());
		driver.findElement(By.id("refreshtable")).click();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);     
	}

	/**
	 * This method verifies the values in table against JSON file
	 */
	public void assertTheInsertedValues() {
		List<Person> tableDetails = dataExtraction.getDataFromJSON(jsonFilePath);
		List<String> names = new ArrayList<String>();
		List<String> genders = new ArrayList<String>();
		List<String> ages = new ArrayList<String>();
		for (Person person : tableDetails) {
			names.add(person.getName());
			genders.add(person.getGender());
			ages.add(Integer.toString(person.getAge()));
		}
		String tableData = "(//table[@id='dynamictable']//tr[%s]//td[%s])";
		int sizeOfTable = driver.findElements(By.xpath("//table//tr")).size();
		int genderCount = 0, namesCount = 0, ageCount = 0;
		try {
			for (int row = 2; row < sizeOfTable; row++) {
				for (int coloumn = 1; coloumn <= 3; coloumn++) {
					if (coloumn == 1) {
						logger.info(driver.findElement(By.xpath(String.format(tableData, row, coloumn))).getText()
								+ "==" + genders.get(genderCount));
						Assert.assertTrue("Values didn't match",
								driver.findElement(By.xpath(String.format(tableData, row, coloumn))).getText()
										.equalsIgnoreCase(genders.get(genderCount)));
						genderCount += 1;
					} else if (coloumn == 2) {
						logger.info(driver.findElement(By.xpath(String.format(tableData, row, coloumn))).getText()
								+ "==" + names.get(namesCount));
						Assert.assertTrue("Values didn't match",
								driver.findElement(By.xpath(String.format(tableData, row, coloumn))).getText()
										.equalsIgnoreCase(names.get(namesCount)));
						namesCount += 1;
					} else if (coloumn == 3) {
						logger.info(driver.findElement(By.xpath(String.format(tableData, row, coloumn))).getText()
								+ "==" + ages.get(ageCount));
						Assert.assertTrue("Values didn't match",
								driver.findElement(By.xpath(String.format(tableData, row, coloumn))).getText()
										.equalsIgnoreCase(ages.get(ageCount)));
						ageCount += 1;
					}
				}
			}
			System.out.println("All the values are inserted into the table succesfully! - PASSED");
		} catch (Exception e) {
			System.out.println("All the values are not inserted into the table - FAILED");
			e.printStackTrace();
		}finally {

		driver.close();
		}
	}

}
