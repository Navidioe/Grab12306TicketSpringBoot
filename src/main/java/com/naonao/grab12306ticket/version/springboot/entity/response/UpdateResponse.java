package com.naonao.grab12306ticket.version.springboot.entity.response;

import com.naonao.grab12306ticket.version.springboot.entity.IResponseInterface;
import lombok.Data;
import org.springframework.stereotype.Component;

/**
 * @program: SpringBoot
 * @description:
 * @author: Wen lyuzhao
 * @create: 2019-05-15 15:12
 **/
@Component
@Data
public class UpdateResponse implements IResponseInterface {

    private Boolean status;
    private Integer httpStatus;
    private String message;

}
