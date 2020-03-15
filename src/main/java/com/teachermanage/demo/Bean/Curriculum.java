package com.teachermanage.demo.Bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Curriculum {
    private Integer cid;
    private String cname;
    private Integer week;
    private Integer jieci;
    private String classname;
    private String address;
    private Integer tid;
    private String allweek;
}
