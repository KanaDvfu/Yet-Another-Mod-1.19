# Yet-Another-Mod-1.19.3

The source code for _Yet Another Mod_ for Minecraft 1.19.3. A mod made for a university project.

## Working builds for testing and running

- Latest preferable build located in "Releases" section. Download `yetanothermod-\*.\*.\*-1.19.3.jar` and move it to minecraft mods folder.
- All mod builds located in `./build/libs`.

## Requirements

This mod requires Fabric and Fabric API for 1.19.3:

> Install Fabric using the [installer](https://fabricmc.net/use/installer/), selecting 1.19.3 version and clicking install.

> Download [Fabric API for 1.19.3](https://modrinth.com/mod/fabric-api). Install it and place it into the `mods` folder next to Yet Another Mod's file.

## Optional Optimization (Needs revision)

All of the extra stuff is located in `./mods`. It only includes optimization mods for better performance and to test on GLaDOS-potato-calculators like mine [*CMKana*] is:

- OS: macOS Monterey 12
- CPU: 1,6 GHz 2-core Intel Core i5
- GPU: Intel HD Graphics 6000 1,5 GB
- RAM: 8 GB 1600 MHz DDR3
- SSD: Kingston SNVS500G (500GB)

On the build, including additional mods, the game runs smoothly, providing a great gaming experience.

The mod was developed for the official version of Minecraft. Installation, performance and stability of all mods on non-licensed versions may vary.

## Ver. 0.7.6-1.19.3

- Lang file update for the Valkyr mob
- Adding a light source to the ProtoChunk where sea lanterns are in ChunkGen process
- Removal of DataGen. Reason: Currently it's not a focus, JSON preferred atm
- Change of yarn to v2 in `build.gradle`

## TODO

- Do a better implementation of a 3 param. function for `randomFunction` in `src/main/java/net/CMKana_AJMC2002/yetanothermod/world/gen/chunk/YetAnotherRooms.java`
- Update README to include GeckoLib v4 as a requirement (ask *CMKana*)
- Fix entity placement in dimension russkiy_island; currently monsters spawn on the roof
- Add portals
- Add stuff or remove vladivostok dimension
- Add loot to floors and vary blocks to make rooms according to floor