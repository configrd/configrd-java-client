package io.configrd.client.discovery;

import java.net.URI;
import java.util.Map;
import java.util.Optional;

public interface ConfigDiscoveryStrategy {

  public Optional<URI> lookupConfigPath(Map<String, String> hosts, Map<String, String> envProps);

}
