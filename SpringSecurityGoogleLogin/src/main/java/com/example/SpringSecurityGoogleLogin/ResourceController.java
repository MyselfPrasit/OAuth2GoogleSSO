package com.example.SpringSecurityGoogleLogin;

import org.springframework.boot.autoconfigure.neo4j.Neo4jProperties;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.security.oauth2.core.OAuth2AccessToken;
import org.springframework.security.oauth2.core.OAuth2AuthenticatedPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;
import java.util.Date;
import java.util.Map;

@RestController
public class ResourceController {

    @GetMapping("/welcome")
    public String welcome(Principal principal){
        Map<String,Object> details = ((OAuth2AuthenticationToken)principal).getPrincipal().getAttributes();
        return "Hello "+details.get("name")+", Happy New Year 2023!!!";
    }
}
