package com.tcramer.anubis.admin;

import de.codecentric.boot.admin.server.config.AdminServerProperties;
import de.codecentric.boot.admin.server.config.EnableAdminServer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.csrf.CookieCsrfTokenRepository;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration(proxyBeanMethods = false)
@EnableAdminServer
@SpringBootApplication
@ComponentScan({"com.anubis.core", "com.tcramer.anubis.admin"})
public class AnubisAdminApplication extends SpringBootServletInitializer {

    private final AdminServerProperties adminServer;

    public AnubisAdminApplication(AdminServerProperties adminServer) {
        this.adminServer = adminServer;
    }

    public static void main(String[] args) {
        SpringApplication.run(AnubisAdminApplication.class, args);
    }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application;
    }

    //    @Profile("insecure")
    @Configuration(proxyBeanMethods = false)
    public static class SecurityPermitAllConfig extends WebSecurityConfigurerAdapter {

        private final AdminServerProperties adminServer;

        public SecurityPermitAllConfig(AdminServerProperties adminServer) {
            this.adminServer = adminServer;
        }

        @Override
        protected void configure(HttpSecurity http) throws Exception {
            http.authorizeRequests((authorizeRequests) -> authorizeRequests.anyRequest().permitAll())
                    .csrf((csrf) -> csrf.csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse())
                            .ignoringRequestMatchers(
                                    new AntPathRequestMatcher(this.adminServer.path("/instances"),
                                            HttpMethod.POST.toString()),
                                    new AntPathRequestMatcher(this.adminServer.path("/instances/*"),
                                            HttpMethod.DELETE.toString()),
                                    new AntPathRequestMatcher(this.adminServer.path("/actuator/**"))));
        }

    }

//    @Profile("secure")
//    @Configuration(proxyBeanMethods = false)
//    public static class SecuritySecureConfig extends WebSecurityConfigurerAdapter {
//
//        private final AdminServerProperties adminServer;
//
//        public SecuritySecureConfig(AdminServerProperties adminServer) {
//            this.adminServer = adminServer;
//        }
//
//        @Override
//        protected void configure(HttpSecurity http) throws Exception {
//            SavedRequestAwareAuthenticationSuccessHandler successHandler = new SavedRequestAwareAuthenticationSuccessHandler();
//            successHandler.setTargetUrlParameter("redirectTo");
//            successHandler.setDefaultTargetUrl(this.adminServer.path("/"));
//
//            http.authorizeRequests((authorizeRequests) -> authorizeRequests
//                    .antMatchers(this.adminServer.path("/assets/**")).permitAll()
//                    .antMatchers(this.adminServer.path("/login")).permitAll().anyRequest().authenticated())
//
//                    .formLogin((formLogin) -> formLogin.loginPage(this.adminServer.path("/login"))
//                            .successHandler(successHandler))
//                    .logout((logout) -> logout.logoutUrl(this.adminServer.path("/logout")))
//                    .httpBasic(Customizer.withDefaults())
//                    .csrf((csrf) -> csrf.csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse())
//                            .ignoringRequestMatchers(
//                                    new AntPathRequestMatcher(this.adminServer.path("/instances"),
//                                            HttpMethod.POST.toString()),
//                                    new AntPathRequestMatcher(this.adminServer.path("/instances/*"),
//                                            HttpMethod.DELETE.toString()),
//                                    new AntPathRequestMatcher(this.adminServer.path("/actuator/**"))));
//        }
//
//    }
}
