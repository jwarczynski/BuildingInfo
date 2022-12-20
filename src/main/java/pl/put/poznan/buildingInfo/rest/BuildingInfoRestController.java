package pl.put.poznan.buildingInfo.rest;

import lombok.EqualsAndHashCode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;
import pl.put.poznan.buildingInfo.dto.BuildingRequest;
import pl.put.poznan.buildingInfo.logic.locations.Building;
import pl.put.poznan.buildingInfo.logic.visitors.AreaVisitor;
import pl.put.poznan.buildingInfo.logic.visitors.CubatureVisitor;
import pl.put.poznan.buildingInfo.logic.visitors.LightVisitor;
import pl.put.poznan.buildingInfo.mapper.BuildingMapper;

import java.util.HashMap;
import java.util.Map;

@EqualsAndHashCode
@RestController()
@RequestMapping(value = "/api/v1/", produces = "application/json")
public class BuildingInfoRestController {

    private static final Logger logger = LoggerFactory.getLogger(BuildingInfoRestController.class);

    @PostMapping("/area/building")
    public Map<String, Float> getBuildingArea(@RequestBody BuildingRequest buildingRequest) {
        logger.info("requested for area of building with id {}", buildingRequest.getBuildingId());
        Building building = BuildingMapper.toModel(buildingRequest);

        Float result = building.accept(new AreaVisitor());

        Map<String, Float> response = new HashMap<>();
        response.put("result", result);
        return response;
    }

    @PostMapping("/area/building/floor/{id}")
    public Map<String, Float> getFloorArea(@PathVariable int id, @RequestBody BuildingRequest buildingRequest) {
        logger.info("requested for area of floor with id {}", id);
        Building building = BuildingMapper.toModel(buildingRequest);

        Float result = building.getFloors().stream().filter(floor -> floor.getId() == id).
                findFirst().get().accept(new AreaVisitor());

        Map<String, Float> response = new HashMap<>();
        response.put("result", result);
        return response;
    }

    @PostMapping("/area/building/floor/{floorId}/room/{roomId}")
    public Map<String, Float> getRoomArea(@PathVariable int floorId, @PathVariable int roomId, @RequestBody BuildingRequest buildingRequest) {
        logger.info("requested for area of room with id {} on the floor with id {}", roomId,  floorId);
        Building building = BuildingMapper.toModel(buildingRequest);

        Float result = building.getFloors().stream().filter(floor -> floor.getId() == floorId).findFirst().get().getRooms()
                .stream().filter(room -> room.getId() == roomId).findFirst().get()
                .accept(new AreaVisitor());

        Map<String, Float> response = new HashMap<>();
        response.put("result", result);
        return response;
    }

    @PostMapping("/volume/building")
    public Map<String, Float> getBuildingVolume(@RequestBody BuildingRequest buildingRequest) {
        logger.info("requested for volume of building with id {}", buildingRequest.getBuildingId());
        Building building = BuildingMapper.toModel(buildingRequest);

        Float result = building.accept(new CubatureVisitor());

        Map<String, Float> response = new HashMap<>();
        response.put("result", result);
        return response;
    }

    @PostMapping("/volume/building/floor/{id}")
    public Map<String, Float> getFloorVolume(@PathVariable int id, @RequestBody BuildingRequest buildingRequest) {
        logger.info("requested for volume of floor with id {}", id);

        Building building = BuildingMapper.toModel(buildingRequest);


        Float result = building.getFloors().stream().filter(floor -> floor.getId() == id).findFirst()
                .get().accept(new CubatureVisitor());

        Map<String, Float> response = new HashMap<>();
        response.put("result", result);
        return response;
    }

    @PostMapping("/volume/building/floor/{floorId}/room/{roomId}")
    public Map<String, Float> getRoomVolume(@PathVariable int floorId, @PathVariable int roomId, @RequestBody BuildingRequest buildingRequest) {
        logger.info("requested for volume of room with id {} on the floor with id {}", roomId, floorId);
        Building building = BuildingMapper.toModel(buildingRequest);

        Float result = building.getFloors().stream().filter(floor -> floor.getId() == floorId).findFirst().get().getRooms()
                .stream().filter(room -> room.getId() == roomId).findFirst().get()
                .accept(new CubatureVisitor());

        Map<String, Float> response = new HashMap<>();
        response.put("result", result);
        return response;
    }

    @PostMapping("/light/building")
    public Map<String, Float> getBuildingLightPower(@RequestBody BuildingRequest buildingRequest) {
        logger.info("requested for light power of building with id {}", buildingRequest.getBuildingId());

        Building building = BuildingMapper.toModel(buildingRequest);

        Float result = building.accept(new LightVisitor());

        Map<String, Float> response = new HashMap<>();
        response.put("result", result);
        return response;
    }

    @PostMapping("/light/building/floor/{id}")
    public Map<String, Float> getFloorLightPower(@PathVariable int id, @RequestBody BuildingRequest buildingRequest) {
        logger.info("requested for light power of floor with id {}", id);

        Building building = BuildingMapper.toModel(buildingRequest);

        Float result = building.getFloors().stream().filter(floor -> floor.getId() == id).findFirst().get().accept(new LightVisitor());

        Map<String, Float> response = new HashMap<>();
        response.put("result", result);
        return response;
    }

    @PostMapping("/light/building/floor/{floorId}/room/{roomId}")
    public Map<String, Float> getRoomLightPower(@PathVariable int floorId, @PathVariable int roomId, @RequestBody BuildingRequest buildingRequest) {
        logger.info("requested for volume of room with id {} on the floor with id {}", roomId, floorId);

        Building building = BuildingMapper.toModel(buildingRequest);
        Float result = building.getFloors().stream().filter(floor -> floor.getId() == floorId).findFirst().get().getRooms()
                .stream().filter(room -> room.getId() == roomId).findFirst().get()
                .accept(new LightVisitor());

        Map<String, Float> response = new HashMap<>();
        response.put("result", result);
        return response;
    }
}
