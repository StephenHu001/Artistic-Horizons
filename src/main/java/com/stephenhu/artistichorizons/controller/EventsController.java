package com.stephenhu.artistichorizons.controller;

import com.stephenhu.artistichorizons.pojo.Events;
import com.stephenhu.artistichorizons.service.EventsService;
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
 * @date 2024-12-11 1:21:21
 * @description: EventsController
 */
@RestController
@RequestMapping("/api/events")
@Tag(name = "Controller:Events", description = "The Events API")
public class EventsController {
    @Autowired
    private EventsService eventsService;

    @Operation(summary = "EventsInsertAPI")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "success"),
            @ApiResponse(responseCode = "400", description = "stop"),
            @ApiResponse(responseCode = "401", description = "error"),
            @ApiResponse(responseCode = "402", description = "loser")
    })
    @PostMapping("/insert")
    public ResultUtil<Integer> insertEvent(
            @Parameter(description = "The name of the event", required = true, example = "The event name")
            @RequestParam String eventName,
            @Parameter(description = "The description of the event", required = true, example = "The event description")
            @RequestParam String description) {
        return eventsService.insert(eventName, description);
    }

    @Operation(summary = "EventsDeleteAPI")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "success"),
            @ApiResponse(responseCode = "400", description = "stop"),
            @ApiResponse(responseCode = "401", description = "error"),
            @ApiResponse(responseCode = "402", description = "loser")
    })
    @DeleteMapping("/delete")
    public ResultUtil<Integer> delById(
            @Parameter(description = "ID of the event to delete", required = true, example = "565760015601664")
            @RequestParam long eventId) {
        return eventsService.delById(eventId);
    }

    @Operation(summary = "EventsSelectAPI")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "success"),
            @ApiResponse(responseCode = "400", description = "stop"),
            @ApiResponse(responseCode = "401", description = "error"),
            @ApiResponse(responseCode = "402", description = "loser")
    })
    @GetMapping("/select")
    public ResultUtil<Events> selectEvent(
            @Parameter(description = "ID of the event to select", required = true, example = "565760015601664")
            @RequestParam long eventId) {
        return eventsService.selectById(eventId);
    }

    @Operation(summary = "EventsSelectAllAPI")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "success"),
            @ApiResponse(responseCode = "400", description = "stop"),
            @ApiResponse(responseCode = "401", description = "error"),
            @ApiResponse(responseCode = "402", description = "loser")
    })
    @GetMapping("/selectAll")
    public ResultUtil<List<Events>> selectAllEvents() {
        return eventsService.selectAll();
    }

    @Operation(summary = "EventsUpdateAPI")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "success"),
            @ApiResponse(responseCode = "400", description = "stop"),
            @ApiResponse(responseCode = "401", description = "error"),
            @ApiResponse(responseCode = "402", description = "loser")
    })
    @PutMapping("/update")
    public ResultUtil<Integer> updateEvent(
            @Parameter(description = "ID of the event to update", required = true, example = "565760015601664")
            @RequestParam long eventId,
            @Parameter(description = "The name of the event", required = true, example = "The event name")
            @RequestParam String eventName,
            @Parameter(description = "The description of the event", required = true, example = "The event description")
            @RequestParam String description) {
        return eventsService.updateById(eventId, eventName, description);
    }
}
