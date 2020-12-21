package edu.epam.shape.warehouse;

import edu.epam.shape.entity.QuadrangleParameters;

import java.util.HashMap;
import java.util.Map;

public class QuadrangleWarehouse {
    private static final QuadrangleWarehouse instance = new QuadrangleWarehouse();
    private Map<Long, QuadrangleParameters> properties = new HashMap<>();

    private QuadrangleWarehouse() {}

    public static QuadrangleWarehouse getInstance() {
        return instance;
    }

    public void put(Long id, QuadrangleParameters tp) {
        properties.put(id,tp);
    }

    public QuadrangleParameters get(Long id) {
        return properties.get(id);
    }
}
