package com.stephenhu.artistichorizons.controller;

import cn.dev33.satoken.stp.SaTokenInfo;
import com.stephenhu.artistichorizons.service.AdminsService;
import com.stephenhu.artistichorizons.utils.ResultUtil;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author Stephen Hu
 */
@RestController
@RequestMapping("/api/admins")
@Tag(name = "Controller:Admins", description = "The Admins API")
public class AdminsController {
    @Autowired
    private AdminsService adminsService;

    @Operation(summary = "AdminGetPublicKeyByAccountAPI")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "success"),
            @ApiResponse(responseCode = "400", description = "stop"),
            @ApiResponse(responseCode = "401", description = "error"),
            @ApiResponse(responseCode = "402", description = "loser"),
    })
    @GetMapping("/toFindAccount")
    public ResultUtil<String> toFindAccount(
            @Parameter(description = "Account of the admin", required = true, example = "565760015601664")
            @RequestParam long account) {
        return adminsService.toFindAccount(account);
    }

    @Operation(summary = "AdminLoginAPI")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "success"),
            @ApiResponse(responseCode = "400", description = "stop"),
            @ApiResponse(responseCode = "401", description = "error"),
            @ApiResponse(responseCode = "402", description = "loser"),
    })
    @PostMapping("/doLogin")
    public ResultUtil<Integer> doLogin(
            @Parameter(description = "Account of the admin", required = true, example = "565760015601664")
            @RequestParam long account,

            @Parameter(description = "Account of the admin", required = true, example = "565760015601664")
            @RequestParam String password) {
        return adminsService.doLogin(account, password);
    }

    @Operation(summary = "AdminIsLoginAPI")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "success"),
            @ApiResponse(responseCode = "400", description = "stop"),
            @ApiResponse(responseCode = "401", description = "error"),
            @ApiResponse(responseCode = "402", description = "loser"),
    })
    @GetMapping("/loginCheck")
    public ResultUtil<Integer> isLogin() {
        return adminsService.loginCheck();
    }

    @Operation(summary = "AdminIsLogOutAPI")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "success"),
            @ApiResponse(responseCode = "400", description = "stop"),
            @ApiResponse(responseCode = "401", description = "error"),
            @ApiResponse(responseCode = "402", description = "loser"),
    })
    @GetMapping("/logOut")
    public ResultUtil<Integer> logOut() {
        return adminsService.logout();
    }
    @Operation(summary = "AdminTokenInfoAPI")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "success"),
            @ApiResponse(responseCode = "400", description = "stop"),
            @ApiResponse(responseCode = "401", description = "error"),
            @ApiResponse(responseCode = "402", description = "loser"),
    })
    @GetMapping("/tokenInfo")
    public ResultUtil<SaTokenInfo> tokenInfo() {
        return adminsService.tokenInfo();
    }
}
