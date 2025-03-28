package com.project.demo.controller;

import com.project.demo.entity.MallCenter;
import com.project.demo.service.MallCenterService;
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
 * 商城中心：(MallCenter)表控制层
 *
 */
@RestController
@RequestMapping("/mall_center")
public class MallCenterController extends BaseController<MallCenter, MallCenterService> {

    /**
     * 商城中心对象
     */
    @Autowired
    public MallCenterController(MallCenterService service) {
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
