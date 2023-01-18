package net.CMKana_AJMC2002.yetanothermod.world.gen.chunk;

public class YetAnotherRooms {
	private YetAnotherRooms() {}

	static final int NUM_FLOORS = 9;
	static final int ROOM_HEIGHT = 6;
	static final int ROOM_WIDTH = 5;

	static final boolean[][] CORNER = {
			{true, true, true, true, true},
			{true, false, false, false, false},
			{true, false, false, false, false},
			{true, false, false, false, false},
			{true, false, false, false, false}
	};
	static final boolean[][] EMPTY = {
			{false, false, false, false, false},
			{false, false, false, false, false},
			{false, false, false, false, false},
			{false, false, false, false, false},
			{false, false, false, false, false}
	};
	static final boolean[][] MIDDLE_WALL = {
			{false, false, false, false, false},
			{false, false, false, false, false},
			{true, true, true, true, true},
			{false, false, false, false, false},
			{false, false, false, false, false}
	};
	static final boolean[][] SIDE_WALL = {
			{true, true, true, true, true},
			{false, false, false, false, false},
			{false, false, false, false, false},
			{false, false, false, false, false},
			{false, false, false, false, false}
	};
	static final boolean[][] PASSAGE = {
			{true, true, false, false, true},
			{false, false, false, false, true},
			{false, false, false, false, false},
			{false, false, false, false, false},
			{false, false, false, false, false}
	};

	static final boolean[][] THICK_CORNER = {
			{true, true, true, true, true},
			{true, true, true, true, true},
			{true, true, true, true, true},
			{true, true, true, false, false},
			{true, true, true, false, false}
	};

	static final boolean[][] THICK_WALL = {
			{true, true, true, true, true},
			{true, true, true, true, true},
			{true, true, true, true, true},
			{false, false, false, false, false},
			{false, false, false, false, false}
	};

	static final boolean[][][] ROOMS = {
			CORNER,
			EMPTY,
			MIDDLE_WALL,
			SIDE_WALL,
			PASSAGE,
			THICK_CORNER,
			THICK_WALL
	};

	public static final boolean[][] getRoom(int x, int y, int z) {
		int roomX = Math.abs(Math.floorDiv(x, ROOM_WIDTH));
		int roomY = Math.abs(Math.floorDiv(y, ROOM_HEIGHT));
		int roomZ = Math.abs(Math.floorDiv(z, ROOM_WIDTH));
		long randVal = randomFunction(roomX, roomY, roomZ);
		boolean[][] room = ROOMS[Math.floorMod(randVal, ROOMS.length)];
		return rightRotated(room, Math.floorMod(randVal, ROOM_WIDTH));
	}

	private static final long randomFunction(int i, int j, int k) {
		return 13 * i + 19 * i * j - 17 * j + 23 * j * k - 37 * k - 21 * i * k + 7 * i * j * k;
	}

	private static final boolean[][] rightRotated(boolean[][] arr, int turns) {
		boolean[][] newArr = new boolean[5][5];
		for (int i = 0; i < ROOM_WIDTH; i++) {
			for (int j = 0; j < ROOM_WIDTH; j++) {
				newArr[j][ROOM_WIDTH - i - 1] = arr[i][j];
			}
		}
		if (turns == 0)
			return arr;
		return rightRotated(newArr, turns - 1);
	}
}
