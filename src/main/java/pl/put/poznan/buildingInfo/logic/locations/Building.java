package pl.put.poznan.buildingInfo.logic.locations;

import lombok.*;
import lombok.experimental.SuperBuilder;
import pl.put.poznan.buildingInfo.logic.visitors.Visitor;

import java.util.Set;

/**
 * Represents a building
 * @author Jędrzej Warczyński
 * @version 1.0
 *
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
public class Building extends AbstractLocation{

    /**
     * represents floors of which consists this building
     */
    private Set<Floor> floors;

    /**
     * Enables calculating some specific parameter such as area regarding this building
     *
     * Calculate some parameters regarding this building depending on type of
     * visitor passed as an argument. For example when area visitor is passed
     * area of this whole building is calculated
     *
     * @param visitor represents specific function implementation
     * @return value of which specific visitor calculate for example area for area visitor
     */
    @Override
    public Float accept(Visitor visitor) {
        return visitor.visitBuilding(this);
    }
}
