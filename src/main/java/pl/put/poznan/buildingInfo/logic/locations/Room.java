package pl.put.poznan.buildingInfo.logic.locations;

import lombok.*;
import pl.put.poznan.buildingInfo.logic.visitors.Visitor;

/**
 * Represents a room
 * @author Jędrzej Warczyński
 * @version 1.0
 *
 */
@Getter
@Setter
public class Room extends AbstractLocation {

    /**
     * creates a room with specified id area, volume and lightPower
     * @param id unique identifier of room
     * @param area area of this room expressed in square meters
     * @param volume volume of this room expressed in cubic meters
     * @param lightPower light power of this room expressed in wats
     */
    public Room(int id, Float area, Float volume, Float lightPower) {
        super(id, area, volume, lightPower);
    }

    /**
     * Enables calculating some specific parameter such as area regarding this room
     *
     * Returns some parameters regarding this room depending on type of
     * visitor passed as an argument. For example when area visitor is passed
     * area of this room is calculated
     *
     * @param visitor represents specific function implementation
     * @return value of which specific visitor calculate for example area for area visitor
     */
    @Override
    public Float accept(Visitor visitor) {
        return visitor.visitRoom(this);
    }

}
