package com.stephenhu.artistichorizons.controller;

import com.stephenhu.artistichorizons.pojo.Materials;
import com.stephenhu.artistichorizons.service.MaterialsService;
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
 * @date 2024-12-11 8:41:21
 * @description: MaterialsController
 */
@RestController
@RequestMapping("/api/materials")
@Tag(name = "Controller:Materials", description = "The Materials API")
public class MaterialsController {

    @Autowired
    private MaterialsService materialsService;

    @Operation(summary = "MaterialsInsertAPI")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "success"),
            @ApiResponse(responseCode = "400", description = "stop"),
            @ApiResponse(responseCode = "401", description = "error"),
            @ApiResponse(responseCode = "402", description = "loser")
    })
    @PostMapping("/insert")
    public ResultUtil<Integer> insert(
            @Parameter(description = "Name of the material", required = true, example = "The material name")
            @RequestParam String materialName) {
        return materialsService.insert(materialName);
    }

    @Operation(summary = "MaterialsDeleteAPI")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "success"),
            @ApiResponse(responseCode = "400", description = "stop"),
            @ApiResponse(responseCode = "401", description = "error"),
            @ApiResponse(responseCode = "402", description = "loser")
    })
    @DeleteMapping("/delete")
    public ResultUtil<Integer> delById(
            @Parameter(description = "ID of the material to delete", required = true, example = "565760015601664")
            @RequestParam long materialId) {
        return materialsService.delById(materialId);
    }

    @Operation(summary = "MaterialsSelectAPI")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "success"),
            @ApiResponse(responseCode = "400", description = "stop"),
            @ApiResponse(responseCode = "401", description = "error"),
            @ApiResponse(responseCode = "402", description = "loser")
    })
    @GetMapping("/select")
    public ResultUtil<Materials> selectMaterial(
            @Parameter(description = "ID of the material to select", required = true, example = "565760015601664")
            @RequestParam long materialId) {
        return materialsService.selectById(materialId);
    }

    @Operation(summary = "MaterialsSelectAllAPI")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "success"),
            @ApiResponse(responseCode = "400", description = "stop"),
            @ApiResponse(responseCode = "401", description = "error"),
            @ApiResponse(responseCode = "402", description = "loser")
    })
    @GetMapping("/selectAll")
    public ResultUtil<List<Materials>> selectAllMaterials() {
        return materialsService.selectAll();
    }

    @Operation(summary = "MaterialsUpdateAPI")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "success"),
            @ApiResponse(responseCode = "400", description = "stop"),
            @ApiResponse(responseCode = "401", description = "error"),
            @ApiResponse(responseCode = "402", description = "loser")
    })
    @PutMapping("/update")
    public ResultUtil<Integer> updateMaterial(
            @Parameter(description = "ID of the material to update", required = true, example = "565760015601664")
            @RequestParam long materialId,
            @Parameter(description = "Name of the material", required = true, example = "The material name")
            @RequestParam String materialName) {
        return materialsService.updateById(materialId, materialName);
    }
}