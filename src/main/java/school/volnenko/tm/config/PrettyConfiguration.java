package school.volnenko.tm.config;

import com.ocpsoft.pretty.PrettyFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.servlet.DispatcherType;

@Configuration
public class PrettyConfiguration {

    @Bean
    public FilterRegistrationBean prettyFilter() {
        final FilterRegistrationBean prettyFilter = new FilterRegistrationBean(new PrettyFilter());
        prettyFilter.setDispatcherTypes(DispatcherType.FORWARD, DispatcherType.REQUEST,
                DispatcherType.ASYNC, DispatcherType.ERROR);
        prettyFilter.addUrlPatterns("/*");
        return prettyFilter;
    }

}
