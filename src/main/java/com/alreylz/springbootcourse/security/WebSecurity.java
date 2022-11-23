package com.alreylz.springbootcourse.security;


//import org.springframework.context.annotation.Bean;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.security.crypto.password.NoOpPasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;


/**
 * Por defecto, spring boot una vez incorporamos Spring Security como dependencia, protege todos nuestros endpoints con usuario y contraseña.
 * Para configurar los usuarios, contraseñas y urls protegidas, es necesario crear una clase como la que aquí se muestra:
 * - Anotamos la clase con @EnableWebSecurity
 * - Derivamos de WebsecurityConfigurerAdapter
 * - Hacemos override de los métodos
 * -------> configure(AuthenticationManagerBuilder) : en este especificaremos las credenciales que existirán y los roles de los distintos tipos de clientes.
 * -------> getPasswordEncoder : necesitamos la anotación @Bean  e indica cómo se tratará la contraseña por parte de Spring; normalmente esta se hasheará, pero podemos evitarlo para pruebas rápidas...
 * -------> configure(HttpSecurity) : permite indicar qué urls están protegidas y cómo, y cuáles no
 */


//@EnableWebSecurity
//public class WebSecurity extends WebSecurityConfigurerAdapter {
//
//    @Override
//    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        auth.inMemoryAuthentication().withUser("admin").password("123").roles("ADMIN");
////        auth.inMemoryAuthentication().withUser("user1").password("123").roles("CLIENT").and().withUser("admin").password("123").roles("ADMIN");
//    }
//
//
//    @Bean
//    public PasswordEncoder getPasswordEncoder() {
//        return NoOpPasswordEncoder.getInstance();
//    }
//
//
//    /***
//     * Indica las urls que se ven afectadas por la seguridad y cómo
//     * @param http
//     * @throws Exception
//     */
//    @Override
//    public void configure(HttpSecurity http) throws Exception {
//        http.authorizeRequests()
//                .antMatchers("/helloOnlyAdmin").hasRole("ADMIN")
//                .and().formLogin();
//    }
//
//
//}
