package io.github.xfournet.sandbox;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import io.github.xfournet.sandbox.core.SandboxImpl;

import static org.assertj.core.api.Assertions.assertThat;

public class SandboxImplTest {

    private Sandbox m_sandbox;

    @BeforeMethod
    public void setUp() throws Exception {
        m_sandbox = new SandboxImpl();
    }

    @DataProvider(name = "helloCases")
    public Object[][] providesHelloCases() {
        return new Object[][]{ //
                {"Bill", "Hello Bill!"}, //
                {"Steve", "Hello Steve!"}, //
        };
    }

    @Test(dataProvider = "helloCases")
    public void testHello(String name, String expected) throws Exception {
        String hello = m_sandbox.sayHello(name);
        assertThat(hello).isEqualTo(expected);
    }
}
