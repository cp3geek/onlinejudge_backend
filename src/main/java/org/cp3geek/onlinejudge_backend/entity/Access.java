package org.cp3geek.onlinejudge_backend.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@Entity
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Access {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long accessId;
    private String accessName;
    private String accessDescription;
    private Date createTime;
    private Date updateTime;

}
