package pl.put.poznan.buildingInfo.logic.visitors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pl.put.poznan.buildingInfo.logic.locations.Building;
import pl.put.poznan.buildingInfo.logic.locations.Floor;
import pl.put.poznan.buildingInfo.logic.locations.Room;
/**
 * Calculates total light power for specific part or whole building
 *
 * @author Jakub Żytliński
 * @version 2.0
 */
public class LightVisitor implements Visitor{
    Logger logger = LoggerFactory.getLogger(LightVisitor.class);
      /**
     * This method calculates the total light power of the room passed as an argument
     *
     * @param room it is a location for which LightVisitor is determining light power
     * @return the total light power of the room object passed as an argument
     *
     */
    @Override
    public Float visitRoom(Room room) {
        return room.getLightPower() / room.getArea();
    }
    /**
     * This method calculates the total light power of the floor passed as an argument
     *
     * @param floor it is a location for which LightVisitor is determining light power
     * @return the total light power of the floor object passed as an argument
     *
     */
    @Override
    public Float visitFloor(Floor floor) {
        Float lightPower = 0f;
        long roomCounter = floor.getRooms().stream().count();
        logger.debug("number of rooms on a floor with id {}: {}", floor.getId(), roomCounter);

        for (Room room : floor.getRooms()) {
            lightPower += visitRoom(room);
        }

        float meanLightPower = lightPower / roomCounter;
        return meanLightPower;
    }
    /**
     * This method calculates the total light power of the building passed as an argument
     *
     * @param building it is a location for which LightVisitor is determining light power
     * @return the total light power of the building object passed as an argument
     *
     */
    @Override
    public Float visitBuilding(Building building) {
        Float lightPower = 0f;
        long floorCounter = building.getFloors().stream().count();
        logger.debug("number of floors in building with id {}: {}", building.getId(), floorCounter);


        for (Floor floor : building.getFloors()) {
            lightPower += visitFloor(floor);
        }

        float meanLightPower = lightPower / floorCounter;
        return meanLightPower;
    }

}
