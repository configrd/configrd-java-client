package io.configrd.client;

import org.junit.Before;

public class TestConfigFromClasspath extends CommonConfigFromTest {

  public static final String REPO_ROOT_URI = "classpath:/";

  @Before
  public void setup() {
    client = ConfigClient.config(REPO_ROOT_URI);
  }

}
