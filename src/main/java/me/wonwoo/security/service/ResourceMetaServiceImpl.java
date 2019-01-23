package me.wonwoo.security.service;

import lombok.extern.slf4j.Slf4j;
import me.wonwoo.domain.Resources;
import me.wonwoo.domain.RoleResource;
import me.wonwoo.domain.dto.AuthoritiesDto;
import me.wonwoo.repository.ResourceRepository;
import me.wonwoo.repository.RoleResourceRepository;
import me.wonwoo.security.CacheEventMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by wonwoo on 2016. 4. 9..
 */
@Slf4j
public class ResourceMetaServiceImpl implements ResourceMetaService {

  @Autowired
  private ResourceRepository resourceRepository;

  @Autowired
  private RoleResourceRepository roleResourceRepository;

  @Autowired
  private ApplicationContext applicationContext;

  @Override
  public void findAllResources() {
//    List<AuthoritiesDto> authorities2 = resourceRepository.findAllAuthorities();
    List<RoleResource> roleResources = roleResourceRepository.findAll();
    List<AuthoritiesDto> authorities = new ArrayList<>();
    roleResources.stream().forEach(roleResource -> {
      authorities.add(AuthoritiesDto.builder()
              .roleName(roleResource.getRole().getRoleName())
              .url(roleResource.getResources().getName()).build());
    });

    authorities.stream().forEach(userRoleDto -> {
      log.info("role name {} ", userRoleDto.getRoleName());
      log.info("url {}", userRoleDto.getUrl());
    });
    applicationContext.publishEvent(new CacheEventMessage(this, authorities));
  }
}
