package pl.put.poznan.buildingInfo.logic.visitors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pl.put.poznan.buildingInfo.logic.locations.Building;
import pl.put.poznan.buildingInfo.logic.locations.Floor;
import pl.put.poznan.buildingInfo.logic.locations.Room;

public class HeatVisitor implements Visitor{
    Logger logger = LoggerFactory.getLogger(HeatVisitor.class);

    @Override
    public Float visitRoom(Room room) {
        return room.getHeating() / room.getCube();
    }

    @Override
    public Float visitFloor(Floor floor) {
        Float heat = 0f;
        Float cube = 0f;
        long roomCounter = floor.getRooms().stream().count();
        logger.debug("number of rooms on a floor with id {}: {}", floor.getId(), roomCounter);

        for (Room room : floor.getRooms()) {
            heat += room.getHeating();
            cube += room.getCube();
        }

        return heat/cube;
    }

    @Override
    public Float visitBuilding(Building building) {
        Float heat = 0f;
        long floorCounter = building.getFloors().stream().count();
        logger.debug("number of floors in building with id {}: {}", building.getId(), floorCounter);


        for (Floor floor : building.getFloors()) {
            heat += visitFloor(floor);
        }
        return heat / floorCounter;
    }

}
