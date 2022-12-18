package pl.put.poznan.buildingInfo.logic.locations;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import pl.put.poznan.buildingInfo.logic.visitors.Visitor;

import java.util.Set;

/**
 * Represents a floor
 *
 * @author Jędrzej Warczyński
 * @version 1.0
 *
 */
@Getter
@Setter
@NoArgsConstructor
@SuperBuilder
public class Floor extends AbstractLocation {

    /**
     * represents rooms of which consists this floor
     */
    Set<Room> rooms;

    /**
     * creates floor consisting of rooms
     * @param rooms rooms of which consists this floor
     */
    public Floor(Set<Room> rooms) {
        this.rooms = rooms;
    }
    /**
     * Enables calculating some specific parameter such as area regarding this floor
     *
     * Calculate some parameters regarding this floor depending on type of
     * visitor passed as an argument. For example when area visitor is passed
     * area of this whole floor is calculated
     *
     * @param visitor represents specific function implementation
     * @return value of which specific visitor calculate for example area for area visitor
     */
    @Override
    public Float accept(Visitor visitor) {
        return visitor.visitFloor(this);
    }

}
