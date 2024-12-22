package com.stephenhu.artistichorizons.controller;

import com.stephenhu.artistichorizons.pojo.Themes;
import com.stephenhu.artistichorizons.service.ThemesService;
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
 * @description: ThemesController
 */
@RestController
@RequestMapping("/api/themes")
@Tag(name = "Controller:Themes", description = "The Themes API")
public class ThemesController {
    @Autowired
    private ThemesService themesService;

    @Operation(summary = "ThemesInsertAPI")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "success"),
            @ApiResponse(responseCode = "400", description = "stop"),
            @ApiResponse(responseCode = "401", description = "error"),
            @ApiResponse(responseCode = "402", description = "loser")
    })
    @PostMapping("/insert")
    public ResultUtil<Integer> insert(
            @Parameter(description = "Theme name", required = true, example = "The theme name")
            @RequestParam String themeName) {
        return themesService.insert(themeName);
    }

    @Operation(summary = "ThemesDeleteAPI")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "success"),
            @ApiResponse(responseCode = "400", description = "stop"),
            @ApiResponse(responseCode = "401", description = "error"),
            @ApiResponse(responseCode = "402", description = "loser")
    })
    @DeleteMapping("/delete")
    public ResultUtil<Integer> delById(
            @Parameter(description = "ID of the theme to delete", required = true, example = "565760015601664")
            @RequestParam long themeId) {
        return themesService.delById(themeId);
    }

    @Operation(summary = "ThemesSelectAPI")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "success"),
            @ApiResponse(responseCode = "400", description = "stop"),
            @ApiResponse(responseCode = "401", description = "error"),
            @ApiResponse(responseCode = "402", description = "loser")
    })
    @GetMapping("/select")
    public ResultUtil<Themes> selectTheme(
            @Parameter(description = "ID of the theme to select", required = true, example = "565760015601664")
            @RequestParam long themeId) {
        return themesService.selectById(themeId);
    }

    @Operation(summary = "ThemesSelectAllAPI")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "success"),
            @ApiResponse(responseCode = "400", description = "stop"),
            @ApiResponse(responseCode = "401", description = "error"),
            @ApiResponse(responseCode = "402", description = "loser")
    })
    @GetMapping("/selectAll")
    public ResultUtil<List<Themes>> selectAllThemes() {
        return themesService.selectAll();
    }

    @Operation(summary = "ThemesUpdateAPI")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "success"),
            @ApiResponse(responseCode = "400", description = "stop"),
            @ApiResponse(responseCode = "401", description = "error"),
            @ApiResponse(responseCode = "402", description = "loser")
    })
    @PutMapping("/update")
    public ResultUtil<Integer> updateTheme(
            @Parameter(description = "ID of the theme to update", required = true, example = "565760015601664")
            @RequestParam long themeId,
            @Parameter(description = "Theme name", required = true, example = "The theme name")
            @RequestParam String themeName) {
        return themesService.updateById(themeId, themeName);
    }
}
