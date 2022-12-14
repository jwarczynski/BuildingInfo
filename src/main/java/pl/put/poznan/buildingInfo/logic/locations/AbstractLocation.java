package pl.put.poznan.buildingInfo.logic.locations;

import jakarta.annotation.Nullable;
import lombok.*;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
public abstract class AbstractLocation implements Visitable {

    protected int id;
    @Nullable
    protected String name;
    
}
