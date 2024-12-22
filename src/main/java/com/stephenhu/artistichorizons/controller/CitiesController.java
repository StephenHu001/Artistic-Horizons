package com.stephenhu.artistichorizons.controller;

import com.stephenhu.artistichorizons.pojo.Cities;
import com.stephenhu.artistichorizons.service.CitiesService;
import com.stephenhu.artistichorizons.utils.ResultUtil;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Stephen Hu
 * @date 2024-12-11 0:28:50
 * @description: CitiesController
 */
@RestController
@RequestMapping("/api/cities")
@Tag(name = "Controller:Cities", description = "The Cities API")
public class CitiesController {

    @Autowired
    private CitiesService citiesService;

    @Operation(summary = "CitiesInsertAPI")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "success"),
            @ApiResponse(responseCode = "400", description = "stop"),
            @ApiResponse(responseCode = "401", description = "error"),
            @ApiResponse(responseCode = "402", description = "loser"),
    })
    @PostMapping("/insert")
    public ResultUtil<Integer> insertCity(
            @Parameter(description = "The name of the city", required = true, example = "New York")
            @RequestParam String cityName,

            @Parameter(description = "The description of the city", required = true, example = "The Big Apple")
            @RequestParam String description,

            @Parameter(description = "The ID of the district the city is located in", required = true, example = "565760015601664")
            @RequestParam long districtId,

            @Parameter(description = "The ID of the postal code associated with the city", required = true, example = "565760015601664")
            @RequestParam long postalCodeId) {
        return citiesService.insert(cityName, description, districtId, postalCodeId);
    }

    @Operation(summary = "CitiesDeleteAPI")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "success"),
            @ApiResponse(responseCode = "400", description = "stop"),
            @ApiResponse(responseCode = "401", description = "error"),
            @ApiResponse(responseCode = "402", description = "loser"),
    })
    @DeleteMapping("/delete")
    public ResultUtil<Integer> deleteCity(
            @Parameter(description = "ID of the city to delete", required = true, example = "565760015601664")
            @RequestParam long cityId) {
        return citiesService.delById(cityId);
    }

    @Operation(summary = "CitiesSelectAllAPI")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "success"),
            @ApiResponse(responseCode = "400", description = "stop"),
            @ApiResponse(responseCode = "401", description = "error"),
            @ApiResponse(responseCode = "402", description = "loser"),
    })
    @GetMapping("/selectAll")
    public ResultUtil<List<Cities>> selectAllCities() {
        return citiesService.selectAll();
    }

    @Operation(summary = "CitiesSelectAPI")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "success"),
            @ApiResponse(responseCode = "400", description = "stop"),
            @ApiResponse(responseCode = "401", description = "error"),
            @ApiResponse(responseCode = "402", description = "loser"),
    })
    @GetMapping("/select")
    public ResultUtil<Cities> selectCity(
            @Parameter(description = "ID of the city to select", required = true, example = "565760015601664")
            @RequestParam long cityId) {
        return citiesService.selectById(cityId);
    }
    @Operation(summary = "CitiesUpdateAPI")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "success"),
            @ApiResponse(responseCode = "400", description = "stop"),
            @ApiResponse(responseCode = "401", description = "error"),
            @ApiResponse(responseCode = "402", description = "loser"),
    })
    @PutMapping("/update")
    public ResultUtil<Integer> updateCity(
            @Parameter(description = "ID of the city to update", required = true, example = "565760015601664")
            @RequestParam long cityId,

            @Parameter(description = "The name of the city", required = true, example = "New York")
            @RequestParam String cityName,

            @Parameter(description = "The description of the city", required = true, example = "The Big Apple")
            @RequestParam String description,

            @Parameter(description = "The ID of the district the city is located in", required = true, example = "565760015601664")
            @RequestParam long districtId,

            @Parameter(description = "The ID of the postal code associated with the city", required = true, example = "565760015601664")
            @RequestParam long postalCodeId) {
        return citiesService.updateById(cityId, cityName, description, districtId, postalCodeId);
    }
}
