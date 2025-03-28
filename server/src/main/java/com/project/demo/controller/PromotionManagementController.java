package com.project.demo.controller;

import com.project.demo.entity.PromotionManagement;
import com.project.demo.service.PromotionManagementService;
import com.project.demo.controller.base.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import javax.persistence.Query;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * 促销管理：(PromotionManagement)表控制层
 *
 */
@RestController
@RequestMapping("/promotion_management")
public class PromotionManagementController extends BaseController<PromotionManagement, PromotionManagementService> {

    /**
     * 促销管理对象
     */
    @Autowired
    public PromotionManagementController(PromotionManagementService service) {
        setService(service);
    }


    @PostMapping("/add")
    @Transactional
    public Map<String, Object> add(HttpServletRequest request) throws IOException {
        Map<String,Object> paramMap = service.readBody(request.getReader());
        this.addMap(paramMap);
        return success(1);
    }

}
