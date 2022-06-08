package io.configrd.client;

import org.junit.Before;

public class TestConfigFromHttp extends CommonConfigFromTest {

  @Before
  public void setup() {
    client =
        ConfigClient.config("http://config.appcrossings.net");
  }


}