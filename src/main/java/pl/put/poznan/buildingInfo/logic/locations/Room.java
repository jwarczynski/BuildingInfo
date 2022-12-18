package pl.put.poznan.buildingInfo.logic.locations;

import lombok.*;
import lombok.experimental.SuperBuilder;
import pl.put.poznan.buildingInfo.logic.visitors.Visitor;

/**
 * Represents a room
 * @author Jędrzej Warczyński
 * @version 1.0
 *
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
public class Room extends AbstractLocation {
    /**
     * represents area of this room
     */
    protected Float area;
    /**
     * represents volume of this room
     */
    protected Float cube;
    /**
     * represnts light power of this room
     */
    protected Float lightPower;
    /**
     * represent power consumption for heating
     */
    protected Float heating;

    /**
     * creates a room with specified id, name, area, volume lightPower and heating
     * @param id unique identifier of room
     * @param name name of room
     * @param area area of this room expressed in square meters
     * @param cube volume of this room expressed in cubic meters
     * @param heating light power of this room expressed in wats
     */
    public Room(int id, String name, Float area, Float cube, Float lightPower, Float heating) {
        super(id, name);
        this.area = area;
        this.cube = cube;
        this.lightPower = lightPower;
        this.heating = heating;
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
