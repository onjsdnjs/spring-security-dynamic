package me.wonwoo.domain;

import lombok.Data;
import lombok.ToString;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Table(name = "resources")
@Data
@ToString(exclude = {"roleResources"})
public class Resources {

  @Id
  @GeneratedValue
  @Column(name = "RESOURCE_ID", unique = true, nullable = false)
  private Integer id;

  private String name;

  @OneToMany(fetch = FetchType.LAZY, mappedBy = "resources")
  private Set<RoleResource> roleResources = new HashSet<>();

}
