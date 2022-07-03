/*
package com.galdino.AssistenteFinanceiro.Security;


import com.galdino.AssistenteFinanceiro.Model.Entitys.UserBeans;
import com.galdino.AssistenteFinanceiro.Repository.UserRepository;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import java.util.ArrayList;
import java.util.List;


@Configuration
@EnableWebSecurity
public class WebSecurityConfig {

    private final UserRepository userRepository;

    public WebSecurityConfig(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Bean//Bean que é responsável pela liberação de acesso ou não a uma determinada view.
    protected SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/", "home").hasAuthority("ROLE_USER") //acesso irrestrito (Sem usuário e Senha) para as view "/" e "/home"
                .anyRequest().authenticated()	//define acesso autenticado para as demais views (Nesse caso "/hello")
                .and()
                .formLogin()
                .loginPage("/login").permitAll() //Configura o acesso a view de login e da acesso irrestrito a ela
                .and()
                .logout()
                .permitAll();
        return http.build();
    }

    @Bean
    public InMemoryUserDetailsManager userDetailsService() {
        List<UserBeans> userBeans = userRepository.findAll();
        UserBeans usuarioTemp;
        List<UserDetails>userDetailsList = new ArrayList<>();
        for (int i=0; i<userBeans.size(); i++) {
            usuarioTemp = userBeans.get(i);
            System.out.println(usuarioTemp.getEmail());
            userDetailsList.add(User.withDefaultPasswordEncoder()
                    .username(usuarioTemp.getEmail())
                    .password(usuarioTemp.getPassword())
                    .roles(usuarioTemp.getRole())
                    .build());
        }

        return new InMemoryUserDetailsManager(userDetailsList);
    }
    @Bean//Define paginas não autenticadas
    public WebSecurityCustomizer webSecurityCustomizer() {
        return (web) -> web.ignoring().antMatchers("/new");
    }


}

 */

