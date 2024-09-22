package test.ui.basetests;

import main.ui.driver.DriverSingleton;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

public class BaseTest {
    @BeforeEach
    public void warmUp() {
    }

    @AfterEach
    public void tearDown() {
        DriverSingleton.quit();
    }
}
