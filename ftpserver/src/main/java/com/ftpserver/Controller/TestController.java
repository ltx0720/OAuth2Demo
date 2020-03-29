package com.ftpserver.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author ltx
 * @Date 21:28 2020/3/27
 */
@RestController
@RequestMapping("/ftptest")
public class TestController {

    @RequestMapping(value = "/upload", method = RequestMethod.GET)
    public String upload(){

        return "upload";
    }

    @RequestMapping(value = "/download", method = RequestMethod.GET)
    public String download(){

        return "download";
    }

    @RequestMapping(value = "/delete", method = RequestMethod.DELETE)
    public String delete(){

        return "delete";
    }

    @RequestMapping(value = "/rename", method = RequestMethod.PUT)
    public String rename(){

        return "rename";
    }

    @RequestMapping(value = "/select", method = RequestMethod.POST)
    public String select(){
        return "select";
    }

}
