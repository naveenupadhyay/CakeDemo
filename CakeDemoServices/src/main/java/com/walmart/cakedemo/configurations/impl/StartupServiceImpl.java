
package com.walmart.cakedemo.configurations.impl;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.webapputils.base.cache.CacheManager;
import com.walmart.cakedemo.configurations.IStartupService;
import com.walmart.cakedemo.cache.loader.ICacheLoader;
import com.walmart.cakedemo.configurations.ICacheLoadService;

@Service("startupService")
public class StartupServiceImpl implements IStartupService {

    private static final Logger       LOG = LoggerFactory.getLogger(StartupServiceImpl.class);

    @Autowired
    ICacheLoadService           cacheLoadService;
    
    @Autowired
    ICacheLoader                cacheLoader;
    
    private boolean             startup = true;
    
    @Override
    public void loadProperties(boolean forcedReload) throws Exception {
        LOG.info("Load all Properties...");
        List<String> methodNameList = new ArrayList<String>();
        methodNameList.add("loadProperties");
        methodNameList.add("loadCakeDemoPropertiesCache");
        cacheLoadService.loadCacheByMethodName(cacheLoader, methodNameList, null, startup || forcedReload,"host");
        LOG.info("Loaded all Properties SUCCESSFULLY!");
    }

    @Override
    public void loadAll(boolean forcedReload) throws Exception {
    	LOG.info("Loading Properties...");
    	loadProperties(true);
        LOG.info("Loaded Properties SUCCESSFULLY!");
    }

   
}
