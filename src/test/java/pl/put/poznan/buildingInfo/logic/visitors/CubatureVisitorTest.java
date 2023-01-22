package pl.put.poznan.buildingInfo.logic.visitors;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;
import pl.put.poznan.buildingInfo.logic.locations.Building;
import pl.put.poznan.buildingInfo.logic.locations.Floor;
import pl.put.poznan.buildingInfo.logic.locations.Room;

import java.util.Arrays;
import java.util.HashSet;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;


@ExtendWith(MockitoExtension.class)
class CubatureVisitorTest {

    CubatureVisitor cubatureVisitorUnderTest;
    @Spy
    CubatureVisitor spyCubatureVisitor;
    @Mock
    Room mockedRoom;
    @Mock
    Floor mockedFloor;
    @Mock
    Building mockedBuilding;


    @Test
    void visitRoom() {
        cubatureVisitorUnderTest = new CubatureVisitor();
        when(mockedRoom.getCube()).thenReturn(10.f);

        assertEquals(10,cubatureVisitorUnderTest.visitRoom(mockedRoom));
        verify(mockedRoom, times(1)).getCube();

    }

    @Test
    void visitFloor() {
        when(mockedFloor.getRooms()).thenReturn(new HashSet<>(Arrays.asList(new Room(), new Room())));
        doReturn(1.f).when(spyCubatureVisitor).visitRoom(any(Room.class));

        assertEquals(2, spyCubatureVisitor.visitFloor(mockedFloor));
        verify(mockedFloor, times(1)).getRooms();
        verify(spyCubatureVisitor, times(2)).visitRoom(any(Room.class));
    }

    @Test
    void visitBuilding() {
        when(mockedBuilding.getFloors()).thenReturn(new HashSet<>(Arrays.asList(new Floor(), new Floor())));
        doReturn(1.f).when(spyCubatureVisitor).visitFloor(any(Floor.class));

        assertEquals(2, spyCubatureVisitor.visitBuilding(mockedBuilding));
        verify(mockedBuilding, times(1)).getFloors();
        verify(spyCubatureVisitor, times(2)).visitFloor(any(Floor.class));
    }
}