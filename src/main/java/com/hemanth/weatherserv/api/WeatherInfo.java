package com.hemanth.weatherserv.api;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@RestController
@RequestMapping("/v1/weather")
@Api(value = "Weather Information", description = "Shows Weather Information", tags = "weather")
public interface WeatherInfo {

    @Consumes({MediaType.APPLICATION_JSON })
    @Produces({ MediaType.APPLICATION_JSON })
    @ApiOperation(value = "Gives Weather Information")
    @ApiResponses(
            value = {
                    @ApiResponse(code = 200, message = "Success"),
                    @ApiResponse(code = 500, message = "Bad Request")
            }
    )
    @RequestMapping(method = RequestMethod.POST, value = "/search")
    public <T> T getWeatherInfo(@RequestBody String searchJson);
}
