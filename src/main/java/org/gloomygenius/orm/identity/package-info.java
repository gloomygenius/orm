@GenericGenerator(
        name = "ID_GENERATOR",
        strategy = "enhanced-strategy",
        parameters = {
                @Parameter(name = "secuence_name", value = "JPWH_SEQUENCE"),
                @Parameter(name = "initial_value", value = "1000")
        })
package org.gloomygenius.orm.identity;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

