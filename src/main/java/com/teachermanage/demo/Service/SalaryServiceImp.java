package com.teachermanage.demo.Service;

import com.teachermanage.demo.Bean.Salary;
import com.teachermanage.demo.Mapper.SalaryMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SalaryServiceImp implements SalaryService{
    @Autowired
    SalaryMapper salaryMapper;
    @Override
    public List<Salary> getSalary() {
        return null;
    }

    @Override
    public List<Salary> getSalaryByTid(Integer tid) {
        return salaryMapper.getSalaryByTid(tid);
    }
}
