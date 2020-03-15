package com.teachermanage.demo.Bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Salary {
    private Integer Salary_id;
    private Integer tid;
    private Date date;
    private Double base_money;
    private Double bonus;
}
