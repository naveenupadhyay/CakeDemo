package com.walmart.cakedemo.cache.loader;

import com.walmart.cakedemo.configuration.exception.InvalidConfigurationException;
import com.walmart.cakedemo.configuration.exception.InvalidFormatException;

public interface ICacheLoader {

    void loadProperties();

    void loadCakeDemoPropertiesCache() throws InvalidFormatException, InvalidConfigurationException;

    void loadCakeDemoPropertiesCacheWithParams(String confgPath, String fileName) throws InvalidFormatException, InvalidConfigurationException;

}
