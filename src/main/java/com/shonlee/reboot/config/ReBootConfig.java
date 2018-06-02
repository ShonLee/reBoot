package com.shonlee.reboot.config;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @auther shonlee
 * @create 2018/5/11
 */
@Configuration
@EntityScan("reboot.entity")
//@EnableJpaRepositories("reboot.repository")
//@ComponentScan("reboot")
public class ReBootConfig {

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new PasswordEncoder();
    }
}
