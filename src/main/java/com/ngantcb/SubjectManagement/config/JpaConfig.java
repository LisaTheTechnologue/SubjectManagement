package com.ngantcb.SubjectManagement.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EnableJpaRepositories(basePackages = "com.ngantcb.SubjectManagement.repo")
public class JpaConfig {
}
