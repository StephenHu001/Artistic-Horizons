package com.stephenhu.artistichorizons.controller;

import com.stephenhu.artistichorizons.pojo.Imgs;
import com.stephenhu.artistichorizons.service.ImgsService;
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
 * @date 2024-12-11 8:30:21
 * @description: ImgsController
 */
@RestController
@RequestMapping("/api/imgs")
@Tag(name = "Controller:Imgs", description = "The Imgs API")
public class ImgsController {
    @Autowired
    private ImgsService imgsService;

    @Operation(summary = "ImgsInsertAPI")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "success"),
            @ApiResponse(responseCode = "400", description = "stop"),
            @ApiResponse(responseCode = "401", description = "error"),
            @ApiResponse(responseCode = "402", description = "loser")
    })
    @PostMapping("/insert")
    public ResultUtil<Integer> insert(
            @Parameter(description = "Path of the image", required = true, example = "The image path")
            @RequestParam String imgPath,
            @Parameter(description = "ID of the color of the image", required = true, example = "565760015601664")
            @RequestParam long colorId,
            @Parameter(description = "ID of the material of the image", required = true, example = "565760015601664")
            @RequestParam long materialId,
            @Parameter(description = "ID of the country of the image", required = true, example = "565760015601664")
            @RequestParam long countryId,
            @Parameter(description = "ID of the district of the image", required = true, example = "565760015601664")
            @RequestParam long districtId,
            @Parameter(description = "ID of the city of the image", required = true, example = "565760015601664")
            @RequestParam long cityId,
            @Parameter(description = "ID of the collection of the image", required = true, example = "565760015601664")
            @RequestParam long collectionId,
            @Parameter(description = "ID of the figure of the image", required = true, example = "565760015601664")
            @RequestParam long figureId,
            @Parameter(description = "ID of the artist of the image", required = true, example = "565760015601664")
            @RequestParam long artistId,
            @Parameter(description = "ID of the theme of the image", required = true, example = "565760015601664")
            @RequestParam long themeId,
            @Parameter(description = "ID of the event of the image", required = true, example = "565760015601664")
            @RequestParam long eventId,
            @Parameter(description = "ID of the artwork of the image", required = true, example = "565760015601664")
            @RequestParam long artworkId) {
        return imgsService.insert(imgPath, colorId, materialId, countryId, districtId, cityId, collectionId, figureId, artistId, themeId, eventId, artworkId);
    }

    @Operation(summary = "ImgsDeleteAPI")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "success"),
            @ApiResponse(responseCode = "400", description = "stop"),
            @ApiResponse(responseCode = "401", description = "error"),
            @ApiResponse(responseCode = "402", description = "loser")
    })
    @DeleteMapping("/delete")
    public ResultUtil<Integer> delById(
            @Parameter(description = "ID of the image to delete", required = true, example = "565760015601664")
            @RequestParam long imgId) {
        return imgsService.delById(imgId);
    }

    @Operation(summary = "ImgsSelectAllAPI")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "success"),
            @ApiResponse(responseCode = "400", description = "stop"),
            @ApiResponse(responseCode = "401", description = "error"),
            @ApiResponse(responseCode = "402", description = "loser")
    })
    @GetMapping("/selectAll")
    public ResultUtil<List<Imgs>> selectAllImgs() {
        return imgsService.selectAll();
    }

    @Operation(summary = "ImgsSelectAPI")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "success"),
            @ApiResponse(responseCode = "400", description = "stop"),
            @ApiResponse(responseCode = "401", description = "error"),
            @ApiResponse(responseCode = "402", description = "loser")
    })
    @GetMapping("/select")
    public ResultUtil<Imgs> selectImg(
            @Parameter(description = "ID of the image to select", required = true, example = "565760015601664")
            @RequestParam long imgId) {
        return imgsService.selectById(imgId);
    }

    @Operation(summary = "ImgsUpdateAPI")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "success"),
            @ApiResponse(responseCode = "400", description = "stop"),
            @ApiResponse(responseCode = "401", description = "error"),
            @ApiResponse(responseCode = "402", description = "loser")
    })
    @PutMapping("/update")
    public ResultUtil<Integer> updateImg(
            @Parameter(description = "ID of the image to update", required = true, example = "565760015601664")
            @RequestParam long imgId,
            @Parameter(description = "Path of the image", required = true, example = "The image path")
            @RequestParam String imgPath,
            @Parameter(description = "ID of the color of the image", required = true, example = "565760015601664")
            @RequestParam long colorId,
            @Parameter(description = "ID of the material of the image", required = true, example = "565760015601664")
            @RequestParam long materialId,
            @Parameter(description = "ID of the country of the image", required = true, example = "565760015601664")
            @RequestParam long countryId,
            @Parameter(description = "ID of the district of the image", required = true, example = "565760015601664")
            @RequestParam long districtId,
            @Parameter(description = "ID of the city of the image", required = true, example = "565760015601664")
            @RequestParam long cityId,
            @Parameter(description = "ID of the collection of the image", required = true, example = "565760015601664")
            @RequestParam long collectionId,
            @Parameter(description = "ID of the figure of the image", required = true, example = "565760015601664")
            @RequestParam long figureId,
            @Parameter(description = "ID of the artist of the image", required = true, example = "565760015601664")
            @RequestParam long artistId,
            @Parameter(description = "ID of the theme of the image", required = true, example = "565760015601664")
            @RequestParam long themeId,
            @Parameter(description = "ID of the event of the image", required = true, example = "565760015601664")
            @RequestParam long eventId,
            @Parameter(description = "ID of the artwork of the image", required = true, example = "565760015601664")
            @RequestParam long artworkId){
        return imgsService.updateById(imgId, imgPath, colorId, materialId, countryId, districtId, cityId, collectionId, figureId, artistId, themeId, eventId, artworkId);
    }


}
