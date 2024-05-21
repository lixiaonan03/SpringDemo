package com.lxn.controller;

import com.lxn.Book;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import springfox.documentation.service.Parameter;

import org.apache.coyote.Request;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by lixiaonan on 2018/3/15.
 */
@RestController
@RequestMapping("/bat")
@Api(tags = "BookController", description = "BookController | 通过书来测试swagger")
public class LiController {

    private static final Logger logger = LoggerFactory.getLogger(LiController.class);

    Map<String,Book> books = Collections.synchronizedMap(new HashMap<String, Book>());

    @ApiOperation(value="创建图书", notes="创建图书")
    @ApiImplicitParam(name = "book", value = "图书详细实体", required = true, dataType = "Book")
    @RequestMapping(value="/post", method=RequestMethod.POST)
    public String postBook(@RequestBody Book book) {
        books.put(book.getId(), book);
        return "success";
    }

    @RequestMapping(value="/file", method=RequestMethod.POST)
    public String putFile(MultipartFile file) {
        return "success";
    }

    @RequestMapping(value = "/post_user", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public String setConstructKeyPoints( @RequestBody Parameter parameter) {
        return "success";
    }



    @ApiOperation(value = "hello2", notes = "hello2的")
    @RequestMapping(value = "/hello2", method = RequestMethod.GET)
    public String say1(@ApiParam(name="id",value="用户id",required=true)String a, Integer b, BigDecimal c) {
        try {
            logger.info("接受到了"+Thread.currentThread().getName());
        } catch (Exception e) {
            e.printStackTrace();
        }
        logger.info("准备回应的==="+Thread.currentThread().getName());
        return "---蝶衣-----";
    }


    @ApiOperation(value = "获图书细信息", notes = "根据url的id来获取详细信息")
    @ApiImplicitParam(name = "id", value = "ID", required = true, dataType = "String", paramType = "path")
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Book getBook(@PathVariable String id) {
        return books.get(id);
    }
}
