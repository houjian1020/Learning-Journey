package com.springboot.demo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.springboot.demo.entry.AuditOrgaArea;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

public interface AuditOrgaAreaMapper extends BaseMapper<AuditOrgaArea> {

    List<AuditOrgaArea> findAll();

    List<AuditOrgaArea> findlistByOuname(@Param("ouname") String ouname);

    List<AuditOrgaArea> findByCondition(@Param("ouguid")String ouguid,@Param("ouname")String ouname);

    AuditOrgaArea findByGuid(Map<String,Object> map);

    AuditOrgaArea findByBean(AuditOrgaArea auditOrgaArea);

    void insertOrgaArea(@Param("insertList") List<AuditOrgaArea> insertList);

    List<AuditOrgaArea> selectOrgaArea(@Param("cityLevels") List<Integer> cityLevels);

    void updateOrgaArea(@Param("updateList") List<AuditOrgaArea> updateList);

    void deleteOrgaArea(@Param("rowguids") List<String> rowguids);
}
