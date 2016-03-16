
package com.walmart.cakedemo.db.accesscontrol;

import java.util.List;

import com.walmart.cakedemo.entity.AccessControl;

public interface IAccessControlService {

    public List<String> getRoleCodesByPattern(String URI);

    List<AccessControl> getAllAccessControlsFromDB();
}
