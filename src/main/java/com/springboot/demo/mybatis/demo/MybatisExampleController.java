package com.springboot.demo.mybatis.demo;

import com.springboot.demo.entry.AuditOrgaArea;
import com.springboot.demo.service.IAuditOrgaAreaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

@RestController
@RequestMapping("/MybatisExampleController")
public class MybatisExampleController {
    @Autowired
    IAuditOrgaAreaService service;



    /**
     * 模糊查询like语句:CONCAT(’%’,#{question},’%’) 使用CONCAT()函数，（推荐）
     */
    @RequestMapping("/findlistByOuname")
    public String findlistByOuname(){
        List<AuditOrgaArea> auditOrgaAreas = service.findlistByOuname("审批局");
        System.out.println(auditOrgaAreas.toString());
        return "模糊查询like语句:CONCAT(’%’,#{question},’%’) 使用CONCAT()函数";
    }

    /**
     * 在mapper中如何传递多个参数
     */

    // 方法1：@Param注解传参法
    @RequestMapping("/findByCondition")
    public String findByCondition(){
        List<AuditOrgaArea> list = service.findByCondition("5c5d438b-eaab-4297-85bc-f1bd7b50952f", "行政审批局");
        System.out.println(list.get(0).getOuName());
        return "在mapper中如何传递多个参数:顺序传参法";
    }

    // 方法2：Map传参法
    @RequestMapping("/findByGuid")
    public String findByGuid(){
        HashMap map = new HashMap<>();
        map.put("rowguid", "03a1c985-3e59-4d5c-ab56-9a5805b0a4e9");
        AuditOrgaArea byGuid = service.findByGuid(map);
        System.out.println(byGuid.getRowguid()+"============="+byGuid.getOuName());
        return " 方法2：Map传参法";
    }

    // 方法3：Java Bean传参法
    @RequestMapping("/findByBean")
    public String findByBean(){
        AuditOrgaArea   auditOrgaArea = new AuditOrgaArea();
        auditOrgaArea.setRowguid("03a1c985-3e59-4d5c-ab56-9a5805b0a4e9");
        AuditOrgaArea byBean = service.findByBean(auditOrgaArea);
        System.out.println(byBean.getRowguid()+"============="+byBean.getOuName());
        return " 方法3：Java Bean传参法";
    }


    /**
     * Mybatis如何执行批量操作: foreach标签的使用
     *
     *  1在 INSERT 语句中使用 <foreach>
     */
    @RequestMapping("/insertList")
    public String insertList(){
        List<AuditOrgaArea> list = new ArrayList<>();
        for(int i=0;i<10;i++){
            AuditOrgaArea auditOrgaArea = new AuditOrgaArea();
            auditOrgaArea.setRowguid(UUID.randomUUID().toString());
            auditOrgaArea.setOperateUserName("系统批量录入");
            auditOrgaArea.setOperateDate(new Date());
            auditOrgaArea.setOuGuid(UUID.randomUUID().toString());
            auditOrgaArea.setOuName("行政审批局");
            auditOrgaArea.setXiaQuCode("610000");
            auditOrgaArea.setCityLevel(2);
            auditOrgaArea.setOrderNum(0);
            auditOrgaArea.setAddress("北京市市辖区丰台区五里店街道");
            list.add(auditOrgaArea);
        }
        service.insertList(list);
        return "在 INSERT 语句中使用 <foreach>";
    }

    /**
     * 2 在 SELECT 语句中使用 <foreach>
     * @return
     */
    @RequestMapping("/selectOrgaArea")
    public String selectOrgaArea(){
        List<Integer> cityLevelList = new ArrayList<>();
        cityLevelList.add(1);
        cityLevelList.add(2);
        List<AuditOrgaArea> auditOrgaAreas = service.selectOrgaArea(cityLevelList);
        for (AuditOrgaArea auditOrgaArea : auditOrgaAreas){
            System.out.println(auditOrgaArea.getRowguid()+auditOrgaArea.getOuName());
        }

        return "在 SELECT 语句中使用 <foreach>";
    }

    /**
     * 3 在 UPDATE 语句中使用 <foreach>
     */
    @RequestMapping("/updateList")
    public String updateList(){
        List<AuditOrgaArea> updateList = service.findAll();
        for ( AuditOrgaArea auditOrgaArea : updateList) {
            auditOrgaArea.setXiaQuName(auditOrgaArea.getXiaQuCode()+"辖区");
        }
        service.updateOrgaArea(updateList);
        return " 在 UPDATE 语句中使用 <foreach>";
    }

    /**
     * 在 DELETE 语句中使用 <foreach>
     */
    @RequestMapping("/deleteOrgaArea")
    public String deleteOrgaArea(){
        List<String> deleteList = new ArrayList<>();
        deleteList.add("f5ca52ee-fcc3-4f77-baee-9aa70421e56f");
        deleteList.add("fa0bd828-54be-4f02-86d6-f1be9662e7b3");
        service.deleteOrgaArea(deleteList);
        return "在 DELETE 语句中使用 <foreach>";
    }



}
