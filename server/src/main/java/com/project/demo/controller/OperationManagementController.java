package com.project.demo.controller;

import com.project.demo.entity.OperationManagement;
import com.project.demo.service.OperationManagementService;
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
 * 运营管理：(OperationManagement)表控制层
 *
 */
@RestController
@RequestMapping("/operation_management")
public class OperationManagementController extends BaseController<OperationManagement, OperationManagementService> {

    /**
     * 运营管理对象
     */
    @Autowired
    public OperationManagementController(OperationManagementService service) {
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
