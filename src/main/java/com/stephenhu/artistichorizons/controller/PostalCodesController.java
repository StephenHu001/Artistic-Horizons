package com.stephenhu.artistichorizons.controller;

import com.stephenhu.artistichorizons.pojo.PostalCodes;
import com.stephenhu.artistichorizons.service.PostalCodesService;
import com.stephenhu.artistichorizons.utils.ResultUtil;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author Stephen Hu
 * @date 2024-12-11 8:46:21
 * @description: PostalCodesController
 */
@RestController
@RequestMapping("/api/postalCodes")
@Tag(name = "Controller:PostalCodes", description = "The PostalCodes API")
public class PostalCodesController {
    @Autowired
    private PostalCodesService postalCodesService;

    @Operation(summary = "PostalCodesInsertAPI")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "success"),
            @ApiResponse(responseCode = "400", description = "stop"),
            @ApiResponse(responseCode = "401", description = "error"),
            @ApiResponse(responseCode = "402", description = "loser")
    })
    @PostMapping("/insert")
    public ResultUtil<Integer> insert(
            @Parameter(description = "Postal code", required = true, example = "565760015601664")
            @RequestParam String postalCode,
            @Parameter(description = "Description of the postal code", required = true, example = "The postal code description")
            @RequestParam String description) {
        return postalCodesService.insert(postalCode, description);
    }

    @Operation(summary = "PostalCodesDeleteAPI")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "success"),
            @ApiResponse(responseCode = "400", description = "stop"),
            @ApiResponse(responseCode = "401", description = "error"),
            @ApiResponse(responseCode = "402", description = "loser")
    })
    @DeleteMapping("/delete")
    public ResultUtil<Integer> delById(
            @Parameter(description = "ID of the postal code to delete", required = true, example = "565760015601664")
            @RequestParam long postalCodeId) {
        return postalCodesService.delById(postalCodeId);
    }

    @Operation(summary = "PostalCodesSelectAllAPI")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "success"),
            @ApiResponse(responseCode = "400", description = "stop"),
            @ApiResponse(responseCode = "401", description = "error"),
            @ApiResponse(responseCode = "402", description = "loser")
    })
    @GetMapping("/selectAll")
    public ResultUtil<List<PostalCodes>> selectAllPostalCodes() {
        return postalCodesService.selectAll();
    }

    @Operation(summary = "PostalCodesSelectAPI")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "success"),
            @ApiResponse(responseCode = "400", description = "stop"),
            @ApiResponse(responseCode = "401", description = "error"),
            @ApiResponse(responseCode = "402", description = "loser")
    })
    @GetMapping("/select")
    public ResultUtil<PostalCodes> selectPostalCode(
            @Parameter(description = "ID of the postal code to select", required = true, example = "565760015601664")
            @RequestParam long postalCodeId) {
        return postalCodesService.selectById(postalCodeId);
    }

    @Operation(summary = "PostalCodesUpdateAPI")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "success"),
            @ApiResponse(responseCode = "400", description = "stop"),
            @ApiResponse(responseCode = "401", description = "error"),
            @ApiResponse(responseCode = "402", description = "loser")
    })
    @PutMapping("/update")
    public ResultUtil<Integer> updatePostalCode(
            @Parameter(description = "ID of the postal code to update", required = true, example = "565760015601664")
            @RequestParam long postalCodeId,
            @Parameter(description = "Postal code", required = true, example = "565760015601664")
            @RequestParam String postalCode,
            @Parameter(description = "Description of the postal code", required = true, example = "The postal code description")
            @RequestParam String description) {
        return postalCodesService.updateById(postalCodeId, postalCode, description);
    }
}
