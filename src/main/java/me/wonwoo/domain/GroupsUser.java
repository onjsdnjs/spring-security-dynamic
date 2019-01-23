package me.wonwoo.domain;

import lombok.Data;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Table(name = "groups_user")
@Data
@ToString(exclude = {"groups", "user"})
public class GroupsUser {

  @Id
  @GeneratedValue
  @Column(name = "ID", unique = true, nullable = false)
  private Integer id;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "GROUP_ID")
  private Groups groups;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "USER_ID")
  private User user;

}
