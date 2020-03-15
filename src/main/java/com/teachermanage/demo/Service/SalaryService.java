package com.teachermanage.demo.Service;


import com.teachermanage.demo.Bean.Salary;

import java.util.List;

public interface SalaryService{
    public List<Salary> getSalary();
    public List<Salary> getSalaryByTid(Integer tid);
}
