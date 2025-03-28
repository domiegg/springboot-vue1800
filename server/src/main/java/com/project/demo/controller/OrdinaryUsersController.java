package com.project.demo.controller;

import com.project.demo.entity.OrdinaryUsers;
import com.project.demo.service.OrdinaryUsersService;
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
 * 普通用户：(OrdinaryUsers)表控制层
 *
 */
@RestController
@RequestMapping("/ordinary_users")
public class OrdinaryUsersController extends BaseController<OrdinaryUsers, OrdinaryUsersService> {

    /**
     * 普通用户对象
     */
    @Autowired
    public OrdinaryUsersController(OrdinaryUsersService service) {
        setService(service);
    }


    @PostMapping("/add")
    @Transactional
    public Map<String, Object> add(HttpServletRequest request) throws IOException {
        Map<String,Object> paramMap = service.readBody(request.getReader());
        Map<String, String> mapuser_account = new HashMap<>();
        mapuser_account.put("user_account",String.valueOf(paramMap.get("user_account")));
        List listuser_account = service.select(mapuser_account, new HashMap<>()).getResultList();
        if (listuser_account.size()>0){
            return error(30000, "字段用户账号内容不能重复");
        }
        this.addMap(paramMap);
        return success(1);
    }

}
