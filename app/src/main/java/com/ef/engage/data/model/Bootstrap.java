
package com.ef.engage.data.model;

import java.util.HashMap;
import java.util.Map;

public class Bootstrap {

    private Settings settings;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * 
     * @return
     *     The settings
     */
    public Settings getSettings() {
        return settings;
    }

    /**
     * 
     * @param settings
     *     The settings
     */
    public void setSettings(Settings settings) {
        this.settings = settings;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
