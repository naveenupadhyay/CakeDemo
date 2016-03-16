package com.walmart.cakedemo.cache.loader.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.webapputils.base.cache.CacheManager;
import com.walmart.cakedemo.annotations.Reload;
import com.walmart.cakedemo.cache.loader.ICacheLoader;
import com.walmart.cakedemo.configuration.ConfigUtils;
import com.walmart.cakedemo.configuration.ConfigurationUtils;
import com.walmart.cakedemo.configuration.FilePropertiesCache;
import com.walmart.cakedemo.configuration.CakeDemoPropertiesCache;
import com.walmart.cakedemo.configuration.Property;
import com.walmart.cakedemo.configuration.exception.InvalidConfigurationException;
import com.walmart.cakedemo.configuration.exception.InvalidFormatException;
import com.walmart.cakedemo.db.dao.IStartupDao;
import com.walmart.cakedemo.entity.CakeDemoProperty;

@Service("CacheLoader")
@Transactional(readOnly = true)
public class CacheLoader implements ICacheLoader {

    private static final Logger LOG = LoggerFactory.getLogger(CacheLoader.class);

    @Autowired
    IStartupDao                 startupDao;


    @Override
    @Reload(MIN_REPEAT_TIME_IN_MINUTE = 60, CACHE_GROUP = { "ALL" })
    public void loadProperties() {
        LOG.info("Loading Properties..");
        List<CakeDemoProperty> properties = startupDao.getProperties();
        CakeDemoPropertiesCache propertiesCache = new CakeDemoPropertiesCache();
        for (CakeDemoProperty property : properties) {
            propertiesCache.addProperty(property.getName(), property.getValue());
        }

        CacheManager.getInstance().setCache(propertiesCache);
        LOG.info("Loaded Properties SUCCESSFULLY!");
    }

    @Override
    @Reload(MIN_REPEAT_TIME_IN_MINUTE = 60, CACHE_GROUP = { "ALL" })
    public void loadCakeDemoPropertiesCache() throws InvalidFormatException, InvalidConfigurationException {
        String basePath = ConfigUtils.getStringScalar(Property.CONFIGURATION_DIR_PATH);
        String filePath = ConfigUtils.getStringScalar(Property.CONFIG_RELATIVE_PATH);
       // loadCakeDemoPropertiesCacheWithParams(basePath, filePath);
    }

    @Override
    @Reload(MIN_REPEAT_TIME_IN_MINUTE = 60, CACHE_GROUP = { "ALL" })
    public void loadCakeDemoPropertiesCacheWithParams(String confgPath, String fileName) throws InvalidFormatException, InvalidConfigurationException {
        LOG.info("Loading CakeDemo Properties Cache ..");
        FilePropertiesCache opc = null;
        Map<String, Object> properties = new HashMap<String, Object>();
        LOG.info("Reading CakeDemo Configuration File: " + confgPath + fileName);
        properties = ConfigurationUtils.getMaps(confgPath + fileName);

        opc = new FilePropertiesCache(properties);
        CacheManager.getInstance().setCache(opc);
        LOG.info("CakeDemo properties loaded SUCCESSFULLY!");
    }

}
