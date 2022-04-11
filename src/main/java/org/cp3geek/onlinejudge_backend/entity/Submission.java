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
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Submission {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long submitId;
    private Long userId;
    private Long problemId;
    private String status;
    private int statusType;//1.AC 2.PE 3.WA 4.TLE 5.MLE 6.OLE 7.RE 8.CE 9.UE 10.Queuing&Judging 11.Pending
    private String additionalInfo;//备注信息 存放编译错误等信息
    private String realRunId;//源OJ运行ID
    private int runTime;//运行时间
    private int runMemory;//内存消耗
    private Date submitTime;//
    private String language;
    private String code;

}
