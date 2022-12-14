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
@RequestMapping(value = "/info", produces = "application/json")
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
    public Float getFloorArea(@PathVariable int floorId, @PathVariable int roomId, @RequestBody BuildingRequest buildingRequest) {
        //logger.info(id);

        Building building = BuildingMapper.toModel(buildingRequest);

        return building.getFloors().stream().filter(floor -> floor.getId() == floorId).findFirst().get().getRooms()
                .stream().filter(room -> room.getId() == roomId).findFirst().get()
                .accept(new AreaVisitor());
    }
    //TODO implement calcutaling cube and light
//    @GetMapping("/volume/{id}")
//    public Float getVolume(@PathVariable String id) {
//        logger.info(id);
//
//        Visitor cubatureVisitor = new CubatureVisitor();
//        //Room room = new Room(10, 12f, 30f, 40f);
//
//        return room.accept(cubatureVisitor);
//    }
//
//    @GetMapping("/light/{id}")
//    public Float getLightningPower(@PathVariable String id) {
//        logger.info(id);
//
//        Room room1 = new Room(10, 12f, 30f, 40f);
//        Room room2 = new Room(20, 12f, 30f, 40f);
//
//        Set<Room> rooms = HashSet.newHashSet(5);
//        rooms.add(room1);
//        rooms.add(room2);
//
//        Visitor lightVisitor = new LightVisitor();
//        Floor floor = new Floor(rooms);
//        return floor.accept(lightVisitor);
//    }
}
