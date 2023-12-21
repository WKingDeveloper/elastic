package com.wkingdeveloper.elastic.configuration

import org.springframework.context.annotation.Configuration
import org.springframework.data.elasticsearch.client.ClientConfiguration
import org.springframework.data.elasticsearch.client.elc.ElasticsearchConfiguration


@Configuration
class RestClientConfig : ElasticsearchConfiguration() {

    override fun clientConfiguration(): ClientConfiguration {
        val username = "elastic"
        val password = "p8i47na9xuChr65Mmm4JTUj0"
        return ClientConfiguration.builder()
            .connectedTo("f0b9315ae8e84417b610265ea4e43bbf.us-central1.gcp.cloud.es.io:443")
            .usingSsl()
            .withBasicAuth(username, password)
            .build()
    }
}
