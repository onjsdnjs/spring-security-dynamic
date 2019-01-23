
package me.wonwoo.domain;

import lombok.Data;
import lombok.ToString;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Table(name = "role")
@Data
@ToString(exclude = {"authorities", "roleResources", "groups"})
public class Role {

  @Id
  @GeneratedValue
  @Column(name = "ROLE_ID", unique = true, nullable = false)
  private Integer id;

  private String roleName;

  private String roleDesc;

  @OneToMany(fetch = FetchType.LAZY, mappedBy = "role")
  private Set<Authorities> authorities = new HashSet<>();

  @OneToMany(fetch = FetchType.LAZY, mappedBy = "role")
  private Set<RoleResource> roleResources = new HashSet<>();

  @OneToMany(fetch = FetchType.LAZY, mappedBy = "role")
  private Set<GroupsRole> groups = new HashSet<>();


}
