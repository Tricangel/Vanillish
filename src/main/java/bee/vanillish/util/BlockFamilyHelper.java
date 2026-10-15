package bee.vanillish.util;

import net.minecraft.resources.Identifier;
import net.minecraft.world.level.block.Block;
import oshi.util.tuples.Pair;

import java.util.ArrayList;
import java.util.List;

public class BlockFamilyHelper {
    public static List<VanillishBlockFamily> families = new ArrayList<>();

    public static VanillishBlockFamily.Builder of(String name, String nameSpace) {
        return new VanillishBlockFamily.Builder(name, nameSpace);
    }

    public static VanillishBlockFamily.Builder of(String name, String nameSpace, Block fullBlock) {
        return new VanillishBlockFamily.Builder(name, nameSpace, fullBlock);
    }


    public static Identifier id(String nameSpace, String name) {
        return Identifier.fromNamespaceAndPath(nameSpace, name);
    }

    public static String capital(String string) {
        return string.substring(0, 1).toUpperCase() + string.substring(1);
    }



}
