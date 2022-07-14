package com.springboot.demo.service;

import com.springboot.demo.entry.AuditOrgaArea;

import java.util.List;

public interface IAuditOrgaAreaService {
    List<AuditOrgaArea> findAll();
}
