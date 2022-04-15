package org.cp3geek.onlinejudge_backend.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RoleAccess {
    //角色权限连接表
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long roleAccessId;
    private Long roleId;
    private Long accessId;
}
