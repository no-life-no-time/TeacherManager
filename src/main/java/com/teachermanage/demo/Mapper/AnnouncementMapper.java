package com.teachermanage.demo.Mapper;

import com.teachermanage.demo.Bean.Announcement;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface AnnouncementMapper {
    public List<Announcement> getAll();
}
