package com.liuzlin.springbootdemo.controller;

import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.liuzlin.springbootdemo.ResultResponse;
import com.liuzlin.springbootdemo.vo.UserVO;
import io.swagger.annotations.*;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/userController")
@Api(tags = "用户")
public class UserController {

    @ApiImplicitParams({ @ApiImplicitParam(name = "userId",
            value = "用户Id、",
            dataType = "Long",
            paramType = "query",
            required = true,
            example = "123")})
    @ApiOperationSupport(author = "liuzelin")
    @ApiOperation(value = "查询用户详情")
    @GetMapping("/get-user")
    public ResultResponse<UserVO> getUser(@RequestParam Long userId) {
        return ResultResponse.success(new UserVO());
    }

    @ApiResponses(value = { @ApiResponse(code = 1000, message = "成功"), @ApiResponse(code = 1001, message = "失败")})
    @ApiOperationSupport(author = "liuzelin")
    @ApiOperation(value = "会员新增")
    @PostMapping
    public ResultResponse<Boolean> insertUser(@RequestBody UserVO userVO) {
        return ResultResponse.success(true);
    }
}
