package com.getir.controller;

import com.getir.constants.ApiEndPoints;
import com.getir.model.response.CustomerStatisticsResponse;
import com.getir.service.StatisticsService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.SwaggerDefinition;
import io.swagger.annotations.Tag;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = ApiEndPoints.STATISTICS_API, produces = MediaType.APPLICATION_JSON_VALUE,
        consumes = MediaType.APPLICATION_JSON_VALUE)
@Api
@SwaggerDefinition(tags = {
        @Tag(name = "statistics-api", description = "Statistics Api")
})
public class StatisticsController {

    private static final Logger logger = LoggerFactory.getLogger(StatisticsController.class);

    private final StatisticsService statisticsService;

    public StatisticsController(StatisticsService statisticsService) {
        this.statisticsService = statisticsService;
    }

    @GetMapping(value = "/{id}", consumes = MediaType.ALL_VALUE)
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation(value = "Get Customer Statistics", notes = "Get Customer Statistics")
    public CustomerStatisticsResponse getCustomerStatistics(@PathVariable int id){
        logger.info("Get customer statistics by customer id {}", id);
        return statisticsService.getCustomerStatistics(id);
    }
}
