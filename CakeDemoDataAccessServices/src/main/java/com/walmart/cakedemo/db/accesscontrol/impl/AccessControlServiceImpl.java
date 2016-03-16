
package com.walmart.cakedemo.db.accesscontrol.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.webapputils.base.cache.CacheManager;
import com.webapputils.base.utils.StringUtils;
import com.walmart.cakedemo.cache.AccessControlCache;
import com.walmart.cakedemo.entity.AccessControl;
import com.walmart.cakedemo.db.accesscontrol.IAccessControlService;
import com.walmart.cakedemo.db.accesscontrol.IAccessControlDao;

@Service("accessControlService")
public class AccessControlServiceImpl implements IAccessControlService {

    @Autowired
    private IAccessControlDao accessControlDao;

    @Override
    @Transactional
    public List<String> getRoleCodesByPattern(String URI) {
        AccessControl accessControls = CacheManager.getInstance().getCache(AccessControlCache.class).getAccessControl(URI);
        if (accessControls == null) {
            accessControls = accessControlDao.getAccessControlByPattern(URI);
        }
        if(accessControls != null){
            return StringUtils.split(accessControls.getCsvRoleCodes(), ",");
        }
        return new ArrayList<String>();
    }
    
    @Override
    public List<AccessControl> getAllAccessControlsFromDB() {
        return accessControlDao.getAllAccessControls();
    }

}
