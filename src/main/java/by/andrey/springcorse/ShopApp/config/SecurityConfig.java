package by.andrey.springcorse.ShopApp.config;

import by.andrey.springcorse.ShopApp.services.PersonDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private final PersonDetailsService personDetailsService;

    @Autowired
    public SecurityConfig(PersonDetailsService personDetailsService) {
        this.personDetailsService = personDetailsService;
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        //конфигурируем сам спринг секурити
        // конфигурируем авторизацию
        http.
                 csrf().disable()
         //      csrf().csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse()).and()
                .authorizeRequests()
                .antMatchers("/admin").hasAnyRole("ADMIN", "OWNER")
                .antMatchers("/auth/login", "/error", "/auth/registration", "/auth/checkAll").permitAll()  // разрешенный страницы для всех
                .anyRequest().hasAnyRole("USER", "ADMIN")           //все остальные страницы доступны авторизированным
                .and()
                .formLogin().loginPage("/auth/registration") // стартует с этой страницы
                .loginProcessingUrl("/process_login")               //сюда отправляются данные при входе (входящие поля должны быть обязательно username / password)
                .defaultSuccessUrl("/auth/registration",  true)  // перекидывает сюда после удачного входа
                .failureUrl("/auth/login?error")
                .and()
                .logout()
                .logoutUrl("/logout")
                .logoutSuccessUrl("/auth/login");       //куда выкидывает после логаута
    }

    // НАСТРАИВАЕМ аутентификацию
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(personDetailsService)
                .passwordEncoder(getPasswordEncoder());
    }

    @Bean
    public PasswordEncoder getPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }

}
