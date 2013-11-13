package components;

public class WorldBuilder {
	private int width;
	private int height;
	private Tile[][] tiles;

	public WorldBuilder(int width, int height) {
		this.width = width;
		this.height = height;
		this.tiles = new Tile[width][height];
	}

	public World build() {
		return new World(tiles);
	}

	private WorldBuilder randomizeTiles() {
		for (int x = 0; x < width; x++) {
			for (int y = 0; y < height; y++) {
				tiles[x][y] = Math.random() < 0.5 ? Tile.FLOOR : Tile.WALL;
			}
		}
		return this;
	}

	private WorldBuilder smooth(int times) {
		Tile[][] tiles2 = new Tile[width][height];
		for (int time = 0; time < times; time++) {

			for (int x = 0; x < width; x++) {
				for (int y = 0; y < height; y++) {
					int floors = 0;
					int rocks = 0;

					for (int ox = -1; ox < 2; ox++) {
						for (int oy = -1; oy < 2; oy++) {
							if (x + ox < 0 || x + ox >= width || y + oy < 0
									|| y + oy >= height)
								continue;

							if (tiles[x + ox][y + oy] == Tile.FLOOR)
								floors++;
							else
								rocks++;
						}
					}
					tiles2[x][y] = floors >= rocks ? Tile.FLOOR : Tile.WALL;
				}
			}
			tiles = tiles2;
		}
		return this;
	}

	public WorldBuilder makeCaves() {
		return randomizeTiles().smooth(8);
	}
	
	public WorldBuilder makeShip(){ // TODO upper and lower floors, i.e cargo/reactor deck, bridge deck
		for (int x = 0; x < width; x++) { // writing void canvas to begin with
			for (int y = 0; y < height; y++) {
				tiles[x][y] = Tile.VOID;
			}
		}
		for(int x = 1; x < width - 7; x++){ // drawing central floor TODO make complex for certain section floors.
			for(int y = 7; y < 12; y++) {
				tiles[x][y] = Tile.FLOOR;
			}
		}
		for(int x = 7; x < width - 1; x++){
			for(int y = 1; y < 6; y++){
				tiles[x][y] = Tile.FLOOR;
			}
			for(int y = 13; y < height - 1; y++){
				tiles[x][y] = Tile.FLOOR;
			}
		}
		for(int x = 6; x < width; x++){ // drawing upper upper and lower lower wall
			tiles[x][0] = Tile.WALL;
			tiles[x][18] = Tile.WALL;
		}
		for(int x = 0; x < width; x++){ // drawing upper and lower central wall
			tiles[x][6] = Tile.WALL;
			tiles[x][12] = Tile.WALL;
		}
		for(int y = 6; y < 12; y++){ // drawing outer left wall and inner right wall
			tiles[0][y] = Tile.WALL;
		}
		for(int y = 0; y < height; y++){ // drawing inner left wall, inner middle right wall and inner right wall
			tiles[6][y] = Tile.WALL;
			tiles[width - 7][y] = Tile.WALL;
		}
		for(int y = 0; y < 6; y++){ // drawing top outer right wall and top inner walls
			tiles[width - 1][y] = Tile.WALL;
			tiles[12][y] = Tile.WALL;
			tiles[18][y] = Tile.WALL;
			tiles[24][y] = Tile.WALL;
		}
		for(int y = 12; y < height; y++){ // drawing bottom outer right wall and lower inner walls
			tiles[width - 1][y] = Tile.WALL;
			tiles[12][y] = Tile.WALL;
			tiles[18][y] = Tile.WALL;
			tiles[24][y] = Tile.WALL;
		}
		tiles[6][9] = Tile.DOOR; // drawing doors
		tiles[9][6] = Tile.DOOR;
		tiles[15][6] = Tile.DOOR;
		tiles[21][6] = Tile.DOOR;
		tiles[27][6] = Tile.DOOR;
		tiles[9][12] = Tile.DOOR;
		tiles[15][12] = Tile.DOOR;
		tiles[21][12] = Tile.DOOR;
		tiles[27][12] = Tile.DOOR;
		tiles[30][3] = Tile.DOOR;
		tiles[30][15] = Tile.DOOR;
		return this;
	}
}