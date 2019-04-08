/*
package com.microservice.vapro.gateway.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.oauth2.client.registration.ClientRegistration;
import org.springframework.security.oauth2.client.registration.ClientRegistrationRepository;
import org.springframework.security.oauth2.client.registration.InMemoryClientRegistrationRepository;
import org.springframework.security.oauth2.core.AuthorizationGrantType;
import org.springframework.security.oauth2.core.ClientAuthenticationMethod;

*/
/**
 * @description:
 * @author: Mr.Lee
 * @create: 2019-04-05 16:37
 **//*

@Configuration
public class OAuth2LoginConfig {
    @Bean
    public ClientRegistrationRepository clientRegistrationRepository() {
        return new InMemoryClientRegistrationRepository(clientRegistration());
    }

    @Value("${spring.security.oauth2.client.registration.client.client-id}")
    private String clientId;

    @Value("${spring.security.oauth2.client.registration.client.client-secret}")
    private String clientSecret;

    private ClientRegistration clientRegistration() {
//        RegistrationId，名字随便取
        return ClientRegistration.withRegistrationId("client")
                .clientId(clientId)
                .clientSecret(clientSecret)
                .clientAuthenticationMethod(ClientAuthenticationMethod.POST)
                .redirectUriTemplate("{baseUrl}/login/oauth2/code/{registrationId}")
//                .clientName("AAA")       ??可忽略
//                .providerConfigurationMetadata("provider","")
                .tokenUri("http://localhost:9060/uaa/oauth/token")
                .authorizationUri("http://localhost:9060/uaa/oauth/authorize")
                .authorizationGrantType(AuthorizationGrantType.AUTHORIZATION_CODE)
                .userNameAttributeName("sub")
                .userInfoUri("http://localhost:9060/uaa/user")
                .jwkSetUri("http://localhost:9060/uaa/oauth/token_key")
                .build();
    }
}
*/
