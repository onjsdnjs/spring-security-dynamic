package me.wonwoo;

import me.wonwoo.security.filter.FilterMetadataSource;
import me.wonwoo.security.service.CacheManager;
import me.wonwoo.security.service.ResourceMetaService;
import me.wonwoo.security.service.ResourceMetaServiceImpl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
public class SpringSecurityDynamicApplication {

  public static void main(String[] args) {

    SpringApplication.run(SpringSecurityDynamicApplication.class, args);
  }

  @Bean
  public PasswordEncoder passwordEncoder(){
    return new BCryptPasswordEncoder();
  }

  @Bean
  public ResourceMetaService resourceMetaService(){
    return new ResourceMetaServiceImpl();
  }

  @Bean
  public FilterMetadataSource filterMetadataSource(){
    return new FilterMetadataSource();
  }

  @Bean
  public CacheManager cacheManager(){
    return new CacheManager();
  }


//  FilterInvocationSecurityMetadataSource filterInvocationSecurityMetadataSource(){
//    List<String> roles = userRoleDto.stream().map(AuthoritiesDto::getRoleName).collect(Collectors.toList());
//
//    String[] stockArr = new String[roles.size()];
//    stockArr = roles.toArray(stockArr);
//
//
//    return new DefaultFilterInvocationSecurityMetadataSource(SecurityConfig.createList(stockArr));
//  }
}
