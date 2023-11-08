package Tilesets;

import Builders.FrameBuilder;
import Builders.MapTileBuilder;
import Engine.ImageLoader;
import GameObject.Frame;
import GameObject.ImageEffect;
import Level.TileType;
import Level.Tileset;

import java.util.ArrayList;

// This class represents a "common" tileset of standard tiles defined in the CommonTileset.png file
public class CommonTileset extends Tileset {

    public CommonTileset() {
        super(ImageLoader.load("CommonTileset2.png"), 16, 16, 3);
    }

    @Override
    public ArrayList<MapTileBuilder> defineTiles() {
        ArrayList<MapTileBuilder> mapTiles = new ArrayList<>();

        // grass
        Frame grassFrame = new FrameBuilder(getSubImage(0, 0))
                .withScale(tileScale)
                .build();

        MapTileBuilder grassTile = new MapTileBuilder(grassFrame);

        mapTiles.add(grassTile);


        // sign
        Frame signFrame = new FrameBuilder(getSubImage(3, 0))
                .withScale(tileScale)
                .build();

        MapTileBuilder signTile = new MapTileBuilder(signFrame)
                .withTileType(TileType.NOT_PASSABLE);

        mapTiles.add(signTile);

        // sand
        Frame sandFrame = new FrameBuilder(getSubImage(0, 1))
                .withScale(tileScale)
                .build();

        MapTileBuilder sandTile = new MapTileBuilder(sandFrame);

        mapTiles.add(sandTile);

        // rock
        Frame rockFrame = new FrameBuilder(getSubImage(3, 1))
                .withScale(tileScale)
                .build();

        MapTileBuilder rockTile = new MapTileBuilder(rockFrame)
                .withTileType(TileType.NOT_PASSABLE);

        mapTiles.add(rockTile);

        // tree trunk with full hole
        Frame treeTrunkWithFullHoleFrame = new FrameBuilder(getSubImage(2, 2))
                .withScale(tileScale)
                .build();

        MapTileBuilder treeTrunkWithFullHoleTile = new MapTileBuilder(grassFrame)
                .withTopLayer(treeTrunkWithFullHoleFrame)
                .withTileType(TileType.NOT_PASSABLE);

        mapTiles.add(treeTrunkWithFullHoleTile);

        // left end branch
        Frame leftEndBranchFrame = new FrameBuilder(getSubImage(2, 4))
                .withScale(tileScale)
                .build();

        MapTileBuilder leftEndBranchTile = new MapTileBuilder(grassFrame)
                .withTopLayer(leftEndBranchFrame)
                .withTileType(TileType.NOT_PASSABLE); 

        mapTiles.add(leftEndBranchTile);

        // right end branch
        Frame rightEndBranchFrame = new FrameBuilder(getSubImage(2, 4))
                .withScale(tileScale)
                .withImageEffect(ImageEffect.FLIP_HORIZONTAL)
                .build();

        MapTileBuilder rightEndBranchTile = new MapTileBuilder(grassFrame)
                .withTopLayer(rightEndBranchFrame)
                .withTileType(TileType.NOT_PASSABLE);

        mapTiles.add(rightEndBranchTile);
        
        // tree trunk
        Frame treeTrunkFrame = new FrameBuilder(getSubImage(1, 0))
                .withScale(tileScale)
                .build();

        MapTileBuilder treeTrunkTile = new MapTileBuilder(grassFrame)
                .withTopLayer(treeTrunkFrame)
                .withTileType(TileType.NOT_PASSABLE);

        mapTiles.add(treeTrunkTile);

        // tree top leaves
        Frame treeTopLeavesFrame = new FrameBuilder(getSubImage(1, 1))
                .withScale(tileScale)
                .build();

        MapTileBuilder treeTopLeavesTile = new MapTileBuilder(grassFrame)
                .withTopLayer(treeTopLeavesFrame)
                .withTileType(TileType.NOT_PASSABLE);

        mapTiles.add(treeTopLeavesTile);
        
        // yellow flower
        Frame[] yellowFlowerFrames = new Frame[] {
                new FrameBuilder(getSubImage(1, 2), 65)
                    .withScale(tileScale)
                    .build(),
                new FrameBuilder(getSubImage(1, 3), 65)
                        .withScale(tileScale)
                        .build(),
                new FrameBuilder(getSubImage(1, 2), 65)
                        .withScale(tileScale)
                        .build(),
                new FrameBuilder(getSubImage(1, 4), 65)
                        .withScale(tileScale)
                        .build()
        };

        MapTileBuilder yellowFlowerTile = new MapTileBuilder(yellowFlowerFrames);

        mapTiles.add(yellowFlowerTile);

        // purple flower
        Frame[] purpleFlowerFrames = new Frame[] {
                new FrameBuilder(getSubImage(0, 2), 65)
                        .withScale(tileScale)
                        .build(),
                new FrameBuilder(getSubImage(0, 3), 65)
                        .withScale(tileScale)
                        .build(),
                new FrameBuilder(getSubImage(0, 2), 65)
                        .withScale(tileScale)
                        .build(),
                new FrameBuilder(getSubImage(0, 4), 65)
                        .withScale(tileScale)
                        .build()
        };

        MapTileBuilder purpleFlowerTile = new MapTileBuilder(purpleFlowerFrames);

        mapTiles.add(purpleFlowerTile);

        // middle branch
        Frame middleBranchFrame = new FrameBuilder(getSubImage(2, 3))
                .withScale(tileScale)
                .build();

        MapTileBuilder middleBranchTile = new MapTileBuilder(grassFrame)
                .withTopLayer(middleBranchFrame)
                .withTileType(TileType.NOT_PASSABLE);

        mapTiles.add(middleBranchTile);

        // tree trunk bottom
        Frame treeTrunkBottomFrame = new FrameBuilder(getSubImage(2, 0))
                .withScale(tileScale)
                .build();

        MapTileBuilder treeTrunkBottomTile = new MapTileBuilder(treeTrunkBottomFrame)
                .withTileType(TileType.NOT_PASSABLE);

        mapTiles.add(treeTrunkBottomTile);

        // mushrooms
        Frame mushroomFrame = new FrameBuilder(getSubImage(2, 1))
                .withScale(tileScale)
                .build();

        MapTileBuilder mushroomTile = new MapTileBuilder(mushroomFrame)
                .withTileType(TileType.PASSABLE);

        mapTiles.add(mushroomTile);


        // grey rock
        Frame greyRockFrame = new FrameBuilder(getSubImage(3, 2))
                .withScale(tileScale)
                .build();

        MapTileBuilder greyRockTile = new MapTileBuilder(greyRockFrame)
                .withTileType(TileType.PASSABLE);

        mapTiles.add(greyRockTile);

        // bush
        Frame bushFrame = new FrameBuilder(getSubImage(3, 3))
                .withScale(tileScale)
                .build();

        MapTileBuilder bushTile = new MapTileBuilder(bushFrame)
                .withTileType(TileType.NOT_PASSABLE);

        mapTiles.add(bushTile);

        // house body
        Frame houseBodyFrame = new FrameBuilder(getSubImage(3, 4))
                .withScale(tileScale)
                .build();

        MapTileBuilder houseBodyTile = new MapTileBuilder(houseBodyFrame)
                .withTileType(TileType.NOT_PASSABLE);

        mapTiles.add(houseBodyTile);

        // house roof body
        Frame houseRoofBodyFrame = new FrameBuilder(getSubImage(4, 0))
                .withScale(tileScale)
                .build();

        MapTileBuilder houseRoofBodyTile = new MapTileBuilder(grassFrame)
                .withTopLayer(houseRoofBodyFrame)
                .withTileType(TileType.PASSABLE);

        mapTiles.add(houseRoofBodyTile);

        // left house roof
        Frame leftHouseRoofFrame = new FrameBuilder(getSubImage(4, 1))
                .withScale(tileScale)
                .build();

        MapTileBuilder leftHouseRoofTile = new MapTileBuilder(grassFrame)
                .withTopLayer(leftHouseRoofFrame)
                .withTileType(TileType.PASSABLE);

        mapTiles.add(leftHouseRoofTile);

        // right house roof
        Frame rightHouseRoofFrame = new FrameBuilder(getSubImage(4, 1))
                .withScale(tileScale)
                .withImageEffect(ImageEffect.FLIP_HORIZONTAL)
                .build();

        MapTileBuilder rightHouseRoofTile = new MapTileBuilder(grassFrame)
                .withTopLayer(rightHouseRoofFrame)
                .withTileType(TileType.PASSABLE);

        mapTiles.add(rightHouseRoofTile);

        // left window
        Frame leftWindowFrame = new FrameBuilder(getSubImage(4, 2))
                .withScale(tileScale)
                .build();

        MapTileBuilder leftWindowTile = new MapTileBuilder(leftWindowFrame)
                .withTileType(TileType.NOT_PASSABLE);

        mapTiles.add(leftWindowTile);

        // right window
        Frame rightWindowFrame = new FrameBuilder(getSubImage(4, 2))
                .withScale(tileScale)
                .withImageEffect(ImageEffect.FLIP_HORIZONTAL)
                .build();

        MapTileBuilder rightWindowTile = new MapTileBuilder(rightWindowFrame)
                .withTileType(TileType.NOT_PASSABLE);

        mapTiles.add(rightWindowTile);

        // door
        Frame doorFrame = new FrameBuilder(getSubImage(4, 3))
                .withScale(tileScale)
                .build();

        MapTileBuilder doorTile = new MapTileBuilder(doorFrame)
                .withTileType(TileType.NOT_PASSABLE);

        mapTiles.add(doorTile);

        Frame floor0Frame = new FrameBuilder(getSubImage(6, 0))
                .withScale(tileScale)
                .build();

        MapTileBuilder floor0Tile = new MapTileBuilder(floor0Frame)
                .withTileType(TileType.NOT_PASSABLE);

        mapTiles.add(floor0Tile);

        
        Frame floor1Frame = new FrameBuilder(getSubImage(6, 1))
                .withScale(tileScale)
                .build();

        MapTileBuilder floor1Tile = new MapTileBuilder(floor1Frame)
                .withTileType(TileType.NOT_PASSABLE);

        mapTiles.add(floor1Tile);

        
        Frame floor2Frame = new FrameBuilder(getSubImage(6, 2))
                .withScale(tileScale)
                .build();

        MapTileBuilder floor2Tile = new MapTileBuilder(floor2Frame)
                .withTileType(TileType.NOT_PASSABLE);

        mapTiles.add(floor2Tile);

        Frame floor3Frame = new FrameBuilder(getSubImage(6, 3))
                .withScale(tileScale)
                .build();

        MapTileBuilder floor3Tile = new MapTileBuilder(floor3Frame)
                .withTileType(TileType.NOT_PASSABLE);

        mapTiles.add(floor3Tile);

        
        Frame floor4Frame = new FrameBuilder(getSubImage(6, 4))
                .withScale(tileScale)
                .build();

        MapTileBuilder floor4Tile = new MapTileBuilder(floor4Frame)
                .withTileType(TileType.PASSABLE);

        mapTiles.add(floor4Tile);

        Frame floor5Frame = new FrameBuilder(getSubImage(7, 0))
        .withScale(tileScale)
        .build();

        MapTileBuilder floor5Tile = new MapTileBuilder(floor5Frame)
                .withTileType(TileType.NOT_PASSABLE);

        mapTiles.add(floor5Tile);
        
        Frame floor6Frame = new FrameBuilder(getSubImage(7, 1))
        .withScale(tileScale)
        .build();

        MapTileBuilder floor6Tile = new MapTileBuilder(floor6Frame)
                .withTileType(TileType.NOT_PASSABLE);

        mapTiles.add(floor6Tile);
                
        Frame floor7Frame = new FrameBuilder(getSubImage(7, 2))
        .withScale(tileScale)
        .build();

        MapTileBuilder floor7Tile = new MapTileBuilder(floor7Frame)
                .withTileType(TileType.NOT_PASSABLE);

        mapTiles.add(floor7Tile);

                
        Frame floor8Frame = new FrameBuilder(getSubImage(7, 3))
        .withScale(tileScale)
        .build();

        MapTileBuilder floor8Tile = new MapTileBuilder(floor8Frame)
                .withTileType(TileType.NOT_PASSABLE);

        mapTiles.add(floor8Tile);

        //bobcat
        Frame bobcat1Frame = new FrameBuilder(getSubImage(8, 0))
        .withScale(tileScale)
        .build();

        MapTileBuilder bobcat1Tile = new MapTileBuilder(bobcat1Frame)
                .withTileType(TileType.PASSABLE);

        mapTiles.add(bobcat1Tile);
               //bobcat
        Frame bobcat2Frame = new FrameBuilder(getSubImage(8, 1))
        .withScale(tileScale)
        .build();

        MapTileBuilder bobcat2Tile = new MapTileBuilder(bobcat2Frame)
                .withTileType(TileType.PASSABLE);

        mapTiles.add(bobcat2Tile);
               //bobcat
        Frame bobcat3Frame = new FrameBuilder(getSubImage(8, 2))
        .withScale(tileScale)
        .build();

        MapTileBuilder bobcat3Tile = new MapTileBuilder(bobcat3Frame)
                .withTileType(TileType.PASSABLE);

        mapTiles.add(bobcat3Tile);
                Frame bobcat4Frame = new FrameBuilder(getSubImage(8, 3))
        .withScale(tileScale)
        .build();

        MapTileBuilder bobcat4Tile = new MapTileBuilder(bobcat4Frame)
                .withTileType(TileType.PASSABLE);

        mapTiles.add(bobcat4Tile);
                Frame bobcat5Frame = new FrameBuilder(getSubImage(8, 4))
        .withScale(tileScale)
        .build();

        MapTileBuilder bobcat5Tile = new MapTileBuilder(bobcat5Frame)
                .withTileType(TileType.PASSABLE);

        mapTiles.add(bobcat5Tile);
        Frame bobcat6Frame = new FrameBuilder(getSubImage(9, 0))
        .withScale(tileScale)
        .build();

        MapTileBuilder bobcat6Tile = new MapTileBuilder(bobcat6Frame)
                .withTileType(TileType.PASSABLE);

        mapTiles.add(bobcat6Tile);
                Frame bobcat7Frame = new FrameBuilder(getSubImage(9, 1))
        .withScale(tileScale)
        .build();

        MapTileBuilder bobcat7Tile = new MapTileBuilder(bobcat7Frame)
                .withTileType(TileType.PASSABLE);

        mapTiles.add(bobcat7Tile);
                Frame bobcat8Frame = new FrameBuilder(getSubImage(9, 2))
        .withScale(tileScale)
        .build();

        MapTileBuilder bobcat8Tile = new MapTileBuilder(bobcat8Frame)
                .withTileType(TileType.PASSABLE);

        mapTiles.add(bobcat8Tile);
                Frame bobcat9Frame = new FrameBuilder(getSubImage(9, 3))
        .withScale(tileScale)
        .build();

        MapTileBuilder bobcat9Tile = new MapTileBuilder(bobcat9Frame)
                .withTileType(TileType.PASSABLE);

        mapTiles.add(bobcat9Tile);
                        Frame bobcat10Frame = new FrameBuilder(getSubImage(9, 4))
        .withScale(tileScale)
        .build();

        MapTileBuilder bobcat10Tile = new MapTileBuilder(bobcat10Frame)
                .withTileType(TileType.PASSABLE);

        mapTiles.add(bobcat10Tile);
        Frame bobcat11Frame = new FrameBuilder(getSubImage(10, 0))
        .withScale(tileScale)
        .build();

        MapTileBuilder bobcat11Tile = new MapTileBuilder(bobcat11Frame)
                .withTileType(TileType.PASSABLE);

        mapTiles.add(bobcat11Tile);
        
        Frame bobcat12Frame = new FrameBuilder(getSubImage(10, 1))
        .withScale(tileScale)
        .build();

        MapTileBuilder bobcat12Tile = new MapTileBuilder(bobcat12Frame)
                .withTileType(TileType.PASSABLE);

        mapTiles.add(bobcat12Tile);
        
        Frame bobcat13Frame = new FrameBuilder(getSubImage(10, 2))
        .withScale(tileScale)
        .build();

        MapTileBuilder bobcat13Tile = new MapTileBuilder(bobcat13Frame)
                .withTileType(TileType.PASSABLE);

        mapTiles.add(bobcat13Tile);
        
        Frame bobcat14Frame = new FrameBuilder(getSubImage(10, 3))
        .withScale(tileScale)
        .build();

        MapTileBuilder bobcat14Tile = new MapTileBuilder(bobcat14Frame)
                .withTileType(TileType.PASSABLE);

        mapTiles.add(bobcat14Tile);
        
        Frame bobcat15Frame = new FrameBuilder(getSubImage(10, 4))
        .withScale(tileScale)
        .build();

        MapTileBuilder bobcat15Tile = new MapTileBuilder(bobcat15Frame)
                .withTileType(TileType.PASSABLE);

        mapTiles.add(bobcat15Tile);
        
        Frame bobcat16Frame = new FrameBuilder(getSubImage(11, 0))
        .withScale(tileScale)
        .build();

        MapTileBuilder bobcat16Tile = new MapTileBuilder(bobcat16Frame)
                .withTileType(TileType.PASSABLE);

        mapTiles.add(bobcat16Tile);
        
        Frame bobcat17Frame = new FrameBuilder(getSubImage(11, 1))
        .withScale(tileScale)
        .build();

        MapTileBuilder bobcat17Tile = new MapTileBuilder(bobcat17Frame)
                .withTileType(TileType.PASSABLE);

        mapTiles.add(bobcat17Tile);
        
        
        Frame bobcat18Frame = new FrameBuilder(getSubImage(11, 2))
        .withScale(tileScale)
        .build();

        MapTileBuilder bobcat18Tile = new MapTileBuilder(bobcat18Frame)
                .withTileType(TileType.PASSABLE);

        mapTiles.add(bobcat18Tile);
        
        
        Frame bobcat19Frame = new FrameBuilder(getSubImage(11, 2))
        .withScale(tileScale)
        .build();

        MapTileBuilder bobcat19Tile = new MapTileBuilder(bobcat19Frame)
                .withTileType(TileType.PASSABLE);

        mapTiles.add(bobcat19Tile);
        
        
        Frame bobcat20Frame = new FrameBuilder(getSubImage(11, 3))
        .withScale(tileScale)
        .build();

        MapTileBuilder bobcat20Tile = new MapTileBuilder(bobcat20Frame)
                .withTileType(TileType.PASSABLE);

        mapTiles.add(bobcat20Tile);
        
        
        Frame bobcat21Frame = new FrameBuilder(getSubImage(11, 4))
        .withScale(tileScale)
        .build();

        MapTileBuilder bobcat21Tile = new MapTileBuilder(bobcat21Frame)
                .withTileType(TileType.PASSABLE);

        mapTiles.add(bobcat21Tile);
        
        
        Frame bobcat22Frame = new FrameBuilder(getSubImage(12, 0))
        .withScale(tileScale)
        .build();

        MapTileBuilder bobcat22Tile = new MapTileBuilder(bobcat22Frame)
                .withTileType(TileType.PASSABLE);

        mapTiles.add(bobcat22Tile);
        
        
        Frame bobcat23Frame = new FrameBuilder(getSubImage(12, 1))
        .withScale(tileScale)
        .build();

        MapTileBuilder bobcat23Tile = new MapTileBuilder(bobcat23Frame)
                .withTileType(TileType.PASSABLE);

        mapTiles.add(bobcat23Tile);
        
        
        Frame bobcat24Frame = new FrameBuilder(getSubImage(12, 2))
        .withScale(tileScale)
        .build();

        MapTileBuilder bobcat24Tile = new MapTileBuilder(bobcat24Frame)
                .withTileType(TileType.PASSABLE);

        mapTiles.add(bobcat24Tile);
        
        
        Frame bobcat25Frame = new FrameBuilder(getSubImage(12, 3))
        .withScale(tileScale)
        .build();

        MapTileBuilder bobcat25Tile = new MapTileBuilder(bobcat25Frame)
                .withTileType(TileType.PASSABLE);

        mapTiles.add(bobcat25Tile);
        
        
        Frame bobcat26Frame = new FrameBuilder(getSubImage(12, 4))
        .withScale(tileScale)
        .build();

        MapTileBuilder bobcat26Tile = new MapTileBuilder(bobcat26Frame)
                .withTileType(TileType.PASSABLE);

        mapTiles.add(bobcat26Tile);
        
                
        Frame bobcat30Frame = new FrameBuilder(getSubImage(13, 0))
        .withScale(tileScale)
        .build();

        MapTileBuilder bobcat30Tile = new MapTileBuilder(bobcat30Frame)
                .withTileType(TileType.PASSABLE);

        mapTiles.add(bobcat30Tile);
        
                
        Frame bobcat31Frame = new FrameBuilder(getSubImage(13, 4))
        .withScale(tileScale)
        .build();

        MapTileBuilder bobcat31Tile = new MapTileBuilder(bobcat31Frame)
                .withTileType(TileType.PASSABLE);

        mapTiles.add(bobcat31Tile);
                
        Frame bobcat27Frame = new FrameBuilder(getSubImage(13, 1))
        .withScale(tileScale)
        .build();

        MapTileBuilder bobcat27Tile = new MapTileBuilder(bobcat27Frame)
                .withTileType(TileType.PASSABLE);

        mapTiles.add(bobcat27Tile);
                
        Frame bobcat28Frame = new FrameBuilder(getSubImage(13, 2))
        .withScale(tileScale)
        .build();

        MapTileBuilder bobcat28Tile = new MapTileBuilder(bobcat28Frame)
                .withTileType(TileType.PASSABLE);

        mapTiles.add(bobcat28Tile);
                
        Frame bobcat29Frame = new FrameBuilder(getSubImage(13, 3))
        .withScale(tileScale)
        .build();

        MapTileBuilder bobcat29Tile = new MapTileBuilder(bobcat29Frame)
                .withTileType(TileType.PASSABLE);

        mapTiles.add(bobcat29Tile);





        // top water
        Frame[] topWaterFrames = new Frame[] {
            new FrameBuilder(getSubImage(5, 0), 65)
                    .withScale(tileScale)
                    .build(),
            new FrameBuilder(getSubImage(5, 1), 65)
                    .withScale(tileScale)
                    .build(),
            new FrameBuilder(getSubImage(5, 2), 65)
                    .withScale(tileScale)
                    .build(),
            new FrameBuilder(getSubImage(5, 1), 65)
                    .withScale(tileScale)
                    .build(),
            new FrameBuilder(getSubImage(5, 0), 65)
                    .withScale(tileScale)
                    .build(),
            new FrameBuilder(getSubImage(5, 3), 65)
                    .withScale(tileScale)
                    .build(),
            new FrameBuilder(getSubImage(5, 4), 65)
                    .withScale(tileScale)
                    .build(),
            new FrameBuilder(getSubImage(5, 3), 65)
                    .withScale(tileScale)
                    .build()
        };

        MapTileBuilder topWaterTile = new MapTileBuilder(topWaterFrames)
                .withTileType(TileType.NOT_PASSABLE);

        mapTiles.add(topWaterTile);


        return mapTiles;
    }
}
