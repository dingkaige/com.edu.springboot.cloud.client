package org.springframework.boot.cloud.client.controller;

import lombok.extern.log4j.Log4j2;
import net.sf.json.JSONObject;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;


/**
 * @description:
 * @program: eureka-service
 * @author: dingkaige
 * @date: 2019-12-23 11:05
 **/
@RestController
@RequestMapping("api")
@Log4j2
public class ClientController {

    @GetMapping("findById")
    public Object findById(@RequestParam(name = "id") Long id) {
        log.info("findById:"+id);
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("id", id);
        return jsonObject;
    }

    @GetMapping("findById2")
    public Object findById2(@RequestParam(name = "id") Long id) {
        log.info("findById2:"+id);
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("id", id+2);
        return jsonObject;
    }

    @GetMapping("/{id}")
    public Object findByPathId(@PathVariable Long id) {
        log.info("findByPathId:"+id);
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("findByPathId", id);
        return jsonObject;
    }

    @PostMapping("upload")
    public Object upload(@RequestParam(value="file")MultipartFile file) {
        try {
            byte[] in = file.getBytes();
            File out = new File(file.getOriginalFilename());
            FileCopyUtils.copy(in, out);
            return out.getAbsolutePath();
        }catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
