package pl.put.poznan.buildingInfo.logic.locations;

import lombok.*;
import pl.put.poznan.buildingInfo.logic.visitors.Visitor;

import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Building extends AbstractLocation{

    private Set<Floor> floors;
    @Override
    public Float accept(Visitor visitor) {
        return visitor.visitBuilding(this);
    }
}
