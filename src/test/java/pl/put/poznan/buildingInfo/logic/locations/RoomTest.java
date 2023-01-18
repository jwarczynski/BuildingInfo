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
class RoomTest {

    private Room roomUnderTest;
    @Mock
    private AreaVisitor areaVisitor;
    @Mock
    private LightVisitor lightVisitor;
    @Mock
    private CubatureVisitor cubatureVisitor;


    @BeforeEach
    void setUp() {
        roomUnderTest = new Room();
    }

    @Test
    void acceptAllVisitorTypes() {
        roomUnderTest.accept(areaVisitor);
        roomUnderTest.accept(lightVisitor);
        roomUnderTest.accept(cubatureVisitor);
    }

    @Test
    void shouldReturnCorrectArea() {
        when(areaVisitor.visitRoom(roomUnderTest)).thenReturn(5.f);
        assertEquals(5, roomUnderTest.accept(areaVisitor));
    }

    @Test
    void shouldReturnCorrectLightPower() {
        when(lightVisitor.visitRoom(roomUnderTest)).thenReturn(5.f);
        assertEquals(5, roomUnderTest.accept(lightVisitor));
    }

    @Test
    void shouldReturnCorrectCubature() {
        when(cubatureVisitor.visitRoom(roomUnderTest)).thenReturn(5.f);
        assertEquals(5, roomUnderTest.accept(cubatureVisitor));
    }
}