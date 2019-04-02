/*
package com.microservice.vapro.gateway.config;


import org.springframework.boot.autoconfigure.security.oauth2.client.EnableOAuth2Sso;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableReactiveMethodSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.web.server.SecurityWebFilterChain;

*/
/**
 * @author ChengJianSheng
 * @date 2019-03-19
 *//*


@Configuration
@EnableWebFluxSecurity
@EnableReactiveMethodSecurity
public class WebSecurityConfig {

*/
/*
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.logout().logoutSuccessUrl("http://localhost:8080/logout");
        http.authorizeRequests().anyRequest().authenticated();
        http.csrf().disable();
    }

*//*


    @Bean
    public SecurityWebFilterChain springSecurityFilterChain(ServerHttpSecurity http) throws Exception {
        return http.csrf().disable()
                .logout().logoutUrl("http://localhost:9060/uaa/logout").and()
                .authorizeExchange()
                .anyExchange().authenticated()
                .and().build();
    }
}
*/
