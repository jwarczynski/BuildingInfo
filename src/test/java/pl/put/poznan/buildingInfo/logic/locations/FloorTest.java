package pl.put.poznan.buildingInfo.logic.locations;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import pl.put.poznan.buildingInfo.logic.visitors.AreaVisitor;
import pl.put.poznan.buildingInfo.logic.visitors.CubatureVisitor;
import pl.put.poznan.buildingInfo.logic.visitors.LightVisitor;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;


@ExtendWith(MockitoExtension.class)
class FloorTest {

    private Floor floorUnderTest;
    @Mock
    private AreaVisitor areaVisitor;
    @Mock
    private LightVisitor lightVisitor;
    @Mock
    private CubatureVisitor cubatureVisitor;

    @BeforeEach
    void setUp() {
        floorUnderTest = new Floor();
    }

    @Test
    void acceptAllVisitorTypes() {
        floorUnderTest.accept(areaVisitor);
        floorUnderTest.accept(lightVisitor);
        floorUnderTest.accept(cubatureVisitor);
    }

    @Test
    void shouldReturnCorrectArea() {
        when(areaVisitor.visitFloor(floorUnderTest)).thenReturn(5.f);
        assertEquals(5, floorUnderTest.accept(areaVisitor));
    }

    @Test
    void shouldReturnCorrectLightPower() {
        when(lightVisitor.visitFloor(floorUnderTest)).thenReturn(5.f);
        assertEquals(5, floorUnderTest.accept(lightVisitor));
    }

    @Test
    void shouldReturnCorrectCubature() {
        when(cubatureVisitor.visitFloor(floorUnderTest)).thenReturn(5.f);
        assertEquals(5, floorUnderTest.accept(cubatureVisitor));
    }
}