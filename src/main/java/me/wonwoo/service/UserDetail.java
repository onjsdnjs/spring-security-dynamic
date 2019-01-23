package me.wonwoo.service;

import me.wonwoo.domain.User;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.List;
import java.util.stream.Collectors;

public class UserDetail extends org.springframework.security.core.userdetails.User {
  private User user;
  private List<String> roles;

  public UserDetail(User user, List<String> roles) {
    super(user.getUsername(), user.getPassword(), roles.stream().map(SimpleGrantedAuthority::new).collect(Collectors.toList()));
    this.user = user;
    this.roles = roles;
  }
}
