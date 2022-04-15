package org.cp3geek.onlinejudge_backend.entity;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Contest {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long contestId;
    private String contestName;//比赛名称
    private String contestType;//比赛类型
    private String contestDescription;//比赛描述
    private String contestAnnouncement;//比赛公告
    private String contestState;//比赛状态
    private Date contestStartTime;//比赛开始时间
    private Date contestEndTime;//比赛结束时间
    private String contestHost;//举办者

    


}
