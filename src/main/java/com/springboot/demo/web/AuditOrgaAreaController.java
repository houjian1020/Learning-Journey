package com.springboot.demo.web;

import com.springboot.demo.entry.AuditOrgaArea;
import com.springboot.demo.service.IAuditOrgaAreaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/AuditOrgaAreaController")
public class AuditOrgaAreaController {
    @Autowired
    IAuditOrgaAreaService service;
    @RequestMapping("/findAll")
    public String findAll(){
        List<AuditOrgaArea> all = service.findAll();
        for (AuditOrgaArea area: all) {
        System.out.println(area.getBaseAreaCode());
        }
        return all.toString();
    }
}
