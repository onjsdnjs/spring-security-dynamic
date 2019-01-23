package me.wonwoo.security.service;

import me.wonwoo.domain.User;
import me.wonwoo.domain.dto.AuthoritiesDto;
import me.wonwoo.repository.UserRepository;
import me.wonwoo.security.CacheEventMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;
import java.util.List;
import java.util.Map;

import static java.util.stream.Collectors.*;

public class CacheManager implements ApplicationListener<CacheEventMessage> {

  @Autowired
  private UserRepository userRepository;

  @Autowired
  private PasswordEncoder passwordEncoder;

  private Map<String, List<AuthoritiesDto>> authorities;

  public Map<String, List<AuthoritiesDto>> getAuthorities() {
    return authorities;
  }

  public List<AuthoritiesDto> getAuthoritie(String key) {
    return authorities.get(key);
  }

  @Override
  public void onApplicationEvent(CacheEventMessage event) {
    authorities = event.getAuthoritiesDto()
      .stream().collect(groupingBy(AuthoritiesDto::getUrl, toList()));

    createUserIfNotFound();

    // grouping
    // url => roles

//    String url;
//    for (UserRoleDto userRoleDto : event.getUserRoleDto()) {
//      url = userRoleDto.getUrl();
//      if (this.urlRoles.containsKey(url)) {
//        List<String> roles = this.urlRoles.get(url);
//        roles.add(userRoleDto.getRoleName());
//
//      } else {
//        List<String> roles = new ArrayList<>();
//        roles.add(userRoleDto.getRoleName());
//        this.urlRoles.put(url, roles);
//      }
//    }
  }

  @Transactional
  public User createUserIfNotFound() {
    User user = userRepository.findByusername("onjsdnjs");
    if (user == null) {
      user = User.builder()
              .username("onjsdnjs")
              .password(passwordEncoder.encode("onjsdnjs"))
              .build();
    }
    user = userRepository.save(user);
    return user;
  }
}
