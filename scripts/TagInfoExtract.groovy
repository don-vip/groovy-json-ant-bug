// License: GPL. For details, see LICENSE file.
import java.time.Instant
import java.time.ZoneId
import java.time.format.DateTimeFormatter

import groovy.json.JsonBuilder

class TagInfoExtract {

    static main(def args) {
        write_json("JOSM main presets", "Tags supported by the default presets in the OSM editor JOSM")
    }

    static void write_json(name, description) {
        def json = new JsonBuilder()
        def project = [
                name: name,
                description: description,
                project_url: "https://josm.openstreetmap.de/",
                icon_url: "https://josm.openstreetmap.de/export/7770/josm/trunk/images/logo_16x16x8.png",
                contact_name: "JOSM developer team",
                contact_email: "josm-dev@openstreetmap.org",
        ]
        json data_format: 1, data_updated: DateTimeFormatter.ofPattern("yyyyMMdd'T'hhmmss'Z'").withZone(ZoneId.of("Z")).format(Instant.now()), project: project
        print json.toPrettyString()
    }
}
