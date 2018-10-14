package za.co.absa.lab.springsecurity.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.ResourceServerTokenServices;


@Configuration
@EnableResourceServer // CUSTOM RESOURCE SERVER
public class ResourceServerConfig  extends ResourceServerConfigurerAdapter {

    @Autowired
    private ResourceServerTokenServices tokenServices;

    @Value("${security.jwt.resource-ids}")
    private String resourceIds;

    @Override
    public void configure(ResourceServerSecurityConfigurer resources) throws Exception {
        resources.resourceId(resourceIds).tokenServices(tokenServices);
    }

    @Override // Create SECURITY FILTER Authenticates via  OATH2 TOKEN
    public void configure(HttpSecurity http) throws Exception {
        http
            .requestMatchers()
            .and()
            .authorizeRequests()
            .antMatchers("/actuator/**", "/api-docs/**").permitAll()  //maps to filter-order in properties file
            .antMatchers("/springjwt/**" ).authenticated();
    }
}
