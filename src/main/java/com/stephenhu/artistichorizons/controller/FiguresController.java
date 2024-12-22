package com.stephenhu.artistichorizons.controller;

import com.stephenhu.artistichorizons.pojo.Figures;
import com.stephenhu.artistichorizons.service.FiguresService;
import com.stephenhu.artistichorizons.utils.DateUtil;
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
 * @date 2024-12-11 1:41:21
 * @description: FiguresController
 */
@RestController
@RequestMapping("/api/figures")
@Tag(name = "Controller:Figures", description = "The Figures API")
public class FiguresController {

    @Autowired
    private FiguresService figuresService;

    @Operation(summary = "FiguresInsertAPI")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "success"),
            @ApiResponse(responseCode = "400", description = "stop"),
            @ApiResponse(responseCode = "401", description = "error"),
            @ApiResponse(responseCode = "402", description = "loser")
    })
    @PostMapping("/insert")
    public ResultUtil<Integer> insertFigure(
            @Parameter(description = "The name of the figure", required = true, example = "The figure name")
            @RequestParam String figureName,
            @Parameter(description = "The birth date of the figure", required = true, example = "The figure birth date")
            @RequestParam String birthDate,
            @Parameter(description = "The death date of the figure", required = true, example = "The figure death date")
            @RequestParam String deathDate,
            @Parameter(description = "The description of the figure", required = true, example = "The figure description")
            @RequestParam String description,
            @Parameter(description = "ID of the city the figure was born in", required = true, example = "565760015601664")
            @RequestParam long cityId,
            @Parameter(description = "ID of the event the figure was involved in", required = true, example = "565760015601664")
            @RequestParam long eventId) {
        return figuresService.insert(figureName, DateUtil.parseDate(birthDate), DateUtil.parseDate(deathDate), description, cityId, eventId);
    }


    @Operation(summary = "FiguresDeleteAPI")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "success"),
            @ApiResponse(responseCode = "400", description = "stop"),
            @ApiResponse(responseCode = "401", description = "error"),
            @ApiResponse(responseCode = "402", description = "loser")
    })
    @DeleteMapping("/delete")
    public ResultUtil<Integer> delById(
            @Parameter(description = "ID of the figure to delete", required = true, example = "565760015601664")
            @RequestParam long figureId) {
        return figuresService.delById(figureId);
    }

    @Operation(summary = "FiguresSelectAllAPI")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "success"),
            @ApiResponse(responseCode = "400", description = "stop"),
            @ApiResponse(responseCode = "401", description = "error"),
            @ApiResponse(responseCode = "402", description = "loser")
    })
    @GetMapping("/selectAll")
    public ResultUtil<List<Figures>> selectAllFigures() {
        return figuresService.selectAll();
    }

    @Operation(summary = "FiguresSelectAPI")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "success"),
            @ApiResponse(responseCode = "400", description = "stop"),
            @ApiResponse(responseCode = "401", description = "error"),
            @ApiResponse(responseCode = "402", description = "loser")
    })
    @GetMapping("/select")
    public ResultUtil<Figures> selectFigure(
            @Parameter(description = "ID of the figure to select", required = true, example = "565760015601664")
            @RequestParam long figureId) {
        return figuresService.selectById(figureId);
    }

    @Operation(summary = "FiguresUpdateAPI")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "success"),
            @ApiResponse(responseCode = "400", description = "stop"),
            @ApiResponse(responseCode = "401", description = "error"),
            @ApiResponse(responseCode = "402", description = "loser")
    })
    @PutMapping("/update")
    public ResultUtil<Integer> updateFigure(
            @Parameter(description = "ID of the figure to update", required = true, example = "565760015601664")
            @RequestParam long figureId,

            @Parameter(description = "The name of the figure", required = true, example = "The figure name")
            @RequestParam String figureName,

            @Parameter(description = "The birth date of the figure", required = true, example = "The figure birth date")
            @RequestParam String birthDate,

            @Parameter(description = "The death date of the figure", required = true, example = "The figure death date")
            @RequestParam String deathDate,

            @Parameter(description = "The description of the figure", required = true, example = "The figure description")
            @RequestParam String description,

            @Parameter(description = "ID of the city the figure was born in", required = true, example = "565760015601664")
            @RequestParam long cityId,

            @Parameter(description = "ID of the event the figure was involved in", required = true, example = "565760015601664")
            @RequestParam long eventId) {
        return figuresService.updateById(figureId, figureName, DateUtil.parseDate(birthDate), DateUtil.parseDate(deathDate), description, cityId, eventId);
    }
}
