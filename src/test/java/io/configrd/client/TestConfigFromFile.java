package io.configrd.client;

import io.configrd.core.util.UriUtil;
import java.net.URL;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TestConfigFromFile extends CommonConfigFromTest {


  @Before
  public void setup() throws Exception {

    URL url = getClass().getClassLoader().getResource("default.properties");
    client = ConfigClient.config(UriUtil.stripFile(url.toURI()).toString());

  }

}
