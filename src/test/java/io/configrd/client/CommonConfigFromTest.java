package io.configrd.client;

import io.configrd.core.Config;
import java.util.Properties;
import org.junit.Assert;
import org.junit.Test;

public abstract class CommonConfigFromTest {

  protected Config config;

  protected ConfigClient.BaseClientBuilder client;

  @Test
  public void testGetPropertyFromDefaultRepo() throws Exception {
    config = client.path("env/dev/simple").build();
    Assert.assertNotNull(config.getProperty("property.3.name", String.class));
  }

  @Test
  public void testGetPropertyByPath() throws Exception {
    config = client.path("env/dev/simple").build();
    Assert.assertNotNull(config.getProperty("property.3.name", String.class));
  }

  @Test
  public void testGetPropertyByAbsolutePath() throws Exception {
    config = client.path("/env/dev/simple").build();
    Assert.assertNotNull(config.getProperty("property.3.name", String.class));
  }

  @Test
  public void testGetPropertyFromDefaultRepoByFilename() throws Exception {
    config = client.path("env/dev/simple/default.properties").build();
    Assert.assertNotNull(config.getProperty("property.3.name", String.class));
  }

  @Test
  public void testGetPropertyByFilename() throws Exception {
    config = client.path("env/dev/simple/default.properties").build();
    Assert.assertNotNull(config.getProperty("property.3.name", String.class));
  }
  
  @Test
  public void testGetEmptyProperties() throws Exception {
    config = client.path("does/not/exist/notexists.file").build();
    Assert.assertEquals(3, config.getProperties().size());
  }

  @Test
  public void testGetPropertyOfJson() throws Exception {

    config = client.path("/env/dev/json/default.json").build();

    Properties props = config.getProperties();

    Assert.assertTrue(props.containsKey("property.1.name"));
    Assert.assertEquals("simple", props.getProperty("property.1.name"));

    Assert.assertTrue(props.containsKey("property.4.name"));
    Assert.assertEquals("simple-${property.3.name}", props.getProperty("property.4.name"));

    Assert.assertTrue(props.containsKey("bonus.1.property"));
    Assert.assertEquals("bonus2", props.getProperty("bonus.1.property"));
  }

  @Test
  public void testGetPropertyOfYaml() throws Exception {

    config = client.path("/env/dev/yaml/default.yaml").build();

    Properties props = config.getProperties();

    Assert.assertTrue(props.containsKey("property.1.name"));
    Assert.assertEquals("simple", props.getProperty("property.1.name"));

    Assert.assertTrue(props.containsKey("property.4.name"));
    Assert.assertEquals("simple-${property.3.name}", props.getProperty("property.4.name"));

    Assert.assertTrue(props.containsKey("bonus.1.property"));
    Assert.assertEquals("bonus2", props.getProperty("bonus.1.property"));
  }

  @Test
  public void testPropertyValueSubstitution() throws Exception {
    config = client.path("env/dev/michelangello-custom2").build();

    Assert.assertNotNull(config.getProperty("property.4.name", String.class));
    Assert.assertEquals("simple-michelangello",
        config.getProperty("property.4.name", String.class));
  }

  @Test
  public void testPropertyValueSubstitutionWithMissingValue() throws Exception {
    config = client.path("env/dev/michelangello-custom2").build();

    Assert.assertNotNull(config.getProperty("property.5.name", String.class));
    Assert.assertEquals("${property.1.notexsts}-michelangello",
        config.getProperty("property.5.name", String.class));
  }

}
