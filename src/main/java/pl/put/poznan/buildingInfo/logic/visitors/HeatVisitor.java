package pl.put.poznan.buildingInfo.logic.visitors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pl.put.poznan.buildingInfo.logic.locations.Building;
import pl.put.poznan.buildingInfo.logic.locations.Floor;
import pl.put.poznan.buildingInfo.logic.locations.Room;

/**
 * Calculates energy consumption for heating for in specific part or whole building
 *
 * @author Jakub Żytliński
 * @version 2.0
 */

public class HeatVisitor implements Visitor{
    Logger logger = LoggerFactory.getLogger(HeatVisitor.class);
    
     /**
     * This method calculates the energy consumption for heating in the room passed as an argument
     *
     * @param room it is a location for which HeatVisitor is determining the energy consumption for heating
     * @return the energy consumption for heating in the room object passed as an argument
     *
     */
    
    @Override
    public Float visitRoom(Room room) {
        return room.getHeating() / room.getCube();
    }

     /**
     * This method calculates the energy consumption for heating in the floor passed as an argument
     *
     * @param floor it is a location for which HeatVisitor is determining the energy consumption for heating
     * @return the energy consumption for heating in the floor object passed as an argument
     *
     */
    
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
     /**
     * This method calculates the energy consumption for heating in the building passed as an argument
     *
     * @param building it is a location for which HeatVisitor is determining the energy consumption for heating
     * @return the energy consumption for heating in the building object passed as an argument
     *
     */
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
