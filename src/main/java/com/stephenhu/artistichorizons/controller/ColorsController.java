package com.stephenhu.artistichorizons.controller;

import com.stephenhu.artistichorizons.pojo.Colors;
import com.stephenhu.artistichorizons.service.ColorsService;
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
 * @date 2024-12-11 0:46:21
 * @description: ColorsController
 */
@RestController
@RequestMapping("/api/colors")
@Tag(name = "Controller:Colors", description = "The Colors API")
public class ColorsController {
    @Autowired
    private ColorsService colorsService;

    @Operation(summary = "ColorsInsertAPI")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "success"),
            @ApiResponse(responseCode = "400", description = "stop"),
            @ApiResponse(responseCode = "401", description = "error"),
            @ApiResponse(responseCode = "402", description = "loser"),
    })
    @PostMapping("/insert")
    public ResultUtil<Integer> insertColor(
            @Parameter(description = "The name of the color", required = true, example = "The color name")
            @RequestParam String colorName,

            @Parameter(description = "The RGB value of the color", required = true, example = "#000000")
            @RequestParam String colorRgb) {
        return colorsService.insert(colorName, colorRgb);
    }

    @Operation(summary = "ColorsDeleteAPI")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "success"),
            @ApiResponse(responseCode = "400", description = "stop"),
            @ApiResponse(responseCode = "401", description = "error"),
            @ApiResponse(responseCode = "402", description = "loser"),
    })
    @DeleteMapping("/delete")
    public ResultUtil<Integer> delById(
            @Parameter(description = "ID of the color to delete", required = true, example = "565760015601664")
            @RequestParam long colorId) {
        return colorsService.delById(colorId);
    }

    @Operation(summary = "ColorsSelectAPI")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "success"),
            @ApiResponse(responseCode = "400", description = "stop"),
            @ApiResponse(responseCode = "401", description = "error"),
            @ApiResponse(responseCode = "402", description = "loser"),
    })
    @GetMapping("/select")
    public ResultUtil<Colors> selectColor(
            @Parameter(description = "ID of the color to select", required = true, example = "565760015601664")
            @RequestParam long colorId) {
        return colorsService.selectById(colorId);
    }

    @Operation(summary = "ColorsSelectAllAPI")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "success"),
            @ApiResponse(responseCode = "400", description = "stop"),
            @ApiResponse(responseCode = "401", description = "error"),
            @ApiResponse(responseCode = "402", description = "loser"),
    })
    @GetMapping("/selectAll")
    public ResultUtil<List<Colors>> selectAllColors() {
        return colorsService.selectAll();
    }

    @Operation(summary = "ColorsUpdateAPI")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "success"),
            @ApiResponse(responseCode = "400", description = "stop"),
            @ApiResponse(responseCode = "401", description = "error"),
            @ApiResponse(responseCode = "402", description = "loser"),
    })
    @PutMapping("/update")
    public ResultUtil<Integer> updateColor(
            @Parameter(description = "ID of the color to update", required = true, example = "565760015601664")
            @RequestParam long colorId,

            @Parameter(description = "The name of the color", required = true, example = "The color name")
            @RequestParam String colorName,

            @Parameter(description = "The RGB value of the color", required = true, example = "#000000")
            @RequestParam String colorRgb) {
        return colorsService.updateById(colorId, colorName, colorRgb);
    }
}
