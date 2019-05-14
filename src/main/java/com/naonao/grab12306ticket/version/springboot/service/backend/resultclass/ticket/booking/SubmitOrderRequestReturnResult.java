package com.naonao.grab12306ticket.version.springboot.service.backend.resultclass.ticket.booking;

import com.naonao.grab12306ticket.version.database.backend.resultclass.IReturnResult;
import lombok.Getter;
import lombok.Setter;
import org.apache.http.impl.client.CloseableHttpClient;

/**
 * @program: 12306grabticket_java
 * @description: submit order request return result
 * @author: Wen lyuzhao
 * @create: 2019-05-01 23:36
 **/
@Getter
@Setter
public class SubmitOrderRequestReturnResult implements IReturnResult {

    private Boolean status;
    private String message;
    private CloseableHttpClient session;

}
