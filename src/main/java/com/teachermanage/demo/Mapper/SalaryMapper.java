package com.teachermanage.demo.Mapper;

import com.teachermanage.demo.Bean.Salary;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface SalaryMapper {
//    public Salary getSalary();
    public List<Salary> getSalaryByTid(Integer tid);
}
