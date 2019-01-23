package me.wonwoo.domain;

import lombok.Data;
import lombok.ToString;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "groups")
@Data
@ToString(exclude = {"users", "roles"})
public class Groups {

  @Id
  @GeneratedValue
  @Column(name = "GROUP_ID", unique = true, nullable = false)
  private Integer id;

  private String groupName;

  @OneToMany(fetch = FetchType.LAZY, mappedBy = "groups")
  private Set<GroupsUser> users = new HashSet<>();

  @OneToMany(fetch = FetchType.LAZY, mappedBy = "groups")
  private Set<GroupsRole> roles = new HashSet<>();

}
