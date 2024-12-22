package com.stephenhu.artistichorizons.controller;

import com.stephenhu.artistichorizons.pojo.Collections;
import com.stephenhu.artistichorizons.service.CollectionsService;
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
 * @date 2024-12-11 0:38:16
 * @description: CollectionsController
 */
@RestController
@RequestMapping("/api/collections")
@Tag(name = "Controller:Collections", description = "The Collections API")
public class CollectionsController {

    @Autowired
    private CollectionsService collectionsService;

    @Operation(summary = "CollectionsAPI")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "success"),
            @ApiResponse(responseCode = "400", description = "stop"),
            @ApiResponse(responseCode = "401", description = "error"),
            @ApiResponse(responseCode = "402", description = "loser"),
    })
    @PostMapping("/insert")
    public ResultUtil<Integer> insertCollection(
            @Parameter(description = "The name of the collection", required = true, example = "The collection name")
            @RequestParam String collectionName,

            @Parameter(description = "The description of the collection", required = true, example = "The collection description")
            @RequestParam String description,

            @Parameter(description = "The create time of the collection", required = true, example = "2024-12-11")
            @RequestParam String createTime,

            @Parameter(description = "The ID of the city where the collection is located", required = true, example = "565760015601664")
            @RequestParam long cityId) {
        return collectionsService.insert(collectionName, description, DateUtil.parseDate(createTime), cityId);
    }

    @Operation(summary = "CollectionsDeleteAPI")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "success"),
            @ApiResponse(responseCode = "400", description = "stop"),
            @ApiResponse(responseCode = "401", description = "error"),
            @ApiResponse(responseCode = "402", description = "loser"),
    })
    @DeleteMapping("/delete")
    public ResultUtil<Integer> deleteCollection(
            @Parameter(description = "ID of the collection to delete", required = true, example = "565760015601664")
            @RequestParam long collectionId) {
        return collectionsService.delById(collectionId);
    }

    @Operation(summary = "CollectionsSelectAPI")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "success"),
            @ApiResponse(responseCode = "400", description = "stop"),
            @ApiResponse(responseCode = "401", description = "error"),
            @ApiResponse(responseCode = "402", description = "loser"),
    })
    @GetMapping("/select")
    public ResultUtil<Collections> selectCollection(
            @Parameter(description = "ID of the collection to select", required = true, example = "565760015601664")
            @RequestParam long collectionId) {
        return collectionsService.selectById(collectionId);
    }

    @Operation(summary = "CollectionsSelectAllAPI")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "success"),
            @ApiResponse(responseCode = "400", description = "stop"),
            @ApiResponse(responseCode = "401", description = "error"),
            @ApiResponse(responseCode = "402", description = "loser"),
    })
    @GetMapping("/selectAll")
    public ResultUtil<List<Collections>> selectAllCollections() {
        return collectionsService.selectAll();
    }

    @Operation(summary = "CollectionsUpdateAPI")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "success"),
            @ApiResponse(responseCode = "400", description = "stop"),
            @ApiResponse(responseCode = "401", description = "error"),
            @ApiResponse(responseCode = "402", description = "loser"),
    })
    @PutMapping("/update")
    public ResultUtil<Integer> updateCollection(
            @Parameter(description = "ID of the collection to update", required = true, example = "565760015601664")
            @RequestParam long collectionId,

            @Parameter(description = "The name of the collection", required = true, example = "The collection name")
            @RequestParam String collectionName,

            @Parameter(description = "The description of the collection", required = true, example = "The collection description")
            @RequestParam String description,

            @Parameter(description = "The create time of the collection", required = true, example = "2024-12-11")
            @RequestParam String createTime,

            @Parameter(description = "The ID of the city where the collection is located", required = true, example = "565760015601664")
            @RequestParam long cityId) {
        return collectionsService.updateById(collectionId, collectionName, description, DateUtil.parseDate(createTime), cityId);
    }

}
