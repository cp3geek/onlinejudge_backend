package org.cp3geek.onlinejudge_backend.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProblemInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long problemInfoId;
    private Long problemId;
    private int timeLimit;//时间限制
    private int memoryLimit;//内存限制
    private String level;//题目等级
    private String tags;//题目标签
    private int total;//提交总数
    private int accepted;//通过数
}
