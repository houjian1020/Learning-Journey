package com.springboot.demo.service;
import com.springboot.demo.entry.AuditOrgaArea;
import com.springboot.demo.mapper.AuditOrgaAreaMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuditOrgaAreaServiceImpl implements IAuditOrgaAreaService{
    @Autowired
    private AuditOrgaAreaMapper mapper;
    @Override
    public List<AuditOrgaArea> findAll() {
        return mapper.findAll();
    }
}
