package pl.put.poznan.buildingInfo.rest;

import lombok.EqualsAndHashCode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;
import pl.put.poznan.buildingInfo.dto.BuildingRequest;
import pl.put.poznan.buildingInfo.logic.locations.Building;
import pl.put.poznan.buildingInfo.logic.locations.Floor;
import pl.put.poznan.buildingInfo.logic.locations.Room;
import pl.put.poznan.buildingInfo.logic.visitors.AreaVisitor;
import pl.put.poznan.buildingInfo.logic.visitors.CubatureVisitor;
import pl.put.poznan.buildingInfo.logic.visitors.LightVisitor;
import pl.put.poznan.buildingInfo.logic.visitors.Visitor;
import pl.put.poznan.buildingInfo.mapper.BuildingMapper;

import java.util.HashSet;
import java.util.Set;

@EqualsAndHashCode
@RestController()
@RequestMapping(value = "/api/v1/", produces = "application/json")
public class BuildingInfoRestController {

    private static final Logger logger = LoggerFactory.getLogger(BuildingInfoRestController.class);

    @PostMapping("/area/building")
    public Float getBuildingArea(@RequestBody BuildingRequest buildingRequest) {
        //logger.info(id);
        Building building = BuildingMapper.toModel(buildingRequest);

        return building.accept(new AreaVisitor());
    }

    @PostMapping("/area/building/floor/{id}")
    public Float getFloorArea(@PathVariable int id, @RequestBody BuildingRequest buildingRequest) {
        //logger.info(id);

        Building building = BuildingMapper.toModel(buildingRequest);

        return building.getFloors().stream().filter(floor -> floor.getId() == id).findFirst().get().accept(new AreaVisitor());
    }

    @PostMapping("/area/building/floor/{floorId}/room/{roomId}")
    public Float getRoomArea(@PathVariable int floorId, @PathVariable int roomId, @RequestBody BuildingRequest buildingRequest) {
        //logger.info(id);

        Building building = BuildingMapper.toModel(buildingRequest);

        return building.getFloors().stream().filter(floor -> floor.getId() == floorId).findFirst().get().getRooms()
                .stream().filter(room -> room.getId() == roomId).findFirst().get()
                .accept(new AreaVisitor());
    }

    @PostMapping("/volume/building")
    public Float getBuildingVolume(@RequestBody BuildingRequest buildingRequest) {
        //logger.info(id);
        Building building = BuildingMapper.toModel(buildingRequest);

        return building.accept(new CubatureVisitor());
    }

    @PostMapping("/volume/building/floor/{id}")
    public Float getFloorVolume(@PathVariable int id, @RequestBody BuildingRequest buildingRequest) {
        //logger.info(id);

        Building building = BuildingMapper.toModel(buildingRequest);

        return building.getFloors().stream().filter(floor -> floor.getId() == id).findFirst().get().accept(new CubatureVisitor());
    }

    @PostMapping("/volume/building/floor/{floorId}/room/{roomId}")
    public Float getRoomVolume(@PathVariable int floorId, @PathVariable int roomId, @RequestBody BuildingRequest buildingRequest) {
        //logger.info(id);

        Building building = BuildingMapper.toModel(buildingRequest);

        return building.getFloors().stream().filter(floor -> floor.getId() == floorId).findFirst().get().getRooms()
                .stream().filter(room -> room.getId() == roomId).findFirst().get()
                .accept(new CubatureVisitor());
    }

    @PostMapping("/light/building")
    public Float getBuildingLightPower(@RequestBody BuildingRequest buildingRequest) {
        //logger.info(id);

        Building building = BuildingMapper.toModel(buildingRequest);

        return building.accept(new LightVisitor());
    }

    @PostMapping("/light/building/floor/{id}")
    public Float getFloorLightPower(@PathVariable int id, @RequestBody BuildingRequest buildingRequest) {
        //logger.info(id);

        Building building = BuildingMapper.toModel(buildingRequest);

        return building.getFloors().stream().filter(floor -> floor.getId() == id).findFirst().get().accept(new LightVisitor());
    }

    @PostMapping("/light/building/floor/{floorId}/room/{roomId}")
    public Float getRoomLightPower(@PathVariable int floorId, @PathVariable int roomId, @RequestBody BuildingRequest buildingRequest) {
        //logger.info(id);

        Building building = BuildingMapper.toModel(buildingRequest);

        return building.getFloors().stream().filter(floor -> floor.getId() == floorId).findFirst().get().getRooms()
                .stream().filter(room -> room.getId() == roomId).findFirst().get()
                .accept(new LightVisitor());
    }
}
