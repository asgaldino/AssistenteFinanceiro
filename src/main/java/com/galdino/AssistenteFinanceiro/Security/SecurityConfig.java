/*
package com.galdino.AssistenteFinanceiro.Security;

import com.galdino.AssistenteFinanceiro.Model.Entitys.UserBeans;
import com.galdino.AssistenteFinanceiro.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
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
public class SecurityConfig{

    @Autowired
    private UserRepository userRepository;

    @Bean//Bean que é responsável pela liberação de acesso ou não a uma determinada view.
    protected SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/", "home").hasAuthority("ROLE_user") //acesso irrestrito (Sem usuário e Senha) para as view "/" e "/home"
                .antMatchers("/new").permitAll()
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
        List<UserBeans> user = userRepository.findAll();
        UserBeans userTemp;
        List<UserDetails>userDetailsList = new ArrayList<>();
        for (UserBeans userBeans : user) {
            userTemp = userBeans;
            System.out.println(userTemp.getEmail());
            System.out.println(userTemp.getPassword());
            userDetailsList.add(User.withDefaultPasswordEncoder()
                    .username(userTemp.getEmail().toString())
                    .password(userTemp.getPassword().toString())
                    .roles(userTemp.getRole().toString())
                    .build());
        }

        return new InMemoryUserDetailsManager(userDetailsList);
    }
    @Bean
    public WebSecurityCustomizer ignoringCustomizer() {
        return (web) -> web.ignoring().antMatchers("/new");
    }
}
*/