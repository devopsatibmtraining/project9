package junitwebapp;
import static net.sourceforge.jwebunit.junit.JWebUnit.*;

import org.junit.Before;
import org.junit.Test;

import net.sourceforge.jwebunit.util.TestingEngineRegistry;


public class JWebUnitTest {
	@Before
	public void prepare() {
		setTestingEngineKey(TestingEngineRegistry.TESTING_ENGINE_HTMLUNIT); 
		setBaseUrl("http://localhost:9090/junit");
	}

	@Test
	public void testLoginPage() {
		beginAt("index.jsp"); 
		assertTitleEquals("Login");
		assertLinkPresent("home");
		clickLink("home");
		assertTitleEquals("Home");
	}
	
	@Test
	public void testHomePage() {
		beginAt("home.jsp"); 
		assertTitleEquals("Home");
		assertLinkPresent("login");
		clickLink("login");
		assertTitleEquals("Login");
	}
}
