package me.wonwoo.domain;

import lombok.Data;
import lombok.ToString;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "users", uniqueConstraints = @UniqueConstraint(columnNames = "USERNAME"))
@Data
@ToString(exclude = {"userRoles", "groupUsers"})
public class User {

  @Id
  @GeneratedValue
  @Column(name = "USER_ID", unique = true, nullable = false)
  private Integer id;

  @Column(name = "USERNAME", unique = true, length = 50)
  private String username;

  @Column(name = "PASSWORD", length = 200)
  private String password;

  @OneToMany(fetch = FetchType.LAZY, mappedBy = "user")
  private List<Authorities> userRoles = new ArrayList<>();

  @OneToMany(fetch = FetchType.LAZY, mappedBy = "user")
  private List<GroupsUser> groupUsers = new ArrayList<>();
}
