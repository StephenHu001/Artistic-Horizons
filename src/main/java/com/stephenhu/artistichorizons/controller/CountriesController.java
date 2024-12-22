package com.stephenhu.artistichorizons.controller;

import com.stephenhu.artistichorizons.pojo.Countries;
import com.stephenhu.artistichorizons.service.CountriesService;
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
 * @date 2024-12-11 0:58:21
 * @description: CountriesController
 */
@RestController
@RequestMapping("/api/countries")
@Tag(name = "Controller:Countries", description = "The Countries API")
public class CountriesController {

    @Autowired
    private CountriesService countriesService;

    @Operation(summary = "CountriesInsertAPI")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "success"),
            @ApiResponse(responseCode = "400", description = "stop"),
            @ApiResponse(responseCode = "401", description = "error"),
            @ApiResponse(responseCode = "402", description = "loser"),
    })
    @PostMapping("/insert")
    public ResultUtil<Integer> insertCountry(
            @Parameter(description = "The name of the country", required = true, example = "The country name")
            @RequestParam String countryName,

            @Parameter(description = "The description of the country", required = true, example = "The country description")
            @RequestParam String description) {
        return countriesService.insert(countryName, description);
    }

    @Operation(summary = "CountriesDeleteAPI")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "success"),
            @ApiResponse(responseCode = "400", description = "stop"),
            @ApiResponse(responseCode = "401", description = "error"),
            @ApiResponse(responseCode = "402", description = "loser"),
    })
    @DeleteMapping("/delete")
    public ResultUtil<Integer> delById(
            @Parameter(description = "ID of the country to delete", required = true, example = "565760015601664")
            @RequestParam long countryId) {
        return countriesService.delById(countryId);
    }

    @Operation(summary = "CountriesSelectAPI")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "success"),
            @ApiResponse(responseCode = "400", description = "stop"),
            @ApiResponse(responseCode = "401", description = "error"),
            @ApiResponse(responseCode = "402", description = "loser"),
    })
    @GetMapping("/select")
    public ResultUtil<Countries> selectCountry(
            @Parameter(description = "ID of the country to select", required = true, example = "565760015601664")
            @RequestParam long countryId) {
        return countriesService.selectById(countryId);
    }

    @Operation(summary = "CountriesSelectAllAPI")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "success"),
            @ApiResponse(responseCode = "400", description = "stop"),
            @ApiResponse(responseCode = "401", description = "error"),
            @ApiResponse(responseCode = "402", description = "loser"),
    })
    @GetMapping("/selectAll")
    public ResultUtil<List<Countries>> selectAllCountries() {
        return countriesService.selectAll();
    }

    @Operation(summary = "CountriesUpdateAPI")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "success"),
            @ApiResponse(responseCode = "400", description = "stop"),
            @ApiResponse(responseCode = "401", description = "error"),
            @ApiResponse(responseCode = "402", description = "loser"),
    })
    @PutMapping("/update")
    public ResultUtil<Integer> updateCountry(
            @Parameter(description = "ID of the country to update", required = true, example = "565760015601664")
            @RequestParam long countryId,

            @Parameter(description = "The name of the country", required = true, example = "The country name")
            @RequestParam String countryName,

            @Parameter(description = "The description of the country", required = true, example = "The country description")
            @RequestParam String description) {
        return countriesService.updateById(countryId, countryName, description);
    }
}
