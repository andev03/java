package com.an.ldapAuth.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.ldap.core.LdapTemplate;
import org.springframework.ldap.core.support.BaseLdapPathContextSource;
import org.springframework.ldap.core.support.LdapContextSource;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.ldap.LdapBindAuthenticationManagerFactory;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableMethodSecurity
public class SecurityConfig {
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.
                authorizeHttpRequests((authorize) -> authorize
                        .anyRequest().fullyAuthenticated()
                ).formLogin(Customizer.withDefaults());
        return http.build();
    }

//    @Bean
//    public LdapContextSource contextSource() {
//        LdapContextSource contextSource = new LdapContextSource();
//        contextSource.setUrl("ldap://localhost:10389");
//        contextSource.setBase("dc=example,dc=com"); // Thay đổi phù hợp với cấu trúc LDAP của bạn
//        contextSource.setUserDn("cn=admin,dc=example,dc=com");
//        contextSource.setPassword("admin_password");
//        return contextSource;
//    }
//
//    @Bean
//    public LdapTemplate ldapTemplate() {
//        return new LdapTemplate(contextSource());
//    }
    @Bean
    AuthenticationManager authenticationManager(BaseLdapPathContextSource source) {
        LdapBindAuthenticationManagerFactory factory = new LdapBindAuthenticationManagerFactory(source);
        factory.setUserDnPatterns("cn={0}");
        return factory.createAuthenticationManager();
    }
}
