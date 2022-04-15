package org.cp3geek.onlinejudge_backend.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.cp3geek.onlinejudge_backend.util.JpaConverterListJson;

import javax.persistence.*;
import java.util.List;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class ConSignUpProblem {
    //比赛报名人数和比赛题集表
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long conSignUpProblemId;
    private Long contestId;
    @Convert(converter = JpaConverterListJson.class)
    private List<Integer> participants;//参与者
    @Convert(converter = JpaConverterListJson.class)
    private List<Integer>contestProblem;
}
