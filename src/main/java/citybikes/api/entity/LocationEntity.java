package citybikes.api.entity;

import io.cucumber.java.DataTableType;

import java.util.Map;

public class LocationEntity {

        @DataTableType
        public Location locationEntry(Map<String, String> entry) {
            return new Location(
                    entry.get("city"),
                    entry.get("country"));
        }
}
