package com.personalProject.Enterprise_employees_management_system.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;

import java.util.logging.Logger;

@Configuration
public class ProjectConfig extends WebSecurityConfigurerAdapter {

    private static final Logger LOGGER = Logger.getLogger("ProjectConfig");

    // Codificarea parolei se face cu o funcție de "hashing" numită "bcrypt" considerată încă sigură.
    @Bean
    public PasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public UserDetailsManager userDetailsManager() {
        final UserDetailsManager userDetailsManager = new InMemoryUserDetailsManager();

        final UserDetails user1 = User.withUsername("Laura")
                .password(bCryptPasswordEncoder().encode("laura"))
                .roles("ANALYST")
                .authorities("READ_AUTHORITY")
                .build();

        final UserDetails user2 = User.withUsername("Maia")
                .password(bCryptPasswordEncoder().encode("maia"))
                .roles("ADMIN")
                .authorities("READ_AUTHORITY", "WRITE_AUTHORITY", "UPDATE_AUTHORITY")
                .build();

        final UserDetails user3 = User.withUsername("Dana")
                .password(bCryptPasswordEncoder().encode("dana"))
                .roles("ADMIN")
                .authorities("READ_AUTHORITY", "WRITE_AUTHORITY", "UPDATE_AUTHORITY", "DELETE_AUTHORITY")
                .build();

        userDetailsManager.createUser(user1);
        userDetailsManager.createUser(user2);
        userDetailsManager.createUser(user3);

        LOGGER.info(user1 + "Laura" + user1.getPassword());
        LOGGER.info(user2 + "Dana" + user2.getPassword());
        LOGGER.info(user3 + "Dana" + user3.getPassword());

        return userDetailsManager;


    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsManager())
                .passwordEncoder(bCryptPasswordEncoder());
    }
//daca users sunt autentificati primesc acces la resurse si primesc mesajul Welcome + numele userului
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.httpBasic();
        http.authorizeRequests().antMatchers("/api/welcome").authenticated()
                .anyRequest().denyAll();
    }
}
/*
1. AuthenticationFilter - acesta interceptează cererea HTTP de autentificare trimisă de către aplicația client.
Atunci când un request ajunge în sistemul nostru, Spring Security alege cel mai potrivit filtru capabil să proceseze cererea de autentificare.

2. AuthenticationManager - componenta căreia îi este adresată responsabilitatea autentificării și care folosește mai departe
componenta de AuthenticationProvider. AuthenticationManager este doar o interfață. Actuala implementare a metodei authenticate()
este oferită de ProviderManager.

3. AuthenticationProvider - componenta care implementează efectiv logica de autentificare.
Ea reprezintă locul în care se află condițiile și instrucțiunile prin care se decide dacă o cerere HTTP trebuie autentificată cu succes sau nu.
Implementările de AuthenticationProvider folosesc mai multe contracte, cele mai importante fiind acestea două: UserDetailsService și PasswordEncoder.

4. UserDetailsService -  Această interfața este contractul pe care Spring Security îl oferă pentru a descrie modul în care aplicația obține
detaliile utilizatorilor care încearcă să se autentifice. Interfața UserDetails  este contractul folosit în Spring Security pentru a descrie un utilizator,
iar UserDetailsService este obiectul folosit pentru a prelua detaliile unui utilizator după numele de utilizator al acestuia.

În ierarhia de interfețe exista și UserDetailsManager (interfață care extinde UserDetailsService) și adaugă comportamente legate de crearea,
modificarea sau ștergerea utilizatorilor
Există mai multe implementări pentru acest contract, cele mai cunoscute fiind InMemoryUserDetailsManager sau JdbcUserDetailsManager.

5. SecurityContext - După ce autentificarea se finalizează cu succes datele entității autentificate (cunoscută ca Principal) sunt
salvate în obiectul SecurityContext.

Interfata PasswordEncoder este foarte important/ă în procesul de autentificare pentru că reprezintă modalitatea prin care îi spunem
framework-ului de Spring Security cum să valideze parola unui utilizator care încearcă să se autentifice în sistem.
* */