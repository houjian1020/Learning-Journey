package com.springboot.demo.service;
import com.springboot.demo.entry.AuditOrgaArea;
import com.springboot.demo.mapper.AuditOrgaAreaMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class AuditOrgaAreaServiceImpl implements IAuditOrgaAreaService{
    @Autowired
    private AuditOrgaAreaMapper mapper;
    @Override
    public List<AuditOrgaArea> findAll() {
        return mapper.findAll();
    }

    @Override
    public List<AuditOrgaArea> findByCondition(String ouguid, String ouname) {
        return mapper.findByCondition(ouguid,ouname);
    }

    @Override
    public AuditOrgaArea findByGuid(Map<String, Object> map) {
        return mapper.findByGuid(map);
    }

    @Override
    public AuditOrgaArea findByBean(AuditOrgaArea auditOrgaArea) {
        return mapper.findByBean(auditOrgaArea);
    }

    @Override
    public void insertList(List<AuditOrgaArea> insertList) {
        mapper.insertOrgaArea(insertList);
    }

    @Override
    public List<AuditOrgaArea> selectOrgaArea(List<Integer> cityLevels) {
        return mapper.selectOrgaArea(cityLevels);
    }

    @Override
    public void updateOrgaArea(List<AuditOrgaArea> updateList) {
        mapper.updateOrgaArea(updateList);
    }

    @Override
    public void deleteOrgaArea(List<String> rowguids) {
        mapper.deleteOrgaArea(rowguids);
    }

    @Override
    public List<AuditOrgaArea> findlistByOuname(String ouname) {
        return mapper.findlistByOuname(ouname);
    }
}
