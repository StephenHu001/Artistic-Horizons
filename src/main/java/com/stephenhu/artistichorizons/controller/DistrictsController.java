package com.stephenhu.artistichorizons.controller;

import com.stephenhu.artistichorizons.pojo.Districts;
import com.stephenhu.artistichorizons.service.DistrictsService;
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
 * @date 2024-12-11 1:10:21
 * @description: CountriesController
 */
@RestController
@RequestMapping("/api/districts")
@Tag(name = "Controller:Districts", description = "The Districts API")
public class DistrictsController {

    @Autowired
    private DistrictsService districtsService;

    @Operation(summary = "DistrictsInsertAPI")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "success"),
            @ApiResponse(responseCode = "400", description = "stop"),
            @ApiResponse(responseCode = "401", description = "error"),
            @ApiResponse(responseCode = "402", description = "loser"),
    })
    @PostMapping("/insert")
    public ResultUtil<Integer> insertDistrict(
            @Parameter(description = "The name of the district", required = true, example = "The district name")
            @RequestParam String districtName,
            @Parameter(description = "The description of the district", required = true, example = "The district description")
            @RequestParam String description,
            @Parameter(description = "ID of the country the district belongs to", required = true, example = "565760015601664")
            @RequestParam long countryId) {
        return districtsService.insert(districtName, description, countryId);
    }

    @Operation(summary = "DistrictsDeleteAPI")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "success"),
            @ApiResponse(responseCode = "400", description = "stop"),
            @ApiResponse(responseCode = "401", description = "error"),
            @ApiResponse(responseCode = "402", description = "loser"),
    })
    @DeleteMapping("/delete")
    public ResultUtil<Integer> delById(
            @Parameter(description = "ID of the district to delete", required = true, example = "565760015601664")
            @RequestParam long districtId) {
        return districtsService.delById(districtId);
    }

    @Operation(summary = "DistrictsSelectAPI")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "success"),
            @ApiResponse(responseCode = "400", description = "stop"),
            @ApiResponse(responseCode = "401", description = "error"),
            @ApiResponse(responseCode = "402", description = "loser"),
    })
    @GetMapping("/select")
    public ResultUtil<Districts> selectDistrict(
            @Parameter(description = "ID of the district to select", required = true, example = "565760015601664")
            @RequestParam long districtId) {
        return districtsService.selectById(districtId);
    }

    @Operation(summary = "DistrictsSelectAllAPI")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "success"),
            @ApiResponse(responseCode = "400", description = "stop"),
            @ApiResponse(responseCode = "401", description = "error"),
            @ApiResponse(responseCode = "402", description = "loser"),
    })
    @GetMapping("/selectAll")
    public ResultUtil<List<Districts>> selectAllDistricts() {
        return districtsService.selectAll();
    }

    @Operation(summary = "DistrictsUpdateAPI")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "success"),
            @ApiResponse(responseCode = "400", description = "stop"),
            @ApiResponse(responseCode = "401", description = "error"),
            @ApiResponse(responseCode = "402", description = "loser"),
    })
    @PutMapping("/update")
    public ResultUtil<Integer> updateDistrict(
            @Parameter(description = "ID of the district to update", required = true, example = "565760015601664")
            @RequestParam long districtId,
            @Parameter(description = "The name of the district", required = true, example = "The district name")
            @RequestParam String districtName,
            @Parameter(description = "The description of the district", required = true, example = "The district description")
            @RequestParam String description,
            @Parameter(description = "ID of the country the district belongs to", required = true, example = "565760015601664")
            @RequestParam long countryId) {
        return districtsService.updateById(districtId, districtName, description, countryId);
    }
}
