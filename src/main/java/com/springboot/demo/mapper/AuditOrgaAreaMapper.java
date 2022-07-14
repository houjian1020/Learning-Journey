package com.springboot.demo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.springboot.demo.entry.AuditOrgaArea;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface AuditOrgaAreaMapper extends BaseMapper<AuditOrgaArea> {

    List<AuditOrgaArea> findAll();
}
