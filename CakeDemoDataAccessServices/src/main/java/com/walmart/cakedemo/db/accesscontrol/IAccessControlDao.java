
package com.walmart.cakedemo.db.accesscontrol;

import java.util.List;

import com.walmart.cakedemo.entity.AccessControl;

public interface IAccessControlDao {

    public List<AccessControl> getAllAccessControls();

    public AccessControl getAccessControlByPattern(String uRI);

}
