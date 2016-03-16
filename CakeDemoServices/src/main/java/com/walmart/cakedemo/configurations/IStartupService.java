
package com.walmart.cakedemo.configurations;

import com.walmart.cakedemo.configuration.exception.InvalidConfigurationException;
import com.walmart.cakedemo.configuration.exception.InvalidFormatException;

public interface IStartupService {

    void loadProperties(boolean forceReload) throws Exception;

    void loadAll(boolean forcedReload) throws Exception;
}
