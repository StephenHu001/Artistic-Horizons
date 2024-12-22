package com.stephenhu.artistichorizons.controller;

import com.stephenhu.artistichorizons.pojo.Artists;
import com.stephenhu.artistichorizons.service.ArtistsService;
import com.stephenhu.artistichorizons.utils.DateUtil;
import com.stephenhu.artistichorizons.utils.ResultUtil;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Stephen Hu
 * @date 2024-12-11 0:10:55
 * @description: ArtistsController
 */
@RestController
@RequestMapping("/api/artists")
@Tag(name = "Controller:Artists", description = "The Artists API")
public class ArtistsController {

    @Autowired
    private ArtistsService artistsService;

    @Operation(summary = "ArtistsInsertAPI")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "success"),
            @ApiResponse(responseCode = "400", description = "stop"),
            @ApiResponse(responseCode = "401", description = "error"),
            @ApiResponse(responseCode = "402", description = "loser"),
    })
    @PostMapping("/insert")
    public ResultUtil<Integer> insertArtist(

            @Parameter(description = "The name of the artist", required = false, example = "Stephen Hu")
            @RequestParam(value = "artistName") String artistName,

            @Parameter(description = "The birth date of the artist (format: yyyy-MM-dd)", required = true, example = "2003-10-28")
            @RequestParam String birthDate,

            @Parameter(description = "The death date of the artist (format: yyyy-MM-dd)", required = true, example = "2024-12-10")
            @RequestParam String deathDate,

            @Parameter(description = "Description of the artist", required = true, example = "A soft engineer artist from China, born in 2003 and died in 2024. Died due to lack of sleep at the age of 21")
            @RequestParam String description,

            @Parameter(description = "ID of the city associated with the artist", required = true, example = "0")
            @RequestParam long cityId,

            @Parameter(description = "ID of the theme associated with the artist", required = true, example = "0")
            @RequestParam long themeId,

            @Parameter(description = "ID of the event associated with the artist", required = true, example = "0")
            @RequestParam long eventId) {
        try {
            return artistsService.insert(artistName, DateUtil.parseDate(birthDate), DateUtil.parseDate(deathDate), description, cityId, themeId, eventId);
        } catch (Exception e) {
            return ResultUtil.fail(400, e.getMessage());
        }
    }


    @Operation(summary = "ArtistsDeleteAPI")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "success"),
            @ApiResponse(responseCode = "400", description = "stop"),
            @ApiResponse(responseCode = "401", description = "error"),
            @ApiResponse(responseCode = "402", description = "loser"),
    })
    @DeleteMapping("/delete")
    public ResultUtil<Integer> deleteArtist(

            @Parameter(description = "ID of the artist to delete", required = true, example = "565760015601664")
            @RequestParam long artistId) {
        try {
            return artistsService.delById(artistId);
        } catch (Exception e) {
            return ResultUtil.fail(400, e.getMessage());
        }
    }

    @Operation(summary = "ArtistsSelectAPI")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "success"),
            @ApiResponse(responseCode = "400", description = "stop"),
            @ApiResponse(responseCode = "401", description = "error"),
            @ApiResponse(responseCode = "402", description = "loser"),
    })
    @GetMapping("/select")
    public ResultUtil<Artists> selectArtist(
            @Parameter(description = "ID of the artist to select", required = true, example = "565760015601664")
            @RequestParam long artistId) {
        try {
            return artistsService.selectById(artistId);
        } catch (Exception e) {
            return ResultUtil.fail(400, e.getMessage());
        }
    }

    @Operation(summary = "ArtistsSelectAllAPI")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "success"),
            @ApiResponse(responseCode = "400", description = "stop"),
            @ApiResponse(responseCode = "401", description = "error"),
            @ApiResponse(responseCode = "402", description = "loser"),
    })
    @GetMapping("/selectAll")
    public ResultUtil<List<Artists>> selectAllArtists() {
        try {
            return artistsService.selectAll();
        } catch (Exception e) {
            return ResultUtil.fail(400, e.getMessage());
        }
    }

    @Operation(summary = "ArtistsUpdateAPI")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "success"),
            @ApiResponse(responseCode = "400", description = "stop"),
            @ApiResponse(responseCode = "401", description = "error"),
            @ApiResponse(responseCode = "402", description = "loser"),
    })
    @PutMapping("/update")
    public ResultUtil<Integer> updateArtist(

            @Parameter(description = "ID of the artist to update", required = true, example = "564320979259392")
            @RequestParam long artistId,

            @Parameter(description = "New name of the artist", required = true, example = "Stephen Hu")
            @RequestParam String artistName,

            @Parameter(description = "New birth date of the artist (format: yyyy-MM-dd)", required = true, example = "2003-10-28")
            @RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") String birthDate,

            @Parameter(description = "New death date of the artist (format: yyyy-MM-dd)", required = true, example = "2024-12-10")
            @RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") String deathDate,

            @Parameter(description = "New description of the artist", required = true, example = "A soft engineer artist from China, born in 2003 and died in 2024. Died due to lack of sleep at the age of 21")
            @RequestParam String description,

            @Parameter(description = "ID of the new city associated with the artist", required = true, example = "0")
            @RequestParam long cityId,

            @Parameter(description = "ID of the new theme associated with the artist", required = true, example = "0")
            @RequestParam long themeId,

            @Parameter(description = "ID of the new event associated with the artist", required = true, example = "0")
            @RequestParam long eventId) {
        try {
            return artistsService.updateById(artistId, artistName, DateUtil.parseDate(birthDate), DateUtil.parseDate(deathDate), description, cityId, themeId, eventId);
        } catch (Exception e) {
            return ResultUtil.fail(400, e.getMessage());
        }
    }
}
