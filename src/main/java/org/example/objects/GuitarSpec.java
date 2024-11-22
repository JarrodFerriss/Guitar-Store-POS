package org.example.objects;

import java.util.HashMap;
import java.util.Map;

public class GuitarSpec {
    private Map<String, Object> properties;

    // Constructor
    public GuitarSpec(Map<String, Object> properties) {
        this.properties = new HashMap<>(properties);
    }

    // Get a property by name
    public Object getProperty(String key) {
        return properties.get(key);
    }

    // Get all properties
    public Map<String, Object> getProperties() {
        return properties;
    }

    // Match specifications
    public boolean matches(GuitarSpec otherSpec) {
        for (String key : otherSpec.getProperties().keySet()) {
            if (!properties.containsKey(key) || !properties.get(key).equals(otherSpec.getProperty(key))) {
                return false;
            }
        }
        return true;
    }
}
