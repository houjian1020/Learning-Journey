package com.springboot.demo.service;

import com.springboot.demo.entry.AuditOrgaArea;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface IAuditOrgaAreaService {
    List<AuditOrgaArea> findAll();

    List<AuditOrgaArea> findByCondition(String ouguid,String ouname);

    AuditOrgaArea findByGuid(Map<String,Object> map);

    AuditOrgaArea findByBean(AuditOrgaArea auditOrgaArea);

    void insertList(List<AuditOrgaArea> insertList);

    List<AuditOrgaArea> selectOrgaArea(List<Integer> cityLevels);

    void updateOrgaArea(List<AuditOrgaArea> updateList);

    void deleteOrgaArea(List<String> rowguids);

    List<AuditOrgaArea> findlistByOuname(String 审批局);
}
