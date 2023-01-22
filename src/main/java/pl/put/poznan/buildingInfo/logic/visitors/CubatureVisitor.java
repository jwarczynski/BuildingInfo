package pl.put.poznan.buildingInfo.logic.visitors;

import pl.put.poznan.buildingInfo.logic.locations.Building;
import pl.put.poznan.buildingInfo.logic.locations.Floor;
import pl.put.poznan.buildingInfo.logic.locations.Room;

/**
 * Calculates cubature for specific part or whole building
 *
 * @author Jakub Żytliński
 * @version 2.0
 */

public class CubatureVisitor implements Visitor{
     /**
     * This method calculate the cubature of the room passed as an argument
     *
     * @param room it is a location for which CubatureVisitor is determining cubature
     * @return the cubature of the room object passed as an argument
     *
     */
    @Override
    public Float visitRoom(Room room) {
        return room.getCube();
    }
      /**
     * This method calculate the cubature of the floor passed as an argument
     *
     * @param floor it is a location for which CubatureVisitor is determining cubature
     * @return the cubature of the floor object passed as an argument
     *
     */
    @Override
    public Float visitFloor(Floor floor) {
        Float volume = 0f;
        for (Room room : floor.getRooms()) {
            volume += visitRoom(room);
        }
        return volume;
    }
      /**
     * This method calculate the cubature of the building passed as an argument
     *
     * @param building it is a location for which CubatureVisitor is determining cubature
     * @return the cubature of the building object passed as an argument
     *
     */
    @Override
    public Float visitBuilding(Building building) {
        Float volume = 0f;
        for (Floor floor : building.getFloors()) {
            volume += visitFloor(floor);
        }
        return volume;
    }
}
