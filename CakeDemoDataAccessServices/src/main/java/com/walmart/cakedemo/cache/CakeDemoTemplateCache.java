
package com.walmart.cakedemo.cache;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.walmart.cakedemo.entity.CakeDemoTemplate;
import com.webapputils.base.annotations.Cache;
import com.webapputils.base.velocity.Template;

@Cache(name = "cakedemoTemplateCache")
public class CakeDemoTemplateCache {
    private final Map<String, Template> cakedemoTemplates    = new HashMap<String, Template>();
    private final List<Template>        cakedemoTemplateList = new ArrayList<Template>();

    public void addCakeDemoTemplate(CakeDemoTemplate cakedemoTemplate) {
        Template template = Template.compile(cakedemoTemplate.getTemplate());
        cakedemoTemplates.put(cakedemoTemplate.getName(), template);
        cakedemoTemplateList.add(template);
    }

    public Template getCakeDemoTemplateByName(String templateName) {
        return cakedemoTemplates.get(templateName);
    }

    public List<Template> getCakeDemoTemplateList() {
        return cakedemoTemplateList;
    }

    public Map<String, Template> getCakeDemoTemplates() {
        return cakedemoTemplates;
    }
}
