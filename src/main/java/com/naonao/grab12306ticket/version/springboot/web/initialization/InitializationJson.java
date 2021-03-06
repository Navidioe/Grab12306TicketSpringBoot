package com.naonao.grab12306ticket.version.springboot.web.initialization;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.naonao.grab12306ticket.version.springboot.constants.ConvertMap;
import com.naonao.grab12306ticket.version.springboot.service.tools.GeneralTools;
import com.naonao.grab12306ticket.version.springboot.web.base.AbstractInitialization;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @program: Grab12306Ticket-SpringBoot
 * @description: initialization json data
 * @author: Wen lyuzhao
 * @create: 2019-05-19 13:21
 **/
@RestController
@RequestMapping("${url.prefix}" + "initialization")
public class InitializationJson extends AbstractInitialization {

    /**
     * get city json data, return a list.
     * format:
     * [
     *     children:[
     *         {
     *             "label":"北京市",
     *             "value":"beijingshi"
     *         }
     *     ]
     * ]
     * @return      JSONArray
     */
    @GetMapping("cityJson")
    public JSONArray cityJson(){
        String jsonString = GeneralTools.readFileText("cityJson.json");
        if ("".equals(jsonString)){
            return new JSONArray();
        }
        JSONObject jsonObject= JSONObject.parseObject(jsonString);
        return jsonObject.getJSONArray("data");
    }

    @GetMapping("purposeCodeJson")
    public List<Map<String, String>>  purposeCodeJson(){
        List<Map<String, String>> purposeCodeList = new ArrayList<>();
        Map<String, String> purposeCodeMap = new HashMap<>(16);
        purposeCodeMap.put("label", "成人票");
        purposeCodeMap.put("value", "ADULT");
        purposeCodeList.add(purposeCodeMap);
        return purposeCodeList;
    }

    @GetMapping("documentTypeJson")
    public List<Map<String, String>> documentTypeJson(){
        List<Map<String, String>> documentTypeMapList = new ArrayList<>();
        Map<String, String> documentTypeMap = new HashMap<>(16);
        documentTypeMap.put("label", "身份证");
        documentTypeMap.put("value", "1");
        documentTypeMapList.add(documentTypeMap);
        return documentTypeMapList;
    }

    @GetMapping("seatTypeJson")
    public List<Map<String, String>> seatTypeJson(){
        List<Map<String, String>> documentTypeMapList = new ArrayList<>();
        List<String> seatTypeNameList = ConvertMap.seatTypeNameList();
        for(String seatTypeName: seatTypeNameList){
            Map<String, String> documentTypeMap = new HashMap<>(16);
            documentTypeMap.put("label", seatTypeName);
            documentTypeMap.put("value", seatTypeName);
            documentTypeMapList.add(documentTypeMap);
        }
        return documentTypeMapList;
    }

    @GetMapping("expectSeatNumberJson")
    public List<Map<String, String>> expectSeatNumberJson(){
        List<Map<String, String>> expectSeatNumberMapList = new ArrayList<>();
        String[] expectSeatNumberArray = {
                "A", "B", "C", "E", "F"
        };
        for(String expectSeatNumber: expectSeatNumberArray){
            Map<String, String> documentTypeMap = new HashMap<>(16);
            documentTypeMap.put("label", expectSeatNumber);
            documentTypeMap.put("value", expectSeatNumber);
            expectSeatNumberMapList.add(documentTypeMap);
        }
        return expectSeatNumberMapList;
    }

    @GetMapping("emailSuffixJson")
    public List<Map<String, String>> emailSuffixJson(){
        List<Map<String, String>> expectSeatNumberMapList = new ArrayList<>();
        String[] expectSeatNumberArray = {
                "@gmail.com",
                "@qq.com",
                "@sina.com",
                "@163.com",
                "@cloud.com"
        };
        for(String expectSeatNumber: expectSeatNumberArray){
            Map<String, String> documentTypeMap = new HashMap<>(16);
            documentTypeMap.put("label", expectSeatNumber);
            documentTypeMap.put("value", expectSeatNumber);
            expectSeatNumberMapList.add(documentTypeMap);
        }
        return expectSeatNumberMapList;
    }

    @GetMapping("publicKey")
    public Map<String, String> publicKey(@Value("${setting.encryption.rsa.publicFilePath}")String publicKeyPath){
        Map<String, String> map = new HashMap<>(16);
        String publicKey = GeneralTools
                .readFileText(publicKeyPath)
                .replace("-----BEGIN PUBLIC KEY-----", "")
                .replace("-----END PUBLIC KEY-----", "")
                .replace("\n", "")
                .trim();
        map.put("publicKey", publicKey);
        return map;
    }
}
