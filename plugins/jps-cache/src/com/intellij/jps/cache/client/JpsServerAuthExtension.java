package com.intellij.jps.cache.client;

import com.intellij.openapi.extensions.ExtensionPointName;

import java.util.Map;

/**
 * Extension point which provides authentication data for requests to the JPS cache server
 */
public interface JpsServerAuthExtension {
  ExtensionPointName<JpsServerAuthExtension> EP_NAME = ExtensionPointName.create("com.jetbrains.jpsServerAuthExtension");

  /**
   * The method provides HTTP authentication headers for the requests to the server.
   * It will be called in the background thread. The assertion that thread isn't EDT can
   * be added to the implementation. If it's not possible to get the authentication headers,
   * empty map or `null` can be return.
   * @return
   */
  Map<String, String> getAuthHeader();
}