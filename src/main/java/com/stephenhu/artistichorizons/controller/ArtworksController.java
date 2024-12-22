package com.stephenhu.artistichorizons.controller;

import com.stephenhu.artistichorizons.pojo.Artworks;
import com.stephenhu.artistichorizons.service.ArtworksService;
import com.stephenhu.artistichorizons.utils.DateUtil;
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
 * @date 2024-12-11 0:11:37
 * @description: ArtworksController
 */
@RestController
@RequestMapping("/api/artworks")
@Tag(name = "Controller:Artworks", description = "The Artworks API")
public class ArtworksController {

    @Autowired
    private ArtworksService artworksService;

    @Operation(summary = "ArtworksInsertAPI")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "success"),
            @ApiResponse(responseCode = "400", description = "stop"),
            @ApiResponse(responseCode = "401", description = "error"),
            @ApiResponse(responseCode = "402", description = "loser"),
    })
    @PostMapping("/insert")
    public ResultUtil<Integer> insertArtwork(
            @Parameter(description = "The name of the artwork", required = true, example = "Sunrise")
            @RequestParam String artworkName,

            @Parameter(description = "The creation date of the artwork (format: yyyy-MM-dd)", required = true, example = "2023-10-01")
            @RequestParam String createTime,

            @Parameter(description = "Description of the artwork", required = true, example = "A beautiful sunrise painting")
            @RequestParam String description,

            @Parameter(description = "ID of the material used in the artwork", required = true, example = "0")
            @RequestParam long materialId,

            @Parameter(description = "ID of the color used in the artwork", required = true, example = "0")
            @RequestParam long colorId,

            @Parameter(description = "ID of the artist who created the artwork", required = true, example = "0")
            @RequestParam long artistId,

            @Parameter(description = "ID of the event associated with the artwork", required = true, example = "0")
            @RequestParam long eventId,

            @Parameter(description = "ID of the collection where the artwork is stored", required = true, example = "0")
            @RequestParam long collectionId,

            @Parameter(description = "ID of the theme associated with the artwork", required = true, example = "0")
            @RequestParam long themeId) {
        try {
            return artworksService.insert(artworkName, DateUtil.parseDate(createTime), description, materialId, colorId, artistId, eventId, collectionId, themeId);
        } catch (Exception e) {
            return ResultUtil.fail(400, e.getMessage());
        }
    }

    @Operation(summary = "ArtworksDeleteAPI")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "success"),
            @ApiResponse(responseCode = "400", description = "stop"),
            @ApiResponse(responseCode = "401", description = "error"),
            @ApiResponse(responseCode = "402", description = "loser"),
    })
    @DeleteMapping("/delete")
    public ResultUtil<Integer> deleteArtwork(
            @Parameter(description = "ID of the artwork to delete", required = true, example = "565760015601664")
            @RequestParam long artworkId) {
        try {
            return artworksService.delById(artworkId);
        } catch (Exception e) {
            return ResultUtil.fail(400, e.getMessage());
        }
    }

    @Operation(summary = "ArtworksSelectAPI")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "success"),
            @ApiResponse(responseCode = "400", description = "stop"),
            @ApiResponse(responseCode = "401", description = "error"),
            @ApiResponse(responseCode = "402", description = "loser"),
    })
    @GetMapping("/select")
    public ResultUtil<Artworks> selectArtwork(
            @Parameter(description = "ID of the artwork to select", required = true, example = "565760015601664")
            @RequestParam long artworkId) {
        try {
            return artworksService.selectById(artworkId);
        } catch (Exception e) {
            return ResultUtil.fail(400, e.getMessage());
        }
    }

    @Operation(summary = "ArtworksSelectAllAPI")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "success"),
            @ApiResponse(responseCode = "400", description = "stop"),
            @ApiResponse(responseCode = "401", description = "error"),
            @ApiResponse(responseCode = "402", description = "loser"),
    })
    @GetMapping("/selectAll")
    public ResultUtil<List<Artworks>> selectAllArtworks() {
        try {
            return artworksService.selectAll();
        } catch (Exception e) {
            return ResultUtil.fail(400, e.getMessage());
        }
    }

    @Operation(summary = "ArtworksUpdateAPI")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "success"),
            @ApiResponse(responseCode = "400", description = "stop"),
            @ApiResponse(responseCode = "401", description = "error"),
            @ApiResponse(responseCode = "402", description = "loser"),
    })
    @PutMapping("/update")
    public ResultUtil<Integer> updateArtwork(
            @Parameter(description = "ID of the artwork to update", required = true, example = "565760015601664")
            @RequestParam long artworkId,

            @Parameter(description = "The name of the artwork", required = true, example = "Sunrise")
            @RequestParam String artworkName,

            @Parameter(description = "The creation date of the artwork (format: yyyy-MM-dd)", required = true, example = "2023-10-01")
            @RequestParam String createTime,

            @Parameter(description = "Description of the artwork", required = true, example = "A beautiful sunrise painting")
            @RequestParam String description,

            @Parameter(description = "ID of the material used in the artwork", required = true, example = "0")
            @RequestParam long materialId,

            @Parameter(description = "ID of the color used in the artwork", required = true, example = "0")
            @RequestParam long colorId,

            @Parameter(description = "ID of the artist who created the artwork", required = true, example = "0")
            @RequestParam long artistId,

            @Parameter(description = "ID of the event associated with the artwork", required = true, example = "0")
            @RequestParam long eventId,

            @Parameter(description = "ID of the collection where the artwork is stored", required = true, example = "0")
            @RequestParam long collectionId,

            @Parameter(description = "ID of the theme associated with the artwork", required = true, example = "0")
            @RequestParam long themeId) {
        try {
            return artworksService.updateById(artworkId, artworkName, DateUtil.parseDate(createTime), description, materialId, colorId, artistId, eventId, collectionId, themeId);
        } catch (Exception e) {
            return ResultUtil.fail(400, e.getMessage());
        }
    }

}
