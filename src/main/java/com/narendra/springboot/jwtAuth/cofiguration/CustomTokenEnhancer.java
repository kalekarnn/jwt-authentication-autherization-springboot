package com.narendra.springboot.jwtAuth.cofiguration;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.oauth2.common.DefaultOAuth2AccessToken;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class CustomTokenEnhancer extends JwtAccessTokenConverter {
    @Override
    public OAuth2AccessToken enhance(OAuth2AccessToken oAuth2AccessToken, OAuth2Authentication oAuth2Authentication) {
        Map<String, Object> additionalInfo = new HashMap<>();
        User user = (User) oAuth2Authentication.getPrincipal();

        additionalInfo.put("org", "narendra");
        additionalInfo.put("username", user.getUsername());

        ((DefaultOAuth2AccessToken) oAuth2AccessToken).setAdditionalInformation(additionalInfo);

        oAuth2AccessToken = super.enhance(oAuth2AccessToken, oAuth2Authentication);
        ((DefaultOAuth2AccessToken) oAuth2AccessToken).setAdditionalInformation(Collections.emptyMap());

        return oAuth2AccessToken;
    }
}
