package com.microservice.valpro.oauth.config;


import com.microservice.valpro.oauth.service.impl.UserDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.ClassPathResource;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.oauth2.common.DefaultOAuth2AccessToken;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.token.DefaultTokenServices;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;
import org.springframework.security.oauth2.provider.token.store.KeyStoreKeyFactory;


import java.security.KeyPair;
import java.util.HashMap;
import java.util.Map;

/**
 * @description:
 * @author: Mr.Lee
 * @create: 2019-03-17 04:16
 **/
@Configuration
@EnableAuthorizationServer
public class AuthenticationManagerConfig extends AuthorizationServerConfigurerAdapter {

    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private UserDetailsServiceImpl userDetailsService;
    @Bean
    public JwtTokenStore jwtTokenStore() {
        return new JwtTokenStore(accessTokenConverter());
    }

    public AuthenticationManagerConfig(AuthenticationManager authenticationManager) {
        this.authenticationManager = authenticationManager;
    }
    /*用于自定义TokenService*/
    @Primary
    @Bean
    public DefaultTokenServices tokenServices() {
        DefaultTokenServices defaultTokenServices = new DefaultTokenServices();
        defaultTokenServices.setTokenStore(jwtTokenStore());
        defaultTokenServices.setSupportRefreshToken(true);
        //设置jwtAccessTokenConverter,因为jwtAccessTokenConverter实现了TokenEnhancer接口
        defaultTokenServices.setTokenEnhancer(accessTokenConverter());
//        defaultTokenServices.setClientDetailsService(clientDetailsService());
        return defaultTokenServices;
    }

    @Override
    public void configure(final AuthorizationServerSecurityConfigurer oauthServer) throws Exception {
        oauthServer.tokenKeyAccess("permitAll()")
                .checkTokenAccess("isAuthenticated()")/*.allowFormAuthenticationForClients()*/;

    }

    @Override
    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
        clients.inMemory() // 使用in-memory存储
                .withClient("client") // client_id
                //secret:secret
                .secret("$2a$10$HEAIdxtzHvCBkIfRDF1XDe2uEdjmxkf5gHfcZFuRUCZEKeW0n6RlG") // client_secret
                .autoApprove(true)
                .authorizedGrantTypes("authorization_code","refresh_token") // 该client允许的授权类型
                .redirectUris("http://localhost:9030/login/oauth2/code/client")//set redirect as gateway set
                .scopes("all"); // 允许的授权范围
    }

    @Override
    public void configure(final AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
        // @formatter:off
        endpoints.tokenStore(jwtTokenStore()).userDetailsService(userDetailsService).authenticationManager(authenticationManager);
        endpoints.tokenServices(tokenServices());

        // @formatter:on
    }
    @Bean
    public JwtAccessTokenConverter accessTokenConverter() {
        JwtAccessTokenConverter converter = new JwtAccessTokenConverter() {
            @Override
            public OAuth2AccessToken enhance(OAuth2AccessToken accessToken, OAuth2Authentication authentication) {
                String userName = authentication.getUserAuthentication().getName();
                final Map<String, Object> additionalInformation = new HashMap<>();
                additionalInformation.put("user_name", userName);
                ((DefaultOAuth2AccessToken) accessToken).setAdditionalInformation(additionalInformation);
                OAuth2AccessToken token = super.enhance(accessToken, authentication);
                return token;
            }
        };
        KeyPair keyPair = new KeyStoreKeyFactory(new ClassPathResource("kevin_key.jks"), "123456".toCharArray())
                .getKeyPair("kevin_key");
        converter.setKeyPair(keyPair);
        return converter;
    }
}
