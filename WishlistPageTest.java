import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class WishlistPageTest {

    public static void main(String[] args) {
        // Set the path to the ChromeDriver executable
        System.setProperty("webdriver.chrome.driver", "PATH_TO_CHROMEDRIVER");

        // Create a WebDriver instance
        WebDriver driver = new ChromeDriver();

        // Navigate to the URL
        driver.get("https://qaecomwishlist.ccbp.tech/");

        // Find checkboxes and buttons
        List<WebElement> checkboxes = driver.findElements(By.className("product-checkbox"));
        List<WebElement> buttons = driver.findElements(By.className("product-button"));

        // Verify initial state of the page
        int selectedCheckboxesCount = 0;
        int enabledButtonsCount = 0;

        for (WebElement checkbox : checkboxes) {
            if (checkbox.isSelected()) selectedCheckboxesCount++;
        }

        for (WebElement button : buttons) {
            if (button.isEnabled()) enabledButtonsCount++;
        }

        if (selectedCheckboxesCount == 2) System.out.println("Selected Checkboxes Matched");
        else System.out.println("Selected Checkboxes Mismatched");

        if (enabledButtonsCount == 3) System.out.println("Enabled Buttons Matched");
        else System.out.println("Enabled Buttons Mismatched");

        // Click all the enabled buttons
        for (WebElement button : buttons) {
            if (button.isEnabled()) button.click();
        }

        // Verify selected checkboxes and disabled buttons
        int selectedCheckboxesAfterClickCount = 0;
        int disabledButtonsCount = 0;

        for (WebElement checkbox : checkboxes) {
            if (checkbox.isSelected()) selectedCheckboxesAfterClickCount++;
        }

        for (WebElement button : buttons) {
            if (!button.isEnabled()) disabledButtonsCount++;
        }

        if (selectedCheckboxesAfterClickCount == 5) System.out.println("Selected Checkboxes Matched");
        else System.out.println("Selected Checkboxes Mismatched");


        if (disabledButtonsCount == 5) System.out.println("Disabled Buttons Matched");
        else System.out.println("Disabled Buttons Mismatched");

        // Refresh the page
        driver.navigate().refresh();

        checkboxes = driver.findElements(By.className("product-checkbox"));
        buttons = driver.findElements(By.className("product-button"));

        // Verify state of the page after refreshing
        int selectedCheckboxesAfterRefreshCount = 0;

        for (WebElement checkbox : checkboxes) {
            if (checkbox.isSelected()) selectedCheckboxesAfterRefreshCount++;
        }

        if (selectedCheckboxesAfterRefreshCount == 2) System.out.println("Selected Checkboxes Matched after Refresh");
        else System.out.println("Selected Checkboxes Mismatched after Refresh");

        int enabledButtonsCountRefreshCount = 0;

        for (WebElement button : buttons) {
            if (button.isEnabled()) enabledButtonsCountRefreshCount++;
        }
        if (enabledButtonsCountRefreshCount == 3) System.out.println("Enabled Buttons Matched after Refresh");
        else System.out.println("Enabled Buttons Mismatched after Refresh");


        // Quit the WebDriver
        driver.quit();
    }
}
