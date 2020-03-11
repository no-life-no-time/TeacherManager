package com.teachermanage.demo.Controller;

import com.teachermanage.demo.Bean.Announcement;
import com.teachermanage.demo.Service.AnnouncementServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class AnnouncementController {
    @Autowired
    AnnouncementServiceImp announcementServiceImp;
    @GetMapping("/show")
    public String Announcement(Model model){
        List<Announcement> a=announcementServiceImp.getAll();
        model.addAttribute("ann",a);
        return "Teacher/Announcement";
    }
}
