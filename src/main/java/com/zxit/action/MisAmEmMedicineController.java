package com.zxit.action;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zxit.model.MisAmEmMedicine;
import com.zxit.service.MisAmEmMedicineService;


@Controller
@RequestMapping("/misAmEmMedicine.do")
public class MisAmEmMedicineController {

    @Resource
    private MisAmEmMedicineService misAmEmMedicineService;

    /**
     * 根据ID找到相应的药物对象
     *
     * @param id
     * @param request
     * @return
     */
    @ResponseBody
    @RequestMapping(params = "method=findMisAmEmMedicine")
    public MisAmEmMedicine findMisAmEmMedicine(Integer id, HttpServletRequest request) {
        MisAmEmMedicine misAmEmMedicine = misAmEmMedicineService.findMisAmEmMedicineById(id);
        return misAmEmMedicine;
    }

}
