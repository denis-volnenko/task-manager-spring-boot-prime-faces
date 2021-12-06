package school.volnenko.tm.config;

import org.apache.cxf.Bus;
import org.apache.cxf.jaxws.EndpointImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import school.volnenko.tm.endpoint.ProjectEndpoint;
import school.volnenko.tm.endpoint.TaskEndpoint;

import javax.xml.ws.Endpoint;

@Configuration
public class WebApplicationConfiguration {

    @Bean
    public Endpoint projectEndpointRegistry(final ProjectEndpoint projectEndpoint, Bus bus) {
        final EndpointImpl endpoint = new EndpointImpl(bus, projectEndpoint);
        endpoint.publish("/ProjectEndpoint");
        return endpoint;
    }

    @Bean
    public Endpoint taskEndpointRegistry(final TaskEndpoint taskEndpoint, Bus bus) {
        final EndpointImpl endpoint = new EndpointImpl(bus, taskEndpoint);
        endpoint.publish("/TaskEndpoint");
        return endpoint;
    }

}
