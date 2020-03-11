package com.teachermanage.demo.Service;

import com.teachermanage.demo.Bean.Announcement;
import com.teachermanage.demo.Mapper.AnnouncementMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class AnnouncementServiceImp implements AnnouncementService {
    @Autowired
    AnnouncementMapper announcementMapper;
    @Override
    public List<Announcement> getAll() {
        return announcementMapper.getAll();
    }
}
